package com.tencent.mm.plugin.backup.d;

import android.os.Looper;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.lan_cs.Server.Java2C;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.plugin.backup.c.a.1;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.c.ri;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.LinkedList;

public final class e
{
  com.tencent.mm.plugin.backup.b.e hFp;
  LinkedList<ri> hID;
  String hIE;
  private String hIF = "";
  private boolean hIG = false;
  e.a hIH;
  private am hII = new am(Looper.getMainLooper(), new e.1(this), true);
  final f hIJ = new e.2(this);
  final f hIK = new e.3(this);
  
  public e(e.a parama, com.tencent.mm.plugin.backup.b.e parame)
  {
    this.hIH = parama;
    this.hFp = parame;
  }
  
  private boolean aul()
  {
    this.hID = new LinkedList();
    PString localPString = new PString();
    PInt localPInt = new PInt();
    this.hIE = g.cM(ae.getContext());
    y.i("MicroMsg.CheckNetworkGenQrCodeHandler", "wifiName :%s", new Object[] { this.hIE });
    if (bk.bl(this.hIE))
    {
      this.hFp.hFu = -4;
      this.hIH.l(-4, null);
      this.hIF = "";
      return false;
    }
    Object localObject = b.atS().atT();
    ((com.tencent.mm.plugin.backup.c.a)localObject).mode = 0;
    y.i("MicroMsg.BackupCEngine", "listen, before server.stop");
    Server.Java2C.stop();
    y.i("MicroMsg.BackupCEngine", "listen, before server.start listener");
    com.tencent.mm.lan_cs.Server.dOI = new a.1((com.tencent.mm.plugin.backup.c.a)localObject);
    Object[] arrayOfObject = Server.Java2C.access$000();
    int i;
    if ((arrayOfObject == null) || (arrayOfObject.length != 3))
    {
      y.e("MicroMsg.BackupCEngine", "listen error");
      i = 0;
    }
    while (i == 0)
    {
      this.hFp.hFu = -4;
      this.hIH.l(-4, null);
      this.hIF = "";
      return false;
      y.i("MicroMsg.BackupCEngine", "listen, result[%d, %s, %d]", new Object[] { arrayOfObject[0], arrayOfObject[1], arrayOfObject[2] });
      if (((Integer)arrayOfObject[0]).intValue() != 1)
      {
        i = 0;
      }
      else
      {
        localPString.value = ((String)arrayOfObject[1]);
        localPInt.value = ((Integer)arrayOfObject[2]).intValue();
        ((com.tencent.mm.plugin.backup.c.a)localObject).mode = 1;
        i = 1;
      }
    }
    y.i("MicroMsg.CheckNetworkGenQrCodeHandler", "server listen result: %s, %d", new Object[] { localPString.value, Integer.valueOf(localPInt.value) });
    localObject = new ri();
    ((ri)localObject).sMR = localPString.value;
    ((ri)localObject).sPm = new LinkedList();
    ((ri)localObject).sPm.add(Integer.valueOf(localPInt.value));
    this.hID.add(localObject);
    return true;
  }
  
  final void auk()
  {
    Object localObject = g.cM(ae.getContext());
    y.i("MicroMsg.CheckNetworkGenQrCodeHandler", "checkNetStatus newWifiName:%s  preWifiName:%s acc:%b hold:%b", new Object[] { localObject, this.hIF, Boolean.valueOf(au.DK()), Boolean.valueOf(au.CW()) });
    if ((((String)localObject).equals(this.hIF)) || (!au.DK())) {
      return;
    }
    this.hIF = ((String)localObject);
    if (!aul())
    {
      this.hIG = false;
      return;
    }
    this.hIG = false;
    if (!au.CW())
    {
      y.i("MicroMsg.CheckNetworkGenQrCodeHandler", "begin to netscene create QRCode online ");
      au.Dk().a(704, this.hIJ);
      localObject = new com.tencent.mm.plugin.backup.e.b(this.hID, this.hIE);
      au.Dk().a((m)localObject, 0);
      return;
    }
    y.i("MicroMsg.CheckNetworkGenQrCodeHandler", "begin to netscene create QRCode offline");
    au.Dk().a(1000, this.hIK);
    localObject = new com.tencent.mm.plugin.backup.e.a(this.hID, this.hIE, b.atS().hHF);
    au.Dk().a((m)localObject, 0);
  }
  
  public final void start()
  {
    y.i("MicroMsg.CheckNetworkGenQrCodeHandler", "start check network and gen qrcode handler starting:%b stop:%b .%s %s", new Object[] { Boolean.valueOf(this.hIG), Boolean.valueOf(this.hII.crl()), this, bk.csb() });
    if (this.hIG) {
      return;
    }
    this.hIG = true;
    if (aul())
    {
      this.hIF = null;
      auk();
    }
    for (;;)
    {
      this.hII.S(500L, 500L);
      return;
      this.hFp.hFu = -4;
      this.hIH.l(-4, null);
    }
  }
  
  public final void stop()
  {
    y.i("MicroMsg.CheckNetworkGenQrCodeHandler", "stop check network and gen qrcode handler.");
    this.hIG = false;
    au.Dk().b(704, this.hIJ);
    au.Dk().b(1000, this.hIK);
    this.hII.stopTimer();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.e
 * JD-Core Version:    0.7.0.1
 */
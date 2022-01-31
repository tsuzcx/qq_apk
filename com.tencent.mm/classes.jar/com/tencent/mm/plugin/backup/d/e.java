package com.tencent.mm.plugin.backup.d;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.model.aw;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.protobuf.vd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public final class e
{
  LinkedList<vd> jCd;
  String jCe;
  private String jCf;
  private boolean jCg;
  e.a jCh;
  private ap jCi;
  final f jCj;
  final f jCk;
  com.tencent.mm.plugin.backup.b.e jyI;
  
  public e(e.a parama, com.tencent.mm.plugin.backup.b.e parame)
  {
    AppMethodBeat.i(17305);
    this.jCf = "";
    this.jCg = false;
    this.jCi = new ap(Looper.getMainLooper(), new e.1(this), true);
    this.jCj = new e.2(this);
    this.jCk = new e.3(this);
    this.jCh = parama;
    this.jyI = parame;
    AppMethodBeat.o(17305);
  }
  
  private boolean aTL()
  {
    AppMethodBeat.i(17309);
    this.jCd = new LinkedList();
    PString localPString = new PString();
    PInt localPInt = new PInt();
    this.jCe = g.dx(ah.getContext());
    ab.i("MicroMsg.CheckNetworkGenQrCodeHandler", "wifiName :%s", new Object[] { this.jCe });
    if (bo.isNullOrNil(this.jCe))
    {
      this.jyI.jyN = -4;
      this.jCh.l(-4, null);
      this.jCf = "";
      AppMethodBeat.o(17309);
      return false;
    }
    if (!b.aTr().aTs().a(localPString, localPInt))
    {
      this.jyI.jyN = -4;
      this.jCh.l(-4, null);
      this.jCf = "";
      AppMethodBeat.o(17309);
      return false;
    }
    ab.i("MicroMsg.CheckNetworkGenQrCodeHandler", "server listen result: %s, %d", new Object[] { localPString.value, Integer.valueOf(localPInt.value) });
    vd localvd = new vd();
    localvd.wKH = localPString.value;
    localvd.wNF = new LinkedList();
    localvd.wNF.add(Integer.valueOf(localPInt.value));
    this.jCd.add(localvd);
    AppMethodBeat.o(17309);
    return true;
  }
  
  final void aTK()
  {
    AppMethodBeat.i(17308);
    Object localObject = g.dx(ah.getContext());
    ab.i("MicroMsg.CheckNetworkGenQrCodeHandler", "checkNetStatus newWifiName:%s  preWifiName:%s acc:%b hold:%b", new Object[] { localObject, this.jCf, Boolean.valueOf(aw.RG()), Boolean.valueOf(aw.QP()) });
    if (!((String)localObject).equals(this.jCf))
    {
      if (!aw.RG())
      {
        AppMethodBeat.o(17308);
        return;
      }
      this.jCf = ((String)localObject);
      if (!aTL())
      {
        this.jCg = false;
        AppMethodBeat.o(17308);
        return;
      }
      this.jCg = false;
      if (!aw.QP())
      {
        ab.i("MicroMsg.CheckNetworkGenQrCodeHandler", "begin to netscene create QRCode online ");
        aw.Rc().a(704, this.jCj);
        localObject = new com.tencent.mm.plugin.backup.e.b(this.jCd, this.jCe);
        aw.Rc().a((m)localObject, 0);
        AppMethodBeat.o(17308);
        return;
      }
      ab.i("MicroMsg.CheckNetworkGenQrCodeHandler", "begin to netscene create QRCode offline");
      aw.Rc().a(1000, this.jCk);
      localObject = new com.tencent.mm.plugin.backup.e.a(this.jCd, this.jCe, b.aTr().jBb);
      aw.Rc().a((m)localObject, 0);
    }
    AppMethodBeat.o(17308);
  }
  
  public final void start()
  {
    AppMethodBeat.i(17306);
    ab.i("MicroMsg.CheckNetworkGenQrCodeHandler", "start check network and gen qrcode handler starting:%b stop:%b .%s %s", new Object[] { Boolean.valueOf(this.jCg), Boolean.valueOf(this.jCi.dtj()), this, bo.dtY() });
    if (this.jCg)
    {
      AppMethodBeat.o(17306);
      return;
    }
    this.jCg = true;
    if (aTL())
    {
      this.jCf = null;
      aTK();
    }
    for (;;)
    {
      this.jCi.ag(500L, 500L);
      AppMethodBeat.o(17306);
      return;
      this.jyI.jyN = -4;
      this.jCh.l(-4, null);
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(17307);
    ab.i("MicroMsg.CheckNetworkGenQrCodeHandler", "stop check network and gen qrcode handler.");
    this.jCg = false;
    aw.Rc().b(704, this.jCj);
    aw.Rc().b(1000, this.jCk);
    this.jCi.stopTimer();
    AppMethodBeat.o(17307);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.e
 * JD-Core Version:    0.7.0.1
 */
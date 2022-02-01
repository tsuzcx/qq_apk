package com.tencent.mm.plugin.backup.d;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.aba;
import com.tencent.mm.protocal.protobuf.id;
import com.tencent.mm.protocal.protobuf.ie;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public final class e
{
  com.tencent.mm.plugin.backup.b.e nsE;
  LinkedList<aba> nvX;
  String nvY;
  private String nvZ;
  private boolean nwa;
  a nwb;
  private av nwc;
  final f nwd;
  final f nwe;
  
  public e(a parama, com.tencent.mm.plugin.backup.b.e parame)
  {
    AppMethodBeat.i(21363);
    this.nvZ = "";
    this.nwa = false;
    this.nwc = new av(Looper.getMainLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(21360);
        e.this.bHY();
        AppMethodBeat.o(21360);
        return true;
      }
    }, true);
    this.nwd = new f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(21361);
        com.tencent.mm.plugin.backup.g.b.b(704, e.this.nwd);
        ad.i("MicroMsg.CheckNetworkGenQrCodeHandler", "backup move receive createQrcode response.[%d,%d,%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          ad.e("MicroMsg.CheckNetworkGenQrCodeHandler", "create qrcode failed, errMsg:".concat(String.valueOf(paramAnonymousString)));
          ad.i("MicroMsg.CheckNetworkGenQrCodeHandler", "err: %d, %d, %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if (paramAnonymousInt2 == -100)
          {
            ba.aiU().a(1000, e.this.nwe);
            paramAnonymousString = new com.tencent.mm.plugin.backup.e.a(e.this.nvX, e.this.nvY, b.bHG().nuX);
            ba.aiU().a(paramAnonymousString, 0);
            AppMethodBeat.o(21361);
            return;
          }
          e.this.nsE.nsJ = -11;
          e.this.nwb.n(-11, null);
          AppMethodBeat.o(21361);
          return;
        }
        paramAnonymousString = (com.tencent.mm.plugin.backup.e.b)paramAnonymousn;
        paramAnonymousn = (ie)paramAnonymousString.rr.hNL.hNQ;
        b.bHG().nsB = "";
        b.bHG().nsC = paramAnonymousn.FAG;
        b.bHG().nsD = paramAnonymousn.FAH;
        b.bHG().nuX = paramAnonymousn.FAC;
        paramAnonymousString = (ie)paramAnonymousString.rr.hNL.hNQ;
        if (paramAnonymousString == null) {
          paramAnonymousString = null;
        }
        for (;;)
        {
          if (paramAnonymousString != null)
          {
            e.this.nsE.nsJ = 51;
            e.this.nwb.n(51, paramAnonymousString);
          }
          AppMethodBeat.o(21361);
          return;
          if (paramAnonymousString.FAD == null) {
            paramAnonymousString = null;
          } else {
            paramAnonymousString = paramAnonymousString.FAD.getBufferToBytes();
          }
        }
      }
    };
    this.nwe = new f()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(21362);
        com.tencent.mm.plugin.backup.g.b.b(1000, e.this.nwe);
        ad.i("MicroMsg.CheckNetworkGenQrCodeHandler", "backup move receive createOffilineQrcode response.[%d,%d,%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          ad.e("MicroMsg.CheckNetworkGenQrCodeHandler", "create offline qrcode failed, errMsg:".concat(String.valueOf(paramAnonymousString)));
          e.this.nsE.nsJ = -11;
          e.this.nwb.n(-11, null);
          AppMethodBeat.o(21362);
          return;
        }
        paramAnonymousn = ((k.b)((com.tencent.mm.plugin.backup.e.a)paramAnonymousn).hON.getRespObj()).FnW;
        if (paramAnonymousn == null)
        {
          paramAnonymousString = "null";
          ad.i("MicroMsg.BackupCreateQRCodeOfflineScene", "onGYNetEnd QRCodeUrl:%s", new Object[] { paramAnonymousString });
          if (paramAnonymousn != null) {
            break label202;
          }
          paramAnonymousString = null;
        }
        for (;;)
        {
          if (paramAnonymousString != null)
          {
            e.this.nsE.nsJ = 51;
            e.this.nwb.n(51, paramAnonymousString);
          }
          AppMethodBeat.o(21362);
          return;
          paramAnonymousString = paramAnonymousn.FAE;
          break;
          label202:
          if (paramAnonymousn.FAD == null) {
            paramAnonymousString = null;
          } else {
            paramAnonymousString = paramAnonymousn.FAD.getBufferToBytes();
          }
        }
      }
    };
    this.nwb = parama;
    this.nsE = parame;
    AppMethodBeat.o(21363);
  }
  
  private boolean bHZ()
  {
    AppMethodBeat.i(21367);
    this.nvX = new LinkedList();
    PString localPString = new PString();
    PInt localPInt = new PInt();
    this.nvY = g.eh(aj.getContext());
    ad.i("MicroMsg.CheckNetworkGenQrCodeHandler", "wifiName :%s", new Object[] { this.nvY });
    if (bt.isNullOrNil(this.nvY))
    {
      this.nsE.nsJ = -4;
      this.nwb.n(-4, null);
      this.nvZ = "";
      AppMethodBeat.o(21367);
      return false;
    }
    if (!b.bHG().bHH().a(localPString, localPInt))
    {
      this.nsE.nsJ = -4;
      this.nwb.n(-4, null);
      this.nvZ = "";
      AppMethodBeat.o(21367);
      return false;
    }
    ad.i("MicroMsg.CheckNetworkGenQrCodeHandler", "server listen result: %s, %d", new Object[] { localPString.value, Integer.valueOf(localPInt.value) });
    aba localaba = new aba();
    localaba.FWO = localPString.value;
    localaba.Gaw = new LinkedList();
    localaba.Gaw.add(Integer.valueOf(localPInt.value));
    this.nvX.add(localaba);
    AppMethodBeat.o(21367);
    return true;
  }
  
  final void bHY()
  {
    AppMethodBeat.i(21366);
    Object localObject = g.eh(aj.getContext());
    ad.i("MicroMsg.CheckNetworkGenQrCodeHandler", "checkNetStatus newWifiName:%s  preWifiName:%s acc:%b hold:%b", new Object[] { localObject, this.nvZ, Boolean.valueOf(ba.ajx()), Boolean.valueOf(ba.aiE()) });
    if (!((String)localObject).equals(this.nvZ))
    {
      if (!ba.ajx())
      {
        AppMethodBeat.o(21366);
        return;
      }
      this.nvZ = ((String)localObject);
      if (!bHZ())
      {
        this.nwa = false;
        AppMethodBeat.o(21366);
        return;
      }
      this.nwa = false;
      if (!ba.aiE())
      {
        ad.i("MicroMsg.CheckNetworkGenQrCodeHandler", "begin to netscene create QRCode online ");
        ba.aiU().a(704, this.nwd);
        localObject = new com.tencent.mm.plugin.backup.e.b(this.nvX, this.nvY);
        ba.aiU().a((n)localObject, 0);
        AppMethodBeat.o(21366);
        return;
      }
      ad.i("MicroMsg.CheckNetworkGenQrCodeHandler", "begin to netscene create QRCode offline");
      ba.aiU().a(1000, this.nwe);
      localObject = new com.tencent.mm.plugin.backup.e.a(this.nvX, this.nvY, b.bHG().nuX);
      ba.aiU().a((n)localObject, 0);
    }
    AppMethodBeat.o(21366);
  }
  
  public final void start()
  {
    AppMethodBeat.i(21364);
    ad.i("MicroMsg.CheckNetworkGenQrCodeHandler", "start check network and gen qrcode handler starting:%b stop:%b .%s %s", new Object[] { Boolean.valueOf(this.nwa), Boolean.valueOf(this.nwc.fkZ()), this, bt.flS() });
    if (this.nwa)
    {
      AppMethodBeat.o(21364);
      return;
    }
    this.nwa = true;
    if (bHZ())
    {
      this.nvZ = null;
      bHY();
    }
    for (;;)
    {
      this.nwc.az(500L, 500L);
      AppMethodBeat.o(21364);
      return;
      this.nsE.nsJ = -4;
      this.nwb.n(-4, null);
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(21365);
    ad.i("MicroMsg.CheckNetworkGenQrCodeHandler", "stop check network and gen qrcode handler.");
    this.nwa = false;
    ba.aiU().b(704, this.nwd);
    ba.aiU().b(1000, this.nwe);
    this.nwc.stopTimer();
    AppMethodBeat.o(21365);
  }
  
  public static abstract interface a
  {
    public abstract void n(int paramInt, byte[] paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.e
 * JD-Core Version:    0.7.0.1
 */
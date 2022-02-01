package com.tencent.mm.plugin.backup.d;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.model.az;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.hs;
import com.tencent.mm.protocal.protobuf.ht;
import com.tencent.mm.protocal.protobuf.yf;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.av.a;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public final class e
{
  com.tencent.mm.plugin.backup.b.e mqe;
  private String mtA;
  private boolean mtB;
  a mtC;
  private av mtD;
  final com.tencent.mm.al.g mtE;
  final com.tencent.mm.al.g mtF;
  LinkedList<yf> mty;
  String mtz;
  
  public e(a parama, com.tencent.mm.plugin.backup.b.e parame)
  {
    AppMethodBeat.i(21363);
    this.mtA = "";
    this.mtB = false;
    this.mtD = new av(Looper.getMainLooper(), new av.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(21360);
        e.this.bwT();
        AppMethodBeat.o(21360);
        return true;
      }
    }, true);
    this.mtE = new com.tencent.mm.al.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(21361);
        com.tencent.mm.plugin.backup.g.b.b(704, e.this.mtE);
        ad.i("MicroMsg.CheckNetworkGenQrCodeHandler", "backup move receive createQrcode response.[%d,%d,%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          ad.e("MicroMsg.CheckNetworkGenQrCodeHandler", "create qrcode failed, errMsg:".concat(String.valueOf(paramAnonymousString)));
          ad.i("MicroMsg.CheckNetworkGenQrCodeHandler", "err: %d, %d, %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if (paramAnonymousInt2 == -100)
          {
            az.aeS().a(1000, e.this.mtF);
            paramAnonymousString = new com.tencent.mm.plugin.backup.e.a(e.this.mty, e.this.mtz, b.bwC().msy);
            az.aeS().a(paramAnonymousString, 0);
            AppMethodBeat.o(21361);
            return;
          }
          e.this.mqe.mqj = -11;
          e.this.mtC.n(-11, null);
          AppMethodBeat.o(21361);
          return;
        }
        paramAnonymousString = (com.tencent.mm.plugin.backup.e.b)paramAnonymousn;
        paramAnonymousn = (ht)paramAnonymousString.rr.gUT.gUX;
        b.bwC().mqb = "";
        b.bwC().mqc = paramAnonymousn.CCO;
        b.bwC().mqd = paramAnonymousn.CCP;
        b.bwC().msy = paramAnonymousn.CCK;
        paramAnonymousString = (ht)paramAnonymousString.rr.gUT.gUX;
        if (paramAnonymousString == null) {
          paramAnonymousString = null;
        }
        for (;;)
        {
          if (paramAnonymousString != null)
          {
            e.this.mqe.mqj = 51;
            e.this.mtC.n(51, paramAnonymousString);
          }
          AppMethodBeat.o(21361);
          return;
          if (paramAnonymousString.CCL == null) {
            paramAnonymousString = null;
          } else {
            paramAnonymousString = paramAnonymousString.CCL.getBufferToBytes();
          }
        }
      }
    };
    this.mtF = new com.tencent.mm.al.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(21362);
        com.tencent.mm.plugin.backup.g.b.b(1000, e.this.mtF);
        ad.i("MicroMsg.CheckNetworkGenQrCodeHandler", "backup move receive createOffilineQrcode response.[%d,%d,%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          ad.e("MicroMsg.CheckNetworkGenQrCodeHandler", "create offline qrcode failed, errMsg:".concat(String.valueOf(paramAnonymousString)));
          e.this.mqe.mqj = -11;
          e.this.mtC.n(-11, null);
          AppMethodBeat.o(21362);
          return;
        }
        paramAnonymousn = ((k.b)((com.tencent.mm.plugin.backup.e.a)paramAnonymousn).gVZ.getRespObj()).Cqx;
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
            e.this.mqe.mqj = 51;
            e.this.mtC.n(51, paramAnonymousString);
          }
          AppMethodBeat.o(21362);
          return;
          paramAnonymousString = paramAnonymousn.CCM;
          break;
          label202:
          if (paramAnonymousn.CCL == null) {
            paramAnonymousString = null;
          } else {
            paramAnonymousString = paramAnonymousn.CCL.getBufferToBytes();
          }
        }
      }
    };
    this.mtC = parama;
    this.mqe = parame;
    AppMethodBeat.o(21363);
  }
  
  private boolean bwU()
  {
    AppMethodBeat.i(21367);
    this.mty = new LinkedList();
    PString localPString = new PString();
    PInt localPInt = new PInt();
    this.mtz = com.tencent.mm.plugin.backup.b.g.dZ(aj.getContext());
    ad.i("MicroMsg.CheckNetworkGenQrCodeHandler", "wifiName :%s", new Object[] { this.mtz });
    if (bt.isNullOrNil(this.mtz))
    {
      this.mqe.mqj = -4;
      this.mtC.n(-4, null);
      this.mtA = "";
      AppMethodBeat.o(21367);
      return false;
    }
    if (!b.bwC().bwD().a(localPString, localPInt))
    {
      this.mqe.mqj = -4;
      this.mtC.n(-4, null);
      this.mtA = "";
      AppMethodBeat.o(21367);
      return false;
    }
    ad.i("MicroMsg.CheckNetworkGenQrCodeHandler", "server listen result: %s, %d", new Object[] { localPString.value, Integer.valueOf(localPInt.value) });
    yf localyf = new yf();
    localyf.CWU = localPString.value;
    localyf.Dai = new LinkedList();
    localyf.Dai.add(Integer.valueOf(localPInt.value));
    this.mty.add(localyf);
    AppMethodBeat.o(21367);
    return true;
  }
  
  final void bwT()
  {
    AppMethodBeat.i(21366);
    Object localObject = com.tencent.mm.plugin.backup.b.g.dZ(aj.getContext());
    ad.i("MicroMsg.CheckNetworkGenQrCodeHandler", "checkNetStatus newWifiName:%s  preWifiName:%s acc:%b hold:%b", new Object[] { localObject, this.mtA, Boolean.valueOf(az.afw()), Boolean.valueOf(az.aeC()) });
    if (!((String)localObject).equals(this.mtA))
    {
      if (!az.afw())
      {
        AppMethodBeat.o(21366);
        return;
      }
      this.mtA = ((String)localObject);
      if (!bwU())
      {
        this.mtB = false;
        AppMethodBeat.o(21366);
        return;
      }
      this.mtB = false;
      if (!az.aeC())
      {
        ad.i("MicroMsg.CheckNetworkGenQrCodeHandler", "begin to netscene create QRCode online ");
        az.aeS().a(704, this.mtE);
        localObject = new com.tencent.mm.plugin.backup.e.b(this.mty, this.mtz);
        az.aeS().a((n)localObject, 0);
        AppMethodBeat.o(21366);
        return;
      }
      ad.i("MicroMsg.CheckNetworkGenQrCodeHandler", "begin to netscene create QRCode offline");
      az.aeS().a(1000, this.mtF);
      localObject = new com.tencent.mm.plugin.backup.e.a(this.mty, this.mtz, b.bwC().msy);
      az.aeS().a((n)localObject, 0);
    }
    AppMethodBeat.o(21366);
  }
  
  public final void start()
  {
    AppMethodBeat.i(21364);
    ad.i("MicroMsg.CheckNetworkGenQrCodeHandler", "start check network and gen qrcode handler starting:%b stop:%b .%s %s", new Object[] { Boolean.valueOf(this.mtB), Boolean.valueOf(this.mtD.eFX()), this, bt.eGN() });
    if (this.mtB)
    {
      AppMethodBeat.o(21364);
      return;
    }
    this.mtB = true;
    if (bwU())
    {
      this.mtA = null;
      bwT();
    }
    for (;;)
    {
      this.mtD.av(500L, 500L);
      AppMethodBeat.o(21364);
      return;
      this.mqe.mqj = -4;
      this.mtC.n(-4, null);
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(21365);
    ad.i("MicroMsg.CheckNetworkGenQrCodeHandler", "stop check network and gen qrcode handler.");
    this.mtB = false;
    az.aeS().b(704, this.mtE);
    az.aeS().b(1000, this.mtF);
    this.mtD.stopTimer();
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
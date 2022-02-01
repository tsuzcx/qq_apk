package com.tencent.mm.plugin.backup.d;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.model.az;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.hw;
import com.tencent.mm.protocal.protobuf.hx;
import com.tencent.mm.protocal.protobuf.za;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.au.a;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.LinkedList;

public final class e
{
  com.tencent.mm.plugin.backup.b.e mSf;
  LinkedList<za> mVA;
  String mVB;
  private String mVC;
  private boolean mVD;
  a mVE;
  private au mVF;
  final com.tencent.mm.ak.g mVG;
  final com.tencent.mm.ak.g mVH;
  
  public e(a parama, com.tencent.mm.plugin.backup.b.e parame)
  {
    AppMethodBeat.i(21363);
    this.mVC = "";
    this.mVD = false;
    this.mVF = new au(Looper.getMainLooper(), new au.a()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(21360);
        e.this.bDP();
        AppMethodBeat.o(21360);
        return true;
      }
    }, true);
    this.mVG = new com.tencent.mm.ak.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(21361);
        com.tencent.mm.plugin.backup.g.b.b(704, e.this.mVG);
        ac.i("MicroMsg.CheckNetworkGenQrCodeHandler", "backup move receive createQrcode response.[%d,%d,%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          ac.e("MicroMsg.CheckNetworkGenQrCodeHandler", "create qrcode failed, errMsg:".concat(String.valueOf(paramAnonymousString)));
          ac.i("MicroMsg.CheckNetworkGenQrCodeHandler", "err: %d, %d, %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if (paramAnonymousInt2 == -100)
          {
            az.agi().a(1000, e.this.mVH);
            paramAnonymousString = new com.tencent.mm.plugin.backup.e.a(e.this.mVA, e.this.mVB, b.bDy().mUz);
            az.agi().a(paramAnonymousString, 0);
            AppMethodBeat.o(21361);
            return;
          }
          e.this.mSf.mSk = -11;
          e.this.mVE.n(-11, null);
          AppMethodBeat.o(21361);
          return;
        }
        paramAnonymousString = (com.tencent.mm.plugin.backup.e.b)paramAnonymousn;
        paramAnonymousn = (hx)paramAnonymousString.rr.hvs.hvw;
        b.bDy().mSc = "";
        b.bDy().mSd = paramAnonymousn.DVl;
        b.bDy().mSe = paramAnonymousn.DVm;
        b.bDy().mUz = paramAnonymousn.DVh;
        paramAnonymousString = (hx)paramAnonymousString.rr.hvs.hvw;
        if (paramAnonymousString == null) {
          paramAnonymousString = null;
        }
        for (;;)
        {
          if (paramAnonymousString != null)
          {
            e.this.mSf.mSk = 51;
            e.this.mVE.n(51, paramAnonymousString);
          }
          AppMethodBeat.o(21361);
          return;
          if (paramAnonymousString.DVi == null) {
            paramAnonymousString = null;
          } else {
            paramAnonymousString = paramAnonymousString.DVi.getBufferToBytes();
          }
        }
      }
    };
    this.mVH = new com.tencent.mm.ak.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(21362);
        com.tencent.mm.plugin.backup.g.b.b(1000, e.this.mVH);
        ac.i("MicroMsg.CheckNetworkGenQrCodeHandler", "backup move receive createOffilineQrcode response.[%d,%d,%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          ac.e("MicroMsg.CheckNetworkGenQrCodeHandler", "create offline qrcode failed, errMsg:".concat(String.valueOf(paramAnonymousString)));
          e.this.mSf.mSk = -11;
          e.this.mVE.n(-11, null);
          AppMethodBeat.o(21362);
          return;
        }
        paramAnonymousn = ((k.b)((com.tencent.mm.plugin.backup.e.a)paramAnonymousn).hwy.getRespObj()).DIP;
        if (paramAnonymousn == null)
        {
          paramAnonymousString = "null";
          ac.i("MicroMsg.BackupCreateQRCodeOfflineScene", "onGYNetEnd QRCodeUrl:%s", new Object[] { paramAnonymousString });
          if (paramAnonymousn != null) {
            break label202;
          }
          paramAnonymousString = null;
        }
        for (;;)
        {
          if (paramAnonymousString != null)
          {
            e.this.mSf.mSk = 51;
            e.this.mVE.n(51, paramAnonymousString);
          }
          AppMethodBeat.o(21362);
          return;
          paramAnonymousString = paramAnonymousn.DVj;
          break;
          label202:
          if (paramAnonymousn.DVi == null) {
            paramAnonymousString = null;
          } else {
            paramAnonymousString = paramAnonymousn.DVi.getBufferToBytes();
          }
        }
      }
    };
    this.mVE = parama;
    this.mSf = parame;
    AppMethodBeat.o(21363);
  }
  
  private boolean bDQ()
  {
    AppMethodBeat.i(21367);
    this.mVA = new LinkedList();
    PString localPString = new PString();
    PInt localPInt = new PInt();
    this.mVB = com.tencent.mm.plugin.backup.b.g.eh(ai.getContext());
    ac.i("MicroMsg.CheckNetworkGenQrCodeHandler", "wifiName :%s", new Object[] { this.mVB });
    if (bs.isNullOrNil(this.mVB))
    {
      this.mSf.mSk = -4;
      this.mVE.n(-4, null);
      this.mVC = "";
      AppMethodBeat.o(21367);
      return false;
    }
    if (!b.bDy().bDz().a(localPString, localPInt))
    {
      this.mSf.mSk = -4;
      this.mVE.n(-4, null);
      this.mVC = "";
      AppMethodBeat.o(21367);
      return false;
    }
    ac.i("MicroMsg.CheckNetworkGenQrCodeHandler", "server listen result: %s, %d", new Object[] { localPString.value, Integer.valueOf(localPInt.value) });
    za localza = new za();
    localza.EpD = localPString.value;
    localza.Etf = new LinkedList();
    localza.Etf.add(Integer.valueOf(localPInt.value));
    this.mVA.add(localza);
    AppMethodBeat.o(21367);
    return true;
  }
  
  final void bDP()
  {
    AppMethodBeat.i(21366);
    Object localObject = com.tencent.mm.plugin.backup.b.g.eh(ai.getContext());
    ac.i("MicroMsg.CheckNetworkGenQrCodeHandler", "checkNetStatus newWifiName:%s  preWifiName:%s acc:%b hold:%b", new Object[] { localObject, this.mVC, Boolean.valueOf(az.agM()), Boolean.valueOf(az.afS()) });
    if (!((String)localObject).equals(this.mVC))
    {
      if (!az.agM())
      {
        AppMethodBeat.o(21366);
        return;
      }
      this.mVC = ((String)localObject);
      if (!bDQ())
      {
        this.mVD = false;
        AppMethodBeat.o(21366);
        return;
      }
      this.mVD = false;
      if (!az.afS())
      {
        ac.i("MicroMsg.CheckNetworkGenQrCodeHandler", "begin to netscene create QRCode online ");
        az.agi().a(704, this.mVG);
        localObject = new com.tencent.mm.plugin.backup.e.b(this.mVA, this.mVB);
        az.agi().a((n)localObject, 0);
        AppMethodBeat.o(21366);
        return;
      }
      ac.i("MicroMsg.CheckNetworkGenQrCodeHandler", "begin to netscene create QRCode offline");
      az.agi().a(1000, this.mVH);
      localObject = new com.tencent.mm.plugin.backup.e.a(this.mVA, this.mVB, b.bDy().mUz);
      az.agi().a((n)localObject, 0);
    }
    AppMethodBeat.o(21366);
  }
  
  public final void start()
  {
    AppMethodBeat.i(21364);
    ac.i("MicroMsg.CheckNetworkGenQrCodeHandler", "start check network and gen qrcode handler starting:%b stop:%b .%s %s", new Object[] { Boolean.valueOf(this.mVD), Boolean.valueOf(this.mVF.eVs()), this, bs.eWi() });
    if (this.mVD)
    {
      AppMethodBeat.o(21364);
      return;
    }
    this.mVD = true;
    if (bDQ())
    {
      this.mVC = null;
      bDP();
    }
    for (;;)
    {
      this.mVF.au(500L, 500L);
      AppMethodBeat.o(21364);
      return;
      this.mSf.mSk = -4;
      this.mVE.n(-4, null);
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(21365);
    ac.i("MicroMsg.CheckNetworkGenQrCodeHandler", "stop check network and gen qrcode handler.");
    this.mVD = false;
    az.agi().b(704, this.mVG);
    az.agi().b(1000, this.mVH);
    this.mVF.stopTimer();
    AppMethodBeat.o(21365);
  }
  
  public static abstract interface a
  {
    public abstract void n(int paramInt, byte[] paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.e
 * JD-Core Version:    0.7.0.1
 */
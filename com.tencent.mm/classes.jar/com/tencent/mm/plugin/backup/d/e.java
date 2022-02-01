package com.tencent.mm.plugin.backup.d;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.model.bh;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.protobuf.adp;
import com.tencent.mm.protocal.protobuf.eae;
import com.tencent.mm.protocal.protobuf.if;
import com.tencent.mm.protocal.protobuf.ig;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class e
{
  private static long rOq = 30000L;
  private long lastUpdateTime;
  private com.tencent.mm.plugin.backup.b.e rKN;
  private LinkedList<adp> rOm;
  private String rOn;
  private String rOo;
  private boolean rOp;
  private a rOr;
  private MTimerHandler rOs;
  final i rOt;
  final i rOu;
  
  public e(a parama, com.tencent.mm.plugin.backup.b.e parame)
  {
    AppMethodBeat.i(21363);
    this.rOo = "";
    this.rOp = false;
    this.lastUpdateTime = 0L;
    this.rOs = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(21360);
        e.a(e.this);
        AppMethodBeat.o(21360);
        return true;
      }
    }, true);
    this.rOt = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(21361);
        com.tencent.mm.plugin.backup.g.b.b(704, e.this.rOt);
        Log.i("MicroMsg.CheckNetworkGenQrCodeHandler", "backup move receive createQrcode response.[%d,%d,%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          if ((paramAnonymousInt2 == -100) || (paramAnonymousInt2 == -2023))
          {
            bh.aGY().a(1000, e.this.rOu);
            paramAnonymousString = new com.tencent.mm.plugin.backup.e.a(e.b(e.this), e.c(e.this), b.csI().rNg);
            bh.aGY().a(paramAnonymousString, 0);
            AppMethodBeat.o(21361);
            return;
          }
          e.d(e.this).rKS = -11;
          e.e(e.this).o(-11, null);
          AppMethodBeat.o(21361);
          return;
        }
        paramAnonymousString = (com.tencent.mm.plugin.backup.e.b)paramAnonymousq;
        paramAnonymousq = (ig)d.c.b(paramAnonymousString.rr.lBS);
        b.csI().rKK = "";
        b.csI().rKL = paramAnonymousq.RNF;
        b.csI().rKM = paramAnonymousq.RNG;
        b.csI().rNg = paramAnonymousq.RNB;
        paramAnonymousString = (ig)d.c.b(paramAnonymousString.rr.lBS);
        if (paramAnonymousString == null) {
          paramAnonymousString = null;
        }
        for (;;)
        {
          if (paramAnonymousString != null)
          {
            e.d(e.this).rKS = 51;
            e.e(e.this).o(51, paramAnonymousString);
          }
          AppMethodBeat.o(21361);
          return;
          if (paramAnonymousString.RNC == null) {
            paramAnonymousString = null;
          } else {
            paramAnonymousString = paramAnonymousString.RNC.Tkb.UH;
          }
        }
      }
    };
    this.rOu = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(21362);
        com.tencent.mm.plugin.backup.g.b.b(1000, e.this.rOu);
        Log.i("MicroMsg.CheckNetworkGenQrCodeHandler", "backup move receive createOffilineQrcode response.[%d,%d,%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          Log.e("MicroMsg.CheckNetworkGenQrCodeHandler", "create offline qrcode failed, errMsg:".concat(String.valueOf(paramAnonymousString)));
          e.d(e.this).rKS = -11;
          e.e(e.this).o(-11, null);
          AppMethodBeat.o(21362);
          return;
        }
        paramAnonymousq = ((k.b)((com.tencent.mm.plugin.backup.e.a)paramAnonymousq).lCW.getRespObj()).RBv;
        if (paramAnonymousq == null)
        {
          paramAnonymousString = "null";
          Log.i("MicroMsg.BackupCreateQRCodeOfflineScene", "onGYNetEnd QRCodeUrl:%s", new Object[] { paramAnonymousString });
          if (paramAnonymousq != null) {
            break label202;
          }
          paramAnonymousString = null;
        }
        for (;;)
        {
          if (paramAnonymousString != null)
          {
            e.d(e.this).rKS = 51;
            e.e(e.this).o(51, paramAnonymousString);
          }
          AppMethodBeat.o(21362);
          return;
          paramAnonymousString = paramAnonymousq.RND;
          break;
          label202:
          if (paramAnonymousq.RNC == null) {
            paramAnonymousString = null;
          } else {
            paramAnonymousString = paramAnonymousq.RNC.Tkb.UH;
          }
        }
      }
    };
    this.rOr = parama;
    this.rKN = parame;
    AppMethodBeat.o(21363);
  }
  
  private void ctb()
  {
    AppMethodBeat.i(21366);
    Object localObject = g.eH(MMApplicationContext.getContext());
    if ((!((String)localObject).equals(this.rOo)) || (Util.milliSecondsToNow(this.lastUpdateTime) >= rOq))
    {
      Log.i("MicroMsg.CheckNetworkGenQrCodeHandler", "checkNetStatus newWifiName:%s, preWifiName:%s", new Object[] { localObject, this.rOo });
      if (!bh.aHB())
      {
        AppMethodBeat.o(21366);
        return;
      }
      this.rOo = ((String)localObject);
      if (!ctc())
      {
        Log.e("MicroMsg.CheckNetworkGenQrCodeHandler", "checkNetStatus initNetSceneParameter failed");
        this.rOp = false;
        AppMethodBeat.o(21366);
        return;
      }
      this.rOp = false;
      if (com.tencent.mm.kernel.b.aGQ() == 0) {
        break label174;
      }
      Log.i("MicroMsg.CheckNetworkGenQrCodeHandler", "checkNetStatus create QRCode online ");
      bh.aGY().a(704, this.rOt);
      localObject = new com.tencent.mm.plugin.backup.e.b(this.rOm, this.rOn);
      bh.aGY().a((q)localObject, 0);
    }
    for (;;)
    {
      this.lastUpdateTime = Util.nowMilliSecond();
      AppMethodBeat.o(21366);
      return;
      label174:
      Log.i("MicroMsg.CheckNetworkGenQrCodeHandler", "checkNetStatus create QRCode offline");
      bh.aGY().a(1000, this.rOu);
      localObject = new com.tencent.mm.plugin.backup.e.a(this.rOm, this.rOn, b.csI().rNg);
      bh.aGY().a((q)localObject, 0);
    }
  }
  
  private boolean ctc()
  {
    AppMethodBeat.i(21367);
    this.rOm = new LinkedList();
    PString localPString = new PString();
    PInt localPInt = new PInt();
    this.rOn = g.eH(MMApplicationContext.getContext());
    Log.i("MicroMsg.CheckNetworkGenQrCodeHandler", "wifiName :%s", new Object[] { this.rOn });
    if (Util.isNullOrNil(this.rOn))
    {
      this.rKN.rKS = -4;
      this.rOr.o(-4, null);
      this.rOo = "";
      AppMethodBeat.o(21367);
      return false;
    }
    if (!b.csI().csJ().a(localPString, localPInt))
    {
      this.rKN.rKS = -4;
      this.rOr.o(-4, null);
      this.rOo = "";
      AppMethodBeat.o(21367);
      return false;
    }
    Log.i("MicroMsg.CheckNetworkGenQrCodeHandler", "server listen result: %s, %d", new Object[] { localPString.value, Integer.valueOf(localPInt.value) });
    adp localadp = new adp();
    localadp.Slg = localPString.value;
    localadp.SpS = new LinkedList();
    localadp.SpS.add(Integer.valueOf(localPInt.value));
    this.rOm.add(localadp);
    AppMethodBeat.o(21367);
    return true;
  }
  
  public final void start()
  {
    AppMethodBeat.i(21364);
    Log.i("MicroMsg.CheckNetworkGenQrCodeHandler", "start check network and gen qrcode handler starting:%b stop:%b .%s %s", new Object[] { Boolean.valueOf(this.rOp), Boolean.valueOf(this.rOs.stopped()), this, Util.getStack() });
    if (this.rOp)
    {
      AppMethodBeat.o(21364);
      return;
    }
    this.rOp = true;
    this.lastUpdateTime = Util.nowMilliSecond();
    if (ctc())
    {
      this.rOo = null;
      ctb();
    }
    for (;;)
    {
      this.rOs.startTimer(5000L);
      AppMethodBeat.o(21364);
      return;
      this.rKN.rKS = -4;
      this.rOr.o(-4, null);
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(21365);
    Log.i("MicroMsg.CheckNetworkGenQrCodeHandler", "stop check network and gen qrcode handler.");
    this.rOp = false;
    bh.aGY().b(704, this.rOt);
    bh.aGY().b(1000, this.rOu);
    this.rOs.stopTimer();
    AppMethodBeat.o(21365);
  }
  
  public static abstract interface a
  {
    public abstract void o(int paramInt, byte[] paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.e
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.backup.d;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.protobuf.afx;
import com.tencent.mm.protocal.protobuf.gol;
import com.tencent.mm.protocal.protobuf.jb;
import com.tencent.mm.protocal.protobuf.jc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class e
{
  private static long uZE = 30000L;
  private long lastUpdateTime;
  private com.tencent.mm.plugin.backup.b.e uWb;
  private LinkedList<afx> uZA;
  private String uZB;
  private String uZC;
  private boolean uZD;
  private a uZF;
  private MTimerHandler uZG;
  final h uZH;
  final h uZI;
  
  public e(a parama, com.tencent.mm.plugin.backup.b.e parame)
  {
    AppMethodBeat.i(21363);
    this.uZC = "";
    this.uZD = false;
    this.lastUpdateTime = 0L;
    this.uZG = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(21360);
        e.a(e.this);
        AppMethodBeat.o(21360);
        return true;
      }
    }, true);
    this.uZH = new h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
      {
        AppMethodBeat.i(21361);
        com.tencent.mm.plugin.backup.g.b.b(704, e.this.uZH);
        Log.i("MicroMsg.CheckNetworkGenQrCodeHandler", "backup move receive createQrcode response.[%d,%d,%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          if ((paramAnonymousInt2 == -100) || (paramAnonymousInt2 == -2023))
          {
            bh.aZW().a(1000, e.this.uZI);
            paramAnonymousString = new com.tencent.mm.plugin.backup.e.a(e.b(e.this), e.c(e.this), b.cVs().uYu);
            bh.aZW().a(paramAnonymousString, 0);
            AppMethodBeat.o(21361);
            return;
          }
          e.d(e.this).uWg = -11;
          e.e(e.this).o(-11, null);
          AppMethodBeat.o(21361);
          return;
        }
        paramAnonymousString = (com.tencent.mm.plugin.backup.e.b)paramAnonymousp;
        paramAnonymousp = (jc)c.c.b(paramAnonymousString.rr.otC);
        b.cVs().uVY = "";
        b.cVs().uVZ = paramAnonymousp.YKT;
        b.cVs().uWa = paramAnonymousp.YKU;
        b.cVs().uYu = paramAnonymousp.YKP;
        paramAnonymousString = (jc)c.c.b(paramAnonymousString.rr.otC);
        if (paramAnonymousString == null) {
          paramAnonymousString = null;
        }
        for (;;)
        {
          if (paramAnonymousString != null)
          {
            e.d(e.this).uWg = 51;
            e.e(e.this).o(51, paramAnonymousString);
          }
          AppMethodBeat.o(21361);
          return;
          if (paramAnonymousString.YKQ == null) {
            paramAnonymousString = null;
          } else {
            paramAnonymousString = paramAnonymousString.YKQ.aaxD.Op;
          }
        }
      }
    };
    this.uZI = new h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
      {
        AppMethodBeat.i(21362);
        com.tencent.mm.plugin.backup.g.b.b(1000, e.this.uZI);
        Log.i("MicroMsg.CheckNetworkGenQrCodeHandler", "backup move receive createOffilineQrcode response.[%d,%d,%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          Log.e("MicroMsg.CheckNetworkGenQrCodeHandler", "create offline qrcode failed, errMsg:".concat(String.valueOf(paramAnonymousString)));
          e.d(e.this).uWg = -11;
          e.e(e.this).o(-11, null);
          AppMethodBeat.o(21362);
          return;
        }
        paramAnonymousp = ((k.b)((com.tencent.mm.plugin.backup.e.a)paramAnonymousp).ouH.getRespObj()).YxY;
        if (paramAnonymousp == null)
        {
          paramAnonymousString = "null";
          Log.i("MicroMsg.BackupCreateQRCodeOfflineScene", "onGYNetEnd QRCodeUrl:%s", new Object[] { paramAnonymousString });
          if (paramAnonymousp != null) {
            break label202;
          }
          paramAnonymousString = null;
        }
        for (;;)
        {
          if (paramAnonymousString != null)
          {
            e.d(e.this).uWg = 51;
            e.e(e.this).o(51, paramAnonymousString);
          }
          AppMethodBeat.o(21362);
          return;
          paramAnonymousString = paramAnonymousp.YKR;
          break;
          label202:
          if (paramAnonymousp.YKQ == null) {
            paramAnonymousString = null;
          } else {
            paramAnonymousString = paramAnonymousp.YKQ.aaxD.Op;
          }
        }
      }
    };
    this.uZF = parama;
    this.uWb = parame;
    AppMethodBeat.o(21363);
  }
  
  private void cVL()
  {
    AppMethodBeat.i(21366);
    Object localObject = g.fC(MMApplicationContext.getContext());
    if ((!((String)localObject).equals(this.uZC)) || (Util.milliSecondsToNow(this.lastUpdateTime) >= uZE))
    {
      Log.i("MicroMsg.CheckNetworkGenQrCodeHandler", "checkNetStatus newWifiName:%s, preWifiName:%s", new Object[] { localObject, this.uZC });
      if (!bh.baz())
      {
        AppMethodBeat.o(21366);
        return;
      }
      this.uZC = ((String)localObject);
      if (!cVM())
      {
        Log.e("MicroMsg.CheckNetworkGenQrCodeHandler", "checkNetStatus initNetSceneParameter failed");
        this.uZD = false;
        AppMethodBeat.o(21366);
        return;
      }
      this.uZD = false;
      if (com.tencent.mm.kernel.b.aZQ() == 0) {
        break label174;
      }
      Log.i("MicroMsg.CheckNetworkGenQrCodeHandler", "checkNetStatus create QRCode online ");
      bh.aZW().a(704, this.uZH);
      localObject = new com.tencent.mm.plugin.backup.e.b(this.uZA, this.uZB);
      bh.aZW().a((p)localObject, 0);
    }
    for (;;)
    {
      this.lastUpdateTime = Util.nowMilliSecond();
      AppMethodBeat.o(21366);
      return;
      label174:
      Log.i("MicroMsg.CheckNetworkGenQrCodeHandler", "checkNetStatus create QRCode offline");
      bh.aZW().a(1000, this.uZI);
      localObject = new com.tencent.mm.plugin.backup.e.a(this.uZA, this.uZB, b.cVs().uYu);
      bh.aZW().a((p)localObject, 0);
    }
  }
  
  private boolean cVM()
  {
    AppMethodBeat.i(21367);
    this.uZA = new LinkedList();
    PString localPString = new PString();
    PInt localPInt = new PInt();
    this.uZB = g.fC(MMApplicationContext.getContext());
    Log.i("MicroMsg.CheckNetworkGenQrCodeHandler", "wifiName :%s", new Object[] { this.uZB });
    if (Util.isNullOrNil(this.uZB))
    {
      this.uWb.uWg = -4;
      this.uZF.o(-4, null);
      this.uZC = "";
      AppMethodBeat.o(21367);
      return false;
    }
    if (!b.cVs().cVt().a(localPString, localPInt))
    {
      this.uWb.uWg = -4;
      this.uZF.o(-4, null);
      this.uZC = "";
      AppMethodBeat.o(21367);
      return false;
    }
    Log.i("MicroMsg.CheckNetworkGenQrCodeHandler", "server listen result: %s, %d", new Object[] { localPString.value, Integer.valueOf(localPInt.value) });
    afx localafx = new afx();
    localafx.Zjq = localPString.value;
    localafx.ZoN = new LinkedList();
    localafx.ZoN.add(Integer.valueOf(localPInt.value));
    this.uZA.add(localafx);
    AppMethodBeat.o(21367);
    return true;
  }
  
  public final void start()
  {
    AppMethodBeat.i(21364);
    Log.i("MicroMsg.CheckNetworkGenQrCodeHandler", "start check network and gen qrcode handler starting:%b stop:%b .%s %s", new Object[] { Boolean.valueOf(this.uZD), Boolean.valueOf(this.uZG.stopped()), this, Util.getStack() });
    if (this.uZD)
    {
      AppMethodBeat.o(21364);
      return;
    }
    this.uZD = true;
    this.lastUpdateTime = Util.nowMilliSecond();
    if (cVM())
    {
      this.uZC = null;
      cVL();
    }
    for (;;)
    {
      this.uZG.startTimer(5000L);
      AppMethodBeat.o(21364);
      return;
      this.uWb.uWg = -4;
      this.uZF.o(-4, null);
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(21365);
    Log.i("MicroMsg.CheckNetworkGenQrCodeHandler", "stop check network and gen qrcode handler.");
    this.uZD = false;
    bh.aZW().b(704, this.uZH);
    bh.aZW().b(1000, this.uZI);
    this.uZG.stopTimer();
    AppMethodBeat.o(21365);
  }
  
  public static abstract interface a
  {
    public abstract void o(int paramInt, byte[] paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.e
 * JD-Core Version:    0.7.0.1
 */
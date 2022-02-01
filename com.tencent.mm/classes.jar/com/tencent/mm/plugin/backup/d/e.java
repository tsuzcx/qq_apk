package com.tencent.mm.plugin.backup.d;

import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.model.bg;
import com.tencent.mm.network.s;
import com.tencent.mm.plugin.backup.b.g;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.protocal.k.b;
import com.tencent.mm.protocal.protobuf.SKBuiltinBuffer_t;
import com.tencent.mm.protocal.protobuf.adi;
import com.tencent.mm.protocal.protobuf.iq;
import com.tencent.mm.protocal.protobuf.ir;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler.CallBack;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class e
{
  com.tencent.mm.plugin.backup.b.e oIX;
  LinkedList<adi> oMr;
  String oMs;
  private String oMt;
  private boolean oMu;
  a oMv;
  private MTimerHandler oMw;
  final i oMx;
  final i oMy;
  
  public e(a parama, com.tencent.mm.plugin.backup.b.e parame)
  {
    AppMethodBeat.i(21363);
    this.oMt = "";
    this.oMu = false;
    this.oMw = new MTimerHandler(Looper.getMainLooper(), new MTimerHandler.CallBack()
    {
      public final boolean onTimerExpired()
      {
        AppMethodBeat.i(21360);
        e.this.cfO();
        AppMethodBeat.o(21360);
        return true;
      }
    }, true);
    this.oMx = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(21361);
        com.tencent.mm.plugin.backup.g.b.b(704, e.this.oMx);
        Log.i("MicroMsg.CheckNetworkGenQrCodeHandler", "backup move receive createQrcode response.[%d,%d,%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          Log.e("MicroMsg.CheckNetworkGenQrCodeHandler", "create qrcode failed, errMsg:".concat(String.valueOf(paramAnonymousString)));
          Log.i("MicroMsg.CheckNetworkGenQrCodeHandler", "err: %d, %d, %s", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
          if ((paramAnonymousInt2 == -100) || (paramAnonymousInt2 == -2023))
          {
            bg.azz().a(1000, e.this.oMy);
            paramAnonymousString = new com.tencent.mm.plugin.backup.e.a(e.this.oMr, e.this.oMs, b.cfv().oLq);
            bg.azz().a(paramAnonymousString, 0);
            AppMethodBeat.o(21361);
            return;
          }
          e.this.oIX.oJc = -11;
          e.this.oMv.n(-11, null);
          AppMethodBeat.o(21361);
          return;
        }
        paramAnonymousString = (com.tencent.mm.plugin.backup.e.b)paramAnonymousq;
        paramAnonymousq = (ir)paramAnonymousString.rr.iLL.iLR;
        b.cfv().oIU = "";
        b.cfv().oIV = paramAnonymousq.KML;
        b.cfv().oIW = paramAnonymousq.KMM;
        b.cfv().oLq = paramAnonymousq.KMH;
        paramAnonymousString = (ir)paramAnonymousString.rr.iLL.iLR;
        if (paramAnonymousString == null) {
          paramAnonymousString = null;
        }
        for (;;)
        {
          if (paramAnonymousString != null)
          {
            e.this.oIX.oJc = 51;
            e.this.oMv.n(51, paramAnonymousString);
          }
          AppMethodBeat.o(21361);
          return;
          if (paramAnonymousString.KMI == null) {
            paramAnonymousString = null;
          } else {
            paramAnonymousString = paramAnonymousString.KMI.getBufferToBytes();
          }
        }
      }
    };
    this.oMy = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(21362);
        com.tencent.mm.plugin.backup.g.b.b(1000, e.this.oMy);
        Log.i("MicroMsg.CheckNetworkGenQrCodeHandler", "backup move receive createOffilineQrcode response.[%d,%d,%s]", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2), paramAnonymousString });
        if ((paramAnonymousInt1 != 0) || (paramAnonymousInt2 != 0))
        {
          Log.e("MicroMsg.CheckNetworkGenQrCodeHandler", "create offline qrcode failed, errMsg:".concat(String.valueOf(paramAnonymousString)));
          e.this.oIX.oJc = -11;
          e.this.oMv.n(-11, null);
          AppMethodBeat.o(21362);
          return;
        }
        paramAnonymousq = ((k.b)((com.tencent.mm.plugin.backup.e.a)paramAnonymousq).iMO.getRespObj()).KzF;
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
            e.this.oIX.oJc = 51;
            e.this.oMv.n(51, paramAnonymousString);
          }
          AppMethodBeat.o(21362);
          return;
          paramAnonymousString = paramAnonymousq.KMJ;
          break;
          label202:
          if (paramAnonymousq.KMI == null) {
            paramAnonymousString = null;
          } else {
            paramAnonymousString = paramAnonymousq.KMI.getBufferToBytes();
          }
        }
      }
    };
    this.oMv = parama;
    this.oIX = parame;
    AppMethodBeat.o(21363);
  }
  
  private boolean cfP()
  {
    AppMethodBeat.i(21367);
    this.oMr = new LinkedList();
    PString localPString = new PString();
    PInt localPInt = new PInt();
    this.oMs = g.eE(MMApplicationContext.getContext());
    Log.i("MicroMsg.CheckNetworkGenQrCodeHandler", "wifiName :%s", new Object[] { this.oMs });
    if (Util.isNullOrNil(this.oMs))
    {
      this.oIX.oJc = -4;
      this.oMv.n(-4, null);
      this.oMt = "";
      AppMethodBeat.o(21367);
      return false;
    }
    if (!b.cfv().cfw().a(localPString, localPInt))
    {
      this.oIX.oJc = -4;
      this.oMv.n(-4, null);
      this.oMt = "";
      AppMethodBeat.o(21367);
      return false;
    }
    Log.i("MicroMsg.CheckNetworkGenQrCodeHandler", "server listen result: %s, %d", new Object[] { localPString.value, Integer.valueOf(localPInt.value) });
    adi localadi = new adi();
    localadi.LjZ = localPString.value;
    localadi.Low = new LinkedList();
    localadi.Low.add(Integer.valueOf(localPInt.value));
    this.oMr.add(localadi);
    AppMethodBeat.o(21367);
    return true;
  }
  
  final void cfO()
  {
    AppMethodBeat.i(21366);
    Object localObject = g.eE(MMApplicationContext.getContext());
    Log.i("MicroMsg.CheckNetworkGenQrCodeHandler", "checkNetStatus newWifiName:%s  preWifiName:%s acc:%b hold:%b", new Object[] { localObject, this.oMt, Boolean.valueOf(bg.aAc()), Boolean.valueOf(bg.azj()) });
    if (!((String)localObject).equals(this.oMt))
    {
      if (!bg.aAc())
      {
        AppMethodBeat.o(21366);
        return;
      }
      this.oMt = ((String)localObject);
      if (!cfP())
      {
        this.oMu = false;
        AppMethodBeat.o(21366);
        return;
      }
      this.oMu = false;
      if (!bg.azj())
      {
        Log.i("MicroMsg.CheckNetworkGenQrCodeHandler", "begin to netscene create QRCode online ");
        bg.azz().a(704, this.oMx);
        localObject = new com.tencent.mm.plugin.backup.e.b(this.oMr, this.oMs);
        bg.azz().a((q)localObject, 0);
        AppMethodBeat.o(21366);
        return;
      }
      Log.i("MicroMsg.CheckNetworkGenQrCodeHandler", "begin to netscene create QRCode offline");
      bg.azz().a(1000, this.oMy);
      localObject = new com.tencent.mm.plugin.backup.e.a(this.oMr, this.oMs, b.cfv().oLq);
      bg.azz().a((q)localObject, 0);
    }
    AppMethodBeat.o(21366);
  }
  
  public final void start()
  {
    AppMethodBeat.i(21364);
    Log.i("MicroMsg.CheckNetworkGenQrCodeHandler", "start check network and gen qrcode handler starting:%b stop:%b .%s %s", new Object[] { Boolean.valueOf(this.oMu), Boolean.valueOf(this.oMw.stopped()), this, Util.getStack() });
    if (this.oMu)
    {
      AppMethodBeat.o(21364);
      return;
    }
    this.oMu = true;
    if (cfP())
    {
      this.oMt = null;
      cfO();
    }
    for (;;)
    {
      this.oMw.startTimer(500L);
      AppMethodBeat.o(21364);
      return;
      this.oIX.oJc = -4;
      this.oMv.n(-4, null);
    }
  }
  
  public final void stop()
  {
    AppMethodBeat.i(21365);
    Log.i("MicroMsg.CheckNetworkGenQrCodeHandler", "stop check network and gen qrcode handler.");
    this.oMu = false;
    bg.azz().b(704, this.oMx);
    bg.azz().b(1000, this.oMy);
    this.oMw.stopTimer();
    AppMethodBeat.o(21365);
  }
  
  public static abstract interface a
  {
    public abstract void n(int paramInt, byte[] paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.d.e
 * JD-Core Version:    0.7.0.1
 */
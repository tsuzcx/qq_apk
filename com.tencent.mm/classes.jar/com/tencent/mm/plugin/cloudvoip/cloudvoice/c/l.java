package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bv.b;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.compatible.e.n;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.b.c;
import com.tencent.mm.protocal.protobuf.uw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ag;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.voip.mars.comm.PlatformComm;
import com.tencent.wxmm.IConfCallBack;
import com.tencent.wxmm.v2conference;
import java.io.IOException;

class l
{
  private static final String[] kJu;
  private static v2conference kKw;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(135497);
    kJu = new String[] { "marsbridgenetwork", "marsbridgexlog", "confService" };
    Context localContext = ah.getContext();
    ab.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "hy: load so");
    String[] arrayOfString = kJu;
    int j = arrayOfString.length;
    while (i < j)
    {
      k.a(arrayOfString[i], l.class.getClassLoader());
      i += 1;
    }
    PlatformComm.init(localContext, new Handler(Looper.getMainLooper()));
    kKw = new v2conference();
    AppMethodBeat.o(135497);
  }
  
  public static int Jl(String paramString)
  {
    AppMethodBeat.i(135488);
    int i = kKw.UpdateAuthKey(paramString.getBytes(), paramString.getBytes().length);
    AppMethodBeat.o(135488);
    return i;
  }
  
  public static int N(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(135491);
    paramInt = kKw.GetAudioData(paramArrayOfByte, paramInt);
    AppMethodBeat.o(135491);
    return paramInt;
  }
  
  public static int a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, IConfCallBack paramIConfCallBack)
  {
    AppMethodBeat.i(145857);
    ab.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "hy: init voip");
    int j = -1;
    i = j;
    for (;;)
    {
      try
      {
        uw localuw = new uw();
        i = j;
        localuw.app_id = paramString1;
        i = j;
        localuw.wNe = paramString2;
        i = j;
        localuw.wNf = paramString3;
        i = j;
        localuw.wNg = (e.eQu + "/openvoice");
        i = j;
        localuw.wNh = 0;
        i = j;
        localuw.wNi = 1;
        i = j;
        localuw.wNj = c.bhk();
        i = j;
        localuw.wNk = paramInt1;
        i = j;
        localuw.wNm = paramInt2;
        i = j;
        localuw.wNn = paramInt3;
        i = j;
        localuw.wNo = n.getNumCores();
        i = j;
        localuw.wNp = bo.getInt(m.Lr(), 0);
        i = j;
        localuw.wNq = m.Lo();
        i = j;
        localuw.wNr = Build.MANUFACTURER;
        i = j;
        localuw.wNs = Build.MODEL;
        i = j;
        localuw.wNt = Build.VERSION.RELEASE;
        i = j;
        localuw.wNu = Build.VERSION.INCREMENTAL;
        i = j;
        localuw.wNv = Build.DISPLAY;
        i = j;
        paramString1 = q.bP(false);
        if (paramString1 == null) {
          continue;
        }
        i = j;
        if (paramString1.isEmpty()) {
          continue;
        }
        i = j;
        localuw.wNw = b.bL(ag.cE(paramString1).getBytes());
        i = j;
        localuw.wNx = Build.VERSION.RELEASE;
        i = j;
        ab.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "envInfo:" + new String(localuw.toByteArray()) + ",length:" + localuw.toByteArray().length);
        i = j;
        paramInt1 = kKw.InitSDK(localuw.toByteArray(), localuw.toByteArray().length, paramIConfCallBack);
        i = paramInt1;
        ab.v("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "init ret:".concat(String.valueOf(paramInt1)));
      }
      catch (IOException paramString1)
      {
        ab.printErrStackTrace("MicroMsg.OpenVoice.OpenVoiceNativeEngine", paramString1, "envInfo exception", new Object[0]);
        paramInt1 = i;
        continue;
      }
      AppMethodBeat.o(145857);
      return paramInt1;
      i = j;
      ab.e("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "getDeviceId failed");
    }
  }
  
  public static int az(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(145860);
    int i = kKw.GetDecodeVideoData(paramArrayOfByte);
    AppMethodBeat.o(145860);
    return i;
  }
  
  public static v2conference bhq()
  {
    return kKw;
  }
  
  public static int bhr()
  {
    AppMethodBeat.i(135494);
    int i = kKw.UnInit();
    ab.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "unInit ret:".concat(String.valueOf(i)));
    AppMethodBeat.o(135494);
    return i;
  }
  
  public static int c(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(145859);
    paramInt1 = kKw.SendVideoData(paramArrayOfByte, paramArrayOfByte.length, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(145859);
    return paramInt1;
  }
  
  public static int e(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    AppMethodBeat.i(135495);
    paramInt1 = kKw.SetAppCmd(paramInt1, paramArrayOfByte, paramInt2);
    AppMethodBeat.o(135495);
    return paramInt1;
  }
  
  public static int n(long paramLong, int paramInt)
  {
    AppMethodBeat.i(145858);
    paramInt = kKw.JoinRoom(paramLong, paramInt, 4);
    ab.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "joinRoom ret:".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(145858);
    return paramInt;
  }
  
  public static int t(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(135490);
    paramInt1 = kKw.SendAudioData(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(135490);
    return paramInt1;
  }
  
  public static int tH(int paramInt)
  {
    AppMethodBeat.i(135492);
    paramInt = kKw.GetVoiceActivity(paramInt);
    AppMethodBeat.o(135492);
    return paramInt;
  }
  
  static int tI(int paramInt)
  {
    AppMethodBeat.i(135493);
    paramInt = kKw.ExitRoom(paramInt);
    ab.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "exitRoom ret:".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(135493);
    return paramInt;
  }
  
  public static void tJ(int paramInt)
  {
    AppMethodBeat.i(135496);
    kKw.OnNetworkChange(paramInt);
    AppMethodBeat.o(135496);
  }
  
  public static int videoHWProcess(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(145861);
    paramInt1 = kKw.videoHWProcess(paramArrayOfByte1, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfByte2);
    AppMethodBeat.o(145861);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.l
 * JD-Core Version:    0.7.0.1
 */
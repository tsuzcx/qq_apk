package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.Looper;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.mars.ilink.comm.PlatformComm;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.n;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.c;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.protobuf.adc;
import com.tencent.mm.protocal.protobuf.adg;
import com.tencent.mm.protocal.protobuf.epj;
import com.tencent.mm.protocal.protobuf.epk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.wxmm.IConfCallBack;
import com.tencent.wxmm.v2conference;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

class m
{
  private static boolean hasInit;
  private static final String[] tQf;
  private static v2conference tRm;
  
  static
  {
    AppMethodBeat.i(90838);
    tQf = new String[] { "ilink_network", "ilink_xlog", "confService" };
    hasInit = false;
    tRm = new v2conference();
    AppMethodBeat.o(90838);
  }
  
  public static int H(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(90827);
    paramInt1 = tRm.SendAudioData(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(90827);
    return paramInt1;
  }
  
  public static int IC(int paramInt)
  {
    AppMethodBeat.i(90831);
    paramInt = tRm.GetVoiceActivity(paramInt);
    AppMethodBeat.o(90831);
    return paramInt;
  }
  
  static int ID(int paramInt)
  {
    AppMethodBeat.i(90832);
    paramInt = tRm.ExitRoom(paramInt);
    Log.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "exitRoom ret:".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(90832);
    return paramInt;
  }
  
  public static void IE(int paramInt)
  {
    AppMethodBeat.i(90835);
    tRm.OnNetworkChange(paramInt, null);
    AppMethodBeat.o(90835);
  }
  
  public static int S(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(90828);
    paramInt = tRm.GetAudioData(paramArrayOfByte, paramInt);
    AppMethodBeat.o(90828);
    return paramInt;
  }
  
  public static int T(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(203473);
    paramInt = tRm.GetDecodeVideoData(paramArrayOfByte, paramInt);
    AppMethodBeat.o(203473);
    return paramInt;
  }
  
  public static int a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, IConfCallBack paramIConfCallBack)
  {
    AppMethodBeat.i(90824);
    Log.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "hy: init voip");
    Object localObject1 = MMApplicationContext.getContext();
    Log.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "prepareOpenVoiceEnv, hasInit " + hasInit);
    Object localObject2;
    int j;
    if (!hasInit)
    {
      hasInit = true;
      Log.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "hy: load so");
      localObject2 = tQf;
      j = localObject2.length;
      i = 0;
      for (;;)
      {
        if (i < j)
        {
          String str = localObject2[i];
          try
          {
            m.class.getClassLoader();
            j.KW(str);
            i += 1;
          }
          catch (Throwable localThrowable)
          {
            for (;;)
            {
              Log.w("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "tryLoadLibrary fail, error = " + localThrowable.getMessage());
            }
          }
        }
      }
      Log.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "load so end");
      if (Looper.getMainLooper() == Looper.myLooper())
      {
        PlatformComm.init((Context)localObject1, new Handler(Looper.getMainLooper()));
        Log.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "main thread exec PlatformComm.init");
      }
    }
    else
    {
      j = -1;
      i = j;
    }
    for (;;)
    {
      try
      {
        localObject1 = new adc();
        i = j;
        ((adc)localObject1).app_id = paramString1;
        i = j;
        ((adc)localObject1).SoY = paramString2;
        i = j;
        ((adc)localObject1).SoZ = paramString3;
        i = j;
        ((adc)localObject1).Spb = (com.tencent.mm.loader.j.b.aSC() + "/openvoice");
        i = j;
        ((adc)localObject1).Spc = 0;
        i = j;
        ((adc)localObject1).Spe = 1;
        i = j;
        ((adc)localObject1).Spf = c.cNs();
        i = j;
        ((adc)localObject1).Spg = paramInt1;
        i = j;
        ((adc)localObject1).Spj = paramInt2;
        i = j;
        ((adc)localObject1).Spk = paramInt3;
        i = j;
        ((adc)localObject1).Spl = 1;
        i = j;
        ((adc)localObject1).Spp = n.getNumCores();
        i = j;
        ((adc)localObject1).Spq = Util.getInt(com.tencent.mm.compatible.deviceinfo.m.auu(), 0);
        i = j;
        ((adc)localObject1).Spr = com.tencent.mm.compatible.deviceinfo.m.aus();
        i = j;
        ((adc)localObject1).Sps = Build.MANUFACTURER;
        i = j;
        ((adc)localObject1).Spt = Build.MODEL;
        i = j;
        ((adc)localObject1).Spu = Build.VERSION.RELEASE;
        i = j;
        ((adc)localObject1).Spv = Build.VERSION.INCREMENTAL;
        i = j;
        ((adc)localObject1).Spw = Build.DISPLAY;
        i = j;
        paramString1 = q.dR(false);
        if (paramString1 == null) {
          continue;
        }
        i = j;
        if (paramString1.isEmpty()) {
          continue;
        }
        i = j;
        ((adc)localObject1).Spx = com.tencent.mm.cd.b.cU(MD5Util.getMD5String(paramString1).getBytes());
        i = j;
        ((adc)localObject1).Spy = Build.VERSION.RELEASE;
        i = j;
        ((adc)localObject1).SpB = String.format("0x%x", new Object[] { Integer.valueOf(d.RAD) });
        i = j;
        Log.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "envInfo:" + new String(((adc)localObject1).toByteArray()) + ",length:" + ((adc)localObject1).toByteArray().length);
        i = j;
        paramInt1 = tRm.InitSDK(((adc)localObject1).toByteArray(), ((adc)localObject1).toByteArray().length, paramIConfCallBack);
        i = paramInt1;
        Log.v("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "init ret:".concat(String.valueOf(paramInt1)));
      }
      catch (IOException paramString1)
      {
        Log.printErrStackTrace("MicroMsg.OpenVoice.OpenVoiceNativeEngine", paramString1, "envInfo exception", new Object[0]);
        paramInt1 = i;
        continue;
      }
      AppMethodBeat.o(90824);
      return paramInt1;
      localObject2 = new ConditionVariable();
      h.ZvG.bd(new m.1((Context)localObject1, (ConditionVariable)localObject2));
      Log.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "condition block wait for open");
      ((ConditionVariable)localObject2).block(2000L);
      Log.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "condition block release...");
      break;
      i = j;
      Log.e("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "getDeviceId failed");
    }
  }
  
  public static int ast(String paramString)
  {
    AppMethodBeat.i(90825);
    int i = tRm.UpdateAuthKey(paramString.getBytes(), paramString.getBytes().length);
    AppMethodBeat.o(90825);
    return i;
  }
  
  public static void b(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(203479);
    v2conference localv2conference = tRm;
    int i;
    if (paramBoolean1)
    {
      i = 1;
      if (!paramBoolean2) {
        break label46;
      }
    }
    for (;;)
    {
      localv2conference.SwitchAV(i, j, paramInt);
      AppMethodBeat.o(203479);
      return;
      i = 0;
      break;
      label46:
      j = 0;
    }
  }
  
  public static int c(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(90829);
    paramInt1 = tRm.SendVideoData(paramArrayOfByte, paramArrayOfByte.length, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(90829);
    return paramInt1;
  }
  
  public static v2conference cNC()
  {
    return tRm;
  }
  
  public static int cND()
  {
    AppMethodBeat.i(90833);
    int i = tRm.UnInit();
    Log.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "unInit ret:".concat(String.valueOf(i)));
    AppMethodBeat.o(90833);
    return i;
  }
  
  public static int e(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    AppMethodBeat.i(90834);
    paramInt1 = tRm.SetAppCmd(paramInt1, paramArrayOfByte, paramInt2);
    AppMethodBeat.o(90834);
    return paramInt1;
  }
  
  public static int f(ArrayList<epk> paramArrayList1, ArrayList<epk> paramArrayList2)
  {
    AppMethodBeat.i(203489);
    if (paramArrayList1.size() == 0) {
      Log.e("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "videoMembers is null");
    }
    if (paramArrayList2.size() == 0) {
      Log.e("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "screenMembers is null");
    }
    epj localepj = new epj();
    paramArrayList1 = paramArrayList1.iterator();
    while (paramArrayList1.hasNext())
    {
      epk localepk = (epk)paramArrayList1.next();
      localepj.Crl.add(localepk);
    }
    paramArrayList1 = paramArrayList2.iterator();
    while (paramArrayList1.hasNext())
    {
      paramArrayList2 = (epk)paramArrayList1.next();
      localepj.Ush.add(paramArrayList2);
    }
    label206:
    for (;;)
    {
      try
      {
        Log.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "videoResParam:" + new String(localepj.toByteArray()) + ",length:" + localepj.toByteArray().length);
        int i = tRm.SubscribeVideo(localepj.toByteArray(), localepj.toByteArray().length);
        Log.printErrStackTrace("MicroMsg.OpenVoice.OpenVoiceNativeEngine", paramArrayList1, "SetVideoResolution exception", new Object[0]);
      }
      catch (IOException paramArrayList1)
      {
        try
        {
          Log.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "steve: subScribeVideoAndResList ret:".concat(String.valueOf(i)));
          AppMethodBeat.o(203489);
          return i;
        }
        catch (IOException paramArrayList1)
        {
          break label206;
        }
        paramArrayList1 = paramArrayList1;
        i = -1;
      }
    }
  }
  
  public static int q(long paramLong, int paramInt)
  {
    AppMethodBeat.i(90826);
    adg localadg = new adg();
    localadg.SoQ = paramLong;
    localadg.SpD = paramInt;
    localadg.SpF = 4;
    localadg.SpE = false;
    paramInt = -1;
    try
    {
      int i = tRm.JoinRoom(localadg.toByteArray(), localadg.toByteArray().length);
      paramInt = i;
      Log.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "join room ret:".concat(String.valueOf(i)));
      paramInt = i;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.printErrStackTrace("MicroMsg.OpenVoice.OpenVoiceNativeEngine", localIOException, "JoinRoom exception", new Object[0]);
      }
    }
    Log.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "joinRoom ret:".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(90826);
    return paramInt;
  }
  
  public static int videoHWProcess(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte2, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(203481);
    paramInt1 = tRm.videoHWProcess(paramArrayOfByte1, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfByte2, paramInt5, paramInt6);
    AppMethodBeat.o(203481);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.m
 * JD-Core Version:    0.7.0.1
 */
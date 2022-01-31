package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.compatible.e.n;
import com.tencent.mm.compatible.e.q;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.protocal.c.re;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.wxmm.IConfCallBack;
import com.tencent.wxmm.v2conference;
import java.io.IOException;

final class g
{
  private static v2conference iEX = new v2conference();
  
  public static int M(byte[] paramArrayOfByte, int paramInt)
  {
    return iEX.GetAudioData(paramArrayOfByte, paramInt);
  }
  
  public static int a(String paramString1, String paramString2, IConfCallBack paramIConfCallBack)
  {
    y.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "hy: init voip");
    re localre = new re();
    localre.app_id = paramString1;
    localre.sOT = paramString2;
    localre.sOU = (e.dOO + "/openvoice");
    localre.sOV = 0;
    localre.sOW = 1;
    localre.sOX = com.tencent.mm.plugin.cloudvoip.cloudvoice.b.b.aEk();
    localre.sOY = n.getNumCores();
    localre.sOZ = bk.getInt(m.yU(), 0);
    localre.sPa = m.yR();
    localre.sPb = Build.MANUFACTURER;
    localre.sPc = Build.MODEL;
    localre.sPd = Build.VERSION.RELEASE;
    localre.sPe = com.tencent.mm.bv.b.bk(ad.bB(q.getDeviceID(ae.getContext())).getBytes());
    localre.sPf = q.zp();
    int j = -1;
    int i = j;
    try
    {
      y.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "envInfo:" + new String(localre.toByteArray()) + ",length:" + localre.toByteArray().length);
      i = j;
      j = iEX.InitSDK(localre.toByteArray(), localre.toByteArray().length, paramIConfCallBack);
      i = j;
      y.v("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "init ret:" + j);
      return j;
    }
    catch (IOException paramString1)
    {
      y.printErrStackTrace("MicroMsg.OpenVoice.OpenVoiceNativeEngine", paramString1, "envInfo exception", new Object[0]);
    }
    return i;
  }
  
  public static int aEm()
  {
    int i = iEX.UnInit();
    y.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "unInit ret:" + i);
    return i;
  }
  
  public static int d(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    return iEX.SetAppCmd(paramInt1, paramArrayOfByte, paramInt2);
  }
  
  public static int da(long paramLong)
  {
    int i = iEX.JoinRoom(paramLong, 4);
    y.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "joinRoom ret:" + i);
    return i;
  }
  
  public static int p(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return iEX.SendAudioData(paramArrayOfByte, paramInt1, paramInt2);
  }
  
  public static int pq(int paramInt)
  {
    return iEX.GetVoiceActivity(paramInt);
  }
  
  static int pr(int paramInt)
  {
    paramInt = iEX.ExitRoom(paramInt);
    y.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "exitRoom ret:" + paramInt);
    return paramInt;
  }
  
  public static void ps(int paramInt)
  {
    iEX.OnNetworkChange(paramInt);
  }
  
  public static int zu(String paramString)
  {
    return iEX.UpdateAuthKey(paramString.getBytes(), paramString.getBytes().length);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.g
 * JD-Core Version:    0.7.0.1
 */
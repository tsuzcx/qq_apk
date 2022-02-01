package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.m;
import com.tencent.mm.compatible.deviceinfo.n;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.c;
import com.tencent.mm.protocal.protobuf.dkl;
import com.tencent.mm.protocal.protobuf.dkn;
import com.tencent.mm.protocal.protobuf.xy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.wxmm.IConfCallBack;
import com.tencent.wxmm.v2conference;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

class l
{
  private static final String[] nPv;
  private static v2conference nQx;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(90838);
    nPv = new String[] { "marsbridgenetwork", "marsbridgexlog", "confService" };
    Context localContext = aj.getContext();
    ad.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "hy: load so");
    String[] arrayOfString = nPv;
    int j = arrayOfString.length;
    while (i < j)
    {
      String str = arrayOfString[i];
      l.class.getClassLoader();
      j.pq(str);
      i += 1;
    }
    h.Iye.aO(new l.1(localContext));
    nQx = new v2conference();
    AppMethodBeat.o(90838);
  }
  
  public static int F(ArrayList<dkl> paramArrayList)
  {
    AppMethodBeat.i(184468);
    if (paramArrayList.size() == 0)
    {
      ad.e("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "steve: memberIdArr is null");
      AppMethodBeat.o(184468);
      return -1;
    }
    dkn localdkn = new dkn();
    localdkn.CZN = 320;
    LinkedList localLinkedList = new LinkedList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localLinkedList.add((dkl)paramArrayList.next());
    }
    localdkn.hom = localLinkedList;
    label169:
    for (;;)
    {
      try
      {
        ad.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "videoResParam:" + new String(localdkn.toByteArray()) + ",length:" + localdkn.toByteArray().length);
        int i = nQx.SetVideoResolution(localdkn.toByteArray(), localdkn.toByteArray().length);
        ad.printErrStackTrace("MicroMsg.OpenVoice.OpenVoiceNativeEngine", paramArrayList, "SetVideoResolution exception", new Object[0]);
      }
      catch (IOException paramArrayList)
      {
        try
        {
          ad.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "steve: subScribeVideoAndResList ret:".concat(String.valueOf(i)));
          AppMethodBeat.o(184468);
          return i;
        }
        catch (IOException paramArrayList)
        {
          break label169;
        }
        paramArrayList = paramArrayList;
        i = -1;
      }
    }
  }
  
  public static int R(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(90828);
    paramInt = nQx.GetAudioData(paramArrayOfByte, paramInt);
    AppMethodBeat.o(90828);
    return paramInt;
  }
  
  public static int RP(String paramString)
  {
    AppMethodBeat.i(90825);
    int i = nQx.UpdateAuthKey(paramString.getBytes(), paramString.getBytes().length);
    AppMethodBeat.o(90825);
    return i;
  }
  
  public static int a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, IConfCallBack paramIConfCallBack)
  {
    AppMethodBeat.i(90824);
    ad.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "hy: init voip");
    int j = -1;
    i = j;
    for (;;)
    {
      try
      {
        xy localxy = new xy();
        i = j;
        localxy.app_id = paramString1;
        i = j;
        localxy.CZE = paramString2;
        i = j;
        localxy.CZF = paramString3;
        i = j;
        localxy.CZG = (com.tencent.mm.loader.j.b.ahY() + "/openvoice");
        i = j;
        localxy.CZH = 0;
        i = j;
        localxy.CZI = 1;
        i = j;
        localxy.CZJ = c.bOb();
        i = j;
        localxy.CZK = paramInt1;
        i = j;
        localxy.CZO = paramInt2;
        i = j;
        localxy.CZP = paramInt3;
        i = j;
        localxy.CZR = n.WO();
        i = j;
        localxy.CZS = bt.getInt(m.WI(), 0);
        i = j;
        localxy.CZT = m.WG();
        i = j;
        localxy.CZU = Build.MANUFACTURER;
        i = j;
        localxy.CZV = Build.MODEL;
        i = j;
        localxy.CZW = Build.VERSION.RELEASE;
        i = j;
        localxy.CZX = Build.VERSION.INCREMENTAL;
        i = j;
        localxy.CZY = Build.DISPLAY;
        i = j;
        paramString1 = q.cG(false);
        if (paramString1 == null) {
          continue;
        }
        i = j;
        if (paramString1.isEmpty()) {
          continue;
        }
        i = j;
        localxy.CZZ = com.tencent.mm.bx.b.cd(ai.du(paramString1).getBytes());
        i = j;
        localxy.Daa = Build.VERSION.RELEASE;
        i = j;
        ad.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "envInfo:" + new String(localxy.toByteArray()) + ",length:" + localxy.toByteArray().length);
        i = j;
        paramInt1 = nQx.InitSDK(localxy.toByteArray(), localxy.toByteArray().length, paramIConfCallBack);
        i = paramInt1;
        ad.v("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "init ret:".concat(String.valueOf(paramInt1)));
      }
      catch (IOException paramString1)
      {
        ad.printErrStackTrace("MicroMsg.OpenVoice.OpenVoiceNativeEngine", paramString1, "envInfo exception", new Object[0]);
        paramInt1 = i;
        continue;
      }
      AppMethodBeat.o(90824);
      return paramInt1;
      i = j;
      ad.e("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "getDeviceId failed");
    }
  }
  
  public static int aO(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(90830);
    int i = nQx.GetDecodeVideoData(paramArrayOfByte);
    AppMethodBeat.o(90830);
    return i;
  }
  
  public static v2conference bOh()
  {
    return nQx;
  }
  
  public static int bOi()
  {
    AppMethodBeat.i(90833);
    int i = nQx.UnInit();
    ad.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "unInit ret:".concat(String.valueOf(i)));
    AppMethodBeat.o(90833);
    return i;
  }
  
  public static int c(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(90829);
    paramInt1 = nQx.SendVideoData(paramArrayOfByte, paramArrayOfByte.length, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(90829);
    return paramInt1;
  }
  
  public static int e(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    AppMethodBeat.i(90834);
    paramInt1 = nQx.SetAppCmd(paramInt1, paramArrayOfByte, paramInt2);
    AppMethodBeat.o(90834);
    return paramInt1;
  }
  
  public static void iV(boolean paramBoolean)
  {
    AppMethodBeat.i(90836);
    v2conference localv2conference = nQx;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      localv2conference.SwitchAV(1, i);
      AppMethodBeat.o(90836);
      return;
    }
  }
  
  public static int q(long paramLong, int paramInt)
  {
    AppMethodBeat.i(90826);
    paramInt = nQx.JoinRoom(paramLong, paramInt, 4);
    ad.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "joinRoom ret:".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(90826);
    return paramInt;
  }
  
  public static int videoHWProcess(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(90837);
    paramInt1 = nQx.videoHWProcess(paramArrayOfByte1, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfByte2);
    AppMethodBeat.o(90837);
    return paramInt1;
  }
  
  public static int w(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(90827);
    paramInt1 = nQx.SendAudioData(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(90827);
    return paramInt1;
  }
  
  public static int zA(int paramInt)
  {
    AppMethodBeat.i(90831);
    paramInt = nQx.GetVoiceActivity(paramInt);
    AppMethodBeat.o(90831);
    return paramInt;
  }
  
  static int zB(int paramInt)
  {
    AppMethodBeat.i(90832);
    paramInt = nQx.ExitRoom(paramInt);
    ad.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "exitRoom ret:".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(90832);
    return paramInt;
  }
  
  public static void zC(int paramInt)
  {
    AppMethodBeat.i(90835);
    nQx.OnNetworkChange(paramInt);
    AppMethodBeat.o(90835);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.l
 * JD-Core Version:    0.7.0.1
 */
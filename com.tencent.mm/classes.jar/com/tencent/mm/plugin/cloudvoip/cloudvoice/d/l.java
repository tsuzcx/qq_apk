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
import com.tencent.mm.protocal.protobuf.dqc;
import com.tencent.mm.protocal.protobuf.dqe;
import com.tencent.mm.protocal.protobuf.yt;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.wxmm.IConfCallBack;
import com.tencent.wxmm.v2conference;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

class l
{
  private static final String[] osz;
  private static v2conference otC;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(90838);
    osz = new String[] { "marsbridgenetwork", "marsbridgexlog", "confService" };
    Context localContext = ai.getContext();
    ac.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "hy: load so");
    String[] arrayOfString = osz;
    int j = arrayOfString.length;
    while (i < j)
    {
      String str = arrayOfString[i];
      l.class.getClassLoader();
      j.sC(str);
      i += 1;
    }
    h.JZN.aR(new l.1(localContext));
    otC = new v2conference();
    AppMethodBeat.o(90838);
  }
  
  public static int Ar(int paramInt)
  {
    AppMethodBeat.i(90831);
    paramInt = otC.GetVoiceActivity(paramInt);
    AppMethodBeat.o(90831);
    return paramInt;
  }
  
  static int As(int paramInt)
  {
    AppMethodBeat.i(90832);
    paramInt = otC.ExitRoom(paramInt);
    ac.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "exitRoom ret:".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(90832);
    return paramInt;
  }
  
  public static void At(int paramInt)
  {
    AppMethodBeat.i(90835);
    otC.OnNetworkChange(paramInt);
    AppMethodBeat.o(90835);
  }
  
  public static void I(boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 1;
    AppMethodBeat.i(200741);
    v2conference localv2conference = otC;
    int i;
    if (paramBoolean1)
    {
      i = 1;
      if (!paramBoolean2) {
        break label41;
      }
    }
    for (;;)
    {
      localv2conference.SwitchAV(i, j);
      AppMethodBeat.o(200741);
      return;
      i = 0;
      break;
      label41:
      j = 0;
    }
  }
  
  public static int K(ArrayList<dqc> paramArrayList)
  {
    AppMethodBeat.i(184468);
    if (paramArrayList.size() == 0)
    {
      ac.e("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "steve: memberIdArr is null");
      AppMethodBeat.o(184468);
      return -1;
    }
    dqe localdqe = new dqe();
    localdqe.EsK = 320;
    LinkedList localLinkedList = new LinkedList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localLinkedList.add((dqc)paramArrayList.next());
    }
    localdqe.hOP = localLinkedList;
    label169:
    for (;;)
    {
      try
      {
        ac.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "videoResParam:" + new String(localdqe.toByteArray()) + ",length:" + localdqe.toByteArray().length);
        int i = otC.SetVideoResolution(localdqe.toByteArray(), localdqe.toByteArray().length);
        ac.printErrStackTrace("MicroMsg.OpenVoice.OpenVoiceNativeEngine", paramArrayList, "SetVideoResolution exception", new Object[0]);
      }
      catch (IOException paramArrayList)
      {
        try
        {
          ac.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "steve: subScribeVideoAndResList ret:".concat(String.valueOf(i)));
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
  
  public static int P(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(90828);
    paramInt = otC.GetAudioData(paramArrayOfByte, paramInt);
    AppMethodBeat.o(90828);
    return paramInt;
  }
  
  public static int Wb(String paramString)
  {
    AppMethodBeat.i(90825);
    int i = otC.UpdateAuthKey(paramString.getBytes(), paramString.getBytes().length);
    AppMethodBeat.o(90825);
    return i;
  }
  
  public static int a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, IConfCallBack paramIConfCallBack)
  {
    AppMethodBeat.i(90824);
    ac.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "hy: init voip");
    int j = -1;
    i = j;
    for (;;)
    {
      try
      {
        yt localyt = new yt();
        i = j;
        localyt.app_id = paramString1;
        i = j;
        localyt.EsB = paramString2;
        i = j;
        localyt.EsC = paramString3;
        i = j;
        localyt.EsD = (com.tencent.mm.loader.j.b.aoY() + "/openvoice");
        i = j;
        localyt.EsE = 0;
        i = j;
        localyt.EsF = 1;
        i = j;
        localyt.EsG = c.bVn();
        i = j;
        localyt.EsH = paramInt1;
        i = j;
        localyt.EsL = paramInt2;
        i = j;
        localyt.EsM = paramInt3;
        i = j;
        localyt.EsO = n.getNumCores();
        i = j;
        localyt.EsP = bs.getInt(m.XG(), 0);
        i = j;
        localyt.EsQ = m.XE();
        i = j;
        localyt.EsR = Build.MANUFACTURER;
        i = j;
        localyt.EsS = Build.MODEL;
        i = j;
        localyt.EsT = Build.VERSION.RELEASE;
        i = j;
        localyt.EsU = Build.VERSION.INCREMENTAL;
        i = j;
        localyt.EsV = Build.DISPLAY;
        i = j;
        paramString1 = q.cF(false);
        if (paramString1 == null) {
          continue;
        }
        i = j;
        if (paramString1.isEmpty()) {
          continue;
        }
        i = j;
        localyt.EsW = com.tencent.mm.bw.b.cc(ah.dg(paramString1).getBytes());
        i = j;
        localyt.EsX = Build.VERSION.RELEASE;
        i = j;
        ac.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "envInfo:" + new String(localyt.toByteArray()) + ",length:" + localyt.toByteArray().length);
        i = j;
        paramInt1 = otC.InitSDK(localyt.toByteArray(), localyt.toByteArray().length, paramIConfCallBack);
        i = paramInt1;
        ac.v("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "init ret:".concat(String.valueOf(paramInt1)));
      }
      catch (IOException paramString1)
      {
        ac.printErrStackTrace("MicroMsg.OpenVoice.OpenVoiceNativeEngine", paramString1, "envInfo exception", new Object[0]);
        paramInt1 = i;
        continue;
      }
      AppMethodBeat.o(90824);
      return paramInt1;
      i = j;
      ac.e("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "getDeviceId failed");
    }
  }
  
  public static int aN(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(90830);
    int i = otC.GetDecodeVideoData(paramArrayOfByte);
    AppMethodBeat.o(90830);
    return i;
  }
  
  public static v2conference bVu()
  {
    return otC;
  }
  
  public static int bVv()
  {
    AppMethodBeat.i(90833);
    int i = otC.UnInit();
    ac.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "unInit ret:".concat(String.valueOf(i)));
    AppMethodBeat.o(90833);
    return i;
  }
  
  public static int c(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(90829);
    paramInt1 = otC.SendVideoData(paramArrayOfByte, paramArrayOfByte.length, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(90829);
    return paramInt1;
  }
  
  public static int e(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    AppMethodBeat.i(90834);
    paramInt1 = otC.SetAppCmd(paramInt1, paramArrayOfByte, paramInt2);
    AppMethodBeat.o(90834);
    return paramInt1;
  }
  
  public static int r(long paramLong, int paramInt)
  {
    AppMethodBeat.i(90826);
    paramInt = otC.JoinRoom(paramLong, paramInt, 4);
    ac.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "joinRoom ret:".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(90826);
    return paramInt;
  }
  
  public static int v(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(90827);
    paramInt1 = otC.SendAudioData(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(90827);
    return paramInt1;
  }
  
  public static int videoHWProcess(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(90837);
    paramInt1 = otC.videoHWProcess(paramArrayOfByte1, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfByte2);
    AppMethodBeat.o(90837);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.l
 * JD-Core Version:    0.7.0.1
 */
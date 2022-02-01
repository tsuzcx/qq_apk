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
import com.tencent.mm.protocal.protobuf.aas;
import com.tencent.mm.protocal.protobuf.dvt;
import com.tencent.mm.protocal.protobuf.dvv;
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
  private static final String[] oVV;
  private static v2conference oWY;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(90838);
    oVV = new String[] { "ilink_network", "ilink_xlog", "confService" };
    Context localContext = aj.getContext();
    ad.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "hy: load so");
    String[] arrayOfString = oVV;
    int j = arrayOfString.length;
    while (i < j)
    {
      String str = arrayOfString[i];
      l.class.getClassLoader();
      j.vr(str);
      i += 1;
    }
    h.LTJ.aQ(new l.1(localContext));
    oWY = new v2conference();
    AppMethodBeat.o(90838);
  }
  
  public static int Ba(int paramInt)
  {
    AppMethodBeat.i(90831);
    paramInt = oWY.GetVoiceActivity(paramInt);
    AppMethodBeat.o(90831);
    return paramInt;
  }
  
  static int Bb(int paramInt)
  {
    AppMethodBeat.i(90832);
    paramInt = oWY.ExitRoom(paramInt);
    ad.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "exitRoom ret:".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(90832);
    return paramInt;
  }
  
  public static void Bc(int paramInt)
  {
    AppMethodBeat.i(90835);
    oWY.OnNetworkChange(paramInt);
    AppMethodBeat.o(90835);
  }
  
  public static void J(boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 1;
    AppMethodBeat.i(190910);
    v2conference localv2conference = oWY;
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
      AppMethodBeat.o(190910);
      return;
      i = 0;
      break;
      label41:
      j = 0;
    }
  }
  
  public static int K(ArrayList<dvt> paramArrayList)
  {
    AppMethodBeat.i(184468);
    if (paramArrayList.size() == 0)
    {
      ad.e("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "steve: memberIdArr is null");
      AppMethodBeat.o(184468);
      return -1;
    }
    dvv localdvv = new dvv();
    localdvv.FZY = 320;
    LinkedList localLinkedList = new LinkedList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      localLinkedList.add((dvt)paramArrayList.next());
    }
    localdvv.iid = localLinkedList;
    label169:
    for (;;)
    {
      try
      {
        ad.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "videoResParam:" + new String(localdvv.toByteArray()) + ",length:" + localdvv.toByteArray().length);
        int i = oWY.SetVideoResolution(localdvv.toByteArray(), localdvv.toByteArray().length);
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
  
  public static int P(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(90828);
    paramInt = oWY.GetAudioData(paramArrayOfByte, paramInt);
    AppMethodBeat.o(90828);
    return paramInt;
  }
  
  public static int ZI(String paramString)
  {
    AppMethodBeat.i(90825);
    int i = oWY.UpdateAuthKey(paramString.getBytes(), paramString.getBytes().length);
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
        aas localaas = new aas();
        i = j;
        localaas.app_id = paramString1;
        i = j;
        localaas.FZN = paramString2;
        i = j;
        localaas.FZO = paramString3;
        i = j;
        localaas.FZQ = (com.tencent.mm.loader.j.b.arL() + "/openvoice");
        i = j;
        localaas.FZR = 0;
        i = j;
        localaas.FZT = 1;
        i = j;
        localaas.FZU = c.bZS();
        i = j;
        localaas.FZV = paramInt1;
        i = j;
        localaas.FZZ = paramInt2;
        i = j;
        localaas.Gaa = paramInt3;
        i = j;
        localaas.Gad = n.getNumCores();
        i = j;
        localaas.Gae = bt.getInt(m.aah(), 0);
        i = j;
        localaas.Gaf = m.aaf();
        i = j;
        localaas.Gag = Build.MANUFACTURER;
        i = j;
        localaas.Gah = Build.MODEL;
        i = j;
        localaas.Gai = Build.VERSION.RELEASE;
        i = j;
        localaas.Gaj = Build.VERSION.INCREMENTAL;
        i = j;
        localaas.Gak = Build.DISPLAY;
        i = j;
        paramString1 = q.cH(false);
        if (paramString1 == null) {
          continue;
        }
        i = j;
        if (paramString1.isEmpty()) {
          continue;
        }
        i = j;
        localaas.Gal = com.tencent.mm.bx.b.cj(ai.ee(paramString1).getBytes());
        i = j;
        localaas.Gam = Build.VERSION.RELEASE;
        i = j;
        ad.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "envInfo:" + new String(localaas.toByteArray()) + ",length:" + localaas.toByteArray().length);
        i = j;
        paramInt1 = oWY.InitSDK(localaas.toByteArray(), localaas.toByteArray().length, paramIConfCallBack);
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
  
  public static int aQ(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(90830);
    int i = oWY.GetDecodeVideoData(paramArrayOfByte);
    AppMethodBeat.o(90830);
    return i;
  }
  
  public static v2conference bZY()
  {
    return oWY;
  }
  
  public static int bZZ()
  {
    AppMethodBeat.i(90833);
    int i = oWY.UnInit();
    ad.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "unInit ret:".concat(String.valueOf(i)));
    AppMethodBeat.o(90833);
    return i;
  }
  
  public static int c(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(90829);
    paramInt1 = oWY.SendVideoData(paramArrayOfByte, paramArrayOfByte.length, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(90829);
    return paramInt1;
  }
  
  public static int e(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    AppMethodBeat.i(90834);
    paramInt1 = oWY.SetAppCmd(paramInt1, paramArrayOfByte, paramInt2);
    AppMethodBeat.o(90834);
    return paramInt1;
  }
  
  public static int r(long paramLong, int paramInt)
  {
    AppMethodBeat.i(90826);
    paramInt = oWY.JoinRoom(paramLong, paramInt, 4);
    ad.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "joinRoom ret:".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(90826);
    return paramInt;
  }
  
  public static int v(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(90827);
    paramInt1 = oWY.SendAudioData(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(90827);
    return paramInt1;
  }
  
  public static int videoHWProcess(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte2)
  {
    AppMethodBeat.i(90837);
    paramInt1 = oWY.videoHWProcess(paramArrayOfByte1, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfByte2);
    AppMethodBeat.o(90837);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.l
 * JD-Core Version:    0.7.0.1
 */
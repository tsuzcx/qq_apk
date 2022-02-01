package com.tencent.mm.plugin.cloudvoip.cloudvoice.d;

import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.n;
import com.tencent.mm.compatible.deviceinfo.q;
import com.tencent.mm.compatible.util.j;
import com.tencent.mm.plugin.cloudvoip.cloudvoice.c.c;
import com.tencent.mm.protocal.protobuf.acu;
import com.tencent.mm.protocal.protobuf.acy;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.wxmm.IConfCallBack;
import com.tencent.wxmm.v2conference;
import java.io.IOException;

public class m
{
  private static final String[] qrx;
  private static v2conference qsB;
  
  static
  {
    AppMethodBeat.i(90838);
    qrx = new String[] { "ilink_network", "ilink_xlog", "confService" };
    MMApplicationContext.getContext();
    Log.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "hy: load so");
    String[] arrayOfString = qrx;
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        String str = arrayOfString[i];
        try
        {
          m.class.getClassLoader();
          j.Ed(str);
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
    h.RTc.aW(new m.1());
    qsB = new v2conference();
    AppMethodBeat.o(90838);
  }
  
  public static int EU(int paramInt)
  {
    AppMethodBeat.i(90831);
    paramInt = qsB.GetVoiceActivity(paramInt);
    AppMethodBeat.o(90831);
    return paramInt;
  }
  
  static int EV(int paramInt)
  {
    AppMethodBeat.i(90832);
    paramInt = qsB.ExitRoom(paramInt);
    Log.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "exitRoom ret:".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(90832);
    return paramInt;
  }
  
  public static void EW(int paramInt)
  {
    AppMethodBeat.i(90835);
    qsB.OnNetworkChange(paramInt, null);
    AppMethodBeat.o(90835);
  }
  
  public static int F(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(90827);
    paramInt1 = qsB.SendAudioData(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(90827);
    return paramInt1;
  }
  
  /* Error */
  public static int R(java.util.ArrayList<com.tencent.mm.protocal.protobuf.efj> paramArrayList)
  {
    // Byte code:
    //   0: ldc 143
    //   2: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokevirtual 149	java/util/ArrayList:size	()I
    //   9: ifne +17 -> 26
    //   12: ldc 37
    //   14: ldc 151
    //   16: invokestatic 154	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: ldc 143
    //   21: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: iconst_m1
    //   25: ireturn
    //   26: new 156	com/tencent/mm/protocal/protobuf/efi
    //   29: dup
    //   30: invokespecial 157	com/tencent/mm/protocal/protobuf/efi:<init>	()V
    //   33: astore_2
    //   34: new 159	java/util/LinkedList
    //   37: dup
    //   38: invokespecial 160	java/util/LinkedList:<init>	()V
    //   41: astore_3
    //   42: aload_0
    //   43: invokevirtual 164	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   46: astore_0
    //   47: aload_0
    //   48: invokeinterface 170 1 0
    //   53: ifeq +20 -> 73
    //   56: aload_3
    //   57: aload_0
    //   58: invokeinterface 174 1 0
    //   63: checkcast 176	com/tencent/mm/protocal/protobuf/efj
    //   66: invokevirtual 180	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   69: pop
    //   70: goto -23 -> 47
    //   73: aload_2
    //   74: aload_3
    //   75: putfield 184	com/tencent/mm/protocal/protobuf/efi:xuS	Ljava/util/LinkedList;
    //   78: ldc 37
    //   80: new 58	java/lang/StringBuilder
    //   83: dup
    //   84: ldc 186
    //   86: invokespecial 63	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   89: new 21	java/lang/String
    //   92: dup
    //   93: aload_2
    //   94: invokevirtual 190	com/tencent/mm/protocal/protobuf/efi:toByteArray	()[B
    //   97: invokespecial 193	java/lang/String:<init>	([B)V
    //   100: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: ldc 195
    //   105: invokevirtual 71	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: aload_2
    //   109: invokevirtual 190	com/tencent/mm/protocal/protobuf/efi:toByteArray	()[B
    //   112: arraylength
    //   113: invokevirtual 198	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   116: invokevirtual 74	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokestatic 44	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   122: getstatic 100	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/m:qsB	Lcom/tencent/wxmm/v2conference;
    //   125: aload_2
    //   126: invokevirtual 190	com/tencent/mm/protocal/protobuf/efi:toByteArray	()[B
    //   129: aload_2
    //   130: invokevirtual 190	com/tencent/mm/protocal/protobuf/efi:toByteArray	()[B
    //   133: arraylength
    //   134: invokevirtual 202	com/tencent/wxmm/v2conference:SubscribeVideo	([BI)I
    //   137: istore_1
    //   138: ldc 37
    //   140: ldc 204
    //   142: iload_1
    //   143: invokestatic 122	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   146: invokevirtual 126	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   149: invokestatic 44	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   152: ldc 143
    //   154: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   157: iload_1
    //   158: ireturn
    //   159: astore_0
    //   160: iconst_m1
    //   161: istore_1
    //   162: ldc 37
    //   164: aload_0
    //   165: ldc 206
    //   167: iconst_0
    //   168: anewarray 4	java/lang/Object
    //   171: invokestatic 210	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   174: goto -22 -> 152
    //   177: astore_0
    //   178: goto -16 -> 162
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	paramArrayList	java.util.ArrayList<com.tencent.mm.protocal.protobuf.efj>
    //   137	25	1	i	int
    //   33	97	2	localefi	com.tencent.mm.protocal.protobuf.efi
    //   41	34	3	localLinkedList	java.util.LinkedList
    // Exception table:
    //   from	to	target	type
    //   78	138	159	java/io/IOException
    //   138	152	177	java/io/IOException
  }
  
  public static int R(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(90828);
    paramInt = qsB.GetAudioData(paramArrayOfByte, paramInt);
    AppMethodBeat.o(90828);
    return paramInt;
  }
  
  public static int a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, IConfCallBack paramIConfCallBack)
  {
    AppMethodBeat.i(90824);
    Log.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "hy: init voip");
    int j = -1;
    i = j;
    for (;;)
    {
      try
      {
        acu localacu = new acu();
        i = j;
        localacu.app_id = paramString1;
        i = j;
        localacu.LnD = paramString2;
        i = j;
        localacu.LnE = paramString3;
        i = j;
        localacu.LnG = (com.tencent.mm.loader.j.b.aKA() + "/openvoice");
        i = j;
        localacu.LnH = 0;
        i = j;
        localacu.LnJ = 1;
        i = j;
        localacu.LnK = c.cyW();
        i = j;
        localacu.LnL = paramInt1;
        i = j;
        localacu.LnO = paramInt2;
        i = j;
        localacu.LnP = paramInt3;
        i = j;
        localacu.LnQ = 1;
        i = j;
        localacu.LnS = n.getNumCores();
        i = j;
        localacu.LnT = Util.getInt(com.tencent.mm.compatible.deviceinfo.m.aop(), 0);
        i = j;
        localacu.LnU = com.tencent.mm.compatible.deviceinfo.m.aon();
        i = j;
        localacu.LnV = Build.MANUFACTURER;
        i = j;
        localacu.LnW = Build.MODEL;
        i = j;
        localacu.LnX = Build.VERSION.RELEASE;
        i = j;
        localacu.LnY = Build.VERSION.INCREMENTAL;
        i = j;
        localacu.LnZ = Build.DISPLAY;
        i = j;
        paramString1 = q.dr(false);
        if (paramString1 == null) {
          continue;
        }
        i = j;
        if (paramString1.isEmpty()) {
          continue;
        }
        i = j;
        localacu.Loa = com.tencent.mm.bw.b.cD(MD5Util.getMD5String(paramString1).getBytes());
        i = j;
        localacu.Lob = Build.VERSION.RELEASE;
        i = j;
        Log.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "envInfo:" + new String(localacu.toByteArray()) + ",length:" + localacu.toByteArray().length);
        i = j;
        paramInt1 = qsB.InitSDK(localacu.toByteArray(), localacu.toByteArray().length, paramIConfCallBack);
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
      i = j;
      Log.e("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "getDeviceId failed");
    }
  }
  
  public static int akF(String paramString)
  {
    AppMethodBeat.i(90825);
    int i = qsB.UpdateAuthKey(paramString.getBytes(), paramString.getBytes().length);
    AppMethodBeat.o(90825);
    return i;
  }
  
  public static void b(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(186731);
    v2conference localv2conference = qsB;
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
      AppMethodBeat.o(186731);
      return;
      i = 0;
      break;
      label46:
      j = 0;
    }
  }
  
  public static int bg(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(186730);
    int i = qsB.GetDecodeVideoData(paramArrayOfByte, 0);
    AppMethodBeat.o(186730);
    return i;
  }
  
  public static int c(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(90829);
    paramInt1 = qsB.SendVideoData(paramArrayOfByte, paramArrayOfByte.length, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(90829);
    return paramInt1;
  }
  
  public static void czc()
  {
    AppMethodBeat.i(186729);
    Log.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "preloadInit");
    AppMethodBeat.o(186729);
  }
  
  public static v2conference czd()
  {
    return qsB;
  }
  
  public static int cze()
  {
    AppMethodBeat.i(90833);
    int i = qsB.UnInit();
    Log.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "unInit ret:".concat(String.valueOf(i)));
    AppMethodBeat.o(90833);
    return i;
  }
  
  public static int e(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    AppMethodBeat.i(90834);
    paramInt1 = qsB.SetAppCmd(paramInt1, paramArrayOfByte, paramInt2);
    AppMethodBeat.o(90834);
    return paramInt1;
  }
  
  public static int o(long paramLong, int paramInt)
  {
    AppMethodBeat.i(90826);
    acy localacy = new acy();
    localacy.Lnv = paramLong;
    localacy.Lof = paramInt;
    localacy.Loh = 4;
    localacy.Log = false;
    paramInt = -1;
    try
    {
      int i = qsB.JoinRoom(localacy.toByteArray(), localacy.toByteArray().length);
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
    AppMethodBeat.i(186732);
    paramInt1 = qsB.videoHWProcess(paramArrayOfByte1, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfByte2, paramInt5, paramInt6);
    AppMethodBeat.o(186732);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.m
 * JD-Core Version:    0.7.0.1
 */
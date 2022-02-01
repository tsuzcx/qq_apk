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
import com.tencent.mm.protocal.protobuf.aaw;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.wxmm.IConfCallBack;
import com.tencent.wxmm.v2conference;
import java.io.IOException;

class l
{
  private static final String[] pcy;
  private static v2conference pdB;
  
  static
  {
    int i = 0;
    AppMethodBeat.i(90838);
    pcy = new String[] { "ilink_network", "ilink_xlog", "confService" };
    Context localContext = ak.getContext();
    ae.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "hy: load so");
    String[] arrayOfString = pcy;
    int j = arrayOfString.length;
    while (i < j)
    {
      String str = arrayOfString[i];
      l.class.getClassLoader();
      j.vN(str);
      i += 1;
    }
    h.MqF.aN(new l.1(localContext));
    pdB = new v2conference();
    AppMethodBeat.o(90838);
  }
  
  public static int Bm(int paramInt)
  {
    AppMethodBeat.i(90831);
    paramInt = pdB.GetVoiceActivity(paramInt);
    AppMethodBeat.o(90831);
    return paramInt;
  }
  
  static int Bn(int paramInt)
  {
    AppMethodBeat.i(90832);
    paramInt = pdB.ExitRoom(paramInt);
    ae.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "exitRoom ret:".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(90832);
    return paramInt;
  }
  
  public static void Bo(int paramInt)
  {
    AppMethodBeat.i(90835);
    pdB.OnNetworkChange(paramInt);
    AppMethodBeat.o(90835);
  }
  
  /* Error */
  public static int K(java.util.ArrayList<com.tencent.mm.protocal.protobuf.dlw> paramArrayList)
  {
    // Byte code:
    //   0: ldc 114
    //   2: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokevirtual 120	java/util/ArrayList:size	()I
    //   9: ifne +17 -> 26
    //   12: ldc 35
    //   14: ldc 122
    //   16: invokestatic 125	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   19: ldc 114
    //   21: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: iconst_m1
    //   25: ireturn
    //   26: new 127	com/tencent/mm/protocal/protobuf/dlv
    //   29: dup
    //   30: invokespecial 128	com/tencent/mm/protocal/protobuf/dlv:<init>	()V
    //   33: astore_2
    //   34: new 130	java/util/LinkedList
    //   37: dup
    //   38: invokespecial 131	java/util/LinkedList:<init>	()V
    //   41: astore_3
    //   42: aload_0
    //   43: invokevirtual 135	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   46: astore_0
    //   47: aload_0
    //   48: invokeinterface 141 1 0
    //   53: ifeq +20 -> 73
    //   56: aload_3
    //   57: aload_0
    //   58: invokeinterface 145 1 0
    //   63: checkcast 147	com/tencent/mm/protocal/protobuf/dlw
    //   66: invokevirtual 151	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   69: pop
    //   70: goto -23 -> 47
    //   73: aload_2
    //   74: aload_3
    //   75: putfield 155	com/tencent/mm/protocal/protobuf/dlv:udf	Ljava/util/LinkedList;
    //   78: ldc 35
    //   80: new 157	java/lang/StringBuilder
    //   83: dup
    //   84: ldc 159
    //   86: invokespecial 161	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   89: new 19	java/lang/String
    //   92: dup
    //   93: aload_2
    //   94: invokevirtual 165	com/tencent/mm/protocal/protobuf/dlv:toByteArray	()[B
    //   97: invokespecial 168	java/lang/String:<init>	([B)V
    //   100: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: ldc 174
    //   105: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: aload_2
    //   109: invokevirtual 165	com/tencent/mm/protocal/protobuf/dlv:toByteArray	()[B
    //   112: arraylength
    //   113: invokevirtual 177	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   116: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   119: invokestatic 42	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   122: getstatic 78	com/tencent/mm/plugin/cloudvoip/cloudvoice/d/l:pdB	Lcom/tencent/wxmm/v2conference;
    //   125: aload_2
    //   126: invokevirtual 165	com/tencent/mm/protocal/protobuf/dlv:toByteArray	()[B
    //   129: aload_2
    //   130: invokevirtual 165	com/tencent/mm/protocal/protobuf/dlv:toByteArray	()[B
    //   133: arraylength
    //   134: invokevirtual 185	com/tencent/wxmm/v2conference:SubscribeVideo	([BI)I
    //   137: istore_1
    //   138: ldc 35
    //   140: ldc 187
    //   142: iload_1
    //   143: invokestatic 100	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   146: invokevirtual 104	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   149: invokestatic 42	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   152: ldc 114
    //   154: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   157: iload_1
    //   158: ireturn
    //   159: astore_0
    //   160: iconst_m1
    //   161: istore_1
    //   162: ldc 35
    //   164: aload_0
    //   165: ldc 189
    //   167: iconst_0
    //   168: anewarray 4	java/lang/Object
    //   171: invokestatic 193	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   174: goto -22 -> 152
    //   177: astore_0
    //   178: goto -16 -> 162
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	paramArrayList	java.util.ArrayList<com.tencent.mm.protocal.protobuf.dlw>
    //   137	25	1	i	int
    //   33	97	2	localdlv	com.tencent.mm.protocal.protobuf.dlv
    //   41	34	3	localLinkedList	java.util.LinkedList
    // Exception table:
    //   from	to	target	type
    //   78	138	159	java/io/IOException
    //   138	152	177	java/io/IOException
  }
  
  public static int P(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(90828);
    paramInt = pdB.GetAudioData(paramArrayOfByte, paramInt);
    AppMethodBeat.o(90828);
    return paramInt;
  }
  
  public static int a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, IConfCallBack paramIConfCallBack)
  {
    AppMethodBeat.i(90824);
    ae.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "hy: init voip");
    int j = -1;
    i = j;
    for (;;)
    {
      try
      {
        aaw localaaw = new aaw();
        i = j;
        localaaw.app_id = paramString1;
        i = j;
        localaaw.Gsn = paramString2;
        i = j;
        localaaw.Gso = paramString3;
        i = j;
        localaaw.Gsq = (com.tencent.mm.loader.j.b.asa() + "/openvoice");
        i = j;
        localaaw.Gsr = 0;
        i = j;
        localaaw.Gst = 1;
        i = j;
        localaaw.Gsu = c.cbh();
        i = j;
        localaaw.Gsv = paramInt1;
        i = j;
        localaaw.Gsz = paramInt2;
        i = j;
        localaaw.GsA = paramInt3;
        i = j;
        localaaw.GsD = n.getNumCores();
        i = j;
        localaaw.GsE = bu.getInt(m.aaq(), 0);
        i = j;
        localaaw.GsF = m.aao();
        i = j;
        localaaw.GsG = Build.MANUFACTURER;
        i = j;
        localaaw.GsH = Build.MODEL;
        i = j;
        localaaw.GsI = Build.VERSION.RELEASE;
        i = j;
        localaaw.GsJ = Build.VERSION.INCREMENTAL;
        i = j;
        localaaw.GsK = Build.DISPLAY;
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
        localaaw.GsL = com.tencent.mm.bw.b.cm(aj.ej(paramString1).getBytes());
        i = j;
        localaaw.GsM = Build.VERSION.RELEASE;
        i = j;
        ae.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "envInfo:" + new String(localaaw.toByteArray()) + ",length:" + localaaw.toByteArray().length);
        i = j;
        paramInt1 = pdB.InitSDK(localaaw.toByteArray(), localaaw.toByteArray().length, paramIConfCallBack);
        i = paramInt1;
        ae.v("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "init ret:".concat(String.valueOf(paramInt1)));
      }
      catch (IOException paramString1)
      {
        ae.printErrStackTrace("MicroMsg.OpenVoice.OpenVoiceNativeEngine", paramString1, "envInfo exception", new Object[0]);
        paramInt1 = i;
        continue;
      }
      AppMethodBeat.o(90824);
      return paramInt1;
      i = j;
      ae.e("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "getDeviceId failed");
    }
  }
  
  public static int aP(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(211563);
    int i = pdB.GetDecodeVideoData(paramArrayOfByte, 0);
    AppMethodBeat.o(211563);
    return i;
  }
  
  public static int aaz(String paramString)
  {
    AppMethodBeat.i(90825);
    int i = pdB.UpdateAuthKey(paramString.getBytes(), paramString.getBytes().length);
    AppMethodBeat.o(90825);
    return i;
  }
  
  public static int c(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(90829);
    paramInt1 = pdB.SendVideoData(paramArrayOfByte, paramArrayOfByte.length, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(90829);
    return paramInt1;
  }
  
  public static void c(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(211564);
    v2conference localv2conference = pdB;
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
      AppMethodBeat.o(211564);
      return;
      i = 0;
      break;
      label46:
      j = 0;
    }
  }
  
  public static v2conference cbn()
  {
    return pdB;
  }
  
  public static int cbo()
  {
    AppMethodBeat.i(90833);
    int i = pdB.UnInit();
    ae.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "unInit ret:".concat(String.valueOf(i)));
    AppMethodBeat.o(90833);
    return i;
  }
  
  public static int e(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    AppMethodBeat.i(90834);
    paramInt1 = pdB.SetAppCmd(paramInt1, paramArrayOfByte, paramInt2);
    AppMethodBeat.o(90834);
    return paramInt1;
  }
  
  public static int r(long paramLong, int paramInt)
  {
    AppMethodBeat.i(90826);
    paramInt = pdB.JoinRoom(paramLong, paramInt, 4);
    ae.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "joinRoom ret:".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(90826);
    return paramInt;
  }
  
  public static int v(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(90827);
    paramInt1 = pdB.SendAudioData(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(90827);
    return paramInt1;
  }
  
  public static int videoHWProcess(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte2, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(211565);
    paramInt1 = pdB.videoHWProcess(paramArrayOfByte1, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfByte2, paramInt5, paramInt6);
    AppMethodBeat.o(211565);
    return paramInt1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.d.l
 * JD-Core Version:    0.7.0.1
 */
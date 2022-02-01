package com.tencent.mm.plugin.cloudvoip.cloudvoice.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.afo;
import com.tencent.mm.protocal.protobuf.fki;
import com.tencent.mm.protocal.protobuf.fkj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.wxmm.v2conference;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

class m
{
  private static boolean hasInit;
  private static final String[] wTv;
  private static v2conference wUC;
  
  static
  {
    AppMethodBeat.i(90838);
    wTv = new String[] { "ilink_network", "ilink_xlog", "confService" };
    hasInit = false;
    wUC = new v2conference();
    AppMethodBeat.o(90838);
  }
  
  public static int F(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(90827);
    paramInt1 = wUC.SendAudioData(paramArrayOfByte, paramInt1, paramInt2);
    AppMethodBeat.o(90827);
    return paramInt1;
  }
  
  public static int Jf(int paramInt)
  {
    AppMethodBeat.i(90831);
    paramInt = wUC.GetVoiceActivity(paramInt);
    AppMethodBeat.o(90831);
    return paramInt;
  }
  
  static int Jg(int paramInt)
  {
    AppMethodBeat.i(90832);
    paramInt = wUC.ExitRoom(paramInt);
    Log.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "exitRoom ret:".concat(String.valueOf(paramInt)));
    AppMethodBeat.o(90832);
    return paramInt;
  }
  
  public static void Jh(int paramInt)
  {
    AppMethodBeat.i(90835);
    wUC.OnNetworkChange(paramInt, null);
    AppMethodBeat.o(90835);
  }
  
  public static int Q(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(90828);
    paramInt = wUC.GetAudioData(paramArrayOfByte, paramInt);
    AppMethodBeat.o(90828);
    return paramInt;
  }
  
  public static int R(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(268317);
    paramInt = wUC.GetDecodeVideoData(paramArrayOfByte, paramInt);
    AppMethodBeat.o(268317);
    return paramInt;
  }
  
  /* Error */
  public static int a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, int paramInt3, com.tencent.wxmm.IConfCallBack paramIConfCallBack)
  {
    // Byte code:
    //   0: ldc 99
    //   2: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 62
    //   7: ldc 101
    //   9: invokestatic 77	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   12: invokestatic 107	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   15: astore 9
    //   17: ldc 62
    //   19: new 109	java/lang/StringBuilder
    //   22: dup
    //   23: ldc 111
    //   25: invokespecial 114	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   28: getstatic 31	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/m:hasInit	Z
    //   31: invokevirtual 118	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   34: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 77	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: getstatic 31	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/m:hasInit	Z
    //   43: ifne +129 -> 172
    //   46: iconst_1
    //   47: putstatic 31	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/m:hasInit	Z
    //   50: ldc 62
    //   52: ldc 124
    //   54: invokestatic 77	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: getstatic 29	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/m:wTv	[Ljava/lang/String;
    //   60: astore 10
    //   62: aload 10
    //   64: arraylength
    //   65: istore 8
    //   67: iconst_0
    //   68: istore 7
    //   70: iload 7
    //   72: iload 8
    //   74: if_icmpge +60 -> 134
    //   77: aload 10
    //   79: iload 7
    //   81: aaload
    //   82: astore 11
    //   84: ldc 2
    //   86: invokevirtual 130	java/lang/Class:getClassLoader	()Ljava/lang/ClassLoader;
    //   89: pop
    //   90: aload 11
    //   92: invokestatic 135	com/tencent/mm/compatible/util/k:DA	(Ljava/lang/String;)V
    //   95: iload 7
    //   97: iconst_1
    //   98: iadd
    //   99: istore 7
    //   101: goto -31 -> 70
    //   104: astore 11
    //   106: ldc 62
    //   108: new 109	java/lang/StringBuilder
    //   111: dup
    //   112: ldc 137
    //   114: invokespecial 114	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   117: aload 11
    //   119: invokevirtual 142	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   122: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   128: invokestatic 148	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   131: goto -36 -> 95
    //   134: ldc 62
    //   136: ldc 150
    //   138: invokestatic 77	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   141: invokestatic 156	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   144: invokestatic 159	android/os/Looper:myLooper	()Landroid/os/Looper;
    //   147: if_acmpne +473 -> 620
    //   150: aload 9
    //   152: new 161	android/os/Handler
    //   155: dup
    //   156: invokestatic 156	android/os/Looper:getMainLooper	()Landroid/os/Looper;
    //   159: invokespecial 164	android/os/Handler:<init>	(Landroid/os/Looper;)V
    //   162: invokestatic 170	com/tencent/mars/ilink/comm/PlatformComm:init	(Landroid/content/Context;Landroid/os/Handler;)V
    //   165: ldc 62
    //   167: ldc 172
    //   169: invokestatic 77	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   172: iconst_m1
    //   173: istore 8
    //   175: iload 8
    //   177: istore 7
    //   179: new 174	com/tencent/mm/protocal/protobuf/afk
    //   182: dup
    //   183: invokespecial 175	com/tencent/mm/protocal/protobuf/afk:<init>	()V
    //   186: astore 9
    //   188: iload 8
    //   190: istore 7
    //   192: aload 9
    //   194: aload_0
    //   195: putfield 179	com/tencent/mm/protocal/protobuf/afk:app_id	Ljava/lang/String;
    //   198: iload 8
    //   200: istore 7
    //   202: aload 9
    //   204: aload_1
    //   205: putfield 182	com/tencent/mm/protocal/protobuf/afk:Zos	Ljava/lang/String;
    //   208: iload 8
    //   210: istore 7
    //   212: aload 9
    //   214: aload_2
    //   215: putfield 185	com/tencent/mm/protocal/protobuf/afk:ZnQ	Ljava/lang/String;
    //   218: iload 8
    //   220: istore 7
    //   222: aload 9
    //   224: new 109	java/lang/StringBuilder
    //   227: dup
    //   228: invokespecial 186	java/lang/StringBuilder:<init>	()V
    //   231: invokestatic 191	com/tencent/mm/loader/i/b:bmq	()Ljava/lang/String;
    //   234: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   237: ldc 193
    //   239: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   245: putfield 196	com/tencent/mm/protocal/protobuf/afk:ZnS	Ljava/lang/String;
    //   248: iload 8
    //   250: istore 7
    //   252: getstatic 202	com/tencent/mm/util/i:agtt	Lcom/tencent/mm/util/i;
    //   255: astore_0
    //   256: iload 8
    //   258: istore 7
    //   260: aload 9
    //   262: getstatic 208	com/tencent/mm/util/b$a:agsT	Lcom/tencent/mm/util/b$a;
    //   265: iconst_0
    //   266: invokestatic 211	com/tencent/mm/util/i:a	(Lcom/tencent/mm/util/b$a;I)I
    //   269: putfield 215	com/tencent/mm/protocal/protobuf/afk:ZnT	I
    //   272: iload 8
    //   274: istore 7
    //   276: aload 9
    //   278: iconst_1
    //   279: putfield 218	com/tencent/mm/protocal/protobuf/afk:ZnV	I
    //   282: iload 8
    //   284: istore 7
    //   286: aload 9
    //   288: invokestatic 224	com/tencent/mm/plugin/cloudvoip/cloudvoice/c/c:dqY	()I
    //   291: putfield 227	com/tencent/mm/protocal/protobuf/afk:ZnW	I
    //   294: iload 8
    //   296: istore 7
    //   298: aload 9
    //   300: iload_3
    //   301: putfield 230	com/tencent/mm/protocal/protobuf/afk:ZnX	I
    //   304: iload 8
    //   306: istore 7
    //   308: aload 9
    //   310: iload 4
    //   312: putfield 233	com/tencent/mm/protocal/protobuf/afk:Zou	I
    //   315: iload 8
    //   317: istore 7
    //   319: aload 9
    //   321: iload 5
    //   323: putfield 236	com/tencent/mm/protocal/protobuf/afk:Zov	I
    //   326: iload 8
    //   328: istore 7
    //   330: aload 9
    //   332: iconst_1
    //   333: putfield 239	com/tencent/mm/protocal/protobuf/afk:Zoa	I
    //   336: iload 8
    //   338: istore 7
    //   340: aload 9
    //   342: invokestatic 244	com/tencent/mm/compatible/deviceinfo/n:getNumCores	()I
    //   345: putfield 247	com/tencent/mm/protocal/protobuf/afk:Zoe	I
    //   348: iload 8
    //   350: istore 7
    //   352: aload 9
    //   354: invokestatic 252	com/tencent/mm/compatible/deviceinfo/m:aON	()Ljava/lang/String;
    //   357: iconst_0
    //   358: invokestatic 258	com/tencent/mm/sdk/platformtools/Util:getInt	(Ljava/lang/String;I)I
    //   361: putfield 261	com/tencent/mm/protocal/protobuf/afk:Zof	I
    //   364: iload 8
    //   366: istore 7
    //   368: aload 9
    //   370: invokestatic 264	com/tencent/mm/compatible/deviceinfo/m:aOK	()I
    //   373: putfield 267	com/tencent/mm/protocal/protobuf/afk:Zog	I
    //   376: iload 8
    //   378: istore 7
    //   380: aload 9
    //   382: getstatic 272	android/os/Build:MANUFACTURER	Ljava/lang/String;
    //   385: putfield 275	com/tencent/mm/protocal/protobuf/afk:Zoh	Ljava/lang/String;
    //   388: iload 8
    //   390: istore 7
    //   392: aload 9
    //   394: invokestatic 280	com/tencent/mm/compatible/deviceinfo/q:aPo	()Ljava/lang/String;
    //   397: putfield 283	com/tencent/mm/protocal/protobuf/afk:Zoi	Ljava/lang/String;
    //   400: iload 8
    //   402: istore 7
    //   404: aload 9
    //   406: getstatic 288	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   409: putfield 291	com/tencent/mm/protocal/protobuf/afk:Zoj	Ljava/lang/String;
    //   412: iload 8
    //   414: istore 7
    //   416: aload 9
    //   418: getstatic 294	android/os/Build$VERSION:INCREMENTAL	Ljava/lang/String;
    //   421: putfield 297	com/tencent/mm/protocal/protobuf/afk:Zok	Ljava/lang/String;
    //   424: iload 8
    //   426: istore 7
    //   428: aload 9
    //   430: getstatic 300	android/os/Build:DISPLAY	Ljava/lang/String;
    //   433: putfield 303	com/tencent/mm/protocal/protobuf/afk:Zol	Ljava/lang/String;
    //   436: iload 8
    //   438: istore 7
    //   440: iconst_0
    //   441: invokestatic 307	com/tencent/mm/compatible/deviceinfo/q:eD	(Z)Ljava/lang/String;
    //   444: astore_0
    //   445: aload_0
    //   446: ifnull +231 -> 677
    //   449: iload 8
    //   451: istore 7
    //   453: aload_0
    //   454: invokevirtual 311	java/lang/String:isEmpty	()Z
    //   457: ifne +220 -> 677
    //   460: iload 8
    //   462: istore 7
    //   464: aload 9
    //   466: aload_0
    //   467: invokestatic 316	com/tencent/mm/sdk/platformtools/MD5Util:getMD5String	(Ljava/lang/String;)Ljava/lang/String;
    //   470: invokevirtual 320	java/lang/String:getBytes	()[B
    //   473: invokestatic 326	com/tencent/mm/bx/b:cX	([B)Lcom/tencent/mm/bx/b;
    //   476: putfield 330	com/tencent/mm/protocal/protobuf/afk:Zom	Lcom/tencent/mm/bx/b;
    //   479: iload 8
    //   481: istore 7
    //   483: aload 9
    //   485: getstatic 288	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   488: putfield 333	com/tencent/mm/protocal/protobuf/afk:Zon	Ljava/lang/String;
    //   491: iload 8
    //   493: istore 7
    //   495: aload 9
    //   497: ldc_w 335
    //   500: iconst_1
    //   501: anewarray 4	java/lang/Object
    //   504: dup
    //   505: iconst_0
    //   506: getstatic 340	com/tencent/mm/protocal/d:Yxh	I
    //   509: invokestatic 345	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   512: aastore
    //   513: invokestatic 349	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   516: putfield 352	com/tencent/mm/protocal/protobuf/afk:Zoq	Ljava/lang/String;
    //   519: iload 8
    //   521: istore 7
    //   523: ldc 62
    //   525: new 109	java/lang/StringBuilder
    //   528: dup
    //   529: ldc_w 354
    //   532: invokespecial 114	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   535: new 21	java/lang/String
    //   538: dup
    //   539: aload 9
    //   541: invokevirtual 357	com/tencent/mm/protocal/protobuf/afk:toByteArray	()[B
    //   544: invokespecial 360	java/lang/String:<init>	([B)V
    //   547: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   550: ldc_w 362
    //   553: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   556: aload 9
    //   558: invokevirtual 357	com/tencent/mm/protocal/protobuf/afk:toByteArray	()[B
    //   561: arraylength
    //   562: invokevirtual 365	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   565: invokevirtual 122	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   568: invokestatic 77	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   571: iload 8
    //   573: istore 7
    //   575: getstatic 38	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/m:wUC	Lcom/tencent/wxmm/v2conference;
    //   578: aload 9
    //   580: invokevirtual 357	com/tencent/mm/protocal/protobuf/afk:toByteArray	()[B
    //   583: aload 9
    //   585: invokevirtual 357	com/tencent/mm/protocal/protobuf/afk:toByteArray	()[B
    //   588: arraylength
    //   589: aload 6
    //   591: invokevirtual 369	com/tencent/wxmm/v2conference:InitSDK	([BILcom/tencent/wxmm/IConfCallBack;)I
    //   594: istore_3
    //   595: iload_3
    //   596: istore 7
    //   598: ldc 62
    //   600: ldc_w 371
    //   603: iload_3
    //   604: invokestatic 68	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   607: invokevirtual 72	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   610: invokestatic 374	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   613: ldc 99
    //   615: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   618: iload_3
    //   619: ireturn
    //   620: new 376	android/os/ConditionVariable
    //   623: dup
    //   624: invokespecial 377	android/os/ConditionVariable:<init>	()V
    //   627: astore 10
    //   629: getstatic 383	com/tencent/threadpool/h:ahAA	Lcom/tencent/threadpool/i;
    //   632: new 385	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/m$1
    //   635: dup
    //   636: aload 9
    //   638: aload 10
    //   640: invokespecial 388	com/tencent/mm/plugin/cloudvoip/cloudvoice/service/m$1:<init>	(Landroid/content/Context;Landroid/os/ConditionVariable;)V
    //   643: invokeinterface 394 2 0
    //   648: pop
    //   649: ldc 62
    //   651: ldc_w 396
    //   654: invokestatic 77	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   657: aload 10
    //   659: ldc2_w 397
    //   662: invokevirtual 402	android/os/ConditionVariable:block	(J)Z
    //   665: pop
    //   666: ldc 62
    //   668: ldc_w 404
    //   671: invokestatic 77	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   674: goto -502 -> 172
    //   677: iload 8
    //   679: istore 7
    //   681: ldc 62
    //   683: ldc_w 406
    //   686: invokestatic 409	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   689: goto -210 -> 479
    //   692: astore_0
    //   693: ldc 62
    //   695: aload_0
    //   696: ldc_w 411
    //   699: iconst_0
    //   700: anewarray 4	java/lang/Object
    //   703: invokestatic 415	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   706: iload 7
    //   708: istore_3
    //   709: goto -96 -> 613
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	712	0	paramString1	String
    //   0	712	1	paramString2	String
    //   0	712	2	paramString3	String
    //   0	712	3	paramInt1	int
    //   0	712	4	paramInt2	int
    //   0	712	5	paramInt3	int
    //   0	712	6	paramIConfCallBack	com.tencent.wxmm.IConfCallBack
    //   68	639	7	i	int
    //   65	613	8	j	int
    //   15	622	9	localObject1	Object
    //   60	598	10	localObject2	Object
    //   82	9	11	str	String
    //   104	14	11	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   84	95	104	finally
    //   179	188	692	java/io/IOException
    //   192	198	692	java/io/IOException
    //   202	208	692	java/io/IOException
    //   212	218	692	java/io/IOException
    //   222	248	692	java/io/IOException
    //   252	256	692	java/io/IOException
    //   260	272	692	java/io/IOException
    //   276	282	692	java/io/IOException
    //   286	294	692	java/io/IOException
    //   298	304	692	java/io/IOException
    //   308	315	692	java/io/IOException
    //   319	326	692	java/io/IOException
    //   330	336	692	java/io/IOException
    //   340	348	692	java/io/IOException
    //   352	364	692	java/io/IOException
    //   368	376	692	java/io/IOException
    //   380	388	692	java/io/IOException
    //   392	400	692	java/io/IOException
    //   404	412	692	java/io/IOException
    //   416	424	692	java/io/IOException
    //   428	436	692	java/io/IOException
    //   440	445	692	java/io/IOException
    //   453	460	692	java/io/IOException
    //   464	479	692	java/io/IOException
    //   483	491	692	java/io/IOException
    //   495	519	692	java/io/IOException
    //   523	571	692	java/io/IOException
    //   575	595	692	java/io/IOException
    //   598	613	692	java/io/IOException
    //   681	689	692	java/io/IOException
  }
  
  public static int alY(String paramString)
  {
    AppMethodBeat.i(90825);
    int i = wUC.UpdateAuthKey(paramString.getBytes(), paramString.getBytes().length);
    AppMethodBeat.o(90825);
    return i;
  }
  
  public static void b(boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    int j = 1;
    AppMethodBeat.i(268334);
    v2conference localv2conference = wUC;
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
      AppMethodBeat.o(268334);
      return;
      i = 0;
      break;
      label46:
      j = 0;
    }
  }
  
  public static int d(int paramInt1, byte[] paramArrayOfByte, int paramInt2)
  {
    AppMethodBeat.i(90834);
    paramInt1 = wUC.SetAppCmd(paramInt1, paramArrayOfByte, paramInt2);
    AppMethodBeat.o(90834);
    return paramInt1;
  }
  
  public static v2conference dri()
  {
    return wUC;
  }
  
  public static int drj()
  {
    AppMethodBeat.i(90833);
    int i = wUC.UnInit();
    Log.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "unInit ret:".concat(String.valueOf(i)));
    AppMethodBeat.o(90833);
    return i;
  }
  
  public static int e(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(90829);
    paramInt1 = wUC.SendVideoData(paramArrayOfByte, paramArrayOfByte.length, paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(90829);
    return paramInt1;
  }
  
  public static int f(ArrayList<fkj> paramArrayList1, ArrayList<fkj> paramArrayList2)
  {
    AppMethodBeat.i(268341);
    if (paramArrayList1.size() == 0) {
      Log.e("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "videoMembers is null");
    }
    if (paramArrayList2.size() == 0) {
      Log.e("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "screenMembers is null");
    }
    fki localfki = new fki();
    paramArrayList1 = paramArrayList1.iterator();
    while (paramArrayList1.hasNext())
    {
      fkj localfkj = (fkj)paramArrayList1.next();
      localfki.Ids.add(localfkj);
    }
    paramArrayList1 = paramArrayList2.iterator();
    while (paramArrayList1.hasNext())
    {
      paramArrayList2 = (fkj)paramArrayList1.next();
      localfki.abLk.add(paramArrayList2);
    }
    label206:
    for (;;)
    {
      try
      {
        Log.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "videoResParam:" + new String(localfki.toByteArray()) + ",length:" + localfki.toByteArray().length);
        int i = wUC.SubscribeVideo(localfki.toByteArray(), localfki.toByteArray().length);
        Log.printErrStackTrace("MicroMsg.OpenVoice.OpenVoiceNativeEngine", paramArrayList1, "SetVideoResolution exception", new Object[0]);
      }
      catch (IOException paramArrayList1)
      {
        try
        {
          Log.i("MicroMsg.OpenVoice.OpenVoiceNativeEngine", "steve: subScribeVideoAndResList ret:".concat(String.valueOf(i)));
          AppMethodBeat.o(268341);
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
  
  public static int videoHWProcess(byte[] paramArrayOfByte1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte[] paramArrayOfByte2, int paramInt5, int paramInt6)
  {
    AppMethodBeat.i(268337);
    paramInt1 = wUC.videoHWProcess(paramArrayOfByte1, paramInt1, paramInt2, paramInt3, paramInt4, paramArrayOfByte2, paramInt5, paramInt6);
    AppMethodBeat.o(268337);
    return paramInt1;
  }
  
  public static int z(long paramLong, int paramInt)
  {
    AppMethodBeat.i(90826);
    afo localafo = new afo();
    localafo.ZnD = paramLong;
    localafo.Zox = paramInt;
    localafo.Zoz = 4;
    localafo.Zoy = false;
    paramInt = -1;
    try
    {
      int i = wUC.JoinRoom(localafo.toByteArray(), localafo.toByteArray().length);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.service.m
 * JD-Core Version:    0.7.0.1
 */
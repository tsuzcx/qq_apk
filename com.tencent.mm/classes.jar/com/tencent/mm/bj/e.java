package com.tencent.mm.bj;

import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMetadataRetriever;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.k;
import com.tencent.mm.ipcinvoker.f;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.media.g.d.a;
import com.tencent.mm.media.g.d.b;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;

public final class e
{
  private static final Object fYz;
  
  static
  {
    AppMethodBeat.i(50931);
    fYz = new Object();
    AppMethodBeat.o(50931);
  }
  
  public static int a(String paramString1, final String paramString2, final VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(50926);
    ab.i("MicroMsg.TransferUtil", "Begin to local tranfer");
    final long l = bo.yB();
    ??? = new d.b()
    {
      public final void mP(String arg1)
      {
        AppMethodBeat.i(50918);
        ab.i("MicroMsg.TransferUtil", "mediaCodecRemuxer remux onFinish");
        if (bo.isNullOrNil(???))
        {
          ab.e("MicroMsg.TransferUtil", "MediaCodecRemuxer remux failed, ret path is null, retry x264");
          try
          {
            e.b(this.fYA, paramString2, paramVideoTransPara, l);
          }
          catch (Exception ???)
          {
            synchronized (e.ao())
            {
              try
              {
                e.ao().notifyAll();
                AppMethodBeat.o(50918);
                return;
                ??? = ???;
                ab.i("MicroMsg.TransferUtil", "fallbackTransferWithVideoTransfer error!!!");
                e.z(-1, l);
              }
              catch (Exception localException1)
              {
                for (;;)
                {
                  ab.printErrStackTrace("MicroMsg.TransferUtil", localException1, "wait mediaCodecRemuxer error", new Object[0]);
                }
              }
            }
          }
        }
        e.z(0, l);
        synchronized (e.ao())
        {
          try
          {
            e.ao().notifyAll();
            AppMethodBeat.o(50918);
            return;
          }
          catch (Exception localException2)
          {
            for (;;)
            {
              ab.printErrStackTrace("MicroMsg.TransferUtil", localException2, "wait mediaCodecRemuxer error", new Object[0]);
            }
          }
        }
      }
    };
    boolean bool2 = true;
    for (;;)
    {
      int i;
      try
      {
        if (ah.brt()) {
          if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getInt("HEVCTranscodeMediaCodec", 1) == 1)
          {
            bool1 = true;
            break label526;
            i = ac.erF.epH;
            if (i == -1) {
              break label539;
            }
            if (i != 1) {
              break label533;
            }
            bool1 = true;
            ab.i("MicroMsg.TransferUtil", "serverConfigMediaCodec: %s, dynamicConfigX264: %s, useX264: %s", new Object[] { Boolean.valueOf(bool2), Integer.valueOf(i), Boolean.valueOf(bool1) });
            if (!bool1) {
              continue;
            }
            localObject2 = new g();
            ((g)localObject2).b(paramString1, paramString2, paramVideoTransPara);
            ((g)localObject2).fYO = true;
            ((g)localObject2).fYP = bool1;
            ??? = null;
            if ((localObject2 == null) || (!bool1)) {
              break label370;
            }
          }
        }
      }
      catch (Exception paramString1)
      {
        Object localObject2;
        ab.e("MicroMsg.TransferUtil", "Local tranfer init failed: %s", new Object[] { paramString1.getMessage() });
        AppMethodBeat.o(50926);
        return -1;
      }
      try
      {
        i = ((g)localObject2).hg(ew(paramString1));
        y(i, l);
        b.fYm.XJ();
      }
      catch (Exception paramString1)
      {
        i = -1;
        ab.e("MicroMsg.TransferUtil", "Local tranfer to H264 error: %s", new Object[] { paramString1.getMessage() });
        b.fYm.XJ();
        continue;
      }
      finally
      {
        b.fYm.XJ();
        AppMethodBeat.o(50926);
      }
      AppMethodBeat.o(50926);
      return i;
      boolean bool1 = false;
      break label526;
      localObject2 = (IPCBoolean)f.a("com.tencent.mm", new IPCVoid(), e.a.class);
      label526:
      label533:
      label539:
      if (localObject2 != null)
      {
        bool2 = ((IPCBoolean)localObject2).value;
        continue;
        localObject2 = com.tencent.mm.plugin.sight.base.d.Zo(paramString1);
        if ((localObject2 != null) && (((com.tencent.mm.plugin.sight.base.a)localObject2).eRw > 0))
        {
          paramVideoTransPara.fps = ((int)Math.min(30.0F, ((com.tencent.mm.plugin.sight.base.a)localObject2).eRw));
          ab.i("MicroMsg.TransferUtil", "transfer h265 use 30fps, newPara.fps:%s, mediaInfo.frameRate:%s", new Object[] { Integer.valueOf(paramVideoTransPara.fps), Integer.valueOf(((com.tencent.mm.plugin.sight.base.a)localObject2).eRw) });
        }
        ??? = com.tencent.mm.media.g.d.eWu.a(paramString1, paramString2, paramVideoTransPara.width, paramVideoTransPara.height, paramVideoTransPara.videoBitrate, paramVideoTransPara.fps, (d.b)???);
        localObject2 = null;
        continue;
        label370:
        if (??? != null)
        {
          try
          {
            ab.i("MicroMsg.TransferUtil", "start mediaCodecRemuxer remux");
            ((com.tencent.mm.media.g.d)???).Va();
            synchronized (fYz)
            {
              try
              {
                fYz.wait();
                ab.i("MicroMsg.TransferUtil", "mediaCodecRemuxLock wait finish");
                i = 0;
              }
              catch (Exception localException2)
              {
                for (;;)
                {
                  ab.printErrStackTrace("MicroMsg.TransferUtil", localException2, "wait mediaCodecRemux error", new Object[0]);
                }
              }
            }
            i = 0;
          }
          catch (Exception localException1)
          {
            ab.i("MicroMsg.TransferUtil", "MediaCodecRemuxer remux, retry x264, error:%s", new Object[] { localException1.getMessage() });
            a(paramString1, paramString2, paramVideoTransPara, l);
          }
        }
        else
        {
          continue;
          bool2 = bool1;
          continue;
          bool1 = false;
          continue;
          if (!bool2) {
            bool1 = true;
          } else {
            bool1 = false;
          }
        }
      }
    }
  }
  
  public static VideoTransPara a(VideoTransPara paramVideoTransPara, String paramString)
  {
    AppMethodBeat.i(50923);
    VideoTransPara localVideoTransPara = com.tencent.mm.modelcontrol.d.afW().c(paramVideoTransPara);
    if (localVideoTransPara == null)
    {
      ab.i("MicroMsg.TransferUtil", "get C2C album video para is null. old para %s", new Object[] { paramVideoTransPara });
      paramVideoTransPara = vD(paramString);
      AppMethodBeat.o(50923);
      return paramVideoTransPara;
    }
    ab.d("MicroMsg.TransferUtil", "compress new para is %s", new Object[] { localVideoTransPara });
    if ((paramVideoTransPara.videoBitrate <= 640000) || (localVideoTransPara.videoBitrate > paramVideoTransPara.videoBitrate))
    {
      ab.i("MicroMsg.TransferUtil", "new bitrate is bigger than old bitrate %s %s", new Object[] { localVideoTransPara, paramVideoTransPara });
      paramVideoTransPara = vD(paramString);
      AppMethodBeat.o(50923);
      return paramVideoTransPara;
    }
    if ((paramVideoTransPara.fps >= 45) && (paramVideoTransPara.duration * 1000 >= 180000))
    {
      paramVideoTransPara = vD(paramString);
      AppMethodBeat.o(50923);
      return paramVideoTransPara;
    }
    AppMethodBeat.o(50923);
    return localVideoTransPara;
  }
  
  /* Error */
  private static void a(String paramString, VideoTransPara paramVideoTransPara)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: ldc_w 264
    //   5: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 266	android/media/MediaExtractor
    //   11: dup
    //   12: invokespecial 267	android/media/MediaExtractor:<init>	()V
    //   15: astore 5
    //   17: aload 5
    //   19: astore 4
    //   21: aload 5
    //   23: aload_0
    //   24: invokevirtual 271	android/media/MediaExtractor:setDataSource	(Ljava/lang/String;)V
    //   27: aload 5
    //   29: astore 4
    //   31: aload 5
    //   33: invokevirtual 274	android/media/MediaExtractor:getTrackCount	()I
    //   36: istore_3
    //   37: iload_2
    //   38: iload_3
    //   39: if_icmpge +140 -> 179
    //   42: aload 5
    //   44: astore 4
    //   46: aload 5
    //   48: iload_2
    //   49: invokevirtual 278	android/media/MediaExtractor:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   52: astore 6
    //   54: aload 5
    //   56: astore 4
    //   58: aload 6
    //   60: ldc_w 280
    //   63: invokevirtual 286	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   66: ifeq +125 -> 191
    //   69: aload 5
    //   71: astore 4
    //   73: aload 6
    //   75: ldc_w 280
    //   78: invokevirtual 290	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   81: invokestatic 293	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   84: ifne +107 -> 191
    //   87: aload 5
    //   89: astore 4
    //   91: aload 6
    //   93: ldc_w 280
    //   96: invokevirtual 290	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   99: astore 7
    //   101: aload 5
    //   103: astore 4
    //   105: ldc 35
    //   107: ldc_w 295
    //   110: iconst_1
    //   111: anewarray 4	java/lang/Object
    //   114: dup
    //   115: iconst_0
    //   116: aload 7
    //   118: aastore
    //   119: invokestatic 105	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   122: aload 5
    //   124: astore 4
    //   126: aload 7
    //   128: ldc_w 297
    //   131: invokevirtual 302	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   134: ifeq +57 -> 191
    //   137: aload 5
    //   139: astore 4
    //   141: aload_1
    //   142: aload 6
    //   144: ldc_w 304
    //   147: invokevirtual 307	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   150: putfield 178	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   153: aload 5
    //   155: astore 4
    //   157: ldc 35
    //   159: ldc_w 309
    //   162: iconst_1
    //   163: anewarray 4	java/lang/Object
    //   166: dup
    //   167: iconst_0
    //   168: aload_1
    //   169: getfield 178	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   172: invokestatic 102	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   175: aastore
    //   176: invokestatic 105	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   179: aload 5
    //   181: invokevirtual 312	android/media/MediaExtractor:release	()V
    //   184: ldc_w 264
    //   187: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   190: return
    //   191: iload_2
    //   192: iconst_1
    //   193: iadd
    //   194: istore_2
    //   195: goto -158 -> 37
    //   198: astore 6
    //   200: aconst_null
    //   201: astore 5
    //   203: aload 5
    //   205: astore 4
    //   207: ldc 35
    //   209: aload 6
    //   211: ldc_w 314
    //   214: iconst_0
    //   215: anewarray 4	java/lang/Object
    //   218: invokestatic 226	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   221: aload 5
    //   223: astore 4
    //   225: aload_0
    //   226: invokestatic 161	com/tencent/mm/plugin/sight/base/d:Zo	(Ljava/lang/String;)Lcom/tencent/mm/plugin/sight/base/a;
    //   229: astore_0
    //   230: aload_0
    //   231: ifnull +41 -> 272
    //   234: aload 5
    //   236: astore 4
    //   238: aload_1
    //   239: aload_0
    //   240: getfield 166	com/tencent/mm/plugin/sight/base/a:eRw	I
    //   243: putfield 178	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   246: aload 5
    //   248: astore 4
    //   250: ldc 35
    //   252: ldc_w 316
    //   255: iconst_1
    //   256: anewarray 4	java/lang/Object
    //   259: dup
    //   260: iconst_0
    //   261: aload_0
    //   262: getfield 166	com/tencent/mm/plugin/sight/base/a:eRw	I
    //   265: invokestatic 102	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   268: aastore
    //   269: invokestatic 105	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   272: aload 5
    //   274: ifnull +37 -> 311
    //   277: aload 5
    //   279: invokevirtual 312	android/media/MediaExtractor:release	()V
    //   282: ldc_w 264
    //   285: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   288: return
    //   289: astore_0
    //   290: aconst_null
    //   291: astore 4
    //   293: aload 4
    //   295: ifnull +8 -> 303
    //   298: aload 4
    //   300: invokevirtual 312	android/media/MediaExtractor:release	()V
    //   303: ldc_w 264
    //   306: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   309: aload_0
    //   310: athrow
    //   311: ldc_w 264
    //   314: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   317: return
    //   318: astore_0
    //   319: goto -26 -> 293
    //   322: astore 6
    //   324: goto -121 -> 203
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	327	0	paramString	String
    //   0	327	1	paramVideoTransPara	VideoTransPara
    //   1	194	2	i	int
    //   36	4	3	j	int
    //   19	280	4	localMediaExtractor1	MediaExtractor
    //   15	263	5	localMediaExtractor2	MediaExtractor
    //   52	91	6	localMediaFormat	MediaFormat
    //   198	12	6	localException1	Exception
    //   322	1	6	localException2	Exception
    //   99	28	7	str	String
    // Exception table:
    //   from	to	target	type
    //   8	17	198	java/lang/Exception
    //   8	17	289	finally
    //   21	27	318	finally
    //   31	37	318	finally
    //   46	54	318	finally
    //   58	69	318	finally
    //   73	87	318	finally
    //   91	101	318	finally
    //   105	122	318	finally
    //   126	137	318	finally
    //   141	153	318	finally
    //   157	179	318	finally
    //   207	221	318	finally
    //   225	230	318	finally
    //   238	246	318	finally
    //   250	272	318	finally
    //   21	27	322	java/lang/Exception
    //   31	37	322	java/lang/Exception
    //   46	54	322	java/lang/Exception
    //   58	69	322	java/lang/Exception
    //   73	87	322	java/lang/Exception
    //   91	101	322	java/lang/Exception
    //   105	122	322	java/lang/Exception
    //   126	137	322	java/lang/Exception
    //   141	153	322	java/lang/Exception
    //   157	179	322	java/lang/Exception
  }
  
  private static void a(String paramString1, String paramString2, VideoTransPara paramVideoTransPara, long paramLong)
  {
    AppMethodBeat.i(50927);
    ab.b("MicroMsg.TransferUtil", "fallbackTransferWithVideoTransfer, srcPath:%s, dstPath:%s, newPara:%s", new Object[] { paramString1, paramString2, paramVideoTransPara });
    g localg = new g();
    localg.b(paramString1, paramString2, paramVideoTransPara);
    localg.fYO = true;
    localg.fYP = true;
    int i = localg.hg(ew(paramString1));
    ab.i("MicroMsg.TransferUtil", "fallbackTransferWithVideoTransfer, finish, segRet:%s", new Object[] { Integer.valueOf(i) });
    y(i, paramLong);
    AppMethodBeat.o(50927);
  }
  
  public static int ew(String paramString)
  {
    AppMethodBeat.i(50925);
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    localMediaMetadataRetriever.setDataSource(paramString);
    paramString = localMediaMetadataRetriever.extractMetadata(9);
    localMediaMetadataRetriever.release();
    if (paramString == null)
    {
      AppMethodBeat.o(50925);
      return 0;
    }
    try
    {
      int i = Integer.valueOf(paramString).intValue();
      AppMethodBeat.o(50925);
      return i;
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.TransferUtil", "getDuration error %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(50925);
    }
    return 0;
  }
  
  public static boolean vB(String paramString)
  {
    AppMethodBeat.i(50920);
    ab.i("MicroMsg.TransferUtil", "Check video format：h265 or h264？");
    try
    {
      MediaExtractor localMediaExtractor = new MediaExtractor();
      localMediaExtractor.setDataSource(paramString);
      int j = localMediaExtractor.getTrackCount();
      int i = 0;
      while (i < j)
      {
        paramString = localMediaExtractor.getTrackFormat(i);
        if ((paramString.containsKey("mime")) && (!bo.isNullOrNil(paramString.getString("mime"))))
        {
          paramString = paramString.getString("mime");
          ab.i("MicroMsg.TransferUtil", "mime: %s", new Object[] { paramString });
          boolean bool = paramString.startsWith("video/hevc");
          if (bool)
          {
            AppMethodBeat.o(50920);
            return true;
          }
        }
        i += 1;
      }
      localMediaExtractor.release();
    }
    catch (Exception paramString)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.TransferUtil", paramString, "check H265 error", new Object[0]);
      }
    }
    AppMethodBeat.o(50920);
    return false;
  }
  
  public static VideoTransPara vC(String paramString)
  {
    AppMethodBeat.i(50921);
    ab.i("MicroMsg.TransferUtil", "buildPara：srcPath %s ", new Object[] { paramString });
    VideoTransPara localVideoTransPara = new VideoTransPara();
    Object localObject = Boolean.valueOf(vB(paramString));
    ab.i("MicroMsg.TransferUtil", "Video format is h265 : %s", new Object[] { localObject });
    if (((Boolean)localObject).booleanValue())
    {
      localObject = new MediaMetadataRetriever();
      ((MediaMetadataRetriever)localObject).setDataSource(paramString);
      localVideoTransPara.duration = bo.getInt(((MediaMetadataRetriever)localObject).extractMetadata(9), 0);
      localVideoTransPara.duration = bo.nX(localVideoTransPara.duration);
      localVideoTransPara.width = bo.getInt(((MediaMetadataRetriever)localObject).extractMetadata(18), 0);
      localVideoTransPara.height = bo.getInt(((MediaMetadataRetriever)localObject).extractMetadata(19), 0);
      localVideoTransPara.videoBitrate = bo.getInt(((MediaMetadataRetriever)localObject).extractMetadata(20), 0);
      a(paramString, localVideoTransPara);
      ((MediaMetadataRetriever)localObject).release();
    }
    for (;;)
    {
      ab.d("MicroMsg.TransferUtil", "VideoPara is : %s", new Object[] { localVideoTransPara });
      AppMethodBeat.o(50921);
      return localVideoTransPara;
      localObject = new PInt();
      PInt localPInt1 = new PInt();
      PInt localPInt2 = new PInt();
      PInt localPInt3 = new PInt();
      PInt localPInt4 = new PInt();
      com.tencent.mm.plugin.sight.base.d.a(paramString, (PInt)localObject, localPInt1, localPInt2, localPInt3, localPInt4);
      localVideoTransPara.duration = bo.nX(((PInt)localObject).value);
      localVideoTransPara.width = localPInt1.value;
      localVideoTransPara.height = localPInt2.value;
      localVideoTransPara.fps = localPInt3.value;
      localVideoTransPara.videoBitrate = localPInt4.value;
    }
  }
  
  /* Error */
  private static VideoTransPara vD(String paramString)
  {
    // Byte code:
    //   0: ldc_w 381
    //   3: invokestatic 19	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 175	com/tencent/mm/modelcontrol/VideoTransPara
    //   9: dup
    //   10: invokespecial 357	com/tencent/mm/modelcontrol/VideoTransPara:<init>	()V
    //   13: astore 5
    //   15: iconst_2
    //   16: newarray int
    //   18: astore 6
    //   20: new 329	android/media/MediaMetadataRetriever
    //   23: dup
    //   24: invokespecial 330	android/media/MediaMetadataRetriever:<init>	()V
    //   27: astore 4
    //   29: aload 4
    //   31: aload_0
    //   32: invokevirtual 331	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   35: aload 4
    //   37: bipush 18
    //   39: invokevirtual 335	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   42: iconst_0
    //   43: invokestatic 365	com/tencent/mm/sdk/platformtools/bo:getInt	(Ljava/lang/String;I)I
    //   46: istore_3
    //   47: aload 4
    //   49: bipush 19
    //   51: invokevirtual 335	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   54: iconst_0
    //   55: invokestatic 365	com/tencent/mm/sdk/platformtools/bo:getInt	(Ljava/lang/String;I)I
    //   58: istore_2
    //   59: aload 6
    //   61: iconst_0
    //   62: iload_3
    //   63: iastore
    //   64: aload 6
    //   66: iconst_1
    //   67: iload_2
    //   68: iastore
    //   69: iconst_0
    //   70: istore_1
    //   71: iload_1
    //   72: iconst_3
    //   73: if_icmpge +125 -> 198
    //   76: iload_3
    //   77: iconst_2
    //   78: irem
    //   79: ifne +9 -> 88
    //   82: iload_2
    //   83: iconst_2
    //   84: irem
    //   85: ifeq +75 -> 160
    //   88: aload 4
    //   90: invokevirtual 336	android/media/MediaMetadataRetriever:release	()V
    //   93: aload 5
    //   95: aload 6
    //   97: iconst_0
    //   98: iaload
    //   99: putfield 189	com/tencent/mm/modelcontrol/VideoTransPara:width	I
    //   102: aload 5
    //   104: aload 6
    //   106: iconst_1
    //   107: iaload
    //   108: putfield 192	com/tencent/mm/modelcontrol/VideoTransPara:height	I
    //   111: aload 5
    //   113: getstatic 386	com/tencent/mm/plugin/sight/base/b:qSq	I
    //   116: putfield 195	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
    //   119: aload 5
    //   121: getstatic 389	com/tencent/mm/plugin/sight/base/b:qSp	I
    //   124: putfield 392	com/tencent/mm/modelcontrol/VideoTransPara:fzW	I
    //   127: aload 5
    //   129: iconst_2
    //   130: putfield 395	com/tencent/mm/modelcontrol/VideoTransPara:fzV	I
    //   133: aload 5
    //   135: getstatic 399	com/tencent/mm/plugin/sight/base/b:qSr	F
    //   138: f2i
    //   139: putfield 178	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   142: aload 5
    //   144: aload_0
    //   145: invokestatic 123	com/tencent/mm/bj/e:ew	(Ljava/lang/String;)I
    //   148: putfield 261	com/tencent/mm/modelcontrol/VideoTransPara:duration	I
    //   151: ldc_w 381
    //   154: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   157: aload 5
    //   159: areturn
    //   160: iload_3
    //   161: iload_2
    //   162: if_icmplt +17 -> 179
    //   165: iload_3
    //   166: sipush 640
    //   169: if_icmple +29 -> 198
    //   172: iload_2
    //   173: sipush 480
    //   176: if_icmple +22 -> 198
    //   179: iload_3
    //   180: iload_2
    //   181: if_icmpgt +64 -> 245
    //   184: iload_3
    //   185: sipush 480
    //   188: if_icmple +10 -> 198
    //   191: iload_2
    //   192: sipush 640
    //   195: if_icmpgt +50 -> 245
    //   198: aload 6
    //   200: iconst_0
    //   201: iload_3
    //   202: iastore
    //   203: aload 6
    //   205: iconst_1
    //   206: iload_2
    //   207: iastore
    //   208: aload 4
    //   210: invokevirtual 336	android/media/MediaMetadataRetriever:release	()V
    //   213: goto -120 -> 93
    //   216: astore_0
    //   217: ldc 35
    //   219: aload_0
    //   220: ldc_w 401
    //   223: iconst_1
    //   224: anewarray 4	java/lang/Object
    //   227: dup
    //   228: iconst_0
    //   229: aload_0
    //   230: invokevirtual 206	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   233: aastore
    //   234: invokestatic 226	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   237: ldc_w 381
    //   240: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   243: aconst_null
    //   244: areturn
    //   245: iload_3
    //   246: iconst_2
    //   247: idiv
    //   248: istore_3
    //   249: iload_2
    //   250: iconst_2
    //   251: idiv
    //   252: istore_2
    //   253: iload_1
    //   254: iconst_1
    //   255: iadd
    //   256: istore_1
    //   257: goto -186 -> 71
    //   260: astore_0
    //   261: aconst_null
    //   262: astore 4
    //   264: aload 4
    //   266: ifnull +8 -> 274
    //   269: aload 4
    //   271: invokevirtual 336	android/media/MediaMetadataRetriever:release	()V
    //   274: ldc_w 381
    //   277: invokestatic 27	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   280: aload_0
    //   281: athrow
    //   282: astore_0
    //   283: goto -19 -> 264
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	286	0	paramString	String
    //   70	187	1	i	int
    //   58	195	2	j	int
    //   46	203	3	k	int
    //   27	243	4	localMediaMetadataRetriever	MediaMetadataRetriever
    //   13	145	5	localVideoTransPara	VideoTransPara
    //   18	186	6	arrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   6	20	216	java/lang/Exception
    //   88	93	216	java/lang/Exception
    //   93	151	216	java/lang/Exception
    //   208	213	216	java/lang/Exception
    //   269	274	216	java/lang/Exception
    //   274	282	216	java/lang/Exception
    //   20	29	260	finally
    //   29	59	282	finally
    //   245	253	282	finally
  }
  
  private static void y(int paramInt, long paramLong)
  {
    AppMethodBeat.i(50928);
    if (paramInt < 0) {
      ab.i("MicroMsg.TransferUtil", "Local tranfer to H264 failed：%s", new Object[] { Integer.valueOf(paramInt) });
    }
    ab.i("MicroMsg.TransferUtil", "Transfer Finish");
    paramLong = bo.yB() - paramLong;
    ab.i("MicroMsg.TransferUtil", "totalTime：%d", new Object[] { Long.valueOf(paramLong) });
    ArrayList localArrayList = new ArrayList();
    IDKey localIDKey1 = new IDKey();
    localIDKey1.SetID(354);
    localIDKey1.SetKey(253);
    localIDKey1.SetValue(paramLong);
    IDKey localIDKey2 = new IDKey();
    localIDKey2.SetID(354);
    localIDKey2.SetKey(254);
    localIDKey2.SetValue(1L);
    localArrayList.add(localIDKey1);
    localArrayList.add(localIDKey2);
    h.qsU.b(localArrayList, false);
    AppMethodBeat.o(50928);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.bj.e
 * JD-Core Version:    0.7.0.1
 */
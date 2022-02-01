package com.tencent.mm.bk;

import android.annotation.TargetApi;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import com.tencent.mars.smc.IDKey;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.k;
import com.tencent.mm.ipcinvoker.h;
import com.tencent.mm.ipcinvoker.type.IPCBoolean;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.media.i.d.a;
import com.tencent.mm.media.i.d.b;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.modelvideo.r;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.vfs.o;
import java.util.ArrayList;

@TargetApi(16)
public final class e
{
  static void B(int paramInt, long paramLong)
  {
    AppMethodBeat.i(127098);
    if (paramInt < 0) {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.TransferUtil", "Local tranfer to H264 failed：%s", new Object[] { Integer.valueOf(paramInt) });
    }
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.TransferUtil", "Transfer Finish");
    paramLong = bu.HQ() - paramLong;
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.TransferUtil", "totalTime：%d", new Object[] { Long.valueOf(paramLong) });
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
    com.tencent.mm.plugin.report.service.g.yxI.b(localArrayList, false);
    AppMethodBeat.o(127098);
  }
  
  public static boolean Ik(String paramString)
  {
    AppMethodBeat.i(127091);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.TransferUtil", "Check video format：h265 or h264？");
    boolean bool = r.isH265Video(paramString);
    AppMethodBeat.o(127091);
    return bool;
  }
  
  public static VideoTransPara Il(String paramString)
  {
    AppMethodBeat.i(127092);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.TransferUtil", "buildPara：srcPath %s ", new Object[] { paramString });
    VideoTransPara localVideoTransPara = new VideoTransPara();
    Object localObject = Boolean.valueOf(Ik(paramString));
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.TransferUtil", "Video format is h265 : %s", new Object[] { localObject });
    if (((Boolean)localObject).booleanValue())
    {
      localObject = new com.tencent.mm.compatible.h.d();
      ((MediaMetadataRetriever)localObject).setDataSource(paramString);
      localVideoTransPara.duration = bu.getInt(((MediaMetadataRetriever)localObject).extractMetadata(9), 0);
      localVideoTransPara.duration = bu.DE(localVideoTransPara.duration);
      localVideoTransPara.width = bu.getInt(((MediaMetadataRetriever)localObject).extractMetadata(18), 0);
      localVideoTransPara.height = bu.getInt(((MediaMetadataRetriever)localObject).extractMetadata(19), 0);
      localVideoTransPara.videoBitrate = bu.getInt(((MediaMetadataRetriever)localObject).extractMetadata(20), 0);
      a(paramString, localVideoTransPara);
      ((MediaMetadataRetriever)localObject).release();
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.TransferUtil", "VideoPara is : %s", new Object[] { localVideoTransPara });
      AppMethodBeat.o(127092);
      return localVideoTransPara;
      localObject = new PInt();
      PInt localPInt1 = new PInt();
      PInt localPInt2 = new PInt();
      PInt localPInt3 = new PInt();
      PInt localPInt4 = new PInt();
      com.tencent.mm.plugin.sight.base.e.a(paramString, (PInt)localObject, localPInt1, localPInt2, localPInt3, localPInt4);
      localVideoTransPara.duration = bu.DE(((PInt)localObject).value);
      localVideoTransPara.width = localPInt1.value;
      localVideoTransPara.height = localPInt2.value;
      localVideoTransPara.fps = localPInt3.value;
      localVideoTransPara.videoBitrate = localPInt4.value;
    }
  }
  
  /* Error */
  private static VideoTransPara Im(String paramString)
  {
    // Byte code:
    //   0: ldc 184
    //   2: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 107	com/tencent/mm/modelcontrol/VideoTransPara
    //   8: dup
    //   9: invokespecial 108	com/tencent/mm/modelcontrol/VideoTransPara:<init>	()V
    //   12: astore 5
    //   14: iconst_2
    //   15: newarray int
    //   17: astore 6
    //   19: new 123	com/tencent/mm/compatible/h/d
    //   22: dup
    //   23: invokespecial 124	com/tencent/mm/compatible/h/d:<init>	()V
    //   26: astore 4
    //   28: aload 4
    //   30: aload_0
    //   31: invokevirtual 130	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   34: aload 4
    //   36: bipush 18
    //   38: invokevirtual 134	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   41: iconst_0
    //   42: invokestatic 138	com/tencent/mm/sdk/platformtools/bu:getInt	(Ljava/lang/String;I)I
    //   45: istore_3
    //   46: aload 4
    //   48: bipush 19
    //   50: invokevirtual 134	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   53: iconst_0
    //   54: invokestatic 138	com/tencent/mm/sdk/platformtools/bu:getInt	(Ljava/lang/String;I)I
    //   57: istore_2
    //   58: aload 6
    //   60: iconst_0
    //   61: iload_3
    //   62: iastore
    //   63: aload 6
    //   65: iconst_1
    //   66: iload_2
    //   67: iastore
    //   68: iconst_0
    //   69: istore_1
    //   70: iload_1
    //   71: iconst_3
    //   72: if_icmpge +124 -> 196
    //   75: iload_3
    //   76: iconst_2
    //   77: irem
    //   78: ifne +9 -> 87
    //   81: iload_2
    //   82: iconst_2
    //   83: irem
    //   84: ifeq +74 -> 158
    //   87: aload 4
    //   89: invokevirtual 162	android/media/MediaMetadataRetriever:release	()V
    //   92: aload 5
    //   94: aload 6
    //   96: iconst_0
    //   97: iaload
    //   98: putfield 149	com/tencent/mm/modelcontrol/VideoTransPara:width	I
    //   101: aload 5
    //   103: aload 6
    //   105: iconst_1
    //   106: iaload
    //   107: putfield 152	com/tencent/mm/modelcontrol/VideoTransPara:height	I
    //   110: aload 5
    //   112: getstatic 189	com/tencent/mm/plugin/sight/base/c:zhm	I
    //   115: putfield 155	com/tencent/mm/modelcontrol/VideoTransPara:videoBitrate	I
    //   118: aload 5
    //   120: getstatic 192	com/tencent/mm/plugin/sight/base/c:zhl	I
    //   123: putfield 195	com/tencent/mm/modelcontrol/VideoTransPara:hXX	I
    //   126: aload 5
    //   128: iconst_2
    //   129: putfield 198	com/tencent/mm/modelcontrol/VideoTransPara:hXW	I
    //   132: aload 5
    //   134: getstatic 202	com/tencent/mm/plugin/sight/base/c:zhn	F
    //   137: f2i
    //   138: putfield 180	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   141: aload 5
    //   143: aload_0
    //   144: invokestatic 206	com/tencent/mm/bk/e:gu	(Ljava/lang/String;)I
    //   147: putfield 142	com/tencent/mm/modelcontrol/VideoTransPara:duration	I
    //   150: ldc 184
    //   152: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   155: aload 5
    //   157: areturn
    //   158: iload_3
    //   159: iload_2
    //   160: if_icmplt +17 -> 177
    //   163: iload_3
    //   164: sipush 640
    //   167: if_icmple +29 -> 196
    //   170: iload_2
    //   171: sipush 480
    //   174: if_icmple +22 -> 196
    //   177: iload_3
    //   178: iload_2
    //   179: if_icmpgt +62 -> 241
    //   182: iload_3
    //   183: sipush 480
    //   186: if_icmple +10 -> 196
    //   189: iload_2
    //   190: sipush 640
    //   193: if_icmpgt +48 -> 241
    //   196: aload 6
    //   198: iconst_0
    //   199: iload_3
    //   200: iastore
    //   201: aload 6
    //   203: iconst_1
    //   204: iload_2
    //   205: iastore
    //   206: aload 4
    //   208: invokevirtual 162	android/media/MediaMetadataRetriever:release	()V
    //   211: goto -119 -> 92
    //   214: astore_0
    //   215: ldc 22
    //   217: aload_0
    //   218: ldc 208
    //   220: iconst_1
    //   221: anewarray 4	java/lang/Object
    //   224: dup
    //   225: iconst_0
    //   226: aload_0
    //   227: invokevirtual 212	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   230: aastore
    //   231: invokestatic 216	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   234: ldc 184
    //   236: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   239: aconst_null
    //   240: areturn
    //   241: iload_3
    //   242: iconst_2
    //   243: idiv
    //   244: istore_3
    //   245: iload_2
    //   246: iconst_2
    //   247: idiv
    //   248: istore_2
    //   249: iload_1
    //   250: iconst_1
    //   251: iadd
    //   252: istore_1
    //   253: goto -183 -> 70
    //   256: astore_0
    //   257: aconst_null
    //   258: astore 4
    //   260: aload 4
    //   262: ifnull +8 -> 270
    //   265: aload 4
    //   267: invokevirtual 162	android/media/MediaMetadataRetriever:release	()V
    //   270: ldc 184
    //   272: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   275: aload_0
    //   276: athrow
    //   277: astore_0
    //   278: goto -18 -> 260
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	281	0	paramString	String
    //   69	184	1	i	int
    //   57	192	2	j	int
    //   45	200	3	k	int
    //   26	240	4	locald	com.tencent.mm.compatible.h.d
    //   12	144	5	localVideoTransPara	VideoTransPara
    //   17	185	6	arrayOfInt	int[]
    // Exception table:
    //   from	to	target	type
    //   5	19	214	java/lang/Exception
    //   87	92	214	java/lang/Exception
    //   92	150	214	java/lang/Exception
    //   206	211	214	java/lang/Exception
    //   265	270	214	java/lang/Exception
    //   270	277	214	java/lang/Exception
    //   19	28	256	finally
    //   28	58	277	finally
    //   241	249	277	finally
  }
  
  public static int a(String paramString1, final String paramString2, final VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(127096);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.TransferUtil", "Begin to local tranfer");
    final long l = bu.HQ();
    Object localObject1 = new d.b()
    {
      public final void yO(String paramAnonymousString)
      {
        AppMethodBeat.i(127089);
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.TransferUtil", "mediaCodecRemuxer remux onFinish");
        if (bu.isNullOrNil(paramAnonymousString))
        {
          com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.TransferUtil", "MediaCodecRemuxer remux failed, ret path is null, retry x264");
          try
          {
            e.a(this.iyd, paramString2, paramVideoTransPara, l);
            e.b(this.iyd, paramString2, paramVideoTransPara);
            AppMethodBeat.o(127089);
            return;
          }
          catch (Exception paramAnonymousString)
          {
            for (;;)
            {
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.TransferUtil", "fallbackTransferWithVideoTransfer error!!!");
              e.B(-1, l);
            }
          }
        }
        e.B(0, l);
        e.b(this.iyd, paramString2, paramVideoTransPara);
        AppMethodBeat.o(127089);
      }
    };
    boolean bool2 = true;
    for (;;)
    {
      int i;
      try
      {
        if (ak.cpe()) {
          if (((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acL().getInt("HEVCTranscodeMediaCodec", 1) == 1)
          {
            bool1 = true;
            break label501;
            i = com.tencent.mm.compatible.deviceinfo.ae.geX.gcm;
            if (i == -1) {
              break label514;
            }
            if (i != 1) {
              break label508;
            }
            bool1 = true;
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.TransferUtil", "serverConfigMediaCodec: %s, dynamicConfigX264: %s, useX264: %s", new Object[] { Boolean.valueOf(bool2), Integer.valueOf(i), Boolean.valueOf(bool1) });
            if (!bool1) {
              continue;
            }
            localObject2 = new g();
            ((g)localObject2).c(paramString1, paramString2, paramVideoTransPara);
            ((g)localObject2).iyt = true;
            ((g)localObject2).iyu = bool1;
            localObject1 = null;
            if ((localObject2 == null) || (!bool1)) {
              break label389;
            }
          }
        }
      }
      catch (Exception paramString1)
      {
        Object localObject2;
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.TransferUtil", "Local tranfer init failed: %s", new Object[] { paramString1.getMessage() });
        AppMethodBeat.o(127096);
        return -1;
      }
      try
      {
        i = ((g)localObject2).sG(gu(paramString1));
        B(i, l);
        b(paramString1, paramString2, paramVideoTransPara);
        b.ixQ.ayL();
      }
      catch (Exception paramString1)
      {
        i = -1;
        com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.TransferUtil", "Local tranfer to H264 error: %s", new Object[] { paramString1.getMessage() });
        b.ixQ.ayL();
        continue;
      }
      finally
      {
        b.ixQ.ayL();
        AppMethodBeat.o(127096);
      }
      AppMethodBeat.o(127096);
      return i;
      boolean bool1 = false;
      break label501;
      localObject2 = (IPCBoolean)h.a("com.tencent.mm", new IPCVoid(), e.a.class);
      label514:
      if (localObject2 != null)
      {
        bool2 = ((IPCBoolean)localObject2).value;
        continue;
        localObject2 = com.tencent.mm.plugin.sight.base.e.ayN(paramString1);
        if ((localObject2 != null) && (((com.tencent.mm.plugin.sight.base.a)localObject2).frameRate > 0))
        {
          paramVideoTransPara.fps = ((int)Math.min(30.0F, ((com.tencent.mm.plugin.sight.base.a)localObject2).frameRate));
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.TransferUtil", "transfer h265 use 30fps, newPara.fps:%s, mediaInfo.frameRate:%s", new Object[] { Integer.valueOf(paramVideoTransPara.fps), Integer.valueOf(((com.tencent.mm.plugin.sight.base.a)localObject2).frameRate) });
        }
        localObject1 = com.tencent.mm.media.i.d.hol.a(paramString1, paramString2, paramVideoTransPara.width, paramVideoTransPara.height, paramVideoTransPara.videoBitrate, paramVideoTransPara.fps, paramVideoTransPara.hkJ, paramVideoTransPara.hkK, (d.b)localObject1);
        localObject2 = null;
        continue;
        label389:
        if (localObject1 != null)
        {
          try
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.TransferUtil", "start mediaCodecRemuxer remux");
            ((com.tencent.mm.media.i.d)localObject1).aue();
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.TransferUtil", "mediaCodecRemuxLock wait finish");
            i = 0;
          }
          catch (Exception localException)
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.TransferUtil", "MediaCodecRemuxer remux, retry x264, error:%s", new Object[] { localException.getMessage() });
            a(paramString1, paramString2, paramVideoTransPara, l);
          }
        }
        else
        {
          i = 0;
          continue;
          label501:
          bool2 = bool1;
          continue;
          label508:
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
    AppMethodBeat.i(127093);
    VideoTransPara localVideoTransPara = com.tencent.mm.modelcontrol.d.aHh().c(paramVideoTransPara);
    if (localVideoTransPara == null)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.TransferUtil", "get C2C album video para is null. old para %s", new Object[] { paramVideoTransPara });
      paramVideoTransPara = Im(paramString);
      AppMethodBeat.o(127093);
      return paramVideoTransPara;
    }
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.TransferUtil", "compress new para is %s", new Object[] { localVideoTransPara });
    if ((paramVideoTransPara.videoBitrate <= 640000) || (localVideoTransPara.videoBitrate > paramVideoTransPara.videoBitrate))
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.TransferUtil", "new bitrate is bigger than old bitrate %s %s", new Object[] { localVideoTransPara, paramVideoTransPara });
      paramVideoTransPara = Im(paramString);
      AppMethodBeat.o(127093);
      return paramVideoTransPara;
    }
    if ((paramVideoTransPara.fps >= 45) && (paramVideoTransPara.duration * 1000 >= 180000))
    {
      paramVideoTransPara = Im(paramString);
      AppMethodBeat.o(127093);
      return paramVideoTransPara;
    }
    AppMethodBeat.o(127093);
    return localVideoTransPara;
  }
  
  /* Error */
  private static void a(String paramString, VideoTransPara paramVideoTransPara)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_2
    //   2: ldc_w 378
    //   5: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: new 380	com/tencent/mm/compatible/h/c
    //   11: dup
    //   12: invokespecial 381	com/tencent/mm/compatible/h/c:<init>	()V
    //   15: astore 5
    //   17: aload 5
    //   19: astore 4
    //   21: aload 5
    //   23: aload_0
    //   24: invokevirtual 384	com/tencent/mm/compatible/h/c:vT	(Ljava/lang/String;)V
    //   27: aload 5
    //   29: astore 4
    //   31: aload 5
    //   33: getfield 388	com/tencent/mm/compatible/h/c:gga	Landroid/media/MediaExtractor;
    //   36: invokevirtual 393	android/media/MediaExtractor:getTrackCount	()I
    //   39: istore_3
    //   40: iload_2
    //   41: iload_3
    //   42: if_icmpge +140 -> 182
    //   45: aload 5
    //   47: astore 4
    //   49: aload 5
    //   51: iload_2
    //   52: invokevirtual 397	com/tencent/mm/compatible/h/c:getTrackFormat	(I)Landroid/media/MediaFormat;
    //   55: astore 6
    //   57: aload 5
    //   59: astore 4
    //   61: aload 6
    //   63: ldc_w 399
    //   66: invokevirtual 404	android/media/MediaFormat:containsKey	(Ljava/lang/String;)Z
    //   69: ifeq +128 -> 197
    //   72: aload 5
    //   74: astore 4
    //   76: aload 6
    //   78: ldc_w 399
    //   81: invokevirtual 408	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   84: invokestatic 411	com/tencent/mm/sdk/platformtools/bu:isNullOrNil	(Ljava/lang/String;)Z
    //   87: ifne +110 -> 197
    //   90: aload 5
    //   92: astore 4
    //   94: aload 6
    //   96: ldc_w 399
    //   99: invokevirtual 408	android/media/MediaFormat:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   102: astore 7
    //   104: aload 5
    //   106: astore 4
    //   108: ldc 22
    //   110: ldc_w 413
    //   113: iconst_1
    //   114: anewarray 4	java/lang/Object
    //   117: dup
    //   118: iconst_0
    //   119: aload 7
    //   121: aastore
    //   122: invokestatic 35	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   125: aload 5
    //   127: astore 4
    //   129: aload 7
    //   131: ldc_w 415
    //   134: invokevirtual 420	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   137: ifeq +60 -> 197
    //   140: aload 5
    //   142: astore 4
    //   144: aload_1
    //   145: aload 6
    //   147: ldc_w 422
    //   150: invokevirtual 425	android/media/MediaFormat:getInteger	(Ljava/lang/String;)I
    //   153: putfield 180	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   156: aload 5
    //   158: astore 4
    //   160: ldc 22
    //   162: ldc_w 427
    //   165: iconst_1
    //   166: anewarray 4	java/lang/Object
    //   169: dup
    //   170: iconst_0
    //   171: aload_1
    //   172: getfield 180	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   175: invokestatic 30	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   178: aastore
    //   179: invokestatic 35	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   182: aload 5
    //   184: getfield 388	com/tencent/mm/compatible/h/c:gga	Landroid/media/MediaExtractor;
    //   187: invokevirtual 428	android/media/MediaExtractor:release	()V
    //   190: ldc_w 378
    //   193: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   196: return
    //   197: iload_2
    //   198: iconst_1
    //   199: iadd
    //   200: istore_2
    //   201: goto -161 -> 40
    //   204: astore 6
    //   206: aconst_null
    //   207: astore 5
    //   209: aload 5
    //   211: astore 4
    //   213: ldc 22
    //   215: aload 6
    //   217: ldc_w 430
    //   220: iconst_0
    //   221: anewarray 4	java/lang/Object
    //   224: invokestatic 216	com/tencent/mm/sdk/platformtools/ae:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   227: aload 5
    //   229: astore 4
    //   231: aload_0
    //   232: invokestatic 306	com/tencent/mm/plugin/sight/base/e:ayN	(Ljava/lang/String;)Lcom/tencent/mm/plugin/sight/base/a;
    //   235: astore_0
    //   236: aload_0
    //   237: ifnull +41 -> 278
    //   240: aload 5
    //   242: astore 4
    //   244: aload_1
    //   245: aload_0
    //   246: getfield 311	com/tencent/mm/plugin/sight/base/a:frameRate	I
    //   249: putfield 180	com/tencent/mm/modelcontrol/VideoTransPara:fps	I
    //   252: aload 5
    //   254: astore 4
    //   256: ldc 22
    //   258: ldc_w 432
    //   261: iconst_1
    //   262: anewarray 4	java/lang/Object
    //   265: dup
    //   266: iconst_0
    //   267: aload_0
    //   268: getfield 311	com/tencent/mm/plugin/sight/base/a:frameRate	I
    //   271: invokestatic 30	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   274: aastore
    //   275: invokestatic 35	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   278: aload 5
    //   280: ifnull +43 -> 323
    //   283: aload 5
    //   285: getfield 388	com/tencent/mm/compatible/h/c:gga	Landroid/media/MediaExtractor;
    //   288: invokevirtual 428	android/media/MediaExtractor:release	()V
    //   291: ldc_w 378
    //   294: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   297: return
    //   298: astore_0
    //   299: aconst_null
    //   300: astore 4
    //   302: aload 4
    //   304: ifnull +11 -> 315
    //   307: aload 4
    //   309: getfield 388	com/tencent/mm/compatible/h/c:gga	Landroid/media/MediaExtractor;
    //   312: invokevirtual 428	android/media/MediaExtractor:release	()V
    //   315: ldc_w 378
    //   318: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   321: aload_0
    //   322: athrow
    //   323: ldc_w 378
    //   326: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   329: return
    //   330: astore_0
    //   331: goto -29 -> 302
    //   334: astore 6
    //   336: goto -127 -> 209
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	339	0	paramString	String
    //   0	339	1	paramVideoTransPara	VideoTransPara
    //   1	200	2	i	int
    //   39	4	3	j	int
    //   19	289	4	localc1	com.tencent.mm.compatible.h.c
    //   15	269	5	localc2	com.tencent.mm.compatible.h.c
    //   55	91	6	localMediaFormat	android.media.MediaFormat
    //   204	12	6	localException1	Exception
    //   334	1	6	localException2	Exception
    //   102	28	7	str	String
    // Exception table:
    //   from	to	target	type
    //   8	17	204	java/lang/Exception
    //   8	17	298	finally
    //   21	27	330	finally
    //   31	40	330	finally
    //   49	57	330	finally
    //   61	72	330	finally
    //   76	90	330	finally
    //   94	104	330	finally
    //   108	125	330	finally
    //   129	140	330	finally
    //   144	156	330	finally
    //   160	182	330	finally
    //   213	227	330	finally
    //   231	236	330	finally
    //   244	252	330	finally
    //   256	278	330	finally
    //   21	27	334	java/lang/Exception
    //   31	40	334	java/lang/Exception
    //   49	57	334	java/lang/Exception
    //   61	72	334	java/lang/Exception
    //   76	90	334	java/lang/Exception
    //   94	104	334	java/lang/Exception
    //   108	125	334	java/lang/Exception
    //   129	140	334	java/lang/Exception
    //   144	156	334	java/lang/Exception
    //   160	182	334	java/lang/Exception
  }
  
  static void a(String paramString1, String paramString2, VideoTransPara paramVideoTransPara, long paramLong)
  {
    AppMethodBeat.i(127097);
    com.tencent.mm.sdk.platformtools.ae.m("MicroMsg.TransferUtil", "fallbackTransferWithVideoTransfer, srcPath:%s, dstPath:%s, newPara:%s", new Object[] { paramString1, paramString2, paramVideoTransPara });
    g localg = new g();
    localg.c(paramString1, paramString2, paramVideoTransPara);
    localg.iyt = true;
    localg.iyu = true;
    int i = localg.sG(gu(paramString1));
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.TransferUtil", "fallbackTransferWithVideoTransfer, finish, segRet:%s", new Object[] { Integer.valueOf(i) });
    B(i, paramLong);
    AppMethodBeat.o(127097);
  }
  
  private static void b(String paramString, VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(217497);
    if (paramVideoTransPara == null)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.TransferUtil", "checkRemuxResult newPara == null");
      AppMethodBeat.o(217497);
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.TransferUtil", "checkRemuxResult path is empty, destPath:[%s]", new Object[] { paramString });
      AppMethodBeat.o(217497);
      return;
    }
    Object localObject = new PInt();
    PInt localPInt1 = new PInt();
    PInt localPInt2 = new PInt();
    PInt localPInt3 = new PInt();
    PInt localPInt4 = new PInt();
    com.tencent.mm.plugin.sight.base.e.a(paramString, (PInt)localObject, localPInt1, localPInt2, localPInt3, localPInt4);
    float f = bu.getFloat(((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.zero.b.a.class)).acL().getValue("MMSightCheckSendVideoBitrateLimit"), 1.3F);
    int i = localPInt4.value;
    int j = paramVideoTransPara.videoBitrate;
    if (i < f * j)
    {
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.TransferUtil", "checkRemuxResult success currentBitrate:[%d], maxBitrate:[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
      AppMethodBeat.o(217497);
      return;
    }
    long l = System.currentTimeMillis();
    com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.TransferUtil", "checkRemuxResult fail currentBitrate:[%d], maxBitrate:[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(j) });
    localObject = paramString + ".check_temp";
    o.mF(paramString, (String)localObject);
    o.deleteFile(paramString);
    i = SightVideoJNI.remuxingVFS((String)localObject, paramString, paramVideoTransPara.width, paramVideoTransPara.height, paramVideoTransPara.videoBitrate, paramVideoTransPara.hXX, 8, paramVideoTransPara.hXW, 25.0F, paramVideoTransPara.fps, null, 0, false, 0, 51);
    com.tencent.mm.plugin.report.service.g.yxI.n(986L, 119L, 1L);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.TransferUtil", "checkRemuxResult speedTime:[%s], remuxingVFS ret:[%d]", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(i) });
    AppMethodBeat.o(217497);
  }
  
  static void b(String paramString1, String paramString2, VideoTransPara paramVideoTransPara)
  {
    AppMethodBeat.i(217496);
    b(paramString2, paramVideoTransPara);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.TransferUtil", "tranferToH264 result \nsrcPath:[%s], srcPathVal:[%s], \ndstPath:[%s], dstPathVal:[%s]", new Object[] { paramString1, com.tencent.mm.plugin.sight.base.e.arR(paramString1), paramString2, com.tencent.mm.plugin.sight.base.e.arR(paramString2) });
    AppMethodBeat.o(217496);
  }
  
  public static int gu(String paramString)
  {
    AppMethodBeat.i(127095);
    com.tencent.mm.compatible.h.d locald = new com.tencent.mm.compatible.h.d();
    locald.setDataSource(paramString);
    paramString = locald.extractMetadata(9);
    locald.release();
    if (paramString == null)
    {
      AppMethodBeat.o(127095);
      return 0;
    }
    try
    {
      int i = Integer.valueOf(paramString).intValue();
      AppMethodBeat.o(127095);
      return i;
    }
    catch (Exception paramString)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.TransferUtil", "getDuration error %s", new Object[] { paramString.getMessage() });
      AppMethodBeat.o(127095);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.bk.e
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.liteav.videodecoder;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.view.Surface;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;

public class f
  implements b
{
  private MediaCodec.BufferInfo a;
  private MediaCodec b;
  private String c;
  private int d;
  private int e;
  private long f;
  private long g;
  private boolean h;
  private boolean i;
  private boolean j;
  private Surface k;
  private int l;
  private ArrayList<TXSNALPacket> m;
  private ArrayList<Long> n;
  private long o;
  private int p;
  private JSONArray q;
  private g r;
  private d s;
  private boolean t;
  private WeakReference<com.tencent.liteav.basic.c.b> u;
  
  public f()
  {
    AppMethodBeat.i(230315);
    this.a = new MediaCodec.BufferInfo();
    this.b = null;
    this.c = "video/avc";
    this.d = 540;
    this.e = 960;
    this.f = 0L;
    this.g = 0L;
    this.h = true;
    this.i = false;
    this.j = false;
    this.k = null;
    this.l = 0;
    this.m = new ArrayList();
    this.n = new ArrayList();
    this.o = 0L;
    this.p = 0;
    this.q = null;
    this.s = new d();
    this.t = false;
    AppMethodBeat.o(230315);
  }
  
  /* Error */
  private int a(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, boolean paramBoolean)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore 6
    //   3: iconst_m1
    //   4: istore 5
    //   6: iconst_0
    //   7: istore 7
    //   9: ldc 110
    //   11: invokestatic 54	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   14: aload_0
    //   15: getfield 61	com/tencent/liteav/videodecoder/f:b	Landroid/media/MediaCodec;
    //   18: astore 8
    //   20: aload 8
    //   22: ifnonnull +10 -> 32
    //   25: aload_0
    //   26: getfield 81	com/tencent/liteav/videodecoder/f:k	Landroid/view/Surface;
    //   29: ifnonnull +44 -> 73
    //   32: ldc 112
    //   34: new 114	java/lang/StringBuilder
    //   37: dup
    //   38: ldc 116
    //   40: invokespecial 119	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   43: aload 8
    //   45: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   48: ldc 125
    //   50: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: aload_0
    //   54: getfield 81	com/tencent/liteav/videodecoder/f:k	Landroid/view/Surface;
    //   57: invokevirtual 123	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   60: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   63: invokestatic 137	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: ldc 110
    //   68: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: iconst_m1
    //   72: ireturn
    //   73: aload_0
    //   74: iload_3
    //   75: putfield 79	com/tencent/liteav/videodecoder/f:j	Z
    //   78: aload_0
    //   79: getfield 79	com/tencent/liteav/videodecoder/f:j	Z
    //   82: ifeq +104 -> 186
    //   85: aload_0
    //   86: ldc 139
    //   88: putfield 65	com/tencent/liteav/videodecoder/f:c	Ljava/lang/String;
    //   91: aload_0
    //   92: getfield 65	com/tencent/liteav/videodecoder/f:c	Ljava/lang/String;
    //   95: aload_0
    //   96: getfield 67	com/tencent/liteav/videodecoder/f:d	I
    //   99: aload_0
    //   100: getfield 69	com/tencent/liteav/videodecoder/f:e	I
    //   103: invokestatic 145	android/media/MediaFormat:createVideoFormat	(Ljava/lang/String;II)Landroid/media/MediaFormat;
    //   106: astore 9
    //   108: aload_1
    //   109: ifnull +11 -> 120
    //   112: aload 9
    //   114: ldc 147
    //   116: aload_1
    //   117: invokevirtual 151	android/media/MediaFormat:setByteBuffer	(Ljava/lang/String;Ljava/nio/ByteBuffer;)V
    //   120: aload_2
    //   121: ifnull +11 -> 132
    //   124: aload 9
    //   126: ldc 153
    //   128: aload_2
    //   129: invokevirtual 151	android/media/MediaFormat:setByteBuffer	(Ljava/lang/String;Ljava/nio/ByteBuffer;)V
    //   132: aload_0
    //   133: getfield 96	com/tencent/liteav/videodecoder/f:q	Lorg/json/JSONArray;
    //   136: astore_1
    //   137: aload_1
    //   138: ifnull +150 -> 288
    //   141: iconst_0
    //   142: istore 4
    //   144: iload 4
    //   146: aload_1
    //   147: invokevirtual 159	org/json/JSONArray:length	()I
    //   150: if_icmpge +138 -> 288
    //   153: aload_1
    //   154: iload 4
    //   156: invokevirtual 163	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   159: astore_2
    //   160: aload 9
    //   162: aload_2
    //   163: ldc 165
    //   165: invokevirtual 171	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   168: aload_2
    //   169: ldc 173
    //   171: invokevirtual 177	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   174: invokevirtual 181	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   177: iload 4
    //   179: iconst_1
    //   180: iadd
    //   181: istore 4
    //   183: goto -39 -> 144
    //   186: aload_0
    //   187: ldc 63
    //   189: putfield 65	com/tencent/liteav/videodecoder/f:c	Ljava/lang/String;
    //   192: goto -101 -> 91
    //   195: astore_2
    //   196: iconst_0
    //   197: istore 4
    //   199: aload 8
    //   201: astore_1
    //   202: aload_1
    //   203: ifnull +14 -> 217
    //   206: aload_1
    //   207: invokevirtual 186	android/media/MediaCodec:release	()V
    //   210: ldc 112
    //   212: ldc 188
    //   214: invokestatic 191	com/tencent/liteav/basic/log/TXCLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   217: ldc 112
    //   219: new 114	java/lang/StringBuilder
    //   222: dup
    //   223: ldc 193
    //   225: invokespecial 119	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   228: iload 4
    //   230: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   233: ldc 198
    //   235: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   238: aload_2
    //   239: invokevirtual 199	java/lang/Exception:toString	()Ljava/lang/String;
    //   242: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   248: invokestatic 137	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   251: aload_0
    //   252: invokespecial 201	com/tencent/liteav/videodecoder/f:e	()V
    //   255: ldc 110
    //   257: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   260: iload 5
    //   262: ireturn
    //   263: astore_1
    //   264: ldc 112
    //   266: new 114	java/lang/StringBuilder
    //   269: dup
    //   270: ldc 203
    //   272: invokespecial 119	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   275: aload_1
    //   276: invokevirtual 199	java/lang/Exception:toString	()Ljava/lang/String;
    //   279: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   285: invokestatic 191	com/tencent/liteav/basic/log/TXCLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   288: getstatic 208	android/os/Build$VERSION:SDK_INT	I
    //   291: bipush 21
    //   293: if_icmplt +212 -> 505
    //   296: aload_0
    //   297: getfield 79	com/tencent/liteav/videodecoder/f:j	Z
    //   300: ifeq +205 -> 505
    //   303: new 210	android/media/MediaCodecList
    //   306: dup
    //   307: iconst_1
    //   308: invokespecial 212	android/media/MediaCodecList:<init>	(I)V
    //   311: aload 9
    //   313: invokevirtual 216	android/media/MediaCodecList:findDecoderForFormat	(Landroid/media/MediaFormat;)Ljava/lang/String;
    //   316: astore_1
    //   317: ldc 112
    //   319: new 114	java/lang/StringBuilder
    //   322: dup
    //   323: ldc 218
    //   325: invokespecial 119	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   328: aload_1
    //   329: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   332: ldc 220
    //   334: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: aload 9
    //   339: invokevirtual 221	android/media/MediaFormat:toString	()Ljava/lang/String;
    //   342: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   345: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   348: invokestatic 223	com/tencent/liteav/basic/log/TXCLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   351: aload_1
    //   352: ifnull +135 -> 487
    //   355: aload_1
    //   356: invokestatic 227	android/media/MediaCodec:createByCodecName	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   359: astore_1
    //   360: iload 6
    //   362: istore 4
    //   364: aload_1
    //   365: aload 9
    //   367: aload_0
    //   368: getfield 81	com/tencent/liteav/videodecoder/f:k	Landroid/view/Surface;
    //   371: aconst_null
    //   372: iconst_0
    //   373: invokevirtual 231	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   376: iconst_2
    //   377: istore 4
    //   379: aload_1
    //   380: iconst_1
    //   381: invokevirtual 234	android/media/MediaCodec:setVideoScalingMode	(I)V
    //   384: iconst_3
    //   385: istore 4
    //   387: aload_1
    //   388: invokevirtual 237	android/media/MediaCodec:start	()V
    //   391: iconst_4
    //   392: istore 6
    //   394: iload 6
    //   396: istore 4
    //   398: ldc 112
    //   400: new 114	java/lang/StringBuilder
    //   403: dup
    //   404: ldc 239
    //   406: invokespecial 119	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   409: aload_0
    //   410: getfield 79	com/tencent/liteav/videodecoder/f:j	Z
    //   413: invokevirtual 242	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   416: ldc 244
    //   418: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   421: aload_0
    //   422: getfield 67	com/tencent/liteav/videodecoder/f:d	I
    //   425: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   428: ldc 246
    //   430: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: aload_0
    //   434: getfield 69	com/tencent/liteav/videodecoder/f:e	I
    //   437: invokevirtual 196	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   440: ldc 248
    //   442: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: aload 9
    //   447: invokevirtual 221	android/media/MediaFormat:toString	()Ljava/lang/String;
    //   450: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   456: invokestatic 191	com/tencent/liteav/basic/log/TXCLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   459: aload_0
    //   460: aload_1
    //   461: putfield 61	com/tencent/liteav/videodecoder/f:b	Landroid/media/MediaCodec;
    //   464: aload_0
    //   465: iconst_0
    //   466: putfield 83	com/tencent/liteav/videodecoder/f:l	I
    //   469: iload 7
    //   471: istore 5
    //   473: goto -218 -> 255
    //   476: astore_2
    //   477: iconst_0
    //   478: istore 5
    //   480: iload 6
    //   482: istore 4
    //   484: goto -282 -> 202
    //   487: ldc 112
    //   489: ldc 250
    //   491: invokestatic 137	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   494: aload_0
    //   495: invokespecial 201	com/tencent/liteav/videodecoder/f:e	()V
    //   498: ldc 110
    //   500: invokestatic 105	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   503: iconst_m1
    //   504: ireturn
    //   505: aload_0
    //   506: getfield 65	com/tencent/liteav/videodecoder/f:c	Ljava/lang/String;
    //   509: invokestatic 253	android/media/MediaCodec:createDecoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   512: astore_1
    //   513: goto -153 -> 360
    //   516: astore_1
    //   517: ldc 112
    //   519: new 114	java/lang/StringBuilder
    //   522: dup
    //   523: ldc 255
    //   525: invokespecial 119	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   528: aload_2
    //   529: invokevirtual 199	java/lang/Exception:toString	()Ljava/lang/String;
    //   532: invokevirtual 128	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   535: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   538: invokestatic 137	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   541: goto -324 -> 217
    //   544: astore_2
    //   545: goto -343 -> 202
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	548	0	this	f
    //   0	548	1	paramByteBuffer1	ByteBuffer
    //   0	548	2	paramByteBuffer2	ByteBuffer
    //   0	548	3	paramBoolean	boolean
    //   142	341	4	i1	int
    //   4	475	5	i2	int
    //   1	480	6	i3	int
    //   7	463	7	i4	int
    //   18	182	8	localMediaCodec	MediaCodec
    //   106	340	9	localMediaFormat	MediaFormat
    // Exception table:
    //   from	to	target	type
    //   25	32	195	java/lang/Exception
    //   32	66	195	java/lang/Exception
    //   73	91	195	java/lang/Exception
    //   91	108	195	java/lang/Exception
    //   112	120	195	java/lang/Exception
    //   124	132	195	java/lang/Exception
    //   132	137	195	java/lang/Exception
    //   186	192	195	java/lang/Exception
    //   264	288	195	java/lang/Exception
    //   288	351	195	java/lang/Exception
    //   355	360	195	java/lang/Exception
    //   487	498	195	java/lang/Exception
    //   505	513	195	java/lang/Exception
    //   144	177	263	java/lang/Exception
    //   459	469	476	java/lang/Exception
    //   206	217	516	java/lang/Exception
    //   364	376	544	java/lang/Exception
    //   379	384	544	java/lang/Exception
    //   387	391	544	java/lang/Exception
    //   398	459	544	java/lang/Exception
  }
  
  private void a()
  {
    AppMethodBeat.i(230338);
    final MediaCodec localMediaCodec = this.b;
    this.b = null;
    if (localMediaCodec != null) {
      new Thread(null, new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(230744);
          TXCLog.i("MediaCodecDecoder", "release decoder:" + localMediaCodec.hashCode() + " in thread:" + Thread.currentThread().getId());
          for (;;)
          {
            try
            {
              localMediaCodec.stop();
              TXCLog.i("MediaCodecDecoder", "decode: stop decoder sucess");
            }
            catch (Exception localException2)
            {
              localException2 = localException2;
              TXCLog.e("MediaCodecDecoder", "decode: stop decoder Exception: " + localException2.toString());
              try
              {
                localMediaCodec.release();
                TXCLog.i("MediaCodecDecoder", "decode: release decoder sucess");
              }
              catch (Exception localException3)
              {
                TXCLog.e("MediaCodecDecoder", "decode: release decoder exception: " + localException3.toString());
              }
              continue;
            }
            finally {}
            try
            {
              localMediaCodec.release();
              TXCLog.i("MediaCodecDecoder", "decode: release decoder sucess");
              TXCLog.i("MediaCodecDecoder", "release decoder:" + localMediaCodec.hashCode() + " finish.");
              AppMethodBeat.o(230744);
              return;
            }
            catch (Exception localException1)
            {
              TXCLog.e("MediaCodecDecoder", "decode: release decoder exception: " + localException1.toString());
            }
          }
          try
          {
            localMediaCodec.release();
            TXCLog.i("MediaCodecDecoder", "decode: release decoder sucess");
            AppMethodBeat.o(230744);
            throw localObject;
          }
          catch (Exception localException4)
          {
            for (;;)
            {
              TXCLog.e("MediaCodecDecoder", "decode: release decoder exception: " + localException4.toString());
            }
          }
        }
      }, "DecoderReleaseThread-" + localMediaCodec.hashCode()).start();
    }
    this.m.clear();
    this.f = 0L;
    this.h = true;
    this.i = false;
    AppMethodBeat.o(230338);
  }
  
  private void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    AppMethodBeat.i(230345);
    MediaCodec localMediaCodec = this.b;
    if (localMediaCodec != null) {}
    try
    {
      localMediaCodec.releaseOutputBuffer(paramInt1, true);
      if ((this.a.flags & 0x4) != 0) {
        TXCLog.i("MediaCodecDecoder", "output EOS");
      }
    }
    catch (Exception localException1)
    {
      try
      {
        if (this.r != null) {
          this.r.onDecodeFrame(null, this.d, this.e, paramLong1, paramLong2, paramInt2);
        }
        d();
        AppMethodBeat.o(230345);
        return;
        localException1 = localException1;
        TXCLog.e("MediaCodecDecoder", "decode: releaseOutputBuffer exception!!", localException1);
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          TXCLog.e("MediaCodecDecoder", "onDecodeFrame failed.", localException2);
        }
      }
    }
  }
  
  private void a(TXSNALPacket paramTXSNALPacket)
  {
    int i2 = 0;
    AppMethodBeat.i(230355);
    if (!this.t)
    {
      AppMethodBeat.o(230355);
      return;
    }
    int i3;
    int i1;
    if (paramTXSNALPacket.nalType == 0)
    {
      i3 = -1;
      i1 = i3;
    }
    for (;;)
    {
      try
      {
        if (i2 < paramTXSNALPacket.nalData.length)
        {
          if ((paramTXSNALPacket.nalData[i2] == 0) && (paramTXSNALPacket.nalData[(i2 + 1)] == 0) && (paramTXSNALPacket.nalData[(i2 + 2)] == 0) && (paramTXSNALPacket.nalData[(i2 + 3)] == 1) && ((paramTXSNALPacket.nalData[(i2 + 4)] & 0x1F) == 7)) {
            i1 = i2 + 4;
          }
        }
        else
        {
          if (i1 >= 0)
          {
            int i4 = paramTXSNALPacket.nalData.length - i1;
            i2 = i1;
            i3 = i4;
            if (i2 < paramTXSNALPacket.nalData.length)
            {
              if ((paramTXSNALPacket.nalData[i2] == 0) && (paramTXSNALPacket.nalData[(i2 + 1)] == 0) && (paramTXSNALPacket.nalData[(i2 + 2)] == 1)) {
                break label422;
              }
              if ((paramTXSNALPacket.nalData[i2] != 0) || (paramTXSNALPacket.nalData[(i2 + 1)] != 0) || (paramTXSNALPacket.nalData[(i2 + 2)] != 0) || (paramTXSNALPacket.nalData[(i2 + 3)] != 1)) {
                continue;
              }
              break label422;
            }
            byte[] arrayOfByte1 = new byte[i3];
            System.arraycopy(paramTXSNALPacket.nalData, i1, arrayOfByte1, 0, i3);
            arrayOfByte1 = this.s.a(arrayOfByte1);
            if (arrayOfByte1 != null)
            {
              byte[] arrayOfByte2 = new byte[paramTXSNALPacket.nalData.length + arrayOfByte1.length - i3];
              if (i1 > 0) {
                System.arraycopy(paramTXSNALPacket.nalData, 0, arrayOfByte2, 0, i1);
              }
              System.arraycopy(arrayOfByte1, 0, arrayOfByte2, i1, arrayOfByte1.length);
              System.arraycopy(paramTXSNALPacket.nalData, i1 + i3, arrayOfByte2, arrayOfByte1.length + i1, paramTXSNALPacket.nalData.length - i3 - i1);
              paramTXSNALPacket.nalData = arrayOfByte2;
            }
          }
          AppMethodBeat.o(230355);
          return;
        }
        if ((paramTXSNALPacket.nalData[i2] == 0) && (paramTXSNALPacket.nalData[(i2 + 1)] == 0) && (paramTXSNALPacket.nalData[(i2 + 2)] == 0))
        {
          i1 = paramTXSNALPacket.nalData[(i2 + 3)];
          if ((i1 & 0x1F) == 7)
          {
            i1 = i2 + 3;
            continue;
          }
        }
        i2 = i2 + 1 + 1;
        break;
        i2 += 1;
        continue;
        AppMethodBeat.o(230355);
      }
      catch (Exception paramTXSNALPacket)
      {
        TXCLog.e("MediaCodecDecoder", "modify dec buffer error ", paramTXSNALPacket);
      }
      return;
      label422:
      i3 = i2 - i1;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    AppMethodBeat.i(230353);
    if (this.j != paramBoolean)
    {
      StringBuilder localStringBuilder = new StringBuilder("[Video][Decoder] nal data format changed, from:");
      if (this.j)
      {
        str = "h265";
        localStringBuilder = localStringBuilder.append(str).append(" to:");
        if (!paramBoolean) {
          break label119;
        }
      }
      label119:
      for (String str = "h265";; str = "h264")
      {
        TXCLog.i("MediaCodecDecoder", str);
        this.j = paramBoolean;
        if ((!this.j) || (e.b(this.d, this.e, 20))) {
          break label126;
        }
        a();
        e();
        AppMethodBeat.o(230353);
        return;
        str = "h264";
        break;
      }
      label126:
      a();
      a(null, null, this.j);
      if (this.r != null) {
        this.r.onDecoderChange(this.c, this.j);
      }
    }
    AppMethodBeat.o(230353);
  }
  
  @TargetApi(16)
  private void b()
  {
    AppMethodBeat.i(230344);
    localMediaCodec = this.b;
    if (localMediaCodec == null)
    {
      TXCLog.e("MediaCodecDecoder", "null decoder");
      AppMethodBeat.o(230344);
      return;
    }
    localObject = (TXSNALPacket)this.m.get(0);
    if ((localObject == null) || (((TXSNALPacket)localObject).nalData.length == 0))
    {
      TXCLog.e("MediaCodecDecoder", "decode: empty buffer");
      this.m.remove(0);
      AppMethodBeat.o(230344);
      return;
    }
    l1 = TXCTimeUtil.getTimeTick();
    if (this.o == 0L) {
      this.o = l1;
    }
    try
    {
      ByteBuffer[] arrayOfByteBuffer = localMediaCodec.getInputBuffers();
      if ((arrayOfByteBuffer == null) || (arrayOfByteBuffer.length == 0))
      {
        TXCLog.e("MediaCodecDecoder", "decode: getInputBuffers failed");
        AppMethodBeat.o(230344);
        return;
      }
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        TXCLog.e("MediaCodecDecoder", "decode: getInputBuffers Exception!! " + localException1.toString());
        localIterator = null;
      }
      i1 = -10000;
    }
    try
    {
      i2 = localMediaCodec.dequeueInputBuffer(10000L);
      i1 = i2;
    }
    catch (Exception localException4)
    {
      for (;;)
      {
        try
        {
          int i2;
          localMediaCodec.queueInputBuffer(i1, 0, ((TXSNALPacket)localObject).nalData.length, TimeUnit.MILLISECONDS.toMicros(((TXSNALPacket)localObject).pts), 0);
          this.m.remove(0);
          if (this.f == 0L) {
            TXCLog.w("MediaCodecDecoder", "decode: input buffer available, dequeueInputBuffer index: ".concat(String.valueOf(i1)));
          }
          i1 = -10000;
          try
          {
            i2 = localMediaCodec.dequeueOutputBuffer(this.a, 10000L);
            i1 = i2;
          }
          catch (Exception localException3)
          {
            long l2;
            f();
            TXCLog.e("MediaCodecDecoder", "decode: dequeueOutputBuffer exception!!".concat(String.valueOf(localException3)));
            continue;
            if (i1 != -1) {
              break label520;
            }
            try
            {
              Thread.sleep(10L);
              TXCLog.i("MediaCodecDecoder", "decode: no output from decoder available when timeout fail count " + this.l);
              f();
              continue;
              if (i1 == -3)
              {
                TXCLog.i("MediaCodecDecoder", "decode: output buffers changed");
                continue;
              }
              if (i1 == -2)
              {
                c();
                continue;
              }
              TXCLog.e("MediaCodecDecoder", "decode: unexpected result from decoder.dequeueOutputBuffer: ".concat(String.valueOf(i1)));
              continue;
              this.n.clear();
              this.o = l2;
              this.p = ((int)(3L * l1));
              AppMethodBeat.o(230344);
              return;
            }
            catch (InterruptedException localInterruptedException)
            {
              break label488;
            }
            continue;
          }
          if (i1 < 0) {
            break;
          }
          l2 = TimeUnit.MICROSECONDS.toMillis(this.a.presentationTimeUs);
          a(i1, l2, l2, ((TXSNALPacket)localObject).rotation);
          this.l = 0;
          l2 = TXCTimeUtil.getTimeTick();
          this.n.add(Long.valueOf(l2 - l1));
          if (l2 <= this.o + 1000L) {
            break label591;
          }
          l1 = 0L;
          localIterator = this.n.iterator();
          if (!localIterator.hasNext()) {
            break label568;
          }
          localObject = (Long)localIterator.next();
          if (((Long)localObject).longValue() <= l1) {
            break label603;
          }
          l1 = ((Long)localObject).longValue();
          continue;
          localException4 = localException4;
          TXCLog.e("MediaCodecDecoder", "decode: dequeueInputBuffer Exception!! " + localException4.toString());
        }
        catch (Exception localException2)
        {
          f();
          continue;
        }
        TXCLog.w("MediaCodecDecoder", "decode: input buffer not available, dequeueInputBuffer failed");
      }
    }
    if (i1 >= 0) {
      localIterator[i1].put(((TXSNALPacket)localObject).nalData);
    }
  }
  
  private void c()
  {
    AppMethodBeat.i(230348);
    MediaCodec localMediaCodec = this.b;
    Object localObject3 = null;
    Object localObject1 = localObject3;
    if (localMediaCodec != null) {}
    try
    {
      localObject1 = localMediaCodec.getOutputFormat();
      if (localObject1 == null)
      {
        TXCLog.e("MediaCodecDecoder", "get decoder's format failed.");
        AppMethodBeat.o(230348);
        return;
      }
    }
    catch (Exception localException1)
    {
      Object localObject2;
      for (;;)
      {
        TXCLog.e("MediaCodecDecoder", "get decoder's format failed.", localException1);
        localObject2 = localObject3;
      }
      TXCLog.i("MediaCodecDecoder", "decode output format changed: ".concat(String.valueOf(localObject2)));
      int i3 = Math.abs(localObject2.getInteger("crop-right") - localObject2.getInteger("crop-left"));
      int i1 = Math.abs(localObject2.getInteger("crop-bottom") - localObject2.getInteger("crop-top"));
      int i4 = localObject2.getInteger("width");
      int i2 = localObject2.getInteger("height");
      i3 = Math.min(i3 + 1, i4);
      i1 = Math.min(i1 + 1, i2);
      if ((i3 != this.d) || (i1 != this.e))
      {
        if ((this.j) && (!e.b(i3, i1, 20)))
        {
          e();
          Monitor.a(2, String.format(Locale.getDefault(), "outputFormatChange: dynamic change resolution but change to a not support resolution: %s, oldwidth = %d,oldheight = %d, newwidth = %d, newheight=", new Object[] { TXCCommonUtil.getDeviceInfo(), Integer.valueOf(this.d), Integer.valueOf(this.e), Integer.valueOf(i3), Integer.valueOf(i1) }), "", 0);
        }
        this.d = i3;
        this.e = i1;
        try
        {
          if (this.r != null) {
            this.r.onVideoSizeChange(this.d, this.e);
          }
          TXCLog.i("MediaCodecDecoder", "decode: video size change to w:" + i3 + ",h:" + i1);
          AppMethodBeat.o(230348);
          return;
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            TXCLog.e("MediaCodecDecoder", "onVideoSizeChange failed.", localException2);
          }
        }
      }
      if (this.h)
      {
        this.h = false;
        if (this.r != null) {
          this.r.onVideoSizeChange(this.d, this.e);
        }
      }
      AppMethodBeat.o(230348);
    }
  }
  
  private void d()
  {
    AppMethodBeat.i(230350);
    if (this.f == 0L) {
      TXCLog.w("MediaCodecDecoder", "decode first frame sucess");
    }
    long l1 = System.currentTimeMillis();
    if ((this.f > 0L) && (l1 > this.f + 1000L) && (l1 > this.g + 2000L) && (this.g != 0L))
    {
      TXCLog.e("MediaCodecDecoder", "frame interval[" + (l1 - this.f) + "] > 1000");
      this.g = l1;
    }
    if (this.g == 0L) {
      this.g = l1;
    }
    this.f = l1;
    AppMethodBeat.o(230350);
  }
  
  private void e()
  {
    int i2 = 1;
    AppMethodBeat.i(230351);
    int i1;
    if (!this.i)
    {
      this.i = true;
      TXCLog.e("MediaCodecDecoder", "[Video][Decoder] notify HWDecoder error, isH265:" + this.j);
      if (!this.j) {
        break label176;
      }
      h.a(this.u, -2304, "h265 Decoding failed");
      Locale localLocale = Locale.getDefault();
      String str = TXCCommonUtil.getDeviceInfo();
      if (!e.b(1920, 1080, 20)) {
        break label166;
      }
      i1 = 1;
      if (!e.a(1920, 1080, 20)) {
        break label171;
      }
      label104:
      Monitor.a(2, String.format(localLocale, "VideoDecoder: hevc hardware decoder error. %s, %d, %d", new Object[] { str, Integer.valueOf(i1), Integer.valueOf(i2) }), "", 0);
    }
    for (;;)
    {
      if (this.r != null) {
        this.r.onDecodeFailed(-1);
      }
      AppMethodBeat.o(230351);
      return;
      label166:
      i1 = 0;
      break;
      label171:
      i2 = 0;
      break label104;
      label176:
      h.a(this.u, 2106, "Failed to enable hardware decoding，use software decoding.");
    }
  }
  
  private void f()
  {
    AppMethodBeat.i(230352);
    if (this.l >= 40)
    {
      e();
      this.l = 0;
      AppMethodBeat.o(230352);
      return;
    }
    this.l += 1;
    AppMethodBeat.o(230352);
  }
  
  public int GetDecodeCost()
  {
    return this.p;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(230335);
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      this.d = paramInt1;
      this.e = paramInt2;
      TXCLog.w("MediaCodecDecoder", "decode: init with video size: " + this.d + ", " + this.e);
    }
    AppMethodBeat.o(230335);
  }
  
  public void a(JSONArray paramJSONArray)
  {
    this.q = paramJSONArray;
  }
  
  public int config(Surface paramSurface)
  {
    if (paramSurface == null) {
      return -1;
    }
    this.k = paramSurface;
    return 0;
  }
  
  public void decode(TXSNALPacket paramTXSNALPacket)
  {
    boolean bool = true;
    AppMethodBeat.i(230326);
    if (paramTXSNALPacket.codecId == 1) {}
    for (;;)
    {
      a(bool);
      if (paramTXSNALPacket.codecId == 0) {
        a(paramTXSNALPacket);
      }
      this.m.add(paramTXSNALPacket);
      label42:
      int i1;
      if (!this.m.isEmpty()) {
        i1 = this.m.size();
      }
      try
      {
        b();
        if (i1 != this.m.size()) {
          break label42;
        }
        AppMethodBeat.o(230326);
        return;
        bool = false;
      }
      catch (Exception paramTXSNALPacket)
      {
        for (;;)
        {
          TXCLog.e("MediaCodecDecoder", "decode: doDecode Exception!! " + paramTXSNALPacket.toString());
        }
      }
    }
  }
  
  public void enableLimitDecCache(boolean paramBoolean)
  {
    AppMethodBeat.i(230333);
    this.t = paramBoolean;
    TXCLog.i("MediaCodecDecoder", "decode: enable limit dec cache: ".concat(String.valueOf(paramBoolean)));
    AppMethodBeat.o(230333);
  }
  
  public void setListener(g paramg)
  {
    this.r = paramg;
  }
  
  public void setNotifyListener(WeakReference<com.tencent.liteav.basic.c.b> paramWeakReference)
  {
    this.u = paramWeakReference;
  }
  
  public int start(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(230329);
    int i1 = a(paramByteBuffer1, paramByteBuffer2, paramBoolean2);
    AppMethodBeat.o(230329);
    return i1;
  }
  
  public void stop()
  {
    AppMethodBeat.i(230330);
    a();
    AppMethodBeat.o(230330);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.videodecoder.f
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.liteav.videodecoder;

import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import android.view.Surface;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.util.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.json.JSONArray;

public class b
  implements a
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
  private c r;
  private WeakReference<com.tencent.liteav.basic.c.a> s;
  
  public b()
  {
    AppMethodBeat.i(16647);
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
    AppMethodBeat.o(16647);
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
    //   9: sipush 16652
    //   12: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   15: aload_0
    //   16: getfield 55	com/tencent/liteav/videodecoder/b:b	Landroid/media/MediaCodec;
    //   19: ifnonnull +10 -> 29
    //   22: aload_0
    //   23: getfield 75	com/tencent/liteav/videodecoder/b:k	Landroid/view/Surface;
    //   26: ifnonnull +47 -> 73
    //   29: ldc 98
    //   31: new 100	java/lang/StringBuilder
    //   34: dup
    //   35: ldc 102
    //   37: invokespecial 105	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   40: aload_0
    //   41: getfield 55	com/tencent/liteav/videodecoder/b:b	Landroid/media/MediaCodec;
    //   44: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   47: ldc 111
    //   49: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: aload_0
    //   53: getfield 75	com/tencent/liteav/videodecoder/b:k	Landroid/view/Surface;
    //   56: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   59: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   62: invokestatic 123	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   65: sipush 16652
    //   68: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: iconst_m1
    //   72: ireturn
    //   73: aload_0
    //   74: iload_3
    //   75: putfield 73	com/tencent/liteav/videodecoder/b:j	Z
    //   78: aload_0
    //   79: getfield 73	com/tencent/liteav/videodecoder/b:j	Z
    //   82: ifeq +104 -> 186
    //   85: aload_0
    //   86: ldc 125
    //   88: putfield 59	com/tencent/liteav/videodecoder/b:c	Ljava/lang/String;
    //   91: aload_0
    //   92: getfield 59	com/tencent/liteav/videodecoder/b:c	Ljava/lang/String;
    //   95: aload_0
    //   96: getfield 61	com/tencent/liteav/videodecoder/b:d	I
    //   99: aload_0
    //   100: getfield 63	com/tencent/liteav/videodecoder/b:e	I
    //   103: invokestatic 131	android/media/MediaFormat:createVideoFormat	(Ljava/lang/String;II)Landroid/media/MediaFormat;
    //   106: astore 8
    //   108: aload_1
    //   109: ifnull +11 -> 120
    //   112: aload 8
    //   114: ldc 133
    //   116: aload_1
    //   117: invokevirtual 137	android/media/MediaFormat:setByteBuffer	(Ljava/lang/String;Ljava/nio/ByteBuffer;)V
    //   120: aload_2
    //   121: ifnull +11 -> 132
    //   124: aload 8
    //   126: ldc 139
    //   128: aload_2
    //   129: invokevirtual 137	android/media/MediaFormat:setByteBuffer	(Ljava/lang/String;Ljava/nio/ByteBuffer;)V
    //   132: aload_0
    //   133: getfield 90	com/tencent/liteav/videodecoder/b:q	Lorg/json/JSONArray;
    //   136: astore_1
    //   137: aload_1
    //   138: ifnull +159 -> 297
    //   141: iconst_0
    //   142: istore 4
    //   144: iload 4
    //   146: aload_1
    //   147: invokevirtual 145	org/json/JSONArray:length	()I
    //   150: if_icmpge +147 -> 297
    //   153: aload_1
    //   154: iload 4
    //   156: invokevirtual 149	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   159: astore_2
    //   160: aload 8
    //   162: aload_2
    //   163: ldc 151
    //   165: invokevirtual 157	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   168: aload_2
    //   169: ldc 159
    //   171: invokevirtual 163	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   174: invokevirtual 167	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   177: iload 4
    //   179: iconst_1
    //   180: iadd
    //   181: istore 4
    //   183: goto -39 -> 144
    //   186: aload_0
    //   187: ldc 57
    //   189: putfield 59	com/tencent/liteav/videodecoder/b:c	Ljava/lang/String;
    //   192: goto -101 -> 91
    //   195: astore_1
    //   196: iconst_0
    //   197: istore 4
    //   199: aload_0
    //   200: getfield 55	com/tencent/liteav/videodecoder/b:b	Landroid/media/MediaCodec;
    //   203: ifnull +22 -> 225
    //   206: aload_0
    //   207: getfield 55	com/tencent/liteav/videodecoder/b:b	Landroid/media/MediaCodec;
    //   210: invokevirtual 172	android/media/MediaCodec:release	()V
    //   213: ldc 98
    //   215: ldc 174
    //   217: invokestatic 177	com/tencent/liteav/basic/log/TXCLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   220: aload_0
    //   221: aconst_null
    //   222: putfield 55	com/tencent/liteav/videodecoder/b:b	Landroid/media/MediaCodec;
    //   225: ldc 98
    //   227: new 100	java/lang/StringBuilder
    //   230: dup
    //   231: ldc 179
    //   233: invokespecial 105	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   236: iload 4
    //   238: invokevirtual 182	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   241: ldc 184
    //   243: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: aload_1
    //   247: invokevirtual 185	java/lang/Exception:toString	()Ljava/lang/String;
    //   250: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   253: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   256: invokestatic 123	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   259: aload_0
    //   260: invokespecial 187	com/tencent/liteav/videodecoder/b:f	()V
    //   263: sipush 16652
    //   266: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   269: iload 5
    //   271: ireturn
    //   272: astore_1
    //   273: ldc 98
    //   275: new 100	java/lang/StringBuilder
    //   278: dup
    //   279: ldc 189
    //   281: invokespecial 105	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   284: aload_1
    //   285: invokevirtual 185	java/lang/Exception:toString	()Ljava/lang/String;
    //   288: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   294: invokestatic 177	com/tencent/liteav/basic/log/TXCLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   297: aload_0
    //   298: aload_0
    //   299: getfield 59	com/tencent/liteav/videodecoder/b:c	Ljava/lang/String;
    //   302: invokestatic 193	android/media/MediaCodec:createDecoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   305: putfield 55	com/tencent/liteav/videodecoder/b:b	Landroid/media/MediaCodec;
    //   308: iload 6
    //   310: istore 4
    //   312: aload_0
    //   313: getfield 55	com/tencent/liteav/videodecoder/b:b	Landroid/media/MediaCodec;
    //   316: aload 8
    //   318: aload_0
    //   319: getfield 75	com/tencent/liteav/videodecoder/b:k	Landroid/view/Surface;
    //   322: aconst_null
    //   323: iconst_0
    //   324: invokevirtual 197	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   327: iconst_2
    //   328: istore 4
    //   330: aload_0
    //   331: getfield 55	com/tencent/liteav/videodecoder/b:b	Landroid/media/MediaCodec;
    //   334: iconst_1
    //   335: invokevirtual 200	android/media/MediaCodec:setVideoScalingMode	(I)V
    //   338: iconst_3
    //   339: istore 4
    //   341: aload_0
    //   342: getfield 55	com/tencent/liteav/videodecoder/b:b	Landroid/media/MediaCodec;
    //   345: invokevirtual 203	android/media/MediaCodec:start	()V
    //   348: iconst_4
    //   349: istore 6
    //   351: iload 6
    //   353: istore 4
    //   355: ldc 98
    //   357: new 100	java/lang/StringBuilder
    //   360: dup
    //   361: ldc 205
    //   363: invokespecial 105	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   366: aload_0
    //   367: getfield 73	com/tencent/liteav/videodecoder/b:j	Z
    //   370: invokevirtual 208	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   373: ldc 210
    //   375: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: aload_0
    //   379: getfield 61	com/tencent/liteav/videodecoder/b:d	I
    //   382: invokevirtual 182	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   385: ldc 212
    //   387: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: aload_0
    //   391: getfield 63	com/tencent/liteav/videodecoder/b:e	I
    //   394: invokevirtual 182	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   397: ldc 214
    //   399: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: aload 8
    //   404: invokevirtual 215	android/media/MediaFormat:toString	()Ljava/lang/String;
    //   407: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   413: invokestatic 177	com/tencent/liteav/basic/log/TXCLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   416: aload_0
    //   417: iconst_0
    //   418: putfield 77	com/tencent/liteav/videodecoder/b:l	I
    //   421: iload 7
    //   423: istore 5
    //   425: goto -162 -> 263
    //   428: astore_1
    //   429: iconst_0
    //   430: istore 5
    //   432: iload 6
    //   434: istore 4
    //   436: goto -237 -> 199
    //   439: astore_2
    //   440: ldc 98
    //   442: new 100	java/lang/StringBuilder
    //   445: dup
    //   446: ldc 217
    //   448: invokespecial 105	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   451: aload_1
    //   452: invokevirtual 185	java/lang/Exception:toString	()Ljava/lang/String;
    //   455: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   461: invokestatic 123	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   464: aload_0
    //   465: aconst_null
    //   466: putfield 55	com/tencent/liteav/videodecoder/b:b	Landroid/media/MediaCodec;
    //   469: goto -244 -> 225
    //   472: astore_1
    //   473: aload_0
    //   474: aconst_null
    //   475: putfield 55	com/tencent/liteav/videodecoder/b:b	Landroid/media/MediaCodec;
    //   478: sipush 16652
    //   481: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   484: aload_1
    //   485: athrow
    //   486: astore_1
    //   487: goto -288 -> 199
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	490	0	this	b
    //   0	490	1	paramByteBuffer1	ByteBuffer
    //   0	490	2	paramByteBuffer2	ByteBuffer
    //   0	490	3	paramBoolean	boolean
    //   142	293	4	i1	int
    //   4	427	5	i2	int
    //   1	432	6	i3	int
    //   7	415	7	i4	int
    //   106	297	8	localMediaFormat	MediaFormat
    // Exception table:
    //   from	to	target	type
    //   15	29	195	java/lang/Exception
    //   29	65	195	java/lang/Exception
    //   73	91	195	java/lang/Exception
    //   91	108	195	java/lang/Exception
    //   112	120	195	java/lang/Exception
    //   124	132	195	java/lang/Exception
    //   132	137	195	java/lang/Exception
    //   186	192	195	java/lang/Exception
    //   273	297	195	java/lang/Exception
    //   297	308	195	java/lang/Exception
    //   144	177	272	java/lang/Exception
    //   416	421	428	java/lang/Exception
    //   206	220	439	java/lang/Exception
    //   206	220	472	finally
    //   440	464	472	finally
    //   312	327	486	java/lang/Exception
    //   330	338	486	java/lang/Exception
    //   341	348	486	java/lang/Exception
    //   355	416	486	java/lang/Exception
  }
  
  private void a()
  {
    AppMethodBeat.i(16653);
    if (this.b != null) {}
    for (;;)
    {
      try
      {
        this.b.stop();
        TXCLog.w("MediaCodecDecoder", "decode: stop decoder sucess");
      }
      catch (Exception localException2)
      {
        TXCLog.e("MediaCodecDecoder", "decode: stop decoder Exception: " + localException2.toString());
        try
        {
          this.b.release();
          TXCLog.w("MediaCodecDecoder", "decode: release decoder sucess");
          this.b = null;
          continue;
        }
        catch (Exception localException3)
        {
          TXCLog.e("MediaCodecDecoder", "decode: release decoder exception: " + localException3.toString());
          this.b = null;
          continue;
        }
        finally
        {
          this.b = null;
          AppMethodBeat.o(16653);
        }
      }
      finally
      {
        try
        {
          this.b.release();
          TXCLog.w("MediaCodecDecoder", "decode: release decoder sucess");
          this.b = null;
        }
        catch (Exception localException4)
        {
          TXCLog.e("MediaCodecDecoder", "decode: release decoder exception: " + localException4.toString());
          this.b = null;
          continue;
        }
        finally
        {
          this.b = null;
          AppMethodBeat.o(16653);
        }
        AppMethodBeat.o(16653);
      }
      try
      {
        this.b.release();
        TXCLog.w("MediaCodecDecoder", "decode: release decoder sucess");
        this.b = null;
      }
      catch (Exception localException1)
      {
        TXCLog.e("MediaCodecDecoder", "decode: release decoder exception: " + localException1.toString());
        this.b = null;
      }
      finally
      {
        this.b = null;
        AppMethodBeat.o(16653);
      }
    }
    this.m.clear();
    this.f = 0L;
    this.h = true;
    AppMethodBeat.o(16653);
  }
  
  private void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    AppMethodBeat.i(16655);
    this.b.releaseOutputBuffer(paramInt1, true);
    if ((this.a.flags & 0x4) != 0) {
      TXCLog.i("MediaCodecDecoder", "output EOS");
    }
    try
    {
      if (this.r != null) {
        this.r.onDecodeFrame(null, this.d, this.e, paramLong1, paramLong2, paramInt2);
      }
      label64:
      d();
      AppMethodBeat.o(16655);
      return;
    }
    catch (Exception localException)
    {
      break label64;
    }
  }
  
  private void a(boolean paramBoolean)
  {
    AppMethodBeat.i(16661);
    if (this.j != paramBoolean)
    {
      this.j = paramBoolean;
      if (this.i)
      {
        AppMethodBeat.o(16661);
        return;
      }
      if ((this.j) && (!e()))
      {
        a();
        f();
        AppMethodBeat.o(16661);
        return;
      }
      a();
      a(null, null, this.j);
    }
    AppMethodBeat.o(16661);
  }
  
  /* Error */
  @android.annotation.TargetApi(16)
  private void b()
  {
    // Byte code:
    //   0: sipush 16654
    //   3: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 55	com/tencent/liteav/videodecoder/b:b	Landroid/media/MediaCodec;
    //   10: ifnonnull +18 -> 28
    //   13: ldc 98
    //   15: ldc_w 267
    //   18: invokestatic 123	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: sipush 16654
    //   24: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: return
    //   28: aload_0
    //   29: getfield 82	com/tencent/liteav/videodecoder/b:m	Ljava/util/ArrayList;
    //   32: iconst_0
    //   33: invokevirtual 271	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   36: checkcast 273	com/tencent/liteav/basic/structs/TXSNALPacket
    //   39: astore 7
    //   41: aload 7
    //   43: ifnull +12 -> 55
    //   46: aload 7
    //   48: getfield 277	com/tencent/liteav/basic/structs/TXSNALPacket:nalData	[B
    //   51: arraylength
    //   52: ifne +27 -> 79
    //   55: ldc 98
    //   57: ldc_w 279
    //   60: invokestatic 123	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   63: aload_0
    //   64: getfield 82	com/tencent/liteav/videodecoder/b:m	Ljava/util/ArrayList;
    //   67: iconst_0
    //   68: invokevirtual 282	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   71: pop
    //   72: sipush 16654
    //   75: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: return
    //   79: invokestatic 288	com/tencent/liteav/basic/util/TXCTimeUtil:getTimeTick	()J
    //   82: lstore_2
    //   83: aload_0
    //   84: getfield 86	com/tencent/liteav/videodecoder/b:o	J
    //   87: lconst_0
    //   88: lcmp
    //   89: ifne +8 -> 97
    //   92: aload_0
    //   93: lload_2
    //   94: putfield 86	com/tencent/liteav/videodecoder/b:o	J
    //   97: aload_0
    //   98: getfield 55	com/tencent/liteav/videodecoder/b:b	Landroid/media/MediaCodec;
    //   101: invokevirtual 292	android/media/MediaCodec:getInputBuffers	()[Ljava/nio/ByteBuffer;
    //   104: astore 6
    //   106: aload 6
    //   108: ifnull +9 -> 117
    //   111: aload 6
    //   113: arraylength
    //   114: ifne +52 -> 166
    //   117: ldc 98
    //   119: ldc_w 294
    //   122: invokestatic 123	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   125: sipush 16654
    //   128: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   131: return
    //   132: astore 6
    //   134: ldc 98
    //   136: new 100	java/lang/StringBuilder
    //   139: dup
    //   140: ldc_w 296
    //   143: invokespecial 105	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   146: aload 6
    //   148: invokevirtual 185	java/lang/Exception:toString	()Ljava/lang/String;
    //   151: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokestatic 123	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   160: aconst_null
    //   161: astore 6
    //   163: goto -57 -> 106
    //   166: aload_0
    //   167: getfield 55	com/tencent/liteav/videodecoder/b:b	Landroid/media/MediaCodec;
    //   170: ldc2_w 297
    //   173: invokevirtual 302	android/media/MediaCodec:dequeueInputBuffer	(J)I
    //   176: istore_1
    //   177: iload_1
    //   178: iflt +248 -> 426
    //   181: aload 6
    //   183: iload_1
    //   184: aaload
    //   185: aload 7
    //   187: getfield 277	com/tencent/liteav/basic/structs/TXSNALPacket:nalData	[B
    //   190: invokevirtual 308	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   193: pop
    //   194: aload_0
    //   195: getfield 55	com/tencent/liteav/videodecoder/b:b	Landroid/media/MediaCodec;
    //   198: iload_1
    //   199: iconst_0
    //   200: aload 7
    //   202: getfield 277	com/tencent/liteav/basic/structs/TXSNALPacket:nalData	[B
    //   205: arraylength
    //   206: aload 7
    //   208: getfield 311	com/tencent/liteav/basic/structs/TXSNALPacket:pts	J
    //   211: iconst_0
    //   212: invokevirtual 315	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   215: aload_0
    //   216: getfield 82	com/tencent/liteav/videodecoder/b:m	Ljava/util/ArrayList;
    //   219: iconst_0
    //   220: invokevirtual 282	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   223: pop
    //   224: aload_0
    //   225: getfield 65	com/tencent/liteav/videodecoder/b:f	J
    //   228: lconst_0
    //   229: lcmp
    //   230: ifne +18 -> 248
    //   233: ldc 98
    //   235: ldc_w 317
    //   238: iload_1
    //   239: invokestatic 323	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   242: invokevirtual 326	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   245: invokestatic 177	com/tencent/liteav/basic/log/TXCLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   248: aload_0
    //   249: getfield 55	com/tencent/liteav/videodecoder/b:b	Landroid/media/MediaCodec;
    //   252: aload_0
    //   253: getfield 53	com/tencent/liteav/videodecoder/b:a	Landroid/media/MediaCodec$BufferInfo;
    //   256: ldc2_w 297
    //   259: invokevirtual 330	android/media/MediaCodec:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   262: istore_1
    //   263: iload_1
    //   264: iflt +202 -> 466
    //   267: aload_0
    //   268: iload_1
    //   269: aload_0
    //   270: getfield 53	com/tencent/liteav/videodecoder/b:a	Landroid/media/MediaCodec$BufferInfo;
    //   273: getfield 333	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   276: aload_0
    //   277: getfield 53	com/tencent/liteav/videodecoder/b:a	Landroid/media/MediaCodec$BufferInfo;
    //   280: getfield 333	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   283: aload 7
    //   285: getfield 336	com/tencent/liteav/basic/structs/TXSNALPacket:rotation	I
    //   288: invokespecial 338	com/tencent/liteav/videodecoder/b:a	(IJJI)V
    //   291: aload_0
    //   292: iconst_0
    //   293: putfield 77	com/tencent/liteav/videodecoder/b:l	I
    //   296: invokestatic 288	com/tencent/liteav/basic/util/TXCTimeUtil:getTimeTick	()J
    //   299: lstore 4
    //   301: aload_0
    //   302: getfield 84	com/tencent/liteav/videodecoder/b:n	Ljava/util/ArrayList;
    //   305: lload 4
    //   307: lload_2
    //   308: lsub
    //   309: invokestatic 343	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   312: invokevirtual 347	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   315: pop
    //   316: lload 4
    //   318: aload_0
    //   319: getfield 86	com/tencent/liteav/videodecoder/b:o	J
    //   322: ldc2_w 348
    //   325: ladd
    //   326: lcmp
    //   327: ifle +253 -> 580
    //   330: aload_0
    //   331: getfield 84	com/tencent/liteav/videodecoder/b:n	Ljava/util/ArrayList;
    //   334: invokevirtual 353	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   337: astore 6
    //   339: lconst_0
    //   340: lstore_2
    //   341: aload 6
    //   343: invokeinterface 358 1 0
    //   348: ifeq +209 -> 557
    //   351: aload 6
    //   353: invokeinterface 362 1 0
    //   358: checkcast 340	java/lang/Long
    //   361: astore 7
    //   363: aload 7
    //   365: invokevirtual 365	java/lang/Long:longValue	()J
    //   368: lload_2
    //   369: lcmp
    //   370: ifle +222 -> 592
    //   373: aload 7
    //   375: invokevirtual 365	java/lang/Long:longValue	()J
    //   378: lstore_2
    //   379: goto -38 -> 341
    //   382: astore 8
    //   384: ldc 98
    //   386: new 100	java/lang/StringBuilder
    //   389: dup
    //   390: ldc_w 367
    //   393: invokespecial 105	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   396: aload 8
    //   398: invokevirtual 185	java/lang/Exception:toString	()Ljava/lang/String;
    //   401: invokevirtual 114	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   407: invokestatic 123	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   410: sipush -10000
    //   413: istore_1
    //   414: goto -237 -> 177
    //   417: astore 6
    //   419: aload_0
    //   420: invokespecial 369	com/tencent/liteav/videodecoder/b:g	()V
    //   423: goto -199 -> 224
    //   426: ldc 98
    //   428: ldc_w 371
    //   431: invokestatic 177	com/tencent/liteav/basic/log/TXCLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   434: goto -186 -> 248
    //   437: astore 6
    //   439: aload_0
    //   440: invokespecial 369	com/tencent/liteav/videodecoder/b:g	()V
    //   443: ldc 98
    //   445: ldc_w 373
    //   448: aload 6
    //   450: invokestatic 376	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   453: invokevirtual 326	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   456: invokestatic 123	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   459: sipush -10000
    //   462: istore_1
    //   463: goto -200 -> 263
    //   466: iload_1
    //   467: iconst_m1
    //   468: if_icmpne +41 -> 509
    //   471: ldc2_w 377
    //   474: invokestatic 384	java/lang/Thread:sleep	(J)V
    //   477: ldc 98
    //   479: new 100	java/lang/StringBuilder
    //   482: dup
    //   483: ldc_w 386
    //   486: invokespecial 105	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   489: aload_0
    //   490: getfield 77	com/tencent/liteav/videodecoder/b:l	I
    //   493: invokevirtual 182	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   496: invokevirtual 118	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   499: invokestatic 243	com/tencent/liteav/basic/log/TXCLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   502: aload_0
    //   503: invokespecial 369	com/tencent/liteav/videodecoder/b:g	()V
    //   506: goto -210 -> 296
    //   509: iload_1
    //   510: bipush 253
    //   512: if_icmpne +14 -> 526
    //   515: ldc 98
    //   517: ldc_w 388
    //   520: invokestatic 243	com/tencent/liteav/basic/log/TXCLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   523: goto -227 -> 296
    //   526: iload_1
    //   527: bipush 254
    //   529: if_icmpne +10 -> 539
    //   532: aload_0
    //   533: invokespecial 390	com/tencent/liteav/videodecoder/b:c	()V
    //   536: goto -240 -> 296
    //   539: ldc 98
    //   541: ldc_w 392
    //   544: iload_1
    //   545: invokestatic 323	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   548: invokevirtual 326	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   551: invokestatic 123	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   554: goto -258 -> 296
    //   557: aload_0
    //   558: getfield 84	com/tencent/liteav/videodecoder/b:n	Ljava/util/ArrayList;
    //   561: invokevirtual 227	java/util/ArrayList:clear	()V
    //   564: aload_0
    //   565: lload 4
    //   567: putfield 86	com/tencent/liteav/videodecoder/b:o	J
    //   570: aload_0
    //   571: ldc2_w 393
    //   574: lload_2
    //   575: lmul
    //   576: l2i
    //   577: putfield 88	com/tencent/liteav/videodecoder/b:p	I
    //   580: sipush 16654
    //   583: invokestatic 92	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   586: return
    //   587: astore 6
    //   589: goto -112 -> 477
    //   592: goto -213 -> 379
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	595	0	this	b
    //   176	369	1	i1	int
    //   82	493	2	l1	long
    //   299	267	4	l2	long
    //   104	8	6	arrayOfByteBuffer	ByteBuffer[]
    //   132	15	6	localException1	Exception
    //   161	191	6	localIterator	java.util.Iterator
    //   417	1	6	localException2	Exception
    //   437	12	6	localException3	Exception
    //   587	1	6	localInterruptedException	java.lang.InterruptedException
    //   39	335	7	localObject	Object
    //   382	15	8	localException4	Exception
    // Exception table:
    //   from	to	target	type
    //   97	106	132	java/lang/Exception
    //   166	177	382	java/lang/Exception
    //   194	224	417	java/lang/Exception
    //   248	263	437	java/lang/Exception
    //   471	477	587	java/lang/InterruptedException
  }
  
  private void c()
  {
    AppMethodBeat.i(16656);
    MediaFormat localMediaFormat = this.b.getOutputFormat();
    TXCLog.i("MediaCodecDecoder", "decode output format changed: ".concat(String.valueOf(localMediaFormat)));
    int i3 = Math.abs(localMediaFormat.getInteger("crop-right") - localMediaFormat.getInteger("crop-left"));
    int i1 = Math.abs(localMediaFormat.getInteger("crop-bottom") - localMediaFormat.getInteger("crop-top"));
    int i4 = localMediaFormat.getInteger("width");
    int i2 = localMediaFormat.getInteger("height");
    i3 = Math.min(i3 + 1, i4);
    i1 = Math.min(i1 + 1, i2);
    if ((i3 != this.d) || (i1 != this.e))
    {
      this.d = i3;
      this.e = i1;
    }
    try
    {
      if (this.r != null) {
        this.r.onVideoSizeChange(this.d, this.e);
      }
      label159:
      TXCLog.i("MediaCodecDecoder", "decode: video size change to w:" + i3 + ",h:" + i1);
      AppMethodBeat.o(16656);
      return;
      if (this.h)
      {
        this.h = false;
        if (this.r != null) {
          this.r.onVideoSizeChange(this.d, this.e);
        }
      }
      AppMethodBeat.o(16656);
      return;
    }
    catch (Exception localException)
    {
      break label159;
    }
  }
  
  private void d()
  {
    AppMethodBeat.i(16657);
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
    AppMethodBeat.o(16657);
  }
  
  private boolean e()
  {
    AppMethodBeat.i(16658);
    Object localObject;
    int i3;
    int i1;
    String[] arrayOfString1;
    int i4;
    int i2;
    if (Build.VERSION.SDK_INT >= 21)
    {
      localObject = new MediaCodecList(1).getCodecInfos();
      i3 = localObject.length;
      i1 = 0;
      while (i1 < i3)
      {
        arrayOfString1 = localObject[i1];
        String[] arrayOfString2 = arrayOfString1.getSupportedTypes();
        i4 = arrayOfString2.length;
        i2 = 0;
        while (i2 < i4)
        {
          if (arrayOfString2[i2].contains("video/hevc"))
          {
            TXCLog.e("MediaCodecDecoder", "decode: video/hevc MediaCodecInfo: " + arrayOfString1.getName() + ",encoder:" + arrayOfString1.isEncoder());
            AppMethodBeat.o(16658);
            return true;
          }
          i2 += 1;
        }
        i1 += 1;
      }
      AppMethodBeat.o(16658);
      return false;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      i3 = MediaCodecList.getCodecCount();
      i1 = 0;
      while (i1 < i3)
      {
        localObject = MediaCodecList.getCodecInfoAt(i1);
        arrayOfString1 = ((MediaCodecInfo)localObject).getSupportedTypes();
        i4 = arrayOfString1.length;
        i2 = 0;
        while (i2 < i4)
        {
          if (arrayOfString1[i2].contains("video/hevc"))
          {
            TXCLog.e("MediaCodecDecoder", "video/hevc MediaCodecInfo: " + ((MediaCodecInfo)localObject).getName() + ",encoder:" + ((MediaCodecInfo)localObject).isEncoder());
            AppMethodBeat.o(16658);
            return true;
          }
          i2 += 1;
        }
        i1 += 1;
      }
    }
    AppMethodBeat.o(16658);
    return false;
  }
  
  private void f()
  {
    AppMethodBeat.i(16659);
    if (!this.i)
    {
      TXCLog.w("MediaCodecDecoder", "decode: hw decode error, hevc: " + this.j);
      if (!this.j) {
        break label87;
      }
      d.a(this.s, -2304, "h265解码失败");
    }
    for (;;)
    {
      this.i = true;
      if (this.r != null) {
        this.r.onDecodeFailed(-1);
      }
      AppMethodBeat.o(16659);
      return;
      label87:
      d.a(this.s, 2106, "硬解启动失败，采用软解");
    }
  }
  
  private void g()
  {
    AppMethodBeat.i(16660);
    if (this.l >= 40)
    {
      f();
      this.l = 0;
      AppMethodBeat.o(16660);
      return;
    }
    this.l += 1;
    AppMethodBeat.o(16660);
  }
  
  public int GetDecodeCost()
  {
    return this.p;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(16651);
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      this.d = paramInt1;
      this.e = paramInt2;
      TXCLog.w("MediaCodecDecoder", "decode: init with video size: " + this.d + ", " + this.e);
    }
    AppMethodBeat.o(16651);
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
    AppMethodBeat.i(16648);
    if (paramTXSNALPacket.codecId == 1) {}
    for (;;)
    {
      a(bool);
      this.m.add(paramTXSNALPacket);
      label30:
      int i1;
      if (!this.m.isEmpty()) {
        i1 = this.m.size();
      }
      try
      {
        b();
        if (i1 != this.m.size()) {
          break label30;
        }
        AppMethodBeat.o(16648);
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
  
  public boolean isHevc()
  {
    return this.j;
  }
  
  public void setListener(c paramc)
  {
    this.r = paramc;
  }
  
  public void setNotifyListener(WeakReference<com.tencent.liteav.basic.c.a> paramWeakReference)
  {
    this.s = paramWeakReference;
  }
  
  public int start(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(16649);
    int i1 = a(paramByteBuffer1, paramByteBuffer2, paramBoolean2);
    AppMethodBeat.o(16649);
    return i1;
  }
  
  public void stop()
  {
    AppMethodBeat.i(16650);
    a();
    AppMethodBeat.o(16650);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.videodecoder.b
 * JD-Core Version:    0.7.0.1
 */
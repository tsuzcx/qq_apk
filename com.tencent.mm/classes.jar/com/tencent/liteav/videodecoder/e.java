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
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.json.JSONArray;

public class e
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
  private f r;
  private d s;
  private boolean t;
  private WeakReference<com.tencent.liteav.basic.b.b> u;
  
  public e()
  {
    AppMethodBeat.i(222592);
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
    AppMethodBeat.o(222592);
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
    //   9: ldc 108
    //   11: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   14: aload_0
    //   15: getfield 59	com/tencent/liteav/videodecoder/e:b	Landroid/media/MediaCodec;
    //   18: ifnonnull +10 -> 28
    //   21: aload_0
    //   22: getfield 79	com/tencent/liteav/videodecoder/e:k	Landroid/view/Surface;
    //   25: ifnonnull +46 -> 71
    //   28: ldc 110
    //   30: new 112	java/lang/StringBuilder
    //   33: dup
    //   34: ldc 114
    //   36: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   39: aload_0
    //   40: getfield 59	com/tencent/liteav/videodecoder/e:b	Landroid/media/MediaCodec;
    //   43: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   46: ldc 123
    //   48: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: aload_0
    //   52: getfield 79	com/tencent/liteav/videodecoder/e:k	Landroid/view/Surface;
    //   55: invokevirtual 121	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   58: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   61: invokestatic 135	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   64: ldc 108
    //   66: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   69: iconst_m1
    //   70: ireturn
    //   71: aload_0
    //   72: iload_3
    //   73: putfield 77	com/tencent/liteav/videodecoder/e:j	Z
    //   76: aload_0
    //   77: getfield 77	com/tencent/liteav/videodecoder/e:j	Z
    //   80: ifeq +104 -> 184
    //   83: aload_0
    //   84: ldc 137
    //   86: putfield 63	com/tencent/liteav/videodecoder/e:c	Ljava/lang/String;
    //   89: aload_0
    //   90: getfield 63	com/tencent/liteav/videodecoder/e:c	Ljava/lang/String;
    //   93: aload_0
    //   94: getfield 65	com/tencent/liteav/videodecoder/e:d	I
    //   97: aload_0
    //   98: getfield 67	com/tencent/liteav/videodecoder/e:e	I
    //   101: invokestatic 143	android/media/MediaFormat:createVideoFormat	(Ljava/lang/String;II)Landroid/media/MediaFormat;
    //   104: astore 8
    //   106: aload_1
    //   107: ifnull +11 -> 118
    //   110: aload 8
    //   112: ldc 145
    //   114: aload_1
    //   115: invokevirtual 149	android/media/MediaFormat:setByteBuffer	(Ljava/lang/String;Ljava/nio/ByteBuffer;)V
    //   118: aload_2
    //   119: ifnull +11 -> 130
    //   122: aload 8
    //   124: ldc 151
    //   126: aload_2
    //   127: invokevirtual 149	android/media/MediaFormat:setByteBuffer	(Ljava/lang/String;Ljava/nio/ByteBuffer;)V
    //   130: aload_0
    //   131: getfield 94	com/tencent/liteav/videodecoder/e:q	Lorg/json/JSONArray;
    //   134: astore_1
    //   135: aload_1
    //   136: ifnull +158 -> 294
    //   139: iconst_0
    //   140: istore 4
    //   142: iload 4
    //   144: aload_1
    //   145: invokevirtual 157	org/json/JSONArray:length	()I
    //   148: if_icmpge +146 -> 294
    //   151: aload_1
    //   152: iload 4
    //   154: invokevirtual 161	org/json/JSONArray:getJSONObject	(I)Lorg/json/JSONObject;
    //   157: astore_2
    //   158: aload 8
    //   160: aload_2
    //   161: ldc 163
    //   163: invokevirtual 169	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   166: aload_2
    //   167: ldc 171
    //   169: invokevirtual 175	org/json/JSONObject:optInt	(Ljava/lang/String;)I
    //   172: invokevirtual 179	android/media/MediaFormat:setInteger	(Ljava/lang/String;I)V
    //   175: iload 4
    //   177: iconst_1
    //   178: iadd
    //   179: istore 4
    //   181: goto -39 -> 142
    //   184: aload_0
    //   185: ldc 61
    //   187: putfield 63	com/tencent/liteav/videodecoder/e:c	Ljava/lang/String;
    //   190: goto -101 -> 89
    //   193: astore_1
    //   194: iconst_0
    //   195: istore 4
    //   197: aload_0
    //   198: getfield 59	com/tencent/liteav/videodecoder/e:b	Landroid/media/MediaCodec;
    //   201: ifnull +22 -> 223
    //   204: aload_0
    //   205: getfield 59	com/tencent/liteav/videodecoder/e:b	Landroid/media/MediaCodec;
    //   208: invokevirtual 184	android/media/MediaCodec:release	()V
    //   211: ldc 110
    //   213: ldc 186
    //   215: invokestatic 189	com/tencent/liteav/basic/log/TXCLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   218: aload_0
    //   219: aconst_null
    //   220: putfield 59	com/tencent/liteav/videodecoder/e:b	Landroid/media/MediaCodec;
    //   223: ldc 110
    //   225: new 112	java/lang/StringBuilder
    //   228: dup
    //   229: ldc 191
    //   231: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   234: iload 4
    //   236: invokevirtual 194	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   239: ldc 196
    //   241: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   244: aload_1
    //   245: invokevirtual 197	java/lang/Exception:toString	()Ljava/lang/String;
    //   248: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: invokestatic 135	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   257: aload_0
    //   258: invokespecial 199	com/tencent/liteav/videodecoder/e:f	()V
    //   261: ldc 108
    //   263: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   266: iload 5
    //   268: ireturn
    //   269: astore_1
    //   270: ldc 110
    //   272: new 112	java/lang/StringBuilder
    //   275: dup
    //   276: ldc 201
    //   278: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   281: aload_1
    //   282: invokevirtual 197	java/lang/Exception:toString	()Ljava/lang/String;
    //   285: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   288: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   291: invokestatic 189	com/tencent/liteav/basic/log/TXCLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   294: aload_0
    //   295: aload_0
    //   296: getfield 63	com/tencent/liteav/videodecoder/e:c	Ljava/lang/String;
    //   299: invokestatic 205	android/media/MediaCodec:createDecoderByType	(Ljava/lang/String;)Landroid/media/MediaCodec;
    //   302: putfield 59	com/tencent/liteav/videodecoder/e:b	Landroid/media/MediaCodec;
    //   305: iload 6
    //   307: istore 4
    //   309: aload_0
    //   310: getfield 59	com/tencent/liteav/videodecoder/e:b	Landroid/media/MediaCodec;
    //   313: aload 8
    //   315: aload_0
    //   316: getfield 79	com/tencent/liteav/videodecoder/e:k	Landroid/view/Surface;
    //   319: aconst_null
    //   320: iconst_0
    //   321: invokevirtual 209	android/media/MediaCodec:configure	(Landroid/media/MediaFormat;Landroid/view/Surface;Landroid/media/MediaCrypto;I)V
    //   324: iconst_2
    //   325: istore 4
    //   327: aload_0
    //   328: getfield 59	com/tencent/liteav/videodecoder/e:b	Landroid/media/MediaCodec;
    //   331: iconst_1
    //   332: invokevirtual 212	android/media/MediaCodec:setVideoScalingMode	(I)V
    //   335: iconst_3
    //   336: istore 4
    //   338: aload_0
    //   339: getfield 59	com/tencent/liteav/videodecoder/e:b	Landroid/media/MediaCodec;
    //   342: invokevirtual 215	android/media/MediaCodec:start	()V
    //   345: iconst_4
    //   346: istore 6
    //   348: iload 6
    //   350: istore 4
    //   352: ldc 110
    //   354: new 112	java/lang/StringBuilder
    //   357: dup
    //   358: ldc 217
    //   360: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   363: aload_0
    //   364: getfield 77	com/tencent/liteav/videodecoder/e:j	Z
    //   367: invokevirtual 220	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   370: ldc 222
    //   372: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   375: aload_0
    //   376: getfield 65	com/tencent/liteav/videodecoder/e:d	I
    //   379: invokevirtual 194	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   382: ldc 224
    //   384: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   387: aload_0
    //   388: getfield 67	com/tencent/liteav/videodecoder/e:e	I
    //   391: invokevirtual 194	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   394: ldc 226
    //   396: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: aload 8
    //   401: invokevirtual 227	android/media/MediaFormat:toString	()Ljava/lang/String;
    //   404: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   410: invokestatic 189	com/tencent/liteav/basic/log/TXCLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   413: aload_0
    //   414: iconst_0
    //   415: putfield 81	com/tencent/liteav/videodecoder/e:l	I
    //   418: iload 7
    //   420: istore 5
    //   422: goto -161 -> 261
    //   425: astore_1
    //   426: iconst_0
    //   427: istore 5
    //   429: iload 6
    //   431: istore 4
    //   433: goto -236 -> 197
    //   436: astore_2
    //   437: ldc 110
    //   439: new 112	java/lang/StringBuilder
    //   442: dup
    //   443: ldc 229
    //   445: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   448: aload_1
    //   449: invokevirtual 197	java/lang/Exception:toString	()Ljava/lang/String;
    //   452: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   455: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   458: invokestatic 135	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   461: aload_0
    //   462: aconst_null
    //   463: putfield 59	com/tencent/liteav/videodecoder/e:b	Landroid/media/MediaCodec;
    //   466: goto -243 -> 223
    //   469: astore_1
    //   470: aload_0
    //   471: aconst_null
    //   472: putfield 59	com/tencent/liteav/videodecoder/e:b	Landroid/media/MediaCodec;
    //   475: ldc 108
    //   477: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   480: aload_1
    //   481: athrow
    //   482: astore_1
    //   483: goto -286 -> 197
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	486	0	this	e
    //   0	486	1	paramByteBuffer1	ByteBuffer
    //   0	486	2	paramByteBuffer2	ByteBuffer
    //   0	486	3	paramBoolean	boolean
    //   140	292	4	i1	int
    //   4	424	5	i2	int
    //   1	429	6	i3	int
    //   7	412	7	i4	int
    //   104	296	8	localMediaFormat	MediaFormat
    // Exception table:
    //   from	to	target	type
    //   14	28	193	java/lang/Exception
    //   28	64	193	java/lang/Exception
    //   71	89	193	java/lang/Exception
    //   89	106	193	java/lang/Exception
    //   110	118	193	java/lang/Exception
    //   122	130	193	java/lang/Exception
    //   130	135	193	java/lang/Exception
    //   184	190	193	java/lang/Exception
    //   270	294	193	java/lang/Exception
    //   294	305	193	java/lang/Exception
    //   142	175	269	java/lang/Exception
    //   413	418	425	java/lang/Exception
    //   204	218	436	java/lang/Exception
    //   204	218	469	finally
    //   437	461	469	finally
    //   309	324	482	java/lang/Exception
    //   327	335	482	java/lang/Exception
    //   338	345	482	java/lang/Exception
    //   352	413	482	java/lang/Exception
  }
  
  private void a()
  {
    AppMethodBeat.i(222599);
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
          AppMethodBeat.o(222599);
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
          AppMethodBeat.o(222599);
        }
        AppMethodBeat.o(222599);
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
        AppMethodBeat.o(222599);
      }
    }
    this.m.clear();
    this.f = 0L;
    this.h = true;
    this.i = false;
    AppMethodBeat.o(222599);
  }
  
  private void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    AppMethodBeat.i(222601);
    this.b.releaseOutputBuffer(paramInt1, true);
    if ((this.a.flags & 0x4) != 0) {
      TXCLog.i("MediaCodecDecoder", "output EOS");
    }
    try
    {
      if (this.r != null) {
        this.r.onDecodeFrame(null, this.d, this.e, paramLong1, paramLong2, paramInt2);
      }
      d();
      AppMethodBeat.o(222601);
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        TXCLog.e("MediaCodecDecoder", "onDecodeFrame failed.", localException);
      }
    }
  }
  
  private void a(TXSNALPacket paramTXSNALPacket)
  {
    int i2 = 0;
    AppMethodBeat.i(222608);
    if (!this.t)
    {
      AppMethodBeat.o(222608);
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
          AppMethodBeat.o(222608);
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
        AppMethodBeat.o(222608);
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
    AppMethodBeat.i(222607);
    if (this.j != paramBoolean)
    {
      this.j = paramBoolean;
      if ((this.j) && (!e()))
      {
        a();
        f();
        AppMethodBeat.o(222607);
        return;
      }
      a();
      a(null, null, this.j);
    }
    AppMethodBeat.o(222607);
  }
  
  /* Error */
  @android.annotation.TargetApi(16)
  private void b()
  {
    // Byte code:
    //   0: ldc_w 308
    //   3: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 59	com/tencent/liteav/videodecoder/e:b	Landroid/media/MediaCodec;
    //   10: ifnonnull +18 -> 28
    //   13: ldc 110
    //   15: ldc_w 310
    //   18: invokestatic 135	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: ldc_w 308
    //   24: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: return
    //   28: aload_0
    //   29: getfield 86	com/tencent/liteav/videodecoder/e:m	Ljava/util/ArrayList;
    //   32: iconst_0
    //   33: invokevirtual 314	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   36: checkcast 276	com/tencent/liteav/basic/structs/TXSNALPacket
    //   39: astore 7
    //   41: aload 7
    //   43: ifnull +12 -> 55
    //   46: aload 7
    //   48: getfield 283	com/tencent/liteav/basic/structs/TXSNALPacket:nalData	[B
    //   51: arraylength
    //   52: ifne +27 -> 79
    //   55: ldc 110
    //   57: ldc_w 316
    //   60: invokestatic 135	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   63: aload_0
    //   64: getfield 86	com/tencent/liteav/videodecoder/e:m	Ljava/util/ArrayList;
    //   67: iconst_0
    //   68: invokevirtual 319	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   71: pop
    //   72: ldc_w 308
    //   75: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: return
    //   79: invokestatic 325	com/tencent/liteav/basic/util/TXCTimeUtil:getTimeTick	()J
    //   82: lstore_2
    //   83: aload_0
    //   84: getfield 90	com/tencent/liteav/videodecoder/e:o	J
    //   87: lconst_0
    //   88: lcmp
    //   89: ifne +8 -> 97
    //   92: aload_0
    //   93: lload_2
    //   94: putfield 90	com/tencent/liteav/videodecoder/e:o	J
    //   97: aload_0
    //   98: getfield 59	com/tencent/liteav/videodecoder/e:b	Landroid/media/MediaCodec;
    //   101: invokevirtual 329	android/media/MediaCodec:getInputBuffers	()[Ljava/nio/ByteBuffer;
    //   104: astore 6
    //   106: aload 6
    //   108: ifnull +9 -> 117
    //   111: aload 6
    //   113: arraylength
    //   114: ifne +52 -> 166
    //   117: ldc 110
    //   119: ldc_w 331
    //   122: invokestatic 135	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   125: ldc_w 308
    //   128: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   131: return
    //   132: astore 6
    //   134: ldc 110
    //   136: new 112	java/lang/StringBuilder
    //   139: dup
    //   140: ldc_w 333
    //   143: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   146: aload 6
    //   148: invokevirtual 197	java/lang/Exception:toString	()Ljava/lang/String;
    //   151: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokestatic 135	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   160: aconst_null
    //   161: astore 6
    //   163: goto -57 -> 106
    //   166: aload_0
    //   167: getfield 59	com/tencent/liteav/videodecoder/e:b	Landroid/media/MediaCodec;
    //   170: ldc2_w 334
    //   173: invokevirtual 339	android/media/MediaCodec:dequeueInputBuffer	(J)I
    //   176: istore_1
    //   177: iload_1
    //   178: iflt +248 -> 426
    //   181: aload 6
    //   183: iload_1
    //   184: aaload
    //   185: aload 7
    //   187: getfield 283	com/tencent/liteav/basic/structs/TXSNALPacket:nalData	[B
    //   190: invokevirtual 345	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   193: pop
    //   194: aload_0
    //   195: getfield 59	com/tencent/liteav/videodecoder/e:b	Landroid/media/MediaCodec;
    //   198: iload_1
    //   199: iconst_0
    //   200: aload 7
    //   202: getfield 283	com/tencent/liteav/basic/structs/TXSNALPacket:nalData	[B
    //   205: arraylength
    //   206: aload 7
    //   208: getfield 348	com/tencent/liteav/basic/structs/TXSNALPacket:pts	J
    //   211: iconst_0
    //   212: invokevirtual 352	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   215: aload_0
    //   216: getfield 86	com/tencent/liteav/videodecoder/e:m	Ljava/util/ArrayList;
    //   219: iconst_0
    //   220: invokevirtual 319	java/util/ArrayList:remove	(I)Ljava/lang/Object;
    //   223: pop
    //   224: aload_0
    //   225: getfield 69	com/tencent/liteav/videodecoder/e:f	J
    //   228: lconst_0
    //   229: lcmp
    //   230: ifne +18 -> 248
    //   233: ldc 110
    //   235: ldc_w 354
    //   238: iload_1
    //   239: invokestatic 360	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   242: invokevirtual 363	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   245: invokestatic 189	com/tencent/liteav/basic/log/TXCLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   248: aload_0
    //   249: getfield 59	com/tencent/liteav/videodecoder/e:b	Landroid/media/MediaCodec;
    //   252: aload_0
    //   253: getfield 57	com/tencent/liteav/videodecoder/e:a	Landroid/media/MediaCodec$BufferInfo;
    //   256: ldc2_w 334
    //   259: invokevirtual 367	android/media/MediaCodec:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   262: istore_1
    //   263: iload_1
    //   264: iflt +202 -> 466
    //   267: aload_0
    //   268: iload_1
    //   269: aload_0
    //   270: getfield 57	com/tencent/liteav/videodecoder/e:a	Landroid/media/MediaCodec$BufferInfo;
    //   273: getfield 370	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   276: aload_0
    //   277: getfield 57	com/tencent/liteav/videodecoder/e:a	Landroid/media/MediaCodec$BufferInfo;
    //   280: getfield 370	android/media/MediaCodec$BufferInfo:presentationTimeUs	J
    //   283: aload 7
    //   285: getfield 373	com/tencent/liteav/basic/structs/TXSNALPacket:rotation	I
    //   288: invokespecial 375	com/tencent/liteav/videodecoder/e:a	(IJJI)V
    //   291: aload_0
    //   292: iconst_0
    //   293: putfield 81	com/tencent/liteav/videodecoder/e:l	I
    //   296: invokestatic 325	com/tencent/liteav/basic/util/TXCTimeUtil:getTimeTick	()J
    //   299: lstore 4
    //   301: aload_0
    //   302: getfield 88	com/tencent/liteav/videodecoder/e:n	Ljava/util/ArrayList;
    //   305: lload 4
    //   307: lload_2
    //   308: lsub
    //   309: invokestatic 380	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   312: invokevirtual 384	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   315: pop
    //   316: lload 4
    //   318: aload_0
    //   319: getfield 90	com/tencent/liteav/videodecoder/e:o	J
    //   322: ldc2_w 385
    //   325: ladd
    //   326: lcmp
    //   327: ifle +253 -> 580
    //   330: aload_0
    //   331: getfield 88	com/tencent/liteav/videodecoder/e:n	Ljava/util/ArrayList;
    //   334: invokevirtual 390	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   337: astore 6
    //   339: lconst_0
    //   340: lstore_2
    //   341: aload 6
    //   343: invokeinterface 395 1 0
    //   348: ifeq +209 -> 557
    //   351: aload 6
    //   353: invokeinterface 399 1 0
    //   358: checkcast 377	java/lang/Long
    //   361: astore 7
    //   363: aload 7
    //   365: invokevirtual 402	java/lang/Long:longValue	()J
    //   368: lload_2
    //   369: lcmp
    //   370: ifle +222 -> 592
    //   373: aload 7
    //   375: invokevirtual 402	java/lang/Long:longValue	()J
    //   378: lstore_2
    //   379: goto -38 -> 341
    //   382: astore 8
    //   384: ldc 110
    //   386: new 112	java/lang/StringBuilder
    //   389: dup
    //   390: ldc_w 404
    //   393: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   396: aload 8
    //   398: invokevirtual 197	java/lang/Exception:toString	()Ljava/lang/String;
    //   401: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   404: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   407: invokestatic 135	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   410: sipush -10000
    //   413: istore_1
    //   414: goto -237 -> 177
    //   417: astore 6
    //   419: aload_0
    //   420: invokespecial 406	com/tencent/liteav/videodecoder/e:g	()V
    //   423: goto -199 -> 224
    //   426: ldc 110
    //   428: ldc_w 408
    //   431: invokestatic 189	com/tencent/liteav/basic/log/TXCLog:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   434: goto -186 -> 248
    //   437: astore 6
    //   439: aload_0
    //   440: invokespecial 406	com/tencent/liteav/videodecoder/e:g	()V
    //   443: ldc 110
    //   445: ldc_w 410
    //   448: aload 6
    //   450: invokestatic 413	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   453: invokevirtual 363	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   456: invokestatic 135	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   459: sipush -10000
    //   462: istore_1
    //   463: goto -200 -> 263
    //   466: iload_1
    //   467: iconst_m1
    //   468: if_icmpne +41 -> 509
    //   471: ldc2_w 414
    //   474: invokestatic 421	java/lang/Thread:sleep	(J)V
    //   477: ldc 110
    //   479: new 112	java/lang/StringBuilder
    //   482: dup
    //   483: ldc_w 423
    //   486: invokespecial 117	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   489: aload_0
    //   490: getfield 81	com/tencent/liteav/videodecoder/e:l	I
    //   493: invokevirtual 194	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   496: invokevirtual 130	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   499: invokestatic 257	com/tencent/liteav/basic/log/TXCLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   502: aload_0
    //   503: invokespecial 406	com/tencent/liteav/videodecoder/e:g	()V
    //   506: goto -210 -> 296
    //   509: iload_1
    //   510: bipush 253
    //   512: if_icmpne +14 -> 526
    //   515: ldc 110
    //   517: ldc_w 425
    //   520: invokestatic 257	com/tencent/liteav/basic/log/TXCLog:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   523: goto -227 -> 296
    //   526: iload_1
    //   527: bipush 254
    //   529: if_icmpne +10 -> 539
    //   532: aload_0
    //   533: invokespecial 427	com/tencent/liteav/videodecoder/e:c	()V
    //   536: goto -240 -> 296
    //   539: ldc 110
    //   541: ldc_w 429
    //   544: iload_1
    //   545: invokestatic 360	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   548: invokevirtual 363	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   551: invokestatic 135	com/tencent/liteav/basic/log/TXCLog:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   554: goto -258 -> 296
    //   557: aload_0
    //   558: getfield 88	com/tencent/liteav/videodecoder/e:n	Ljava/util/ArrayList;
    //   561: invokevirtual 240	java/util/ArrayList:clear	()V
    //   564: aload_0
    //   565: lload 4
    //   567: putfield 90	com/tencent/liteav/videodecoder/e:o	J
    //   570: aload_0
    //   571: ldc2_w 430
    //   574: lload_2
    //   575: lmul
    //   576: l2i
    //   577: putfield 92	com/tencent/liteav/videodecoder/e:p	I
    //   580: ldc_w 308
    //   583: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   586: return
    //   587: astore 6
    //   589: goto -112 -> 477
    //   592: goto -213 -> 379
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	595	0	this	e
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
    AppMethodBeat.i(222602);
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
      try
      {
        if (this.r != null) {
          this.r.onVideoSizeChange(this.d, this.e);
        }
        TXCLog.i("MediaCodecDecoder", "decode: video size change to w:" + i3 + ",h:" + i1);
        AppMethodBeat.o(222602);
        return;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          TXCLog.e("MediaCodecDecoder", "onVideoSizeChange failed.", localException);
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
    AppMethodBeat.o(222602);
  }
  
  private void d()
  {
    AppMethodBeat.i(222603);
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
    AppMethodBeat.o(222603);
  }
  
  private boolean e()
  {
    AppMethodBeat.i(222604);
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
            AppMethodBeat.o(222604);
            return true;
          }
          i2 += 1;
        }
        i1 += 1;
      }
      AppMethodBeat.o(222604);
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
            AppMethodBeat.o(222604);
            return true;
          }
          i2 += 1;
        }
        i1 += 1;
      }
    }
    AppMethodBeat.o(222604);
    return false;
  }
  
  private void f()
  {
    AppMethodBeat.i(222605);
    if (!this.i)
    {
      this.i = true;
      TXCLog.w("MediaCodecDecoder", "decode: hw decode error, hevc: " + this.j);
      if (!this.j) {
        break label87;
      }
      com.tencent.liteav.basic.util.f.a(this.u, -2304, "h265 Decoding failed");
    }
    for (;;)
    {
      if (this.r != null) {
        this.r.onDecodeFailed(-1);
      }
      AppMethodBeat.o(222605);
      return;
      label87:
      com.tencent.liteav.basic.util.f.a(this.u, 2106, "Failed to enable hardware decoding，use software decoding.");
    }
  }
  
  private void g()
  {
    AppMethodBeat.i(222606);
    if (this.l >= 40)
    {
      f();
      this.l = 0;
      AppMethodBeat.o(222606);
      return;
    }
    this.l += 1;
    AppMethodBeat.o(222606);
  }
  
  public int GetDecodeCost()
  {
    return this.p;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(222597);
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      this.d = paramInt1;
      this.e = paramInt2;
      TXCLog.w("MediaCodecDecoder", "decode: init with video size: " + this.d + ", " + this.e);
    }
    AppMethodBeat.o(222597);
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
    AppMethodBeat.i(222593);
    if (paramTXSNALPacket.codecId == 1) {}
    for (;;)
    {
      a(bool);
      a(paramTXSNALPacket);
      this.m.add(paramTXSNALPacket);
      label35:
      int i1;
      if (!this.m.isEmpty()) {
        i1 = this.m.size();
      }
      try
      {
        b();
        if (i1 != this.m.size()) {
          break label35;
        }
        AppMethodBeat.o(222593);
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
    AppMethodBeat.i(222596);
    this.t = paramBoolean;
    TXCLog.i("MediaCodecDecoder", "decode: enable limit dec cache: ".concat(String.valueOf(paramBoolean)));
    AppMethodBeat.o(222596);
  }
  
  public boolean isHevc()
  {
    return this.j;
  }
  
  public void setListener(f paramf)
  {
    this.r = paramf;
  }
  
  public void setNotifyListener(WeakReference<com.tencent.liteav.basic.b.b> paramWeakReference)
  {
    this.u = paramWeakReference;
  }
  
  public int start(ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(222594);
    int i1 = a(paramByteBuffer1, paramByteBuffer2, paramBoolean2);
    AppMethodBeat.o(222594);
    return i1;
  }
  
  public void stop()
  {
    AppMethodBeat.i(222595);
    a();
    AppMethodBeat.o(222595);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.videodecoder.e
 * JD-Core Version:    0.7.0.1
 */
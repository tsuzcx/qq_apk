package com.tencent.mm.media.e;

import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.deviceinfo.z;
import java.nio.ByteBuffer;
import kotlin.g.a.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/media/encoder/MediaCodecAACEncoder;", "Lcom/tencent/mm/media/encoder/IAudioEncoder;", "mediaFormat", "Landroid/media/MediaFormat;", "frameEncodeCallback", "Lkotlin/Function3;", "Ljava/nio/ByteBuffer;", "Lkotlin/ParameterName;", "name", "data", "Landroid/media/MediaCodec$BufferInfo;", "bufferInfo", "format", "", "frameEncodeEndCallback", "Lkotlin/Function0;", "(Landroid/media/MediaFormat;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;)V", "currentPts", "", "drainEncoder", "sendDataToEncoder", "pcmData", "", "pts", "isLast", "", "startEncoder", "Companion", "plugin-mediaeditor_release"})
public final class c
  extends a
{
  public static final c.a ifi;
  
  static
  {
    AppMethodBeat.i(93626);
    ifi = new c.a((byte)0);
    AppMethodBeat.o(93626);
  }
  
  public c(MediaFormat paramMediaFormat, q<? super ByteBuffer, ? super MediaCodec.BufferInfo, ? super MediaFormat, x> paramq, kotlin.g.a.a<x> parama)
  {
    super(paramMediaFormat, paramq, parama);
    AppMethodBeat.i(93625);
    this.ieT.start();
    AppMethodBeat.o(93625);
  }
  
  /* Error */
  @android.annotation.SuppressLint({"WrongConstant"})
  private final void aMn()
  {
    // Byte code:
    //   0: ldc 91
    //   2: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: getfield 95	com/tencent/mm/media/e/a:stopLock	Ljava/lang/Object;
    //   9: astore_2
    //   10: aload_2
    //   11: monitorenter
    //   12: aload_0
    //   13: getfield 99	com/tencent/mm/media/e/a:idt	Z
    //   16: ifeq +18 -> 34
    //   19: ldc 101
    //   21: ldc 103
    //   23: invokestatic 108	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: aload_2
    //   27: monitorexit
    //   28: ldc 91
    //   30: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: return
    //   34: getstatic 114	kotlin/x:SXb	Lkotlin/x;
    //   37: astore_3
    //   38: aload_2
    //   39: monitorexit
    //   40: new 116	android/media/MediaCodec$BufferInfo
    //   43: dup
    //   44: invokespecial 118	android/media/MediaCodec$BufferInfo:<init>	()V
    //   47: astore_2
    //   48: aload_0
    //   49: getfield 77	com/tencent/mm/media/e/a:ieT	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   52: aload_2
    //   53: ldc2_w 119
    //   56: invokevirtual 124	com/tencent/mm/compatible/deviceinfo/z:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   59: istore_1
    //   60: ldc 101
    //   62: ldc 126
    //   64: iconst_1
    //   65: anewarray 128	java/lang/Object
    //   68: dup
    //   69: iconst_0
    //   70: iload_1
    //   71: invokestatic 134	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   74: aastore
    //   75: invokestatic 138	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   78: iload_1
    //   79: iconst_m1
    //   80: if_icmpne +55 -> 135
    //   83: ldc 101
    //   85: ldc 140
    //   87: invokestatic 142	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   90: ldc 91
    //   92: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   95: return
    //   96: astore_2
    //   97: ldc 101
    //   99: aload_2
    //   100: checkcast 144	java/lang/Throwable
    //   103: ldc 146
    //   105: iconst_1
    //   106: anewarray 128	java/lang/Object
    //   109: dup
    //   110: iconst_0
    //   111: aload_2
    //   112: invokevirtual 150	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   115: aastore
    //   116: invokestatic 154	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   119: ldc 91
    //   121: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   124: return
    //   125: astore_3
    //   126: aload_2
    //   127: monitorexit
    //   128: ldc 91
    //   130: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   133: aload_3
    //   134: athrow
    //   135: iload_1
    //   136: bipush 254
    //   138: if_icmpne +43 -> 181
    //   141: aload_0
    //   142: getfield 77	com/tencent/mm/media/e/a:ieT	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   145: invokevirtual 158	com/tencent/mm/compatible/deviceinfo/z:getOutputFormat	()Landroid/media/MediaFormat;
    //   148: astore_3
    //   149: aload_3
    //   150: ldc 160
    //   152: invokestatic 163	kotlin/g/b/p:g	(Ljava/lang/Object;Ljava/lang/String;)V
    //   155: aload_0
    //   156: aload_3
    //   157: invokevirtual 166	com/tencent/mm/media/e/c:d	(Landroid/media/MediaFormat;)V
    //   160: ldc 101
    //   162: ldc 168
    //   164: iconst_1
    //   165: anewarray 128	java/lang/Object
    //   168: dup
    //   169: iconst_0
    //   170: aload_0
    //   171: getfield 171	com/tencent/mm/media/e/a:ieU	Landroid/media/MediaFormat;
    //   174: aastore
    //   175: invokestatic 173	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   178: goto -130 -> 48
    //   181: iload_1
    //   182: ifge +24 -> 206
    //   185: ldc 101
    //   187: ldc 175
    //   189: iconst_1
    //   190: anewarray 128	java/lang/Object
    //   193: dup
    //   194: iconst_0
    //   195: iload_1
    //   196: invokestatic 134	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   199: aastore
    //   200: invokestatic 178	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   203: goto -155 -> 48
    //   206: aload_2
    //   207: getfield 182	android/media/MediaCodec$BufferInfo:flags	I
    //   210: iconst_2
    //   211: iand
    //   212: ifeq +35 -> 247
    //   215: ldc 101
    //   217: ldc 184
    //   219: iconst_2
    //   220: anewarray 128	java/lang/Object
    //   223: dup
    //   224: iconst_0
    //   225: aload_2
    //   226: getfield 187	android/media/MediaCodec$BufferInfo:size	I
    //   229: invokestatic 134	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   232: aastore
    //   233: dup
    //   234: iconst_1
    //   235: getstatic 193	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   238: aastore
    //   239: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   242: aload_2
    //   243: iconst_0
    //   244: putfield 187	android/media/MediaCodec$BufferInfo:size	I
    //   247: ldc 101
    //   249: ldc 198
    //   251: invokestatic 200	com/tencent/mm/sdk/platformtools/Log:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   254: aload_0
    //   255: getfield 77	com/tencent/mm/media/e/a:ieT	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   258: invokevirtual 204	com/tencent/mm/compatible/deviceinfo/z:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   261: iload_1
    //   262: aaload
    //   263: astore_3
    //   264: aload_3
    //   265: ifnonnull +16 -> 281
    //   268: ldc 101
    //   270: ldc 206
    //   272: invokestatic 208	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   275: ldc 91
    //   277: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   280: return
    //   281: aload_2
    //   282: getfield 187	android/media/MediaCodec$BufferInfo:size	I
    //   285: ifle +9 -> 294
    //   288: aload_0
    //   289: aload_3
    //   290: aload_2
    //   291: invokevirtual 212	com/tencent/mm/media/e/c:f	(Ljava/nio/ByteBuffer;Landroid/media/MediaCodec$BufferInfo;)V
    //   294: aload_0
    //   295: getfield 77	com/tencent/mm/media/e/a:ieT	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   298: iload_1
    //   299: iconst_0
    //   300: invokevirtual 216	com/tencent/mm/compatible/deviceinfo/z:releaseOutputBuffer	(IZ)V
    //   303: aload_2
    //   304: getfield 182	android/media/MediaCodec$BufferInfo:flags	I
    //   307: iconst_4
    //   308: iand
    //   309: ifeq -261 -> 48
    //   312: ldc 101
    //   314: ldc 218
    //   316: invokestatic 108	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   319: aload_0
    //   320: getfield 77	com/tencent/mm/media/e/a:ieT	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   323: invokevirtual 221	com/tencent/mm/compatible/deviceinfo/z:stop	()V
    //   326: aload_0
    //   327: getfield 77	com/tencent/mm/media/e/a:ieT	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   330: invokevirtual 224	com/tencent/mm/compatible/deviceinfo/z:release	()V
    //   333: ldc 91
    //   335: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   338: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	339	0	this	c
    //   59	240	1	i	int
    //   96	208	2	localException	java.lang.Exception
    //   37	1	3	localx	x
    //   125	9	3	localObject2	java.lang.Object
    //   148	142	3	localObject3	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   5	12	96	java/lang/Exception
    //   26	33	96	java/lang/Exception
    //   38	48	96	java/lang/Exception
    //   48	78	96	java/lang/Exception
    //   83	95	96	java/lang/Exception
    //   126	135	96	java/lang/Exception
    //   141	178	96	java/lang/Exception
    //   185	203	96	java/lang/Exception
    //   206	247	96	java/lang/Exception
    //   247	264	96	java/lang/Exception
    //   268	280	96	java/lang/Exception
    //   281	294	96	java/lang/Exception
    //   294	338	96	java/lang/Exception
    //   12	26	125	finally
    //   34	38	125	finally
  }
  
  /* Error */
  public final void b(byte[] paramArrayOfByte, long paramLong, boolean paramBoolean)
  {
    // Byte code:
    //   0: ldc 228
    //   2: invokestatic 50	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ldc 229
    //   8: invokestatic 68	kotlin/g/b/p:h	(Ljava/lang/Object;Ljava/lang/String;)V
    //   11: aload_1
    //   12: ifnonnull +16 -> 28
    //   15: ldc 101
    //   17: ldc 231
    //   19: invokestatic 208	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: ldc 228
    //   24: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: return
    //   28: aload_0
    //   29: getfield 95	com/tencent/mm/media/e/a:stopLock	Ljava/lang/Object;
    //   32: astore 7
    //   34: aload 7
    //   36: monitorenter
    //   37: aload_0
    //   38: getfield 99	com/tencent/mm/media/e/a:idt	Z
    //   41: ifeq +41 -> 82
    //   44: ldc 101
    //   46: ldc 233
    //   48: invokestatic 108	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   51: aload 7
    //   53: monitorexit
    //   54: ldc 228
    //   56: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   59: return
    //   60: astore_1
    //   61: ldc 101
    //   63: aload_1
    //   64: checkcast 144	java/lang/Throwable
    //   67: ldc 234
    //   69: iconst_0
    //   70: anewarray 128	java/lang/Object
    //   73: invokestatic 154	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   76: ldc 228
    //   78: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   81: return
    //   82: getstatic 114	kotlin/x:SXb	Lkotlin/x;
    //   85: astore 8
    //   87: aload 7
    //   89: monitorexit
    //   90: aload_0
    //   91: invokestatic 240	com/tencent/mm/sdk/platformtools/Util:currentTicks	()J
    //   94: putfield 244	com/tencent/mm/media/e/a:ieV	J
    //   97: ldc 101
    //   99: new 246	java/lang/StringBuilder
    //   102: dup
    //   103: ldc 248
    //   105: invokespecial 251	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   108: aload_1
    //   109: arraylength
    //   110: invokevirtual 255	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   113: ldc_w 257
    //   116: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: lload_2
    //   120: invokevirtual 263	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   123: ldc_w 265
    //   126: invokevirtual 260	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: iload 4
    //   131: invokevirtual 268	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   134: invokevirtual 271	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: invokestatic 108	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   140: aload_0
    //   141: getfield 77	com/tencent/mm/media/e/a:ieT	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   144: ldc2_w 119
    //   147: invokevirtual 275	com/tencent/mm/compatible/deviceinfo/z:dequeueInputBuffer	(J)I
    //   150: istore 6
    //   152: iload 6
    //   154: ifge +15 -> 169
    //   157: ldc 101
    //   159: ldc_w 277
    //   162: invokestatic 142	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   165: aload_0
    //   166: invokespecial 279	com/tencent/mm/media/e/c:aMn	()V
    //   169: iload 6
    //   171: iflt +96 -> 267
    //   174: aload_0
    //   175: getfield 77	com/tencent/mm/media/e/a:ieT	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   178: invokevirtual 282	com/tencent/mm/compatible/deviceinfo/z:getInputBuffers	()[Ljava/nio/ByteBuffer;
    //   181: iload 6
    //   183: aaload
    //   184: astore 7
    //   186: aload 7
    //   188: ifnull +9 -> 197
    //   191: aload 7
    //   193: invokevirtual 288	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   196: pop
    //   197: aload 7
    //   199: ifnull +10 -> 209
    //   202: aload 7
    //   204: iconst_0
    //   205: invokevirtual 292	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   208: pop
    //   209: aload 7
    //   211: ifnull +10 -> 221
    //   214: aload 7
    //   216: aload_1
    //   217: invokevirtual 296	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   220: pop
    //   221: iload 4
    //   223: ifeq +81 -> 304
    //   226: ldc 101
    //   228: ldc_w 298
    //   231: invokestatic 108	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   234: iconst_1
    //   235: istore 5
    //   237: aload_0
    //   238: invokevirtual 301	com/tencent/mm/media/e/c:aMj	()V
    //   241: iload 5
    //   243: ifeq +45 -> 288
    //   246: ldc 101
    //   248: ldc_w 303
    //   251: invokestatic 108	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   254: aload_0
    //   255: getfield 77	com/tencent/mm/media/e/a:ieT	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   258: iload 6
    //   260: aload_1
    //   261: arraylength
    //   262: lload_2
    //   263: iconst_4
    //   264: invokevirtual 307	com/tencent/mm/compatible/deviceinfo/z:a	(IIJI)V
    //   267: aload_0
    //   268: invokespecial 279	com/tencent/mm/media/e/c:aMn	()V
    //   271: ldc 228
    //   273: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   276: return
    //   277: astore_1
    //   278: aload 7
    //   280: monitorexit
    //   281: ldc 228
    //   283: invokestatic 59	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   286: aload_1
    //   287: athrow
    //   288: aload_0
    //   289: getfield 77	com/tencent/mm/media/e/a:ieT	Lcom/tencent/mm/compatible/deviceinfo/z;
    //   292: iload 6
    //   294: aload_1
    //   295: arraylength
    //   296: lload_2
    //   297: iconst_0
    //   298: invokevirtual 307	com/tencent/mm/compatible/deviceinfo/z:a	(IIJI)V
    //   301: goto -34 -> 267
    //   304: iconst_0
    //   305: istore 5
    //   307: goto -66 -> 241
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	310	0	this	c
    //   0	310	1	paramArrayOfByte	byte[]
    //   0	310	2	paramLong	long
    //   0	310	4	paramBoolean	boolean
    //   235	71	5	i	int
    //   150	143	6	j	int
    //   85	1	8	localx	x
    // Exception table:
    //   from	to	target	type
    //   15	27	60	java/lang/Exception
    //   28	37	60	java/lang/Exception
    //   51	59	60	java/lang/Exception
    //   87	152	60	java/lang/Exception
    //   157	169	60	java/lang/Exception
    //   174	186	60	java/lang/Exception
    //   191	197	60	java/lang/Exception
    //   202	209	60	java/lang/Exception
    //   214	221	60	java/lang/Exception
    //   226	234	60	java/lang/Exception
    //   237	241	60	java/lang/Exception
    //   246	267	60	java/lang/Exception
    //   267	271	60	java/lang/Exception
    //   278	288	60	java/lang/Exception
    //   288	301	60	java/lang/Exception
    //   37	51	277	finally
    //   82	87	277	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.media.e.c
 * JD-Core Version:    0.7.0.1
 */
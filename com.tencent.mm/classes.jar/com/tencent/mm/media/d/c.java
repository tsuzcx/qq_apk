package com.tencent.mm.media.d;

import a.f.a.m;
import a.l;
import a.y;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/media/encoder/MediaCodecAACEncoder;", "Lcom/tencent/mm/media/encoder/IAudioEncoder;", "mediaFormat", "Landroid/media/MediaFormat;", "frameEncodeCallback", "Lkotlin/Function2;", "Ljava/nio/ByteBuffer;", "Lkotlin/ParameterName;", "name", "data", "Landroid/media/MediaCodec$BufferInfo;", "bufferInfo", "", "frameEncodeEndCallback", "Lkotlin/Function0;", "(Landroid/media/MediaFormat;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "drainEncoder", "sendDataToEncoder", "pcmData", "", "pts", "", "isLast", "", "startEncoder", "Companion", "plugin-mediaeditor_release"})
public final class c
  extends a
{
  public static final c.a eUs;
  
  static
  {
    AppMethodBeat.i(12934);
    eUs = new c.a((byte)0);
    AppMethodBeat.o(12934);
  }
  
  public c(MediaFormat paramMediaFormat, m<? super ByteBuffer, ? super MediaCodec.BufferInfo, y> paramm, a.f.a.a<y> parama)
  {
    super(paramMediaFormat, paramm, parama);
    AppMethodBeat.i(12933);
    this.eUg.start();
    AppMethodBeat.o(12933);
  }
  
  /* Error */
  @android.annotation.SuppressLint({"WrongConstant"})
  private final void UR()
  {
    // Byte code:
    //   0: sipush 12931
    //   3: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 90	com/tencent/mm/media/d/a:eRH	Ljava/lang/Object;
    //   10: astore_2
    //   11: aload_2
    //   12: monitorenter
    //   13: aload_0
    //   14: getfield 94	com/tencent/mm/media/d/a:eRq	Z
    //   17: ifeq +19 -> 36
    //   20: ldc 96
    //   22: ldc 98
    //   24: invokestatic 103	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   27: aload_2
    //   28: monitorexit
    //   29: sipush 12931
    //   32: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   35: return
    //   36: getstatic 109	a/y:BMg	La/y;
    //   39: astore_3
    //   40: aload_2
    //   41: monitorexit
    //   42: new 111	android/media/MediaCodec$BufferInfo
    //   45: dup
    //   46: invokespecial 113	android/media/MediaCodec$BufferInfo:<init>	()V
    //   49: astore_2
    //   50: aload_0
    //   51: getfield 73	com/tencent/mm/media/d/a:eUg	Landroid/media/MediaCodec;
    //   54: aload_2
    //   55: ldc2_w 114
    //   58: invokevirtual 119	android/media/MediaCodec:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   61: istore_1
    //   62: ldc 96
    //   64: ldc 121
    //   66: iconst_1
    //   67: anewarray 123	java/lang/Object
    //   70: dup
    //   71: iconst_0
    //   72: iload_1
    //   73: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   76: aastore
    //   77: invokestatic 133	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   80: iload_1
    //   81: iconst_m1
    //   82: if_icmpne +58 -> 140
    //   85: ldc 96
    //   87: ldc 135
    //   89: invokestatic 137	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: sipush 12931
    //   95: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   98: return
    //   99: astore_2
    //   100: ldc 96
    //   102: aload_2
    //   103: checkcast 139	java/lang/Throwable
    //   106: ldc 141
    //   108: iconst_1
    //   109: anewarray 123	java/lang/Object
    //   112: dup
    //   113: iconst_0
    //   114: aload_2
    //   115: invokevirtual 145	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   118: aastore
    //   119: invokestatic 149	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   122: sipush 12931
    //   125: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: return
    //   129: astore_3
    //   130: aload_2
    //   131: monitorexit
    //   132: sipush 12931
    //   135: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: aload_3
    //   139: athrow
    //   140: iload_1
    //   141: bipush 254
    //   143: if_icmpne +43 -> 186
    //   146: aload_0
    //   147: getfield 73	com/tencent/mm/media/d/a:eUg	Landroid/media/MediaCodec;
    //   150: invokevirtual 153	android/media/MediaCodec:getOutputFormat	()Landroid/media/MediaFormat;
    //   153: astore_3
    //   154: aload_3
    //   155: ldc 155
    //   157: invokestatic 158	a/f/b/j:p	(Ljava/lang/Object;Ljava/lang/String;)V
    //   160: aload_0
    //   161: aload_3
    //   162: invokevirtual 161	com/tencent/mm/media/d/c:d	(Landroid/media/MediaFormat;)V
    //   165: ldc 96
    //   167: ldc 163
    //   169: iconst_1
    //   170: anewarray 123	java/lang/Object
    //   173: dup
    //   174: iconst_0
    //   175: aload_0
    //   176: getfield 166	com/tencent/mm/media/d/a:eUh	Landroid/media/MediaFormat;
    //   179: aastore
    //   180: invokestatic 168	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   183: goto -133 -> 50
    //   186: iload_1
    //   187: ifge +24 -> 211
    //   190: ldc 96
    //   192: ldc 170
    //   194: iconst_1
    //   195: anewarray 123	java/lang/Object
    //   198: dup
    //   199: iconst_0
    //   200: iload_1
    //   201: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   204: aastore
    //   205: invokestatic 173	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   208: goto -158 -> 50
    //   211: aload_2
    //   212: getfield 177	android/media/MediaCodec$BufferInfo:flags	I
    //   215: iconst_2
    //   216: iand
    //   217: ifeq +35 -> 252
    //   220: ldc 96
    //   222: ldc 179
    //   224: iconst_2
    //   225: anewarray 123	java/lang/Object
    //   228: dup
    //   229: iconst_0
    //   230: aload_2
    //   231: getfield 182	android/media/MediaCodec$BufferInfo:size	I
    //   234: invokestatic 129	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   237: aastore
    //   238: dup
    //   239: iconst_1
    //   240: getstatic 188	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   243: aastore
    //   244: invokestatic 191	com/tencent/mm/sdk/platformtools/ab:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   247: aload_2
    //   248: iconst_0
    //   249: putfield 182	android/media/MediaCodec$BufferInfo:size	I
    //   252: ldc 96
    //   254: ldc 193
    //   256: invokestatic 195	com/tencent/mm/sdk/platformtools/ab:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   259: aload_0
    //   260: getfield 73	com/tencent/mm/media/d/a:eUg	Landroid/media/MediaCodec;
    //   263: invokevirtual 199	android/media/MediaCodec:getOutputBuffers	()[Ljava/nio/ByteBuffer;
    //   266: iload_1
    //   267: aaload
    //   268: astore_3
    //   269: aload_3
    //   270: ifnonnull +17 -> 287
    //   273: ldc 96
    //   275: ldc 201
    //   277: invokestatic 203	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   280: sipush 12931
    //   283: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   286: return
    //   287: aload_2
    //   288: getfield 182	android/media/MediaCodec$BufferInfo:size	I
    //   291: ifle +9 -> 300
    //   294: aload_0
    //   295: aload_3
    //   296: aload_2
    //   297: invokevirtual 207	com/tencent/mm/media/d/c:f	(Ljava/nio/ByteBuffer;Landroid/media/MediaCodec$BufferInfo;)V
    //   300: aload_0
    //   301: getfield 73	com/tencent/mm/media/d/a:eUg	Landroid/media/MediaCodec;
    //   304: iload_1
    //   305: iconst_0
    //   306: invokevirtual 211	android/media/MediaCodec:releaseOutputBuffer	(IZ)V
    //   309: aload_2
    //   310: getfield 177	android/media/MediaCodec$BufferInfo:flags	I
    //   313: iconst_4
    //   314: iand
    //   315: ifeq -265 -> 50
    //   318: ldc 96
    //   320: ldc 213
    //   322: invokestatic 103	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   325: aload_0
    //   326: getfield 73	com/tencent/mm/media/d/a:eUg	Landroid/media/MediaCodec;
    //   329: invokevirtual 216	android/media/MediaCodec:stop	()V
    //   332: aload_0
    //   333: getfield 73	com/tencent/mm/media/d/a:eUg	Landroid/media/MediaCodec;
    //   336: invokevirtual 219	android/media/MediaCodec:release	()V
    //   339: sipush 12931
    //   342: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   345: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	346	0	this	c
    //   61	244	1	i	int
    //   99	211	2	localException	java.lang.Exception
    //   39	1	3	localy	y
    //   129	10	3	localObject2	java.lang.Object
    //   153	143	3	localObject3	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   6	13	99	java/lang/Exception
    //   27	35	99	java/lang/Exception
    //   40	50	99	java/lang/Exception
    //   50	80	99	java/lang/Exception
    //   85	98	99	java/lang/Exception
    //   130	140	99	java/lang/Exception
    //   146	183	99	java/lang/Exception
    //   190	208	99	java/lang/Exception
    //   211	252	99	java/lang/Exception
    //   252	269	99	java/lang/Exception
    //   273	286	99	java/lang/Exception
    //   287	300	99	java/lang/Exception
    //   300	345	99	java/lang/Exception
    //   13	27	129	finally
    //   36	40	129	finally
  }
  
  /* Error */
  public final void b(byte[] paramArrayOfByte, long paramLong, boolean paramBoolean)
  {
    // Byte code:
    //   0: sipush 12932
    //   3: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ldc 223
    //   9: invokestatic 65	a/f/b/j:q	(Ljava/lang/Object;Ljava/lang/String;)V
    //   12: aload_1
    //   13: ifnonnull +17 -> 30
    //   16: ldc 96
    //   18: ldc 225
    //   20: invokestatic 203	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: sipush 12932
    //   26: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: return
    //   30: aload_0
    //   31: getfield 90	com/tencent/mm/media/d/a:eRH	Ljava/lang/Object;
    //   34: astore 7
    //   36: aload 7
    //   38: monitorenter
    //   39: aload_0
    //   40: getfield 94	com/tencent/mm/media/d/a:eRq	Z
    //   43: ifeq +43 -> 86
    //   46: ldc 96
    //   48: ldc 227
    //   50: invokestatic 103	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   53: aload 7
    //   55: monitorexit
    //   56: sipush 12932
    //   59: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   62: return
    //   63: astore_1
    //   64: ldc 96
    //   66: aload_1
    //   67: checkcast 139	java/lang/Throwable
    //   70: ldc 228
    //   72: iconst_0
    //   73: anewarray 123	java/lang/Object
    //   76: invokestatic 149	com/tencent/mm/sdk/platformtools/ab:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   79: sipush 12932
    //   82: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: return
    //   86: getstatic 109	a/y:BMg	La/y;
    //   89: astore 8
    //   91: aload 7
    //   93: monitorexit
    //   94: aload_0
    //   95: invokestatic 234	com/tencent/mm/sdk/platformtools/bo:yB	()J
    //   98: putfield 238	com/tencent/mm/media/d/a:eUi	J
    //   101: ldc 96
    //   103: new 240	java/lang/StringBuilder
    //   106: dup
    //   107: ldc 242
    //   109: invokespecial 245	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   112: aload_1
    //   113: arraylength
    //   114: invokevirtual 249	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   117: ldc 251
    //   119: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: lload_2
    //   123: invokevirtual 257	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   126: ldc_w 259
    //   129: invokevirtual 254	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: iload 4
    //   134: invokevirtual 262	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   137: invokevirtual 265	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokestatic 103	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   143: aload_0
    //   144: getfield 73	com/tencent/mm/media/d/a:eUg	Landroid/media/MediaCodec;
    //   147: ldc2_w 114
    //   150: invokevirtual 269	android/media/MediaCodec:dequeueInputBuffer	(J)I
    //   153: istore 6
    //   155: iload 6
    //   157: ifge +15 -> 172
    //   160: ldc 96
    //   162: ldc_w 271
    //   165: invokestatic 137	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   168: aload_0
    //   169: invokespecial 273	com/tencent/mm/media/d/c:UR	()V
    //   172: iload 6
    //   174: iflt +97 -> 271
    //   177: aload_0
    //   178: getfield 73	com/tencent/mm/media/d/a:eUg	Landroid/media/MediaCodec;
    //   181: invokevirtual 276	android/media/MediaCodec:getInputBuffers	()[Ljava/nio/ByteBuffer;
    //   184: iload 6
    //   186: aaload
    //   187: astore 7
    //   189: aload 7
    //   191: ifnull +9 -> 200
    //   194: aload 7
    //   196: invokevirtual 282	java/nio/ByteBuffer:clear	()Ljava/nio/Buffer;
    //   199: pop
    //   200: aload 7
    //   202: ifnull +10 -> 212
    //   205: aload 7
    //   207: iconst_0
    //   208: invokevirtual 286	java/nio/ByteBuffer:position	(I)Ljava/nio/Buffer;
    //   211: pop
    //   212: aload 7
    //   214: ifnull +10 -> 224
    //   217: aload 7
    //   219: aload_1
    //   220: invokevirtual 290	java/nio/ByteBuffer:put	([B)Ljava/nio/ByteBuffer;
    //   223: pop
    //   224: iload 4
    //   226: ifeq +85 -> 311
    //   229: ldc 96
    //   231: ldc_w 292
    //   234: invokestatic 103	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   237: iconst_1
    //   238: istore 5
    //   240: aload_0
    //   241: invokevirtual 295	com/tencent/mm/media/d/c:releaseEncoder	()V
    //   244: iload 5
    //   246: ifeq +48 -> 294
    //   249: ldc 96
    //   251: ldc_w 297
    //   254: invokestatic 103	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   257: aload_0
    //   258: getfield 73	com/tencent/mm/media/d/a:eUg	Landroid/media/MediaCodec;
    //   261: iload 6
    //   263: iconst_0
    //   264: aload_1
    //   265: arraylength
    //   266: lload_2
    //   267: iconst_4
    //   268: invokevirtual 301	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   271: aload_0
    //   272: invokespecial 273	com/tencent/mm/media/d/c:UR	()V
    //   275: sipush 12932
    //   278: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   281: return
    //   282: astore_1
    //   283: aload 7
    //   285: monitorexit
    //   286: sipush 12932
    //   289: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   292: aload_1
    //   293: athrow
    //   294: aload_0
    //   295: getfield 73	com/tencent/mm/media/d/a:eUg	Landroid/media/MediaCodec;
    //   298: iload 6
    //   300: iconst_0
    //   301: aload_1
    //   302: arraylength
    //   303: lload_2
    //   304: iconst_0
    //   305: invokevirtual 301	android/media/MediaCodec:queueInputBuffer	(IIIJI)V
    //   308: goto -37 -> 271
    //   311: iconst_0
    //   312: istore 5
    //   314: goto -70 -> 244
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	317	0	this	c
    //   0	317	1	paramArrayOfByte	byte[]
    //   0	317	2	paramLong	long
    //   0	317	4	paramBoolean	boolean
    //   238	75	5	i	int
    //   153	146	6	j	int
    //   89	1	8	localy	y
    // Exception table:
    //   from	to	target	type
    //   16	29	63	java/lang/Exception
    //   30	39	63	java/lang/Exception
    //   53	62	63	java/lang/Exception
    //   91	155	63	java/lang/Exception
    //   160	172	63	java/lang/Exception
    //   177	189	63	java/lang/Exception
    //   194	200	63	java/lang/Exception
    //   205	212	63	java/lang/Exception
    //   217	224	63	java/lang/Exception
    //   229	237	63	java/lang/Exception
    //   240	244	63	java/lang/Exception
    //   249	271	63	java/lang/Exception
    //   271	275	63	java/lang/Exception
    //   283	294	63	java/lang/Exception
    //   294	308	63	java/lang/Exception
    //   39	53	282	finally
    //   86	91	282	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.media.d.c
 * JD-Core Version:    0.7.0.1
 */
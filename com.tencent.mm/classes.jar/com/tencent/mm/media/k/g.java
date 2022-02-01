package com.tencent.mm.media.k;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/util/VideoColorSpaceDetector;", "", "()V", "DECODE_TIMEOUT", "", "MaxDetectFrameCount", "", "TAG", "", "TIMEOUT", "extractRealVideoFormat", "Landroid/media/MediaFormat;", "src", "loadVideoColorSpace", "Lcom/tencent/mm/media/util/VideoColorSpaceDetector$VideoColorSpace;", "setNativeColorSpaceInfo", "", "bufId", "colorSpace", "VideoColorSpace", "plugin-mediaeditor_release"})
public final class g
{
  public static final g laC;
  
  static
  {
    AppMethodBeat.i(258268);
    laC = new g();
    AppMethodBeat.o(258268);
  }
  
  public static a OE(String paramString)
  {
    AppMethodBeat.i(258265);
    p.k(paramString, "src");
    if (((b)h.ae(b.class)).a(b.a.wci, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.VideoColorSpaceDetector", "exportColorSpace:".concat(String.valueOf(bool)));
      if ((Build.VERSION.SDK_INT < 24) || (!bool)) {
        break label199;
      }
      long l = Util.currentTicks();
      paramString = OF(paramString);
      if (paramString == null) {
        break label199;
      }
      try
      {
        int i = e.a(paramString, "color-range");
        int j = e.a(paramString, "color-standard");
        int k = e.a(paramString, "color-transfer");
        Log.i("MicroMsg.VideoColorSpaceDetector", "find colorSpace! colorRange:" + i + ", colorStandard:" + j + ", colorTransfer:" + k + ", cost:" + Util.ticksToNow(l));
        paramString = new a(i, j, k);
        AppMethodBeat.o(258265);
        return paramString;
      }
      catch (Exception paramString)
      {
        Log.e("MicroMsg.VideoColorSpaceDetector", "extract color space info fail:" + paramString.getLocalizedMessage());
      }
    }
    label199:
    AppMethodBeat.o(258265);
    return null;
  }
  
  /* Error */
  private static android.media.MediaFormat OF(String paramString)
  {
    // Byte code:
    //   0: ldc 169
    //   2: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 175	com/tencent/mm/vfs/u:agG	(Ljava/lang/String;)Z
    //   9: ifne +24 -> 33
    //   12: ldc 82
    //   14: ldc 177
    //   16: aload_0
    //   17: invokestatic 180	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   20: invokevirtual 94	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   23: invokestatic 99	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   26: ldc 169
    //   28: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   31: aconst_null
    //   32: areturn
    //   33: new 182	com/tencent/mm/media/f/a
    //   36: dup
    //   37: aload_0
    //   38: invokespecial 183	com/tencent/mm/media/f/a:<init>	(Ljava/lang/String;)V
    //   41: astore 9
    //   43: aload 9
    //   45: invokevirtual 186	com/tencent/mm/media/f/a:aUG	()V
    //   48: aload 9
    //   50: getfield 189	com/tencent/mm/media/f/a:kUV	Landroid/media/MediaFormat;
    //   53: astore_0
    //   54: aload_0
    //   55: ifnull +133 -> 188
    //   58: aload_0
    //   59: ldc 117
    //   61: invokestatic 122	com/tencent/mm/media/k/e:a	(Landroid/media/MediaFormat;Ljava/lang/String;)I
    //   64: istore_2
    //   65: aload_0
    //   66: ldc 124
    //   68: invokestatic 122	com/tencent/mm/media/k/e:a	(Landroid/media/MediaFormat;Ljava/lang/String;)I
    //   71: istore_1
    //   72: aload_0
    //   73: ldc 126
    //   75: invokestatic 122	com/tencent/mm/media/k/e:a	(Landroid/media/MediaFormat;Ljava/lang/String;)I
    //   78: istore_3
    //   79: ldc 65
    //   81: invokestatic 71	com/tencent/mm/kernel/h:ae	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   84: checkcast 65	com/tencent/mm/plugin/expt/b/b
    //   87: getstatic 192	com/tencent/mm/plugin/expt/b/b$a:wcj	Lcom/tencent/mm/plugin/expt/b/b$a;
    //   90: iconst_1
    //   91: invokeinterface 80 3 0
    //   96: iconst_1
    //   97: if_icmpne +403 -> 500
    //   100: iconst_1
    //   101: istore 6
    //   103: ldc 82
    //   105: new 128	java/lang/StringBuilder
    //   108: dup
    //   109: ldc 194
    //   111: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   114: iload_2
    //   115: invokevirtual 137	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   118: ldc 139
    //   120: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: iload_1
    //   124: invokevirtual 137	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   127: ldc 144
    //   129: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: iload_3
    //   133: invokevirtual 137	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   136: ldc 196
    //   138: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: iload 6
    //   143: invokevirtual 199	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   146: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokestatic 99	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   152: iload 6
    //   154: ifne +34 -> 188
    //   157: iload_2
    //   158: ifne +30 -> 188
    //   161: iload_1
    //   162: ifne +26 -> 188
    //   165: iload_3
    //   166: ifne +22 -> 188
    //   169: ldc 82
    //   171: ldc 201
    //   173: invokestatic 99	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   176: aload 9
    //   178: invokevirtual 204	com/tencent/mm/media/f/a:release	()V
    //   181: ldc 169
    //   183: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   186: aconst_null
    //   187: areturn
    //   188: aload 9
    //   190: invokevirtual 207	com/tencent/mm/media/f/a:aUI	()Ljava/lang/String;
    //   193: invokestatic 213	com/tencent/mm/compatible/deviceinfo/aa:KR	(Ljava/lang/String;)Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   196: astore 10
    //   198: aload 10
    //   200: aload 9
    //   202: getfield 189	com/tencent/mm/media/f/a:kUV	Landroid/media/MediaFormat;
    //   205: aconst_null
    //   206: iconst_0
    //   207: invokevirtual 216	com/tencent/mm/compatible/deviceinfo/aa:a	(Landroid/media/MediaFormat;Landroid/view/Surface;I)V
    //   210: aload 10
    //   212: invokevirtual 219	com/tencent/mm/compatible/deviceinfo/aa:start	()V
    //   215: new 221	android/media/MediaCodec$BufferInfo
    //   218: dup
    //   219: invokespecial 222	android/media/MediaCodec$BufferInfo:<init>	()V
    //   222: astore_0
    //   223: iconst_0
    //   224: istore_2
    //   225: iconst_0
    //   226: istore_3
    //   227: iload_2
    //   228: bipush 30
    //   230: if_icmpgt +255 -> 485
    //   233: iload_3
    //   234: istore_1
    //   235: iload_3
    //   236: ifne +82 -> 318
    //   239: aload 10
    //   241: ldc2_w 223
    //   244: invokevirtual 228	com/tencent/mm/compatible/deviceinfo/aa:EX	(J)I
    //   247: istore 4
    //   249: iload_3
    //   250: istore_1
    //   251: iload 4
    //   253: iflt +65 -> 318
    //   256: aload 10
    //   258: iload 4
    //   260: invokevirtual 232	com/tencent/mm/compatible/deviceinfo/aa:getInputBuffer	(I)Ljava/nio/ByteBuffer;
    //   263: astore 11
    //   265: aload 11
    //   267: ldc 234
    //   269: invokestatic 237	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   272: aload 9
    //   274: aload 11
    //   276: invokestatic 240	com/tencent/mm/media/f/a:a	(Lcom/tencent/mm/media/f/a;Ljava/nio/ByteBuffer;)Z
    //   279: ifeq +166 -> 445
    //   282: aload 9
    //   284: invokevirtual 243	com/tencent/mm/media/f/a:getSampleTime	()J
    //   287: lstore 7
    //   289: aload 9
    //   291: getfield 246	com/tencent/mm/media/f/a:sampleSize	I
    //   294: istore 5
    //   296: iload 5
    //   298: ifge +137 -> 435
    //   301: iconst_1
    //   302: istore_1
    //   303: goto +203 -> 506
    //   306: aload 10
    //   308: iload 4
    //   310: iload 5
    //   312: lload 7
    //   314: iload_3
    //   315: invokevirtual 249	com/tencent/mm/compatible/deviceinfo/aa:a	(IIJI)V
    //   318: aload 10
    //   320: aload_0
    //   321: ldc2_w 250
    //   324: invokevirtual 254	com/tencent/mm/compatible/deviceinfo/aa:a	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   327: istore_3
    //   328: iload_3
    //   329: bipush 254
    //   331: if_icmpne +119 -> 450
    //   334: aload 10
    //   336: ldc_w 256
    //   339: invokestatic 237	kotlin/g/b/p:j	(Ljava/lang/Object;Ljava/lang/String;)V
    //   342: aload 10
    //   344: invokevirtual 260	com/tencent/mm/compatible/deviceinfo/aa:avi	()Landroid/media/MediaFormat;
    //   347: astore_0
    //   348: ldc 82
    //   350: new 128	java/lang/StringBuilder
    //   353: dup
    //   354: ldc_w 262
    //   357: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   360: aload_0
    //   361: invokevirtual 265	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   364: ldc_w 267
    //   367: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   370: iload_2
    //   371: invokevirtual 137	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   374: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   377: invokestatic 99	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   380: aload 9
    //   382: invokevirtual 204	com/tencent/mm/media/f/a:release	()V
    //   385: aload 10
    //   387: invokevirtual 270	com/tencent/mm/compatible/deviceinfo/aa:stop	()V
    //   390: aload 10
    //   392: invokevirtual 271	com/tencent/mm/compatible/deviceinfo/aa:release	()V
    //   395: ldc 169
    //   397: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   400: aload_0
    //   401: areturn
    //   402: astore_0
    //   403: ldc 82
    //   405: new 128	java/lang/StringBuilder
    //   408: dup
    //   409: ldc_w 273
    //   412: invokespecial 133	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   415: aload_0
    //   416: invokevirtual 276	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   419: invokevirtual 142	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   422: invokevirtual 157	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   425: invokestatic 168	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   428: ldc 169
    //   430: invokestatic 49	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   433: aconst_null
    //   434: areturn
    //   435: iconst_0
    //   436: istore_1
    //   437: goto +69 -> 506
    //   440: iconst_0
    //   441: istore_3
    //   442: goto -136 -> 306
    //   445: aconst_null
    //   446: astore_0
    //   447: goto -67 -> 380
    //   450: iload_3
    //   451: iflt +15 -> 466
    //   454: aload 10
    //   456: iload_3
    //   457: iconst_0
    //   458: invokevirtual 280	com/tencent/mm/compatible/deviceinfo/aa:releaseOutputBuffer	(IZ)V
    //   461: aconst_null
    //   462: astore_0
    //   463: goto -83 -> 380
    //   466: iload_2
    //   467: iconst_1
    //   468: iadd
    //   469: istore_2
    //   470: iload_1
    //   471: istore_3
    //   472: goto -245 -> 227
    //   475: astore_0
    //   476: iconst_0
    //   477: istore_1
    //   478: goto +17 -> 495
    //   481: astore_0
    //   482: goto +13 -> 495
    //   485: aconst_null
    //   486: astore_0
    //   487: goto -107 -> 380
    //   490: astore_0
    //   491: iconst_0
    //   492: istore_1
    //   493: iconst_0
    //   494: istore_2
    //   495: iconst_0
    //   496: istore_3
    //   497: goto -418 -> 79
    //   500: iconst_0
    //   501: istore 6
    //   503: goto -400 -> 103
    //   506: iload_1
    //   507: ifeq -67 -> 440
    //   510: iconst_4
    //   511: istore_3
    //   512: goto -206 -> 306
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	515	0	paramString	String
    //   71	436	1	i	int
    //   64	431	2	j	int
    //   78	434	3	k	int
    //   247	62	4	m	int
    //   294	17	5	n	int
    //   101	401	6	bool	boolean
    //   287	26	7	l	long
    //   41	340	9	locala	com.tencent.mm.media.f.a
    //   196	259	10	localaa	com.tencent.mm.compatible.deviceinfo.aa
    //   263	12	11	localByteBuffer	java.nio.ByteBuffer
    // Exception table:
    //   from	to	target	type
    //   5	31	402	java/lang/Exception
    //   33	54	402	java/lang/Exception
    //   79	100	402	java/lang/Exception
    //   103	152	402	java/lang/Exception
    //   169	186	402	java/lang/Exception
    //   188	223	402	java/lang/Exception
    //   239	249	402	java/lang/Exception
    //   256	296	402	java/lang/Exception
    //   306	318	402	java/lang/Exception
    //   318	328	402	java/lang/Exception
    //   334	380	402	java/lang/Exception
    //   380	400	402	java/lang/Exception
    //   454	461	402	java/lang/Exception
    //   65	72	475	java/lang/Exception
    //   72	79	481	java/lang/Exception
    //   58	65	490	java/lang/Exception
  }
  
  public static void a(int paramInt, a parama)
  {
    AppMethodBeat.i(258267);
    p.k(parama, "colorSpace");
    if (paramInt >= 0)
    {
      List localList2 = (List)new ArrayList();
      List localList1 = (List)new ArrayList();
      localList2.add("color-range");
      localList1.add(Integer.valueOf(parama.colorRange));
      localList2.add("color-standard");
      localList1.add(Integer.valueOf(parama.colorStandard));
      localList2.add("color-transfer");
      localList1.add(Integer.valueOf(parama.colorTransfer));
      Log.i("MicroMsg.VideoColorSpaceDetector", "mediaFormatKeys:" + localList2 + ", mediaFormatValues:" + localList1);
      int i;
      if (!((Collection)localList2).isEmpty()) {
        i = 1;
      }
      while (i != 0)
      {
        parama = ((Collection)localList2).toArray(new String[0]);
        if (parama == null)
        {
          parama = new t("null cannot be cast to non-null type kotlin.Array<T>");
          AppMethodBeat.o(258267);
          throw parama;
          i = 0;
        }
        else
        {
          SightVideoJNI.setVideoFormatHeader(paramInt, (String[])parama, j.s((Collection)localList1));
        }
      }
    }
    AppMethodBeat.o(258267);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/media/util/VideoColorSpaceDetector$VideoColorSpace;", "", "colorRange", "", "colorStandard", "colorTransfer", "(III)V", "getColorRange", "()I", "getColorStandard", "getColorTransfer", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-mediaeditor_release"})
  public static final class a
  {
    public final int colorRange;
    public final int colorStandard;
    public final int colorTransfer;
    
    public a(int paramInt1, int paramInt2, int paramInt3)
    {
      this.colorRange = paramInt1;
      this.colorStandard = paramInt2;
      this.colorTransfer = paramInt3;
    }
    
    public final boolean equals(Object paramObject)
    {
      if (this != paramObject)
      {
        if ((paramObject instanceof a))
        {
          paramObject = (a)paramObject;
          if ((this.colorRange != paramObject.colorRange) || (this.colorStandard != paramObject.colorStandard) || (this.colorTransfer != paramObject.colorTransfer)) {}
        }
      }
      else {
        return true;
      }
      return false;
    }
    
    public final int hashCode()
    {
      return (this.colorRange * 31 + this.colorStandard) * 31 + this.colorTransfer;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(263572);
      String str = "VideoColorSpace(colorRange=" + this.colorRange + ", colorStandard=" + this.colorStandard + ", colorTransfer=" + this.colorTransfer + ")";
      AppMethodBeat.o(263572);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.media.k.g
 * JD-Core Version:    0.7.0.1
 */
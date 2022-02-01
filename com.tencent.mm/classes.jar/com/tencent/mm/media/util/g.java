package com.tencent.mm.media.util;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/util/VideoColorSpaceDetector;", "", "()V", "DECODE_TIMEOUT", "", "MaxDetectFrameCount", "", "TAG", "", "TIMEOUT", "extractRealVideoFormat", "Landroid/media/MediaFormat;", "src", "loadVideoColorSpace", "Lcom/tencent/mm/media/util/VideoColorSpaceDetector$VideoColorSpace;", "setNativeColorSpaceInfo", "", "bufId", "colorSpace", "VideoColorSpace", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final g nFH;
  
  static
  {
    AppMethodBeat.i(236959);
    nFH = new g();
    AppMethodBeat.o(236959);
  }
  
  public static a GU(String paramString)
  {
    AppMethodBeat.i(236938);
    s.u(paramString, "src");
    if (((c)h.ax(c.class)).a(c.a.zvO, 1) == 1) {}
    for (boolean bool = true;; bool = false)
    {
      Log.i("MicroMsg.VideoColorSpaceDetector", s.X("exportColorSpace:", Boolean.valueOf(bool)));
      if ((Build.VERSION.SDK_INT < 24) || (!bool)) {
        break label189;
      }
      long l = Util.currentTicks();
      paramString = GV(paramString);
      if (paramString == null) {
        break label189;
      }
      try
      {
        int i = e.a(paramString, "color-range");
        int j = e.a(paramString, "color-standard");
        int k = e.a(paramString, "color-transfer");
        Log.i("MicroMsg.VideoColorSpaceDetector", "find colorSpace! colorRange:" + i + ", colorStandard:" + j + ", colorTransfer:" + k + ", cost:" + Util.ticksToNow(l));
        paramString = new a(i, j, k);
        AppMethodBeat.o(236938);
        return paramString;
      }
      catch (Exception paramString)
      {
        Log.e("MicroMsg.VideoColorSpaceDetector", s.X("extract color space info fail:", paramString.getLocalizedMessage()));
      }
    }
    label189:
    AppMethodBeat.o(236938);
    return null;
  }
  
  /* Error */
  private static android.media.MediaFormat GV(String paramString)
  {
    // Byte code:
    //   0: ldc 172
    //   2: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokestatic 178	com/tencent/mm/vfs/y:ZC	(Ljava/lang/String;)Z
    //   9: ifne +21 -> 30
    //   12: ldc 85
    //   14: ldc 180
    //   16: aload_0
    //   17: invokestatic 97	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   20: invokestatic 102	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   23: ldc 172
    //   25: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   28: aconst_null
    //   29: areturn
    //   30: new 182	com/tencent/mm/media/f/a
    //   33: dup
    //   34: aload_0
    //   35: invokespecial 183	com/tencent/mm/media/f/a:<init>	(Ljava/lang/String;)V
    //   38: astore 9
    //   40: aload 9
    //   42: invokevirtual 186	com/tencent/mm/media/f/a:bpn	()V
    //   45: aload 9
    //   47: getfield 189	com/tencent/mm/media/f/a:nAs	Landroid/media/MediaFormat;
    //   50: astore_0
    //   51: aload_0
    //   52: ifnull +133 -> 185
    //   55: aload_0
    //   56: ldc 120
    //   58: invokestatic 125	com/tencent/mm/media/util/e:a	(Landroid/media/MediaFormat;Ljava/lang/String;)I
    //   61: istore_2
    //   62: aload_0
    //   63: ldc 127
    //   65: invokestatic 125	com/tencent/mm/media/util/e:a	(Landroid/media/MediaFormat;Ljava/lang/String;)I
    //   68: istore_1
    //   69: aload_0
    //   70: ldc 129
    //   72: invokestatic 125	com/tencent/mm/media/util/e:a	(Landroid/media/MediaFormat;Ljava/lang/String;)I
    //   75: istore_3
    //   76: ldc 68
    //   78: invokestatic 74	com/tencent/mm/kernel/h:ax	(Ljava/lang/Class;)Lcom/tencent/mm/kernel/c/a;
    //   81: checkcast 68	com/tencent/mm/plugin/expt/b/c
    //   84: getstatic 192	com/tencent/mm/plugin/expt/b/c$a:zvP	Lcom/tencent/mm/plugin/expt/b/c$a;
    //   87: iconst_1
    //   88: invokeinterface 83 3 0
    //   93: iconst_1
    //   94: if_icmpne +410 -> 504
    //   97: iconst_1
    //   98: istore 6
    //   100: ldc 85
    //   102: new 131	java/lang/StringBuilder
    //   105: dup
    //   106: ldc 194
    //   108: invokespecial 136	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   111: iload_2
    //   112: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   115: ldc 142
    //   117: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   120: iload_1
    //   121: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   124: ldc 147
    //   126: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: iload_3
    //   130: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   133: ldc 196
    //   135: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   138: iload 6
    //   140: invokevirtual 199	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   143: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   146: invokestatic 102	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   149: iload 6
    //   151: ifne +34 -> 185
    //   154: iload_2
    //   155: ifne +30 -> 185
    //   158: iload_1
    //   159: ifne +26 -> 185
    //   162: iload_3
    //   163: ifne +22 -> 185
    //   166: ldc 85
    //   168: ldc 201
    //   170: invokestatic 102	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   173: aload 9
    //   175: invokevirtual 204	com/tencent/mm/media/f/a:release	()V
    //   178: ldc 172
    //   180: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   183: aconst_null
    //   184: areturn
    //   185: aload 9
    //   187: invokevirtual 207	com/tencent/mm/media/f/a:bpp	()Ljava/lang/String;
    //   190: invokestatic 213	com/tencent/mm/compatible/deviceinfo/aa:Dw	(Ljava/lang/String;)Lcom/tencent/mm/compatible/deviceinfo/aa;
    //   193: astore 10
    //   195: iconst_1
    //   196: iconst_1
    //   197: iconst_1
    //   198: iconst_1
    //   199: invokestatic 219	android/media/ImageReader:newInstance	(IIII)Landroid/media/ImageReader;
    //   202: astore 11
    //   204: aload 11
    //   206: ldc 221
    //   208: invokestatic 224	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   211: aload 10
    //   213: aload 9
    //   215: getfield 189	com/tencent/mm/media/f/a:nAs	Landroid/media/MediaFormat;
    //   218: aload 11
    //   220: invokevirtual 228	android/media/ImageReader:getSurface	()Landroid/view/Surface;
    //   223: iconst_0
    //   224: invokevirtual 231	com/tencent/mm/compatible/deviceinfo/aa:a	(Landroid/media/MediaFormat;Landroid/view/Surface;I)V
    //   227: aload 10
    //   229: invokevirtual 234	com/tencent/mm/compatible/deviceinfo/aa:start	()V
    //   232: new 236	android/media/MediaCodec$BufferInfo
    //   235: dup
    //   236: invokespecial 237	android/media/MediaCodec$BufferInfo:<init>	()V
    //   239: astore_0
    //   240: iconst_0
    //   241: istore_2
    //   242: iconst_0
    //   243: istore_3
    //   244: iload_2
    //   245: bipush 30
    //   247: if_icmpgt +242 -> 489
    //   250: iload_3
    //   251: istore_1
    //   252: iload_3
    //   253: ifne +82 -> 335
    //   256: aload 10
    //   258: ldc2_w 238
    //   261: invokevirtual 243	com/tencent/mm/compatible/deviceinfo/aa:dequeueInputBuffer	(J)I
    //   264: istore 4
    //   266: iload_3
    //   267: istore_1
    //   268: iload 4
    //   270: iflt +65 -> 335
    //   273: aload 10
    //   275: iload 4
    //   277: invokevirtual 247	com/tencent/mm/compatible/deviceinfo/aa:getInputBuffer	(I)Ljava/nio/ByteBuffer;
    //   280: astore 12
    //   282: aload 12
    //   284: ldc 249
    //   286: invokestatic 224	kotlin/g/b/s:s	(Ljava/lang/Object;Ljava/lang/String;)V
    //   289: aload 9
    //   291: aload 12
    //   293: invokestatic 252	com/tencent/mm/media/f/a:a	(Lcom/tencent/mm/media/f/a;Ljava/nio/ByteBuffer;)Z
    //   296: ifeq +153 -> 449
    //   299: aload 9
    //   301: invokevirtual 255	com/tencent/mm/media/f/a:getSampleTime	()J
    //   304: lstore 7
    //   306: aload 9
    //   308: getfield 258	com/tencent/mm/media/f/a:sampleSize	I
    //   311: istore 5
    //   313: iload 5
    //   315: ifge +124 -> 439
    //   318: iconst_1
    //   319: istore_1
    //   320: goto +190 -> 510
    //   323: aload 10
    //   325: iload 4
    //   327: iload 5
    //   329: lload 7
    //   331: iload_3
    //   332: invokevirtual 261	com/tencent/mm/compatible/deviceinfo/aa:a	(IIJI)V
    //   335: aload 10
    //   337: aload_0
    //   338: ldc2_w 262
    //   341: invokevirtual 267	com/tencent/mm/compatible/deviceinfo/aa:dequeueOutputBuffer	(Landroid/media/MediaCodec$BufferInfo;J)I
    //   344: istore_3
    //   345: iload_3
    //   346: bipush 254
    //   348: if_icmpne +106 -> 454
    //   351: aload 10
    //   353: invokevirtual 271	com/tencent/mm/compatible/deviceinfo/aa:getOutputFormat	()Landroid/media/MediaFormat;
    //   356: astore_0
    //   357: ldc 85
    //   359: new 131	java/lang/StringBuilder
    //   362: dup
    //   363: ldc_w 273
    //   366: invokespecial 136	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   369: aload_0
    //   370: invokevirtual 276	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   373: ldc_w 278
    //   376: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   379: iload_2
    //   380: invokevirtual 140	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   383: invokevirtual 160	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   386: invokestatic 102	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   389: aload 9
    //   391: invokevirtual 204	com/tencent/mm/media/f/a:release	()V
    //   394: aload 10
    //   396: invokevirtual 281	com/tencent/mm/compatible/deviceinfo/aa:stop	()V
    //   399: aload 10
    //   401: invokevirtual 282	com/tencent/mm/compatible/deviceinfo/aa:release	()V
    //   404: aload 11
    //   406: invokevirtual 285	android/media/ImageReader:close	()V
    //   409: ldc 172
    //   411: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   414: aload_0
    //   415: areturn
    //   416: astore_0
    //   417: ldc 85
    //   419: ldc_w 287
    //   422: aload_0
    //   423: invokevirtual 290	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   426: invokestatic 97	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   429: invokestatic 171	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   432: ldc 172
    //   434: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   437: aconst_null
    //   438: areturn
    //   439: iconst_0
    //   440: istore_1
    //   441: goto +69 -> 510
    //   444: iconst_0
    //   445: istore_3
    //   446: goto -123 -> 323
    //   449: aconst_null
    //   450: astore_0
    //   451: goto -62 -> 389
    //   454: iload_3
    //   455: iflt +15 -> 470
    //   458: aload 10
    //   460: iload_3
    //   461: iconst_0
    //   462: invokevirtual 294	com/tencent/mm/compatible/deviceinfo/aa:releaseOutputBuffer	(IZ)V
    //   465: aconst_null
    //   466: astore_0
    //   467: goto -78 -> 389
    //   470: iload_2
    //   471: iconst_1
    //   472: iadd
    //   473: istore_2
    //   474: iload_1
    //   475: istore_3
    //   476: goto -232 -> 244
    //   479: astore_0
    //   480: iconst_0
    //   481: istore_1
    //   482: goto +17 -> 499
    //   485: astore_0
    //   486: goto +13 -> 499
    //   489: aconst_null
    //   490: astore_0
    //   491: goto -102 -> 389
    //   494: astore_0
    //   495: iconst_0
    //   496: istore_1
    //   497: iconst_0
    //   498: istore_2
    //   499: iconst_0
    //   500: istore_3
    //   501: goto -425 -> 76
    //   504: iconst_0
    //   505: istore 6
    //   507: goto -407 -> 100
    //   510: iload_1
    //   511: ifeq -67 -> 444
    //   514: iconst_4
    //   515: istore_3
    //   516: goto -193 -> 323
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	519	0	paramString	String
    //   68	443	1	i	int
    //   61	438	2	j	int
    //   75	441	3	k	int
    //   264	62	4	m	int
    //   311	17	5	n	int
    //   98	408	6	bool	boolean
    //   304	26	7	l	long
    //   38	352	9	locala	com.tencent.mm.media.f.a
    //   193	266	10	localaa	com.tencent.mm.compatible.deviceinfo.aa
    //   202	203	11	localImageReader	android.media.ImageReader
    //   280	12	12	localByteBuffer	java.nio.ByteBuffer
    // Exception table:
    //   from	to	target	type
    //   5	28	416	java/lang/Exception
    //   30	51	416	java/lang/Exception
    //   76	97	416	java/lang/Exception
    //   100	149	416	java/lang/Exception
    //   166	183	416	java/lang/Exception
    //   185	240	416	java/lang/Exception
    //   256	266	416	java/lang/Exception
    //   273	313	416	java/lang/Exception
    //   323	335	416	java/lang/Exception
    //   335	345	416	java/lang/Exception
    //   351	389	416	java/lang/Exception
    //   389	414	416	java/lang/Exception
    //   458	465	416	java/lang/Exception
    //   62	69	479	java/lang/Exception
    //   69	76	485	java/lang/Exception
    //   55	62	494	java/lang/Exception
  }
  
  public static void a(int paramInt, a parama)
  {
    AppMethodBeat.i(236957);
    s.u(parama, "colorSpace");
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
          parama = new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
          AppMethodBeat.o(236957);
          throw parama;
          i = 0;
        }
        else
        {
          SightVideoJNI.setVideoFormatHeader(paramInt, (String[])parama, p.I((Collection)localList1));
        }
      }
    }
    AppMethodBeat.o(236957);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/media/util/VideoColorSpaceDetector$VideoColorSpace;", "", "colorRange", "", "colorStandard", "colorTransfer", "(III)V", "getColorRange", "()I", "getColorStandard", "getColorTransfer", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "", "plugin-mediaeditor_release"}, k=1, mv={1, 5, 1}, xi=48)
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
      if (this == paramObject) {}
      do
      {
        return true;
        if (!(paramObject instanceof a)) {
          return false;
        }
        paramObject = (a)paramObject;
        if (this.colorRange != paramObject.colorRange) {
          return false;
        }
        if (this.colorStandard != paramObject.colorStandard) {
          return false;
        }
      } while (this.colorTransfer == paramObject.colorTransfer);
      return false;
    }
    
    public final int hashCode()
    {
      return (this.colorRange * 31 + this.colorStandard) * 31 + this.colorTransfer;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(236927);
      Object localObject = new JSONObject();
      ((JSONObject)localObject).put("colorRange", this.colorRange);
      ((JSONObject)localObject).put("colorStandard", this.colorStandard);
      ((JSONObject)localObject).put("colorTransfer", this.colorTransfer);
      localObject = ((JSONObject)localObject).toString();
      s.s(localObject, "jsonObj.toString()");
      localObject = n.bV((String)localObject, ",", ";");
      AppMethodBeat.o(236927);
      return localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.util.g
 * JD-Core Version:    0.7.0.1
 */
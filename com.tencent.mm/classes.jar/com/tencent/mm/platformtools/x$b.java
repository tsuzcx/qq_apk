package com.tencent.mm.platformtools;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.e;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.az;
import com.tencent.mm.sdk.platformtools.az.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

 enum x$b
{
  private static DisplayMetrics gjH;
  private Map<String, x.b.c> gjD;
  private Map<String, WeakReference<Bitmap>> gjE;
  private az gjF;
  private az gjG;
  
  static
  {
    AppMethodBeat.i(79030);
    gjC = new b("INSTANCE");
    gjI = new b[] { gjC };
    gjH = null;
    AppMethodBeat.o(79030);
  }
  
  private x$b()
  {
    AppMethodBeat.i(79018);
    this.gjD = new HashMap();
    this.gjE = new HashMap();
    this.gjF = null;
    this.gjG = null;
    AppMethodBeat.o(79018);
  }
  
  private static DisplayMetrics aow()
  {
    AppMethodBeat.i(79022);
    if (gjH == null) {
      gjH = ah.getContext().getResources().getDisplayMetrics();
    }
    DisplayMetrics localDisplayMetrics = gjH;
    AppMethodBeat.o(79022);
    return localDisplayMetrics;
  }
  
  private void b(v paramv, Bitmap paramBitmap)
  {
    AppMethodBeat.i(79021);
    Assert.assertTrue("picture strategy here must be validity", x.c(paramv));
    String str = paramv.getCacheKey();
    if (this.gjE.containsKey(str)) {}
    for (paramv = (Bitmap)((WeakReference)this.gjE.get(str)).get();; paramv = null)
    {
      if ((paramv == null) || (paramv.isRecycled()))
      {
        this.gjE.remove(str);
        this.gjE.put(str, new WeakReference(paramBitmap));
      }
      AppMethodBeat.o(79021);
      return;
    }
  }
  
  private Bitmap d(v paramv)
  {
    AppMethodBeat.i(79019);
    Assert.assertTrue("picture strategy here must be validity", x.c(paramv));
    String str = paramv.aoo();
    x.b.c localc = (x.b.c)this.gjD.get(str);
    Object localObject = localc;
    if (localc == null) {
      localObject = new x.b.c();
    }
    if (((x.b.c)localObject).gjL) {
      if (((x.b.c)localObject).gjM >= 3)
      {
        if (bo.gz(((x.b.c)localObject).gjN) < 120L)
        {
          ab.w("MicroMsg.MMPictureLogic", "download fail interval less than %d s for %s", new Object[] { Integer.valueOf(120), str });
          AppMethodBeat.o(79019);
          return null;
        }
        ((x.b.c)localObject).gjM = 0;
        ((x.b.c)localObject).gjL = false;
        ((x.b.c)localObject).gjN = ((int)bo.aox());
        this.gjD.put(str, localObject);
        label143:
        if (!paramv.aoq()) {
          break label368;
        }
        localObject = paramv.aom();
        if (localObject == null) {
          break label299;
        }
      }
    }
    label299:
    for (localObject = ((v.b)localObject).wv(paramv.aon());; localObject = wx(paramv.aon()))
    {
      if (localObject == null) {
        break label312;
      }
      paramv = a(paramv, (Bitmap)localObject);
      this.gjD.remove(str);
      AppMethodBeat.o(79019);
      return paramv;
      ((x.b.c)localObject).gjM += 1;
      break;
      if (bo.gz(((x.b.c)localObject).gjN) < 120L)
      {
        ab.d("MicroMsg.MMPictureLogic", "downloading interval less than %d s for %s", new Object[] { Integer.valueOf(120), str });
        AppMethodBeat.o(79019);
        return null;
      }
      ((x.b.c)localObject).gjM += 1;
      ((x.b.c)localObject).gjN = ((int)bo.aox());
      this.gjD.put(str, localObject);
      break label143;
    }
    label312:
    if ((this.gjF == null) || (this.gjF.dtw())) {
      this.gjF = new az(1, "readerapp-pic-logic-download", 3);
    }
    this.gjF.e(new a(paramv));
    AppMethodBeat.o(79019);
    return null;
    label368:
    if ((this.gjG == null) || (this.gjG.dtw())) {
      this.gjG = new az(1, "readerapp-pic-logic-reader", 1);
    }
    this.gjG.e(new b(paramv));
    AppMethodBeat.o(79019);
    return null;
  }
  
  public static Bitmap wx(String paramString)
  {
    AppMethodBeat.i(79024);
    DisplayMetrics localDisplayMetrics = aow();
    paramString = y(paramString, localDisplayMetrics.widthPixels, localDisplayMetrics.heightPixels);
    AppMethodBeat.o(79024);
    return paramString;
  }
  
  public static Bitmap wy(String paramString)
  {
    AppMethodBeat.i(79025);
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.MMPictureLogic", "error input, path is null");
      AppMethodBeat.o(79025);
      return null;
    }
    paramString = d.aA(paramString, 0, 0);
    AppMethodBeat.o(79025);
    return paramString;
  }
  
  public static Bitmap y(String paramString, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(79023);
    if (bo.isNullOrNil(paramString))
    {
      ab.w("MicroMsg.MMPictureLogic", "error input, path is null");
      AppMethodBeat.o(79023);
      return null;
    }
    if ((paramInt1 <= 0) || (paramInt2 <= 0))
    {
      ab.w("MicroMsg.MMPictureLogic", "error input, targetWidth %d, targetHeight %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
      AppMethodBeat.o(79023);
      return null;
    }
    paramString = d.aA(paramString, paramInt1, paramInt2);
    AppMethodBeat.o(79023);
    return paramString;
  }
  
  protected final Bitmap a(v paramv, Bitmap paramBitmap)
  {
    AppMethodBeat.i(79020);
    Assert.assertTrue("picture strategy here must be validity", x.c(paramv));
    Bitmap localBitmap;
    if (paramBitmap != null)
    {
      localBitmap = paramv.a(paramBitmap, v.a.gjy, paramv.aon());
      if ((localBitmap != paramBitmap) && (!paramBitmap.isRecycled()))
      {
        ab.i("MicroMsg.MMPictureLogic", "recycle bitmap:%s", new Object[] { paramBitmap.toString() });
        paramBitmap.recycle();
      }
      b(paramv, localBitmap);
    }
    for (paramv = localBitmap;; paramv = paramBitmap)
    {
      AppMethodBeat.o(79020);
      return paramv;
      paramv.a(v.a.gjy, null);
    }
  }
  
  static final class a
    implements az.a
  {
    private Bitmap frG;
    private int gjJ;
    private v gjK;
    
    public a(v paramv)
    {
      AppMethodBeat.i(79009);
      this.gjJ = 0;
      this.frG = null;
      if (!x.c(paramv))
      {
        paramv = new IllegalArgumentException("from net, picture strategy here must be validity");
        AppMethodBeat.o(79009);
        throw paramv;
      }
      this.gjK = paramv;
      AppMethodBeat.o(79009);
    }
    
    /* Error */
    public final boolean acS()
    {
      // Byte code:
      //   0: ldc 58
      //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 50	com/tencent/mm/platformtools/x$b$a:gjK	Lcom/tencent/mm/platformtools/v;
      //   9: ifnonnull +17 -> 26
      //   12: ldc 60
      //   14: ldc 62
      //   16: invokestatic 68	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   19: ldc 58
      //   21: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   24: iconst_1
      //   25: ireturn
      //   26: aload_0
      //   27: getfield 50	com/tencent/mm/platformtools/x$b$a:gjK	Lcom/tencent/mm/platformtools/v;
      //   30: invokeinterface 73 1 0
      //   35: new 75	java/io/File
      //   38: dup
      //   39: aload_0
      //   40: getfield 50	com/tencent/mm/platformtools/x$b$a:gjK	Lcom/tencent/mm/platformtools/v;
      //   43: invokeinterface 79 1 0
      //   48: invokespecial 80	java/io/File:<init>	(Ljava/lang/String;)V
      //   51: astore 8
      //   53: new 82	java/io/FileOutputStream
      //   56: dup
      //   57: new 84	java/lang/StringBuilder
      //   60: dup
      //   61: invokespecial 85	java/lang/StringBuilder:<init>	()V
      //   64: aload 8
      //   66: invokevirtual 88	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   69: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   72: ldc 94
      //   74: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   77: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   80: invokespecial 98	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
      //   83: astore 5
      //   85: aload_0
      //   86: getfield 50	com/tencent/mm/platformtools/x$b$a:gjK	Lcom/tencent/mm/platformtools/v;
      //   89: invokeinterface 101 1 0
      //   94: aconst_null
      //   95: invokestatic 106	com/tencent/mm/network/b:a	(Ljava/lang/String;Lcom/tencent/mm/network/b$b;)Lcom/tencent/mm/network/v;
      //   98: astore_3
      //   99: invokestatic 111	com/tencent/mm/at/q:ahJ	()Z
      //   102: ifeq +45 -> 147
      //   105: aload_0
      //   106: getfield 50	com/tencent/mm/platformtools/x$b$a:gjK	Lcom/tencent/mm/platformtools/v;
      //   109: invokeinterface 101 1 0
      //   114: invokestatic 115	com/tencent/mm/at/q:tv	(Ljava/lang/String;)Z
      //   117: ifeq +30 -> 147
      //   120: getstatic 120	com/tencent/mm/protocal/d:whH	I
      //   123: invokestatic 124	com/tencent/mm/at/q:lE	(I)Ljava/lang/String;
      //   126: astore_2
      //   127: ldc 60
      //   129: ldc 126
      //   131: iconst_1
      //   132: anewarray 4	java/lang/Object
      //   135: dup
      //   136: iconst_0
      //   137: aload_2
      //   138: aastore
      //   139: invokestatic 130	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   142: aload_3
      //   143: aload_2
      //   144: invokevirtual 135	com/tencent/mm/network/v:we	(Ljava/lang/String;)V
      //   147: aload_3
      //   148: sipush 10000
      //   151: invokevirtual 138	com/tencent/mm/network/v:setConnectTimeout	(I)V
      //   154: aload_3
      //   155: sipush 20000
      //   158: invokevirtual 141	com/tencent/mm/network/v:setReadTimeout	(I)V
      //   161: aload_3
      //   162: ldc 143
      //   164: invokevirtual 146	com/tencent/mm/network/v:setRequestMethod	(Ljava/lang/String;)V
      //   167: aload_3
      //   168: invokestatic 149	com/tencent/mm/network/b:a	(Lcom/tencent/mm/network/v;)I
      //   171: ifne +911 -> 1082
      //   174: aload_3
      //   175: invokevirtual 153	com/tencent/mm/network/v:getInputStream	()Ljava/io/InputStream;
      //   178: astore_2
      //   179: aload_2
      //   180: astore 7
      //   182: aload 5
      //   184: astore 6
      //   186: aload_3
      //   187: getfield 157	com/tencent/mm/network/v:connection	Ljava/net/HttpURLConnection;
      //   190: invokevirtual 162	java/net/HttpURLConnection:getContentType	()Ljava/lang/String;
      //   193: astore 4
      //   195: aload_2
      //   196: astore 7
      //   198: aload 5
      //   200: astore 6
      //   202: ldc 60
      //   204: ldc 164
      //   206: iconst_1
      //   207: anewarray 4	java/lang/Object
      //   210: dup
      //   211: iconst_0
      //   212: aload 4
      //   214: aastore
      //   215: invokestatic 130	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   218: aload_2
      //   219: ifnonnull +116 -> 335
      //   222: aload_2
      //   223: astore 7
      //   225: aload 5
      //   227: astore 6
      //   229: ldc 60
      //   231: ldc 166
      //   233: iconst_1
      //   234: anewarray 4	java/lang/Object
      //   237: dup
      //   238: iconst_0
      //   239: aload_0
      //   240: getfield 50	com/tencent/mm/platformtools/x$b$a:gjK	Lcom/tencent/mm/platformtools/v;
      //   243: invokeinterface 101 1 0
      //   248: aastore
      //   249: invokestatic 169	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   252: aload_2
      //   253: astore 7
      //   255: aload 5
      //   257: astore 6
      //   259: aload_0
      //   260: getfield 50	com/tencent/mm/platformtools/x$b$a:gjK	Lcom/tencent/mm/platformtools/v;
      //   263: aload 4
      //   265: iconst_0
      //   266: invokeinterface 173 3 0
      //   271: aload_2
      //   272: ifnull +7 -> 279
      //   275: aload_2
      //   276: invokevirtual 178	java/io/InputStream:close	()V
      //   279: aload 5
      //   281: invokevirtual 179	java/io/FileOutputStream:close	()V
      //   284: ldc 58
      //   286: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   289: iconst_1
      //   290: ireturn
      //   291: astore_2
      //   292: ldc 60
      //   294: ldc 181
      //   296: iconst_1
      //   297: anewarray 4	java/lang/Object
      //   300: dup
      //   301: iconst_0
      //   302: aload_2
      //   303: invokestatic 187	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   306: aastore
      //   307: invokestatic 189	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   310: goto -31 -> 279
      //   313: astore_2
      //   314: ldc 60
      //   316: ldc 181
      //   318: iconst_1
      //   319: anewarray 4	java/lang/Object
      //   322: dup
      //   323: iconst_0
      //   324: aload_2
      //   325: invokestatic 187	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   328: aastore
      //   329: invokestatic 189	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   332: goto -48 -> 284
      //   335: aload_2
      //   336: astore 7
      //   338: aload 5
      //   340: astore 6
      //   342: sipush 1024
      //   345: newarray byte
      //   347: astore_3
      //   348: aload_2
      //   349: astore 7
      //   351: aload 5
      //   353: astore 6
      //   355: aload_2
      //   356: aload_3
      //   357: invokevirtual 193	java/io/InputStream:read	([B)I
      //   360: istore_1
      //   361: iload_1
      //   362: iconst_m1
      //   363: if_icmpeq +138 -> 501
      //   366: aload_2
      //   367: astore 7
      //   369: aload 5
      //   371: astore 6
      //   373: aload_0
      //   374: aload_0
      //   375: getfield 32	com/tencent/mm/platformtools/x$b$a:gjJ	I
      //   378: iload_1
      //   379: iadd
      //   380: putfield 32	com/tencent/mm/platformtools/x$b$a:gjJ	I
      //   383: aload_2
      //   384: astore 7
      //   386: aload 5
      //   388: astore 6
      //   390: aload 5
      //   392: aload_3
      //   393: iconst_0
      //   394: iload_1
      //   395: invokevirtual 197	java/io/FileOutputStream:write	([BII)V
      //   398: goto -50 -> 348
      //   401: astore_3
      //   402: aload_2
      //   403: astore 7
      //   405: aload 5
      //   407: astore 6
      //   409: ldc 60
      //   411: ldc 181
      //   413: iconst_1
      //   414: anewarray 4	java/lang/Object
      //   417: dup
      //   418: iconst_0
      //   419: aload_3
      //   420: invokestatic 187	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   423: aastore
      //   424: invokestatic 189	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   427: aload_2
      //   428: astore 7
      //   430: aload 5
      //   432: astore 6
      //   434: ldc 60
      //   436: ldc 199
      //   438: iconst_1
      //   439: anewarray 4	java/lang/Object
      //   442: dup
      //   443: iconst_0
      //   444: aload_0
      //   445: getfield 50	com/tencent/mm/platformtools/x$b$a:gjK	Lcom/tencent/mm/platformtools/v;
      //   448: invokeinterface 101 1 0
      //   453: aastore
      //   454: invokestatic 169	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   457: aload_2
      //   458: astore 7
      //   460: aload 5
      //   462: astore 6
      //   464: aload_0
      //   465: getfield 50	com/tencent/mm/platformtools/x$b$a:gjK	Lcom/tencent/mm/platformtools/v;
      //   468: aload 4
      //   470: iconst_0
      //   471: invokeinterface 173 3 0
      //   476: aload_2
      //   477: ifnull +7 -> 484
      //   480: aload_2
      //   481: invokevirtual 178	java/io/InputStream:close	()V
      //   484: aload 5
      //   486: ifnull +8 -> 494
      //   489: aload 5
      //   491: invokevirtual 179	java/io/FileOutputStream:close	()V
      //   494: ldc 58
      //   496: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   499: iconst_1
      //   500: ireturn
      //   501: aload_2
      //   502: astore 7
      //   504: aload 5
      //   506: astore 6
      //   508: ldc 60
      //   510: ldc 201
      //   512: iconst_2
      //   513: anewarray 4	java/lang/Object
      //   516: dup
      //   517: iconst_0
      //   518: aload_0
      //   519: getfield 50	com/tencent/mm/platformtools/x$b$a:gjK	Lcom/tencent/mm/platformtools/v;
      //   522: invokeinterface 101 1 0
      //   527: aastore
      //   528: dup
      //   529: iconst_1
      //   530: aload_0
      //   531: getfield 32	com/tencent/mm/platformtools/x$b$a:gjJ	I
      //   534: invokestatic 207	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
      //   537: aastore
      //   538: invokestatic 209	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   541: aload_2
      //   542: astore 7
      //   544: aload 5
      //   546: astore 6
      //   548: aload_0
      //   549: getfield 50	com/tencent/mm/platformtools/x$b$a:gjK	Lcom/tencent/mm/platformtools/v;
      //   552: aload 4
      //   554: iconst_1
      //   555: invokeinterface 173 3 0
      //   560: aload_2
      //   561: ifnull +7 -> 568
      //   564: aload_2
      //   565: invokevirtual 178	java/io/InputStream:close	()V
      //   568: aload 5
      //   570: invokevirtual 179	java/io/FileOutputStream:close	()V
      //   573: new 84	java/lang/StringBuilder
      //   576: dup
      //   577: invokespecial 85	java/lang/StringBuilder:<init>	()V
      //   580: aload 8
      //   582: invokevirtual 88	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   585: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   588: ldc 94
      //   590: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   593: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   596: invokestatic 215	com/tencent/mm/a/g:getMD5	(Ljava/lang/String;)Ljava/lang/String;
      //   599: pop
      //   600: aload_0
      //   601: getfield 50	com/tencent/mm/platformtools/x$b$a:gjK	Lcom/tencent/mm/platformtools/v;
      //   604: invokeinterface 219 1 0
      //   609: astore_2
      //   610: aload_2
      //   611: ifnull +331 -> 942
      //   614: aload_2
      //   615: new 84	java/lang/StringBuilder
      //   618: dup
      //   619: invokespecial 85	java/lang/StringBuilder:<init>	()V
      //   622: aload 8
      //   624: invokevirtual 88	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   627: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   630: ldc 94
      //   632: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   635: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   638: invokeinterface 225 2 0
      //   643: astore_3
      //   644: aload_3
      //   645: ifnull +327 -> 972
      //   648: aload_0
      //   649: getfield 50	com/tencent/mm/platformtools/x$b$a:gjK	Lcom/tencent/mm/platformtools/v;
      //   652: aload_3
      //   653: getstatic 231	com/tencent/mm/platformtools/v$a:gjx	Lcom/tencent/mm/platformtools/v$a;
      //   656: new 84	java/lang/StringBuilder
      //   659: dup
      //   660: invokespecial 85	java/lang/StringBuilder:<init>	()V
      //   663: aload 8
      //   665: invokevirtual 88	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   668: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   671: ldc 94
      //   673: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   676: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   679: invokeinterface 234 4 0
      //   684: astore_2
      //   685: aload_2
      //   686: aload_3
      //   687: if_acmpeq +32 -> 719
      //   690: aload_3
      //   691: invokevirtual 239	android/graphics/Bitmap:isRecycled	()Z
      //   694: ifne +25 -> 719
      //   697: ldc 60
      //   699: ldc 241
      //   701: iconst_1
      //   702: anewarray 4	java/lang/Object
      //   705: dup
      //   706: iconst_0
      //   707: aload_3
      //   708: invokevirtual 242	java/lang/Object:toString	()Ljava/lang/String;
      //   711: aastore
      //   712: invokestatic 209	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   715: aload_3
      //   716: invokevirtual 245	android/graphics/Bitmap:recycle	()V
      //   719: getstatic 249	com/tencent/mm/platformtools/x$b:gjC	Lcom/tencent/mm/platformtools/x$b;
      //   722: aload_0
      //   723: getfield 50	com/tencent/mm/platformtools/x$b$a:gjK	Lcom/tencent/mm/platformtools/v;
      //   726: aload_2
      //   727: invokestatic 252	com/tencent/mm/platformtools/x$b:a	(Lcom/tencent/mm/platformtools/x$b;Lcom/tencent/mm/platformtools/v;Landroid/graphics/Bitmap;)V
      //   730: new 75	java/io/File
      //   733: dup
      //   734: new 84	java/lang/StringBuilder
      //   737: dup
      //   738: invokespecial 85	java/lang/StringBuilder:<init>	()V
      //   741: aload 8
      //   743: invokevirtual 88	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   746: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   749: ldc 94
      //   751: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   754: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   757: invokespecial 80	java/io/File:<init>	(Ljava/lang/String;)V
      //   760: invokevirtual 255	java/io/File:delete	()Z
      //   763: pop
      //   764: aload_0
      //   765: aload_2
      //   766: putfield 34	com/tencent/mm/platformtools/x$b$a:frG	Landroid/graphics/Bitmap;
      //   769: ldc 58
      //   771: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   774: iconst_1
      //   775: ireturn
      //   776: astore_2
      //   777: ldc 60
      //   779: ldc 181
      //   781: iconst_1
      //   782: anewarray 4	java/lang/Object
      //   785: dup
      //   786: iconst_0
      //   787: aload_2
      //   788: invokestatic 187	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   791: aastore
      //   792: invokestatic 189	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   795: goto -227 -> 568
      //   798: astore_2
      //   799: ldc 60
      //   801: ldc 181
      //   803: iconst_1
      //   804: anewarray 4	java/lang/Object
      //   807: dup
      //   808: iconst_0
      //   809: aload_2
      //   810: invokestatic 187	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   813: aastore
      //   814: invokestatic 189	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   817: goto -244 -> 573
      //   820: astore_2
      //   821: ldc 60
      //   823: ldc 181
      //   825: iconst_1
      //   826: anewarray 4	java/lang/Object
      //   829: dup
      //   830: iconst_0
      //   831: aload_2
      //   832: invokestatic 187	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   835: aastore
      //   836: invokestatic 189	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   839: goto -355 -> 484
      //   842: astore_2
      //   843: ldc 60
      //   845: ldc 181
      //   847: iconst_1
      //   848: anewarray 4	java/lang/Object
      //   851: dup
      //   852: iconst_0
      //   853: aload_2
      //   854: invokestatic 187	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   857: aastore
      //   858: invokestatic 189	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   861: goto -367 -> 494
      //   864: astore_2
      //   865: aconst_null
      //   866: astore 7
      //   868: aconst_null
      //   869: astore 5
      //   871: aload 7
      //   873: ifnull +8 -> 881
      //   876: aload 7
      //   878: invokevirtual 178	java/io/InputStream:close	()V
      //   881: aload 5
      //   883: ifnull +8 -> 891
      //   886: aload 5
      //   888: invokevirtual 179	java/io/FileOutputStream:close	()V
      //   891: ldc 58
      //   893: invokestatic 48	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   896: aload_2
      //   897: athrow
      //   898: astore_3
      //   899: ldc 60
      //   901: ldc 181
      //   903: iconst_1
      //   904: anewarray 4	java/lang/Object
      //   907: dup
      //   908: iconst_0
      //   909: aload_3
      //   910: invokestatic 187	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   913: aastore
      //   914: invokestatic 189	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   917: goto -36 -> 881
      //   920: astore_3
      //   921: ldc 60
      //   923: ldc 181
      //   925: iconst_1
      //   926: anewarray 4	java/lang/Object
      //   929: dup
      //   930: iconst_0
      //   931: aload_3
      //   932: invokestatic 187	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   935: aastore
      //   936: invokestatic 189	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   939: goto -48 -> 891
      //   942: new 84	java/lang/StringBuilder
      //   945: dup
      //   946: invokespecial 85	java/lang/StringBuilder:<init>	()V
      //   949: aload 8
      //   951: invokevirtual 88	java/io/File:getAbsolutePath	()Ljava/lang/String;
      //   954: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   957: ldc 94
      //   959: invokevirtual 92	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   962: invokevirtual 97	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   965: invokestatic 258	com/tencent/mm/platformtools/x$b:wx	(Ljava/lang/String;)Landroid/graphics/Bitmap;
      //   968: astore_3
      //   969: goto -325 -> 644
      //   972: aload_0
      //   973: getfield 50	com/tencent/mm/platformtools/x$b$a:gjK	Lcom/tencent/mm/platformtools/v;
      //   976: getstatic 231	com/tencent/mm/platformtools/v$a:gjx	Lcom/tencent/mm/platformtools/v$a;
      //   979: aload 4
      //   981: invokeinterface 261 3 0
      //   986: aconst_null
      //   987: astore_2
      //   988: goto -303 -> 685
      //   991: astore_2
      //   992: ldc 60
      //   994: ldc_w 263
      //   997: iconst_1
      //   998: anewarray 4	java/lang/Object
      //   1001: dup
      //   1002: iconst_0
      //   1003: aload_0
      //   1004: getfield 50	com/tencent/mm/platformtools/x$b$a:gjK	Lcom/tencent/mm/platformtools/v;
      //   1007: invokeinterface 101 1 0
      //   1012: aastore
      //   1013: invokestatic 169	com/tencent/mm/sdk/platformtools/ab:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1016: ldc 60
      //   1018: ldc 181
      //   1020: iconst_1
      //   1021: anewarray 4	java/lang/Object
      //   1024: dup
      //   1025: iconst_0
      //   1026: aload_2
      //   1027: invokestatic 187	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
      //   1030: aastore
      //   1031: invokestatic 189	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
      //   1034: aconst_null
      //   1035: astore_2
      //   1036: goto -272 -> 764
      //   1039: astore_2
      //   1040: aconst_null
      //   1041: astore 7
      //   1043: goto -172 -> 871
      //   1046: astore_2
      //   1047: aload 6
      //   1049: astore 5
      //   1051: goto -180 -> 871
      //   1054: astore_3
      //   1055: aconst_null
      //   1056: astore 4
      //   1058: aconst_null
      //   1059: astore_2
      //   1060: aconst_null
      //   1061: astore 5
      //   1063: goto -661 -> 402
      //   1066: astore_3
      //   1067: aconst_null
      //   1068: astore 4
      //   1070: aconst_null
      //   1071: astore_2
      //   1072: goto -670 -> 402
      //   1075: astore_3
      //   1076: aconst_null
      //   1077: astore 4
      //   1079: goto -677 -> 402
      //   1082: aconst_null
      //   1083: astore_2
      //   1084: goto -905 -> 179
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	1087	0	this	a
      //   360	35	1	i	int
      //   126	150	2	localObject1	Object
      //   291	12	2	localIOException1	java.io.IOException
      //   313	252	2	localIOException2	java.io.IOException
      //   609	157	2	localObject2	Object
      //   776	12	2	localIOException3	java.io.IOException
      //   798	12	2	localIOException4	java.io.IOException
      //   820	12	2	localIOException5	java.io.IOException
      //   842	12	2	localIOException6	java.io.IOException
      //   864	33	2	localObject3	Object
      //   987	1	2	localObject4	Object
      //   991	36	2	localException1	Exception
      //   1035	1	2	localObject5	Object
      //   1039	1	2	localObject6	Object
      //   1046	1	2	localObject7	Object
      //   1059	25	2	localObject8	Object
      //   98	295	3	localObject9	Object
      //   401	19	3	localException2	Exception
      //   643	73	3	localBitmap1	Bitmap
      //   898	12	3	localIOException7	java.io.IOException
      //   920	12	3	localIOException8	java.io.IOException
      //   968	1	3	localBitmap2	Bitmap
      //   1054	1	3	localException3	Exception
      //   1066	1	3	localException4	Exception
      //   1075	1	3	localException5	Exception
      //   193	885	4	str	String
      //   83	979	5	localObject10	Object
      //   184	864	6	localObject11	Object
      //   180	862	7	localObject12	Object
      //   51	899	8	localFile	java.io.File
      // Exception table:
      //   from	to	target	type
      //   275	279	291	java/io/IOException
      //   279	284	313	java/io/IOException
      //   202	218	401	java/lang/Exception
      //   229	252	401	java/lang/Exception
      //   259	271	401	java/lang/Exception
      //   342	348	401	java/lang/Exception
      //   355	361	401	java/lang/Exception
      //   373	383	401	java/lang/Exception
      //   390	398	401	java/lang/Exception
      //   508	541	401	java/lang/Exception
      //   548	560	401	java/lang/Exception
      //   564	568	776	java/io/IOException
      //   568	573	798	java/io/IOException
      //   480	484	820	java/io/IOException
      //   489	494	842	java/io/IOException
      //   26	85	864	finally
      //   876	881	898	java/io/IOException
      //   886	891	920	java/io/IOException
      //   573	610	991	java/lang/Exception
      //   614	644	991	java/lang/Exception
      //   648	685	991	java/lang/Exception
      //   690	719	991	java/lang/Exception
      //   719	764	991	java/lang/Exception
      //   942	969	991	java/lang/Exception
      //   972	986	991	java/lang/Exception
      //   85	147	1039	finally
      //   147	179	1039	finally
      //   186	195	1046	finally
      //   202	218	1046	finally
      //   229	252	1046	finally
      //   259	271	1046	finally
      //   342	348	1046	finally
      //   355	361	1046	finally
      //   373	383	1046	finally
      //   390	398	1046	finally
      //   409	427	1046	finally
      //   434	457	1046	finally
      //   464	476	1046	finally
      //   508	541	1046	finally
      //   548	560	1046	finally
      //   26	85	1054	java/lang/Exception
      //   85	147	1066	java/lang/Exception
      //   147	179	1066	java/lang/Exception
      //   186	195	1075	java/lang/Exception
    }
    
    public final boolean acT()
    {
      AppMethodBeat.i(79011);
      try
      {
        ao.a.flJ.cq(this.gjJ, 0);
        x.b.a(x.b.gjC, this.gjK.aoo(), this.gjK.aop(), this.frG);
        this.frG = null;
        AppMethodBeat.o(79011);
        return false;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ab.e("MicroMsg.MMPictureLogic", "exception:%s", new Object[] { bo.l(localException) });
        }
      }
    }
  }
  
  static final class b
    implements az.a
  {
    public Bitmap frG;
    private v gjK;
    
    public b(v paramv)
    {
      AppMethodBeat.i(79012);
      this.frG = null;
      if (!x.c(paramv))
      {
        paramv = new IllegalArgumentException("from sdcard, picture strategy here must be validity");
        AppMethodBeat.o(79012);
        throw paramv;
      }
      this.gjK = paramv;
      AppMethodBeat.o(79012);
    }
    
    public final boolean acS()
    {
      boolean bool = false;
      AppMethodBeat.i(79013);
      this.frG = x.b.wx(this.gjK.aon());
      if (this.frG != null) {
        this.frG = x.b.gjC.a(this.gjK, this.frG);
      }
      String str1 = this.gjK.aoo();
      String str2 = this.gjK.aon();
      if (this.frG != null) {
        bool = true;
      }
      ab.v("MicroMsg.MMPictureLogic", "get url[%s] from[%s] result[%B]", new Object[] { str1, str2, Boolean.valueOf(bool) });
      AppMethodBeat.o(79013);
      return true;
    }
    
    public final boolean acT()
    {
      AppMethodBeat.i(79014);
      if (this.frG == null)
      {
        ab.d("MicroMsg.MMPictureLogic", "can not find bitmap on sdCard, url=%s, try to download it", new Object[] { this.gjK.aoo() });
        if ((x.b.a(x.b.gjC) == null) || (x.b.a(x.b.gjC).dtw())) {
          x.b.a(x.b.gjC, new az(1, "readerapp-pic-logic-download", 3));
        }
        x.b.a(x.b.gjC).e(new x.b.a(this.gjK));
      }
      for (;;)
      {
        AppMethodBeat.o(79014);
        return false;
        x.b.a(x.b.gjC, this.gjK.aoo(), this.gjK.aop(), this.frG);
        this.frG = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.platformtools.x.b
 * JD-Core Version:    0.7.0.1
 */
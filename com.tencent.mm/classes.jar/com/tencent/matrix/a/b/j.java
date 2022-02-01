package com.tencent.matrix.a.b;

import android.content.Context;
import java.io.IOException;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class j
{
  private static j eTK = null;
  static final HashMap<String, Double> eTL = new HashMap();
  static final HashMap<String, Double[]> eTM = new HashMap();
  private static final Object sLock = new Object();
  public a[] eTN;
  
  private j(Context paramContext)
  {
    synchronized (sLock)
    {
      if ((eTL.size() == 0) && (eTM.size() == 0)) {
        cf(paramContext);
      }
      axx();
      return;
    }
  }
  
  private static double S(String paramString, int paramInt)
  {
    if (eTL.containsKey(paramString)) {
      return ((Double)eTL.get(paramString)).doubleValue();
    }
    if (eTM.containsKey(paramString))
    {
      paramString = (Double[])eTM.get(paramString);
      if ((paramString.length > paramInt) && (paramInt >= 0)) {
        return paramString[paramInt].doubleValue();
      }
      if ((paramInt < 0) || (paramString.length == 0)) {
        return 0.0D;
      }
      return paramString[(paramString.length - 1)].doubleValue();
    }
    return 0.0D;
  }
  
  private j axw()
  {
    if (this.eTN.length <= 0) {
      throw new IOException("Invalid cpu clusters: " + this.eTN.length);
    }
    int i = 0;
    while (i < this.eTN.length)
    {
      if (nf(i) <= 0) {
        throw new IOException("Invalid cpu cluster speed-steps: cluster = " + i + ", steps = " + nf(i));
      }
      i += 1;
    }
    i = b.axr();
    int j = axr();
    if (i != j) {
      throw new IOException("Unmatched cpu core num, sys = " + i + ", profile = " + j);
    }
    return this;
  }
  
  private void axx()
  {
    int i = 1;
    if (eTM.containsKey("cpu.clusters.cores"))
    {
      Double[] arrayOfDouble = (Double[])eTM.get("cpu.clusters.cores");
      this.eTN = new a[arrayOfDouble.length];
      i = 0;
      while (i < arrayOfDouble.length)
      {
        int j = (int)Math.round(arrayOfDouble[i].doubleValue());
        this.eTN[i] = new a("cpu.core_speeds.cluster".concat(String.valueOf(i)), "cpu.cluster_power.cluster".concat(String.valueOf(i)), "cpu.core_power.cluster".concat(String.valueOf(i)), j, 0);
        i += 1;
      }
    }
    this.eTN = new a[1];
    if (eTL.containsKey("cpu.clusters.cores")) {
      i = (int)Math.round(((Double)eTL.get("cpu.clusters.cores")).doubleValue());
    }
    this.eTN[0] = new a("cpu.core_speeds.cluster0", "cpu.cluster_power.cluster0", "cpu.core_power.cluster0", i, 0);
  }
  
  /* Error */
  public static j ce(Context arg0)
  {
    // Byte code:
    //   0: getstatic 37	com/tencent/matrix/a/b/j:sLock	Ljava/lang/Object;
    //   3: astore_1
    //   4: aload_1
    //   5: monitorenter
    //   6: new 2	com/tencent/matrix/a/b/j
    //   9: dup
    //   10: aload_0
    //   11: invokespecial 147	com/tencent/matrix/a/b/j:<init>	(Landroid/content/Context;)V
    //   14: invokespecial 149	com/tencent/matrix/a/b/j:axw	()Lcom/tencent/matrix/a/b/j;
    //   17: astore_0
    //   18: aload_0
    //   19: putstatic 25	com/tencent/matrix/a/b/j:eTK	Lcom/tencent/matrix/a/b/j;
    //   22: aload_1
    //   23: monitorexit
    //   24: aload_0
    //   25: areturn
    //   26: astore_0
    //   27: new 73	java/io/IOException
    //   30: dup
    //   31: aload_0
    //   32: invokespecial 152	java/io/IOException:<init>	(Ljava/lang/Throwable;)V
    //   35: athrow
    //   36: astore_0
    //   37: aload_1
    //   38: monitorexit
    //   39: aload_0
    //   40: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   3	35	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   6	22	26	finally
    //   22	24	36	finally
    //   27	36	36	finally
    //   37	39	36	finally
  }
  
  /* Error */
  private static void cf(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 162	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   4: ldc 164
    //   6: ldc 166
    //   8: ldc 168
    //   10: invokevirtual 174	android/content/res/Resources:getIdentifier	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   13: istore 5
    //   15: aload_0
    //   16: invokevirtual 162	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   19: astore 14
    //   21: aload 14
    //   23: iload 5
    //   25: invokevirtual 178	android/content/res/Resources:getXml	(I)Landroid/content/res/XmlResourceParser;
    //   28: astore 13
    //   30: new 180	java/util/ArrayList
    //   33: dup
    //   34: invokespecial 181	java/util/ArrayList:<init>	()V
    //   37: astore 15
    //   39: aload 13
    //   41: ldc 183
    //   43: invokestatic 187	com/tencent/matrix/a/b/j$b:d	(Lorg/xmlpull/v1/XmlPullParser;Ljava/lang/String;)V
    //   46: aconst_null
    //   47: astore 11
    //   49: iconst_0
    //   50: istore 5
    //   52: aload 13
    //   54: invokestatic 190	com/tencent/matrix/a/b/j$b:d	(Lorg/xmlpull/v1/XmlPullParser;)V
    //   57: aload 13
    //   59: invokeinterface 195 1 0
    //   64: astore 16
    //   66: aload 16
    //   68: ifnull +190 -> 258
    //   71: iload 5
    //   73: ifeq +449 -> 522
    //   76: aload 16
    //   78: ldc 197
    //   80: invokevirtual 200	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   83: ifne +439 -> 522
    //   86: getstatic 34	com/tencent/matrix/a/b/j:eTM	Ljava/util/HashMap;
    //   89: aload 11
    //   91: aload 15
    //   93: aload 15
    //   95: invokevirtual 201	java/util/ArrayList:size	()I
    //   98: anewarray 61	java/lang/Double
    //   101: invokevirtual 205	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   104: invokevirtual 209	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   107: pop
    //   108: iconst_0
    //   109: istore 5
    //   111: aload 16
    //   113: ldc 211
    //   115: invokevirtual 200	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   118: ifeq +26 -> 144
    //   121: aload 15
    //   123: invokevirtual 214	java/util/ArrayList:clear	()V
    //   126: aload 13
    //   128: aconst_null
    //   129: ldc 216
    //   131: invokeinterface 220 3 0
    //   136: astore 11
    //   138: iconst_1
    //   139: istore 5
    //   141: goto -89 -> 52
    //   144: aload 16
    //   146: ldc 222
    //   148: invokevirtual 200	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   151: ifne +13 -> 164
    //   154: aload 16
    //   156: ldc 197
    //   158: invokevirtual 200	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   161: ifeq +364 -> 525
    //   164: iload 5
    //   166: ifne +350 -> 516
    //   169: aload 13
    //   171: aconst_null
    //   172: ldc 216
    //   174: invokeinterface 220 3 0
    //   179: astore 12
    //   181: aload 13
    //   183: invokeinterface 225 1 0
    //   188: iconst_4
    //   189: if_icmpne +336 -> 525
    //   192: aload 13
    //   194: invokeinterface 228 1 0
    //   199: astore 17
    //   201: dconst_0
    //   202: dstore_1
    //   203: aload 17
    //   205: invokestatic 231	java/lang/Double:valueOf	(Ljava/lang/String;)Ljava/lang/Double;
    //   208: invokevirtual 65	java/lang/Double:doubleValue	()D
    //   211: dstore_3
    //   212: dload_3
    //   213: dstore_1
    //   214: aload 16
    //   216: ldc 222
    //   218: invokevirtual 200	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   221: ifeq +19 -> 240
    //   224: getstatic 32	com/tencent/matrix/a/b/j:eTL	Ljava/util/HashMap;
    //   227: aload 12
    //   229: dload_1
    //   230: invokestatic 234	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   233: invokevirtual 209	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   236: pop
    //   237: goto -185 -> 52
    //   240: iload 5
    //   242: ifeq +283 -> 525
    //   245: aload 15
    //   247: dload_1
    //   248: invokestatic 234	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   251: invokevirtual 237	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   254: pop
    //   255: goto +270 -> 525
    //   258: iload 5
    //   260: ifeq +25 -> 285
    //   263: getstatic 34	com/tencent/matrix/a/b/j:eTM	Ljava/util/HashMap;
    //   266: aload 11
    //   268: aload 15
    //   270: aload 15
    //   272: invokevirtual 201	java/util/ArrayList:size	()I
    //   275: anewarray 61	java/lang/Double
    //   278: invokevirtual 205	java/util/ArrayList:toArray	([Ljava/lang/Object;)[Ljava/lang/Object;
    //   281: invokevirtual 209	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   284: pop
    //   285: aload 13
    //   287: invokeinterface 240 1 0
    //   292: aload_0
    //   293: invokevirtual 162	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   296: ldc 242
    //   298: ldc 244
    //   300: ldc 168
    //   302: invokevirtual 174	android/content/res/Resources:getIdentifier	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   305: istore 6
    //   307: aload_0
    //   308: invokevirtual 162	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   311: ldc 246
    //   313: ldc 244
    //   315: ldc 168
    //   317: invokevirtual 174	android/content/res/Resources:getIdentifier	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   320: istore 7
    //   322: aload_0
    //   323: invokevirtual 162	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   326: ldc 248
    //   328: ldc 244
    //   330: ldc 168
    //   332: invokevirtual 174	android/content/res/Resources:getIdentifier	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   335: istore 8
    //   337: aload_0
    //   338: invokevirtual 162	android/content/Context:getResources	()Landroid/content/res/Resources;
    //   341: ldc 250
    //   343: ldc 244
    //   345: ldc 168
    //   347: invokevirtual 174	android/content/res/Resources:getIdentifier	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I
    //   350: istore 9
    //   352: iconst_0
    //   353: istore 5
    //   355: iload 5
    //   357: iconst_4
    //   358: if_icmpge +152 -> 510
    //   361: iconst_4
    //   362: anewarray 122	java/lang/String
    //   365: dup
    //   366: iconst_0
    //   367: ldc 252
    //   369: aastore
    //   370: dup
    //   371: iconst_1
    //   372: ldc 254
    //   374: aastore
    //   375: dup
    //   376: iconst_2
    //   377: ldc_w 256
    //   380: aastore
    //   381: dup
    //   382: iconst_3
    //   383: ldc_w 258
    //   386: aastore
    //   387: iload 5
    //   389: aaload
    //   390: astore_0
    //   391: getstatic 32	com/tencent/matrix/a/b/j:eTL	Ljava/util/HashMap;
    //   394: aload_0
    //   395: invokevirtual 55	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   398: ifeq +21 -> 419
    //   401: getstatic 32	com/tencent/matrix/a/b/j:eTL	Ljava/util/HashMap;
    //   404: aload_0
    //   405: invokevirtual 59	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   408: checkcast 61	java/lang/Double
    //   411: invokevirtual 65	java/lang/Double:doubleValue	()D
    //   414: dconst_0
    //   415: dcmpl
    //   416: ifgt +55 -> 471
    //   419: aload 14
    //   421: iconst_4
    //   422: newarray int
    //   424: dup
    //   425: iconst_0
    //   426: iload 6
    //   428: iastore
    //   429: dup
    //   430: iconst_1
    //   431: iload 7
    //   433: iastore
    //   434: dup
    //   435: iconst_2
    //   436: iload 8
    //   438: iastore
    //   439: dup
    //   440: iconst_3
    //   441: iload 9
    //   443: iastore
    //   444: iload 5
    //   446: iaload
    //   447: invokevirtual 261	android/content/res/Resources:getInteger	(I)I
    //   450: istore 10
    //   452: iload 10
    //   454: ifle +17 -> 471
    //   457: getstatic 32	com/tencent/matrix/a/b/j:eTL	Ljava/util/HashMap;
    //   460: aload_0
    //   461: iload 10
    //   463: i2d
    //   464: invokestatic 234	java/lang/Double:valueOf	(D)Ljava/lang/Double;
    //   467: invokevirtual 209	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   470: pop
    //   471: iload 5
    //   473: iconst_1
    //   474: iadd
    //   475: istore 5
    //   477: goto -122 -> 355
    //   480: astore_0
    //   481: new 263	java/lang/RuntimeException
    //   484: dup
    //   485: aload_0
    //   486: invokespecial 264	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   489: athrow
    //   490: astore_0
    //   491: aload 13
    //   493: invokeinterface 240 1 0
    //   498: aload_0
    //   499: athrow
    //   500: astore_0
    //   501: new 263	java/lang/RuntimeException
    //   504: dup
    //   505: aload_0
    //   506: invokespecial 264	java/lang/RuntimeException:<init>	(Ljava/lang/Throwable;)V
    //   509: athrow
    //   510: return
    //   511: astore 17
    //   513: goto -299 -> 214
    //   516: aconst_null
    //   517: astore 12
    //   519: goto -338 -> 181
    //   522: goto -411 -> 111
    //   525: goto -473 -> 52
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	528	0	paramContext	Context
    //   202	46	1	d1	double
    //   211	2	3	d2	double
    //   13	463	5	i	int
    //   305	122	6	j	int
    //   320	112	7	k	int
    //   335	102	8	m	int
    //   350	92	9	n	int
    //   450	12	10	i1	int
    //   47	220	11	localObject	Object
    //   179	339	12	str1	String
    //   28	464	13	localXmlResourceParser	android.content.res.XmlResourceParser
    //   19	401	14	localResources	android.content.res.Resources
    //   37	234	15	localArrayList	java.util.ArrayList
    //   64	151	16	str2	String
    //   199	5	17	str3	String
    //   511	1	17	localNumberFormatException	java.lang.NumberFormatException
    // Exception table:
    //   from	to	target	type
    //   39	46	480	org/xmlpull/v1/XmlPullParserException
    //   52	66	480	org/xmlpull/v1/XmlPullParserException
    //   76	108	480	org/xmlpull/v1/XmlPullParserException
    //   111	138	480	org/xmlpull/v1/XmlPullParserException
    //   144	164	480	org/xmlpull/v1/XmlPullParserException
    //   169	181	480	org/xmlpull/v1/XmlPullParserException
    //   181	201	480	org/xmlpull/v1/XmlPullParserException
    //   203	212	480	org/xmlpull/v1/XmlPullParserException
    //   214	237	480	org/xmlpull/v1/XmlPullParserException
    //   245	255	480	org/xmlpull/v1/XmlPullParserException
    //   263	285	480	org/xmlpull/v1/XmlPullParserException
    //   39	46	490	finally
    //   52	66	490	finally
    //   76	108	490	finally
    //   111	138	490	finally
    //   144	164	490	finally
    //   169	181	490	finally
    //   181	201	490	finally
    //   203	212	490	finally
    //   214	237	490	finally
    //   245	255	490	finally
    //   263	285	490	finally
    //   481	490	490	finally
    //   501	510	490	finally
    //   39	46	500	java/io/IOException
    //   52	66	500	java/io/IOException
    //   76	108	500	java/io/IOException
    //   111	138	500	java/io/IOException
    //   144	164	500	java/io/IOException
    //   169	181	500	java/io/IOException
    //   181	201	500	java/io/IOException
    //   203	212	500	java/io/IOException
    //   214	237	500	java/io/IOException
    //   245	255	500	java/io/IOException
    //   263	285	500	java/io/IOException
    //   203	212	511	java/lang/NumberFormatException
  }
  
  private int ne(int paramInt)
  {
    return this.eTN[paramInt].eTR;
  }
  
  public final int axr()
  {
    int j = 0;
    int k;
    for (int i = 0; j < this.eTN.length; i = k + i)
    {
      k = ne(j);
      j += 1;
    }
    return i;
  }
  
  public final double dl(int paramInt1, int paramInt2)
  {
    if ((paramInt1 >= 0) && (paramInt1 < this.eTN.length)) {
      return S(this.eTN[paramInt1].eTQ, paramInt2);
    }
    return 0.0D;
  }
  
  public final boolean isSupported()
  {
    try
    {
      axw();
      return true;
    }
    catch (IOException localIOException) {}
    return false;
  }
  
  public final int nd(int paramInt)
  {
    int k;
    if (paramInt < 0)
    {
      k = -1;
      return k;
    }
    int i = 0;
    for (int j = 0;; j = k + j)
    {
      if (i >= this.eTN.length) {
        break label66;
      }
      a locala = this.eTN[i];
      k = i;
      if (locala.eTR + j >= paramInt + 1) {
        break;
      }
      k = locala.eTR;
      i += 1;
    }
    label66:
    return -2;
  }
  
  public final int nf(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.eTN.length)) {
      return 0;
    }
    if (eTM.containsKey(this.eTN[paramInt].eTO)) {
      return ((Double[])eTM.get(this.eTN[paramInt].eTO)).length;
    }
    return 1;
  }
  
  public static final class a
  {
    final String eTO;
    private final String eTP;
    final String eTQ;
    final int eTR;
    
    private a(String paramString1, String paramString2, String paramString3, int paramInt)
    {
      this.eTO = paramString1;
      this.eTP = paramString2;
      this.eTQ = paramString3;
      this.eTR = paramInt;
    }
  }
  
  static final class b
  {
    public static void d(XmlPullParser paramXmlPullParser)
    {
      int i;
      do
      {
        i = paramXmlPullParser.next();
      } while ((i != 2) && (i != 1));
    }
    
    public static void d(XmlPullParser paramXmlPullParser, String paramString)
    {
      int i;
      do
      {
        i = paramXmlPullParser.next();
      } while ((i != 2) && (i != 1));
      if (i != 2) {
        throw new XmlPullParserException("No start tag found");
      }
      if (!paramXmlPullParser.getName().equals(paramString)) {
        throw new XmlPullParserException("Unexpected start tag: found " + paramXmlPullParser.getName() + ", expected " + paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.matrix.a.b.j
 * JD-Core Version:    0.7.0.1
 */
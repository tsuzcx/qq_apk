package com.tencent.mm.compatible.loader;

import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.util.TypedValue;
import com.tencent.mm.sdk.platformtools.y;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.zip.ZipFile;

public class PluginResourceLoader
  extends Resources
{
  public Resources dza;
  private Method dzb;
  private Method dzc;
  private HashMap<String, ZipFile> dzd;
  private final b<WeakReference<Drawable.ConstantState>> dze;
  
  private Drawable a(TypedValue paramTypedValue, int paramInt)
  {
    try
    {
      Drawable localDrawable1 = (Drawable)this.dzb.invoke(this.dza, new Object[] { paramTypedValue, Integer.valueOf(paramInt) });
      return localDrawable1;
    }
    catch (StackOverflowError localStackOverflowError)
    {
      y.e("MicroMsg.PluginResourceLoader", "load drawable StackOverflowError");
      try
      {
        if ((paramTypedValue.string != null) && (paramTypedValue.string.toString().endsWith(".xml")))
        {
          XmlResourceParser localXmlResourceParser = b(paramTypedValue.string.toString(), paramInt, paramTypedValue.assetCookie, "drawable");
          localDrawable2 = Drawable.createFromXml(this, localXmlResourceParser);
          localXmlResourceParser.close();
          return localDrawable2;
        }
      }
      catch (Exception localException1)
      {
        Drawable localDrawable2;
        Iterator localIterator = this.dzd.entrySet().iterator();
        while (localIterator.hasNext())
        {
          localDrawable2 = a((ZipFile)((Map.Entry)localIterator.next()).getValue(), paramTypedValue);
          if (localDrawable2 != null) {
            return localDrawable2;
          }
        }
        y.d("MicroMsg.PluginResourceLoader", "loadFromZipFile null");
        return null;
      }
    }
    catch (Exception localException2)
    {
      label40:
      break label40;
    }
  }
  
  /* Error */
  private Drawable a(ZipFile paramZipFile, TypedValue paramTypedValue)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 8
    //   3: aconst_null
    //   4: astore 9
    //   6: aconst_null
    //   7: astore 6
    //   9: aload_2
    //   10: getfield 57	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   13: ifnonnull +8 -> 21
    //   16: aload 6
    //   18: astore_2
    //   19: aload_2
    //   20: areturn
    //   21: aload_2
    //   22: getfield 75	android/util/TypedValue:assetCookie	I
    //   25: i2l
    //   26: lstore 4
    //   28: aload_2
    //   29: getfield 134	android/util/TypedValue:data	I
    //   32: i2l
    //   33: lload 4
    //   35: bipush 32
    //   37: lshl
    //   38: lor
    //   39: lstore 4
    //   41: aload_0
    //   42: getfield 136	com/tencent/mm/compatible/loader/PluginResourceLoader:dze	Lcom/tencent/mm/compatible/loader/b;
    //   45: astore 6
    //   47: aload 6
    //   49: getfield 142	com/tencent/mm/compatible/loader/b:Eg	[J
    //   52: aload 6
    //   54: getfield 145	com/tencent/mm/compatible/loader/b:mSize	I
    //   57: lload 4
    //   59: invokestatic 148	com/tencent/mm/compatible/loader/b:b	([JIJ)I
    //   62: istore_3
    //   63: iload_3
    //   64: iflt +16 -> 80
    //   67: aload 6
    //   69: getfield 152	com/tencent/mm/compatible/loader/b:Eh	[Ljava/lang/Object;
    //   72: iload_3
    //   73: aaload
    //   74: getstatic 156	com/tencent/mm/compatible/loader/b:Ee	Ljava/lang/Object;
    //   77: if_acmpne +56 -> 133
    //   80: aconst_null
    //   81: astore 6
    //   83: aload 6
    //   85: checkcast 158	java/lang/ref/WeakReference
    //   88: astore 6
    //   90: aload 6
    //   92: ifnull +108 -> 200
    //   95: aload 6
    //   97: invokevirtual 161	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   100: checkcast 163	android/graphics/drawable/Drawable$ConstantState
    //   103: astore 6
    //   105: aload 6
    //   107: ifnull +38 -> 145
    //   110: aload 6
    //   112: aload_0
    //   113: invokevirtual 167	android/graphics/drawable/Drawable$ConstantState:newDrawable	(Landroid/content/res/Resources;)Landroid/graphics/drawable/Drawable;
    //   116: astore 6
    //   118: aload 6
    //   120: ifnull +86 -> 206
    //   123: ldc 43
    //   125: ldc 169
    //   127: invokestatic 172	com/tencent/mm/sdk/platformtools/y:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   130: aload 6
    //   132: areturn
    //   133: aload 6
    //   135: getfield 152	com/tencent/mm/compatible/loader/b:Eh	[Ljava/lang/Object;
    //   138: iload_3
    //   139: aaload
    //   140: astore 6
    //   142: goto -59 -> 83
    //   145: aload_0
    //   146: getfield 136	com/tencent/mm/compatible/loader/PluginResourceLoader:dze	Lcom/tencent/mm/compatible/loader/b;
    //   149: astore 6
    //   151: aload 6
    //   153: getfield 142	com/tencent/mm/compatible/loader/b:Eg	[J
    //   156: aload 6
    //   158: getfield 145	com/tencent/mm/compatible/loader/b:mSize	I
    //   161: lload 4
    //   163: invokestatic 148	com/tencent/mm/compatible/loader/b:b	([JIJ)I
    //   166: istore_3
    //   167: iload_3
    //   168: iflt +32 -> 200
    //   171: aload 6
    //   173: getfield 152	com/tencent/mm/compatible/loader/b:Eh	[Ljava/lang/Object;
    //   176: iload_3
    //   177: aaload
    //   178: getstatic 156	com/tencent/mm/compatible/loader/b:Ee	Ljava/lang/Object;
    //   181: if_acmpeq +19 -> 200
    //   184: aload 6
    //   186: getfield 152	com/tencent/mm/compatible/loader/b:Eh	[Ljava/lang/Object;
    //   189: iload_3
    //   190: getstatic 156	com/tencent/mm/compatible/loader/b:Ee	Ljava/lang/Object;
    //   193: aastore
    //   194: aload 6
    //   196: iconst_1
    //   197: putfield 176	com/tencent/mm/compatible/loader/b:Ef	Z
    //   200: aconst_null
    //   201: astore 6
    //   203: goto -85 -> 118
    //   206: aload_2
    //   207: getfield 57	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   210: invokeinterface 63 1 0
    //   215: astore 10
    //   217: aload 6
    //   219: astore 7
    //   221: ldc 43
    //   223: ldc 178
    //   225: iconst_2
    //   226: anewarray 27	java/lang/Object
    //   229: dup
    //   230: iconst_0
    //   231: aload 10
    //   233: aastore
    //   234: dup
    //   235: iconst_1
    //   236: aload_1
    //   237: invokevirtual 181	java/util/zip/ZipFile:getName	()Ljava/lang/String;
    //   240: aastore
    //   241: invokestatic 184	com/tencent/mm/sdk/platformtools/y:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   244: aload 6
    //   246: astore 7
    //   248: aload_1
    //   249: aload 10
    //   251: invokevirtual 188	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   254: astore 11
    //   256: aload 9
    //   258: astore 7
    //   260: aload_1
    //   261: aload 11
    //   263: invokevirtual 192	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   266: astore 9
    //   268: aload 9
    //   270: astore 8
    //   272: aload 9
    //   274: astore 7
    //   276: aload_0
    //   277: aload_2
    //   278: aload 9
    //   280: aload 10
    //   282: invokestatic 196	android/graphics/drawable/Drawable:createFromResourceStream	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   285: astore_2
    //   286: aload_2
    //   287: astore 6
    //   289: aload 6
    //   291: astore_2
    //   292: aload 9
    //   294: astore 7
    //   296: aload 9
    //   298: ifnull +15 -> 313
    //   301: aload 9
    //   303: invokevirtual 199	java/io/InputStream:close	()V
    //   306: aload 9
    //   308: astore 7
    //   310: aload 6
    //   312: astore_2
    //   313: aload_2
    //   314: astore 6
    //   316: aload_2
    //   317: ifnonnull +180 -> 497
    //   320: aload 7
    //   322: astore 8
    //   324: aload_1
    //   325: aload 11
    //   327: invokevirtual 192	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   330: astore 9
    //   332: aload 9
    //   334: astore 8
    //   336: aload 9
    //   338: astore 7
    //   340: aload 9
    //   342: aload 10
    //   344: invokestatic 203	android/graphics/drawable/Drawable:createFromStream	(Ljava/io/InputStream;Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   347: astore_1
    //   348: aload_1
    //   349: astore 6
    //   351: aload 9
    //   353: ifnull +144 -> 497
    //   356: aload 9
    //   358: invokevirtual 199	java/io/InputStream:close	()V
    //   361: aload_1
    //   362: astore_2
    //   363: aload_1
    //   364: ifnull -345 -> 19
    //   367: aload_0
    //   368: getfield 136	com/tencent/mm/compatible/loader/PluginResourceLoader:dze	Lcom/tencent/mm/compatible/loader/b;
    //   371: lload 4
    //   373: new 158	java/lang/ref/WeakReference
    //   376: dup
    //   377: aload_1
    //   378: invokevirtual 207	android/graphics/drawable/Drawable:getConstantState	()Landroid/graphics/drawable/Drawable$ConstantState;
    //   381: invokespecial 211	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   384: invokevirtual 215	com/tencent/mm/compatible/loader/b:put	(JLjava/lang/Object;)V
    //   387: aload_1
    //   388: areturn
    //   389: astore_2
    //   390: aload 6
    //   392: astore_2
    //   393: aload 8
    //   395: astore 7
    //   397: aload 8
    //   399: ifnull -86 -> 313
    //   402: aload 8
    //   404: invokevirtual 199	java/io/InputStream:close	()V
    //   407: aload 6
    //   409: astore_2
    //   410: aload 8
    //   412: astore 7
    //   414: goto -101 -> 313
    //   417: astore_2
    //   418: aload 6
    //   420: astore_2
    //   421: aload 8
    //   423: astore 7
    //   425: goto -112 -> 313
    //   428: astore_1
    //   429: aload 7
    //   431: ifnull +8 -> 439
    //   434: aload 7
    //   436: invokevirtual 199	java/io/InputStream:close	()V
    //   439: aload 6
    //   441: astore 7
    //   443: aload_1
    //   444: athrow
    //   445: astore_1
    //   446: aload 7
    //   448: astore_1
    //   449: goto -88 -> 361
    //   452: astore_2
    //   453: goto -92 -> 361
    //   456: astore_1
    //   457: aload_2
    //   458: astore 6
    //   460: aload 8
    //   462: ifnull +35 -> 497
    //   465: aload 8
    //   467: invokevirtual 199	java/io/InputStream:close	()V
    //   470: aload_2
    //   471: astore_1
    //   472: goto -111 -> 361
    //   475: astore_1
    //   476: aload_2
    //   477: astore_1
    //   478: goto -117 -> 361
    //   481: astore_1
    //   482: aload 7
    //   484: ifnull +8 -> 492
    //   487: aload 7
    //   489: invokevirtual 199	java/io/InputStream:close	()V
    //   492: aload_2
    //   493: astore 7
    //   495: aload_1
    //   496: athrow
    //   497: aload 6
    //   499: astore_1
    //   500: goto -139 -> 361
    //   503: astore_2
    //   504: aload 6
    //   506: astore_2
    //   507: aload 9
    //   509: astore 7
    //   511: goto -198 -> 313
    //   514: astore_2
    //   515: goto -76 -> 439
    //   518: astore 6
    //   520: goto -28 -> 492
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	523	0	this	PluginResourceLoader
    //   0	523	1	paramZipFile	ZipFile
    //   0	523	2	paramTypedValue	TypedValue
    //   62	128	3	i	int
    //   26	346	4	l	long
    //   7	498	6	localObject1	Object
    //   518	1	6	localException	Exception
    //   219	291	7	localObject2	Object
    //   1	465	8	localObject3	Object
    //   4	504	9	localInputStream	InputStream
    //   215	128	10	str	String
    //   254	72	11	localZipEntry	java.util.zip.ZipEntry
    // Exception table:
    //   from	to	target	type
    //   260	268	389	java/lang/Exception
    //   276	286	389	java/lang/Exception
    //   402	407	417	java/lang/Exception
    //   260	268	428	finally
    //   276	286	428	finally
    //   221	244	445	java/lang/Exception
    //   248	256	445	java/lang/Exception
    //   443	445	445	java/lang/Exception
    //   495	497	445	java/lang/Exception
    //   356	361	452	java/lang/Exception
    //   324	332	456	java/lang/Exception
    //   340	348	456	java/lang/Exception
    //   465	470	475	java/lang/Exception
    //   324	332	481	finally
    //   340	348	481	finally
    //   301	306	503	java/lang/Exception
    //   434	439	514	java/lang/Exception
    //   487	492	518	java/lang/Exception
  }
  
  private XmlResourceParser b(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    try
    {
      paramString1 = (XmlResourceParser)this.dzc.invoke(this.dza, new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2 });
      return paramString1;
    }
    catch (Exception paramString1)
    {
      y.printErrStackTrace("MicroMsg.PluginResourceLoader", paramString1, "", new Object[0]);
    }
    return null;
  }
  
  private static InputStream b(ZipFile paramZipFile, TypedValue paramTypedValue)
  {
    if (paramTypedValue.string == null) {
      return null;
    }
    paramTypedValue = paramTypedValue.string.toString();
    try
    {
      y.d("MicroMsg.PluginResourceLoader", "try load stream from zip, entry=%s, file=%s", new Object[] { paramTypedValue, paramZipFile.getName() });
      paramZipFile = paramZipFile.getInputStream(paramZipFile.getEntry(paramTypedValue));
      return paramZipFile;
    }
    catch (Exception paramZipFile) {}
    return null;
  }
  
  Drawable loadDrawable(TypedValue paramTypedValue, int paramInt)
  {
    return a(paramTypedValue, paramInt);
  }
  
  Drawable loadDrawable(TypedValue paramTypedValue, int paramInt, boolean paramBoolean)
  {
    return a(paramTypedValue, paramInt);
  }
  
  public InputStream openRawResource(int paramInt, TypedValue paramTypedValue)
  {
    InputStream localInputStream3 = null;
    getValue(paramInt, paramTypedValue, true);
    try
    {
      InputStream localInputStream1 = super.openRawResource(paramInt, paramTypedValue);
      if (localInputStream1 == null)
      {
        Iterator localIterator = this.dzd.entrySet().iterator();
        localInputStream1 = localInputStream3;
        while (localIterator.hasNext())
        {
          localInputStream3 = b((ZipFile)((Map.Entry)localIterator.next()).getValue(), paramTypedValue);
          localInputStream1 = localInputStream3;
          if (localInputStream3 != null) {
            localInputStream1 = localInputStream3;
          }
        }
        return localInputStream1;
      }
    }
    catch (Exception localException)
    {
      InputStream localInputStream2;
      for (;;)
      {
        localInputStream2 = null;
      }
      return localInputStream2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.compatible.loader.PluginResourceLoader
 * JD-Core Version:    0.7.0.1
 */
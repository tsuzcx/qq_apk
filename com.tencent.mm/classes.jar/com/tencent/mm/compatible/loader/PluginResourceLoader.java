package com.tencent.mm.compatible.loader;

import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.util.TypedValue;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
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
  private Method fJA;
  private HashMap<String, ZipFile> fJB;
  private final b<WeakReference<Drawable.ConstantState>> fJC;
  public Resources fJy;
  private Method fJz;
  
  private Drawable a(TypedValue paramTypedValue, int paramInt)
  {
    AppMethodBeat.i(155838);
    try
    {
      Drawable localDrawable1 = (Drawable)this.fJz.invoke(this.fJy, new Object[] { paramTypedValue, Integer.valueOf(paramInt) });
      AppMethodBeat.o(155838);
      return localDrawable1;
    }
    catch (StackOverflowError localStackOverflowError)
    {
      ac.e("MicroMsg.PluginResourceLoader", "load drawable StackOverflowError");
      try
      {
        if ((paramTypedValue.string != null) && (paramTypedValue.string.toString().endsWith(".xml")))
        {
          XmlResourceParser localXmlResourceParser = b(paramTypedValue.string.toString(), paramInt, paramTypedValue.assetCookie, "drawable");
          localDrawable2 = Drawable.createFromXml(this, localXmlResourceParser);
          localXmlResourceParser.close();
          AppMethodBeat.o(155838);
          return localDrawable2;
        }
      }
      catch (Exception localException1)
      {
        Drawable localDrawable2;
        Iterator localIterator = this.fJB.entrySet().iterator();
        while (localIterator.hasNext())
        {
          localDrawable2 = a((ZipFile)((Map.Entry)localIterator.next()).getValue(), paramTypedValue);
          if (localDrawable2 != null)
          {
            AppMethodBeat.o(155838);
            return localDrawable2;
          }
        }
        ac.d("MicroMsg.PluginResourceLoader", "loadFromZipFile null");
        AppMethodBeat.o(155838);
        return null;
      }
    }
    catch (Exception localException2)
    {
      label50:
      break label50;
    }
  }
  
  /* Error */
  private Drawable a(ZipFile paramZipFile, TypedValue paramTypedValue)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 9
    //   3: aconst_null
    //   4: astore 8
    //   6: ldc 142
    //   8: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   11: aload_2
    //   12: getfield 67	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   15: ifnonnull +10 -> 25
    //   18: ldc 142
    //   20: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   23: aconst_null
    //   24: areturn
    //   25: aload_2
    //   26: getfield 85	android/util/TypedValue:assetCookie	I
    //   29: i2l
    //   30: lstore 4
    //   32: aload_2
    //   33: getfield 145	android/util/TypedValue:data	I
    //   36: i2l
    //   37: lload 4
    //   39: bipush 32
    //   41: lshl
    //   42: lor
    //   43: lstore 4
    //   45: aload_0
    //   46: getfield 147	com/tencent/mm/compatible/loader/PluginResourceLoader:fJC	Lcom/tencent/mm/compatible/loader/b;
    //   49: astore 6
    //   51: aload 6
    //   53: getfield 153	com/tencent/mm/compatible/loader/b:MR	[J
    //   56: aload 6
    //   58: getfield 156	com/tencent/mm/compatible/loader/b:mSize	I
    //   61: lload 4
    //   63: invokestatic 159	com/tencent/mm/compatible/loader/b:b	([JIJ)I
    //   66: istore_3
    //   67: iload_3
    //   68: iflt +16 -> 84
    //   71: aload 6
    //   73: getfield 163	com/tencent/mm/compatible/loader/b:MS	[Ljava/lang/Object;
    //   76: iload_3
    //   77: aaload
    //   78: getstatic 167	com/tencent/mm/compatible/loader/b:MP	Ljava/lang/Object;
    //   81: if_acmpne +61 -> 142
    //   84: aconst_null
    //   85: astore 6
    //   87: aload 6
    //   89: checkcast 169	java/lang/ref/WeakReference
    //   92: astore 6
    //   94: aload 6
    //   96: ifnull +113 -> 209
    //   99: aload 6
    //   101: invokevirtual 172	java/lang/ref/WeakReference:get	()Ljava/lang/Object;
    //   104: checkcast 174	android/graphics/drawable/Drawable$ConstantState
    //   107: astore 6
    //   109: aload 6
    //   111: ifnull +43 -> 154
    //   114: aload 6
    //   116: aload_0
    //   117: invokevirtual 178	android/graphics/drawable/Drawable$ConstantState:newDrawable	(Landroid/content/res/Resources;)Landroid/graphics/drawable/Drawable;
    //   120: astore 6
    //   122: aload 6
    //   124: ifnull +91 -> 215
    //   127: ldc 53
    //   129: ldc 180
    //   131: invokestatic 183	com/tencent/mm/sdk/platformtools/ac:v	(Ljava/lang/String;Ljava/lang/String;)V
    //   134: ldc 142
    //   136: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   139: aload 6
    //   141: areturn
    //   142: aload 6
    //   144: getfield 163	com/tencent/mm/compatible/loader/b:MS	[Ljava/lang/Object;
    //   147: iload_3
    //   148: aaload
    //   149: astore 6
    //   151: goto -64 -> 87
    //   154: aload_0
    //   155: getfield 147	com/tencent/mm/compatible/loader/PluginResourceLoader:fJC	Lcom/tencent/mm/compatible/loader/b;
    //   158: astore 6
    //   160: aload 6
    //   162: getfield 153	com/tencent/mm/compatible/loader/b:MR	[J
    //   165: aload 6
    //   167: getfield 156	com/tencent/mm/compatible/loader/b:mSize	I
    //   170: lload 4
    //   172: invokestatic 159	com/tencent/mm/compatible/loader/b:b	([JIJ)I
    //   175: istore_3
    //   176: iload_3
    //   177: iflt +32 -> 209
    //   180: aload 6
    //   182: getfield 163	com/tencent/mm/compatible/loader/b:MS	[Ljava/lang/Object;
    //   185: iload_3
    //   186: aaload
    //   187: getstatic 167	com/tencent/mm/compatible/loader/b:MP	Ljava/lang/Object;
    //   190: if_acmpeq +19 -> 209
    //   193: aload 6
    //   195: getfield 163	com/tencent/mm/compatible/loader/b:MS	[Ljava/lang/Object;
    //   198: iload_3
    //   199: getstatic 167	com/tencent/mm/compatible/loader/b:MP	Ljava/lang/Object;
    //   202: aastore
    //   203: aload 6
    //   205: iconst_1
    //   206: putfield 187	com/tencent/mm/compatible/loader/b:MQ	Z
    //   209: aconst_null
    //   210: astore 6
    //   212: goto -90 -> 122
    //   215: aload_2
    //   216: getfield 67	android/util/TypedValue:string	Ljava/lang/CharSequence;
    //   219: invokeinterface 73 1 0
    //   224: astore 10
    //   226: aload 6
    //   228: astore 7
    //   230: ldc 53
    //   232: ldc 189
    //   234: iconst_2
    //   235: anewarray 34	java/lang/Object
    //   238: dup
    //   239: iconst_0
    //   240: aload 10
    //   242: aastore
    //   243: dup
    //   244: iconst_1
    //   245: aload_1
    //   246: invokevirtual 192	java/util/zip/ZipFile:getName	()Ljava/lang/String;
    //   249: aastore
    //   250: invokestatic 195	com/tencent/mm/sdk/platformtools/ac:v	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   253: aload 6
    //   255: astore 7
    //   257: aload_1
    //   258: aload 10
    //   260: invokevirtual 199	java/util/zip/ZipFile:getEntry	(Ljava/lang/String;)Ljava/util/zip/ZipEntry;
    //   263: astore 11
    //   265: aload 9
    //   267: astore 7
    //   269: aload_1
    //   270: aload 11
    //   272: invokevirtual 203	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   275: astore 9
    //   277: aload 9
    //   279: astore 8
    //   281: aload 9
    //   283: astore 7
    //   285: aload_0
    //   286: aload_2
    //   287: aload 9
    //   289: aload 10
    //   291: invokestatic 207	android/graphics/drawable/Drawable:createFromResourceStream	(Landroid/content/res/Resources;Landroid/util/TypedValue;Ljava/io/InputStream;Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   294: astore_2
    //   295: aload_2
    //   296: astore 6
    //   298: aload 6
    //   300: astore_2
    //   301: aload 9
    //   303: astore 7
    //   305: aload 9
    //   307: ifnull +15 -> 322
    //   310: aload 9
    //   312: invokevirtual 210	java/io/InputStream:close	()V
    //   315: aload 9
    //   317: astore 7
    //   319: aload 6
    //   321: astore_2
    //   322: aload_2
    //   323: astore 6
    //   325: aload_2
    //   326: ifnonnull +200 -> 526
    //   329: aload 7
    //   331: astore 8
    //   333: aload_1
    //   334: aload 11
    //   336: invokevirtual 203	java/util/zip/ZipFile:getInputStream	(Ljava/util/zip/ZipEntry;)Ljava/io/InputStream;
    //   339: astore 9
    //   341: aload 9
    //   343: astore 8
    //   345: aload 9
    //   347: astore 7
    //   349: aload 9
    //   351: aload 10
    //   353: invokestatic 214	android/graphics/drawable/Drawable:createFromStream	(Ljava/io/InputStream;Ljava/lang/String;)Landroid/graphics/drawable/Drawable;
    //   356: astore_1
    //   357: aload_1
    //   358: astore 6
    //   360: aload 9
    //   362: ifnull +164 -> 526
    //   365: aload 9
    //   367: invokevirtual 210	java/io/InputStream:close	()V
    //   370: aload_1
    //   371: ifnull +23 -> 394
    //   374: aload_0
    //   375: getfield 147	com/tencent/mm/compatible/loader/PluginResourceLoader:fJC	Lcom/tencent/mm/compatible/loader/b;
    //   378: lload 4
    //   380: new 169	java/lang/ref/WeakReference
    //   383: dup
    //   384: aload_1
    //   385: invokevirtual 218	android/graphics/drawable/Drawable:getConstantState	()Landroid/graphics/drawable/Drawable$ConstantState;
    //   388: invokespecial 222	java/lang/ref/WeakReference:<init>	(Ljava/lang/Object;)V
    //   391: invokevirtual 226	com/tencent/mm/compatible/loader/b:put	(JLjava/lang/Object;)V
    //   394: ldc 142
    //   396: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   399: aload_1
    //   400: areturn
    //   401: astore_2
    //   402: aload 6
    //   404: astore_2
    //   405: aload 8
    //   407: astore 7
    //   409: aload 8
    //   411: ifnull -89 -> 322
    //   414: aload 8
    //   416: invokevirtual 210	java/io/InputStream:close	()V
    //   419: aload 6
    //   421: astore_2
    //   422: aload 8
    //   424: astore 7
    //   426: goto -104 -> 322
    //   429: astore_2
    //   430: aload 6
    //   432: astore_2
    //   433: aload 8
    //   435: astore 7
    //   437: goto -115 -> 322
    //   440: astore_1
    //   441: aload 7
    //   443: ifnull +8 -> 451
    //   446: aload 7
    //   448: invokevirtual 210	java/io/InputStream:close	()V
    //   451: aload 6
    //   453: astore 7
    //   455: ldc 142
    //   457: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   460: aload 6
    //   462: astore 7
    //   464: aload_1
    //   465: athrow
    //   466: astore_1
    //   467: aload 7
    //   469: astore_1
    //   470: goto -100 -> 370
    //   473: astore_2
    //   474: goto -104 -> 370
    //   477: astore_1
    //   478: aload_2
    //   479: astore 6
    //   481: aload 8
    //   483: ifnull +43 -> 526
    //   486: aload 8
    //   488: invokevirtual 210	java/io/InputStream:close	()V
    //   491: aload_2
    //   492: astore_1
    //   493: goto -123 -> 370
    //   496: astore_1
    //   497: aload_2
    //   498: astore_1
    //   499: goto -129 -> 370
    //   502: astore_1
    //   503: aload 7
    //   505: ifnull +8 -> 513
    //   508: aload 7
    //   510: invokevirtual 210	java/io/InputStream:close	()V
    //   513: aload_2
    //   514: astore 7
    //   516: ldc 142
    //   518: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   521: aload_2
    //   522: astore 7
    //   524: aload_1
    //   525: athrow
    //   526: aload 6
    //   528: astore_1
    //   529: goto -159 -> 370
    //   532: astore_2
    //   533: aload 6
    //   535: astore_2
    //   536: aload 9
    //   538: astore 7
    //   540: goto -218 -> 322
    //   543: astore_2
    //   544: goto -93 -> 451
    //   547: astore 6
    //   549: goto -36 -> 513
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	552	0	this	PluginResourceLoader
    //   0	552	1	paramZipFile	ZipFile
    //   0	552	2	paramTypedValue	TypedValue
    //   66	133	3	i	int
    //   30	349	4	l	long
    //   49	485	6	localObject1	Object
    //   547	1	6	localException	Exception
    //   228	311	7	localObject2	Object
    //   4	483	8	localObject3	Object
    //   1	536	9	localInputStream	InputStream
    //   224	128	10	str	String
    //   263	72	11	localZipEntry	java.util.zip.ZipEntry
    // Exception table:
    //   from	to	target	type
    //   269	277	401	java/lang/Exception
    //   285	295	401	java/lang/Exception
    //   414	419	429	java/lang/Exception
    //   269	277	440	finally
    //   285	295	440	finally
    //   230	253	466	java/lang/Exception
    //   257	265	466	java/lang/Exception
    //   455	460	466	java/lang/Exception
    //   464	466	466	java/lang/Exception
    //   516	521	466	java/lang/Exception
    //   524	526	466	java/lang/Exception
    //   365	370	473	java/lang/Exception
    //   333	341	477	java/lang/Exception
    //   349	357	477	java/lang/Exception
    //   486	491	496	java/lang/Exception
    //   333	341	502	finally
    //   349	357	502	finally
    //   310	315	532	java/lang/Exception
    //   446	451	543	java/lang/Exception
    //   508	513	547	java/lang/Exception
  }
  
  private XmlResourceParser b(String paramString1, int paramInt1, int paramInt2, String paramString2)
  {
    AppMethodBeat.i(155834);
    try
    {
      paramString1 = (XmlResourceParser)this.fJA.invoke(this.fJy, new Object[] { paramString1, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString2 });
      AppMethodBeat.o(155834);
      return paramString1;
    }
    catch (Exception paramString1)
    {
      ac.printErrStackTrace("MicroMsg.PluginResourceLoader", paramString1, "", new Object[0]);
      AppMethodBeat.o(155834);
    }
    return null;
  }
  
  private static InputStream b(ZipFile paramZipFile, TypedValue paramTypedValue)
  {
    AppMethodBeat.i(155840);
    if (paramTypedValue.string == null)
    {
      AppMethodBeat.o(155840);
      return null;
    }
    paramTypedValue = paramTypedValue.string.toString();
    try
    {
      ac.d("MicroMsg.PluginResourceLoader", "try load stream from zip, entry=%s, file=%s", new Object[] { paramTypedValue, paramZipFile.getName() });
      paramZipFile = paramZipFile.getInputStream(paramZipFile.getEntry(paramTypedValue));
      AppMethodBeat.o(155840);
      return paramZipFile;
    }
    catch (Exception paramZipFile)
    {
      AppMethodBeat.o(155840);
    }
    return null;
  }
  
  Drawable loadDrawable(TypedValue paramTypedValue, int paramInt)
  {
    AppMethodBeat.i(155835);
    paramTypedValue = a(paramTypedValue, paramInt);
    AppMethodBeat.o(155835);
    return paramTypedValue;
  }
  
  Drawable loadDrawable(TypedValue paramTypedValue, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(155836);
    paramTypedValue = a(paramTypedValue, paramInt);
    AppMethodBeat.o(155836);
    return paramTypedValue;
  }
  
  public InputStream openRawResource(int paramInt, TypedValue paramTypedValue)
  {
    InputStream localInputStream2 = null;
    AppMethodBeat.i(155837);
    getValue(paramInt, paramTypedValue, true);
    try
    {
      InputStream localInputStream1 = super.openRawResource(paramInt, paramTypedValue);
      if (localInputStream1 == null)
      {
        Iterator localIterator = this.fJB.entrySet().iterator();
        localInputStream1 = localInputStream2;
        while (localIterator.hasNext())
        {
          localInputStream2 = b((ZipFile)((Map.Entry)localIterator.next()).getValue(), paramTypedValue);
          localInputStream1 = localInputStream2;
          if (localInputStream2 != null) {
            localInputStream1 = localInputStream2;
          }
        }
        AppMethodBeat.o(155837);
        return localInputStream1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.compatible.loader.PluginResourceLoader
 * JD-Core Version:    0.7.0.1
 */
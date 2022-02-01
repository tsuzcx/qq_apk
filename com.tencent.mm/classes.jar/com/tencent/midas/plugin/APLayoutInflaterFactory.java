package com.tencent.midas.plugin;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater.Factory2;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.util.HashMap;

@SuppressLint({"NewApi"})
public class APLayoutInflaterFactory
  implements LayoutInflater.Factory2
{
  private final Object[] constructorArgs;
  private final HashMap<String, Constructor<? extends View>> constructorMap;
  private final Class<?>[] constructorSign;
  
  public APLayoutInflaterFactory()
  {
    AppMethodBeat.i(193166);
    this.constructorMap = new HashMap();
    this.constructorSign = new Class[] { Context.class, AttributeSet.class };
    this.constructorArgs = new Object[2];
    AppMethodBeat.o(193166);
  }
  
  /* Error */
  public View onCreateView(View paramView, String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    // Byte code:
    //   0: ldc 58
    //   2: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_2
    //   6: astore 5
    //   8: aload_2
    //   9: ldc 60
    //   11: invokevirtual 66	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   14: ifeq +15 -> 29
    //   17: aload 4
    //   19: aconst_null
    //   20: ldc 68
    //   22: invokeinterface 72 3 0
    //   27: astore 5
    //   29: iconst_m1
    //   30: aload 5
    //   32: bipush 46
    //   34: invokevirtual 76	java/lang/String:indexOf	(I)I
    //   37: if_icmpne +10 -> 47
    //   40: ldc 58
    //   42: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   45: aconst_null
    //   46: areturn
    //   47: aload_0
    //   48: getfield 43	com/tencent/midas/plugin/APLayoutInflaterFactory:constructorArgs	[Ljava/lang/Object;
    //   51: iconst_0
    //   52: aaload
    //   53: checkcast 37	android/content/Context
    //   56: astore 6
    //   58: aload_0
    //   59: getfield 43	com/tencent/midas/plugin/APLayoutInflaterFactory:constructorArgs	[Ljava/lang/Object;
    //   62: iconst_0
    //   63: aload_3
    //   64: aastore
    //   65: aload_0
    //   66: getfield 33	com/tencent/midas/plugin/APLayoutInflaterFactory:constructorMap	Ljava/util/HashMap;
    //   69: aload 5
    //   71: invokevirtual 80	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   74: checkcast 82	java/lang/reflect/Constructor
    //   77: astore_1
    //   78: aload_1
    //   79: ifnonnull +347 -> 426
    //   82: aload_3
    //   83: invokevirtual 86	android/content/Context:getClassLoader	()Ljava/lang/ClassLoader;
    //   86: aload 5
    //   88: invokevirtual 92	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   91: ldc 94
    //   93: invokevirtual 98	java/lang/Class:asSubclass	(Ljava/lang/Class;)Ljava/lang/Class;
    //   96: astore_2
    //   97: aload_2
    //   98: astore_1
    //   99: aload_2
    //   100: aload_0
    //   101: getfield 41	com/tencent/midas/plugin/APLayoutInflaterFactory:constructorSign	[Ljava/lang/Class;
    //   104: invokevirtual 102	java/lang/Class:getConstructor	([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;
    //   107: astore_3
    //   108: aload_2
    //   109: astore_1
    //   110: aload_0
    //   111: getfield 33	com/tencent/midas/plugin/APLayoutInflaterFactory:constructorMap	Ljava/util/HashMap;
    //   114: aload 5
    //   116: aload_3
    //   117: invokevirtual 106	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   120: pop
    //   121: aload_2
    //   122: astore_1
    //   123: aload_0
    //   124: getfield 43	com/tencent/midas/plugin/APLayoutInflaterFactory:constructorArgs	[Ljava/lang/Object;
    //   127: astore 7
    //   129: aload 7
    //   131: iconst_1
    //   132: aload 4
    //   134: aastore
    //   135: aload_2
    //   136: astore_1
    //   137: aload_3
    //   138: iconst_1
    //   139: invokevirtual 110	java/lang/reflect/Constructor:setAccessible	(Z)V
    //   142: aload_2
    //   143: astore_1
    //   144: aload_3
    //   145: aload 7
    //   147: invokevirtual 114	java/lang/reflect/Constructor:newInstance	([Ljava/lang/Object;)Ljava/lang/Object;
    //   150: checkcast 94	android/view/View
    //   153: astore_2
    //   154: aload_0
    //   155: getfield 43	com/tencent/midas/plugin/APLayoutInflaterFactory:constructorArgs	[Ljava/lang/Object;
    //   158: iconst_0
    //   159: aload 6
    //   161: aastore
    //   162: aload_0
    //   163: getfield 43	com/tencent/midas/plugin/APLayoutInflaterFactory:constructorArgs	[Ljava/lang/Object;
    //   166: iconst_1
    //   167: aconst_null
    //   168: aastore
    //   169: ldc 58
    //   171: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   174: aload_2
    //   175: areturn
    //   176: astore_1
    //   177: new 116	android/view/InflateException
    //   180: dup
    //   181: new 118	java/lang/StringBuilder
    //   184: dup
    //   185: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   188: aload 4
    //   190: invokeinterface 123 1 0
    //   195: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: ldc 129
    //   200: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: aload 5
    //   205: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   208: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   211: invokespecial 135	android/view/InflateException:<init>	(Ljava/lang/String;)V
    //   214: astore_2
    //   215: aload_2
    //   216: aload_1
    //   217: invokevirtual 139	android/view/InflateException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   220: pop
    //   221: ldc 58
    //   223: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   226: aload_2
    //   227: athrow
    //   228: astore_1
    //   229: aload_0
    //   230: getfield 43	com/tencent/midas/plugin/APLayoutInflaterFactory:constructorArgs	[Ljava/lang/Object;
    //   233: iconst_0
    //   234: aload 6
    //   236: aastore
    //   237: aload_0
    //   238: getfield 43	com/tencent/midas/plugin/APLayoutInflaterFactory:constructorArgs	[Ljava/lang/Object;
    //   241: iconst_1
    //   242: aconst_null
    //   243: aastore
    //   244: ldc 58
    //   246: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   249: aload_1
    //   250: athrow
    //   251: astore_1
    //   252: new 116	android/view/InflateException
    //   255: dup
    //   256: new 118	java/lang/StringBuilder
    //   259: dup
    //   260: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   263: aload 4
    //   265: invokeinterface 123 1 0
    //   270: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   273: ldc 141
    //   275: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: aload 5
    //   280: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   286: invokespecial 135	android/view/InflateException:<init>	(Ljava/lang/String;)V
    //   289: astore_2
    //   290: aload_2
    //   291: aload_1
    //   292: invokevirtual 139	android/view/InflateException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   295: pop
    //   296: ldc 58
    //   298: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   301: aload_2
    //   302: athrow
    //   303: astore_1
    //   304: new 116	android/view/InflateException
    //   307: dup
    //   308: new 118	java/lang/StringBuilder
    //   311: dup
    //   312: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   315: aload 4
    //   317: invokeinterface 123 1 0
    //   322: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   325: ldc 143
    //   327: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   330: aload 5
    //   332: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   335: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   338: invokespecial 135	android/view/InflateException:<init>	(Ljava/lang/String;)V
    //   341: astore_2
    //   342: aload_2
    //   343: aload_1
    //   344: invokevirtual 139	android/view/InflateException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   347: pop
    //   348: ldc 58
    //   350: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   353: aload_2
    //   354: athrow
    //   355: new 118	java/lang/StringBuilder
    //   358: dup
    //   359: invokespecial 119	java/lang/StringBuilder:<init>	()V
    //   362: aload 4
    //   364: invokeinterface 123 1 0
    //   369: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: ldc 129
    //   374: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: astore_3
    //   378: aload_1
    //   379: ifnonnull +35 -> 414
    //   382: ldc 145
    //   384: astore_1
    //   385: new 116	android/view/InflateException
    //   388: dup
    //   389: aload_3
    //   390: aload_1
    //   391: invokevirtual 127	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   394: invokevirtual 132	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   397: invokespecial 135	android/view/InflateException:<init>	(Ljava/lang/String;)V
    //   400: astore_1
    //   401: aload_1
    //   402: aload_2
    //   403: invokevirtual 139	android/view/InflateException:initCause	(Ljava/lang/Throwable;)Ljava/lang/Throwable;
    //   406: pop
    //   407: ldc 58
    //   409: invokestatic 46	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   412: aload_1
    //   413: athrow
    //   414: aload_1
    //   415: invokevirtual 148	java/lang/Class:getName	()Ljava/lang/String;
    //   418: astore_1
    //   419: goto -34 -> 385
    //   422: astore_2
    //   423: goto -68 -> 355
    //   426: aconst_null
    //   427: astore_2
    //   428: aload_1
    //   429: astore_3
    //   430: goto -309 -> 121
    //   433: astore_2
    //   434: aconst_null
    //   435: astore_1
    //   436: goto -81 -> 355
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	439	0	this	APLayoutInflaterFactory
    //   0	439	1	paramView	View
    //   0	439	2	paramString	String
    //   0	439	3	paramContext	Context
    //   0	439	4	paramAttributeSet	AttributeSet
    //   6	325	5	str	String
    //   56	179	6	localContext	Context
    //   127	19	7	arrayOfObject	Object[]
    // Exception table:
    //   from	to	target	type
    //   82	97	176	java/lang/NoSuchMethodException
    //   99	108	176	java/lang/NoSuchMethodException
    //   110	121	176	java/lang/NoSuchMethodException
    //   123	129	176	java/lang/NoSuchMethodException
    //   137	142	176	java/lang/NoSuchMethodException
    //   144	154	176	java/lang/NoSuchMethodException
    //   82	97	228	finally
    //   99	108	228	finally
    //   110	121	228	finally
    //   123	129	228	finally
    //   137	142	228	finally
    //   144	154	228	finally
    //   177	228	228	finally
    //   252	303	228	finally
    //   304	355	228	finally
    //   355	378	228	finally
    //   385	414	228	finally
    //   414	419	228	finally
    //   82	97	251	java/lang/ClassCastException
    //   99	108	251	java/lang/ClassCastException
    //   110	121	251	java/lang/ClassCastException
    //   123	129	251	java/lang/ClassCastException
    //   137	142	251	java/lang/ClassCastException
    //   144	154	251	java/lang/ClassCastException
    //   82	97	303	java/lang/ClassNotFoundException
    //   99	108	303	java/lang/ClassNotFoundException
    //   110	121	303	java/lang/ClassNotFoundException
    //   123	129	303	java/lang/ClassNotFoundException
    //   137	142	303	java/lang/ClassNotFoundException
    //   144	154	303	java/lang/ClassNotFoundException
    //   99	108	422	java/lang/Exception
    //   110	121	422	java/lang/Exception
    //   123	129	422	java/lang/Exception
    //   137	142	422	java/lang/Exception
    //   144	154	422	java/lang/Exception
    //   82	97	433	java/lang/Exception
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    AppMethodBeat.i(193168);
    paramString = onCreateView(null, paramString, paramContext, paramAttributeSet);
    AppMethodBeat.o(193168);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.midas.plugin.APLayoutInflaterFactory
 * JD-Core Version:    0.7.0.1
 */
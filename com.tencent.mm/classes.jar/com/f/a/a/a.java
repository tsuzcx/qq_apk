package com.f.a.a;

import android.content.Context;
import android.net.Uri;
import android.net.Uri.Builder;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.json.JSONObject;

public final class a
{
  public static final Uri dYo;
  public static final Uri dYp;
  public b dYq;
  private Context mContext;
  
  static
  {
    AppMethodBeat.i(207433);
    Uri localUri = Uri.parse("content://com.oplus.fantasywindow.fantasywindowprovider/");
    dYo = localUri;
    dYp = localUri.buildUpon().appendPath("t_server").build();
    AppMethodBeat.o(207433);
  }
  
  /* Error */
  public a(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 58	java/lang/Object:<init>	()V
    //   4: ldc 59
    //   6: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   9: aload_0
    //   10: aconst_null
    //   11: putfield 61	com/f/a/a/a:mContext	Landroid/content/Context;
    //   14: aload_0
    //   15: aconst_null
    //   16: putfield 63	com/f/a/a/a:dYq	Lcom/f/a/a/b;
    //   19: aload_0
    //   20: getfield 61	com/f/a/a/a:mContext	Landroid/content/Context;
    //   23: ifnonnull +8 -> 31
    //   26: aload_0
    //   27: aload_1
    //   28: putfield 61	com/f/a/a/a:mContext	Landroid/content/Context;
    //   31: aload_0
    //   32: getfield 61	com/f/a/a/a:mContext	Landroid/content/Context;
    //   35: invokevirtual 69	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   38: getstatic 48	com/f/a/a/a:dYp	Landroid/net/Uri;
    //   41: aconst_null
    //   42: ldc 71
    //   44: aconst_null
    //   45: aconst_null
    //   46: invokevirtual 77	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   49: astore 5
    //   51: aload 5
    //   53: ifnull +365 -> 418
    //   56: aload 5
    //   58: invokeinterface 83 1 0
    //   63: istore 4
    //   65: iload 4
    //   67: ifeq +351 -> 418
    //   70: new 85	java/lang/StringBuilder
    //   73: dup
    //   74: ldc 87
    //   76: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   79: aload 5
    //   81: aload 5
    //   83: ldc 92
    //   85: invokeinterface 96 2 0
    //   90: invokeinterface 100 2 0
    //   95: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: iconst_1
    //   100: istore_2
    //   101: iload_2
    //   102: istore_3
    //   103: aload 5
    //   105: ifnull +14 -> 119
    //   108: iload_2
    //   109: istore_3
    //   110: aload 5
    //   112: invokeinterface 107 1 0
    //   117: iload_2
    //   118: istore_3
    //   119: iload_3
    //   120: ifeq +174 -> 294
    //   123: aload_0
    //   124: getfield 63	com/f/a/a/a:dYq	Lcom/f/a/a/b;
    //   127: ifnonnull +167 -> 294
    //   130: aload_0
    //   131: new 109	com/f/a/a/b
    //   134: dup
    //   135: aload_0
    //   136: getfield 61	com/f/a/a/a:mContext	Landroid/content/Context;
    //   139: invokespecial 111	com/f/a/a/b:<init>	(Landroid/content/Context;)V
    //   142: putfield 63	com/f/a/a/a:dYq	Lcom/f/a/a/b;
    //   145: aload_0
    //   146: getfield 63	com/f/a/a/a:dYq	Lcom/f/a/a/b;
    //   149: astore_1
    //   150: aload_1
    //   151: getfield 115	com/f/a/a/b:dYr	Ljava/lang/Object;
    //   154: ifnonnull +44 -> 198
    //   157: ldc 117
    //   159: invokestatic 123	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   162: astore 5
    //   164: aload 5
    //   166: ldc 125
    //   168: iconst_0
    //   169: anewarray 119	java/lang/Class
    //   172: invokevirtual 129	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   175: astore 6
    //   177: aload 6
    //   179: iconst_1
    //   180: invokevirtual 135	java/lang/reflect/Method:setAccessible	(Z)V
    //   183: aload_1
    //   184: aload 6
    //   186: aload 5
    //   188: iconst_0
    //   189: anewarray 4	java/lang/Object
    //   192: invokevirtual 139	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   195: putfield 115	com/f/a/a/b:dYr	Ljava/lang/Object;
    //   198: aload_1
    //   199: getfield 143	com/f/a/a/b:dYs	Ljava/lang/reflect/Method;
    //   202: ifnonnull +49 -> 251
    //   205: aload_1
    //   206: ldc 117
    //   208: invokestatic 123	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   211: ldc 145
    //   213: iconst_4
    //   214: anewarray 119	java/lang/Class
    //   217: dup
    //   218: iconst_0
    //   219: ldc 147
    //   221: aastore
    //   222: dup
    //   223: iconst_1
    //   224: ldc 147
    //   226: aastore
    //   227: dup
    //   228: iconst_2
    //   229: ldc 147
    //   231: aastore
    //   232: dup
    //   233: iconst_3
    //   234: ldc 149
    //   236: aastore
    //   237: invokevirtual 129	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   240: putfield 143	com/f/a/a/b:dYs	Ljava/lang/reflect/Method;
    //   243: aload_1
    //   244: getfield 143	com/f/a/a/b:dYs	Ljava/lang/reflect/Method;
    //   247: iconst_1
    //   248: invokevirtual 135	java/lang/reflect/Method:setAccessible	(Z)V
    //   251: aload_1
    //   252: getfield 115	com/f/a/a/b:dYr	Ljava/lang/Object;
    //   255: ifnull +145 -> 400
    //   258: aload_1
    //   259: getfield 143	com/f/a/a/b:dYs	Ljava/lang/reflect/Method;
    //   262: ifnull +138 -> 400
    //   265: iconst_1
    //   266: istore 4
    //   268: aload_1
    //   269: iload 4
    //   271: putfield 153	com/f/a/a/b:dYt	Z
    //   274: new 85	java/lang/StringBuilder
    //   277: dup
    //   278: ldc 155
    //   280: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   283: aload_0
    //   284: getfield 63	com/f/a/a/a:dYq	Lcom/f/a/a/b;
    //   287: getfield 153	com/f/a/a/b:dYt	Z
    //   290: invokevirtual 158	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   293: pop
    //   294: ldc 59
    //   296: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   299: return
    //   300: astore_1
    //   301: iconst_0
    //   302: istore_2
    //   303: aload 5
    //   305: ifnull +10 -> 315
    //   308: aload 5
    //   310: invokeinterface 107 1 0
    //   315: iload_2
    //   316: istore_3
    //   317: ldc 59
    //   319: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   322: iload_2
    //   323: istore_3
    //   324: aload_1
    //   325: athrow
    //   326: astore_1
    //   327: new 85	java/lang/StringBuilder
    //   330: dup
    //   331: ldc 160
    //   333: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   336: aload_1
    //   337: invokevirtual 164	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   340: invokevirtual 104	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: pop
    //   344: goto -225 -> 119
    //   347: astore 5
    //   349: iload_2
    //   350: istore_3
    //   351: aload_1
    //   352: aload 5
    //   354: invokevirtual 170	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   357: goto -42 -> 315
    //   360: astore 5
    //   362: new 85	java/lang/StringBuilder
    //   365: dup
    //   366: ldc 172
    //   368: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   371: aload 5
    //   373: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   376: pop
    //   377: goto -179 -> 198
    //   380: astore 5
    //   382: new 85	java/lang/StringBuilder
    //   385: dup
    //   386: ldc 177
    //   388: invokespecial 90	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   391: aload 5
    //   393: invokevirtual 175	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   396: pop
    //   397: goto -146 -> 251
    //   400: iconst_0
    //   401: istore 4
    //   403: goto -135 -> 268
    //   406: astore_1
    //   407: iconst_0
    //   408: istore_3
    //   409: goto -82 -> 327
    //   412: astore_1
    //   413: iconst_1
    //   414: istore_2
    //   415: goto -112 -> 303
    //   418: iconst_0
    //   419: istore_2
    //   420: goto -319 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	423	0	this	a
    //   0	423	1	paramContext	Context
    //   100	320	2	i	int
    //   102	307	3	j	int
    //   63	339	4	bool	boolean
    //   49	260	5	localObject	Object
    //   347	6	5	localThrowable	java.lang.Throwable
    //   360	12	5	localException1	java.lang.Exception
    //   380	12	5	localException2	java.lang.Exception
    //   175	10	6	localMethod	java.lang.reflect.Method
    // Exception table:
    //   from	to	target	type
    //   56	65	300	finally
    //   110	117	326	java/lang/Exception
    //   317	322	326	java/lang/Exception
    //   324	326	326	java/lang/Exception
    //   351	357	326	java/lang/Exception
    //   308	315	347	finally
    //   157	198	360	java/lang/Exception
    //   205	251	380	java/lang/Exception
    //   31	51	406	java/lang/Exception
    //   70	99	412	finally
  }
  
  public final com.f.a.b.a a(String paramString1, String paramString2, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(207436);
    new StringBuilder("call InvokeSync function = ").append(paramString1).append(", method = ").append(paramString2);
    paramString1 = this.dYq.h(this.mContext.getPackageName(), paramString2, paramJSONObject.toString());
    AppMethodBeat.o(207436);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.f.a.a.a
 * JD-Core Version:    0.7.0.1
 */
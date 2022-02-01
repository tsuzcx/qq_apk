package com.tencent.mm.plugin.appbrand.config;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.luggage.wxa.storage.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.lc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;

public final class ab
{
  private static final Uri obT;
  private static final ab obU;
  
  static
  {
    AppMethodBeat.i(146063);
    obT = Uri.parse("content://" + a.AUTHORITY + "/WxaAttributesTable");
    obU = new ab();
    AppMethodBeat.o(146063);
  }
  
  /* Error */
  public static java.util.List<WxaAttributes> a(java.util.List<String> paramList, String... paramVarArgs)
  {
    // Byte code:
    //   0: ldc 63
    //   2: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnull +12 -> 18
    //   9: aload_0
    //   10: invokeinterface 69 1 0
    //   15: ifeq +14 -> 29
    //   18: invokestatic 75	java/util/Collections:emptyList	()Ljava/util/List;
    //   21: astore_0
    //   22: ldc 63
    //   24: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: aload_0
    //   28: areturn
    //   29: new 77	java/util/ArrayList
    //   32: dup
    //   33: aload_0
    //   34: invokespecial 80	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   37: astore 4
    //   39: iconst_0
    //   40: istore_2
    //   41: iload_2
    //   42: aload 4
    //   44: invokevirtual 84	java/util/ArrayList:size	()I
    //   47: if_icmpge +38 -> 85
    //   50: aload 4
    //   52: iload_2
    //   53: getstatic 90	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   56: ldc 92
    //   58: iconst_1
    //   59: anewarray 4	java/lang/Object
    //   62: dup
    //   63: iconst_0
    //   64: aload 4
    //   66: iload_2
    //   67: invokevirtual 96	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   70: aastore
    //   71: invokestatic 102	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   74: invokevirtual 106	java/util/ArrayList:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   77: pop
    //   78: iload_2
    //   79: iconst_1
    //   80: iadd
    //   81: istore_2
    //   82: goto -41 -> 41
    //   85: aload 4
    //   87: ldc 108
    //   89: invokestatic 113	org/apache/commons/b/g:a	(Ljava/util/Collection;Ljava/lang/String;)Ljava/lang/String;
    //   92: astore 4
    //   94: invokestatic 119	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   97: invokevirtual 125	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   100: astore 5
    //   102: getstatic 49	com/tencent/mm/plugin/appbrand/config/ab:obT	Landroid/net/Uri;
    //   105: astore 6
    //   107: aload_1
    //   108: arraylength
    //   109: ifgt +118 -> 227
    //   112: aconst_null
    //   113: astore_1
    //   114: aload 5
    //   116: aload 6
    //   118: aload_1
    //   119: getstatic 90	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   122: ldc 127
    //   124: iconst_2
    //   125: anewarray 4	java/lang/Object
    //   128: dup
    //   129: iconst_0
    //   130: ldc 129
    //   132: aastore
    //   133: dup
    //   134: iconst_1
    //   135: aload 4
    //   137: aastore
    //   138: invokestatic 102	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   141: aconst_null
    //   142: aconst_null
    //   143: invokevirtual 135	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   146: astore 5
    //   148: new 137	java/util/LinkedList
    //   151: dup
    //   152: invokespecial 138	java/util/LinkedList:<init>	()V
    //   155: astore_1
    //   156: aload 5
    //   158: ifnull +50 -> 208
    //   161: aload 5
    //   163: invokeinterface 143 1 0
    //   168: ifeq +40 -> 208
    //   171: new 145	com/tencent/mm/plugin/appbrand/config/WxaAttributes
    //   174: dup
    //   175: invokespecial 146	com/tencent/mm/plugin/appbrand/config/WxaAttributes:<init>	()V
    //   178: astore 4
    //   180: aload 4
    //   182: aload 5
    //   184: invokevirtual 150	com/tencent/mm/plugin/appbrand/config/WxaAttributes:convertFrom	(Landroid/database/Cursor;)V
    //   187: aload_1
    //   188: aload 4
    //   190: invokeinterface 154 2 0
    //   195: pop
    //   196: aload 5
    //   198: invokeinterface 157 1 0
    //   203: istore_3
    //   204: iload_3
    //   205: ifne -34 -> 171
    //   208: aload 5
    //   210: ifnull +10 -> 220
    //   213: aload 5
    //   215: invokeinterface 160 1 0
    //   220: ldc 63
    //   222: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   225: aload_1
    //   226: areturn
    //   227: goto -113 -> 114
    //   230: astore 4
    //   232: ldc 63
    //   234: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   237: aload 4
    //   239: athrow
    //   240: astore_1
    //   241: aload 5
    //   243: ifnull +15 -> 258
    //   246: aload 4
    //   248: ifnull +64 -> 312
    //   251: aload 5
    //   253: invokeinterface 160 1 0
    //   258: ldc 63
    //   260: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   263: aload_1
    //   264: athrow
    //   265: astore_1
    //   266: ldc 162
    //   268: ldc 164
    //   270: iconst_2
    //   271: anewarray 4	java/lang/Object
    //   274: dup
    //   275: iconst_0
    //   276: aload_0
    //   277: invokeinterface 165 1 0
    //   282: invokestatic 171	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   285: aastore
    //   286: dup
    //   287: iconst_1
    //   288: aload_1
    //   289: aastore
    //   290: invokestatic 177	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   293: ldc 63
    //   295: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   298: aconst_null
    //   299: areturn
    //   300: astore 5
    //   302: aload 4
    //   304: aload 5
    //   306: invokevirtual 181	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   309: goto -51 -> 258
    //   312: aload 5
    //   314: invokeinterface 160 1 0
    //   319: goto -61 -> 258
    //   322: astore_1
    //   323: aconst_null
    //   324: astore 4
    //   326: goto -85 -> 241
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	329	0	paramList	java.util.List<String>
    //   0	329	1	paramVarArgs	String[]
    //   40	42	2	i	int
    //   203	2	3	bool	boolean
    //   37	152	4	localObject1	Object
    //   230	73	4	localThrowable1	java.lang.Throwable
    //   324	1	4	localObject2	Object
    //   100	152	5	localObject3	Object
    //   300	13	5	localThrowable2	java.lang.Throwable
    //   105	12	6	localUri	Uri
    // Exception table:
    //   from	to	target	type
    //   148	156	230	java/lang/Throwable
    //   161	171	230	java/lang/Throwable
    //   171	204	230	java/lang/Throwable
    //   232	240	240	finally
    //   94	112	265	java/lang/Throwable
    //   114	148	265	java/lang/Throwable
    //   213	220	265	java/lang/Throwable
    //   258	265	265	java/lang/Throwable
    //   302	309	265	java/lang/Throwable
    //   312	319	265	java/lang/Throwable
    //   251	258	300	java/lang/Throwable
    //   148	156	322	finally
    //   161	171	322	finally
    //   171	204	322	finally
  }
  
  public static boolean a(lc paramlc)
  {
    AppMethodBeat.i(232375);
    if (paramlc == null)
    {
      AppMethodBeat.o(232375);
      return false;
    }
    try
    {
      paramlc = paramlc.toByteArray();
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("CONTENT_KEY_BATCH_SYNC_SCENE", Integer.valueOf(107));
      localContentValues.put("CONTENT_KEY_BATCH_SYNC_PROTO", paramlc);
      MMApplicationContext.getContext().getContentResolver().insert(obT, localContentValues);
      AppMethodBeat.o(232375);
      return true;
    }
    catch (Exception paramlc)
    {
      Log.e("Luggage.WxaAttrsContentResolver", "batchUpdateWithProto insert failed");
      AppMethodBeat.o(232375);
    }
    return false;
  }
  
  public static ab bLM()
  {
    return obU;
  }
  
  public static WxaAttributes d(String paramString, String... paramVarArgs)
  {
    AppMethodBeat.i(232374);
    long l = Util.currentTicks();
    WxaAttributes localWxaAttributes = e(String.format("%s=?", new Object[] { "appId" }), new String[] { paramString });
    Log.i("Luggage.WxaAttrsContentResolver", "queryWithAppId appId:%s, cost:%dms, columns:%s", new Object[] { paramString, Long.valueOf(Util.currentTicks() - l), Arrays.toString(paramVarArgs) });
    AppMethodBeat.o(232374);
    return localWxaAttributes;
  }
  
  public static WxaAttributes e(String paramString, String[] paramArrayOfString)
  {
    Object localObject = null;
    AppMethodBeat.i(146062);
    paramArrayOfString = MMApplicationContext.getContext().getContentResolver().query(obT, null, paramString, paramArrayOfString, null);
    if (paramArrayOfString == null)
    {
      AppMethodBeat.o(146062);
      return null;
    }
    paramString = localObject;
    if (!paramArrayOfString.isClosed())
    {
      paramString = localObject;
      if (paramArrayOfString.moveToFirst())
      {
        paramString = new WxaAttributes();
        paramString.convertFrom(paramArrayOfString);
      }
    }
    paramArrayOfString.close();
    AppMethodBeat.o(146062);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.ab
 * JD-Core Version:    0.7.0.1
 */
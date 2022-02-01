package com.tencent.mm.plugin.appbrand.config;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.luggage.wxa.storage.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.md;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Arrays;
import java.util.Locale;

public final class ai
{
  private static final Uri rcH;
  private static final ai rcI;
  
  static
  {
    AppMethodBeat.i(146063);
    rcH = Uri.parse("content://" + a.AUTHORITY + "/WxaAttributesTable");
    rcI = new ai();
    AppMethodBeat.o(146063);
  }
  
  public static long XZ(String paramString)
  {
    AppMethodBeat.i(323309);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(323309);
      return -1L;
    }
    String str = String.format(Locale.ENGLISH, "%s=?", new Object[] { "username" });
    paramString = a(new String[] { "syncTimeSecond" }, str, new String[] { paramString });
    if (paramString == null)
    {
      AppMethodBeat.o(323309);
      return -1L;
    }
    long l = paramString.field_syncTimeSecond;
    AppMethodBeat.o(323309);
    return l;
  }
  
  public static WxaAttributes a(String[] paramArrayOfString1, String paramString, String[] paramArrayOfString2)
  {
    Object localObject = null;
    AppMethodBeat.i(323326);
    paramString = MMApplicationContext.getContext().getContentResolver().query(rcH, paramArrayOfString1, paramString, paramArrayOfString2, null);
    if (paramString == null)
    {
      AppMethodBeat.o(323326);
      return null;
    }
    paramArrayOfString1 = localObject;
    if (!paramString.isClosed())
    {
      paramArrayOfString1 = localObject;
      if (paramString.moveToFirst())
      {
        paramArrayOfString1 = new WxaAttributes();
        paramArrayOfString1.convertFrom(paramString);
      }
    }
    paramString.close();
    AppMethodBeat.o(323326);
    return paramArrayOfString1;
  }
  
  /* Error */
  public static java.util.List<WxaAttributes> a(java.util.List<String> paramList, String... paramVarArgs)
  {
    // Byte code:
    //   0: ldc 135
    //   2: invokestatic 17	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: ifnull +12 -> 18
    //   9: aload_0
    //   10: invokeinterface 139 1 0
    //   15: ifeq +14 -> 29
    //   18: invokestatic 145	java/util/Collections:emptyList	()Ljava/util/List;
    //   21: astore_0
    //   22: ldc 135
    //   24: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   27: aload_0
    //   28: areturn
    //   29: new 147	java/util/ArrayList
    //   32: dup
    //   33: aload_0
    //   34: invokespecial 150	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   37: astore 4
    //   39: iconst_0
    //   40: istore_2
    //   41: iload_2
    //   42: aload 4
    //   44: invokevirtual 154	java/util/ArrayList:size	()I
    //   47: if_icmpge +38 -> 85
    //   50: aload 4
    //   52: iload_2
    //   53: getstatic 75	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   56: ldc 156
    //   58: iconst_1
    //   59: anewarray 4	java/lang/Object
    //   62: dup
    //   63: iconst_0
    //   64: aload 4
    //   66: iload_2
    //   67: invokevirtual 160	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   70: aastore
    //   71: invokestatic 85	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   74: invokevirtual 164	java/util/ArrayList:set	(ILjava/lang/Object;)Ljava/lang/Object;
    //   77: pop
    //   78: iload_2
    //   79: iconst_1
    //   80: iadd
    //   81: istore_2
    //   82: goto -41 -> 41
    //   85: aload 4
    //   87: ldc 166
    //   89: invokestatic 172	org/apache/commons/c/i:b	(Ljava/util/Collection;Ljava/lang/String;)Ljava/lang/String;
    //   92: astore 4
    //   94: invokestatic 104	com/tencent/mm/sdk/platformtools/MMApplicationContext:getContext	()Landroid/content/Context;
    //   97: invokevirtual 110	android/content/Context:getContentResolver	()Landroid/content/ContentResolver;
    //   100: astore 5
    //   102: getstatic 49	com/tencent/mm/plugin/appbrand/config/ai:rcH	Landroid/net/Uri;
    //   105: astore 6
    //   107: aload_1
    //   108: arraylength
    //   109: ifgt +114 -> 223
    //   112: aconst_null
    //   113: astore_1
    //   114: aload 5
    //   116: aload 6
    //   118: aload_1
    //   119: getstatic 75	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   122: ldc 174
    //   124: iconst_2
    //   125: anewarray 4	java/lang/Object
    //   128: dup
    //   129: iconst_0
    //   130: ldc 176
    //   132: aastore
    //   133: dup
    //   134: iconst_1
    //   135: aload 4
    //   137: aastore
    //   138: invokestatic 85	java/lang/String:format	(Ljava/util/Locale;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   141: aconst_null
    //   142: aconst_null
    //   143: invokevirtual 116	android/content/ContentResolver:query	(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   146: astore_1
    //   147: new 178	java/util/LinkedList
    //   150: dup
    //   151: invokespecial 179	java/util/LinkedList:<init>	()V
    //   154: astore 4
    //   156: aload_1
    //   157: ifnull +48 -> 205
    //   160: aload_1
    //   161: invokeinterface 125 1 0
    //   166: ifeq +39 -> 205
    //   169: new 93	com/tencent/mm/plugin/appbrand/config/WxaAttributes
    //   172: dup
    //   173: invokespecial 126	com/tencent/mm/plugin/appbrand/config/WxaAttributes:<init>	()V
    //   176: astore 5
    //   178: aload 5
    //   180: aload_1
    //   181: invokevirtual 130	com/tencent/mm/plugin/appbrand/config/WxaAttributes:convertFrom	(Landroid/database/Cursor;)V
    //   184: aload 4
    //   186: aload 5
    //   188: invokeinterface 183 2 0
    //   193: pop
    //   194: aload_1
    //   195: invokeinterface 186 1 0
    //   200: istore_3
    //   201: iload_3
    //   202: ifne -33 -> 169
    //   205: aload_1
    //   206: ifnull +9 -> 215
    //   209: aload_1
    //   210: invokeinterface 133 1 0
    //   215: ldc 135
    //   217: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   220: aload 4
    //   222: areturn
    //   223: goto -109 -> 114
    //   226: astore 4
    //   228: aload_1
    //   229: ifnull +9 -> 238
    //   232: aload_1
    //   233: invokeinterface 133 1 0
    //   238: ldc 135
    //   240: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   243: aload 4
    //   245: athrow
    //   246: astore_1
    //   247: ldc 188
    //   249: ldc 190
    //   251: iconst_2
    //   252: anewarray 4	java/lang/Object
    //   255: dup
    //   256: iconst_0
    //   257: aload_0
    //   258: invokeinterface 191 1 0
    //   263: invokestatic 197	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   266: aastore
    //   267: dup
    //   268: iconst_1
    //   269: aload_1
    //   270: aastore
    //   271: invokestatic 203	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   274: ldc 135
    //   276: invokestatic 56	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   279: aconst_null
    //   280: areturn
    //   281: astore_1
    //   282: aload 4
    //   284: aload_1
    //   285: invokevirtual 209	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   288: goto -50 -> 238
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	291	0	paramList	java.util.List<String>
    //   0	291	1	paramVarArgs	String[]
    //   40	42	2	i	int
    //   200	2	3	bool	boolean
    //   37	184	4	localObject1	Object
    //   226	57	4	localObject2	Object
    //   100	87	5	localObject3	Object
    //   105	12	6	localUri	Uri
    // Exception table:
    //   from	to	target	type
    //   147	156	226	finally
    //   160	169	226	finally
    //   169	201	226	finally
    //   94	112	246	finally
    //   114	147	246	finally
    //   209	215	246	finally
    //   238	246	246	finally
    //   282	288	246	finally
    //   232	238	281	finally
  }
  
  public static boolean a(md parammd)
  {
    AppMethodBeat.i(323315);
    if (parammd == null)
    {
      AppMethodBeat.o(323315);
      return false;
    }
    try
    {
      parammd = parammd.toByteArray();
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("CONTENT_KEY_BATCH_SYNC_SCENE", Integer.valueOf(107));
      localContentValues.put("CONTENT_KEY_BATCH_SYNC_PROTO", parammd);
      MMApplicationContext.getContext().getContentResolver().insert(rcH, localContentValues);
      AppMethodBeat.o(323315);
      return true;
    }
    catch (Exception parammd)
    {
      Log.e("Luggage.WxaAttrsContentResolver", "batchUpdateWithProto insert failed");
      AppMethodBeat.o(323315);
    }
    return false;
  }
  
  public static ai clk()
  {
    return rcI;
  }
  
  public static WxaAttributes e(String paramString, String... paramVarArgs)
  {
    AppMethodBeat.i(323305);
    long l = Util.currentTicks();
    WxaAttributes localWxaAttributes = a(null, String.format("%s=?", new Object[] { "appId" }), new String[] { paramString });
    Log.i("Luggage.WxaAttrsContentResolver", "queryWithAppId appId:%s, cost:%dms, columns:%s", new Object[] { paramString, Long.valueOf(Util.currentTicks() - l), Arrays.toString(paramVarArgs) });
    AppMethodBeat.o(323305);
    return localWxaAttributes;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.config.ai
 * JD-Core Version:    0.7.0.1
 */
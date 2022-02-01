package com.tencent.mm.plugin.appbrand.appcache;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
import com.tencent.mm.vfs.u;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/appcache/WxaCommLibVersionUtils;", "", "()V", "TAG", "", "checkIsValid", "", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgManifestRecord;", "getLatestValidPkgRecordForType", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgStorage;", "versionType", "", "toWrappingInfo", "Lcom/tencent/mm/plugin/appbrand/appcache/WxaPkgWrappingInfo;", "luggage-wechat-full-sdk_release"})
public final class ax
{
  public static final ax nGl;
  
  static
  {
    AppMethodBeat.i(238206);
    nGl = new ax();
    AppMethodBeat.o(238206);
  }
  
  /* Error */
  public static final bh a(bm parambm, int paramInt)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: ldc 48
    //   4: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: ldc 50
    //   10: invokestatic 56	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: new 58	java/lang/StringBuilder
    //   16: dup
    //   17: ldc 60
    //   19: invokespecial 63	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   22: aload_0
    //   23: invokevirtual 69	com/tencent/mm/plugin/appbrand/appcache/bm:getTableName	()Ljava/lang/String;
    //   26: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc 75
    //   31: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   34: invokevirtual 78	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: astore 4
    //   39: aload_0
    //   40: invokevirtual 82	com/tencent/mm/plugin/appbrand/appcache/bm:bHF	()Lcom/tencent/mm/sdk/storage/ISQLiteDatabaseEx;
    //   43: aload 4
    //   45: iconst_3
    //   46: anewarray 84	java/lang/String
    //   49: dup
    //   50: iconst_0
    //   51: ldc 86
    //   53: aastore
    //   54: dup
    //   55: iconst_1
    //   56: iload_1
    //   57: invokestatic 90	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   60: aastore
    //   61: dup
    //   62: iconst_2
    //   63: ldc 91
    //   65: aastore
    //   66: iconst_2
    //   67: invokeinterface 97 4 0
    //   72: astore_0
    //   73: aload_0
    //   74: ifnull +82 -> 156
    //   77: aload_0
    //   78: checkcast 99	java/io/Closeable
    //   81: astore 4
    //   83: aload 4
    //   85: checkcast 101	android/database/Cursor
    //   88: astore_0
    //   89: aload_0
    //   90: invokeinterface 105 1 0
    //   95: ifeq +68 -> 163
    //   98: new 107	com/tencent/mm/plugin/appbrand/appcache/bh
    //   101: dup
    //   102: invokespecial 108	com/tencent/mm/plugin/appbrand/appcache/bh:<init>	()V
    //   105: astore 5
    //   107: aload 5
    //   109: aload_0
    //   110: invokevirtual 112	com/tencent/mm/plugin/appbrand/appcache/bh:convertFrom	(Landroid/database/Cursor;)V
    //   113: aload 5
    //   115: invokestatic 115	com/tencent/mm/plugin/appbrand/appcache/ax:a	(Lcom/tencent/mm/plugin/appbrand/appcache/bh;)Z
    //   118: istore_2
    //   119: iload_2
    //   120: ifeq +17 -> 137
    //   123: aload 4
    //   125: aconst_null
    //   126: invokestatic 120	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   129: ldc 48
    //   131: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   134: aload 5
    //   136: areturn
    //   137: aload_0
    //   138: invokeinterface 123 1 0
    //   143: ifne -36 -> 107
    //   146: getstatic 129	kotlin/x:aazN	Lkotlin/x;
    //   149: astore_0
    //   150: aload 4
    //   152: aconst_null
    //   153: invokestatic 120	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   156: ldc 48
    //   158: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   161: aconst_null
    //   162: areturn
    //   163: aload 4
    //   165: aconst_null
    //   166: invokestatic 120	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   169: ldc 48
    //   171: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   174: aconst_null
    //   175: areturn
    //   176: astore_3
    //   177: ldc 48
    //   179: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   182: aload_3
    //   183: athrow
    //   184: astore_0
    //   185: aload 4
    //   187: aload_3
    //   188: invokestatic 120	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   191: ldc 48
    //   193: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   196: aload_0
    //   197: athrow
    //   198: astore_0
    //   199: goto -14 -> 185
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	202	0	parambm	bm
    //   0	202	1	paramInt	int
    //   118	2	2	bool	boolean
    //   1	1	3	localObject1	Object
    //   176	12	3	localThrowable	java.lang.Throwable
    //   37	149	4	localObject2	Object
    //   105	30	5	localbh	bh
    // Exception table:
    //   from	to	target	type
    //   83	107	176	java/lang/Throwable
    //   107	119	176	java/lang/Throwable
    //   137	150	176	java/lang/Throwable
    //   177	184	184	finally
    //   83	107	198	finally
    //   107	119	198	finally
    //   137	150	198	finally
  }
  
  private static boolean a(bh parambh)
  {
    AppMethodBeat.i(238199);
    if ((999 == parambh.field_debugType) && (parambh.field_endTime > 0L) && (parambh.field_endTime <= Util.nowSecond()))
    {
      Log.e("Luggage.WxaCommLibVersionUtils", "checkIsValid BETA_LIBRARY expired, endTime:" + parambh.field_endTime);
      AppMethodBeat.o(238199);
      return false;
    }
    if (u.agG(parambh.field_pkgPath)) {
      try
      {
        String str = WxaPkgWrappingInfo.n(new q(parambh.field_pkgPath));
        if (str == null) {
          p.iCn();
        }
        if (p.h(str, parambh.field_versionMd5))
        {
          AppMethodBeat.o(238199);
          return true;
        }
      }
      catch (Exception localException)
      {
        Log.e("Luggage.WxaCommLibVersionUtils", "checkIsValid getFileMD5 failed " + localException + ", path:" + parambh.field_pkgPath + ", version:" + parambh.field_version + ", versionType:" + parambh.field_debugType);
        AppMethodBeat.o(238199);
        return false;
      }
    }
    AppMethodBeat.o(238199);
    return false;
  }
  
  public static final WxaPkgWrappingInfo b(bh parambh)
  {
    int j = 0;
    AppMethodBeat.i(238203);
    p.k(parambh, "$this$toWrappingInfo");
    WxaPkgWrappingInfo localWxaPkgWrappingInfo = new WxaPkgWrappingInfo();
    int i;
    if (parambh.field_debugType == 0)
    {
      i = parambh.field_version;
      localWxaPkgWrappingInfo.pkgVersion = i;
      localWxaPkgWrappingInfo.nHZ = parambh.field_createTime;
      localWxaPkgWrappingInfo.nHY = parambh.field_debugType;
      localWxaPkgWrappingInfo.pkgPath = parambh.field_pkgPath;
      localWxaPkgWrappingInfo.nIa = false;
      CharSequence localCharSequence = (CharSequence)parambh.field_versionMd5;
      if (localCharSequence != null)
      {
        i = j;
        if (localCharSequence.length() != 0) {}
      }
      else
      {
        i = 1;
      }
      if (i == 0) {
        break label131;
      }
    }
    label131:
    for (parambh = WxaPkgWrappingInfo.n(new q(localWxaPkgWrappingInfo.pkgPath));; parambh = parambh.field_versionMd5)
    {
      localWxaPkgWrappingInfo.md5 = parambh;
      AppMethodBeat.o(238203);
      return localWxaPkgWrappingInfo;
      i = 0;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.ax
 * JD-Core Version:    0.7.0.1
 */
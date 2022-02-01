package com.tencent.mm.plugin.appbrand.jsapi.file;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.vfs.q;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

public final class r
  extends a
{
  private static final int CTRL_INDEX = 278;
  private static final String NAME = "getFileInfo";
  
  /* Error */
  static String y(com.tencent.mm.vfs.e parame)
  {
    // Byte code:
    //   0: ldc 27
    //   2: invokestatic 33	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 35
    //   7: invokestatic 41	java/security/MessageDigest:getInstance	(Ljava/lang/String;)Ljava/security/MessageDigest;
    //   10: astore_3
    //   11: aload_0
    //   12: invokestatic 47	com/tencent/mm/vfs/i:ag	(Lcom/tencent/mm/vfs/e;)Ljava/io/InputStream;
    //   15: astore_2
    //   16: sipush 8192
    //   19: newarray byte
    //   21: astore_0
    //   22: aload_2
    //   23: aload_0
    //   24: invokevirtual 53	java/io/InputStream:read	([B)I
    //   27: istore_1
    //   28: iload_1
    //   29: ifle +74 -> 103
    //   32: aload_3
    //   33: aload_0
    //   34: iconst_0
    //   35: iload_1
    //   36: invokevirtual 57	java/security/MessageDigest:update	([BII)V
    //   39: goto -17 -> 22
    //   42: astore_0
    //   43: aload_2
    //   44: invokevirtual 60	java/io/InputStream:close	()V
    //   47: ldc 27
    //   49: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   52: ldc 65
    //   54: areturn
    //   55: astore_0
    //   56: ldc 67
    //   58: ldc 69
    //   60: iconst_1
    //   61: anewarray 71	java/lang/Object
    //   64: dup
    //   65: iconst_0
    //   66: aload_0
    //   67: aastore
    //   68: invokestatic 77	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   71: ldc 27
    //   73: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: ldc 65
    //   78: areturn
    //   79: astore_0
    //   80: ldc 67
    //   82: ldc 79
    //   84: iconst_1
    //   85: anewarray 71	java/lang/Object
    //   88: dup
    //   89: iconst_0
    //   90: aload_0
    //   91: aastore
    //   92: invokestatic 77	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   95: ldc 27
    //   97: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: ldc 65
    //   102: areturn
    //   103: aload_3
    //   104: invokevirtual 83	java/security/MessageDigest:digest	()[B
    //   107: astore_0
    //   108: aload_0
    //   109: ifnonnull +16 -> 125
    //   112: aconst_null
    //   113: astore_0
    //   114: aload_2
    //   115: invokevirtual 60	java/io/InputStream:close	()V
    //   118: ldc 27
    //   120: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   123: aload_0
    //   124: areturn
    //   125: new 85	java/lang/StringBuffer
    //   128: dup
    //   129: aload_0
    //   130: arraylength
    //   131: invokespecial 87	java/lang/StringBuffer:<init>	(I)V
    //   134: astore_3
    //   135: iconst_0
    //   136: istore_1
    //   137: iload_1
    //   138: aload_0
    //   139: arraylength
    //   140: if_icmpge +47 -> 187
    //   143: aload_0
    //   144: iload_1
    //   145: baload
    //   146: sipush 255
    //   149: iand
    //   150: invokestatic 93	java/lang/Integer:toHexString	(I)Ljava/lang/String;
    //   153: astore 4
    //   155: aload 4
    //   157: invokevirtual 99	java/lang/String:length	()I
    //   160: iconst_2
    //   161: if_icmpge +9 -> 170
    //   164: aload_3
    //   165: iconst_0
    //   166: invokevirtual 103	java/lang/StringBuffer:append	(I)Ljava/lang/StringBuffer;
    //   169: pop
    //   170: aload_3
    //   171: aload 4
    //   173: invokevirtual 107	java/lang/String:toLowerCase	()Ljava/lang/String;
    //   176: invokevirtual 110	java/lang/StringBuffer:append	(Ljava/lang/String;)Ljava/lang/StringBuffer;
    //   179: pop
    //   180: iload_1
    //   181: iconst_1
    //   182: iadd
    //   183: istore_1
    //   184: goto -47 -> 137
    //   187: aload_3
    //   188: invokevirtual 113	java/lang/StringBuffer:toString	()Ljava/lang/String;
    //   191: astore_0
    //   192: goto -78 -> 114
    //   195: astore_2
    //   196: ldc 67
    //   198: ldc 115
    //   200: iconst_1
    //   201: anewarray 71	java/lang/Object
    //   204: dup
    //   205: iconst_0
    //   206: aload_2
    //   207: aastore
    //   208: invokestatic 77	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   211: goto -93 -> 118
    //   214: astore_0
    //   215: ldc 67
    //   217: ldc 115
    //   219: iconst_1
    //   220: anewarray 71	java/lang/Object
    //   223: dup
    //   224: iconst_0
    //   225: aload_0
    //   226: aastore
    //   227: invokestatic 77	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   230: goto -183 -> 47
    //   233: astore_0
    //   234: aload_2
    //   235: invokevirtual 60	java/io/InputStream:close	()V
    //   238: ldc 27
    //   240: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   243: aload_0
    //   244: athrow
    //   245: astore_2
    //   246: ldc 67
    //   248: ldc 115
    //   250: iconst_1
    //   251: anewarray 71	java/lang/Object
    //   254: dup
    //   255: iconst_0
    //   256: aload_2
    //   257: aastore
    //   258: invokestatic 77	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   261: goto -23 -> 238
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	264	0	parame	com.tencent.mm.vfs.e
    //   27	157	1	i	int
    //   15	100	2	localInputStream	java.io.InputStream
    //   195	40	2	localIOException1	java.io.IOException
    //   245	12	2	localIOException2	java.io.IOException
    //   10	178	3	localObject	Object
    //   153	19	4	str	String
    // Exception table:
    //   from	to	target	type
    //   22	28	42	java/io/IOException
    //   32	39	42	java/io/IOException
    //   103	108	42	java/io/IOException
    //   125	135	42	java/io/IOException
    //   137	170	42	java/io/IOException
    //   170	180	42	java/io/IOException
    //   187	192	42	java/io/IOException
    //   5	11	55	java/security/NoSuchAlgorithmException
    //   11	16	79	java/io/FileNotFoundException
    //   114	118	195	java/io/IOException
    //   43	47	214	java/io/IOException
    //   22	28	233	finally
    //   32	39	233	finally
    //   103	108	233	finally
    //   125	135	233	finally
    //   137	170	233	finally
    //   170	180	233	finally
    //   187	192	233	finally
    //   234	238	245	java/io/IOException
  }
  
  public final void a(final c paramc, final JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(128875);
    final String str = paramJSONObject.optString("filePath", "");
    if (!"sha1".equalsIgnoreCase(paramJSONObject.optString("digestAlgorithm", "md5"))) {}
    for (paramJSONObject = "md5"; bs.isNullOrNil(str); paramJSONObject = "sha1")
    {
      paramc.h(paramInt, e("fail:invalid data", null));
      AppMethodBeat.o(128875);
      return;
    }
    e.kqZ.execute(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(128874);
        if (!paramc.isRunning())
        {
          AppMethodBeat.o(128874);
          return;
        }
        Object localObject = paramc.DH().IS(str);
        if (localObject == null)
        {
          paramc.h(paramInt, r.this.e("fail:file doesn't exist", null));
          AppMethodBeat.o(128874);
          return;
        }
        com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(q.B(((com.tencent.mm.vfs.e)localObject).fxV()));
        localObject = paramJSONObject;
        int i = -1;
        switch (((String)localObject).hashCode())
        {
        default: 
          switch (i)
          {
          default: 
            localObject = "";
          }
          break;
        }
        for (;;)
        {
          HashMap localHashMap = new HashMap(2);
          localHashMap.put("size", Long.valueOf(locale.length()));
          localHashMap.put("digest", localObject);
          paramc.h(paramInt, r.this.k("ok", localHashMap));
          AppMethodBeat.o(128874);
          return;
          if (!((String)localObject).equals("md5")) {
            break;
          }
          i = 0;
          break;
          if (!((String)localObject).equals("sha1")) {
            break;
          }
          i = 1;
          break;
          localObject = g.getMD5(q.B(locale.fxV()));
          continue;
          localObject = r.y(new com.tencent.mm.vfs.e(q.B(locale.fxV())));
        }
      }
    });
    AppMethodBeat.o(128875);
  }
  
  public final boolean bex()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.file.r
 * JD-Core Version:    0.7.0.1
 */
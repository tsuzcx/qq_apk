package com.tencent.mm.plugin.appbrand.appstorage.b;

import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.ji;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import junit.framework.Assert;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/appstorage/security/AppBrandStorageSecurityInfoDB;", "Lcom/tencent/mm/sdk/storage/MAutoStorage;", "Lcom/tencent/mm/plugin/appbrand/appstorage/security/InfoRecord;", "db", "Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;", "(Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;)V", "deleteSalt", "", "appId", "", "generateSalt", "", "byteSize", "", "getSalt", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends MAutoStorage<c>
{
  public static final String[] nVW;
  public static final b.a qOg;
  private final ISQLiteDatabase db;
  
  static
  {
    AppMethodBeat.i(323219);
    qOg = new b.a((byte)0);
    c.a locala = c.qOh;
    nVW = c.chh();
    AppMethodBeat.o(323219);
  }
  
  public b(ISQLiteDatabase paramISQLiteDatabase)
  {
    super(paramISQLiteDatabase, c.chg(), "WxaSecurityStorageInfo", ji.INDEX_CREATE);
    AppMethodBeat.i(323210);
    this.db = paramISQLiteDatabase;
    AppMethodBeat.o(323210);
  }
  
  /* Error */
  private static byte[] cix()
  {
    // Byte code:
    //   0: ldc 95
    //   2: invokestatic 44	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: ldc 97
    //   7: invokestatic 103	com/tencent/mm/vfs/y:Lh	(Ljava/lang/String;)Ljava/io/InputStream;
    //   10: checkcast 105	java/io/Closeable
    //   13: astore_2
    //   14: aload_2
    //   15: checkcast 107	java/io/InputStream
    //   18: astore_3
    //   19: bipush 64
    //   21: newarray byte
    //   23: astore 4
    //   25: iconst_0
    //   26: istore_0
    //   27: aload_3
    //   28: aload 4
    //   30: iload_0
    //   31: bipush 64
    //   33: iload_0
    //   34: isub
    //   35: invokevirtual 111	java/io/InputStream:read	([BII)I
    //   38: istore_1
    //   39: iload_1
    //   40: ifge +22 -> 62
    //   43: ldc 113
    //   45: ldc 115
    //   47: invokestatic 121	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   50: aload_2
    //   51: aconst_null
    //   52: invokestatic 127	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   55: ldc 95
    //   57: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: aconst_null
    //   61: areturn
    //   62: iload_0
    //   63: iload_1
    //   64: iadd
    //   65: istore_1
    //   66: iload_1
    //   67: istore_0
    //   68: iload_1
    //   69: bipush 64
    //   71: if_icmplt -44 -> 27
    //   74: aload_2
    //   75: aconst_null
    //   76: invokestatic 127	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   79: ldc 95
    //   81: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   84: aload 4
    //   86: areturn
    //   87: astore_3
    //   88: ldc 95
    //   90: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: aload_3
    //   94: athrow
    //   95: astore 4
    //   97: aload_2
    //   98: aload_3
    //   99: invokestatic 127	kotlin/f/b:a	(Ljava/io/Closeable;Ljava/lang/Throwable;)V
    //   102: ldc 95
    //   104: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: aload 4
    //   109: athrow
    //   110: astore_2
    //   111: ldc 113
    //   113: aload_2
    //   114: checkcast 129	java/lang/Throwable
    //   117: ldc 131
    //   119: iconst_0
    //   120: anewarray 133	java/lang/Object
    //   123: invokestatic 137	com/tencent/mm/sdk/platformtools/Log:printErrStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
    //   126: bipush 64
    //   128: newarray byte
    //   130: astore_2
    //   131: getstatic 143	kotlin/j/c:aixl	Lkotlin/j/c$a;
    //   134: aload_2
    //   135: invokevirtual 149	kotlin/j/c$a:dG	([B)[B
    //   138: pop
    //   139: ldc 95
    //   141: invokestatic 65	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   144: aload_2
    //   145: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   26	42	0	i	int
    //   38	34	1	j	int
    //   13	85	2	localCloseable	java.io.Closeable
    //   110	4	2	localIOException	java.io.IOException
    //   130	15	2	arrayOfByte1	byte[]
    //   18	10	3	localInputStream	java.io.InputStream
    //   87	12	3	localThrowable	java.lang.Throwable
    //   23	62	4	arrayOfByte2	byte[]
    //   95	13	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   14	25	87	finally
    //   27	39	87	finally
    //   43	50	87	finally
    //   88	95	95	finally
    //   5	14	110	java/io/IOException
    //   50	60	110	java/io/IOException
    //   74	84	110	java/io/IOException
    //   97	110	110	java/io/IOException
  }
  
  public final String WH(String paramString)
  {
    label188:
    for (;;)
    {
      try
      {
        AppMethodBeat.i(323223);
        s.u(paramString, "appId");
        Assert.assertTrue(MMApplicationContext.isMainProcess());
        Object localObject1 = new c();
        ((c)localObject1).field_appId = paramString;
        Object localObject2 = ah.aiuX;
        get((IAutoDBItem)localObject1, new String[] { "appId" });
        localObject1 = ((c)localObject1).field_securityKeySalt;
        localObject2 = (CharSequence)localObject1;
        if (localObject2 != null)
        {
          if (((CharSequence)localObject2).length() == 0)
          {
            break label188;
            if (i == 0)
            {
              Log.i("MicroMsg.SecretMMKVStorage.AppBrandStorageSecurityInfoDB", "use securityKeySalt db cache");
              s.s(localObject1, "securityKeySalt");
              AppMethodBeat.o(323223);
              paramString = (String)localObject1;
              return paramString;
            }
          }
          else
          {
            i = 0;
            continue;
          }
          localObject1 = Base64.encodeToString(cix(), 0);
          localObject2 = new c();
          ((c)localObject2).field_appId = paramString;
          ((c)localObject2).field_securityKeySalt = ((String)localObject1);
          paramString = ah.aiuX;
          insert((IAutoDBItem)localObject2);
          Log.i("MicroMsg.SecretMMKVStorage.AppBrandStorageSecurityInfoDB", "generate security key salt and insert into db");
          s.s(localObject1, "securityKeySalt");
          AppMethodBeat.o(323223);
          paramString = (String)localObject1;
          continue;
        }
        int i = 1;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appstorage.b.b
 * JD-Core Version:    0.7.0.1
 */
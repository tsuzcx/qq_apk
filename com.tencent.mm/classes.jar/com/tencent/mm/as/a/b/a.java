package com.tencent.mm.as.a.b;

import com.tencent.mm.as.a.a.c;
import com.tencent.mm.as.a.c.f;
import com.tencent.mm.modelsfs.SFSContext;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.d;
import java.io.FileNotFoundException;
import java.io.InputStream;

public final class a
  implements com.tencent.mm.as.a.c.a
{
  private f erK;
  
  private String a(String paramString, c paramc)
  {
    Object localObject2 = paramc.erh;
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((String)localObject2).length() != 0) {}
    }
    else
    {
      localObject2 = paramc.eri;
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((String)localObject2).length() != 0) {
          localObject1 = (String)localObject2 + "/" + this.erK.mt(paramString);
        }
      }
    }
    localObject2 = localObject1;
    if (paramc.ere)
    {
      localObject2 = localObject1;
      if (bk.bl((String)localObject1)) {
        localObject2 = com.tencent.mm.as.a.g.b.OY() + "/" + this.erK.mt(paramString);
      }
    }
    if (localObject2 != null)
    {
      paramString = (String)localObject2;
      if (((String)localObject2).length() != 0) {}
    }
    else
    {
      paramString = null;
    }
    return paramString;
  }
  
  private String b(String paramString, c paramc)
  {
    String str1 = paramc.erj;
    Object localObject;
    if (str1 != null)
    {
      localObject = str1;
      if (str1.length() != 0) {}
    }
    else
    {
      String str2 = paramc.erh;
      localObject = str1;
      if (str2 != null)
      {
        localObject = str1;
        if (str2.length() > 0)
        {
          paramc = paramc.eri;
          if ((paramc == null) || (paramc.length() == 0) || (!str2.startsWith(paramc)))
          {
            y.e("MicroMsg.imageloader.DefaultImageDiskCache", "[johnw] SFS can't deal with absolute path: %s", new Object[] { str2 });
            throw new IllegalArgumentException("SFS can't deal with absolute path: " + str2);
          }
          paramc = str2.substring(paramc.length());
          localObject = paramc;
          if (paramc.startsWith("/")) {
            localObject = paramc.substring(1);
          }
        }
      }
    }
    if (localObject != null)
    {
      paramc = (c)localObject;
      if (((String)localObject).length() != 0) {}
    }
    else
    {
      paramc = this.erK.mt(paramString);
    }
    if (paramc != null)
    {
      paramString = paramc;
      if (paramc.length() != 0) {}
    }
    else
    {
      paramString = null;
    }
    return paramString;
  }
  
  public final void OW()
  {
    com.tencent.mm.as.a.g.b.Pa();
  }
  
  public final void a(f paramf)
  {
    this.erK = paramf;
  }
  
  /* Error */
  public final boolean a(String paramString, byte[] paramArrayOfByte, c paramc)
  {
    // Byte code:
    //   0: aload_3
    //   1: getfield 110	com/tencent/mm/as/a/a/c:erB	Lcom/tencent/mm/modelsfs/SFSContext;
    //   4: astore 4
    //   6: aload 4
    //   8: ifnull +80 -> 88
    //   11: aload_0
    //   12: aload_1
    //   13: aload_3
    //   14: invokespecial 112	com/tencent/mm/as/a/b/a:b	(Ljava/lang/String;Lcom/tencent/mm/as/a/a/c;)Ljava/lang/String;
    //   17: astore 5
    //   19: aload 5
    //   21: ifnonnull +5 -> 26
    //   24: iconst_0
    //   25: ireturn
    //   26: aconst_null
    //   27: astore_3
    //   28: aconst_null
    //   29: astore_1
    //   30: aload 4
    //   32: aload 5
    //   34: invokevirtual 118	com/tencent/mm/modelsfs/SFSContext:jI	(Ljava/lang/String;)Ljava/io/OutputStream;
    //   37: astore 4
    //   39: aload 4
    //   41: astore_1
    //   42: aload 4
    //   44: astore_3
    //   45: aload 4
    //   47: aload_2
    //   48: invokevirtual 124	java/io/OutputStream:write	([B)V
    //   51: aload 4
    //   53: ifnull +8 -> 61
    //   56: aload 4
    //   58: invokevirtual 127	java/io/OutputStream:close	()V
    //   61: iconst_1
    //   62: ireturn
    //   63: astore_2
    //   64: aload_1
    //   65: ifnull -41 -> 24
    //   68: aload_1
    //   69: invokevirtual 127	java/io/OutputStream:close	()V
    //   72: iconst_0
    //   73: ireturn
    //   74: astore_1
    //   75: iconst_0
    //   76: ireturn
    //   77: astore_1
    //   78: aload_3
    //   79: ifnull +7 -> 86
    //   82: aload_3
    //   83: invokevirtual 127	java/io/OutputStream:close	()V
    //   86: aload_1
    //   87: athrow
    //   88: aload_0
    //   89: aload_1
    //   90: aload_3
    //   91: invokespecial 129	com/tencent/mm/as/a/b/a:a	(Ljava/lang/String;Lcom/tencent/mm/as/a/a/c;)Ljava/lang/String;
    //   94: astore_1
    //   95: aload_1
    //   96: ifnull -72 -> 24
    //   99: new 131	com/tencent/mm/vfs/b
    //   102: dup
    //   103: aload_1
    //   104: invokespecial 132	com/tencent/mm/vfs/b:<init>	(Ljava/lang/String;)V
    //   107: invokevirtual 136	com/tencent/mm/vfs/b:cLq	()Lcom/tencent/mm/vfs/b;
    //   110: astore_3
    //   111: aload_3
    //   112: ifnull +15 -> 127
    //   115: aload_3
    //   116: invokevirtual 139	com/tencent/mm/vfs/b:exists	()Z
    //   119: ifne +8 -> 127
    //   122: aload_3
    //   123: invokevirtual 142	com/tencent/mm/vfs/b:mkdirs	()Z
    //   126: pop
    //   127: new 131	com/tencent/mm/vfs/b
    //   130: dup
    //   131: aload_1
    //   132: invokespecial 132	com/tencent/mm/vfs/b:<init>	(Ljava/lang/String;)V
    //   135: astore_3
    //   136: aload_3
    //   137: invokevirtual 139	com/tencent/mm/vfs/b:exists	()Z
    //   140: ifne +8 -> 148
    //   143: aload_3
    //   144: invokevirtual 145	com/tencent/mm/vfs/b:createNewFile	()Z
    //   147: pop
    //   148: aload_2
    //   149: ifnull -88 -> 61
    //   152: aload_1
    //   153: aload_2
    //   154: aload_2
    //   155: arraylength
    //   156: invokestatic 150	com/tencent/mm/vfs/e:b	(Ljava/lang/String;[BI)I
    //   159: ifge -98 -> 61
    //   162: iconst_0
    //   163: ireturn
    //   164: astore_3
    //   165: ldc 75
    //   167: aload_3
    //   168: invokestatic 154	com/tencent/mm/sdk/platformtools/bk:j	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   171: invokestatic 158	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   174: goto -26 -> 148
    //   177: astore_1
    //   178: goto -117 -> 61
    //   181: astore_2
    //   182: goto -96 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	185	0	this	a
    //   0	185	1	paramString	String
    //   0	185	2	paramArrayOfByte	byte[]
    //   0	185	3	paramc	c
    //   4	53	4	localObject	Object
    //   17	16	5	str	String
    // Exception table:
    //   from	to	target	type
    //   30	39	63	java/io/IOException
    //   45	51	63	java/io/IOException
    //   68	72	74	java/io/IOException
    //   30	39	77	finally
    //   45	51	77	finally
    //   143	148	164	java/lang/Exception
    //   56	61	177	java/io/IOException
    //   82	86	181	java/io/IOException
  }
  
  public final boolean c(String paramString, c paramc)
  {
    SFSContext localSFSContext = paramc.erB;
    if (localSFSContext != null)
    {
      paramString = b(paramString, paramc);
      if (paramString != null) {}
    }
    do
    {
      return false;
      return localSFSContext.jJ(paramString);
      paramString = a(paramString, paramc);
    } while (paramString == null);
    return new com.tencent.mm.vfs.b(paramString).delete();
  }
  
  public final InputStream d(String paramString, c paramc)
  {
    try
    {
      SFSContext localSFSContext = paramc.erB;
      if (localSFSContext != null)
      {
        paramString = b(paramString, paramc);
        if (paramString == null) {
          return null;
        }
        return localSFSContext.openRead(paramString);
      }
      paramString = a(paramString, paramc);
      if (paramString != null)
      {
        paramString = new d(paramString);
        return paramString;
      }
    }
    catch (FileNotFoundException paramString) {}
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.as.a.b.a
 * JD-Core Version:    0.7.0.1
 */
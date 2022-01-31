package com.tencent.mm.at.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.at.a.a.c;
import com.tencent.mm.at.a.c.f;
import com.tencent.mm.modelsfs.SFSContext;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.vfs.d;
import java.io.FileNotFoundException;
import java.io.InputStream;

public final class a
  implements com.tencent.mm.at.a.c.a
{
  private f fHA;
  
  private String a(String paramString, c paramc)
  {
    AppMethodBeat.i(116076);
    Object localObject2 = paramc.eNO;
    Object localObject1;
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (((String)localObject2).length() != 0) {}
    }
    else
    {
      localObject2 = paramc.eNP;
      localObject1 = localObject2;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (((String)localObject2).length() != 0) {
          localObject1 = (String)localObject2 + "/" + this.fHA.tD(paramString);
        }
      }
    }
    localObject2 = localObject1;
    if (paramc.eNL)
    {
      localObject2 = localObject1;
      if (bo.isNullOrNil((String)localObject1)) {
        localObject2 = com.tencent.mm.at.a.g.b.Uq() + "/" + this.fHA.tD(paramString);
      }
    }
    if ((localObject2 == null) || (((String)localObject2).length() == 0))
    {
      AppMethodBeat.o(116076);
      return null;
    }
    AppMethodBeat.o(116076);
    return localObject2;
  }
  
  private String b(String paramString, c paramc)
  {
    AppMethodBeat.i(116077);
    String str1 = paramc.eNQ;
    Object localObject;
    if (str1 != null)
    {
      localObject = str1;
      if (str1.length() != 0) {}
    }
    else
    {
      String str2 = paramc.eNO;
      localObject = str1;
      if (str2 != null)
      {
        localObject = str1;
        if (str2.length() > 0)
        {
          paramc = paramc.eNP;
          if ((paramc == null) || (paramc.length() == 0) || (!str2.startsWith(paramc)))
          {
            ab.e("MicroMsg.imageloader.DefaultImageDiskCache", "[johnw] SFS can't deal with absolute path: %s", new Object[] { str2 });
            paramString = new IllegalArgumentException("SFS can't deal with absolute path: ".concat(String.valueOf(str2)));
            AppMethodBeat.o(116077);
            throw paramString;
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
      paramc = this.fHA.tD(paramString);
    }
    if ((paramc == null) || (paramc.length() == 0))
    {
      AppMethodBeat.o(116077);
      return null;
    }
    AppMethodBeat.o(116077);
    return paramc;
  }
  
  public final void a(f paramf)
  {
    this.fHA = paramf;
  }
  
  /* Error */
  public final boolean a(String paramString, byte[] paramArrayOfByte, c paramc)
  {
    // Byte code:
    //   0: ldc 119
    //   2: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_3
    //   6: getfield 123	com/tencent/mm/at/a/a/c:eOd	Lcom/tencent/mm/modelsfs/SFSContext;
    //   9: astore 4
    //   11: aload 4
    //   13: ifnull +97 -> 110
    //   16: aload_0
    //   17: aload_1
    //   18: aload_3
    //   19: invokespecial 125	com/tencent/mm/at/a/b/a:b	(Ljava/lang/String;Lcom/tencent/mm/at/a/a/c;)Ljava/lang/String;
    //   22: astore 5
    //   24: aload 5
    //   26: ifnonnull +10 -> 36
    //   29: ldc 119
    //   31: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   34: iconst_0
    //   35: ireturn
    //   36: aconst_null
    //   37: astore_3
    //   38: aconst_null
    //   39: astore_1
    //   40: aload 4
    //   42: aload 5
    //   44: invokevirtual 131	com/tencent/mm/modelsfs/SFSContext:qC	(Ljava/lang/String;)Ljava/io/OutputStream;
    //   47: astore 4
    //   49: aload 4
    //   51: astore_1
    //   52: aload 4
    //   54: astore_3
    //   55: aload 4
    //   57: aload_2
    //   58: invokevirtual 137	java/io/OutputStream:write	([B)V
    //   61: aload 4
    //   63: ifnull +8 -> 71
    //   66: aload 4
    //   68: invokevirtual 140	java/io/OutputStream:close	()V
    //   71: ldc 119
    //   73: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: iconst_1
    //   77: ireturn
    //   78: astore_2
    //   79: aload_1
    //   80: ifnull +7 -> 87
    //   83: aload_1
    //   84: invokevirtual 140	java/io/OutputStream:close	()V
    //   87: ldc 119
    //   89: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   92: iconst_0
    //   93: ireturn
    //   94: astore_1
    //   95: aload_3
    //   96: ifnull +7 -> 103
    //   99: aload_3
    //   100: invokevirtual 140	java/io/OutputStream:close	()V
    //   103: ldc 119
    //   105: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   108: aload_1
    //   109: athrow
    //   110: aload_0
    //   111: aload_1
    //   112: aload_3
    //   113: invokespecial 142	com/tencent/mm/at/a/b/a:a	(Ljava/lang/String;Lcom/tencent/mm/at/a/a/c;)Ljava/lang/String;
    //   116: astore_1
    //   117: aload_1
    //   118: ifnonnull +10 -> 128
    //   121: ldc 119
    //   123: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: iconst_0
    //   127: ireturn
    //   128: new 144	com/tencent/mm/vfs/b
    //   131: dup
    //   132: aload_1
    //   133: invokespecial 145	com/tencent/mm/vfs/b:<init>	(Ljava/lang/String;)V
    //   136: invokevirtual 149	com/tencent/mm/vfs/b:dQI	()Lcom/tencent/mm/vfs/b;
    //   139: astore_3
    //   140: aload_3
    //   141: ifnull +15 -> 156
    //   144: aload_3
    //   145: invokevirtual 153	com/tencent/mm/vfs/b:exists	()Z
    //   148: ifne +8 -> 156
    //   151: aload_3
    //   152: invokevirtual 156	com/tencent/mm/vfs/b:mkdirs	()Z
    //   155: pop
    //   156: new 144	com/tencent/mm/vfs/b
    //   159: dup
    //   160: aload_1
    //   161: invokespecial 145	com/tencent/mm/vfs/b:<init>	(Ljava/lang/String;)V
    //   164: astore_3
    //   165: aload_3
    //   166: invokevirtual 153	com/tencent/mm/vfs/b:exists	()Z
    //   169: ifne +8 -> 177
    //   172: aload_3
    //   173: invokevirtual 159	com/tencent/mm/vfs/b:createNewFile	()Z
    //   176: pop
    //   177: aload_2
    //   178: ifnull -107 -> 71
    //   181: aload_1
    //   182: aload_2
    //   183: aload_2
    //   184: arraylength
    //   185: invokestatic 164	com/tencent/mm/vfs/e:b	(Ljava/lang/String;[BI)I
    //   188: ifge -117 -> 71
    //   191: ldc 119
    //   193: invokestatic 76	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   196: iconst_0
    //   197: ireturn
    //   198: astore_3
    //   199: ldc 86
    //   201: aload_3
    //   202: invokestatic 168	com/tencent/mm/sdk/platformtools/bo:l	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   205: invokestatic 171	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   208: goto -31 -> 177
    //   211: astore_1
    //   212: goto -141 -> 71
    //   215: astore_1
    //   216: goto -129 -> 87
    //   219: astore_2
    //   220: goto -117 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	223	0	this	a
    //   0	223	1	paramString	String
    //   0	223	2	paramArrayOfByte	byte[]
    //   0	223	3	paramc	c
    //   9	58	4	localObject	Object
    //   22	21	5	str	String
    // Exception table:
    //   from	to	target	type
    //   40	49	78	java/io/IOException
    //   55	61	78	java/io/IOException
    //   40	49	94	finally
    //   55	61	94	finally
    //   172	177	198	java/lang/Exception
    //   66	71	211	java/io/IOException
    //   83	87	215	java/io/IOException
    //   99	103	219	java/io/IOException
  }
  
  public final void ahZ()
  {
    AppMethodBeat.i(116080);
    com.tencent.mm.at.a.g.b.aib();
    AppMethodBeat.o(116080);
  }
  
  public final boolean c(String paramString, c paramc)
  {
    AppMethodBeat.i(116079);
    SFSContext localSFSContext = paramc.eOd;
    if (localSFSContext != null)
    {
      paramString = b(paramString, paramc);
      if (paramString == null)
      {
        AppMethodBeat.o(116079);
        return false;
      }
      bool = localSFSContext.qD(paramString);
      AppMethodBeat.o(116079);
      return bool;
    }
    paramString = a(paramString, paramc);
    if (paramString == null)
    {
      AppMethodBeat.o(116079);
      return false;
    }
    boolean bool = new com.tencent.mm.vfs.b(paramString).delete();
    AppMethodBeat.o(116079);
    return bool;
  }
  
  public final InputStream d(String paramString, c paramc)
  {
    AppMethodBeat.i(116081);
    try
    {
      SFSContext localSFSContext = paramc.eOd;
      if (localSFSContext != null)
      {
        paramString = b(paramString, paramc);
        if (paramString == null)
        {
          AppMethodBeat.o(116081);
          return null;
        }
        paramString = localSFSContext.openRead(paramString);
        AppMethodBeat.o(116081);
        return paramString;
      }
      paramString = a(paramString, paramc);
      if (paramString == null)
      {
        AppMethodBeat.o(116081);
        return null;
      }
      paramString = new d(paramString);
      AppMethodBeat.o(116081);
      return paramString;
    }
    catch (FileNotFoundException paramString)
    {
      AppMethodBeat.o(116081);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.at.a.b.a
 * JD-Core Version:    0.7.0.1
 */
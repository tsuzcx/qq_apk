package com.tencent.mm.plugin.appbrand.jsapi.media;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.sdk.system.MimeTypeUtil;
import java.io.InputStream;
import org.json.JSONObject;

public abstract class a
  extends com.tencent.mm.plugin.appbrand.jsapi.d<f>
{
  /* Error */
  static boolean c(String paramString, InputStream paramInputStream)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 5
    //   6: aload 5
    //   8: astore 4
    //   10: aload 6
    //   12: astore_3
    //   13: new 22	com/tencent/mm/vfs/o
    //   16: dup
    //   17: aload_0
    //   18: invokespecial 25	com/tencent/mm/vfs/o:<init>	(Ljava/lang/String;)V
    //   21: astore_0
    //   22: aload 5
    //   24: astore 4
    //   26: aload 6
    //   28: astore_3
    //   29: aload_0
    //   30: invokevirtual 29	com/tencent/mm/vfs/o:heq	()Lcom/tencent/mm/vfs/o;
    //   33: invokevirtual 33	com/tencent/mm/vfs/o:mkdirs	()Z
    //   36: pop
    //   37: aload 5
    //   39: astore 4
    //   41: aload 6
    //   43: astore_3
    //   44: aload_0
    //   45: invokestatic 39	com/tencent/mm/vfs/s:ap	(Lcom/tencent/mm/vfs/o;)Ljava/io/OutputStream;
    //   48: astore_0
    //   49: aload_0
    //   50: astore 4
    //   52: aload_0
    //   53: astore_3
    //   54: sipush 4096
    //   57: newarray byte
    //   59: astore 5
    //   61: aload_0
    //   62: astore 4
    //   64: aload_0
    //   65: astore_3
    //   66: aload_1
    //   67: aload 5
    //   69: iconst_0
    //   70: sipush 4096
    //   73: invokevirtual 45	java/io/InputStream:read	([BII)I
    //   76: istore_2
    //   77: iload_2
    //   78: iconst_m1
    //   79: if_icmpeq +49 -> 128
    //   82: aload_0
    //   83: astore 4
    //   85: aload_0
    //   86: astore_3
    //   87: aload_0
    //   88: aload 5
    //   90: iconst_0
    //   91: iload_2
    //   92: invokevirtual 51	java/io/OutputStream:write	([BII)V
    //   95: goto -34 -> 61
    //   98: astore_0
    //   99: aload 4
    //   101: astore_3
    //   102: ldc 53
    //   104: ldc 55
    //   106: iconst_1
    //   107: anewarray 57	java/lang/Object
    //   110: dup
    //   111: iconst_0
    //   112: aload_0
    //   113: aastore
    //   114: invokestatic 63	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   117: aload 4
    //   119: invokestatic 69	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   122: aload_1
    //   123: invokestatic 69	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   126: iconst_0
    //   127: ireturn
    //   128: aload_0
    //   129: astore 4
    //   131: aload_0
    //   132: astore_3
    //   133: aload_0
    //   134: invokevirtual 72	java/io/OutputStream:flush	()V
    //   137: aload_0
    //   138: invokestatic 69	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   141: aload_1
    //   142: invokestatic 69	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   145: iconst_1
    //   146: ireturn
    //   147: astore_0
    //   148: aload_3
    //   149: invokestatic 69	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   152: aload_1
    //   153: invokestatic 69	com/tencent/mm/sdk/platformtools/Util:qualityClose	(Ljava/io/Closeable;)V
    //   156: aload_0
    //   157: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	158	0	paramString	String
    //   0	158	1	paramInputStream	InputStream
    //   76	16	2	i	int
    //   12	137	3	localObject1	Object
    //   8	122	4	localObject2	Object
    //   4	85	5	arrayOfByte	byte[]
    //   1	41	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   13	22	98	java/lang/Exception
    //   29	37	98	java/lang/Exception
    //   44	49	98	java/lang/Exception
    //   54	61	98	java/lang/Exception
    //   66	77	98	java/lang/Exception
    //   87	95	98	java/lang/Exception
    //   133	137	98	java/lang/Exception
    //   13	22	147	finally
    //   29	37	147	finally
    //   44	49	147	finally
    //   54	61	147	finally
    //   66	77	147	finally
    //   87	95	147	finally
    //   102	117	147	finally
    //   133	137	147	finally
  }
  
  public final void a(final f paramf, final JSONObject paramJSONObject, final int paramInt)
  {
    paramJSONObject = paramJSONObject.optString("filePath", "");
    if (Util.isNullOrNil(paramJSONObject))
    {
      paramf.i(paramInt, h("fail filePath invalid", null));
      return;
    }
    paramJSONObject = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(139864);
        if (!paramf.isRunning())
        {
          AppMethodBeat.o(139864);
          return;
        }
        InputStream localInputStream = paramf.getFileSystem().Wc(paramJSONObject);
        if (localInputStream == null) {}
        try
        {
          paramf.i(paramInt, a.this.h("fail file not exists", null));
          return;
        }
        finally
        {
          String str1;
          Object localObject2;
          boolean bool;
          int i;
          a locala;
          Util.qualityClose(localInputStream);
          AppMethodBeat.o(139864);
        }
        str1 = org.apache.commons.a.d.getExtension(paramJSONObject);
        localObject2 = MimeTypeUtil.getMimeTypeByFileExt(str1);
        if (!a.this.aaa((String)localObject2))
        {
          paramf.i(paramInt, a.this.h("fail invalid file type", null));
          Util.qualityClose(localInputStream);
          AppMethodBeat.o(139864);
          return;
        }
        str1 = a.this.aab(str1);
        bool = a.c(str1, localInputStream);
        if (bool)
        {
          a.this.aac(str1);
          AndroidMediaUtil.refreshMediaScanner(str1, paramf.getContext());
        }
        localObject2 = paramf;
        i = paramInt;
        locala = a.this;
        if (bool) {}
        String str2;
        for (str1 = "ok";; str2 = "fail")
        {
          ((f)localObject2).i(i, locala.h(str1, null));
          break;
        }
      }
    };
    a.a locala = (a.a)paramf.M(a.a.class);
    if (locala == null)
    {
      Log.w("MicroMsg.AppBrand.BaseJsApiSaveToPhotosAlbum", "NULL permissionInterface with appId:%s, run directly", new Object[] { paramf.getAppId() });
      paramJSONObject.run();
      return;
    }
    locala.a(paramf.getContext(), paramJSONObject, new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(193677);
        paramf.i(paramInt, a.this.h("fail:system permission denied", null));
        AppMethodBeat.o(193677);
      }
    });
  }
  
  abstract boolean aaa(String paramString);
  
  abstract String aab(String paramString);
  
  abstract void aac(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.media.a
 * JD-Core Version:    0.7.0.1
 */
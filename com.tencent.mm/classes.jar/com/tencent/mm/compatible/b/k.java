package com.tencent.mm.compatible.b;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.IOException;

public final class k
  extends MediaPlayer
{
  public k()
  {
    AppMethodBeat.i(155617);
    g.os(hashCode());
    AppMethodBeat.o(155617);
  }
  
  public static k f(Context paramContext, Uri paramUri)
  {
    AppMethodBeat.i(155618);
    try
    {
      k localk = new k();
      localk.setDataSource(paramContext, paramUri);
      localk.prepare();
      AppMethodBeat.o(155618);
      return localk;
    }
    catch (IOException paramContext)
    {
      Log.d("MicroMsg.MediaPlayerWrapper", "create failed:", new Object[] { paramContext });
      AppMethodBeat.o(155618);
      return null;
    }
    catch (IllegalArgumentException paramContext)
    {
      for (;;)
      {
        Log.d("MicroMsg.MediaPlayerWrapper", "create failed:", new Object[] { paramContext });
      }
    }
    catch (SecurityException paramContext)
    {
      for (;;)
      {
        Log.d("MicroMsg.MediaPlayerWrapper", "create failed:", new Object[] { paramContext });
      }
    }
  }
  
  public final void release()
  {
    AppMethodBeat.i(155623);
    super.release();
    g.ot(hashCode());
    AppMethodBeat.o(155623);
  }
  
  public final void setDataSource(Context paramContext, Uri paramUri)
  {
    AppMethodBeat.i(155620);
    if (d.oD(26))
    {
      setDataSource(paramContext, paramUri, null, null);
      AppMethodBeat.o(155620);
      return;
    }
    setDataSource(paramContext, paramUri, null);
    AppMethodBeat.o(155620);
  }
  
  /* Error */
  public final void setDataSource(Context paramContext, Uri paramUri, java.util.Map<java.lang.String, java.lang.String> paramMap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc 80
    //   5: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: bipush 26
    //   10: invokestatic 71	com/tencent/mm/compatible/util/d:oD	(I)Z
    //   13: ifeq +17 -> 30
    //   16: aload_0
    //   17: aload_1
    //   18: aload_2
    //   19: aload_3
    //   20: aconst_null
    //   21: invokevirtual 74	com/tencent/mm/compatible/b/k:setDataSource	(Landroid/content/Context;Landroid/net/Uri;Ljava/util/Map;Ljava/util/List;)V
    //   24: ldc 80
    //   26: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: return
    //   30: aload_2
    //   31: invokevirtual 86	android/net/Uri:getScheme	()Ljava/lang/String;
    //   34: astore 5
    //   36: aload 5
    //   38: ifnull +33 -> 71
    //   41: aload 5
    //   43: ldc 88
    //   45: invokevirtual 94	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   48: ifne +23 -> 71
    //   51: aload 5
    //   53: ldc 96
    //   55: invokevirtual 94	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   58: ifne +13 -> 71
    //   61: aload 5
    //   63: ldc 98
    //   65: invokevirtual 94	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   68: ifeq +83 -> 151
    //   71: aload_2
    //   72: aconst_null
    //   73: ldc 100
    //   75: invokestatic 106	com/tencent/mm/vfs/s:a	(Landroid/net/Uri;Lcom/tencent/mm/vfs/g$e;Ljava/lang/String;)Landroid/os/ParcelFileDescriptor;
    //   78: astore_3
    //   79: aload_0
    //   80: aload_3
    //   81: invokevirtual 112	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   84: invokevirtual 115	com/tencent/mm/compatible/b/k:setDataSource	(Ljava/io/FileDescriptor;)V
    //   87: aload_3
    //   88: ifnull +57 -> 145
    //   91: aload_3
    //   92: invokevirtual 118	android/os/ParcelFileDescriptor:close	()V
    //   95: ldc 80
    //   97: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   100: return
    //   101: astore_2
    //   102: ldc 80
    //   104: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: aload_2
    //   108: athrow
    //   109: astore_1
    //   110: aload_3
    //   111: ifnull +11 -> 122
    //   114: aload_2
    //   115: ifnull +23 -> 138
    //   118: aload_3
    //   119: invokevirtual 118	android/os/ParcelFileDescriptor:close	()V
    //   122: ldc 80
    //   124: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   127: aload_1
    //   128: athrow
    //   129: astore_3
    //   130: aload_2
    //   131: aload_3
    //   132: invokevirtual 122	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   135: goto -13 -> 122
    //   138: aload_3
    //   139: invokevirtual 118	android/os/ParcelFileDescriptor:close	()V
    //   142: goto -20 -> 122
    //   145: ldc 80
    //   147: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   150: return
    //   151: aload_0
    //   152: aload_1
    //   153: aload_2
    //   154: aload_3
    //   155: invokespecial 123	android/media/MediaPlayer:setDataSource	(Landroid/content/Context;Landroid/net/Uri;Ljava/util/Map;)V
    //   158: ldc 80
    //   160: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   163: return
    //   164: astore_1
    //   165: aload 4
    //   167: astore_2
    //   168: goto -58 -> 110
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	171	0	this	k
    //   0	171	1	paramContext	Context
    //   0	171	2	paramUri	Uri
    //   0	171	3	paramMap	java.util.Map<java.lang.String, java.lang.String>
    //   1	165	4	localObject	Object
    //   34	28	5	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   79	87	101	java/lang/Throwable
    //   102	109	109	finally
    //   118	122	129	java/lang/Throwable
    //   79	87	164	finally
  }
  
  /* Error */
  public final void setDataSource(Context paramContext, Uri paramUri, java.util.Map<java.lang.String, java.lang.String> paramMap, java.util.List<java.net.HttpCookie> paramList)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: ldc 126
    //   5: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_2
    //   9: invokevirtual 86	android/net/Uri:getScheme	()Ljava/lang/String;
    //   12: astore 6
    //   14: aload 6
    //   16: ifnull +33 -> 49
    //   19: aload 6
    //   21: ldc 88
    //   23: invokevirtual 94	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   26: ifne +23 -> 49
    //   29: aload 6
    //   31: ldc 96
    //   33: invokevirtual 94	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   36: ifne +13 -> 49
    //   39: aload 6
    //   41: ldc 98
    //   43: invokevirtual 94	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   46: ifeq +83 -> 129
    //   49: aload_2
    //   50: aconst_null
    //   51: ldc 100
    //   53: invokestatic 106	com/tencent/mm/vfs/s:a	(Landroid/net/Uri;Lcom/tencent/mm/vfs/g$e;Ljava/lang/String;)Landroid/os/ParcelFileDescriptor;
    //   56: astore_3
    //   57: aload_0
    //   58: aload_3
    //   59: invokevirtual 112	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   62: invokevirtual 115	com/tencent/mm/compatible/b/k:setDataSource	(Ljava/io/FileDescriptor;)V
    //   65: aload_3
    //   66: ifnull +57 -> 123
    //   69: aload_3
    //   70: invokevirtual 118	android/os/ParcelFileDescriptor:close	()V
    //   73: ldc 126
    //   75: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   78: return
    //   79: astore_2
    //   80: ldc 126
    //   82: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: aload_2
    //   86: athrow
    //   87: astore_1
    //   88: aload_3
    //   89: ifnull +11 -> 100
    //   92: aload_2
    //   93: ifnull +23 -> 116
    //   96: aload_3
    //   97: invokevirtual 118	android/os/ParcelFileDescriptor:close	()V
    //   100: ldc 126
    //   102: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   105: aload_1
    //   106: athrow
    //   107: astore_3
    //   108: aload_2
    //   109: aload_3
    //   110: invokevirtual 122	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   113: goto -13 -> 100
    //   116: aload_3
    //   117: invokevirtual 118	android/os/ParcelFileDescriptor:close	()V
    //   120: goto -20 -> 100
    //   123: ldc 126
    //   125: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   128: return
    //   129: aload_0
    //   130: aload_1
    //   131: aload_2
    //   132: aload_3
    //   133: aload 4
    //   135: invokespecial 127	android/media/MediaPlayer:setDataSource	(Landroid/content/Context;Landroid/net/Uri;Ljava/util/Map;Ljava/util/List;)V
    //   138: ldc 126
    //   140: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   143: return
    //   144: astore_1
    //   145: aload 5
    //   147: astore_2
    //   148: goto -60 -> 88
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	151	0	this	k
    //   0	151	1	paramContext	Context
    //   0	151	2	paramUri	Uri
    //   0	151	3	paramMap	java.util.Map<java.lang.String, java.lang.String>
    //   0	151	4	paramList	java.util.List<java.net.HttpCookie>
    //   1	145	5	localObject	Object
    //   12	28	6	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   57	65	79	java/lang/Throwable
    //   80	87	87	finally
    //   96	100	107	java/lang/Throwable
    //   57	65	144	finally
  }
  
  /* Error */
  public final void setDataSource(java.lang.String paramString)
  {
    // Byte code:
    //   0: ldc 132
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ldc 100
    //   8: invokestatic 136	com/tencent/mm/vfs/s:nv	(Ljava/lang/String;Ljava/lang/String;)Landroid/os/ParcelFileDescriptor;
    //   11: astore 4
    //   13: aconst_null
    //   14: astore_3
    //   15: aload_0
    //   16: aload 4
    //   18: invokevirtual 112	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   21: invokevirtual 115	com/tencent/mm/compatible/b/k:setDataSource	(Ljava/io/FileDescriptor;)V
    //   24: aload 4
    //   26: ifnull +8 -> 34
    //   29: aload 4
    //   31: invokevirtual 118	android/os/ParcelFileDescriptor:close	()V
    //   34: ldc 132
    //   36: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: return
    //   40: astore_3
    //   41: ldc 132
    //   43: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: aload_3
    //   47: athrow
    //   48: astore_2
    //   49: aload 4
    //   51: ifnull +12 -> 63
    //   54: aload_3
    //   55: ifnull +71 -> 126
    //   58: aload 4
    //   60: invokevirtual 118	android/os/ParcelFileDescriptor:close	()V
    //   63: ldc 132
    //   65: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   68: aload_2
    //   69: athrow
    //   70: astore_2
    //   71: ldc 49
    //   73: new 138	java/lang/StringBuilder
    //   76: dup
    //   77: ldc 140
    //   79: invokespecial 142	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   82: aload_1
    //   83: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: ldc 148
    //   88: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload_2
    //   92: invokevirtual 151	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   95: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 154	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokestatic 158	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   104: aload_0
    //   105: aload_1
    //   106: invokespecial 160	android/media/MediaPlayer:setDataSource	(Ljava/lang/String;)V
    //   109: ldc 132
    //   111: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   114: return
    //   115: astore 4
    //   117: aload_3
    //   118: aload 4
    //   120: invokevirtual 122	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   123: goto -60 -> 63
    //   126: aload 4
    //   128: invokevirtual 118	android/os/ParcelFileDescriptor:close	()V
    //   131: goto -68 -> 63
    //   134: astore_2
    //   135: goto -86 -> 49
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	this	k
    //   0	138	1	paramString	java.lang.String
    //   48	21	2	localObject1	Object
    //   70	22	2	localFileNotFoundException	java.io.FileNotFoundException
    //   134	1	2	localObject2	Object
    //   14	1	3	localObject3	Object
    //   40	78	3	localThrowable1	java.lang.Throwable
    //   11	48	4	localParcelFileDescriptor	android.os.ParcelFileDescriptor
    //   115	12	4	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   15	24	40	java/lang/Throwable
    //   41	48	48	finally
    //   5	13	70	java/io/FileNotFoundException
    //   29	34	70	java/io/FileNotFoundException
    //   58	63	70	java/io/FileNotFoundException
    //   63	70	70	java/io/FileNotFoundException
    //   117	123	70	java/io/FileNotFoundException
    //   126	131	70	java/io/FileNotFoundException
    //   58	63	115	java/lang/Throwable
    //   15	24	134	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.compatible.b.k
 * JD-Core Version:    0.7.0.1
 */
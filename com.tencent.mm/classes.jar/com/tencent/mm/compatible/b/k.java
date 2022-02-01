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
    g.qH(hashCode());
    AppMethodBeat.o(155617);
  }
  
  public static k d(Context paramContext, Uri paramUri)
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
    g.qI(hashCode());
    AppMethodBeat.o(155623);
  }
  
  public final void setDataSource(Context paramContext, Uri paramUri)
  {
    AppMethodBeat.i(155620);
    if (d.qV(26))
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
    //   3: ldc 79
    //   5: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: bipush 26
    //   10: invokestatic 70	com/tencent/mm/compatible/util/d:qV	(I)Z
    //   13: ifeq +17 -> 30
    //   16: aload_0
    //   17: aload_1
    //   18: aload_2
    //   19: aload_3
    //   20: aconst_null
    //   21: invokevirtual 73	com/tencent/mm/compatible/b/k:setDataSource	(Landroid/content/Context;Landroid/net/Uri;Ljava/util/Map;Ljava/util/List;)V
    //   24: ldc 79
    //   26: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   29: return
    //   30: aload_2
    //   31: invokevirtual 85	android/net/Uri:getScheme	()Ljava/lang/String;
    //   34: astore 5
    //   36: aload 5
    //   38: ifnull +33 -> 71
    //   41: aload 5
    //   43: ldc 87
    //   45: invokevirtual 93	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   48: ifne +23 -> 71
    //   51: aload 5
    //   53: ldc 95
    //   55: invokevirtual 93	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   58: ifne +13 -> 71
    //   61: aload 5
    //   63: ldc 97
    //   65: invokevirtual 93	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   68: ifeq +82 -> 150
    //   71: aload_2
    //   72: ldc 99
    //   74: invokestatic 105	com/tencent/mm/vfs/u:b	(Landroid/net/Uri;Ljava/lang/String;)Landroid/os/ParcelFileDescriptor;
    //   77: astore_3
    //   78: aload_0
    //   79: aload_3
    //   80: invokevirtual 111	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   83: invokevirtual 114	com/tencent/mm/compatible/b/k:setDataSource	(Ljava/io/FileDescriptor;)V
    //   86: aload_3
    //   87: ifnull +57 -> 144
    //   90: aload_3
    //   91: invokevirtual 117	android/os/ParcelFileDescriptor:close	()V
    //   94: ldc 79
    //   96: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   99: return
    //   100: astore_2
    //   101: ldc 79
    //   103: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   106: aload_2
    //   107: athrow
    //   108: astore_1
    //   109: aload_3
    //   110: ifnull +11 -> 121
    //   113: aload_2
    //   114: ifnull +23 -> 137
    //   117: aload_3
    //   118: invokevirtual 117	android/os/ParcelFileDescriptor:close	()V
    //   121: ldc 79
    //   123: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: aload_1
    //   127: athrow
    //   128: astore_3
    //   129: aload_2
    //   130: aload_3
    //   131: invokevirtual 121	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   134: goto -13 -> 121
    //   137: aload_3
    //   138: invokevirtual 117	android/os/ParcelFileDescriptor:close	()V
    //   141: goto -20 -> 121
    //   144: ldc 79
    //   146: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   149: return
    //   150: aload_0
    //   151: aload_1
    //   152: aload_2
    //   153: aload_3
    //   154: invokespecial 122	android/media/MediaPlayer:setDataSource	(Landroid/content/Context;Landroid/net/Uri;Ljava/util/Map;)V
    //   157: ldc 79
    //   159: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   162: return
    //   163: astore_1
    //   164: aload 4
    //   166: astore_2
    //   167: goto -58 -> 109
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	170	0	this	k
    //   0	170	1	paramContext	Context
    //   0	170	2	paramUri	Uri
    //   0	170	3	paramMap	java.util.Map<java.lang.String, java.lang.String>
    //   1	164	4	localObject	Object
    //   34	28	5	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   78	86	100	java/lang/Throwable
    //   101	108	108	finally
    //   117	121	128	java/lang/Throwable
    //   78	86	163	finally
  }
  
  /* Error */
  public final void setDataSource(Context paramContext, Uri paramUri, java.util.Map<java.lang.String, java.lang.String> paramMap, java.util.List<java.net.HttpCookie> paramList)
  {
    // Byte code:
    //   0: ldc 125
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_2
    //   6: invokevirtual 85	android/net/Uri:getScheme	()Ljava/lang/String;
    //   9: astore 5
    //   11: aload 5
    //   13: ifnull +33 -> 46
    //   16: aload 5
    //   18: ldc 87
    //   20: invokevirtual 93	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   23: ifne +23 -> 46
    //   26: aload 5
    //   28: ldc 95
    //   30: invokevirtual 93	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   33: ifne +13 -> 46
    //   36: aload 5
    //   38: ldc 97
    //   40: invokevirtual 93	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   43: ifeq +84 -> 127
    //   46: aload_2
    //   47: ldc 99
    //   49: invokestatic 105	com/tencent/mm/vfs/u:b	(Landroid/net/Uri;Ljava/lang/String;)Landroid/os/ParcelFileDescriptor;
    //   52: astore_3
    //   53: aconst_null
    //   54: astore_2
    //   55: aload_0
    //   56: aload_3
    //   57: invokevirtual 111	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   60: invokevirtual 114	com/tencent/mm/compatible/b/k:setDataSource	(Ljava/io/FileDescriptor;)V
    //   63: aload_3
    //   64: ifnull +57 -> 121
    //   67: aload_3
    //   68: invokevirtual 117	android/os/ParcelFileDescriptor:close	()V
    //   71: ldc 125
    //   73: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: return
    //   77: astore_2
    //   78: ldc 125
    //   80: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   83: aload_2
    //   84: athrow
    //   85: astore_1
    //   86: aload_3
    //   87: ifnull +11 -> 98
    //   90: aload_2
    //   91: ifnull +23 -> 114
    //   94: aload_3
    //   95: invokevirtual 117	android/os/ParcelFileDescriptor:close	()V
    //   98: ldc 125
    //   100: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   103: aload_1
    //   104: athrow
    //   105: astore_3
    //   106: aload_2
    //   107: aload_3
    //   108: invokevirtual 121	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   111: goto -13 -> 98
    //   114: aload_3
    //   115: invokevirtual 117	android/os/ParcelFileDescriptor:close	()V
    //   118: goto -20 -> 98
    //   121: ldc 125
    //   123: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: return
    //   127: aload_0
    //   128: aload_1
    //   129: aload_2
    //   130: aload_3
    //   131: aload 4
    //   133: invokespecial 126	android/media/MediaPlayer:setDataSource	(Landroid/content/Context;Landroid/net/Uri;Ljava/util/Map;Ljava/util/List;)V
    //   136: ldc 125
    //   138: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   141: return
    //   142: astore_1
    //   143: goto -57 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	this	k
    //   0	146	1	paramContext	Context
    //   0	146	2	paramUri	Uri
    //   0	146	3	paramMap	java.util.Map<java.lang.String, java.lang.String>
    //   0	146	4	paramList	java.util.List<java.net.HttpCookie>
    //   9	28	5	str	java.lang.String
    // Exception table:
    //   from	to	target	type
    //   55	63	77	java/lang/Throwable
    //   78	85	85	finally
    //   94	98	105	java/lang/Throwable
    //   55	63	142	finally
  }
  
  /* Error */
  public final void setDataSource(java.lang.String paramString)
  {
    // Byte code:
    //   0: ldc 131
    //   2: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ldc 99
    //   8: invokestatic 135	com/tencent/mm/vfs/u:om	(Ljava/lang/String;Ljava/lang/String;)Landroid/os/ParcelFileDescriptor;
    //   11: astore 4
    //   13: aconst_null
    //   14: astore_3
    //   15: aload_0
    //   16: aload 4
    //   18: invokevirtual 111	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   21: invokevirtual 114	com/tencent/mm/compatible/b/k:setDataSource	(Ljava/io/FileDescriptor;)V
    //   24: aload 4
    //   26: ifnull +8 -> 34
    //   29: aload 4
    //   31: invokevirtual 117	android/os/ParcelFileDescriptor:close	()V
    //   34: ldc 131
    //   36: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: return
    //   40: astore_3
    //   41: ldc 131
    //   43: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: aload_3
    //   47: athrow
    //   48: astore_2
    //   49: aload 4
    //   51: ifnull +12 -> 63
    //   54: aload_3
    //   55: ifnull +71 -> 126
    //   58: aload 4
    //   60: invokevirtual 117	android/os/ParcelFileDescriptor:close	()V
    //   63: ldc 131
    //   65: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   68: aload_2
    //   69: athrow
    //   70: astore_2
    //   71: ldc 49
    //   73: new 137	java/lang/StringBuilder
    //   76: dup
    //   77: ldc 139
    //   79: invokespecial 141	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   82: aload_1
    //   83: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: ldc 147
    //   88: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload_2
    //   92: invokevirtual 150	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   95: invokevirtual 145	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 153	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokestatic 157	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   104: aload_0
    //   105: aload_1
    //   106: invokespecial 159	android/media/MediaPlayer:setDataSource	(Ljava/lang/String;)V
    //   109: ldc 131
    //   111: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   114: return
    //   115: astore 4
    //   117: aload_3
    //   118: aload 4
    //   120: invokevirtual 121	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   123: goto -60 -> 63
    //   126: aload 4
    //   128: invokevirtual 117	android/os/ParcelFileDescriptor:close	()V
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.compatible.b.k
 * JD-Core Version:    0.7.0.1
 */
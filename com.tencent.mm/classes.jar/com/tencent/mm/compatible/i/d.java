package com.tencent.mm.compatible.i;

import android.media.MediaMetadataRetriever;

public final class d
  extends MediaMetadataRetriever
{
  /* Error */
  public final void setDataSource(android.content.Context paramContext, android.net.Uri paramUri)
  {
    // Byte code:
    //   0: ldc 14
    //   2: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_2
    //   6: invokevirtual 26	android/net/Uri:getScheme	()Ljava/lang/String;
    //   9: astore_3
    //   10: aload_3
    //   11: ifnull +30 -> 41
    //   14: aload_3
    //   15: ldc 28
    //   17: invokevirtual 34	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   20: ifne +21 -> 41
    //   23: aload_3
    //   24: ldc 36
    //   26: invokevirtual 34	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   29: ifne +12 -> 41
    //   32: aload_3
    //   33: ldc 38
    //   35: invokevirtual 34	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   38: ifeq +89 -> 127
    //   41: aload_2
    //   42: aconst_null
    //   43: ldc 40
    //   45: invokestatic 46	com/tencent/mm/vfs/y:a	(Landroid/net/Uri;Lcom/tencent/mm/vfs/k$f;Ljava/lang/String;)Landroid/os/ParcelFileDescriptor;
    //   48: astore 4
    //   50: aload_0
    //   51: aload 4
    //   53: invokevirtual 52	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   56: invokevirtual 55	com/tencent/mm/compatible/i/d:setDataSource	(Ljava/io/FileDescriptor;)V
    //   59: aload 4
    //   61: ifnull +8 -> 69
    //   64: aload 4
    //   66: invokevirtual 58	android/os/ParcelFileDescriptor:close	()V
    //   69: ldc 14
    //   71: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   74: return
    //   75: astore_3
    //   76: aload 4
    //   78: ifnull +8 -> 86
    //   81: aload 4
    //   83: invokevirtual 58	android/os/ParcelFileDescriptor:close	()V
    //   86: ldc 14
    //   88: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: aload_3
    //   92: athrow
    //   93: astore_3
    //   94: ldc 63
    //   96: new 65	java/lang/StringBuilder
    //   99: dup
    //   100: ldc 67
    //   102: invokespecial 70	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   105: aload_2
    //   106: invokevirtual 74	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   109: ldc 76
    //   111: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: aload_3
    //   115: invokevirtual 82	java/io/IOException:getMessage	()Ljava/lang/String;
    //   118: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   121: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   124: invokestatic 91	com/tencent/stubs/logger/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   127: aload_0
    //   128: aload_1
    //   129: aload_2
    //   130: invokespecial 93	android/media/MediaMetadataRetriever:setDataSource	(Landroid/content/Context;Landroid/net/Uri;)V
    //   133: ldc 14
    //   135: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: return
    //   139: astore 4
    //   141: aload_3
    //   142: aload 4
    //   144: invokevirtual 99	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   147: goto -61 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	150	0	this	d
    //   0	150	1	paramContext	android.content.Context
    //   0	150	2	paramUri	android.net.Uri
    //   9	24	3	str	java.lang.String
    //   75	17	3	localObject	java.lang.Object
    //   93	49	3	localIOException	java.io.IOException
    //   48	34	4	localParcelFileDescriptor	android.os.ParcelFileDescriptor
    //   139	4	4	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   50	59	75	finally
    //   41	50	93	java/io/IOException
    //   64	69	93	java/io/IOException
    //   86	93	93	java/io/IOException
    //   141	147	93	java/io/IOException
    //   81	86	139	finally
  }
  
  /* Error */
  public final void setDataSource(java.lang.String paramString)
  {
    // Byte code:
    //   0: ldc 100
    //   2: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ldc 40
    //   8: invokestatic 104	com/tencent/mm/vfs/y:qk	(Ljava/lang/String;Ljava/lang/String;)Landroid/os/ParcelFileDescriptor;
    //   11: astore_3
    //   12: aload_0
    //   13: aload_3
    //   14: invokevirtual 52	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   17: invokevirtual 55	com/tencent/mm/compatible/i/d:setDataSource	(Ljava/io/FileDescriptor;)V
    //   20: aload_3
    //   21: ifnull +7 -> 28
    //   24: aload_3
    //   25: invokevirtual 58	android/os/ParcelFileDescriptor:close	()V
    //   28: ldc 100
    //   30: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   33: return
    //   34: astore_2
    //   35: aload_3
    //   36: ifnull +7 -> 43
    //   39: aload_3
    //   40: invokevirtual 58	android/os/ParcelFileDescriptor:close	()V
    //   43: ldc 100
    //   45: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   48: aload_2
    //   49: athrow
    //   50: astore_2
    //   51: ldc 63
    //   53: new 65	java/lang/StringBuilder
    //   56: dup
    //   57: ldc 106
    //   59: invokespecial 70	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   62: aload_1
    //   63: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: ldc 76
    //   68: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: aload_2
    //   72: invokevirtual 82	java/io/IOException:getMessage	()Ljava/lang/String;
    //   75: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   81: invokestatic 91	com/tencent/stubs/logger/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   84: aload_0
    //   85: aload_1
    //   86: invokespecial 108	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   89: ldc 100
    //   91: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   94: return
    //   95: astore_3
    //   96: aload_2
    //   97: aload_3
    //   98: invokevirtual 99	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   101: goto -58 -> 43
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	104	0	this	d
    //   0	104	1	paramString	java.lang.String
    //   34	15	2	localObject	java.lang.Object
    //   50	47	2	localIOException	java.io.IOException
    //   11	29	3	localParcelFileDescriptor	android.os.ParcelFileDescriptor
    //   95	3	3	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   12	20	34	finally
    //   5	12	50	java/io/IOException
    //   24	28	50	java/io/IOException
    //   43	50	50	java/io/IOException
    //   96	101	50	java/io/IOException
    //   39	43	95	finally
  }
  
  /* Error */
  public final void setDataSource(java.lang.String paramString, java.util.Map<java.lang.String, java.lang.String> paramMap)
  {
    // Byte code:
    //   0: ldc 110
    //   2: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokestatic 114	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   9: invokevirtual 26	android/net/Uri:getScheme	()Ljava/lang/String;
    //   12: astore_3
    //   13: aload_3
    //   14: ifnull +30 -> 44
    //   17: aload_3
    //   18: ldc 28
    //   20: invokevirtual 34	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   23: ifne +21 -> 44
    //   26: aload_3
    //   27: ldc 36
    //   29: invokevirtual 34	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   32: ifne +12 -> 44
    //   35: aload_3
    //   36: ldc 38
    //   38: invokevirtual 34	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   41: ifeq +88 -> 129
    //   44: aload_1
    //   45: ldc 40
    //   47: invokestatic 104	com/tencent/mm/vfs/y:qk	(Ljava/lang/String;Ljava/lang/String;)Landroid/os/ParcelFileDescriptor;
    //   50: astore 4
    //   52: aload_0
    //   53: aload 4
    //   55: invokevirtual 52	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   58: invokevirtual 55	com/tencent/mm/compatible/i/d:setDataSource	(Ljava/io/FileDescriptor;)V
    //   61: aload 4
    //   63: ifnull +8 -> 71
    //   66: aload 4
    //   68: invokevirtual 58	android/os/ParcelFileDescriptor:close	()V
    //   71: ldc 110
    //   73: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: return
    //   77: astore_3
    //   78: aload 4
    //   80: ifnull +8 -> 88
    //   83: aload 4
    //   85: invokevirtual 58	android/os/ParcelFileDescriptor:close	()V
    //   88: ldc 110
    //   90: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   93: aload_3
    //   94: athrow
    //   95: astore_3
    //   96: ldc 63
    //   98: new 65	java/lang/StringBuilder
    //   101: dup
    //   102: ldc 67
    //   104: invokespecial 70	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   107: aload_1
    //   108: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: ldc 76
    //   113: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: aload_3
    //   117: invokevirtual 82	java/io/IOException:getMessage	()Ljava/lang/String;
    //   120: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: invokevirtual 85	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   126: invokestatic 91	com/tencent/stubs/logger/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   129: aload_0
    //   130: aload_1
    //   131: aload_2
    //   132: invokespecial 116	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;Ljava/util/Map;)V
    //   135: ldc 110
    //   137: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   140: return
    //   141: astore 4
    //   143: aload_3
    //   144: aload 4
    //   146: invokevirtual 99	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   149: goto -61 -> 88
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	152	0	this	d
    //   0	152	1	paramString	java.lang.String
    //   0	152	2	paramMap	java.util.Map<java.lang.String, java.lang.String>
    //   12	24	3	str	java.lang.String
    //   77	17	3	localObject	java.lang.Object
    //   95	49	3	localIOException	java.io.IOException
    //   50	34	4	localParcelFileDescriptor	android.os.ParcelFileDescriptor
    //   141	4	4	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   52	61	77	finally
    //   44	52	95	java/io/IOException
    //   66	71	95	java/io/IOException
    //   88	95	95	java/io/IOException
    //   143	149	95	java/io/IOException
    //   83	88	141	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.compatible.i.d
 * JD-Core Version:    0.7.0.1
 */
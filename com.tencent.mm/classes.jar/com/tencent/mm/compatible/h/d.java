package com.tencent.mm.compatible.h;

import android.annotation.TargetApi;
import android.media.MediaMetadataRetriever;

@TargetApi(16)
public final class d
  extends MediaMetadataRetriever
{
  /* Error */
  public final void setDataSource(android.content.Context paramContext, android.net.Uri paramUri)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: ldc 19
    //   5: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: aload_2
    //   9: invokevirtual 31	android/net/Uri:getScheme	()Ljava/lang/String;
    //   12: astore_3
    //   13: aload_3
    //   14: ifnull +30 -> 44
    //   17: aload_3
    //   18: ldc 33
    //   20: invokevirtual 39	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   23: ifne +21 -> 44
    //   26: aload_3
    //   27: ldc 41
    //   29: invokevirtual 39	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   32: ifne +12 -> 44
    //   35: aload_3
    //   36: ldc 43
    //   38: invokevirtual 39	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   41: ifeq +104 -> 145
    //   44: aload_2
    //   45: aconst_null
    //   46: ldc 45
    //   48: invokestatic 51	com/tencent/mm/vfs/i:a	(Landroid/net/Uri;Lcom/tencent/mm/vfs/a$e;Ljava/lang/String;)Landroid/os/ParcelFileDescriptor;
    //   51: astore 5
    //   53: aload_0
    //   54: aload 5
    //   56: invokevirtual 57	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   59: invokevirtual 60	com/tencent/mm/compatible/h/d:setDataSource	(Ljava/io/FileDescriptor;)V
    //   62: aload 5
    //   64: ifnull +8 -> 72
    //   67: aload 5
    //   69: invokevirtual 63	android/os/ParcelFileDescriptor:close	()V
    //   72: ldc 19
    //   74: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   77: return
    //   78: astore 4
    //   80: ldc 19
    //   82: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   85: aload 4
    //   87: athrow
    //   88: astore_3
    //   89: aload 5
    //   91: ifnull +13 -> 104
    //   94: aload 4
    //   96: ifnull +73 -> 169
    //   99: aload 5
    //   101: invokevirtual 63	android/os/ParcelFileDescriptor:close	()V
    //   104: ldc 19
    //   106: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   109: aload_3
    //   110: athrow
    //   111: astore_3
    //   112: ldc 68
    //   114: new 70	java/lang/StringBuilder
    //   117: dup
    //   118: ldc 72
    //   120: invokespecial 75	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   123: aload_2
    //   124: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   127: ldc 81
    //   129: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   132: aload_3
    //   133: invokevirtual 87	java/io/IOException:getMessage	()Ljava/lang/String;
    //   136: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   139: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   142: invokestatic 96	com/tencent/stubs/logger/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   145: aload_0
    //   146: aload_1
    //   147: aload_2
    //   148: invokespecial 98	android/media/MediaMetadataRetriever:setDataSource	(Landroid/content/Context;Landroid/net/Uri;)V
    //   151: ldc 19
    //   153: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   156: return
    //   157: astore 5
    //   159: aload 4
    //   161: aload 5
    //   163: invokevirtual 102	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   166: goto -62 -> 104
    //   169: aload 5
    //   171: invokevirtual 63	android/os/ParcelFileDescriptor:close	()V
    //   174: goto -70 -> 104
    //   177: astore_3
    //   178: goto -89 -> 89
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	181	0	this	d
    //   0	181	1	paramContext	android.content.Context
    //   0	181	2	paramUri	android.net.Uri
    //   12	24	3	str	java.lang.String
    //   88	22	3	localObject1	java.lang.Object
    //   111	22	3	localIOException	java.io.IOException
    //   177	1	3	localObject2	java.lang.Object
    //   1	1	4	localObject3	java.lang.Object
    //   78	82	4	localThrowable1	java.lang.Throwable
    //   51	49	5	localParcelFileDescriptor	android.os.ParcelFileDescriptor
    //   157	13	5	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   53	62	78	java/lang/Throwable
    //   80	88	88	finally
    //   44	53	111	java/io/IOException
    //   67	72	111	java/io/IOException
    //   99	104	111	java/io/IOException
    //   104	111	111	java/io/IOException
    //   159	166	111	java/io/IOException
    //   169	174	111	java/io/IOException
    //   99	104	157	java/lang/Throwable
    //   53	62	177	finally
  }
  
  /* Error */
  public final void setDataSource(java.lang.String paramString)
  {
    // Byte code:
    //   0: ldc 103
    //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ldc 45
    //   8: invokestatic 107	com/tencent/mm/vfs/i:my	(Ljava/lang/String;Ljava/lang/String;)Landroid/os/ParcelFileDescriptor;
    //   11: astore 4
    //   13: aconst_null
    //   14: astore_3
    //   15: aload_0
    //   16: aload 4
    //   18: invokevirtual 57	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   21: invokevirtual 60	com/tencent/mm/compatible/h/d:setDataSource	(Ljava/io/FileDescriptor;)V
    //   24: aload 4
    //   26: ifnull +8 -> 34
    //   29: aload 4
    //   31: invokevirtual 63	android/os/ParcelFileDescriptor:close	()V
    //   34: ldc 103
    //   36: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: return
    //   40: astore_3
    //   41: ldc 103
    //   43: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   46: aload_3
    //   47: athrow
    //   48: astore_2
    //   49: aload 4
    //   51: ifnull +12 -> 63
    //   54: aload_3
    //   55: ifnull +71 -> 126
    //   58: aload 4
    //   60: invokevirtual 63	android/os/ParcelFileDescriptor:close	()V
    //   63: ldc 103
    //   65: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   68: aload_2
    //   69: athrow
    //   70: astore_2
    //   71: ldc 68
    //   73: new 70	java/lang/StringBuilder
    //   76: dup
    //   77: ldc 109
    //   79: invokespecial 75	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   82: aload_1
    //   83: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   86: ldc 81
    //   88: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   91: aload_2
    //   92: invokevirtual 87	java/io/IOException:getMessage	()Ljava/lang/String;
    //   95: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   101: invokestatic 96	com/tencent/stubs/logger/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   104: aload_0
    //   105: aload_1
    //   106: invokespecial 111	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   109: ldc 103
    //   111: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   114: return
    //   115: astore 4
    //   117: aload_3
    //   118: aload 4
    //   120: invokevirtual 102	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   123: goto -60 -> 63
    //   126: aload 4
    //   128: invokevirtual 63	android/os/ParcelFileDescriptor:close	()V
    //   131: goto -68 -> 63
    //   134: astore_2
    //   135: goto -86 -> 49
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	138	0	this	d
    //   0	138	1	paramString	java.lang.String
    //   48	21	2	localObject1	java.lang.Object
    //   70	22	2	localIOException	java.io.IOException
    //   134	1	2	localObject2	java.lang.Object
    //   14	1	3	localObject3	java.lang.Object
    //   40	78	3	localThrowable1	java.lang.Throwable
    //   11	48	4	localParcelFileDescriptor	android.os.ParcelFileDescriptor
    //   115	12	4	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   15	24	40	java/lang/Throwable
    //   41	48	48	finally
    //   5	13	70	java/io/IOException
    //   29	34	70	java/io/IOException
    //   58	63	70	java/io/IOException
    //   63	70	70	java/io/IOException
    //   117	123	70	java/io/IOException
    //   126	131	70	java/io/IOException
    //   58	63	115	java/lang/Throwable
    //   15	24	134	finally
  }
  
  /* Error */
  public final void setDataSource(java.lang.String paramString, java.util.Map<java.lang.String, java.lang.String> paramMap)
  {
    // Byte code:
    //   0: ldc 113
    //   2: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokestatic 117	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   9: invokevirtual 31	android/net/Uri:getScheme	()Ljava/lang/String;
    //   12: astore_3
    //   13: aload_3
    //   14: ifnull +30 -> 44
    //   17: aload_3
    //   18: ldc 33
    //   20: invokevirtual 39	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   23: ifne +21 -> 44
    //   26: aload_3
    //   27: ldc 41
    //   29: invokevirtual 39	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   32: ifne +12 -> 44
    //   35: aload_3
    //   36: ldc 43
    //   38: invokevirtual 39	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   41: ifeq +106 -> 147
    //   44: aload_1
    //   45: ldc 45
    //   47: invokestatic 107	com/tencent/mm/vfs/i:my	(Ljava/lang/String;Ljava/lang/String;)Landroid/os/ParcelFileDescriptor;
    //   50: astore 5
    //   52: aconst_null
    //   53: astore 4
    //   55: aload_0
    //   56: aload 5
    //   58: invokevirtual 57	android/os/ParcelFileDescriptor:getFileDescriptor	()Ljava/io/FileDescriptor;
    //   61: invokevirtual 60	com/tencent/mm/compatible/h/d:setDataSource	(Ljava/io/FileDescriptor;)V
    //   64: aload 5
    //   66: ifnull +8 -> 74
    //   69: aload 5
    //   71: invokevirtual 63	android/os/ParcelFileDescriptor:close	()V
    //   74: ldc 113
    //   76: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   79: return
    //   80: astore 4
    //   82: ldc 113
    //   84: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   87: aload 4
    //   89: athrow
    //   90: astore_3
    //   91: aload 5
    //   93: ifnull +13 -> 106
    //   96: aload 4
    //   98: ifnull +73 -> 171
    //   101: aload 5
    //   103: invokevirtual 63	android/os/ParcelFileDescriptor:close	()V
    //   106: ldc 113
    //   108: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   111: aload_3
    //   112: athrow
    //   113: astore_3
    //   114: ldc 68
    //   116: new 70	java/lang/StringBuilder
    //   119: dup
    //   120: ldc 72
    //   122: invokespecial 75	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   125: aload_1
    //   126: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: ldc 81
    //   131: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: aload_3
    //   135: invokevirtual 87	java/io/IOException:getMessage	()Ljava/lang/String;
    //   138: invokevirtual 84	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   141: invokevirtual 90	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   144: invokestatic 96	com/tencent/stubs/logger/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   147: aload_0
    //   148: aload_1
    //   149: aload_2
    //   150: invokespecial 119	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;Ljava/util/Map;)V
    //   153: ldc 113
    //   155: invokestatic 66	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   158: return
    //   159: astore 5
    //   161: aload 4
    //   163: aload 5
    //   165: invokevirtual 102	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   168: goto -62 -> 106
    //   171: aload 5
    //   173: invokevirtual 63	android/os/ParcelFileDescriptor:close	()V
    //   176: goto -70 -> 106
    //   179: astore_3
    //   180: goto -89 -> 91
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	183	0	this	d
    //   0	183	1	paramString	java.lang.String
    //   0	183	2	paramMap	java.util.Map<java.lang.String, java.lang.String>
    //   12	24	3	str	java.lang.String
    //   90	22	3	localObject1	java.lang.Object
    //   113	22	3	localIOException	java.io.IOException
    //   179	1	3	localObject2	java.lang.Object
    //   53	1	4	localObject3	java.lang.Object
    //   80	82	4	localThrowable1	java.lang.Throwable
    //   50	52	5	localParcelFileDescriptor	android.os.ParcelFileDescriptor
    //   159	13	5	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   55	64	80	java/lang/Throwable
    //   82	90	90	finally
    //   44	52	113	java/io/IOException
    //   69	74	113	java/io/IOException
    //   101	106	113	java/io/IOException
    //   106	113	113	java/io/IOException
    //   161	168	113	java/io/IOException
    //   171	176	113	java/io/IOException
    //   101	106	159	java/lang/Throwable
    //   55	64	179	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.h.d
 * JD-Core Version:    0.7.0.1
 */
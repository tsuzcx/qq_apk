package com.facebook.internal;

import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidParameterException;
import java.util.PriorityQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLong;

public final class FileLruCache
{
  private static final String HEADER_CACHEKEY_KEY = "key";
  private static final String HEADER_CACHE_CONTENT_TAG_KEY = "tag";
  static final String TAG;
  private static final AtomicLong bufferIndex;
  private final File directory;
  private boolean isTrimInProgress;
  private boolean isTrimPending;
  private AtomicLong lastClearCacheTime;
  private final Limits limits;
  private final Object lock;
  private final String tag;
  
  static
  {
    AppMethodBeat.i(72368);
    TAG = FileLruCache.class.getSimpleName();
    bufferIndex = new AtomicLong();
    AppMethodBeat.o(72368);
  }
  
  public FileLruCache(String paramString, Limits paramLimits)
  {
    AppMethodBeat.i(72353);
    this.lastClearCacheTime = new AtomicLong(0L);
    this.tag = paramString;
    this.limits = paramLimits;
    this.directory = new File(FacebookSdk.getCacheDir(), paramString);
    this.lock = new Object();
    if ((this.directory.mkdirs()) || (this.directory.isDirectory())) {
      BufferFile.deleteAll(this.directory);
    }
    AppMethodBeat.o(72353);
  }
  
  private void postTrim()
  {
    AppMethodBeat.i(72364);
    synchronized (this.lock)
    {
      if (!this.isTrimPending)
      {
        this.isTrimPending = true;
        FacebookSdk.getExecutor().execute(new FileLruCache.3(this));
      }
      AppMethodBeat.o(72364);
      return;
    }
  }
  
  private void renameToTargetAndTrim(String paramString, File paramFile)
  {
    AppMethodBeat.i(72361);
    if (!paramFile.renameTo(new File(this.directory, Utility.md5hash(paramString)))) {
      paramFile.delete();
    }
    postTrim();
    AppMethodBeat.o(72361);
  }
  
  private void trim()
  {
    AppMethodBeat.i(72365);
    synchronized (this.lock)
    {
      this.isTrimPending = false;
      this.isTrimInProgress = true;
    }
    for (;;)
    {
      try
      {
        Logger.log(LoggingBehavior.CACHE, TAG, "trim started");
        ??? = new PriorityQueue();
        long l3 = 0L;
        l2 = 0L;
        File[] arrayOfFile = this.directory.listFiles(BufferFile.excludeBufferFiles());
        l4 = l2;
        l1 = l3;
        if (arrayOfFile == null) {
          continue;
        }
        int j = arrayOfFile.length;
        int i = 0;
        l4 = l2;
        l1 = l3;
        if (i >= j) {
          continue;
        }
        File localFile2 = arrayOfFile[i];
        FileLruCache.ModifiedFile localModifiedFile = new FileLruCache.ModifiedFile(localFile2);
        ((PriorityQueue)???).add(localModifiedFile);
        Logger.log(LoggingBehavior.CACHE, TAG, "  trim considering time=" + Long.valueOf(localModifiedFile.getModified()) + " name=" + localModifiedFile.getFile().getName());
        l1 = localFile2.length();
        l3 += l1;
        l2 += 1L;
        i += 1;
        continue;
        localObject2 = finally;
        AppMethodBeat.o(72365);
        throw localObject2;
      }
      finally
      {
        long l4;
        synchronized (this.lock)
        {
          long l1;
          File localFile1;
          this.isTrimInProgress = false;
          this.lock.notifyAll();
          AppMethodBeat.o(72365);
          throw localObject4;
        }
        long l2 = l4;
        continue;
      }
      if ((l1 <= this.limits.getByteCount()) && (l2 <= this.limits.getFileCount())) {
        continue;
      }
      localFile1 = ((FileLruCache.ModifiedFile)((PriorityQueue)???).remove()).getFile();
      Logger.log(LoggingBehavior.CACHE, TAG, "  trim removing " + localFile1.getName());
      l1 -= localFile1.length();
      localFile1.delete();
      l2 -= 1L;
    }
    synchronized (this.lock)
    {
      this.isTrimInProgress = false;
      this.lock.notifyAll();
      AppMethodBeat.o(72365);
      return;
    }
  }
  
  public final void clearCache()
  {
    AppMethodBeat.i(72359);
    File[] arrayOfFile = this.directory.listFiles(BufferFile.excludeBufferFiles());
    this.lastClearCacheTime.set(System.currentTimeMillis());
    if (arrayOfFile != null) {
      FacebookSdk.getExecutor().execute(new FileLruCache.2(this, arrayOfFile));
    }
    AppMethodBeat.o(72359);
  }
  
  public final InputStream get(String paramString)
  {
    AppMethodBeat.i(72355);
    paramString = get(paramString, null);
    AppMethodBeat.o(72355);
    return paramString;
  }
  
  /* Error */
  public final InputStream get(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc_w 271
    //   3: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 84	java/io/File
    //   9: dup
    //   10: aload_0
    //   11: getfield 95	com/facebook/internal/FileLruCache:directory	Ljava/io/File;
    //   14: aload_1
    //   15: invokestatic 150	com/facebook/internal/Utility:md5hash	(Ljava/lang/String;)Ljava/lang/String;
    //   18: invokespecial 93	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   21: astore 6
    //   23: new 273	java/io/FileInputStream
    //   26: dup
    //   27: aload 6
    //   29: invokespecial 274	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   32: astore 7
    //   34: new 276	java/io/BufferedInputStream
    //   37: dup
    //   38: aload 7
    //   40: sipush 8192
    //   43: invokespecial 279	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   46: astore 7
    //   48: aload 7
    //   50: invokestatic 283	com/facebook/internal/FileLruCache$StreamHeader:readHeader	(Ljava/io/InputStream;)Lorg/json/JSONObject;
    //   53: astore 8
    //   55: aload 8
    //   57: ifnonnull +25 -> 82
    //   60: aload 7
    //   62: invokevirtual 286	java/io/BufferedInputStream:close	()V
    //   65: ldc_w 271
    //   68: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: aconst_null
    //   72: areturn
    //   73: astore_1
    //   74: ldc_w 271
    //   77: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: aconst_null
    //   81: areturn
    //   82: aload 8
    //   84: ldc 26
    //   86: invokevirtual 291	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   89: astore 9
    //   91: aload 9
    //   93: ifnull +14 -> 107
    //   96: aload 9
    //   98: aload_1
    //   99: invokevirtual 296	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   102: istore_3
    //   103: iload_3
    //   104: ifne +16 -> 120
    //   107: aload 7
    //   109: invokevirtual 286	java/io/BufferedInputStream:close	()V
    //   112: ldc_w 271
    //   115: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   118: aconst_null
    //   119: areturn
    //   120: aload 8
    //   122: ldc 29
    //   124: aconst_null
    //   125: invokevirtual 299	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   128: astore_1
    //   129: aload_2
    //   130: ifnonnull +7 -> 137
    //   133: aload_1
    //   134: ifnonnull +17 -> 151
    //   137: aload_2
    //   138: ifnull +26 -> 164
    //   141: aload_2
    //   142: aload_1
    //   143: invokevirtual 296	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   146: istore_3
    //   147: iload_3
    //   148: ifne +16 -> 164
    //   151: aload 7
    //   153: invokevirtual 286	java/io/BufferedInputStream:close	()V
    //   156: ldc_w 271
    //   159: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   162: aconst_null
    //   163: areturn
    //   164: new 301	java/util/Date
    //   167: dup
    //   168: invokespecial 302	java/util/Date:<init>	()V
    //   171: invokevirtual 305	java/util/Date:getTime	()J
    //   174: lstore 4
    //   176: getstatic 168	com/facebook/LoggingBehavior:CACHE	Lcom/facebook/LoggingBehavior;
    //   179: getstatic 59	com/facebook/internal/FileLruCache:TAG	Ljava/lang/String;
    //   182: new 195	java/lang/StringBuilder
    //   185: dup
    //   186: ldc_w 307
    //   189: invokespecial 200	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   192: lload 4
    //   194: invokestatic 210	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   197: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   200: ldc_w 309
    //   203: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: aload 6
    //   208: invokevirtual 225	java/io/File:getName	()Ljava/lang/String;
    //   211: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 176	com/facebook/internal/Logger:log	(Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;)V
    //   220: aload 6
    //   222: lload 4
    //   224: invokevirtual 313	java/io/File:setLastModified	(J)Z
    //   227: pop
    //   228: ldc_w 271
    //   231: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   234: aload 7
    //   236: areturn
    //   237: astore_1
    //   238: aload 7
    //   240: invokevirtual 286	java/io/BufferedInputStream:close	()V
    //   243: ldc_w 271
    //   246: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   249: aload_1
    //   250: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	251	0	this	FileLruCache
    //   0	251	1	paramString1	String
    //   0	251	2	paramString2	String
    //   102	46	3	bool	boolean
    //   174	49	4	l	long
    //   21	200	6	localFile	File
    //   32	207	7	localObject	Object
    //   53	68	8	localJSONObject	org.json.JSONObject
    //   89	8	9	str	String
    // Exception table:
    //   from	to	target	type
    //   23	34	73	java/io/IOException
    //   48	55	237	finally
    //   82	91	237	finally
    //   96	103	237	finally
    //   120	129	237	finally
    //   141	147	237	finally
    //   164	228	237	finally
  }
  
  public final String getLocation()
  {
    AppMethodBeat.i(72360);
    String str = this.directory.getPath();
    AppMethodBeat.o(72360);
    return str;
  }
  
  public final InputStream interceptAndPut(String paramString, InputStream paramInputStream)
  {
    AppMethodBeat.i(72362);
    paramString = new FileLruCache.CopyingInputStream(paramInputStream, openPutStream(paramString));
    AppMethodBeat.o(72362);
    return paramString;
  }
  
  public final OutputStream openPutStream(String paramString)
  {
    AppMethodBeat.i(72357);
    paramString = openPutStream(paramString, null);
    AppMethodBeat.o(72357);
    return paramString;
  }
  
  /* Error */
  public final OutputStream openPutStream(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc_w 337
    //   3: invokestatic 51	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 95	com/facebook/internal/FileLruCache:directory	Ljava/io/File;
    //   10: invokestatic 341	com/facebook/internal/FileLruCache$BufferFile:newFile	(Ljava/io/File;)Ljava/io/File;
    //   13: astore_3
    //   14: aload_3
    //   15: invokevirtual 157	java/io/File:delete	()Z
    //   18: pop
    //   19: aload_3
    //   20: invokevirtual 344	java/io/File:createNewFile	()Z
    //   23: ifne +39 -> 62
    //   26: new 270	java/io/IOException
    //   29: dup
    //   30: new 195	java/lang/StringBuilder
    //   33: dup
    //   34: ldc_w 346
    //   37: invokespecial 200	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   40: aload_3
    //   41: invokevirtual 349	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   44: invokevirtual 219	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 228	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokespecial 350	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   53: astore_1
    //   54: ldc_w 337
    //   57: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: aload_1
    //   61: athrow
    //   62: new 352	java/io/FileOutputStream
    //   65: dup
    //   66: aload_3
    //   67: invokespecial 353	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   70: astore 4
    //   72: new 355	java/io/BufferedOutputStream
    //   75: dup
    //   76: new 11	com/facebook/internal/FileLruCache$CloseCallbackOutputStream
    //   79: dup
    //   80: aload 4
    //   82: new 357	com/facebook/internal/FileLruCache$1
    //   85: dup
    //   86: aload_0
    //   87: invokestatic 254	java/lang/System:currentTimeMillis	()J
    //   90: aload_3
    //   91: aload_1
    //   92: invokespecial 360	com/facebook/internal/FileLruCache$1:<init>	(Lcom/facebook/internal/FileLruCache;JLjava/io/File;Ljava/lang/String;)V
    //   95: invokespecial 363	com/facebook/internal/FileLruCache$CloseCallbackOutputStream:<init>	(Ljava/io/OutputStream;Lcom/facebook/internal/FileLruCache$StreamCloseCallback;)V
    //   98: sipush 8192
    //   101: invokespecial 366	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   104: astore_3
    //   105: new 288	org/json/JSONObject
    //   108: dup
    //   109: invokespecial 367	org/json/JSONObject:<init>	()V
    //   112: astore 4
    //   114: aload 4
    //   116: ldc 26
    //   118: aload_1
    //   119: invokevirtual 371	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   122: pop
    //   123: aload_2
    //   124: invokestatic 375	com/facebook/internal/Utility:isNullOrEmpty	(Ljava/lang/String;)Z
    //   127: ifne +12 -> 139
    //   130: aload 4
    //   132: ldc 29
    //   134: aload_2
    //   135: invokevirtual 371	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   138: pop
    //   139: aload_3
    //   140: aload 4
    //   142: invokestatic 379	com/facebook/internal/FileLruCache$StreamHeader:writeHeader	(Ljava/io/OutputStream;Lorg/json/JSONObject;)V
    //   145: ldc_w 337
    //   148: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   151: aload_3
    //   152: areturn
    //   153: astore_1
    //   154: getstatic 168	com/facebook/LoggingBehavior:CACHE	Lcom/facebook/LoggingBehavior;
    //   157: iconst_5
    //   158: getstatic 59	com/facebook/internal/FileLruCache:TAG	Ljava/lang/String;
    //   161: ldc_w 381
    //   164: aload_1
    //   165: invokestatic 384	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   168: invokevirtual 387	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   171: invokestatic 390	com/facebook/internal/Logger:log	(Lcom/facebook/LoggingBehavior;ILjava/lang/String;Ljava/lang/String;)V
    //   174: new 270	java/io/IOException
    //   177: dup
    //   178: aload_1
    //   179: invokevirtual 393	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   182: invokespecial 350	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   185: astore_1
    //   186: ldc_w 337
    //   189: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   192: aload_1
    //   193: athrow
    //   194: astore_1
    //   195: getstatic 168	com/facebook/LoggingBehavior:CACHE	Lcom/facebook/LoggingBehavior;
    //   198: iconst_5
    //   199: getstatic 59	com/facebook/internal/FileLruCache:TAG	Ljava/lang/String;
    //   202: ldc_w 395
    //   205: aload_1
    //   206: invokestatic 384	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   209: invokevirtual 387	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   212: invokestatic 390	com/facebook/internal/Logger:log	(Lcom/facebook/LoggingBehavior;ILjava/lang/String;Ljava/lang/String;)V
    //   215: new 270	java/io/IOException
    //   218: dup
    //   219: aload_1
    //   220: invokevirtual 396	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   223: invokespecial 350	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   226: astore_1
    //   227: ldc_w 337
    //   230: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   233: aload_1
    //   234: athrow
    //   235: astore_1
    //   236: aload_3
    //   237: invokevirtual 397	java/io/BufferedOutputStream:close	()V
    //   240: ldc_w 337
    //   243: invokestatic 69	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   246: aload_1
    //   247: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	248	0	this	FileLruCache
    //   0	248	1	paramString1	String
    //   0	248	2	paramString2	String
    //   13	224	3	localObject1	Object
    //   70	71	4	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   62	72	153	java/io/FileNotFoundException
    //   105	139	194	org/json/JSONException
    //   139	145	194	org/json/JSONException
    //   105	139	235	finally
    //   139	145	235	finally
    //   195	235	235	finally
  }
  
  final long sizeInBytesForTest()
  {
    AppMethodBeat.i(72354);
    long l2;
    synchronized (this.lock)
    {
      for (;;)
      {
        if (!this.isTrimPending)
        {
          boolean bool = this.isTrimInProgress;
          if (!bool) {
            break;
          }
        }
        try
        {
          this.lock.wait();
        }
        catch (InterruptedException localInterruptedException) {}
      }
      ??? = this.directory.listFiles();
      long l1 = 0L;
      l2 = l1;
      if (??? != null)
      {
        int j = ???.length;
        int i = 0;
        l2 = l1;
        if (i < j)
        {
          l1 += ???[i].length();
          i += 1;
        }
      }
    }
    AppMethodBeat.o(72354);
    return l2;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(72363);
    String str = "{FileLruCache: tag:" + this.tag + " file:" + this.directory.getName() + "}";
    AppMethodBeat.o(72363);
    return str;
  }
  
  static class BufferFile
  {
    private static final String FILE_NAME_PREFIX = "buffer";
    private static final FilenameFilter filterExcludeBufferFiles;
    private static final FilenameFilter filterExcludeNonBufferFiles;
    
    static
    {
      AppMethodBeat.i(72330);
      filterExcludeBufferFiles = new FilenameFilter()
      {
        public final boolean accept(File paramAnonymousFile, String paramAnonymousString)
        {
          AppMethodBeat.i(72326);
          if (!paramAnonymousString.startsWith("buffer"))
          {
            AppMethodBeat.o(72326);
            return true;
          }
          AppMethodBeat.o(72326);
          return false;
        }
      };
      filterExcludeNonBufferFiles = new FileLruCache.BufferFile.2();
      AppMethodBeat.o(72330);
    }
    
    static void deleteAll(File paramFile)
    {
      AppMethodBeat.i(72328);
      paramFile = paramFile.listFiles(excludeNonBufferFiles());
      if (paramFile != null)
      {
        int j = paramFile.length;
        int i = 0;
        while (i < j)
        {
          paramFile[i].delete();
          i += 1;
        }
      }
      AppMethodBeat.o(72328);
    }
    
    static FilenameFilter excludeBufferFiles()
    {
      return filterExcludeBufferFiles;
    }
    
    static FilenameFilter excludeNonBufferFiles()
    {
      return filterExcludeNonBufferFiles;
    }
    
    static File newFile(File paramFile)
    {
      AppMethodBeat.i(72329);
      paramFile = new File(paramFile, "buffer" + Long.valueOf(FileLruCache.bufferIndex.incrementAndGet()).toString());
      AppMethodBeat.o(72329);
      return paramFile;
    }
  }
  
  public static final class Limits
  {
    private int byteCount = 1048576;
    private int fileCount = 1024;
    
    final int getByteCount()
    {
      return this.byteCount;
    }
    
    final int getFileCount()
    {
      return this.fileCount;
    }
    
    final void setByteCount(int paramInt)
    {
      AppMethodBeat.i(72344);
      if (paramInt < 0)
      {
        InvalidParameterException localInvalidParameterException = new InvalidParameterException("Cache byte-count limit must be >= 0");
        AppMethodBeat.o(72344);
        throw localInvalidParameterException;
      }
      this.byteCount = paramInt;
      AppMethodBeat.o(72344);
    }
    
    final void setFileCount(int paramInt)
    {
      AppMethodBeat.i(72345);
      if (paramInt < 0)
      {
        InvalidParameterException localInvalidParameterException = new InvalidParameterException("Cache file count limit must be >= 0");
        AppMethodBeat.o(72345);
        throw localInvalidParameterException;
      }
      this.fileCount = paramInt;
      AppMethodBeat.o(72345);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.facebook.internal.FileLruCache
 * JD-Core Version:    0.7.0.1
 */
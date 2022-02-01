package com.facebook.internal;

import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidParameterException;
import java.util.PriorityQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

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
    AppMethodBeat.i(17804);
    TAG = FileLruCache.class.getSimpleName();
    bufferIndex = new AtomicLong();
    AppMethodBeat.o(17804);
  }
  
  public FileLruCache(String paramString, Limits paramLimits)
  {
    AppMethodBeat.i(17789);
    this.lastClearCacheTime = new AtomicLong(0L);
    this.tag = paramString;
    this.limits = paramLimits;
    this.directory = new File(FacebookSdk.getCacheDir(), paramString);
    this.lock = new Object();
    if ((this.directory.mkdirs()) || (this.directory.isDirectory())) {
      BufferFile.deleteAll(this.directory);
    }
    AppMethodBeat.o(17789);
  }
  
  private void postTrim()
  {
    AppMethodBeat.i(17800);
    synchronized (this.lock)
    {
      if (!this.isTrimPending)
      {
        this.isTrimPending = true;
        FacebookSdk.getExecutor().execute(new Runnable()
        {
          public void run()
          {
            AppMethodBeat.i(17761);
            FileLruCache.access$200(FileLruCache.this);
            AppMethodBeat.o(17761);
          }
        });
      }
      AppMethodBeat.o(17800);
      return;
    }
  }
  
  private void renameToTargetAndTrim(String paramString, File paramFile)
  {
    AppMethodBeat.i(17797);
    if (!paramFile.renameTo(new File(this.directory, Utility.md5hash(paramString)))) {
      paramFile.delete();
    }
    postTrim();
    AppMethodBeat.o(17797);
  }
  
  private void trim()
  {
    AppMethodBeat.i(17801);
    for (;;)
    {
      long l3;
      File[] arrayOfFile;
      long l1;
      int j;
      int i;
      File localFile2;
      ModifiedFile localModifiedFile;
      synchronized (this.lock)
      {
        this.isTrimPending = false;
        this.isTrimInProgress = true;
      }
      File localFile1 = ((ModifiedFile)((PriorityQueue)???).remove()).getFile();
      Logger.log(LoggingBehavior.CACHE, TAG, "  trim removing " + localFile1.getName());
      l1 -= localFile1.length();
      localFile1.delete();
      l2 -= 1L;
    }
    synchronized (this.lock)
    {
      this.isTrimInProgress = false;
      this.lock.notifyAll();
      AppMethodBeat.o(17801);
      return;
    }
  }
  
  public final void clearCache()
  {
    AppMethodBeat.i(17795);
    final File[] arrayOfFile = this.directory.listFiles(BufferFile.excludeBufferFiles());
    this.lastClearCacheTime.set(System.currentTimeMillis());
    if (arrayOfFile != null) {
      FacebookSdk.getExecutor().execute(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(17760);
          File[] arrayOfFile = arrayOfFile;
          int j = arrayOfFile.length;
          int i = 0;
          while (i < j)
          {
            arrayOfFile[i].delete();
            i += 1;
          }
          AppMethodBeat.o(17760);
        }
      });
    }
    AppMethodBeat.o(17795);
  }
  
  public final InputStream get(String paramString)
  {
    AppMethodBeat.i(17791);
    paramString = get(paramString, null);
    AppMethodBeat.o(17791);
    return paramString;
  }
  
  /* Error */
  public final InputStream get(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: sipush 17792
    //   3: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: new 95	java/io/File
    //   9: dup
    //   10: aload_0
    //   11: getfield 106	com/facebook/internal/FileLruCache:directory	Ljava/io/File;
    //   14: aload_1
    //   15: invokestatic 155	com/facebook/internal/Utility:md5hash	(Ljava/lang/String;)Ljava/lang/String;
    //   18: invokespecial 104	java/io/File:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   21: astore 6
    //   23: new 272	java/io/FileInputStream
    //   26: dup
    //   27: aload 6
    //   29: invokespecial 273	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   32: astore 7
    //   34: new 275	java/io/BufferedInputStream
    //   37: dup
    //   38: aload 7
    //   40: sipush 8192
    //   43: invokespecial 278	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   46: astore 7
    //   48: aload 7
    //   50: invokestatic 282	com/facebook/internal/FileLruCache$StreamHeader:readHeader	(Ljava/io/InputStream;)Lorg/json/JSONObject;
    //   53: astore 8
    //   55: aload 8
    //   57: ifnonnull +25 -> 82
    //   60: aload 7
    //   62: invokevirtual 285	java/io/BufferedInputStream:close	()V
    //   65: sipush 17792
    //   68: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   71: aconst_null
    //   72: areturn
    //   73: astore_1
    //   74: sipush 17792
    //   77: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   80: aconst_null
    //   81: areturn
    //   82: aload 8
    //   84: ldc 39
    //   86: invokevirtual 290	org/json/JSONObject:optString	(Ljava/lang/String;)Ljava/lang/String;
    //   89: astore 9
    //   91: aload 9
    //   93: ifnull +14 -> 107
    //   96: aload 9
    //   98: aload_1
    //   99: invokevirtual 295	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   102: istore_3
    //   103: iload_3
    //   104: ifne +16 -> 120
    //   107: aload 7
    //   109: invokevirtual 285	java/io/BufferedInputStream:close	()V
    //   112: sipush 17792
    //   115: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   118: aconst_null
    //   119: areturn
    //   120: aload 8
    //   122: ldc 42
    //   124: aconst_null
    //   125: invokevirtual 298	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   128: astore_1
    //   129: aload_2
    //   130: ifnonnull +7 -> 137
    //   133: aload_1
    //   134: ifnonnull +17 -> 151
    //   137: aload_2
    //   138: ifnull +26 -> 164
    //   141: aload_2
    //   142: aload_1
    //   143: invokevirtual 295	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   146: istore_3
    //   147: iload_3
    //   148: ifne +16 -> 164
    //   151: aload 7
    //   153: invokevirtual 285	java/io/BufferedInputStream:close	()V
    //   156: sipush 17792
    //   159: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   162: aconst_null
    //   163: areturn
    //   164: new 300	java/util/Date
    //   167: dup
    //   168: invokespecial 301	java/util/Date:<init>	()V
    //   171: invokevirtual 304	java/util/Date:getTime	()J
    //   174: lstore 4
    //   176: getstatic 172	com/facebook/LoggingBehavior:CACHE	Lcom/facebook/LoggingBehavior;
    //   179: getstatic 71	com/facebook/internal/FileLruCache:TAG	Ljava/lang/String;
    //   182: new 199	java/lang/StringBuilder
    //   185: dup
    //   186: ldc_w 306
    //   189: invokespecial 204	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   192: lload 4
    //   194: invokestatic 214	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   197: invokevirtual 218	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   200: ldc_w 308
    //   203: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   206: aload 6
    //   208: invokevirtual 229	java/io/File:getName	()Ljava/lang/String;
    //   211: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   214: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   217: invokestatic 180	com/facebook/internal/Logger:log	(Lcom/facebook/LoggingBehavior;Ljava/lang/String;Ljava/lang/String;)V
    //   220: aload 6
    //   222: lload 4
    //   224: invokevirtual 312	java/io/File:setLastModified	(J)Z
    //   227: pop
    //   228: sipush 17792
    //   231: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   234: aload 7
    //   236: areturn
    //   237: astore_1
    //   238: aload 7
    //   240: invokevirtual 285	java/io/BufferedInputStream:close	()V
    //   243: sipush 17792
    //   246: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    //   53	68	8	localJSONObject	JSONObject
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
    AppMethodBeat.i(17796);
    String str = this.directory.getPath();
    AppMethodBeat.o(17796);
    return str;
  }
  
  public final InputStream interceptAndPut(String paramString, InputStream paramInputStream)
  {
    AppMethodBeat.i(17798);
    paramString = new CopyingInputStream(paramInputStream, openPutStream(paramString));
    AppMethodBeat.o(17798);
    return paramString;
  }
  
  public final OutputStream openPutStream(String paramString)
  {
    AppMethodBeat.i(17793);
    paramString = openPutStream(paramString, null);
    AppMethodBeat.o(17793);
    return paramString;
  }
  
  /* Error */
  public final OutputStream openPutStream(final String paramString1, String paramString2)
  {
    // Byte code:
    //   0: sipush 17794
    //   3: invokestatic 63	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_0
    //   7: getfield 106	com/facebook/internal/FileLruCache:directory	Ljava/io/File;
    //   10: invokestatic 336	com/facebook/internal/FileLruCache$BufferFile:newFile	(Ljava/io/File;)Ljava/io/File;
    //   13: astore_3
    //   14: aload_3
    //   15: invokevirtual 162	java/io/File:delete	()Z
    //   18: pop
    //   19: aload_3
    //   20: invokevirtual 339	java/io/File:createNewFile	()Z
    //   23: ifne +39 -> 62
    //   26: new 270	java/io/IOException
    //   29: dup
    //   30: new 199	java/lang/StringBuilder
    //   33: dup
    //   34: ldc_w 341
    //   37: invokespecial 204	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   40: aload_3
    //   41: invokevirtual 344	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   44: invokevirtual 223	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: invokevirtual 232	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   50: invokespecial 345	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   53: astore_1
    //   54: sipush 17794
    //   57: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   60: aload_1
    //   61: athrow
    //   62: new 347	java/io/FileOutputStream
    //   65: dup
    //   66: aload_3
    //   67: invokespecial 348	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   70: astore 4
    //   72: new 350	java/io/BufferedOutputStream
    //   75: dup
    //   76: new 19	com/facebook/internal/FileLruCache$CloseCallbackOutputStream
    //   79: dup
    //   80: aload 4
    //   82: new 6	com/facebook/internal/FileLruCache$1
    //   85: dup
    //   86: aload_0
    //   87: invokestatic 257	java/lang/System:currentTimeMillis	()J
    //   90: aload_3
    //   91: aload_1
    //   92: invokespecial 353	com/facebook/internal/FileLruCache$1:<init>	(Lcom/facebook/internal/FileLruCache;JLjava/io/File;Ljava/lang/String;)V
    //   95: invokespecial 356	com/facebook/internal/FileLruCache$CloseCallbackOutputStream:<init>	(Ljava/io/OutputStream;Lcom/facebook/internal/FileLruCache$StreamCloseCallback;)V
    //   98: sipush 8192
    //   101: invokespecial 359	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   104: astore_3
    //   105: new 287	org/json/JSONObject
    //   108: dup
    //   109: invokespecial 360	org/json/JSONObject:<init>	()V
    //   112: astore 4
    //   114: aload 4
    //   116: ldc 39
    //   118: aload_1
    //   119: invokevirtual 364	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   122: pop
    //   123: aload_2
    //   124: invokestatic 368	com/facebook/internal/Utility:isNullOrEmpty	(Ljava/lang/String;)Z
    //   127: ifne +12 -> 139
    //   130: aload 4
    //   132: ldc 42
    //   134: aload_2
    //   135: invokevirtual 364	org/json/JSONObject:put	(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    //   138: pop
    //   139: aload_3
    //   140: aload 4
    //   142: invokestatic 372	com/facebook/internal/FileLruCache$StreamHeader:writeHeader	(Ljava/io/OutputStream;Lorg/json/JSONObject;)V
    //   145: sipush 17794
    //   148: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   151: aload_3
    //   152: areturn
    //   153: astore_1
    //   154: getstatic 172	com/facebook/LoggingBehavior:CACHE	Lcom/facebook/LoggingBehavior;
    //   157: iconst_5
    //   158: getstatic 71	com/facebook/internal/FileLruCache:TAG	Ljava/lang/String;
    //   161: ldc_w 374
    //   164: aload_1
    //   165: invokestatic 377	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   168: invokevirtual 380	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   171: invokestatic 383	com/facebook/internal/Logger:log	(Lcom/facebook/LoggingBehavior;ILjava/lang/String;Ljava/lang/String;)V
    //   174: new 270	java/io/IOException
    //   177: dup
    //   178: aload_1
    //   179: invokevirtual 386	java/io/FileNotFoundException:getMessage	()Ljava/lang/String;
    //   182: invokespecial 345	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   185: astore_1
    //   186: sipush 17794
    //   189: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   192: aload_1
    //   193: athrow
    //   194: astore_1
    //   195: getstatic 172	com/facebook/LoggingBehavior:CACHE	Lcom/facebook/LoggingBehavior;
    //   198: iconst_5
    //   199: getstatic 71	com/facebook/internal/FileLruCache:TAG	Ljava/lang/String;
    //   202: ldc_w 388
    //   205: aload_1
    //   206: invokestatic 377	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   209: invokevirtual 380	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   212: invokestatic 383	com/facebook/internal/Logger:log	(Lcom/facebook/LoggingBehavior;ILjava/lang/String;Ljava/lang/String;)V
    //   215: new 270	java/io/IOException
    //   218: dup
    //   219: aload_1
    //   220: invokevirtual 389	org/json/JSONException:getMessage	()Ljava/lang/String;
    //   223: invokespecial 345	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   226: astore_1
    //   227: sipush 17794
    //   230: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   233: aload_1
    //   234: athrow
    //   235: astore_1
    //   236: aload_3
    //   237: invokevirtual 390	java/io/BufferedOutputStream:close	()V
    //   240: sipush 17794
    //   243: invokestatic 81	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
    AppMethodBeat.i(17790);
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
    AppMethodBeat.o(17790);
    return l2;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(17799);
    String str = "{FileLruCache: tag:" + this.tag + " file:" + this.directory.getName() + "}";
    AppMethodBeat.o(17799);
    return str;
  }
  
  static class BufferFile
  {
    private static final String FILE_NAME_PREFIX = "buffer";
    private static final FilenameFilter filterExcludeBufferFiles;
    private static final FilenameFilter filterExcludeNonBufferFiles;
    
    static
    {
      AppMethodBeat.i(17766);
      filterExcludeBufferFiles = new FilenameFilter()
      {
        public final boolean accept(File paramAnonymousFile, String paramAnonymousString)
        {
          AppMethodBeat.i(17762);
          if (!paramAnonymousString.startsWith("buffer"))
          {
            AppMethodBeat.o(17762);
            return true;
          }
          AppMethodBeat.o(17762);
          return false;
        }
      };
      filterExcludeNonBufferFiles = new FilenameFilter()
      {
        public final boolean accept(File paramAnonymousFile, String paramAnonymousString)
        {
          AppMethodBeat.i(17763);
          boolean bool = paramAnonymousString.startsWith("buffer");
          AppMethodBeat.o(17763);
          return bool;
        }
      };
      AppMethodBeat.o(17766);
    }
    
    static void deleteAll(File paramFile)
    {
      AppMethodBeat.i(17764);
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
      AppMethodBeat.o(17764);
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
      AppMethodBeat.i(17765);
      paramFile = new File(paramFile, "buffer" + Long.valueOf(FileLruCache.bufferIndex.incrementAndGet()).toString());
      AppMethodBeat.o(17765);
      return paramFile;
    }
  }
  
  static class CloseCallbackOutputStream
    extends OutputStream
  {
    final FileLruCache.StreamCloseCallback callback;
    final OutputStream innerStream;
    
    CloseCallbackOutputStream(OutputStream paramOutputStream, FileLruCache.StreamCloseCallback paramStreamCloseCallback)
    {
      this.innerStream = paramOutputStream;
      this.callback = paramStreamCloseCallback;
    }
    
    public void close()
    {
      AppMethodBeat.i(17767);
      try
      {
        this.innerStream.close();
        return;
      }
      finally
      {
        this.callback.onClose();
        AppMethodBeat.o(17767);
      }
    }
    
    public void flush()
    {
      AppMethodBeat.i(17768);
      this.innerStream.flush();
      AppMethodBeat.o(17768);
    }
    
    public void write(int paramInt)
    {
      AppMethodBeat.i(17771);
      this.innerStream.write(paramInt);
      AppMethodBeat.o(17771);
    }
    
    public void write(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(17770);
      this.innerStream.write(paramArrayOfByte);
      AppMethodBeat.o(17770);
    }
    
    public void write(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(17769);
      this.innerStream.write(paramArrayOfByte, paramInt1, paramInt2);
      AppMethodBeat.o(17769);
    }
  }
  
  static final class CopyingInputStream
    extends InputStream
  {
    final InputStream input;
    final OutputStream output;
    
    CopyingInputStream(InputStream paramInputStream, OutputStream paramOutputStream)
    {
      this.input = paramInputStream;
      this.output = paramOutputStream;
    }
    
    public final int available()
    {
      AppMethodBeat.i(17772);
      int i = this.input.available();
      AppMethodBeat.o(17772);
      return i;
    }
    
    public final void close()
    {
      AppMethodBeat.i(17773);
      try
      {
        this.input.close();
        return;
      }
      finally
      {
        this.output.close();
        AppMethodBeat.o(17773);
      }
    }
    
    public final void mark(int paramInt)
    {
      AppMethodBeat.i(17774);
      UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
      AppMethodBeat.o(17774);
      throw localUnsupportedOperationException;
    }
    
    public final boolean markSupported()
    {
      return false;
    }
    
    public final int read()
    {
      AppMethodBeat.i(17776);
      int i = this.input.read();
      if (i >= 0) {
        this.output.write(i);
      }
      AppMethodBeat.o(17776);
      return i;
    }
    
    public final int read(byte[] paramArrayOfByte)
    {
      AppMethodBeat.i(17775);
      int i = this.input.read(paramArrayOfByte);
      if (i > 0) {
        this.output.write(paramArrayOfByte, 0, i);
      }
      AppMethodBeat.o(17775);
      return i;
    }
    
    public final int read(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(17777);
      paramInt2 = this.input.read(paramArrayOfByte, paramInt1, paramInt2);
      if (paramInt2 > 0) {
        this.output.write(paramArrayOfByte, paramInt1, paramInt2);
      }
      AppMethodBeat.o(17777);
      return paramInt2;
    }
    
    public final void reset()
    {
      try
      {
        AppMethodBeat.i(17778);
        UnsupportedOperationException localUnsupportedOperationException = new UnsupportedOperationException();
        AppMethodBeat.o(17778);
        throw localUnsupportedOperationException;
      }
      finally {}
    }
    
    public final long skip(long paramLong)
    {
      AppMethodBeat.i(17779);
      byte[] arrayOfByte = new byte[1024];
      int i;
      for (long l = 0L; l < paramLong; l += i)
      {
        i = read(arrayOfByte, 0, (int)Math.min(paramLong - l, 1024L));
        if (i < 0)
        {
          AppMethodBeat.o(17779);
          return l;
        }
      }
      AppMethodBeat.o(17779);
      return l;
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
      AppMethodBeat.i(17780);
      if (paramInt < 0)
      {
        InvalidParameterException localInvalidParameterException = new InvalidParameterException("Cache byte-count limit must be >= 0");
        AppMethodBeat.o(17780);
        throw localInvalidParameterException;
      }
      this.byteCount = paramInt;
      AppMethodBeat.o(17780);
    }
    
    final void setFileCount(int paramInt)
    {
      AppMethodBeat.i(17781);
      if (paramInt < 0)
      {
        InvalidParameterException localInvalidParameterException = new InvalidParameterException("Cache file count limit must be >= 0");
        AppMethodBeat.o(17781);
        throw localInvalidParameterException;
      }
      this.fileCount = paramInt;
      AppMethodBeat.o(17781);
    }
  }
  
  static final class ModifiedFile
    implements Comparable<ModifiedFile>
  {
    private static final int HASH_MULTIPLIER = 37;
    private static final int HASH_SEED = 29;
    private final File file;
    private final long modified;
    
    ModifiedFile(File paramFile)
    {
      AppMethodBeat.i(17782);
      this.file = paramFile;
      this.modified = paramFile.lastModified();
      AppMethodBeat.o(17782);
    }
    
    public final int compareTo(ModifiedFile paramModifiedFile)
    {
      AppMethodBeat.i(17783);
      if (getModified() < paramModifiedFile.getModified())
      {
        AppMethodBeat.o(17783);
        return -1;
      }
      if (getModified() > paramModifiedFile.getModified())
      {
        AppMethodBeat.o(17783);
        return 1;
      }
      int i = getFile().compareTo(paramModifiedFile.getFile());
      AppMethodBeat.o(17783);
      return i;
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(17784);
      if (((paramObject instanceof ModifiedFile)) && (compareTo((ModifiedFile)paramObject) == 0))
      {
        AppMethodBeat.o(17784);
        return true;
      }
      AppMethodBeat.o(17784);
      return false;
    }
    
    final File getFile()
    {
      return this.file;
    }
    
    final long getModified()
    {
      return this.modified;
    }
    
    public final int hashCode()
    {
      AppMethodBeat.i(17785);
      int i = this.file.hashCode();
      int j = (int)(this.modified % 2147483647L);
      AppMethodBeat.o(17785);
      return (i + 1073) * 37 + j;
    }
  }
  
  static abstract interface StreamCloseCallback
  {
    public abstract void onClose();
  }
  
  static final class StreamHeader
  {
    private static final int HEADER_VERSION = 0;
    
    static JSONObject readHeader(InputStream paramInputStream)
    {
      int k = 0;
      AppMethodBeat.i(17788);
      if (paramInputStream.read() != 0)
      {
        AppMethodBeat.o(17788);
        return null;
      }
      int j = 0;
      int i = 0;
      while (j < 3)
      {
        int m = paramInputStream.read();
        if (m == -1)
        {
          Logger.log(LoggingBehavior.CACHE, FileLruCache.TAG, "readHeader: stream.read returned -1 while reading header size");
          AppMethodBeat.o(17788);
          return null;
        }
        i = (i << 8) + (m & 0xFF);
        j += 1;
      }
      byte[] arrayOfByte = new byte[i];
      j = k;
      while (j < i)
      {
        k = paramInputStream.read(arrayOfByte, j, i - j);
        if (k <= 0)
        {
          Logger.log(LoggingBehavior.CACHE, FileLruCache.TAG, "readHeader: stream.read stopped at " + Integer.valueOf(j) + " when expected " + i);
          AppMethodBeat.o(17788);
          return null;
        }
        j += k;
      }
      paramInputStream = new JSONTokener(new String(arrayOfByte));
      try
      {
        paramInputStream = paramInputStream.nextValue();
        if (!(paramInputStream instanceof JSONObject))
        {
          Logger.log(LoggingBehavior.CACHE, FileLruCache.TAG, "readHeader: expected JSONObject, got " + paramInputStream.getClass().getCanonicalName());
          AppMethodBeat.o(17788);
          return null;
        }
        paramInputStream = (JSONObject)paramInputStream;
        AppMethodBeat.o(17788);
        return paramInputStream;
      }
      catch (JSONException paramInputStream)
      {
        paramInputStream = new IOException(paramInputStream.getMessage());
        AppMethodBeat.o(17788);
        throw paramInputStream;
      }
    }
    
    static void writeHeader(OutputStream paramOutputStream, JSONObject paramJSONObject)
    {
      AppMethodBeat.i(17787);
      paramJSONObject = paramJSONObject.toString().getBytes();
      paramOutputStream.write(0);
      paramOutputStream.write(paramJSONObject.length >> 16 & 0xFF);
      paramOutputStream.write(paramJSONObject.length >> 8 & 0xFF);
      paramOutputStream.write(paramJSONObject.length >> 0 & 0xFF);
      paramOutputStream.write(paramJSONObject);
      AppMethodBeat.o(17787);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.internal.FileLruCache
 * JD-Core Version:    0.7.0.1
 */
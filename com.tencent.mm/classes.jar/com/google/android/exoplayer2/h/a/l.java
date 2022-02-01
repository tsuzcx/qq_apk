package com.google.android.exoplayer2.h.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.NavigableSet;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/google/android/exoplayer2/upstream/cache/MultiProcessSupportSimpleCache;", "Lcom/google/android/exoplayer2/upstream/cache/Cache;", "realCache", "Lcom/google/android/exoplayer2/upstream/cache/SimpleCache;", "cacheDir", "Ljava/io/File;", "index", "Lcom/google/android/exoplayer2/upstream/cache/CachedContentIndex;", "(Lcom/google/android/exoplayer2/upstream/cache/SimpleCache;Ljava/io/File;Lcom/google/android/exoplayer2/upstream/cache/CachedContentIndex;)V", "fileLocks", "Landroid/util/SparseArray;", "Ljava/nio/channels/FileLock;", "myTag", "", "addListener", "Ljava/util/NavigableSet;", "Lcom/google/android/exoplayer2/upstream/cache/CacheSpan;", "kotlin.jvm.PlatformType", "p0", "p1", "Lcom/google/android/exoplayer2/upstream/cache/Cache$Listener;", "commitFile", "", "getCacheSpace", "", "getCachedBytes", "p2", "getCachedSpans", "getContentLength", "getKeys", "", "", "isCached", "", "releaseHoleSpan", "holeSpan", "removeListener", "removeSpan", "setContentLength", "startFile", "startReadWrite", "startReadWriteNonBlocking", "key", "position", "Companion", "luggage-commons-jsapi-video-ext_release"})
public final class l
  implements a
{
  public static final l.a bqn;
  private final String bqj;
  private final SparseArray<FileLock> bqk;
  private final m bql;
  private final j bqm;
  private final File cacheDir;
  
  static
  {
    AppMethodBeat.i(227036);
    bqn = new l.a((byte)0);
    AppMethodBeat.o(227036);
  }
  
  private l(m paramm, File paramFile, j paramj)
  {
    AppMethodBeat.i(227034);
    this.bql = paramm;
    this.cacheDir = paramFile;
    this.bqm = paramj;
    this.bqj = ("MicroMsg.AppBrand.MultiProcessSupportSimpleCache#" + hashCode());
    this.bqk = new SparseArray();
    AppMethodBeat.o(227034);
  }
  
  public final NavigableSet<g> a(String paramString, a.b paramb)
  {
    AppMethodBeat.i(227037);
    paramString = this.bql.a(paramString, paramb);
    AppMethodBeat.o(227037);
    return paramString;
  }
  
  /* Error */
  public final void a(g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 137
    //   4: invokestatic 75	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ldc 138
    //   10: invokestatic 144	kotlin/g/b/p:k	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: aload_0
    //   14: getfield 116	com/google/android/exoplayer2/h/a/l:bqj	Ljava/lang/String;
    //   17: ldc 146
    //   19: invokestatic 151	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: aload_0
    //   23: getfield 95	com/google/android/exoplayer2/h/a/l:bqm	Lcom/google/android/exoplayer2/h/a/j;
    //   26: aload_1
    //   27: getfield 155	com/google/android/exoplayer2/h/a/g:key	Ljava/lang/String;
    //   30: invokevirtual 161	com/google/android/exoplayer2/h/a/j:bC	(Ljava/lang/String;)Lcom/google/android/exoplayer2/h/a/i;
    //   33: getfield 167	com/google/android/exoplayer2/h/a/i:id	I
    //   36: istore_2
    //   37: aload_0
    //   38: getfield 121	com/google/android/exoplayer2/h/a/l:bqk	Landroid/util/SparseArray;
    //   41: iload_2
    //   42: invokevirtual 171	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   45: checkcast 173	java/nio/channels/FileLock
    //   48: invokevirtual 176	java/nio/channels/FileLock:release	()V
    //   51: aload_0
    //   52: getfield 121	com/google/android/exoplayer2/h/a/l:bqk	Landroid/util/SparseArray;
    //   55: iload_2
    //   56: invokevirtual 179	android/util/SparseArray:remove	(I)V
    //   59: aload_0
    //   60: getfield 91	com/google/android/exoplayer2/h/a/l:bql	Lcom/google/android/exoplayer2/h/a/m;
    //   63: aload_1
    //   64: invokevirtual 181	com/google/android/exoplayer2/h/a/m:a	(Lcom/google/android/exoplayer2/h/a/g;)V
    //   67: ldc 137
    //   69: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: aload_0
    //   73: monitorexit
    //   74: return
    //   75: astore_3
    //   76: aload_0
    //   77: getfield 116	com/google/android/exoplayer2/h/a/l:bqj	Ljava/lang/String;
    //   80: ldc 183
    //   82: aload_3
    //   83: invokestatic 189	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   86: invokevirtual 193	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   89: invokestatic 196	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: goto -33 -> 59
    //   95: astore_1
    //   96: aload_0
    //   97: monitorexit
    //   98: aload_1
    //   99: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	100	0	this	l
    //   0	100	1	paramg	g
    //   36	20	2	i	int
    //   75	8	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   13	59	75	java/lang/Exception
    //   2	13	95	finally
    //   13	59	95	finally
    //   59	72	95	finally
    //   76	92	95	finally
  }
  
  public final void b(g paramg)
  {
    AppMethodBeat.i(227043);
    this.bql.b(paramg);
    AppMethodBeat.o(227043);
  }
  
  public final long bA(String paramString)
  {
    AppMethodBeat.i(227042);
    long l = this.bql.bA(paramString);
    AppMethodBeat.o(227042);
    return l;
  }
  
  public final g e(String paramString, long paramLong)
  {
    AppMethodBeat.i(227048);
    paramString = (g)this.bql.i(paramString, paramLong);
    AppMethodBeat.o(227048);
    return paramString;
  }
  
  public final File e(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(227046);
    paramString = this.bql.e(paramString, paramLong1, paramLong2);
    AppMethodBeat.o(227046);
    return paramString;
  }
  
  public final long f(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(227041);
    paramLong1 = this.bql.f(paramString, paramLong1, paramLong2);
    AppMethodBeat.o(227041);
    return paramLong1;
  }
  
  public final g f(String paramString, long paramLong)
  {
    for (;;)
    {
      n localn;
      try
      {
        AppMethodBeat.i(227028);
        localn = this.bql.j(paramString, paramLong);
        if (localn == null)
        {
          Log.i(this.bqj, "startReadWriteNonBlocking, write case, lock not available.");
          AppMethodBeat.o(227028);
          paramString = null;
          return paramString;
        }
        if (localn.bpU)
        {
          Log.i(this.bqj, "startReadWriteNonBlocking, read case.");
          paramString = (g)localn;
          AppMethodBeat.o(227028);
          continue;
        }
        Log.i(this.bqj, "startReadWriteNonBlocking, write case, lock available.");
      }
      finally {}
      int i = this.bqm.bD(paramString);
      paramString = this.cacheDir;
      p.k(paramString, "cacheDir");
      paramString = new File(paramString, i + ".v1.lock");
      Log.i(this.bqj, "startReadWriteNonBlocking, lockFile: ".concat(String.valueOf(paramString)));
      try
      {
        Log.i(this.bqj, "startReadWriteNonBlocking, try lock");
        paramString = new RandomAccessFile(paramString, "rw").getChannel().tryLock();
        if (paramString != null)
        {
          this.bqk.put(i, paramString);
          Log.i(this.bqj, "startReadWriteNonBlocking, write case, file lock available.");
          paramString = (g)localn;
          AppMethodBeat.o(227028);
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          Log.w(this.bqj, "startReadWriteNonBlocking, try lock fail since ".concat(String.valueOf(paramString)));
          paramString = null;
        }
        Log.i(this.bqj, "startReadWriteNonBlocking, write case, file lock not available.");
        AppMethodBeat.o(227028);
        paramString = null;
      }
    }
  }
  
  public final void g(String paramString, long paramLong)
  {
    AppMethodBeat.i(227044);
    this.bql.g(paramString, paramLong);
    AppMethodBeat.o(227044);
  }
  
  public final void r(File paramFile)
  {
    AppMethodBeat.i(227038);
    this.bql.r(paramFile);
    AppMethodBeat.o(227038);
  }
  
  public final long uP()
  {
    AppMethodBeat.i(227040);
    long l = this.bql.uP();
    AppMethodBeat.o(227040);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.h.a.l
 * JD-Core Version:    0.7.0.1
 */
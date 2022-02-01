package com.google.android.exoplayer2.h.a;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.NavigableSet;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/google/android/exoplayer2/upstream/cache/MultiProcessSupportSimpleCache;", "Lcom/google/android/exoplayer2/upstream/cache/Cache;", "realCache", "Lcom/google/android/exoplayer2/upstream/cache/SimpleCache;", "cacheDir", "Ljava/io/File;", "index", "Lcom/google/android/exoplayer2/upstream/cache/CachedContentIndex;", "(Lcom/google/android/exoplayer2/upstream/cache/SimpleCache;Ljava/io/File;Lcom/google/android/exoplayer2/upstream/cache/CachedContentIndex;)V", "fileLocks", "Landroid/util/SparseArray;", "Ljava/nio/channels/FileLock;", "myTag", "", "addListener", "Ljava/util/NavigableSet;", "Lcom/google/android/exoplayer2/upstream/cache/CacheSpan;", "kotlin.jvm.PlatformType", "p0", "p1", "Lcom/google/android/exoplayer2/upstream/cache/Cache$Listener;", "commitFile", "", "getCacheSpace", "", "getCachedBytes", "p2", "getCachedSpans", "getContentLength", "getKeys", "", "", "isCached", "", "releaseHoleSpan", "holeSpan", "removeListener", "removeSpan", "setContentLength", "startFile", "startReadWrite", "startReadWriteNonBlocking", "key", "position", "Companion", "luggage-commons-jsapi-video-ext_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  implements a
{
  public static final l.a djN;
  private final File cacheDir;
  private final m djO;
  private final j djP;
  private final String djQ;
  private final SparseArray<FileLock> djR;
  
  static
  {
    AppMethodBeat.i(210326);
    djN = new l.a((byte)0);
    AppMethodBeat.o(210326);
  }
  
  private l(m paramm, File paramFile, j paramj)
  {
    AppMethodBeat.i(210323);
    this.djO = paramm;
    this.cacheDir = paramFile;
    this.djP = paramj;
    this.djQ = s.X("MicroMsg.AppBrand.MultiProcessSupportSimpleCache#", Integer.valueOf(hashCode()));
    this.djR = new SparseArray();
    AppMethodBeat.o(210323);
  }
  
  public final long Uo()
  {
    AppMethodBeat.i(210329);
    long l = this.djO.Uo();
    AppMethodBeat.o(210329);
    return l;
  }
  
  public final NavigableSet<g> a(String paramString, a.b paramb)
  {
    AppMethodBeat.i(210327);
    paramString = this.djO.a(paramString, paramb);
    AppMethodBeat.o(210327);
    return paramString;
  }
  
  /* Error */
  public final void a(g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 144
    //   4: invokestatic 78	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: ldc 145
    //   10: invokestatic 149	kotlin/g/b/s:u	(Ljava/lang/Object;Ljava/lang/String;)V
    //   13: aload_0
    //   14: getfield 118	com/google/android/exoplayer2/h/a/l:djQ	Ljava/lang/String;
    //   17: ldc 151
    //   19: invokestatic 156	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   22: aload_0
    //   23: getfield 98	com/google/android/exoplayer2/h/a/l:djP	Lcom/google/android/exoplayer2/h/a/j;
    //   26: aload_1
    //   27: getfield 160	com/google/android/exoplayer2/h/a/g:key	Ljava/lang/String;
    //   30: invokevirtual 166	com/google/android/exoplayer2/h/a/j:cU	(Ljava/lang/String;)Lcom/google/android/exoplayer2/h/a/i;
    //   33: getfield 172	com/google/android/exoplayer2/h/a/i:id	I
    //   36: istore_2
    //   37: aload_0
    //   38: getfield 123	com/google/android/exoplayer2/h/a/l:djR	Landroid/util/SparseArray;
    //   41: iload_2
    //   42: invokevirtual 176	android/util/SparseArray:get	(I)Ljava/lang/Object;
    //   45: checkcast 178	java/nio/channels/FileLock
    //   48: invokevirtual 181	java/nio/channels/FileLock:release	()V
    //   51: aload_0
    //   52: getfield 123	com/google/android/exoplayer2/h/a/l:djR	Landroid/util/SparseArray;
    //   55: iload_2
    //   56: invokevirtual 184	android/util/SparseArray:remove	(I)V
    //   59: aload_0
    //   60: getfield 94	com/google/android/exoplayer2/h/a/l:djO	Lcom/google/android/exoplayer2/h/a/m;
    //   63: aload_1
    //   64: invokevirtual 186	com/google/android/exoplayer2/h/a/m:a	(Lcom/google/android/exoplayer2/h/a/g;)V
    //   67: ldc 144
    //   69: invokestatic 87	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   72: aload_0
    //   73: monitorexit
    //   74: return
    //   75: astore_3
    //   76: aload_0
    //   77: getfield 118	com/google/android/exoplayer2/h/a/l:djQ	Ljava/lang/String;
    //   80: ldc 188
    //   82: aload_3
    //   83: invokestatic 116	kotlin/g/b/s:X	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/String;
    //   86: invokestatic 191	com/tencent/mm/sdk/platformtools/Log:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   89: goto -30 -> 59
    //   92: astore_1
    //   93: aload_0
    //   94: monitorexit
    //   95: aload_1
    //   96: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	97	0	this	l
    //   0	97	1	paramg	g
    //   36	20	2	i	int
    //   75	8	3	localException	Exception
    // Exception table:
    //   from	to	target	type
    //   13	59	75	java/lang/Exception
    //   2	13	92	finally
    //   13	59	92	finally
    //   59	72	92	finally
    //   76	89	92	finally
  }
  
  public final void b(g paramg)
  {
    AppMethodBeat.i(210332);
    this.djO.b(paramg);
    AppMethodBeat.o(210332);
  }
  
  public final long cS(String paramString)
  {
    AppMethodBeat.i(210331);
    long l = this.djO.cS(paramString);
    AppMethodBeat.o(210331);
    return l;
  }
  
  public final g e(String paramString, long paramLong)
  {
    AppMethodBeat.i(210335);
    paramString = (g)this.djO.i(paramString, paramLong);
    AppMethodBeat.o(210335);
    return paramString;
  }
  
  public final File e(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(210334);
    paramString = this.djO.e(paramString, paramLong1, paramLong2);
    AppMethodBeat.o(210334);
    return paramString;
  }
  
  public final long f(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(210330);
    paramLong1 = this.djO.f(paramString, paramLong1, paramLong2);
    AppMethodBeat.o(210330);
    return paramLong1;
  }
  
  public final g f(String paramString, long paramLong)
  {
    for (;;)
    {
      n localn;
      try
      {
        AppMethodBeat.i(210336);
        localn = this.djO.j(paramString, paramLong);
        if (localn == null)
        {
          Log.i(this.djQ, "startReadWriteNonBlocking, write case, lock not available.");
          AppMethodBeat.o(210336);
          paramString = null;
          return paramString;
        }
        if (localn.djy)
        {
          Log.i(this.djQ, "startReadWriteNonBlocking, read case.");
          paramString = (g)localn;
          AppMethodBeat.o(210336);
          continue;
        }
        Log.i(this.djQ, "startReadWriteNonBlocking, write case, lock available.");
      }
      finally {}
      int i = this.djP.cV(paramString);
      paramString = this.cacheDir;
      s.u(paramString, "cacheDir");
      paramString = new File(paramString, i + ".v1.lock");
      Log.i(this.djQ, s.X("startReadWriteNonBlocking, lockFile: ", paramString));
      try
      {
        Log.i(this.djQ, "startReadWriteNonBlocking, try lock");
        paramString = new RandomAccessFile(paramString, "rw").getChannel().tryLock();
        if (paramString != null)
        {
          this.djR.put(i, paramString);
          Log.i(this.djQ, "startReadWriteNonBlocking, write case, file lock available.");
          paramString = (g)localn;
          AppMethodBeat.o(210336);
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          Log.w(this.djQ, s.X("startReadWriteNonBlocking, try lock fail since ", paramString));
          paramString = null;
        }
        Log.i(this.djQ, "startReadWriteNonBlocking, write case, file lock not available.");
        AppMethodBeat.o(210336);
        paramString = null;
      }
    }
  }
  
  public final void g(String paramString, long paramLong)
  {
    AppMethodBeat.i(210333);
    this.djO.g(paramString, paramLong);
    AppMethodBeat.o(210333);
  }
  
  public final void x(File paramFile)
  {
    AppMethodBeat.i(210328);
    this.djO.x(paramFile);
    AppMethodBeat.o(210328);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.h.a.l
 * JD-Core Version:    0.7.0.1
 */
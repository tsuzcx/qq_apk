package com.google.android.gms.common.data;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

@VisibleForTesting
public final class ConcatenatedDataBuffer<T>
  implements DataBuffer<T>, ExclusionFilterable, TextFilterable
{
  private Bundle mBundle;
  private final ArrayList<DataBuffer<T>> zznf;
  private final ArrayList<Integer> zzng;
  private int zznh;
  
  public ConcatenatedDataBuffer()
  {
    AppMethodBeat.i(61020);
    this.zznf = new ArrayList();
    this.zzng = new ArrayList();
    AppMethodBeat.o(61020);
  }
  
  public ConcatenatedDataBuffer(DataBuffer<T> paramDataBuffer)
  {
    AppMethodBeat.i(61021);
    this.zznf = new ArrayList();
    this.zzng = new ArrayList();
    append(paramDataBuffer);
    AppMethodBeat.o(61021);
  }
  
  public static <T> ConcatenatedDataBuffer<T> extend(ConcatenatedDataBuffer<T> paramConcatenatedDataBuffer, DataBuffer<T> paramDataBuffer)
  {
    AppMethodBeat.i(61029);
    ConcatenatedDataBuffer localConcatenatedDataBuffer = new ConcatenatedDataBuffer();
    paramConcatenatedDataBuffer = (ArrayList)paramConcatenatedDataBuffer.zznf;
    int j = paramConcatenatedDataBuffer.size();
    int i = 0;
    while (i < j)
    {
      Object localObject = paramConcatenatedDataBuffer.get(i);
      i += 1;
      localConcatenatedDataBuffer.append((DataBuffer)localObject);
    }
    localConcatenatedDataBuffer.append(paramDataBuffer);
    AppMethodBeat.o(61029);
    return localConcatenatedDataBuffer;
  }
  
  /* Error */
  public final void append(DataBuffer<T> paramDataBuffer)
  {
    // Byte code:
    //   0: ldc 64
    //   2: invokestatic 32	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: ifnonnull +9 -> 15
    //   9: ldc 64
    //   11: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   14: return
    //   15: aload_0
    //   16: monitorenter
    //   17: aload_0
    //   18: getfield 37	com/google/android/gms/common/data/ConcatenatedDataBuffer:zznf	Ljava/util/ArrayList;
    //   21: invokevirtual 68	java/util/ArrayList:isEmpty	()Z
    //   24: ifeq +40 -> 64
    //   27: aload_0
    //   28: new 70	android/os/Bundle
    //   31: dup
    //   32: invokespecial 71	android/os/Bundle:<init>	()V
    //   35: putfield 73	com/google/android/gms/common/data/ConcatenatedDataBuffer:mBundle	Landroid/os/Bundle;
    //   38: aload_1
    //   39: invokeinterface 77 1 0
    //   44: astore_2
    //   45: aload_2
    //   46: ifnull +18 -> 64
    //   49: aload_0
    //   50: getfield 73	com/google/android/gms/common/data/ConcatenatedDataBuffer:mBundle	Landroid/os/Bundle;
    //   53: ldc 79
    //   55: aload_2
    //   56: ldc 79
    //   58: invokevirtual 83	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   61: invokevirtual 87	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   64: aload_0
    //   65: getfield 37	com/google/android/gms/common/data/ConcatenatedDataBuffer:zznf	Ljava/util/ArrayList;
    //   68: aload_1
    //   69: invokevirtual 91	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   72: pop
    //   73: aload_0
    //   74: invokevirtual 94	com/google/android/gms/common/data/ConcatenatedDataBuffer:computeCounts	()V
    //   77: aload_1
    //   78: invokeinterface 77 1 0
    //   83: astore_1
    //   84: aload_1
    //   85: ifnull +26 -> 111
    //   88: aload_0
    //   89: getfield 73	com/google/android/gms/common/data/ConcatenatedDataBuffer:mBundle	Landroid/os/Bundle;
    //   92: ldc 96
    //   94: aload_1
    //   95: ldc 96
    //   97: invokevirtual 83	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   100: invokevirtual 87	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   103: aload_0
    //   104: monitorexit
    //   105: ldc 64
    //   107: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   110: return
    //   111: aload_0
    //   112: getfield 73	com/google/android/gms/common/data/ConcatenatedDataBuffer:mBundle	Landroid/os/Bundle;
    //   115: ldc 96
    //   117: invokevirtual 100	android/os/Bundle:remove	(Ljava/lang/String;)V
    //   120: goto -17 -> 103
    //   123: astore_1
    //   124: aload_0
    //   125: monitorexit
    //   126: ldc 64
    //   128: invokestatic 42	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   131: aload_1
    //   132: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	133	0	this	ConcatenatedDataBuffer
    //   0	133	1	paramDataBuffer	DataBuffer<T>
    //   44	12	2	localBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   17	45	123	finally
    //   49	64	123	finally
    //   64	84	123	finally
    //   88	103	123	finally
    //   103	105	123	finally
    //   111	120	123	finally
    //   124	126	123	finally
  }
  
  public final void clearFilters()
  {
    AppMethodBeat.i(61032);
    int j = this.zznf.size();
    int i = 0;
    while (i < j)
    {
      DataBuffer localDataBuffer = (DataBuffer)this.zznf.get(i);
      if ((localDataBuffer instanceof ExclusionFilterable)) {
        ((ExclusionFilterable)localDataBuffer).clearFilters();
      }
      i += 1;
    }
    computeCounts();
    AppMethodBeat.o(61032);
  }
  
  @Deprecated
  public final void close()
  {
    AppMethodBeat.i(61025);
    release();
    AppMethodBeat.o(61025);
  }
  
  public final void computeCounts()
  {
    AppMethodBeat.i(61028);
    this.zzng.clear();
    int k = this.zznf.size();
    int j = 0;
    int i = 0;
    if (j < k)
    {
      DataBuffer localDataBuffer = (DataBuffer)this.zznf.get(j);
      if (localDataBuffer == null) {
        break label87;
      }
      i = localDataBuffer.getCount() + i;
    }
    label87:
    for (;;)
    {
      this.zzng.add(Integer.valueOf(i));
      j += 1;
      break;
      this.zznh = i;
      AppMethodBeat.o(61028);
      return;
    }
  }
  
  public final void filterOut(String paramString)
  {
    AppMethodBeat.i(61030);
    int j = this.zznf.size();
    int i = 0;
    while (i < j)
    {
      DataBuffer localDataBuffer = (DataBuffer)this.zznf.get(i);
      if ((localDataBuffer instanceof ExclusionFilterable)) {
        ((ExclusionFilterable)localDataBuffer).filterOut(paramString);
      }
      i += 1;
    }
    computeCounts();
    AppMethodBeat.o(61030);
  }
  
  public final T get(int paramInt)
  {
    AppMethodBeat.i(61022);
    try
    {
      int j = this.zznf.size();
      int i = 0;
      while (i < j)
      {
        int k = ((Integer)this.zzng.get(i)).intValue();
        if (paramInt < k)
        {
          Object localObject1 = (DataBuffer)this.zznf.get(i);
          if (localObject1 != null)
          {
            localObject1 = ((DataBuffer)localObject1).get(paramInt - k + ((DataBuffer)localObject1).getCount());
            return localObject1;
          }
        }
        i += 1;
      }
      return null;
    }
    finally
    {
      AppMethodBeat.o(61022);
    }
  }
  
  public final int getCount()
  {
    try
    {
      int i = this.zznh;
      return i;
    }
    finally {}
  }
  
  public final Bundle getMetadata()
  {
    try
    {
      Bundle localBundle = this.mBundle;
      return localBundle;
    }
    finally {}
  }
  
  @Deprecated
  public final boolean isClosed()
  {
    return false;
  }
  
  public final Iterator<T> iterator()
  {
    AppMethodBeat.i(61026);
    DataBufferIterator localDataBufferIterator = new DataBufferIterator(this);
    AppMethodBeat.o(61026);
    return localDataBufferIterator;
  }
  
  public final void release()
  {
    AppMethodBeat.i(61023);
    for (;;)
    {
      int i;
      try
      {
        int j = this.zznf.size();
        i = 0;
        if (i < j)
        {
          DataBuffer localDataBuffer = (DataBuffer)this.zznf.get(i);
          if (localDataBuffer != null) {
            localDataBuffer.release();
          }
        }
        else
        {
          this.zznf.clear();
          this.zzng.clear();
          this.mBundle = null;
          return;
        }
      }
      finally
      {
        AppMethodBeat.o(61023);
      }
      i += 1;
    }
  }
  
  public final void setFilterTerm(Context paramContext, TextFilterable.StringFilter paramStringFilter, String paramString)
  {
    AppMethodBeat.i(61034);
    int j = this.zznf.size();
    int i = 0;
    while (i < j)
    {
      DataBuffer localDataBuffer = (DataBuffer)this.zznf.get(i);
      if ((localDataBuffer instanceof TextFilterable)) {
        ((TextFilterable)localDataBuffer).setFilterTerm(paramContext, paramStringFilter, paramString);
      }
      i += 1;
    }
    computeCounts();
    AppMethodBeat.o(61034);
  }
  
  public final void setFilterTerm(Context paramContext, String paramString)
  {
    AppMethodBeat.i(61033);
    int j = this.zznf.size();
    int i = 0;
    while (i < j)
    {
      DataBuffer localDataBuffer = (DataBuffer)this.zznf.get(i);
      if ((localDataBuffer instanceof TextFilterable)) {
        ((TextFilterable)localDataBuffer).setFilterTerm(paramContext, paramString);
      }
      i += 1;
    }
    computeCounts();
    AppMethodBeat.o(61033);
  }
  
  public final Iterator<T> singleRefIterator()
  {
    AppMethodBeat.i(61027);
    Iterator localIterator = iterator();
    AppMethodBeat.o(61027);
    return localIterator;
  }
  
  public final void unfilter(String paramString)
  {
    AppMethodBeat.i(61031);
    int j = this.zznf.size();
    int i = 0;
    while (i < j)
    {
      DataBuffer localDataBuffer = (DataBuffer)this.zznf.get(i);
      if ((localDataBuffer instanceof ExclusionFilterable)) {
        ((ExclusionFilterable)localDataBuffer).unfilter(paramString);
      }
      i += 1;
    }
    computeCounts();
    AppMethodBeat.o(61031);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.common.data.ConcatenatedDataBuffer
 * JD-Core Version:    0.7.0.1
 */
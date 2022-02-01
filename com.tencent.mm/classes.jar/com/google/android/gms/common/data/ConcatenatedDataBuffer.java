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
    AppMethodBeat.i(11512);
    this.zznf = new ArrayList();
    this.zzng = new ArrayList();
    AppMethodBeat.o(11512);
  }
  
  public ConcatenatedDataBuffer(DataBuffer<T> paramDataBuffer)
  {
    AppMethodBeat.i(11513);
    this.zznf = new ArrayList();
    this.zzng = new ArrayList();
    append(paramDataBuffer);
    AppMethodBeat.o(11513);
  }
  
  public static <T> ConcatenatedDataBuffer<T> extend(ConcatenatedDataBuffer<T> paramConcatenatedDataBuffer, DataBuffer<T> paramDataBuffer)
  {
    AppMethodBeat.i(11521);
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
    AppMethodBeat.o(11521);
    return localConcatenatedDataBuffer;
  }
  
  /* Error */
  public final void append(DataBuffer<T> paramDataBuffer)
  {
    // Byte code:
    //   0: sipush 11516
    //   3: invokestatic 31	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   6: aload_1
    //   7: ifnonnull +10 -> 17
    //   10: sipush 11516
    //   13: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   16: return
    //   17: aload_0
    //   18: monitorenter
    //   19: aload_0
    //   20: getfield 36	com/google/android/gms/common/data/ConcatenatedDataBuffer:zznf	Ljava/util/ArrayList;
    //   23: invokevirtual 64	java/util/ArrayList:isEmpty	()Z
    //   26: ifeq +40 -> 66
    //   29: aload_0
    //   30: new 66	android/os/Bundle
    //   33: dup
    //   34: invokespecial 67	android/os/Bundle:<init>	()V
    //   37: putfield 69	com/google/android/gms/common/data/ConcatenatedDataBuffer:mBundle	Landroid/os/Bundle;
    //   40: aload_1
    //   41: invokeinterface 73 1 0
    //   46: astore_2
    //   47: aload_2
    //   48: ifnull +18 -> 66
    //   51: aload_0
    //   52: getfield 69	com/google/android/gms/common/data/ConcatenatedDataBuffer:mBundle	Landroid/os/Bundle;
    //   55: ldc 75
    //   57: aload_2
    //   58: ldc 75
    //   60: invokevirtual 79	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   63: invokevirtual 83	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   66: aload_0
    //   67: getfield 36	com/google/android/gms/common/data/ConcatenatedDataBuffer:zznf	Ljava/util/ArrayList;
    //   70: aload_1
    //   71: invokevirtual 87	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   74: pop
    //   75: aload_0
    //   76: invokevirtual 90	com/google/android/gms/common/data/ConcatenatedDataBuffer:computeCounts	()V
    //   79: aload_1
    //   80: invokeinterface 73 1 0
    //   85: astore_1
    //   86: aload_1
    //   87: ifnull +27 -> 114
    //   90: aload_0
    //   91: getfield 69	com/google/android/gms/common/data/ConcatenatedDataBuffer:mBundle	Landroid/os/Bundle;
    //   94: ldc 92
    //   96: aload_1
    //   97: ldc 92
    //   99: invokevirtual 79	android/os/Bundle:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   102: invokevirtual 83	android/os/Bundle:putString	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: aload_0
    //   106: monitorexit
    //   107: sipush 11516
    //   110: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   113: return
    //   114: aload_0
    //   115: getfield 69	com/google/android/gms/common/data/ConcatenatedDataBuffer:mBundle	Landroid/os/Bundle;
    //   118: ldc 92
    //   120: invokevirtual 96	android/os/Bundle:remove	(Ljava/lang/String;)V
    //   123: goto -18 -> 105
    //   126: astore_1
    //   127: aload_0
    //   128: monitorexit
    //   129: sipush 11516
    //   132: invokestatic 41	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   135: aload_1
    //   136: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	137	0	this	ConcatenatedDataBuffer
    //   0	137	1	paramDataBuffer	DataBuffer<T>
    //   46	12	2	localBundle	Bundle
    // Exception table:
    //   from	to	target	type
    //   19	47	126	finally
    //   51	66	126	finally
    //   66	86	126	finally
    //   90	105	126	finally
    //   105	107	126	finally
    //   114	123	126	finally
    //   127	129	126	finally
  }
  
  public final void clearFilters()
  {
    AppMethodBeat.i(11524);
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
    AppMethodBeat.o(11524);
  }
  
  @Deprecated
  public final void close()
  {
    AppMethodBeat.i(11517);
    release();
    AppMethodBeat.o(11517);
  }
  
  public final void computeCounts()
  {
    AppMethodBeat.i(11520);
    this.zzng.clear();
    int k = this.zznf.size();
    int j = 0;
    int i = 0;
    if (j < k)
    {
      DataBuffer localDataBuffer = (DataBuffer)this.zznf.get(j);
      if (localDataBuffer == null) {
        break label89;
      }
      i = localDataBuffer.getCount() + i;
    }
    label89:
    for (;;)
    {
      this.zzng.add(Integer.valueOf(i));
      j += 1;
      break;
      this.zznh = i;
      AppMethodBeat.o(11520);
      return;
    }
  }
  
  public final void filterOut(String paramString)
  {
    AppMethodBeat.i(11522);
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
    AppMethodBeat.o(11522);
  }
  
  public final T get(int paramInt)
  {
    AppMethodBeat.i(11514);
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
      AppMethodBeat.o(11514);
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
    AppMethodBeat.i(11518);
    DataBufferIterator localDataBufferIterator = new DataBufferIterator(this);
    AppMethodBeat.o(11518);
    return localDataBufferIterator;
  }
  
  public final void release()
  {
    AppMethodBeat.i(11515);
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
        AppMethodBeat.o(11515);
      }
      i += 1;
    }
  }
  
  public final void setFilterTerm(Context paramContext, TextFilterable.StringFilter paramStringFilter, String paramString)
  {
    AppMethodBeat.i(11526);
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
    AppMethodBeat.o(11526);
  }
  
  public final void setFilterTerm(Context paramContext, String paramString)
  {
    AppMethodBeat.i(11525);
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
    AppMethodBeat.o(11525);
  }
  
  public final Iterator<T> singleRefIterator()
  {
    AppMethodBeat.i(11519);
    Iterator localIterator = iterator();
    AppMethodBeat.o(11519);
    return localIterator;
  }
  
  public final void unfilter(String paramString)
  {
    AppMethodBeat.i(11523);
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
    AppMethodBeat.o(11523);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.data.ConcatenatedDataBuffer
 * JD-Core Version:    0.7.0.1
 */
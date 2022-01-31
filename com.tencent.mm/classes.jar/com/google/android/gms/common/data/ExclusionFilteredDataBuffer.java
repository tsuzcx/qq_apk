package com.google.android.gms.common.data;

import android.text.TextUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

@VisibleForTesting
public final class ExclusionFilteredDataBuffer<T>
  extends FilteredDataBuffer<T>
  implements DataBufferObserver.Observable, ExclusionFilterable
{
  private AbstractDataBuffer<T> zzoc;
  private final String zzod;
  private final HashSet<Integer> zzoe;
  private DataBufferObserverSet zzof;
  
  public ExclusionFilteredDataBuffer(AbstractDataBuffer<T> paramAbstractDataBuffer, String paramString)
  {
    super(paramAbstractDataBuffer);
    AppMethodBeat.i(61126);
    this.zzoe = new HashSet();
    this.zzoc = paramAbstractDataBuffer;
    this.zzod = paramString;
    this.zzof = new DataBufferObserverSet();
    AppMethodBeat.o(61126);
  }
  
  private final ArrayList<Integer> zza(String paramString, ArrayList<Integer> paramArrayList)
  {
    AppMethodBeat.i(61135);
    ArrayList localArrayList = new ArrayList();
    if (paramArrayList != null) {
      paramArrayList.clear();
    }
    DataHolder localDataHolder = this.zzoc.mDataHolder;
    String str1 = this.zzod;
    boolean bool = this.zzoc instanceof EntityBuffer;
    int n = this.zzoc.getCount();
    int j = 0;
    int i = 0;
    int k;
    label86:
    String str2;
    if (j < n) {
      if (bool)
      {
        k = ((EntityBuffer)this.zzoc).zzi(j);
        str2 = localDataHolder.getString(str1, k, localDataHolder.getWindowIndex(k));
        if (paramArrayList == null) {
          break label209;
        }
        if (!this.zzoe.contains(Integer.valueOf(j))) {
          break label187;
        }
        k = -i - 1;
      }
    }
    for (;;)
    {
      if ((!TextUtils.isEmpty(str2)) && (str2.equals(paramString)))
      {
        localArrayList.add(Integer.valueOf(j));
        if (paramArrayList != null) {
          paramArrayList.add(Integer.valueOf(k));
        }
      }
      j += 1;
      break;
      k = j;
      break label86;
      label187:
      int m = i + 1;
      k = i;
      i = m;
      continue;
      AppMethodBeat.o(61135);
      return localArrayList;
      label209:
      k = i;
    }
  }
  
  public final void addObserver(DataBufferObserver paramDataBufferObserver)
  {
    AppMethodBeat.i(61127);
    this.zzof.addObserver(paramDataBufferObserver);
    AppMethodBeat.o(61127);
  }
  
  public final void clearFilters()
  {
    AppMethodBeat.i(61134);
    if (!this.zzof.hasObservers())
    {
      this.zzoe.clear();
      AppMethodBeat.o(61134);
      return;
    }
    int n = this.zzoe.size();
    Integer[] arrayOfInteger = new Integer[n];
    arrayOfInteger = (Integer[])this.zzoe.toArray(arrayOfInteger);
    Arrays.sort(arrayOfInteger);
    int k = 0;
    int j = 0;
    int i = 0;
    if (k < n)
    {
      int m = arrayOfInteger[k].intValue();
      this.zzoe.remove(Integer.valueOf(m));
      if (j == 0)
      {
        i = 1;
        j = m;
      }
      for (;;)
      {
        k += 1;
        m = i;
        i = j;
        j = m;
        break;
        if (m == i + j)
        {
          m = j + 1;
          j = i;
          i = m;
        }
        else
        {
          this.zzof.onDataRangeRemoved(i, j);
          i = 1;
          j = m;
        }
      }
    }
    if (j > 0) {
      this.zzof.onDataRangeRemoved(i, j);
    }
    AppMethodBeat.o(61134);
  }
  
  public final int computeRealPosition(int paramInt)
  {
    AppMethodBeat.i(61130);
    if (this.zzoe.isEmpty())
    {
      AppMethodBeat.o(61130);
      return paramInt;
    }
    if ((paramInt < 0) || (paramInt >= getCount()))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException(53 + "Position " + paramInt + " is out of bounds for this buffer");
      AppMethodBeat.o(61130);
      throw localIllegalArgumentException;
    }
    int m = this.mDataBuffer.getCount();
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      k = j;
      if (!this.zzoe.contains(Integer.valueOf(i)))
      {
        if (j == paramInt)
        {
          AppMethodBeat.o(61130);
          return i;
        }
        k = j + 1;
      }
      i += 1;
    }
    AppMethodBeat.o(61130);
    return -1;
  }
  
  public final void filterOut(String paramString)
  {
    AppMethodBeat.i(61132);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(61132);
      return;
    }
    if (this.zzof.hasObservers()) {}
    for (ArrayList localArrayList = new ArrayList();; localArrayList = null)
    {
      paramString = zza(paramString, localArrayList);
      int k;
      int i;
      int j;
      int n;
      int m;
      if (this.zzof.hasObservers())
      {
        k = paramString.size() - 1;
        i = 0;
        j = 0;
        if (k >= 0)
        {
          n = ((Integer)localArrayList.get(k)).intValue();
          if (n < 0)
          {
            m = 1;
            label95:
            if (m != 0) {
              break label221;
            }
            m = ((Integer)paramString.get(k)).intValue();
            this.zzoe.add(Integer.valueOf(m));
            if (i != 0) {
              break label151;
            }
            i = 1;
            j = n;
          }
        }
      }
      label151:
      label221:
      for (;;)
      {
        k -= 1;
        break;
        m = 0;
        break label95;
        if (n == j - 1)
        {
          j -= 1;
          i += 1;
        }
        else
        {
          this.zzof.onDataRangeRemoved(j, i);
          i = 1;
          j = n;
          continue;
          if (i > 0) {
            this.zzof.onDataRangeRemoved(j, i);
          }
          AppMethodBeat.o(61132);
          return;
          this.zzoe.addAll(paramString);
          AppMethodBeat.o(61132);
          return;
        }
      }
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(61129);
    int i = this.mDataBuffer.getCount();
    int j = this.zzoe.size();
    AppMethodBeat.o(61129);
    return i - j;
  }
  
  public final void release()
  {
    AppMethodBeat.i(61131);
    super.release();
    this.zzof.clear();
    AppMethodBeat.o(61131);
  }
  
  public final void removeObserver(DataBufferObserver paramDataBufferObserver)
  {
    AppMethodBeat.i(61128);
    this.zzof.removeObserver(paramDataBufferObserver);
    AppMethodBeat.o(61128);
  }
  
  public final void unfilter(String paramString)
  {
    AppMethodBeat.i(61133);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(61133);
      return;
    }
    if (this.zzof.hasObservers()) {}
    for (ArrayList localArrayList = new ArrayList();; localArrayList = null)
    {
      paramString = zza(paramString, localArrayList);
      int k;
      int j;
      int i;
      int m;
      if (this.zzof.hasObservers())
      {
        k = paramString.size() - 1;
        j = 0;
        i = 0;
        if (k >= 0)
        {
          int n = ((Integer)localArrayList.get(k)).intValue();
          if (n < 0)
          {
            m = 1;
            label95:
            if (m == 0) {
              break label240;
            }
            m = ((Integer)paramString.get(k)).intValue();
            this.zzoe.remove(Integer.valueOf(m));
            m = -n - 1;
            if (j != 0) {
              break label170;
            }
            i = 1;
            j = m;
          }
        }
      }
      for (;;)
      {
        m = k - 1;
        k = j;
        j = i;
        i = k;
        k = m;
        break;
        m = 0;
        break label95;
        label170:
        if (m == i)
        {
          m = j + 1;
          j = i;
          i = m;
        }
        else
        {
          this.zzof.onDataRangeInserted(i, j);
          i = 1;
          j = m;
          continue;
          if (j > 0) {
            this.zzof.onDataRangeInserted(i, j);
          }
          AppMethodBeat.o(61133);
          return;
          this.zzoe.removeAll(paramString);
          AppMethodBeat.o(61133);
          return;
          label240:
          m = i;
          i = j;
          j = m;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.gms.common.data.ExclusionFilteredDataBuffer
 * JD-Core Version:    0.7.0.1
 */
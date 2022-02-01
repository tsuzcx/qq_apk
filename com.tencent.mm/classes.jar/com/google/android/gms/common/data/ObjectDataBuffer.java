package com.google.android.gms.common.data;

import android.os.Bundle;
import com.google.android.gms.common.internal.Asserts;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public final class ObjectDataBuffer<T>
  extends AbstractDataBuffer<T>
  implements DataBufferObserver.Observable, ObjectExclusionFilterable<T>
{
  private final ArrayList<Integer> zzob;
  private final HashSet<Integer> zzoe;
  private DataBufferObserverSet zzof;
  private final ArrayList<T> zzog;
  
  public ObjectDataBuffer()
  {
    super(null);
    AppMethodBeat.i(11631);
    this.zzoe = new HashSet();
    this.zzob = new ArrayList();
    this.zzog = new ArrayList();
    this.zzof = new DataBufferObserverSet();
    zzcl();
    AppMethodBeat.o(11631);
  }
  
  public ObjectDataBuffer(ArrayList<T> paramArrayList)
  {
    super(null);
    AppMethodBeat.i(11633);
    this.zzoe = new HashSet();
    this.zzob = new ArrayList();
    this.zzog = paramArrayList;
    this.zzof = new DataBufferObserverSet();
    zzcl();
    AppMethodBeat.o(11633);
  }
  
  public ObjectDataBuffer(T... paramVarArgs)
  {
    super(null);
    AppMethodBeat.i(11632);
    this.zzoe = new HashSet();
    this.zzob = new ArrayList();
    this.zzog = new ArrayList(Arrays.asList(paramVarArgs));
    this.zzof = new DataBufferObserverSet();
    zzcl();
    AppMethodBeat.o(11632);
  }
  
  private final void zzcl()
  {
    AppMethodBeat.i(11653);
    this.zzob.clear();
    int i = 0;
    int j = this.zzog.size();
    while (i < j)
    {
      if (!this.zzoe.contains(Integer.valueOf(i))) {
        this.zzob.add(Integer.valueOf(i));
      }
      i += 1;
    }
    AppMethodBeat.o(11653);
  }
  
  public final void add(T paramT)
  {
    boolean bool2 = false;
    AppMethodBeat.i(11636);
    int i = this.zzog.size();
    this.zzog.add(paramT);
    zzcl();
    int j;
    if (this.zzof.hasObservers())
    {
      if (this.zzoe.contains(Integer.valueOf(i))) {
        break label132;
      }
      bool1 = true;
      Asserts.checkState(bool1);
      j = this.zzob.size();
      if (j <= 0) {
        break label138;
      }
    }
    label132:
    label138:
    for (boolean bool1 = true;; bool1 = false)
    {
      Asserts.checkState(bool1);
      bool1 = bool2;
      if (((Integer)this.zzob.get(j - 1)).intValue() == i) {
        bool1 = true;
      }
      Asserts.checkState(bool1);
      this.zzof.onDataRangeInserted(j - 1, 1);
      AppMethodBeat.o(11636);
      return;
      bool1 = false;
      break;
    }
  }
  
  public final void addObserver(DataBufferObserver paramDataBufferObserver)
  {
    AppMethodBeat.i(11634);
    this.zzof.addObserver(paramDataBufferObserver);
    AppMethodBeat.o(11634);
  }
  
  public final void filterOut(T paramT)
  {
    AppMethodBeat.i(11648);
    int i2 = this.zzog.size();
    int n = 0;
    int k = -1;
    int m = -1;
    int i1 = 0;
    int i = -1;
    int j;
    if (n < i2)
    {
      j = i;
      if (this.zzoe.contains(Integer.valueOf(n))) {
        break label206;
      }
      i += 1;
      if (paramT.equals(this.zzog.get(n)))
      {
        this.zzoe.add(Integer.valueOf(n));
        if (!this.zzof.hasObservers()) {
          break label214;
        }
        if (m < 0)
        {
          k = 1;
          m = i;
          j = 1;
        }
      }
    }
    for (;;)
    {
      n += 1;
      i1 = j;
      break;
      k += 1;
      j = 1;
      continue;
      j = i;
      if (m >= 0)
      {
        zzcl();
        this.zzof.onDataRangeRemoved(m, k);
        i1 = -1;
        m = -1;
        j = 0;
        i -= k;
        k = i1;
        continue;
        if (i1 != 0) {
          zzcl();
        }
        if (m >= 0) {
          this.zzof.onDataRangeRemoved(m, k);
        }
        AppMethodBeat.o(11648);
      }
      else
      {
        label206:
        i = j;
        j = i1;
        continue;
        label214:
        j = 1;
      }
    }
  }
  
  public final void filterOutRaw(int paramInt)
  {
    AppMethodBeat.i(11649);
    boolean bool = this.zzoe.add(Integer.valueOf(paramInt));
    int i;
    if ((this.zzof.hasObservers()) && (bool))
    {
      i = 0;
      int j = this.zzob.size();
      if (i < j) {
        if (((Integer)this.zzob.get(i)).intValue() != paramInt) {}
      }
    }
    for (;;)
    {
      zzcl();
      if (i >= 0) {
        this.zzof.onDataRangeRemoved(i, 1);
      }
      AppMethodBeat.o(11649);
      return;
      i += 1;
      break;
      i = -1;
    }
  }
  
  public final T get(int paramInt)
  {
    AppMethodBeat.i(11640);
    Object localObject = this.zzog.get(getRawPosition(paramInt));
    AppMethodBeat.o(11640);
    return localObject;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(11639);
    int i = this.zzog.size();
    int j = this.zzoe.size();
    AppMethodBeat.o(11639);
    return i - j;
  }
  
  public final Bundle getMetadata()
  {
    return null;
  }
  
  public final int getPositionFromRawPosition(int paramInt)
  {
    AppMethodBeat.i(11644);
    int j = -1;
    int i = 0;
    while (i <= paramInt)
    {
      int k = j;
      if (!this.zzoe.contains(Integer.valueOf(i))) {
        k = j + 1;
      }
      i += 1;
      j = k;
    }
    AppMethodBeat.o(11644);
    return j;
  }
  
  public final T getRaw(int paramInt)
  {
    AppMethodBeat.i(11642);
    Object localObject = this.zzog.get(paramInt);
    AppMethodBeat.o(11642);
    return localObject;
  }
  
  public final int getRawCount()
  {
    AppMethodBeat.i(11641);
    int i = this.zzog.size();
    AppMethodBeat.o(11641);
    return i;
  }
  
  public final int getRawPosition(int paramInt)
  {
    AppMethodBeat.i(11643);
    if ((paramInt < 0) || (paramInt >= getCount()))
    {
      IllegalArgumentException localIllegalArgumentException = new IllegalArgumentException(53 + "Position " + paramInt + " is out of bounds for this buffer");
      AppMethodBeat.o(11643);
      throw localIllegalArgumentException;
    }
    paramInt = ((Integer)this.zzob.get(paramInt)).intValue();
    AppMethodBeat.o(11643);
    return paramInt;
  }
  
  public final void insertRaw(int paramInt, T paramT)
  {
    AppMethodBeat.i(11637);
    this.zzog.add(paramInt, paramT);
    paramT = new HashSet(this.zzoe.size());
    Object localObject = this.zzoe.iterator();
    int i = paramInt;
    while (((Iterator)localObject).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject).next();
      if (localInteger.intValue() < paramInt)
      {
        i -= 1;
      }
      else
      {
        paramT.add(Integer.valueOf(localInteger.intValue() + 1));
        ((Iterator)localObject).remove();
      }
    }
    paramT = paramT.iterator();
    while (paramT.hasNext())
    {
      localObject = (Integer)paramT.next();
      this.zzoe.add(localObject);
    }
    zzcl();
    if (this.zzof.hasObservers()) {
      this.zzof.onDataRangeInserted(i, 1);
    }
    AppMethodBeat.o(11637);
  }
  
  public final boolean isRawPositionFiltered(int paramInt)
  {
    AppMethodBeat.i(11645);
    boolean bool = this.zzoe.contains(Integer.valueOf(paramInt));
    AppMethodBeat.o(11645);
    return bool;
  }
  
  public final void notifyChanged(T paramT)
  {
    AppMethodBeat.i(11652);
    if (!this.zzof.hasObservers())
    {
      AppMethodBeat.o(11652);
      return;
    }
    int j = this.zzob.size();
    int i = 0;
    while (i < j)
    {
      if (paramT.equals(this.zzog.get(((Integer)this.zzob.get(i)).intValue()))) {
        this.zzof.onDataRangeChanged(i, 1);
      }
      i += 1;
    }
    AppMethodBeat.o(11652);
  }
  
  public final void release()
  {
    AppMethodBeat.i(11646);
    this.zzof.clear();
    AppMethodBeat.o(11646);
  }
  
  public final void removeObserver(DataBufferObserver paramDataBufferObserver)
  {
    AppMethodBeat.i(11635);
    this.zzof.removeObserver(paramDataBufferObserver);
    AppMethodBeat.o(11635);
  }
  
  public final void removeRaw(int paramInt)
  {
    AppMethodBeat.i(11647);
    this.zzog.remove(paramInt);
    boolean bool = this.zzoe.remove(Integer.valueOf(paramInt));
    Object localObject1 = new HashSet(this.zzoe.size());
    Object localObject2 = this.zzoe.iterator();
    int i = paramInt;
    while (((Iterator)localObject2).hasNext())
    {
      Integer localInteger = (Integer)((Iterator)localObject2).next();
      if (localInteger.intValue() < paramInt)
      {
        i -= 1;
      }
      else
      {
        ((Iterator)localObject2).remove();
        ((HashSet)localObject1).add(Integer.valueOf(localInteger.intValue() - 1));
      }
    }
    localObject1 = ((HashSet)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Integer)((Iterator)localObject1).next();
      this.zzoe.add(localObject2);
    }
    zzcl();
    if ((!bool) && (this.zzof.hasObservers())) {
      this.zzof.onDataRangeRemoved(i, 1);
    }
    AppMethodBeat.o(11647);
  }
  
  public final boolean setRaw(int paramInt, T paramT)
  {
    AppMethodBeat.i(11638);
    this.zzog.set(paramInt, paramT);
    boolean bool;
    int j;
    int i;
    if (!this.zzoe.contains(Integer.valueOf(paramInt)))
    {
      bool = true;
      if ((bool) && (this.zzof.hasObservers()))
      {
        j = this.zzob.size();
        i = 0;
      }
    }
    for (;;)
    {
      if (i < j)
      {
        if (((Integer)this.zzob.get(i)).intValue() == paramInt) {
          this.zzof.onDataRangeChanged(i, 1);
        }
      }
      else
      {
        AppMethodBeat.o(11638);
        return bool;
        bool = false;
        break;
      }
      i += 1;
    }
  }
  
  public final void unfilter(T paramT)
  {
    AppMethodBeat.i(11650);
    int i2 = this.zzog.size();
    int n = 0;
    int k = -1;
    int m = -1;
    int i1 = 0;
    int i = 0;
    int j;
    if (n < i2) {
      if (!this.zzoe.contains(Integer.valueOf(n)))
      {
        i += 1;
        j = i;
        if (m < 0) {
          break label258;
        }
        zzcl();
        this.zzof.onDataRangeInserted(m, k);
        i1 = -1;
        m = -1;
        j = 0;
        i += k;
        k = i1;
      }
    }
    for (;;)
    {
      n += 1;
      i1 = j;
      break;
      if (paramT.equals(this.zzog.get(n)))
      {
        this.zzoe.remove(Integer.valueOf(n));
        if (this.zzof.hasObservers())
        {
          if (m < 0)
          {
            k = 1;
            m = i;
            j = 1;
            continue;
          }
          k += 1;
          j = 1;
        }
      }
      else
      {
        j = i;
        if (this.zzof.hasObservers())
        {
          j = i;
          if (m >= 0)
          {
            zzcl();
            this.zzof.onDataRangeInserted(m, k);
            i1 = -1;
            m = -1;
            j = 0;
            i += k;
            k = i1;
            continue;
            if (i1 != 0) {
              zzcl();
            }
            if (m >= 0) {
              this.zzof.onDataRangeInserted(m, k);
            }
            AppMethodBeat.o(11650);
            return;
          }
        }
        label258:
        i = j;
        j = i1;
        continue;
      }
      j = 1;
    }
  }
  
  public final void unfilterRaw(int paramInt)
  {
    AppMethodBeat.i(11651);
    boolean bool = this.zzoe.remove(Integer.valueOf(paramInt));
    zzcl();
    if ((!this.zzof.hasObservers()) || (!bool))
    {
      AppMethodBeat.o(11651);
      return;
    }
    int i = 0;
    int j = this.zzob.size();
    if (i < j) {
      if (((Integer)this.zzob.get(i)).intValue() != paramInt) {}
    }
    for (;;)
    {
      if (i >= 0) {
        this.zzof.onDataRangeInserted(i, 1);
      }
      AppMethodBeat.o(11651);
      return;
      i += 1;
      break;
      i = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.data.ObjectDataBuffer
 * JD-Core Version:    0.7.0.1
 */
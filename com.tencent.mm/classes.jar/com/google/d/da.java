package com.google.d;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class da<MType extends a, BType extends a.a, IType extends ch>
  implements a.b
{
  List<MType> dJE;
  public a.b dUC;
  private boolean dUD;
  List<df<MType, BType, IType>> dUE;
  private da.b<MType, BType, IType> dUF;
  private da.a<MType, BType, IType> dUG;
  private da.c<MType, BType, IType> dUH;
  boolean isClean;
  
  public da(List<MType> paramList, boolean paramBoolean1, a.b paramb, boolean paramBoolean2)
  {
    this.dJE = paramList;
    this.dUD = paramBoolean1;
    this.dUC = paramb;
    this.isClean = paramBoolean2;
  }
  
  private void ajb()
  {
    if (!this.dUD)
    {
      this.dJE = new ArrayList(this.dJE);
      this.dUD = true;
    }
  }
  
  private void ajc()
  {
    if (this.dUF != null) {
      throw null;
    }
    if (this.dUG != null) {
      throw null;
    }
    if (this.dUH != null) {
      throw null;
    }
  }
  
  private void onChanged()
  {
    if ((this.isClean) && (this.dUC != null))
    {
      this.dUC.ZN();
      this.isClean = false;
    }
  }
  
  final MType J(int paramInt, boolean paramBoolean)
  {
    if (this.dUE == null) {
      return (a)this.dJE.get(paramInt);
    }
    df localdf = (df)this.dUE.get(paramInt);
    if (localdf == null) {
      return (a)this.dJE.get(paramInt);
    }
    if (paramBoolean) {
      return localdf.ajn();
    }
    return localdf.ajm();
  }
  
  public final void ZN()
  {
    onChanged();
  }
  
  public final da<MType, BType, IType> a(MType paramMType)
  {
    bj.checkNotNull(paramMType);
    ajb();
    this.dJE.add(paramMType);
    if (this.dUE != null) {
      this.dUE.add(null);
    }
    onChanged();
    ajc();
    return this;
  }
  
  public final da<MType, BType, IType> a(Iterable<? extends MType> paramIterable)
  {
    Object localObject = paramIterable.iterator();
    while (((Iterator)localObject).hasNext()) {
      bj.checkNotNull((a)((Iterator)localObject).next());
    }
    if ((paramIterable instanceof Collection))
    {
      localObject = (Collection)paramIterable;
      if (((Collection)localObject).size() == 0) {
        return this;
      }
    }
    for (int i = ((Collection)localObject).size();; i = -1)
    {
      ajb();
      if ((i >= 0) && ((this.dJE instanceof ArrayList))) {
        ((ArrayList)this.dJE).ensureCapacity(i + this.dJE.size());
      }
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext()) {
        a((a)paramIterable.next());
      }
      onChanged();
      ajc();
      return this;
    }
  }
  
  public final List<MType> build()
  {
    this.isClean = true;
    if ((!this.dUD) && (this.dUE == null)) {
      return this.dJE;
    }
    if (!this.dUD)
    {
      i = 0;
      if (i >= this.dJE.size()) {
        break label168;
      }
      cb localcb = (cb)this.dJE.get(i);
      df localdf = (df)this.dUE.get(i);
      if ((localdf == null) || (localdf.ajn() == localcb)) {}
    }
    label168:
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        return this.dJE;
        i += 1;
        break;
      }
      ajb();
      i = 0;
      while (i < this.dJE.size())
      {
        this.dJE.set(i, J(i, true));
        i += 1;
      }
      this.dJE = Collections.unmodifiableList(this.dJE);
      this.dUD = false;
      return this.dJE;
    }
  }
  
  public final void clear()
  {
    this.dJE = Collections.emptyList();
    this.dUD = false;
    if (this.dUE != null)
    {
      Iterator localIterator = this.dUE.iterator();
      while (localIterator.hasNext())
      {
        df localdf = (df)localIterator.next();
        if (localdf != null) {
          localdf.dUC = null;
        }
      }
      this.dUE = null;
    }
    onChanged();
    ajc();
  }
  
  public final int getCount()
  {
    return this.dJE.size();
  }
  
  public final boolean isEmpty()
  {
    return this.dJE.isEmpty();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.google.d.da
 * JD-Core Version:    0.7.0.1
 */
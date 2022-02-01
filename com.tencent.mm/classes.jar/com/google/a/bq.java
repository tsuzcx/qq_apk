package com.google.a;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class bq<MType extends a, BType extends a.a, IType extends az>
  implements a.b
{
  List<MType> bNN;
  boolean bWv;
  a.b bYP;
  private boolean bYQ;
  List<bu<MType, BType, IType>> bYR;
  private b<MType, BType, IType> bYS;
  private a<MType, BType, IType> bYT;
  private c<MType, BType, IType> bYU;
  
  public bq(List<MType> paramList, boolean paramBoolean1, a.b paramb, boolean paramBoolean2)
  {
    this.bNN = paramList;
    this.bYQ = paramBoolean1;
    this.bYP = paramb;
    this.bWv = paramBoolean2;
  }
  
  private void Hm()
  {
    if (!this.bYQ)
    {
      this.bNN = new ArrayList(this.bNN);
      this.bYQ = true;
    }
  }
  
  private void Hn()
  {
    if (this.bYS != null) {
      this.bYS.Ho();
    }
    if (this.bYT != null) {
      this.bYT.Ho();
    }
    if (this.bYU != null) {
      this.bYU.Ho();
    }
  }
  
  private void onChanged()
  {
    if ((this.bWv) && (this.bYP != null))
    {
      this.bYP.yH();
      this.bWv = false;
    }
  }
  
  public final bq<MType, BType, IType> a(MType paramMType)
  {
    ae.checkNotNull(paramMType);
    Hm();
    this.bNN.add(paramMType);
    if (this.bYR != null) {
      this.bYR.add(null);
    }
    onChanged();
    Hn();
    return this;
  }
  
  public final bq<MType, BType, IType> a(Iterable<? extends MType> paramIterable)
  {
    Object localObject = paramIterable.iterator();
    while (((Iterator)localObject).hasNext()) {
      ae.checkNotNull((a)((Iterator)localObject).next());
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
      Hm();
      if ((i >= 0) && ((this.bNN instanceof ArrayList))) {
        ((ArrayList)this.bNN).ensureCapacity(i + this.bNN.size());
      }
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext()) {
        a((a)paramIterable.next());
      }
      onChanged();
      Hn();
      return this;
    }
  }
  
  public final List<MType> build()
  {
    this.bWv = true;
    if ((!this.bYQ) && (this.bYR == null)) {
      return this.bNN;
    }
    if (!this.bYQ)
    {
      i = 0;
      if (i >= this.bNN.size()) {
        break label168;
      }
      at localat = (at)this.bNN.get(i);
      bu localbu = (bu)this.bYR.get(i);
      if ((localbu == null) || (localbu.Hv() == localat)) {}
    }
    label168:
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        return this.bNN;
        i += 1;
        break;
      }
      Hm();
      i = 0;
      while (i < this.bNN.size())
      {
        this.bNN.set(i, s(i, true));
        i += 1;
      }
      this.bNN = Collections.unmodifiableList(this.bNN);
      this.bYQ = false;
      return this.bNN;
    }
  }
  
  public final int getCount()
  {
    return this.bNN.size();
  }
  
  public final boolean isEmpty()
  {
    return this.bNN.isEmpty();
  }
  
  final MType s(int paramInt, boolean paramBoolean)
  {
    if (this.bYR == null) {
      return (a)this.bNN.get(paramInt);
    }
    bu localbu = (bu)this.bYR.get(paramInt);
    if (localbu == null) {
      return (a)this.bNN.get(paramInt);
    }
    if (paramBoolean) {
      return localbu.Hv();
    }
    return localbu.Hu();
  }
  
  public final void yH()
  {
    onChanged();
  }
  
  static final class a<MType extends a, BType extends a.a, IType extends az>
    extends AbstractList<BType>
    implements List<BType>
  {
    bq<MType, BType, IType> bYV;
    
    final void Ho()
    {
      this.modCount += 1;
    }
    
    public final int size()
    {
      return this.bYV.getCount();
    }
  }
  
  static final class b<MType extends a, BType extends a.a, IType extends az>
    extends AbstractList<MType>
    implements List<MType>
  {
    bq<MType, BType, IType> bYV;
    
    final void Ho()
    {
      this.modCount += 1;
    }
    
    public final int size()
    {
      return this.bYV.getCount();
    }
  }
  
  static final class c<MType extends a, BType extends a.a, IType extends az>
    extends AbstractList<IType>
    implements List<IType>
  {
    bq<MType, BType, IType> bYV;
    
    final void Ho()
    {
      this.modCount += 1;
    }
    
    public final int size()
    {
      return this.bYV.getCount();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.a.bq
 * JD-Core Version:    0.7.0.1
 */
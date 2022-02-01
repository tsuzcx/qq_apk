package com.google.b;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class co<MType extends a, BType extends a.a, IType extends bz>
  implements a.b
{
  List<MType> bPM;
  boolean bYn;
  public a.b cat;
  private boolean cau;
  List<cs<MType, BType, IType>> cav;
  private co.b<MType, BType, IType> caw;
  private co.a<MType, BType, IType> cax;
  private co.c<MType, BType, IType> cay;
  
  public co(List<MType> paramList, boolean paramBoolean1, a.b paramb, boolean paramBoolean2)
  {
    this.bPM = paramList;
    this.cau = paramBoolean1;
    this.cat = paramb;
    this.bYn = paramBoolean2;
  }
  
  private void IN()
  {
    if (!this.cau)
    {
      this.bPM = new ArrayList(this.bPM);
      this.cau = true;
    }
  }
  
  private void IO()
  {
    if (this.caw != null) {
      throw null;
    }
    if (this.cax != null) {
      throw null;
    }
    if (this.cay != null) {
      throw null;
    }
  }
  
  private void onChanged()
  {
    if ((this.bYn) && (this.cat != null))
    {
      this.cat.Ai();
      this.bYn = false;
    }
  }
  
  public final void Ai()
  {
    onChanged();
  }
  
  public final co<MType, BType, IType> a(MType paramMType)
  {
    be.checkNotNull(paramMType);
    IN();
    this.bPM.add(paramMType);
    if (this.cav != null) {
      this.cav.add(null);
    }
    onChanged();
    IO();
    return this;
  }
  
  public final co<MType, BType, IType> a(Iterable<? extends MType> paramIterable)
  {
    Object localObject = paramIterable.iterator();
    while (((Iterator)localObject).hasNext()) {
      be.checkNotNull((a)((Iterator)localObject).next());
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
      IN();
      if ((i >= 0) && ((this.bPM instanceof ArrayList))) {
        ((ArrayList)this.bPM).ensureCapacity(i + this.bPM.size());
      }
      paramIterable = paramIterable.iterator();
      while (paramIterable.hasNext()) {
        a((a)paramIterable.next());
      }
      onChanged();
      IO();
      return this;
    }
  }
  
  public final List<MType> build()
  {
    this.bYn = true;
    if ((!this.cau) && (this.cav == null)) {
      return this.bPM;
    }
    if (!this.cau)
    {
      i = 0;
      if (i >= this.bPM.size()) {
        break label168;
      }
      bt localbt = (bt)this.bPM.get(i);
      cs localcs = (cs)this.cav.get(i);
      if ((localcs == null) || (localcs.IV() == localbt)) {}
    }
    label168:
    for (int i = 0;; i = 1)
    {
      if (i != 0)
      {
        return this.bPM;
        i += 1;
        break;
      }
      IN();
      i = 0;
      while (i < this.bPM.size())
      {
        this.bPM.set(i, u(i, true));
        i += 1;
      }
      this.bPM = Collections.unmodifiableList(this.bPM);
      this.cau = false;
      return this.bPM;
    }
  }
  
  public final int getCount()
  {
    return this.bPM.size();
  }
  
  public final boolean isEmpty()
  {
    return this.bPM.isEmpty();
  }
  
  final MType u(int paramInt, boolean paramBoolean)
  {
    if (this.cav == null) {
      return (a)this.bPM.get(paramInt);
    }
    cs localcs = (cs)this.cav.get(paramInt);
    if (localcs == null) {
      return (a)this.bPM.get(paramInt);
    }
    if (paramBoolean) {
      return localcs.IV();
    }
    return localcs.IU();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.b.co
 * JD-Core Version:    0.7.0.1
 */
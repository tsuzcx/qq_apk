package com.tencent.mm.cf.a;

import android.util.SparseArray;
import java.util.ArrayList;

public abstract class g<K, T extends a>
{
  public d uEU;
  
  public g(d paramd, int paramInt)
  {
    this.uEU = paramd;
    this.uEU.mD(true);
    this.uEU.a(new g.1(this));
    if (paramInt != 0) {
      this.uEU.FD(paramInt);
    }
    getCount();
  }
  
  public abstract ArrayList<T> ag(ArrayList<Object> paramArrayList);
  
  public final boolean bY(Object paramObject)
  {
    return this.uEU.bY(paramObject);
  }
  
  public final void c(Object paramObject, T paramT)
  {
    this.uEU.a(paramObject, paramT);
  }
  
  public final void close()
  {
    this.uEU.close();
    this.uEU = null;
  }
  
  public final SparseArray<K>[] cwY()
  {
    return this.uEU.cwY();
  }
  
  public final boolean cxa()
  {
    return this.uEU.cxa();
  }
  
  public abstract T cxk();
  
  public final int getCount()
  {
    return this.uEU.getCount();
  }
  
  public final boolean isClosed()
  {
    return this.uEU.isClosed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.cf.a.g
 * JD-Core Version:    0.7.0.1
 */
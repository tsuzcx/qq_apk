package com.tencent.mm.cg.a;

import android.util.SparseArray;
import java.util.ArrayList;

public abstract class g<K, T extends a>
{
  public d yRC;
  
  public g(d paramd, int paramInt)
  {
    this.yRC = paramd;
    this.yRC.pV(true);
    this.yRC.a(new g.1(this));
    if (paramInt != 0) {
      this.yRC.NN(paramInt);
    }
    getCount();
  }
  
  public abstract ArrayList<T> ap(ArrayList<Object> paramArrayList);
  
  public final void c(Object paramObject, T paramT)
  {
    this.yRC.a(paramObject, paramT);
  }
  
  public final boolean cD(Object paramObject)
  {
    return this.yRC.cD(paramObject);
  }
  
  public final void close()
  {
    this.yRC.close();
    this.yRC = null;
  }
  
  public final SparseArray<K>[] dzK()
  {
    return this.yRC.dzK();
  }
  
  public final boolean dzM()
  {
    return this.yRC.dzM();
  }
  
  public abstract T dzZ();
  
  public final int getCount()
  {
    return this.yRC.getCount();
  }
  
  public final boolean isClosed()
  {
    return this.yRC.isClosed();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.cg.a.g
 * JD-Core Version:    0.7.0.1
 */
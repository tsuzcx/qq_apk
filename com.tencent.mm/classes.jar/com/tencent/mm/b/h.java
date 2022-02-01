package com.tencent.mm.b;

import com.tencent.mm.sdk.platformtools.LruCache;

public class h<K, O>
  extends LruCache<K, O>
  implements f<K, O>
{
  private f.b<K, O> dgK = null;
  private f.c<K, O> dgL = null;
  
  public h(int paramInt)
  {
    super(paramInt);
  }
  
  public h(int paramInt, f.b<K, O> paramb)
  {
    super(paramInt);
    this.dgK = paramb;
  }
  
  public h(int paramInt, f.b<K, O> paramb, f.c<K, O> paramc)
  {
    super(paramInt);
    this.dgK = paramb;
    this.dgL = paramc;
  }
  
  public void a(f.a<K, O> parama)
  {
    clear();
  }
  
  public final O aT(K paramK)
  {
    return get(paramK);
  }
  
  public void clear()
  {
    trimToSize(-1);
  }
  
  public O create(K paramK)
  {
    return super.create(paramK);
  }
  
  public void entryRemoved(boolean paramBoolean, K paramK, O paramO1, O paramO2)
  {
    super.entryRemoved(paramBoolean, paramK, paramO1, paramO2);
    if (this.dgK != null) {
      this.dgK.c(paramK, paramO1, paramO2);
    }
  }
  
  public int sizeOf(K paramK, O paramO)
  {
    if (this.dgL != null) {
      return this.dgL.y(paramK, paramO);
    }
    return super.sizeOf(paramK, paramO);
  }
  
  public void trimToSize(int paramInt)
  {
    super.trimToSize(paramInt);
  }
  
  public final void x(K paramK, O paramO)
  {
    if ((paramO == null) || (paramK == null)) {
      return;
    }
    put(paramK, paramO);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.b.h
 * JD-Core Version:    0.7.0.1
 */
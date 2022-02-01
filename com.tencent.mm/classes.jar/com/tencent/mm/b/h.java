package com.tencent.mm.b;

import com.tencent.mm.sdk.platformtools.LruCache;

public class h<K, O>
  extends LruCache<K, O>
  implements f<K, O>
{
  private f.b<K, O> eYr = null;
  private f.c<K, O> eYs = null;
  
  public h(int paramInt)
  {
    super(paramInt);
  }
  
  public h(int paramInt, f.b<K, O> paramb)
  {
    super(paramInt);
    this.eYr = paramb;
  }
  
  public h(int paramInt, f.b<K, O> paramb, f.c<K, O> paramc)
  {
    super(paramInt);
    this.eYr = paramb;
    this.eYs = paramc;
  }
  
  public void a(f.a<K, O> parama)
  {
    clear();
  }
  
  public final O aX(K paramK)
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
    if (this.eYr != null) {
      this.eYr.preRemoveCallback(paramK, paramO1, paramO2);
    }
  }
  
  public final void q(K paramK, O paramO)
  {
    if ((paramO == null) || (paramK == null)) {
      return;
    }
    put(paramK, paramO);
  }
  
  public int sizeOf(K paramK, O paramO)
  {
    if (this.eYs != null) {
      return this.eYs.r(paramK, paramO);
    }
    return super.sizeOf(paramK, paramO);
  }
  
  public void trimToSize(int paramInt)
  {
    super.trimToSize(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.b.h
 * JD-Core Version:    0.7.0.1
 */
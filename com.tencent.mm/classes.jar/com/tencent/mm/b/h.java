package com.tencent.mm.b;

import com.tencent.mm.sdk.platformtools.LruCache;

public class h<K, O>
  extends LruCache<K, O>
  implements f<K, O>
{
  private f.b<K, O> hbR = null;
  private f.c<K, O> hbS = null;
  
  public h(int paramInt)
  {
    super(paramInt);
  }
  
  public h(int paramInt, f.b<K, O> paramb)
  {
    super(paramInt);
    this.hbR = paramb;
  }
  
  public h(int paramInt, f.b<K, O> paramb, f.c<K, O> paramc)
  {
    super(paramInt);
    this.hbR = paramb;
    this.hbS = paramc;
  }
  
  public final void B(K paramK, O paramO)
  {
    if ((paramO == null) || (paramK == null)) {
      return;
    }
    put(paramK, paramO);
  }
  
  public void a(f.a<K, O> parama)
  {
    clear();
  }
  
  public void clear()
  {
    trimToSize(-1);
  }
  
  public O create(K paramK)
  {
    return super.create(paramK);
  }
  
  public final O ct(K paramK)
  {
    return get(paramK);
  }
  
  public void entryRemoved(boolean paramBoolean, K paramK, O paramO1, O paramO2)
  {
    super.entryRemoved(paramBoolean, paramK, paramO1, paramO2);
    if (this.hbR != null) {
      this.hbR.preRemoveCallback(paramK, paramO1, paramO2);
    }
  }
  
  public int sizeOf(K paramK, O paramO)
  {
    if (this.hbS != null) {
      return this.hbS.C(paramK, paramO);
    }
    return super.sizeOf(paramK, paramO);
  }
  
  public void trimToSize(int paramInt)
  {
    super.trimToSize(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.b.h
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.b;

import com.tencent.mm.sdk.platformtools.af;

public class h<K, O>
  extends af<K, O>
  implements f<K, O>
{
  private f.b<K, O> cEB = null;
  private f.c<K, O> cEC = null;
  
  public h(int paramInt)
  {
    super(paramInt);
  }
  
  public h(int paramInt, f.b<K, O> paramb)
  {
    super(paramInt);
    this.cEB = paramb;
  }
  
  public h(int paramInt, f.b<K, O> paramb, f.c<K, O> paramc)
  {
    super(paramInt);
    this.cEB = paramb;
    this.cEC = paramc;
  }
  
  public void a(f.a<K, O> parama)
  {
    clear();
  }
  
  public final O aJ(K paramK)
  {
    return get(paramK);
  }
  
  public void clear()
  {
    super.trimToSize(-1);
  }
  
  public final O create(K paramK)
  {
    return super.create(paramK);
  }
  
  public void entryRemoved(boolean paramBoolean, K paramK, O paramO1, O paramO2)
  {
    super.entryRemoved(paramBoolean, paramK, paramO1, paramO2);
    if (this.cEB != null) {
      this.cEB.c(paramK, paramO1, paramO2);
    }
  }
  
  public final void o(K paramK, O paramO)
  {
    if ((paramO == null) || (paramK == null)) {
      return;
    }
    put(paramK, paramO);
  }
  
  public int sizeOf(K paramK, O paramO)
  {
    if (this.cEC != null) {
      return this.cEC.p(paramK, paramO);
    }
    return super.sizeOf(paramK, paramO);
  }
  
  public final void trimToSize(int paramInt)
  {
    super.trimToSize(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.b.h
 * JD-Core Version:    0.7.0.1
 */
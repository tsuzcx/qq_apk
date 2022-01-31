package com.tencent.mm.a;

import com.tencent.mm.sdk.platformtools.ae;

public class h<K, O>
  extends ae<K, O>
  implements f<K, O>
{
  private f.b<K, O> bVm = null;
  private f.c<K, O> bVn = null;
  
  public h(int paramInt)
  {
    super(paramInt);
  }
  
  public h(int paramInt, f.b<K, O> paramb)
  {
    super(paramInt);
    this.bVm = paramb;
  }
  
  public h(int paramInt, f.b<K, O> paramb, f.c<K, O> paramc)
  {
    super(paramInt);
    this.bVm = paramb;
    this.bVn = paramc;
  }
  
  public final O Y(K paramK)
  {
    return get(paramK);
  }
  
  public void a(f.a<K, O> parama)
  {
    clear();
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
    if (this.bVm != null) {
      this.bVm.c(paramK, paramO1, paramO2);
    }
  }
  
  public final void f(K paramK, O paramO)
  {
    if ((paramO == null) || (paramK == null)) {
      return;
    }
    put(paramK, paramO);
  }
  
  public int sizeOf(K paramK, O paramO)
  {
    if (this.bVn != null) {
      return this.bVn.g(paramK, paramO);
    }
    return super.sizeOf(paramK, paramO);
  }
  
  public final void trimToSize(int paramInt)
  {
    super.trimToSize(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.a.h
 * JD-Core Version:    0.7.0.1
 */
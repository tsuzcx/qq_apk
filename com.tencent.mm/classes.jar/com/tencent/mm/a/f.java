package com.tencent.mm.a;

import com.tencent.mm.sdk.platformtools.ab;

public class f<K, O>
  extends ab<K, O>
{
  private b<K, O> bub = null;
  
  public f(int paramInt)
  {
    super(paramInt);
  }
  
  public f(int paramInt, b<K, O> paramb)
  {
    super(paramInt);
    this.bub = paramb;
  }
  
  public void a(a<K, O> parama)
  {
    clear();
  }
  
  public void clear()
  {
    super.trimToSize(-1);
  }
  
  protected final O create(K paramK)
  {
    return super.create(paramK);
  }
  
  public void entryRemoved(boolean paramBoolean, K paramK, O paramO1, O paramO2)
  {
    super.entryRemoved(paramBoolean, paramK, paramO1, paramO2);
    if ((this.bub != null) && (paramO2 == null)) {
      this.bub.g(paramK, paramO1);
    }
  }
  
  public final void f(K paramK, O paramO)
  {
    if (paramO == null) {
      return;
    }
    put(paramK, paramO);
  }
  
  public int sizeOf(K paramK, O paramO)
  {
    return super.sizeOf(paramK, paramO);
  }
  
  public final void trimToSize(int paramInt)
  {
    super.trimToSize(paramInt);
  }
  
  public static abstract interface a<K, O> {}
  
  public static abstract interface b<K, O>
  {
    public abstract void g(K paramK, O paramO);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.a.f
 * JD-Core Version:    0.7.0.1
 */
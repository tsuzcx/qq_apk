package com.tencent.mapsdk.internal;

public abstract class jm<D extends jh>
  extends jf<D>
{
  private static b a = new jm.1();
  private c b;
  
  public jm(c paramc)
  {
    this.b = paramc;
  }
  
  public c g()
  {
    return this.b;
  }
  
  public static abstract interface b
  {
    public abstract String a(String paramString);
  }
  
  public static abstract class c
    implements jg.a
  {
    jm.a i;
    public int j = 104857600;
    public jm.b k = jm.i();
    
    public c(jm.a parama)
    {
      this.i = parama;
    }
    
    private c a(jm.b paramb)
    {
      this.k = paramb;
      return this;
    }
    
    private c b()
    {
      this.j = -1;
      return this;
    }
    
    private jm.a c()
    {
      return this.i;
    }
    
    private jm.b d()
    {
      return this.k;
    }
    
    public final int a()
    {
      return this.j;
    }
    
    public String toString()
    {
      return "Options{mType=" + this.i + ", mCacheSize=" + this.j + ", keyGenerator=" + this.k + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.jm
 * JD-Core Version:    0.7.0.1
 */
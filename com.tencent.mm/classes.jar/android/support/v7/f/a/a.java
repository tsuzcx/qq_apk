package android.support.v7.f.a;

import android.support.v7.h.c.c;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class a<T>
{
  public final c.c<T> adg;
  private final Executor dB;
  public final Executor eE;
  
  a(Executor paramExecutor1, Executor paramExecutor2, c.c<T> paramc)
  {
    this.dB = paramExecutor1;
    this.eE = paramExecutor2;
    this.adg = paramc;
  }
  
  public static final class a<T>
  {
    private static final Object adh = new Object();
    private static Executor adi = null;
    private final c.c<T> adg;
    private Executor dB;
    private Executor eE;
    
    public a(c.c<T> paramc)
    {
      this.adg = paramc;
    }
    
    public final a<T> hy()
    {
      if (this.eE == null) {}
      synchronized (adh)
      {
        if (adi == null) {
          adi = Executors.newFixedThreadPool(2);
        }
        this.eE = adi;
        return new a(this.dB, this.eE, this.adg);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     android.support.v7.f.a.a
 * JD-Core Version:    0.7.0.1
 */
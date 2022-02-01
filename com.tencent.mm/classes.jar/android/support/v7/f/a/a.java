package android.support.v7.f.a;

import android.support.v7.h.c.c;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class a<T>
{
  public final c.c<T> acT;
  private final Executor dC;
  public final Executor eF;
  
  a(Executor paramExecutor1, Executor paramExecutor2, c.c<T> paramc)
  {
    this.dC = paramExecutor1;
    this.eF = paramExecutor2;
    this.acT = paramc;
  }
  
  public static final class a<T>
  {
    private static final Object acU = new Object();
    private static Executor acV = null;
    private final c.c<T> acT;
    private Executor dC;
    private Executor eF;
    
    public a(c.c<T> paramc)
    {
      this.acT = paramc;
    }
    
    public final a<T> hp()
    {
      if (this.eF == null) {}
      synchronized (acU)
      {
        if (acV == null) {
          acV = Executors.newFixedThreadPool(2);
        }
        this.eF = acV;
        return new a(this.dC, this.eF, this.acT);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     android.support.v7.f.a.a
 * JD-Core Version:    0.7.0.1
 */
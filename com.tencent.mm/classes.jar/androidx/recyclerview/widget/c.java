package androidx.recyclerview.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class c<T>
{
  private final Executor bKN;
  public final Executor bUq;
  public final g.c<T> bUr;
  
  c(Executor paramExecutor1, Executor paramExecutor2, g.c<T> paramc)
  {
    this.bKN = paramExecutor1;
    this.bUq = paramExecutor2;
    this.bUr = paramc;
  }
  
  public static final class a<T>
  {
    private static final Object bUs;
    private static Executor bUt;
    private Executor bKN;
    private Executor bUq;
    private final g.c<T> bUr;
    
    static
    {
      AppMethodBeat.i(195000);
      bUs = new Object();
      bUt = null;
      AppMethodBeat.o(195000);
    }
    
    public a(g.c<T> paramc)
    {
      this.bUr = paramc;
    }
    
    public final c<T> IS()
    {
      AppMethodBeat.i(195009);
      if (this.bUq == null) {}
      synchronized (bUs)
      {
        if (bUt == null) {
          bUt = Executors.newFixedThreadPool(2);
        }
        this.bUq = bUt;
        ??? = new c(this.bKN, this.bUq, this.bUr);
        AppMethodBeat.o(195009);
        return ???;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.recyclerview.widget.c
 * JD-Core Version:    0.7.0.1
 */
package androidx.recyclerview.widget;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class c<T>
{
  final Executor acO;
  public final Executor adS;
  public final h.c<T> afK;
  
  c(Executor paramExecutor1, Executor paramExecutor2, h.c<T> paramc)
  {
    this.acO = paramExecutor1;
    this.adS = paramExecutor2;
    this.afK = paramc;
  }
  
  public static final class a<T>
  {
    private static final Object afL;
    private static Executor afM;
    private Executor acO;
    private Executor adS;
    private final h.c<T> afK;
    
    static
    {
      AppMethodBeat.i(260759);
      afL = new Object();
      afM = null;
      AppMethodBeat.o(260759);
    }
    
    public a(h.c<T> paramc)
    {
      this.afK = paramc;
    }
    
    public final c<T> kh()
    {
      AppMethodBeat.i(260755);
      if (this.adS == null) {}
      synchronized (afL)
      {
        if (afM == null) {
          afM = Executors.newFixedThreadPool(2);
        }
        this.adS = afM;
        ??? = new c(this.acO, this.adS, this.afK);
        AppMethodBeat.o(260755);
        return ???;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.recyclerview.widget.c
 * JD-Core Version:    0.7.0.1
 */
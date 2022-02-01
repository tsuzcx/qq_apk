package androidx.compose.runtime;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/AbstractApplier;", "T", "Landroidx/compose/runtime/Applier;", "root", "(Ljava/lang/Object;)V", "<set-?>", "current", "getCurrent", "()Ljava/lang/Object;", "setCurrent", "Ljava/lang/Object;", "getRoot", "stack", "", "clear", "", "down", "node", "onClear", "up", "move", "from", "", "to", "count", "remove", "index", "runtime_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a<T>
  implements d<T>
{
  public static final int Ue = 8;
  private final T alm;
  private final List<T> aln;
  private T alo;
  
  public a(T paramT)
  {
    this.alm = paramT;
    this.aln = ((List)new ArrayList());
    this.alo = this.alm;
  }
  
  public final void D(T paramT)
  {
    this.aln.add(this.alo);
    this.alo = paramT;
  }
  
  public final void clear()
  {
    this.aln.clear();
    this.alo = this.alm;
    nP();
  }
  
  public final T nM()
  {
    return this.alm;
  }
  
  public final T nN()
  {
    return this.alo;
  }
  
  public final void nO()
  {
    if (!((Collection)this.aln).isEmpty()) {}
    for (int i = 1; i == 0; i = 0) {
      throw ((Throwable)new IllegalStateException("Check failed.".toString()));
    }
    this.alo = this.aln.remove(this.aln.size() - 1);
  }
  
  protected abstract void nP();
  
  public final void nQ()
  {
    s.u(this, "this");
  }
  
  public void nR()
  {
    s.u(this, "this");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.a
 * JD-Core Version:    0.7.0.1
 */
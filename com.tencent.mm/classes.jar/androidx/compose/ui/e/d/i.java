package androidx.compose.ui.e.d;

import androidx.compose.ui.e.b.e;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/graphics/vector/VNode;", "", "()V", "invalidateListener", "Lkotlin/Function0;", "", "getInvalidateListener$ui_release", "()Lkotlin/jvm/functions/Function0;", "setInvalidateListener$ui_release", "(Lkotlin/jvm/functions/Function0;)V", "invalidate", "draw", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Landroidx/compose/ui/graphics/vector/VectorComponent;", "Landroidx/compose/ui/graphics/vector/PathComponent;", "Landroidx/compose/ui/graphics/vector/GroupComponent;", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class i
{
  public static final int Ue = 8;
  private a<ah> aAT;
  
  public abstract void c(e parame);
  
  public void i(a<ah> parama)
  {
    this.aAT = parama;
  }
  
  public final void invalidate()
  {
    a locala = uP();
    if (locala != null) {
      locala.invoke();
    }
  }
  
  public a<ah> uP()
  {
    return this.aAT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.e.d.i
 * JD-Core Version:    0.7.0.1
 */
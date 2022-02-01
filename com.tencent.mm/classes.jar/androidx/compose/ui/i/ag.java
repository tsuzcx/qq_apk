package androidx.compose.ui.i;

import androidx.compose.runtime.a;
import androidx.compose.runtime.a.e;
import androidx.compose.ui.platform.AndroidComposeView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/node/UiApplier;", "Landroidx/compose/runtime/AbstractApplier;", "Landroidx/compose/ui/node/LayoutNode;", "root", "(Landroidx/compose/ui/node/LayoutNode;)V", "insertBottomUp", "", "index", "", "instance", "insertTopDown", "move", "from", "to", "count", "onClear", "onEndChanges", "remove", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ag
  extends a<f>
{
  public ag(f paramf)
  {
    super(paramf);
    AppMethodBeat.i(204670);
    AppMethodBeat.o(204670);
  }
  
  public final void G(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(204673);
    ((f)nN()).ad(paramInt1, paramInt2);
    AppMethodBeat.o(204673);
  }
  
  public final void d(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(204677);
    ((f)nN()).n(paramInt1, paramInt2, paramInt3);
    AppMethodBeat.o(204677);
  }
  
  public final void nP()
  {
    AppMethodBeat.i(204683);
    f localf1 = (f)nM();
    int i;
    int j;
    if (localf1.aOl != null)
    {
      i = 1;
      j = localf1.aOh.size - 1;
      if (j < 0) {}
    }
    for (;;)
    {
      int k = j - 1;
      f localf2 = (f)localf1.aOh.aqq[j];
      if (i != 0) {
        localf2.xw();
      }
      localf2.aOk = null;
      if (k < 0)
      {
        localf1.aOh.clear();
        localf1.xv();
        localf1.aOg = 0;
        localf1.xq();
        AppMethodBeat.o(204683);
        return;
        i = 0;
        break;
      }
      j = k;
    }
  }
  
  public final void nR()
  {
    AppMethodBeat.i(204689);
    super.nR();
    Object localObject = ((f)nM()).aOl;
    if ((localObject instanceof AndroidComposeView)) {}
    for (localObject = (AndroidComposeView)localObject;; localObject = null)
    {
      if (localObject != null) {
        ((AndroidComposeView)localObject).yo();
      }
      AppMethodBeat.o(204689);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.i.ag
 * JD-Core Version:    0.7.0.1
 */
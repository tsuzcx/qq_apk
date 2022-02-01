package androidx.compose.ui.i;

import androidx.compose.runtime.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Comparator;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/node/OnPositionedDispatcher;", "", "()V", "layoutNodes", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/node/LayoutNode;", "dispatch", "", "dispatchHierarchy", "layoutNode", "onNodePositioned", "node", "onRootNodePositioned", "rootNode", "Companion", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class v
{
  public static final v.a aPW;
  final e<f> aPX;
  
  static
  {
    AppMethodBeat.i(204546);
    aPW = new v.a((byte)0);
    AppMethodBeat.o(204546);
  }
  
  public v()
  {
    AppMethodBeat.i(204543);
    this.aPX = new e(new f[16]);
    AppMethodBeat.o(204543);
  }
  
  final void w(f paramf)
  {
    AppMethodBeat.i(204551);
    paramf.xI();
    paramf.aOK = false;
    paramf = paramf.xr();
    int j = paramf.size;
    int i;
    if (j > 0)
    {
      paramf = paramf.aqq;
      i = 0;
    }
    for (;;)
    {
      w((f)paramf[i]);
      i += 1;
      if (i >= j)
      {
        AppMethodBeat.o(204551);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/node/OnPositionedDispatcher$Companion$DepthComparator;", "Ljava/util/Comparator;", "Landroidx/compose/ui/node/LayoutNode;", "Lkotlin/Comparator;", "()V", "compare", "", "a", "b", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
  static final class a$a
    implements Comparator<f>
  {
    public static final a aPY;
    
    static
    {
      AppMethodBeat.i(204644);
      aPY = new a();
      AppMethodBeat.o(204644);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.i.v
 * JD-Core Version:    0.7.0.1
 */
package androidx.compose.ui.platform;

import androidx.compose.ui.i.z;
import androidx.compose.ui.k.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/platform/ScrollObservationScope;", "Landroidx/compose/ui/node/OwnerScope;", "semanticsNodeId", "", "allScopes", "", "oldXValue", "", "oldYValue", "horizontalScrollAxisRange", "Landroidx/compose/ui/semantics/ScrollAxisRange;", "verticalScrollAxisRange", "(ILjava/util/List;Ljava/lang/Float;Ljava/lang/Float;Landroidx/compose/ui/semantics/ScrollAxisRange;Landroidx/compose/ui/semantics/ScrollAxisRange;)V", "getAllScopes", "()Ljava/util/List;", "getHorizontalScrollAxisRange", "()Landroidx/compose/ui/semantics/ScrollAxisRange;", "setHorizontalScrollAxisRange", "(Landroidx/compose/ui/semantics/ScrollAxisRange;)V", "isValid", "", "()Z", "getOldXValue", "()Ljava/lang/Float;", "setOldXValue", "(Ljava/lang/Float;)V", "Ljava/lang/Float;", "getOldYValue", "setOldYValue", "getSemanticsNodeId", "()I", "getVerticalScrollAxisRange", "setVerticalScrollAxisRange", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class al
  implements z
{
  final int aVa;
  private final List<al> aVb;
  Float aVc;
  Float aVd;
  h aVe;
  h aVf;
  
  public al(int paramInt, List<al> paramList)
  {
    AppMethodBeat.i(206721);
    this.aVa = paramInt;
    this.aVb = paramList;
    this.aVc = null;
    this.aVd = null;
    this.aVe = null;
    this.aVf = null;
    AppMethodBeat.o(206721);
  }
  
  public final boolean isValid()
  {
    AppMethodBeat.i(206726);
    boolean bool = this.aVb.contains(this);
    AppMethodBeat.o(206726);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.platform.al
 * JD-Core Version:    0.7.0.1
 */
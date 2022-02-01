package androidx.compose.foundation.c;

import androidx.compose.ui.a.c;
import androidx.compose.ui.f;
import androidx.compose.ui.f.c;
import androidx.compose.ui.h.w;
import androidx.compose.ui.h.w.a;
import androidx.compose.ui.platform.ad;
import androidx.compose.ui.platform.ae;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/foundation/layout/VerticalAlignModifier;", "Landroidx/compose/ui/layout/ParentDataModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "vertical", "Landroidx/compose/ui/Alignment$Vertical;", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Alignment$Vertical;Lkotlin/jvm/functions/Function1;)V", "getVertical", "()Landroidx/compose/ui/Alignment$Vertical;", "equals", "", "other", "", "hashCode", "", "toString", "", "modifyParentData", "Landroidx/compose/foundation/layout/RowColumnParentData;", "Landroidx/compose/ui/unit/Density;", "parentData", "foundation-layout_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ag
  extends ae
  implements w
{
  private final a.c acI;
  
  public ag(a.c paramc, b<? super ad, ah> paramb)
  {
    super(paramb);
    AppMethodBeat.i(203804);
    this.acI = paramc;
    AppMethodBeat.o(203804);
  }
  
  public final f a(f paramf)
  {
    AppMethodBeat.i(203876);
    paramf = w.a.a((w)this, paramf);
    AppMethodBeat.o(203876);
    return paramf;
  }
  
  public final <R> R a(R paramR, m<? super R, ? super f.c, ? extends R> paramm)
  {
    AppMethodBeat.i(203849);
    paramR = w.a.a((w)this, paramR, paramm);
    AppMethodBeat.o(203849);
    return paramR;
  }
  
  public final boolean a(b<? super f.c, Boolean> paramb)
  {
    AppMethodBeat.i(203868);
    boolean bool = w.a.a((w)this, paramb);
    AppMethodBeat.o(203868);
    return bool;
  }
  
  public final <R> R b(R paramR, m<? super f.c, ? super R, ? extends R> paramm)
  {
    AppMethodBeat.i(203858);
    paramR = w.a.b((w)this, paramR, paramm);
    AppMethodBeat.o(203858);
    return paramR;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(203814);
    if (this == paramObject)
    {
      AppMethodBeat.o(203814);
      return true;
    }
    if ((paramObject instanceof ag)) {}
    for (paramObject = (ag)paramObject; paramObject == null; paramObject = null)
    {
      AppMethodBeat.o(203814);
      return false;
    }
    boolean bool = s.p(this.acI, paramObject.acI);
    AppMethodBeat.o(203814);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(203824);
    int i = this.acI.hashCode();
    AppMethodBeat.o(203824);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(203841);
    String str = "VerticalAlignModifier(vertical=" + this.acI + ')';
    AppMethodBeat.o(203841);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.c.ag
 * JD-Core Version:    0.7.0.1
 */
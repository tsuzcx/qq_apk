package androidx.compose.foundation.c;

import androidx.compose.ui.a.b;
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

@Metadata(d1={""}, d2={"Landroidx/compose/foundation/layout/HorizontalAlignModifier;", "Landroidx/compose/ui/layout/ParentDataModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "horizontal", "Landroidx/compose/ui/Alignment$Horizontal;", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Alignment$Horizontal;Lkotlin/jvm/functions/Function1;)V", "getHorizontal", "()Landroidx/compose/ui/Alignment$Horizontal;", "equals", "", "other", "", "hashCode", "", "toString", "", "modifyParentData", "Landroidx/compose/foundation/layout/RowColumnParentData;", "Landroidx/compose/ui/unit/Density;", "parentData", "foundation-layout_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends ae
  implements w
{
  private final a.b acG;
  
  public l(a.b paramb, b<? super ad, ah> paramb1)
  {
    super(paramb1);
    AppMethodBeat.i(203954);
    this.acG = paramb;
    AppMethodBeat.o(203954);
  }
  
  public final f a(f paramf)
  {
    AppMethodBeat.i(204006);
    paramf = w.a.a((w)this, paramf);
    AppMethodBeat.o(204006);
    return paramf;
  }
  
  public final <R> R a(R paramR, m<? super R, ? super f.c, ? extends R> paramm)
  {
    AppMethodBeat.i(203979);
    paramR = w.a.a((w)this, paramR, paramm);
    AppMethodBeat.o(203979);
    return paramR;
  }
  
  public final boolean a(b<? super f.c, Boolean> paramb)
  {
    AppMethodBeat.i(203996);
    boolean bool = w.a.a((w)this, paramb);
    AppMethodBeat.o(203996);
    return bool;
  }
  
  public final <R> R b(R paramR, m<? super f.c, ? super R, ? extends R> paramm)
  {
    AppMethodBeat.i(203988);
    paramR = w.a.b((w)this, paramR, paramm);
    AppMethodBeat.o(203988);
    return paramR;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(203961);
    if (this == paramObject)
    {
      AppMethodBeat.o(203961);
      return true;
    }
    if ((paramObject instanceof l)) {}
    for (paramObject = (l)paramObject; paramObject == null; paramObject = null)
    {
      AppMethodBeat.o(203961);
      return false;
    }
    boolean bool = s.p(this.acG, paramObject.acG);
    AppMethodBeat.o(203961);
    return bool;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(203968);
    int i = this.acG.hashCode();
    AppMethodBeat.o(203968);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(203974);
    String str = "HorizontalAlignModifier(horizontal=" + this.acG + ')';
    AppMethodBeat.o(203974);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.c.l
 * JD-Core Version:    0.7.0.1
 */
package androidx.compose.foundation.c;

import androidx.compose.b.a.e..ExternalSyntheticBackport0;
import androidx.compose.ui.a;
import androidx.compose.ui.f;
import androidx.compose.ui.f.c;
import androidx.compose.ui.h.w;
import androidx.compose.ui.h.w.a;
import androidx.compose.ui.platform.ad;
import androidx.compose.ui.platform.ae;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/foundation/layout/BoxChildData;", "Landroidx/compose/ui/layout/ParentDataModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "alignment", "Landroidx/compose/ui/Alignment;", "matchParentSize", "", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Alignment;ZLkotlin/jvm/functions/Function1;)V", "getAlignment", "()Landroidx/compose/ui/Alignment;", "setAlignment", "(Landroidx/compose/ui/Alignment;)V", "getMatchParentSize", "()Z", "setMatchParentSize", "(Z)V", "equals", "other", "", "hashCode", "", "toString", "", "modifyParentData", "Landroidx/compose/ui/unit/Density;", "parentData", "foundation-layout_release"}, k=1, mv={1, 5, 1}, xi=48)
final class b
  extends ae
  implements w
{
  a SF;
  boolean acc;
  
  public b(a parama, kotlin.g.a.b<? super ad, ah> paramb)
  {
    super(paramb);
    AppMethodBeat.i(203969);
    this.SF = parama;
    this.acc = false;
    AppMethodBeat.o(203969);
  }
  
  public final f a(f paramf)
  {
    AppMethodBeat.i(204018);
    paramf = w.a.a((w)this, paramf);
    AppMethodBeat.o(204018);
    return paramf;
  }
  
  public final <R> R a(R paramR, m<? super R, ? super f.c, ? extends R> paramm)
  {
    AppMethodBeat.i(203994);
    paramR = w.a.a((w)this, paramR, paramm);
    AppMethodBeat.o(203994);
    return paramR;
  }
  
  public final boolean a(kotlin.g.a.b<? super f.c, Boolean> paramb)
  {
    AppMethodBeat.i(204009);
    boolean bool = w.a.a((w)this, paramb);
    AppMethodBeat.o(204009);
    return bool;
  }
  
  public final <R> R b(R paramR, m<? super f.c, ? super R, ? extends R> paramm)
  {
    AppMethodBeat.i(204000);
    paramR = w.a.b((w)this, paramR, paramm);
    AppMethodBeat.o(204000);
    return paramR;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(203975);
    if (this == paramObject)
    {
      AppMethodBeat.o(203975);
      return true;
    }
    if ((paramObject instanceof b)) {}
    for (paramObject = (b)paramObject; paramObject == null; paramObject = null)
    {
      AppMethodBeat.o(203975);
      return false;
    }
    if ((s.p(this.SF, paramObject.SF)) && (this.acc == paramObject.acc))
    {
      AppMethodBeat.o(203975);
      return true;
    }
    AppMethodBeat.o(203975);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(203980);
    int i = this.SF.hashCode();
    int j = e..ExternalSyntheticBackport0.m(this.acc);
    AppMethodBeat.o(203980);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(203987);
    String str = "BoxChildData(alignment=" + this.SF + ", matchParentSize=" + this.acc + ')';
    AppMethodBeat.o(203987);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.c.b
 * JD-Core Version:    0.7.0.1
 */
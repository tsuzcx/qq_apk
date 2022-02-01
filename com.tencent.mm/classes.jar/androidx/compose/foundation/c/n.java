package androidx.compose.foundation.c;

import androidx.compose.b.a.e..ExternalSyntheticBackport0;
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

@Metadata(d1={""}, d2={"Landroidx/compose/foundation/layout/LayoutWeightImpl;", "Landroidx/compose/ui/layout/ParentDataModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "weight", "", "fill", "", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(FZLkotlin/jvm/functions/Function1;)V", "getFill", "()Z", "getWeight", "()F", "equals", "other", "", "hashCode", "", "toString", "", "modifyParentData", "Landroidx/compose/foundation/layout/RowColumnParentData;", "Landroidx/compose/ui/unit/Density;", "parentData", "foundation-layout_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class n
  extends ae
  implements w
{
  private final boolean acS;
  private final float qL;
  
  public n(float paramFloat, boolean paramBoolean, b<? super ad, ah> paramb)
  {
    super(paramb);
    AppMethodBeat.i(203924);
    this.qL = paramFloat;
    this.acS = true;
    AppMethodBeat.o(203924);
  }
  
  public final f a(f paramf)
  {
    AppMethodBeat.i(203950);
    paramf = w.a.a((w)this, paramf);
    AppMethodBeat.o(203950);
    return paramf;
  }
  
  public final <R> R a(R paramR, m<? super R, ? super f.c, ? extends R> paramm)
  {
    AppMethodBeat.i(203938);
    paramR = w.a.a((w)this, paramR, paramm);
    AppMethodBeat.o(203938);
    return paramR;
  }
  
  public final boolean a(b<? super f.c, Boolean> paramb)
  {
    AppMethodBeat.i(203945);
    boolean bool = w.a.a((w)this, paramb);
    AppMethodBeat.o(203945);
    return bool;
  }
  
  public final <R> R b(R paramR, m<? super f.c, ? super R, ? extends R> paramm)
  {
    AppMethodBeat.i(203941);
    paramR = w.a.b((w)this, paramR, paramm);
    AppMethodBeat.o(203941);
    return paramR;
  }
  
  public final boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    for (;;)
    {
      return true;
      if ((paramObject instanceof n)) {}
      for (paramObject = (n)paramObject; paramObject == null; paramObject = null) {
        return false;
      }
      if (this.qL == paramObject.qL) {}
      for (int i = 1; (i != 0) || (this.acS == paramObject.acS); i = 0) {
        return false;
      }
    }
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(203931);
    int i = Float.floatToIntBits(this.qL);
    int j = e..ExternalSyntheticBackport0.m(this.acS);
    AppMethodBeat.o(203931);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(203932);
    String str = "LayoutWeightImpl(weight=" + this.qL + ", fill=" + this.acS + ')';
    AppMethodBeat.o(203932);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.c.n
 * JD-Core Version:    0.7.0.1
 */
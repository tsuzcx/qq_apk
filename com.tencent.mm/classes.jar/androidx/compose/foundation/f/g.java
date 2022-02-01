package androidx.compose.foundation.f;

import androidx.compose.ui.m.a;
import androidx.compose.ui.m.a.a;
import androidx.compose.ui.m.b.c.a;
import androidx.compose.ui.m.e;
import androidx.compose.ui.m.u;
import androidx.compose.ui.n.d;
import androidx.compose.ui.n.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/foundation/text/TextDelegate;", "", "text", "Landroidx/compose/ui/text/AnnotatedString;", "style", "Landroidx/compose/ui/text/TextStyle;", "maxLines", "", "softWrap", "", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "density", "Landroidx/compose/ui/unit/Density;", "resourceLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "placeholders", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/Placeholder;", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/text/TextStyle;IZILandroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/font/Font$ResourceLoader;Ljava/util/List;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getDensity", "()Landroidx/compose/ui/unit/Density;", "intrinsicsLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getIntrinsicsLayoutDirection$foundation_release", "()Landroidx/compose/ui/unit/LayoutDirection;", "setIntrinsicsLayoutDirection$foundation_release", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "maxIntrinsicWidth", "getMaxIntrinsicWidth", "()I", "getMaxLines", "minIntrinsicWidth", "getMinIntrinsicWidth", "nonNullIntrinsics", "Landroidx/compose/ui/text/MultiParagraphIntrinsics;", "getNonNullIntrinsics", "()Landroidx/compose/ui/text/MultiParagraphIntrinsics;", "getOverflow-gIe3tQ8", "I", "paragraphIntrinsics", "getParagraphIntrinsics$foundation_release", "setParagraphIntrinsics$foundation_release", "(Landroidx/compose/ui/text/MultiParagraphIntrinsics;)V", "getPlaceholders", "()Ljava/util/List;", "getResourceLoader", "()Landroidx/compose/ui/text/font/Font$ResourceLoader;", "getSoftWrap", "()Z", "getStyle", "()Landroidx/compose/ui/text/TextStyle;", "getText", "()Landroidx/compose/ui/text/AnnotatedString;", "layout", "Landroidx/compose/ui/text/TextLayoutResult;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "layoutDirection", "prevResult", "layout-NN6Ew-U", "(JLandroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/text/TextLayoutResult;)Landroidx/compose/ui/text/TextLayoutResult;", "layoutIntrinsics", "", "layoutText", "Landroidx/compose/ui/text/MultiParagraph;", "layoutText-K40F9xA", "(JLandroidx/compose/ui/unit/LayoutDirection;)Landroidx/compose/ui/text/MultiParagraph;", "Companion", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
{
  public static final g.a ahl;
  final d TD;
  final a ahm;
  final u ahn;
  final boolean aho;
  final int ahp;
  final c.a ahq;
  final List<a.a<Object>> ahr;
  e ahs;
  n aht;
  final int maxLines;
  
  static
  {
    AppMethodBeat.i(203736);
    ahl = new g.a((byte)0);
    AppMethodBeat.o(203736);
  }
  
  private g(a parama, u paramu, int paramInt1, boolean paramBoolean, int paramInt2, d paramd, c.a parama1, List<a.a<Object>> paramList)
  {
    AppMethodBeat.i(203728);
    this.ahm = parama;
    this.ahn = paramu;
    this.maxLines = paramInt1;
    this.aho = paramBoolean;
    this.ahp = paramInt2;
    this.TD = paramd;
    this.ahq = parama1;
    this.ahr = paramList;
    if (this.maxLines > 0) {}
    for (paramInt1 = 1; paramInt1 == 0; paramInt1 = 0)
    {
      parama = (Throwable)new IllegalStateException("Check failed.".toString());
      AppMethodBeat.o(203728);
      throw parama;
    }
    AppMethodBeat.o(203728);
  }
  
  final e mY()
  {
    AppMethodBeat.i(203742);
    Object localObject = this.ahs;
    if (localObject == null)
    {
      localObject = new IllegalStateException("layoutForIntrinsics must be called first");
      AppMethodBeat.o(203742);
      throw ((Throwable)localObject);
    }
    AppMethodBeat.o(203742);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.f.g
 * JD-Core Version:    0.7.0.1
 */
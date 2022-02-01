package androidx.compose.ui.m.a;

import android.text.BoringLayout.Metrics;
import android.text.TextPaint;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;
import kotlin.o;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/android/LayoutIntrinsics;", "", "charSequence", "", "textPaint", "Landroid/text/TextPaint;", "textDirectionHeuristic", "", "(Ljava/lang/CharSequence;Landroid/text/TextPaint;I)V", "boringMetrics", "Landroid/text/BoringLayout$Metrics;", "getBoringMetrics", "()Landroid/text/BoringLayout$Metrics;", "boringMetrics$delegate", "Lkotlin/Lazy;", "maxIntrinsicWidth", "", "getMaxIntrinsicWidth", "()F", "maxIntrinsicWidth$delegate", "minIntrinsicWidth", "getMinIntrinsicWidth", "minIntrinsicWidth$delegate", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public final j aYT;
  private final j aYU;
  private final j baN;
  
  public c(final CharSequence paramCharSequence, final TextPaint paramTextPaint, int paramInt)
  {
    AppMethodBeat.i(205175);
    this.baN = k.a(o.aiuH, (a)new a(paramInt, paramCharSequence, paramTextPaint));
    this.aYT = k.a(o.aiuH, (a)new c(paramCharSequence, paramTextPaint));
    this.aYU = k.a(o.aiuH, (a)new b(this, paramCharSequence, paramTextPaint));
    AppMethodBeat.o(205175);
  }
  
  public final float AG()
  {
    AppMethodBeat.i(205187);
    float f = ((Number)this.aYU.getValue()).floatValue();
    AppMethodBeat.o(205187);
    return f;
  }
  
  public final BoringLayout.Metrics AU()
  {
    AppMethodBeat.i(205181);
    BoringLayout.Metrics localMetrics = (BoringLayout.Metrics)this.baN.getValue();
    AppMethodBeat.o(205181);
    return localMetrics;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/text/BoringLayout$Metrics;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<BoringLayout.Metrics>
  {
    a(int paramInt, CharSequence paramCharSequence, TextPaint paramTextPaint)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<Float>
  {
    b(c paramc, CharSequence paramCharSequence, TextPaint paramTextPaint)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<Float>
  {
    c(CharSequence paramCharSequence, TextPaint paramTextPaint)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.a.c
 * JD-Core Version:    0.7.0.1
 */
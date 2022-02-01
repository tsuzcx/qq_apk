package androidx.compose.ui.m.a;

import android.text.BoringLayout;
import android.text.BoringLayout.Metrics;
import android.text.Layout.Alignment;
import android.text.TextDirectionHeuristic;
import android.text.TextPaint;
import android.text.TextUtils.TruncateAt;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/android/BoringLayoutFactory;", "", "()V", "create", "Landroid/text/BoringLayout;", "text", "", "paint", "Landroid/text/TextPaint;", "width", "", "metrics", "Landroid/text/BoringLayout$Metrics;", "alignment", "Landroid/text/Layout$Alignment;", "includePadding", "", "ellipsize", "Landroid/text/TextUtils$TruncateAt;", "ellipsizedWidth", "measure", "textDir", "Landroid/text/TextDirectionHeuristic;", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a baJ;
  
  static
  {
    AppMethodBeat.i(205241);
    baJ = new a();
    AppMethodBeat.o(205241);
  }
  
  public static BoringLayout.Metrics a(CharSequence paramCharSequence, TextPaint paramTextPaint, TextDirectionHeuristic paramTextDirectionHeuristic)
  {
    AppMethodBeat.i(205228);
    s.u(paramCharSequence, "text");
    s.u(paramTextDirectionHeuristic, "textDir");
    if (!paramTextDirectionHeuristic.isRtl(paramCharSequence, 0, paramCharSequence.length()))
    {
      paramCharSequence = BoringLayout.isBoring(paramCharSequence, paramTextPaint, null);
      AppMethodBeat.o(205228);
      return paramCharSequence;
    }
    AppMethodBeat.o(205228);
    return null;
  }
  
  public static BoringLayout a(CharSequence paramCharSequence, TextPaint paramTextPaint, int paramInt1, BoringLayout.Metrics paramMetrics, Layout.Alignment paramAlignment, boolean paramBoolean, TextUtils.TruncateAt paramTruncateAt, int paramInt2)
  {
    AppMethodBeat.i(205234);
    s.u(paramCharSequence, "text");
    s.u(paramTextPaint, "paint");
    s.u(paramMetrics, "metrics");
    s.u(paramAlignment, "alignment");
    if (paramInt1 >= 0) {}
    for (int i = 1; i == 0; i = 0)
    {
      paramCharSequence = (Throwable)new IllegalArgumentException("Failed requirement.".toString());
      AppMethodBeat.o(205234);
      throw paramCharSequence;
    }
    if (paramInt2 >= 0) {}
    for (i = 1; i == 0; i = 0)
    {
      paramCharSequence = (Throwable)new IllegalArgumentException("Failed requirement.".toString());
      AppMethodBeat.o(205234);
      throw paramCharSequence;
    }
    if (paramTruncateAt == null)
    {
      paramCharSequence = new BoringLayout(paramCharSequence, paramTextPaint, paramInt1, paramAlignment, 1.0F, 0.0F, paramMetrics, true);
      AppMethodBeat.o(205234);
      return paramCharSequence;
    }
    paramCharSequence = new BoringLayout(paramCharSequence, paramTextPaint, paramInt1, paramAlignment, 1.0F, 0.0F, paramMetrics, true, paramTruncateAt, paramInt2);
    AppMethodBeat.o(205234);
    return paramCharSequence;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.a.a
 * JD-Core Version:    0.7.0.1
 */
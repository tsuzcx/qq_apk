package androidx.compose.ui.m.a;

import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/android/StaticLayoutFactory;", "", "()V", "delegate", "Landroidx/compose/ui/text/android/StaticLayoutFactoryImpl;", "create", "Landroid/text/StaticLayout;", "text", "", "start", "", "end", "paint", "Landroid/text/TextPaint;", "width", "textDir", "Landroid/text/TextDirectionHeuristic;", "alignment", "Landroid/text/Layout$Alignment;", "maxLines", "ellipsize", "Landroid/text/TextUtils$TruncateAt;", "ellipsizedWidth", "lineSpacingMultiplier", "", "lineSpacingExtra", "justificationMode", "includePadding", "", "useFallbackLineSpacing", "breakStrategy", "hyphenationFrequency", "leftIndents", "", "rightIndents", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final f baT;
  private static final j baU;
  
  static
  {
    AppMethodBeat.i(205196);
    baT = new f();
    if (Build.VERSION.SDK_INT >= 23) {}
    for (j localj = (j)new g();; localj = (j)new k())
    {
      baU = localj;
      AppMethodBeat.o(205196);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.a.f
 * JD-Core Version:    0.7.0.1
 */
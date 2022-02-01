package androidx.compose.ui.m.a.b;

import android.text.TextPaint;
import android.text.style.CharacterStyle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/text/android/style/TextDecorationSpan;", "Landroid/text/style/CharacterStyle;", "isUnderlineText", "", "isStrikethroughText", "(ZZ)V", "()Z", "updateDrawState", "", "textPaint", "Landroid/text/TextPaint;", "ui-text_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class i
  extends CharacterStyle
{
  private final boolean bbM;
  private final boolean bbN;
  
  public i(boolean paramBoolean1, boolean paramBoolean2)
  {
    this.bbM = paramBoolean1;
    this.bbN = paramBoolean2;
  }
  
  public final void updateDrawState(TextPaint paramTextPaint)
  {
    AppMethodBeat.i(205221);
    s.u(paramTextPaint, "textPaint");
    paramTextPaint.setUnderlineText(this.bbM);
    paramTextPaint.setStrikeThruText(this.bbN);
    AppMethodBeat.o(205221);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.m.a.b.i
 * JD-Core Version:    0.7.0.1
 */
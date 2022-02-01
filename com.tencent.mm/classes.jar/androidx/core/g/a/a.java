package androidx.core.g.a;

import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a
  extends ClickableSpan
{
  private final int Oq;
  private final d Os;
  private final int Ot;
  
  public a(int paramInt1, d paramd, int paramInt2)
  {
    this.Oq = paramInt1;
    this.Os = paramd;
    this.Ot = paramInt2;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(252011);
    paramView = new Bundle();
    paramView.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.Oq);
    d locald = this.Os;
    int i = this.Ot;
    if (Build.VERSION.SDK_INT >= 16) {
      locald.Ov.performAction(i, paramView);
    }
    AppMethodBeat.o(252011);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.core.g.a.a
 * JD-Core Version:    0.7.0.1
 */
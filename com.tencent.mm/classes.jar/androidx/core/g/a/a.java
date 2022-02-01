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
  private final int buK;
  private final d buL;
  private final int buM;
  
  public a(int paramInt1, d paramd, int paramInt2)
  {
    this.buK = paramInt1;
    this.buL = paramd;
    this.buM = paramInt2;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(195978);
    paramView = new Bundle();
    paramView.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.buK);
    d locald = this.buL;
    int i = this.buM;
    if (Build.VERSION.SDK_INT >= 16) {
      locald.buO.performAction(i, paramView);
    }
    AppMethodBeat.o(195978);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.core.g.a.a
 * JD-Core Version:    0.7.0.1
 */
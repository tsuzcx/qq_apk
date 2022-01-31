package com.tencent.mm.plugin.appbrand.widget.input;

import android.text.SpanWatcher;
import android.text.Spannable;
import com.tencent.mm.sdk.platformtools.ah;

final class y$2
  implements SpanWatcher
{
  y$2(y paramy) {}
  
  public final void onSpanAdded(Spannable paramSpannable, Object paramObject, int paramInt1, int paramInt2)
  {
    if (ai.be(paramObject)) {
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.EditTextComposingTextDismissedObserver", "[bindInput] onSpanAdded %s, %s", new Object[] { paramSpannable, paramObject.getClass().getSimpleName() });
    }
  }
  
  public final void onSpanChanged(Spannable paramSpannable, Object paramObject, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (ai.be(paramObject)) {
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.EditTextComposingTextDismissedObserver", "[bindInput] onSpanChanged %s, %s", new Object[] { paramSpannable, paramObject.getClass().getSimpleName() });
    }
  }
  
  public final void onSpanRemoved(Spannable paramSpannable, Object paramObject, int paramInt1, int paramInt2)
  {
    if (ai.be(paramObject))
    {
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.EditTextComposingTextDismissedObserver", "[bindInput] onSpanRemoved %s, %s", new Object[] { paramSpannable, paramObject.getClass().getSimpleName() });
      this.hvH.hcZ.removeCallbacks(this.hvH.hvG);
      this.hvH.hcZ.postDelayed(this.hvH.hvG, 100L);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.y.2
 * JD-Core Version:    0.7.0.1
 */
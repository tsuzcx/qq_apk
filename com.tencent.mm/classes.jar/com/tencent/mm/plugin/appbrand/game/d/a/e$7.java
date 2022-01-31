package com.tencent.mm.plugin.appbrand.game.d.a;

import android.view.KeyEvent;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import com.tencent.mm.plugin.appbrand.game.widget.input.WAGamePanelInputEditText;
import com.tencent.mm.plugin.appbrand.p;

final class e$7
  implements TextView.OnEditorActionListener
{
  e$7(e parame, boolean paramBoolean, WAGamePanelInputEditText paramWAGamePanelInputEditText, p paramp) {}
  
  public final boolean onEditorAction(TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.gcj)
    {
      this.gcl.gcf.a(this.gcm.getEditableText().toString(), this.gbW);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.d.a.e.7
 * JD-Core Version:    0.7.0.1
 */
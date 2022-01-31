package com.tencent.mm.plugin.appbrand.game.widget.input;

import android.text.Editable;
import android.text.Editable.Factory;
import com.tencent.mm.plugin.appbrand.widget.input.y;

final class WAGamePanelInputEditText$1
  extends Editable.Factory
{
  WAGamePanelInputEditText$1(WAGamePanelInputEditText paramWAGamePanelInputEditText) {}
  
  public final Editable newEditable(CharSequence paramCharSequence)
  {
    return WAGamePanelInputEditText.a(this.gdC).c((Editable)WAGamePanelInputEditText.a(this.gdC, super.newEditable(paramCharSequence)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.widget.input.WAGamePanelInputEditText.1
 * JD-Core Version:    0.7.0.1
 */
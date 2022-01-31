package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

final class a$2
  implements CompoundButton.OnCheckedChangeListener
{
  a$2(a parama) {}
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (a.b(this.heZ) != null) {
      a.b(this.heZ).setEnabled(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.autofill.a.2
 * JD-Core Version:    0.7.0.1
 */
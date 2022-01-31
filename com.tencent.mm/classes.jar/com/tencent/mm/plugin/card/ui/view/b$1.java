package com.tencent.mm.plugin.card.ui.view;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import com.tencent.mm.plugin.card.b.f;

final class b$1
  implements View.OnClickListener
{
  b$1(b paramb, f paramf) {}
  
  public final void onClick(View paramView)
  {
    if (((CheckBox)paramView).isChecked())
    {
      this.ixL.azW().ilC = true;
      return;
    }
    this.ixL.azW().ilC = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.view.b.1
 * JD-Core Version:    0.7.0.1
 */
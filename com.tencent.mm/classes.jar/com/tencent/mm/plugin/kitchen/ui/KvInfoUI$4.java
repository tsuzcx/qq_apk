package com.tencent.mm.plugin.kitchen.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

final class KvInfoUI$4
  implements View.OnClickListener
{
  KvInfoUI$4(KvInfoUI paramKvInfoUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = KvInfoUI.a(this.lAA).getText().toString().trim();
    KvInfoUI.a(this.lAA, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.kitchen.ui.KvInfoUI.4
 * JD-Core Version:    0.7.0.1
 */
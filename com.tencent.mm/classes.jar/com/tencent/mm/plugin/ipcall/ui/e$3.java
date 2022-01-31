package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

final class e$3
  implements View.OnClickListener
{
  e$3(e parame) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.lup.lui, IPCallDialUI.class);
    paramView.putExtra("IPCallTalkUI_dialScene", 1);
    this.lup.lui.startActivityForResult(paramView, 1001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.e.3
 * JD-Core Version:    0.7.0.1
 */
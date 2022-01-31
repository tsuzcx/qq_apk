package com.tencent.mm.plugin.clean.ui.newui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

final class CleanChattingUI$2
  implements AdapterView.OnItemClickListener
{
  CleanChattingUI$2(CleanChattingUI paramCleanChattingUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = new Intent(this.iEe, CleanChattingDetailUI.class);
    paramAdapterView.putExtra("key_position", paramInt);
    this.iEe.startActivityForResult(paramAdapterView, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.clean.ui.newui.CleanChattingUI.2
 * JD-Core Version:    0.7.0.1
 */
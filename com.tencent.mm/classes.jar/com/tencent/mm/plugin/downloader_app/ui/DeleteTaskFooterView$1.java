package com.tencent.mm.plugin.downloader_app.ui;

import android.content.Context;
import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.downloader_app.b.b;
import com.tencent.mm.plugin.downloader_app.b.d;
import com.tencent.mm.plugin.downloader_app.b.d.c;

final class DeleteTaskFooterView$1
  implements d.c
{
  DeleteTaskFooterView$1(DeleteTaskFooterView paramDeleteTaskFooterView) {}
  
  public final void eV(boolean paramBoolean)
  {
    DeleteTaskFooterView localDeleteTaskFooterView = this.iTk;
    if (paramBoolean)
    {
      localDeleteTaskFooterView.iTf.setClickable(true);
      localDeleteTaskFooterView.iTh.setImageResource(b.d.task_delete_able);
      localDeleteTaskFooterView.iTg.setTextColor(localDeleteTaskFooterView.getContext().getResources().getColor(b.b.item_name_color));
      return;
    }
    localDeleteTaskFooterView.iTf.setClickable(false);
    localDeleteTaskFooterView.iTh.setImageResource(b.d.task_delete_disable);
    localDeleteTaskFooterView.iTg.setTextColor(localDeleteTaskFooterView.getContext().getResources().getColor(b.b.item_desc_color));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.DeleteTaskFooterView.1
 * JD-Core Version:    0.7.0.1
 */
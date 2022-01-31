package com.tencent.mm.plugin.downloader_app.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mm.plugin.downloader_app.b.d;

final class DeleteTaskFooterView$2
  implements View.OnClickListener
{
  DeleteTaskFooterView$2(DeleteTaskFooterView paramDeleteTaskFooterView) {}
  
  public final void onClick(View paramView)
  {
    if (DeleteTaskFooterView.a(this.iTk))
    {
      DeleteTaskFooterView.a(this.iTk, false);
      DeleteTaskFooterView.b(this.iTk).setImageResource(b.d.check_box_unselected);
    }
    for (;;)
    {
      if (DeleteTaskFooterView.c(this.iTk)) {
        DeleteTaskFooterView.eW(DeleteTaskFooterView.a(this.iTk));
      }
      DeleteTaskFooterView.d(this.iTk);
      return;
      DeleteTaskFooterView.a(this.iTk, true);
      DeleteTaskFooterView.b(this.iTk).setImageResource(b.d.check_box_selected);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.DeleteTaskFooterView.2
 * JD-Core Version:    0.7.0.1
 */
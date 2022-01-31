package com.tencent.mm.plugin.downloader_app.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class DeleteTaskFooterView$2
  implements View.OnClickListener
{
  DeleteTaskFooterView$2(DeleteTaskFooterView paramDeleteTaskFooterView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(136216);
    if (DeleteTaskFooterView.a(this.lbZ))
    {
      DeleteTaskFooterView.a(this.lbZ, false);
      DeleteTaskFooterView.b(this.lbZ).setImageResource(2130838379);
    }
    for (;;)
    {
      if (DeleteTaskFooterView.c(this.lbZ)) {
        DeleteTaskFooterView.gz(DeleteTaskFooterView.a(this.lbZ));
      }
      DeleteTaskFooterView.d(this.lbZ);
      AppMethodBeat.o(136216);
      return;
      DeleteTaskFooterView.a(this.lbZ, true);
      DeleteTaskFooterView.b(this.lbZ).setImageResource(2130838378);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.DeleteTaskFooterView.2
 * JD-Core Version:    0.7.0.1
 */
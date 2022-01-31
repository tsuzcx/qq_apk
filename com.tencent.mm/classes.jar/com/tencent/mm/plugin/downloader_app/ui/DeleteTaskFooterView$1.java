package com.tencent.mm.plugin.downloader_app.ui;

import android.content.Context;
import android.content.res.Resources;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader_app.b.d.c;

final class DeleteTaskFooterView$1
  implements d.c
{
  DeleteTaskFooterView$1(DeleteTaskFooterView paramDeleteTaskFooterView) {}
  
  public final void gy(boolean paramBoolean)
  {
    AppMethodBeat.i(136215);
    DeleteTaskFooterView localDeleteTaskFooterView = this.lbZ;
    if (paramBoolean)
    {
      localDeleteTaskFooterView.lbU.setClickable(true);
      localDeleteTaskFooterView.lbW.setImageResource(2130840544);
      localDeleteTaskFooterView.lbV.setTextColor(localDeleteTaskFooterView.getContext().getResources().getColor(2131690194));
      AppMethodBeat.o(136215);
      return;
    }
    localDeleteTaskFooterView.lbU.setClickable(false);
    localDeleteTaskFooterView.lbW.setImageResource(2130840545);
    localDeleteTaskFooterView.lbV.setTextColor(localDeleteTaskFooterView.getContext().getResources().getColor(2131690193));
    AppMethodBeat.o(136215);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.DeleteTaskFooterView.1
 * JD-Core Version:    0.7.0.1
 */
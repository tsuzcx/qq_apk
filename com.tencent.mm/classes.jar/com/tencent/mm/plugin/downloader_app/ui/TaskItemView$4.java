package com.tencent.mm.plugin.downloader_app.ui;

import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader_app.b.c;
import com.tencent.mm.plugin.downloader_app.b.i;
import com.tencent.mm.vfs.e;

final class TaskItemView$4
  implements View.OnClickListener
{
  TaskItemView$4(TaskItemView paramTaskItemView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(136265);
    if (TaskItemView.a(this.lcM).type == 6)
    {
      c.c(this.lcM.getContext(), TaskItemView.a(this.lcM));
      AppMethodBeat.o(136265);
      return;
    }
    paramView = d.JD(TaskItemView.a(this.lcM).appId);
    if (paramView != null)
    {
      if (TaskItemView.c(this.lcM).getText().equals(this.lcM.getResources().getString(2131304771)))
      {
        c.a(this.lcM.getContext(), paramView.field_downloadId, new TaskItemView.4.1(this));
        AppMethodBeat.o(136265);
        return;
      }
      if (TaskItemView.c(this.lcM).getText().equals(this.lcM.getResources().getString(2131300740)))
      {
        c.b(this.lcM.getContext(), TaskItemView.a(this.lcM));
        AppMethodBeat.o(136265);
        return;
      }
      if (TaskItemView.c(this.lcM).getText().equals(this.lcM.getResources().getString(2131301541)))
      {
        if (!e.cN(paramView.field_filePath))
        {
          c.a(this.lcM.getContext(), TaskItemView.a(this.lcM));
          AppMethodBeat.o(136265);
        }
      }
      else
      {
        c.a(this.lcM.getContext(), TaskItemView.a(this.lcM));
        AppMethodBeat.o(136265);
      }
    }
    else
    {
      c.a(this.lcM.getContext(), TaskItemView.a(this.lcM));
    }
    AppMethodBeat.o(136265);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.TaskItemView.4
 * JD-Core Version:    0.7.0.1
 */
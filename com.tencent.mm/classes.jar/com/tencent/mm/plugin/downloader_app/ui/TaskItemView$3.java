package com.tencent.mm.plugin.downloader_app.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.g.a;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader_app.b.c;
import com.tencent.mm.plugin.downloader_app.b.i;

final class TaskItemView$3
  implements View.OnClickListener
{
  TaskItemView$3(TaskItemView paramTaskItemView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(136263);
    if (d.JD(TaskItemView.a(this.lcM).appId).field_status == 1)
    {
      c.a(TaskItemView.a(this.lcM));
      AppMethodBeat.o(136263);
      return;
    }
    c.a(this.lcM.getContext(), TaskItemView.a(this.lcM), new TaskItemView.3.1(this));
    AppMethodBeat.o(136263);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.TaskItemView.3
 * JD-Core Version:    0.7.0.1
 */
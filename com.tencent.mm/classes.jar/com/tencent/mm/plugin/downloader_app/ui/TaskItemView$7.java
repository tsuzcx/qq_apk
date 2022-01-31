package com.tencent.mm.plugin.downloader_app.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader_app.b.i;
import com.tencent.mm.plugin.downloader_app.c.a;

final class TaskItemView$7
  implements View.OnClickListener
{
  TaskItemView$7(TaskItemView paramTaskItemView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(136268);
    TaskItemView.a(this.lcM, true);
    TaskItemView.g(this.lcM).setMaxLines(2147483647);
    TaskItemView.e(this.lcM).setVisibility(0);
    TaskItemView.d(this.lcM).setVisibility(8);
    a.a(10, 1003, 0, 2, TaskItemView.a(this.lcM).appId, "", "");
    AppMethodBeat.o(136268);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.TaskItemView.7
 * JD-Core Version:    0.7.0.1
 */
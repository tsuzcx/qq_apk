package com.tencent.mm.plugin.downloader_app.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class TaskItemView$6
  implements View.OnClickListener
{
  TaskItemView$6(TaskItemView paramTaskItemView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(136267);
    TaskItemView.a(this.lcM, false);
    TaskItemView.g(this.lcM).setMaxLines(2);
    TaskItemView.e(this.lcM).setVisibility(8);
    TaskItemView.d(this.lcM).setVisibility(0);
    AppMethodBeat.o(136267);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.TaskItemView.6
 * JD-Core Version:    0.7.0.1
 */
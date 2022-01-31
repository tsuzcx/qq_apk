package com.tencent.mm.plugin.downloader_app.ui;

import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class TaskItemView$5
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  TaskItemView$5(TaskItemView paramTaskItemView) {}
  
  public final void onGlobalLayout()
  {
    AppMethodBeat.i(136266);
    if (TaskItemView.d(this.lcM).getLineCount() <= 2)
    {
      TaskItemView.e(this.lcM).setVisibility(8);
      TaskItemView.d(this.lcM).setVisibility(8);
      AppMethodBeat.o(136266);
      return;
    }
    if (TaskItemView.f(this.lcM))
    {
      TaskItemView.e(this.lcM).setVisibility(8);
      TaskItemView.d(this.lcM).setVisibility(0);
      AppMethodBeat.o(136266);
      return;
    }
    TaskItemView.e(this.lcM).setVisibility(0);
    TaskItemView.d(this.lcM).setVisibility(8);
    AppMethodBeat.o(136266);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.TaskItemView.5
 * JD-Core Version:    0.7.0.1
 */
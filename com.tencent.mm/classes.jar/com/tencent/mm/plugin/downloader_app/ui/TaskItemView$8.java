package com.tencent.mm.plugin.downloader_app.ui;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.downloader_app.a.d;
import com.tencent.mm.plugin.downloader_app.b.i;
import com.tencent.mm.sdk.platformtools.bo;

final class TaskItemView$8
  implements View.OnClickListener
{
  TaskItemView$8(TaskItemView paramTaskItemView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(136269);
    if ((TaskItemView.a(this.lcM) != null) && (TaskItemView.a(this.lcM).lbd != null) && (!bo.isNullOrNil(TaskItemView.a(this.lcM).lbd.kWm)))
    {
      paramView = new Bundle();
      paramView.putString("rawUrl", TaskItemView.a(this.lcM).lbd.kWm);
      ((d)g.E(d.class)).g(this.lcM.getContext(), paramView);
      com.tencent.mm.plugin.downloader_app.c.a.a(10, 1006, TaskItemView.a(this.lcM).position, 40, TaskItemView.a(this.lcM).appId, "", "");
    }
    AppMethodBeat.o(136269);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.TaskItemView.8
 * JD-Core Version:    0.7.0.1
 */
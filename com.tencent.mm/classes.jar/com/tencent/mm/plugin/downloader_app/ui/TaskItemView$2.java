package com.tencent.mm.plugin.downloader_app.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mm.plugin.downloader.e.d;
import com.tencent.mm.plugin.downloader_app.b.h;
import com.tencent.mm.plugin.downloader_app.b.c.4;
import com.tencent.mm.plugin.downloader_app.b.c.5;
import com.tencent.mm.plugin.downloader_app.b.j;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.vfs.e;

final class TaskItemView$2
  implements View.OnClickListener
{
  TaskItemView$2(TaskItemView paramTaskItemView) {}
  
  public final void onClick(View paramView)
  {
    j localj;
    if (TaskItemView.a(this.iTP).type == 6)
    {
      paramView = this.iTP.getContext();
      localj = TaskItemView.a(this.iTP);
      if (p.o(paramView, localj.iSt.iQe)) {
        com.tencent.mm.plugin.downloader.h.a.a(paramView, localj.appId, null);
      }
    }
    do
    {
      return;
      h.a(paramView, paramView.getString(b.h.app_uninstalled_dialog_tips), paramView.getString(b.h.app_uninstalled_dialog_title), paramView.getString(b.h.restart_download_app), paramView.getString(b.h.task_cancel), false, new c.4(paramView, localj), new c.5());
      return;
      paramView = com.tencent.mm.plugin.downloader.model.c.zH(TaskItemView.a(this.iTP).appId);
      if (paramView == null) {
        break label288;
      }
      if (TaskItemView.d(this.iTP).getText().equals(this.iTP.getResources().getString(b.h.wait_for_wifi)))
      {
        com.tencent.mm.plugin.downloader_app.b.c.a(this.iTP.getContext(), paramView, null);
        return;
      }
      if (TaskItemView.d(this.iTP).getText().equals(this.iTP.getResources().getString(b.h.install_app)))
      {
        com.tencent.mm.plugin.downloader_app.b.c.b(this.iTP.getContext(), TaskItemView.a(this.iTP));
        return;
      }
      if (!TaskItemView.d(this.iTP).getText().equals(this.iTP.getResources().getString(b.h.md5_checking))) {
        break;
      }
    } while (e.bK(paramView.field_filePath));
    com.tencent.mm.plugin.downloader_app.b.c.a(this.iTP.getContext(), TaskItemView.a(this.iTP));
    return;
    com.tencent.mm.plugin.downloader_app.b.c.a(this.iTP.getContext(), TaskItemView.a(this.iTP));
    return;
    label288:
    com.tencent.mm.plugin.downloader_app.b.c.a(this.iTP.getContext(), TaskItemView.a(this.iTP));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.TaskItemView.2
 * JD-Core Version:    0.7.0.1
 */
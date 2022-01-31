package com.tencent.mm.plugin.downloader_app.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mm.plugin.downloader.f.a;
import com.tencent.mm.plugin.downloader.model.d;
import com.tencent.mm.plugin.downloader_app.b.j;
import com.tencent.mm.vfs.e;

final class TaskItemView$1
  implements View.OnClickListener
{
  TaskItemView$1(TaskItemView paramTaskItemView) {}
  
  public final void onClick(View paramView)
  {
    paramView = com.tencent.mm.plugin.downloader.model.c.zH(TaskItemView.a(this.iTP).appId);
    if (paramView == null) {
      com.tencent.mm.plugin.downloader_app.b.c.a(this.iTP.getContext(), TaskItemView.a(this.iTP));
    }
    do
    {
      do
      {
        return;
        if (paramView.field_status == 3)
        {
          if (e.bK(paramView.field_filePath))
          {
            com.tencent.mm.plugin.downloader_app.b.c.b(this.iTP.getContext(), TaskItemView.a(this.iTP));
            return;
          }
          com.tencent.mm.plugin.downloader_app.b.c.a(this.iTP.getContext(), TaskItemView.a(this.iTP));
          return;
        }
        if (paramView.field_status == 2)
        {
          com.tencent.mm.plugin.downloader_app.b.c.a(this.iTP.getContext(), paramView, null);
          return;
        }
        if (paramView.field_status != 1) {
          break;
        }
      } while (TaskItemView.b(this.iTP));
      if (paramView.field_downloadInWifi)
      {
        paramView.field_downloadInWifi = false;
        com.tencent.mm.plugin.downloader.model.c.d(paramView);
      }
      d.aFP().de(paramView.field_downloadId);
      return;
      if (paramView.field_status != 6) {
        break;
      }
    } while (e.bK(paramView.field_filePath));
    com.tencent.mm.plugin.downloader_app.b.c.a(this.iTP.getContext(), TaskItemView.a(this.iTP));
    return;
    TaskItemView.c(this.iTP).setVisibility(8);
    com.tencent.mm.plugin.downloader_app.b.c.a(this.iTP.getContext(), TaskItemView.a(this.iTP));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.TaskItemView.1
 * JD-Core Version:    0.7.0.1
 */
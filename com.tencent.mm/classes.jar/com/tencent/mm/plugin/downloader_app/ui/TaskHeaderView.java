package com.tencent.mm.plugin.downloader_app.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.downloader_app.b.b;
import com.tencent.mm.plugin.downloader_app.b.e;
import com.tencent.mm.plugin.downloader_app.b.h;
import com.tencent.mm.plugin.downloader_app.b.j;

public class TaskHeaderView
  extends LinearLayout
{
  private TextView iTA;
  private View iTB;
  private TextView iTz;
  
  public TaskHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void a(j paramj, boolean paramBoolean)
  {
    if (paramj.type == 1)
    {
      this.iTz.setText(getResources().getString(b.h.download_task_title));
      this.iTA.setVisibility(8);
      if (!paramBoolean) {
        break label187;
      }
      this.iTB.setVisibility(0);
    }
    for (;;)
    {
      if (!paramj.ilB) {
        break label199;
      }
      this.iTz.setTextColor(getContext().getResources().getColor(b.b.disable_title_color));
      this.iTA.setVisibility(8);
      return;
      if (paramj.type == 3)
      {
        this.iTz.setText(getResources().getString(b.h.update_task_title));
        this.iTA.setText(getResources().getString(b.h.update_task_count, new Object[] { Integer.valueOf(paramj.iSs) }));
        this.iTA.setVisibility(0);
        break;
      }
      if (paramj.type != 5) {
        break;
      }
      this.iTz.setText(getResources().getString(b.h.download_history_title));
      this.iTA.setVisibility(8);
      break;
      label187:
      this.iTB.setVisibility(8);
    }
    label199:
    this.iTz.setTextColor(getContext().getResources().getColor(b.b.item_name_color));
    this.iTA.setVisibility(0);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.iTB = findViewById(b.e.divided_view);
    this.iTz = ((TextView)findViewById(b.e.left_title));
    this.iTA = ((TextView)findViewById(b.e.right_title));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.TaskHeaderView
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.downloader_app.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.downloader_app.b.b;
import com.tencent.mm.plugin.downloader_app.b.e;
import com.tencent.mm.plugin.downloader_app.b.f;

public class TaskManagerHeaderView
  extends LinearLayout
{
  private TextView iTA;
  
  public TaskManagerHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOrientation(1);
    this.iTA = ((TextView)LayoutInflater.from(getContext()).inflate(b.f.head_view, this, true).findViewById(b.e.right_title));
    this.iTA.setOnClickListener(new TaskManagerHeaderView.1(this));
    paramContext = new View(getContext());
    paramContext.setBackgroundColor(getResources().getColor(b.b.divided_color));
    addView(paramContext, -1, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.TaskManagerHeaderView
 * JD-Core Version:    0.7.0.1
 */
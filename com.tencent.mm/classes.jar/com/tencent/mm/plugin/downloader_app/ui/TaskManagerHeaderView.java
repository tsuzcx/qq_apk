package com.tencent.mm.plugin.downloader_app.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TaskManagerHeaderView
  extends LinearLayout
{
  private TextView lcq;
  
  public TaskManagerHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(136315);
    setOrientation(1);
    this.lcq = ((TextView)LayoutInflater.from(getContext()).inflate(2130969856, this, true).findViewById(2131822335));
    this.lcq.setOnClickListener(new TaskManagerHeaderView.1(this));
    paramContext = new View(getContext());
    paramContext.setBackgroundColor(getResources().getColor(2131689965));
    addView(paramContext, -1, 1);
    AppMethodBeat.o(136315);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.TaskManagerHeaderView
 * JD-Core Version:    0.7.0.1
 */
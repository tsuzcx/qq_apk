package com.tencent.mm.plugin.downloader_app.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class TaskManagerHeaderView
  extends LinearLayout
{
  private TextView ojz;
  
  public TaskManagerHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(9085);
    setOrientation(1);
    this.ojz = ((TextView)LayoutInflater.from(getContext()).inflate(2131494433, this, true).findViewById(2131304200));
    this.ojz.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(9084);
        if ((TaskManagerHeaderView.this.getContext() instanceof DownloadMainUI)) {
          ((DownloadMainUI)TaskManagerHeaderView.this.getContext()).ojb.bRt();
        }
        AppMethodBeat.o(9084);
      }
    });
    paramContext = new View(getContext());
    paramContext.setBackgroundColor(getResources().getColor(2131100251));
    addView(paramContext, -1, 1);
    AppMethodBeat.o(9085);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.TaskManagerHeaderView
 * JD-Core Version:    0.7.0.1
 */
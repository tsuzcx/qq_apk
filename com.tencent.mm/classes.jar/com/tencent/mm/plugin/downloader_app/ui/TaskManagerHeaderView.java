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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.downloader_app.e.b;
import com.tencent.mm.plugin.downloader_app.e.e;
import com.tencent.mm.plugin.downloader_app.e.f;

public class TaskManagerHeaderView
  extends LinearLayout
{
  private TextView xum;
  
  public TaskManagerHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(9085);
    setOrientation(1);
    this.xum = ((TextView)LayoutInflater.from(getContext()).inflate(e.f.xqP, this, true).findViewById(e.e.right_title));
    this.xum.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(9084);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/downloader_app/ui/TaskManagerHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if ((TaskManagerHeaderView.this.getContext() instanceof DownloadMainUI)) {
          ((DownloadMainUI)TaskManagerHeaderView.this.getContext()).xtO.dvp();
        }
        a.a(this, "com/tencent/mm/plugin/downloader_app/ui/TaskManagerHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(9084);
      }
    });
    paramContext = new View(getContext());
    paramContext.setBackgroundColor(getResources().getColor(e.b.xpG));
    addView(paramContext, -1, 1);
    AppMethodBeat.o(9085);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.TaskManagerHeaderView
 * JD-Core Version:    0.7.0.1
 */
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

public class TaskManagerHeaderView
  extends LinearLayout
{
  private TextView qME;
  
  public TaskManagerHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(9085);
    setOrientation(1);
    this.qME = ((TextView)LayoutInflater.from(getContext()).inflate(2131495010, this, true).findViewById(2131307114));
    this.qME.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(9084);
        b localb = new b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/downloader_app/ui/TaskManagerHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if ((TaskManagerHeaderView.this.getContext() instanceof DownloadMainUI)) {
          ((DownloadMainUI)TaskManagerHeaderView.this.getContext()).qMg.cCr();
        }
        a.a(this, "com/tencent/mm/plugin/downloader_app/ui/TaskManagerHeaderView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(9084);
      }
    });
    paramContext = new View(getContext());
    paramContext.setBackgroundColor(getResources().getColor(2131100285));
    addView(paramContext, -1, 1);
    AppMethodBeat.o(9085);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.TaskManagerHeaderView
 * JD-Core Version:    0.7.0.1
 */
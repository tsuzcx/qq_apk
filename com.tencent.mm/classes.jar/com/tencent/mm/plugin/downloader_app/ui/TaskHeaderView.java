package com.tencent.mm.plugin.downloader_app.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader_app.a.i;

public class TaskHeaderView
  extends LinearLayout
{
  private TextView qMD;
  private TextView qME;
  private View qMF;
  
  public TaskHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void a(i parami, boolean paramBoolean)
  {
    AppMethodBeat.i(9023);
    if (parami.type == 1)
    {
      this.qMD.setText(getResources().getString(2131758394));
      this.qME.setVisibility(8);
      if (!paramBoolean) {
        break label194;
      }
      this.qMF.setVisibility(0);
    }
    for (;;)
    {
      if (!parami.pSk) {
        break label206;
      }
      this.qMD.setTextColor(getContext().getResources().getColor(2131100284));
      this.qME.setVisibility(8);
      AppMethodBeat.o(9023);
      return;
      if (parami.type == 3)
      {
        this.qMD.setText(getResources().getString(2131766932));
        this.qME.setText(getResources().getString(2131766931, new Object[] { Integer.valueOf(parami.qLh) }));
        this.qME.setVisibility(0);
        break;
      }
      if (parami.type != 5) {
        break;
      }
      this.qMD.setText(getResources().getString(2131758376));
      this.qME.setVisibility(8);
      break;
      label194:
      this.qMF.setVisibility(8);
    }
    label206:
    this.qMD.setTextColor(getContext().getResources().getColor(2131100660));
    this.qME.setVisibility(0);
    AppMethodBeat.o(9023);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(9022);
    super.onFinishInflate();
    this.qMF = findViewById(2131299681);
    this.qMD = ((TextView)findViewById(2131303147));
    this.qME = ((TextView)findViewById(2131307114));
    AppMethodBeat.o(9022);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.TaskHeaderView
 * JD-Core Version:    0.7.0.1
 */
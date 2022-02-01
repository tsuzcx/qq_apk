package com.tencent.mm.plugin.downloader_app.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader_app.a.i;
import com.tencent.mm.plugin.downloader_app.e.b;
import com.tencent.mm.plugin.downloader_app.e.e;
import com.tencent.mm.plugin.downloader_app.e.h;

public class TaskHeaderView
  extends LinearLayout
{
  private TextView unP;
  private TextView unQ;
  private View unR;
  
  public TaskHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void a(i parami, boolean paramBoolean)
  {
    AppMethodBeat.i(9023);
    if (parami.type == 1)
    {
      this.unP.setText(getResources().getString(e.h.ukU));
      this.unQ.setVisibility(8);
      if (!paramBoolean) {
        break label199;
      }
      this.unR.setVisibility(0);
    }
    for (;;)
    {
      if (!parami.toj) {
        break label211;
      }
      this.unP.setTextColor(getContext().getResources().getColor(e.b.ujC));
      this.unQ.setVisibility(8);
      AppMethodBeat.o(9023);
      return;
      if (parami.type == 3)
      {
        this.unP.setText(getResources().getString(e.h.ulx));
        this.unQ.setText(getResources().getString(e.h.ulw, new Object[] { Integer.valueOf(parami.umt) }));
        this.unQ.setVisibility(0);
        break;
      }
      if (parami.type != 5) {
        break;
      }
      this.unP.setText(getResources().getString(e.h.ukR));
      this.unQ.setVisibility(8);
      break;
      label199:
      this.unR.setVisibility(8);
    }
    label211:
    this.unP.setTextColor(getContext().getResources().getColor(e.b.ujF));
    this.unQ.setVisibility(0);
    AppMethodBeat.o(9023);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(9022);
    super.onFinishInflate();
    this.unR = findViewById(e.e.ujW);
    this.unP = ((TextView)findViewById(e.e.dLe));
    this.unQ = ((TextView)findViewById(e.e.dSW));
    AppMethodBeat.o(9022);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.TaskHeaderView
 * JD-Core Version:    0.7.0.1
 */
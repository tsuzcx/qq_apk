package com.tencent.mm.plugin.downloader_app.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader_app.b.i;

public class TaskHeaderView
  extends LinearLayout
{
  private TextView lcp;
  private TextView lcq;
  private View lcr;
  
  public TaskHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void a(i parami, boolean paramBoolean)
  {
    AppMethodBeat.i(136256);
    if (parami.type == 1)
    {
      this.lcp.setText(getResources().getString(2131299019));
      this.lcq.setVisibility(8);
      if (!paramBoolean) {
        break label192;
      }
      this.lcr.setVisibility(0);
    }
    for (;;)
    {
      if (!parami.kmz) {
        break label204;
      }
      this.lcp.setTextColor(getContext().getResources().getColor(2131689964));
      this.lcq.setVisibility(8);
      AppMethodBeat.o(136256);
      return;
      if (parami.type == 3)
      {
        this.lcp.setText(getResources().getString(2131304440));
        this.lcq.setText(getResources().getString(2131304439, new Object[] { Integer.valueOf(parami.lba) }));
        this.lcq.setVisibility(0);
        break;
      }
      if (parami.type != 5) {
        break;
      }
      this.lcp.setText(getResources().getString(2131299007));
      this.lcq.setVisibility(8);
      break;
      label192:
      this.lcr.setVisibility(8);
    }
    label204:
    this.lcp.setTextColor(getContext().getResources().getColor(2131690194));
    this.lcq.setVisibility(0);
    AppMethodBeat.o(136256);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(136255);
    super.onFinishInflate();
    this.lcr = findViewById(2131823429);
    this.lcp = ((TextView)findViewById(2131822330));
    this.lcq = ((TextView)findViewById(2131822335));
    AppMethodBeat.o(136255);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.TaskHeaderView
 * JD-Core Version:    0.7.0.1
 */
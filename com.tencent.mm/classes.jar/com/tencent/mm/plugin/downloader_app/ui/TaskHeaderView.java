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
  private View ojA;
  private TextView ojy;
  private TextView ojz;
  
  public TaskHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void a(i parami, boolean paramBoolean)
  {
    AppMethodBeat.i(9023);
    if (parami.type == 1)
    {
      this.ojy.setText(getResources().getString(2131758122));
      this.ojz.setVisibility(8);
      if (!paramBoolean) {
        break label194;
      }
      this.ojA.setVisibility(0);
    }
    for (;;)
    {
      if (!parami.nrE) {
        break label206;
      }
      this.ojy.setTextColor(getContext().getResources().getColor(2131100250));
      this.ojz.setVisibility(8);
      AppMethodBeat.o(9023);
      return;
      if (parami.type == 3)
      {
        this.ojy.setText(getResources().getString(2131764586));
        this.ojz.setText(getResources().getString(2131764585, new Object[] { Integer.valueOf(parami.oic) }));
        this.ojz.setVisibility(0);
        break;
      }
      if (parami.type != 5) {
        break;
      }
      this.ojy.setText(getResources().getString(2131758109));
      this.ojz.setVisibility(8);
      break;
      label194:
      this.ojA.setVisibility(8);
    }
    label206:
    this.ojy.setTextColor(getContext().getResources().getColor(2131100523));
    this.ojz.setVisibility(0);
    AppMethodBeat.o(9023);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(9022);
    super.onFinishInflate();
    this.ojA = findViewById(2131299153);
    this.ojy = ((TextView)findViewById(2131301392));
    this.ojz = ((TextView)findViewById(2131304200));
    AppMethodBeat.o(9022);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.TaskHeaderView
 * JD-Core Version:    0.7.0.1
 */
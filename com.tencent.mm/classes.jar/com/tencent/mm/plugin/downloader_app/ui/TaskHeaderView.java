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
  private TextView oMY;
  private TextView oMZ;
  private View oNa;
  
  public TaskHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void a(i parami, boolean paramBoolean)
  {
    AppMethodBeat.i(9023);
    if (parami.type == 1)
    {
      this.oMY.setText(getResources().getString(2131758122));
      this.oMZ.setVisibility(8);
      if (!paramBoolean) {
        break label194;
      }
      this.oNa.setVisibility(0);
    }
    for (;;)
    {
      if (!parami.nUE) {
        break label206;
      }
      this.oMY.setTextColor(getContext().getResources().getColor(2131100250));
      this.oMZ.setVisibility(8);
      AppMethodBeat.o(9023);
      return;
      if (parami.type == 3)
      {
        this.oMY.setText(getResources().getString(2131764586));
        this.oMZ.setText(getResources().getString(2131764585, new Object[] { Integer.valueOf(parami.oLC) }));
        this.oMZ.setVisibility(0);
        break;
      }
      if (parami.type != 5) {
        break;
      }
      this.oMY.setText(getResources().getString(2131758109));
      this.oMZ.setVisibility(8);
      break;
      label194:
      this.oNa.setVisibility(8);
    }
    label206:
    this.oMY.setTextColor(getContext().getResources().getColor(2131100523));
    this.oMZ.setVisibility(0);
    AppMethodBeat.o(9023);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(9022);
    super.onFinishInflate();
    this.oNa = findViewById(2131299153);
    this.oMY = ((TextView)findViewById(2131301392));
    this.oMZ = ((TextView)findViewById(2131304200));
    AppMethodBeat.o(9022);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.TaskHeaderView
 * JD-Core Version:    0.7.0.1
 */
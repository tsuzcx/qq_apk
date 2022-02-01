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
  private TextView pqG;
  private TextView pqH;
  private View pqI;
  
  public TaskHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void a(i parami, boolean paramBoolean)
  {
    AppMethodBeat.i(9023);
    if (parami.type == 1)
    {
      this.pqG.setText(getResources().getString(2131758122));
      this.pqH.setVisibility(8);
      if (!paramBoolean) {
        break label194;
      }
      this.pqI.setVisibility(0);
    }
    for (;;)
    {
      if (!parami.oxZ) {
        break label206;
      }
      this.pqG.setTextColor(getContext().getResources().getColor(2131100250));
      this.pqH.setVisibility(8);
      AppMethodBeat.o(9023);
      return;
      if (parami.type == 3)
      {
        this.pqG.setText(getResources().getString(2131764586));
        this.pqH.setText(getResources().getString(2131764585, new Object[] { Integer.valueOf(parami.ppk) }));
        this.pqH.setVisibility(0);
        break;
      }
      if (parami.type != 5) {
        break;
      }
      this.pqG.setText(getResources().getString(2131758109));
      this.pqH.setVisibility(8);
      break;
      label194:
      this.pqI.setVisibility(8);
    }
    label206:
    this.pqG.setTextColor(getContext().getResources().getColor(2131100523));
    this.pqH.setVisibility(0);
    AppMethodBeat.o(9023);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(9022);
    super.onFinishInflate();
    this.pqI = findViewById(2131299153);
    this.pqG = ((TextView)findViewById(2131301392));
    this.pqH = ((TextView)findViewById(2131304200));
    AppMethodBeat.o(9022);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.TaskHeaderView
 * JD-Core Version:    0.7.0.1
 */
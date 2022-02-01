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
  private TextView xul;
  private TextView xum;
  private View xun;
  
  public TaskHeaderView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void a(i parami, boolean paramBoolean)
  {
    AppMethodBeat.i(9023);
    if (parami.type == 1)
    {
      this.xul.setText(getResources().getString(e.h.xrg));
      this.xum.setVisibility(8);
      if (!paramBoolean) {
        break label199;
      }
      this.xun.setVisibility(0);
    }
    for (;;)
    {
      if (!parami.wsK) {
        break label211;
      }
      this.xul.setTextColor(getContext().getResources().getColor(e.b.xpF));
      this.xum.setVisibility(8);
      AppMethodBeat.o(9023);
      return;
      if (parami.type == 3)
      {
        this.xul.setText(getResources().getString(e.h.xrJ));
        this.xum.setText(getResources().getString(e.h.xrI, new Object[] { Integer.valueOf(parami.xsF) }));
        this.xum.setVisibility(0);
        break;
      }
      if (parami.type != 5) {
        break;
      }
      this.xul.setText(getResources().getString(e.h.xrd));
      this.xum.setVisibility(8);
      break;
      label199:
      this.xun.setVisibility(8);
    }
    label211:
    this.xul.setTextColor(getContext().getResources().getColor(e.b.xpI));
    this.xum.setVisibility(0);
    AppMethodBeat.o(9023);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(9022);
    super.onFinishInflate();
    this.xun = findViewById(e.e.xqc);
    this.xul = ((TextView)findViewById(e.e.fMJ));
    this.xum = ((TextView)findViewById(e.e.right_title));
    AppMethodBeat.o(9022);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.TaskHeaderView
 * JD-Core Version:    0.7.0.1
 */
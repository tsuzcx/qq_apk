package com.tencent.mm.plugin.downloader_app.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.c.a.a.f;

public class NoTaskLayout
  extends RelativeLayout
{
  private BottomEntranceView lco;
  
  public NoTaskLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(136253);
    super.onFinishInflate();
    this.lco = ((BottomEntranceView)findViewById(2131826551));
    AppMethodBeat.o(136253);
  }
  
  public void setData(f paramf)
  {
    AppMethodBeat.i(136254);
    this.lco.setData(paramf);
    AppMethodBeat.o(136254);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.NoTaskLayout
 * JD-Core Version:    0.7.0.1
 */
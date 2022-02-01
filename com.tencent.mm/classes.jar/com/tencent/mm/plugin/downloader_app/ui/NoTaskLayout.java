package com.tencent.mm.plugin.downloader_app.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.b.a.a.f;
import com.tencent.mm.plugin.downloader_app.b;
import com.tencent.mm.plugin.downloader_app.e.e;

public class NoTaskLayout
  extends RelativeLayout
{
  private ImageView tZX;
  private BottomEntranceView xuh;
  
  public NoTaskLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(9019);
    super.onFinishInflate();
    this.tZX = ((ImageView)findViewById(e.e.img));
    this.xuh = ((BottomEntranceView)findViewById(e.e.xpW));
    b.i(this.tZX, "download_non_task");
    AppMethodBeat.o(9019);
  }
  
  public void setData(f paramf)
  {
    AppMethodBeat.i(9020);
    this.xuh.setData(paramf);
    AppMethodBeat.o(9020);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.NoTaskLayout
 * JD-Core Version:    0.7.0.1
 */
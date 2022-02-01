package com.tencent.mm.plugin.downloader_app.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.c.a.a.f;
import com.tencent.mm.plugin.downloader_app.b;

public class NoTaskLayout
  extends RelativeLayout
{
  private ImageView nSS;
  private BottomEntranceView qMz;
  
  public NoTaskLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(9019);
    super.onFinishInflate();
    this.nSS = ((ImageView)findViewById(2131302613));
    this.qMz = ((BottomEntranceView)findViewById(2131297676));
    b.e(this.nSS, "download_non_task");
    AppMethodBeat.o(9019);
  }
  
  public void setData(f paramf)
  {
    AppMethodBeat.i(9020);
    this.qMz.setData(paramf);
    AppMethodBeat.o(9020);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.NoTaskLayout
 * JD-Core Version:    0.7.0.1
 */
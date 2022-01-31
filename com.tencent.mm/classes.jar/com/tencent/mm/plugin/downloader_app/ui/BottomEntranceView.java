package com.tencent.mm.plugin.downloader_app.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader.c.a.a.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.am;

public class BottomEntranceView
  extends RelativeLayout
{
  private f lbN;
  private TextView lbO;
  private int lbP;
  private int lbQ;
  
  public BottomEntranceView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private int getDisplayHeight()
  {
    AppMethodBeat.i(136213);
    int i = am.hQ(getContext()).y;
    AppMethodBeat.o(136213);
    return i;
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(136211);
    super.onFinishInflate();
    this.lbO = ((TextView)findViewById(2131823426));
    this.lbQ = (getDisplayHeight() - am.di(getContext()) - am.getStatusBarHeight(getContext()) - am.fx(getContext()));
    this.lbP = getResources().getDimensionPixelSize(2131428132);
    ab.d("MicroMsg.BottomEntranceView", "mContentH = %d", new Object[] { Integer.valueOf(this.lbQ) });
    getViewTreeObserver().addOnGlobalLayoutListener(new BottomEntranceView.1(this));
    setOnClickListener(new BottomEntranceView.2(this));
    AppMethodBeat.o(136211);
  }
  
  public void setData(f paramf)
  {
    AppMethodBeat.i(136212);
    if ((paramf == null) || (bo.isNullOrNil(paramf.desc)) || (bo.isNullOrNil(paramf.knV)))
    {
      setVisibility(8);
      AppMethodBeat.o(136212);
      return;
    }
    this.lbN = paramf;
    setVisibility(0);
    this.lbO.setText(this.lbN.desc);
    AppMethodBeat.o(136212);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.BottomEntranceView
 * JD-Core Version:    0.7.0.1
 */
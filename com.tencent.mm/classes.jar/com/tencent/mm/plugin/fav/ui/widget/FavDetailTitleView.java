package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class FavDetailTitleView
  extends LinearLayout
{
  private ImageView egq;
  private TextView gpL;
  
  public FavDetailTitleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(74671);
    super.onFinishInflate();
    this.egq = ((ImageView)findViewById(2131821210));
    this.gpL = ((TextView)findViewById(2131821212));
    AppMethodBeat.o(74671);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.FavDetailTitleView
 * JD-Core Version:    0.7.0.1
 */
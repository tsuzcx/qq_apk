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
  private ImageView fQl;
  private TextView iYj;
  
  public FavDetailTitleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(107512);
    super.onFinishInflate();
    this.fQl = ((ImageView)findViewById(2131297008));
    this.iYj = ((TextView)findViewById(2131305948));
    AppMethodBeat.o(107512);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.FavDetailTitleView
 * JD-Core Version:    0.7.0.1
 */
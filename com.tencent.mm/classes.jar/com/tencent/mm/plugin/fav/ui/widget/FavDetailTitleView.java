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
  private ImageView gvv;
  private TextView jVO;
  
  public FavDetailTitleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(107512);
    super.onFinishInflate();
    this.gvv = ((ImageView)findViewById(2131297134));
    this.jVO = ((TextView)findViewById(2131309249));
    AppMethodBeat.o(107512);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.FavDetailTitleView
 * JD-Core Version:    0.7.0.1
 */
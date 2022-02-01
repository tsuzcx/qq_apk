package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.ui.q.e;

public class FavDetailTitleView
  extends LinearLayout
{
  private ImageView lBC;
  private TextView pJJ;
  
  public FavDetailTitleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(107512);
    super.onFinishInflate();
    this.lBC = ((ImageView)findViewById(q.e.avatar_iv));
    this.pJJ = ((TextView)findViewById(q.e.title_tv));
    AppMethodBeat.o(107512);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.FavDetailTitleView
 * JD-Core Version:    0.7.0.1
 */
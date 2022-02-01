package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.ui.s.e;

public class FavDetailTitleView
  extends LinearLayout
{
  private ImageView iZG;
  private TextView mNb;
  
  public FavDetailTitleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(107512);
    super.onFinishInflate();
    this.iZG = ((ImageView)findViewById(s.e.avatar_iv));
    this.mNb = ((TextView)findViewById(s.e.title_tv));
    AppMethodBeat.o(107512);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.FavDetailTitleView
 * JD-Core Version:    0.7.0.1
 */
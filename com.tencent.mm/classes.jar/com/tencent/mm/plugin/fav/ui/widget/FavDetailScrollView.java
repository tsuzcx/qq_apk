package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMLoadScrollView;

public class FavDetailScrollView
  extends MMLoadScrollView
{
  private FavDetailScrollView.a mDT;
  
  public FavDetailScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public FavDetailScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onScrollChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(74670);
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((getScrollY() == 0) && (this.mDT != null))
    {
      this.mDT.bxW();
      AppMethodBeat.o(74670);
      return;
    }
    if (this.mDT != null) {
      this.mDT.bxV();
    }
    AppMethodBeat.o(74670);
  }
  
  public void setOnScrollChangeListener(FavDetailScrollView.a parama)
  {
    this.mDT = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.FavDetailScrollView
 * JD-Core Version:    0.7.0.1
 */
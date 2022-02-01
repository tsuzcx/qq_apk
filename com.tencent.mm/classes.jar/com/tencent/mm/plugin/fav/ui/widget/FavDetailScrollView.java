package com.tencent.mm.plugin.fav.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.MMLoadScrollView;

public class FavDetailScrollView
  extends MMLoadScrollView
{
  private a tmr;
  
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
    AppMethodBeat.i(107511);
    super.onScrollChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((getScrollY() == 0) && (this.tmr != null))
    {
      this.tmr.cWt();
      AppMethodBeat.o(107511);
      return;
    }
    if (this.tmr != null) {
      this.tmr.cWs();
    }
    AppMethodBeat.o(107511);
  }
  
  public void setOnScrollChangeListener(a parama)
  {
    this.tmr = parama;
  }
  
  public static abstract interface a
  {
    public abstract void cWs();
    
    public abstract void cWt();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.widget.FavDetailScrollView
 * JD-Core Version:    0.7.0.1
 */
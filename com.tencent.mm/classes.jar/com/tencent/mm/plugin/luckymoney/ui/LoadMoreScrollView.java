package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class LoadMoreScrollView
  extends ScrollView
{
  private a oqU;
  
  public LoadMoreScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public LoadMoreScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onOverScrolled(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(42558);
    ab.v("MicroMsg.LoadMoreScrollView", paramInt1 + ", " + paramInt2 + ", " + paramBoolean1 + ", " + paramBoolean2 + ", " + getScrollY());
    super.onOverScrolled(paramInt1, paramInt2, paramBoolean1, paramBoolean2);
    AppMethodBeat.o(42558);
  }
  
  public void setOnLoadMoreListener(a parama)
  {
    this.oqU = parama;
  }
  
  public static abstract interface a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LoadMoreScrollView
 * JD-Core Version:    0.7.0.1
 */
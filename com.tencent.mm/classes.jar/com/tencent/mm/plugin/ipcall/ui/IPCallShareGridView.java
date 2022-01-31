package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.GridView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class IPCallShareGridView
  extends GridView
{
  public IPCallShareGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public IPCallShareGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(22357);
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(536870911, -2147483648));
    AppMethodBeat.o(22357);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallShareGridView
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.w;

public class AAQueryListLoadingMoreView
  extends LinearLayout
{
  public AAQueryListLoadingMoreView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(40724);
    init(paramContext);
    AppMethodBeat.o(40724);
  }
  
  public AAQueryListLoadingMoreView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(40725);
    init(paramContext);
    AppMethodBeat.o(40725);
  }
  
  public AAQueryListLoadingMoreView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(40726);
    init(paramContext);
    AppMethodBeat.o(40726);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(40727);
    w.hM(paramContext).inflate(2130968581, this, true);
    AppMethodBeat.o(40727);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.AAQueryListLoadingMoreView
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.z;

public class AAQueryListLoadingMoreView
  extends LinearLayout
{
  public AAQueryListLoadingMoreView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(63504);
    init(paramContext);
    AppMethodBeat.o(63504);
  }
  
  public AAQueryListLoadingMoreView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(63505);
    init(paramContext);
    AppMethodBeat.o(63505);
  }
  
  public AAQueryListLoadingMoreView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(63506);
    init(paramContext);
    AppMethodBeat.o(63506);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(63507);
    z.jV(paramContext).inflate(2131492888, this, true);
    AppMethodBeat.o(63507);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.AAQueryListLoadingMoreView
 * JD-Core Version:    0.7.0.1
 */
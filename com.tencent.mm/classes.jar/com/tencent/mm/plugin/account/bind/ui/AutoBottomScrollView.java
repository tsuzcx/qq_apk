package com.tencent.mm.plugin.account.bind.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class AutoBottomScrollView
  extends ScrollView
{
  public AutoBottomScrollView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AutoBottomScrollView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(109756);
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    postDelayed(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(109755);
        AutoBottomScrollView.this.smoothScrollTo(0, AutoBottomScrollView.this.getBottom());
        AppMethodBeat.o(109755);
      }
    }, 100L);
    AppMethodBeat.o(109756);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.AutoBottomScrollView
 * JD-Core Version:    0.7.0.1
 */
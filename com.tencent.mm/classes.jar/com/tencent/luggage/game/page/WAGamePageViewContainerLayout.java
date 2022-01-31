package com.tencent.luggage.game.page;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Display;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.tencent.luggage.g.d;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class WAGamePageViewContainerLayout
  extends FrameLayout
{
  private b bBM = null;
  private a bBN = null;
  
  public WAGamePageViewContainerLayout(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public WAGamePageViewContainerLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, -1);
  }
  
  public WAGamePageViewContainerLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(140501);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    b localb;
    if ((getContext() instanceof Activity))
    {
      paramInt1 = ((Activity)getContext()).getWindowManager().getDefaultDisplay().getRotation();
      switch (paramInt1)
      {
      default: 
        d.e("MicroMsg.WAContainerView", "hy: invalid rotate: %d!", new Object[] { Integer.valueOf(paramInt1) });
        localb = b.bBO;
      }
    }
    for (;;)
    {
      if (this.bBN != null) {
        this.bBN.a(this.bBM, localb);
      }
      this.bBM = localb;
      AppMethodBeat.o(140501);
      return;
      localb = b.bBP;
      continue;
      localb = b.bBQ;
      continue;
      localb = b.bBR;
      continue;
      localb = b.bBS;
    }
  }
  
  public void setOnConfigurationChangedListener(a parama)
  {
    this.bBN = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a(WAGamePageViewContainerLayout.b paramb1, WAGamePageViewContainerLayout.b paramb2);
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(140500);
      bBO = new b("UNDEFINED", 0);
      bBP = new b("PORTRAIT", 1);
      bBQ = new b("LANDSCAPE", 2);
      bBR = new b("PORTRAIT_REVERSE", 3);
      bBS = new b("LANDSCAPE_REVERSE", 4);
      bBT = new b[] { bBO, bBP, bBQ, bBR, bBS };
      AppMethodBeat.o(140500);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.game.page.WAGamePageViewContainerLayout
 * JD-Core Version:    0.7.0.1
 */
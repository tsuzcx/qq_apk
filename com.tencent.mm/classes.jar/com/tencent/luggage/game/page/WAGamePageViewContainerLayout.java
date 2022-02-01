package com.tencent.luggage.game.page;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Display;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

public class WAGamePageViewContainerLayout
  extends FrameLayout
{
  private b ckR = null;
  private a ckS = null;
  
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
    AppMethodBeat.i(130643);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    b localb;
    if ((getContext() instanceof Activity))
    {
      paramInt1 = ((Activity)getContext()).getWindowManager().getDefaultDisplay().getRotation();
      switch (paramInt1)
      {
      default: 
        ae.e("MicroMsg.WAContainerView", "hy: invalid rotate: %d!", new Object[] { Integer.valueOf(paramInt1) });
        localb = b.ckT;
      }
    }
    for (;;)
    {
      if (this.ckS != null) {
        this.ckS.a(this.ckR, localb);
      }
      this.ckR = localb;
      AppMethodBeat.o(130643);
      return;
      localb = b.ckU;
      continue;
      localb = b.ckV;
      continue;
      localb = b.ckW;
      continue;
      localb = b.ckX;
    }
  }
  
  public void setOnConfigurationChangedListener(a parama)
  {
    this.ckS = parama;
  }
  
  public static abstract interface a
  {
    public abstract void a(WAGamePageViewContainerLayout.b paramb1, WAGamePageViewContainerLayout.b paramb2);
  }
  
  public static enum b
  {
    static
    {
      AppMethodBeat.i(130642);
      ckT = new b("UNDEFINED", 0);
      ckU = new b("PORTRAIT", 1);
      ckV = new b("LANDSCAPE", 2);
      ckW = new b("PORTRAIT_REVERSE", 3);
      ckX = new b("LANDSCAPE_REVERSE", 4);
      ckY = new b[] { ckT, ckU, ckV, ckW, ckX };
      AppMethodBeat.o(130642);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.game.page.WAGamePageViewContainerLayout
 * JD-Core Version:    0.7.0.1
 */
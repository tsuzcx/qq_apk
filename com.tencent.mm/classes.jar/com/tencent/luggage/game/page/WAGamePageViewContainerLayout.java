package com.tencent.luggage.game.page;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Display;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public class WAGamePageViewContainerLayout
  extends FrameLayout
{
  private b ckP = null;
  private a ckQ = null;
  
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
        ad.e("MicroMsg.WAContainerView", "hy: invalid rotate: %d!", new Object[] { Integer.valueOf(paramInt1) });
        localb = b.ckR;
      }
    }
    for (;;)
    {
      if (this.ckQ != null) {
        this.ckQ.a(this.ckP, localb);
      }
      this.ckP = localb;
      AppMethodBeat.o(130643);
      return;
      localb = b.ckS;
      continue;
      localb = b.ckT;
      continue;
      localb = b.ckU;
      continue;
      localb = b.ckV;
    }
  }
  
  public void setOnConfigurationChangedListener(a parama)
  {
    this.ckQ = parama;
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
      ckR = new b("UNDEFINED", 0);
      ckS = new b("PORTRAIT", 1);
      ckT = new b("LANDSCAPE", 2);
      ckU = new b("PORTRAIT_REVERSE", 3);
      ckV = new b("LANDSCAPE_REVERSE", 4);
      ckW = new b[] { ckR, ckS, ckT, ckU, ckV };
      AppMethodBeat.o(130642);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.game.page.WAGamePageViewContainerLayout
 * JD-Core Version:    0.7.0.1
 */
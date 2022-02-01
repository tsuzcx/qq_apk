package com.tencent.luggage.game.page;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Display;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

public class WAGamePageViewContainerLayout
  extends FrameLayout
{
  private b cay = null;
  private a caz = null;
  
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
        ac.e("MicroMsg.WAContainerView", "hy: invalid rotate: %d!", new Object[] { Integer.valueOf(paramInt1) });
        localb = b.caA;
      }
    }
    for (;;)
    {
      if (this.caz != null) {
        this.caz.a(this.cay, localb);
      }
      this.cay = localb;
      AppMethodBeat.o(130643);
      return;
      localb = b.caB;
      continue;
      localb = b.caC;
      continue;
      localb = b.caD;
      continue;
      localb = b.caE;
    }
  }
  
  public void setOnConfigurationChangedListener(a parama)
  {
    this.caz = parama;
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
      caA = new b("UNDEFINED", 0);
      caB = new b("PORTRAIT", 1);
      caC = new b("LANDSCAPE", 2);
      caD = new b("PORTRAIT_REVERSE", 3);
      caE = new b("LANDSCAPE_REVERSE", 4);
      caF = new b[] { caA, caB, caC, caD, caE };
      AppMethodBeat.o(130642);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.luggage.game.page.WAGamePageViewContainerLayout
 * JD-Core Version:    0.7.0.1
 */
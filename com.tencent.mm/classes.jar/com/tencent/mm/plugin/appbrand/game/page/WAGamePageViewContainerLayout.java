package com.tencent.mm.plugin.appbrand.game.page;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Display;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.tencent.mm.sdk.platformtools.y;

public class WAGamePageViewContainerLayout
  extends FrameLayout
{
  private WAGamePageViewContainerLayout.b gcJ = null;
  private WAGamePageViewContainerLayout.a gcK = null;
  
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
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    WAGamePageViewContainerLayout.b localb;
    if ((getContext() instanceof Activity))
    {
      paramInt1 = ((Activity)getContext()).getWindowManager().getDefaultDisplay().getRotation();
      switch (paramInt1)
      {
      default: 
        y.e("MicroMsg.WAContainerView", "hy: invalid rotate: %d!", new Object[] { Integer.valueOf(paramInt1) });
        localb = WAGamePageViewContainerLayout.b.gcL;
      }
    }
    for (;;)
    {
      if (this.gcK != null) {
        this.gcK.a(this.gcJ, localb);
      }
      this.gcJ = localb;
      return;
      localb = WAGamePageViewContainerLayout.b.gcM;
      continue;
      localb = WAGamePageViewContainerLayout.b.gcN;
      continue;
      localb = WAGamePageViewContainerLayout.b.gcO;
      continue;
      localb = WAGamePageViewContainerLayout.b.gcP;
    }
  }
  
  public void setOnConfigurationChangedListener(WAGamePageViewContainerLayout.a parama)
  {
    this.gcK = parama;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.page.WAGamePageViewContainerLayout
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.luggage.game.page;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Display;
import android.view.WindowManager;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.system.AndroidContextUtil;

public class WAGamePageViewContainerLayout
  extends FrameLayout
{
  private b eno;
  private a enp;
  Activity mActivity;
  
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
    AppMethodBeat.i(220150);
    this.eno = null;
    this.enp = null;
    this.mActivity = AndroidContextUtil.castActivityOrNull(getContext());
    AppMethodBeat.o(220150);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(130643);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    b localb;
    if (this.mActivity != null)
    {
      paramInt1 = this.mActivity.getWindowManager().getDefaultDisplay().getRotation();
      switch (paramInt1)
      {
      default: 
        Log.e("MicroMsg.WAContainerView", "hy: invalid rotate: %d!", new Object[] { Integer.valueOf(paramInt1) });
        localb = b.enq;
      }
    }
    for (;;)
    {
      if (this.enp != null) {
        this.enp.a(this.eno, localb);
      }
      this.eno = localb;
      AppMethodBeat.o(130643);
      return;
      localb = b.enr;
      continue;
      localb = b.ens;
      continue;
      localb = b.ent;
      continue;
      localb = b.enu;
    }
  }
  
  public void setOnConfigurationChangedListener(a parama)
  {
    this.enp = parama;
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
      enq = new b("UNDEFINED", 0);
      enr = new b("PORTRAIT", 1);
      ens = new b("LANDSCAPE", 2);
      ent = new b("PORTRAIT_REVERSE", 3);
      enu = new b("LANDSCAPE_REVERSE", 4);
      enw = new b[] { enq, enr, ens, ent, enu };
      AppMethodBeat.o(130642);
    }
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.luggage.game.page.WAGamePageViewContainerLayout
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.support.annotation.Keep;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.appbrand.jsapi.n.b;

public final class AppBrandMultiOptionsPicker
  extends FrameLayout
  implements b<int[]>
{
  private boolean aih;
  private final Drawable jsk;
  public LinearLayout jsl;
  private boolean jsm;
  private d jsn;
  public final YANumberPicker.b jso;
  
  @Keep
  public AppBrandMultiOptionsPicker(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(126704);
    this.jso = new AppBrandMultiOptionsPicker.1(this);
    this.jsk = paramContext.getResources().getDrawable(2130837750);
    this.jsl = new LinearLayout(paramContext);
    this.jsl.setPadding(a.fromDPToPix(paramContext, 2), 0, a.fromDPToPix(paramContext, 2), 0);
    this.jsl.setOrientation(0);
    addView(this.jsl, new FrameLayout.LayoutParams(-1, -1, 17));
    this.jsl.setDividerDrawable(this.jsk);
    this.jsl.setShowDividers(2);
    AppMethodBeat.o(126704);
  }
  
  public final void a(d paramd)
  {
    this.jsn = paramd;
  }
  
  public final void aEs()
  {
    AppMethodBeat.i(126712);
    int j = getPickersCount();
    int i = 0;
    while (i < j)
    {
      c localc = qI(i);
      if (localc != null) {
        localc.aSe();
      }
      i += 1;
    }
    AppMethodBeat.o(126712);
  }
  
  public final void aEt()
  {
    this.jsn = null;
  }
  
  public final void b(d paramd)
  {
    this.jsn = paramd;
  }
  
  public final int getPickersCount()
  {
    AppMethodBeat.i(126710);
    if (this.jsl == null)
    {
      AppMethodBeat.o(126710);
      return 0;
    }
    int i = this.jsl.getChildCount();
    AppMethodBeat.o(126710);
    return i;
  }
  
  public final View getView()
  {
    return this;
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(126707);
    if (this.aih)
    {
      AppMethodBeat.o(126707);
      return false;
    }
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(126707);
    return bool;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(126708);
    if (this.aih)
    {
      AppMethodBeat.o(126708);
      return false;
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(126708);
    return bool;
  }
  
  public final c qI(int paramInt)
  {
    AppMethodBeat.i(126709);
    if (paramInt < 0)
    {
      AppMethodBeat.o(126709);
      return null;
    }
    if (this.jsl == null)
    {
      AppMethodBeat.o(126709);
      return null;
    }
    c localc = (c)this.jsl.getChildAt(paramInt);
    AppMethodBeat.o(126709);
    return localc;
  }
  
  public final void qJ(int paramInt)
  {
    AppMethodBeat.i(126711);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(126711);
      return;
    }
    int i = getPickersCount() - 1;
    while (paramInt > 0)
    {
      this.jsl.removeViewAt(i);
      i -= 1;
      paramInt -= 1;
    }
    AppMethodBeat.o(126711);
  }
  
  public final void requestLayout()
  {
    AppMethodBeat.i(126706);
    if (this.aih)
    {
      this.jsm = true;
      AppMethodBeat.o(126706);
      return;
    }
    super.requestLayout();
    AppMethodBeat.o(126706);
  }
  
  public final void setLayoutFrozen(boolean paramBoolean)
  {
    AppMethodBeat.i(126705);
    if (this.aih != paramBoolean)
    {
      this.aih = paramBoolean;
      if (paramBoolean)
      {
        long l = SystemClock.uptimeMillis();
        onTouchEvent(MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0));
        AppMethodBeat.o(126705);
        return;
      }
      if (this.jsm) {
        requestLayout();
      }
    }
    AppMethodBeat.o(126705);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker
 * JD-Core Version:    0.7.0.1
 */
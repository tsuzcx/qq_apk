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
import com.tencent.mm.cc.a;

public final class AppBrandMultiOptionsPicker
  extends FrameLayout
  implements com.tencent.mm.plugin.appbrand.jsapi.m.c<int[]>
{
  private boolean aqk;
  private final Drawable mKf;
  public LinearLayout mKg;
  private boolean mKh;
  private c mKi;
  public final YANumberPicker.b mKj;
  
  @Keep
  public AppBrandMultiOptionsPicker(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(137995);
    this.mKj = new YANumberPicker.b()
    {
      public final void a(YANumberPicker paramAnonymousYANumberPicker, int paramAnonymousInt)
      {
        AppMethodBeat.i(137993);
        if (AppBrandMultiOptionsPicker.a(AppBrandMultiOptionsPicker.this) != null)
        {
          int i = ((Integer)paramAnonymousYANumberPicker.getTag(2131296775)).intValue();
          AppBrandMultiOptionsPicker.a(AppBrandMultiOptionsPicker.this).cM(new int[] { i, paramAnonymousInt });
        }
        AppMethodBeat.o(137993);
      }
    };
    this.mKf = paramContext.getResources().getDrawable(2131230991);
    this.mKg = new LinearLayout(paramContext);
    this.mKg.setPadding(a.fromDPToPix(paramContext, 2), 0, a.fromDPToPix(paramContext, 2), 0);
    this.mKg.setOrientation(0);
    addView(this.mKg, new FrameLayout.LayoutParams(-1, -1, 17));
    this.mKg.setDividerDrawable(this.mKf);
    this.mKg.setShowDividers(2);
    AppMethodBeat.o(137995);
  }
  
  public final int getPickersCount()
  {
    AppMethodBeat.i(138001);
    if (this.mKg == null)
    {
      AppMethodBeat.o(138001);
      return 0;
    }
    int i = this.mKg.getChildCount();
    AppMethodBeat.o(138001);
    return i;
  }
  
  public final View getView()
  {
    return this;
  }
  
  public final void onAttach(c paramc)
  {
    this.mKi = paramc;
  }
  
  public final void onDetach(c paramc)
  {
    this.mKi = null;
  }
  
  public final void onHide(c paramc)
  {
    AppMethodBeat.i(138002);
    int j = getPickersCount();
    int i = 0;
    while (i < j)
    {
      paramc = wb(i);
      if (paramc != null) {
        paramc.bBt();
      }
      i += 1;
    }
    AppMethodBeat.o(138002);
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(137998);
    if (this.aqk)
    {
      AppMethodBeat.o(137998);
      return false;
    }
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(137998);
    return bool;
  }
  
  public final void onShow(c paramc)
  {
    this.mKi = paramc;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(137999);
    if (this.aqk)
    {
      AppMethodBeat.o(137999);
      return false;
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(137999);
    return bool;
  }
  
  public final void requestLayout()
  {
    AppMethodBeat.i(137997);
    if (this.aqk)
    {
      this.mKh = true;
      AppMethodBeat.o(137997);
      return;
    }
    super.requestLayout();
    AppMethodBeat.o(137997);
  }
  
  public final void setLayoutFrozen(boolean paramBoolean)
  {
    AppMethodBeat.i(137996);
    if (this.aqk != paramBoolean)
    {
      this.aqk = paramBoolean;
      if (paramBoolean)
      {
        long l = SystemClock.uptimeMillis();
        onTouchEvent(MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0));
        AppMethodBeat.o(137996);
        return;
      }
      if (this.mKh) {
        requestLayout();
      }
    }
    AppMethodBeat.o(137996);
  }
  
  public final AppBrandOptionsPickerV2 wb(int paramInt)
  {
    AppMethodBeat.i(138000);
    if (paramInt < 0)
    {
      AppMethodBeat.o(138000);
      return null;
    }
    if (this.mKg == null)
    {
      AppMethodBeat.o(138000);
      return null;
    }
    AppBrandOptionsPickerV2 localAppBrandOptionsPickerV2 = (AppBrandOptionsPickerV2)this.mKg.getChildAt(paramInt);
    AppMethodBeat.o(138000);
    return localAppBrandOptionsPickerV2;
  }
  
  public final void wc(int paramInt)
  {
    AppMethodBeat.i(206843);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(206843);
      return;
    }
    int i = getPickersCount() - 1;
    while (paramInt > 0)
    {
      this.mKg.removeViewAt(i);
      i -= 1;
      paramInt -= 1;
    }
    AppMethodBeat.o(206843);
  }
  
  public static final class a
  {
    public final String[] mKl;
    public final int selected;
    
    public a(String[] paramArrayOfString, int paramInt)
    {
      AppMethodBeat.i(137994);
      this.mKl = paramArrayOfString;
      this.selected = Math.max(0, Math.min(paramInt, paramArrayOfString.length - 1));
      AppMethodBeat.o(137994);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker
 * JD-Core Version:    0.7.0.1
 */
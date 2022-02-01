package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import androidx.annotation.Keep;
import com.tencent.luggage.b.a.a.d;
import com.tencent.luggage.b.a.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;

public final class AppBrandMultiOptionsPicker
  extends FrameLayout
  implements com.tencent.mm.plugin.appbrand.jsapi.s.c<int[]>
{
  private boolean aki;
  private final Drawable rBX;
  public LinearLayout rBY;
  private boolean rBZ;
  private c rCa;
  public final YANumberPicker.b rCb;
  
  @Keep
  public AppBrandMultiOptionsPicker(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(137995);
    this.rCb = new YANumberPicker.b()
    {
      public final void a(YANumberPicker paramAnonymousYANumberPicker, int paramAnonymousInt)
      {
        AppMethodBeat.i(137993);
        if (AppBrandMultiOptionsPicker.a(AppBrandMultiOptionsPicker.this) != null)
        {
          int i = ((Integer)paramAnonymousYANumberPicker.getTag(a.e.app_brand_multi_options_picker_view_index_tag)).intValue();
          AppBrandMultiOptionsPicker.a(AppBrandMultiOptionsPicker.this).cV(new int[] { i, paramAnonymousInt });
        }
        AppMethodBeat.o(137993);
      }
    };
    this.rBX = paramContext.getResources().getDrawable(a.d.app_brand_multi_options_picker_column_divider);
    this.rBY = new LinearLayout(paramContext);
    this.rBY.setPadding(a.fromDPToPix(paramContext, 2), 0, a.fromDPToPix(paramContext, 2), 0);
    this.rBY.setOrientation(0);
    addView(this.rBY, new FrameLayout.LayoutParams(-1, -1, 17));
    this.rBY.setDividerDrawable(this.rBX);
    this.rBY.setShowDividers(2);
    AppMethodBeat.o(137995);
  }
  
  public final AppBrandOptionsPickerV2 Ea(int paramInt)
  {
    AppMethodBeat.i(138000);
    if (paramInt < 0)
    {
      AppMethodBeat.o(138000);
      return null;
    }
    if (this.rBY == null)
    {
      AppMethodBeat.o(138000);
      return null;
    }
    AppBrandOptionsPickerV2 localAppBrandOptionsPickerV2 = (AppBrandOptionsPickerV2)this.rBY.getChildAt(paramInt);
    AppMethodBeat.o(138000);
    return localAppBrandOptionsPickerV2;
  }
  
  public final void Eb(int paramInt)
  {
    AppMethodBeat.i(206488);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(206488);
      return;
    }
    int i = getPickersCount() - 1;
    while (paramInt > 0)
    {
      this.rBY.removeViewAt(i);
      i -= 1;
      paramInt -= 1;
    }
    AppMethodBeat.o(206488);
  }
  
  public final int getPickersCount()
  {
    AppMethodBeat.i(138001);
    if (this.rBY == null)
    {
      AppMethodBeat.o(138001);
      return 0;
    }
    int i = this.rBY.getChildCount();
    AppMethodBeat.o(138001);
    return i;
  }
  
  public final View getView()
  {
    return this;
  }
  
  public final void onAttach(c paramc)
  {
    this.rCa = paramc;
  }
  
  public final void onDetach(c paramc)
  {
    this.rCa = null;
  }
  
  public final void onHide(c paramc)
  {
    AppMethodBeat.i(138002);
    int j = getPickersCount();
    int i = 0;
    while (i < j)
    {
      paramc = Ea(i);
      if (paramc != null) {
        paramc.cpX();
      }
      i += 1;
    }
    AppMethodBeat.o(138002);
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(137998);
    if (this.aki)
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
    this.rCa = paramc;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(137999);
    if (this.aki)
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
    if (this.aki)
    {
      this.rBZ = true;
      AppMethodBeat.o(137997);
      return;
    }
    super.requestLayout();
    AppMethodBeat.o(137997);
  }
  
  public final void setLayoutFrozen(boolean paramBoolean)
  {
    AppMethodBeat.i(137996);
    if (this.aki != paramBoolean)
    {
      this.aki = paramBoolean;
      if (paramBoolean)
      {
        long l = SystemClock.uptimeMillis();
        onTouchEvent(MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0));
        AppMethodBeat.o(137996);
        return;
      }
      if (this.rBZ) {
        requestLayout();
      }
    }
    AppMethodBeat.o(137996);
  }
  
  public static final class a
  {
    public final String[] rCd;
    public final int selected;
    
    public a(String[] paramArrayOfString, int paramInt)
    {
      AppMethodBeat.i(137994);
      this.rCd = paramArrayOfString;
      this.selected = Math.max(0, Math.min(paramInt, paramArrayOfString.length - 1));
      AppMethodBeat.o(137994);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPicker
 * JD-Core Version:    0.7.0.1
 */
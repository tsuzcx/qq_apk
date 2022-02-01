package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.content.res.Resources;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.Keep;
import com.tencent.luggage.b.a.a.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.base.view.WheelView;
import java.util.ArrayList;
import java.util.List;

public final class AppBrandMultiOptionsPickerV2
  extends LinearLayout
  implements com.tencent.mm.plugin.appbrand.jsapi.s.c<int[]>
{
  private boolean aki;
  private boolean rBZ;
  private c rCa;
  public List<AppBrandOptionsPickerV3> rCe;
  
  @Keep
  public AppBrandMultiOptionsPickerV2(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(138007);
    setOrientation(0);
    this.rCe = new ArrayList();
    AppMethodBeat.o(138007);
  }
  
  public final void Eb(int paramInt)
  {
    AppMethodBeat.i(138015);
    if (paramInt <= 0)
    {
      AppMethodBeat.o(138015);
      return;
    }
    int i = getPickersCount() - 1;
    while (paramInt > 0)
    {
      removeViewAt(i);
      i -= 1;
      paramInt -= 1;
    }
    cpI();
    AppMethodBeat.o(138015);
  }
  
  public final AppBrandOptionsPickerV3 Ec(int paramInt)
  {
    AppMethodBeat.i(138012);
    if (paramInt < 0)
    {
      AppMethodBeat.o(138012);
      return null;
    }
    AppBrandOptionsPickerV3 localAppBrandOptionsPickerV3 = (AppBrandOptionsPickerV3)this.rCe.get(paramInt);
    AppMethodBeat.o(138012);
    return localAppBrandOptionsPickerV3;
  }
  
  public final void cpI()
  {
    AppMethodBeat.i(138014);
    if (this.rCe.size() == 1)
    {
      ((AppBrandOptionsPickerV3)this.rCe.get(0)).rCk.buW().setPadding(0, getContext().getResources().getDimensionPixelSize(a.c.Edge_2A), 0, getContext().getResources().getDimensionPixelSize(a.c.Edge_2A));
      AppMethodBeat.o(138014);
      return;
    }
    if (this.rCe.size() == 2)
    {
      ((AppBrandOptionsPickerV3)this.rCe.get(0)).rCk.buW().setPadding(0, getContext().getResources().getDimensionPixelSize(a.c.Edge_2A), getContext().getResources().getDimensionPixelSize(a.c.Edge_2A), getContext().getResources().getDimensionPixelSize(a.c.Edge_2A));
      ((AppBrandOptionsPickerV3)this.rCe.get(1)).rCk.buW().setPadding(getContext().getResources().getDimensionPixelSize(a.c.Edge_2A), getContext().getResources().getDimensionPixelSize(a.c.Edge_2A), 0, getContext().getResources().getDimensionPixelSize(a.c.Edge_2A));
      AppMethodBeat.o(138014);
      return;
    }
    if (this.rCe.size() == 3)
    {
      ((AppBrandOptionsPickerV3)this.rCe.get(0)).rCk.buW().setPadding(0, getContext().getResources().getDimensionPixelSize(a.c.Edge_2A), getContext().getResources().getDimensionPixelSize(a.c.Edge_0_5_A), getContext().getResources().getDimensionPixelSize(a.c.Edge_2A));
      ((AppBrandOptionsPickerV3)this.rCe.get(1)).rCk.buW().setPadding(getContext().getResources().getDimensionPixelSize(a.c.Edge_0_5_A), getContext().getResources().getDimensionPixelSize(a.c.Edge_2A), getContext().getResources().getDimensionPixelSize(a.c.Edge_0_5_A), getContext().getResources().getDimensionPixelSize(a.c.Edge_2A));
      ((AppBrandOptionsPickerV3)this.rCe.get(2)).rCk.buW().setPadding(getContext().getResources().getDimensionPixelSize(a.c.Edge_0_5_A), getContext().getResources().getDimensionPixelSize(a.c.Edge_2A), 0, getContext().getResources().getDimensionPixelSize(a.c.Edge_2A));
    }
    AppMethodBeat.o(138014);
  }
  
  public final int getPickersCount()
  {
    AppMethodBeat.i(138013);
    int i = getChildCount();
    AppMethodBeat.o(138013);
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
  
  public final void onHide(c paramc) {}
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(138010);
    if (this.aki)
    {
      AppMethodBeat.o(138010);
      return false;
    }
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(138010);
    return bool;
  }
  
  public final void onShow(c paramc)
  {
    this.rCa = paramc;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(138011);
    if (this.aki)
    {
      AppMethodBeat.o(138011);
      return false;
    }
    boolean bool = super.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(138011);
    return bool;
  }
  
  public final void requestLayout()
  {
    AppMethodBeat.i(138009);
    if (this.aki)
    {
      this.rBZ = true;
      AppMethodBeat.o(138009);
      return;
    }
    super.requestLayout();
    AppMethodBeat.o(138009);
  }
  
  public final void setLayoutFrozen(boolean paramBoolean)
  {
    AppMethodBeat.i(138008);
    if (this.aki != paramBoolean)
    {
      this.aki = paramBoolean;
      if (paramBoolean)
      {
        long l = SystemClock.uptimeMillis();
        onTouchEvent(MotionEvent.obtain(l, l, 3, 0.0F, 0.0F, 0));
        AppMethodBeat.o(138008);
        return;
      }
      if (this.rBZ) {
        requestLayout();
      }
    }
    AppMethodBeat.o(138008);
  }
  
  public static final class a
  {
    public final String[] rCd;
    public final int selected;
    
    public a(String[] paramArrayOfString, int paramInt)
    {
      AppMethodBeat.i(138006);
      this.rCd = paramArrayOfString;
      this.selected = Math.max(0, Math.min(paramInt, paramArrayOfString.length - 1));
      AppMethodBeat.o(138006);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.AppBrandMultiOptionsPickerV2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.car_license_plate.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.recyclerview.MRecyclerView;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/car_license_plate/ui/CarPlateListRecyclerViewBase;", "Lcom/tencent/mm/plugin/appbrand/widget/recyclerview/MRecyclerView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyle", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dispatchTouchEvent", "", "ev", "Landroid/view/MotionEvent;", "onInterceptTouchEvent", "e", "onTouchEvent", "plugin-car-license-plate_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class CarPlateListRecyclerViewBase
  extends MRecyclerView
{
  public CarPlateListRecyclerViewBase(Context paramContext)
  {
    super(paramContext);
  }
  
  public CarPlateListRecyclerViewBase(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public CarPlateListRecyclerViewBase(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = 1;
    AppMethodBeat.i(277666);
    RecyclerView.f localf = getItemAnimator();
    if ((localf != null) && (localf.isRunning() == true)) {}
    while (i != 0)
    {
      AppMethodBeat.o(277666);
      return false;
      i = 0;
    }
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    AppMethodBeat.o(277666);
    return bool;
  }
  
  public final boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = 1;
    AppMethodBeat.i(277659);
    RecyclerView.f localf = getItemAnimator();
    if ((localf != null) && (localf.isRunning() == true)) {}
    while (i != 0)
    {
      AppMethodBeat.o(277659);
      return false;
      i = 0;
    }
    boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
    AppMethodBeat.o(277659);
    return bool;
  }
  
  public final boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = 1;
    AppMethodBeat.i(277677);
    RecyclerView.f localf = getItemAnimator();
    if ((localf != null) && (localf.isRunning() == true)) {}
    while (i != 0)
    {
      AppMethodBeat.o(277677);
      return false;
      i = 0;
    }
    try
    {
      bool = super.onTouchEvent(paramMotionEvent);
      AppMethodBeat.o(277677);
      return bool;
    }
    catch (IndexOutOfBoundsException localIndexOutOfBoundsException)
    {
      for (;;)
      {
        paramMotionEvent = MotionEvent.obtain(paramMotionEvent);
        paramMotionEvent.setAction(3);
        ah localah = ah.aiuX;
        boolean bool = super.onTouchEvent(paramMotionEvent);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.car_license_plate.ui.CarPlateListRecyclerViewBase
 * JD-Core Version:    0.7.0.1
 */
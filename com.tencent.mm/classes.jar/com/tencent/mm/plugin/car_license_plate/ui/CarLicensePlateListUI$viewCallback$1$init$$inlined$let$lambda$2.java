package com.tencent.mm.plugin.car_license_plate.ui;

import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.n;
import androidx.recyclerview.widget.RecyclerView.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListUI$viewCallback$1$init$1$2$1", "Landroidx/recyclerview/widget/LinearLayoutManager;", "scrollVerticallyBy", "", "dy", "recycler", "Landroidx/recyclerview/widget/RecyclerView$Recycler;", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "supportsPredictiveItemAnimations", "", "plugin-car-license-plate_release", "com/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListUI$viewCallback$1$$special$$inlined$apply$lambda$2"})
public final class CarLicensePlateListUI$viewCallback$1$init$$inlined$let$lambda$2
  extends LinearLayoutManager
{
  CarLicensePlateListUI$viewCallback$1$init$$inlined$let$lambda$2(ViewGroup paramViewGroup, CarLicensePlateListUI.f paramf)
  {
    super(1, false);
  }
  
  public final int scrollVerticallyBy(int paramInt, RecyclerView.n paramn, RecyclerView.s params)
  {
    AppMethodBeat.i(186994);
    try
    {
      paramInt = super.scrollVerticallyBy(paramInt, paramn, params);
      AppMethodBeat.o(186994);
      return paramInt;
    }
    catch (IndexOutOfBoundsException paramn)
    {
      for (;;)
      {
        paramInt = 0;
      }
    }
  }
  
  public final boolean supportsPredictiveItemAnimations()
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.car_license_plate.ui.CarLicensePlateListUI.viewCallback.1.init..inlined.let.lambda.2
 * JD-Core Version:    0.7.0.1
 */
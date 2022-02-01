package com.tencent.mm.plugin.car_license_plate.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMActivity;
import kotlin.Metadata;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateBaseActivity;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "mainScope", "Lkotlinx/coroutines/CoroutineScope;", "getMainScope", "()Lkotlinx/coroutines/CoroutineScope;", "onDestroy", "", "plugin-car-license-plate_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class CarLicensePlateBaseActivity
  extends MMActivity
{
  final aq mainScope = ar.kBZ();
  
  public void _$_clearFindViewByIdCache() {}
  
  public void onDestroy()
  {
    if (ar.a(this.mainScope)) {
      ar.a(this.mainScope, null);
    }
    super.onDestroy();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.car_license_plate.ui.CarLicensePlateBaseActivity
 * JD-Core Version:    0.7.0.1
 */
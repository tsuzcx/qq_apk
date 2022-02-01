package com.tencent.mm.plugin.car_license_plate.ui;

import android.app.Activity;
import com.tencent.mm.plugin.car_license_plate.a.d;
import com.tencent.mm.plugin.car_license_plate.api.entity.MMCarLicensePlateInfo;
import kotlin.l;
import kotlinx.coroutines.ak;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListViewContract$ViewCallback;", "", "getActivityForResult", "Landroid/app/Activity;", "getCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "onRenderData", "", "data", "Lcom/tencent/mm/plugin/car_license_plate/api/entity/MMCarLicensePlateInfo;", "onRenderError", "exception", "Lcom/tencent/mm/plugin/car_license_plate/cgi/CgiException;", "onRenderLoading", "request", "Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListViewContract$ViewCallback$Request;", "Request", "plugin-car-license-plate_release"})
public abstract interface CarLicensePlateListViewContract$b
{
  public abstract void a(d paramd);
  
  public abstract void a(MMCarLicensePlateInfo paramMMCarLicensePlateInfo);
  
  public abstract void a(CarLicensePlateListViewContract.b.a parama);
  
  public abstract ak bQu();
  
  public abstract Activity bQv();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.car_license_plate.ui.CarLicensePlateListViewContract.b
 * JD-Core Version:    0.7.0.1
 */
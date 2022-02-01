package com.tencent.mm.plugin.car_license_plate.ui;

import androidx.recyclerview.widget.RecyclerView.f.c;
import androidx.recyclerview.widget.RecyclerView.v;
import androidx.recyclerview.widget.f;
import androidx.recyclerview.widget.w;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListUI$ListItemAnimator;", "Landroidx/recyclerview/widget/DefaultItemAnimator;", "(Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListUI;)V", "animateAdd", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "animateChange", "oldHolder", "newHolder", "preInfo", "Landroidx/recyclerview/widget/RecyclerView$ItemAnimator$ItemHolderInfo;", "postInfo", "canReuseUpdatedViewHolder", "viewHolder", "payloads", "", "", "plugin-car-license-plate_release"}, k=1, mv={1, 5, 1}, xi=48)
final class CarLicensePlateListUI$d
  extends f
{
  public CarLicensePlateListUI$d()
  {
    AppMethodBeat.i(277604);
    AppMethodBeat.o(277604);
  }
  
  public final boolean a(RecyclerView.v paramv1, RecyclerView.v paramv2, RecyclerView.f.c paramc1, RecyclerView.f.c paramc2)
  {
    AppMethodBeat.i(277610);
    s.u(paramv1, "oldHolder");
    s.u(paramv2, "newHolder");
    s.u(paramc1, "preInfo");
    s.u(paramc2, "postInfo");
    c(paramv1);
    r(paramv1);
    c(paramv2);
    r(paramv2);
    AppMethodBeat.o(277610);
    return false;
  }
  
  public final boolean a(RecyclerView.v paramv, List<Object> paramList)
  {
    AppMethodBeat.i(277616);
    s.u(paramv, "viewHolder");
    s.u(paramList, "payloads");
    if (((paramv instanceof CarLicensePlateListUI.e)) || (super.a(paramv, paramList)))
    {
      AppMethodBeat.o(277616);
      return true;
    }
    AppMethodBeat.o(277616);
    return false;
  }
  
  public final boolean b(RecyclerView.v paramv)
  {
    AppMethodBeat.i(277622);
    s.u(paramv, "holder");
    if (!(paramv instanceof CarLicensePlateListUI.e))
    {
      c(paramv);
      r(paramv);
      AppMethodBeat.o(277622);
      return false;
    }
    boolean bool = super.b(paramv);
    AppMethodBeat.o(277622);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.car_license_plate.ui.CarLicensePlateListUI.d
 * JD-Core Version:    0.7.0.1
 */
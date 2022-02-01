package com.tencent.mm.plugin.car_license_plate.ui;

import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.car_license_plate.a.d;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListUI$ListVHText;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "text", "Landroid/widget/TextView;", "renderPlateNo", "", "plateNo", "", "plugin-car-license-plate_release"}, k=1, mv={1, 5, 1}, xi=48)
final class CarLicensePlateListUI$e
  extends RecyclerView.v
{
  final TextView wdg;
  
  public CarLicensePlateListUI$e(View paramView)
  {
    super(paramView);
    AppMethodBeat.i(277609);
    paramView = paramView.findViewById(a.d.text);
    s.checkNotNull(paramView);
    this.wdg = ((TextView)paramView);
    AppMethodBeat.o(277609);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.car_license_plate.ui.CarLicensePlateListUI.e
 * JD-Core Version:    0.7.0.1
 */
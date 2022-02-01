package com.tencent.mm.plugin.car_license_plate.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewParent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.b.a;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListUI$ListAdapter$onLongClick$1", "Lcom/tencent/mm/ui/widget/menu/MMPopupMenu;", "dismiss", "", "show", "xDown", "", "yDown", "plugin-car-license-plate_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class CarLicensePlateListUI$b$a
  extends a
{
  CarLicensePlateListUI$b$a(View paramView, Context paramContext)
  {
    super(paramContext);
  }
  
  public final boolean diW()
  {
    AppMethodBeat.i(277738);
    ViewParent localViewParent = this.$v.getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(false);
    }
    boolean bool = super.diW();
    AppMethodBeat.o(277738);
    return bool;
  }
  
  public final boolean fQ(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(277734);
    ViewParent localViewParent = this.$v.getParent();
    if (localViewParent != null) {
      localViewParent.requestDisallowInterceptTouchEvent(true);
    }
    boolean bool = super.fQ(paramInt1, paramInt2);
    AppMethodBeat.o(277734);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.car_license_plate.ui.CarLicensePlateListUI.b.a
 * JD-Core Version:    0.7.0.1
 */
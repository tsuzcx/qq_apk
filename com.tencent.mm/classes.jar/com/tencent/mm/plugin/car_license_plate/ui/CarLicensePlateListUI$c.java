package com.tencent.mm.plugin.car_license_plate.ui;

import androidx.recyclerview.widget.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListUI$ListDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "newList", "(Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "plugin-car-license-plate_release"})
public final class CarLicensePlateListUI$c
  extends h.a
{
  private final ArrayList<String> sYO;
  private final ArrayList<String> sYP;
  
  public CarLicensePlateListUI$c(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    AppMethodBeat.i(187350);
    this.sYO = paramArrayList1;
    this.sYP = paramArrayList2;
    AppMethodBeat.o(187350);
  }
  
  public final boolean Z(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(187343);
    boolean bool = ab(paramInt1, paramInt2);
    AppMethodBeat.o(187343);
    return bool;
  }
  
  public final boolean ab(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(187344);
    String str1 = (String)j.M((List)this.sYO, paramInt1);
    String str2 = (String)j.M((List)this.sYP, paramInt2);
    if ((str1 != null) && (p.h(str1, str2)))
    {
      AppMethodBeat.o(187344);
      return true;
    }
    AppMethodBeat.o(187344);
    return false;
  }
  
  public final int jL()
  {
    AppMethodBeat.i(187339);
    int i = this.sYO.size();
    AppMethodBeat.o(187339);
    return i;
  }
  
  public final int jM()
  {
    AppMethodBeat.i(187341);
    int i = this.sYP.size();
    AppMethodBeat.o(187341);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.car_license_plate.ui.CarLicensePlateListUI.c
 * JD-Core Version:    0.7.0.1
 */
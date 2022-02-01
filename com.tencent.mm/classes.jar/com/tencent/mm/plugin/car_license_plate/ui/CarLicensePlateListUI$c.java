package com.tencent.mm.plugin.car_license_plate.ui;

import androidx.recyclerview.widget.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListUI$ListDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldList", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "newList", "(Ljava/util/ArrayList;Ljava/util/ArrayList;)V", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "plugin-car-license-plate_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class CarLicensePlateListUI$c
  extends g.a
{
  private final ArrayList<String> wde;
  private final ArrayList<String> wdf;
  
  public CarLicensePlateListUI$c(ArrayList<String> paramArrayList1, ArrayList<String> paramArrayList2)
  {
    AppMethodBeat.i(277620);
    this.wde = paramArrayList1;
    this.wdf = paramArrayList2;
    AppMethodBeat.o(277620);
  }
  
  public final int If()
  {
    AppMethodBeat.i(277627);
    int i = this.wde.size();
    AppMethodBeat.o(277627);
    return i;
  }
  
  public final int Ig()
  {
    AppMethodBeat.i(277636);
    int i = this.wdf.size();
    AppMethodBeat.o(277636);
    return i;
  }
  
  public final boolean aU(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(277638);
    boolean bool = aV(paramInt1, paramInt2);
    AppMethodBeat.o(277638);
    return bool;
  }
  
  public final boolean aV(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(277645);
    String str1 = (String)p.ae((List)this.wde, paramInt1);
    String str2 = (String)p.ae((List)this.wdf, paramInt2);
    if ((str1 != null) && (s.p(str1, str2)))
    {
      AppMethodBeat.o(277645);
      return true;
    }
    AppMethodBeat.o(277645);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.car_license_plate.ui.CarLicensePlateListUI.c
 * JD-Core Version:    0.7.0.1
 */
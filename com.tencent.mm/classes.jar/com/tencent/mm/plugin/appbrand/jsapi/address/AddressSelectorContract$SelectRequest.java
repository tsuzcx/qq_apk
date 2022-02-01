package com.tencent.mm.plugin.appbrand.jsapi.address;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/address/AddressSelectorContract$SelectRequest;", "Landroid/os/Parcelable;", "mode", "Lcom/tencent/mm/plugin/appbrand/jsapi/address/AddressSelectorContract$Mode;", "current", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "(Lcom/tencent/mm/plugin/appbrand/jsapi/address/AddressSelectorContract$Mode;Ljava/util/ArrayList;)V", "getCurrent", "()Ljava/util/ArrayList;", "getMode", "()Lcom/tencent/mm/plugin/appbrand/jsapi/address/AddressSelectorContract$Mode;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-select-address-contract_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AddressSelectorContract$SelectRequest
  implements Parcelable
{
  public static final Parcelable.Creator<SelectRequest> CREATOR;
  final AddressSelectorContract.a rBV;
  final ArrayList<String> rBW;
  
  static
  {
    AppMethodBeat.i(326491);
    CREATOR = (Parcelable.Creator)new a();
    AppMethodBeat.o(326491);
  }
  
  public AddressSelectorContract$SelectRequest(AddressSelectorContract.a parama, ArrayList<String> paramArrayList)
  {
    AppMethodBeat.i(326483);
    this.rBV = parama;
    this.rBW = paramArrayList;
    AppMethodBeat.o(326483);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(326521);
    if (this == paramObject)
    {
      AppMethodBeat.o(326521);
      return true;
    }
    if (!(paramObject instanceof SelectRequest))
    {
      AppMethodBeat.o(326521);
      return false;
    }
    paramObject = (SelectRequest)paramObject;
    if (this.rBV != paramObject.rBV)
    {
      AppMethodBeat.o(326521);
      return false;
    }
    if (!s.p(this.rBW, paramObject.rBW))
    {
      AppMethodBeat.o(326521);
      return false;
    }
    AppMethodBeat.o(326521);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(326512);
    int j = this.rBV.hashCode();
    if (this.rBW == null) {}
    for (int i = 0;; i = this.rBW.hashCode())
    {
      AppMethodBeat.o(326512);
      return i + j * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(326505);
    String str = "SelectRequest(mode=" + this.rBV + ", current=" + this.rBW + ')';
    AppMethodBeat.o(326505);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(326532);
    s.u(paramParcel, "out");
    AddressSelectorContract.a.b localb = AddressSelectorContract.a.b.rBU;
    AddressSelectorContract.a.b.a(this.rBV, paramParcel);
    paramParcel.writeStringList((List)this.rBW);
    AppMethodBeat.o(326532);
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<AddressSelectorContract.SelectRequest>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.address.AddressSelectorContract.SelectRequest
 * JD-Core Version:    0.7.0.1
 */
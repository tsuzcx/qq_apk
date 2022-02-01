package com.tencent.mm.plugin.appbrand.jsapi.address;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/address/AddressSelectorContract$SelectResponse;", "Landroid/os/Parcelable;", "list", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/jsapi/address/AddressSelectorContract$AddressNode;", "Lkotlin/collections/ArrayList;", "postcode", "", "(Ljava/util/ArrayList;I)V", "getList", "()Ljava/util/ArrayList;", "getPostcode", "()I", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-select-address-contract_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AddressSelectorContract$SelectResponse
  implements Parcelable
{
  public static final Parcelable.Creator<SelectResponse> CREATOR;
  final ArrayList<AddressSelectorContract.AddressNode> hqL;
  final int rBX;
  
  static
  {
    AppMethodBeat.i(326504);
    CREATOR = (Parcelable.Creator)new a();
    AppMethodBeat.o(326504);
  }
  
  public AddressSelectorContract$SelectResponse(ArrayList<AddressSelectorContract.AddressNode> paramArrayList, int paramInt)
  {
    AppMethodBeat.i(326497);
    this.hqL = paramArrayList;
    this.rBX = paramInt;
    AppMethodBeat.o(326497);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(326519);
    if (this == paramObject)
    {
      AppMethodBeat.o(326519);
      return true;
    }
    if (!(paramObject instanceof SelectResponse))
    {
      AppMethodBeat.o(326519);
      return false;
    }
    paramObject = (SelectResponse)paramObject;
    if (!s.p(this.hqL, paramObject.hqL))
    {
      AppMethodBeat.o(326519);
      return false;
    }
    if (this.rBX != paramObject.rBX)
    {
      AppMethodBeat.o(326519);
      return false;
    }
    AppMethodBeat.o(326519);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(326513);
    int i = this.hqL.hashCode();
    int j = this.rBX;
    AppMethodBeat.o(326513);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(326507);
    String str = "SelectResponse(list=" + this.hqL + ", postcode=" + this.rBX + ')';
    AppMethodBeat.o(326507);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(326525);
    s.u(paramParcel, "out");
    Object localObject = this.hqL;
    paramParcel.writeInt(((ArrayList)localObject).size());
    localObject = ((ArrayList)localObject).iterator();
    while (((Iterator)localObject).hasNext()) {
      ((AddressSelectorContract.AddressNode)((Iterator)localObject).next()).writeToParcel(paramParcel, paramInt);
    }
    paramParcel.writeInt(this.rBX);
    AppMethodBeat.o(326525);
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<AddressSelectorContract.SelectResponse>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.address.AddressSelectorContract.SelectResponse
 * JD-Core Version:    0.7.0.1
 */
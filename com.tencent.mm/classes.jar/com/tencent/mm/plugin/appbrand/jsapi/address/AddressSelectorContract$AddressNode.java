package com.tencent.mm.plugin.appbrand.jsapi.address;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/jsapi/address/AddressSelectorContract$AddressNode;", "Landroid/os/Parcelable;", "name", "", "code", "", "(Ljava/lang/String;I)V", "getCode", "()I", "getName", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "plugin-select-address-contract_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AddressSelectorContract$AddressNode
  implements Parcelable
{
  public static final Parcelable.Creator<AddressNode> CREATOR;
  final int code;
  final String name;
  
  static
  {
    AppMethodBeat.i(326502);
    CREATOR = (Parcelable.Creator)new a();
    AppMethodBeat.o(326502);
  }
  
  public AddressSelectorContract$AddressNode(String paramString, int paramInt)
  {
    AppMethodBeat.i(326493);
    this.name = paramString;
    this.code = paramInt;
    AppMethodBeat.o(326493);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(326520);
    if (this == paramObject)
    {
      AppMethodBeat.o(326520);
      return true;
    }
    if (!(paramObject instanceof AddressNode))
    {
      AppMethodBeat.o(326520);
      return false;
    }
    paramObject = (AddressNode)paramObject;
    if (!s.p(this.name, paramObject.name))
    {
      AppMethodBeat.o(326520);
      return false;
    }
    if (this.code != paramObject.code)
    {
      AppMethodBeat.o(326520);
      return false;
    }
    AppMethodBeat.o(326520);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(326514);
    int i = this.name.hashCode();
    int j = this.code;
    AppMethodBeat.o(326514);
    return i * 31 + j;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(326508);
    String str = "AddressNode(name=" + this.name + ", code=" + this.code + ')';
    AppMethodBeat.o(326508);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(326526);
    s.u(paramParcel, "out");
    paramParcel.writeString(this.name);
    paramParcel.writeInt(this.code);
    AppMethodBeat.o(326526);
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<AddressSelectorContract.AddressNode>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.address.AddressSelectorContract.AddressNode
 * JD-Core Version:    0.7.0.1
 */
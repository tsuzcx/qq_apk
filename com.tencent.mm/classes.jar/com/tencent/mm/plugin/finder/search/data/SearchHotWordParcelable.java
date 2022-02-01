package com.tencent.mm.plugin.finder.search.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bio;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/search/data/SearchHotWordParcelable;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "searchHotWord", "Lcom/tencent/mm/protocal/protobuf/FinderSearchHotWord;", "getSearchHotWord", "()Lcom/tencent/mm/protocal/protobuf/FinderSearchHotWord;", "setSearchHotWord", "(Lcom/tencent/mm/protocal/protobuf/FinderSearchHotWord;)V", "describeContents", "", "toString", "", "writeToParcel", "", "flags", "CREATOR", "plugin-finder_release"})
public final class SearchHotWordParcelable
  implements Parcelable
{
  public static final a CREATOR;
  public bio AcT;
  
  static
  {
    AppMethodBeat.i(280574);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(280574);
  }
  
  public SearchHotWordParcelable() {}
  
  public SearchHotWordParcelable(Parcel paramParcel)
  {
    this();
    AppMethodBeat.i(280572);
    byte[] arrayOfByte = new byte[paramParcel.readInt()];
    paramParcel.readByteArray(arrayOfByte);
    paramParcel = new bio();
    paramParcel.parseFrom(arrayOfByte);
    this.AcT = paramParcel;
    AppMethodBeat.o(280572);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    Object localObject = this.AcT;
    if (localObject != null)
    {
      String str = ((bio)localObject).SSO;
      localObject = str;
      if (str != null) {}
    }
    else
    {
      localObject = "null";
    }
    return localObject;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(280571);
    p.k(paramParcel, "parcel");
    Object localObject = this.AcT;
    if (localObject != null)
    {
      localObject = ((bio)localObject).toByteArray();
      paramParcel.writeInt(localObject.length);
      paramParcel.writeByteArray((byte[])localObject);
      AppMethodBeat.o(280571);
      return;
    }
    AppMethodBeat.o(280571);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/search/data/SearchHotWordParcelable$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/finder/search/data/SearchHotWordParcelable;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/finder/search/data/SearchHotWordParcelable;", "plugin-finder_release"})
  public static final class a
    implements Parcelable.Creator<SearchHotWordParcelable>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.data.SearchHotWordParcelable
 * JD-Core Version:    0.7.0.1
 */
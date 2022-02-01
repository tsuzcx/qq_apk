package com.tencent.mm.plugin.finder.search.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bux;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/search/data/SearchHotWordParcelable;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "searchHotWord", "Lcom/tencent/mm/protocal/protobuf/FinderSearchHotWord;", "getSearchHotWord", "()Lcom/tencent/mm/protocal/protobuf/FinderSearchHotWord;", "setSearchHotWord", "(Lcom/tencent/mm/protocal/protobuf/FinderSearchHotWord;)V", "describeContents", "", "toString", "", "writeToParcel", "", "flags", "CREATOR", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class SearchHotWordParcelable
  implements Parcelable
{
  public static final a CREATOR;
  public bux FyF;
  
  static
  {
    AppMethodBeat.i(342768);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(342768);
  }
  
  public SearchHotWordParcelable() {}
  
  public SearchHotWordParcelable(Parcel paramParcel)
  {
    this();
    AppMethodBeat.i(342762);
    Object localObject = new byte[paramParcel.readInt()];
    paramParcel.readByteArray((byte[])localObject);
    paramParcel = new bux();
    paramParcel.parseFrom((byte[])localObject);
    localObject = ah.aiuX;
    this.FyF = paramParcel;
    AppMethodBeat.o(342762);
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    Object localObject = this.FyF;
    if (localObject == null) {
      localObject = "null";
    }
    String str;
    do
    {
      return localObject;
      str = ((bux)localObject).aacq;
      localObject = str;
    } while (str != null);
    return "null";
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(342777);
    s.u(paramParcel, "parcel");
    Object localObject = this.FyF;
    if (localObject != null)
    {
      localObject = ((bux)localObject).toByteArray();
      paramParcel.writeInt(localObject.length);
      paramParcel.writeByteArray((byte[])localObject);
    }
    AppMethodBeat.o(342777);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/search/data/SearchHotWordParcelable$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/finder/search/data/SearchHotWordParcelable;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/finder/search/data/SearchHotWordParcelable;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<SearchHotWordParcelable>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.data.SearchHotWordParcelable
 * JD-Core Version:    0.7.0.1
 */
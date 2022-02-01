package com.tencent.mm.plugin.finder.search.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bux;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/search/data/SearchHotWordListParcelable;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "TAG", "", "hotWordParcelable", "Lcom/tencent/mm/plugin/finder/search/data/SearchHotWordParcelable;", "getHotWordParcelable", "()Lcom/tencent/mm/plugin/finder/search/data/SearchHotWordParcelable;", "setHotWordParcelable", "(Lcom/tencent/mm/plugin/finder/search/data/SearchHotWordParcelable;)V", "position", "", "getPosition", "()I", "setPosition", "(I)V", "searchHotWordParcelableList", "Ljava/util/LinkedList;", "getSearchHotWordParcelableList", "()Ljava/util/LinkedList;", "setSearchHotWordParcelableList", "(Ljava/util/LinkedList;)V", "append", "", "list", "Lcom/tencent/mm/protocal/protobuf/FinderSearchHotWord;", "describeContents", "getCurHotWord", "isAtEnd", "", "removePrev", "hotWord", "hotWordText", "toString", "writeToParcel", "flags", "CREATOR", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class SearchHotWordListParcelable
  implements Parcelable
{
  public static final a CREATOR;
  public SearchHotWordParcelable FyD;
  public LinkedList<SearchHotWordParcelable> FyE;
  private final String TAG;
  public int position;
  
  static
  {
    AppMethodBeat.i(342772);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(342772);
  }
  
  public SearchHotWordListParcelable()
  {
    AppMethodBeat.i(342757);
    this.TAG = "Finder.SearchHotWordList";
    this.position = -1;
    this.FyE = new LinkedList();
    AppMethodBeat.o(342757);
  }
  
  public SearchHotWordListParcelable(Parcel paramParcel)
  {
    this();
    AppMethodBeat.i(342763);
    this.FyD = ((SearchHotWordParcelable)paramParcel.readParcelable(SearchHotWordParcelable.class.getClassLoader()));
    this.position = paramParcel.readInt();
    paramParcel.readTypedList((List)this.FyE, (Parcelable.Creator)SearchHotWordParcelable.CREATOR);
    AppMethodBeat.o(342763);
  }
  
  public final void aAk(String paramString)
  {
    AppMethodBeat.i(342784);
    s.u(paramString, "hotWordText");
    if (Util.isNullOrNil(paramString))
    {
      Log.i(this.TAG, "removePre return for empty");
      AppMethodBeat.o(342784);
      return;
    }
    Iterator localIterator = this.FyE.iterator();
    int i = -1;
    for (;;)
    {
      SearchHotWordParcelable localSearchHotWordParcelable;
      if (localIterator.hasNext())
      {
        localSearchHotWordParcelable = (SearchHotWordParcelable)localIterator.next();
        localObject = localSearchHotWordParcelable.FyF;
        if (localObject != null) {
          break label175;
        }
      }
      label175:
      for (Object localObject = null; Util.isEqual((String)localObject, paramString); localObject = ((bux)localObject).aacq)
      {
        Log.i(this.TAG, "remove :" + paramString + " index:" + this.FyE.indexOf(localSearchHotWordParcelable) + ": position:" + this.position);
        if ((i >= 0) && (i < this.FyE.size()))
        {
          this.FyE.remove(i);
          this.position = (i - 1);
        }
        AppMethodBeat.o(342784);
        return;
      }
      i += 1;
    }
  }
  
  public final int describeContents()
  {
    return 0;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(342796);
    String str = this.FyD + " pos:" + this.position + " list:" + this.FyE;
    AppMethodBeat.o(342796);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(342789);
    s.u(paramParcel, "parcel");
    paramParcel.writeParcelable((Parcelable)this.FyD, paramInt);
    paramParcel.writeInt(this.position);
    paramParcel.writeTypedList((List)this.FyE);
    AppMethodBeat.o(342789);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/search/data/SearchHotWordListParcelable$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/finder/search/data/SearchHotWordListParcelable;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/finder/search/data/SearchHotWordListParcelable;", "transform", "hotWord", "Lcom/tencent/mm/protocal/protobuf/FinderSearchHotWord;", "position", "hotWordList", "", "transformFinderSearchHotWordList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/search/data/SearchHotWordParcelable;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements Parcelable.Creator<SearchHotWordListParcelable>
  {
    public static SearchHotWordListParcelable a(bux parambux, int paramInt, List<? extends bux> paramList)
    {
      AppMethodBeat.i(342781);
      SearchHotWordParcelable localSearchHotWordParcelable = new SearchHotWordParcelable();
      localSearchHotWordParcelable.FyF = parambux;
      parambux = new SearchHotWordListParcelable();
      parambux.FyD = localSearchHotWordParcelable;
      parambux.position = paramInt;
      paramList = hs(paramList);
      s.u(paramList, "<set-?>");
      parambux.FyE = paramList;
      AppMethodBeat.o(342781);
      return parambux;
    }
    
    private static LinkedList<SearchHotWordParcelable> hs(List<? extends bux> paramList)
    {
      AppMethodBeat.i(342787);
      LinkedList localLinkedList = new LinkedList();
      if (paramList != null)
      {
        paramList = ((Iterable)paramList).iterator();
        while (paramList.hasNext())
        {
          bux localbux = (bux)paramList.next();
          SearchHotWordParcelable localSearchHotWordParcelable = new SearchHotWordParcelable();
          localSearchHotWordParcelable.FyF = localbux;
          localLinkedList.add(localSearchHotWordParcelable);
        }
      }
      AppMethodBeat.o(342787);
      return localLinkedList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.data.SearchHotWordListParcelable
 * JD-Core Version:    0.7.0.1
 */
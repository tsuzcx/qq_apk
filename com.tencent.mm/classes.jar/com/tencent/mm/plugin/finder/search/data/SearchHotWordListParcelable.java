package com.tencent.mm.plugin.finder.search.data;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bio;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/search/data/SearchHotWordListParcelable;", "Landroid/os/Parcelable;", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "()V", "TAG", "", "hotWordParcelable", "Lcom/tencent/mm/plugin/finder/search/data/SearchHotWordParcelable;", "getHotWordParcelable", "()Lcom/tencent/mm/plugin/finder/search/data/SearchHotWordParcelable;", "setHotWordParcelable", "(Lcom/tencent/mm/plugin/finder/search/data/SearchHotWordParcelable;)V", "position", "", "getPosition", "()I", "setPosition", "(I)V", "searchHotWordParcelableList", "Ljava/util/LinkedList;", "getSearchHotWordParcelableList", "()Ljava/util/LinkedList;", "setSearchHotWordParcelableList", "(Ljava/util/LinkedList;)V", "append", "", "list", "Lcom/tencent/mm/protocal/protobuf/FinderSearchHotWord;", "describeContents", "getCurHotWord", "isAtEnd", "", "removePrev", "hotWord", "hotWordText", "toString", "writeToParcel", "flags", "CREATOR", "plugin-finder_release"})
public final class SearchHotWordListParcelable
  implements Parcelable
{
  public static final a CREATOR;
  public SearchHotWordParcelable AcR;
  public LinkedList<SearchHotWordParcelable> AcS;
  private final String TAG;
  public int position;
  
  static
  {
    AppMethodBeat.i(223581);
    CREATOR = new a((byte)0);
    AppMethodBeat.o(223581);
  }
  
  public SearchHotWordListParcelable()
  {
    AppMethodBeat.i(223576);
    this.TAG = "Finder.SearchHotWordList";
    this.position = -1;
    this.AcS = new LinkedList();
    AppMethodBeat.o(223576);
  }
  
  public SearchHotWordListParcelable(Parcel paramParcel)
  {
    this();
    AppMethodBeat.i(223579);
    this.AcR = ((SearchHotWordParcelable)paramParcel.readParcelable(SearchHotWordParcelable.class.getClassLoader()));
    this.position = paramParcel.readInt();
    paramParcel.readTypedList((List)this.AcS, (Parcelable.Creator)SearchHotWordParcelable.CREATOR);
    AppMethodBeat.o(223579);
  }
  
  public final void aEr(String paramString)
  {
    AppMethodBeat.i(223564);
    p.k(paramString, "hotWordText");
    if (Util.isNullOrNil(paramString))
    {
      Log.i(this.TAG, "removePre return for empty");
      AppMethodBeat.o(223564);
      return;
    }
    Iterator localIterator = this.AcS.iterator();
    int i = -1;
    for (;;)
    {
      SearchHotWordParcelable localSearchHotWordParcelable;
      if (localIterator.hasNext())
      {
        localSearchHotWordParcelable = (SearchHotWordParcelable)localIterator.next();
        localObject = localSearchHotWordParcelable.AcT;
        if (localObject == null) {
          break label178;
        }
      }
      label178:
      for (Object localObject = ((bio)localObject).SSO; Util.isEqual((String)localObject, paramString); localObject = null)
      {
        Log.i(this.TAG, "remove :" + paramString + " index:" + this.AcS.indexOf(localSearchHotWordParcelable) + ": position:" + this.position);
        if ((i >= 0) && (i < this.AcS.size()))
        {
          this.AcS.remove(i);
          this.position = (i - 1);
        }
        AppMethodBeat.o(223564);
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
    AppMethodBeat.i(223573);
    String str = String.valueOf(this.AcR) + " pos:" + this.position + " list:" + this.AcS;
    AppMethodBeat.o(223573);
    return str;
  }
  
  public final void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(223567);
    p.k(paramParcel, "parcel");
    paramParcel.writeParcelable((Parcelable)this.AcR, paramInt);
    paramParcel.writeInt(this.position);
    paramParcel.writeTypedList((List)this.AcS);
    AppMethodBeat.o(223567);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/search/data/SearchHotWordListParcelable$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/tencent/mm/plugin/finder/search/data/SearchHotWordListParcelable;", "()V", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "", "(I)[Lcom/tencent/mm/plugin/finder/search/data/SearchHotWordListParcelable;", "transform", "hotWord", "Lcom/tencent/mm/protocal/protobuf/FinderSearchHotWord;", "position", "hotWordList", "", "transformFinderSearchHotWordList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/finder/search/data/SearchHotWordParcelable;", "plugin-finder_release"})
  public static final class a
    implements Parcelable.Creator<SearchHotWordListParcelable>
  {
    public static SearchHotWordListParcelable a(bio parambio, int paramInt, List<? extends bio> paramList)
    {
      AppMethodBeat.i(278576);
      SearchHotWordParcelable localSearchHotWordParcelable = new SearchHotWordParcelable();
      localSearchHotWordParcelable.AcT = parambio;
      parambio = new SearchHotWordListParcelable();
      parambio.AcR = localSearchHotWordParcelable;
      parambio.position = paramInt;
      paramList = eI(paramList);
      p.k(paramList, "<set-?>");
      parambio.AcS = paramList;
      AppMethodBeat.o(278576);
      return parambio;
    }
    
    private static LinkedList<SearchHotWordParcelable> eI(List<? extends bio> paramList)
    {
      AppMethodBeat.i(278577);
      LinkedList localLinkedList = new LinkedList();
      if (paramList != null)
      {
        paramList = ((Iterable)paramList).iterator();
        while (paramList.hasNext())
        {
          bio localbio = (bio)paramList.next();
          SearchHotWordParcelable localSearchHotWordParcelable = new SearchHotWordParcelable();
          localSearchHotWordParcelable.AcT = localbio;
          localLinkedList.add(localSearchHotWordParcelable);
        }
      }
      AppMethodBeat.o(278577);
      return localLinkedList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.search.data.SearchHotWordListParcelable
 * JD-Core Version:    0.7.0.1
 */
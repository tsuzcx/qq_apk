package com.tencent.mm.plugin.finder.feed.model.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import d.a.j;
import d.g.b.k;
import d.l;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/internal/DataStore;", "T", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "dataList", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "getDataList", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "setDataList", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;)V", "keep", "", "getKeep", "()Ljava/util/Set;", "get", "index", "", "(I)Ljava/lang/Object;", "getDataListJustForAdapter", "getLast", "()Ljava/lang/Object;", "getListInfo", "getSize", "isEmpty", "", "safeGet", "plugin-finder_release"})
public class DataStore<T>
{
  private String TAG;
  private DataBuffer<T> dataList;
  private final Set<Object> keep;
  
  public DataStore()
  {
    AppMethodBeat.i(166103);
    this.TAG = "Finder.FinderFeedLoader";
    setTAG(getTAG() + "_@" + hashCode());
    this.keep = ((Set)new HashSet());
    this.dataList = new DataBuffer(new ArrayList());
    AppMethodBeat.o(166103);
  }
  
  public final T get(int paramInt)
  {
    AppMethodBeat.i(166101);
    Object localObject = this.dataList.get(paramInt);
    AppMethodBeat.o(166101);
    return localObject;
  }
  
  public final DataBuffer<T> getDataList()
  {
    return this.dataList;
  }
  
  public final DataBuffer<T> getDataListJustForAdapter()
  {
    return this.dataList;
  }
  
  public final Set<Object> getKeep()
  {
    return this.keep;
  }
  
  public final T getLast()
  {
    AppMethodBeat.i(166100);
    Object localObject = j.iQ((List)this.dataList);
    AppMethodBeat.o(166100);
    return localObject;
  }
  
  public final String getListInfo()
  {
    AppMethodBeat.i(202258);
    String str = "DataStore: info count: " + this.dataList.size();
    ac.i(getTAG(), str);
    Iterator localIterator = ((Iterable)this.dataList).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (i < 0) {
        j.fOc();
      }
      ac.i(getTAG(), "DataStore:index " + i + " obj:" + String.valueOf(localObject));
      i += 1;
    }
    AppMethodBeat.o(202258);
    return str;
  }
  
  public final int getSize()
  {
    AppMethodBeat.i(202257);
    int i = this.dataList.size();
    AppMethodBeat.o(202257);
    return i;
  }
  
  public String getTAG()
  {
    return this.TAG;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(202256);
    boolean bool = this.dataList.isEmpty();
    AppMethodBeat.o(202256);
    return bool;
  }
  
  public final T safeGet(int paramInt)
  {
    AppMethodBeat.i(166102);
    if ((paramInt >= 0) && (paramInt < this.dataList.size()))
    {
      Object localObject = this.dataList.get(paramInt);
      AppMethodBeat.o(166102);
      return localObject;
    }
    AppMethodBeat.o(166102);
    return null;
  }
  
  public final void setDataList(DataBuffer<T> paramDataBuffer)
  {
    AppMethodBeat.i(202255);
    k.h(paramDataBuffer, "<set-?>");
    this.dataList = paramDataBuffer;
    AppMethodBeat.o(202255);
  }
  
  public void setTAG(String paramString)
  {
    AppMethodBeat.i(166099);
    k.h(paramString, "<set-?>");
    this.TAG = paramString;
    AppMethodBeat.o(166099);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.DataStore
 * JD-Core Version:    0.7.0.1
 */
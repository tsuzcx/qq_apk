package com.tencent.mm.plugin.finder.feed.model.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/internal/DataStore;", "T", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "dataList", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "getDataList", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "setDataList", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;)V", "get", "index", "", "(I)Ljava/lang/Object;", "getDataListJustForAdapter", "getLast", "()Ljava/lang/Object;", "getLastItemOfType", "E", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "getListInfo", "getListOfType", "", "getSize", "isEmpty", "", "safeGet", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public class DataStore<T>
{
  private String TAG;
  public DataBuffer<T> dataList;
  
  public DataStore()
  {
    AppMethodBeat.i(166103);
    this.TAG = ("Finder." + getClass().getSimpleName() + "_@" + hashCode());
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
  
  public final T getLast()
  {
    AppMethodBeat.i(166100);
    Object localObject = p.oN((List)this.dataList);
    AppMethodBeat.o(166100);
    return localObject;
  }
  
  public final <E> E getLastItemOfType(Class<E> paramClass)
  {
    AppMethodBeat.i(366673);
    s.u(paramClass, "clazz");
    Object localObject = (List)this.dataList;
    ListIterator localListIterator = ((List)localObject).listIterator(((List)localObject).size());
    do
    {
      if (!localListIterator.hasPrevious()) {
        break;
      }
      localObject = localListIterator.previous();
    } while (!paramClass.isInstance(localObject));
    for (paramClass = (Class<E>)localObject; paramClass != null; paramClass = null)
    {
      AppMethodBeat.o(366673);
      return paramClass;
    }
    AppMethodBeat.o(366673);
    return null;
  }
  
  public final String getListInfo()
  {
    AppMethodBeat.i(366658);
    String str = s.X("DataStore: info count: ", Integer.valueOf(this.dataList.size()));
    Log.i(getTAG(), str);
    Iterator localIterator = ((Iterable)this.dataList).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (i < 0) {
        p.kkW();
      }
      Log.i(getTAG(), "DataStore:index " + i + " obj:" + localObject);
      i += 1;
    }
    AppMethodBeat.o(366658);
    return str;
  }
  
  public final <E> List<E> getListOfType(Class<E> paramClass)
  {
    AppMethodBeat.i(366665);
    s.u(paramClass, "clazz");
    List localList = (List)new ArrayList();
    Iterator localIterator = ((Iterable)this.dataList).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (paramClass.isInstance(localObject)) {
        localList.add(localObject);
      }
    }
    AppMethodBeat.o(366665);
    return localList;
  }
  
  public final int getSize()
  {
    AppMethodBeat.i(366638);
    int i = this.dataList.size();
    AppMethodBeat.o(366638);
    return i;
  }
  
  public String getTAG()
  {
    return this.TAG;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(366633);
    boolean bool = this.dataList.isEmpty();
    AppMethodBeat.o(366633);
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
    AppMethodBeat.i(366628);
    s.u(paramDataBuffer, "<set-?>");
    this.dataList = paramDataBuffer;
    AppMethodBeat.o(366628);
  }
  
  public void setTAG(String paramString)
  {
    AppMethodBeat.i(166099);
    s.u(paramString, "<set-?>");
    this.TAG = paramString;
    AppMethodBeat.o(166099);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.DataStore
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.feed.model.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/internal/DataStore;", "T", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "setTAG", "(Ljava/lang/String;)V", "dataList", "Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "getDataList", "()Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "setDataList", "(Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;)V", "get", "index", "", "(I)Ljava/lang/Object;", "getDataListJustForAdapter", "getLast", "()Ljava/lang/Object;", "getLastItemOfType", "E", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "getListInfo", "getListOfType", "", "getSize", "isEmpty", "", "safeGet", "plugin-finder-base_release"})
public class DataStore<T>
{
  private String TAG;
  private DataBuffer<T> dataList;
  
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
    Object localObject = j.lr((List)this.dataList);
    AppMethodBeat.o(166100);
    return localObject;
  }
  
  public final <E> E getLastItemOfType(Class<E> paramClass)
  {
    AppMethodBeat.i(258435);
    p.k(paramClass, "clazz");
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
      AppMethodBeat.o(258435);
      return paramClass;
    }
    AppMethodBeat.o(258435);
    return null;
  }
  
  public final String getListInfo()
  {
    AppMethodBeat.i(258432);
    String str = "DataStore: info count: " + this.dataList.size();
    Log.i(getTAG(), str);
    Iterator localIterator = ((Iterable)this.dataList).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (i < 0) {
        j.iBO();
      }
      Log.i(getTAG(), "DataStore:index " + i + " obj:" + String.valueOf(localObject));
      i += 1;
    }
    AppMethodBeat.o(258432);
    return str;
  }
  
  public final <E> List<E> getListOfType(Class<E> paramClass)
  {
    AppMethodBeat.i(258433);
    p.k(paramClass, "clazz");
    List localList = (List)new ArrayList();
    Iterator localIterator = ((Iterable)this.dataList).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (paramClass.isInstance(localObject)) {
        localList.add(localObject);
      }
    }
    AppMethodBeat.o(258433);
    return localList;
  }
  
  public final int getSize()
  {
    AppMethodBeat.i(258430);
    int i = this.dataList.size();
    AppMethodBeat.o(258430);
    return i;
  }
  
  public String getTAG()
  {
    return this.TAG;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(258429);
    boolean bool = this.dataList.isEmpty();
    AppMethodBeat.o(258429);
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
    AppMethodBeat.i(258428);
    p.k(paramDataBuffer, "<set-?>");
    this.dataList = paramDataBuffer;
    AppMethodBeat.o(258428);
  }
  
  public void setTAG(String paramString)
  {
    AppMethodBeat.i(166099);
    p.k(paramString, "<set-?>");
    this.TAG = paramString;
    AppMethodBeat.o(166099);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.DataStore
 * JD-Core Version:    0.7.0.1
 */
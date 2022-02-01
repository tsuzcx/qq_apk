package com.tencent.mm.plugin.finder.feed.model.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.a.j;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "T", "Ljava/util/ArrayList;", "buffer", "(Ljava/util/ArrayList;)V", "t", "(Ljava/lang/Object;Ljava/util/ArrayList;)V", "", "offset", "", "getOffset", "()I", "totalSize", "getTotalSize", "clearBuffer", "", "contains", "", "element", "(Ljava/lang/Object;)Z", "get", "index", "(I)Ljava/lang/Object;", "setBuffer", "elements", "", "Companion", "plugin-finder_release"})
public final class DataBuffer<T>
  extends ArrayList<T>
{
  public static final a Companion;
  public static final String TAG = "DataBuffer";
  private final List<T> buffer;
  
  static
  {
    AppMethodBeat.i(202550);
    Companion = new a((byte)0);
    AppMethodBeat.o(202550);
  }
  
  public DataBuffer(T paramT, ArrayList<T> paramArrayList)
  {
    AppMethodBeat.i(202548);
    this.buffer = ((List)paramArrayList);
    add(paramT);
    AppMethodBeat.o(202548);
  }
  
  public DataBuffer(ArrayList<T> paramArrayList)
  {
    AppMethodBeat.i(202546);
    this.buffer = ((List)paramArrayList);
    AppMethodBeat.o(202546);
  }
  
  public final void clearBuffer()
  {
    AppMethodBeat.i(202543);
    this.buffer.clear();
    AppMethodBeat.o(202543);
  }
  
  public final boolean contains(Object paramObject)
  {
    AppMethodBeat.i(202545);
    if ((super.contains(paramObject)) || (this.buffer.contains(paramObject)))
    {
      AppMethodBeat.o(202545);
      return true;
    }
    AppMethodBeat.o(202545);
    return false;
  }
  
  public final T get(int paramInt)
  {
    AppMethodBeat.i(202542);
    if (paramInt < size())
    {
      localObject = super.get(paramInt);
      AppMethodBeat.o(202542);
      return localObject;
    }
    Object localObject = this.buffer.get(paramInt - size() + getOffset());
    AppMethodBeat.o(202542);
    return localObject;
  }
  
  public final int getOffset()
  {
    AppMethodBeat.i(202541);
    Object localObject = j.jf(this);
    if (localObject != null)
    {
      int i = this.buffer.indexOf(localObject);
      AppMethodBeat.o(202541);
      return i + 1;
    }
    AppMethodBeat.o(202541);
    return 0;
  }
  
  public final int getSize()
  {
    AppMethodBeat.i(202553);
    int i = super.size();
    AppMethodBeat.o(202553);
    return i;
  }
  
  public final int getTotalSize()
  {
    AppMethodBeat.i(202540);
    int i = size();
    int j = this.buffer.size();
    int k = getOffset();
    AppMethodBeat.o(202540);
    return i + (j - k);
  }
  
  public final T remove(int paramInt)
  {
    AppMethodBeat.i(202552);
    Object localObject = removeAt(paramInt);
    AppMethodBeat.o(202552);
    return localObject;
  }
  
  public final Object removeAt(int paramInt)
  {
    AppMethodBeat.i(202551);
    Object localObject = super.remove(paramInt);
    AppMethodBeat.o(202551);
    return localObject;
  }
  
  public final boolean setBuffer(Collection<? extends T> paramCollection)
  {
    AppMethodBeat.i(202544);
    clearBuffer();
    if (paramCollection == null)
    {
      AppMethodBeat.o(202544);
      return false;
    }
    ad.i("DataBuffer", "[addAllBuffer] " + paramCollection.size());
    boolean bool = this.buffer.addAll(paramCollection);
    AppMethodBeat.o(202544);
    return bool;
  }
  
  public final int size()
  {
    AppMethodBeat.i(202554);
    int i = getSize();
    AppMethodBeat.o(202554);
    return i;
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer
 * JD-Core Version:    0.7.0.1
 */
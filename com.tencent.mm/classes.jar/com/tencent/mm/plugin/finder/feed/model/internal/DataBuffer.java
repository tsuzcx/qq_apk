package com.tencent.mm.plugin.finder.feed.model.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.a.j;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "T", "Ljava/util/ArrayList;", "buffer", "(Ljava/util/ArrayList;)V", "t", "(Ljava/lang/Object;Ljava/util/ArrayList;)V", "", "offset", "", "getOffset", "()I", "totalSize", "getTotalSize", "clearBuffer", "", "contains", "", "element", "(Ljava/lang/Object;)Z", "get", "index", "(I)Ljava/lang/Object;", "getBuffer", "setBuffer", "elements", "", "Companion", "plugin-finder-base_release"})
public final class DataBuffer<T>
  extends ArrayList<T>
{
  public static final a Companion;
  public static final String TAG = "DataBuffer";
  private final List<T> buffer;
  
  static
  {
    AppMethodBeat.i(259458);
    Companion = new a((byte)0);
    AppMethodBeat.o(259458);
  }
  
  public DataBuffer(T paramT, ArrayList<T> paramArrayList)
  {
    AppMethodBeat.i(259455);
    this.buffer = ((List)paramArrayList);
    add(paramT);
    AppMethodBeat.o(259455);
  }
  
  public DataBuffer(ArrayList<T> paramArrayList)
  {
    AppMethodBeat.i(259451);
    this.buffer = ((List)paramArrayList);
    AppMethodBeat.o(259451);
  }
  
  public final void clearBuffer()
  {
    AppMethodBeat.i(259444);
    this.buffer.clear();
    AppMethodBeat.o(259444);
  }
  
  public final boolean contains(Object paramObject)
  {
    AppMethodBeat.i(259449);
    if ((super.contains(paramObject)) || (this.buffer.contains(paramObject)))
    {
      AppMethodBeat.o(259449);
      return true;
    }
    AppMethodBeat.o(259449);
    return false;
  }
  
  public final T get(int paramInt)
  {
    AppMethodBeat.i(259443);
    if (paramInt < size())
    {
      localObject = super.get(paramInt);
      AppMethodBeat.o(259443);
      return localObject;
    }
    Object localObject = this.buffer.get(paramInt - size() + getOffset());
    AppMethodBeat.o(259443);
    return localObject;
  }
  
  public final List<T> getBuffer()
  {
    return this.buffer;
  }
  
  public final int getOffset()
  {
    AppMethodBeat.i(259440);
    Object localObject = j.lr(this);
    if (localObject != null)
    {
      int i = this.buffer.indexOf(localObject);
      AppMethodBeat.o(259440);
      return i + 1;
    }
    AppMethodBeat.o(259440);
    return 0;
  }
  
  public final int getSize()
  {
    AppMethodBeat.i(259463);
    int i = super.size();
    AppMethodBeat.o(259463);
    return i;
  }
  
  public final int getTotalSize()
  {
    AppMethodBeat.i(259439);
    int i = size();
    int j = this.buffer.size();
    int k = getOffset();
    AppMethodBeat.o(259439);
    return i + (j - k);
  }
  
  public final T remove(int paramInt)
  {
    AppMethodBeat.i(259461);
    Object localObject = removeAt(paramInt);
    AppMethodBeat.o(259461);
    return localObject;
  }
  
  public final Object removeAt(int paramInt)
  {
    AppMethodBeat.i(259459);
    Object localObject = super.remove(paramInt);
    AppMethodBeat.o(259459);
    return localObject;
  }
  
  public final boolean setBuffer(Collection<? extends T> paramCollection)
  {
    AppMethodBeat.i(259448);
    clearBuffer();
    if (paramCollection == null)
    {
      AppMethodBeat.o(259448);
      return false;
    }
    Log.i("DataBuffer", "[addAllBuffer] " + paramCollection.size());
    boolean bool = this.buffer.addAll(paramCollection);
    AppMethodBeat.o(259448);
    return bool;
  }
  
  public final int size()
  {
    AppMethodBeat.i(259464);
    int i = getSize();
    AppMethodBeat.o(259464);
    return i;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer$Companion;", "", "()V", "TAG", "", "plugin-finder-base_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer
 * JD-Core Version:    0.7.0.1
 */
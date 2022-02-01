package com.tencent.mm.plugin.finder.feed.model.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.a.j;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "T", "Ljava/util/ArrayList;", "buffer", "(Ljava/util/ArrayList;)V", "t", "(Ljava/lang/Object;Ljava/util/ArrayList;)V", "", "offset", "", "getOffset", "()I", "totalSize", "getTotalSize", "clearBuffer", "", "contains", "", "element", "(Ljava/lang/Object;)Z", "get", "index", "(I)Ljava/lang/Object;", "getBuffer", "setBuffer", "elements", "", "Companion", "plugin-finder_release"})
public final class DataBuffer<T>
  extends ArrayList<T>
{
  public static final a Companion;
  public static final String TAG = "DataBuffer";
  private final List<T> buffer;
  
  static
  {
    AppMethodBeat.i(244989);
    Companion = new a((byte)0);
    AppMethodBeat.o(244989);
  }
  
  public DataBuffer(T paramT, ArrayList<T> paramArrayList)
  {
    AppMethodBeat.i(244987);
    this.buffer = ((List)paramArrayList);
    add(paramT);
    AppMethodBeat.o(244987);
  }
  
  public DataBuffer(ArrayList<T> paramArrayList)
  {
    AppMethodBeat.i(244985);
    this.buffer = ((List)paramArrayList);
    AppMethodBeat.o(244985);
  }
  
  public final void clearBuffer()
  {
    AppMethodBeat.i(244982);
    this.buffer.clear();
    AppMethodBeat.o(244982);
  }
  
  public final boolean contains(Object paramObject)
  {
    AppMethodBeat.i(244984);
    if ((super.contains(paramObject)) || (this.buffer.contains(paramObject)))
    {
      AppMethodBeat.o(244984);
      return true;
    }
    AppMethodBeat.o(244984);
    return false;
  }
  
  public final T get(int paramInt)
  {
    AppMethodBeat.i(244981);
    if (paramInt < size())
    {
      localObject = super.get(paramInt);
      AppMethodBeat.o(244981);
      return localObject;
    }
    Object localObject = this.buffer.get(paramInt - size() + getOffset());
    AppMethodBeat.o(244981);
    return localObject;
  }
  
  public final List<T> getBuffer()
  {
    return this.buffer;
  }
  
  public final int getOffset()
  {
    AppMethodBeat.i(244980);
    Object localObject = j.kv(this);
    if (localObject != null)
    {
      int i = this.buffer.indexOf(localObject);
      AppMethodBeat.o(244980);
      return i + 1;
    }
    AppMethodBeat.o(244980);
    return 0;
  }
  
  public final int getSize()
  {
    AppMethodBeat.i(244992);
    int i = super.size();
    AppMethodBeat.o(244992);
    return i;
  }
  
  public final int getTotalSize()
  {
    AppMethodBeat.i(244979);
    int i = size();
    int j = this.buffer.size();
    int k = getOffset();
    AppMethodBeat.o(244979);
    return i + (j - k);
  }
  
  public final T remove(int paramInt)
  {
    AppMethodBeat.i(244991);
    Object localObject = removeAt(paramInt);
    AppMethodBeat.o(244991);
    return localObject;
  }
  
  public final Object removeAt(int paramInt)
  {
    AppMethodBeat.i(244990);
    Object localObject = super.remove(paramInt);
    AppMethodBeat.o(244990);
    return localObject;
  }
  
  public final boolean setBuffer(Collection<? extends T> paramCollection)
  {
    AppMethodBeat.i(244983);
    clearBuffer();
    if (paramCollection == null)
    {
      AppMethodBeat.o(244983);
      return false;
    }
    Log.i("DataBuffer", "[addAllBuffer] " + paramCollection.size());
    boolean bool = this.buffer.addAll(paramCollection);
    AppMethodBeat.o(244983);
    return bool;
  }
  
  public final int size()
  {
    AppMethodBeat.i(244993);
    int i = getSize();
    AppMethodBeat.o(244993);
    return i;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer
 * JD-Core Version:    0.7.0.1
 */
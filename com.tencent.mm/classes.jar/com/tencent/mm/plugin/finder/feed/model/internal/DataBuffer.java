package com.tencent.mm.plugin.finder.feed.model.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import d.a.j;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "T", "Ljava/util/ArrayList;", "buffer", "(Ljava/util/ArrayList;)V", "t", "(Ljava/lang/Object;Ljava/util/ArrayList;)V", "", "offset", "", "getOffset", "()I", "totalSize", "getTotalSize", "clearBuffer", "", "contains", "", "element", "(Ljava/lang/Object;)Z", "get", "index", "(I)Ljava/lang/Object;", "setBuffer", "elements", "", "Companion", "plugin-finder_release"})
public final class DataBuffer<T>
  extends ArrayList<T>
{
  public static final a Companion;
  public static final String TAG = "DataBuffer";
  private final List<T> buffer;
  
  static
  {
    AppMethodBeat.i(203026);
    Companion = new a((byte)0);
    AppMethodBeat.o(203026);
  }
  
  public DataBuffer(T paramT, ArrayList<T> paramArrayList)
  {
    AppMethodBeat.i(203024);
    this.buffer = ((List)paramArrayList);
    add(paramT);
    AppMethodBeat.o(203024);
  }
  
  public DataBuffer(ArrayList<T> paramArrayList)
  {
    AppMethodBeat.i(203022);
    this.buffer = ((List)paramArrayList);
    AppMethodBeat.o(203022);
  }
  
  public final void clearBuffer()
  {
    AppMethodBeat.i(203019);
    this.buffer.clear();
    AppMethodBeat.o(203019);
  }
  
  public final boolean contains(Object paramObject)
  {
    AppMethodBeat.i(203021);
    if ((super.contains(paramObject)) || (this.buffer.contains(paramObject)))
    {
      AppMethodBeat.o(203021);
      return true;
    }
    AppMethodBeat.o(203021);
    return false;
  }
  
  public final T get(int paramInt)
  {
    AppMethodBeat.i(203018);
    if (paramInt < size())
    {
      localObject = super.get(paramInt);
      AppMethodBeat.o(203018);
      return localObject;
    }
    Object localObject = this.buffer.get(paramInt - size() + getOffset());
    AppMethodBeat.o(203018);
    return localObject;
  }
  
  public final int getOffset()
  {
    AppMethodBeat.i(203017);
    Object localObject = j.jo(this);
    if (localObject != null)
    {
      int i = this.buffer.indexOf(localObject);
      AppMethodBeat.o(203017);
      return i + 1;
    }
    AppMethodBeat.o(203017);
    return 0;
  }
  
  public final int getSize()
  {
    AppMethodBeat.i(203029);
    int i = super.size();
    AppMethodBeat.o(203029);
    return i;
  }
  
  public final int getTotalSize()
  {
    AppMethodBeat.i(203016);
    int i = size();
    int j = this.buffer.size();
    int k = getOffset();
    AppMethodBeat.o(203016);
    return i + (j - k);
  }
  
  public final T remove(int paramInt)
  {
    AppMethodBeat.i(203028);
    Object localObject = removeAt(paramInt);
    AppMethodBeat.o(203028);
    return localObject;
  }
  
  public final Object removeAt(int paramInt)
  {
    AppMethodBeat.i(203027);
    Object localObject = super.remove(paramInt);
    AppMethodBeat.o(203027);
    return localObject;
  }
  
  public final boolean setBuffer(Collection<? extends T> paramCollection)
  {
    AppMethodBeat.i(203020);
    clearBuffer();
    if (paramCollection == null)
    {
      AppMethodBeat.o(203020);
      return false;
    }
    ae.i("DataBuffer", "[addAllBuffer] " + paramCollection.size());
    boolean bool = this.buffer.addAll(paramCollection);
    AppMethodBeat.o(203020);
    return bool;
  }
  
  public final int size()
  {
    AppMethodBeat.i(203030);
    int i = getSize();
    AppMethodBeat.o(203030);
    return i;
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer
 * JD-Core Version:    0.7.0.1
 */
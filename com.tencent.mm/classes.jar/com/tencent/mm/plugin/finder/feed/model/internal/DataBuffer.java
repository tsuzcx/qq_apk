package com.tencent.mm.plugin.finder.feed.model.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import d.a.j;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "T", "Ljava/util/ArrayList;", "buffer", "(Ljava/util/ArrayList;)V", "t", "(Ljava/lang/Object;Ljava/util/ArrayList;)V", "", "offset", "", "getOffset", "()I", "totalSize", "getTotalSize", "addAllBuffer", "", "elements", "", "clearBuffer", "", "contains", "element", "(Ljava/lang/Object;)Z", "get", "index", "(I)Ljava/lang/Object;", "Companion", "plugin-finder_release"})
public final class DataBuffer<T>
  extends ArrayList<T>
{
  public static final DataBuffer.a Companion;
  public static final String TAG = "DataBuffer";
  private final List<T> buffer;
  
  static
  {
    AppMethodBeat.i(202250);
    Companion = new DataBuffer.a((byte)0);
    AppMethodBeat.o(202250);
  }
  
  public DataBuffer(T paramT, ArrayList<T> paramArrayList)
  {
    AppMethodBeat.i(202248);
    this.buffer = ((List)paramArrayList);
    add(paramT);
    AppMethodBeat.o(202248);
  }
  
  public DataBuffer(ArrayList<T> paramArrayList)
  {
    AppMethodBeat.i(202246);
    this.buffer = ((List)paramArrayList);
    AppMethodBeat.o(202246);
  }
  
  public final boolean addAllBuffer(Collection<? extends T> paramCollection)
  {
    AppMethodBeat.i(202244);
    if (paramCollection == null)
    {
      AppMethodBeat.o(202244);
      return false;
    }
    ac.i("DataBuffer", "[addAllBuffer] " + paramCollection.size());
    boolean bool = this.buffer.addAll(paramCollection);
    AppMethodBeat.o(202244);
    return bool;
  }
  
  public final void clearBuffer()
  {
    AppMethodBeat.i(202243);
    this.buffer.clear();
    AppMethodBeat.o(202243);
  }
  
  public final boolean contains(Object paramObject)
  {
    AppMethodBeat.i(202245);
    if ((super.contains(paramObject)) || (this.buffer.contains(paramObject)))
    {
      AppMethodBeat.o(202245);
      return true;
    }
    AppMethodBeat.o(202245);
    return false;
  }
  
  public final T get(int paramInt)
  {
    AppMethodBeat.i(202242);
    if (paramInt < size())
    {
      localObject = super.get(paramInt);
      AppMethodBeat.o(202242);
      return localObject;
    }
    Object localObject = this.buffer.get(paramInt - size() + getOffset());
    AppMethodBeat.o(202242);
    return localObject;
  }
  
  public final int getOffset()
  {
    AppMethodBeat.i(202241);
    Object localObject = j.iR(this);
    if (localObject != null)
    {
      int i = this.buffer.indexOf(localObject);
      AppMethodBeat.o(202241);
      return i + 1;
    }
    AppMethodBeat.o(202241);
    return 0;
  }
  
  public final int getSize()
  {
    AppMethodBeat.i(202253);
    int i = super.size();
    AppMethodBeat.o(202253);
    return i;
  }
  
  public final int getTotalSize()
  {
    AppMethodBeat.i(202240);
    int i = size();
    int j = this.buffer.size();
    int k = getOffset();
    AppMethodBeat.o(202240);
    return i + (j - k);
  }
  
  public final T remove(int paramInt)
  {
    AppMethodBeat.i(202252);
    Object localObject = removeAt(paramInt);
    AppMethodBeat.o(202252);
    return localObject;
  }
  
  public final Object removeAt(int paramInt)
  {
    AppMethodBeat.i(202251);
    Object localObject = super.remove(paramInt);
    AppMethodBeat.o(202251);
    return localObject;
  }
  
  public final int size()
  {
    AppMethodBeat.i(202254);
    int i = getSize();
    AppMethodBeat.o(202254);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer
 * JD-Core Version:    0.7.0.1
 */
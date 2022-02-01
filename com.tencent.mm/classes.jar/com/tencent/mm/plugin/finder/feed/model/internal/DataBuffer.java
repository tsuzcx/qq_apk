package com.tencent.mm.plugin.finder.feed.model.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.a.j;
import d.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "T", "Ljava/util/ArrayList;", "buffer", "(Ljava/util/ArrayList;)V", "t", "(Ljava/lang/Object;Ljava/util/ArrayList;)V", "", "offset", "", "getOffset", "()I", "totalSize", "getTotalSize", "addAllBuffer", "", "elements", "", "clearBuffer", "", "contains", "element", "(Ljava/lang/Object;)Z", "get", "index", "(I)Ljava/lang/Object;", "Companion", "plugin-finder_release"})
public final class DataBuffer<T>
  extends ArrayList<T>
{
  public static final a Companion;
  public static final String TAG = "DataBuffer";
  private final List<T> buffer;
  
  static
  {
    AppMethodBeat.i(198338);
    Companion = new a((byte)0);
    AppMethodBeat.o(198338);
  }
  
  public DataBuffer(T paramT, ArrayList<T> paramArrayList)
  {
    AppMethodBeat.i(198336);
    this.buffer = ((List)paramArrayList);
    add(paramT);
    AppMethodBeat.o(198336);
  }
  
  public DataBuffer(ArrayList<T> paramArrayList)
  {
    AppMethodBeat.i(198334);
    this.buffer = ((List)paramArrayList);
    AppMethodBeat.o(198334);
  }
  
  public final boolean addAllBuffer(Collection<? extends T> paramCollection)
  {
    AppMethodBeat.i(198332);
    if (paramCollection == null)
    {
      AppMethodBeat.o(198332);
      return false;
    }
    ad.i("DataBuffer", "[addAllBuffer] " + paramCollection.size());
    boolean bool = this.buffer.addAll(paramCollection);
    AppMethodBeat.o(198332);
    return bool;
  }
  
  public final void clearBuffer()
  {
    AppMethodBeat.i(198331);
    this.buffer.clear();
    AppMethodBeat.o(198331);
  }
  
  public final boolean contains(Object paramObject)
  {
    AppMethodBeat.i(198333);
    if ((super.contains(paramObject)) || (this.buffer.contains(paramObject)))
    {
      AppMethodBeat.o(198333);
      return true;
    }
    AppMethodBeat.o(198333);
    return false;
  }
  
  public final T get(int paramInt)
  {
    AppMethodBeat.i(198330);
    if (paramInt < size())
    {
      localObject = super.get(paramInt);
      AppMethodBeat.o(198330);
      return localObject;
    }
    Object localObject = this.buffer.get(paramInt - size() + getOffset());
    AppMethodBeat.o(198330);
    return localObject;
  }
  
  public final int getOffset()
  {
    AppMethodBeat.i(198329);
    Object localObject = j.iB(this);
    if (localObject != null)
    {
      int i = this.buffer.indexOf(localObject);
      AppMethodBeat.o(198329);
      return i + 1;
    }
    AppMethodBeat.o(198329);
    return 0;
  }
  
  public final int getSize()
  {
    AppMethodBeat.i(198341);
    int i = super.size();
    AppMethodBeat.o(198341);
    return i;
  }
  
  public final int getTotalSize()
  {
    AppMethodBeat.i(198328);
    int i = size();
    int j = this.buffer.size();
    int k = getOffset();
    AppMethodBeat.o(198328);
    return i + (j - k);
  }
  
  public final T remove(int paramInt)
  {
    AppMethodBeat.i(198340);
    Object localObject = removeAt(paramInt);
    AppMethodBeat.o(198340);
    return localObject;
  }
  
  public final Object removeAt(int paramInt)
  {
    AppMethodBeat.i(198339);
    Object localObject = super.remove(paramInt);
    AppMethodBeat.o(198339);
    return localObject;
  }
  
  public final int size()
  {
    AppMethodBeat.i(198342);
    int i = getSize();
    AppMethodBeat.o(198342);
    return i;
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer
 * JD-Core Version:    0.7.0.1
 */
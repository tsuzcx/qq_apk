package com.tencent.mm.plugin.finder.feed.model.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer;", "T", "Ljava/util/ArrayList;", "buffer", "(Ljava/util/ArrayList;)V", "t", "(Ljava/lang/Object;Ljava/util/ArrayList;)V", "", "offset", "", "getOffset", "()I", "totalSize", "getTotalSize", "clearBuffer", "", "contains", "", "element", "(Ljava/lang/Object;)Z", "get", "index", "(I)Ljava/lang/Object;", "getBuffer", "setBuffer", "elements", "", "Companion", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class DataBuffer<T>
  extends ArrayList<T>
{
  public static final a Companion;
  public static final String TAG = "DataBuffer";
  private final List<T> buffer;
  
  static
  {
    AppMethodBeat.i(366551);
    Companion = new a((byte)0);
    AppMethodBeat.o(366551);
  }
  
  public DataBuffer(T paramT, ArrayList<T> paramArrayList)
  {
    AppMethodBeat.i(366540);
    this.buffer = ((List)paramArrayList);
    add(paramT);
    AppMethodBeat.o(366540);
  }
  
  public DataBuffer(ArrayList<T> paramArrayList)
  {
    AppMethodBeat.i(366525);
    this.buffer = ((List)paramArrayList);
    AppMethodBeat.o(366525);
  }
  
  public final void clearBuffer()
  {
    AppMethodBeat.i(366576);
    this.buffer.clear();
    AppMethodBeat.o(366576);
  }
  
  public final boolean contains(Object paramObject)
  {
    AppMethodBeat.i(366589);
    if ((super.contains(paramObject)) || (this.buffer.contains(paramObject)))
    {
      AppMethodBeat.o(366589);
      return true;
    }
    AppMethodBeat.o(366589);
    return false;
  }
  
  public final T get(int paramInt)
  {
    AppMethodBeat.i(366571);
    if (paramInt < size())
    {
      localObject = super.get(paramInt);
      AppMethodBeat.o(366571);
      return localObject;
    }
    Object localObject = this.buffer.get(paramInt - size() + getOffset());
    AppMethodBeat.o(366571);
    return localObject;
  }
  
  public final List<T> getBuffer()
  {
    return this.buffer;
  }
  
  public final int getOffset()
  {
    AppMethodBeat.i(366564);
    Object localObject = p.oN((List)this);
    if (localObject == null)
    {
      AppMethodBeat.o(366564);
      return 0;
    }
    int i = this.buffer.indexOf(localObject);
    AppMethodBeat.o(366564);
    return i + 1;
  }
  
  public final int getSize()
  {
    AppMethodBeat.i(366609);
    int i = super.size();
    AppMethodBeat.o(366609);
    return i;
  }
  
  public final int getTotalSize()
  {
    AppMethodBeat.i(366559);
    int i = size();
    int j = this.buffer.size();
    int k = getOffset();
    AppMethodBeat.o(366559);
    return i + (j - k);
  }
  
  public final T remove(int paramInt)
  {
    AppMethodBeat.i(366603);
    Object localObject = removeAt(paramInt);
    AppMethodBeat.o(366603);
    return localObject;
  }
  
  public final Object removeAt(int paramInt)
  {
    AppMethodBeat.i(366595);
    Object localObject = super.remove(paramInt);
    AppMethodBeat.o(366595);
    return localObject;
  }
  
  public final boolean setBuffer(Collection<? extends T> paramCollection)
  {
    AppMethodBeat.i(366583);
    clearBuffer();
    if (paramCollection == null)
    {
      AppMethodBeat.o(366583);
      return false;
    }
    Log.i("DataBuffer", s.X("[addAllBuffer] ", Integer.valueOf(paramCollection.size())));
    boolean bool = this.buffer.addAll(paramCollection);
    AppMethodBeat.o(366583);
    return bool;
  }
  
  public final int size()
  {
    AppMethodBeat.i(366614);
    int i = getSize();
    AppMethodBeat.o(366614);
    return i;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/model/internal/DataBuffer$Companion;", "", "()V", "TAG", "", "plugin-finder-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.model.internal.DataBuffer
 * JD-Core Version:    0.7.0.1
 */
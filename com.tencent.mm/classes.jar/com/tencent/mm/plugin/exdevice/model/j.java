package com.tencent.mm.plugin.exdevice.model;

import android.util.SparseArray;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.LinkedList;
import java.util.List;

public final class j
{
  private static j lFn;
  private SparseArray<List<j.a>> lFo;
  
  private j()
  {
    AppMethodBeat.i(19306);
    this.lFo = new SparseArray();
    AppMethodBeat.o(19306);
  }
  
  public static j bpP()
  {
    AppMethodBeat.i(19307);
    if (lFn == null) {
      lFn = new j();
    }
    j localj = lFn;
    AppMethodBeat.o(19307);
    return localj;
  }
  
  public final boolean a(int paramInt, j.a parama)
  {
    AppMethodBeat.i(19308);
    if (parama == null)
    {
      AppMethodBeat.o(19308);
      return false;
    }
    List localList = (List)this.lFo.get(paramInt);
    Object localObject;
    if (localList == null)
    {
      localObject = new LinkedList();
      this.lFo.put(paramInt, localObject);
    }
    do
    {
      boolean bool = ((List)localObject).add(parama);
      AppMethodBeat.o(19308);
      return bool;
      localObject = localList;
    } while (!localList.contains(parama));
    AppMethodBeat.o(19308);
    return false;
  }
  
  public final boolean b(int paramInt, j.a parama)
  {
    AppMethodBeat.i(19309);
    List localList = (List)this.lFo.get(paramInt);
    if (localList != null)
    {
      localList.remove(parama);
      if (localList.size() == 0) {
        this.lFo.remove(paramInt);
      }
    }
    AppMethodBeat.o(19309);
    return false;
  }
  
  public final void h(int paramInt, Object... paramVarArgs)
  {
    AppMethodBeat.i(19310);
    List localList = (List)this.lFo.get(paramInt);
    if ((localList == null) || (localList.size() == 0))
    {
      AppMethodBeat.o(19310);
      return;
    }
    int i = 0;
    while (i < localList.size())
    {
      ((j.a)localList.get(i)).g(paramInt, paramVarArgs);
      i += 1;
    }
    AppMethodBeat.o(19310);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.model.j
 * JD-Core Version:    0.7.0.1
 */
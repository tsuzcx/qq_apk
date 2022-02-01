package com.tencent.mm.picker.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.base.a.b;
import java.util.List;

public final class a<T>
  implements b
{
  private List<T> hqR;
  
  public a(List<T> paramList)
  {
    this.hqR = paramList;
  }
  
  public final Object getItem(int paramInt)
  {
    AppMethodBeat.i(175284);
    if ((paramInt >= 0) && (paramInt < this.hqR.size()))
    {
      Object localObject = this.hqR.get(paramInt);
      AppMethodBeat.o(175284);
      return localObject;
    }
    AppMethodBeat.o(175284);
    return "";
  }
  
  public final int getItemsCount()
  {
    AppMethodBeat.i(175286);
    int i = this.hqR.size();
    AppMethodBeat.o(175286);
    return i;
  }
  
  public final String qk(int paramInt)
  {
    AppMethodBeat.i(175285);
    Object localObject2 = getItem(paramInt);
    Object localObject1;
    if (localObject2 == null) {
      localObject1 = "";
    }
    for (;;)
    {
      localObject1 = (String)localObject1;
      AppMethodBeat.o(175285);
      return localObject1;
      localObject1 = localObject2;
      if (!(localObject2 instanceof String)) {
        localObject1 = localObject2.toString();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.picker.a.a
 * JD-Core Version:    0.7.0.1
 */
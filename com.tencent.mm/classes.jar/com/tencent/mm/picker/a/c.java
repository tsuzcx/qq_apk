package com.tencent.mm.picker.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.base.a.a;
import com.tencent.mm.picker.base.a.b;

public final class c
  implements b<Integer>
{
  public int iNj;
  public int iNk;
  private a iNl;
  
  public c(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(175291);
    a(paramInt1, paramInt2, null);
    AppMethodBeat.o(175291);
  }
  
  public c(int paramInt1, int paramInt2, a parama)
  {
    AppMethodBeat.i(175289);
    a(paramInt1, paramInt2, parama);
    AppMethodBeat.o(175289);
  }
  
  private void a(int paramInt1, int paramInt2, a parama)
  {
    AppMethodBeat.i(175290);
    this.iNl = parama;
    if (this.iNl == null) {
      this.iNl = new a();
    }
    this.iNj = paramInt1;
    this.iNk = paramInt2;
    AppMethodBeat.o(175290);
  }
  
  private Integer qP(int paramInt)
  {
    AppMethodBeat.i(175292);
    if ((paramInt >= 0) && (paramInt < getItemsCount()))
    {
      int i = this.iNj;
      AppMethodBeat.o(175292);
      return Integer.valueOf(i + paramInt);
    }
    AppMethodBeat.o(175292);
    return null;
  }
  
  public final int getItemsCount()
  {
    return this.iNk - this.iNj + 1;
  }
  
  public final String qO(int paramInt)
  {
    AppMethodBeat.i(175293);
    Object localObject = qP(paramInt);
    if (localObject == null) {}
    for (localObject = "";; localObject = ((Integer)localObject).toString())
    {
      localObject = this.iNl.Ji((String)localObject);
      AppMethodBeat.o(175293);
      return localObject;
    }
  }
  
  final class a
    implements a
  {
    a() {}
    
    public final String Ji(String paramString)
    {
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.picker.a.c
 * JD-Core Version:    0.7.0.1
 */
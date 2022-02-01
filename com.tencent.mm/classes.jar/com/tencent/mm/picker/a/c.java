package com.tencent.mm.picker.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.base.a.a;
import com.tencent.mm.picker.base.a.b;

public class c
  implements b<Integer>
{
  private int pxH;
  private int pxI;
  private a pxJ;
  
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
    this.pxJ = parama;
    if (this.pxJ == null) {
      this.pxJ = new a();
    }
    this.pxH = paramInt1;
    this.pxI = paramInt2;
    AppMethodBeat.o(175290);
  }
  
  public int getItemsCount()
  {
    return this.pxI - this.pxH + 1;
  }
  
  public int getMaxValue()
  {
    return this.pxI;
  }
  
  public int getMinValue()
  {
    return this.pxH;
  }
  
  public String xN(int paramInt)
  {
    AppMethodBeat.i(175293);
    Object localObject = xO(paramInt);
    if (localObject == null) {}
    for (localObject = "";; localObject = ((Integer)localObject).toString())
    {
      localObject = this.pxJ.RX((String)localObject);
      AppMethodBeat.o(175293);
      return localObject;
    }
  }
  
  public Integer xO(int paramInt)
  {
    AppMethodBeat.i(175292);
    if ((paramInt >= 0) && (paramInt < getItemsCount()))
    {
      int i = this.pxH;
      AppMethodBeat.o(175292);
      return Integer.valueOf(i + paramInt);
    }
    AppMethodBeat.o(175292);
    return null;
  }
  
  final class a
    implements a
  {
    a() {}
    
    public final String RX(String paramString)
    {
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.picker.a.c
 * JD-Core Version:    0.7.0.1
 */
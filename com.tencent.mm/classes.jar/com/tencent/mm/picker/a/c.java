package com.tencent.mm.picker.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.picker.base.a.a;
import com.tencent.mm.picker.base.a.b;

public class c
  implements b<Integer>
{
  private int mAX;
  private int mAY;
  private a mAZ;
  
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
    this.mAZ = parama;
    if (this.mAZ == null) {
      this.mAZ = new a();
    }
    this.mAX = paramInt1;
    this.mAY = paramInt2;
    AppMethodBeat.o(175290);
  }
  
  public int getItemsCount()
  {
    return this.mAY - this.mAX + 1;
  }
  
  public int getMaxValue()
  {
    return this.mAY;
  }
  
  public int getMinValue()
  {
    return this.mAX;
  }
  
  public String xI(int paramInt)
  {
    AppMethodBeat.i(175293);
    Object localObject = xJ(paramInt);
    if (localObject == null) {}
    for (localObject = "";; localObject = ((Integer)localObject).toString())
    {
      localObject = this.mAZ.ZH((String)localObject);
      AppMethodBeat.o(175293);
      return localObject;
    }
  }
  
  public Integer xJ(int paramInt)
  {
    AppMethodBeat.i(175292);
    if ((paramInt >= 0) && (paramInt < getItemsCount()))
    {
      int i = this.mAX;
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
    
    public final String ZH(String paramString)
    {
      return paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.picker.a.c
 * JD-Core Version:    0.7.0.1
 */
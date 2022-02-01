package com.tencent.mm.picker.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ck.a.i;
import com.tencent.mm.picker.base.a.a;

public final class d
  extends c
{
  private Context mContext;
  private int pxH;
  private int pxI;
  private a pxJ;
  public boolean pxL;
  
  public d(int paramInt1, int paramInt2, Context paramContext)
  {
    super(paramInt1, paramInt2);
    AppMethodBeat.i(231577);
    this.mContext = paramContext;
    this.pxJ = this.pxJ;
    if (this.pxJ == null) {
      this.pxJ = new a();
    }
    this.pxH = paramInt1;
    this.pxI = paramInt2;
    AppMethodBeat.o(231577);
  }
  
  public final int getItemsCount()
  {
    if (this.pxL) {
      return this.pxI - this.pxH + 1 + 1;
    }
    return this.pxI - this.pxH + 1;
  }
  
  public final int getMaxValue()
  {
    return this.pxI;
  }
  
  public final int getMinValue()
  {
    return this.pxH;
  }
  
  public final String xN(int paramInt)
  {
    AppMethodBeat.i(231592);
    if ((paramInt == 0) && (this.pxL))
    {
      str = this.mContext.getString(a.i.picker_long_term);
      AppMethodBeat.o(231592);
      return str;
    }
    String str = super.xN(paramInt);
    AppMethodBeat.o(231592);
    return str;
  }
  
  public final Integer xO(int paramInt)
  {
    AppMethodBeat.i(231590);
    if ((paramInt >= 0) && (paramInt < getItemsCount()))
    {
      if (this.pxL)
      {
        i = this.pxH;
        AppMethodBeat.o(231590);
        return Integer.valueOf(i + paramInt - 1);
      }
      int i = this.pxH;
      AppMethodBeat.o(231590);
      return Integer.valueOf(i + paramInt);
    }
    AppMethodBeat.o(231590);
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
 * Qualified Name:     com.tencent.mm.picker.a.d
 * JD-Core Version:    0.7.0.1
 */
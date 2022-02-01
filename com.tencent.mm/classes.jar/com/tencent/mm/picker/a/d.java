package com.tencent.mm.picker.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cr.a.i;
import com.tencent.mm.picker.base.a.a;

public final class d
  extends c
{
  private int mAX;
  private int mAY;
  private a mAZ;
  public boolean mBb;
  private Context mContext;
  
  public d(int paramInt1, int paramInt2, Context paramContext)
  {
    super(paramInt1, paramInt2);
    AppMethodBeat.i(252039);
    this.mContext = paramContext;
    this.mAZ = this.mAZ;
    if (this.mAZ == null) {
      this.mAZ = new a();
    }
    this.mAX = paramInt1;
    this.mAY = paramInt2;
    AppMethodBeat.o(252039);
  }
  
  public final int getItemsCount()
  {
    if (this.mBb) {
      return this.mAY - this.mAX + 1 + 1;
    }
    return this.mAY - this.mAX + 1;
  }
  
  public final int getMaxValue()
  {
    return this.mAY;
  }
  
  public final int getMinValue()
  {
    return this.mAX;
  }
  
  public final String xI(int paramInt)
  {
    AppMethodBeat.i(252045);
    if ((paramInt == 0) && (this.mBb))
    {
      str = this.mContext.getString(a.i.picker_long_term);
      AppMethodBeat.o(252045);
      return str;
    }
    String str = super.xI(paramInt);
    AppMethodBeat.o(252045);
    return str;
  }
  
  public final Integer xJ(int paramInt)
  {
    AppMethodBeat.i(252043);
    if ((paramInt >= 0) && (paramInt < getItemsCount()))
    {
      if (this.mBb)
      {
        i = this.mAX;
        AppMethodBeat.o(252043);
        return Integer.valueOf(i + paramInt - 1);
      }
      int i = this.mAX;
      AppMethodBeat.o(252043);
      return Integer.valueOf(i + paramInt);
    }
    AppMethodBeat.o(252043);
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
 * Qualified Name:     com.tencent.mm.picker.a.d
 * JD-Core Version:    0.7.0.1
 */
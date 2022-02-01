package com.tencent.luggage.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class o
  implements a
{
  protected n ctG;
  private Context mContext;
  
  public o(Context paramContext, Class<? extends g> paramClass)
  {
    AppMethodBeat.i(221188);
    init();
    this.mContext = paramContext;
    this.ctG = new f(paramContext, paramClass);
    AppMethodBeat.o(221188);
  }
  
  public final n Lc()
  {
    return this.ctG;
  }
  
  public final Context getContext()
  {
    return this.mContext;
  }
  
  protected void init() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.d.o
 * JD-Core Version:    0.7.0.1
 */
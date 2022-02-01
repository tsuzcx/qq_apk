package com.tencent.luggage.d;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class o
  implements a
{
  private n crL;
  private Context mContext;
  
  public o(Context paramContext, Class<? extends g> paramClass)
  {
    AppMethodBeat.i(209028);
    init();
    this.mContext = paramContext;
    this.crL = new f(paramContext, paramClass);
    AppMethodBeat.o(209028);
  }
  
  public final n NS()
  {
    return this.crL;
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
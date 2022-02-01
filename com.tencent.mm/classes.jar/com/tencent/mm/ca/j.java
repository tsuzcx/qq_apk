package com.tencent.mm.ca;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class j
{
  @SuppressLint({"StaticFieldLeak"})
  private static volatile j ELO;
  public i ELP;
  public Context mContext;
  
  public static j eCH()
  {
    AppMethodBeat.i(189884);
    if (ELO == null) {}
    try
    {
      if (ELO == null) {
        ELO = new j();
      }
      j localj = ELO;
      AppMethodBeat.o(189884);
      return localj;
    }
    finally
    {
      AppMethodBeat.o(189884);
    }
  }
  
  public static String eCJ()
  {
    return ":recovery";
  }
  
  public static boolean hA(Context paramContext)
  {
    AppMethodBeat.i(189889);
    boolean bool = k.bU(paramContext, ":recovery");
    AppMethodBeat.o(189889);
    return bool;
  }
  
  public static boolean hz(Context paramContext)
  {
    AppMethodBeat.i(189888);
    boolean bool = k.bU(paramContext, "");
    AppMethodBeat.o(189888);
    return bool;
  }
  
  public final j b(int paramInt, d paramd)
  {
    AppMethodBeat.i(189886);
    if (this.ELP == null) {
      eCI();
    }
    this.ELP.a(paramInt, paramd);
    AppMethodBeat.o(189886);
    return this;
  }
  
  public final void eCI()
  {
    AppMethodBeat.i(189887);
    this.ELP = new i.a(getContext());
    AppMethodBeat.o(189887);
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(189885);
    if (this.mContext == null)
    {
      this.mContext = k.a.eCK().getApplicationContext();
      k.checkNotNull(this.mContext, "Context should not be null");
    }
    Context localContext = this.mContext;
    AppMethodBeat.o(189885);
    return localContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ca.j
 * JD-Core Version:    0.7.0.1
 */
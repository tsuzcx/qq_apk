package com.tencent.mm.bz;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class j
{
  @SuppressLint({"StaticFieldLeak"})
  private static volatile j Gja;
  public i Gjb;
  public Context mContext;
  
  public static j eSb()
  {
    AppMethodBeat.i(194825);
    if (Gja == null) {}
    try
    {
      if (Gja == null) {
        Gja = new j();
      }
      j localj = Gja;
      AppMethodBeat.o(194825);
      return localj;
    }
    finally
    {
      AppMethodBeat.o(194825);
    }
  }
  
  public static String eSd()
  {
    return ":recovery";
  }
  
  public static boolean hK(Context paramContext)
  {
    AppMethodBeat.i(194829);
    boolean bool = k.bV(paramContext, "");
    AppMethodBeat.o(194829);
    return bool;
  }
  
  public static boolean hL(Context paramContext)
  {
    AppMethodBeat.i(194830);
    boolean bool = k.bV(paramContext, ":recovery");
    AppMethodBeat.o(194830);
    return bool;
  }
  
  public final j b(int paramInt, d paramd)
  {
    AppMethodBeat.i(194827);
    if (this.Gjb == null) {
      eSc();
    }
    this.Gjb.a(paramInt, paramd);
    AppMethodBeat.o(194827);
    return this;
  }
  
  public final void eSc()
  {
    AppMethodBeat.i(194828);
    this.Gjb = new i.a(getContext());
    AppMethodBeat.o(194828);
  }
  
  public final Context getContext()
  {
    AppMethodBeat.i(194826);
    if (this.mContext == null)
    {
      this.mContext = k.a.eSe().getApplicationContext();
      k.checkNotNull(this.mContext, "Context should not be null");
    }
    Context localContext = this.mContext;
    AppMethodBeat.o(194826);
    return localContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.bz.j
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.af;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public enum j$a
{
  static
  {
    AppMethodBeat.i(77770);
    fgp = new a("BUSINESS_MY_LIFE_AROUND", 0);
    fgq = new a("BUSINESS_OTHER", 1);
    fgr = new a("BUSINESS_MAX", 2);
    fgs = new a[] { fgp, fgq, fgr };
    AppMethodBeat.o(77770);
  }
  
  private j$a() {}
  
  public static String b(int paramInt, String paramString, Context paramContext)
  {
    AppMethodBeat.i(77769);
    String str2 = "";
    String str1 = str2;
    if (isValid(paramInt))
    {
      str1 = str2;
      if (!bo.isNullOrNil(paramString))
      {
        paramInt = paramContext.getResources().getIdentifier(paramString, "string", paramContext.getPackageName());
        ab.d("MicroMsg.AppMessage", "id: %d.", new Object[] { Integer.valueOf(paramInt) });
        str1 = str2;
        if (paramInt > 0) {
          str1 = paramContext.getResources().getString(paramInt);
        }
      }
    }
    ab.d("MicroMsg.AppMessage", "txt: %s.", new Object[] { str1 });
    AppMethodBeat.o(77769);
    return str1;
  }
  
  public static boolean isValid(int paramInt)
  {
    AppMethodBeat.i(77768);
    if ((paramInt >= fgp.ordinal()) && (paramInt < fgr.ordinal()))
    {
      AppMethodBeat.o(77768);
      return true;
    }
    AppMethodBeat.o(77768);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.af.j.a
 * JD-Core Version:    0.7.0.1
 */
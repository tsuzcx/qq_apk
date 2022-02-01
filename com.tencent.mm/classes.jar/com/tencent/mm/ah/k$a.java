package com.tencent.mm.ah;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public enum k$a
{
  static
  {
    AppMethodBeat.i(150107);
    hhy = new a("BUSINESS_MY_LIFE_AROUND", 0);
    hhz = new a("BUSINESS_OTHER", 1);
    hhA = new a("BUSINESS_MAX", 2);
    hhB = new a[] { hhy, hhz, hhA };
    AppMethodBeat.o(150107);
  }
  
  private k$a() {}
  
  public static String b(int paramInt, String paramString, Context paramContext)
  {
    AppMethodBeat.i(150106);
    String str2 = "";
    String str1 = str2;
    if (isValid(paramInt))
    {
      str1 = str2;
      if (!bs.isNullOrNil(paramString))
      {
        paramInt = paramContext.getResources().getIdentifier(paramString, "string", paramContext.getPackageName());
        ac.d("MicroMsg.AppMessage", "id: %d.", new Object[] { Integer.valueOf(paramInt) });
        str1 = str2;
        if (paramInt > 0) {
          str1 = paramContext.getResources().getString(paramInt);
        }
      }
    }
    ac.d("MicroMsg.AppMessage", "txt: %s.", new Object[] { str1 });
    AppMethodBeat.o(150106);
    return str1;
  }
  
  public static boolean isValid(int paramInt)
  {
    AppMethodBeat.i(150105);
    if ((paramInt >= hhy.ordinal()) && (paramInt < hhA.ordinal()))
    {
      AppMethodBeat.o(150105);
      return true;
    }
    AppMethodBeat.o(150105);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.ah.k.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.ag;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public enum k$a
{
  static
  {
    AppMethodBeat.i(150107);
    iwB = new a("BUSINESS_MY_LIFE_AROUND", 0);
    iwC = new a("BUSINESS_OTHER", 1);
    iwD = new a("BUSINESS_MAX", 2);
    iwE = new a[] { iwB, iwC, iwD };
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
      if (!Util.isNullOrNil(paramString))
      {
        paramInt = paramContext.getResources().getIdentifier(paramString, "string", paramContext.getPackageName());
        Log.d("MicroMsg.AppMessage", "id: %d.", new Object[] { Integer.valueOf(paramInt) });
        str1 = str2;
        if (paramInt > 0) {
          str1 = paramContext.getResources().getString(paramInt);
        }
      }
    }
    Log.d("MicroMsg.AppMessage", "txt: %s.", new Object[] { str1 });
    AppMethodBeat.o(150106);
    return str1;
  }
  
  public static boolean isValid(int paramInt)
  {
    AppMethodBeat.i(150105);
    if ((paramInt >= iwB.ordinal()) && (paramInt < iwD.ordinal()))
    {
      AppMethodBeat.o(150105);
      return true;
    }
    AppMethodBeat.o(150105);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.ag.k.a
 * JD-Core Version:    0.7.0.1
 */
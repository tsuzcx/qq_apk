package com.tencent.mm.h;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.h;

public final class a
{
  public String Title;
  public int cZX;
  public String desc;
  public c fpB;
  public String url;
  
  public static a rM(String paramString)
  {
    AppMethodBeat.i(149961);
    paramString = c.rO(paramString);
    if (paramString != null)
    {
      a locala = new a();
      locala.fpB = paramString;
      locala.url = paramString.url;
      locala.desc = paramString.desc;
      locala.cZX = paramString.cZX;
      locala.Title = paramString.Title;
      AppMethodBeat.o(149961);
      return locala;
    }
    AppMethodBeat.o(149961);
    return null;
  }
  
  public final boolean a(Context paramContext, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    int i = 2131755835;
    AppMethodBeat.i(149962);
    if ((this.cZX == 3) || (this.cZX == 4))
    {
      String str3 = this.fpB.fpN;
      String str4 = this.fpB.fpO;
      String str1 = str3;
      String str2 = str4;
      if (bs.isNullOrNil(str3))
      {
        str1 = str3;
        str2 = str4;
        if (bs.isNullOrNil(str4))
        {
          if (this.cZX == 3) {
            i = 2131755939;
          }
          str1 = paramContext.getString(i);
          if (this.cZX != 3) {
            break label178;
          }
          i = 2131755831;
          str2 = paramContext.getString(i);
        }
      }
      if ((bs.isNullOrNil(str1)) || (bs.isNullOrNil(str2)))
      {
        str3 = this.desc;
        str4 = this.Title;
        if (bs.isNullOrNil(str1))
        {
          label151:
          if (!bs.isNullOrNil(str1)) {
            break label192;
          }
          label159:
          h.a(paramContext, str3, str4, str2, paramOnClickListener2);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(149962);
        return true;
        label178:
        i = 2131755691;
        break;
        str2 = str1;
        break label151;
        label192:
        paramOnClickListener2 = paramOnClickListener1;
        break label159;
        h.d(paramContext, this.desc, this.Title, str1, str2, paramOnClickListener1, paramOnClickListener2);
      }
    }
    if (this.cZX == 1)
    {
      h.a(paramContext, this.desc, this.Title, paramContext.getString(2131755835), true, paramOnClickListener1);
      AppMethodBeat.o(149962);
      return true;
    }
    if (this.cZX == 5)
    {
      h.c(paramContext, this.desc, this.Title, true);
      AppMethodBeat.o(149962);
      return true;
    }
    AppMethodBeat.o(149962);
    return false;
  }
  
  public final boolean a(Context paramContext, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    AppMethodBeat.i(149963);
    h.a(paramContext, this.desc, this.Title, paramOnDismissListener);
    AppMethodBeat.o(149963);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.h.a
 * JD-Core Version:    0.7.0.1
 */
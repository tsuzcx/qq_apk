package com.tencent.mm.h;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;

public final class a
{
  public String Title;
  public int dDG;
  public String desc;
  public c gpb;
  public String url;
  
  public static a Dk(String paramString)
  {
    AppMethodBeat.i(149961);
    paramString = c.Dm(paramString);
    if (paramString != null)
    {
      a locala = new a();
      locala.gpb = paramString;
      locala.url = paramString.url;
      locala.desc = paramString.desc;
      locala.dDG = paramString.dDG;
      locala.Title = paramString.Title;
      AppMethodBeat.o(149961);
      return locala;
    }
    AppMethodBeat.o(149961);
    return null;
  }
  
  public final boolean a(Context paramContext, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    int i = 2131755921;
    AppMethodBeat.i(149962);
    if ((this.dDG == 3) || (this.dDG == 4))
    {
      String str3 = this.gpb.gpn;
      String str4 = this.gpb.gpo;
      String str1 = str3;
      String str2 = str4;
      if (Util.isNullOrNil(str3))
      {
        str1 = str3;
        str2 = str4;
        if (Util.isNullOrNil(str4))
        {
          if (this.dDG == 3) {
            i = 2131756033;
          }
          str1 = paramContext.getString(i);
          if (this.dDG != 3) {
            break label178;
          }
          i = 2131755917;
          str2 = paramContext.getString(i);
        }
      }
      if ((Util.isNullOrNil(str1)) || (Util.isNullOrNil(str2)))
      {
        str3 = this.desc;
        str4 = this.Title;
        if (Util.isNullOrNil(str1))
        {
          label151:
          if (!Util.isNullOrNil(str1)) {
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
        i = 2131755761;
        break;
        str2 = str1;
        break label151;
        label192:
        paramOnClickListener2 = paramOnClickListener1;
        break label159;
        h.c(paramContext, this.desc, this.Title, str1, str2, paramOnClickListener1, paramOnClickListener2);
      }
    }
    if (this.dDG == 1)
    {
      h.a(paramContext, this.desc, this.Title, paramContext.getString(2131755921), true, paramOnClickListener1);
      AppMethodBeat.o(149962);
      return true;
    }
    if (this.dDG == 5)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.h.a
 * JD-Core Version:    0.7.0.1
 */
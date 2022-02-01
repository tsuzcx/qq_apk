package com.tencent.mm.broadcast;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.comm.c.h;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.k;

public final class a
{
  public String desc;
  public int hAN;
  public String hAP;
  public c lvp;
  public String url;
  
  public static a CH(String paramString)
  {
    AppMethodBeat.i(149961);
    paramString = c.CJ(paramString);
    if (paramString != null)
    {
      a locala = new a();
      locala.lvp = paramString;
      locala.url = paramString.url;
      locala.desc = paramString.desc;
      locala.hAN = paramString.hAN;
      locala.hAP = paramString.hAP;
      AppMethodBeat.o(149961);
      return locala;
    }
    AppMethodBeat.o(149961);
    return null;
  }
  
  public final boolean a(Context paramContext, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(149962);
    if ((this.hAN == 3) || (this.hAN == 4))
    {
      String str3 = this.lvp.lvB;
      String str4 = this.lvp.lvC;
      String str1 = str3;
      String str2 = str4;
      int i;
      if (Util.isNullOrNil(str3))
      {
        str1 = str3;
        str2 = str4;
        if (Util.isNullOrNil(str4))
        {
          if (this.hAN != 3) {
            break label176;
          }
          i = c.h.app_yes;
          str1 = paramContext.getString(i);
          if (this.hAN != 3) {
            break label184;
          }
          i = c.h.app_no;
          label105:
          str2 = paramContext.getString(i);
        }
      }
      if ((Util.isNullOrNil(str1)) || (Util.isNullOrNil(str2)))
      {
        str3 = this.desc;
        str4 = this.hAP;
        if (Util.isNullOrNil(str1))
        {
          label149:
          if (!Util.isNullOrNil(str1)) {
            break label199;
          }
          label157:
          k.a(paramContext, str3, str4, str2, paramOnClickListener2);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(149962);
        return true;
        label176:
        i = c.h.app_ok;
        break;
        label184:
        i = c.h.app_cancel;
        break label105;
        str2 = str1;
        break label149;
        label199:
        paramOnClickListener2 = paramOnClickListener1;
        break label157;
        k.b(paramContext, this.desc, this.hAP, str1, str2, paramOnClickListener1, paramOnClickListener2);
      }
    }
    if (this.hAN == 1)
    {
      k.a(paramContext, this.desc, this.hAP, paramContext.getString(c.h.app_ok), true, paramOnClickListener1);
      AppMethodBeat.o(149962);
      return true;
    }
    if (this.hAN == 5)
    {
      k.c(paramContext, this.desc, this.hAP, true);
      AppMethodBeat.o(149962);
      return true;
    }
    AppMethodBeat.o(149962);
    return false;
  }
  
  public final boolean a(Context paramContext, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    AppMethodBeat.i(149963);
    k.a(paramContext, this.desc, this.hAP, paramOnDismissListener);
    AppMethodBeat.o(149963);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.broadcast.a
 * JD-Core Version:    0.7.0.1
 */
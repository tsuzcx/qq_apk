package com.tencent.mm.i;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.comm.a.h;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.base.h;

public final class a
{
  public String bGw;
  public String desc;
  private c dkA;
  public int showType;
  public String url;
  
  public static a eI(String paramString)
  {
    paramString = c.eK(paramString);
    if (paramString != null)
    {
      a locala = new a();
      locala.dkA = paramString;
      locala.url = paramString.url;
      locala.desc = paramString.desc;
      locala.showType = paramString.showType;
      locala.bGw = paramString.bGw;
      return locala;
    }
    return null;
  }
  
  public final boolean a(Context paramContext, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    if ((this.showType == 3) || (this.showType == 4))
    {
      String str3 = this.dkA.dkM;
      String str4 = this.dkA.dkN;
      String str1 = str3;
      String str2 = str4;
      int i;
      if (bk.bl(str3))
      {
        str1 = str3;
        str2 = str4;
        if (bk.bl(str4))
        {
          if (this.showType != 3) {
            break label166;
          }
          i = a.h.app_yes;
          str1 = paramContext.getString(i);
          if (this.showType != 3) {
            break label174;
          }
          i = a.h.app_no;
          label100:
          str2 = paramContext.getString(i);
        }
      }
      if ((bk.bl(str1)) || (bk.bl(str2)))
      {
        str3 = this.desc;
        str4 = this.bGw;
        if (bk.bl(str1))
        {
          label144:
          if (!bk.bl(str1)) {
            break label189;
          }
          label152:
          h.a(paramContext, str3, str4, str2, paramOnClickListener2);
        }
      }
      for (;;)
      {
        return true;
        label166:
        i = a.h.app_ok;
        break;
        label174:
        i = a.h.app_cancel;
        break label100;
        str2 = str1;
        break label144;
        label189:
        paramOnClickListener2 = paramOnClickListener1;
        break label152;
        h.a(paramContext, this.desc, this.bGw, str1, str2, paramOnClickListener1, paramOnClickListener2);
      }
    }
    if (this.showType == 1)
    {
      h.b(paramContext, this.desc, this.bGw, true);
      return true;
    }
    if (this.showType == 5)
    {
      h.b(paramContext, this.desc, this.bGw, true);
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.i.a
 * JD-Core Version:    0.7.0.1
 */
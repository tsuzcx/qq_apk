package com.tencent.mm.h;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.9;
import com.tencent.mm.ui.widget.b.c.a;

public final class a
{
  public String Title;
  public String desc;
  private c ebU;
  public int showType;
  public String url;
  
  public static a kO(String paramString)
  {
    AppMethodBeat.i(77627);
    paramString = c.kQ(paramString);
    if (paramString != null)
    {
      a locala = new a();
      locala.ebU = paramString;
      locala.url = paramString.url;
      locala.desc = paramString.desc;
      locala.showType = paramString.showType;
      locala.Title = paramString.Title;
      AppMethodBeat.o(77627);
      return locala;
    }
    AppMethodBeat.o(77627);
    return null;
  }
  
  public final boolean a(Context paramContext, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(77628);
    if ((this.showType == 3) || (this.showType == 4))
    {
      String str3 = this.ebU.ecg;
      String str4 = this.ebU.ech;
      String str1 = str3;
      String str2 = str4;
      int i;
      if (bo.isNullOrNil(str3))
      {
        str1 = str3;
        str2 = str4;
        if (bo.isNullOrNil(str4))
        {
          if (this.showType != 3) {
            break label174;
          }
          i = 2131297115;
          str1 = paramContext.getString(i);
          if (this.showType != 3) {
            break label181;
          }
          i = 2131297014;
          label103:
          str2 = paramContext.getString(i);
        }
      }
      if ((bo.isNullOrNil(str1)) || (bo.isNullOrNil(str2)))
      {
        str3 = this.desc;
        str4 = this.Title;
        if (bo.isNullOrNil(str1))
        {
          label147:
          if (!bo.isNullOrNil(str1)) {
            break label195;
          }
          label155:
          h.a(paramContext, str3, str4, str2, paramOnClickListener2);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(77628);
        return true;
        label174:
        i = 2131297018;
        break;
        label181:
        i = 2131296888;
        break label103;
        str2 = str1;
        break label147;
        label195:
        paramOnClickListener2 = paramOnClickListener1;
        break label155;
        h.d(paramContext, this.desc, this.Title, str1, str2, paramOnClickListener1, paramOnClickListener2);
      }
    }
    if (this.showType == 1)
    {
      h.b(paramContext, this.desc, this.Title, true);
      AppMethodBeat.o(77628);
      return true;
    }
    if (this.showType == 5)
    {
      h.b(paramContext, this.desc, this.Title, true);
      AppMethodBeat.o(77628);
      return true;
    }
    AppMethodBeat.o(77628);
    return false;
  }
  
  public final boolean a(Context paramContext, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    AppMethodBeat.i(77629);
    String str1 = this.desc;
    String str2 = this.Title;
    if (!((Activity)paramContext).isFinishing())
    {
      c.a locala = new c.a(paramContext);
      locala.avm(str2);
      locala.avn(str1);
      locala.a(paramOnDismissListener);
      locala.rG(false);
      locala.Ri(2131297018).a(new h.9());
      paramOnDismissListener = locala.aLZ();
      paramOnDismissListener.show();
      h.a(paramContext, paramOnDismissListener);
    }
    AppMethodBeat.o(77629);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.h.a
 * JD-Core Version:    0.7.0.1
 */
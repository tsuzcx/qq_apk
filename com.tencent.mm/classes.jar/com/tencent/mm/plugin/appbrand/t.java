package com.tencent.mm.plugin.appbrand;

import android.content.Intent;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.b.g;
import com.tencent.mm.modelappbrand.b.a;
import com.tencent.mm.plugin.base.model.c;
import com.tencent.mm.sdk.platformtools.bu;

public final class t
  implements a
{
  public static t aYb()
  {
    return a.jDr;
  }
  
  public final Intent a(String paramString1, int paramInt1, String paramString2, String paramString3, String[] paramArrayOfString, String paramString4, int paramInt2, int paramInt3)
  {
    int i = 0;
    AppMethodBeat.i(43960);
    if (Build.VERSION.SDK_INT >= 26) {}
    String str;
    for (boolean bool = true;; bool = false)
    {
      str = c.aE(paramString2, bool);
      if (!bu.isNullOrNil(str)) {
        break;
      }
      AppMethodBeat.o(43960);
      return null;
    }
    if (TextUtils.isEmpty(paramString3)) {}
    for (;;)
    {
      paramString3 = new StringBuilder();
      int j = paramArrayOfString.length;
      while (i < j)
      {
        paramString3.append(paramArrayOfString[i]);
        i += 1;
      }
      paramString2 = paramString3;
    }
    paramString2 = g.getMessageDigest((paramString2 + paramString3.toString()).getBytes());
    paramString3 = new Intent("com.tencent.mm.action.WX_SHORTCUT");
    paramString3.putExtra("type", paramInt3);
    paramString3.putExtra("id", str);
    paramString3.putExtra("ext_info", c.aE(paramString4, bool));
    paramString3.putExtra("token", c.eH(paramString4, String.valueOf(paramInt2)));
    paramString3.putExtra("digest", paramString2);
    paramString3.putExtra("ext_info_1", paramInt1);
    paramString3.setPackage(paramString1);
    paramString3.addFlags(67108864);
    AppMethodBeat.o(43960);
    return paramString3;
  }
  
  static final class a
  {
    static t jDr;
    
    static
    {
      AppMethodBeat.i(43959);
      jDr = new t();
      AppMethodBeat.o(43959);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.t
 * JD-Core Version:    0.7.0.1
 */
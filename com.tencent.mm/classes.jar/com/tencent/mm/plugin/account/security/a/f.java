package com.tencent.mm.plugin.account.security.a;

import android.content.Context;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.protocal.protobuf.auo;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.k;
import com.tencent.mm.storage.aj;

public final class f
{
  public static String aUd()
  {
    AppMethodBeat.i(125529);
    String str = Build.MANUFACTURER + "-" + Build.MODEL;
    AppMethodBeat.o(125529);
    return str;
  }
  
  public static String di(Context paramContext)
  {
    AppMethodBeat.i(125528);
    if (paramContext == null)
    {
      if (k.IwL)
      {
        paramContext = ak.getContext().getString(2131762749);
        AppMethodBeat.o(125528);
        return paramContext;
      }
      paramContext = ak.getContext().getString(2131762748);
      AppMethodBeat.o(125528);
      return paramContext;
    }
    if (k.IwL)
    {
      paramContext = paramContext.getString(2131762749);
      AppMethodBeat.o(125528);
      return paramContext;
    }
    paramContext = paramContext.getString(2131762748);
    AppMethodBeat.o(125528);
    return paramContext;
  }
  
  public static void p(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(125527);
    if (!g.ajM())
    {
      AppMethodBeat.o(125527);
      return;
    }
    int i = v.aAI();
    auo localauo;
    if (paramBoolean1)
    {
      i |= 0x4000;
      g.ajR().ajA().set(40, Integer.valueOf(i));
      if (paramBoolean2)
      {
        localauo = new auo();
        localauo.GLx = 28;
        if (!paramBoolean1) {
          break label126;
        }
      }
    }
    label126:
    for (i = 1;; i = 2)
    {
      localauo.xsz = i;
      ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azE().d(new k.a(23, localauo));
      a.iUA.MM();
      AppMethodBeat.o(125527);
      return;
      i &= 0xFFFFBFFF;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.a.f
 * JD-Core Version:    0.7.0.1
 */
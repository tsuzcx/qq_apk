package com.tencent.mm.plugin.account.security.a;

import android.content.Context;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.protocal.protobuf.amy;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.ab;

public final class f
{
  public static String aJB()
  {
    AppMethodBeat.i(125529);
    String str = Build.MANUFACTURER + "-" + Build.MODEL;
    AppMethodBeat.o(125529);
    return str;
  }
  
  public static String cZ(Context paramContext)
  {
    AppMethodBeat.i(125528);
    if (paramContext == null)
    {
      if (com.tencent.mm.sdk.platformtools.i.ETz)
      {
        paramContext = aj.getContext().getString(2131762749);
        AppMethodBeat.o(125528);
        return paramContext;
      }
      paramContext = aj.getContext().getString(2131762748);
      AppMethodBeat.o(125528);
      return paramContext;
    }
    if (com.tencent.mm.sdk.platformtools.i.ETz)
    {
      paramContext = paramContext.getString(2131762749);
      AppMethodBeat.o(125528);
      return paramContext;
    }
    paramContext = paramContext.getString(2131762748);
    AppMethodBeat.o(125528);
    return paramContext;
  }
  
  public static void o(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(125527);
    if (!g.afw())
    {
      AppMethodBeat.o(125527);
      return;
    }
    int i = u.aqM();
    amy localamy;
    if (paramBoolean1)
    {
      i |= 0x4000;
      g.afB().afk().set(40, Integer.valueOf(i));
      if (paramBoolean2)
      {
        localamy = new amy();
        localamy.DnY = 28;
        if (!paramBoolean1) {
          break label126;
        }
      }
    }
    label126:
    for (i = 1;; i = 2)
    {
      localamy.uMR = i;
      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apL().c(new j.a(23, localamy));
      a.hYu.Ll();
      AppMethodBeat.o(125527);
      return;
      i &= 0xFFFFBFFF;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.a.f
 * JD-Core Version:    0.7.0.1
 */
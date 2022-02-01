package com.tencent.mm.plugin.account.security.a;

import android.content.Context;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.protocal.protobuf.aqc;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.storage.ae;

public final class f
{
  public static String aQs()
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
      if (com.tencent.mm.sdk.platformtools.i.GqM)
      {
        paramContext = ai.getContext().getString(2131762749);
        AppMethodBeat.o(125528);
        return paramContext;
      }
      paramContext = ai.getContext().getString(2131762748);
      AppMethodBeat.o(125528);
      return paramContext;
    }
    if (com.tencent.mm.sdk.platformtools.i.GqM)
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
    if (!g.agM())
    {
      AppMethodBeat.o(125527);
      return;
    }
    int i = u.axC();
    aqc localaqc;
    if (paramBoolean1)
    {
      i |= 0x4000;
      g.agR().agA().set(40, Integer.valueOf(i));
      if (paramBoolean2)
      {
        localaqc = new aqc();
        localaqc.EIY = 28;
        if (!paramBoolean1) {
          break label126;
        }
      }
    }
    label126:
    for (i = 1;; i = 2)
    {
      localaqc.vVH = i;
      ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awA().c(new j.a(23, localaqc));
      a.iyy.Lj();
      AppMethodBeat.o(125527);
      return;
      i &= 0xFFFFBFFF;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.a.f
 * JD-Core Version:    0.7.0.1
 */
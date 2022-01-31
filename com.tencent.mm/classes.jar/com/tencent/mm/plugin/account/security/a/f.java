package com.tencent.mm.plugin.account.security.a;

import android.content.Context;
import android.os.Build;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.account.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.a.j.a;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.protocal.protobuf.aek;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.z;

public final class f
{
  public static String arb()
  {
    AppMethodBeat.i(69844);
    String str = Build.MANUFACTURER + "-" + Build.MODEL;
    AppMethodBeat.o(69844);
    return str;
  }
  
  public static String cF(Context paramContext)
  {
    AppMethodBeat.i(69843);
    if (paramContext == null)
    {
      if (com.tencent.mm.sdk.platformtools.g.ymO)
      {
        paramContext = ah.getContext().getString(2131302837);
        AppMethodBeat.o(69843);
        return paramContext;
      }
      paramContext = ah.getContext().getString(2131302836);
      AppMethodBeat.o(69843);
      return paramContext;
    }
    if (com.tencent.mm.sdk.platformtools.g.ymO)
    {
      paramContext = paramContext.getString(2131302837);
      AppMethodBeat.o(69843);
      return paramContext;
    }
    paramContext = paramContext.getString(2131302836);
    AppMethodBeat.o(69843);
    return paramContext;
  }
  
  public static void n(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(69842);
    if (!com.tencent.mm.kernel.g.RG())
    {
      AppMethodBeat.o(69842);
      return;
    }
    int i = r.Zt();
    aek localaek;
    if (paramBoolean1)
    {
      i |= 0x4000;
      com.tencent.mm.kernel.g.RL().Ru().set(40, Integer.valueOf(i));
      if (paramBoolean2)
      {
        localaek = new aek();
        localaek.wXn = 28;
        if (!paramBoolean1) {
          break label126;
        }
      }
    }
    label126:
    for (i = 1;; i = 2)
    {
      localaek.pKC = i;
      ((j)com.tencent.mm.kernel.g.E(j.class)).Yz().c(new j.a(23, localaek));
      a.gmP.BO();
      AppMethodBeat.o(69842);
      return;
      i &= 0xFFFFBFFF;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.security.a.f
 * JD-Core Version:    0.7.0.1
 */
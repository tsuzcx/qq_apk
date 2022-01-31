package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.as;
import com.tencent.mm.sdk.platformtools.ab;

public final class h
{
  public static void a(Context paramContext, ViewGroup paramViewGroup, as paramas, h.c paramc)
  {
    AppMethodBeat.i(42900);
    if (paramas == null)
    {
      AppMethodBeat.o(42900);
      return;
    }
    a(paramContext, paramViewGroup, paramas, paramc, paramas.type);
    AppMethodBeat.o(42900);
  }
  
  public static void a(Context paramContext, ViewGroup paramViewGroup, as paramas, h.c paramc, String paramString)
  {
    AppMethodBeat.i(42901);
    if ((paramViewGroup == null) || (paramas == null))
    {
      AppMethodBeat.o(42901);
      return;
    }
    if (paramas.eoD == 0)
    {
      ab.i("MicroMsg.LuckyMoneyOperationViewMgr", "operInfo enable:" + paramas.eoD);
      paramViewGroup.setVisibility(8);
      AppMethodBeat.o(42901);
      return;
    }
    if (!paramas.type.equalsIgnoreCase(paramString))
    {
      ab.i("MicroMsg.LuckyMoneyOperationViewMgr", "not match type:" + paramas.type + ", " + paramString);
      paramViewGroup.setVisibility(8);
      AppMethodBeat.o(42901);
      return;
    }
    if ((paramString.equalsIgnoreCase("Text")) || (paramString.equalsIgnoreCase("Native")))
    {
      paramString = new h.e();
      paramString.ovE = paramc;
      paramString.a(paramContext, paramViewGroup, paramas);
      AppMethodBeat.o(42901);
      return;
    }
    if (paramString.equalsIgnoreCase("Pic"))
    {
      paramString = new h.a();
      paramString.ovE = paramc;
      paramString.a(paramContext, paramViewGroup, paramas);
      AppMethodBeat.o(42901);
      return;
    }
    if (paramString.equalsIgnoreCase("Appid"))
    {
      paramString = new h.b();
      paramString.ovE = paramc;
      paramString.a(paramContext, paramViewGroup, paramas);
    }
    AppMethodBeat.o(42901);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.h
 * JD-Core Version:    0.7.0.1
 */
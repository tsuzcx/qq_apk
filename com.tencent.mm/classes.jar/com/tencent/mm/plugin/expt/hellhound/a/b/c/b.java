package com.tencent.mm.plugin.expt.hellhound.a.b.c;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.aux;
import com.tencent.mm.protocal.protobuf.auy;
import com.tencent.mm.protocal.protobuf.bki;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vending.j.c;
import java.util.LinkedList;

public final class b
{
  public static void T(String paramString, long paramLong)
  {
    AppMethodBeat.i(152395);
    aux localaux = a.bsu();
    if (localaux.fjy.isEmpty())
    {
      ab.e("HellPageFlowManager", "HABBYGE-MALI, setEndTimeOfPageWhenEvent8, pageFlow.items == NULL");
      AppMethodBeat.o(152395);
      return;
    }
    paramString = com.tencent.mm.plugin.expt.hellhound.core.b.Mb(paramString);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(152395);
      return;
    }
    paramString = (auy)localaux.fjy.getLast();
    if (paramString == null)
    {
      AppMethodBeat.o(152395);
      return;
    }
    paramLong -= paramString.startTime;
    if (paramLong > 0L) {}
    for (;;)
    {
      paramString.duration = paramLong;
      a.a(localaux);
      AppMethodBeat.o(152395);
      return;
      paramLong = 0L;
    }
  }
  
  public static void U(String paramString, long paramLong)
  {
    AppMethodBeat.i(152396);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(152396);
      return;
    }
    Object localObject = com.tencent.mm.plugin.expt.hellhound.core.b.Mb(paramString);
    paramString = new auy();
    paramString.xkf = ((String)localObject);
    paramString.startTime = paramLong;
    bki localbki = com.tencent.mm.plugin.expt.hellhound.a.b.b.a.bsj();
    if (localbki == null)
    {
      ab.i("HellPageFlowManager", "HABBYGE-MALI, setPageStartTimeOfCurSession, addPageFlow, Unknown Page: ".concat(String.valueOf(localObject)));
      paramString.czq = null;
    }
    for (;;)
    {
      localObject = a.bsu();
      ((aux)localObject).fjy.addLast(paramString);
      a.a((aux)localObject);
      AppMethodBeat.o(152396);
      return;
      paramString.czq = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.c(localbki);
      ab.i("HellPageFlowManager", "HABBYGE-MALI, setPageStartTimeOfCurSession, addPageFlow, session: " + (String)localObject + " | " + paramString.czq);
    }
  }
  
  public static void a(auy paramauy, int paramInt)
  {
    AppMethodBeat.i(156442);
    if (paramauy == null)
    {
      AppMethodBeat.o(156442);
      return;
    }
    aux localaux = a.bsu();
    try
    {
      localaux.fjy.set(paramInt, paramauy);
      a.a(localaux);
      AppMethodBeat.o(156442);
      return;
    }
    catch (Exception paramauy)
    {
      ab.printErrStackTrace("HellPageFlowManager", paramauy, "HABBYGE-MALI, updatePageFlowItemOfCurSession crash", new Object[0]);
      AppMethodBeat.o(156442);
    }
  }
  
  public static void a(bki parambki, String paramString, long paramLong)
  {
    AppMethodBeat.i(152393);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(152393);
      return;
    }
    if ((parambki != null) && (com.tencent.mm.plugin.expt.hellhound.a.b.f.a.MT(parambki.czq)))
    {
      ab.w("HellPageFlowManager", "HABBYGE-MALI, addpageFlow scan-session, need filter !!");
      AppMethodBeat.o(152393);
      return;
    }
    b(parambki, paramString, paramLong);
    AppMethodBeat.o(152393);
  }
  
  public static c<auy, Integer> b(bki parambki, String paramString)
  {
    AppMethodBeat.i(156441);
    if ((parambki == null) || (paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(156441);
      return null;
    }
    ab.d("HellPageFlowManager", "habbyge-mali, getPageFlowItemOfCurSession: " + paramString + " | " + parambki.xyK + " | " + parambki.czq);
    aux localaux = a.bsu();
    int i = localaux.fjy.size() - 1;
    while (i >= 0)
    {
      auy localauy = (auy)localaux.fjy.get(i);
      if ((localauy.czq.equals(parambki.czq)) && (localauy.xkf.equals(paramString)))
      {
        parambki = com.tencent.mm.vending.j.a.C(localauy, Integer.valueOf(i));
        AppMethodBeat.o(156441);
        return parambki;
      }
      i -= 1;
    }
    AppMethodBeat.o(156441);
    return null;
  }
  
  public static void b(bki parambki, String paramString, long paramLong)
  {
    AppMethodBeat.i(152394);
    String str = com.tencent.mm.plugin.expt.hellhound.core.b.Mb(paramString);
    paramString = new auy();
    paramString.xkf = str;
    paramString.startTime = paramLong;
    if (parambki == null)
    {
      ab.i("HellPageFlowManager", "HABBYGE-MALI, addPageFlow, Unknown Page: ".concat(String.valueOf(str)));
      paramString.czq = null;
    }
    for (;;)
    {
      parambki = a.bsu();
      parambki.fjy.addLast(paramString);
      a.a(parambki);
      AppMethodBeat.o(152394);
      return;
      paramString.czq = com.tencent.mm.plugin.expt.hellhound.a.b.a.b.c(parambki);
      ab.i("HellPageFlowManager", "HABBYGE-MALI, addPageFlow, session: " + str + " | " + paramString.czq);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.c.b
 * JD-Core Version:    0.7.0.1
 */
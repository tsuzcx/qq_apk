package com.tencent.mm.plugin.expt.hellhound.a.f.d;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.j;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.k;
import com.tencent.mm.protocal.protobuf.bot;
import com.tencent.mm.protocal.protobuf.bou;
import com.tencent.mm.protocal.protobuf.cie;
import com.tencent.mm.sdk.platformtools.ae;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class b
{
  private static void a(bot parambot, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(177397);
    int j = parambot.Hck.size();
    int i = j;
    if (!paramBoolean) {
      i = j - 1;
    }
    i -= 1;
    bou localbou;
    if (i >= 0)
    {
      localbou = (bou)parambot.Hck.get(i);
      if (localbou != null)
      {
        if (!localbou.dAa.equals(paramString1)) {
          break label144;
        }
        localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.afE(paramString1);
        if (localObject1 == null) {
          break label156;
        }
      }
    }
    label144:
    label156:
    for (Object localObject1 = (String)((com.tencent.mm.vending.j.c)localObject1).get(1);; localObject1 = null)
    {
      Object localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.afE(paramString2);
      if (localObject2 != null) {}
      for (localObject2 = (String)((com.tencent.mm.vending.j.c)localObject2).get(1);; localObject2 = null)
      {
        if ((localObject1 != null) && (((String)localObject1).equals(localObject2))) {
          localbou.dAa = paramString2;
        }
        i -= 1;
        break;
        AppMethodBeat.o(177397);
        return;
      }
    }
  }
  
  public static void a(bou parambou, int paramInt)
  {
    AppMethodBeat.i(196139);
    if (parambou == null)
    {
      AppMethodBeat.o(196139);
      return;
    }
    bot localbot = a.crZ();
    try
    {
      localbot.Hck.set(paramInt, parambou);
      a.a(localbot);
      AppMethodBeat.o(196139);
      return;
    }
    catch (Exception parambou)
    {
      ae.printErrStackTrace("HABBYGE-MALI.HellPageFlowManager", parambou, "updatePageFlow crash: %s", new Object[] { parambou.getMessage() });
      AppMethodBeat.o(196139);
    }
  }
  
  public static void a(cie paramcie, String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(196135);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(196135);
      return;
    }
    if ((paramcie != null) && (com.tencent.mm.plugin.expt.hellhound.a.f.g.a.agq(paramcie.sessionId)))
    {
      ae.i("HABBYGE-MALI.HellPageFlowManager", "addpageFlow scan-session, need filter !!");
      AppMethodBeat.o(196135);
      return;
    }
    b(paramcie, paramString, paramInt, paramLong);
    AppMethodBeat.o(196135);
  }
  
  public static List<bou> agf(String paramString)
  {
    AppMethodBeat.i(122178);
    if (paramString == null)
    {
      AppMethodBeat.o(122178);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    bot localbot = a.crZ();
    int j = localbot.Hck.size();
    int i = 0;
    while (i < j)
    {
      bou localbou = (bou)localbot.Hck.get(i);
      if (localbou.dAa.equals(paramString)) {
        localArrayList.add(localbou);
      }
      i += 1;
    }
    AppMethodBeat.o(122178);
    return localArrayList;
  }
  
  public static void aq(String paramString, long paramLong)
  {
    AppMethodBeat.i(122176);
    bot localbot = a.crZ();
    if (localbot.Hck.isEmpty())
    {
      ae.e("HABBYGE-MALI.HellPageFlowManager", "setEndTimeOfPageWhenEvent8, pageFlow.items == NULL");
      AppMethodBeat.o(122176);
      return;
    }
    paramString = com.tencent.mm.plugin.expt.hellhound.core.b.aer(paramString);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(122176);
      return;
    }
    paramString = (bou)localbot.Hck.getLast();
    if (paramString == null)
    {
      AppMethodBeat.o(122176);
      return;
    }
    paramLong -= paramString.startTime;
    if (paramLong > 0L) {}
    for (;;)
    {
      paramString.duration = paramLong;
      a.a(localbot);
      AppMethodBeat.o(122176);
      return;
      paramLong = 0L;
    }
  }
  
  public static void b(cie paramcie, String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(196136);
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.aer(paramString);
    bot localbot = a.crZ();
    if (paramcie == null)
    {
      if ((!"LauncherUI".equals(localObject1)) && (!"FinderHomeUI".equals(localObject1)))
      {
        paramString = (String)localObject1;
        if (!"FinderConversationUI".equals(localObject1)) {}
      }
      else
      {
        ae.i("HABBYGE-MALI.HellPageFlowManager", "Invalidate Page: LauncherUI/FinderHomeUI");
        AppMethodBeat.o(196136);
      }
    }
    else
    {
      if ("LauncherUI".equals(localObject1))
      {
        ae.i("HABBYGE-MALI.HellPageFlowManager", "Invalidate Page: LauncherUI");
        AppMethodBeat.o(196136);
        return;
      }
      if (!"FinderHomeUI".equals(localObject1))
      {
        paramString = (String)localObject1;
        if (!"FinderConversationUI".equals(localObject1)) {}
      }
      else
      {
        paramString = j.cpR();
        if (paramString == null) {
          break label323;
        }
      }
    }
    Object localObject2;
    label323:
    for (paramString = paramString.getClass().getSimpleName();; paramString = "FinderFollowTabFragment")
    {
      ae.i("HABBYGE-MALI.HellPageFlowManager", "maybe invalidate Page: FinderHomeUI in %s, %s", new Object[] { paramcie.sessionId, paramString });
      localObject1 = (bou)localbot.Hck.peekLast();
      if (localObject1 == null) {
        break label483;
      }
      if (!((bou)localObject1).duQ.equals(paramString)) {
        break;
      }
      if ((paramcie != null) && (!paramcie.sessionId.equals(((bou)localObject1).dAa)))
      {
        localObject2 = ((bou)localObject1).dAa;
        ((bou)localObject1).dAa = paramcie.sessionId;
        localbot.Hck.set(localbot.Hck.size() - 1, localObject1);
        a(localbot, (String)localObject2, paramcie.sessionId, false);
        a.a(localbot);
      }
      if ((((bou)localObject1).aHQ <= 0) && (paramInt > 0))
      {
        ((bou)localObject1).aHQ = paramInt;
        a.a(localbot);
      }
      ae.i("HABBYGE-MALI.HellPageFlowManager", "repeated page, no need to add this page: %s, %d, %s, %d", new Object[] { ((bou)localObject1).duQ, Integer.valueOf(((bou)localObject1).aHQ), paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(196136);
      return;
    }
    if ((paramcie != null) && (!((bou)localObject1).dAa.equals(paramcie.sessionId))) {
      a(localbot, ((bou)localObject1).dAa, paramcie.sessionId, true);
    }
    int i = localbot.Hck.size();
    if (i > 2)
    {
      localObject2 = (bou)localbot.Hck.get(i - 2);
      if (localObject2 != null)
      {
        if (("MsgRetransmitUI".equals(((bou)localObject2).duQ)) && ("SelectConversationUI".equals(((bou)localObject1).duQ)) && ("MsgRetransmitUI".equals(paramString)))
        {
          AppMethodBeat.o(196136);
          return;
        }
        if (("SelectConversationUI".equals(((bou)localObject2).duQ)) && ("MsgRetransmitUI".equals(((bou)localObject1).duQ)) && ("SelectConversationUI".equals(paramString)))
        {
          AppMethodBeat.o(196136);
          return;
        }
      }
    }
    label483:
    localObject1 = new bou();
    ((bou)localObject1).duQ = paramString;
    ((bou)localObject1).aHQ = paramInt;
    ((bou)localObject1).startTime = paramLong;
    if (paramcie == null)
    {
      ae.i("HABBYGE-MALI.HellPageFlowManager", "addPageFlow, Unknown Page: %s, %d", new Object[] { paramString, Integer.valueOf(paramInt) });
      ((bou)localObject1).dAa = null;
      k.crT();
    }
    for (;;)
    {
      localbot.Hck.addLast(localObject1);
      a.a(localbot);
      AppMethodBeat.o(196136);
      return;
      ((bou)localObject1).dAa = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.j(paramcie);
      ae.i("HABBYGE-MALI.HellPageFlowManager", "addPageFlow, session: %s, %d, %s", new Object[] { paramString, Integer.valueOf(paramInt), ((bou)localObject1).dAa });
      k.a((bou)localObject1);
    }
  }
  
  public static Pair<bou, Integer> csb()
  {
    AppMethodBeat.i(196140);
    Object localObject = a.crZ();
    if (((bot)localObject).Hck.isEmpty())
    {
      AppMethodBeat.o(196140);
      return null;
    }
    localObject = Pair.create(((bot)localObject).Hck.getLast(), Integer.valueOf(((bot)localObject).Hck.size() - 1));
    AppMethodBeat.o(196140);
    return localObject;
  }
  
  public static com.tencent.mm.vending.j.c<bou, Integer> gc(String paramString1, String paramString2)
  {
    AppMethodBeat.i(196138);
    if ((paramString1 == null) || (paramString2 == null) || (paramString2.isEmpty()))
    {
      AppMethodBeat.o(196138);
      return null;
    }
    paramString2 = com.tencent.mm.plugin.expt.hellhound.core.b.aer(paramString2);
    ae.i("HABBYGE-MALI.HellPageFlowManager", "getPageFlowItemOfCurSession: %s, %s", new Object[] { paramString2, paramString1 });
    bot localbot = a.crZ();
    int i = localbot.Hck.size() - 1;
    while (i >= 0)
    {
      bou localbou = (bou)localbot.Hck.get(i);
      if (localbou.dAa.equals(paramString1))
      {
        String str = com.tencent.mm.plugin.expt.hellhound.core.b.aer(localbou.duQ);
        if ((str != null) && (str.equals(paramString2)))
        {
          paramString1 = com.tencent.mm.vending.j.a.N(localbou, Integer.valueOf(i));
          AppMethodBeat.o(196138);
          return paramString1;
        }
      }
      i -= 1;
    }
    AppMethodBeat.o(196138);
    return null;
  }
  
  public static void y(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(196137);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(196137);
      return;
    }
    Object localObject = com.tencent.mm.plugin.expt.hellhound.core.b.aer(paramString);
    paramString = new bou();
    paramString.duQ = ((String)localObject);
    paramString.aHQ = paramInt;
    paramString.startTime = paramLong;
    cie localcie = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.crG();
    if (localcie == null)
    {
      ae.i("HABBYGE-MALI.HellPageFlowManager", "addPageflow(addPage2Flow), Unknown Page: %s", new Object[] { localObject });
      paramString.dAa = null;
      k.crT();
    }
    for (;;)
    {
      localObject = a.crZ();
      ((bot)localObject).Hck.addLast(paramString);
      a.a((bot)localObject);
      AppMethodBeat.o(196137);
      return;
      paramString.dAa = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.j(localcie);
      ae.i("HABBYGE-MALI.HellPageFlowManager", "addPageflow(addPage2Flow), session: %s, %s", new Object[] { localObject, paramString.dAa });
      k.a(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.d.b
 * JD-Core Version:    0.7.0.1
 */
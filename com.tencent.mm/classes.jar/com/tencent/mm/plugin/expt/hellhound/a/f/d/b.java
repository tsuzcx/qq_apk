package com.tencent.mm.plugin.expt.hellhound.a.f.d;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cbl;
import com.tencent.mm.protocal.protobuf.cbm;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class b
{
  private static void a(cbl paramcbl, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(177397);
    int j = paramcbl.Mhn.size();
    int i = j;
    if (!paramBoolean) {
      i = j - 1;
    }
    i -= 1;
    cbm localcbm;
    if (i >= 0)
    {
      localcbm = (cbm)paramcbl.Mhn.get(i);
      if (localcbm != null)
      {
        if (!localcbm.dRM.equals(paramString1)) {
          break label144;
        }
        localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqp(paramString1);
        if (localObject1 == null) {
          break label156;
        }
      }
    }
    label144:
    label156:
    for (Object localObject1 = (String)((com.tencent.mm.vending.j.c)localObject1).get(1);; localObject1 = null)
    {
      Object localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aqp(paramString2);
      if (localObject2 != null) {}
      for (localObject2 = (String)((com.tencent.mm.vending.j.c)localObject2).get(1);; localObject2 = null)
      {
        if ((localObject1 != null) && (((String)localObject1).equals(localObject2))) {
          localcbm.dRM = paramString2;
        }
        i -= 1;
        break;
        AppMethodBeat.o(177397);
        return;
      }
    }
  }
  
  public static void a(cbm paramcbm, int paramInt)
  {
    AppMethodBeat.i(220570);
    if (paramcbm == null)
    {
      AppMethodBeat.o(220570);
      return;
    }
    cbl localcbl = a.cQH();
    try
    {
      localcbl.Mhn.set(paramInt, paramcbm);
      a.a(localcbl);
      AppMethodBeat.o(220570);
      return;
    }
    catch (Exception paramcbm)
    {
      Log.printErrStackTrace("HABBYGE-MALI.HellPageFlowManager", paramcbm, "updatePageFlow crash: %s", new Object[] { paramcbm.getMessage() });
      AppMethodBeat.o(220570);
    }
  }
  
  public static void a(cyl paramcyl, String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(220566);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(220566);
      return;
    }
    if ((paramcyl != null) && (com.tencent.mm.plugin.expt.hellhound.a.f.g.a.arb(paramcyl.sessionId)))
    {
      Log.i("HABBYGE-MALI.HellPageFlowManager", "addpageFlow scan-session, need filter !!");
      AppMethodBeat.o(220566);
      return;
    }
    b(paramcyl, paramString, paramInt, paramLong);
    AppMethodBeat.o(220566);
  }
  
  public static void ap(String paramString, long paramLong)
  {
    AppMethodBeat.i(122176);
    cbl localcbl = a.cQH();
    if (localcbl.Mhn.isEmpty())
    {
      Log.e("HABBYGE-MALI.HellPageFlowManager", "setEndTimeOfPageWhenEvent8, pageFlow.items == NULL");
      AppMethodBeat.o(122176);
      return;
    }
    paramString = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(paramString);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(122176);
      return;
    }
    paramString = (cbm)localcbl.Mhn.getLast();
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
      a.a(localcbl);
      AppMethodBeat.o(122176);
      return;
      paramLong = 0L;
    }
  }
  
  public static List<cbm> aqQ(String paramString)
  {
    AppMethodBeat.i(122178);
    if (paramString == null)
    {
      AppMethodBeat.o(122178);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    cbl localcbl = a.cQH();
    int j = localcbl.Mhn.size();
    int i = 0;
    while (i < j)
    {
      cbm localcbm = (cbm)localcbl.Mhn.get(i);
      if (localcbm.dRM.equals(paramString)) {
        localArrayList.add(localcbm);
      }
      i += 1;
    }
    AppMethodBeat.o(122178);
    return localArrayList;
  }
  
  public static void b(cyl paramcyl, String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(220567);
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(paramString);
    cbl localcbl = a.cQH();
    if (paramcyl == null)
    {
      if ((!"LauncherUI".equals(localObject1)) && (!"FinderHomeUI".equals(localObject1)))
      {
        paramString = (String)localObject1;
        if (!"FinderConversationUI".equals(localObject1)) {}
      }
      else
      {
        Log.i("HABBYGE-MALI.HellPageFlowManager", "Invalidate Page: LauncherUI/FinderHomeUI");
        AppMethodBeat.o(220567);
      }
    }
    else
    {
      if ("LauncherUI".equals(localObject1))
      {
        Log.i("HABBYGE-MALI.HellPageFlowManager", "Invalidate Page: LauncherUI");
        AppMethodBeat.o(220567);
        return;
      }
      if (!"FinderHomeUI".equals(localObject1))
      {
        paramString = (String)localObject1;
        if (!"FinderConversationUI".equals(localObject1)) {}
      }
      else
      {
        paramString = com.tencent.mm.plugin.expt.hellhound.a.b.b.k.cOk();
        if (paramString == null) {
          break label323;
        }
      }
    }
    Object localObject2;
    label323:
    for (paramString = paramString.getClass().getSimpleName();; paramString = "FinderFollowTabFragment")
    {
      Log.i("HABBYGE-MALI.HellPageFlowManager", "maybe invalidate Page: FinderHomeUI in %s, %s", new Object[] { paramcyl.sessionId, paramString });
      localObject1 = (cbm)localcbl.Mhn.peekLast();
      if (localObject1 == null) {
        break label483;
      }
      if (!((cbm)localObject1).dMl.equals(paramString)) {
        break;
      }
      if ((paramcyl != null) && (!paramcyl.sessionId.equals(((cbm)localObject1).dRM)))
      {
        localObject2 = ((cbm)localObject1).dRM;
        ((cbm)localObject1).dRM = paramcyl.sessionId;
        localcbl.Mhn.set(localcbl.Mhn.size() - 1, localObject1);
        a(localcbl, (String)localObject2, paramcyl.sessionId, false);
        a.a(localcbl);
      }
      if ((((cbm)localObject1).aHK <= 0) && (paramInt > 0))
      {
        ((cbm)localObject1).aHK = paramInt;
        a.a(localcbl);
      }
      Log.i("HABBYGE-MALI.HellPageFlowManager", "repeated page, no need to add this page: %s, %d, %s, %d", new Object[] { ((cbm)localObject1).dMl, Integer.valueOf(((cbm)localObject1).aHK), paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(220567);
      return;
    }
    if ((paramcyl != null) && (!((cbm)localObject1).dRM.equals(paramcyl.sessionId))) {
      a(localcbl, ((cbm)localObject1).dRM, paramcyl.sessionId, true);
    }
    int i = localcbl.Mhn.size();
    if (i > 2)
    {
      localObject2 = (cbm)localcbl.Mhn.get(i - 2);
      if (localObject2 != null)
      {
        if (("MsgRetransmitUI".equals(((cbm)localObject2).dMl)) && ("SelectConversationUI".equals(((cbm)localObject1).dMl)) && ("MsgRetransmitUI".equals(paramString)))
        {
          AppMethodBeat.o(220567);
          return;
        }
        if (("SelectConversationUI".equals(((cbm)localObject2).dMl)) && ("MsgRetransmitUI".equals(((cbm)localObject1).dMl)) && ("SelectConversationUI".equals(paramString)))
        {
          AppMethodBeat.o(220567);
          return;
        }
      }
    }
    label483:
    localObject1 = new cbm();
    ((cbm)localObject1).dMl = paramString;
    ((cbm)localObject1).aHK = paramInt;
    ((cbm)localObject1).startTime = paramLong;
    if (paramcyl == null)
    {
      Log.i("HABBYGE-MALI.HellPageFlowManager", "addPageFlow, Unknown Page: %s, %d", new Object[] { paramString, Integer.valueOf(paramInt) });
      ((cbm)localObject1).dRM = null;
      com.tencent.mm.plugin.expt.hellhound.a.f.c.k.cQB();
    }
    for (;;)
    {
      localcbl.Mhn.addLast(localObject1);
      a.a(localcbl);
      AppMethodBeat.o(220567);
      return;
      ((cbm)localObject1).dRM = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.j(paramcyl);
      Log.i("HABBYGE-MALI.HellPageFlowManager", "addPageFlow, session: %s, %d, %s", new Object[] { paramString, Integer.valueOf(paramInt), ((cbm)localObject1).dRM });
      com.tencent.mm.plugin.expt.hellhound.a.f.c.k.a((cbm)localObject1);
    }
  }
  
  public static Pair<cbm, Integer> cQJ()
  {
    AppMethodBeat.i(220571);
    Object localObject = a.cQH();
    if (((cbl)localObject).Mhn.isEmpty())
    {
      AppMethodBeat.o(220571);
      return null;
    }
    localObject = Pair.create(((cbl)localObject).Mhn.getLast(), Integer.valueOf(((cbl)localObject).Mhn.size() - 1));
    AppMethodBeat.o(220571);
    return localObject;
  }
  
  public static com.tencent.mm.vending.j.c<cbm, Integer> gw(String paramString1, String paramString2)
  {
    AppMethodBeat.i(220569);
    if ((paramString1 == null) || (paramString2 == null) || (paramString2.isEmpty()))
    {
      AppMethodBeat.o(220569);
      return null;
    }
    paramString2 = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(paramString2);
    Log.i("HABBYGE-MALI.HellPageFlowManager", "getPageFlowItemOfCurSession: %s, %s", new Object[] { paramString2, paramString1 });
    cbl localcbl = a.cQH();
    int i = localcbl.Mhn.size() - 1;
    while (i >= 0)
    {
      cbm localcbm = (cbm)localcbl.Mhn.get(i);
      if (localcbm.dRM.equals(paramString1))
      {
        String str = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(localcbm.dMl);
        if ((str != null) && (str.equals(paramString2)))
        {
          paramString1 = com.tencent.mm.vending.j.a.Q(localcbm, Integer.valueOf(i));
          AppMethodBeat.o(220569);
          return paramString1;
        }
      }
      i -= 1;
    }
    AppMethodBeat.o(220569);
    return null;
  }
  
  public static void x(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(220568);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(220568);
      return;
    }
    Object localObject = com.tencent.mm.plugin.expt.hellhound.core.b.aoE(paramString);
    paramString = new cbm();
    paramString.dMl = ((String)localObject);
    paramString.aHK = paramInt;
    paramString.startTime = paramLong;
    cyl localcyl = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cQo();
    if (localcyl == null)
    {
      Log.i("HABBYGE-MALI.HellPageFlowManager", "addPageflow(addPage2Flow), Unknown Page: %s", new Object[] { localObject });
      paramString.dRM = null;
      com.tencent.mm.plugin.expt.hellhound.a.f.c.k.cQB();
    }
    for (;;)
    {
      localObject = a.cQH();
      ((cbl)localObject).Mhn.addLast(paramString);
      a.a((cbl)localObject);
      AppMethodBeat.o(220568);
      return;
      paramString.dRM = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.j(localcyl);
      Log.i("HABBYGE-MALI.HellPageFlowManager", "addPageflow(addPage2Flow), session: %s, %s", new Object[] { localObject, paramString.dRM });
      com.tencent.mm.plugin.expt.hellhound.a.f.c.k.a(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.d.b
 * JD-Core Version:    0.7.0.1
 */
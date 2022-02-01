package com.tencent.mm.plugin.expt.hellhound.a.f.d;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cjo;
import com.tencent.mm.protocal.protobuf.cjp;
import com.tencent.mm.protocal.protobuf.dhx;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class b
{
  private static void a(cjo paramcjo, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(177397);
    int j = paramcjo.Trb.size();
    int i = j;
    if (!paramBoolean) {
      i = j - 1;
    }
    i -= 1;
    cjp localcjp;
    if (i >= 0)
    {
      localcjp = (cjp)paramcjo.Trb.get(i);
      if (localcjp != null)
      {
        if (!localcjp.fLj.equals(paramString1)) {
          break label144;
        }
        localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ayp(paramString1);
        if (localObject1 == null) {
          break label156;
        }
      }
    }
    label144:
    label156:
    for (Object localObject1 = (String)((com.tencent.mm.vending.j.c)localObject1).get(1);; localObject1 = null)
    {
      Object localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ayp(paramString2);
      if (localObject2 != null) {}
      for (localObject2 = (String)((com.tencent.mm.vending.j.c)localObject2).get(1);; localObject2 = null)
      {
        if ((localObject1 != null) && (((String)localObject1).equals(localObject2))) {
          localcjp.fLj = paramString2;
        }
        i -= 1;
        break;
        AppMethodBeat.o(177397);
        return;
      }
    }
  }
  
  public static void a(cjp paramcjp, int paramInt)
  {
    AppMethodBeat.i(256030);
    if (paramcjp == null)
    {
      AppMethodBeat.o(256030);
      return;
    }
    cjo localcjo = a.dfB();
    try
    {
      localcjo.Trb.set(paramInt, paramcjp);
      a.a(localcjo);
      AppMethodBeat.o(256030);
      return;
    }
    catch (Exception paramcjp)
    {
      Log.printErrStackTrace("HABBYGE-MALI.HellPageFlowManager", paramcjp, "updatePageFlow crash: %s", new Object[] { paramcjp.getMessage() });
      AppMethodBeat.o(256030);
    }
  }
  
  public static void a(dhx paramdhx, String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(256017);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(256017);
      return;
    }
    if ((paramdhx != null) && (com.tencent.mm.plugin.expt.hellhound.a.f.g.a.azc(paramdhx.sessionId)))
    {
      Log.i("HABBYGE-MALI.HellPageFlowManager", "addpageFlow scan-session, need filter !!");
      AppMethodBeat.o(256017);
      return;
    }
    b(paramdhx, paramString, paramInt, paramLong);
    AppMethodBeat.o(256017);
  }
  
  public static void aq(String paramString, long paramLong)
  {
    AppMethodBeat.i(122176);
    cjo localcjo = a.dfB();
    if (localcjo.Trb.isEmpty())
    {
      Log.e("HABBYGE-MALI.HellPageFlowManager", "setEndTimeOfPageWhenEvent8, pageFlow.items == NULL");
      AppMethodBeat.o(122176);
      return;
    }
    paramString = com.tencent.mm.plugin.expt.hellhound.core.b.awD(paramString);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(122176);
      return;
    }
    paramString = (cjp)localcjo.Trb.getLast();
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
      a.a(localcjo);
      AppMethodBeat.o(122176);
      return;
      paramLong = 0L;
    }
  }
  
  public static List<cjp> ayR(String paramString)
  {
    AppMethodBeat.i(122178);
    if (paramString == null)
    {
      AppMethodBeat.o(122178);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    cjo localcjo = a.dfB();
    int j = localcjo.Trb.size();
    int i = 0;
    while (i < j)
    {
      cjp localcjp = (cjp)localcjo.Trb.get(i);
      if (localcjp.fLj.equals(paramString)) {
        localArrayList.add(localcjp);
      }
      i += 1;
    }
    AppMethodBeat.o(122178);
    return localArrayList;
  }
  
  public static void b(dhx paramdhx, String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(256018);
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.awD(paramString);
    cjo localcjo = a.dfB();
    if (paramdhx == null)
    {
      if ((!"LauncherUI".equals(localObject1)) && (!"FinderHomeUI".equals(localObject1)))
      {
        paramString = (String)localObject1;
        if (!"FinderConversationUI".equals(localObject1)) {}
      }
      else
      {
        Log.i("HABBYGE-MALI.HellPageFlowManager", "Invalidate Page: LauncherUI/FinderHomeUI");
        AppMethodBeat.o(256018);
      }
    }
    else
    {
      if ("LauncherUI".equals(localObject1))
      {
        Log.i("HABBYGE-MALI.HellPageFlowManager", "Invalidate Page: LauncherUI");
        AppMethodBeat.o(256018);
        return;
      }
      if (!"FinderHomeUI".equals(localObject1))
      {
        paramString = (String)localObject1;
        if (!"FinderConversationUI".equals(localObject1)) {}
      }
      else
      {
        paramString = com.tencent.mm.plugin.expt.hellhound.a.b.b.k.ddc();
        if (paramString == null) {
          break label323;
        }
      }
    }
    Object localObject2;
    label323:
    for (paramString = paramString.getClass().getSimpleName();; paramString = "FinderFollowTabFragment")
    {
      Log.i("HABBYGE-MALI.HellPageFlowManager", "maybe invalidate Page: FinderHomeUI in %s, %s", new Object[] { paramdhx.sessionId, paramString });
      localObject1 = (cjp)localcjo.Trb.peekLast();
      if (localObject1 == null) {
        break label483;
      }
      if (!((cjp)localObject1).fFe.equals(paramString)) {
        break;
      }
      if ((paramdhx != null) && (!paramdhx.sessionId.equals(((cjp)localObject1).fLj)))
      {
        localObject2 = ((cjp)localObject1).fLj;
        ((cjp)localObject1).fLj = paramdhx.sessionId;
        localcjo.Trb.set(localcjo.Trb.size() - 1, localObject1);
        a(localcjo, (String)localObject2, paramdhx.sessionId, false);
        a.a(localcjo);
      }
      if ((((cjp)localObject1).aNf <= 0) && (paramInt > 0))
      {
        ((cjp)localObject1).aNf = paramInt;
        a.a(localcjo);
      }
      Log.i("HABBYGE-MALI.HellPageFlowManager", "repeated page, no need to add this page: %s, %d, %s, %d", new Object[] { ((cjp)localObject1).fFe, Integer.valueOf(((cjp)localObject1).aNf), paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(256018);
      return;
    }
    if ((paramdhx != null) && (!((cjp)localObject1).fLj.equals(paramdhx.sessionId))) {
      a(localcjo, ((cjp)localObject1).fLj, paramdhx.sessionId, true);
    }
    int i = localcjo.Trb.size();
    if (i > 2)
    {
      localObject2 = (cjp)localcjo.Trb.get(i - 2);
      if (localObject2 != null)
      {
        if (("MsgRetransmitUI".equals(((cjp)localObject2).fFe)) && ("SelectConversationUI".equals(((cjp)localObject1).fFe)) && ("MsgRetransmitUI".equals(paramString)))
        {
          AppMethodBeat.o(256018);
          return;
        }
        if (("SelectConversationUI".equals(((cjp)localObject2).fFe)) && ("MsgRetransmitUI".equals(((cjp)localObject1).fFe)) && ("SelectConversationUI".equals(paramString)))
        {
          AppMethodBeat.o(256018);
          return;
        }
      }
    }
    label483:
    localObject1 = new cjp();
    ((cjp)localObject1).fFe = paramString;
    ((cjp)localObject1).aNf = paramInt;
    ((cjp)localObject1).startTime = paramLong;
    if (paramdhx == null)
    {
      Log.i("HABBYGE-MALI.HellPageFlowManager", "addPageFlow, Unknown Page: %s, %d", new Object[] { paramString, Integer.valueOf(paramInt) });
      ((cjp)localObject1).fLj = null;
      com.tencent.mm.plugin.expt.hellhound.a.f.c.k.dfv();
    }
    for (;;)
    {
      localcjo.Trb.addLast(localObject1);
      a.a(localcjo);
      AppMethodBeat.o(256018);
      return;
      ((cjp)localObject1).fLj = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.j(paramdhx);
      Log.i("HABBYGE-MALI.HellPageFlowManager", "addPageFlow, session: %s, %d, %s", new Object[] { paramString, Integer.valueOf(paramInt), ((cjp)localObject1).fLj });
      com.tencent.mm.plugin.expt.hellhound.a.f.c.k.a((cjp)localObject1);
    }
  }
  
  public static Pair<cjp, Integer> dfD()
  {
    AppMethodBeat.i(256032);
    Object localObject = a.dfB();
    if (((cjo)localObject).Trb.isEmpty())
    {
      AppMethodBeat.o(256032);
      return null;
    }
    localObject = Pair.create(((cjo)localObject).Trb.getLast(), Integer.valueOf(((cjo)localObject).Trb.size() - 1));
    AppMethodBeat.o(256032);
    return localObject;
  }
  
  public static com.tencent.mm.vending.j.c<cjp, Integer> gK(String paramString1, String paramString2)
  {
    AppMethodBeat.i(256024);
    if ((paramString1 == null) || (paramString2 == null) || (paramString2.isEmpty()))
    {
      AppMethodBeat.o(256024);
      return null;
    }
    paramString2 = com.tencent.mm.plugin.expt.hellhound.core.b.awD(paramString2);
    Log.i("HABBYGE-MALI.HellPageFlowManager", "getPageFlowItemOfCurSession: %s, %s", new Object[] { paramString2, paramString1 });
    cjo localcjo = a.dfB();
    int i = localcjo.Trb.size() - 1;
    while (i >= 0)
    {
      cjp localcjp = (cjp)localcjo.Trb.get(i);
      if (localcjp.fLj.equals(paramString1))
      {
        String str = com.tencent.mm.plugin.expt.hellhound.core.b.awD(localcjp.fFe);
        if ((str != null) && (str.equals(paramString2)))
        {
          paramString1 = com.tencent.mm.vending.j.a.J(localcjp, Integer.valueOf(i));
          AppMethodBeat.o(256024);
          return paramString1;
        }
      }
      i -= 1;
    }
    AppMethodBeat.o(256024);
    return null;
  }
  
  public static void y(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(256019);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(256019);
      return;
    }
    Object localObject = com.tencent.mm.plugin.expt.hellhound.core.b.awD(paramString);
    paramString = new cjp();
    paramString.fFe = ((String)localObject);
    paramString.aNf = paramInt;
    paramString.startTime = paramLong;
    dhx localdhx = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.dfi();
    if (localdhx == null)
    {
      Log.i("HABBYGE-MALI.HellPageFlowManager", "addPageflow(addPage2Flow), Unknown Page: %s", new Object[] { localObject });
      paramString.fLj = null;
      com.tencent.mm.plugin.expt.hellhound.a.f.c.k.dfv();
    }
    for (;;)
    {
      localObject = a.dfB();
      ((cjo)localObject).Trb.addLast(paramString);
      a.a((cjo)localObject);
      AppMethodBeat.o(256019);
      return;
      paramString.fLj = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.j(localdhx);
      Log.i("HABBYGE-MALI.HellPageFlowManager", "addPageflow(addPage2Flow), session: %s, %s", new Object[] { localObject, paramString.fLj });
      com.tencent.mm.plugin.expt.hellhound.a.f.c.k.a(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.d.b
 * JD-Core Version:    0.7.0.1
 */
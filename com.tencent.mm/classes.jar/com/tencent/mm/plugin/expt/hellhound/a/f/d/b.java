package com.tencent.mm.plugin.expt.hellhound.a.f.d;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.j;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.k;
import com.tencent.mm.protocal.protobuf.bob;
import com.tencent.mm.protocal.protobuf.boc;
import com.tencent.mm.protocal.protobuf.chk;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class b
{
  private static void a(bob parambob, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(177397);
    int j = parambob.GII.size();
    int i = j;
    if (!paramBoolean) {
      i = j - 1;
    }
    i -= 1;
    boc localboc;
    if (i >= 0)
    {
      localboc = (boc)parambob.GII.get(i);
      if (localboc != null)
      {
        if (!localboc.dyV.equals(paramString1)) {
          break label144;
        }
        localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aeI(paramString1);
        if (localObject1 == null) {
          break label156;
        }
      }
    }
    label144:
    label156:
    for (Object localObject1 = (String)((com.tencent.mm.vending.j.c)localObject1).get(1);; localObject1 = null)
    {
      Object localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aeI(paramString2);
      if (localObject2 != null) {}
      for (localObject2 = (String)((com.tencent.mm.vending.j.c)localObject2).get(1);; localObject2 = null)
      {
        if ((localObject1 != null) && (((String)localObject1).equals(localObject2))) {
          localboc.dyV = paramString2;
        }
        i -= 1;
        break;
        AppMethodBeat.o(177397);
        return;
      }
    }
  }
  
  public static void a(boc paramboc, int paramInt)
  {
    AppMethodBeat.i(210472);
    if (paramboc == null)
    {
      AppMethodBeat.o(210472);
      return;
    }
    bob localbob = a.cqx();
    try
    {
      localbob.GII.set(paramInt, paramboc);
      a.a(localbob);
      AppMethodBeat.o(210472);
      return;
    }
    catch (Exception paramboc)
    {
      ad.printErrStackTrace("HABBYGE-MALI.HellPageFlowManager", paramboc, "updatePageFlow crash: %s", new Object[] { paramboc.getMessage() });
      AppMethodBeat.o(210472);
    }
  }
  
  public static void a(chk paramchk, String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(210468);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(210468);
      return;
    }
    if ((paramchk != null) && (com.tencent.mm.plugin.expt.hellhound.a.f.g.a.afu(paramchk.sessionId)))
    {
      ad.i("HABBYGE-MALI.HellPageFlowManager", "addpageFlow scan-session, need filter !!");
      AppMethodBeat.o(210468);
      return;
    }
    b(paramchk, paramString, paramInt, paramLong);
    AppMethodBeat.o(210468);
  }
  
  public static List<boc> afj(String paramString)
  {
    AppMethodBeat.i(122178);
    if (paramString == null)
    {
      AppMethodBeat.o(122178);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    bob localbob = a.cqx();
    int j = localbob.GII.size();
    int i = 0;
    while (i < j)
    {
      boc localboc = (boc)localbob.GII.get(i);
      if (localboc.dyV.equals(paramString)) {
        localArrayList.add(localboc);
      }
      i += 1;
    }
    AppMethodBeat.o(122178);
    return localArrayList;
  }
  
  public static void aq(String paramString, long paramLong)
  {
    AppMethodBeat.i(122176);
    bob localbob = a.cqx();
    if (localbob.GII.isEmpty())
    {
      ad.e("HABBYGE-MALI.HellPageFlowManager", "setEndTimeOfPageWhenEvent8, pageFlow.items == NULL");
      AppMethodBeat.o(122176);
      return;
    }
    paramString = com.tencent.mm.plugin.expt.hellhound.core.b.adx(paramString);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(122176);
      return;
    }
    paramString = (boc)localbob.GII.getLast();
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
      a.a(localbob);
      AppMethodBeat.o(122176);
      return;
      paramLong = 0L;
    }
  }
  
  public static void b(chk paramchk, String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(210469);
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.adx(paramString);
    bob localbob = a.cqx();
    if (paramchk == null)
    {
      if ((!"LauncherUI".equals(localObject1)) && (!"FinderHomeUI".equals(localObject1)))
      {
        paramString = (String)localObject1;
        if (!"FinderConversationUI".equals(localObject1)) {}
      }
      else
      {
        ad.i("HABBYGE-MALI.HellPageFlowManager", "Invalidate Page: LauncherUI/FinderHomeUI");
        AppMethodBeat.o(210469);
      }
    }
    else
    {
      if ("LauncherUI".equals(localObject1))
      {
        ad.i("HABBYGE-MALI.HellPageFlowManager", "Invalidate Page: LauncherUI");
        AppMethodBeat.o(210469);
        return;
      }
      if (!"FinderHomeUI".equals(localObject1))
      {
        paramString = (String)localObject1;
        if (!"FinderConversationUI".equals(localObject1)) {}
      }
      else
      {
        paramString = j.cop();
        if (paramString == null) {
          break label323;
        }
      }
    }
    Object localObject2;
    label323:
    for (paramString = paramString.getClass().getSimpleName();; paramString = "FinderFollowTabFragment")
    {
      ad.i("HABBYGE-MALI.HellPageFlowManager", "maybe invalidate Page: FinderHomeUI in %s, %s", new Object[] { paramchk.sessionId, paramString });
      localObject1 = (boc)localbob.GII.peekLast();
      if (localObject1 == null) {
        break label483;
      }
      if (!((boc)localObject1).dtL.equals(paramString)) {
        break;
      }
      if ((paramchk != null) && (!paramchk.sessionId.equals(((boc)localObject1).dyV)))
      {
        localObject2 = ((boc)localObject1).dyV;
        ((boc)localObject1).dyV = paramchk.sessionId;
        localbob.GII.set(localbob.GII.size() - 1, localObject1);
        a(localbob, (String)localObject2, paramchk.sessionId, false);
        a.a(localbob);
      }
      if ((((boc)localObject1).aHQ <= 0) && (paramInt > 0))
      {
        ((boc)localObject1).aHQ = paramInt;
        a.a(localbob);
      }
      ad.i("HABBYGE-MALI.HellPageFlowManager", "repeated page, no need to add this page: %s, %d, %s, %d", new Object[] { ((boc)localObject1).dtL, Integer.valueOf(((boc)localObject1).aHQ), paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(210469);
      return;
    }
    if ((paramchk != null) && (!((boc)localObject1).dyV.equals(paramchk.sessionId))) {
      a(localbob, ((boc)localObject1).dyV, paramchk.sessionId, true);
    }
    int i = localbob.GII.size();
    if (i > 2)
    {
      localObject2 = (boc)localbob.GII.get(i - 2);
      if (localObject2 != null)
      {
        if (("MsgRetransmitUI".equals(((boc)localObject2).dtL)) && ("SelectConversationUI".equals(((boc)localObject1).dtL)) && ("MsgRetransmitUI".equals(paramString)))
        {
          AppMethodBeat.o(210469);
          return;
        }
        if (("SelectConversationUI".equals(((boc)localObject2).dtL)) && ("MsgRetransmitUI".equals(((boc)localObject1).dtL)) && ("SelectConversationUI".equals(paramString)))
        {
          AppMethodBeat.o(210469);
          return;
        }
      }
    }
    label483:
    localObject1 = new boc();
    ((boc)localObject1).dtL = paramString;
    ((boc)localObject1).aHQ = paramInt;
    ((boc)localObject1).startTime = paramLong;
    if (paramchk == null)
    {
      ad.i("HABBYGE-MALI.HellPageFlowManager", "addPageFlow, Unknown Page: %s, %d", new Object[] { paramString, Integer.valueOf(paramInt) });
      ((boc)localObject1).dyV = null;
      k.cqr();
    }
    for (;;)
    {
      localbob.GII.addLast(localObject1);
      a.a(localbob);
      AppMethodBeat.o(210469);
      return;
      ((boc)localObject1).dyV = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.f(paramchk);
      ad.i("HABBYGE-MALI.HellPageFlowManager", "addPageFlow, session: %s, %d, %s", new Object[] { paramString, Integer.valueOf(paramInt), ((boc)localObject1).dyV });
      k.a((boc)localObject1);
    }
  }
  
  public static Pair<boc, Integer> cqz()
  {
    AppMethodBeat.i(210473);
    Object localObject = a.cqx();
    if (((bob)localObject).GII.isEmpty())
    {
      AppMethodBeat.o(210473);
      return null;
    }
    localObject = Pair.create(((bob)localObject).GII.getLast(), Integer.valueOf(((bob)localObject).GII.size() - 1));
    AppMethodBeat.o(210473);
    return localObject;
  }
  
  public static com.tencent.mm.vending.j.c<boc, Integer> fX(String paramString1, String paramString2)
  {
    AppMethodBeat.i(210471);
    if ((paramString1 == null) || (paramString2 == null) || (paramString2.isEmpty()))
    {
      AppMethodBeat.o(210471);
      return null;
    }
    paramString2 = com.tencent.mm.plugin.expt.hellhound.core.b.adx(paramString2);
    ad.i("HABBYGE-MALI.HellPageFlowManager", "getPageFlowItemOfCurSession: %s, %s", new Object[] { paramString2, paramString1 });
    bob localbob = a.cqx();
    int i = localbob.GII.size() - 1;
    while (i >= 0)
    {
      boc localboc = (boc)localbob.GII.get(i);
      if (localboc.dyV.equals(paramString1))
      {
        String str = com.tencent.mm.plugin.expt.hellhound.core.b.adx(localboc.dtL);
        if ((str != null) && (str.equals(paramString2)))
        {
          paramString1 = com.tencent.mm.vending.j.a.N(localboc, Integer.valueOf(i));
          AppMethodBeat.o(210471);
          return paramString1;
        }
      }
      i -= 1;
    }
    AppMethodBeat.o(210471);
    return null;
  }
  
  public static void z(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(210470);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(210470);
      return;
    }
    Object localObject = com.tencent.mm.plugin.expt.hellhound.core.b.adx(paramString);
    paramString = new boc();
    paramString.dtL = ((String)localObject);
    paramString.aHQ = paramInt;
    paramString.startTime = paramLong;
    chk localchk = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cqe();
    if (localchk == null)
    {
      ad.i("HABBYGE-MALI.HellPageFlowManager", "addPageflow(addPage2Flow), Unknown Page: %s", new Object[] { localObject });
      paramString.dyV = null;
      k.cqr();
    }
    for (;;)
    {
      localObject = a.cqx();
      ((bob)localObject).GII.addLast(paramString);
      a.a((bob)localObject);
      AppMethodBeat.o(210470);
      return;
      paramString.dyV = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.f(localchk);
      ad.i("HABBYGE-MALI.HellPageFlowManager", "addPageflow(addPage2Flow), session: %s, %s", new Object[] { localObject, paramString.dyV });
      k.a(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.d.b
 * JD-Core Version:    0.7.0.1
 */
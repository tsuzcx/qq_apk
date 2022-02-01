package com.tencent.mm.plugin.expt.hellhound.a.f.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.j;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.k;
import com.tencent.mm.protocal.protobuf.bjt;
import com.tencent.mm.protocal.protobuf.bju;
import com.tencent.mm.protocal.protobuf.ccs;
import com.tencent.mm.sdk.platformtools.ac;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class b
{
  private static void a(bjt parambjt, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(177397);
    int j = parambjt.EZk.size();
    int i = j;
    if (!paramBoolean) {
      i = j - 1;
    }
    i -= 1;
    bju localbju;
    if (i >= 0)
    {
      localbju = (bju)parambjt.EZk.get(i);
      if (localbju != null)
      {
        if (!localbju.dnh.equals(paramString1)) {
          break label144;
        }
        localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aaU(paramString1);
        if (localObject1 == null) {
          break label156;
        }
      }
    }
    label144:
    label156:
    for (Object localObject1 = (String)((com.tencent.mm.vending.j.c)localObject1).get(1);; localObject1 = null)
    {
      Object localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.aaU(paramString2);
      if (localObject2 != null) {}
      for (localObject2 = (String)((com.tencent.mm.vending.j.c)localObject2).get(1);; localObject2 = null)
      {
        if ((localObject1 != null) && (((String)localObject1).equals(localObject2))) {
          localbju.dnh = paramString2;
        }
        i -= 1;
        break;
        AppMethodBeat.o(177397);
        return;
      }
    }
  }
  
  public static void a(bju parambju, int paramInt)
  {
    AppMethodBeat.i(122179);
    if (parambju == null)
    {
      AppMethodBeat.o(122179);
      return;
    }
    bjt localbjt = a.clh();
    try
    {
      localbjt.EZk.set(paramInt, parambju);
      a.a(localbjt);
      AppMethodBeat.o(122179);
      return;
    }
    catch (Exception parambju)
    {
      ac.printErrStackTrace("HABBYGE-MALI.HellPageFlowManager", parambju, "updatePageFlowItemOfCurSession crash", new Object[0]);
      AppMethodBeat.o(122179);
    }
  }
  
  public static List<bju> abw(String paramString)
  {
    AppMethodBeat.i(122178);
    if (paramString == null)
    {
      AppMethodBeat.o(122178);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    bjt localbjt = a.clh();
    int j = localbjt.EZk.size();
    int i = 0;
    while (i < j)
    {
      bju localbju = (bju)localbjt.EZk.get(i);
      if (localbju.dnh.equals(paramString)) {
        localArrayList.add(localbju);
      }
      i += 1;
    }
    AppMethodBeat.o(122178);
    return localArrayList;
  }
  
  public static void am(String paramString, long paramLong)
  {
    AppMethodBeat.i(177396);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(177396);
      return;
    }
    Object localObject = com.tencent.mm.plugin.expt.hellhound.core.b.ZK(paramString);
    paramString = new bju();
    paramString.qoi = ((String)localObject);
    paramString.startTime = paramLong;
    ccs localccs = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.ckP();
    if (localccs == null)
    {
      ac.i("HABBYGE-MALI.HellPageFlowManager", "addPageflow(addPage2Flow), Unknown Page: %s", new Object[] { localObject });
      paramString.dnh = null;
      k.cld();
    }
    for (;;)
    {
      localObject = a.clh();
      ((bjt)localObject).EZk.addLast(paramString);
      a.a((bjt)localObject);
      AppMethodBeat.o(177396);
      return;
      paramString.dnh = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.g(localccs);
      ac.i("HABBYGE-MALI.HellPageFlowManager", "addPageflow(addPage2Flow), session: %s, %s", new Object[] { localObject, paramString.dnh });
      k.a(paramString);
    }
  }
  
  public static void an(String paramString, long paramLong)
  {
    AppMethodBeat.i(122176);
    bjt localbjt = a.clh();
    if (localbjt.EZk.isEmpty())
    {
      ac.e("HABBYGE-MALI.HellPageFlowManager", "setEndTimeOfPageWhenEvent8, pageFlow.items == NULL");
      AppMethodBeat.o(122176);
      return;
    }
    paramString = com.tencent.mm.plugin.expt.hellhound.core.b.ZK(paramString);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(122176);
      return;
    }
    paramString = (bju)localbjt.EZk.getLast();
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
      a.a(localbjt);
      AppMethodBeat.o(122176);
      return;
      paramLong = 0L;
    }
  }
  
  public static void b(ccs paramccs, String paramString, long paramLong)
  {
    AppMethodBeat.i(122174);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(122174);
      return;
    }
    if ((paramccs != null) && (com.tencent.mm.plugin.expt.hellhound.a.f.g.a.abG(paramccs.sessionId)))
    {
      ac.i("HABBYGE-MALI.HellPageFlowManager", "addpageFlow scan-session, need filter !!");
      AppMethodBeat.o(122174);
      return;
    }
    c(paramccs, paramString, paramLong);
    AppMethodBeat.o(122174);
  }
  
  public static void c(ccs paramccs, String paramString, long paramLong)
  {
    AppMethodBeat.i(122175);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.core.b.ZK(paramString);
    bjt localbjt = a.clh();
    if (paramccs == null)
    {
      if ((!"LauncherUI".equals(localObject)) && (!"FinderHomeUI".equals(localObject)))
      {
        paramString = (String)localObject;
        if (!"FinderConversationUI".equals(localObject)) {}
      }
      else
      {
        ac.i("HABBYGE-MALI.HellPageFlowManager", "Invalidate Page: LauncherUI/FinderHomeUI");
        AppMethodBeat.o(122175);
      }
    }
    else
    {
      if ("LauncherUI".equals(localObject))
      {
        ac.i("HABBYGE-MALI.HellPageFlowManager", "Invalidate Page: LauncherUI");
        paramString = "MainUI";
        paramccs = null;
        localObject = (bju)localbjt.EZk.peekLast();
        if (localObject == null) {
          break label438;
        }
        if (!((bju)localObject).qoi.equals(paramString)) {
          break label284;
        }
        if ((paramccs != null) && (!paramccs.sessionId.equals(((bju)localObject).dnh)))
        {
          paramString = ((bju)localObject).dnh;
          ((bju)localObject).dnh = paramccs.sessionId;
          localbjt.EZk.set(localbjt.EZk.size() - 1, localObject);
          a(localbjt, paramString, paramccs.sessionId, false);
          a.a(localbjt);
        }
        ac.d("HABBYGE-MALI.HellPageFlowManager", "repeated page, no need to add this page: %s", new Object[] { ((bju)localObject).qoi });
        AppMethodBeat.o(122175);
        return;
      }
      if (!"FinderHomeUI".equals(localObject))
      {
        paramString = (String)localObject;
        if (!"FinderConversationUI".equals(localObject)) {}
      }
      else
      {
        paramString = j.cji();
        if (paramString == null) {
          break label278;
        }
      }
    }
    label278:
    for (paramString = paramString.getClass().getSimpleName();; paramString = "FinderFollowTabFragment")
    {
      ac.i("HABBYGE-MALI.HellPageFlowManager", "maybe invalidate Page: FinderHomeUI in %s, %s", new Object[] { paramccs.sessionId, paramString });
      break;
    }
    label284:
    if ((paramccs != null) && (!((bju)localObject).dnh.equals(paramccs.sessionId))) {
      a(localbjt, ((bju)localObject).dnh, paramccs.sessionId, true);
    }
    int i = localbjt.EZk.size();
    if (i > 2)
    {
      bju localbju = (bju)localbjt.EZk.get(i - 2);
      if (localbju != null)
      {
        if (("MsgRetransmitUI".equals(localbju.qoi)) && ("SelectConversationUI".equals(((bju)localObject).qoi)) && ("MsgRetransmitUI".equals(paramString)))
        {
          AppMethodBeat.o(122175);
          return;
        }
        if (("SelectConversationUI".equals(localbju.qoi)) && ("MsgRetransmitUI".equals(((bju)localObject).qoi)) && ("SelectConversationUI".equals(paramString)))
        {
          AppMethodBeat.o(122175);
          return;
        }
      }
    }
    label438:
    localObject = new bju();
    ((bju)localObject).qoi = paramString;
    ((bju)localObject).startTime = paramLong;
    if (paramccs == null)
    {
      ac.i("HABBYGE-MALI.HellPageFlowManager", "addPageFlow, Unknown Page: %s", new Object[] { paramString });
      ((bju)localObject).dnh = null;
      k.cld();
    }
    for (;;)
    {
      localbjt.EZk.addLast(localObject);
      a.a(localbjt);
      AppMethodBeat.o(122175);
      return;
      ((bju)localObject).dnh = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.g(paramccs);
      ac.i("HABBYGE-MALI.HellPageFlowManager", "addPageFlow, session: %s, %s", new Object[] { paramString, ((bju)localObject).dnh });
      k.a((bju)localObject);
    }
  }
  
  public static com.tencent.mm.vending.j.c<bju, Integer> fO(String paramString1, String paramString2)
  {
    AppMethodBeat.i(122177);
    if ((paramString1 == null) || (paramString2 == null) || (paramString2.isEmpty()))
    {
      AppMethodBeat.o(122177);
      return null;
    }
    paramString2 = com.tencent.mm.plugin.expt.hellhound.core.b.ZK(paramString2);
    ac.i("HABBYGE-MALI.HellPageFlowManager", "habbyge-mali, getPageFlowItemOfCurSession: %s, %s", new Object[] { paramString2, paramString1 });
    bjt localbjt = a.clh();
    int i = localbjt.EZk.size() - 1;
    while (i >= 0)
    {
      bju localbju = (bju)localbjt.EZk.get(i);
      if (localbju.dnh.equals(paramString1))
      {
        String str = com.tencent.mm.plugin.expt.hellhound.core.b.ZK(localbju.qoi);
        if ((str != null) && (str.equals(paramString2)))
        {
          paramString1 = com.tencent.mm.vending.j.a.L(localbju, Integer.valueOf(i));
          AppMethodBeat.o(122177);
          return paramString1;
        }
      }
      i -= 1;
    }
    AppMethodBeat.o(122177);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.d.b
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.expt.hellhound.a.f.d;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.j;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.k;
import com.tencent.mm.protocal.protobuf.bgb;
import com.tencent.mm.protocal.protobuf.bgc;
import com.tencent.mm.protocal.protobuf.bxx;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class b
{
  public static List<bgc> WZ(String paramString)
  {
    AppMethodBeat.i(122178);
    if (paramString == null)
    {
      AppMethodBeat.o(122178);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    bgb localbgb = a.cdz();
    int j = localbgb.DDO.size();
    int i = 0;
    while (i < j)
    {
      bgc localbgc = (bgc)localbgb.DDO.get(i);
      if (localbgc.dpw.equals(paramString)) {
        localArrayList.add(localbgc);
      }
      i += 1;
    }
    AppMethodBeat.o(122178);
    return localArrayList;
  }
  
  private static void a(bgb parambgb, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(177397);
    int j = parambgb.DDO.size();
    int i = j;
    if (!paramBoolean) {
      i = j - 1;
    }
    i -= 1;
    bgc localbgc;
    if (i >= 0)
    {
      localbgc = (bgc)parambgb.DDO.get(i);
      if (localbgc != null)
      {
        if (!localbgc.dpw.equals(paramString1)) {
          break label144;
        }
        localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.Wx(paramString1);
        if (localObject1 == null) {
          break label156;
        }
      }
    }
    label144:
    label156:
    for (Object localObject1 = (String)((com.tencent.mm.vending.j.c)localObject1).get(1);; localObject1 = null)
    {
      Object localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.Wx(paramString2);
      if (localObject2 != null) {}
      for (localObject2 = (String)((com.tencent.mm.vending.j.c)localObject2).get(1);; localObject2 = null)
      {
        if ((localObject1 != null) && (((String)localObject1).equals(localObject2))) {
          localbgc.dpw = paramString2;
        }
        i -= 1;
        break;
        AppMethodBeat.o(177397);
        return;
      }
    }
  }
  
  public static void a(bgc parambgc, int paramInt)
  {
    AppMethodBeat.i(122179);
    if (parambgc == null)
    {
      AppMethodBeat.o(122179);
      return;
    }
    bgb localbgb = a.cdz();
    try
    {
      localbgb.DDO.set(paramInt, parambgc);
      a.a(localbgb);
      AppMethodBeat.o(122179);
      return;
    }
    catch (Exception parambgc)
    {
      ad.printErrStackTrace("HABBYGE-MALI.HellPageFlowManager", parambgc, "updatePageFlowItemOfCurSession crash", new Object[0]);
      AppMethodBeat.o(122179);
    }
  }
  
  public static void ak(String paramString, long paramLong)
  {
    AppMethodBeat.i(177396);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(177396);
      return;
    }
    Object localObject = com.tencent.mm.plugin.expt.hellhound.core.b.Vy(paramString);
    paramString = new bgc();
    paramString.DDP = ((String)localObject);
    paramString.startTime = paramLong;
    bxx localbxx = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cdh();
    if (localbxx == null)
    {
      ad.i("HABBYGE-MALI.HellPageFlowManager", "addPageflow(addPage2Flow), Unknown Page: %s", new Object[] { localObject });
      paramString.dpw = null;
      k.cdv();
    }
    for (;;)
    {
      localObject = a.cdz();
      ((bgb)localObject).DDO.addLast(paramString);
      a.a((bgb)localObject);
      AppMethodBeat.o(177396);
      return;
      paramString.dpw = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.f(localbxx);
      ad.i("HABBYGE-MALI.HellPageFlowManager", "addPageflow(addPage2Flow), session: %s, %s", new Object[] { localObject, paramString.dpw });
      k.a(paramString);
    }
  }
  
  public static void al(String paramString, long paramLong)
  {
    AppMethodBeat.i(122176);
    bgb localbgb = a.cdz();
    if (localbgb.DDO.isEmpty())
    {
      ad.e("HABBYGE-MALI.HellPageFlowManager", "setEndTimeOfPageWhenEvent8, pageFlow.items == NULL");
      AppMethodBeat.o(122176);
      return;
    }
    paramString = com.tencent.mm.plugin.expt.hellhound.core.b.Vy(paramString);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(122176);
      return;
    }
    paramString = (bgc)localbgb.DDO.getLast();
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
      a.a(localbgb);
      AppMethodBeat.o(122176);
      return;
      paramLong = 0L;
    }
  }
  
  public static void b(bxx parambxx, String paramString, long paramLong)
  {
    AppMethodBeat.i(122174);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(122174);
      return;
    }
    if ((parambxx != null) && (com.tencent.mm.plugin.expt.hellhound.a.f.g.a.Xj(parambxx.sessionId)))
    {
      ad.i("HABBYGE-MALI.HellPageFlowManager", "addpageFlow scan-session, need filter !!");
      AppMethodBeat.o(122174);
      return;
    }
    c(parambxx, paramString, paramLong);
    AppMethodBeat.o(122174);
  }
  
  public static void c(bxx parambxx, String paramString, long paramLong)
  {
    AppMethodBeat.i(122175);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.core.b.Vy(paramString);
    bgb localbgb = a.cdz();
    if (parambxx == null)
    {
      if ((!"LauncherUI".equals(localObject)) && (!"FinderHomeUI".equals(localObject)))
      {
        paramString = (String)localObject;
        if (!"FinderConversationUI".equals(localObject)) {}
      }
      else
      {
        ad.i("HABBYGE-MALI.HellPageFlowManager", "Invalidate Page: LauncherUI/FinderHomeUI");
        AppMethodBeat.o(122175);
      }
    }
    else
    {
      if ("LauncherUI".equals(localObject))
      {
        ad.i("HABBYGE-MALI.HellPageFlowManager", "Invalidate Page: LauncherUI");
        paramString = "MainUI";
        parambxx = null;
        localObject = (bgc)localbgb.DDO.peekLast();
        if (localObject == null) {
          break label438;
        }
        if (!((bgc)localObject).DDP.equals(paramString)) {
          break label284;
        }
        if ((parambxx != null) && (!parambxx.sessionId.equals(((bgc)localObject).dpw)))
        {
          paramString = ((bgc)localObject).dpw;
          ((bgc)localObject).dpw = parambxx.sessionId;
          localbgb.DDO.set(localbgb.DDO.size() - 1, localObject);
          a(localbgb, paramString, parambxx.sessionId, false);
          a.a(localbgb);
        }
        ad.d("HABBYGE-MALI.HellPageFlowManager", "repeated page, no need to add this page: %s", new Object[] { ((bgc)localObject).DDP });
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
        paramString = j.fRo();
        if (paramString == null) {
          break label278;
        }
      }
    }
    label278:
    for (paramString = paramString.getClass().getSimpleName();; paramString = "FinderFollowTabFragment")
    {
      ad.i("HABBYGE-MALI.HellPageFlowManager", "maybe invalidate Page: FinderHomeUI in %s, %s", new Object[] { parambxx.sessionId, paramString });
      break;
    }
    label284:
    if ((parambxx != null) && (!((bgc)localObject).dpw.equals(parambxx.sessionId))) {
      a(localbgb, ((bgc)localObject).dpw, parambxx.sessionId, true);
    }
    int i = localbgb.DDO.size();
    if (i > 2)
    {
      bgc localbgc = (bgc)localbgb.DDO.get(i - 2);
      if (localbgc != null)
      {
        if (("MsgRetransmitUI".equals(localbgc.DDP)) && ("SelectConversationUI".equals(((bgc)localObject).DDP)) && ("MsgRetransmitUI".equals(paramString)))
        {
          AppMethodBeat.o(122175);
          return;
        }
        if (("SelectConversationUI".equals(localbgc.DDP)) && ("MsgRetransmitUI".equals(((bgc)localObject).DDP)) && ("SelectConversationUI".equals(paramString)))
        {
          AppMethodBeat.o(122175);
          return;
        }
      }
    }
    label438:
    localObject = new bgc();
    ((bgc)localObject).DDP = paramString;
    ((bgc)localObject).startTime = paramLong;
    if (parambxx == null)
    {
      ad.i("HABBYGE-MALI.HellPageFlowManager", "addPageFlow, Unknown Page: %s", new Object[] { paramString });
      ((bgc)localObject).dpw = null;
      k.cdv();
    }
    for (;;)
    {
      localbgb.DDO.addLast(localObject);
      a.a(localbgb);
      AppMethodBeat.o(122175);
      return;
      ((bgc)localObject).dpw = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.f(parambxx);
      ad.i("HABBYGE-MALI.HellPageFlowManager", "addPageFlow, session: %s, %s", new Object[] { paramString, ((bgc)localObject).dpw });
      k.a((bgc)localObject);
    }
  }
  
  public static com.tencent.mm.vending.j.c<bgc, Integer> fB(String paramString1, String paramString2)
  {
    AppMethodBeat.i(122177);
    if ((paramString1 == null) || (paramString2 == null) || (paramString2.isEmpty()))
    {
      AppMethodBeat.o(122177);
      return null;
    }
    paramString2 = com.tencent.mm.plugin.expt.hellhound.core.b.Vy(paramString2);
    ad.i("HABBYGE-MALI.HellPageFlowManager", "habbyge-mali, getPageFlowItemOfCurSession: %s, %s", new Object[] { paramString2, paramString1 });
    bgb localbgb = a.cdz();
    int i = localbgb.DDO.size() - 1;
    while (i >= 0)
    {
      bgc localbgc = (bgc)localbgb.DDO.get(i);
      if (localbgc.dpw.equals(paramString1))
      {
        String str = com.tencent.mm.plugin.expt.hellhound.core.b.Vy(localbgc.DDP);
        if ((str != null) && (str.equals(paramString2)))
        {
          paramString1 = com.tencent.mm.vending.j.a.L(localbgc, Integer.valueOf(i));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.d.b
 * JD-Core Version:    0.7.0.1
 */
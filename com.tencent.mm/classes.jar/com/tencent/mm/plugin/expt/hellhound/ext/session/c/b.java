package com.tencent.mm.plugin.expt.hellhound.ext.session.c;

import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.czt;
import com.tencent.mm.protocal.protobuf.czu;
import com.tencent.mm.protocal.protobuf.eah;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class b
{
  private static void a(czt paramczt, String paramString1, String paramString2, boolean paramBoolean)
  {
    AppMethodBeat.i(177397);
    int j = paramczt.aaFj.size();
    int i = j;
    if (!paramBoolean) {
      i = j - 1;
    }
    i -= 1;
    czu localczu;
    if (i >= 0)
    {
      localczu = (czu)paramczt.aaFj.get(i);
      if (localczu != null)
      {
        if (!localczu.hQR.equals(paramString1)) {
          break label144;
        }
        localObject1 = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.asu(paramString1);
        if (localObject1 == null) {
          break label156;
        }
      }
    }
    label144:
    label156:
    for (Object localObject1 = (String)((com.tencent.mm.vending.j.c)localObject1).get(1);; localObject1 = null)
    {
      Object localObject2 = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.asu(paramString2);
      if (localObject2 != null) {}
      for (localObject2 = (String)((com.tencent.mm.vending.j.c)localObject2).get(1);; localObject2 = null)
      {
        if ((localObject1 != null) && (((String)localObject1).equals(localObject2))) {
          localczu.hQR = paramString2;
        }
        i -= 1;
        break;
        AppMethodBeat.o(177397);
        return;
      }
    }
  }
  
  public static void a(czu paramczu, int paramInt)
  {
    AppMethodBeat.i(300182);
    if (paramczu == null)
    {
      AppMethodBeat.o(300182);
      return;
    }
    czt localczt = a.dMp();
    try
    {
      localczt.aaFj.set(paramInt, paramczu);
      a.a(localczt);
      AppMethodBeat.o(300182);
      return;
    }
    catch (Exception paramczu)
    {
      Log.printErrStackTrace("HABBYGE-MALI.HellPageFlowManager", paramczu, "updatePageFlow crash: %s", new Object[] { paramczu.getMessage() });
      AppMethodBeat.o(300182);
    }
  }
  
  public static void a(eah parameah, String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(300162);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(300162);
      return;
    }
    if ((parameah != null) && (com.tencent.mm.plugin.expt.hellhound.ext.session.f.a.ath(parameah.sessionId)))
    {
      Log.i("HABBYGE-MALI.HellPageFlowManager", "addpageFlow scan-session, need filter !!");
      AppMethodBeat.o(300162);
      return;
    }
    b(parameah, paramString, paramInt, paramLong);
    AppMethodBeat.o(300162);
  }
  
  public static List<czu> asW(String paramString)
  {
    AppMethodBeat.i(122178);
    if (paramString == null)
    {
      AppMethodBeat.o(122178);
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    czt localczt = a.dMp();
    int j = localczt.aaFj.size();
    int i = 0;
    while (i < j)
    {
      czu localczu = (czu)localczt.aaFj.get(i);
      if (localczu.hQR.equals(paramString)) {
        localArrayList.add(localczu);
      }
      i += 1;
    }
    AppMethodBeat.o(122178);
    return localArrayList;
  }
  
  public static void ay(String paramString, long paramLong)
  {
    AppMethodBeat.i(122176);
    czt localczt = a.dMp();
    if (localczt.aaFj.isEmpty())
    {
      Log.e("HABBYGE-MALI.HellPageFlowManager", "setEndTimeOfPageWhenEvent8, pageFlow.items == NULL");
      AppMethodBeat.o(122176);
      return;
    }
    paramString = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(paramString);
    if ((paramString == null) || (paramString.isEmpty()))
    {
      AppMethodBeat.o(122176);
      return;
    }
    paramString = (czu)localczt.aaFj.getLast();
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
      a.a(localczt);
      AppMethodBeat.o(122176);
      return;
      paramLong = 0L;
    }
  }
  
  public static void b(eah parameah, String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(300168);
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(paramString);
    czt localczt = a.dMp();
    if (parameah == null)
    {
      if ((!"LauncherUI".equals(localObject1)) && (!"FinderHomeUI".equals(localObject1)) && (!"FinderHomeAffinityUI".equals(localObject1)))
      {
        paramString = (String)localObject1;
        if (!"FinderConversationUI".equals(localObject1)) {}
      }
      else
      {
        Log.i("HABBYGE-MALI.HellPageFlowManager", "Invalidate Page: LauncherUI/FinderHomeUI");
        AppMethodBeat.o(300168);
      }
    }
    else
    {
      if ("LauncherUI".equals(localObject1))
      {
        Log.i("HABBYGE-MALI.HellPageFlowManager", "Invalidate Page: LauncherUI");
        AppMethodBeat.o(300168);
        return;
      }
      if ((!"FinderHomeUI".equals(localObject1)) && (!"FinderHomeAffinityUI".equals(localObject1)))
      {
        paramString = (String)localObject1;
        if (!"FinderConversationUI".equals(localObject1)) {}
      }
      else
      {
        paramString = com.tencent.mm.plugin.expt.hellhound.ext.b.b.k.dKR();
        if (paramString == null) {
          break label343;
        }
      }
    }
    Object localObject2;
    label343:
    for (paramString = paramString.getClass().getSimpleName();; paramString = "FinderFollowTabFragment")
    {
      Log.i("HABBYGE-MALI.HellPageFlowManager", "maybe invalidate Page: FinderHomeUI in %s, %s", new Object[] { parameah.sessionId, paramString });
      localObject1 = (czu)localczt.aaFj.peekLast();
      if (localObject1 == null) {
        break label503;
      }
      if (!((czu)localObject1).hJW.equals(paramString)) {
        break;
      }
      if ((parameah != null) && (!parameah.sessionId.equals(((czu)localObject1).hQR)))
      {
        localObject2 = ((czu)localObject1).hQR;
        ((czu)localObject1).hQR = parameah.sessionId;
        localczt.aaFj.set(localczt.aaFj.size() - 1, localObject1);
        a(localczt, (String)localObject2, parameah.sessionId, false);
        a.a(localczt);
      }
      if ((((czu)localObject1).cHb <= 0) && (paramInt > 0))
      {
        ((czu)localObject1).cHb = paramInt;
        a.a(localczt);
      }
      Log.i("HABBYGE-MALI.HellPageFlowManager", "repeated page, no need to add this page: %s, %d, %s, %d", new Object[] { ((czu)localObject1).hJW, Integer.valueOf(((czu)localObject1).cHb), paramString, Integer.valueOf(paramInt) });
      AppMethodBeat.o(300168);
      return;
    }
    if ((parameah != null) && (!((czu)localObject1).hQR.equals(parameah.sessionId))) {
      a(localczt, ((czu)localObject1).hQR, parameah.sessionId, true);
    }
    int i = localczt.aaFj.size();
    if (i > 2)
    {
      localObject2 = (czu)localczt.aaFj.get(i - 2);
      if (localObject2 != null)
      {
        if (("MsgRetransmitUI".equals(((czu)localObject2).hJW)) && ("SelectConversationUI".equals(((czu)localObject1).hJW)) && ("MsgRetransmitUI".equals(paramString)))
        {
          AppMethodBeat.o(300168);
          return;
        }
        if (("SelectConversationUI".equals(((czu)localObject2).hJW)) && ("MsgRetransmitUI".equals(((czu)localObject1).hJW)) && ("SelectConversationUI".equals(paramString)))
        {
          AppMethodBeat.o(300168);
          return;
        }
      }
    }
    label503:
    localObject1 = new czu();
    ((czu)localObject1).hJW = paramString;
    ((czu)localObject1).cHb = paramInt;
    ((czu)localObject1).startTime = paramLong;
    if (parameah == null)
    {
      Log.i("HABBYGE-MALI.HellPageFlowManager", "addPageFlow, Unknown Page: %s, %d", new Object[] { paramString, Integer.valueOf(paramInt) });
      ((czu)localObject1).hQR = null;
      com.tencent.mm.plugin.expt.hellhound.ext.session.b.k.dMj();
    }
    for (;;)
    {
      localczt.aaFj.addLast(localObject1);
      a.a(localczt);
      AppMethodBeat.o(300168);
      return;
      ((czu)localObject1).hQR = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.h(parameah);
      Log.i("HABBYGE-MALI.HellPageFlowManager", "addPageFlow, session: %s, %d, %s", new Object[] { paramString, Integer.valueOf(paramInt), ((czu)localObject1).hQR });
      com.tencent.mm.plugin.expt.hellhound.ext.session.b.k.a((czu)localObject1);
    }
  }
  
  public static Pair<czu, Integer> dMr()
  {
    AppMethodBeat.i(300186);
    Object localObject = a.dMp();
    if (((czt)localObject).aaFj.isEmpty())
    {
      AppMethodBeat.o(300186);
      return null;
    }
    localObject = Pair.create((czu)((czt)localObject).aaFj.getLast(), Integer.valueOf(((czt)localObject).aaFj.size() - 1));
    AppMethodBeat.o(300186);
    return localObject;
  }
  
  public static com.tencent.mm.vending.j.c<czu, Integer> hs(String paramString1, String paramString2)
  {
    AppMethodBeat.i(300175);
    if ((paramString1 == null) || (paramString2 == null) || (paramString2.isEmpty()))
    {
      AppMethodBeat.o(300175);
      return null;
    }
    paramString2 = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(paramString2);
    Log.i("HABBYGE-MALI.HellPageFlowManager", "getPageFlowItemOfCurSession: %s, %s", new Object[] { paramString2, paramString1 });
    czt localczt = a.dMp();
    int i = localczt.aaFj.size() - 1;
    while (i >= 0)
    {
      czu localczu = (czu)localczt.aaFj.get(i);
      if (localczu.hQR.equals(paramString1))
      {
        String str = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(localczu.hJW);
        if ((str != null) && (str.equals(paramString2)))
        {
          paramString1 = com.tencent.mm.vending.j.a.U(localczu, Integer.valueOf(i));
          AppMethodBeat.o(300175);
          return paramString1;
        }
      }
      i -= 1;
    }
    AppMethodBeat.o(300175);
    return null;
  }
  
  public static void y(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(300169);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(300169);
      return;
    }
    Object localObject = com.tencent.mm.plugin.expt.hellhound.core.b.aqH(paramString);
    paramString = new czu();
    paramString.hJW = ((String)localObject);
    paramString.cHb = paramInt;
    paramString.startTime = paramLong;
    eah localeah = com.tencent.mm.plugin.expt.hellhound.ext.session.b.c.dLX();
    if (localeah == null)
    {
      Log.i("HABBYGE-MALI.HellPageFlowManager", "addPageflow(addPage2Flow), Unknown Page: %s", new Object[] { localObject });
      paramString.hQR = null;
      com.tencent.mm.plugin.expt.hellhound.ext.session.b.k.dMj();
    }
    for (;;)
    {
      localObject = a.dMp();
      ((czt)localObject).aaFj.addLast(paramString);
      a.a((czt)localObject);
      AppMethodBeat.o(300169);
      return;
      paramString.hQR = com.tencent.mm.plugin.expt.hellhound.ext.session.config.b.h(localeah);
      Log.i("HABBYGE-MALI.HellPageFlowManager", "addPageflow(addPage2Flow), session: %s, %s", new Object[] { localObject, paramString.hQR });
      com.tencent.mm.plugin.expt.hellhound.ext.session.b.k.a(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.session.c.b
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.expt.hellhound.a.f;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.b.b.c.b;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.k;
import com.tencent.mm.plugin.expt.hellhound.a.f.c.l;
import com.tencent.mm.plugin.expt.hellhound.a.f.f.i;
import com.tencent.mm.plugin.expt.hellhound.core.b.b.f;
import com.tencent.mm.protocal.protobuf.alz;
import com.tencent.mm.protocal.protobuf.bgb;
import com.tencent.mm.protocal.protobuf.bgc;
import com.tencent.mm.protocal.protobuf.bge;
import com.tencent.mm.protocal.protobuf.bh;
import com.tencent.mm.protocal.protobuf.bkl;
import com.tencent.mm.protocal.protobuf.bxt;
import com.tencent.mm.protocal.protobuf.bxu;
import com.tencent.mm.protocal.protobuf.bxx;
import com.tencent.mm.protocal.protobuf.cqr;
import com.tencent.mm.protocal.protobuf.cqv;
import com.tencent.mm.protocal.protobuf.dcm;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public final class b
{
  private static b pHg;
  public final com.tencent.mm.plugin.expt.hellhound.a.f.g.a.a pHh;
  public final com.tencent.mm.plugin.expt.hellhound.a.f.g.a.d pHi;
  public String pHj;
  private int pHk;
  private int pHl;
  private long pHm;
  private bxx pHn;
  
  private b()
  {
    AppMethodBeat.i(122045);
    this.pHj = null;
    this.pHk = -1;
    this.pHl = -1;
    this.pHm = -1L;
    this.pHn = null;
    this.pHh = new com.tencent.mm.plugin.expt.hellhound.a.f.g.a.a();
    this.pHi = new com.tencent.mm.plugin.expt.hellhound.a.f.g.a.d();
    if (com.tencent.mm.plugin.expt.hellhound.core.b.cbv()) {
      k.cdv();
    }
    AppMethodBeat.o(122045);
  }
  
  private void W(int paramInt, long paramLong)
  {
    AppMethodBeat.i(122072);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(122072);
      return;
      pm(paramLong);
      AppMethodBeat.o(122072);
      return;
      X(paramInt, paramLong);
    }
  }
  
  public static Map<Long, Long> Wr(String paramString)
  {
    AppMethodBeat.i(122087);
    Object localObject3 = com.tencent.mm.plugin.expt.hellhound.a.f.d.b.WZ(paramString);
    if ((localObject3 == null) || (((List)localObject3).isEmpty()))
    {
      AppMethodBeat.o(122087);
      return null;
    }
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.Wv(paramString);
    if (localObject1 == null) {
      paramString = null;
    }
    Object localObject2;
    while ((paramString == null) || (paramString.isEmpty()))
    {
      ad.i("HABBYGE-MALI.HellSessionMonitor", "getMatchingSessionPages, Empty !!");
      AppMethodBeat.o(122087);
      return null;
      localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.WF((String)localObject1);
      if ((localObject2 == null) || (((List)localObject2).isEmpty()))
      {
        paramString = null;
      }
      else
      {
        localObject1 = new HashMap();
        localObject3 = ((List)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          bgc localbgc = (bgc)((Iterator)localObject3).next();
          Object localObject4 = i.a(localbgc, (List)localObject2);
          if (localObject4 != null)
          {
            localObject4 = ((Map)localObject4).entrySet().iterator();
            while (((Iterator)localObject4).hasNext())
            {
              Object localObject5 = (Map.Entry)((Iterator)localObject4).next();
              long l = ((Long)((Map.Entry)localObject5).getKey()).longValue();
              localObject5 = (cqr)((Map.Entry)localObject5).getValue();
              cqr localcqr;
              if (((Map)localObject1).containsKey(Long.valueOf(l)))
              {
                localcqr = (cqr)((Map)localObject1).get(Long.valueOf(l));
                if (localcqr != null) {
                  if (((cqr)localObject5).index < 0)
                  {
                    localcqr.EjD.clear();
                    ((Map)localObject1).remove(Long.valueOf(l));
                  }
                  else if (((cqr)localObject5).index == 0)
                  {
                    localcqr.EjD.clear();
                    localcqr.EjD.add(localbgc);
                  }
                  else
                  {
                    localcqr.EjD.add(localbgc);
                  }
                }
              }
              else if ((((cqr)localObject5).index >= 0) && (!((cqr)localObject5).EjC))
              {
                localcqr = new cqr();
                localcqr.index = ((cqr)localObject5).index;
                localcqr.Doi = ((cqr)localObject5).Doi;
                localcqr.qHI = ((cqr)localObject5).qHI;
                localcqr.Doj = l;
                localcqr.dpw = paramString;
                localcqr.EjD.add(localbgc);
                ((Map)localObject1).put(Long.valueOf(l), localcqr);
              }
            }
          }
        }
        paramString = (String)localObject1;
      }
    }
    localObject1 = new HashMap();
    paramString = paramString.entrySet().iterator();
    while (paramString.hasNext())
    {
      localObject2 = (Map.Entry)paramString.next();
      localObject3 = ((cqr)((Map.Entry)localObject2).getValue()).EjD;
      if ((localObject3 != null) && (!((List)localObject3).isEmpty())) {
        ((Map)localObject1).put(((Map.Entry)localObject2).getKey(), Long.valueOf(((bgc)((List)localObject3).get(0)).startTime));
      }
    }
    AppMethodBeat.o(122087);
    return localObject1;
  }
  
  public static Map<Long, Long> Ws(String paramString)
  {
    AppMethodBeat.i(185583);
    Object localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.d.b.WZ(paramString);
    if (localObject2 != null)
    {
      localObject1 = localObject2;
      if (!((List)localObject2).isEmpty()) {}
    }
    else
    {
      localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.c.j.WX(paramString);
    }
    if ((localObject1 == null) || (((List)localObject1).isEmpty()))
    {
      AppMethodBeat.o(185583);
      return null;
    }
    localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.Wv(paramString);
    if (localObject2 == null) {
      localObject1 = null;
    }
    Object localObject4;
    Object localObject3;
    while ((localObject1 == null) || (((Map)localObject1).isEmpty()))
    {
      ad.i("HABBYGE-MALI.HellSessionMonitor", "getMatchedSessionPages, Empty !!");
      AppMethodBeat.o(185583);
      return null;
      localObject4 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.WF((String)localObject2);
      if ((localObject4 == null) || (((List)localObject4).isEmpty()))
      {
        localObject1 = null;
      }
      else
      {
        localObject2 = new HashMap();
        Iterator localIterator1 = ((List)localObject1).iterator();
        while (localIterator1.hasNext())
        {
          bgc localbgc = (bgc)localIterator1.next();
          localObject1 = i.a(localbgc, (List)localObject4);
          if (localObject1 != null)
          {
            Iterator localIterator2 = ((Map)localObject1).entrySet().iterator();
            while (localIterator2.hasNext())
            {
              localObject1 = (Map.Entry)localIterator2.next();
              long l = ((Long)((Map.Entry)localObject1).getKey()).longValue();
              localObject1 = (cqr)((Map.Entry)localObject1).getValue();
              if (((Map)localObject2).containsKey(Long.valueOf(l)))
              {
                if (((cqr)localObject1).EjC)
                {
                  localObject3 = (cqr)((Map)localObject2).get(Long.valueOf(l));
                  localObject1 = localObject3;
                  if (localObject3 == null)
                  {
                    localObject1 = new cqr();
                    ((Map)localObject2).put(Long.valueOf(l), localObject1);
                  }
                  ((cqr)localObject1).EjD.add(localbgc);
                }
              }
              else if (((cqr)localObject1).EjC)
              {
                localObject3 = new cqr();
                ((cqr)localObject3).index = ((cqr)localObject1).index;
                ((cqr)localObject3).Doi = ((cqr)localObject1).Doi;
                ((cqr)localObject3).qHI = ((cqr)localObject1).qHI;
                ((cqr)localObject3).Doj = l;
                ((cqr)localObject3).dpw = paramString;
                ((cqr)localObject3).EjD.add(localbgc);
                ((Map)localObject2).put(Long.valueOf(l), localObject3);
              }
            }
          }
        }
        localObject1 = localObject2;
      }
    }
    localObject2 = new HashMap();
    Object localObject1 = ((Map)localObject1).entrySet().iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject3 = (Map.Entry)((Iterator)localObject1).next();
      localObject4 = ((cqr)((Map.Entry)localObject3).getValue()).EjD;
      if ((localObject4 != null) && (!((List)localObject4).isEmpty())) {
        ((Map)localObject2).put(((Map.Entry)localObject3).getKey(), Long.valueOf(((bgc)((List)localObject4).get(0)).startTime));
      }
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.c.j.RR(paramString);
    AppMethodBeat.o(185583);
    return localObject2;
  }
  
  private void X(int paramInt, long paramLong)
  {
    AppMethodBeat.i(122074);
    bxx localbxx = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cdh();
    if (localbxx == null)
    {
      ad.e("HABBYGE-MALI.HellSessionMonitor", "_chattingUIOut, 不是合法session !!!");
      AppMethodBeat.o(122074);
      return;
    }
    ad.i("HABBYGE-MALI.HellSessionMonitor", "_chattingUIOut, curSessionId: %s", new Object[] { localbxx.sessionId });
    if (!com.tencent.mm.plugin.expt.hellhound.a.f.b.b.WD(localbxx.sessionId))
    {
      ad.i("HABBYGE-MALI.HellSessionMonitor", "_chattingUIOut, not chat session: %s", new Object[] { localbxx.sessionId });
      com.tencent.mm.plugin.expt.hellhound.core.stack.d.cbG();
      localObject = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cbL();
      if (localObject != null)
      {
        localObject = ((bh)localObject).CvH.activityName;
        ad.i("HABBYGE-MALI.HellSessionMonitor", "_chattingUIOut, not chat session, page: %s", new Object[] { localObject });
        if (paramInt != 2) {
          com.tencent.mm.plugin.expt.hellhound.a.f.d.b.b(localbxx, (String)localObject, paramLong);
        }
      }
      AppMethodBeat.o(122074);
      return;
    }
    Object localObject = a.ccF();
    ad.i("HABBYGE-MALI.HellSessionMonitor", "_chattingUIOut, userName: %s", new Object[] { (String)((com.tencent.mm.vending.j.b)localObject).get(0) });
    int i = ((Integer)((com.tencent.mm.vending.j.c)localObject).get(1)).intValue();
    ad.i("HABBYGE-MALI.HellSessionMonitor", "_chattingUIOut, newChattingType: %s, %d", new Object[] { Integer.valueOf(i), Integer.valueOf(localbxx.DUr) });
    if (i == localbxx.DUr)
    {
      if ("ChattingUI".equals(localbxx.DUq))
      {
        ad.i("HABBYGE-MALI.HellSessionMonitor", "chattingUIOut, CHATTING_UI");
        a(localbxx, paramLong);
        AppMethodBeat.o(122074);
        return;
      }
      if (paramInt == 2)
      {
        ad.i("HABBYGE-MALI.HellSessionMonitor", "chattingUIOut, SLIENCE: %s", new Object[] { localbxx.DUq });
        a(localbxx, paramLong);
        AppMethodBeat.o(122074);
        return;
      }
      com.tencent.mm.plugin.expt.hellhound.core.stack.d.cbG();
      localObject = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cbL();
      if (localObject != null)
      {
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.b(localbxx, ((bh)localObject).CvH.activityName, paramLong);
        com.tencent.mm.plugin.expt.hellhound.a.f.c.c.i(localbxx);
      }
      AppMethodBeat.o(122074);
      return;
    }
    ad.e("HABBYGE-MALI.HellSessionMonitor", "_chattingUIOut, curChattingType不等: %d", new Object[] { Integer.valueOf(i) });
    AppMethodBeat.o(122074);
  }
  
  private static Pair<String, String> a(bxx parambxx1, bxx parambxx2, bge parambge)
  {
    AppMethodBeat.i(190896);
    int j = parambge.DDV.size();
    int i;
    if ((parambxx1 == null) && (parambxx2 == null))
    {
      if (j <= 0)
      {
        AppMethodBeat.o(190896);
        return null;
      }
      if (j < 2)
      {
        parambxx1 = (bxt)parambge.DDV.getLast();
        parambxx1 = Pair.create(parambxx1.DDP + "_" + parambxx1.startTime, null);
        AppMethodBeat.o(190896);
        return parambxx1;
      }
      if (j == 2)
      {
        parambxx1 = (bxt)parambge.DDV.getLast();
        parambxx2 = (bxt)parambge.DDV.get(0);
        parambxx1 = Pair.create(parambxx1.DDP + "_" + parambxx1.startTime, parambxx2.DDP + "_" + parambxx2.startTime);
        AppMethodBeat.o(190896);
        return parambxx1;
      }
      parambxx1 = (bxt)parambge.DDV.getLast();
      i = j - 2;
      while (i >= 0)
      {
        parambxx2 = (bxt)parambge.DDV.get(i);
        if (!parambxx1.DDP.equals(parambxx2.DDP))
        {
          parambxx1 = Pair.create(parambxx1.DDP + "_" + parambxx1.startTime, parambxx2.DDP + "_" + parambxx2.startTime);
          AppMethodBeat.o(190896);
          return parambxx1;
        }
        i -= 1;
      }
      parambxx2 = (bxt)parambge.DDV.get(j - 2);
      parambxx1 = Pair.create(parambxx1.DDP + "_" + parambxx1.startTime, parambxx2.DDP + "_" + parambxx2.startTime);
      AppMethodBeat.o(190896);
      return parambxx1;
    }
    bxt localbxt;
    if ((parambxx1 != null) && (parambxx2 == null))
    {
      if (j <= 0)
      {
        parambxx1 = Pair.create(parambxx1.sessionId, null);
        AppMethodBeat.o(190896);
        return parambxx1;
      }
      if (j < 2)
      {
        parambxx2 = (bxt)parambge.DDV.getLast();
        if (parambxx2.startTime <= parambxx1.startTime)
        {
          parambxx1 = Pair.create(parambxx1.sessionId, parambxx2.DDP + "_" + parambxx2.startTime);
          AppMethodBeat.o(190896);
          return parambxx1;
        }
        parambxx1 = Pair.create(parambxx2.DDP + "_" + parambxx2.startTime, parambxx1.sessionId);
        AppMethodBeat.o(190896);
        return parambxx1;
      }
      if (j == 2)
      {
        parambxx2 = (bxt)parambge.DDV.getLast();
        parambge = (bxt)parambge.DDV.get(j - 2);
        if (parambxx2.startTime <= parambxx1.startTime)
        {
          parambxx1 = Pair.create(parambxx1.sessionId, parambxx2.DDP + "_" + parambxx2.startTime);
          AppMethodBeat.o(190896);
          return parambxx1;
        }
        if (parambge.startTime <= parambxx1.startTime)
        {
          parambxx1 = Pair.create(parambxx2.DDP + "_" + parambxx2.startTime, parambxx1.sessionId);
          AppMethodBeat.o(190896);
          return parambxx1;
        }
        parambxx1 = Pair.create(parambxx2.DDP + "_" + parambxx2.startTime, parambge.DDP + "_" + parambge.startTime);
        AppMethodBeat.o(190896);
        return parambxx1;
      }
      parambxx2 = (bxt)parambge.DDV.getLast();
      if (parambxx2.startTime <= parambxx1.startTime)
      {
        parambxx1 = Pair.create(parambxx1.sessionId, parambxx2.DDP + "_" + parambxx2.startTime);
        AppMethodBeat.o(190896);
        return parambxx1;
      }
      localbxt = (bxt)parambge.DDV.get(j - 2);
      if (localbxt.startTime <= parambxx1.startTime)
      {
        parambxx1 = Pair.create(parambxx2.DDP + "_" + parambxx2.startTime, parambxx1.sessionId);
        AppMethodBeat.o(190896);
        return parambxx1;
      }
      if (!parambxx2.DDP.equals(localbxt.DDP))
      {
        parambxx1 = Pair.create(parambxx2.DDP + "_" + parambxx2.startTime, localbxt.DDP + "_" + localbxt.startTime);
        AppMethodBeat.o(190896);
        return parambxx1;
      }
      i = j - 2;
      while (i >= 0)
      {
        localbxt = (bxt)parambge.DDV.get(i);
        if (localbxt.DDP.equals(parambxx2.DDP))
        {
          if (localbxt.startTime <= parambxx1.startTime)
          {
            parambxx1 = Pair.create(parambxx2.DDP + "_" + parambxx2.startTime, parambxx1.sessionId);
            AppMethodBeat.o(190896);
            return parambxx1;
          }
        }
        else
        {
          if (localbxt.startTime <= parambxx1.startTime)
          {
            parambxx1 = Pair.create(parambxx2.DDP + "_" + parambxx2.startTime, parambxx1.sessionId);
            AppMethodBeat.o(190896);
            return parambxx1;
          }
          parambxx1 = Pair.create(parambxx2.DDP + "_" + parambxx2.startTime, localbxt.DDP + "_" + localbxt.startTime);
          AppMethodBeat.o(190896);
          return parambxx1;
        }
        i -= 1;
      }
      parambxx1 = Pair.create(parambxx2.DDP + "_" + parambxx2.startTime, parambxx1.sessionId);
      AppMethodBeat.o(190896);
      return parambxx1;
    }
    if (parambxx1 != null)
    {
      if (j <= 0)
      {
        parambxx1 = Pair.create(parambxx1.sessionId, parambxx2.sessionId);
        AppMethodBeat.o(190896);
        return parambxx1;
      }
      if (j < 2)
      {
        parambge = (bxt)parambge.DDV.getLast();
        if (parambge.startTime > parambxx1.startTime)
        {
          parambxx1 = Pair.create(parambge.DDP + "_" + parambge.startTime, parambxx1.sessionId);
          AppMethodBeat.o(190896);
          return parambxx1;
        }
        if (parambge.startTime > parambxx2.startTime)
        {
          parambxx1 = Pair.create(parambxx1.sessionId, parambge.DDP + "_" + parambge.startTime);
          AppMethodBeat.o(190896);
          return parambxx1;
        }
        parambxx1 = Pair.create(parambxx1.sessionId, parambxx2.sessionId);
        AppMethodBeat.o(190896);
        return parambxx1;
      }
      localbxt = (bxt)parambge.DDV.getLast();
      parambge = (bxt)parambge.DDV.get(j - 2);
      if (localbxt.startTime <= parambxx1.startTime)
      {
        if (localbxt.startTime <= parambxx2.startTime)
        {
          parambxx1 = Pair.create(parambxx1.sessionId, parambxx2.sessionId);
          AppMethodBeat.o(190896);
          return parambxx1;
        }
        parambxx1 = Pair.create(parambxx1.sessionId, localbxt.DDP + "_" + localbxt.startTime);
        AppMethodBeat.o(190896);
        return parambxx1;
      }
      if (parambxx1.startTime >= parambge.startTime)
      {
        parambxx1 = Pair.create(localbxt.DDP + "_" + localbxt.startTime, parambxx1.sessionId);
        AppMethodBeat.o(190896);
        return parambxx1;
      }
      parambxx1 = Pair.create(localbxt.DDP + "_" + localbxt.startTime, parambge.DDP + "_" + parambge.startTime);
      AppMethodBeat.o(190896);
      return parambxx1;
    }
    AppMethodBeat.o(190896);
    return null;
  }
  
  private void a(int paramInt, bh parambh, long paramLong)
  {
    AppMethodBeat.i(122077);
    ad.i("HABBYGE-MALI.HellSessionMonitor", "monitorChatUIFragment: %d", new Object[] { Integer.valueOf(paramInt) });
    if (paramInt == 6)
    {
      a(parambh, paramLong);
      AppMethodBeat.o(122077);
      return;
    }
    if (paramInt == 7) {
      po(paramLong);
    }
    AppMethodBeat.o(122077);
  }
  
  private void a(Activity paramActivity, bh parambh1, bh parambh2, int paramInt)
  {
    AppMethodBeat.i(184368);
    if (parambh1 == null)
    {
      AppMethodBeat.o(184368);
      return;
    }
    if ("ChattingUI".equals(com.tencent.mm.plugin.expt.hellhound.core.b.Vy(parambh1.CvH.activityName)))
    {
      W(paramInt, parambh1.CvH.timestamp);
      AppMethodBeat.o(184368);
      return;
    }
    a(paramActivity, parambh1, parambh2, paramInt, parambh1.CvH.timestamp);
    AppMethodBeat.o(184368);
  }
  
  private void a(Activity paramActivity, bh parambh1, bh parambh2, int paramInt, long paramLong)
  {
    AppMethodBeat.i(122068);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(122068);
      return;
      a(paramActivity, parambh1, parambh2, paramLong);
      AppMethodBeat.o(122068);
      return;
      a(parambh1, paramInt, paramLong);
    }
  }
  
  private void a(Activity paramActivity, bh parambh1, bh parambh2, long paramLong)
  {
    AppMethodBeat.i(122069);
    if (parambh1 == null)
    {
      AppMethodBeat.o(122069);
      return;
    }
    String str = com.tencent.mm.plugin.expt.hellhound.core.b.Vy(parambh1.CvH.activityName);
    ad.i("HABBYGE-MALI.HellSessionMonitor", "activityIn, curActivityName: %s", new Object[] { str });
    if (parambh1.CvH.timestamp <= 0L) {}
    bxx localbxx;
    for (;;)
    {
      localbxx = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cdh();
      parambh1 = e(parambh1, parambh2);
      if (localbxx != null) {
        break label227;
      }
      ad.i("HABBYGE-MALI.HellSessionMonitor", "_activityIn, newSession: %s, %s", new Object[] { str, parambh1 });
      paramActivity = a(paramActivity, parambh1, str, paramLong);
      if (paramActivity != null) {
        break;
      }
      ad.e("HABBYGE-MALI.HellSessionMonitor", "_activityIn, illegal session ~~~");
      AppMethodBeat.o(122069);
      return;
      paramLong = parambh1.CvH.timestamp;
    }
    int i = 1;
    for (;;)
    {
      if ((str != null) && (!str.equals("LauncherUI"))) {
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.b(paramActivity, str, paramLong);
      }
      if (i != 0)
      {
        ad.i("HABBYGE-MALI.HellSessionMonitor", "activityIn, isNewSession: %s", new Object[] { paramActivity.sessionId });
        paramActivity.gXt = 0;
        parambh2 = l.ccJ();
        parambh1 = parambh2;
        if (parambh2 == null) {
          parambh1 = "";
        }
        paramActivity.DUm = parambh1;
        com.tencent.mm.plugin.expt.hellhound.a.f.c.c.h(paramActivity);
        a(paramActivity);
        AppMethodBeat.o(122069);
        return;
        label227:
        ad.i("HABBYGE-MALI.HellSessionMonitor", "_activityIn, curSession: %s, %s, %s", new Object[] { localbxx.sessionId, parambh1, str });
        if (com.tencent.mm.plugin.expt.hellhound.core.b.VN(parambh1))
        {
          paramActivity = a(paramActivity, parambh1, str, paramLong);
          if (paramActivity != null)
          {
            paramActivity.DUw = true;
            a(localbxx, paramLong);
            d(localbxx);
            i = 1;
          }
        }
      }
      else
      {
        ad.i("HABBYGE-MALI.HellSessionMonitor", "activityIn, setPageFlow: %s", new Object[] { paramActivity.sessionId });
        AppMethodBeat.o(122069);
        return;
      }
      paramActivity = localbxx;
      i = 0;
    }
  }
  
  public static void a(Fragment paramFragment, int paramInt)
  {
    AppMethodBeat.i(122054);
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ccP())
    {
      ad.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, catchParamsOnFragment: FALSE");
      AppMethodBeat.o(122054);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.e.a.b(paramFragment, paramInt);
    com.tencent.mm.plugin.expt.hellhound.a.f.e.c.b(paramFragment, paramInt);
    AppMethodBeat.o(122054);
  }
  
  @SuppressLint({"NewApi"})
  private void a(bh parambh, int paramInt, long paramLong)
  {
    AppMethodBeat.i(122071);
    if (parambh == null)
    {
      ad.e("HABBYGE-MALI.HellSessionMonitor", "HelLSessionMonitor, activityOut: NULL");
      AppMethodBeat.o(122071);
      return;
    }
    bxx localbxx = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cdh();
    if (localbxx == null)
    {
      ad.e("HABBYGE-MALI.HellSessionMonitor", "_activityOut, 不是合法session !!!");
      AppMethodBeat.o(122071);
      return;
    }
    String str1 = com.tencent.mm.plugin.expt.hellhound.core.b.Vy(parambh.CvH.activityName);
    if (str1 == null)
    {
      AppMethodBeat.o(122071);
      return;
    }
    String str2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.Wv(localbxx.sessionId);
    ad.i("HABBYGE-MALI.HellSessionMonitor", "activityOut, curSesssion: %s, %s", new Object[] { str2, str1 });
    int i;
    if ((com.tencent.mm.plugin.expt.hellhound.a.f.b.b.WA(str2)) || ("131".equals(str2)) || ("144".equals(str2))) {
      i = 1;
    }
    while (i != 0) {
      if (com.tencent.mm.plugin.expt.hellhound.core.b.VE(localbxx.DUv))
      {
        if (com.tencent.mm.plugin.expt.hellhound.core.b.VE(str1))
        {
          a(localbxx, paramLong);
          AppMethodBeat.o(122071);
          return;
          i = 0;
        }
        else
        {
          com.tencent.mm.plugin.expt.hellhound.core.stack.d.cbG();
          parambh = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cbL();
          if (parambh != null) {
            com.tencent.mm.plugin.expt.hellhound.a.f.d.b.b(localbxx, parambh.CvH.activityName, paramLong);
          }
          AppMethodBeat.o(122071);
        }
      }
      else
      {
        if ("AppBrandLaunchProxyUI".equals(str1))
        {
          ad.e("HABBYGE-MALI.HellSessionMonitor", "_activityOut, AppBrandLaunchProxyUI out ~~");
          AppMethodBeat.o(122071);
          return;
        }
        ad.i("HABBYGE-MALI.HellSessionMonitor", "_activityOut, AppBrand cur: %s, start: %s", new Object[] { str1, localbxx.DUv });
        if ((com.tencent.mm.plugin.expt.hellhound.core.b.VD(str1)) && (str1.equals(localbxx.DUv)))
        {
          a(localbxx, paramLong);
          AppMethodBeat.o(122071);
          return;
        }
        if ((!com.tencent.mm.plugin.expt.hellhound.core.b.VD(str1)) || (!"AppBrandLaunchProxyUI".equals(localbxx.DUv))) {
          break label367;
        }
        a(localbxx, paramLong);
      }
    }
    label367:
    Object localObject;
    while ("132".equals(str2)) {
      if ("GameCenterUI".equals(str1))
      {
        ad.e("HABBYGE-MALI.HellSessionMonitor", "_activityOut, GameCenterUI out ~~");
        AppMethodBeat.o(122071);
        return;
        com.tencent.mm.plugin.expt.hellhound.core.stack.d.cbG();
        localObject = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cbL();
        if (localObject != null) {
          ad.i("HABBYGE-MALI.HellSessionMonitor", "_activityOut, dstAR: %s", new Object[] { ((bh)localObject).CvH.activityName });
        }
        if ((com.tencent.mm.plugin.expt.hellhound.core.b.VD(str1)) && (localObject != null) && (com.tencent.mm.plugin.expt.hellhound.core.b.Vt(((bh)localObject).CvH.activityName)))
        {
          a(localbxx, paramLong);
          AppMethodBeat.o(122071);
          return;
        }
        if ((localObject != null) && (!com.tencent.mm.plugin.expt.hellhound.core.b.Vt(((bh)localObject).CvH.activityName))) {
          com.tencent.mm.plugin.expt.hellhound.a.f.d.b.b(localbxx, ((bh)localObject).CvH.activityName, paramLong);
        }
      }
      else if (("GameWebViewUI".equals(str1)) || ("LuggageGameWebViewUI".equals(str1)) || ("GameWebViewMpUI".equals(str1)) || ("LuggageGameWebViewMpUI".equals(str1)))
      {
        ad.i("HABBYGE-MALI.HellSessionMonitor", "_activityOut, GameWebViewUI: %s", new Object[] { str1 });
        a(localbxx, paramLong);
        AppMethodBeat.o(122071);
        return;
      }
    }
    if ("142".equals(str2))
    {
      ad.i("HABBYGE-MALI.HellSessionMonitor", "_activityOut, StoryGallery Session(142)");
      if ("StoryCaptureUI".equals(str1))
      {
        ad.i("HABBYGE-MALI.HellSessionMonitor", "_activityOut, GameWebViewUI: %s", new Object[] { str1 });
        a(localbxx, paramLong);
        AppMethodBeat.o(122071);
        return;
      }
    }
    if ("110".equals(str2))
    {
      if ((!"WalletOfflineCoinPurseUI".equals(str1)) && (!"WalletOfflineEntranceUI".equals(str1)))
      {
        com.tencent.mm.plugin.expt.hellhound.core.stack.d.cbG();
        parambh = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cbL();
        if (parambh != null) {
          com.tencent.mm.plugin.expt.hellhound.a.f.d.b.b(localbxx, parambh.CvH.activityName, paramLong);
        }
        AppMethodBeat.o(122071);
        return;
      }
      if (paramInt != 2) {
        a(localbxx, paramLong);
      }
      AppMethodBeat.o(122071);
      return;
    }
    if ((parambh.CvK != null) && (!parambh.CvK.isEmpty()))
    {
      parambh = com.tencent.mm.plugin.expt.hellhound.core.b.Vy(parambh.CvK);
      ad.i("HABBYGE-MALI.HellSessionMonitor", "_activityOut, nextActivity: %s, %d", new Object[] { parambh, Integer.valueOf(paramInt) });
      if ((paramInt != 2) && (!"LauncherUI".equals(parambh))) {
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.b(localbxx, parambh, paramLong);
      }
    }
    for (;;)
    {
      if (!str1.equals(localbxx.DUq))
      {
        ad.i("HABBYGE-MALI.HellSessionMonitor", "_activityOut, curActivity: %s is not curSession: %s preActivity %s", new Object[] { str1, localbxx.sessionId, localbxx.DUq });
        if ((com.tencent.mm.plugin.expt.hellhound.a.f.g.a.Xj(str2)) && ("WebViewUI".equals(str1)))
        {
          ad.i("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, isScanSession true !!");
          a(localbxx, paramLong);
        }
        AppMethodBeat.o(122071);
        return;
      }
      int j = 1;
      int m;
      int k;
      bkl localbkl;
      if ("WebViewUI".equals(str1))
      {
        ad.i("HABBYGE-MALI.HellSessionMonitor", "_activityOut, WebViewUI: %s, %s", new Object[] { com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.VY("minimize_secene"), com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.VY("KPublisherId") });
        m = 0;
        j = 0;
        if (localbxx.DUs == null) {
          break label1389;
        }
        localObject = localbxx.DUs.DUn.iterator();
        i = 0;
        do
        {
          k = i;
          m = j;
          if (!((Iterator)localObject).hasNext()) {
            break;
          }
          localbkl = (bkl)((Iterator)localObject).next();
        } while (localbkl == null);
        if ((!"minimize_secene".equals(localbkl.key)) || (!"1".equals(localbkl.value))) {
          break label1287;
        }
        if (i == 0) {
          break label1383;
        }
        m = 1;
        k = i;
      }
      for (;;)
      {
        label1007:
        if ((m != 0) && (k != 0)) {}
        for (i = 1;; i = 0)
        {
          j = i;
          if ("LauncherUI".equals(parambh))
          {
            j = i;
            if ("148".equals(str2)) {
              j = 1;
            }
          }
          if (j != 0)
          {
            ad.i("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, isStartPageOfSession true: %s", new Object[] { str1 });
            if (com.tencent.mm.plugin.expt.hellhound.a.f.g.a.Xj(str2))
            {
              boolean bool = com.tencent.mm.plugin.expt.hellhound.a.e.a.ccC();
              ad.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, scan session: %s", new Object[] { Boolean.valueOf(bool) });
              if (bool)
              {
                com.tencent.mm.plugin.expt.hellhound.a.e.a.ccD();
                com.tencent.mm.plugin.expt.hellhound.core.stack.d.cbG();
                parambh = com.tencent.mm.plugin.expt.hellhound.core.b.Vy(com.tencent.mm.plugin.expt.hellhound.core.stack.e.cbL().CvH.activityName);
                ad.d("HABBYGE-MALI.HellSessionMonitor", "scan session: %s, %s", new Object[] { str1, parambh });
                if ((!"BaseScanUI".equals(str1)) || (!"LauncherUI".equals(parambh))) {
                  break label1356;
                }
                ad.i("HABBYGE-MALI.HellSessionMonitor", "BaseScanUI, LauncherUI");
              }
            }
            else
            {
              if ((!"ContactInfoUI".equals(str1)) || (!"122".equals(str2)) || (paramInt != 2)) {
                break label1363;
              }
              ad.i("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, EVENT_ACTIVITY_OUT_SLIENCE: ContactInfoUI");
              parambh = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.Bq(100);
              str1 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.Bq(101);
              ad.i("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, from: %s, to: %s", new Object[] { parambh, str1 });
              if ((!"com.tencent.mm.plugin.profile.ui.ContactInfoUI".equals(parambh)) || (!"com.tencent.mm.ui.chatting.ChattingUI".equals(str1))) {
                break label1363;
              }
              ad.i("HABBYGE-MALI.HellSessionMonitor", "ContactInfoUI->ChattingUI YES");
              AppMethodBeat.o(122071);
              return;
              label1287:
              k = i;
              if ("KPublisherId".equals(localbkl.key))
              {
                k = i;
                if ("jd_store".equals(localbkl.value))
                {
                  i = 1;
                  k = 1;
                  m = j;
                  if (j != 0) {
                    break label1007;
                  }
                  k = i;
                }
              }
              i = k;
              break;
            }
            AppMethodBeat.o(122071);
            return;
            label1356:
            AppMethodBeat.o(122071);
            return;
            label1363:
            a(localbxx, paramLong);
          }
          AppMethodBeat.o(122071);
          return;
        }
        label1383:
        j = 1;
        break;
        label1389:
        k = 0;
      }
      parambh = null;
    }
  }
  
  private void a(bh parambh1, int paramInt, bh parambh2)
  {
    AppMethodBeat.i(184370);
    Object localObject = b(parambh1, paramInt, parambh2);
    if (localObject == null)
    {
      AppMethodBeat.o(184370);
      return;
    }
    String str = (String)((com.tencent.mm.vending.j.b)localObject).get(0);
    ad.i("HABBYGE-MALI.HellSessionMonitor", "monitorFragment: %s, %s, %d", new Object[] { str, (String)((com.tencent.mm.vending.j.c)localObject).get(1), Integer.valueOf(paramInt) });
    if (paramInt == 4) {
      if ("ChattingUIFragment".equals(com.tencent.mm.plugin.expt.hellhound.core.b.Vy(str)))
      {
        ad.i("HABBYGE-MALI.HellSessionMonitor", "monitorFragment, EVENT_CHATTINGUIFRAGMENT_IN");
        a(6, parambh2, parambh1.CvL);
      }
    }
    for (;;)
    {
      if (this.pHk != -1) {
        this.pHk = -1;
      }
      AppMethodBeat.o(184370);
      return;
      localObject = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cdh();
      if ((localObject != null) && (((bxx)localObject).sessionId.startsWith("142")))
      {
        AppMethodBeat.o(184370);
        return;
      }
      if ((localObject != null) && (com.tencent.mm.plugin.expt.hellhound.a.b.b.c.aUV(parambh1.CvI)))
      {
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.b((bxx)localObject, parambh1.CvI, parambh1.CvL);
        AppMethodBeat.o(184370);
        return;
      }
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.b(null, parambh1.CvI, parambh1.CvL);
      if (localObject == null)
      {
        localObject = com.tencent.mm.plugin.expt.hellhound.core.b.Vy(parambh1.CvI);
        ad.i("HABBYGE-MALI.HellSessionMonitor", "monitorFragment, curSession == null: %s", new Object[] { localObject });
        if ("ChattingUIFragment".equals(localObject)) {
          a(6, parambh2, parambh1.CvL);
        } else {
          ah(parambh1.CvI, parambh1.CvL);
        }
      }
      else if (com.tencent.mm.plugin.expt.hellhound.core.b.aUN(parambh1.CvI))
      {
        ad.i("HABBYGE-MALI.HellSessionMonitor", "curAR.currFragment: %s", new Object[] { parambh1.CvI });
        a((bxx)localObject, parambh1.CvL);
        ah(parambh1.CvI, parambh1.CvL);
        continue;
        if (paramInt == 5)
        {
          if (("ChattingUIFragment".equals(str)) || (com.tencent.mm.plugin.expt.hellhound.a.b.b.c.aUV(str)))
          {
            ad.i("HABBYGE-MALI.HellSessionMonitor", "monitorFragment, out event, no need handle, curFragment=%s", new Object[] { str });
            AppMethodBeat.o(184370);
            return;
          }
          ai(str, parambh1.CvL);
        }
      }
    }
  }
  
  private void a(bh parambh, long paramLong)
  {
    AppMethodBeat.i(122078);
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cdh();
    if (localObject1 == null) {
      if (parambh != null)
      {
        parambh = com.tencent.mm.plugin.expt.hellhound.core.b.Vy(parambh.CvJ);
        localObject1 = a(null, parambh, "ChattingUIFragment", paramLong);
        if (localObject1 == null)
        {
          ad.e("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart, curSession == null");
          AppMethodBeat.o(122078);
          return;
        }
        ad.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart, lastPage: %s", new Object[] { parambh });
        parambh = (bh)localObject1;
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        ad.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart new Session: %s", new Object[] { Long.valueOf(paramLong) });
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.b(parambh, com.tencent.mm.plugin.expt.hellhound.core.b.pDY, paramLong);
        parambh.gXt = 0;
        localObject2 = l.ccJ();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        parambh.DUm = ((String)localObject1);
        com.tencent.mm.plugin.expt.hellhound.a.f.c.c.h(parambh);
        a(parambh);
        AppMethodBeat.o(122078);
        return;
      }
      if (com.tencent.mm.plugin.expt.hellhound.a.f.g.a.Xj(parambh.sessionId))
      {
        ad.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart, NOT, sessionId: %s", new Object[] { parambh.sessionId });
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.b(parambh, com.tencent.mm.plugin.expt.hellhound.core.b.pDY, paramLong);
        AppMethodBeat.o(122078);
        return;
      }
      localObject1 = a.ccG();
      Object localObject2 = (String)((com.tencent.mm.vending.j.b)localObject1).get(0);
      i = ((Integer)((com.tencent.mm.vending.j.c)localObject1).get(1)).intValue();
      ad.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart: %s, %d", new Object[] { localObject2, Integer.valueOf(i) });
      if (i == parambh.DUr)
      {
        ad.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart, curChatType == chatType");
        if (this.pHk != 7)
        {
          ad.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart, 7-Event-NOT");
          com.tencent.mm.plugin.expt.hellhound.a.f.d.b.b(parambh, com.tencent.mm.plugin.expt.hellhound.core.b.pDY, paramLong);
          AppMethodBeat.o(122078);
          return;
        }
        ad.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart, 7-Event");
        AppMethodBeat.o(122078);
        return;
      }
      ad.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionStart, curChatType!=chatType: %d, %d", new Object[] { Integer.valueOf(i), Integer.valueOf(parambh.DUr) });
      a(parambh, paramLong);
      localObject2 = a(null, com.tencent.mm.plugin.expt.hellhound.core.b.pDZ, "ChattingUIFragment", paramLong);
      if (localObject2 != null)
      {
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.b((bxx)localObject2, com.tencent.mm.plugin.expt.hellhound.core.b.pDY, paramLong);
        ((bxx)localObject2).gXt = 0;
        localObject1 = l.ccJ();
        parambh = (bh)localObject1;
        if (localObject1 == null) {
          parambh = "";
        }
        ((bxx)localObject2).DUm = parambh;
        com.tencent.mm.plugin.expt.hellhound.a.f.c.c.h((bxx)localObject2);
        a((bxx)localObject2);
      }
      AppMethodBeat.o(122078);
      return;
      parambh = null;
      break;
      parambh = (bh)localObject1;
    }
  }
  
  public static void a(bxx parambxx)
  {
    AppMethodBeat.i(122082);
    if (parambxx == null)
    {
      AppMethodBeat.o(122082);
      return;
    }
    ad.i("HABBYGE-MALI.HellSessionMonitor", "onSessionStart: %s, %s, %s", new Object[] { parambxx.sessionId, Long.valueOf(parambxx.startTime), parambxx.DUm });
    b(parambxx);
    com.tencent.mm.plugin.expt.hellhound.a.d.a locala = com.tencent.mm.plugin.expt.hellhound.a.d.a.pGO;
    com.tencent.mm.plugin.expt.hellhound.a.d.a.Wi(parambxx.sessionId);
    l.xe(parambxx.sessionId);
    AppMethodBeat.o(122082);
  }
  
  private static void a(bxx parambxx, String paramString)
  {
    AppMethodBeat.i(122066);
    if (parambxx == null)
    {
      AppMethodBeat.o(122066);
      return;
    }
    if (parambxx.sessionId.startsWith("142"))
    {
      if ((paramString == null) || (com.tencent.mm.plugin.expt.hellhound.core.b.Vt(paramString))) {}
      for (int i = 1; i != 0; i = 0)
      {
        boolean bool = f.b(com.tencent.mm.plugin.expt.hellhound.core.b.cby(), com.tencent.mm.plugin.expt.hellhound.core.b.pDX);
        ad.i("HABBYGE-MALI.HellSessionMonitor", "retainCurSession, 142: isActive: %b", new Object[] { Boolean.valueOf(bool) });
        if (bool) {
          break label100;
        }
        AppMethodBeat.o(122066);
        return;
      }
      ad.i("HABBYGE-MALI.HellSessionMonitor", "retainCurSession, 142: isStoryGalleryViewShow: FALSE");
    }
    label100:
    paramString = new bge();
    bxx localbxx = new bxx();
    com.tencent.mm.plugin.expt.hellhound.a.f.b.b.e(parambxx);
    localbxx.sessionId = parambxx.sessionId;
    ad.i("HABBYGE-MALI.HellSessionMonitor", "retainCurSession, curSession.session: %s", new Object[] { parambxx.sessionId });
    localbxx.DUu = true;
    localbxx.gXt = 1;
    localbxx.DUw = parambxx.DUw;
    localbxx.DUq = parambxx.DUq;
    localbxx.DUr = parambxx.DUr;
    localbxx.userName = parambxx.userName;
    localbxx.DUs = parambxx.DUs;
    localbxx.DUt = parambxx.DUt;
    localbxx.seq = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cdf();
    paramString.DDT.addLast(localbxx);
    paramString.DDU = (paramString.DDT.size() - 1);
    ad.i("HABBYGE-MALI.HellSessionMonitor", "retainCurSession.session: %s, %s", new Object[] { localbxx.sessionId, localbxx.DUq });
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.b(paramString);
    AppMethodBeat.o(122066);
  }
  
  public static void ac(String paramString, long paramLong)
  {
    AppMethodBeat.i(184365);
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ccP())
    {
      ad.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, monitorScanSession: FALSE");
      AppMethodBeat.o(184365);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.g.a.an(paramString, paramLong);
    AppMethodBeat.o(184365);
  }
  
  private void ad(String paramString, long paramLong)
  {
    AppMethodBeat.i(122059);
    if (TextUtils.isEmpty(paramString))
    {
      AppMethodBeat.o(122059);
      return;
    }
    Object localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cdm();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new bge();
    }
    ((bge)localObject1).DDR = paramLong;
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.b((bge)localObject1);
    ad.i("HABBYGE-MALI.HellSessionMonitor", "_launcherUIOn7Event: %s, %s", new Object[] { paramString, Long.valueOf(((bge)localObject1).DDR) });
    localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cdh();
    if (localObject2 != null)
    {
      if (((bxx)localObject2).DUu)
      {
        String str = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.Wv(((bxx)localObject2).sessionId);
        ad.i("HABBYGE-MALI.HellSessionMonitor", "_launcherUIOn7Event, curSid: %s", new Object[] { str });
        if ((com.tencent.mm.plugin.expt.hellhound.a.f.b.b.WA(str)) || ("131".equals(str)) || ("144".equals(str))) {}
        for (int i = 1; (i != 0) && (com.tencent.mm.plugin.expt.hellhound.core.b.Vt(paramString)); i = 0)
        {
          ad.i("HABBYGE-MALI.HellSessionMonitor", "_launcherUIOn7Event, AppBrand 7Event !!!");
          com.tencent.mm.plugin.expt.hellhound.a.f.c.c.WQ(((bxx)localObject2).sessionId);
          AppMethodBeat.o(122059);
          return;
        }
        if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.WB(str))
        {
          paramString = com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c.cdD();
          if (paramString != null)
          {
            ad.w("HABBYGE-MALI.HellSessionMonitor", "lstItem: %s, %s", new Object[] { paramString.dpw, paramString.DDP });
            if ((com.tencent.mm.plugin.expt.hellhound.a.f.b.b.WB(paramString.dpw)) && ((paramString.DDP.equals("FloatBall")) || (com.tencent.mm.plugin.expt.hellhound.core.b.VD(paramString.DDP))))
            {
              paramString = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ccR();
              localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cdj();
              ad.w("HABBYGE-MALI.HellSessionMonitor", "lstSessionId: %s", new Object[] { paramString });
              if (localObject1 != null) {
                ad.w("HABBYGE-MALI.HellSessionMonitor", "lstSession: %s", new Object[] { ((bxx)localObject1).sessionId });
              }
              ((bxx)localObject2).startTime = paramLong;
              ((bxx)localObject2).endTime = paramLong;
              ((bxx)localObject2).DUq = "FloatBall";
              ((bxx)localObject2).gXt = 1;
              com.tencent.mm.plugin.expt.hellhound.a.f.c.c.i((bxx)localObject2);
              a((bxx)localObject2, paramLong);
              AppMethodBeat.o(122059);
              return;
            }
          }
        }
        ((bxx)localObject2).DUu = false;
        ((bxx)localObject2).gXt = 0;
        ((bxx)localObject2).startTime = paramLong;
        localObject1 = l.ccJ();
        paramString = (String)localObject1;
        if (localObject1 == null) {
          paramString = "";
        }
        ((bxx)localObject2).DUm = paramString;
        if ("142".equals(str))
        {
          ad.i("HABBYGE-MALI.HellSessionMonitor", "launcherUIOn7Event, addPageFlow: StoryGalleryView");
          com.tencent.mm.plugin.expt.hellhound.a.f.d.b.b((bxx)localObject2, "StoryGalleryView", paramLong);
        }
        for (;;)
        {
          com.tencent.mm.plugin.expt.hellhound.a.f.c.c.i((bxx)localObject2);
          a((bxx)localObject2);
          ad.i("HABBYGE-MALI.HellSessionMonitor", "_launcherUIOn7Event, curSession: %s, %s, %s, %d", new Object[] { ((bxx)localObject2).sessionId, ((bxx)localObject2).DUq, ((bxx)localObject2).DUt, Integer.valueOf(((bxx)localObject2).DUr) });
          AppMethodBeat.o(122059);
          return;
          ad.i("HABBYGE-MALI.HellSessionMonitor", "launcherUIOn7Event, addPageFlow: ChattingUIFragment");
          com.tencent.mm.plugin.expt.hellhound.a.f.d.b.b((bxx)localObject2, com.tencent.mm.plugin.expt.hellhound.core.b.pDY, paramLong);
        }
      }
    }
    else {
      ad.i("HABBYGE-MALI.HellSessionMonitor", "_launcherUIOn7Event, no Session: %s", new Object[] { paramString });
    }
    AppMethodBeat.o(122059);
  }
  
  private void ae(String paramString, long paramLong)
  {
    AppMethodBeat.i(122060);
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cdh();
    if (localObject != null)
    {
      ((bxx)localObject).DUu = true;
      ((bxx)localObject).endTime = paramLong;
      ad.i("HABBYGE-MALI.HellSessionMonitor", "launcherUIOn8Event, curSession: %s, %s", new Object[] { ((bxx)localObject).sessionId, paramString });
      bge localbge = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cdm();
      if (localbge == null)
      {
        AppMethodBeat.o(122060);
        return;
      }
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.al(paramString, paramLong);
      localbge.DDS = paramLong;
      com.tencent.mm.plugin.expt.hellhound.a.f.c.c.b(localbge);
      a((bxx)localObject, paramLong);
      c((bxx)localObject);
      a((bxx)localObject, paramString);
      AppMethodBeat.o(122060);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.cbG();
    localObject = com.tencent.mm.plugin.expt.hellhound.core.stack.g.VQ(paramString);
    if (localObject != null)
    {
      ad.i("HABBYGE-MALI.HellSessionMonitor", "_launcherUIOn8Event, curAR: %s, %s, %s, %s", new Object[] { ((bh)localObject).CvH.activityName, ((bh)localObject).CvK, ((bh)localObject).CvI, ((bh)localObject).CvJ });
      if (!TextUtils.isEmpty(((bh)localObject).CvI)) {
        break label229;
      }
    }
    label229:
    for (paramString = ((bh)localObject).CvH.activityName;; paramString = ((bh)localObject).CvI)
    {
      localObject = paramString;
      if (!TextUtils.isEmpty(paramString)) {
        localObject = com.tencent.mm.plugin.expt.hellhound.core.b.Vy(paramString);
      }
      ai((String)localObject, paramLong);
      paramString = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cdm();
      if (paramString != null) {
        break;
      }
      AppMethodBeat.o(122060);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.d.b.al((String)localObject, paramLong);
    paramString.DDS = paramLong;
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.b(paramString);
    c(null);
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.reset();
    ad.i("HABBYGE-MALI.HellSessionMonitor", "_launcherUIOn8Event, 无Session: %s", new Object[] { localObject });
    AppMethodBeat.o(122060);
  }
  
  private void af(String paramString, long paramLong)
  {
    AppMethodBeat.i(122062);
    Object localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cdm();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new bge();
    }
    ((bge)localObject1).DDR = paramLong;
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.b((bge)localObject1);
    bxx localbxx = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cdh();
    if (localbxx != null)
    {
      if (localbxx.DUu)
      {
        if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.WB(localbxx.sessionId))
        {
          localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c.cdD();
          if (localObject1 != null)
          {
            localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.Vy(paramString);
            ad.w("HABBYGE-MALI.HellSessionMonitor", "lstItem: %s, %s, %s", new Object[] { ((bgc)localObject1).dpw, ((bgc)localObject1).DDP, localObject2 });
            if ((com.tencent.mm.plugin.expt.hellhound.a.f.b.b.WB(((bgc)localObject1).dpw)) && ((((bgc)localObject1).DDP.equals("FloatBall")) || (com.tencent.mm.plugin.expt.hellhound.core.b.VD(((bgc)localObject1).DDP)) || ((((bgc)localObject1).DDP.equals(localObject2)) && (!((String)localObject2).equals("WebViewUI")))))
            {
              localbxx.startTime = paramLong;
              localbxx.endTime = paramLong;
              localbxx.DUq = "FloatBall";
              localbxx.gXt = 1;
              com.tencent.mm.plugin.expt.hellhound.a.f.c.c.i(localbxx);
              a(localbxx, paramLong);
              AppMethodBeat.o(122062);
              return;
            }
          }
        }
        localbxx.DUu = false;
        localbxx.gXt = 0;
        localbxx.startTime = paramLong;
        localObject2 = l.ccJ();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
        localbxx.DUm = ((String)localObject1);
        ad.i("HABBYGE-MALI.HellSessionMonitor", "activityOn7Event, curSession: %s, %s", new Object[] { localbxx.DUq, paramString });
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.b(localbxx, paramString, paramLong);
        com.tencent.mm.plugin.expt.hellhound.a.f.c.c.i(localbxx);
        a(localbxx);
        ad.i("HABBYGE-MALI.HellSessionMonitor", "_activityOn7Event, curSession: %s, %s, %s, %d", new Object[] { localbxx.sessionId, localbxx.DUq, localbxx.DUt, Integer.valueOf(localbxx.DUr) });
        AppMethodBeat.o(122062);
      }
    }
    else
    {
      ad.i("HABBYGE-MALI.HellSessionMonitor", "_activityOn7Event, 无Session: %s", new Object[] { paramString });
      paramString = com.tencent.mm.plugin.expt.hellhound.core.b.Vy(paramString);
      if (!"LauncherUI".equals(paramString))
      {
        ah(paramString, paramLong);
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.b(null, paramString, paramLong);
      }
    }
    AppMethodBeat.o(122062);
  }
  
  private void ag(String paramString, long paramLong)
  {
    AppMethodBeat.i(122063);
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cdh();
    Object localObject2;
    if (localObject1 != null)
    {
      ((bxx)localObject1).DUu = true;
      ((bxx)localObject1).endTime = paramLong;
      localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cdm();
      if (localObject2 == null)
      {
        AppMethodBeat.o(122063);
        return;
      }
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.al(paramString, paramLong);
      ((bge)localObject2).DDS = paramLong;
      com.tencent.mm.plugin.expt.hellhound.a.f.c.c.b((bge)localObject2);
      a((bxx)localObject1, paramLong);
      c((bxx)localObject1);
      ad.i("HABBYGE-MALI.HellSessionMonitor", "_activityOn8Event: %s, %s", new Object[] { ((bxx)localObject1).sessionId, ((bxx)localObject1).DUq });
      a((bxx)localObject1, paramString);
      AppMethodBeat.o(122063);
      return;
    }
    if (paramString == null)
    {
      AppMethodBeat.o(122063);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.cbG();
    localObject1 = com.tencent.mm.plugin.expt.hellhound.core.stack.g.VQ(paramString);
    if (localObject1 != null)
    {
      ad.i("HABBYGE-MALI.HellSessionMonitor", "_activityOn8Event, curAR: %s, %s, %s, %s", new Object[] { ((bh)localObject1).CvH.activityName, ((bh)localObject1).CvK, ((bh)localObject1).CvI, ((bh)localObject1).CvJ });
      if (TextUtils.isEmpty(((bh)localObject1).CvI)) {
        localObject1 = ((bh)localObject1).CvH.activityName;
      }
    }
    for (;;)
    {
      localObject2 = localObject1;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.Vy((String)localObject1);
      }
      ai((String)localObject2, paramLong);
      localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cdm();
      if (localObject1 != null) {
        break;
      }
      AppMethodBeat.o(122063);
      return;
      localObject1 = ((bh)localObject1).CvI;
      continue;
      localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.Vy(paramString);
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.d.b.al(paramString, paramLong);
    ((bge)localObject1).DDS = paramLong;
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.b((bge)localObject1);
    c(null);
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.reset();
    ad.i("HABBYGE-MALI.HellSessionMonitor", "_activityOn8Event, 无Session: %s", new Object[] { localObject2 });
    AppMethodBeat.o(122063);
  }
  
  public static void ai(String paramString, long paramLong)
  {
    AppMethodBeat.i(184367);
    bxt localbxt = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cdk();
    if (localbxt == null)
    {
      AppMethodBeat.o(184367);
      return;
    }
    localbxt.endTime = paramLong;
    ad.i("HABBYGE-MALI.HellSessionMonitor", "onSessionClose, unknow: %s, %s, %s, %s", new Object[] { paramString, localbxt.DDP, Long.valueOf(localbxt.startTime), Long.valueOf(localbxt.endTime) });
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.b(localbxt);
    AppMethodBeat.o(184367);
  }
  
  private void aj(String paramString, long paramLong)
  {
    AppMethodBeat.i(190897);
    if (com.tencent.mm.plugin.expt.hellhound.core.b.a.a.cbN() == 8)
    {
      ad.w("HABBYGE-MALI.HellSessionMonitor", "hellSessionMonitor, restoreLastSession 8Event!!");
      this.pHn = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.WP(paramString);
      AppMethodBeat.o(190897);
      return;
    }
    ad.i("HABBYGE-MALI.HellSessionMonitor", "hellSessionMonitor, restoreLastSession: %s", new Object[] { paramString });
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.WP(paramString);
    paramString = (String)localObject;
    if (localObject == null)
    {
      if (this.pHn != null)
      {
        ad.i("HABBYGE-MALI.HellSessionMonitor", "hellSessionMonitor, mLastSession4Nested: %s", new Object[] { this.pHn.sessionId });
        paramString = this.pHn;
      }
    }
    else
    {
      paramString.gXt = 0;
      paramString.DUw = false;
      paramString.startTime = paramLong;
      paramString.endTime = 0L;
      localObject = com.tencent.mm.plugin.expt.hellhound.core.b.Vy(paramString.DUq);
      if ((localObject != null) && (!((String)localObject).equals("LauncherUI"))) {
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.b(paramString, (String)localObject, paramLong);
      }
      String str = l.ccJ();
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      paramString.DUm = ((String)localObject);
      com.tencent.mm.plugin.expt.hellhound.a.f.c.c.h(paramString);
      a(paramString);
      AppMethodBeat.o(190897);
      return;
    }
    ad.e("HABBYGE-MALI.HellSessionMonitor", "hellSessionMonitor, restoreLastSession: LastSession NULL !!");
    AppMethodBeat.o(190897);
  }
  
  private static com.tencent.mm.vending.j.c<String, String> b(bh parambh1, int paramInt, bh parambh2)
  {
    AppMethodBeat.i(122081);
    if (parambh1 == null)
    {
      AppMethodBeat.o(122081);
      return null;
    }
    String str3 = com.tencent.mm.plugin.expt.hellhound.core.b.Vy(parambh1.CvH.activityName);
    String str1;
    if (paramInt == 4)
    {
      String str2 = com.tencent.mm.plugin.expt.hellhound.core.b.Vy(parambh1.CvI);
      str1 = str2;
      if (TextUtils.isEmpty(parambh1.CvJ)) {
        break label138;
      }
      str1 = str2;
      if (parambh2 == null) {
        break label138;
      }
      str1 = str2;
      if (TextUtils.isEmpty(parambh2.CvJ)) {
        break label138;
      }
      parambh1 = com.tencent.mm.plugin.expt.hellhound.core.b.Vy(parambh2.CvJ);
      str1 = str2;
    }
    for (;;)
    {
      if (parambh1 == null) {
        parambh1 = str3;
      }
      for (;;)
      {
        parambh1 = com.tencent.mm.vending.j.a.L(str1, parambh1);
        AppMethodBeat.o(122081);
        return parambh1;
        if (paramInt != 5) {
          break label146;
        }
        str1 = com.tencent.mm.plugin.expt.hellhound.core.b.Vy(parambh1.CvJ);
        ad.i("HABBYGE-MALI.HellSessionMonitor", "_getCurLastFragment, EVENT_FRAGMENT_OUT: %s", new Object[] { str1 });
        label138:
        parambh1 = null;
        break;
      }
      label146:
      parambh1 = null;
      str1 = null;
    }
  }
  
  private static void b(bxx parambxx)
  {
    AppMethodBeat.i(122083);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.f.b.b.WB(parambxx.sessionId)) && (!com.tencent.mm.plugin.expt.hellhound.a.f.b.b.WC(parambxx.sessionId))) {
      com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.l(parambxx);
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.g.a.b.m(com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cdj());
    AppMethodBeat.o(122083);
  }
  
  public static void b(boolean paramBoolean, String paramString, long paramLong)
  {
    AppMethodBeat.i(184371);
    Object localObject;
    if (paramBoolean)
    {
      localObject = com.tencent.mm.plugin.expt.hellhound.core.b.Vy(paramString);
      if (("AppBrandLaunchProxyUI".equals(localObject)) || ("AppBrandPreLoadingUI".equals(localObject)))
      {
        AppMethodBeat.o(184371);
        return;
      }
    }
    ad.w("HABBYGE-MALI.HellSessionMonitor", "onFloatSessionExit: %b, %s", new Object[] { Boolean.valueOf(paramBoolean), paramString });
    com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c.kg(false);
    paramString = com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c.cdG();
    if (paramString != null)
    {
      int j = ((Integer)paramString.first).intValue();
      int k = ((Integer)paramString.second).intValue();
      ad.i("FloatBallSessionHandler", "HABBYGE-MALI, onFloatSessionExit, finish: %b, %d, %d", new Object[] { Boolean.valueOf(paramBoolean), Integer.valueOf(j), Integer.valueOf(k) });
      if ((j == 2) && (k != 3) && (k != 4))
      {
        ad.w("FloatBallSessionHandler", "HABBYGE-MALI, FoatBall, onFloatSessionExit: onFloatMenuItemClicked");
        AppMethodBeat.o(184371);
        return;
      }
      paramString = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cdh();
      if (paramString == null)
      {
        ad.w("FloatBallSessionHandler", "HABBYGE-MALI, onFloatSessionExit, curSession == null");
        AppMethodBeat.o(184371);
        return;
      }
      if (paramBoolean)
      {
        localObject = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.Wv(paramString.sessionId);
        if ((localObject == null) || (!((String)localObject).equals("145")))
        {
          ad.w("FloatBallSessionHandler", "HABBYGE-MALI, onFloatSessionExit, sid: %s, %s", new Object[] { localObject, paramString.sessionId });
          AppMethodBeat.o(184371);
          return;
        }
        localObject = com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c.cdH();
        if (localObject == null) {}
        for (int i = -1;; i = ((alz)localObject).type)
        {
          if ((i == 3) || (i == 4))
          {
            ad.i("FloatBallSessionHandler", "HABBYGE-MALI, FloatBall, state, read %d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c.cdF()) });
            if (com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c.cdF() == 8) {
              com.tencent.mm.plugin.expt.hellhound.a.f.g.a.a.a(paramString, true, j, k, paramLong);
            }
          }
          AppMethodBeat.o(184371);
          return;
        }
      }
      com.tencent.mm.plugin.expt.hellhound.a.f.g.a.a.a(paramString, false, j, k, paramLong);
    }
    AppMethodBeat.o(184371);
  }
  
  private static void c(bxx parambxx)
  {
    AppMethodBeat.i(177388);
    if (parambxx == null) {}
    for (Object localObject = "NULL";; localObject = parambxx.sessionId)
    {
      ad.i("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, report: %s", new Object[] { localObject });
      localObject = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cdm();
      if (localObject != null) {
        break;
      }
      AppMethodBeat.o(177388);
      return;
    }
    bgb localbgb = com.tencent.mm.plugin.expt.hellhound.a.f.d.a.cdz();
    com.tencent.mm.plugin.expt.hellhound.a.f.b.b.a((bge)localObject);
    i.c((bge)localObject, localbgb, parambxx);
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cdg();
    com.tencent.mm.plugin.expt.hellhound.a.f.d.a.reset();
    AppMethodBeat.o(177388);
  }
  
  public static b ccH()
  {
    AppMethodBeat.i(122044);
    if (pHg == null) {}
    try
    {
      if (pHg == null) {
        pHg = new b();
      }
      b localb = pHg;
      AppMethodBeat.o(122044);
      return localb;
    }
    finally
    {
      AppMethodBeat.o(122044);
    }
  }
  
  public static void ccI()
  {
    AppMethodBeat.i(122055);
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ccP())
    {
      ad.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, handleMMProcessRestart: FALSE");
      AppMethodBeat.o(122055);
      return;
    }
    ad.i("HABBYGE-MALI.HellSessionMonitor", "handleMMProcessRestart");
    bge localbge = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cdm();
    if (localbge == null)
    {
      AppMethodBeat.o(122055);
      return;
    }
    if ((localbge.DDV.isEmpty()) && (localbge.DDT.isEmpty()))
    {
      AppMethodBeat.o(122055);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.reset();
    bgb localbgb = com.tencent.mm.plugin.expt.hellhound.a.f.d.a.cdz();
    if (localbgb.DDO.isEmpty())
    {
      AppMethodBeat.o(122055);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.d.a.reset();
    ad.i("HellSessionReport", "HABBYGE-MALI, reportWhenMMProcessRestart BEGIN !!");
    ad.i("HellSessionReportProcessRestart", "HABBYGE-MALI, HellSessionReportProcessRestart.report()");
    com.tencent.mm.plugin.expt.hellhound.a.f.f.j.a(localbgb, localbge, true);
    bgc localbgc = (bgc)localbgb.DDO.getLast();
    if (localbge.DDS <= 0L) {
      localbge.DDS = localbgc.startTime;
    }
    Iterator localIterator = localbge.DDT.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (bxx)localIterator.next();
      if (((bxx)localObject).endTime <= 0L) {
        ((bxx)localObject).endTime = localbgc.startTime;
      }
    }
    localIterator = localbge.DDV.iterator();
    while (localIterator.hasNext())
    {
      localObject = (bxt)localIterator.next();
      if (((bxt)localObject).endTime <= 0L) {
        ((bxt)localObject).endTime = localbgc.startTime;
      }
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.f.j.a(localbge, (bgc)localbgb.DDO.getFirst());
    localbgb.DDO.removeLast();
    com.tencent.mm.plugin.expt.hellhound.a.f.f.j.d(localbge, localbgb, null);
    AppMethodBeat.o(122055);
  }
  
  public static Pair<String, String> ccK()
  {
    AppMethodBeat.i(190895);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.cbn()) || (!com.tencent.mm.plugin.expt.hellhound.a.cbp()) || (com.tencent.mm.plugin.expt.hellhound.core.b.getUin() == 0))
    {
      AppMethodBeat.o(190895);
      return null;
    }
    Object localObject3 = l.cdx();
    if ((localObject3 == null) || (((cqv)localObject3).DDT.isEmpty()))
    {
      localObject3 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cdm();
      if (localObject3 == null)
      {
        AppMethodBeat.o(190895);
        return null;
      }
      i = ((bge)localObject3).DDT.size();
      if (i <= 0)
      {
        localObject1 = a(null, null, (bge)localObject3);
        AppMethodBeat.o(190895);
        return localObject1;
      }
      if (i < 2)
      {
        localObject1 = a((bxx)((bge)localObject3).DDT.getLast(), null, (bge)localObject3);
        AppMethodBeat.o(190895);
        return localObject1;
      }
      if (i == 2)
      {
        bxx localbxx = (bxx)((bge)localObject3).DDT.getLast();
        localObject2 = (bxx)((bge)localObject3).DDT.get(0);
        localObject1 = localObject2;
        if (localbxx.sessionId.equals(((bxx)localObject2).sessionId)) {
          localObject1 = null;
        }
        localObject1 = a(localbxx, (bxx)localObject1, (bge)localObject3);
        AppMethodBeat.o(190895);
        return localObject1;
      }
      localObject1 = (bxx)((bge)localObject3).DDT.getLast();
      i -= 2;
      while (i >= 0)
      {
        localObject2 = (bxx)((bge)localObject3).DDT.get(i);
        if (!((bxx)localObject1).sessionId.equals(((bxx)localObject2).sessionId))
        {
          localObject1 = a((bxx)localObject1, (bxx)localObject2, (bge)localObject3);
          AppMethodBeat.o(190895);
          return localObject1;
        }
        i -= 1;
      }
      localObject1 = a((bxx)localObject1, null, (bge)localObject3);
      AppMethodBeat.o(190895);
      return localObject1;
    }
    int i = ((cqv)localObject3).DDT.size();
    if (i < 2)
    {
      localObject1 = Pair.create(((cqv)localObject3).DDT.getLast(), ((cqv)localObject3).DDT.getLast());
      AppMethodBeat.o(190895);
      return localObject1;
    }
    if (i == 2)
    {
      localObject1 = Pair.create(((cqv)localObject3).DDT.getLast(), ((cqv)localObject3).DDT.get(i - 2));
      AppMethodBeat.o(190895);
      return localObject1;
    }
    Object localObject2 = (String)((cqv)localObject3).DDT.getLast();
    i -= 2;
    Object localObject1 = localObject2;
    while (i >= 0)
    {
      localObject1 = (String)((cqv)localObject3).DDT.get(i);
      if (!((String)localObject2).equals(localObject1))
      {
        localObject1 = Pair.create(localObject2, localObject1);
        AppMethodBeat.o(190895);
        return localObject1;
      }
      i -= 1;
    }
    localObject1 = Pair.create(localObject2, localObject1);
    AppMethodBeat.o(190895);
    return localObject1;
  }
  
  private void d(bxx parambxx)
  {
    if (parambxx == null) {
      return;
    }
    this.pHn = parambxx;
  }
  
  private void d(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(122058);
    ad.i("HABBYGE-MALI.HellSessionMonitor", "_launcherUIOnFrontBack, pageName: %s", new Object[] { paramString });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(122058);
      return;
      this.pHk = 7;
      ad(paramString, paramLong);
      AppMethodBeat.o(122058);
      return;
      this.pHk = 8;
      ae(paramString, paramLong);
    }
  }
  
  private static String e(bh parambh1, bh parambh2)
  {
    AppMethodBeat.i(184369);
    bh localbh = null;
    if ((parambh1 != null) && (!TextUtils.isEmpty(parambh1.CvJ)))
    {
      ad.i("HABBYGE-MALI.HellSessionMonitor", "getLastPageName, curAR.lastPageName: %s", new Object[] { parambh1.CvJ });
      parambh1 = parambh1.CvJ;
      AppMethodBeat.o(184369);
      return parambh1;
    }
    parambh1 = localbh;
    if (parambh2 != null)
    {
      if (TextUtils.isEmpty(parambh2.CvI)) {
        break label109;
      }
      parambh1 = com.tencent.mm.plugin.expt.hellhound.core.b.Vy(parambh2.CvI);
    }
    while (!TextUtils.isEmpty(parambh1))
    {
      ad.i("HABBYGE-MALI.HellSessionMonitor", "getLastPageName, lnARA, lastPageName: %s", new Object[] { parambh1 });
      AppMethodBeat.o(184369);
      return parambh1;
      label109:
      parambh1 = localbh;
      if (!TextUtils.isEmpty(parambh2.CvJ)) {
        parambh1 = com.tencent.mm.plugin.expt.hellhound.core.b.Vy(parambh2.CvI);
      }
    }
    parambh1 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.c.cbS().pEO.cbQ();
    ad.i("HABBYGE-MALI.HellSessionMonitor", "getLastPageName, lastPageName-1: %s", new Object[] { parambh1 });
    if (com.tencent.mm.plugin.expt.hellhound.core.b.Vt(parambh1))
    {
      com.tencent.mm.plugin.expt.hellhound.core.stack.d.cbG();
      localbh = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cbL();
      if (localbh != null)
      {
        parambh2 = com.tencent.mm.plugin.expt.hellhound.core.b.Vy(localbh.CvI);
        ad.i("HABBYGE-MALI.HellSessionMonitor", "getLastPageName, lastPageName-2: %s", new Object[] { parambh2 });
        parambh1 = parambh2;
        if (TextUtils.isEmpty(parambh2))
        {
          parambh1 = com.tencent.mm.plugin.expt.hellhound.core.b.Vy(localbh.CvJ);
          ad.i("HABBYGE-MALI.HellSessionMonitor", "activityIn, lastPageName-3: %s", new Object[] { parambh1 });
        }
      }
    }
    for (;;)
    {
      ad.i("HABBYGE-MALI.HellSessionMonitor", "getLastPageName, lastPageName: %s", new Object[] { parambh1 });
      if (!TextUtils.isEmpty(parambh1)) {
        break;
      }
      parambh1 = com.tencent.mm.plugin.expt.hellhound.core.b.pDZ;
      AppMethodBeat.o(184369);
      return parambh1;
      parambh1 = com.tencent.mm.plugin.expt.hellhound.core.b.Vy(parambh1);
    }
    AppMethodBeat.o(184369);
    return parambh1;
  }
  
  public static void e(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(122053);
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ccP())
    {
      ad.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, catchParamsOnActivityAsync: FALSE");
      AppMethodBeat.o(122053);
      return;
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.e.a.f(paramActivity, paramInt);
    com.tencent.mm.plugin.expt.hellhound.a.f.e.c.f(paramActivity, paramInt);
    AppMethodBeat.o(122053);
  }
  
  private void e(String paramString, int paramInt, long paramLong)
  {
    AppMethodBeat.i(122061);
    ad.i("HABBYGE-MALI.HellSessionMonitor", "activityOnFrontBack: %s, %d", new Object[] { paramString, Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(122061);
      return;
      af(paramString, paramLong);
      AppMethodBeat.o(122061);
      return;
      ag(paramString, paramLong);
    }
  }
  
  private static void n(bxx parambxx)
  {
    AppMethodBeat.i(205456);
    if (parambxx.sessionId.startsWith("143"))
    {
      com.tencent.mm.plugin.expt.hellhound.a.b.c.b localb = new com.tencent.mm.plugin.expt.hellhound.a.b.c.b((byte)0);
      localb.sessionId = com.tencent.mm.plugin.expt.hellhound.a.f.a.c.ccM().cbk();
      localb.DDP = "All";
      localb.KHU = parambxx.startTime;
      localb.KHV = parambxx.endTime;
      localb.xBr = (parambxx.endTime - parambxx.startTime);
      localb.KHW = com.tencent.mm.plugin.expt.hellhound.core.b.fRm();
      localb.pZX = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.Wv(parambxx.sessionId);
      localb.dvJ = c.b.KGO.value;
      com.tencent.mm.plugin.expt.hellhound.a.b.c.a.a(localb);
    }
    AppMethodBeat.o(205456);
  }
  
  private void pk(long paramLong)
  {
    AppMethodBeat.i(122056);
    ad.i("HABBYGE-MALI.HellSessionMonitor", "openStoryGalleryView");
    bxx localbxx = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cdh();
    if (localbxx == null)
    {
      localbxx = a(null, "MoreTabUI", "StoryGalleryView", paramLong);
      if (localbxx == null)
      {
        ad.e("HABBYGE-MALI.HellSessionMonitor", "openStoryGalleryView, 不是合法session ~~~");
        AppMethodBeat.o(122056);
        return;
      }
    }
    for (int i = 1;; i = 0)
    {
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.b(localbxx, "StoryGalleryView", paramLong);
      if (i == 0) {
        break;
      }
      localbxx.gXt = 0;
      String str2 = l.ccJ();
      String str1 = str2;
      if (str2 == null) {
        str1 = "";
      }
      localbxx.DUm = str1;
      com.tencent.mm.plugin.expt.hellhound.a.f.c.c.h(localbxx);
      a(localbxx);
      AppMethodBeat.o(122056);
      return;
      ad.i("HABBYGE-MALI.HellSessionMonitor", "openStoryGalleryView, curSession: %s", new Object[] { localbxx.sessionId });
    }
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.i(localbxx);
    AppMethodBeat.o(122056);
  }
  
  private void pl(long paramLong)
  {
    AppMethodBeat.i(122057);
    bxx localbxx = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cdh();
    if (localbxx == null)
    {
      ad.e("HABBYGE-MALI.HellSessionMonitor", "closeStoryGalleryView, 不是合法session !!!");
      AppMethodBeat.o(122057);
      return;
    }
    ad.i("HABBYGE-MALI.HellSessionMonitor", "closeStoryGalleryView, curSession: %s", new Object[] { localbxx.sessionId });
    if ("142".equals(com.tencent.mm.plugin.expt.hellhound.a.f.b.b.Wv(localbxx.sessionId)))
    {
      a(localbxx, paramLong);
      AppMethodBeat.o(122057);
      return;
    }
    if (!"StoryGalleryView".equals(localbxx.DUq))
    {
      ad.i("HABBYGE-MALI.HellSessionMonitor", "curActivity: %s IS NOT curSession: %s startPage: %s", new Object[] { "StoryGalleryView", localbxx.sessionId, localbxx.DUq });
      com.tencent.mm.plugin.expt.hellhound.a.f.c.c.i(localbxx);
    }
    AppMethodBeat.o(122057);
  }
  
  private void pm(long paramLong)
  {
    AppMethodBeat.i(122073);
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cdh();
    if (localObject1 == null)
    {
      localObject1 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.Bq(100);
      localObject2 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.Bq(101);
      String str1 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.Bq(102);
      String str2 = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.e.Bq(104);
      if ((com.tencent.mm.plugin.expt.hellhound.core.b.Vv((String)localObject1)) && (com.tencent.mm.plugin.expt.hellhound.core.b.Vs((String)localObject2)) && (com.tencent.mm.plugin.expt.hellhound.core.b.Vv(str1)) && (com.tencent.mm.plugin.expt.hellhound.core.b.Vs(str2)))
      {
        pn(paramLong);
        AppMethodBeat.o(122073);
        return;
      }
      ad.e("HABBYGE-MALI.HellSessionMonitor", "chattingUIIn, 不是合法session !!!");
      AppMethodBeat.o(122073);
      return;
    }
    Object localObject2 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.Wv(((bxx)localObject1).sessionId);
    ad.i("HABBYGE-MALI.HellSessionMonitor", "chattingUIIn, curSessionId: %s", new Object[] { localObject2 });
    if (!com.tencent.mm.plugin.expt.hellhound.a.f.b.b.WD((String)localObject2))
    {
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.b((bxx)localObject1, "com.tencent.mm.ui.chatting.ChattingUI", paramLong);
      AppMethodBeat.o(122073);
      return;
    }
    localObject2 = a.ccF();
    ad.i("HABBYGE-MALI.HellSessionMonitor", "chattingUIIn, userName: %s", new Object[] { (String)((com.tencent.mm.vending.j.b)localObject2).get(0) });
    int i = ((Integer)((com.tencent.mm.vending.j.c)localObject2).get(1)).intValue();
    ad.i("HABBYGE-MALI.HellSessionMonitor", "chattingUIIn, newChattingType: %d", new Object[] { Integer.valueOf(i) });
    if (i == ((bxx)localObject1).DUr)
    {
      ad.i("HABBYGE-MALI.HellSessionMonitor", "chattingUIIn, newChattingType same !!!");
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.b((bxx)localObject1, "com.tencent.mm.ui.chatting.ChattingUI", paramLong);
      AppMethodBeat.o(122073);
      return;
    }
    ad.i("HABBYGE-MALI.HellSessionMonitor", "chattingUIIn, newChattingType difference !!!");
    a((bxx)localObject1, paramLong);
    pn(paramLong);
    AppMethodBeat.o(122073);
  }
  
  private void pn(long paramLong)
  {
    AppMethodBeat.i(122075);
    ad.i("HABBYGE-MALI.HellSessionMonitor", "newChattingUISession");
    bxx localbxx = a(null, com.tencent.mm.plugin.expt.hellhound.core.b.pDZ, "ChattingUI", paramLong);
    if (localbxx == null)
    {
      ad.e("HABBYGE-MALI.HellSessionMonitor", "_doChattingUIInContinue, 不是合法session ~~~");
      AppMethodBeat.o(122075);
      return;
    }
    String str2 = l.ccJ();
    String str1 = str2;
    if (str2 == null) {
      str1 = "";
    }
    localbxx.DUm = str1;
    com.tencent.mm.plugin.expt.hellhound.a.f.d.b.b(localbxx, "com.tencent.mm.ui.chatting.ChattingUI", paramLong);
    localbxx.gXt = 0;
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.h(localbxx);
    a(localbxx);
    AppMethodBeat.o(122075);
  }
  
  private void po(long paramLong)
  {
    AppMethodBeat.i(122079);
    bxx localbxx = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cdh();
    if (localbxx == null)
    {
      ad.e("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionClose, curSession不合法");
      AppMethodBeat.o(122079);
      return;
    }
    com.tencent.mm.vending.j.c localc = a.ccG();
    String str = (String)localc.get(0);
    int i = ((Integer)localc.get(1)).intValue();
    ad.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionClose: %s, %d", new Object[] { str, Integer.valueOf(i) });
    if (i == localbxx.DUr)
    {
      ad.i("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionClose, ==");
      a(localbxx, paramLong);
      AppMethodBeat.o(122079);
      return;
    }
    ad.e("HABBYGE-MALI.HellSessionMonitor", "chatUIFragmentSessionClose, != %d", new Object[] { Integer.valueOf(localbxx.DUr) });
    AppMethodBeat.o(122079);
  }
  
  public static void r(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(122046);
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ccP())
    {
      ad.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, notifyToBizEnter: FALSE");
      AppMethodBeat.o(122046);
      return;
    }
    if (!com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ccQ())
    {
      ad.i("HellBizSessionHandler", "HABBYGE-MALI, whenChattingUIFragmentEnter, NOT 104-Biz Session !!");
      AppMethodBeat.o(122046);
      return;
    }
    if ("Biz".equals(paramString1))
    {
      ad.i("HellBizSessionHandler", "habbyge-mali, whenChattingUIFragmentEnter: %s -> %s", new Object[] { paramString2, com.tencent.mm.plugin.expt.hellhound.core.b.pDY });
      if (!paramString2.contains("BizTimeLineUI")) {
        paramString2.contains("BizConversationUI");
      }
      com.tencent.mm.plugin.expt.hellhound.a.f.d.b.ak(com.tencent.mm.plugin.expt.hellhound.core.b.pDY, paramLong);
    }
    AppMethodBeat.o(122046);
  }
  
  public static void s(String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(122047);
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ccP())
    {
      ad.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, notifyToBizExit: FALSE");
      AppMethodBeat.o(122047);
      return;
    }
    if (!com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ccQ())
    {
      ad.i("HellBizSessionHandler", "HABBYGE-MALI, whenChattingUIFragmentExit, NOT 104-Biz Session !!");
      AppMethodBeat.o(122047);
      return;
    }
    if ("Biz".equals(paramString1))
    {
      ad.i("HellBizSessionHandler", "habbyge-mali, whenChattingUIFragmentExit: %s", new Object[] { paramString2 });
      if (paramString2.contains("BizTimeLineUI"))
      {
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.ak(paramString2, paramLong);
        AppMethodBeat.o(122047);
        return;
      }
      if (paramString2.contains("BizConversationUI")) {
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.ak(paramString2, paramLong);
      }
    }
    AppMethodBeat.o(122047);
  }
  
  public final bxx a(Activity paramActivity, String paramString1, String paramString2, long paramLong)
  {
    AppMethodBeat.i(122080);
    if (paramString2 == null)
    {
      ad.e("HABBYGE-MALI.HellSessionMonitor", "newSession: dstPageName is NULL");
      AppMethodBeat.o(122080);
      return null;
    }
    ad.i("HABBYGE-MALI.HellSessionMonitor", "newSession: srcPageName: %s, dstPageName: %s", new Object[] { paramString1, paramString2 });
    bkl localbkl = null;
    Object localObject2 = null;
    Object localObject1;
    if ("WebViewUI".equals(paramString2))
    {
      localbkl = new bkl();
      localbkl.key = "minimize_secene";
      localbkl.value = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.VY("minimize_secene");
      localObject2 = new bkl();
      ((bkl)localObject2).key = "KPublisherId";
      ((bkl)localObject2).value = com.tencent.mm.plugin.expt.hellhound.core.b.a.a.b.VY("KPublisherId");
      localObject1 = new ArrayList();
      ((List)localObject1).add(localbkl.value);
      ((List)localObject1).add(((bkl)localObject2).value);
      localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.a(paramActivity, paramString1, paramString2, (List)localObject1);
      ad.i("HABBYGE-MALI.HellSessionMonitor", "newSession(WebViewUI)sid = %s, %s", new Object[] { localObject1, Long.valueOf(paramLong) });
    }
    for (paramActivity = (Activity)localObject2; TextUtils.isEmpty((CharSequence)localObject1); paramActivity = (Activity)localObject2)
    {
      AppMethodBeat.o(122080);
      return null;
      localObject1 = com.tencent.mm.plugin.expt.hellhound.a.f.b.b.a(paramActivity, paramString1, paramString2, null);
      ad.i("HABBYGE-MALI.HellSessionMonitor", "newSession(no args)sid = %s, %s", new Object[] { localObject1, Long.valueOf(paramLong) });
    }
    localObject2 = new bxx();
    ((bxx)localObject2).sessionId = ((String)localObject1 + "_" + paramLong);
    ((bxx)localObject2).seq = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cdf();
    ((bxx)localObject2).DUq = paramString2;
    ((bxx)localObject2).DUt = paramString1;
    ((bxx)localObject2).startTime = paramLong;
    if ("WebViewUI".equals(((bxx)localObject2).DUq))
    {
      ((bxx)localObject2).DUs = new bxu();
      ((bxx)localObject2).DUs.DUn.add(localbkl);
      ((bxx)localObject2).DUs.DUn.add(paramActivity);
      ((bxx)localObject2).DUv = paramString2;
      ad.i("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, newSession: %s, %s", new Object[] { ((bxx)localObject2).sessionId, ((bxx)localObject2).DUv });
      this.pHj = ((bxx)localObject2).sessionId;
      AppMethodBeat.o(122080);
      return localObject2;
    }
    if ("ChattingUI".equals(((bxx)localObject2).DUq))
    {
      paramActivity = a.ccF();
      ((bxx)localObject2).userName = ((String)paramActivity.get(0));
      ((bxx)localObject2).DUr = ((Integer)paramActivity.get(1)).intValue();
    }
    for (;;)
    {
      com.tencent.mm.plugin.expt.hellhound.a.f.b.b.e((bxx)localObject2);
      ad.i("HABBYGE-MALI.HellSessionMonitor", "newSession, %s", new Object[] { ((bxx)localObject2).sessionId });
      break;
      if ("ChattingUIFragment".equals(((bxx)localObject2).DUq))
      {
        paramActivity = a.ccG();
        ((bxx)localObject2).userName = ((String)paramActivity.get(0));
        ((bxx)localObject2).DUr = ((Integer)paramActivity.get(1)).intValue();
      }
    }
  }
  
  public final void a(Activity paramActivity, bh parambh1, int paramInt, bh parambh2)
  {
    AppMethodBeat.i(122049);
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ccP())
    {
      ad.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, monitor, needSessionMonitor: FALSE");
      AppMethodBeat.o(122049);
      return;
    }
    if (parambh1 == null)
    {
      AppMethodBeat.o(122049);
      return;
    }
    ad.i("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor monitor: %s", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.pHl = -1;
      AppMethodBeat.o(122049);
      return;
      a(paramActivity, parambh1, parambh2, paramInt);
      ad.i("HABBYGE-MALI.HellSessionMonitor", "monitor, activity: %s, %d", new Object[] { parambh1.CvH.activityName, Integer.valueOf(paramInt) });
      continue;
      a(parambh1, paramInt, parambh2);
      ad.i("HABBYGE-MALI.HellSessionMonitor", "monitor, fragment: %s, %d", new Object[] { parambh1.CvI, Integer.valueOf(paramInt) });
      continue;
      a(paramInt, parambh2, parambh1.CvL);
      ad.i("HABBYGE-MALI.HellSessionMonitor", "monitor, session end: ChattingUIFragment");
    }
  }
  
  public final void a(bxx parambxx, long paramLong)
  {
    AppMethodBeat.i(122084);
    if (parambxx == null)
    {
      ad.e("HABBYGE-MALI.HellSessionMonitor", "HABBYGE-MLAI, onSessionClose, curSession == null");
      AppMethodBeat.o(122084);
      return;
    }
    if ((parambxx.DUu) && (parambxx.gXt == 1))
    {
      ad.i("HABBYGE-MALI.HellSessionMonitor", "onSessionClose: The Repeated sesson close Event: %s", new Object[] { parambxx.sessionId });
      com.tencent.mm.plugin.expt.hellhound.a.f.c.c.WQ(parambxx.sessionId);
      AppMethodBeat.o(122084);
      return;
    }
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.d.a.cdz();
    if (!((bgb)localObject).DDO.isEmpty())
    {
      localObject = (bgc)((bgb)localObject).DDO.getLast();
      if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.WB(((bgc)localObject).dpw)) {
        com.tencent.mm.plugin.expt.hellhound.a.f.g.a.c.b((bgc)localObject);
      }
    }
    parambxx.endTime = paramLong;
    parambxx.gXt = 1;
    com.tencent.mm.plugin.expt.hellhound.a.f.b.b.e(parambxx);
    ad.i("HABBYGE-MALI.HellSessionMonitor", "onSessionClose: %s, %s, %s, %b, %d", new Object[] { parambxx.sessionId, Long.valueOf(parambxx.startTime), Long.valueOf(parambxx.endTime), Boolean.valueOf(parambxx.DUu), Integer.valueOf(parambxx.gXt) });
    com.tencent.mm.plugin.expt.hellhound.a.d.a.pGO.a(parambxx.DUq, paramLong, com.tencent.mm.plugin.expt.hellhound.a.d.g.pGZ);
    com.tencent.mm.plugin.expt.hellhound.a.f.c.c.j(parambxx);
    if (parambxx.DUw) {
      aj(parambxx.sessionId, paramLong);
    }
    com.tencent.mm.plugin.expt.hellhound.a.e.a.ccD();
    n(parambxx);
    AppMethodBeat.o(122084);
  }
  
  public final void ah(String paramString, long paramLong)
  {
    AppMethodBeat.i(184366);
    if (TextUtils.isEmpty(paramString))
    {
      ad.e("HABBYGE-MALI.HellSessionMonitor", "addUnknownPage: page is NULL");
      AppMethodBeat.o(184366);
      return;
    }
    bxt localbxt = new bxt();
    localbxt.DDP = com.tencent.mm.plugin.expt.hellhound.core.b.Vy(paramString);
    if (this.pHl == 7)
    {
      localbxt.startTime = this.pHm;
      this.pHl = -1;
      localbxt.seq = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cdf();
      if (!"LauncherUI".equals(localbxt.DDP)) {
        break label232;
      }
      paramString = com.tencent.mm.plugin.expt.hellhound.core.b.b.g.VZ("com.tencent.mm.ui.LauncherUI");
      if (paramString != null) {
        localbxt.DDP = paramString.getClass().getSimpleName();
      }
    }
    for (;;)
    {
      String str = l.ccJ();
      paramString = str;
      if (str == null) {
        paramString = "";
      }
      localbxt.DUm = paramString;
      ad.i("HABBYGE-MALI.HellSessionMonitor", "onSessionStart, unknow: %s, %s, %s", new Object[] { localbxt.DDP, Long.valueOf(localbxt.startTime), localbxt.DUm });
      com.tencent.mm.plugin.expt.hellhound.a.f.c.c.a(localbxt);
      l.xe(localbxt.DDP + "_" + localbxt.startTime);
      AppMethodBeat.o(184366);
      return;
      localbxt.startTime = paramLong;
      break;
      label232:
      if (("FinderHomeUI".equals(localbxt.DDP)) || ("FinderConversationUI".equals(localbxt.DDP)))
      {
        paramString = com.tencent.mm.plugin.expt.hellhound.a.b.b.j.fRo();
        if (paramString != null) {
          localbxt.DDP = paramString.getClass().getSimpleName();
        }
      }
    }
  }
  
  public final String ccJ()
  {
    AppMethodBeat.i(122086);
    if ((!com.tencent.mm.plugin.expt.hellhound.a.cbn()) || (!com.tencent.mm.plugin.expt.hellhound.a.cbp()) || (com.tencent.mm.plugin.expt.hellhound.core.b.getUin() == 0))
    {
      AppMethodBeat.o(122086);
      return "-1";
    }
    Object localObject = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cdh();
    if (localObject != null)
    {
      localObject = ((bxx)localObject).sessionId;
      AppMethodBeat.o(122086);
      return localObject;
    }
    if (this.pHj == null)
    {
      AppMethodBeat.o(122086);
      return "-2";
    }
    localObject = this.pHj;
    AppMethodBeat.o(122086);
    return localObject;
  }
  
  public final void e(String paramString, long paramLong, int paramInt)
  {
    AppMethodBeat.i(184363);
    this.pHl = paramInt;
    this.pHm = paramLong;
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ccP())
    {
      ad.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, frontbackEvent, needSessionMonitor: FALSE");
      AppMethodBeat.o(184363);
      return;
    }
    ad.i("HABBYGE-MALI.HellSessionMonitor", "frontbackEvent: %s, %d, %s", new Object[] { paramString, Integer.valueOf(paramInt), Long.valueOf(this.pHm) });
    if (com.tencent.mm.plugin.expt.hellhound.core.b.Vt(paramString))
    {
      d(paramString, paramInt, this.pHm);
      AppMethodBeat.o(184363);
      return;
    }
    e(paramString, paramInt, this.pHm);
    AppMethodBeat.o(184363);
  }
  
  public final void h(int paramInt1, int paramInt2, long paramLong)
  {
    AppMethodBeat.i(184364);
    if (com.tencent.mm.plugin.expt.hellhound.a.f.b.b.ccP())
    {
      ad.w("HABBYGE-MALI.HellSessionMonitor", "HellSessionMonitor, monitorStorySession: FALSE");
      AppMethodBeat.o(184364);
      return;
    }
    switch (paramInt1)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(184364);
      return;
      switch (paramInt2)
      {
      case 1: 
      default: 
        AppMethodBeat.o(184364);
        return;
      case 2: 
        ad.i("HABBYGE-MALI.HellSessionMonitor", "monitorStoryGallery: IN, FROM_RESUME, Event-7, !!");
        AppMethodBeat.o(184364);
        return;
      }
      ad.i("HABBYGE-MALI.HellSessionMonitor", "monitorStoryGallery: IN, FROM_StoryGallery_SHOW");
      ai(com.tencent.mm.plugin.expt.hellhound.core.b.pDX, paramLong);
      ad.i("HABBYGE-MALI.HellSessionMonitor", "关闭(闭环)MoreTabUI无效页之后，再开启动态视频session");
      pk(paramLong);
      AppMethodBeat.o(184364);
      return;
      switch (paramInt2)
      {
      case 2: 
      default: 
        break;
      case 1: 
        ad.i("HABBYGE-MALI.HellSessionMonitor", "monitorStoryGallery: OUT, FROM_StoryGallery_GONE");
        pl(paramLong);
        ah(com.tencent.mm.plugin.expt.hellhound.core.b.pDX, paramLong);
        com.tencent.mm.plugin.expt.hellhound.a.f.d.b.b(null, com.tencent.mm.plugin.expt.hellhound.core.b.pEc, paramLong);
      }
    }
    ad.i("HABBYGE-MALI.HellSessionMonitor", "monitorStoryGallery: OUT, FROM_PAUSE Event-8, !!");
    com.tencent.mm.plugin.expt.hellhound.core.stack.d.cbG();
    Object localObject = com.tencent.mm.plugin.expt.hellhound.core.stack.e.cbL();
    if (localObject == null)
    {
      AppMethodBeat.o(184364);
      return;
    }
    if (((bh)localObject).CvH == null)
    {
      AppMethodBeat.o(184364);
      return;
    }
    localObject = com.tencent.mm.plugin.expt.hellhound.core.b.Vy(((bh)localObject).CvH.activityName);
    ad.i("HABBYGE-MALI.HellSessionMonitor", "monitorStoryGalleryViewSession, topActivity: %s", new Object[] { localObject });
    if ("StoryCaptureUI".equals(localObject))
    {
      localObject = com.tencent.mm.plugin.expt.hellhound.a.f.c.c.cdh();
      if (localObject == null)
      {
        AppMethodBeat.o(184364);
        return;
      }
      com.tencent.mm.plugin.expt.hellhound.a.f.c.c.i((bxx)localObject);
    }
    AppMethodBeat.o(184364);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.f.b
 * JD-Core Version:    0.7.0.1
 */
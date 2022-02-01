package com.tencent.mm.h;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.g.a.ap.a;
import com.tencent.mm.g.a.wi;
import com.tencent.mm.g.a.wi.a;
import com.tencent.mm.model.az;
import com.tencent.mm.plugin.account.ui.DisasterUI;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.bv;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class b
{
  public a fpC;
  public Map<Integer, Long> fpD;
  public Map<Long, a> fpE;
  public c fpF;
  
  public b()
  {
    AppMethodBeat.i(20099);
    this.fpD = new HashMap();
    this.fpE = new HashMap();
    this.fpF = new c() {};
    AppMethodBeat.o(20099);
  }
  
  final void Vl()
  {
    AppMethodBeat.i(20102);
    if ((this.fpC == null) || (this.fpC.fpM.get(Integer.valueOf(0)) == null) || (bs.isNullOrNil(this.fpC.fpL)))
    {
      AppMethodBeat.o(20102);
      return;
    }
    ac.i("MicroMsg.BroadcastController", "summerdize checkShowDisasterContent showDisasterContent[%s]", new Object[] { this.fpC.fpL });
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("key_disaster_content", this.fpC.fpL);
    ((Intent)localObject).putExtra("key_disaster_url", ((wi)this.fpC.fpM.get(Integer.valueOf(0))).dzi.url);
    ((Intent)localObject).setClass(ai.getContext(), DisasterUI.class).addFlags(268435456);
    Context localContext = ai.getContext();
    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/broadcast/BroadcastController", "checkShowDisasterContent", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/broadcast/BroadcastController", "checkShowDisasterContent", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    this.fpC.fpL = null;
    AppMethodBeat.o(20102);
  }
  
  final boolean a(com.tencent.mm.g.a.ap paramap)
  {
    AppMethodBeat.i(20100);
    String str = paramap.cZT.cZV;
    if (str == null) {}
    Map localMap;
    for (int i = -1;; i = str.length())
    {
      ac.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster xml len[%d]", new Object[] { Integer.valueOf(i) });
      localMap = bv.L(str, "e");
      if (localMap != null) {
        break;
      }
      ac.e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster this is not errmsg");
      AppMethodBeat.o(20100);
      return false;
    }
    ac.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster values[%s]", new Object[] { localMap });
    long l1 = bs.getLong((String)localMap.get(".e.NoticeId"), 0L);
    if (l1 <= 0L) {
      ac.e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster noticeID null");
    }
    if (!com.tencent.mm.platformtools.ab.iwQ) {
      try
      {
        long l2 = bs.getLong((String)localMap.get(".e.ExpiredTime"), 0L);
        if (bs.pN(l2) > 0L)
        {
          ac.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster expiredTime is too small, drop id:%d", new Object[] { Long.valueOf(l2) });
          AppMethodBeat.o(20100);
          return false;
        }
      }
      catch (Exception localException)
      {
        ac.i("MicroMsg.BroadcastController", "parseLong expiredTime error:%s", new Object[] { localException });
      }
    }
    Object localObject1 = new a();
    ((a)localObject1).fpJ = String.valueOf(l1);
    Object localObject2 = ai.getContext().getSharedPreferences("disaster_pref", g.YK()).getString("disaster_noticeid_list_key", "");
    if ((!com.tencent.mm.platformtools.ab.iwR) && (((String)localObject2).contains(((a)localObject1).fpJ)))
    {
      ac.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster noticeIdList %s contain notifyID:%s, drop id", new Object[] { localObject2, ((a)localObject1).fpJ });
      AppMethodBeat.o(20100);
      return false;
    }
    Object localObject4;
    if (this.fpE.size() > 0)
    {
      localObject4 = (a)this.fpE.get(Long.valueOf(l1));
      if (localObject4 != null) {
        ac.i("MicroMsg.BroadcastController", "summerdiz  handleNewDisaster found info in map[%s]", new Object[] { localObject4 });
      }
    }
    for (;;)
    {
      localObject1 = (String)localMap.get(".e.Position");
      if (!bs.isNullOrNil((String)localObject1)) {
        break;
      }
      ac.e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster positionStr is null!");
      AppMethodBeat.o(20100);
      return false;
      this.fpE.put(Long.valueOf(l1), localObject1);
      localObject4 = localObject1;
      continue;
      this.fpE.put(Long.valueOf(l1), localObject1);
      localObject4 = localObject1;
    }
    Object localObject8 = new ArrayList();
    localObject1 = ((String)localObject1).split(",");
    if ((localObject1 == null) || (localObject1.length <= 0))
    {
      ac.e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster positionStr id invaild!");
      AppMethodBeat.o(20100);
      return false;
    }
    i = 0;
    int k = localObject1.length;
    int j = 0;
    if (j < k)
    {
      int m = bs.getInt(localObject1[j], 0);
      if (m > 0) {
        if (m == 1)
        {
          i = 1;
          ac.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster found tonyTips[%d]", new Object[] { Integer.valueOf(m) });
        }
      }
      for (;;)
      {
        j += 1;
        break;
        ((ArrayList)localObject8).add(Integer.valueOf(m));
      }
    }
    if ((i == 0) && (((ArrayList)localObject8).size() == 0))
    {
      ac.e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster positions size is 0!");
      AppMethodBeat.o(20100);
      return false;
    }
    Object localObject6 = com.tencent.mm.sdk.platformtools.ab.iC(ai.getContext());
    ac.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster curLang[%s]", new Object[] { localObject6 });
    Object localObject3 = null;
    localObject2 = null;
    localObject1 = null;
    j = 0;
    Object localObject7 = new StringBuilder(".e.Item");
    if (j == 0)
    {
      localObject5 = "";
      label647:
      localObject5 = localObject5;
      localObject7 = (String)localMap.get((String)localObject5 + ".Language");
      if ((localObject7 == null) && (j > 3)) {
        break label1753;
      }
      if (!((String)localObject6).equalsIgnoreCase((String)localObject7)) {
        break label1052;
      }
      localObject7 = (String)localMap.get((String)localObject5 + ".Content");
      localObject6 = (String)localMap.get((String)localObject5 + ".Url");
    }
    for (Object localObject5 = (String)localMap.get((String)localObject5 + ".Tips");; localObject5 = null)
    {
      ac.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster content[%s] tips[%s]", new Object[] { localObject7, localObject5 });
      if (bs.isNullOrNil((String)localObject7))
      {
        ac.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster cann't hit curLang");
        label849:
        localObject6 = localObject2;
        if (bs.isNullOrNil((String)localObject2)) {
          localObject6 = ai.getContext().getString(2131758086);
        }
        localObject5 = localObject1;
        localObject2 = localObject3;
        if (i != 0)
        {
          localObject2 = localObject3;
          if (bs.isNullOrNil((String)localObject3)) {
            localObject2 = ai.getContext().getString(2131758080);
          }
          localObject5 = localObject1;
          if (bs.isNullOrNil((String)localObject1)) {
            localObject5 = ai.getContext().getString(2131758084);
          }
          paramap.cZU.desc = ((String)localObject2);
          paramap.cZU.cZW = 30;
          paramap.cZU.cZX = 0;
          paramap.cZU.url = ((String)localObject6);
          paramap.cZU.visible = true;
          paramap.cZU.cZZ = 0;
          paramap.cZU.cZY = 6;
          paramap.cZU.Title = "";
          paramap.cZU.daa = String.valueOf(l1);
          paramap.cZU.position = 1;
        }
        if (((ArrayList)localObject8).size() == 0)
        {
          ac.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster no other position need to tip");
          AppMethodBeat.o(20100);
          return false;
          localObject5 = Integer.valueOf(j);
          break label647;
          label1052:
          if (!"en".equalsIgnoreCase((String)localObject7)) {
            break label1738;
          }
          localObject1 = (String)localMap.get((String)localObject5 + ".Content");
          localObject2 = (String)localMap.get((String)localObject5 + ".Url");
        }
      }
      for (localObject3 = (String)localMap.get((String)localObject5 + ".Tips");; localObject3 = localObject5)
      {
        j += 1;
        localObject5 = localObject1;
        localObject1 = localObject3;
        localObject3 = localObject5;
        break;
        if ((((a)localObject4).fpK != 0L) && (bs.aO(((a)localObject4).fpK) < 1800000L))
        {
          ac.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster disasterTick within half an hour, drop it");
          AppMethodBeat.o(20100);
          return false;
        }
        ((a)localObject4).fpK = bs.Gn();
        localObject7 = ((ArrayList)localObject8).iterator();
        localObject1 = localObject5;
        while (((Iterator)localObject7).hasNext())
        {
          localObject8 = (Integer)((Iterator)localObject7).next();
          localObject3 = Long.valueOf(bs.a((Long)this.fpD.get(localObject8), 0L));
          if ((((Long)localObject3).longValue() > 0L) && (((Long)localObject3).longValue() >= l1))
          {
            ac.i("MicroMsg.BroadcastController", "summerdiz p[%d] has bigger oldPositionNoticeId[%d, %d]", new Object[] { localObject8, localObject3, Long.valueOf(l1) });
          }
          else
          {
            localObject5 = (wi)((a)localObject4).fpM.get(localObject8);
            if (localObject5 != null) {
              break label1720;
            }
            localObject5 = new wi();
            ((wi)localObject5).dzi.cZX = 0;
            ((wi)localObject5).dzi.cZW = 30;
            ((wi)localObject5).dzi.Title = "";
            ((wi)localObject5).dzi.cZZ = 2131494915;
            ((wi)localObject5).dzi.position = ((Integer)localObject8).intValue();
            ((a)localObject4).fpM.put(localObject8, localObject5);
          }
        }
        label1720:
        for (;;)
        {
          if (bs.isNullOrNil((String)localObject1)) {
            localObject1 = localObject2;
          }
          for (;;)
          {
            localObject3 = localObject1;
            if (bs.isNullOrNil((String)localObject1))
            {
              j = 2131758083;
              switch (((Integer)localObject8).intValue())
              {
              }
            }
            for (;;)
            {
              localObject3 = ai.getContext().getString(j);
              ((wi)localObject5).dzi.desc = ((String)localObject3);
              ((wi)localObject5).dzi.url = ((String)localObject6);
              ((wi)localObject5).dzi.visible = true;
              ((wi)localObject5).dzi.cZY = 2;
              ((wi)localObject5).dzi.daa = ((a)localObject4).fpJ;
              this.fpD.put(localObject8, Long.valueOf(l1));
              if (i == 0)
              {
                paramap.cZU.desc = ((String)localObject3);
                paramap.cZU.cZW = 30;
                paramap.cZU.cZX = 0;
                paramap.cZU.url = ((String)localObject6);
                paramap.cZU.visible = true;
                paramap.cZU.cZZ = 2131494915;
                paramap.cZU.cZY = 2;
                paramap.cZU.Title = "";
                paramap.cZU.daa = String.valueOf(l1);
                paramap.cZU.position = ((Integer)localObject8).intValue();
              }
              com.tencent.mm.sdk.platformtools.ap.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(20095);
                  com.tencent.mm.sdk.b.a.GpY.l(this.fpH);
                  AppMethodBeat.o(20095);
                }
              });
              localObject1 = localObject3;
              break;
              j = 2131758085;
              continue;
              j = 2131758082;
            }
            AppMethodBeat.o(20100);
            return true;
          }
        }
        localObject3 = localObject7;
        localObject2 = localObject6;
        localObject1 = localObject5;
        break label849;
        label1738:
        localObject5 = localObject1;
        localObject1 = localObject3;
      }
      label1753:
      localObject7 = null;
      localObject6 = null;
    }
  }
  
  final boolean rN(final String paramString)
  {
    AppMethodBeat.i(20101);
    ac.i("MicroMsg.BroadcastController", "summerdiz handleEventOOB oldNoticeInfo[%s], event[%s]", new Object[] { this.fpC, paramString });
    if (bs.isNullOrNil(paramString))
    {
      AppMethodBeat.o(20101);
      return false;
    }
    if (paramString.indexOf("<") < 0)
    {
      AppMethodBeat.o(20101);
      return false;
    }
    Map localMap = bv.L(paramString, "e");
    if (localMap == null)
    {
      ac.e("MicroMsg.BroadcastController", "this is not errmsg");
      AppMethodBeat.o(20101);
      return false;
    }
    if (this.fpC == null)
    {
      this.fpC = new a();
      paramString = new wi();
      this.fpC.fpM.put(Integer.valueOf(0), paramString);
      paramString.dzi.desc = "";
      paramString.dzi.url = "";
      paramString.dzi.cZX = 0;
      paramString.dzi.cZW = 30;
      paramString.dzi.visible = false;
      paramString.dzi.Title = "";
      paramString.dzi.cZY = 0;
      paramString.dzi.cZZ = 2131494915;
      paramString.dzi.daa = "";
      paramString.dzi.position = 0;
    }
    if (!com.tencent.mm.platformtools.ab.iwP)
    {
      if ((this.fpC.fpK != 0L) && (bs.aO(this.fpC.fpK) < 1800000L))
      {
        ac.i("MicroMsg.BroadcastController", "disasterTick within half an hour, drop it");
        AppMethodBeat.o(20101);
        return false;
      }
      this.fpC.fpK = bs.Gn();
    }
    if (!com.tencent.mm.platformtools.ab.iwQ) {
      try
      {
        long l = bs.getLong((String)localMap.get(".e.ExpiredTime"), 0L);
        if (bs.pN(l) > 0L)
        {
          ac.i("MicroMsg.BroadcastController", "expiredTime is too small, drop id:%d", new Object[] { Long.valueOf(l) });
          AppMethodBeat.o(20101);
          return false;
        }
      }
      catch (Exception paramString)
      {
        ac.i("MicroMsg.BroadcastController", "parseLong expiredTime error:%s", new Object[] { paramString });
      }
    }
    this.fpC.fpJ = ((String)localMap.get(".e.NoticeId"));
    paramString = ai.getContext().getSharedPreferences("disaster_pref", g.YK()).getString("disaster_noticeid_list_key", "");
    if ((!com.tencent.mm.platformtools.ab.iwR) && (paramString.contains(this.fpC.fpJ)))
    {
      ac.i("MicroMsg.BroadcastController", "noticeIdList %s contain notifyID:%s, drop id", new Object[] { paramString, this.fpC.fpJ });
      AppMethodBeat.o(20101);
      return false;
    }
    String str = com.tencent.mm.sdk.platformtools.ab.iC(ai.getContext());
    paramString = null;
    Object localObject1 = null;
    Object localObject2 = null;
    int i = 0;
    Object localObject4 = new StringBuilder(".e.Item");
    if (i == 0)
    {
      localObject3 = "";
      label490:
      localObject3 = localObject3;
      localObject4 = (String)localMap.get((String)localObject3 + ".Language");
      if ((localObject4 == null) && (i > 3)) {
        break label1032;
      }
      if (!str.equalsIgnoreCase((String)localObject4)) {
        break label872;
      }
      str = (String)localMap.get((String)localObject3 + ".Content");
      localObject4 = (String)localMap.get((String)localObject3 + ".Url");
    }
    for (Object localObject3 = (String)localMap.get((String)localObject3 + ".Tips");; localObject3 = null)
    {
      if (bs.isNullOrNil(str))
      {
        ac.i("MicroMsg.BroadcastController", "handleEventOOB cann't hit curLang");
        label670:
        localObject3 = localObject1;
        if (bs.isNullOrNil((String)localObject1)) {
          localObject3 = ai.getContext().getString(2131758086);
        }
        localObject1 = localObject2;
        if (bs.isNullOrNil((String)localObject2))
        {
          ac.i("MicroMsg.BroadcastController", "handleEventOOB defContent is also null use hardcode");
          localObject1 = ai.getContext().getString(2131758079);
        }
        localObject2 = paramString;
        if (bs.isNullOrNil(paramString))
        {
          if (bs.isNullOrNil((String)localObject1)) {
            localObject2 = ai.getContext().getString(2131758083);
          }
        }
        else
        {
          label753:
          paramString = (wi)this.fpC.fpM.get(Integer.valueOf(0));
          paramString.dzi.desc = ((String)localObject2);
          paramString.dzi.url = ((String)localObject3);
          paramString.dzi.visible = true;
          paramString.dzi.cZY = 2;
          paramString.dzi.daa = this.fpC.fpJ;
          com.tencent.mm.sdk.platformtools.ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(20096);
              ac.i("MicroMsg.BroadcastController", "summerdiz handleEventOOB publish uiEvent");
              com.tencent.mm.sdk.b.a.GpY.l(paramString);
              AppMethodBeat.o(20096);
            }
          });
          this.fpC.fpL = ((String)localObject1);
          if (az.agi().foreground) {
            Vl();
          }
          AppMethodBeat.o(20101);
          return true;
          localObject3 = Integer.valueOf(i);
          break label490;
          label872:
          if (!"en".equalsIgnoreCase((String)localObject4)) {
            break label1019;
          }
          paramString = (String)localMap.get((String)localObject3 + ".Content");
          localObject1 = (String)localMap.get((String)localObject3 + ".Url");
        }
      }
      for (localObject2 = (String)localMap.get((String)localObject3 + ".Tips");; localObject2 = localObject3)
      {
        i += 1;
        localObject3 = paramString;
        paramString = (String)localObject2;
        localObject2 = localObject3;
        break;
        localObject2 = localObject1;
        break label753;
        localObject1 = localObject4;
        localObject2 = str;
        paramString = (String)localObject3;
        break label670;
        label1019:
        localObject3 = paramString;
        paramString = (String)localObject2;
      }
      label1032:
      localObject4 = null;
      str = null;
    }
  }
  
  static final class a
  {
    String fpJ;
    long fpK;
    String fpL;
    Map<Integer, wi> fpM;
    
    a()
    {
      AppMethodBeat.i(20097);
      this.fpJ = null;
      this.fpK = 0L;
      this.fpL = null;
      this.fpM = new HashMap();
      AppMethodBeat.o(20097);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(20098);
      Object localObject = this.fpM.keySet().iterator();
      Integer localInteger;
      for (String str = ""; ((Iterator)localObject).hasNext(); str = str + localInteger + ",") {
        localInteger = (Integer)((Iterator)localObject).next();
      }
      localObject = str;
      if (str.length() > 0) {
        localObject = str.substring(0, str.length() - 1);
      }
      str = String.format("NoticeInfo(%d){noticeID[%s], disasterTick[%d], content[%s], posistions[%s]}", new Object[] { Integer.valueOf(hashCode()), this.fpJ, Long.valueOf(this.fpK), this.fpL, localObject });
      AppMethodBeat.o(20098);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.h.b
 * JD-Core Version:    0.7.0.1
 */
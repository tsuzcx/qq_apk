package com.tencent.mm.h;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.g.a.ap;
import com.tencent.mm.g.a.ap.a;
import com.tencent.mm.g.a.xb;
import com.tencent.mm.g.a.xb.a;
import com.tencent.mm.model.ba;
import com.tencent.mm.plugin.account.ui.DisasterUI;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class b
{
  public a fHJ;
  public Map<Integer, Long> fHK;
  public Map<Long, a> fHL;
  public c fHM;
  
  public b()
  {
    AppMethodBeat.i(20099);
    this.fHK = new HashMap();
    this.fHL = new HashMap();
    this.fHM = new c() {};
    AppMethodBeat.o(20099);
  }
  
  final void XC()
  {
    AppMethodBeat.i(20102);
    if ((this.fHJ == null) || (this.fHJ.fHT.get(Integer.valueOf(0)) == null) || (bt.isNullOrNil(this.fHJ.fHS)))
    {
      AppMethodBeat.o(20102);
      return;
    }
    ad.i("MicroMsg.BroadcastController", "summerdize checkShowDisasterContent showDisasterContent[%s]", new Object[] { this.fHJ.fHS });
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("key_disaster_content", this.fHJ.fHS);
    ((Intent)localObject).putExtra("key_disaster_url", ((xb)this.fHJ.fHT.get(Integer.valueOf(0))).dLu.url);
    ((Intent)localObject).setClass(aj.getContext(), DisasterUI.class).addFlags(268435456);
    Context localContext = aj.getContext();
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/broadcast/BroadcastController", "checkShowDisasterContent", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/broadcast/BroadcastController", "checkShowDisasterContent", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    this.fHJ.fHS = null;
    AppMethodBeat.o(20102);
  }
  
  final boolean a(ap paramap)
  {
    AppMethodBeat.i(20100);
    String str = paramap.dll.dln;
    if (str == null) {}
    Map localMap;
    for (int i = -1;; i = str.length())
    {
      ad.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster xml len[%d]", new Object[] { Integer.valueOf(i) });
      localMap = bw.M(str, "e");
      if (localMap != null) {
        break;
      }
      ad.e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster this is not errmsg");
      AppMethodBeat.o(20100);
      return false;
    }
    ad.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster values[%s]", new Object[] { localMap });
    long l1 = bt.getLong((String)localMap.get(".e.NoticeId"), 0L);
    if (l1 <= 0L) {
      ad.e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster noticeID null");
    }
    if (!com.tencent.mm.platformtools.ac.iPZ) {
      try
      {
        long l2 = bt.getLong((String)localMap.get(".e.ExpiredTime"), 0L);
        if (bt.rM(l2) > 0L)
        {
          ad.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster expiredTime is too small, drop id:%d", new Object[] { Long.valueOf(l2) });
          AppMethodBeat.o(20100);
          return false;
        }
      }
      catch (Exception localException)
      {
        ad.i("MicroMsg.BroadcastController", "parseLong expiredTime error:%s", new Object[] { localException });
      }
    }
    Object localObject1 = new a();
    ((a)localObject1).fHQ = String.valueOf(l1);
    Object localObject2 = aj.getContext().getSharedPreferences("disaster_pref", g.abm()).getString("disaster_noticeid_list_key", "");
    if ((!com.tencent.mm.platformtools.ac.iQa) && (((String)localObject2).contains(((a)localObject1).fHQ)))
    {
      ad.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster noticeIdList %s contain notifyID:%s, drop id", new Object[] { localObject2, ((a)localObject1).fHQ });
      AppMethodBeat.o(20100);
      return false;
    }
    Object localObject4;
    if (this.fHL.size() > 0)
    {
      localObject4 = (a)this.fHL.get(Long.valueOf(l1));
      if (localObject4 != null) {
        ad.i("MicroMsg.BroadcastController", "summerdiz  handleNewDisaster found info in map[%s]", new Object[] { localObject4 });
      }
    }
    for (;;)
    {
      localObject1 = (String)localMap.get(".e.Position");
      if (!bt.isNullOrNil((String)localObject1)) {
        break;
      }
      ad.e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster positionStr is null!");
      AppMethodBeat.o(20100);
      return false;
      this.fHL.put(Long.valueOf(l1), localObject1);
      localObject4 = localObject1;
      continue;
      this.fHL.put(Long.valueOf(l1), localObject1);
      localObject4 = localObject1;
    }
    Object localObject8 = new ArrayList();
    localObject1 = ((String)localObject1).split(",");
    if ((localObject1 == null) || (localObject1.length <= 0))
    {
      ad.e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster positionStr id invaild!");
      AppMethodBeat.o(20100);
      return false;
    }
    i = 0;
    int k = localObject1.length;
    int j = 0;
    if (j < k)
    {
      int m = bt.getInt(localObject1[j], 0);
      if (m > 0) {
        if (m == 1)
        {
          i = 1;
          ad.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster found tonyTips[%d]", new Object[] { Integer.valueOf(m) });
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
      ad.e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster positions size is 0!");
      AppMethodBeat.o(20100);
      return false;
    }
    Object localObject6 = com.tencent.mm.sdk.platformtools.ac.iM(aj.getContext());
    ad.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster curLang[%s]", new Object[] { localObject6 });
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
      ad.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster content[%s] tips[%s]", new Object[] { localObject7, localObject5 });
      if (bt.isNullOrNil((String)localObject7))
      {
        ad.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster cann't hit curLang");
        label849:
        localObject6 = localObject2;
        if (bt.isNullOrNil((String)localObject2)) {
          localObject6 = aj.getContext().getString(2131758086);
        }
        localObject5 = localObject1;
        localObject2 = localObject3;
        if (i != 0)
        {
          localObject2 = localObject3;
          if (bt.isNullOrNil((String)localObject3)) {
            localObject2 = aj.getContext().getString(2131758080);
          }
          localObject5 = localObject1;
          if (bt.isNullOrNil((String)localObject1)) {
            localObject5 = aj.getContext().getString(2131758084);
          }
          paramap.dlm.desc = ((String)localObject2);
          paramap.dlm.dlo = 30;
          paramap.dlm.dlp = 0;
          paramap.dlm.url = ((String)localObject6);
          paramap.dlm.visible = true;
          paramap.dlm.dlr = 0;
          paramap.dlm.dlq = 6;
          paramap.dlm.Title = "";
          paramap.dlm.dls = String.valueOf(l1);
          paramap.dlm.position = 1;
        }
        if (((ArrayList)localObject8).size() == 0)
        {
          ad.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster no other position need to tip");
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
        if ((((a)localObject4).fHR != 0L) && (bt.aO(((a)localObject4).fHR) < 1800000L))
        {
          ad.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster disasterTick within half an hour, drop it");
          AppMethodBeat.o(20100);
          return false;
        }
        ((a)localObject4).fHR = bt.HI();
        localObject7 = ((ArrayList)localObject8).iterator();
        localObject1 = localObject5;
        while (((Iterator)localObject7).hasNext())
        {
          localObject8 = (Integer)((Iterator)localObject7).next();
          localObject3 = Long.valueOf(bt.a((Long)this.fHK.get(localObject8), 0L));
          if ((((Long)localObject3).longValue() > 0L) && (((Long)localObject3).longValue() >= l1))
          {
            ad.i("MicroMsg.BroadcastController", "summerdiz p[%d] has bigger oldPositionNoticeId[%d, %d]", new Object[] { localObject8, localObject3, Long.valueOf(l1) });
          }
          else
          {
            localObject5 = (xb)((a)localObject4).fHT.get(localObject8);
            if (localObject5 != null) {
              break label1720;
            }
            localObject5 = new xb();
            ((xb)localObject5).dLu.dlp = 0;
            ((xb)localObject5).dLu.dlo = 30;
            ((xb)localObject5).dLu.Title = "";
            ((xb)localObject5).dLu.dlr = 2131494915;
            ((xb)localObject5).dLu.position = ((Integer)localObject8).intValue();
            ((a)localObject4).fHT.put(localObject8, localObject5);
          }
        }
        label1720:
        for (;;)
        {
          if (bt.isNullOrNil((String)localObject1)) {
            localObject1 = localObject2;
          }
          for (;;)
          {
            localObject3 = localObject1;
            if (bt.isNullOrNil((String)localObject1))
            {
              j = 2131758083;
              switch (((Integer)localObject8).intValue())
              {
              }
            }
            for (;;)
            {
              localObject3 = aj.getContext().getString(j);
              ((xb)localObject5).dLu.desc = ((String)localObject3);
              ((xb)localObject5).dLu.url = ((String)localObject6);
              ((xb)localObject5).dLu.visible = true;
              ((xb)localObject5).dLu.dlq = 2;
              ((xb)localObject5).dLu.dls = ((a)localObject4).fHQ;
              this.fHK.put(localObject8, Long.valueOf(l1));
              if (i == 0)
              {
                paramap.dlm.desc = ((String)localObject3);
                paramap.dlm.dlo = 30;
                paramap.dlm.dlp = 0;
                paramap.dlm.url = ((String)localObject6);
                paramap.dlm.visible = true;
                paramap.dlm.dlr = 2131494915;
                paramap.dlm.dlq = 2;
                paramap.dlm.Title = "";
                paramap.dlm.dls = String.valueOf(l1);
                paramap.dlm.position = ((Integer)localObject8).intValue();
              }
              aq.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(20095);
                  com.tencent.mm.sdk.b.a.IbL.l(this.fHO);
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
  
  final boolean uA(final String paramString)
  {
    AppMethodBeat.i(20101);
    ad.i("MicroMsg.BroadcastController", "summerdiz handleEventOOB oldNoticeInfo[%s], event[%s]", new Object[] { this.fHJ, paramString });
    if (bt.isNullOrNil(paramString))
    {
      AppMethodBeat.o(20101);
      return false;
    }
    if (paramString.indexOf("<") < 0)
    {
      AppMethodBeat.o(20101);
      return false;
    }
    Map localMap = bw.M(paramString, "e");
    if (localMap == null)
    {
      ad.e("MicroMsg.BroadcastController", "this is not errmsg");
      AppMethodBeat.o(20101);
      return false;
    }
    if (this.fHJ == null)
    {
      this.fHJ = new a();
      paramString = new xb();
      this.fHJ.fHT.put(Integer.valueOf(0), paramString);
      paramString.dLu.desc = "";
      paramString.dLu.url = "";
      paramString.dLu.dlp = 0;
      paramString.dLu.dlo = 30;
      paramString.dLu.visible = false;
      paramString.dLu.Title = "";
      paramString.dLu.dlq = 0;
      paramString.dLu.dlr = 2131494915;
      paramString.dLu.dls = "";
      paramString.dLu.position = 0;
    }
    if (!com.tencent.mm.platformtools.ac.iPY)
    {
      if ((this.fHJ.fHR != 0L) && (bt.aO(this.fHJ.fHR) < 1800000L))
      {
        ad.i("MicroMsg.BroadcastController", "disasterTick within half an hour, drop it");
        AppMethodBeat.o(20101);
        return false;
      }
      this.fHJ.fHR = bt.HI();
    }
    if (!com.tencent.mm.platformtools.ac.iPZ) {
      try
      {
        long l = bt.getLong((String)localMap.get(".e.ExpiredTime"), 0L);
        if (bt.rM(l) > 0L)
        {
          ad.i("MicroMsg.BroadcastController", "expiredTime is too small, drop id:%d", new Object[] { Long.valueOf(l) });
          AppMethodBeat.o(20101);
          return false;
        }
      }
      catch (Exception paramString)
      {
        ad.i("MicroMsg.BroadcastController", "parseLong expiredTime error:%s", new Object[] { paramString });
      }
    }
    this.fHJ.fHQ = ((String)localMap.get(".e.NoticeId"));
    paramString = aj.getContext().getSharedPreferences("disaster_pref", g.abm()).getString("disaster_noticeid_list_key", "");
    if ((!com.tencent.mm.platformtools.ac.iQa) && (paramString.contains(this.fHJ.fHQ)))
    {
      ad.i("MicroMsg.BroadcastController", "noticeIdList %s contain notifyID:%s, drop id", new Object[] { paramString, this.fHJ.fHQ });
      AppMethodBeat.o(20101);
      return false;
    }
    String str = com.tencent.mm.sdk.platformtools.ac.iM(aj.getContext());
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
      if (bt.isNullOrNil(str))
      {
        ad.i("MicroMsg.BroadcastController", "handleEventOOB cann't hit curLang");
        label670:
        localObject3 = localObject1;
        if (bt.isNullOrNil((String)localObject1)) {
          localObject3 = aj.getContext().getString(2131758086);
        }
        localObject1 = localObject2;
        if (bt.isNullOrNil((String)localObject2))
        {
          ad.i("MicroMsg.BroadcastController", "handleEventOOB defContent is also null use hardcode");
          localObject1 = aj.getContext().getString(2131758079);
        }
        localObject2 = paramString;
        if (bt.isNullOrNil(paramString))
        {
          if (bt.isNullOrNil((String)localObject1)) {
            localObject2 = aj.getContext().getString(2131758083);
          }
        }
        else
        {
          label753:
          paramString = (xb)this.fHJ.fHT.get(Integer.valueOf(0));
          paramString.dLu.desc = ((String)localObject2);
          paramString.dLu.url = ((String)localObject3);
          paramString.dLu.visible = true;
          paramString.dLu.dlq = 2;
          paramString.dLu.dls = this.fHJ.fHQ;
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(20096);
              ad.i("MicroMsg.BroadcastController", "summerdiz handleEventOOB publish uiEvent");
              com.tencent.mm.sdk.b.a.IbL.l(paramString);
              AppMethodBeat.o(20096);
            }
          });
          this.fHJ.fHS = ((String)localObject1);
          if (ba.aiU().foreground) {
            XC();
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
    String fHQ;
    long fHR;
    String fHS;
    Map<Integer, xb> fHT;
    
    a()
    {
      AppMethodBeat.i(20097);
      this.fHQ = null;
      this.fHR = 0L;
      this.fHS = null;
      this.fHT = new HashMap();
      AppMethodBeat.o(20097);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(20098);
      Object localObject = this.fHT.keySet().iterator();
      Integer localInteger;
      for (String str = ""; ((Iterator)localObject).hasNext(); str = str + localInteger + ",") {
        localInteger = (Integer)((Iterator)localObject).next();
      }
      localObject = str;
      if (str.length() > 0) {
        localObject = str.substring(0, str.length() - 1);
      }
      str = String.format("NoticeInfo(%d){noticeID[%s], disasterTick[%d], content[%s], posistions[%s]}", new Object[] { Integer.valueOf(hashCode()), this.fHQ, Long.valueOf(this.fHR), this.fHS, localObject });
      AppMethodBeat.o(20098);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.h.b
 * JD-Core Version:    0.7.0.1
 */
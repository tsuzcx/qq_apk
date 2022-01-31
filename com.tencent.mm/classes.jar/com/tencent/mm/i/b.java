package com.tencent.mm.i;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.a.aj;
import com.tencent.mm.h.a.aj.a;
import com.tencent.mm.h.a.sh;
import com.tencent.mm.h.a.sh.a;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.account.ui.DisasterUI;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class b
{
  public b.a dkB;
  public Map<Integer, Long> dkC = new HashMap();
  public Map<Long, b.a> dkD = new HashMap();
  public c dkE = new b.1(this);
  
  final boolean a(aj paramaj)
  {
    String str = paramaj.bGr.bGt;
    if (str == null) {}
    Map localMap;
    for (int i = -1;; i = str.length())
    {
      y.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster xml len[%d]", new Object[] { Integer.valueOf(i) });
      localMap = bn.s(str, "e");
      if (localMap != null) {
        break;
      }
      y.e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster this is not errmsg");
      return false;
    }
    y.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster values[%s]", new Object[] { localMap });
    long l1 = bk.getLong((String)localMap.get(".e.NoticeId"), 0L);
    if (l1 <= 0L) {
      y.e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster noticeID null");
    }
    if (!com.tencent.mm.platformtools.ae.eTR) {
      try
      {
        long l2 = bk.getLong((String)localMap.get(".e.ExpiredTime"), 0L);
        if (bk.cn(l2) > 0L)
        {
          y.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster expiredTime is too small, drop id:%d", new Object[] { Long.valueOf(l2) });
          return false;
        }
      }
      catch (Exception localException)
      {
        y.i("MicroMsg.BroadcastController", "parseLong expiredTime error:%s", new Object[] { localException });
      }
    }
    Object localObject1 = new b.a();
    ((b.a)localObject1).dkI = String.valueOf(l1);
    Object localObject2 = com.tencent.mm.sdk.platformtools.ae.getContext().getSharedPreferences("disaster_pref", 4).getString("disaster_noticeid_list_key", "");
    if ((!com.tencent.mm.platformtools.ae.eTS) && (((String)localObject2).contains(((b.a)localObject1).dkI)))
    {
      y.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster noticeIdList %s contain notifyID:%s, drop id", new Object[] { localObject2, ((b.a)localObject1).dkI });
      return false;
    }
    Object localObject4;
    if (this.dkD.size() > 0)
    {
      localObject4 = (b.a)this.dkD.get(Long.valueOf(l1));
      if (localObject4 != null) {
        y.i("MicroMsg.BroadcastController", "summerdiz  handleNewDisaster found info in map[%s]", new Object[] { localObject4 });
      }
    }
    for (;;)
    {
      localObject1 = (String)localMap.get(".e.Position");
      if (!bk.bl((String)localObject1)) {
        break;
      }
      y.e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster positionStr is null!");
      return false;
      this.dkD.put(Long.valueOf(l1), localObject1);
      localObject4 = localObject1;
      continue;
      this.dkD.put(Long.valueOf(l1), localObject1);
      localObject4 = localObject1;
    }
    Object localObject8 = new ArrayList();
    localObject1 = ((String)localObject1).split(",");
    if ((localObject1 == null) || (localObject1.length <= 0))
    {
      y.e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster positionStr id invaild!");
      return false;
    }
    i = 0;
    int k = localObject1.length;
    int j = 0;
    if (j < k)
    {
      int m = bk.getInt(localObject1[j], 0);
      if (m > 0) {
        if (m == 1)
        {
          i = 1;
          y.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster found tonyTips[%d]", new Object[] { Integer.valueOf(m) });
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
      y.e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster positions size is 0!");
      return false;
    }
    Object localObject6 = x.fB(com.tencent.mm.sdk.platformtools.ae.getContext());
    y.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster curLang[%s]", new Object[] { localObject6 });
    Object localObject3 = null;
    localObject2 = null;
    localObject1 = null;
    j = 0;
    Object localObject7 = new StringBuilder(".e.Item");
    if (j == 0)
    {
      localObject5 = "";
      label593:
      localObject5 = localObject5;
      localObject7 = (String)localMap.get((String)localObject5 + ".Language");
      if ((localObject7 == null) && (j > 3)) {
        break label1671;
      }
      if (!((String)localObject6).equalsIgnoreCase((String)localObject7)) {
        break label986;
      }
      localObject6 = (String)localMap.get((String)localObject5 + ".Content");
      localObject7 = (String)localMap.get((String)localObject5 + ".Url");
    }
    for (Object localObject5 = (String)localMap.get((String)localObject5 + ".Tips");; localObject5 = null)
    {
      y.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster content[%s] tips[%s]", new Object[] { localObject6, localObject5 });
      if (bk.bl((String)localObject6))
      {
        y.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster cann't hit curLang");
        label789:
        localObject6 = localObject2;
        if (bk.bl((String)localObject2)) {
          localObject6 = com.tencent.mm.sdk.platformtools.ae.getContext().getString(R.l.disaster_default_url);
        }
        localObject5 = localObject1;
        localObject2 = localObject3;
        if (i != 0)
        {
          localObject2 = localObject3;
          if (bk.bl((String)localObject3)) {
            localObject2 = com.tencent.mm.sdk.platformtools.ae.getContext().getString(R.l.disaster_default_content_login);
          }
          localObject5 = localObject1;
          if (bk.bl((String)localObject1)) {
            localObject5 = com.tencent.mm.sdk.platformtools.ae.getContext().getString(R.l.disaster_default_tips_login);
          }
          paramaj.bGs.desc = ((String)localObject2);
          paramaj.bGs.bGu = 30;
          paramaj.bGs.showType = 0;
          paramaj.bGs.url = ((String)localObject6);
          paramaj.bGs.aoL = true;
          paramaj.bGs.bGx = 0;
          paramaj.bGs.bGv = 6;
          paramaj.bGs.bGw = "";
          paramaj.bGs.bGy = String.valueOf(l1);
          paramaj.bGs.position = 1;
        }
        if (((ArrayList)localObject8).size() == 0)
        {
          y.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster no other position need to tip");
          return false;
          localObject5 = Integer.valueOf(j);
          break label593;
          label986:
          if (!"en".equalsIgnoreCase((String)localObject7)) {
            break label1656;
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
        if ((((b.a)localObject4).dkJ != 0L) && (bk.cp(((b.a)localObject4).dkJ) < 1800000L))
        {
          y.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster disasterTick within half an hour, drop it");
          return false;
        }
        ((b.a)localObject4).dkJ = bk.UZ();
        localObject7 = ((ArrayList)localObject8).iterator();
        localObject1 = localObject5;
        while (((Iterator)localObject7).hasNext())
        {
          localObject8 = (Integer)((Iterator)localObject7).next();
          localObject3 = Long.valueOf(bk.a((Long)this.dkC.get(localObject8), 0L));
          if ((((Long)localObject3).longValue() > 0L) && (((Long)localObject3).longValue() >= l1))
          {
            y.i("MicroMsg.BroadcastController", "summerdiz p[%d] has bigger oldPositionNoticeId[%d, %d]", new Object[] { localObject8, localObject3, Long.valueOf(l1) });
          }
          else
          {
            localObject5 = (sh)((b.a)localObject4).dkL.get(localObject8);
            if (localObject5 != null) {
              break label1638;
            }
            localObject5 = new sh();
            ((sh)localObject5).cbS.showType = 0;
            ((sh)localObject5).cbS.bGu = 30;
            ((sh)localObject5).cbS.bGw = "";
            ((sh)localObject5).cbS.bGx = R.i.mmnotify_view;
            ((sh)localObject5).cbS.position = ((Integer)localObject8).intValue();
            ((b.a)localObject4).dkL.put(localObject8, localObject5);
          }
        }
        label1638:
        for (;;)
        {
          if (bk.bl((String)localObject1)) {
            localObject1 = localObject2;
          }
          for (;;)
          {
            localObject3 = localObject1;
            if (bk.bl((String)localObject1))
            {
              j = R.l.disaster_default_tips_default;
              switch (((Integer)localObject8).intValue())
              {
              }
            }
            for (;;)
            {
              localObject3 = com.tencent.mm.sdk.platformtools.ae.getContext().getString(j);
              ((sh)localObject5).cbS.desc = ((String)localObject3);
              ((sh)localObject5).cbS.url = ((String)localObject6);
              ((sh)localObject5).cbS.aoL = true;
              ((sh)localObject5).cbS.bGv = 2;
              ((sh)localObject5).cbS.bGy = ((b.a)localObject4).dkI;
              this.dkC.put(localObject8, Long.valueOf(l1));
              if (i == 0)
              {
                paramaj.bGs.desc = ((String)localObject3);
                paramaj.bGs.bGu = 30;
                paramaj.bGs.showType = 0;
                paramaj.bGs.url = ((String)localObject6);
                paramaj.bGs.aoL = true;
                paramaj.bGs.bGx = R.i.mmnotify_view;
                paramaj.bGs.bGv = 2;
                paramaj.bGs.bGw = "";
                paramaj.bGs.bGy = String.valueOf(l1);
                paramaj.bGs.position = ((Integer)localObject8).intValue();
              }
              ai.d(new b.2(this, (sh)localObject5));
              localObject1 = localObject3;
              break;
              j = R.l.disaster_default_tips_moment;
              continue;
              j = R.l.disaster_default_tips_chat;
            }
            return true;
          }
        }
        localObject2 = localObject7;
        localObject3 = localObject6;
        localObject1 = localObject5;
        break label789;
        label1656:
        localObject5 = localObject1;
        localObject1 = localObject3;
      }
      label1671:
      localObject7 = null;
      localObject6 = null;
    }
  }
  
  final boolean eJ(String paramString)
  {
    y.i("MicroMsg.BroadcastController", "summerdiz handleEventOOB oldNoticeInfo[%s], event[%s]", new Object[] { this.dkB, paramString });
    if (bk.bl(paramString)) {}
    while (paramString.indexOf("<") < 0) {
      return false;
    }
    Map localMap = bn.s(paramString, "e");
    if (localMap == null)
    {
      y.e("MicroMsg.BroadcastController", "this is not errmsg");
      return false;
    }
    if (this.dkB == null)
    {
      this.dkB = new b.a();
      paramString = new sh();
      this.dkB.dkL.put(Integer.valueOf(0), paramString);
      paramString.cbS.desc = "";
      paramString.cbS.url = "";
      paramString.cbS.showType = 0;
      paramString.cbS.bGu = 30;
      paramString.cbS.aoL = false;
      paramString.cbS.bGw = "";
      paramString.cbS.bGv = 0;
      paramString.cbS.bGx = R.i.mmnotify_view;
      paramString.cbS.bGy = "";
      paramString.cbS.position = 0;
    }
    if (!com.tencent.mm.platformtools.ae.eTQ)
    {
      if ((this.dkB.dkJ != 0L) && (bk.cp(this.dkB.dkJ) < 1800000L))
      {
        y.i("MicroMsg.BroadcastController", "disasterTick within half an hour, drop it");
        return false;
      }
      this.dkB.dkJ = bk.UZ();
    }
    if (!com.tencent.mm.platformtools.ae.eTR) {
      try
      {
        long l = bk.getLong((String)localMap.get(".e.ExpiredTime"), 0L);
        if (bk.cn(l) > 0L)
        {
          y.i("MicroMsg.BroadcastController", "expiredTime is too small, drop id:%d", new Object[] { Long.valueOf(l) });
          return false;
        }
      }
      catch (Exception paramString)
      {
        y.i("MicroMsg.BroadcastController", "parseLong expiredTime error:%s", new Object[] { paramString });
      }
    }
    this.dkB.dkI = ((String)localMap.get(".e.NoticeId"));
    paramString = com.tencent.mm.sdk.platformtools.ae.getContext().getSharedPreferences("disaster_pref", 4).getString("disaster_noticeid_list_key", "");
    if ((!com.tencent.mm.platformtools.ae.eTS) && (paramString.contains(this.dkB.dkI)))
    {
      y.i("MicroMsg.BroadcastController", "noticeIdList %s contain notifyID:%s, drop id", new Object[] { paramString, this.dkB.dkI });
      return false;
    }
    String str = x.fB(com.tencent.mm.sdk.platformtools.ae.getContext());
    paramString = null;
    Object localObject1 = null;
    Object localObject2 = null;
    int i = 0;
    Object localObject4 = new StringBuilder(".e.Item");
    if (i == 0)
    {
      localObject3 = "";
      label443:
      localObject3 = localObject3;
      localObject4 = (String)localMap.get((String)localObject3 + ".Language");
      if ((localObject4 == null) && (i > 3)) {
        break label972;
      }
      if (!str.equalsIgnoreCase((String)localObject4)) {
        break label815;
      }
      str = (String)localMap.get((String)localObject3 + ".Content");
      localObject4 = (String)localMap.get((String)localObject3 + ".Url");
    }
    for (Object localObject3 = (String)localMap.get((String)localObject3 + ".Tips");; localObject3 = null)
    {
      if (bk.bl(str))
      {
        y.i("MicroMsg.BroadcastController", "handleEventOOB cann't hit curLang");
        label619:
        localObject3 = localObject1;
        if (bk.bl((String)localObject1)) {
          localObject3 = com.tencent.mm.sdk.platformtools.ae.getContext().getString(R.l.disaster_default_url);
        }
        localObject1 = localObject2;
        if (bk.bl((String)localObject2))
        {
          y.i("MicroMsg.BroadcastController", "handleEventOOB defContent is also null use hardcode");
          localObject1 = com.tencent.mm.sdk.platformtools.ae.getContext().getString(R.l.disaster_default_content_default);
        }
        localObject2 = paramString;
        if (bk.bl(paramString))
        {
          if (bk.bl((String)localObject1)) {
            localObject2 = com.tencent.mm.sdk.platformtools.ae.getContext().getString(R.l.disaster_default_tips_default);
          }
        }
        else
        {
          label702:
          paramString = (sh)this.dkB.dkL.get(Integer.valueOf(0));
          paramString.cbS.desc = ((String)localObject2);
          paramString.cbS.url = ((String)localObject3);
          paramString.cbS.aoL = true;
          paramString.cbS.bGv = 2;
          paramString.cbS.bGy = this.dkB.dkI;
          ai.d(new b.3(this, paramString));
          this.dkB.dkK = ((String)localObject1);
          if (au.Dk().foreground) {
            wK();
          }
          return true;
          localObject3 = Integer.valueOf(i);
          break label443;
          label815:
          if (!"en".equalsIgnoreCase((String)localObject4)) {
            break label959;
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
        break label702;
        localObject1 = localObject4;
        localObject2 = str;
        paramString = (String)localObject3;
        break label619;
        label959:
        localObject3 = paramString;
        paramString = (String)localObject2;
      }
      label972:
      localObject4 = null;
      str = null;
    }
  }
  
  final void wK()
  {
    if ((this.dkB == null) || (this.dkB.dkL.get(Integer.valueOf(0)) == null) || (bk.bl(this.dkB.dkK))) {
      return;
    }
    y.i("MicroMsg.BroadcastController", "summerdize checkShowDisasterContent showDisasterContent[%s]", new Object[] { this.dkB.dkK });
    Intent localIntent = new Intent();
    localIntent.putExtra("key_disaster_content", this.dkB.dkK);
    localIntent.putExtra("key_disaster_url", ((sh)this.dkB.dkL.get(Integer.valueOf(0))).cbS.url);
    localIntent.setClass(com.tencent.mm.sdk.platformtools.ae.getContext(), DisasterUI.class).addFlags(268435456);
    com.tencent.mm.sdk.platformtools.ae.getContext().startActivity(localIntent);
    this.dkB.dkK = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.i.b
 * JD-Core Version:    0.7.0.1
 */
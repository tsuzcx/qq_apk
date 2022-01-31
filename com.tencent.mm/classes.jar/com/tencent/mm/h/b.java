package com.tencent.mm.h;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.g.a.ak;
import com.tencent.mm.g.a.ak.a;
import com.tencent.mm.g.a.tz;
import com.tencent.mm.g.a.tz.a;
import com.tencent.mm.model.aw;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.account.ui.DisasterUI;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class b
{
  public b.a ebV;
  public Map<Integer, Long> ebW;
  public Map<Long, b.a> ebX;
  public c ebY;
  
  public b()
  {
    AppMethodBeat.i(16066);
    this.ebW = new HashMap();
    this.ebX = new HashMap();
    this.ebY = new b.1(this);
    AppMethodBeat.o(16066);
  }
  
  final void Ja()
  {
    AppMethodBeat.i(16069);
    if ((this.ebV == null) || (this.ebV.ecf.get(Integer.valueOf(0)) == null) || (bo.isNullOrNil(this.ebV.ece)))
    {
      AppMethodBeat.o(16069);
      return;
    }
    ab.i("MicroMsg.BroadcastController", "summerdize checkShowDisasterContent showDisasterContent[%s]", new Object[] { this.ebV.ece });
    Intent localIntent = new Intent();
    localIntent.putExtra("key_disaster_content", this.ebV.ece);
    localIntent.putExtra("key_disaster_url", ((tz)this.ebV.ecf.get(Integer.valueOf(0))).cKy.url);
    localIntent.setClass(ah.getContext(), DisasterUI.class).addFlags(268435456);
    ah.getContext().startActivity(localIntent);
    this.ebV.ece = null;
    AppMethodBeat.o(16069);
  }
  
  final boolean a(ak paramak)
  {
    AppMethodBeat.i(16067);
    String str = paramak.cnA.cnC;
    if (str == null) {}
    Map localMap;
    for (int i = -1;; i = str.length())
    {
      ab.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster xml len[%d]", new Object[] { Integer.valueOf(i) });
      localMap = br.F(str, "e");
      if (localMap != null) {
        break;
      }
      ab.e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster this is not errmsg");
      AppMethodBeat.o(16067);
      return false;
    }
    ab.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster values[%s]", new Object[] { localMap });
    long l1 = bo.getLong((String)localMap.get(".e.NoticeId"), 0L);
    if (l1 <= 0L) {
      ab.e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster noticeID null");
    }
    if (!ae.glP) {
      try
      {
        long l2 = bo.getLong((String)localMap.get(".e.ExpiredTime"), 0L);
        if (bo.gz(l2) > 0L)
        {
          ab.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster expiredTime is too small, drop id:%d", new Object[] { Long.valueOf(l2) });
          AppMethodBeat.o(16067);
          return false;
        }
      }
      catch (Exception localException)
      {
        ab.i("MicroMsg.BroadcastController", "parseLong expiredTime error:%s", new Object[] { localException });
      }
    }
    Object localObject1 = new b.a();
    ((b.a)localObject1).ecc = String.valueOf(l1);
    Object localObject2 = ah.getContext().getSharedPreferences("disaster_pref", h.Mp()).getString("disaster_noticeid_list_key", "");
    if ((!ae.glQ) && (((String)localObject2).contains(((b.a)localObject1).ecc)))
    {
      ab.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster noticeIdList %s contain notifyID:%s, drop id", new Object[] { localObject2, ((b.a)localObject1).ecc });
      AppMethodBeat.o(16067);
      return false;
    }
    Object localObject4;
    if (this.ebX.size() > 0)
    {
      localObject4 = (b.a)this.ebX.get(Long.valueOf(l1));
      if (localObject4 != null) {
        ab.i("MicroMsg.BroadcastController", "summerdiz  handleNewDisaster found info in map[%s]", new Object[] { localObject4 });
      }
    }
    for (;;)
    {
      localObject1 = (String)localMap.get(".e.Position");
      if (!bo.isNullOrNil((String)localObject1)) {
        break;
      }
      ab.e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster positionStr is null!");
      AppMethodBeat.o(16067);
      return false;
      this.ebX.put(Long.valueOf(l1), localObject1);
      localObject4 = localObject1;
      continue;
      this.ebX.put(Long.valueOf(l1), localObject1);
      localObject4 = localObject1;
    }
    Object localObject8 = new ArrayList();
    localObject1 = ((String)localObject1).split(",");
    if ((localObject1 == null) || (localObject1.length <= 0))
    {
      ab.e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster positionStr id invaild!");
      AppMethodBeat.o(16067);
      return false;
    }
    i = 0;
    int k = localObject1.length;
    int j = 0;
    if (j < k)
    {
      int m = bo.getInt(localObject1[j], 0);
      if (m > 0) {
        if (m == 1)
        {
          i = 1;
          ab.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster found tonyTips[%d]", new Object[] { Integer.valueOf(m) });
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
      ab.e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster positions size is 0!");
      AppMethodBeat.o(16067);
      return false;
    }
    Object localObject6 = aa.gP(ah.getContext());
    ab.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster curLang[%s]", new Object[] { localObject6 });
    Object localObject3 = null;
    localObject2 = null;
    localObject1 = null;
    j = 0;
    Object localObject7 = new StringBuilder(".e.Item");
    if (j == 0)
    {
      localObject5 = "";
      label641:
      localObject5 = localObject5;
      localObject7 = (String)localMap.get((String)localObject5 + ".Language");
      if ((localObject7 == null) && (j > 3)) {
        break label1745;
      }
      if (!((String)localObject6).equalsIgnoreCase((String)localObject7)) {
        break label1046;
      }
      localObject7 = (String)localMap.get((String)localObject5 + ".Content");
      localObject6 = (String)localMap.get((String)localObject5 + ".Url");
    }
    for (Object localObject5 = (String)localMap.get((String)localObject5 + ".Tips");; localObject5 = null)
    {
      ab.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster content[%s] tips[%s]", new Object[] { localObject7, localObject5 });
      if (bo.isNullOrNil((String)localObject7))
      {
        ab.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster cann't hit curLang");
        label843:
        localObject6 = localObject2;
        if (bo.isNullOrNil((String)localObject2)) {
          localObject6 = ah.getContext().getString(2131298991);
        }
        localObject5 = localObject1;
        localObject2 = localObject3;
        if (i != 0)
        {
          localObject2 = localObject3;
          if (bo.isNullOrNil((String)localObject3)) {
            localObject2 = ah.getContext().getString(2131298985);
          }
          localObject5 = localObject1;
          if (bo.isNullOrNil((String)localObject1)) {
            localObject5 = ah.getContext().getString(2131298989);
          }
          paramak.cnB.desc = ((String)localObject2);
          paramak.cnB.cnD = 30;
          paramak.cnB.showType = 0;
          paramak.cnB.url = ((String)localObject6);
          paramak.cnB.arf = true;
          paramak.cnB.cnF = 0;
          paramak.cnB.cnE = 6;
          paramak.cnB.Title = "";
          paramak.cnB.cnG = String.valueOf(l1);
          paramak.cnB.position = 1;
        }
        if (((ArrayList)localObject8).size() == 0)
        {
          ab.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster no other position need to tip");
          AppMethodBeat.o(16067);
          return false;
          localObject5 = Integer.valueOf(j);
          break label641;
          label1046:
          if (!"en".equalsIgnoreCase((String)localObject7)) {
            break label1730;
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
        if ((((b.a)localObject4).ecd != 0L) && (bo.av(((b.a)localObject4).ecd) < 1800000L))
        {
          ab.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster disasterTick within half an hour, drop it");
          AppMethodBeat.o(16067);
          return false;
        }
        ((b.a)localObject4).ecd = bo.yB();
        localObject7 = ((ArrayList)localObject8).iterator();
        localObject1 = localObject5;
        while (((Iterator)localObject7).hasNext())
        {
          localObject8 = (Integer)((Iterator)localObject7).next();
          localObject3 = Long.valueOf(bo.a((Long)this.ebW.get(localObject8), 0L));
          if ((((Long)localObject3).longValue() > 0L) && (((Long)localObject3).longValue() >= l1))
          {
            ab.i("MicroMsg.BroadcastController", "summerdiz p[%d] has bigger oldPositionNoticeId[%d, %d]", new Object[] { localObject8, localObject3, Long.valueOf(l1) });
          }
          else
          {
            localObject5 = (tz)((b.a)localObject4).ecf.get(localObject8);
            if (localObject5 != null) {
              break label1712;
            }
            localObject5 = new tz();
            ((tz)localObject5).cKy.showType = 0;
            ((tz)localObject5).cKy.cnD = 30;
            ((tz)localObject5).cKy.Title = "";
            ((tz)localObject5).cKy.cnF = 2130970283;
            ((tz)localObject5).cKy.position = ((Integer)localObject8).intValue();
            ((b.a)localObject4).ecf.put(localObject8, localObject5);
          }
        }
        label1712:
        for (;;)
        {
          if (bo.isNullOrNil((String)localObject1)) {
            localObject1 = localObject2;
          }
          for (;;)
          {
            localObject3 = localObject1;
            if (bo.isNullOrNil((String)localObject1))
            {
              j = 2131298988;
              switch (((Integer)localObject8).intValue())
              {
              }
            }
            for (;;)
            {
              localObject3 = ah.getContext().getString(j);
              ((tz)localObject5).cKy.desc = ((String)localObject3);
              ((tz)localObject5).cKy.url = ((String)localObject6);
              ((tz)localObject5).cKy.arf = true;
              ((tz)localObject5).cKy.cnE = 2;
              ((tz)localObject5).cKy.cnG = ((b.a)localObject4).ecc;
              this.ebW.put(localObject8, Long.valueOf(l1));
              if (i == 0)
              {
                paramak.cnB.desc = ((String)localObject3);
                paramak.cnB.cnD = 30;
                paramak.cnB.showType = 0;
                paramak.cnB.url = ((String)localObject6);
                paramak.cnB.arf = true;
                paramak.cnB.cnF = 2130970283;
                paramak.cnB.cnE = 2;
                paramak.cnB.Title = "";
                paramak.cnB.cnG = String.valueOf(l1);
                paramak.cnB.position = ((Integer)localObject8).intValue();
              }
              al.d(new b.2(this, (tz)localObject5));
              localObject1 = localObject3;
              break;
              j = 2131298990;
              continue;
              j = 2131298987;
            }
            AppMethodBeat.o(16067);
            return true;
          }
        }
        localObject3 = localObject7;
        localObject2 = localObject6;
        localObject1 = localObject5;
        break label843;
        label1730:
        localObject5 = localObject1;
        localObject1 = localObject3;
      }
      label1745:
      localObject7 = null;
      localObject6 = null;
    }
  }
  
  final boolean kP(final String paramString)
  {
    AppMethodBeat.i(16068);
    ab.i("MicroMsg.BroadcastController", "summerdiz handleEventOOB oldNoticeInfo[%s], event[%s]", new Object[] { this.ebV, paramString });
    if (bo.isNullOrNil(paramString))
    {
      AppMethodBeat.o(16068);
      return false;
    }
    if (paramString.indexOf("<") < 0)
    {
      AppMethodBeat.o(16068);
      return false;
    }
    Map localMap = br.F(paramString, "e");
    if (localMap == null)
    {
      ab.e("MicroMsg.BroadcastController", "this is not errmsg");
      AppMethodBeat.o(16068);
      return false;
    }
    if (this.ebV == null)
    {
      this.ebV = new b.a();
      paramString = new tz();
      this.ebV.ecf.put(Integer.valueOf(0), paramString);
      paramString.cKy.desc = "";
      paramString.cKy.url = "";
      paramString.cKy.showType = 0;
      paramString.cKy.cnD = 30;
      paramString.cKy.arf = false;
      paramString.cKy.Title = "";
      paramString.cKy.cnE = 0;
      paramString.cKy.cnF = 2130970283;
      paramString.cKy.cnG = "";
      paramString.cKy.position = 0;
    }
    if (!ae.glO)
    {
      if ((this.ebV.ecd != 0L) && (bo.av(this.ebV.ecd) < 1800000L))
      {
        ab.i("MicroMsg.BroadcastController", "disasterTick within half an hour, drop it");
        AppMethodBeat.o(16068);
        return false;
      }
      this.ebV.ecd = bo.yB();
    }
    if (!ae.glP) {
      try
      {
        long l = bo.getLong((String)localMap.get(".e.ExpiredTime"), 0L);
        if (bo.gz(l) > 0L)
        {
          ab.i("MicroMsg.BroadcastController", "expiredTime is too small, drop id:%d", new Object[] { Long.valueOf(l) });
          AppMethodBeat.o(16068);
          return false;
        }
      }
      catch (Exception paramString)
      {
        ab.i("MicroMsg.BroadcastController", "parseLong expiredTime error:%s", new Object[] { paramString });
      }
    }
    this.ebV.ecc = ((String)localMap.get(".e.NoticeId"));
    paramString = ah.getContext().getSharedPreferences("disaster_pref", h.Mp()).getString("disaster_noticeid_list_key", "");
    if ((!ae.glQ) && (paramString.contains(this.ebV.ecc)))
    {
      ab.i("MicroMsg.BroadcastController", "noticeIdList %s contain notifyID:%s, drop id", new Object[] { paramString, this.ebV.ecc });
      AppMethodBeat.o(16068);
      return false;
    }
    String str = aa.gP(ah.getContext());
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
      if (bo.isNullOrNil(str))
      {
        ab.i("MicroMsg.BroadcastController", "handleEventOOB cann't hit curLang");
        label670:
        localObject3 = localObject1;
        if (bo.isNullOrNil((String)localObject1)) {
          localObject3 = ah.getContext().getString(2131298991);
        }
        localObject1 = localObject2;
        if (bo.isNullOrNil((String)localObject2))
        {
          ab.i("MicroMsg.BroadcastController", "handleEventOOB defContent is also null use hardcode");
          localObject1 = ah.getContext().getString(2131298984);
        }
        localObject2 = paramString;
        if (bo.isNullOrNil(paramString))
        {
          if (bo.isNullOrNil((String)localObject1)) {
            localObject2 = ah.getContext().getString(2131298988);
          }
        }
        else
        {
          label753:
          paramString = (tz)this.ebV.ecf.get(Integer.valueOf(0));
          paramString.cKy.desc = ((String)localObject2);
          paramString.cKy.url = ((String)localObject3);
          paramString.cKy.arf = true;
          paramString.cKy.cnE = 2;
          paramString.cKy.cnG = this.ebV.ecc;
          al.d(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(16063);
              ab.i("MicroMsg.BroadcastController", "summerdiz handleEventOOB publish uiEvent");
              a.ymk.l(paramString);
              AppMethodBeat.o(16063);
            }
          });
          this.ebV.ece = ((String)localObject1);
          if (aw.Rc().foreground) {
            Ja();
          }
          AppMethodBeat.o(16068);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.h.b
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.h;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.g.a.ao;
import com.tencent.mm.g.a.ao.a;
import com.tencent.mm.g.a.vx;
import com.tencent.mm.g.a.vx.a;
import com.tencent.mm.model.az;
import com.tencent.mm.platformtools.ab;
import com.tencent.mm.plugin.account.ui.DisasterUI;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
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
  public a fmh;
  public Map<Integer, Long> fmi;
  public Map<Long, a> fmj;
  public c fmk;
  
  public b()
  {
    AppMethodBeat.i(20099);
    this.fmi = new HashMap();
    this.fmj = new HashMap();
    this.fmk = new c() {};
    AppMethodBeat.o(20099);
  }
  
  final void Uq()
  {
    AppMethodBeat.i(20102);
    if ((this.fmh == null) || (this.fmh.fmr.get(Integer.valueOf(0)) == null) || (bt.isNullOrNil(this.fmh.fmq)))
    {
      AppMethodBeat.o(20102);
      return;
    }
    ad.i("MicroMsg.BroadcastController", "summerdize checkShowDisasterContent showDisasterContent[%s]", new Object[] { this.fmh.fmq });
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("key_disaster_content", this.fmh.fmq);
    ((Intent)localObject).putExtra("key_disaster_url", ((vx)this.fmh.fmr.get(Integer.valueOf(0))).dBu.url);
    ((Intent)localObject).setClass(aj.getContext(), DisasterUI.class).addFlags(268435456);
    Context localContext = aj.getContext();
    localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/broadcast/BroadcastController", "checkShowDisasterContent", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/broadcast/BroadcastController", "checkShowDisasterContent", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    this.fmh.fmq = null;
    AppMethodBeat.o(20102);
  }
  
  final boolean a(ao paramao)
  {
    AppMethodBeat.i(20100);
    String str = paramao.dcv.dcx;
    if (str == null) {}
    Map localMap;
    for (int i = -1;; i = str.length())
    {
      ad.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster xml len[%d]", new Object[] { Integer.valueOf(i) });
      localMap = bw.K(str, "e");
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
    if (!ab.hWM) {
      try
      {
        long l2 = bt.getLong((String)localMap.get(".e.ExpiredTime"), 0L);
        if (bt.lZ(l2) > 0L)
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
    ((a)localObject1).fmo = String.valueOf(l1);
    Object localObject2 = aj.getContext().getSharedPreferences("disaster_pref", g.XN()).getString("disaster_noticeid_list_key", "");
    if ((!ab.hWN) && (((String)localObject2).contains(((a)localObject1).fmo)))
    {
      ad.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster noticeIdList %s contain notifyID:%s, drop id", new Object[] { localObject2, ((a)localObject1).fmo });
      AppMethodBeat.o(20100);
      return false;
    }
    Object localObject4;
    if (this.fmj.size() > 0)
    {
      localObject4 = (a)this.fmj.get(Long.valueOf(l1));
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
      this.fmj.put(Long.valueOf(l1), localObject1);
      localObject4 = localObject1;
      continue;
      this.fmj.put(Long.valueOf(l1), localObject1);
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
    Object localObject6 = ac.ir(aj.getContext());
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
          paramao.dcw.desc = ((String)localObject2);
          paramao.dcw.dcy = 30;
          paramao.dcw.dcz = 0;
          paramao.dcw.url = ((String)localObject6);
          paramao.dcw.visible = true;
          paramao.dcw.dcB = 0;
          paramao.dcw.dcA = 6;
          paramao.dcw.Title = "";
          paramao.dcw.dcC = String.valueOf(l1);
          paramao.dcw.position = 1;
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
        if ((((a)localObject4).fmp != 0L) && (bt.aS(((a)localObject4).fmp) < 1800000L))
        {
          ad.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster disasterTick within half an hour, drop it");
          AppMethodBeat.o(20100);
          return false;
        }
        ((a)localObject4).fmp = bt.GC();
        localObject7 = ((ArrayList)localObject8).iterator();
        localObject1 = localObject5;
        while (((Iterator)localObject7).hasNext())
        {
          localObject8 = (Integer)((Iterator)localObject7).next();
          localObject3 = Long.valueOf(bt.a((Long)this.fmi.get(localObject8), 0L));
          if ((((Long)localObject3).longValue() > 0L) && (((Long)localObject3).longValue() >= l1))
          {
            ad.i("MicroMsg.BroadcastController", "summerdiz p[%d] has bigger oldPositionNoticeId[%d, %d]", new Object[] { localObject8, localObject3, Long.valueOf(l1) });
          }
          else
          {
            localObject5 = (vx)((a)localObject4).fmr.get(localObject8);
            if (localObject5 != null) {
              break label1720;
            }
            localObject5 = new vx();
            ((vx)localObject5).dBu.dcz = 0;
            ((vx)localObject5).dBu.dcy = 30;
            ((vx)localObject5).dBu.Title = "";
            ((vx)localObject5).dBu.dcB = 2131494915;
            ((vx)localObject5).dBu.position = ((Integer)localObject8).intValue();
            ((a)localObject4).fmr.put(localObject8, localObject5);
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
              ((vx)localObject5).dBu.desc = ((String)localObject3);
              ((vx)localObject5).dBu.url = ((String)localObject6);
              ((vx)localObject5).dBu.visible = true;
              ((vx)localObject5).dBu.dcA = 2;
              ((vx)localObject5).dBu.dcC = ((a)localObject4).fmo;
              this.fmi.put(localObject8, Long.valueOf(l1));
              if (i == 0)
              {
                paramao.dcw.desc = ((String)localObject3);
                paramao.dcw.dcy = 30;
                paramao.dcw.dcz = 0;
                paramao.dcw.url = ((String)localObject6);
                paramao.dcw.visible = true;
                paramao.dcw.dcB = 2131494915;
                paramao.dcw.dcA = 2;
                paramao.dcw.Title = "";
                paramao.dcw.dcC = String.valueOf(l1);
                paramao.dcw.position = ((Integer)localObject8).intValue();
              }
              aq.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(20095);
                  com.tencent.mm.sdk.b.a.ESL.l(this.fmm);
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
  
  final boolean oH(final String paramString)
  {
    AppMethodBeat.i(20101);
    ad.i("MicroMsg.BroadcastController", "summerdiz handleEventOOB oldNoticeInfo[%s], event[%s]", new Object[] { this.fmh, paramString });
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
    Map localMap = bw.K(paramString, "e");
    if (localMap == null)
    {
      ad.e("MicroMsg.BroadcastController", "this is not errmsg");
      AppMethodBeat.o(20101);
      return false;
    }
    if (this.fmh == null)
    {
      this.fmh = new a();
      paramString = new vx();
      this.fmh.fmr.put(Integer.valueOf(0), paramString);
      paramString.dBu.desc = "";
      paramString.dBu.url = "";
      paramString.dBu.dcz = 0;
      paramString.dBu.dcy = 30;
      paramString.dBu.visible = false;
      paramString.dBu.Title = "";
      paramString.dBu.dcA = 0;
      paramString.dBu.dcB = 2131494915;
      paramString.dBu.dcC = "";
      paramString.dBu.position = 0;
    }
    if (!ab.hWL)
    {
      if ((this.fmh.fmp != 0L) && (bt.aS(this.fmh.fmp) < 1800000L))
      {
        ad.i("MicroMsg.BroadcastController", "disasterTick within half an hour, drop it");
        AppMethodBeat.o(20101);
        return false;
      }
      this.fmh.fmp = bt.GC();
    }
    if (!ab.hWM) {
      try
      {
        long l = bt.getLong((String)localMap.get(".e.ExpiredTime"), 0L);
        if (bt.lZ(l) > 0L)
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
    this.fmh.fmo = ((String)localMap.get(".e.NoticeId"));
    paramString = aj.getContext().getSharedPreferences("disaster_pref", g.XN()).getString("disaster_noticeid_list_key", "");
    if ((!ab.hWN) && (paramString.contains(this.fmh.fmo)))
    {
      ad.i("MicroMsg.BroadcastController", "noticeIdList %s contain notifyID:%s, drop id", new Object[] { paramString, this.fmh.fmo });
      AppMethodBeat.o(20101);
      return false;
    }
    String str = ac.ir(aj.getContext());
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
          paramString = (vx)this.fmh.fmr.get(Integer.valueOf(0));
          paramString.dBu.desc = ((String)localObject2);
          paramString.dBu.url = ((String)localObject3);
          paramString.dBu.visible = true;
          paramString.dBu.dcA = 2;
          paramString.dBu.dcC = this.fmh.fmo;
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(20096);
              ad.i("MicroMsg.BroadcastController", "summerdiz handleEventOOB publish uiEvent");
              com.tencent.mm.sdk.b.a.ESL.l(paramString);
              AppMethodBeat.o(20096);
            }
          });
          this.fmh.fmq = ((String)localObject1);
          if (az.aeS().foreground) {
            Uq();
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
    String fmo;
    long fmp;
    String fmq;
    Map<Integer, vx> fmr;
    
    a()
    {
      AppMethodBeat.i(20097);
      this.fmo = null;
      this.fmp = 0L;
      this.fmq = null;
      this.fmr = new HashMap();
      AppMethodBeat.o(20097);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(20098);
      Object localObject = this.fmr.keySet().iterator();
      Integer localInteger;
      for (String str = ""; ((Iterator)localObject).hasNext(); str = str + localInteger + ",") {
        localInteger = (Integer)((Iterator)localObject).next();
      }
      localObject = str;
      if (str.length() > 0) {
        localObject = str.substring(0, str.length() - 1);
      }
      str = String.format("NoticeInfo(%d){noticeID[%s], disasterTick[%d], content[%s], posistions[%s]}", new Object[] { Integer.valueOf(hashCode()), this.fmo, Long.valueOf(this.fmp), this.fmq, localObject });
      AppMethodBeat.o(20098);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.h.b
 * JD-Core Version:    0.7.0.1
 */
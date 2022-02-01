package com.tencent.mm.h;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.g.a.ap;
import com.tencent.mm.g.a.ap.a;
import com.tencent.mm.g.a.xf;
import com.tencent.mm.g.a.xf.a;
import com.tencent.mm.model.bc;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.account.ui.DisasterUI;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.bx;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class b
{
  public a fJN;
  public Map<Integer, Long> fJO;
  public Map<Long, a> fJP;
  public c fJQ;
  
  public b()
  {
    AppMethodBeat.i(20099);
    this.fJO = new HashMap();
    this.fJP = new HashMap();
    this.fJQ = new c() {};
    AppMethodBeat.o(20099);
  }
  
  final void XM()
  {
    AppMethodBeat.i(20102);
    if ((this.fJN == null) || (this.fJN.fJX.get(Integer.valueOf(0)) == null) || (bu.isNullOrNil(this.fJN.fJW)))
    {
      AppMethodBeat.o(20102);
      return;
    }
    ae.i("MicroMsg.BroadcastController", "summerdize checkShowDisasterContent showDisasterContent[%s]", new Object[] { this.fJN.fJW });
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("key_disaster_content", this.fJN.fJW);
    ((Intent)localObject).putExtra("key_disaster_url", ((xf)this.fJN.fJX.get(Integer.valueOf(0))).dMJ.url);
    ((Intent)localObject).setClass(ak.getContext(), DisasterUI.class).addFlags(268435456);
    Context localContext = ak.getContext();
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/broadcast/BroadcastController", "checkShowDisasterContent", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/broadcast/BroadcastController", "checkShowDisasterContent", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    this.fJN.fJW = null;
    AppMethodBeat.o(20102);
  }
  
  final boolean a(ap paramap)
  {
    AppMethodBeat.i(20100);
    String str = paramap.dmn.dmp;
    if (str == null) {}
    Map localMap;
    for (int i = -1;; i = str.length())
    {
      ae.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster xml len[%d]", new Object[] { Integer.valueOf(i) });
      localMap = bx.M(str, "e");
      if (localMap != null) {
        break;
      }
      ae.e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster this is not errmsg");
      AppMethodBeat.o(20100);
      return false;
    }
    ae.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster values[%s]", new Object[] { localMap });
    long l1 = bu.getLong((String)localMap.get(".e.NoticeId"), 0L);
    if (l1 <= 0L) {
      ae.e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster noticeID null");
    }
    if (!ac.iSS) {
      try
      {
        long l2 = bu.getLong((String)localMap.get(".e.ExpiredTime"), 0L);
        if (bu.rZ(l2) > 0L)
        {
          ae.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster expiredTime is too small, drop id:%d", new Object[] { Long.valueOf(l2) });
          AppMethodBeat.o(20100);
          return false;
        }
      }
      catch (Exception localException)
      {
        ae.i("MicroMsg.BroadcastController", "parseLong expiredTime error:%s", new Object[] { localException });
      }
    }
    Object localObject1 = new a();
    ((a)localObject1).fJU = String.valueOf(l1);
    Object localObject2 = ak.getContext().getSharedPreferences("disaster_pref", g.abv()).getString("disaster_noticeid_list_key", "");
    if ((!ac.iST) && (((String)localObject2).contains(((a)localObject1).fJU)))
    {
      ae.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster noticeIdList %s contain notifyID:%s, drop id", new Object[] { localObject2, ((a)localObject1).fJU });
      AppMethodBeat.o(20100);
      return false;
    }
    Object localObject4;
    if (this.fJP.size() > 0)
    {
      localObject4 = (a)this.fJP.get(Long.valueOf(l1));
      if (localObject4 != null) {
        ae.i("MicroMsg.BroadcastController", "summerdiz  handleNewDisaster found info in map[%s]", new Object[] { localObject4 });
      }
    }
    for (;;)
    {
      localObject1 = (String)localMap.get(".e.Position");
      if (!bu.isNullOrNil((String)localObject1)) {
        break;
      }
      ae.e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster positionStr is null!");
      AppMethodBeat.o(20100);
      return false;
      this.fJP.put(Long.valueOf(l1), localObject1);
      localObject4 = localObject1;
      continue;
      this.fJP.put(Long.valueOf(l1), localObject1);
      localObject4 = localObject1;
    }
    Object localObject8 = new ArrayList();
    localObject1 = ((String)localObject1).split(",");
    if ((localObject1 == null) || (localObject1.length <= 0))
    {
      ae.e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster positionStr id invaild!");
      AppMethodBeat.o(20100);
      return false;
    }
    i = 0;
    int k = localObject1.length;
    int j = 0;
    if (j < k)
    {
      int m = bu.getInt(localObject1[j], 0);
      if (m > 0) {
        if (m == 1)
        {
          i = 1;
          ae.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster found tonyTips[%d]", new Object[] { Integer.valueOf(m) });
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
      ae.e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster positions size is 0!");
      AppMethodBeat.o(20100);
      return false;
    }
    Object localObject6 = ad.iR(ak.getContext());
    ae.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster curLang[%s]", new Object[] { localObject6 });
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
      ae.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster content[%s] tips[%s]", new Object[] { localObject7, localObject5 });
      if (bu.isNullOrNil((String)localObject7))
      {
        ae.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster cann't hit curLang");
        label849:
        localObject6 = localObject2;
        if (bu.isNullOrNil((String)localObject2)) {
          localObject6 = ak.getContext().getString(2131758086);
        }
        localObject5 = localObject1;
        localObject2 = localObject3;
        if (i != 0)
        {
          localObject2 = localObject3;
          if (bu.isNullOrNil((String)localObject3)) {
            localObject2 = ak.getContext().getString(2131758080);
          }
          localObject5 = localObject1;
          if (bu.isNullOrNil((String)localObject1)) {
            localObject5 = ak.getContext().getString(2131758084);
          }
          paramap.dmo.desc = ((String)localObject2);
          paramap.dmo.dmq = 30;
          paramap.dmo.dmr = 0;
          paramap.dmo.url = ((String)localObject6);
          paramap.dmo.visible = true;
          paramap.dmo.dmt = 0;
          paramap.dmo.dms = 6;
          paramap.dmo.Title = "";
          paramap.dmo.dmu = String.valueOf(l1);
          paramap.dmo.position = 1;
        }
        if (((ArrayList)localObject8).size() == 0)
        {
          ae.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster no other position need to tip");
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
        if ((((a)localObject4).fJV != 0L) && (bu.aO(((a)localObject4).fJV) < 1800000L))
        {
          ae.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster disasterTick within half an hour, drop it");
          AppMethodBeat.o(20100);
          return false;
        }
        ((a)localObject4).fJV = bu.HQ();
        localObject7 = ((ArrayList)localObject8).iterator();
        localObject1 = localObject5;
        while (((Iterator)localObject7).hasNext())
        {
          localObject8 = (Integer)((Iterator)localObject7).next();
          localObject3 = Long.valueOf(bu.a((Long)this.fJO.get(localObject8), 0L));
          if ((((Long)localObject3).longValue() > 0L) && (((Long)localObject3).longValue() >= l1))
          {
            ae.i("MicroMsg.BroadcastController", "summerdiz p[%d] has bigger oldPositionNoticeId[%d, %d]", new Object[] { localObject8, localObject3, Long.valueOf(l1) });
          }
          else
          {
            localObject5 = (xf)((a)localObject4).fJX.get(localObject8);
            if (localObject5 != null) {
              break label1720;
            }
            localObject5 = new xf();
            ((xf)localObject5).dMJ.dmr = 0;
            ((xf)localObject5).dMJ.dmq = 30;
            ((xf)localObject5).dMJ.Title = "";
            ((xf)localObject5).dMJ.dmt = 2131494915;
            ((xf)localObject5).dMJ.position = ((Integer)localObject8).intValue();
            ((a)localObject4).fJX.put(localObject8, localObject5);
          }
        }
        label1720:
        for (;;)
        {
          if (bu.isNullOrNil((String)localObject1)) {
            localObject1 = localObject2;
          }
          for (;;)
          {
            localObject3 = localObject1;
            if (bu.isNullOrNil((String)localObject1))
            {
              j = 2131758083;
              switch (((Integer)localObject8).intValue())
              {
              }
            }
            for (;;)
            {
              localObject3 = ak.getContext().getString(j);
              ((xf)localObject5).dMJ.desc = ((String)localObject3);
              ((xf)localObject5).dMJ.url = ((String)localObject6);
              ((xf)localObject5).dMJ.visible = true;
              ((xf)localObject5).dMJ.dms = 2;
              ((xf)localObject5).dMJ.dmu = ((a)localObject4).fJU;
              this.fJO.put(localObject8, Long.valueOf(l1));
              if (i == 0)
              {
                paramap.dmo.desc = ((String)localObject3);
                paramap.dmo.dmq = 30;
                paramap.dmo.dmr = 0;
                paramap.dmo.url = ((String)localObject6);
                paramap.dmo.visible = true;
                paramap.dmo.dmt = 2131494915;
                paramap.dmo.dms = 2;
                paramap.dmo.Title = "";
                paramap.dmo.dmu = String.valueOf(l1);
                paramap.dmo.position = ((Integer)localObject8).intValue();
              }
              ar.f(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(20095);
                  com.tencent.mm.sdk.b.a.IvT.l(this.fJS);
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
  
  final boolean uV(final String paramString)
  {
    AppMethodBeat.i(20101);
    ae.i("MicroMsg.BroadcastController", "summerdiz handleEventOOB oldNoticeInfo[%s], event[%s]", new Object[] { this.fJN, paramString });
    if (bu.isNullOrNil(paramString))
    {
      AppMethodBeat.o(20101);
      return false;
    }
    if (paramString.indexOf("<") < 0)
    {
      AppMethodBeat.o(20101);
      return false;
    }
    Map localMap = bx.M(paramString, "e");
    if (localMap == null)
    {
      ae.e("MicroMsg.BroadcastController", "this is not errmsg");
      AppMethodBeat.o(20101);
      return false;
    }
    if (this.fJN == null)
    {
      this.fJN = new a();
      paramString = new xf();
      this.fJN.fJX.put(Integer.valueOf(0), paramString);
      paramString.dMJ.desc = "";
      paramString.dMJ.url = "";
      paramString.dMJ.dmr = 0;
      paramString.dMJ.dmq = 30;
      paramString.dMJ.visible = false;
      paramString.dMJ.Title = "";
      paramString.dMJ.dms = 0;
      paramString.dMJ.dmt = 2131494915;
      paramString.dMJ.dmu = "";
      paramString.dMJ.position = 0;
    }
    if (!ac.iSR)
    {
      if ((this.fJN.fJV != 0L) && (bu.aO(this.fJN.fJV) < 1800000L))
      {
        ae.i("MicroMsg.BroadcastController", "disasterTick within half an hour, drop it");
        AppMethodBeat.o(20101);
        return false;
      }
      this.fJN.fJV = bu.HQ();
    }
    if (!ac.iSS) {
      try
      {
        long l = bu.getLong((String)localMap.get(".e.ExpiredTime"), 0L);
        if (bu.rZ(l) > 0L)
        {
          ae.i("MicroMsg.BroadcastController", "expiredTime is too small, drop id:%d", new Object[] { Long.valueOf(l) });
          AppMethodBeat.o(20101);
          return false;
        }
      }
      catch (Exception paramString)
      {
        ae.i("MicroMsg.BroadcastController", "parseLong expiredTime error:%s", new Object[] { paramString });
      }
    }
    this.fJN.fJU = ((String)localMap.get(".e.NoticeId"));
    paramString = ak.getContext().getSharedPreferences("disaster_pref", g.abv()).getString("disaster_noticeid_list_key", "");
    if ((!ac.iST) && (paramString.contains(this.fJN.fJU)))
    {
      ae.i("MicroMsg.BroadcastController", "noticeIdList %s contain notifyID:%s, drop id", new Object[] { paramString, this.fJN.fJU });
      AppMethodBeat.o(20101);
      return false;
    }
    String str = ad.iR(ak.getContext());
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
      if (bu.isNullOrNil(str))
      {
        ae.i("MicroMsg.BroadcastController", "handleEventOOB cann't hit curLang");
        label670:
        localObject3 = localObject1;
        if (bu.isNullOrNil((String)localObject1)) {
          localObject3 = ak.getContext().getString(2131758086);
        }
        localObject1 = localObject2;
        if (bu.isNullOrNil((String)localObject2))
        {
          ae.i("MicroMsg.BroadcastController", "handleEventOOB defContent is also null use hardcode");
          localObject1 = ak.getContext().getString(2131758079);
        }
        localObject2 = paramString;
        if (bu.isNullOrNil(paramString))
        {
          if (bu.isNullOrNil((String)localObject1)) {
            localObject2 = ak.getContext().getString(2131758083);
          }
        }
        else
        {
          label753:
          paramString = (xf)this.fJN.fJX.get(Integer.valueOf(0));
          paramString.dMJ.desc = ((String)localObject2);
          paramString.dMJ.url = ((String)localObject3);
          paramString.dMJ.visible = true;
          paramString.dMJ.dms = 2;
          paramString.dMJ.dmu = this.fJN.fJU;
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(20096);
              ae.i("MicroMsg.BroadcastController", "summerdiz handleEventOOB publish uiEvent");
              com.tencent.mm.sdk.b.a.IvT.l(paramString);
              AppMethodBeat.o(20096);
            }
          });
          this.fJN.fJW = ((String)localObject1);
          if (bc.ajj().foreground) {
            XM();
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
    String fJU;
    long fJV;
    String fJW;
    Map<Integer, xf> fJX;
    
    a()
    {
      AppMethodBeat.i(20097);
      this.fJU = null;
      this.fJV = 0L;
      this.fJW = null;
      this.fJX = new HashMap();
      AppMethodBeat.o(20097);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(20098);
      Object localObject = this.fJX.keySet().iterator();
      Integer localInteger;
      for (String str = ""; ((Iterator)localObject).hasNext(); str = str + localInteger + ",") {
        localInteger = (Integer)((Iterator)localObject).next();
      }
      localObject = str;
      if (str.length() > 0) {
        localObject = str.substring(0, str.length() - 1);
      }
      str = String.format("NoticeInfo(%d){noticeID[%s], disasterTick[%d], content[%s], posistions[%s]}", new Object[] { Integer.valueOf(hashCode()), this.fJU, Long.valueOf(this.fJV), this.fJW, localObject });
      AppMethodBeat.o(20098);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.h.b
 * JD-Core Version:    0.7.0.1
 */
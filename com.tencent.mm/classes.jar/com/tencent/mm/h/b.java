package com.tencent.mm.h;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.g.a.ar;
import com.tencent.mm.g.a.ar.a;
import com.tencent.mm.g.a.yg;
import com.tencent.mm.g.a.yg.a;
import com.tencent.mm.model.bg;
import com.tencent.mm.platformtools.ac;
import com.tencent.mm.plugin.account.ui.DisasterUI;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class b
{
  public b.a gpc;
  public Map<Integer, Long> gpd;
  public Map<Long, b.a> gpe;
  public IListener gpf;
  
  public b()
  {
    AppMethodBeat.i(20099);
    this.gpd = new HashMap();
    this.gpe = new HashMap();
    this.gpf = new IListener() {};
    AppMethodBeat.o(20099);
  }
  
  final boolean Dl(final String paramString)
  {
    AppMethodBeat.i(20101);
    Log.i("MicroMsg.BroadcastController", "summerdiz handleEventOOB oldNoticeInfo[%s], event[%s]", new Object[] { this.gpc, paramString });
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(20101);
      return false;
    }
    if (paramString.indexOf("<") < 0)
    {
      AppMethodBeat.o(20101);
      return false;
    }
    Map localMap = XmlParser.parseXml(paramString, "e", null);
    if (localMap == null)
    {
      Log.e("MicroMsg.BroadcastController", "this is not errmsg");
      AppMethodBeat.o(20101);
      return false;
    }
    if (this.gpc == null)
    {
      this.gpc = new b.a();
      paramString = new yg();
      this.gpc.gpm.put(Integer.valueOf(0), paramString);
      paramString.eeB.desc = "";
      paramString.eeB.url = "";
      paramString.eeB.dDG = 0;
      paramString.eeB.dDF = 30;
      paramString.eeB.visible = false;
      paramString.eeB.Title = "";
      paramString.eeB.dDH = 0;
      paramString.eeB.dDI = 2131495655;
      paramString.eeB.dDJ = "";
      paramString.eeB.position = 0;
    }
    if (!ac.jPM)
    {
      if ((this.gpc.gpk != 0L) && (Util.ticksToNow(this.gpc.gpk) < 1800000L))
      {
        Log.i("MicroMsg.BroadcastController", "disasterTick within half an hour, drop it");
        AppMethodBeat.o(20101);
        return false;
      }
      this.gpc.gpk = Util.currentTicks();
    }
    if (!ac.jPN) {
      try
      {
        long l = Util.getLong((String)localMap.get(".e.ExpiredTime"), 0L);
        if (Util.secondsToNow(l) > 0L)
        {
          Log.i("MicroMsg.BroadcastController", "expiredTime is too small, drop id:%d", new Object[] { Long.valueOf(l) });
          AppMethodBeat.o(20101);
          return false;
        }
      }
      catch (Exception paramString)
      {
        Log.i("MicroMsg.BroadcastController", "parseLong expiredTime error:%s", new Object[] { paramString });
      }
    }
    this.gpc.gpj = ((String)localMap.get(".e.NoticeId"));
    paramString = MMApplicationContext.getContext().getSharedPreferences("disaster_pref", g.aps()).getString("disaster_noticeid_list_key", "");
    if ((!ac.jPO) && (paramString.contains(this.gpc.gpj)))
    {
      Log.i("MicroMsg.BroadcastController", "noticeIdList %s contain notifyID:%s, drop id", new Object[] { paramString, this.gpc.gpj });
      AppMethodBeat.o(20101);
      return false;
    }
    String str = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
    paramString = null;
    Object localObject1 = null;
    Object localObject2 = null;
    int i = 0;
    Object localObject4 = new StringBuilder(".e.Item");
    if (i == 0)
    {
      localObject3 = "";
      label483:
      localObject3 = localObject3;
      localObject4 = (String)localMap.get((String)localObject3 + ".Language");
      if ((localObject4 == null) && (i > 3)) {
        break label1025;
      }
      if (!str.equalsIgnoreCase((String)localObject4)) {
        break label865;
      }
      str = (String)localMap.get((String)localObject3 + ".Content");
      localObject4 = (String)localMap.get((String)localObject3 + ".Url");
    }
    for (Object localObject3 = (String)localMap.get((String)localObject3 + ".Tips");; localObject3 = null)
    {
      if (Util.isNullOrNil(str))
      {
        Log.i("MicroMsg.BroadcastController", "handleEventOOB cann't hit curLang");
        label663:
        localObject3 = localObject1;
        if (Util.isNullOrNil((String)localObject1)) {
          localObject3 = MMApplicationContext.getContext().getString(2131758346);
        }
        localObject1 = localObject2;
        if (Util.isNullOrNil((String)localObject2))
        {
          Log.i("MicroMsg.BroadcastController", "handleEventOOB defContent is also null use hardcode");
          localObject1 = MMApplicationContext.getContext().getString(2131758339);
        }
        localObject2 = paramString;
        if (Util.isNullOrNil(paramString))
        {
          if (Util.isNullOrNil((String)localObject1)) {
            localObject2 = MMApplicationContext.getContext().getString(2131758343);
          }
        }
        else
        {
          label746:
          paramString = (yg)this.gpc.gpm.get(Integer.valueOf(0));
          paramString.eeB.desc = ((String)localObject2);
          paramString.eeB.url = ((String)localObject3);
          paramString.eeB.visible = true;
          paramString.eeB.dDH = 2;
          paramString.eeB.dDJ = this.gpc.gpj;
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(20096);
              Log.i("MicroMsg.BroadcastController", "summerdiz handleEventOOB publish uiEvent");
              EventCenter.instance.publish(paramString);
              AppMethodBeat.o(20096);
            }
          });
          this.gpc.gpl = ((String)localObject1);
          if (bg.azz().foreground) {
            alz();
          }
          AppMethodBeat.o(20101);
          return true;
          localObject3 = Integer.valueOf(i);
          break label483;
          label865:
          if (!"en".equalsIgnoreCase((String)localObject4)) {
            break label1012;
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
        break label746;
        localObject1 = localObject4;
        localObject2 = str;
        paramString = (String)localObject3;
        break label663;
        label1012:
        localObject3 = paramString;
        paramString = (String)localObject2;
      }
      label1025:
      localObject4 = null;
      str = null;
    }
  }
  
  final boolean a(ar paramar)
  {
    AppMethodBeat.i(20100);
    String str = paramar.dDD.event;
    if (str == null) {}
    Map localMap;
    for (int i = -1;; i = str.length())
    {
      Log.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster xml len[%d]", new Object[] { Integer.valueOf(i) });
      localMap = XmlParser.parseXml(str, "e", null);
      if (localMap != null) {
        break;
      }
      Log.e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster this is not errmsg");
      AppMethodBeat.o(20100);
      return false;
    }
    Log.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster values[%s]", new Object[] { localMap });
    long l1 = Util.getLong((String)localMap.get(".e.NoticeId"), 0L);
    if (l1 <= 0L) {
      Log.e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster noticeID null");
    }
    if (!ac.jPN) {
      try
      {
        long l2 = Util.getLong((String)localMap.get(".e.ExpiredTime"), 0L);
        if (Util.secondsToNow(l2) > 0L)
        {
          Log.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster expiredTime is too small, drop id:%d", new Object[] { Long.valueOf(l2) });
          AppMethodBeat.o(20100);
          return false;
        }
      }
      catch (Exception localException)
      {
        Log.i("MicroMsg.BroadcastController", "parseLong expiredTime error:%s", new Object[] { localException });
      }
    }
    Object localObject1 = new b.a();
    ((b.a)localObject1).gpj = String.valueOf(l1);
    Object localObject2 = MMApplicationContext.getContext().getSharedPreferences("disaster_pref", g.aps()).getString("disaster_noticeid_list_key", "");
    if ((!ac.jPO) && (((String)localObject2).contains(((b.a)localObject1).gpj)))
    {
      Log.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster noticeIdList %s contain notifyID:%s, drop id", new Object[] { localObject2, ((b.a)localObject1).gpj });
      AppMethodBeat.o(20100);
      return false;
    }
    Object localObject4;
    if (this.gpe.size() > 0)
    {
      localObject4 = (b.a)this.gpe.get(Long.valueOf(l1));
      if (localObject4 != null) {
        Log.i("MicroMsg.BroadcastController", "summerdiz  handleNewDisaster found info in map[%s]", new Object[] { localObject4 });
      }
    }
    for (;;)
    {
      localObject1 = (String)localMap.get(".e.Position");
      if (!Util.isNullOrNil((String)localObject1)) {
        break;
      }
      Log.e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster positionStr is null!");
      AppMethodBeat.o(20100);
      return false;
      this.gpe.put(Long.valueOf(l1), localObject1);
      localObject4 = localObject1;
      continue;
      this.gpe.put(Long.valueOf(l1), localObject1);
      localObject4 = localObject1;
    }
    Object localObject8 = new ArrayList();
    localObject1 = ((String)localObject1).split(",");
    if ((localObject1 == null) || (localObject1.length <= 0))
    {
      Log.e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster positionStr id invaild!");
      AppMethodBeat.o(20100);
      return false;
    }
    i = 0;
    int k = localObject1.length;
    int j = 0;
    if (j < k)
    {
      int m = Util.getInt(localObject1[j], 0);
      if (m > 0) {
        if (m == 1)
        {
          i = 1;
          Log.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster found tonyTips[%d]", new Object[] { Integer.valueOf(m) });
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
      Log.e("MicroMsg.BroadcastController", "summerdiz handleNewDisaster positions size is 0!");
      AppMethodBeat.o(20100);
      return false;
    }
    Object localObject6 = LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext());
    Log.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster curLang[%s]", new Object[] { localObject6 });
    Object localObject3 = null;
    localObject2 = null;
    localObject1 = null;
    j = 0;
    Object localObject7 = new StringBuilder(".e.Item");
    if (j == 0)
    {
      localObject5 = "";
      label652:
      localObject5 = localObject5;
      localObject7 = (String)localMap.get((String)localObject5 + ".Language");
      if ((localObject7 == null) && (j > 3)) {
        break label1756;
      }
      if (!((String)localObject6).equalsIgnoreCase((String)localObject7)) {
        break label1057;
      }
      localObject7 = (String)localMap.get((String)localObject5 + ".Content");
      localObject6 = (String)localMap.get((String)localObject5 + ".Url");
    }
    for (Object localObject5 = (String)localMap.get((String)localObject5 + ".Tips");; localObject5 = null)
    {
      Log.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster content[%s] tips[%s]", new Object[] { localObject7, localObject5 });
      if (Util.isNullOrNil((String)localObject7))
      {
        Log.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster cann't hit curLang");
        label854:
        localObject6 = localObject2;
        if (Util.isNullOrNil((String)localObject2)) {
          localObject6 = MMApplicationContext.getContext().getString(2131758346);
        }
        localObject5 = localObject1;
        localObject2 = localObject3;
        if (i != 0)
        {
          localObject2 = localObject3;
          if (Util.isNullOrNil((String)localObject3)) {
            localObject2 = MMApplicationContext.getContext().getString(2131758340);
          }
          localObject5 = localObject1;
          if (Util.isNullOrNil((String)localObject1)) {
            localObject5 = MMApplicationContext.getContext().getString(2131758344);
          }
          paramar.dDE.desc = ((String)localObject2);
          paramar.dDE.dDF = 30;
          paramar.dDE.dDG = 0;
          paramar.dDE.url = ((String)localObject6);
          paramar.dDE.visible = true;
          paramar.dDE.dDI = 0;
          paramar.dDE.dDH = 6;
          paramar.dDE.Title = "";
          paramar.dDE.dDJ = String.valueOf(l1);
          paramar.dDE.position = 1;
        }
        if (((ArrayList)localObject8).size() == 0)
        {
          Log.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster no other position need to tip");
          AppMethodBeat.o(20100);
          return false;
          localObject5 = Integer.valueOf(j);
          break label652;
          label1057:
          if (!"en".equalsIgnoreCase((String)localObject7)) {
            break label1741;
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
        if ((((b.a)localObject4).gpk != 0L) && (Util.ticksToNow(((b.a)localObject4).gpk) < 1800000L))
        {
          Log.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster disasterTick within half an hour, drop it");
          AppMethodBeat.o(20100);
          return false;
        }
        ((b.a)localObject4).gpk = Util.currentTicks();
        localObject7 = ((ArrayList)localObject8).iterator();
        localObject1 = localObject5;
        while (((Iterator)localObject7).hasNext())
        {
          localObject8 = (Integer)((Iterator)localObject7).next();
          localObject3 = Long.valueOf(Util.nullAs((Long)this.gpd.get(localObject8), 0L));
          if ((((Long)localObject3).longValue() > 0L) && (((Long)localObject3).longValue() >= l1))
          {
            Log.i("MicroMsg.BroadcastController", "summerdiz p[%d] has bigger oldPositionNoticeId[%d, %d]", new Object[] { localObject8, localObject3, Long.valueOf(l1) });
          }
          else
          {
            localObject5 = (yg)((b.a)localObject4).gpm.get(localObject8);
            if (localObject5 != null) {
              break label1723;
            }
            localObject5 = new yg();
            ((yg)localObject5).eeB.dDG = 0;
            ((yg)localObject5).eeB.dDF = 30;
            ((yg)localObject5).eeB.Title = "";
            ((yg)localObject5).eeB.dDI = 2131495655;
            ((yg)localObject5).eeB.position = ((Integer)localObject8).intValue();
            ((b.a)localObject4).gpm.put(localObject8, localObject5);
          }
        }
        label1723:
        for (;;)
        {
          if (Util.isNullOrNil((String)localObject1)) {
            localObject1 = localObject2;
          }
          for (;;)
          {
            localObject3 = localObject1;
            if (Util.isNullOrNil((String)localObject1))
            {
              j = 2131758343;
              switch (((Integer)localObject8).intValue())
              {
              }
            }
            for (;;)
            {
              localObject3 = MMApplicationContext.getContext().getString(j);
              ((yg)localObject5).eeB.desc = ((String)localObject3);
              ((yg)localObject5).eeB.url = ((String)localObject6);
              ((yg)localObject5).eeB.visible = true;
              ((yg)localObject5).eeB.dDH = 2;
              ((yg)localObject5).eeB.dDJ = ((b.a)localObject4).gpj;
              this.gpd.put(localObject8, Long.valueOf(l1));
              if (i == 0)
              {
                paramar.dDE.desc = ((String)localObject3);
                paramar.dDE.dDF = 30;
                paramar.dDE.dDG = 0;
                paramar.dDE.url = ((String)localObject6);
                paramar.dDE.visible = true;
                paramar.dDE.dDI = 2131495655;
                paramar.dDE.dDH = 2;
                paramar.dDE.Title = "";
                paramar.dDE.dDJ = String.valueOf(l1);
                paramar.dDE.position = ((Integer)localObject8).intValue();
              }
              MMHandlerThread.postToMainThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(20095);
                  EventCenter.instance.publish(this.gph);
                  AppMethodBeat.o(20095);
                }
              });
              localObject1 = localObject3;
              break;
              j = 2131758345;
              continue;
              j = 2131758342;
            }
            AppMethodBeat.o(20100);
            return true;
          }
        }
        localObject3 = localObject7;
        localObject2 = localObject6;
        localObject1 = localObject5;
        break label854;
        label1741:
        localObject5 = localObject1;
        localObject1 = localObject3;
      }
      label1756:
      localObject7 = null;
      localObject6 = null;
    }
  }
  
  final void alz()
  {
    AppMethodBeat.i(20102);
    if ((this.gpc == null) || (this.gpc.gpm.get(Integer.valueOf(0)) == null) || (Util.isNullOrNil(this.gpc.gpl)))
    {
      AppMethodBeat.o(20102);
      return;
    }
    Log.i("MicroMsg.BroadcastController", "summerdize checkShowDisasterContent showDisasterContent[%s]", new Object[] { this.gpc.gpl });
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("key_disaster_content", this.gpc.gpl);
    ((Intent)localObject).putExtra("key_disaster_url", ((yg)this.gpc.gpm.get(Integer.valueOf(0))).eeB.url);
    ((Intent)localObject).setClass(MMApplicationContext.getContext(), DisasterUI.class).addFlags(268435456);
    Context localContext = MMApplicationContext.getContext();
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/broadcast/BroadcastController", "checkShowDisasterContent", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/broadcast/BroadcastController", "checkShowDisasterContent", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    this.gpc.gpl = null;
    AppMethodBeat.o(20102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.h.b
 * JD-Core Version:    0.7.0.1
 */
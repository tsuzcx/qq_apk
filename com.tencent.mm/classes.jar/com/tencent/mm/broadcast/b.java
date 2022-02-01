package com.tencent.mm.broadcast;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.am.s;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.abh;
import com.tencent.mm.autogen.a.abh.a;
import com.tencent.mm.autogen.a.ay;
import com.tencent.mm.autogen.a.ay.a;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.model.bh;
import com.tencent.mm.platformtools.z;
import com.tencent.mm.plugin.account.ui.DisasterUI;
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
  public b.a lvq;
  public Map<Integer, Long> lvr;
  public Map<Long, b.a> lvs;
  public IListener lvt;
  
  public b()
  {
    AppMethodBeat.i(20099);
    this.lvr = new HashMap();
    this.lvs = new HashMap();
    this.lvt = new BroadcastController.1(this, f.hfK);
    AppMethodBeat.o(20099);
  }
  
  final boolean CI(final String paramString)
  {
    AppMethodBeat.i(20101);
    Log.i("MicroMsg.BroadcastController", "summerdiz handleEventOOB oldNoticeInfo[%s], event[%s]", new Object[] { this.lvq, paramString });
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
    if (this.lvq == null)
    {
      this.lvq = new b.a();
      paramString = new abh();
      this.lvq.lvA.put(Integer.valueOf(0), paramString);
      paramString.ieS.desc = "";
      paramString.ieS.url = "";
      paramString.ieS.hAN = 0;
      paramString.ieS.hAM = 30;
      paramString.ieS.visible = false;
      paramString.ieS.hAP = "";
      paramString.ieS.hAO = 0;
      paramString.ieS.hAQ = R.i.mmnotify_view;
      paramString.ieS.hAR = "";
      paramString.ieS.position = 0;
    }
    if (!z.pDx)
    {
      if ((this.lvq.lvy != 0L) && (Util.ticksToNow(this.lvq.lvy) < 1800000L))
      {
        Log.i("MicroMsg.BroadcastController", "disasterTick within half an hour, drop it");
        AppMethodBeat.o(20101);
        return false;
      }
      this.lvq.lvy = Util.currentTicks();
    }
    if (!z.pDy) {
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
    this.lvq.lvx = ((String)localMap.get(".e.NoticeId"));
    paramString = MMApplicationContext.getContext().getSharedPreferences("disaster_pref", g.aQe()).getString("disaster_noticeid_list_key", "");
    if ((!z.pDz) && (paramString.contains(this.lvq.lvx)))
    {
      Log.i("MicroMsg.BroadcastController", "noticeIdList %s contain notifyID:%s, drop id", new Object[] { paramString, this.lvq.lvx });
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
      label485:
      localObject3 = localObject3;
      localObject4 = (String)localMap.get((String)localObject3 + ".Language");
      if ((localObject4 == null) && (i > 3)) {
        break label1027;
      }
      if (!str.equalsIgnoreCase((String)localObject4)) {
        break label867;
      }
      str = (String)localMap.get((String)localObject3 + ".Content");
      localObject4 = (String)localMap.get((String)localObject3 + ".Url");
    }
    for (Object localObject3 = (String)localMap.get((String)localObject3 + ".Tips");; localObject3 = null)
    {
      if (Util.isNullOrNil(str))
      {
        Log.i("MicroMsg.BroadcastController", "handleEventOOB cann't hit curLang");
        label665:
        localObject3 = localObject1;
        if (Util.isNullOrNil((String)localObject1)) {
          localObject3 = MMApplicationContext.getContext().getString(R.l.disaster_default_url);
        }
        localObject1 = localObject2;
        if (Util.isNullOrNil((String)localObject2))
        {
          Log.i("MicroMsg.BroadcastController", "handleEventOOB defContent is also null use hardcode");
          localObject1 = MMApplicationContext.getContext().getString(R.l.disaster_default_content_default);
        }
        localObject2 = paramString;
        if (Util.isNullOrNil(paramString))
        {
          if (Util.isNullOrNil((String)localObject1)) {
            localObject2 = MMApplicationContext.getContext().getString(R.l.disaster_default_tips_default);
          }
        }
        else
        {
          label748:
          paramString = (abh)this.lvq.lvA.get(Integer.valueOf(0));
          paramString.ieS.desc = ((String)localObject2);
          paramString.ieS.url = ((String)localObject3);
          paramString.ieS.visible = true;
          paramString.ieS.hAO = 2;
          paramString.ieS.hAR = this.lvq.lvx;
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(20096);
              Log.i("MicroMsg.BroadcastController", "summerdiz handleEventOOB publish uiEvent");
              paramString.publish();
              AppMethodBeat.o(20096);
            }
          });
          this.lvq.lvz = ((String)localObject1);
          if (bh.aZW().foreground) {
            aLu();
          }
          AppMethodBeat.o(20101);
          return true;
          localObject3 = Integer.valueOf(i);
          break label485;
          label867:
          if (!"en".equalsIgnoreCase((String)localObject4)) {
            break label1014;
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
        break label748;
        localObject1 = localObject4;
        localObject2 = str;
        paramString = (String)localObject3;
        break label665;
        label1014:
        localObject3 = paramString;
        paramString = (String)localObject2;
      }
      label1027:
      localObject4 = null;
      str = null;
    }
  }
  
  final boolean a(ay paramay)
  {
    AppMethodBeat.i(20100);
    String str = paramay.hAK.event;
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
    if (!z.pDy) {
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
    ((b.a)localObject1).lvx = String.valueOf(l1);
    Object localObject2 = MMApplicationContext.getContext().getSharedPreferences("disaster_pref", g.aQe()).getString("disaster_noticeid_list_key", "");
    if ((!z.pDz) && (((String)localObject2).contains(((b.a)localObject1).lvx)))
    {
      Log.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster noticeIdList %s contain notifyID:%s, drop id", new Object[] { localObject2, ((b.a)localObject1).lvx });
      AppMethodBeat.o(20100);
      return false;
    }
    Object localObject4;
    if (this.lvs.size() > 0)
    {
      localObject4 = (b.a)this.lvs.get(Long.valueOf(l1));
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
      this.lvs.put(Long.valueOf(l1), localObject1);
      localObject4 = localObject1;
      continue;
      this.lvs.put(Long.valueOf(l1), localObject1);
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
      label653:
      localObject5 = localObject5;
      localObject7 = (String)localMap.get((String)localObject5 + ".Language");
      if ((localObject7 == null) && (j > 3)) {
        break label1757;
      }
      if (!((String)localObject6).equalsIgnoreCase((String)localObject7)) {
        break label1058;
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
        label855:
        localObject6 = localObject2;
        if (Util.isNullOrNil((String)localObject2)) {
          localObject6 = MMApplicationContext.getContext().getString(R.l.disaster_default_url);
        }
        localObject5 = localObject1;
        localObject2 = localObject3;
        if (i != 0)
        {
          localObject2 = localObject3;
          if (Util.isNullOrNil((String)localObject3)) {
            localObject2 = MMApplicationContext.getContext().getString(R.l.disaster_default_content_login);
          }
          localObject5 = localObject1;
          if (Util.isNullOrNil((String)localObject1)) {
            localObject5 = MMApplicationContext.getContext().getString(R.l.disaster_default_tips_login);
          }
          paramay.hAL.desc = ((String)localObject2);
          paramay.hAL.hAM = 30;
          paramay.hAL.hAN = 0;
          paramay.hAL.url = ((String)localObject6);
          paramay.hAL.visible = true;
          paramay.hAL.hAQ = 0;
          paramay.hAL.hAO = 6;
          paramay.hAL.hAP = "";
          paramay.hAL.hAR = String.valueOf(l1);
          paramay.hAL.position = 1;
        }
        if (((ArrayList)localObject8).size() == 0)
        {
          Log.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster no other position need to tip");
          AppMethodBeat.o(20100);
          return false;
          localObject5 = Integer.valueOf(j);
          break label653;
          label1058:
          if (!"en".equalsIgnoreCase((String)localObject7)) {
            break label1742;
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
        if ((((b.a)localObject4).lvy != 0L) && (Util.ticksToNow(((b.a)localObject4).lvy) < 1800000L))
        {
          Log.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster disasterTick within half an hour, drop it");
          AppMethodBeat.o(20100);
          return false;
        }
        ((b.a)localObject4).lvy = Util.currentTicks();
        localObject7 = ((ArrayList)localObject8).iterator();
        localObject1 = localObject5;
        while (((Iterator)localObject7).hasNext())
        {
          localObject8 = (Integer)((Iterator)localObject7).next();
          localObject3 = Long.valueOf(Util.nullAs((Long)this.lvr.get(localObject8), 0L));
          if ((((Long)localObject3).longValue() > 0L) && (((Long)localObject3).longValue() >= l1))
          {
            Log.i("MicroMsg.BroadcastController", "summerdiz p[%d] has bigger oldPositionNoticeId[%d, %d]", new Object[] { localObject8, localObject3, Long.valueOf(l1) });
          }
          else
          {
            localObject5 = (abh)((b.a)localObject4).lvA.get(localObject8);
            if (localObject5 != null) {
              break label1724;
            }
            localObject5 = new abh();
            ((abh)localObject5).ieS.hAN = 0;
            ((abh)localObject5).ieS.hAM = 30;
            ((abh)localObject5).ieS.hAP = "";
            ((abh)localObject5).ieS.hAQ = R.i.mmnotify_view;
            ((abh)localObject5).ieS.position = ((Integer)localObject8).intValue();
            ((b.a)localObject4).lvA.put(localObject8, localObject5);
          }
        }
        label1724:
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
              j = R.l.disaster_default_tips_default;
              switch (((Integer)localObject8).intValue())
              {
              }
            }
            for (;;)
            {
              localObject3 = MMApplicationContext.getContext().getString(j);
              ((abh)localObject5).ieS.desc = ((String)localObject3);
              ((abh)localObject5).ieS.url = ((String)localObject6);
              ((abh)localObject5).ieS.visible = true;
              ((abh)localObject5).ieS.hAO = 2;
              ((abh)localObject5).ieS.hAR = ((b.a)localObject4).lvx;
              this.lvr.put(localObject8, Long.valueOf(l1));
              if (i == 0)
              {
                paramay.hAL.desc = ((String)localObject3);
                paramay.hAL.hAM = 30;
                paramay.hAL.hAN = 0;
                paramay.hAL.url = ((String)localObject6);
                paramay.hAL.visible = true;
                paramay.hAL.hAQ = R.i.mmnotify_view;
                paramay.hAL.hAO = 2;
                paramay.hAL.hAP = "";
                paramay.hAL.hAR = String.valueOf(l1);
                paramay.hAL.position = ((Integer)localObject8).intValue();
              }
              MMHandlerThread.postToMainThread(new Runnable()
              {
                public final void run()
                {
                  AppMethodBeat.i(20095);
                  this.lvv.publish();
                  AppMethodBeat.o(20095);
                }
              });
              localObject1 = localObject3;
              break;
              j = R.l.disaster_default_tips_moment;
              continue;
              j = R.l.disaster_default_tips_chat;
            }
            AppMethodBeat.o(20100);
            return true;
          }
        }
        localObject3 = localObject7;
        localObject2 = localObject6;
        localObject1 = localObject5;
        break label855;
        label1742:
        localObject5 = localObject1;
        localObject1 = localObject3;
      }
      label1757:
      localObject7 = null;
      localObject6 = null;
    }
  }
  
  final void aLu()
  {
    AppMethodBeat.i(20102);
    if ((this.lvq == null) || (this.lvq.lvA.get(Integer.valueOf(0)) == null) || (Util.isNullOrNil(this.lvq.lvz)))
    {
      AppMethodBeat.o(20102);
      return;
    }
    Log.i("MicroMsg.BroadcastController", "summerdize checkShowDisasterContent showDisasterContent[%s]", new Object[] { this.lvq.lvz });
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("key_disaster_content", this.lvq.lvz);
    ((Intent)localObject).putExtra("key_disaster_url", ((abh)this.lvq.lvA.get(Integer.valueOf(0))).ieS.url);
    ((Intent)localObject).setClass(MMApplicationContext.getContext(), DisasterUI.class).addFlags(268435456);
    Context localContext = MMApplicationContext.getContext();
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/broadcast/BroadcastController", "checkShowDisasterContent", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/broadcast/BroadcastController", "checkShowDisasterContent", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    this.lvq.lvz = null;
    AppMethodBeat.o(20102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.broadcast.b
 * JD-Core Version:    0.7.0.1
 */
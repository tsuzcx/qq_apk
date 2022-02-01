package com.tencent.mm.h;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.an.t;
import com.tencent.mm.compatible.util.g;
import com.tencent.mm.f.a.at;
import com.tencent.mm.f.a.at.a;
import com.tencent.mm.f.a.zn;
import com.tencent.mm.f.a.zn.a;
import com.tencent.mm.model.bh;
import com.tencent.mm.platformtools.ac;
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
  public b.a iTl;
  public Map<Integer, Long> iTm;
  public Map<Long, b.a> iTn;
  public IListener iTo;
  
  public b()
  {
    AppMethodBeat.i(20099);
    this.iTm = new HashMap();
    this.iTn = new HashMap();
    this.iTo = new IListener() {};
    AppMethodBeat.o(20099);
  }
  
  final boolean Kc(String paramString)
  {
    AppMethodBeat.i(20101);
    Log.i("MicroMsg.BroadcastController", "summerdiz handleEventOOB oldNoticeInfo[%s], event[%s]", new Object[] { this.iTl, paramString });
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
    if (this.iTl == null)
    {
      this.iTl = new b.a();
      paramString = new zn();
      this.iTl.iTv.put(Integer.valueOf(0), paramString);
      paramString.fYQ.desc = "";
      paramString.fYQ.url = "";
      paramString.fYQ.fwp = 0;
      paramString.fYQ.fwo = 30;
      paramString.fYQ.visible = false;
      paramString.fYQ.fwr = "";
      paramString.fYQ.fwq = 0;
      paramString.fYQ.fws = R.i.mmnotify_view;
      paramString.fYQ.fwt = "";
      paramString.fYQ.position = 0;
    }
    if (!ac.mGW)
    {
      if ((this.iTl.iTt != 0L) && (Util.ticksToNow(this.iTl.iTt) < 1800000L))
      {
        Log.i("MicroMsg.BroadcastController", "disasterTick within half an hour, drop it");
        AppMethodBeat.o(20101);
        return false;
      }
      this.iTl.iTt = Util.currentTicks();
    }
    if (!ac.mGX) {
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
    this.iTl.iTs = ((String)localMap.get(".e.NoticeId"));
    paramString = MMApplicationContext.getContext().getSharedPreferences("disaster_pref", g.avK()).getString("disaster_noticeid_list_key", "");
    if ((!ac.mGY) && (paramString.contains(this.iTl.iTs)))
    {
      Log.i("MicroMsg.BroadcastController", "noticeIdList %s contain notifyID:%s, drop id", new Object[] { paramString, this.iTl.iTs });
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
      label484:
      localObject3 = localObject3;
      localObject4 = (String)localMap.get((String)localObject3 + ".Language");
      if ((localObject4 == null) && (i > 3)) {
        break label1026;
      }
      if (!str.equalsIgnoreCase((String)localObject4)) {
        break label866;
      }
      str = (String)localMap.get((String)localObject3 + ".Content");
      localObject4 = (String)localMap.get((String)localObject3 + ".Url");
    }
    for (Object localObject3 = (String)localMap.get((String)localObject3 + ".Tips");; localObject3 = null)
    {
      if (Util.isNullOrNil(str))
      {
        Log.i("MicroMsg.BroadcastController", "handleEventOOB cann't hit curLang");
        label664:
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
          label747:
          paramString = (zn)this.iTl.iTv.get(Integer.valueOf(0));
          paramString.fYQ.desc = ((String)localObject2);
          paramString.fYQ.url = ((String)localObject3);
          paramString.fYQ.visible = true;
          paramString.fYQ.fwq = 2;
          paramString.fYQ.fwt = this.iTl.iTs;
          MMHandlerThread.postToMainThread(new b.3(this, paramString));
          this.iTl.iTu = ((String)localObject1);
          if (bh.aGY().foreground) {
            ary();
          }
          AppMethodBeat.o(20101);
          return true;
          localObject3 = Integer.valueOf(i);
          break label484;
          label866:
          if (!"en".equalsIgnoreCase((String)localObject4)) {
            break label1013;
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
        break label747;
        localObject1 = localObject4;
        localObject2 = str;
        paramString = (String)localObject3;
        break label664;
        label1013:
        localObject3 = paramString;
        paramString = (String)localObject2;
      }
      label1026:
      localObject4 = null;
      str = null;
    }
  }
  
  final boolean a(at paramat)
  {
    AppMethodBeat.i(20100);
    String str = paramat.fwm.event;
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
    if (!ac.mGX) {
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
    ((b.a)localObject1).iTs = String.valueOf(l1);
    Object localObject2 = MMApplicationContext.getContext().getSharedPreferences("disaster_pref", g.avK()).getString("disaster_noticeid_list_key", "");
    if ((!ac.mGY) && (((String)localObject2).contains(((b.a)localObject1).iTs)))
    {
      Log.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster noticeIdList %s contain notifyID:%s, drop id", new Object[] { localObject2, ((b.a)localObject1).iTs });
      AppMethodBeat.o(20100);
      return false;
    }
    Object localObject4;
    if (this.iTn.size() > 0)
    {
      localObject4 = (b.a)this.iTn.get(Long.valueOf(l1));
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
      this.iTn.put(Long.valueOf(l1), localObject1);
      localObject4 = localObject1;
      continue;
      this.iTn.put(Long.valueOf(l1), localObject1);
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
        break label1757;
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
          paramat.fwn.desc = ((String)localObject2);
          paramat.fwn.fwo = 30;
          paramat.fwn.fwp = 0;
          paramat.fwn.url = ((String)localObject6);
          paramat.fwn.visible = true;
          paramat.fwn.fws = 0;
          paramat.fwn.fwq = 6;
          paramat.fwn.fwr = "";
          paramat.fwn.fwt = String.valueOf(l1);
          paramat.fwn.position = 1;
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
        if ((((b.a)localObject4).iTt != 0L) && (Util.ticksToNow(((b.a)localObject4).iTt) < 1800000L))
        {
          Log.i("MicroMsg.BroadcastController", "summerdiz handleNewDisaster disasterTick within half an hour, drop it");
          AppMethodBeat.o(20100);
          return false;
        }
        ((b.a)localObject4).iTt = Util.currentTicks();
        localObject7 = ((ArrayList)localObject8).iterator();
        localObject1 = localObject5;
        while (((Iterator)localObject7).hasNext())
        {
          localObject8 = (Integer)((Iterator)localObject7).next();
          localObject3 = Long.valueOf(Util.nullAs((Long)this.iTm.get(localObject8), 0L));
          if ((((Long)localObject3).longValue() > 0L) && (((Long)localObject3).longValue() >= l1))
          {
            Log.i("MicroMsg.BroadcastController", "summerdiz p[%d] has bigger oldPositionNoticeId[%d, %d]", new Object[] { localObject8, localObject3, Long.valueOf(l1) });
          }
          else
          {
            localObject5 = (zn)((b.a)localObject4).iTv.get(localObject8);
            if (localObject5 != null) {
              break label1724;
            }
            localObject5 = new zn();
            ((zn)localObject5).fYQ.fwp = 0;
            ((zn)localObject5).fYQ.fwo = 30;
            ((zn)localObject5).fYQ.fwr = "";
            ((zn)localObject5).fYQ.fws = R.i.mmnotify_view;
            ((zn)localObject5).fYQ.position = ((Integer)localObject8).intValue();
            ((b.a)localObject4).iTv.put(localObject8, localObject5);
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
              ((zn)localObject5).fYQ.desc = ((String)localObject3);
              ((zn)localObject5).fYQ.url = ((String)localObject6);
              ((zn)localObject5).fYQ.visible = true;
              ((zn)localObject5).fYQ.fwq = 2;
              ((zn)localObject5).fYQ.fwt = ((b.a)localObject4).iTs;
              this.iTm.put(localObject8, Long.valueOf(l1));
              if (i == 0)
              {
                paramat.fwn.desc = ((String)localObject3);
                paramat.fwn.fwo = 30;
                paramat.fwn.fwp = 0;
                paramat.fwn.url = ((String)localObject6);
                paramat.fwn.visible = true;
                paramat.fwn.fws = R.i.mmnotify_view;
                paramat.fwn.fwq = 2;
                paramat.fwn.fwr = "";
                paramat.fwn.fwt = String.valueOf(l1);
                paramat.fwn.position = ((Integer)localObject8).intValue();
              }
              MMHandlerThread.postToMainThread(new b.2(this, (zn)localObject5));
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
        break label854;
        label1742:
        localObject5 = localObject1;
        localObject1 = localObject3;
      }
      label1757:
      localObject7 = null;
      localObject6 = null;
    }
  }
  
  final void ary()
  {
    AppMethodBeat.i(20102);
    if ((this.iTl == null) || (this.iTl.iTv.get(Integer.valueOf(0)) == null) || (Util.isNullOrNil(this.iTl.iTu)))
    {
      AppMethodBeat.o(20102);
      return;
    }
    Log.i("MicroMsg.BroadcastController", "summerdize checkShowDisasterContent showDisasterContent[%s]", new Object[] { this.iTl.iTu });
    Object localObject = new Intent();
    ((Intent)localObject).putExtra("key_disaster_content", this.iTl.iTu);
    ((Intent)localObject).putExtra("key_disaster_url", ((zn)this.iTl.iTv.get(Integer.valueOf(0))).fYQ.url);
    ((Intent)localObject).setClass(MMApplicationContext.getContext(), DisasterUI.class).addFlags(268435456);
    Context localContext = MMApplicationContext.getContext();
    localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/broadcast/BroadcastController", "checkShowDisasterContent", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(localContext, "com/tencent/mm/broadcast/BroadcastController", "checkShowDisasterContent", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    this.iTl.iTu = null;
    AppMethodBeat.o(20102);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.h.b
 * JD-Core Version:    0.7.0.1
 */
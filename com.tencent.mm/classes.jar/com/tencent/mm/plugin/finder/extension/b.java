package com.tencent.mm.plugin.finder.extension;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.f.b;
import com.tencent.mm.am.g.a;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.model.bb;
import com.tencent.mm.model.cn;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.forcenotify.c.j;
import com.tencent.mm.plugin.forcenotify.core.c;
import com.tencent.mm.plugin.messenger.foundation.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.axy;
import com.tencent.mm.protocal.protobuf.cap;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.protocal.protobuf.tb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.cc;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.d;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/extension/FinderLiveNotifyMsgInterceptor;", "Lcom/tencent/mm/plugin/messenger/foundation/api/AppMessageInterceptor;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "afterMsgInsert", "", "addMsgInfo", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "contentValues", "", "beforeMsgInsert", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements a
{
  private final String TAG = "FinderLiveNotifyMsgInterceptor";
  
  private static final void a(Map paramMap, int paramInt, String paramString1, String paramString2, b paramb)
  {
    AppMethodBeat.i(366647);
    s.u(paramb, "this$0");
    Object localObject2 = Util.nullAsNil((String)paramMap.get(".msg.appmsg.extinfo.notifymsg.tipsinfo.force_push_info"));
    s.s(localObject2, "it");
    int i;
    if (((CharSequence)localObject2).length() > 0)
    {
      i = 1;
      if (i == 0) {
        break label350;
      }
    }
    label350:
    for (Object localObject1 = localObject2;; localObject1 = null)
    {
      if (localObject1 != null)
      {
        if (paramInt == 1) {}
        try
        {
          com.tencent.mm.ad.i locali = new com.tencent.mm.ad.i((String)localObject2);
          String str1 = locali.optString("description");
          locali.optString("expiredTime");
          Object localObject4 = new com.tencent.mm.ad.i(locali.optString("extinfo"));
          localObject2 = ((com.tencent.mm.ad.i)localObject4).optString("auth_icon_url");
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
          Object localObject3 = ((com.tencent.mm.ad.i)localObject4).optString("nickname");
          localObject2 = localObject3;
          if (localObject3 == null) {
            localObject2 = "";
          }
          ((com.tencent.mm.ad.i)localObject4).optString("start_time");
          localObject4 = locali.optString("subject");
          localObject3 = localObject4;
          if (localObject4 == null) {
            localObject3 = "";
          }
          localObject4 = locali.optString("forcePushId");
          String str2 = locali.optString("userIcon");
          locali.opt("userName");
          paramMap = Util.nullAsNil((String)paramMap.get(".msg.appmsg.extinfo.notifymsg.tipsinfo.object_id"));
          s.s(localObject4, "forcePushId");
          s.s(str2, "userIcon");
          s.s(str1, "dec");
          s.s(paramMap, "feedId");
          s.s(paramString1, "liveId");
          s.s(paramString2, "nonceId");
          paramMap = new j((String)localObject4, str2, (String)localObject2, str1, paramMap, paramString1, paramString2, (String)localObject1, (String)localObject3);
          c.Hoc.a(paramMap);
          AppMethodBeat.o(366647);
          return;
        }
        catch (Exception paramMap)
        {
          Log.i(paramb.TAG, s.X("force notify exception:", paramMap.getMessage()));
        }
        Log.i(paramb.TAG, "dont show force notify,case live has end.");
        AppMethodBeat.o(366647);
        return;
      }
      AppMethodBeat.o(366647);
      return;
      i = 0;
      break;
    }
  }
  
  public final void a(g.a parama, cc paramcc, Map<String, String> paramMap)
  {
    AppMethodBeat.i(366662);
    s.u(parama, "addMsgInfo");
    s.checkNotNull(paramMap);
    String str2 = Util.nullAsNil((String)paramMap.get(".msg.appmsg.extinfo.notifymsg.tipsinfo.live_id"));
    String str4 = Util.nullAsNil((String)paramMap.get(".msg.appmsg.extinfo.notifymsg.tipsinfo.object_id"));
    String str3 = Util.nullAsNil((String)paramMap.get(".msg.appmsg.extinfo.notifymsg.tipsinfo.object_nonce_id"));
    String str1 = Util.nullAsNil((String)paramMap.get(".msg.appmsg.extinfo.notifymsg.tipsinfo.revoke_id"));
    int j = Util.safeParseInt(Util.nullAsNil((String)paramMap.get(".msg.appmsg.extinfo.notifymsg.live_widget.status")));
    String str5 = Util.nullAsNil((String)paramMap.get(".msg.appmsg.extinfo.notifymsg.tipsinfo.tips_id"));
    long l1 = Util.safeParseLong(Util.nullAsNil((String)paramMap.get(".msg.appmsg.extinfo.notifymsg.tipsinfo.delivery_time")));
    s.checkNotNull(paramcc);
    long l2 = paramcc.field_msgId;
    int k = Util.safeParseInt(Util.nullAsNil((String)paramMap.get(".msg.appmsg.extinfo.notifymsg.tipsinfo.control_flag")));
    boolean bool = s.p(paramMap.get(".msg.appmsg.extinfo.notifymsg.tipsinfo.not_filter_by_live_id"), "1");
    ((com.tencent.mm.plugin.g)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.g.class)).aA(paramcc);
    Object localObject1 = new axy();
    Object localObject2;
    if ((parama.extra instanceof f.b))
    {
      localObject2 = parama.extra;
      if (localObject2 == null)
      {
        parama = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.modelbase.IFunctionMessageExtension.FetchAddMsgParams");
        AppMethodBeat.o(366662);
        throw parama;
      }
      localObject2 = (f.b)localObject2;
      if ((((f.b)localObject2).otK == null) || (((f.b)localObject2).otK.YYw == null)) {}
    }
    try
    {
      ((axy)localObject1).parseFrom(((f.b)localObject2).otK.YYw.toByteArray());
      localObject1 = ((axy)localObject1).ZIX.iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (cap)((Iterator)localObject1).next();
      } while (((cap)localObject2).Njv != parama.mpN.Njv);
      int i;
      if (localObject2 == null)
      {
        parama = "";
        localObject2 = Util.nullAsNil((String)paramMap.get(".msg.appmsg.extinfo.notifymsg.tipsinfo.force_push_info"));
        String str6 = Util.nullAsNil((String)paramMap.get(".msg.appmsg.extinfo.notifymsg.tipsinfo.notice_id"));
        s.s(localObject2, "it");
        if (((CharSequence)localObject2).length() <= 0) {
          break label728;
        }
        i = 1;
        label393:
        if (i == 0) {
          break label734;
        }
        localObject1 = localObject2;
        label402:
        if (localObject1 == null) {
          break label820;
        }
        localObject1 = new com.tencent.mm.ad.i((String)localObject2).optString("forcePushId");
        s.s(localObject1, "jsonObject.optString(\"forcePushId\")");
        int m = Util.safeParseInt(Util.nullAsNil((String)paramMap.get(".msg.appmsg.extinfo.notifymsg.tipsinfo.ctrlinfo_type")));
        String str7 = Util.nullAsNil((String)paramMap.get(".msg.appmsg.extinfo.notifymsg.tipsinfo.by_pass_info"));
        localObject2 = new com.tencent.d.a.a.a.d.a.g();
        s.s(str1, "revokeId");
        if (((CharSequence)str1).length() <= 0) {
          break label740;
        }
        i = 1;
        label501:
        if (i == 0) {
          break label746;
        }
        label506:
        ((com.tencent.d.a.a.a.d.a.g)localObject2).field_revokeId = str1;
        ((com.tencent.d.a.a.a.d.a.g)localObject2).field_exposureStatus = 0;
        ((com.tencent.d.a.a.a.d.a.g)localObject2).field_msgId = l2;
        ((com.tencent.d.a.a.a.d.a.g)localObject2).field_liveStatus = j;
        parama = parama.getBytes(d.UTF_8);
        s.s(parama, "(this as java.lang.String).getBytes(charset)");
        ((com.tencent.d.a.a.a.d.a.g)localObject2).field_businessBuf = parama;
        ((com.tencent.d.a.a.a.d.a.g)localObject2).field_insertTime = l1;
        ((com.tencent.d.a.a.a.d.a.g)localObject2).field_tipsId = str5;
        ((com.tencent.d.a.a.a.d.a.g)localObject2).field_liveId = str2;
        ((com.tencent.d.a.a.a.d.a.g)localObject2).field_controlFlag = k;
        ((com.tencent.d.a.a.a.d.a.g)localObject2).field_forcePushId = ((String)localObject1);
        ((com.tencent.d.a.a.a.d.a.g)localObject2).field_ctrlInfoType = m;
        ((com.tencent.d.a.a.a.d.a.g)localObject2).field_bypInfo = str7;
        ((com.tencent.d.a.a.a.d.a.g)localObject2).field_feedId = str4;
        parama = ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).getFinderLiveNotifyExposureInfoStorage();
        if (bool) {
          break label763;
        }
        bool = true;
        label633:
        parama.a((com.tencent.d.a.a.a.d.a.g)localObject2, bool);
        s.s(str6, "noticeId");
        if (((CharSequence)str6).length() != 0) {
          break label769;
        }
        i = 1;
      }
      for (;;)
      {
        if (i != 0)
        {
          parama = ((com.tencent.mm.plugin.notification.b.b)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.notification.b.b.class)).getNotification();
          if (parama == null)
          {
            parama = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.model.IOnNewMsgNotify");
            AppMethodBeat.o(366662);
            throw parama;
            localObject1 = ((cap)localObject2).report_ext_info;
            parama = (g.a)localObject1;
            if (localObject1 != null) {
              break;
            }
            parama = "";
            break;
            label728:
            i = 0;
            break label393;
            label734:
            localObject1 = null;
            break label402;
            label740:
            i = 0;
            break label501;
            label746:
            str1 = s.X("fakeRevoid_", Integer.valueOf(cn.getSyncServerTimeSecond()));
            break label506;
            label763:
            bool = false;
            break label633;
            label769:
            i = 0;
            continue;
          }
          ((bb)parama).a(paramcc);
        }
      }
      com.tencent.threadpool.h.ahAA.bo(new b..ExternalSyntheticLambda0(paramMap, j, str2, str3, this));
      AppMethodBeat.o(366662);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        continue;
        label820:
        localObject1 = "";
        continue;
        parama = "";
      }
    }
  }
  
  public final boolean b(g.a parama, cc paramcc, Map<String, String> paramMap)
  {
    AppMethodBeat.i(366674);
    s.u(parama, "addMsgInfo");
    if (paramcc != null) {
      paramcc.BS("notifymessage");
    }
    if (paramMap == null)
    {
      AppMethodBeat.o(366674);
      return false;
    }
    paramcc = Util.nullAsNil((String)paramMap.get(".msg.appmsg.extinfo.notifymsg.tipsinfo.live_id"));
    String str = Util.nullAsNil((String)paramMap.get(".msg.appmsg.extinfo.notifymsg.tipsinfo.revoke_id"));
    if (s.p(paramMap.get(".msg.appmsg.extinfo.notifymsg.tipsinfo.not_filter_by_live_id"), "1"))
    {
      parama = ((com.tencent.d.a.a.a.b)com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class)).getFinderLiveNotifyExposureInfoStorage().axL(str);
      Log.i(this.TAG, "notFilterByLiveId," + paramcc + ' ' + str + ' ' + parama.systemRowid);
      if (parama.systemRowid == -1L)
      {
        AppMethodBeat.o(366674);
        return true;
      }
      AppMethodBeat.o(366674);
      return false;
    }
    paramMap = w.a(parama.mpN.YFE);
    parama = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().aU(paramMap, parama.mpN.Njv);
    Log.i(this.TAG, "[FINDER_SERVICE_NOTIFY_FOLLOW_LIVE]  liveId " + paramcc + " revokeId " + str + " info.systemRowid " + parama.systemRowid);
    if (parama.systemRowid == -1L) {}
    for (boolean bool = true;; bool = false)
    {
      if (!bool) {
        Log.i(this.TAG, "[FINDER_SERVICE_NOTIFY_FOLLOW_LIVE]  this msg has been insert");
      }
      AppMethodBeat.o(366674);
      return bool;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.b
 * JD-Core Version:    0.7.0.1
 */
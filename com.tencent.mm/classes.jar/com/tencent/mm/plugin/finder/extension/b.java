package com.tencent.mm.plugin.finder.extension;

import com.tencent.c.a.a.a.d.a.e;
import com.tencent.c.a.a.a.d.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.g.b;
import com.tencent.mm.an.h.a;
import com.tencent.mm.model.bb;
import com.tencent.mm.model.cm;
import com.tencent.mm.plugin.forcenotify.c.c;
import com.tencent.mm.plugin.forcenotify.d.g;
import com.tencent.mm.protocal.protobuf.atk;
import com.tencent.mm.protocal.protobuf.bmv;
import com.tencent.mm.protocal.protobuf.db;
import com.tencent.mm.protocal.protobuf.rq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ca;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.d;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/extension/FinderLiveNotifyMsgInterceptor;", "Lcom/tencent/mm/plugin/messenger/foundation/api/AppMessageInterceptor;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "afterMsgInsert", "", "addMsgInfo", "Lcom/tencent/mm/modelbase/IMessageExtension$AddMsgInfo;", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "contentValues", "", "beforeMsgInsert", "", "plugin-finder_release"})
public final class b
  implements com.tencent.mm.plugin.messenger.foundation.a.a
{
  final String TAG = "FinderLiveNotifyMsgInterceptor";
  
  public final void a(h.a parama, ca paramca, final Map<String, String> paramMap)
  {
    AppMethodBeat.i(231443);
    p.k(parama, "addMsgInfo");
    if (paramMap == null) {
      p.iCn();
    }
    final String str1 = Util.nullAsNil((String)paramMap.get(".msg.appmsg.extinfo.notifymsg.tipsinfo.live_id"));
    final String str2 = Util.nullAsNil((String)paramMap.get(".msg.appmsg.extinfo.notifymsg.tipsinfo.object_nonce_id"));
    Object localObject2 = Util.nullAsNil((String)paramMap.get(".msg.appmsg.extinfo.notifymsg.tipsinfo.revoke_id"));
    int j = Util.safeParseInt(Util.nullAsNil((String)paramMap.get(".msg.appmsg.extinfo.notifymsg.live_widget.status")));
    String str3 = Util.nullAsNil((String)paramMap.get(".msg.appmsg.extinfo.notifymsg.tipsinfo.tips_id"));
    long l1 = Util.safeParseLong(Util.nullAsNil((String)paramMap.get(".msg.appmsg.extinfo.notifymsg.tipsinfo.delivery_time")));
    if (paramca == null) {
      p.iCn();
    }
    long l2 = paramca.apG();
    int k = Util.safeParseInt(Util.nullAsNil((String)paramMap.get(".msg.appmsg.extinfo.notifymsg.tipsinfo.control_flag")));
    Object localObject1 = com.tencent.mm.plugin.finder.live.i.xVA;
    com.tencent.mm.plugin.finder.live.i.aE(paramca);
    localObject1 = new atk();
    Object localObject3;
    if ((parama.lCh instanceof g.b))
    {
      localObject3 = parama.lCh;
      if (localObject3 == null)
      {
        parama = new t("null cannot be cast to non-null type com.tencent.mm.modelbase.IFunctionMessageExtension.FetchAddMsgParams");
        AppMethodBeat.o(231443);
        throw parama;
      }
      localObject3 = (g.b)localObject3;
      if ((((g.b)localObject3).lCa == null) || (((g.b)localObject3).lCa.Sax == null)) {}
    }
    try
    {
      ((atk)localObject1).parseFrom(((g.b)localObject3).lCa.Sax.toByteArray());
      localObject1 = ((atk)localObject1).SGn.iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject3 = (bmv)((Iterator)localObject1).next();
      } while (((bmv)localObject3).HlH != parama.jQG.HlH);
      if (localObject3 != null)
      {
        localObject1 = ((bmv)localObject3).report_ext_info;
        parama = (h.a)localObject1;
        if (localObject1 != null) {}
      }
      else
      {
        parama = "";
      }
      localObject3 = Util.nullAsNil((String)paramMap.get(".msg.appmsg.extinfo.notifymsg.tipsinfo.force_push_info"));
      String str4 = Util.nullAsNil((String)paramMap.get(".msg.appmsg.extinfo.notifymsg.tipsinfo.notice_id"));
      p.j(localObject3, "it");
      int i;
      label386:
      int m;
      e locale;
      if (((CharSequence)localObject3).length() > 0)
      {
        i = 1;
        if (i == 0) {
          break label545;
        }
        localObject1 = localObject3;
        if (localObject1 == null) {
          break label795;
        }
        localObject1 = new com.tencent.mm.ad.i((String)localObject3).optString("forcePushId");
        p.j(localObject1, "jsonObject.optString(\"forcePushId\")");
        m = Util.safeParseInt(Util.nullAsNil((String)paramMap.get(".msg.appmsg.extinfo.notifymsg.tipsinfo.ctrlinfo_type")));
        localObject3 = Util.nullAsNil((String)paramMap.get(".msg.appmsg.extinfo.notifymsg.tipsinfo.by_pass_info"));
        locale = new e();
        p.j(localObject2, "revokeId");
        if (((CharSequence)localObject2).length() <= 0) {
          break label551;
        }
        i = 1;
        label481:
        if (i == 0) {
          break label557;
        }
      }
      for (;;)
      {
        locale.field_revokeId = ((String)localObject2);
        locale.field_exposureStatus = 0;
        locale.field_msgId = l2;
        locale.field_liveStatus = j;
        localObject2 = d.UTF_8;
        if (parama != null) {
          break label580;
        }
        parama = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(231443);
        throw parama;
        i = 0;
        break;
        label545:
        localObject1 = null;
        break label386;
        label551:
        i = 0;
        break label481;
        label557:
        localObject2 = "fakeRevoid_" + cm.bfF();
      }
      label580:
      parama = parama.getBytes((Charset)localObject2);
      p.j(parama, "(this as java.lang.String).getBytes(charset)");
      locale.field_businessBuf = parama;
      locale.field_insertTime = l1;
      locale.field_tipsId = str3;
      locale.field_liveId = str1;
      locale.field_controlFlag = k;
      locale.field_forcePushId = ((String)localObject1);
      locale.field_ctrlInfoType = m;
      locale.field_bypInfo = ((String)localObject3);
      ((com.tencent.c.a.a.a.b)com.tencent.mm.kernel.h.ag(com.tencent.c.a.a.a.b.class)).getFinderLiveNotifyExposureInfoStorage().a(locale);
      p.j(str4, "noticeId");
      if (((CharSequence)str4).length() == 0) {
        i = 1;
      }
      while (i != 0)
      {
        parama = com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.notification.b.a.class);
        p.j(parama, "MMKernel.plugin(IPluginNotification::class.java)");
        parama = ((com.tencent.mm.plugin.notification.b.a)parama).getNotification();
        if (parama == null)
        {
          parama = new t("null cannot be cast to non-null type com.tencent.mm.model.IOnNewMsgNotify");
          AppMethodBeat.o(231443);
          throw parama;
          i = 0;
        }
        else
        {
          ((bb)parama).a(paramca);
        }
      }
      com.tencent.e.h.ZvG.bg((Runnable)new a(this, paramMap, str1, str2));
      AppMethodBeat.o(231443);
      return;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        continue;
        label795:
        localObject1 = "";
        continue;
        parama = "";
      }
    }
  }
  
  public final boolean b(h.a parama, ca paramca, Map<String, String> paramMap)
  {
    AppMethodBeat.i(231447);
    p.k(parama, "addMsgInfo");
    if (paramca != null) {
      paramca.Jm("notifymessage");
    }
    if (paramMap == null) {
      p.iCn();
    }
    parama = Util.nullAsNil((String)paramMap.get(".msg.appmsg.extinfo.notifymsg.tipsinfo.live_id"));
    paramca = ((com.tencent.c.a.a.a.b)com.tencent.mm.kernel.h.ag(com.tencent.c.a.a.a.b.class)).getFinderLiveNotifyExposureInfoStorage().aCL(parama);
    paramMap = Util.nullAsNil((String)paramMap.get(".msg.appmsg.extinfo.notifymsg.tipsinfo.revoke_id"));
    Log.i(this.TAG, "[FINDER_SERVICE_NOTIFY_FOLLOW_LIVE]  liveId " + parama + " revokeId " + paramMap + " info.systemRowid " + paramca.systemRowid);
    if (paramca.systemRowid == -1L) {}
    for (boolean bool = true;; bool = false)
    {
      if (!bool) {
        Log.i(this.TAG, "[FINDER_SERVICE_NOTIFY_FOLLOW_LIVE]  this msg has been insert");
      }
      AppMethodBeat.o(231447);
      return bool;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(b paramb, Map paramMap, String paramString1, String paramString2) {}
    
    public final void run()
    {
      AppMethodBeat.i(267669);
      Object localObject2 = Util.nullAsNil((String)paramMap.get(".msg.appmsg.extinfo.notifymsg.tipsinfo.force_push_info"));
      p.j(localObject2, "it");
      int i;
      if (((CharSequence)localObject2).length() > 0)
      {
        i = 1;
        if (i == 0) {
          break label304;
        }
      }
      label304:
      for (Object localObject1 = localObject2;; localObject1 = null)
      {
        if (localObject1 == null) {
          break label339;
        }
        try
        {
          Object localObject5 = new com.tencent.mm.ad.i((String)localObject2);
          String str1 = ((com.tencent.mm.ad.i)localObject5).optString("description");
          ((com.tencent.mm.ad.i)localObject5).optString("expiredTime");
          Object localObject4 = new com.tencent.mm.ad.i(((com.tencent.mm.ad.i)localObject5).optString("extinfo"));
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
          localObject4 = ((com.tencent.mm.ad.i)localObject5).optString("subject");
          localObject3 = localObject4;
          if (localObject4 == null) {
            localObject3 = "";
          }
          localObject4 = ((com.tencent.mm.ad.i)localObject5).optString("forcePushId");
          String str2 = ((com.tencent.mm.ad.i)localObject5).optString("userIcon");
          ((com.tencent.mm.ad.i)localObject5).opt("userName");
          localObject5 = Util.nullAsNil((String)paramMap.get(".msg.appmsg.extinfo.notifymsg.tipsinfo.object_id"));
          p.j(localObject4, "forcePushId");
          p.j(str2, "userIcon");
          p.j(str1, "dec");
          p.j(localObject5, "feedId");
          String str3 = str1;
          p.j(str3, "liveId");
          String str4 = str2;
          p.j(str4, "nonceId");
          localObject1 = new g((String)localObject4, str2, (String)localObject2, str1, (String)localObject5, str3, str4, (String)localObject1, (String)localObject3);
          c.BDQ.a((g)localObject1);
          AppMethodBeat.o(267669);
          return;
        }
        catch (Exception localException)
        {
          Log.i(this.xrS.TAG, "force notify exception:" + localException.getMessage());
        }
        i = 0;
        break;
      }
      label339:
      AppMethodBeat.o(267669);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.b
 * JD-Core Version:    0.7.0.1
 */
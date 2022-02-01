package com.tencent.mm.plugin.bbom;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.l;
import com.tencent.mm.aj.m;
import com.tencent.mm.aj.u;
import com.tencent.mm.aj.v;
import com.tencent.mm.ao.g;
import com.tencent.mm.api.c.b;
import com.tencent.mm.f.a.dd;
import com.tencent.mm.f.a.dd.b;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bh;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.plugin.brandservice.ui.timeline.i;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.model.j;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.chatting.e;
import com.tencent.mm.ui.chatting.s;
import com.tencent.mm.ui.chatting.viewitems.by;
import com.tencent.mm.ui.chatting.viewitems.e.g;
import com.tencent.mm.ui.chatting.viewitems.e.h;
import com.tencent.mm.ui.f.r;

public final class d
  implements com.tencent.mm.plugin.brandservice.a.b
{
  public final void RP()
  {
    AppMethodBeat.i(288870);
    MMAppMgr.RP();
    AppMethodBeat.o(288870);
  }
  
  public final void a(int paramInt, Context paramContext, String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(22350);
    s.a(paramInt, paramContext, paramString1, paramString2, paramLong1, paramLong2);
    AppMethodBeat.o(22350);
  }
  
  public final void a(long paramLong, int paramInt, Context paramContext, Activity paramActivity, ca paramca)
  {
    AppMethodBeat.i(288867);
    s.a(paramLong, paramInt, paramContext, null, paramActivity, paramca);
    AppMethodBeat.o(288867);
  }
  
  public final void a(View paramView, long paramLong, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(22346);
    e.g localg = new e.g();
    localg.msgId = paramLong;
    localg.XeO = paramInt;
    localg.xml = paramString2;
    localg.fKH = paramString1;
    paramView.setTag(localg);
    AppMethodBeat.o(22346);
  }
  
  public final void a(View paramView, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(288868);
    e.g localg = new e.g();
    e.h localh = new e.h();
    localg.XeN = localh;
    localh.title = paramString2;
    localh.url = paramString3;
    localh.QuD = paramString1;
    localh.coverUrl = paramString5;
    localh.lpY = paramString4;
    paramView.setTag(localg);
    AppMethodBeat.o(288868);
  }
  
  public final void a(v paramv, final z paramz, int paramInt1, u paramu, View paramView, boolean paramBoolean, final int paramInt2, final i parami)
  {
    AppMethodBeat.i(22348);
    String str2 = aa.PJ(paramz.field_talker);
    String str1 = paramv.url;
    Object localObject = paramz.field_talker;
    if ((!TextUtils.isEmpty(str1)) && (str1.contains("http://" + WeChatHosts.domainString(R.l.host_weixin_qq_com) + "/emoticonstore/")))
    {
      str1 = str1.substring(str1.lastIndexOf("/") + 1);
      as localas = ((n)h.ae(n.class)).bbL().RG((String)localObject);
      if ((com.tencent.mm.contact.d.rk(localas.field_type)) && (localas.hxX()))
      {
        localObject = g.gu((String)localObject);
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.api.c)localObject).dc(false);
          if ((localObject != null) && (!TextUtils.isEmpty(((c.b)localObject).Zv())) && (str1.contains(((c.b)localObject).Zv())))
          {
            if (TextUtils.isEmpty(str1)) {
              break label397;
            }
            paramu = new by(null, false, paramInt1, paramv.url, paramBoolean, str2, paramu.fUd, paramu.fUe, paramv.title, str1, null, false, false);
            paramView.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(22344);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bn(paramAnonymousView);
                a.c("com/tencent/mm/plugin/bbom/BizTimeLineServices$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                s.a(paramAnonymousView, paramAnonymousView.getContext(), paramz.field_talker);
                a.a(this, "com/tencent/mm/plugin/bbom/BizTimeLineServices$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(22344);
              }
            });
          }
        }
      }
    }
    for (;;)
    {
      if (paramu != null)
      {
        paramu.PVT = paramz.field_msgSvrId;
        paramu.PVU = paramInt2;
        paramu.XmO = paramz;
        paramView.setTag(paramu);
      }
      if (m.OS(paramv.lpP)) {
        s.a(paramv, paramView, paramz.field_talker);
      }
      if (((paramInt2 < 2) || (paramz.field_isExpand)) && (((com.tencent.mm.plugin.brandservice.a.c)h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).Gw(1)) && (!TextUtils.isEmpty(paramv.url)))
      {
        Log.d("MicroMsg.BizTimeLineServices", "terry trace: preload %s:%s", new Object[] { str2, paramv.title });
        ((com.tencent.mm.plugin.brandservice.a.c)h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).a(paramv.url, paramv.type, 90, new Object[0]);
      }
      AppMethodBeat.o(22348);
      return;
      str1 = null;
      break;
      label397:
      if (!Util.isNullOrNil(paramv.url))
      {
        paramu = new by(null, false, paramInt1, paramv.url, paramBoolean, str2, paramu.fUd, paramu.fUe, paramv.title);
        paramu.gco = 56;
        paramu.XmP = paramv.type;
        str1 = paramz.field_talker;
        localObject = new Bundle();
        ((Bundle)localObject).putString("share_report_pre_msg_url", paramv.url);
        ((Bundle)localObject).putString("share_report_pre_msg_title", paramv.title);
        ((Bundle)localObject).putString("share_report_pre_msg_desc", paramv.lpM);
        ((Bundle)localObject).putString("share_report_pre_msg_icon_url", m.a(paramv));
        ((Bundle)localObject).putString("share_report_pre_msg_appid", "");
        ((Bundle)localObject).putInt("share_report_from_scene", 5);
        ((Bundle)localObject).putString("share_report_biz_username", str1);
        paramu.XmN = ((Bundle)localObject);
        paramView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(22345);
            Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramAnonymousView);
            a.c("com/tencent/mm/plugin/bbom/BizTimeLineServices$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
            localObject1 = MPVideoPreviewMgr.sSn;
            MPVideoPreviewMgr.a(paramz, "PAUSE_FOR_RESUME");
            int m = (int)(System.currentTimeMillis() / 1000L);
            localObject1 = paramAnonymousView.getContext();
            paramAnonymousView = (by)paramAnonymousView.getTag();
            z localz = paramAnonymousView.XmO;
            if (localz == null) {
              Log.e("MicroMsg.ChattingItemHelper", "onBizTimeLineWebViewClick info is null");
            }
            int i;
            int k;
            do
            {
              do
              {
                if (parami != null) {
                  parami.a(paramz, paramInt2, m);
                }
                a.a(this, "com/tencent/mm/plugin/bbom/BizTimeLineServices$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(22345);
                return;
                i = 10000;
                if ((localObject1 instanceof Activity)) {
                  i = ((Activity)localObject1).getIntent().getIntExtra("KOpenArticleSceneFromScene", 10000);
                }
                Log.i("MicroMsg.ChattingItemHelper", "onWebViewClick = %d", new Object[] { Integer.valueOf(m) });
              } while (e.a(paramAnonymousView.gbn, (Context)localObject1, null, localz.field_talker));
              k = 90;
              str = paramAnonymousView.userName;
              localObject3 = paramAnonymousView.UJu;
            } while ((str == null) || (str.equals("")));
            bh.beI();
            Object localObject2 = com.tencent.mm.model.c.bbL().RG(localz.field_talker);
            int j = k;
            if (!localz.hwB())
            {
              j = k;
              if (localObject2 != null)
              {
                j = k;
                if (!com.tencent.mm.contact.d.rk(((ax)localObject2).field_type)) {
                  j = 157;
                }
              }
            }
            String str = m.e(str, j, i, m);
            Intent localIntent = new Intent();
            localIntent.putExtra("rawUrl", str);
            localIntent.putExtra("shortUrl", str);
            localIntent.putExtra("webpageTitle", (String)localObject3);
            Object localObject3 = new Bundle();
            if ((localObject2 != null) && (((as)localObject2).hxX()))
            {
              k = 4;
              Log.d("MicroMsg.ChattingItemHelper", "hakon click biz msg %s", new Object[] { ((ax)localObject2).field_username });
            }
            for (;;)
            {
              localIntent.putExtra("msg_id", localz.field_msgId);
              localIntent.putExtra("KPublisherId", "msg_" + localz.field_msgSvrId);
              localIntent.putExtra("pre_username", localz.field_talker);
              localIntent.putExtra("prePublishId", "msg_" + localz.field_msgSvrId);
              localIntent.putExtra("preUsername", localz.field_talker);
              localIntent.putExtra("preChatName", localz.field_talker);
              localIntent.putExtra("preChatTYPE", 7);
              localIntent.putExtra("preMsgIndex", paramAnonymousView.PVU);
              localObject2 = paramAnonymousView.XmN;
              if (localObject2 != null) {
                localIntent.putExtras((Bundle)localObject2);
              }
              ((Bundle)localObject3).putInt("snsWebSource", k);
              localIntent.putExtra("jsapiargs", (Bundle)localObject3);
              localIntent.putExtra("geta8key_username", localz.field_talker);
              if (!ae.isNullOrNil(paramAnonymousView.fUd))
              {
                localIntent.putExtra("srcUsername", paramAnonymousView.fUd);
                localIntent.putExtra("srcDisplayname", paramAnonymousView.fUe);
                localIntent.putExtra("mode", 1);
              }
              localIntent.putExtra("message_id", paramAnonymousView.PVT);
              localIntent.putExtra("message_index", paramAnonymousView.PVU);
              localIntent.putExtra("from_scence", 1);
              localIntent.putExtra("geta8key_scene", paramAnonymousView.gco);
              localIntent.addFlags(536870912);
              localIntent.putExtra("start_activity_time", System.currentTimeMillis());
              localIntent.putExtra(f.r.VSO, paramAnonymousView.XmP);
              if ((((com.tencent.mm.plugin.brandservice.a.c)h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).Gw(1)) && (((com.tencent.mm.plugin.brandservice.a.c)h.ae(com.tencent.mm.plugin.brandservice.a.c.class)).a((Context)localObject1, str, paramAnonymousView.XmP, j, i, localIntent)))
              {
                Log.i("MicroMsg.ChattingItemHelper", "jump to TmplWebview");
                break;
              }
              com.tencent.mm.by.c.b((Context)localObject1, "webview", ".ui.tools.WebViewUI", localIntent);
              break;
              k = 0;
            }
          }
        });
      }
      else
      {
        paramu = null;
      }
    }
  }
  
  public final void a(ca paramca, Activity paramActivity)
  {
    AppMethodBeat.i(22352);
    if (!paramca.erk())
    {
      dd localdd = new dd();
      j.d(localdd, paramca);
      localdd.fyI.activity = paramActivity;
      localdd.fyI.fyP = 43;
      EventCenter.instance.publish(localdd);
      if (localdd.fyJ.ret == 0) {
        com.tencent.mm.modelstat.b.mcf.aj(paramca);
      }
    }
    AppMethodBeat.o(22352);
  }
  
  public final void a(ca paramca, Context paramContext)
  {
    AppMethodBeat.i(22353);
    s.a(paramca, paramContext, null);
    AppMethodBeat.o(22353);
  }
  
  public final void b(com.tencent.mm.api.c paramc, Activity paramActivity, as paramas)
  {
    AppMethodBeat.i(22349);
    com.tencent.mm.ui.tools.c.a(paramc, paramActivity, paramas, 3);
    AppMethodBeat.o(22349);
  }
  
  public final long dN(View paramView)
  {
    AppMethodBeat.i(22347);
    s.hL(paramView);
    if ((paramView.getTag() instanceof e.g))
    {
      long l = ((e.g)paramView.getTag()).msgId;
      AppMethodBeat.o(22347);
      return l;
    }
    AppMethodBeat.o(22347);
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.d
 * JD-Core Version:    0.7.0.1
 */
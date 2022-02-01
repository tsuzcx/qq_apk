package com.tencent.mm.plugin.bbom;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.u;
import com.tencent.mm.api.c.b;
import com.tencent.mm.g.a.cv;
import com.tencent.mm.g.a.cv.b;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.ba;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.brandservice.ui.timeline.j;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bu;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.chatting.e;
import com.tencent.mm.ui.chatting.r;
import com.tencent.mm.ui.chatting.viewitems.bk;
import com.tencent.mm.ui.chatting.viewitems.e.g;
import com.tencent.mm.ui.chatting.viewitems.e.h;
import com.tencent.mm.ui.e.m;

public final class d
  implements com.tencent.mm.plugin.brandservice.a.a
{
  public final void a(int paramInt, Context paramContext, String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(22350);
    r.a(paramInt, paramContext, paramString1, paramString2, paramLong1, paramLong2);
    AppMethodBeat.o(22350);
  }
  
  public final void a(long paramLong, int paramInt, Context paramContext, Activity paramActivity, bu parambu)
  {
    AppMethodBeat.i(22351);
    r.a(paramLong, paramInt, paramContext, null, paramActivity, parambu);
    AppMethodBeat.o(22351);
  }
  
  public final void a(View paramView, long paramLong, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(22346);
    e.g localg = new e.g();
    localg.msgId = paramLong;
    localg.KaJ = paramInt;
    localg.dBS = paramString2;
    localg.dyy = paramString1;
    paramView.setTag(localg);
    AppMethodBeat.o(22346);
  }
  
  public final void a(View paramView, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(193162);
    e.g localg = new e.g();
    e.h localh = new e.h();
    localg.KaI = localh;
    localh.title = paramString2;
    localh.url = paramString3;
    localh.Epf = paramString1;
    localh.coverUrl = paramString5;
    localh.hDA = paramString4;
    paramView.setTag(localg);
    AppMethodBeat.o(193162);
  }
  
  public final void a(com.tencent.mm.ai.v paramv, final w paramw, int paramInt1, u paramu, View paramView, boolean paramBoolean, final int paramInt2, final j paramj)
  {
    AppMethodBeat.i(22348);
    String str2 = com.tencent.mm.model.v.zf(paramw.field_talker);
    String str1 = paramv.url;
    Object localObject = paramw.field_talker;
    if ((!TextUtils.isEmpty(str1)) && (str1.contains("http://weixin.qq.com/emoticonstore/")))
    {
      str1 = str1.substring(str1.lastIndexOf("/") + 1);
      am localam = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().Bf((String)localObject);
      if ((com.tencent.mm.o.b.lM(localam.field_type)) && (localam.fqg()))
      {
        localObject = com.tencent.mm.am.g.eS((String)localObject);
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.api.c)localObject).bX(false);
          if ((localObject != null) && (!TextUtils.isEmpty(((c.b)localObject).KL())) && (str1.contains(((c.b)localObject).KL())))
          {
            if (TextUtils.isEmpty(str1)) {
              break label369;
            }
            paramu = new bk(null, false, paramInt1, paramv.url, paramBoolean, str2, paramu.dHo, paramu.dHp, paramv.title, str1, null, false, false);
            paramView.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(22344);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/bbom/BizTimeLineServices$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
                r.a(paramAnonymousView, paramAnonymousView.getContext(), paramw.field_talker);
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/bbom/BizTimeLineServices$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
        paramu.DUA = paramw.field_msgSvrId;
        paramu.DUB = paramInt2;
        paramu.KhA = paramw;
        paramView.setTag(paramu);
      }
      if (m.yt(paramv.hDr)) {
        r.a(paramv, paramView, paramw.field_talker);
      }
      if (((paramInt2 < 2) || (paramw.field_isExpand)) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).zc(1)) && (!TextUtils.isEmpty(paramv.url)))
      {
        ad.d("MicroMsg.BizTimeLineServices", "terry trace: preload %s:%s", new Object[] { str2, paramv.title });
        ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(paramv.url, paramv.type, 90, new Object[0]);
      }
      AppMethodBeat.o(22348);
      return;
      str1 = null;
      break;
      label369:
      if (!bt.isNullOrNil(paramv.url))
      {
        paramu = new bk(null, false, paramInt1, paramv.url, paramBoolean, str2, paramu.dHo, paramu.dHp, paramv.title);
        paramu.dOE = 56;
        paramu.KhB = paramv.type;
        str1 = paramw.field_talker;
        localObject = new Bundle();
        ((Bundle)localObject).putString("share_report_pre_msg_url", paramv.url);
        ((Bundle)localObject).putString("share_report_pre_msg_title", paramv.title);
        ((Bundle)localObject).putString("share_report_pre_msg_desc", paramv.hDo);
        ((Bundle)localObject).putString("share_report_pre_msg_icon_url", m.a(paramv));
        ((Bundle)localObject).putString("share_report_pre_msg_appid", "");
        ((Bundle)localObject).putInt("share_report_from_scene", 5);
        ((Bundle)localObject).putString("share_report_biz_username", str1);
        paramu.Khz = ((Bundle)localObject);
        paramView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(22345);
            Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/bbom/BizTimeLineServices$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahq());
            int m = (int)(System.currentTimeMillis() / 1000L);
            localObject1 = paramAnonymousView.getContext();
            paramAnonymousView = (bk)paramAnonymousView.getTag();
            w localw = paramAnonymousView.KhA;
            if (localw == null) {
              ad.e("MicroMsg.ChattingItemHelper", "onBizTimeLineWebViewClick info is null");
            }
            int i;
            int k;
            do
            {
              do
              {
                if (paramj != null) {
                  paramj.a(paramw, paramInt2, m);
                }
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/bbom/BizTimeLineServices$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(22345);
                return;
                i = 10000;
                if ((localObject1 instanceof Activity)) {
                  i = ((Activity)localObject1).getIntent().getIntExtra("KOpenArticleSceneFromScene", 10000);
                }
                ad.i("MicroMsg.ChattingItemHelper", "onWebViewClick = %d", new Object[] { Integer.valueOf(m) });
              } while (e.a(paramAnonymousView.dNL, (Context)localObject1, null, localw.field_talker));
              k = 90;
              str = paramAnonymousView.userName;
              localObject3 = paramAnonymousView.Khu;
            } while ((str == null) || (str.equals("")));
            ba.aBQ();
            Object localObject2 = com.tencent.mm.model.c.azp().Bf(localw.field_talker);
            int j = k;
            if (!localw.fpe())
            {
              j = k;
              if (localObject2 != null)
              {
                j = k;
                if (!com.tencent.mm.o.b.lM(((aw)localObject2).field_type)) {
                  j = 157;
                }
              }
            }
            String str = m.d(str, j, i, m);
            Intent localIntent = new Intent();
            localIntent.putExtra("rawUrl", str);
            localIntent.putExtra("shortUrl", str);
            localIntent.putExtra("webpageTitle", (String)localObject3);
            Object localObject3 = new Bundle();
            if ((localObject2 != null) && (((am)localObject2).fqg()))
            {
              k = 4;
              ad.d("MicroMsg.ChattingItemHelper", "hakon click biz msg %s", new Object[] { ((aw)localObject2).field_username });
            }
            for (;;)
            {
              localIntent.putExtra("msg_id", localw.field_msgId);
              localIntent.putExtra("KPublisherId", "msg_" + localw.field_msgSvrId);
              localIntent.putExtra("pre_username", localw.field_talker);
              localIntent.putExtra("prePublishId", "msg_" + localw.field_msgSvrId);
              localIntent.putExtra("preUsername", localw.field_talker);
              localIntent.putExtra("preChatName", localw.field_talker);
              localIntent.putExtra("preChatTYPE", 7);
              localIntent.putExtra("preMsgIndex", paramAnonymousView.DUB);
              localObject2 = paramAnonymousView.Khz;
              if (localObject2 != null) {
                localIntent.putExtras((Bundle)localObject2);
              }
              ((Bundle)localObject3).putInt("snsWebSource", k);
              localIntent.putExtra("jsapiargs", (Bundle)localObject3);
              localIntent.putExtra("geta8key_username", localw.field_talker);
              if (!af.isNullOrNil(paramAnonymousView.dHo))
              {
                localIntent.putExtra("srcUsername", paramAnonymousView.dHo);
                localIntent.putExtra("srcDisplayname", paramAnonymousView.dHp);
                localIntent.putExtra("mode", 1);
              }
              localIntent.putExtra("message_id", paramAnonymousView.DUA);
              localIntent.putExtra("message_index", paramAnonymousView.DUB);
              localIntent.putExtra("from_scence", 1);
              localIntent.putExtra("geta8key_scene", paramAnonymousView.dOE);
              localIntent.addFlags(536870912);
              localIntent.putExtra("start_activity_time", System.currentTimeMillis());
              localIntent.putExtra(e.m.IUR, paramAnonymousView.KhB);
              if ((((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).zc(1)) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a((Context)localObject1, str, paramAnonymousView.KhB, j, i, localIntent)))
              {
                ad.i("MicroMsg.ChattingItemHelper", "jump to TmplWebview");
                break;
              }
              com.tencent.mm.bs.d.b((Context)localObject1, "webview", ".ui.tools.WebViewUI", localIntent);
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
  
  public final void a(bu parambu, Activity paramActivity)
  {
    AppMethodBeat.i(22352);
    if (!parambu.cTc())
    {
      cv localcv = new cv();
      com.tencent.mm.pluginsdk.model.g.e(localcv, parambu);
      localcv.dnG.activity = paramActivity;
      localcv.dnG.dnM = 43;
      com.tencent.mm.sdk.b.a.IbL.l(localcv);
      if (localcv.dnH.ret == 0) {
        com.tencent.mm.modelstat.b.inZ.S(parambu);
      }
    }
    AppMethodBeat.o(22352);
  }
  
  public final void a(bu parambu, Context paramContext)
  {
    AppMethodBeat.i(22353);
    r.a(parambu, paramContext, null);
    AppMethodBeat.o(22353);
  }
  
  public final void b(com.tencent.mm.api.c paramc, Activity paramActivity, am paramam)
  {
    AppMethodBeat.i(22349);
    com.tencent.mm.ui.tools.b.a(paramc, paramActivity, paramam, 3);
    AppMethodBeat.o(22349);
  }
  
  public final void bgl()
  {
    AppMethodBeat.i(193163);
    MMAppMgr.xm(true);
    AppMethodBeat.o(193163);
  }
  
  public final long dz(View paramView)
  {
    AppMethodBeat.i(22347);
    r.gj(paramView);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.d
 * JD-Core Version:    0.7.0.1
 */
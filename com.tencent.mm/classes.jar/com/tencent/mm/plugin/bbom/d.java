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
import com.tencent.mm.am.f;
import com.tencent.mm.api.c.b;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.cs.b;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.az;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.s;
import com.tencent.mm.ui.chatting.e;
import com.tencent.mm.ui.chatting.r;
import com.tencent.mm.ui.chatting.viewitems.bi;
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
  
  public final void a(long paramLong, int paramInt, Context paramContext, Activity paramActivity, bl parambl)
  {
    AppMethodBeat.i(22351);
    r.a(paramLong, paramInt, paramContext, null, paramActivity, parambl);
    AppMethodBeat.o(22351);
  }
  
  public final void a(View paramView, long paramLong, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(22346);
    e.g localg = new e.g();
    localg.msgId = paramLong;
    localg.GKo = paramInt;
    localg.dsv = paramString2;
    localg.dpa = paramString1;
    paramView.setTag(localg);
    AppMethodBeat.o(22346);
  }
  
  public final void a(View paramView, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(191154);
    e.g localg = new e.g();
    e.h localh = new e.h();
    localg.GKn = localh;
    localh.title = paramString2;
    localh.url = paramString3;
    localh.Btj = paramString1;
    localh.coverUrl = paramString5;
    localh.gKR = paramString4;
    paramView.setTag(localg);
    AppMethodBeat.o(191154);
  }
  
  public final void a(com.tencent.mm.ai.v paramv, final s params, int paramInt1, u paramu, View paramView, boolean paramBoolean, final int paramInt2, final com.tencent.mm.plugin.brandservice.ui.timeline.k paramk)
  {
    AppMethodBeat.i(22348);
    String str2 = com.tencent.mm.model.v.sh(params.field_talker);
    String str1 = paramv.url;
    Object localObject = params.field_talker;
    if ((!TextUtils.isEmpty(str1)) && (str1.contains("http://weixin.qq.com/emoticonstore/")))
    {
      str1 = str1.substring(str1.lastIndexOf("/") + 1);
      af localaf = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY((String)localObject);
      if ((com.tencent.mm.n.b.ls(localaf.field_type)) && (localaf.eKB()))
      {
        localObject = f.ei((String)localObject);
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.api.c)localObject).bU(false);
          if ((localObject != null) && (!TextUtils.isEmpty(((c.b)localObject).JD())) && (str1.contains(((c.b)localObject).JD())))
          {
            if (TextUtils.isEmpty(str1)) {
              break label369;
            }
            paramu = new bi(null, false, paramInt1, paramv.url, paramBoolean, str2, paramu.dxz, paramu.dxA, paramv.title, str1, null, false, false);
            paramView.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(22344);
                r.a(paramAnonymousView, paramAnonymousView.getContext(), params.field_talker);
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
        paramu.AYJ = params.field_msgSvrId;
        paramu.AYK = paramInt2;
        paramu.GQW = params;
        paramView.setTag(paramu);
      }
      if (m.rz(paramv.gKI)) {
        r.a(paramv, paramView, params.field_talker);
      }
      if (((paramInt2 < 2) || (params.field_isExpand)) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).xA(1)) && (!TextUtils.isEmpty(paramv.url)))
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
        paramu = new bi(null, false, paramInt1, paramv.url, paramBoolean, str2, paramu.dxz, paramu.dxA, paramv.title);
        paramu.dEF = 56;
        paramu.GQX = paramv.type;
        str1 = params.field_talker;
        localObject = new Bundle();
        ((Bundle)localObject).putString("share_report_pre_msg_url", paramv.url);
        ((Bundle)localObject).putString("share_report_pre_msg_title", paramv.title);
        ((Bundle)localObject).putString("share_report_pre_msg_desc", paramv.gKF);
        ((Bundle)localObject).putString("share_report_pre_msg_icon_url", m.a(paramv));
        ((Bundle)localObject).putString("share_report_pre_msg_appid", "");
        ((Bundle)localObject).putInt("share_report_from_scene", 5);
        ((Bundle)localObject).putString("share_report_biz_username", str1);
        paramu.GQV = ((Bundle)localObject);
        paramView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(22345);
            int m = (int)(System.currentTimeMillis() / 1000L);
            Context localContext = paramAnonymousView.getContext();
            paramAnonymousView = (bi)paramAnonymousView.getTag();
            s locals = paramAnonymousView.GQW;
            if (locals == null) {
              ad.e("MicroMsg.ChattingItemHelper", "onBizTimeLineWebViewClick info is null");
            }
            int i;
            int k;
            do
            {
              do
              {
                if (paramk != null) {
                  paramk.a(params, paramInt2, m);
                }
                AppMethodBeat.o(22345);
                return;
                i = 10000;
                if ((localContext instanceof Activity)) {
                  i = ((Activity)localContext).getIntent().getIntExtra("KOpenArticleSceneFromScene", 10000);
                }
                ad.i("MicroMsg.ChattingItemHelper", "onWebViewClick = %d", new Object[] { Integer.valueOf(m) });
              } while (e.a(paramAnonymousView.dDM, localContext, null, locals.field_talker));
              k = 90;
              str = paramAnonymousView.userName;
              localObject2 = paramAnonymousView.GQQ;
            } while ((str == null) || (str.equals("")));
            az.arV();
            Object localObject1 = com.tencent.mm.model.c.apM().aHY(locals.field_talker);
            int j = k;
            if (!locals.eJM())
            {
              j = k;
              if (localObject1 != null)
              {
                j = k;
                if (!com.tencent.mm.n.b.ls(((au)localObject1).field_type)) {
                  j = 157;
                }
              }
            }
            String str = m.d(str, j, i, m);
            Intent localIntent = new Intent();
            localIntent.putExtra("rawUrl", str);
            localIntent.putExtra("shortUrl", str);
            localIntent.putExtra("webpageTitle", (String)localObject2);
            Object localObject2 = new Bundle();
            if ((localObject1 != null) && (((af)localObject1).eKB()))
            {
              k = 4;
              ad.d("MicroMsg.ChattingItemHelper", "hakon click biz msg %s", new Object[] { ((au)localObject1).field_username });
            }
            for (;;)
            {
              localIntent.putExtra("msg_id", locals.field_msgId);
              localIntent.putExtra("KPublisherId", "msg_" + locals.field_msgSvrId);
              localIntent.putExtra("pre_username", locals.field_talker);
              localIntent.putExtra("prePublishId", "msg_" + locals.field_msgSvrId);
              localIntent.putExtra("preUsername", locals.field_talker);
              localIntent.putExtra("preChatName", locals.field_talker);
              localIntent.putExtra("preChatTYPE", 7);
              localIntent.putExtra("preMsgIndex", paramAnonymousView.AYK);
              localObject1 = paramAnonymousView.GQV;
              if (localObject1 != null) {
                localIntent.putExtras((Bundle)localObject1);
              }
              ((Bundle)localObject2).putInt("snsWebSource", k);
              localIntent.putExtra("jsapiargs", (Bundle)localObject2);
              localIntent.putExtra("geta8key_username", locals.field_talker);
              if (!ae.isNullOrNil(paramAnonymousView.dxz))
              {
                localIntent.putExtra("srcUsername", paramAnonymousView.dxz);
                localIntent.putExtra("srcDisplayname", paramAnonymousView.dxA);
                localIntent.putExtra("mode", 1);
              }
              localIntent.putExtra("message_id", paramAnonymousView.AYJ);
              localIntent.putExtra("message_index", paramAnonymousView.AYK);
              localIntent.putExtra("from_scence", 1);
              localIntent.putExtra("geta8key_scene", paramAnonymousView.dEF);
              localIntent.addFlags(536870912);
              localIntent.putExtra("start_activity_time", System.currentTimeMillis());
              localIntent.putExtra(e.m.FIt, paramAnonymousView.GQX);
              if ((((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).xA(1)) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(localContext, str, paramAnonymousView.GQX, j, i, localIntent)))
              {
                ad.i("MicroMsg.ChattingItemHelper", "jump to TmplWebview");
                break;
              }
              com.tencent.mm.bs.d.b(localContext, "webview", ".ui.tools.WebViewUI", localIntent);
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
  
  public final void a(bl parambl, Activity paramActivity)
  {
    AppMethodBeat.i(22352);
    if (!parambl.cxB())
    {
      cs localcs = new cs();
      com.tencent.mm.pluginsdk.model.g.e(localcs, parambl);
      localcs.deQ.activity = paramActivity;
      localcs.deQ.deW = 43;
      com.tencent.mm.sdk.b.a.ESL.l(localcs);
      if (localcs.deR.ret == 0) {
        com.tencent.mm.modelstat.b.huc.P(parambl);
      }
    }
    AppMethodBeat.o(22352);
  }
  
  public final void a(bl parambl, Context paramContext)
  {
    AppMethodBeat.i(22353);
    r.a(parambl, paramContext, null);
    AppMethodBeat.o(22353);
  }
  
  public final void b(com.tencent.mm.api.c paramc, Activity paramActivity, af paramaf)
  {
    AppMethodBeat.i(22349);
    com.tencent.mm.ui.tools.b.a(paramc, paramActivity, paramaf, 3);
    AppMethodBeat.o(22349);
  }
  
  public final long dv(View paramView)
  {
    AppMethodBeat.i(22347);
    r.fH(paramView);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.d
 * JD-Core Version:    0.7.0.1
 */
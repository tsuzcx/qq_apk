package com.tencent.mm.plugin.bbom;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.u;
import com.tencent.mm.al.f;
import com.tencent.mm.api.c.b;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.cs.b;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.az;
import com.tencent.mm.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.chatting.e;
import com.tencent.mm.ui.chatting.r;
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
  
  public final void a(long paramLong, int paramInt, Context paramContext, Activity paramActivity, bo parambo)
  {
    AppMethodBeat.i(22351);
    r.a(paramLong, paramInt, paramContext, null, paramActivity, parambo);
    AppMethodBeat.o(22351);
  }
  
  public final void a(View paramView, long paramLong, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(22346);
    e.g localg = new e.g();
    localg.msgId = paramLong;
    localg.Ikl = paramInt;
    localg.dqf = paramString2;
    localg.dmK = paramString1;
    paramView.setTag(localg);
    AppMethodBeat.o(22346);
  }
  
  public final void a(View paramView, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(195957);
    e.g localg = new e.g();
    e.h localh = new e.h();
    localg.Ikk = localh;
    localh.title = paramString2;
    localh.url = paramString3;
    localh.CLp = paramString1;
    localh.coverUrl = paramString5;
    localh.hlr = paramString4;
    paramView.setTag(localg);
    AppMethodBeat.o(195957);
  }
  
  public final void a(com.tencent.mm.ah.v paramv, final t paramt, int paramInt1, u paramu, View paramView, boolean paramBoolean, final int paramInt2, final com.tencent.mm.plugin.brandservice.ui.timeline.k paramk)
  {
    AppMethodBeat.i(22348);
    String str2 = com.tencent.mm.model.v.wk(paramt.field_talker);
    String str1 = paramv.url;
    Object localObject = paramt.field_talker;
    if ((!TextUtils.isEmpty(str1)) && (str1.contains("http://weixin.qq.com/emoticonstore/")))
    {
      str1 = str1.substring(str1.lastIndexOf("/") + 1);
      ai localai = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt((String)localObject);
      if ((com.tencent.mm.n.b.ln(localai.field_type)) && (localai.fad()))
      {
        localObject = f.dX((String)localObject);
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.api.c)localObject).bV(false);
          if ((localObject != null) && (!TextUtils.isEmpty(((c.b)localObject).Jm())) && (str1.contains(((c.b)localObject).Jm())))
          {
            if (TextUtils.isEmpty(str1)) {
              break label369;
            }
            paramu = new com.tencent.mm.ui.chatting.viewitems.bj(null, false, paramInt1, paramv.url, paramBoolean, str2, paramu.dvl, paramu.dvm, paramv.title, str1, null, false, false);
            paramView.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(22344);
                r.a(paramAnonymousView, paramAnonymousView.getContext(), paramt.field_talker);
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
        paramu.CqW = paramt.field_msgSvrId;
        paramu.CqX = paramInt2;
        paramu.IqX = paramt;
        paramView.setTag(paramu);
      }
      if (m.vC(paramv.hli)) {
        r.a(paramv, paramView, paramt.field_talker);
      }
      if (((paramInt2 < 2) || (paramt.field_isExpand)) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).ys(1)) && (!TextUtils.isEmpty(paramv.url)))
      {
        ac.d("MicroMsg.BizTimeLineServices", "terry trace: preload %s:%s", new Object[] { str2, paramv.title });
        ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(paramv.url, paramv.type, 90, new Object[0]);
      }
      AppMethodBeat.o(22348);
      return;
      str1 = null;
      break;
      label369:
      if (!bs.isNullOrNil(paramv.url))
      {
        paramu = new com.tencent.mm.ui.chatting.viewitems.bj(null, false, paramInt1, paramv.url, paramBoolean, str2, paramu.dvl, paramu.dvm, paramv.title);
        paramu.dCr = 56;
        paramu.IqY = paramv.type;
        str1 = paramt.field_talker;
        localObject = new Bundle();
        ((Bundle)localObject).putString("share_report_pre_msg_url", paramv.url);
        ((Bundle)localObject).putString("share_report_pre_msg_title", paramv.title);
        ((Bundle)localObject).putString("share_report_pre_msg_desc", paramv.hlf);
        ((Bundle)localObject).putString("share_report_pre_msg_icon_url", m.a(paramv));
        ((Bundle)localObject).putString("share_report_pre_msg_appid", "");
        ((Bundle)localObject).putInt("share_report_from_scene", 5);
        ((Bundle)localObject).putString("share_report_biz_username", str1);
        paramu.IqW = ((Bundle)localObject);
        paramView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(22345);
            int m = (int)(System.currentTimeMillis() / 1000L);
            Context localContext = paramAnonymousView.getContext();
            paramAnonymousView = (com.tencent.mm.ui.chatting.viewitems.bj)paramAnonymousView.getTag();
            t localt = paramAnonymousView.IqX;
            if (localt == null) {
              ac.e("MicroMsg.ChattingItemHelper", "onBizTimeLineWebViewClick info is null");
            }
            int i;
            int k;
            do
            {
              do
              {
                if (paramk != null) {
                  paramk.a(paramt, paramInt2, m);
                }
                AppMethodBeat.o(22345);
                return;
                i = 10000;
                if ((localContext instanceof Activity)) {
                  i = ((Activity)localContext).getIntent().getIntExtra("KOpenArticleSceneFromScene", 10000);
                }
                ac.i("MicroMsg.ChattingItemHelper", "onWebViewClick = %d", new Object[] { Integer.valueOf(m) });
              } while (e.a(paramAnonymousView.dBy, localContext, null, localt.field_talker));
              k = 90;
              str = paramAnonymousView.userName;
              localObject2 = paramAnonymousView.IqR;
            } while ((str == null) || (str.equals("")));
            az.ayM();
            Object localObject1 = com.tencent.mm.model.c.awB().aNt(localt.field_talker);
            int j = k;
            if (!localt.eZk())
            {
              j = k;
              if (localObject1 != null)
              {
                j = k;
                if (!com.tencent.mm.n.b.ln(((av)localObject1).field_type)) {
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
            if ((localObject1 != null) && (((ai)localObject1).fad()))
            {
              k = 4;
              ac.d("MicroMsg.ChattingItemHelper", "hakon click biz msg %s", new Object[] { ((av)localObject1).field_username });
            }
            for (;;)
            {
              localIntent.putExtra("msg_id", localt.field_msgId);
              localIntent.putExtra("KPublisherId", "msg_" + localt.field_msgSvrId);
              localIntent.putExtra("pre_username", localt.field_talker);
              localIntent.putExtra("prePublishId", "msg_" + localt.field_msgSvrId);
              localIntent.putExtra("preUsername", localt.field_talker);
              localIntent.putExtra("preChatName", localt.field_talker);
              localIntent.putExtra("preChatTYPE", 7);
              localIntent.putExtra("preMsgIndex", paramAnonymousView.CqX);
              localObject1 = paramAnonymousView.IqW;
              if (localObject1 != null) {
                localIntent.putExtras((Bundle)localObject1);
              }
              ((Bundle)localObject2).putInt("snsWebSource", k);
              localIntent.putExtra("jsapiargs", (Bundle)localObject2);
              localIntent.putExtra("geta8key_username", localt.field_talker);
              if (!ae.isNullOrNil(paramAnonymousView.dvl))
              {
                localIntent.putExtra("srcUsername", paramAnonymousView.dvl);
                localIntent.putExtra("srcDisplayname", paramAnonymousView.dvm);
                localIntent.putExtra("mode", 1);
              }
              localIntent.putExtra("message_id", paramAnonymousView.CqW);
              localIntent.putExtra("message_index", paramAnonymousView.CqX);
              localIntent.putExtra("from_scence", 1);
              localIntent.putExtra("geta8key_scene", paramAnonymousView.dCr);
              localIntent.addFlags(536870912);
              localIntent.putExtra("start_activity_time", System.currentTimeMillis());
              localIntent.putExtra(e.m.HhB, paramAnonymousView.IqY);
              if ((((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).ys(1)) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(localContext, str, paramAnonymousView.IqY, j, i, localIntent)))
              {
                ac.i("MicroMsg.ChattingItemHelper", "jump to TmplWebview");
                break;
              }
              com.tencent.mm.br.d.b(localContext, "webview", ".ui.tools.WebViewUI", localIntent);
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
  
  public final void a(bo parambo, Activity paramActivity)
  {
    AppMethodBeat.i(22352);
    if (!parambo.cKN())
    {
      cs localcs = new cs();
      com.tencent.mm.pluginsdk.model.g.e(localcs, parambo);
      localcs.dck.activity = paramActivity;
      localcs.dck.dcq = 43;
      com.tencent.mm.sdk.b.a.GpY.l(localcs);
      if (localcs.dcl.ret == 0) {
        com.tencent.mm.modelstat.b.hUE.P(parambo);
      }
    }
    AppMethodBeat.o(22352);
  }
  
  public final void a(bo parambo, Context paramContext)
  {
    AppMethodBeat.i(22353);
    r.a(parambo, paramContext, null);
    AppMethodBeat.o(22353);
  }
  
  public final void b(com.tencent.mm.api.c paramc, Activity paramActivity, ai paramai)
  {
    AppMethodBeat.i(22349);
    com.tencent.mm.ui.tools.b.a(paramc, paramActivity, paramai, 3);
    AppMethodBeat.o(22349);
  }
  
  public final long dx(View paramView)
  {
    AppMethodBeat.i(22347);
    r.fU(paramView);
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
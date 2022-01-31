package com.tencent.mm.plugin.bbom;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.l;
import com.tencent.mm.af.p;
import com.tencent.mm.aj.d.b;
import com.tencent.mm.aj.f;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.g.a.cm.b;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.model.s;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.brandservice.ui.timeline.i;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import com.tencent.mm.ui.chatting.r;
import com.tencent.mm.ui.chatting.viewitems.az;
import com.tencent.mm.ui.chatting.viewitems.d.f;
import com.tencent.mm.ui.e.l;

public final class d
  implements com.tencent.mm.plugin.brandservice.a.a
{
  public final void a(int paramInt, Context paramContext, String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(18249);
    r.a(paramInt, paramContext, paramString1, paramString2, paramLong1, paramLong2);
    AppMethodBeat.o(18249);
  }
  
  public final void a(long paramLong, int paramInt, Context paramContext, Activity paramActivity, bi parambi)
  {
    AppMethodBeat.i(18250);
    r.a(paramLong, paramInt, paramContext, null, paramActivity, parambi);
    AppMethodBeat.o(18250);
  }
  
  public final void a(View paramView, long paramLong, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(18245);
    d.f localf = new d.f();
    localf.cpO = paramLong;
    localf.zTf = paramInt;
    localf.cBW = paramString2;
    localf.imgPath = paramString1;
    paramView.setTag(localf);
    AppMethodBeat.o(18245);
  }
  
  public final void a(com.tencent.mm.af.q paramq, final com.tencent.mm.storage.q paramq1, int paramInt1, p paramp, View paramView, boolean paramBoolean, final int paramInt2, final i parami)
  {
    AppMethodBeat.i(18247);
    String str2 = s.nE(paramq1.field_talker);
    String str1 = paramq.url;
    Object localObject = paramq1.field_talker;
    if ((!TextUtils.isEmpty(str1)) && (str1.contains("http://weixin.qq.com/emoticonstore/")))
    {
      str1 = str1.substring(str1.lastIndexOf("/") + 1);
      ad localad = ((j)g.E(j.class)).YA().arw((String)localObject);
      if ((com.tencent.mm.n.a.je(localad.field_type)) && (localad.dwz()))
      {
        localObject = f.rS((String)localObject);
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.aj.d)localObject).cU(false);
          if ((localObject != null) && (!TextUtils.isEmpty(((d.b)localObject).aeE())) && (str1.contains(((d.b)localObject).aeE())))
          {
            if (TextUtils.isEmpty(str1)) {
              break label369;
            }
            paramp = new az(null, false, paramInt1, paramq.url, paramBoolean, str2, paramp.cGN, paramp.cGO, paramq.title, str1, null, false, false);
            paramView.setOnClickListener(new d.1(this, paramq1));
          }
        }
      }
    }
    for (;;)
    {
      if (paramp != null)
      {
        paramp.uWZ = paramq1.field_msgSvrId;
        paramp.uXa = paramInt2;
        paramp.zYM = paramq1;
        paramView.setTag(paramp);
      }
      if (l.na(paramq.fjO)) {
        r.a(paramq, paramView, paramq1.field_talker);
      }
      if (((paramInt2 < 2) || (paramq1.field_isExpand)) && (((com.tencent.mm.plugin.brandservice.a.b)g.E(com.tencent.mm.plugin.brandservice.a.b.class)).rU(1)) && (!TextUtils.isEmpty(paramq.url)))
      {
        ab.d("MicroMsg.BizTimeLineServices", "terry trace: preload %s:%s", new Object[] { str2, paramq.title });
        ((com.tencent.mm.plugin.brandservice.a.b)g.E(com.tencent.mm.plugin.brandservice.a.b.class)).a(paramq.url, paramq.type, 90, new Object[0]);
      }
      AppMethodBeat.o(18247);
      return;
      str1 = null;
      break;
      label369:
      if (!bo.isNullOrNil(paramq.url))
      {
        paramp = new az(null, false, paramInt1, paramq.url, paramBoolean, str2, paramp.cGN, paramp.cGO, paramq.title);
        paramp.cNH = 56;
        paramp.zYN = paramq.type;
        str1 = paramq1.field_talker;
        localObject = new Bundle();
        ((Bundle)localObject).putString("share_report_pre_msg_url", paramq.url);
        ((Bundle)localObject).putString("share_report_pre_msg_title", paramq.title);
        ((Bundle)localObject).putString("share_report_pre_msg_desc", paramq.fjL);
        ((Bundle)localObject).putString("share_report_pre_msg_icon_url", l.a(paramq));
        ((Bundle)localObject).putString("share_report_pre_msg_appid", "");
        ((Bundle)localObject).putInt("share_report_from_scene", 5);
        ((Bundle)localObject).putString("share_report_biz_username", str1);
        paramp.zYL = ((Bundle)localObject);
        paramView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(18244);
            int k = (int)(System.currentTimeMillis() / 1000L);
            Context localContext = paramAnonymousView.getContext();
            paramAnonymousView = (az)paramAnonymousView.getTag();
            com.tencent.mm.storage.q localq = paramAnonymousView.zYM;
            if (localq == null) {
              ab.e("MicroMsg.ChattingItemHelper", "onBizTimeLineWebViewClick info is null");
            }
            int i;
            do
            {
              do
              {
                if (parami != null) {
                  parami.a(paramq1, paramInt2, k);
                }
                AppMethodBeat.o(18244);
                return;
                i = 10000;
                if ((localContext instanceof Activity)) {
                  i = ((Activity)localContext).getIntent().getIntExtra("KOpenArticleSceneFromScene", 10000);
                }
                ab.i("MicroMsg.ChattingItemHelper", "onWebViewClick = %d", new Object[] { Integer.valueOf(k) });
              } while (com.tencent.mm.ui.chatting.e.a(paramAnonymousView.cMO, localContext, null, localq.field_talker));
              localObject1 = paramAnonymousView.userName;
              localObject2 = paramAnonymousView.zYG;
            } while ((localObject1 == null) || (((String)localObject1).equals("")));
            Object localObject3 = l.c((String)localObject1, 90, i, k);
            Object localObject1 = new Intent();
            ((Intent)localObject1).putExtra("rawUrl", (String)localObject3);
            ((Intent)localObject1).putExtra("shortUrl", (String)localObject3);
            ((Intent)localObject1).putExtra("webpageTitle", (String)localObject2);
            Object localObject2 = new Bundle();
            aw.aaz();
            localObject3 = c.YA().arw(localq.field_talker);
            int j;
            if ((localObject3 != null) && (((ad)localObject3).dwz()))
            {
              j = 4;
              ab.d("MicroMsg.ChattingItemHelper", "hakon click biz msg %s", new Object[] { ((aq)localObject3).field_username });
            }
            for (;;)
            {
              ((Intent)localObject1).putExtra("msg_id", localq.field_msgId);
              ((Intent)localObject1).putExtra("KPublisherId", "msg_" + Long.toString(localq.field_msgSvrId));
              ((Intent)localObject1).putExtra("pre_username", localq.field_talker);
              ((Intent)localObject1).putExtra("prePublishId", "msg_" + Long.toString(localq.field_msgSvrId));
              ((Intent)localObject1).putExtra("preUsername", localq.field_talker);
              ((Intent)localObject1).putExtra("preChatName", localq.field_talker);
              ((Intent)localObject1).putExtra("preChatTYPE", 7);
              ((Intent)localObject1).putExtra("preMsgIndex", paramAnonymousView.uXa);
              localObject3 = paramAnonymousView.zYL;
              if (localObject3 != null) {
                ((Intent)localObject1).putExtras((Bundle)localObject3);
              }
              ((Bundle)localObject2).putInt("snsWebSource", j);
              ((Intent)localObject1).putExtra("jsapiargs", (Bundle)localObject2);
              ((Intent)localObject1).putExtra("geta8key_username", localq.field_talker);
              if (!ah.isNullOrNil(paramAnonymousView.cGN))
              {
                ((Intent)localObject1).putExtra("srcUsername", paramAnonymousView.cGN);
                ((Intent)localObject1).putExtra("srcDisplayname", paramAnonymousView.cGO);
                ((Intent)localObject1).putExtra("mode", 1);
              }
              ((Intent)localObject1).putExtra("message_id", paramAnonymousView.uWZ);
              ((Intent)localObject1).putExtra("message_index", paramAnonymousView.uXa);
              ((Intent)localObject1).putExtra("from_scence", 1);
              ((Intent)localObject1).putExtra("geta8key_scene", paramAnonymousView.cNH);
              ((Intent)localObject1).addFlags(536870912);
              ((Intent)localObject1).putExtra("start_activity_time", System.currentTimeMillis());
              ((Intent)localObject1).putExtra(e.l.yVt, paramAnonymousView.zYN);
              if ((((com.tencent.mm.plugin.brandservice.a.b)g.E(com.tencent.mm.plugin.brandservice.a.b.class)).rU(1)) && (((com.tencent.mm.plugin.brandservice.a.b)g.E(com.tencent.mm.plugin.brandservice.a.b.class)).a(localContext, paramAnonymousView.userName, paramAnonymousView.zYN, false, 90, i, (Intent)localObject1)))
              {
                ab.i("MicroMsg.ChattingItemHelper", "jump to TmplWebview");
                break;
              }
              com.tencent.mm.bq.d.b(localContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
              break;
              j = 0;
            }
          }
        });
      }
      else
      {
        paramp = null;
      }
    }
  }
  
  public final void a(bi parambi, Activity paramActivity)
  {
    AppMethodBeat.i(18251);
    if (!parambi.bCn())
    {
      cm localcm = new cm();
      com.tencent.mm.pluginsdk.model.e.d(localcm, parambi);
      localcm.cpR.activity = paramActivity;
      localcm.cpR.cpY = 43;
      com.tencent.mm.sdk.b.a.ymk.l(localcm);
      if (localcm.cpS.ret == 0) {
        com.tencent.mm.modelstat.b.fRu.D(parambi);
      }
    }
    AppMethodBeat.o(18251);
  }
  
  public final void a(bi parambi, Context paramContext)
  {
    AppMethodBeat.i(18252);
    r.a(parambi, paramContext, null);
    AppMethodBeat.o(18252);
  }
  
  public final void b(com.tencent.mm.aj.d paramd, Activity paramActivity, ad paramad)
  {
    AppMethodBeat.i(18248);
    com.tencent.mm.ui.tools.b.a(paramd, paramActivity, paramad, 3);
    AppMethodBeat.o(18248);
  }
  
  public final long db(View paramView)
  {
    AppMethodBeat.i(18246);
    r.eQ(paramView);
    if ((paramView.getTag() instanceof d.f))
    {
      long l = ((d.f)paramView.getTag()).cpO;
      AppMethodBeat.o(18246);
      return l;
    }
    AppMethodBeat.o(18246);
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.d
 * JD-Core Version:    0.7.0.1
 */
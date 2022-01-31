package com.tencent.mm.plugin.bbom;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.ae.i;
import com.tencent.mm.ae.l;
import com.tencent.mm.ae.m;
import com.tencent.mm.ai.d.b;
import com.tencent.mm.h.a.cj;
import com.tencent.mm.h.a.cj.b;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.au;
import com.tencent.mm.model.r;
import com.tencent.mm.platformtools.ah;
import com.tencent.mm.plugin.brandservice.a.a.a;
import com.tencent.mm.pluginsdk.model.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bi;
import com.tencent.mm.storage.q;
import com.tencent.mm.ui.chatting.viewitems.aw;
import com.tencent.mm.ui.chatting.viewitems.d.f;
import com.tencent.mm.ui.e.j;

public final class d
  implements com.tencent.mm.plugin.brandservice.a.c
{
  public final void a(int paramInt, Context paramContext, String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    com.tencent.mm.ui.chatting.s.a(paramInt, paramContext, paramString1, paramString2, paramLong1, paramLong2);
  }
  
  public final void a(long paramLong, int paramInt, Context paramContext, Activity paramActivity, bi parambi)
  {
    com.tencent.mm.ui.chatting.s.a(paramLong, paramInt, paramContext, null, paramActivity, parambi);
  }
  
  public final void a(View paramView, long paramLong, String paramString1, String paramString2, int paramInt)
  {
    d.f localf = new d.f();
    localf.bIt = paramLong;
    localf.vCm = paramInt;
    localf.bUr = paramString2;
    localf.imgPath = paramString1;
    paramView.setTag(localf);
  }
  
  public final void a(m paramm, final q paramq, int paramInt1, l paraml, View paramView, boolean paramBoolean, final int paramInt2, final com.tencent.mm.plugin.brandservice.ui.timeline.j paramj)
  {
    Object localObject2 = r.gV(paramq.field_talker);
    Object localObject1 = paramm.url;
    Object localObject3 = paramq.field_talker;
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).contains("http://weixin.qq.com/emoticonstore/")))
    {
      localObject1 = ((String)localObject1).substring(((String)localObject1).lastIndexOf("/") + 1);
      ad localad = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl((String)localObject3);
      if ((com.tencent.mm.n.a.gR(localad.field_type)) && (localad.cua()))
      {
        localObject3 = com.tencent.mm.ai.f.kX((String)localObject3);
        if (localObject3 != null)
        {
          localObject3 = ((com.tencent.mm.ai.d)localObject3).bS(false);
          if ((localObject3 != null) && (!TextUtils.isEmpty(((d.b)localObject3).LX())) && (((String)localObject1).contains(((d.b)localObject3).LX())))
          {
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break label267;
            }
            paraml = new aw(null, false, paramInt1, paramm.url, paramBoolean, (String)localObject2, paraml.bYG, paraml.bYH, paramm.title, (String)localObject1, null, false, false);
            paramView.setOnClickListener(new d.1(this, paramq));
          }
        }
      }
    }
    for (;;)
    {
      if (paraml != null)
      {
        paraml.rgL = paramq.field_msgSvrId;
        paraml.rgM = paramInt2;
        paraml.vHr = paramq;
        paramView.setTag(paraml);
      }
      if (i.gr(paramm.dTI)) {
        com.tencent.mm.ui.chatting.s.a(paramm, paramView, paramq.field_talker);
      }
      return;
      localObject1 = null;
      break;
      label267:
      if (!bk.bl(paramm.url))
      {
        localObject1 = new aw(null, false, paramInt1, paramm.url, paramBoolean, (String)localObject2, paraml.bYG, paraml.bYH, paramm.title);
        ((aw)localObject1).cfb = 56;
        ((aw)localObject1).vHs = paramm.type;
        paraml = paramq.field_talker;
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("share_report_pre_msg_url", paramm.url);
        ((Bundle)localObject2).putString("share_report_pre_msg_title", paramm.title);
        ((Bundle)localObject2).putString("share_report_pre_msg_desc", paramm.dTF);
        ((Bundle)localObject2).putString("share_report_pre_msg_icon_url", paramm.dTD);
        ((Bundle)localObject2).putString("share_report_pre_msg_appid", "");
        ((Bundle)localObject2).putInt("share_report_from_scene", 5);
        ((Bundle)localObject2).putString("share_report_biz_username", paraml);
        ((aw)localObject1).vHq = ((Bundle)localObject2);
        paramView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            if (paramj != null) {
              paramj.a(paramq, paramInt2);
            }
            Context localContext = paramAnonymousView.getContext();
            paramAnonymousView = (aw)paramAnonymousView.getTag();
            q localq = paramAnonymousView.vHr;
            if (localq == null) {
              y.e("MicroMsg.ChattingItemHelper", "onBizTimeLineWebViewClick info is null");
            }
            do
            {
              do
              {
                return;
                y.d("MicroMsg.ChattingItemHelper", "onWebViewClick = " + System.currentTimeMillis());
              } while (com.tencent.mm.ui.chatting.f.a(paramAnonymousView.ceb, localContext, null, localq.field_talker));
              localObject1 = paramAnonymousView.userName;
              localObject2 = paramAnonymousView.vHk;
            } while ((localObject1 == null) || (((String)localObject1).equals("")));
            Object localObject3 = i.g(((String)localObject1).replaceAll("(scene=[\\d]*)", ""), 90, -1);
            Object localObject1 = new Intent();
            ((Intent)localObject1).putExtra("rawUrl", (String)localObject3);
            ((Intent)localObject1).putExtra("shortUrl", (String)localObject3);
            ((Intent)localObject1).putExtra("webpageTitle", (String)localObject2);
            Object localObject2 = new Bundle();
            au.Hx();
            localObject3 = com.tencent.mm.model.c.Fw().abl(localq.field_talker);
            int i;
            if ((localObject3 != null) && (((ad)localObject3).cua()))
            {
              i = 4;
              y.d("MicroMsg.ChattingItemHelper", "hakon click biz msg %s", new Object[] { ((ao)localObject3).field_username });
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
              ((Intent)localObject1).putExtra("preMsgIndex", paramAnonymousView.rgM);
              localObject3 = paramAnonymousView.vHq;
              if (localObject3 != null) {
                ((Intent)localObject1).putExtras((Bundle)localObject3);
              }
              ((Bundle)localObject2).putInt("snsWebSource", i);
              ((Intent)localObject1).putExtra("jsapiargs", (Bundle)localObject2);
              ((Intent)localObject1).putExtra("geta8key_username", localq.field_talker);
              if (!ah.bl(paramAnonymousView.bYG))
              {
                ((Intent)localObject1).putExtra("srcUsername", paramAnonymousView.bYG);
                ((Intent)localObject1).putExtra("srcDisplayname", paramAnonymousView.bYH);
                ((Intent)localObject1).putExtra("mode", 1);
              }
              ((Intent)localObject1).putExtra("message_id", paramAnonymousView.rgL);
              ((Intent)localObject1).putExtra("message_index", paramAnonymousView.rgM);
              ((Intent)localObject1).putExtra("from_scence", 1);
              ((Intent)localObject1).putExtra("geta8key_scene", paramAnonymousView.cfb);
              ((Intent)localObject1).addFlags(536870912);
              ((Intent)localObject1).putExtra(e.j.uIc, com.tencent.mm.storage.s.getSessionId());
              ((Intent)localObject1).putExtra(e.j.uId, 90);
              ((Intent)localObject1).putExtra(e.j.uIe, -1);
              if ((com.tencent.mm.plugin.brandservice.ui.timeline.a.d.ayw()) && (com.tencent.mm.plugin.brandservice.ui.timeline.a.d.a(localContext, paramAnonymousView.userName, (Intent)localObject1, paramAnonymousView.vHs)))
              {
                y.i("MicroMsg.ChattingItemHelper", "jump to TmplWebview");
                return;
              }
              com.tencent.mm.br.d.b(localContext, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
              return;
              i = 0;
            }
          }
        });
        paraml = (l)localObject1;
        if (paramm.type == 0)
        {
          paraml = new a.a();
          paraml.url = paramm.url;
          paramj = com.tencent.mm.plugin.brandservice.ui.timeline.a.c.d.oE(0);
          if (paramj != null) {}
          for (paraml.ibT = paramj.field_version;; paraml.ibT = 0)
          {
            ((com.tencent.mm.plugin.brandservice.a.a)g.r(com.tencent.mm.plugin.brandservice.a.a.class)).b(paraml);
            paraml = (l)localObject1;
            break;
          }
        }
      }
      else
      {
        paraml = null;
      }
    }
  }
  
  public final void a(bi parambi, Activity paramActivity)
  {
    if (!parambi.aVK())
    {
      cj localcj = new cj();
      e.a(localcj, parambi);
      localcj.bIw.activity = paramActivity;
      localcj.bIw.bID = 43;
      com.tencent.mm.sdk.b.a.udP.m(localcj);
      if (localcj.bIx.ret == 0) {
        com.tencent.mm.modelstat.b.eBD.x(parambi);
      }
    }
  }
  
  public final void a(bi parambi, Context paramContext)
  {
    com.tencent.mm.ui.chatting.s.a(parambi, paramContext, null);
  }
  
  public final void b(com.tencent.mm.ai.d paramd, Activity paramActivity, ad paramad)
  {
    com.tencent.mm.ui.tools.b.a(paramd, paramActivity, paramad, 3);
  }
  
  public final long cz(View paramView)
  {
    com.tencent.mm.ui.chatting.s.dH(paramView);
    if ((paramView.getTag() instanceof d.f)) {
      return ((d.f)paramView.getTag()).bIt;
    }
    return 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.bbom.d
 * JD-Core Version:    0.7.0.1
 */
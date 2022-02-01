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
import com.tencent.mm.an.g;
import com.tencent.mm.api.c.b;
import com.tencent.mm.autogen.a.dn;
import com.tencent.mm.autogen.a.dn.b;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.m;
import com.tencent.mm.message.v;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bh;
import com.tencent.mm.plugin.brandservice.ui.timeline.i;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.model.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.storage.cc;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.chatting.f;
import com.tencent.mm.ui.chatting.viewitems.bz;
import com.tencent.mm.ui.chatting.viewitems.e.g;
import com.tencent.mm.ui.chatting.viewitems.e.h;
import com.tencent.mm.ui.conversation.k;
import com.tencent.mm.ui.f.s;
import java.util.HashMap;

public final class d
  implements com.tencent.mm.plugin.brandservice.api.b
{
  public final void a(int paramInt, Context paramContext, String paramString1, String paramString2, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(22350);
    com.tencent.mm.ui.chatting.u.a(paramInt, paramContext, paramString1, paramString2, paramLong1, paramLong2);
    AppMethodBeat.o(22350);
  }
  
  public final void a(long paramLong, int paramInt, Context paramContext, Activity paramActivity, cc paramcc)
  {
    AppMethodBeat.i(260651);
    com.tencent.mm.ui.chatting.u.a(paramLong, paramInt, paramContext, null, paramActivity, paramcc);
    AppMethodBeat.o(260651);
  }
  
  public final void a(View paramView, long paramLong, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(22346);
    e.g localg = new e.g();
    localg.msgId = paramLong;
    localg.aeOM = paramInt;
    localg.xml = paramString2;
    localg.hQn = paramString1;
    paramView.setTag(localg);
    AppMethodBeat.o(22346);
  }
  
  public final void a(View paramView, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(260667);
    e.g localg = new e.g();
    e.h localh = new e.h();
    localg.aeOL = localh;
    localh.title = paramString2;
    localh.url = paramString3;
    localh.XmC = paramString1;
    localh.coverUrl = paramString5;
    localh.nVa = paramString4;
    paramView.setTag(localg);
    AppMethodBeat.o(260667);
  }
  
  public final void a(final v paramv, final com.tencent.mm.storage.ab paramab, int paramInt1, com.tencent.mm.message.u paramu, View paramView, boolean paramBoolean, final int paramInt2, final i parami)
  {
    AppMethodBeat.i(22348);
    String str2 = aa.getDisplayName(paramab.field_talker);
    String str1 = paramv.url;
    Object localObject = paramab.field_talker;
    if ((!TextUtils.isEmpty(str1)) && (str1.contains("http://" + WeChatHosts.domainString(R.l.host_weixin_qq_com) + "/emoticonstore/")))
    {
      str1 = str1.substring(str1.lastIndexOf("/") + 1);
      au localau = ((n)h.ax(n.class)).bzA().JE((String)localObject);
      if ((com.tencent.mm.contact.d.rs(localau.field_type)) && (localau.iZC()))
      {
        localObject = g.hU((String)localObject);
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.api.c)localObject).dO(false);
          if ((localObject != null) && (!TextUtils.isEmpty(((c.b)localObject).aBn())) && (str1.contains(((c.b)localObject).aBn())))
          {
            if (TextUtils.isEmpty(str1)) {
              break label395;
            }
            paramu = new bz(null, false, paramInt1, paramv.url, paramBoolean, str2, paramu.iaa, paramu.iab, paramv.title, str1, null, false, false);
            paramView.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(22344);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.cH(paramAnonymousView);
                a.c("com/tencent/mm/plugin/bbom/BizTimeLineServices$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                com.tencent.mm.ui.chatting.u.a(paramAnonymousView, paramAnonymousView.getContext(), paramab.field_talker);
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
        paramu.WMB = paramab.field_msgSvrId;
        paramu.WMC = paramInt2;
        paramu.aeXT = paramab;
        paramView.setTag(paramu);
      }
      if (m.Hh(paramv.nUR)) {
        com.tencent.mm.ui.chatting.u.a(paramv, paramView, paramab.field_talker);
      }
      if (((paramInt2 < 2) || (paramab.field_isExpand)) && (((com.tencent.mm.plugin.brandservice.api.c)h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).GV(1)) && (!TextUtils.isEmpty(paramv.url)))
      {
        Log.d("MicroMsg.BizTimeLineServices", "terry trace: preload %s:%s", new Object[] { str2, paramv.title });
        ((com.tencent.mm.plugin.brandservice.api.c)h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).a(paramv.url, paramv.type, 90, new Object[0]);
      }
      AppMethodBeat.o(22348);
      return;
      str1 = null;
      break;
      label395:
      if (!Util.isNullOrNil(paramv.url))
      {
        paramu = new bz(null, false, paramInt1, paramv.url, paramBoolean, str2, paramu.iaa, paramu.iab, paramv.title);
        paramu.iiA = 56;
        paramu.aeXU = paramv.type;
        str1 = paramab.field_talker;
        localObject = new Bundle();
        ((Bundle)localObject).putString("share_report_pre_msg_url", paramv.url);
        ((Bundle)localObject).putString("share_report_pre_msg_title", paramv.title);
        ((Bundle)localObject).putString("share_report_pre_msg_desc", paramv.nUO);
        ((Bundle)localObject).putString("share_report_pre_msg_icon_url", m.a(paramv));
        ((Bundle)localObject).putString("share_report_pre_msg_appid", "");
        ((Bundle)localObject).putInt("share_report_from_scene", 5);
        ((Bundle)localObject).putString("share_report_biz_username", str1);
        paramu.aeXS = ((Bundle)localObject);
        paramView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(22345);
            Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject1).cH(paramAnonymousView);
            a.c("com/tencent/mm/plugin/bbom/BizTimeLineServices$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aYj());
            localObject1 = MPVideoPreviewMgr.vXs;
            MPVideoPreviewMgr.a(paramab, "PAUSE_FOR_RESUME");
            int m = (int)(System.currentTimeMillis() / 1000L);
            Object localObject2 = paramv.title;
            Object localObject3 = m.a(paramv);
            localObject1 = paramAnonymousView.getContext();
            paramAnonymousView = (bz)paramAnonymousView.getTag();
            com.tencent.mm.storage.ab localab = paramAnonymousView.aeXT;
            if (localab == null) {
              Log.e("MicroMsg.ChattingItemHelper", "onBizTimeLineWebViewClick info is null");
            }
            int i;
            int k;
            do
            {
              do
              {
                if (parami != null) {
                  parami.onClick(paramab, paramv.url, paramInt2, m);
                }
                a.a(this, "com/tencent/mm/plugin/bbom/BizTimeLineServices$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(22345);
                return;
                i = 10000;
                if ((localObject1 instanceof Activity)) {
                  i = ((Activity)localObject1).getIntent().getIntExtra("KOpenArticleSceneFromScene", 10000);
                }
                Log.i("MicroMsg.ChattingItemHelper", "onWebViewClick = %d", new Object[] { Integer.valueOf(m) });
              } while (f.a(paramAnonymousView.ihx, (Context)localObject1, null, localab.field_talker));
              k = 90;
              str = paramAnonymousView.userName;
            } while ((str == null) || (str.equals("")));
            bh.bCz();
            au localau = com.tencent.mm.model.c.bzA().JE(localab.field_talker);
            int j = k;
            if (!localab.iYf())
            {
              j = k;
              if (localau != null)
              {
                j = k;
                if (!com.tencent.mm.contact.d.rs(localau.field_type)) {
                  j = 157;
                }
              }
            }
            String str = m.e(str, j, i, m);
            Intent localIntent = new Intent();
            localIntent.putExtra("rawUrl", str);
            localIntent.putExtra("shortUrl", str);
            localIntent.putExtra("webpageTitle", (String)localObject2);
            localIntent.putExtra("thumbUrl", (String)localObject3);
            localObject2 = new Bundle();
            if ((localau != null) && (localau.iZC()))
            {
              k = 4;
              Log.d("MicroMsg.ChattingItemHelper", "hakon click biz msg %s", new Object[] { localau.field_username });
            }
            for (;;)
            {
              localIntent.putExtra("msg_id", localab.field_msgId);
              localIntent.putExtra("KPublisherId", "msg_" + localab.field_msgSvrId);
              localIntent.putExtra("pre_username", localab.field_talker);
              localIntent.putExtra("prePublishId", "msg_" + localab.field_msgSvrId);
              localIntent.putExtra("preUsername", localab.field_talker);
              localIntent.putExtra("preChatName", localab.field_talker);
              localIntent.putExtra("preChatTYPE", 7);
              localIntent.putExtra("preMsgIndex", paramAnonymousView.WMC);
              localObject3 = paramAnonymousView.aeXS;
              if (localObject3 != null) {
                localIntent.putExtras((Bundle)localObject3);
              }
              ((Bundle)localObject2).putInt("snsWebSource", k);
              localIntent.putExtra("jsapiargs", (Bundle)localObject2);
              localIntent.putExtra("geta8key_username", localab.field_talker);
              if (!com.tencent.mm.platformtools.ab.isNullOrNil(paramAnonymousView.iaa))
              {
                localIntent.putExtra("srcUsername", paramAnonymousView.iaa);
                localIntent.putExtra("srcDisplayname", paramAnonymousView.iab);
                localIntent.putExtra("mode", 1);
              }
              localIntent.putExtra("message_id", paramAnonymousView.WMB);
              localIntent.putExtra("message_index", paramAnonymousView.WMC);
              localIntent.putExtra("from_scence", 1);
              localIntent.putExtra("geta8key_scene", paramAnonymousView.iiA);
              localIntent.addFlags(536870912);
              localIntent.putExtra("start_activity_time", System.currentTimeMillis());
              localIntent.putExtra(f.s.adwW, paramAnonymousView.aeXU);
              if ((((com.tencent.mm.plugin.brandservice.api.c)h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).GV(1)) && (((com.tencent.mm.plugin.brandservice.api.c)h.ax(com.tencent.mm.plugin.brandservice.api.c.class)).a((Context)localObject1, str, paramAnonymousView.aeXU, j, i, localIntent)))
              {
                Log.i("MicroMsg.ChattingItemHelper", "jump to TmplWebview");
                break;
              }
              com.tencent.mm.br.c.b((Context)localObject1, "webview", ".ui.tools.WebViewUI", localIntent);
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
  
  public final void a(cc paramcc, Activity paramActivity)
  {
    AppMethodBeat.i(22352);
    if (!paramcc.fxR())
    {
      dn localdn = new dn();
      l.d(localdn, paramcc);
      localdn.hDr.activity = paramActivity;
      localdn.hDr.hDy = 43;
      localdn.publish();
      if (localdn.hDs.ret == 0) {
        com.tencent.mm.modelstat.b.oUZ.ao(paramcc);
      }
    }
    AppMethodBeat.o(22352);
  }
  
  public final void a(cc paramcc, Context paramContext)
  {
    AppMethodBeat.i(22353);
    com.tencent.mm.ui.chatting.u.a(paramcc, paramContext, null);
    AppMethodBeat.o(22353);
  }
  
  public final void ase()
  {
    AppMethodBeat.i(260670);
    MMAppMgr.Lj(true);
    AppMethodBeat.o(260670);
  }
  
  public final void b(com.tencent.mm.api.c paramc, Activity paramActivity, au paramau)
  {
    AppMethodBeat.i(22349);
    com.tencent.mm.ui.tools.c.a(paramc, paramActivity, paramau, 3);
    AppMethodBeat.o(22349);
  }
  
  public final int dav()
  {
    AppMethodBeat.i(260662);
    Integer localInteger = (Integer)k.afoc.get("officialaccounts");
    if (localInteger != null)
    {
      int i = localInteger.intValue();
      AppMethodBeat.o(260662);
      return i;
    }
    AppMethodBeat.o(260662);
    return -1;
  }
  
  public final long eA(View paramView)
  {
    AppMethodBeat.i(22347);
    com.tencent.mm.ui.chatting.u.li(paramView);
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
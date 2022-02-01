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
import com.tencent.mm.ah.v;
import com.tencent.mm.api.c.b;
import com.tencent.mm.g.a.cw;
import com.tencent.mm.g.a.cw.b;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.bc;
import com.tencent.mm.platformtools.af;
import com.tencent.mm.plugin.brandservice.ui.timeline.j;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.chatting.e;
import com.tencent.mm.ui.chatting.s;
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
    s.a(paramInt, paramContext, paramString1, paramString2, paramLong1, paramLong2);
    AppMethodBeat.o(22350);
  }
  
  public final void a(long paramLong, int paramInt, Context paramContext, Activity paramActivity, bv parambv)
  {
    AppMethodBeat.i(22351);
    s.a(paramLong, paramInt, paramContext, null, paramActivity, parambv);
    AppMethodBeat.o(22351);
  }
  
  public final void a(View paramView, long paramLong, String paramString1, String paramString2, int paramInt)
  {
    AppMethodBeat.i(22346);
    e.g localg = new e.g();
    localg.msgId = paramLong;
    localg.Kxc = paramInt;
    localg.dCX = paramString2;
    localg.dzD = paramString1;
    paramView.setTag(localg);
    AppMethodBeat.o(22346);
  }
  
  public final void a(View paramView, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    AppMethodBeat.i(186420);
    e.g localg = new e.g();
    e.h localh = new e.h();
    localg.Kxb = localh;
    localh.title = paramString2;
    localh.url = paramString3;
    localh.EHk = paramString1;
    localh.coverUrl = paramString5;
    localh.hGs = paramString4;
    paramView.setTag(localg);
    AppMethodBeat.o(186420);
  }
  
  public final void a(v paramv, final com.tencent.mm.storage.w paramw, int paramInt1, u paramu, View paramView, boolean paramBoolean, final int paramInt2, final j paramj)
  {
    AppMethodBeat.i(22348);
    String str2 = com.tencent.mm.model.w.zP(paramw.field_talker);
    String str1 = paramv.url;
    Object localObject = paramw.field_talker;
    if ((!TextUtils.isEmpty(str1)) && (str1.contains("http://weixin.qq.com/emoticonstore/")))
    {
      str1 = str1.substring(str1.lastIndexOf("/") + 1);
      an localan = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH((String)localObject);
      if ((com.tencent.mm.contact.c.lO(localan.field_type)) && (localan.fug()))
      {
        localObject = com.tencent.mm.al.g.eX((String)localObject);
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.api.c)localObject).bX(false);
          if ((localObject != null) && (!TextUtils.isEmpty(((c.b)localObject).KT())) && (str1.contains(((c.b)localObject).KT())))
          {
            if (TextUtils.isEmpty(str1)) {
              break label369;
            }
            paramu = new bk(null, false, paramInt1, paramv.url, paramBoolean, str2, paramu.dIt, paramu.dIu, paramv.title, str1, null, false, false);
            paramView.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(22344);
                com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
                localb.bd(paramAnonymousView);
                com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/bbom/BizTimeLineServices$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                s.a(paramAnonymousView, paramAnonymousView.getContext(), paramw.field_talker);
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
        paramu.Emz = paramw.field_msgSvrId;
        paramu.EmA = paramInt2;
        paramu.KDV = paramw;
        paramView.setTag(paramu);
      }
      if (m.zd(paramv.hGj)) {
        s.a(paramv, paramView, paramw.field_talker);
      }
      if (((paramInt2 < 2) || (paramw.field_isExpand)) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).zl(1)) && (!TextUtils.isEmpty(paramv.url)))
      {
        ae.d("MicroMsg.BizTimeLineServices", "terry trace: preload %s:%s", new Object[] { str2, paramv.title });
        ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(paramv.url, paramv.type, 90, new Object[0]);
      }
      AppMethodBeat.o(22348);
      return;
      str1 = null;
      break;
      label369:
      if (!bu.isNullOrNil(paramv.url))
      {
        paramu = new bk(null, false, paramInt1, paramv.url, paramBoolean, str2, paramu.dIt, paramu.dIu, paramv.title);
        paramu.dPU = 56;
        paramu.KDW = paramv.type;
        str1 = paramw.field_talker;
        localObject = new Bundle();
        ((Bundle)localObject).putString("share_report_pre_msg_url", paramv.url);
        ((Bundle)localObject).putString("share_report_pre_msg_title", paramv.title);
        ((Bundle)localObject).putString("share_report_pre_msg_desc", paramv.hGg);
        ((Bundle)localObject).putString("share_report_pre_msg_icon_url", m.a(paramv));
        ((Bundle)localObject).putString("share_report_pre_msg_appid", "");
        ((Bundle)localObject).putInt("share_report_from_scene", 5);
        ((Bundle)localObject).putString("share_report_biz_username", str1);
        paramu.KDU = ((Bundle)localObject);
        paramView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(22345);
            Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
            ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/bbom/BizTimeLineServices$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
            localObject1 = MPVideoPreviewMgr.ovZ;
            MPVideoPreviewMgr.ail("PAUSE_FOR_RESUME");
            int m = (int)(System.currentTimeMillis() / 1000L);
            localObject1 = paramAnonymousView.getContext();
            paramAnonymousView = (bk)paramAnonymousView.getTag();
            com.tencent.mm.storage.w localw = paramAnonymousView.KDV;
            if (localw == null) {
              ae.e("MicroMsg.ChattingItemHelper", "onBizTimeLineWebViewClick info is null");
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
                ae.i("MicroMsg.ChattingItemHelper", "onWebViewClick = %d", new Object[] { Integer.valueOf(m) });
              } while (e.a(paramAnonymousView.dPb, (Context)localObject1, null, localw.field_talker));
              k = 90;
              str = paramAnonymousView.userName;
              localObject3 = paramAnonymousView.KDP;
            } while ((str == null) || (str.equals("")));
            bc.aCg();
            Object localObject2 = com.tencent.mm.model.c.azF().BH(localw.field_talker);
            int j = k;
            if (!localw.ftb())
            {
              j = k;
              if (localObject2 != null)
              {
                j = k;
                if (!com.tencent.mm.contact.c.lO(((aw)localObject2).field_type)) {
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
            if ((localObject2 != null) && (((an)localObject2).fug()))
            {
              k = 4;
              ae.d("MicroMsg.ChattingItemHelper", "hakon click biz msg %s", new Object[] { ((aw)localObject2).field_username });
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
              localIntent.putExtra("preMsgIndex", paramAnonymousView.EmA);
              localObject2 = paramAnonymousView.KDU;
              if (localObject2 != null) {
                localIntent.putExtras((Bundle)localObject2);
              }
              ((Bundle)localObject3).putInt("snsWebSource", k);
              localIntent.putExtra("jsapiargs", (Bundle)localObject3);
              localIntent.putExtra("geta8key_username", localw.field_talker);
              if (!af.isNullOrNil(paramAnonymousView.dIt))
              {
                localIntent.putExtra("srcUsername", paramAnonymousView.dIt);
                localIntent.putExtra("srcDisplayname", paramAnonymousView.dIu);
                localIntent.putExtra("mode", 1);
              }
              localIntent.putExtra("message_id", paramAnonymousView.Emz);
              localIntent.putExtra("message_index", paramAnonymousView.EmA);
              localIntent.putExtra("from_scence", 1);
              localIntent.putExtra("geta8key_scene", paramAnonymousView.dPU);
              localIntent.addFlags(536870912);
              localIntent.putExtra("start_activity_time", System.currentTimeMillis());
              localIntent.putExtra(e.m.Jpz, paramAnonymousView.KDW);
              if ((((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).zl(1)) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a((Context)localObject1, str, paramAnonymousView.KDW, j, i, localIntent)))
              {
                ae.i("MicroMsg.ChattingItemHelper", "jump to TmplWebview");
                break;
              }
              com.tencent.mm.br.d.b((Context)localObject1, "webview", ".ui.tools.WebViewUI", localIntent);
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
  
  public final void a(bv parambv, Activity paramActivity)
  {
    AppMethodBeat.i(22352);
    if (!parambv.cVH())
    {
      cw localcw = new cw();
      com.tencent.mm.pluginsdk.model.g.e(localcw, parambv);
      localcw.doL.activity = paramActivity;
      localcw.doL.doR = 43;
      com.tencent.mm.sdk.b.a.IvT.l(localcw);
      if (localcw.doM.ret == 0) {
        com.tencent.mm.modelstat.b.iqT.S(parambv);
      }
    }
    AppMethodBeat.o(22352);
  }
  
  public final void a(bv parambv, Context paramContext)
  {
    AppMethodBeat.i(22353);
    s.a(parambv, paramContext, null);
    AppMethodBeat.o(22353);
  }
  
  public final void b(com.tencent.mm.api.c paramc, Activity paramActivity, an paraman)
  {
    AppMethodBeat.i(22349);
    com.tencent.mm.ui.tools.b.a(paramc, paramActivity, paraman, 3);
    AppMethodBeat.o(22349);
  }
  
  public final void bgT()
  {
    AppMethodBeat.i(186421);
    MMAppMgr.xu(true);
    AppMethodBeat.o(186421);
  }
  
  public final long dz(View paramView)
  {
    AppMethodBeat.i(22347);
    s.gi(paramView);
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
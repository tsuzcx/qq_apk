package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.message.f;
import com.tencent.mm.message.k.b;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.live.report.q.c;
import com.tencent.mm.plugin.finder.live.report.q.s;
import com.tencent.mm.plugin.finder.live.report.q.t;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.an;
import com.tencent.mm.plugin.finder.utils.an.a;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.view.e;
import com.tencent.mm.plugin.findersdk.a.ce;
import com.tencent.mm.plugin.findersdk.a.ce.a;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.t;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.n;
import kotlin.r;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderLiveRecentForwardUtils;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderRecentForwardUtils;", "()V", "TAG", "", "getMsgType", "Lkotlin/Pair;", "", "feedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "jumpToConversationByLive", "", "context", "Landroidx/appcompat/app/AppCompatActivity;", "text", "username", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "toUsers", "showForwardConfirmDialog", "userName", "menu", "Lcom/tencent/mm/ui/base/MMMenuItem;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ad
{
  public static final ad AWU;
  
  static
  {
    AppMethodBeat.i(363159);
    AWU = new ad();
    AppMethodBeat.o(363159);
  }
  
  private static final void a(AppCompatActivity paramAppCompatActivity, t paramt, FinderItem paramFinderItem, kotlin.g.a.b paramb, e parame, boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(370830);
    s.u(paramAppCompatActivity, "$context");
    s.u(paramt, "$menu");
    s.u(paramFinderItem, "$feedObject");
    s.u(parame, "$this_apply");
    Object localObject1;
    if (paramBoolean)
    {
      localObject1 = h.ax(ce.class);
      s.s(localObject1, "service(IHellLiveReport::class.java)");
      ce.a.a((ce)localObject1, q.s.Dur);
      localObject1 = paramString;
      if (paramString == null) {
        localObject1 = "";
      }
      paramString = paramt.rDm;
      s.s(paramString, "menu.webUrl");
      paramt = av.GiL;
      if (!av.A(paramFinderItem.getFeedObject()))
      {
        paramt = av.GiL;
        paramt = (Context)paramAppCompatActivity;
        paramAppCompatActivity = paramAppCompatActivity.getString(e.h.finder_private_ban_share);
        s.s(paramAppCompatActivity, "context.getString(R.stri…finder_private_ban_share)");
        av.aO(paramt, paramAppCompatActivity);
      }
    }
    else
    {
      parame.cyW();
      AppMethodBeat.o(370830);
      return;
    }
    paramt = an.GhR;
    Object localObject2 = an.a.getTAG();
    Object localObject3 = new StringBuilder("share live  ").append(paramFinderItem.getId()).append(' ');
    paramt = paramFinderItem.getFeedObject();
    if (paramt == null)
    {
      paramt = null;
      label182:
      localObject3 = ((StringBuilder)localObject3).append(paramt).append(" to conversation,liveId:");
      paramt = paramFinderItem.getLiveInfo();
      if (paramt != null) {
        break label535;
      }
      paramt = null;
      label206:
      localObject3 = ((StringBuilder)localObject3).append(paramt).append(",desc:").append(paramFinderItem.getDescription()).append(",liveStatus ");
      paramt = paramFinderItem.getLiveInfo();
      if (paramt != null) {
        break label546;
      }
      paramt = null;
      label242:
      Log.i((String)localObject2, paramt);
      localObject2 = new k.b();
      paramt = new com.tencent.mm.plugin.findersdk.a.b();
      paramt.b(paramFinderItem.getFinderLive());
      ((k.b)localObject2).a((f)paramt);
      if ((!((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).isChargeLive(paramFinderItem.getLiveInfo())) && (!((com.tencent.d.a.a.a.b)h.az(com.tencent.d.a.a.a.b.class)).isReplayLive(paramFinderItem.getLiveInfo()))) {
        break label557;
      }
    }
    label535:
    label546:
    label557:
    for (paramt = new r(Integer.valueOf(88), Integer.valueOf(31));; paramt = new r(Integer.valueOf(63), Integer.valueOf(23)))
    {
      ((k.b)localObject2).type = ((Number)paramt.bsC).intValue();
      ((k.b)localObject2).title = MMApplicationContext.getContext().getString(e.h.low_version_upgrade_tip);
      ((k.b)localObject2).url = MMApplicationContext.getContext().getString(e.h.low_version_upgrade_url);
      localObject3 = new Intent();
      ((Intent)localObject3).putExtra("Retr_Msg_Type", ((Number)paramt.bsD).intValue());
      ((Intent)localObject3).putExtra("Multi_Retr", true);
      ((Intent)localObject3).putExtra("Retr_Msg_content", k.b.a((k.b)localObject2, null, null));
      ((Intent)localObject3).putExtra("Retr_go_to_chattingUI", false);
      ((Intent)localObject3).putExtra("Retr_show_success_tips", true);
      ((Intent)localObject3).putExtra("Retr_MsgQuickShare", true);
      ((Intent)localObject3).putExtra("custom_send_text", (String)localObject1);
      ((Intent)localObject3).putExtra("Select_Conv_User", paramString);
      c.a((MMFragmentActivity)paramAppCompatActivity, ".ui.transmit.MsgRetransmitUI", (Intent)localObject3, 1005, new ad..ExternalSyntheticLambda1(paramFinderItem, paramb));
      break;
      paramt = Integer.valueOf(paramt.forward_style);
      break label182;
      paramt = Long.valueOf(paramt.liveId);
      break label206;
      paramt = Integer.valueOf(paramt.liveStatus);
      break label242;
    }
  }
  
  public static void b(AppCompatActivity paramAppCompatActivity, String paramString, t paramt, FinderItem paramFinderItem, kotlin.g.a.b<? super List<String>, ah> paramb)
  {
    AppMethodBeat.i(370825);
    s.u(paramAppCompatActivity, "context");
    s.u(paramString, "userName");
    s.u(paramt, "menu");
    s.u(paramFinderItem, "feedObject");
    Log.d("MircoMsg.FinderRecentForwardUtils", "showForwardConfirmDialog() called with: context = " + paramAppCompatActivity + ", userName = " + paramString + ", menu = " + paramt + ", feedObject = " + paramFinderItem);
    Object localObject = an.GhR;
    localObject = an.a.a(paramAppCompatActivity, paramFinderItem);
    paramString = new e((Context)paramAppCompatActivity, paramString, 23, null, (com.tencent.mm.plugin.findersdk.a.b)localObject, 8);
    paramString.a(paramFinderItem.getId(), new ad..ExternalSyntheticLambda0(paramAppCompatActivity, paramt, paramFinderItem, paramb, paramString));
    paramString.dDn();
    paramAppCompatActivity = h.ax(ce.class);
    s.s(paramAppCompatActivity, "service(IHellLiveReport::class.java)");
    ce.a.a((ce)paramAppCompatActivity, q.t.DvA);
    AppMethodBeat.o(370825);
  }
  
  private static final void b(FinderItem paramFinderItem, kotlin.g.a.b paramb, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(370834);
    s.u(paramFinderItem, "$feedObject");
    Object localObject1 = new ArrayList();
    if (paramInt2 == -1)
    {
      if (paramIntent == null)
      {
        localObject1 = null;
        paramIntent = (Intent)localObject1;
        if (localObject1 == null) {
          paramIntent = new ArrayList(0);
        }
        localObject1 = an.GhR;
        Log.i(an.a.getTAG(), "share finderObject " + paramFinderItem.getId() + " to " + paramIntent);
        localObject1 = an.GhR;
        an.a.aC(paramIntent);
        if (((Collection)paramIntent).isEmpty()) {
          break label213;
        }
      }
      JSONObject localJSONObject;
      label213:
      for (paramInt1 = 1;; paramInt1 = 0)
      {
        localObject1 = paramIntent;
        if (paramInt1 == 0) {
          break label327;
        }
        localJSONObject = new JSONObject();
        localObject2 = paramIntent.iterator();
        String str;
        for (localObject1 = ""; ((Iterator)localObject2).hasNext(); localObject1 = (String)localObject1 + str + ';') {
          str = (String)((Iterator)localObject2).next();
        }
        localObject1 = paramIntent.getStringArrayListExtra("SendMsgUsernames");
        break;
      }
      Object localObject2 = localObject1;
      if (n.rs((String)localObject1, ";"))
      {
        paramInt1 = ((String)localObject1).length();
        if (localObject1 == null)
        {
          paramFinderItem = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(370834);
          throw paramFinderItem;
        }
        localObject2 = ((String)localObject1).substring(0, paramInt1 - 1);
        s.s(localObject2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      }
      localJSONObject.put("1", localObject2);
      ((ce)h.ax(ce.class)).a(q.c.Drl, localJSONObject.toString());
      localObject1 = an.GhR;
      an.a.E(paramFinderItem);
      localObject1 = paramIntent;
    }
    for (;;)
    {
      label327:
      if (paramb != null) {
        paramb.invoke(localObject1);
      }
      AppMethodBeat.o(370834);
      return;
      paramFinderItem = new JSONObject();
      paramFinderItem.put("3", "");
      ((ce)h.ax(ce.class)).a(q.c.Drl, paramFinderItem.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ad
 * JD-Core Version:    0.7.0.1
 */
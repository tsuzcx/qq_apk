package com.tencent.mm.plugin.finder.feed;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.event.a;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.model.ca;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.utils.an;
import com.tencent.mm.plugin.finder.utils.an.a;
import com.tencent.mm.plugin.finder.view.e;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.component.k;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/FinderRecentForwardUtils;", "Lcom/tencent/mm/plugin/findersdk/api/IFinderRecentForwardUtils;", "()V", "TAG", "", "jumpToConversation", "", "context", "Landroidx/appcompat/app/AppCompatActivity;", "text", "username", "feedObject", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "contentObject", "Lcom/tencent/mm/plugin/findersdk/api/AppMsgContentFinderObject;", "shareType", "", "callback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "toUsers", "showForwardConfirmDialog", "userName", "menu", "Lcom/tencent/mm/ui/base/MMMenuItem;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ao
{
  public static final ao AYv;
  
  static
  {
    AppMethodBeat.i(363104);
    AYv = new ao();
    AppMethodBeat.o(363104);
  }
  
  private static final void a(AppCompatActivity paramAppCompatActivity, t paramt, FinderItem paramFinderItem, com.tencent.mm.plugin.findersdk.a.f paramf, b paramb, e parame, boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(370823);
    s.u(paramAppCompatActivity, "$context");
    s.u(paramt, "$menu");
    s.u(paramFinderItem, "$feedObject");
    s.u(parame, "$this_apply");
    if (paramBoolean)
    {
      Object localObject = e.Gxh;
      localObject = new r(Boolean.TRUE, Long.valueOf(cn.bDv()));
      s.u(localObject, "value");
      if (((Boolean)((r)localObject).bsC).booleanValue())
      {
        e.UF(0);
        Log.i("Finder.TimelineShareDialog", "reset count=0");
      }
      e.g((r)localObject);
      localObject = paramString;
      if (paramString == null) {
        localObject = "";
      }
      paramt = paramt.rDm;
      s.s(paramt, "menu.webUrl");
      paramString = k.aeZF;
      paramString = ((as)k.d(paramAppCompatActivity).q(as.class)).fou();
      com.tencent.mm.message.k.b localb = new com.tencent.mm.message.k.b();
      localb.a((com.tencent.mm.message.f)paramf);
      localb.type = 51;
      localb.title = MMApplicationContext.getContext().getString(e.h.low_version_upgrade_tip);
      localb.url = MMApplicationContext.getContext().getString(e.h.low_version_upgrade_url);
      paramf = new Intent();
      paramf.putExtra("Retr_Msg_Type", 18);
      paramf.putExtra("Multi_Retr", true);
      paramf.putExtra("Retr_Msg_content", com.tencent.mm.message.k.b.a(localb, null, null));
      paramf.putExtra("Retr_go_to_chattingUI", false);
      paramf.putExtra("Retr_show_success_tips", true);
      paramf.putExtra("custom_send_text", (String)localObject);
      paramf.putExtra("Retr_MsgQuickShare", true);
      paramf.putExtra("Select_Conv_User", paramt);
      c.a((MMFragmentActivity)paramAppCompatActivity, ".ui.transmit.MsgRetransmitUI", paramf, 1001, new ao..ExternalSyntheticLambda1(paramFinderItem, paramAppCompatActivity, 6, paramString, paramb));
    }
    parame.cyW();
    AppMethodBeat.o(370823);
  }
  
  private static final void a(FinderItem paramFinderItem, AppCompatActivity paramAppCompatActivity, int paramInt1, bui parambui, b paramb, int paramInt2, int paramInt3, Intent paramIntent)
  {
    AppMethodBeat.i(370824);
    s.u(paramFinderItem, "$feedObject");
    s.u(paramAppCompatActivity, "$context");
    s.u(parambui, "$contextObj");
    Object localObject = new ArrayList();
    if (paramInt3 == -1) {
      if (paramIntent == null)
      {
        localObject = null;
        paramIntent = (Intent)localObject;
        if (localObject == null) {
          paramIntent = new ArrayList(0);
        }
        localObject = an.GhR;
        Log.i(an.a.getTAG(), "share finderObject " + paramFinderItem.getId() + " to " + paramIntent);
        localObject = an.GhR;
        an.a.aC(paramIntent);
        if (((Collection)paramIntent).isEmpty()) {
          break label297;
        }
        paramInt2 = 1;
        label135:
        if (paramInt2 == 0) {
          break label416;
        }
        localObject = k.aeZF;
        paramAppCompatActivity = k.d(paramAppCompatActivity).q(as.class);
        s.s(paramAppCompatActivity, "UICProvider.of(context).…rReporterUIC::class.java)");
        paramAppCompatActivity = ((bn)paramAppCompatActivity).foy();
        if (paramAppCompatActivity == null) {
          break label416;
        }
        paramAppCompatActivity.dYj().mU(paramFinderItem.getId());
        paramAppCompatActivity = paramIntent;
      }
    }
    for (;;)
    {
      label192:
      long l1;
      if (paramInt3 == -1)
      {
        l1 = 1L;
        label201:
        if (paramFinderItem.getFromType() != 32768) {
          break label366;
        }
        paramIntent = z.FrZ;
        paramFinderItem = new ca(paramFinderItem.getFeedObject());
        paramIntent = Util.listToString((List)paramAppCompatActivity, ";");
        s.s(paramIntent, "listToString(toUsers, \";\")");
        z.a(paramFinderItem, paramInt1, l1, paramIntent, parambui, paramAppCompatActivity.size());
      }
      for (;;)
      {
        if (paramb != null) {
          paramb.invoke(paramAppCompatActivity);
        }
        AppMethodBeat.o(370824);
        return;
        localObject = paramIntent.getStringArrayListExtra("SendMsgUsernames");
        break;
        label297:
        paramInt2 = 0;
        break label135;
        paramIntent = k.aeZF;
        paramAppCompatActivity = k.d(paramAppCompatActivity).q(as.class);
        s.s(paramAppCompatActivity, "UICProvider.of(context).…rReporterUIC::class.java)");
        paramAppCompatActivity = ((bn)paramAppCompatActivity).foy();
        if (paramAppCompatActivity != null) {
          paramAppCompatActivity.dYj().mW(paramFinderItem.getId());
        }
        paramAppCompatActivity = (AppCompatActivity)localObject;
        break label192;
        l1 = 2L;
        break label201;
        label366:
        paramIntent = z.FrZ;
        long l2 = paramFinderItem.getId();
        paramFinderItem = Util.listToString((List)paramAppCompatActivity, ";");
        s.s(paramFinderItem, "listToString(toUsers, \";\")");
        z.a(l2, paramInt1, l1, paramFinderItem, parambui, paramAppCompatActivity.size(), null, 64);
      }
      label416:
      paramAppCompatActivity = paramIntent;
    }
  }
  
  public static void b(AppCompatActivity paramAppCompatActivity, String paramString, t paramt, FinderItem paramFinderItem)
  {
    AppMethodBeat.i(370822);
    s.u(paramAppCompatActivity, "context");
    s.u(paramString, "userName");
    s.u(paramt, "menu");
    s.u(paramFinderItem, "feedObject");
    Log.d("MircoMsg.FinderRecentForwardUtils", "showForwardConfirmDialog() called with: context = " + paramAppCompatActivity + ", userName = " + paramString + ", menu = " + paramt + ", feedObject = " + paramFinderItem);
    Object localObject = an.GhR;
    new Bundle();
    s.u(paramAppCompatActivity, "context");
    s.u(paramFinderItem, "feedObject");
    localObject = ((an.a)localObject).a(paramAppCompatActivity, paramFinderItem, 3, true);
    if (localObject == null) {}
    for (paramAppCompatActivity = null;; paramAppCompatActivity = paramString)
    {
      if (paramAppCompatActivity == null) {
        Log.i("MircoMsg.FinderRecentForwardUtils", "can not share!");
      }
      AppMethodBeat.o(370822);
      return;
      paramString = new e((Context)paramAppCompatActivity, paramString, 18, (com.tencent.mm.plugin.findersdk.a.f)localObject, null, 16);
      paramString.a(paramFinderItem.getId(), new ao..ExternalSyntheticLambda0(paramAppCompatActivity, paramt, paramFinderItem, (com.tencent.mm.plugin.findersdk.a.f)localObject, null, paramString));
      paramString.dDn();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ao
 * JD-Core Version:    0.7.0.1
 */
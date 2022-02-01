package com.tencent.mm.plugin.finder.convert;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.dk;
import com.tencent.mm.br.c;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.event.a.b;
import com.tencent.mm.plugin.finder.feed.component.e;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.logic.d.a;
import com.tencent.mm.plugin.finder.ui.FinderMsgFeedDetailUI;
import com.tencent.mm.plugin.finder.ui.FinderShareFeedDetailUI;
import com.tencent.mm.plugin.finder.ui.FinderShareFeedRelUI;
import com.tencent.mm.plugin.finder.utils.ar;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.utils.r;
import com.tencent.mm.plugin.finder.view.FinderCollapsibleTextView;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.findersdk.a.bi;
import com.tencent.mm.plugin.findersdk.a.bi.a;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.plugin.findersdk.a.bw;
import com.tencent.mm.pluginsdk.ui.span.t;
import com.tencent.mm.protocal.protobuf.FinderAuthInfo;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.FinderObjectDesc;
import com.tencent.mm.protocal.protobuf.axa;
import com.tencent.mm.protocal.protobuf.boi;
import com.tencent.mm.protocal.protobuf.brg;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.djj;
import com.tencent.mm.protocal.protobuf.fei;
import com.tencent.mm.protocal.protobuf.pu;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import com.tencent.mm.view.recyclerview.j;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.io.Serializable;
import java.util.List;
import java.util.List<Ljava.lang.Object;>;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderFeedCommentHeaderContent;", "presenter", "Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter;", "isOnlyShowDesc", "", "(Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter;Z)V", "()Z", "lastReportTime", "", "getPresenter", "()Lcom/tencent/mm/plugin/finder/feed/FinderCommentDrawerPresenter;", "checkJumpProfile", "", "context", "Landroid/content/Context;", "item", "Lcom/tencent/mm/plugin/finder/storage/FinderItem;", "checkPostOk", "createDescSpan", "Landroid/text/SpannableString;", "getLayoutId", "", "handleLinkTvOnClick", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "link", "", "handlePoiOnClick", "poiText", "isNewsObject", "isSelfScene", "jumpBizProfile", "bizUsername", "jumpProfile", "onBindViewHolder", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "refreshActivity", "refreshAvatar", "refreshCloseCommentTips", "refreshContentTime", "refreshDescContent", "refreshFeedJumper", "refreshLink", "refreshLoadingLayout", "refreshNickName", "refreshPoi", "report21464", "contextObj", "Lcom/tencent/mm/protocal/protobuf/FinderReportContextObj;", "feed", "actionType", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public class l
  extends com.tencent.mm.view.recyclerview.f<com.tencent.mm.plugin.finder.model.u>
{
  public static final a AHO;
  final com.tencent.mm.plugin.finder.feed.f AHP;
  private final boolean AHQ;
  private long lastReportTime;
  
  static
  {
    AppMethodBeat.i(350564);
    AHO = new a((byte)0);
    AppMethodBeat.o(350564);
  }
  
  public l(com.tencent.mm.plugin.finder.feed.f paramf, boolean paramBoolean)
  {
    AppMethodBeat.i(350450);
    this.AHP = paramf;
    this.AHQ = paramBoolean;
    AppMethodBeat.o(350450);
  }
  
  private static final void a(View paramView, j paramj, TextView paramTextView, String paramString)
  {
    AppMethodBeat.i(350518);
    kotlin.g.b.s.u(paramj, "$holder");
    int i = paramView.getWidth();
    if (i > 0)
    {
      int j = com.tencent.mm.cd.a.fromDPToPix(paramj.context, 20);
      if (paramTextView.getPaint().measureText(paramString) + j > i) {
        paramTextView.setText(TextUtils.ellipsize((CharSequence)paramString, paramTextView.getPaint(), i - j, TextUtils.TruncateAt.END));
      }
    }
    AppMethodBeat.o(350518);
  }
  
  private static final void a(l paraml, j paramj)
  {
    AppMethodBeat.i(350479);
    kotlin.g.b.s.u(paraml, "this$0");
    kotlin.g.b.s.u(paramj, "$holder");
    paraml = paraml.AHP.AUk;
    if (paraml != null)
    {
      paraml = paraml.getLoadingLayout();
      if (paraml != null) {
        paraml.setPadding(paraml.getPaddingLeft(), paramj.caK.getHeight(), paraml.getPaddingRight(), paraml.getPaddingBottom());
      }
    }
    AppMethodBeat.o(350479);
  }
  
  private static final void a(l paraml, j paramj, com.tencent.mm.plugin.finder.model.u paramu, View paramView)
  {
    AppMethodBeat.i(350514);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paraml);
    localb.cH(paramj);
    localb.cH(paramu);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paraml, "this$0");
    kotlin.g.b.s.u(paramj, "$holder");
    kotlin.g.b.s.u(paramu, "$item");
    paramView = paramj.context;
    kotlin.g.b.s.s(paramView, "holder.context");
    paramj = paramu.ANj;
    paraml = as.GSQ;
    paraml = as.a.hu(paramView);
    int i;
    if (paraml == null)
    {
      i = 0;
      switch (i)
      {
      default: 
        if ((paramj.getFeedObject().func_flag & 0x1) > 0)
        {
          i = 1;
          label175:
          if (i == 0) {
            break label342;
          }
          paraml = paramj;
          label182:
          if (paraml != null) {
            break label347;
          }
        }
        break;
      }
    }
    for (paraml = null;; paraml = null)
    {
      if (paraml == null)
      {
        paraml = new Intent();
        paraml.putExtra("finder_username", paramj.getUserName());
        paraml.putExtra("finder_read_feed_id", paramj.getId());
        if ((!(paramView instanceof FinderShareFeedRelUI)) && (!(paramView instanceof FinderShareFeedDetailUI)) && (!(paramView instanceof FinderMsgFeedDetailUI))) {
          paraml.putExtra("KEY_FROM_TIMELINE", true);
        }
        paramu = as.GSQ;
        as.a.a(paramView, paraml, paramj.getId(), 1, false, 64);
        com.tencent.mm.plugin.finder.utils.a.GfO.enterFinderProfileUI(paramView, paraml);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(350514);
        return;
        i = paraml.AJo;
        break;
        Log.i("Finder.FeedCommentHeaderConvert", "checkJumpProfile: hit SOURCE_PROFILE_TIMELINE, avatar can't click.");
        ((Activity)paramView).finish();
      }
      i = 0;
      break label175;
      label342:
      paraml = null;
      break label182;
      label347:
      paraml = paraml.getBizInfo();
      if (paraml != null) {
        break label361;
      }
    }
    label361:
    paraml = paraml.ADE;
    if (paraml == null) {
      paraml = "";
    }
    for (;;)
    {
      paramu = new Intent();
      localObject = as.GSQ;
      as.a.a(paramView, paramu, paramj.getId(), 1, false, 64);
      paramu.putExtra("Contact_User", paraml);
      paramu.putExtra("Contact_Scene", 214);
      paramu.putExtra("biz_profile_enter_from_finder", true);
      paramu.putExtra("force_get_contact", true);
      paramu.putExtra("key_use_new_contact_profile", true);
      paramu.putExtra("finder_feed_id", paramj.getId());
      paramu.putExtra("Contact_Scene_Note", paramj.getFeedObject().sessionBuffer);
      paramu.putExtra("biz_profile_tab_type", 1);
      c.b(paramView, "profile", ".ui.ContactInfoUI", paramu);
      paraml = ah.aiuX;
      break;
    }
  }
  
  private static final void a(l paraml, j paramj, com.tencent.mm.plugin.finder.model.u paramu, String paramString, View paramView)
  {
    AppMethodBeat.i(350551);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paraml);
    localb.cH(paramj);
    localb.cH(paramu);
    localb.cH(paramString);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paraml, "this$0");
    kotlin.g.b.s.u(paramj, "$holder");
    kotlin.g.b.s.u(paramu, "$item");
    paramu = paramu.ANj;
    paraml = com.tencent.mm.plugin.finder.storage.d.FAy;
    if (((Boolean)com.tencent.mm.plugin.finder.storage.d.eVV().bmg()).booleanValue())
    {
      paraml = new Intent();
      paramString = new fei();
      paramString.ZaH = paramu.getLocation().latitude;
      paramString.ZaG = paramu.getLocation().longitude;
      paramString.ZWG = paramu.getLocation().ZWG;
      paraml.putExtra("key_location", paramString.toByteArray());
      paraml.putExtra("key_from_type", (Serializable)bi.a.Hcp);
      paramu = as.GSQ;
      paramu = paramj.context;
      kotlin.g.b.s.s(paramu, "holder.context");
      paramu = as.a.hu(paramu);
      if (paramu != null)
      {
        paraml.putExtra("key_from_scene", paramu.AJo);
        paraml.putExtra("key_context_id", paramu.zIO);
      }
      com.tencent.mm.plugin.report.service.h.OAn.p(((bi)com.tencent.mm.kernel.h.ax(bi.class)).ePz(), 5L, 1L);
      paramu = com.tencent.mm.plugin.finder.utils.a.GfO;
      paramj = paramj.context;
      kotlin.g.b.s.s(paramj, "holder.context");
      paramu.w(paramj, paraml);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(350551);
      return;
      paraml = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (com.tencent.mm.plugin.finder.storage.d.eRs())
      {
        paraml = com.tencent.mm.plugin.finder.storage.d.FAy;
        if (com.tencent.mm.plugin.finder.storage.d.eRu())
        {
          paraml = av.GiL;
          int i;
          if (!av.Iz(paramu.getUserName())) {
            i = 1;
          }
          for (;;)
          {
            if (i == 0) {
              break label628;
            }
            paramView = new Intent();
            paramView.putExtra("key_topic_type", 2);
            paramView.putExtra("key_ref_object_id", paramu.getId());
            paramView.putExtra("key_topic_title", paramString);
            paramView.putExtra("key_topic_poi_location", paramu.getLocation().toByteArray());
            paraml = as.GSQ;
            paraml = paramj.context;
            kotlin.g.b.s.s(paraml, "holder.context");
            as.a.a(paraml, paramView, 0L, 0, false, 124);
            paraml = com.tencent.mm.plugin.finder.utils.a.GfO;
            localObject = paramj.context;
            kotlin.g.b.s.s(localObject, "holder.context");
            paraml.A((Context)localObject, paramView);
            paraml = as.GSQ;
            paraml = paramj.context;
            kotlin.g.b.s.s(paraml, "holder.context");
            paramj = as.a.hu(paraml);
            if (paramj == null) {
              break;
            }
            paraml = com.tencent.mm.plugin.finder.report.z.FrZ;
            long l = paramu.getId();
            paraml = paramString;
            if (paramString == null) {
              paraml = "";
            }
            com.tencent.mm.plugin.finder.report.z.a(l, paraml, 2, paramj.AJo);
            paramView.putExtra("KEY_TAB_TYPE", paramj.GKp);
            paraml = ((bn)paramj).foy();
            if (paraml == null) {
              break;
            }
            paraml = paraml.dYj();
            if (paraml == null) {
              break;
            }
            paraml.nh(paramu.getId());
            break;
            if (paramu.isPostFinish()) {
              i = 1;
            } else if ((!paramu.isPostFailed()) && ((paramu.isPostFinish()) || (paramu.getPostInfo().aaPw >= 100))) {
              i = 1;
            } else {
              i = 0;
            }
          }
          label628:
          Log.i("Finder.FeedCommentHeaderConvert", "click poi but isPostOk false");
          continue;
        }
      }
      paraml = av.GiL;
      paraml = paramj.context;
      kotlin.g.b.s.s(paraml, "holder.context");
      av.a(paraml, paramu.getLocation());
    }
  }
  
  private static final void a(l paraml, j paramj, com.tencent.mm.plugin.finder.model.u paramu, String paramString, bui parambui, View paramView)
  {
    AppMethodBeat.i(350525);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paraml);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramj);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramu);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramString);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(parambui);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(paraml, "this$0");
    kotlin.g.b.s.u(paramj, "$holder");
    kotlin.g.b.s.u(paramu, "$item");
    paramView = paramu.ANj;
    localObject1 = as.GSQ;
    localObject1 = paramj.context;
    kotlin.g.b.s.s(localObject1, "holder.context");
    localObject1 = as.a.hu((Context)localObject1);
    if (localObject1 == null) {}
    for (int i = 0;; i = ((as)localObject1).AJo)
    {
      localObject1 = new Intent();
      localObject2 = ar.Giw;
      localObject2 = ar.ap(paramString, i + 10000, (int)(System.currentTimeMillis() / 1000L));
      Log.i("Finder.FeedCommentHeaderConvert", "click linkLayout, url:" + paramString + ", urlWithReportParams:" + localObject2);
      ((Intent)localObject1).putExtra("rawUrl", (String)localObject2);
      c.b(paramj.context, "webview", ".ui.tools.WebViewUI", (Intent)localObject1);
      paramString = as.GSQ;
      paramj = paramj.context;
      kotlin.g.b.s.s(paramj, "holder.context");
      paramj = as.a.hu(paramj);
      if (paramj != null)
      {
        paramj = ((bn)paramj).foy();
        if (paramj != null)
        {
          paramj = paramj.dYj();
          if (paramj != null) {
            paramj.nm(paramView.getId());
          }
        }
      }
      paraml.a(parambui, paramu.ANj, 2L);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(350525);
      return;
    }
  }
  
  private static final void a(brg parambrg, com.tencent.mm.plugin.finder.model.u paramu, j paramj, View paramView)
  {
    AppMethodBeat.i(350494);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parambrg);
    localb.cH(paramu);
    localb.cH(paramj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parambrg, "$this_apply");
    kotlin.g.b.s.u(paramu, "$item");
    kotlin.g.b.s.u(paramj, "$holder");
    paramView = new Intent();
    paramView.putExtra("key_activity_id", parambrg.ocD);
    paramView.putExtra("key_activity_name", parambrg.eventName);
    paramView.putExtra("key_nick_name", parambrg.ZZl);
    paramView.putExtra("key_feed_ref_id", paramu.ANj.getFeedObject().id);
    Log.i("Finder.FeedCommentHeaderConvert", "eventTopicId :" + parambrg.ocD + " eventName:" + parambrg.eventName + " refId: " + paramu.ANj.getFeedObject().id);
    paramView.putExtra("key_feed_report_id", paramu.ANj.getFeedObject().id);
    paramView.putExtra("key_activity_profile_src_type", "1");
    paramView.putExtra("key_entrance_type", 7);
    parambrg = com.tencent.mm.plugin.finder.utils.a.GfO;
    parambrg = paramj.context;
    if (parambrg == null)
    {
      parambrg = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(350494);
      throw parambrg;
    }
    com.tencent.mm.plugin.finder.utils.a.aq((Context)parambrg, paramView);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(350494);
  }
  
  private final void a(bui parambui, FinderItem paramFinderItem, long paramLong)
  {
    AppMethodBeat.i(350466);
    dk localdk;
    Object localObject;
    label76:
    String str;
    if (cn.bDw() - this.lastReportTime > 500L)
    {
      this.lastReportTime = cn.bDw();
      localdk = new dk();
      localdk.nr(com.tencent.mm.ae.d.hF(paramFinderItem.getId()));
      if (parambui != null) {
        break label198;
      }
      localObject = "";
      localdk.ns((String)localObject);
      if (parambui != null) {
        break label221;
      }
      localObject = "";
      localdk.nt((String)localObject);
      str = paramFinderItem.getExtReading().link;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      localdk.nu((String)localObject);
      localdk.izD = 1L;
      localdk.ioV = paramLong;
      if (parambui != null) {
        break label244;
      }
      localObject = "";
      label136:
      localdk.nv((String)localObject);
      if (parambui != null) {
        break label267;
      }
      paramLong = 0L;
      label150:
      localdk.iwD = paramLong;
      localObject = com.tencent.mm.plugin.finder.report.z.FrZ;
      paramLong = paramFinderItem.getId();
      if (parambui != null) {
        break label276;
      }
    }
    label267:
    label276:
    for (int i = 0;; i = parambui.AJo)
    {
      localdk.nw(com.tencent.mm.plugin.finder.report.z.p(paramLong, i));
      localdk.bMH();
      AppMethodBeat.o(350466);
      return;
      label198:
      str = parambui.sessionId;
      localObject = str;
      if (str != null) {
        break;
      }
      localObject = "";
      break;
      label221:
      str = parambui.zIO;
      localObject = str;
      if (str != null) {
        break label76;
      }
      localObject = "";
      break label76;
      label244:
      str = parambui.zIB;
      localObject = str;
      if (str != null) {
        break label136;
      }
      localObject = "";
      break label136;
      paramLong = parambui.AJo;
      break label150;
    }
  }
  
  private static final void b(View paramView, j paramj, TextView paramTextView, String paramString)
  {
    AppMethodBeat.i(350532);
    kotlin.g.b.s.u(paramj, "$holder");
    int i = paramView.getWidth();
    if (i > 0)
    {
      int j = com.tencent.mm.cd.a.fromDPToPix(paramj.context, 20);
      if (paramTextView.getPaint().measureText(paramString) + j > i) {
        paramTextView.setText(TextUtils.ellipsize((CharSequence)paramString, paramTextView.getPaint(), i - j, TextUtils.TruncateAt.END));
      }
    }
    AppMethodBeat.o(350532);
  }
  
  private static final void b(j paramj, View paramView)
  {
    AppMethodBeat.i(350502);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramj, "$holder");
    paramj = paramj.UH(e.e.avatar_iv);
    if (paramj != null) {
      paramj.callOnClick();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(350502);
  }
  
  private static final boolean fp(View paramView)
  {
    AppMethodBeat.i(350472);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", localObject, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(false, new Object(), "com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
    AppMethodBeat.o(350472);
    return false;
  }
  
  public SpannableString a(com.tencent.mm.plugin.finder.model.u paramu)
  {
    AppMethodBeat.i(350682);
    kotlin.g.b.s.u(paramu, "item");
    paramu = paramu.ANj.createDescriptionFullSpan2();
    AppMethodBeat.o(350682);
    return paramu;
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(350633);
    kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
    kotlin.g.b.s.u(paramj, "holder");
    paramRecyclerView = (FinderCollapsibleTextView)paramj.UH(e.e.text_content);
    paramRecyclerView.getContentTextView().setOnTouchListener((View.OnTouchListener)new com.tencent.mm.pluginsdk.ui.span.l(paramRecyclerView.getContentTextView(), (View.OnTouchListener)new com.tencent.mm.pluginsdk.ui.span.s(paramj.context)));
    paramRecyclerView.getContentTextView().setTextColor(paramj.context.getResources().getColor(com.tencent.mm.plugin.finder.e.b.BW_0_Alpha_0_9));
    paramRecyclerView.setLimitLine(10);
    AppMethodBeat.o(350633);
  }
  
  public void a(j paramj, com.tencent.mm.plugin.finder.model.u paramu)
  {
    AppMethodBeat.i(350670);
    kotlin.g.b.s.u(paramj, "holder");
    kotlin.g.b.s.u(paramu, "item");
    Object localObject1 = paramu.ANj.getFeedObject().objectDesc;
    if (localObject1 == null) {}
    for (localObject1 = null; localObject1 == null; localObject1 = ((FinderObjectDesc)localObject1).event)
    {
      paramu = null;
      if (paramu == null)
      {
        paramj = paramj.UH(e.e.activity_layout);
        if (paramj != null) {
          paramj.setVisibility(8);
        }
      }
      AppMethodBeat.o(350670);
      return;
    }
    if (Util.isNullOrNil(((brg)localObject1).eventName))
    {
      paramu = paramj.UH(e.e.activity_layout);
      if (paramu != null) {
        paramu.setVisibility(8);
      }
    }
    label198:
    label243:
    do
    {
      paramu = (com.tencent.mm.plugin.finder.model.u)localObject1;
      break;
      localObject2 = paramj.UH(e.e.activity_layout);
      if (localObject2 != null) {
        ((View)localObject2).setVisibility(0);
      }
      localObject2 = paramj.UH(e.e.activity_layout);
      if (localObject2 != null)
      {
        if ((!paramu.ANj.isPostFinish()) || (((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu())) {
          break label355;
        }
        ((View)localObject2).setOnClickListener(new l..ExternalSyntheticLambda3((brg)localObject1, paramu, paramj));
      }
      paramu = (WeImageView)paramj.UH(e.e.activity_icon);
      if (paramu != null)
      {
        if (!((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu()) {
          break label364;
        }
        i = MMApplicationContext.getContext().getResources().getColor(com.tencent.mm.plugin.finder.e.b.FG_1);
        paramu.setIconColor(i);
      }
      paramu = (TextView)paramj.UH(e.e.activity_title);
    } while (paramu == null);
    Object localObject2 = ar.Giw;
    localObject2 = paramu.getContext();
    kotlin.g.b.s.s(localObject2, "it.context");
    localObject2 = kotlin.g.b.s.X(ar.a((brg)localObject1, (Context)localObject2), ((brg)localObject1).eventName);
    if (((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu()) {}
    for (int i = MMApplicationContext.getContext().getResources().getColor(com.tencent.mm.plugin.finder.e.b.FG_1);; i = MMApplicationContext.getContext().getResources().getColor(com.tencent.mm.plugin.finder.e.b.Link_80))
    {
      paramu.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b(MMApplicationContext.getContext(), (CharSequence)localObject2));
      paramu.setTextColor(i);
      break;
      label355:
      ((View)localObject2).setOnClickListener(null);
      break label198;
      label364:
      i = MMApplicationContext.getContext().getResources().getColor(com.tencent.mm.plugin.finder.e.b.Orange);
      break label243;
    }
  }
  
  public void a(final j paramj, com.tencent.mm.plugin.finder.model.u paramu, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(350656);
    kotlin.g.b.s.u(paramj, "holder");
    kotlin.g.b.s.u(paramu, "item");
    Object localObject1 = (TextView)paramj.caK.findViewById(e.e.nickname);
    label72:
    label220:
    Object localObject2;
    label144:
    label189:
    Object localObject3;
    if ((paramu.ANj.getFeedObject().func_flag & 0x1) > 0)
    {
      paramList = paramu.ANj.getBizInfo();
      if (paramList == null)
      {
        paramList = null;
        if (paramList == null) {
          break label505;
        }
        kotlin.g.b.s.s(paramList, "if (item.feed.feedObject…       item.feed.nickName");
        ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b(paramj.context, (CharSequence)paramList));
        paramList = paramu.ANj.getFeedObject().contact;
        if (paramList != null)
        {
          if ((paramu.ANj.getFeedObject().func_flag & 0x1) <= 0) {
            break label517;
          }
          paramj.UH(e.e.auth_icon).setVisibility(8);
        }
        ((TextView)localObject1).setOnClickListener(new l..ExternalSyntheticLambda4(paramj));
        if ((paramu.ANj.getFeedObject().func_flag & 0x1) <= 0) {
          break label662;
        }
        paramList = paramu.ANj.getBizInfo();
        if (paramList != null) {
          break label628;
        }
        localObject1 = null;
        paramList = (List<Object>)localObject1;
        if (localObject1 == null)
        {
          paramList = paramu.ANj.getFeedObject().contact;
          if (paramList != null) {
            break label638;
          }
          paramList = "";
        }
        localObject1 = com.tencent.mm.plugin.finder.loader.p.ExI;
        localObject1 = com.tencent.mm.plugin.finder.loader.p.eCp();
        paramList = new com.tencent.mm.plugin.finder.loader.b(paramList);
        localObject2 = paramj.UH(e.e.avatar_iv);
        kotlin.g.b.s.s(localObject2, "holder.getView(R.id.avatar_iv)");
        localObject2 = (ImageView)localObject2;
        localObject3 = com.tencent.mm.plugin.finder.loader.p.ExI;
        ((com.tencent.mm.loader.d)localObject1).a(paramList, (ImageView)localObject2, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM));
        paramList = paramj.UH(e.e.avatar_iv);
        if (paramList != null) {
          paramList.setOnClickListener(new l..ExternalSyntheticLambda0(this, paramj, paramu));
        }
        paramList = (FinderCollapsibleTextView)paramj.UH(e.e.text_content);
        localObject2 = paramj.UH(e.e.right_btn_layout);
        paramList.setCollapse(paramu.isContentCollapsed);
        if ((!((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu()) && (!this.AHQ)) {
          break label711;
        }
        paramInt1 = MMApplicationContext.getContext().getResources().getColor(com.tencent.mm.plugin.finder.e.b.FG_1);
        label381:
        if ((!((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu()) && (!this.AHQ)) {
          break label727;
        }
      }
    }
    label517:
    label662:
    label711:
    label727:
    for (paramInt2 = MMApplicationContext.getContext().getResources().getColor(com.tencent.mm.plugin.finder.e.b.transparent);; paramInt2 = MMApplicationContext.getContext().getResources().getColor(com.tencent.mm.plugin.finder.e.b.link_color_pressed))
    {
      localObject1 = new SpannableString((CharSequence)a(paramu));
      localObject3 = (t[])((SpannableString)localObject1).getSpans(0, ((SpannableString)localObject1).length(), t.class);
      if (localObject3 == null) {
        break label744;
      }
      int j = localObject3.length;
      int i = 0;
      while (i < j)
      {
        localObject3[i].setColor(paramInt1, paramInt2);
        i += 1;
      }
      paramList = paramList.YTl;
      break;
      label505:
      paramList = paramu.ANj.getNickName();
      break label72;
      localObject2 = paramList.authInfo;
      if (localObject2 == null) {}
      for (paramInt1 = 0;; paramInt1 = ((FinderAuthInfo)localObject2).authIconType)
      {
        localObject2 = av.GiL;
        localObject2 = paramj.UH(e.e.auth_icon);
        kotlin.g.b.s.s(localObject2, "holder.getView<ImageView>(R.id.auth_icon)");
        av.a((ImageView)localObject2, paramList.authInfo, 0, null, 12);
        switch (paramInt1)
        {
        default: 
          break;
        case 1: 
          paramj.pt(e.e.auth_icon, 0);
          break;
        }
      }
      paramj.pt(e.e.auth_icon, 0);
      break label144;
      label628:
      localObject1 = paramList.xkY;
      break label189;
      label638:
      localObject1 = paramList.headUrl;
      paramList = (List<Object>)localObject1;
      if (localObject1 != null) {
        break label220;
      }
      paramList = "";
      break label220;
      paramList = paramu.ANj.getFeedObject().contact;
      if (paramList == null)
      {
        paramList = "";
        break label220;
      }
      localObject1 = paramList.headUrl;
      paramList = (List<Object>)localObject1;
      if (localObject1 != null) {
        break label220;
      }
      paramList = "";
      break label220;
      paramInt1 = MMApplicationContext.getContext().getResources().getColor(com.tencent.mm.plugin.finder.e.b.Link_100);
      break label381;
    }
    label744:
    kotlin.g.b.s.s(paramList, "collapseTextLayout");
    FinderCollapsibleTextView.a(paramList, (CharSequence)localObject1, (View)localObject2, null, 4);
    paramList.setOnCollapse((kotlin.g.a.b)new b(paramu, paramj, this));
    if (((CharSequence)localObject1).length() > 0)
    {
      paramInt1 = 1;
      if (paramInt1 != 0)
      {
        localObject2 = com.tencent.mm.plugin.finder.topic.a.FNS;
        com.tencent.mm.plugin.finder.topic.a.a((View)paramList, (SpannableString)localObject1, paramu.ANj.field_id);
      }
      a(paramj, paramu);
      c(paramj, paramu);
      b(paramj, paramu);
      paramList = (TextView)paramj.caK.findViewById(e.e.contentTimeTv);
      if (paramu.ANj.getCreateTime() <= 0) {
        break label1186;
      }
      localObject1 = com.tencent.mm.plugin.finder.storage.d.FAy;
      if (((Number)com.tencent.mm.plugin.finder.storage.d.eYh().bmg()).intValue() != 1)
      {
        if (paramu.ANj.getFeedObject().objectType != 1) {
          break label1158;
        }
        paramInt1 = 1;
        label905:
        if (paramInt1 == 0)
        {
          localObject1 = paramj.context;
          kotlin.g.b.s.s(localObject1, "holder.context");
          if (!(localObject1 instanceof Activity)) {
            break label1181;
          }
          localObject2 = ((Activity)localObject1).getIntent().getStringExtra("finder_username");
          boolean bool = ((Activity)localObject1).getIntent().getBooleanExtra("KEY_FINDER_SELF_FLAG", false);
          if (localObject2 != null) {
            break label1163;
          }
          paramBoolean = false;
          label972:
          if ((!paramBoolean) || (!bool)) {
            break label1176;
          }
          paramInt1 = 1;
          label984:
          if (paramInt1 == 0) {
            break label1186;
          }
        }
      }
      paramList.setVisibility(0);
      paramList.setText((CharSequence)r.q(paramj.context, paramu.ANj.getCreateTime() * 1000L));
    }
    for (;;)
    {
      if (!((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu()) {
        break label1196;
      }
      paramj.UH(e.e.finder_comment_closed_tips2).setVisibility(8);
      paramj.UH(e.e.finder_comment_teenmode_tips2).setVisibility(0);
      paramu = paramu.ANj;
      paramList = k.aeZF;
      paramList = paramj.context;
      kotlin.g.b.s.s(paramList, "holder.context");
      paramList = (e)k.nq(paramList).q(e.class);
      localObject1 = com.tencent.mm.plugin.finder.storage.logic.d.FND;
      paramList.a(d.a.a(paramu), paramj, "comment");
      paramj.caK.post(new l..ExternalSyntheticLambda8(this, paramj));
      paramj.caK.setOnLongClickListener(l..ExternalSyntheticLambda5.INSTANCE);
      AppMethodBeat.o(350656);
      return;
      paramInt1 = 0;
      break;
      label1158:
      paramInt1 = 0;
      break label905;
      label1163:
      paramBoolean = ((String)localObject2).equals(com.tencent.mm.model.z.bAW());
      break label972;
      label1176:
      paramInt1 = 0;
      break label984;
      label1181:
      paramInt1 = 0;
      break label984;
      label1186:
      paramList.setVisibility(8);
    }
    label1196:
    paramList = paramj.UH(e.e.finder_comment_closed_tips2);
    if (paramu.ANj.isCommentClose()) {}
    for (paramInt1 = 0;; paramInt1 = 8)
    {
      paramList.setVisibility(paramInt1);
      paramj.UH(e.e.finder_comment_teenmode_tips2).setVisibility(8);
      break;
    }
  }
  
  public void b(j paramj, final com.tencent.mm.plugin.finder.model.u paramu)
  {
    AppMethodBeat.i(350677);
    kotlin.g.b.s.u(paramj, "holder");
    kotlin.g.b.s.u(paramu, "item");
    View localView = paramj.UH(e.e.link_layout);
    localView.setVisibility(8);
    Object localObject1 = paramu.ANj.getExtReading();
    String str;
    Object localObject2;
    TextView localTextView;
    if ((!Util.isNullOrNil(((axa)localObject1).link)) && (!Util.isNullOrNil(((axa)localObject1).title)))
    {
      str = ((axa)localObject1).link;
      localObject2 = ((axa)localObject1).title;
      localTextView = (TextView)paramj.UH(e.e.link_title);
      paramj.d(e.e.link_title, (CharSequence)localObject2);
      Log.i("Finder.FeedCommentHeaderConvert", "link " + str + ", title " + ((axa)localObject1).title);
      localView.post(new l..ExternalSyntheticLambda6(localView, paramj, localTextView, (String)localObject2));
      localObject2 = (WeImageView)paramj.UH(e.e.link_icon);
      switch (((axa)localObject1).style)
      {
      default: 
        localObject1 = as.GSQ;
        localObject1 = paramj.context;
        kotlin.g.b.s.s(localObject1, "holder.context");
        localObject1 = as.a.hu((Context)localObject1);
        if (localObject1 != null) {
          break;
        }
      }
    }
    for (localObject1 = null;; localObject1 = ((as)localObject1).fou())
    {
      kotlin.g.b.s.s(localView, "linkLayout");
      com.tencent.mm.view.f.a(localView, (com.tencent.mm.view.e.b)new c(this, (bui)localObject1, paramu));
      localView.setVisibility(0);
      if ((localObject2 != null) && (((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu())) {
        ((WeImageView)localObject2).setIconColor(MMApplicationContext.getContext().getResources().getColor(com.tencent.mm.plugin.finder.e.b.FG_1));
      }
      if ((localTextView != null) && (((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu())) {
        localTextView.setTextColor(MMApplicationContext.getContext().getResources().getColor(com.tencent.mm.plugin.finder.e.b.FG_1));
      }
      if (!((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu()) {
        localTextView.setOnClickListener(new l..ExternalSyntheticLambda2(this, paramj, paramu, str, (bui)localObject1));
      }
      AppMethodBeat.o(350677);
      return;
      ((WeImageView)localObject2).setImageResource(e.g.icons_filled_link);
      break;
      ((WeImageView)localObject2).setImageResource(e.g.icons_filled_red_envelope);
      break;
    }
  }
  
  public void c(j paramj, com.tencent.mm.plugin.finder.model.u paramu)
  {
    AppMethodBeat.i(350689);
    kotlin.g.b.s.u(paramj, "holder");
    kotlin.g.b.s.u(paramu, "item");
    Object localObject = paramu.ANj.getLocation();
    View localView = paramj.UH(e.e.position_layout);
    WeImageView localWeImageView = (WeImageView)paramj.UH(e.e.poi_icon);
    TextView localTextView = (TextView)paramj.UH(e.e.poi_name);
    av localav = av.GiL;
    localObject = av.cn(((boi)localObject).city, ((boi)localObject).poiName);
    if (Util.isNullOrNil((String)localObject))
    {
      localView.setVisibility(8);
      AppMethodBeat.o(350689);
      return;
    }
    localTextView.setText((CharSequence)localObject);
    localTextView.post(new l..ExternalSyntheticLambda7(localView, paramj, localTextView, (String)localObject));
    localView.setVisibility(0);
    if ((localWeImageView != null) && (((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu())) {
      localWeImageView.setIconColor(MMApplicationContext.getContext().getResources().getColor(com.tencent.mm.plugin.finder.e.b.FG_1));
    }
    if ((localTextView != null) && (((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu())) {
      localTextView.setTextColor(MMApplicationContext.getContext().getResources().getColor(com.tencent.mm.plugin.finder.e.b.FG_1));
    }
    if (!((bw)com.tencent.mm.kernel.h.ax(bw.class)).aBu()) {
      localTextView.setOnClickListener(new l..ExternalSyntheticLambda1(this, paramj, paramu, (String)localObject));
    }
    AppMethodBeat.o(350689);
  }
  
  public final int getLayoutId()
  {
    return e.f._feed_comment_header_content_layout;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "isCollapse", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.b<Boolean, ah>
  {
    b(com.tencent.mm.plugin.finder.model.u paramu, j paramj, l paraml)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/convert/FinderFeedCommentHeaderConvert$refreshLink$1$2", "Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;", "getExposedId", "", "view", "Landroid/view/View;", "onViewExposed", "", "oldExposedId", "newExposedId", "isExposed", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    extends com.tencent.mm.view.e.b
  {
    c(l paraml, bui parambui, com.tencent.mm.plugin.finder.model.u paramu) {}
    
    public final void a(View paramView, long paramLong1, long paramLong2, boolean paramBoolean)
    {
      AppMethodBeat.i(350566);
      kotlin.g.b.s.u(paramView, "view");
      if (paramBoolean) {
        l.a(this.AHS, this.$contextObj, paramu.ANj);
      }
      AppMethodBeat.o(350566);
    }
    
    public final long fq(View paramView)
    {
      AppMethodBeat.i(350573);
      kotlin.g.b.s.u(paramView, "view");
      long l = paramu.ANj.field_id;
      AppMethodBeat.o(350573);
      return l;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.l
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.activity.view;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Paint.FontMetricsInt;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.m;
import com.tencent.mm.plugin.finder.cgi.di;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.post.g;
import com.tencent.mm.plugin.finder.utils.ar;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.view.q;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderJumpInfo;
import com.tencent.mm.protocal.protobuf.aws;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.protocal.protobuf.awx;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bxv;
import com.tencent.mm.protocal.protobuf.bys;
import com.tencent.mm.protocal.protobuf.byy;
import com.tencent.mm.protocal.protobuf.fmi;
import com.tencent.mm.protocal.protobuf.fxe;
import com.tencent.mm.protocal.protobuf.fxs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidContextUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.af;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.io.Serializable;
import java.nio.charset.Charset;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.n.n;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "context", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "activityDesc", "", "activityEventId", "", "activityName", "activityParticipateCount", "", "getActivityParticipateCount", "()I", "setActivityParticipateCount", "(I)V", "adActivityIcon", "Landroid/widget/ImageView;", "adArrow", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "adContainer", "Landroid/widget/LinearLayout;", "adMiniAppIcon", "adTextView", "Landroid/widget/TextView;", "avatarContainer", "avatarUrl", "bottomSheetDialog", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "getContext", "()Lcom/tencent/mm/ui/MMActivity;", "coverUrl", "descIconView", "Landroid/view/View;", "endTimeTextView", "eventInfo", "Lcom/tencent/mm/protocal/protobuf/FinderEventInfo;", "finderTopicInfo", "Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "getFinderTopicInfo", "()Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;", "setFinderTopicInfo", "(Lcom/tencent/mm/protocal/protobuf/FinderTopicInfo;)V", "finderTopicInfoListener", "com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$finderTopicInfoListener$1", "Lcom/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$finderTopicInfoListener$1;", "fromObjectId", "headerAvatarView", "headerDescTextView", "headerNameTextView", "headerParticipateTextView", "headerTitleTextView", "headerView", "isReceivedTopic", "", "mDialogBehavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "nickName", "noteAvatarContainer", "noteContainer", "noteLine", "noteTextView", "participateBottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "participateBtn", "participateIcon", "participateText", "preCheckHelper", "Lcom/tencent/mm/plugin/finder/post/PostPreCheckUIC;", "prepareResp", "Lcom/tencent/mm/protocal/protobuf/FinderUserPrepareResponse;", "removeEvent", "com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$removeEvent$1", "Lcom/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$removeEvent$1;", "udfJson", "Lorg/json/JSONObject;", "getUdfJson", "()Lorg/json/JSONObject;", "setUdfJson", "(Lorg/json/JSONObject;)V", "addParticipateCount", "", "incCount", "changeParticipateButton", "changeParticipateView", "isFinished", "destroy", "dismissAuthViews", "authIcon", "authDesc", "authGuaranteeView", "Landroid/view/ViewGroup;", "getActivityEndText", "getAvailableDescWidth", "getHeaderView", "topicInfo", "getIconWidth", "getParticipateText", "getReportUdfKv", "handleAccountStatus", "initHeaderView", "initParam", "isCovered", "isNoEllipseDescClickable", "jumpByJumpInfo", "jumpInfo", "Lcom/tencent/mm/protocal/protobuf/FinderJumpInfo;", "jumpByMiniProgram", "jumpToPage", "jumpToProfile", "username", "kv", "loadAvatar", "url", "onResume", "isFirstResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "participate", "performPost", "intent", "Landroid/content/Intent;", "refreshHeader", "report21875", "eid", "action", "jumpInfoStr", "seatType", "commentScene", "reportJumpInfo", "reportMiniProgram", "setAuthText", "authInfo", "Lcom/tencent/mm/protocal/protobuf/FinderAuthInfo;", "setCoverStyle", "setDescSpan", "textView", "descText", "color", "leftMargin", "clickListener", "Lkotlin/Function1;", "setDetailTextMaxHeight", "setHeaderView", "setNormalStyle", "setParticipateText", "count", "setSuffixedDesc", "maxLineNum", "setSuffixedIcon", "setTextColor", "textColor", "setView", "showAccountBottomSheet", "showBottomSheet", "showJumpView", "showMiniProgram", "showParticipateBottomSheet", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements com.tencent.mm.am.h
{
  public static final a Awx;
  private String AtM;
  private awt AtP;
  private boolean AtV;
  private TextView AuK;
  private View AuL;
  private TextView AuR;
  private TextView AuS;
  private ImageView AuT;
  private TextView AuU;
  private TextView AuV;
  public LinearLayout AuW;
  private com.google.android.material.bottomsheet.a AuX;
  private BottomSheetBehavior<View> AuY;
  private String Ava;
  private long Avc;
  private long Avd;
  public bxv Ave;
  private ImageView AwA;
  private LinearLayout AwB;
  private WeImageView AwC;
  private TextView AwD;
  private WeImageView AwE;
  private ImageView AwF;
  public WeImageView AwG;
  public TextView AwH;
  private LinearLayout AwI;
  private View AwJ;
  public int AwK;
  private com.tencent.mm.ui.widget.a.f AwL;
  public bys AwM;
  public g AwN;
  public JSONObject AwO;
  private final ActivityHeaderManager.finderTopicInfoListener.1 AwP;
  private final ActivityHeaderManager.removeEvent.1 AwQ;
  private TextView Awy;
  private LinearLayout Awz;
  public String coverUrl;
  public final MMActivity lzt;
  private String nVM;
  private String nickName;
  private View pUv;
  
  static
  {
    AppMethodBeat.i(348458);
    Awx = new a((byte)0);
    AppMethodBeat.o(348458);
  }
  
  public a(MMActivity paramMMActivity)
  {
    AppMethodBeat.i(348040);
    this.lzt = paramMMActivity;
    this.nickName = "";
    this.AtM = "";
    this.Ava = "";
    this.nVM = "";
    this.coverUrl = "";
    paramMMActivity = com.tencent.mm.plugin.finder.activity.a.Atw;
    com.tencent.e.f.h.jXD();
    com.tencent.mm.plugin.finder.activity.a.ao(null);
    this.AwN = new g((AppCompatActivity)this.lzt);
    this.AwP = new ActivityHeaderManager.finderTopicInfoListener.1(this, com.tencent.mm.app.f.hfK);
    this.AwQ = new ActivityHeaderManager.removeEvent.1(this, com.tencent.mm.app.f.hfK);
    AppMethodBeat.o(348040);
  }
  
  private final void MU(int paramInt)
  {
    TextView localTextView = null;
    AppMethodBeat.i(348138);
    Object localObject1 = av.GiL;
    localObject1 = this.AtP;
    label42:
    int i;
    label62:
    String str;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (!av.a((awx)localObject1)) {
        break label271;
      }
      localObject1 = this.AtP;
      if (localObject1 != null) {
        break label165;
      }
      localObject1 = null;
      localObject1 = (CharSequence)localObject1;
      if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
        break label187;
      }
      i = 1;
      if (i == 0) {
        break label235;
      }
      str = com.tencent.mm.plugin.finder.utils.r.ip(2, paramInt);
      localObject1 = this.AtP;
      if (localObject1 != null) {
        break label192;
      }
      localObject1 = localTextView;
      label85:
      if (localObject1 != null) {
        break label232;
      }
      localObject1 = this.lzt.getString(e.h.finder_activity_item_desc, new Object[] { str });
      kotlin.g.b.s.s(localObject1, "context.getString(R.stri…ity_item_desc, countText)");
    }
    for (;;)
    {
      localTextView = this.AuV;
      if (localTextView != null) {
        localTextView.setText((CharSequence)localObject1);
      }
      localObject1 = this.AuV;
      if (localObject1 == null) {
        break label286;
      }
      ((TextView)localObject1).setVisibility(0);
      AppMethodBeat.o(348138);
      return;
      localObject1 = ((awt)localObject1).ZHN;
      break;
      label165:
      localObject1 = ((awt)localObject1).ZHN;
      if (localObject1 == null)
      {
        localObject1 = null;
        break label42;
      }
      localObject1 = ((awx)localObject1).ZIm;
      break label42;
      label187:
      i = 0;
      break label62;
      label192:
      Object localObject2 = ((awt)localObject1).ZHN;
      localObject1 = localTextView;
      if (localObject2 == null) {
        break label85;
      }
      localObject2 = ((awx)localObject2).ZId;
      localObject1 = localTextView;
      if (localObject2 == null) {
        break label85;
      }
      localObject1 = kotlin.g.b.s.X(str, localObject2);
      break label85;
      label232:
      continue;
      label235:
      localObject1 = this.AtP;
      if (localObject1 == null)
      {
        localObject1 = null;
      }
      else
      {
        localObject1 = ((awt)localObject1).ZHN;
        if (localObject1 == null) {
          localObject1 = null;
        } else {
          localObject1 = ((awx)localObject1).ZIm;
        }
      }
    }
    label271:
    localObject1 = this.AuV;
    if (localObject1 != null) {
      ((TextView)localObject1).setVisibility(8);
    }
    label286:
    AppMethodBeat.o(348138);
  }
  
  private final void a(TextView paramTextView, String paramString, int paramInt1, int paramInt2, kotlin.g.a.b<? super String, ah> paramb)
  {
    AppMethodBeat.i(348189);
    SpannableString localSpannableString = new SpannableString((CharSequence)paramString);
    hn(paramInt1, paramInt2);
    localSpannableString.setSpan(new q(paramString, paramInt1, this.lzt.getResources().getColor(e.b.transparent), false, (kotlin.g.a.b)new a.b(paramb)), 0, paramString.length(), 17);
    paramTextView.setText((CharSequence)localSpannableString);
    AppMethodBeat.o(348189);
  }
  
  private static final void a(a parama)
  {
    AppMethodBeat.i(348307);
    kotlin.g.b.s.u(parama, "this$0");
    parama.AwL = null;
    AppMethodBeat.o(348307);
  }
  
  private static final void a(a parama, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(348347);
    kotlin.g.b.s.u(parama, "this$0");
    parama.AuX = null;
    AppMethodBeat.o(348347);
  }
  
  private static final void a(a parama, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(348294);
    kotlin.g.b.s.u(parama, "this$0");
    Intent localIntent = new Intent();
    if (paramMenuItem.getItemId() == 1001) {
      localIntent.putExtra("key_finder_post_router", 2);
    }
    for (;;)
    {
      parama.aq(localIntent);
      AppMethodBeat.o(348294);
      return;
      if (paramMenuItem.getItemId() == 1002) {
        localIntent.putExtra("key_finder_post_router", 3);
      }
    }
  }
  
  private static final void a(a parama, View paramView)
  {
    AppMethodBeat.i(348254);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parama, "this$0");
    paramView = av.GiL;
    switch (av.fgg())
    {
    default: 
      Log.d("Finder.ActivityHeader", "not one of six state");
    }
    int i;
    for (;;)
    {
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label294;
        }
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(348254);
        return;
        aa.makeText((Context)parama.lzt, e.h.finder_no_post_quality_tips, 0).show();
        break;
        paramView = new com.tencent.mm.plugin.finder.view.d((Context)parama.lzt);
        paramView.UD(e.f.finder_follow_topic_header_create_accoutn_bottom_sheet_layout);
        paramView.rootView.findViewById(e.e.cancel).setOnClickListener(new a..ExternalSyntheticLambda8(paramView));
        paramView.rootView.findViewById(e.e.create_account).setOnClickListener(new a..ExternalSyntheticLambda5(parama, paramView));
        paramView.dDn();
        break;
      }
      aa.makeText((Context)parama.lzt, e.h.finder_account_forbid, 0).show();
      continue;
      aa.makeText((Context)parama.lzt, e.h.finder_self_contact_reviewing, 0).show();
    }
    label294:
    paramView = av.GiL;
    paramView = parama.Ave;
    long l;
    if (paramView == null)
    {
      i = 0;
      paramView = parama.Ave;
      if (paramView != null) {
        break label404;
      }
      l = 0L;
    }
    for (;;)
    {
      boolean bool = av.aw(i, l);
      Log.i("Finder.ActivityHeader", kotlin.g.b.s.X("participateBtn onClick isFinished : ", Boolean.valueOf(bool)));
      if (!bool) {
        parama.dTR();
      }
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(348254);
      return;
      paramView = paramView.aagK;
      if (paramView == null)
      {
        i = 0;
        break;
      }
      i = paramView.ZHK;
      break;
      label404:
      paramView = paramView.aagK;
      if (paramView == null) {
        l = 0L;
      } else {
        l = paramView.endTime;
      }
    }
  }
  
  private static final void a(a parama, com.tencent.mm.plugin.finder.view.d paramd, View paramView)
  {
    AppMethodBeat.i(348339);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parama, "this$0");
    kotlin.g.b.s.u(paramd, "$bottomSheet");
    if (AndroidContextUtil.castActivityOrNull((Context)parama.lzt) != null)
    {
      paramView = new Intent();
      localObject = as.GSQ;
      as.a.a((Context)parama.lzt, paramView, 0L, null, 0, 0, false);
      paramView.putExtra("key_create_scene", 11);
      localObject = com.tencent.mm.plugin.finder.utils.a.GfO;
      com.tencent.mm.plugin.finder.utils.a.e((Activity)parama.lzt, paramView, 20000);
    }
    paramd.cyW();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(348339);
  }
  
  private static final void a(a parama, FinderContact paramFinderContact, View paramView)
  {
    AppMethodBeat.i(348316);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramFinderContact);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parama, "this$0");
    kotlin.g.b.s.u(paramFinderContact, "$finderContact");
    a(parama, "link_editnote_avatar_profile", 1, null, 1, 0, 20);
    paramView = paramFinderContact.username;
    paramFinderContact = paramView;
    if (paramView == null) {
      paramFinderContact = "";
    }
    paramView = new JSONObject();
    paramView.put("source", 2);
    localObject = ah.aiuX;
    paramView = paramView.toString();
    kotlin.g.b.s.s(paramView, "JSONObject().apply {\n   …             }.toString()");
    parama.hF(paramFinderContact, paramView);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(348316);
  }
  
  private static final void a(com.tencent.mm.plugin.finder.view.d paramd, View paramView)
  {
    AppMethodBeat.i(348327);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramd, "$bottomSheet");
    paramd.cyW();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(348327);
  }
  
  private final void a(FinderJumpInfo paramFinderJumpInfo, int paramInt)
  {
    AppMethodBeat.i(348064);
    try
    {
      paramFinderJumpInfo = paramFinderJumpInfo.toByteArray();
      kotlin.g.b.s.s(paramFinderJumpInfo, "jumpInfo.toByteArray()");
      Charset localCharset = Charset.forName("ISO-8859-1");
      kotlin.g.b.s.s(localCharset, "forName(\"ISO-8859-1\")");
      new String(paramFinderJumpInfo, localCharset);
      a(this, "feed_jumpicon", paramInt, null, 0, 0, 28);
      AppMethodBeat.o(348064);
      return;
    }
    catch (Exception paramFinderJumpInfo)
    {
      for (;;)
      {
        Log.printErrStackTrace("Finder.ActivityHeader", (Throwable)paramFinderJumpInfo, "jumpByJumpInfo", new Object[0]);
      }
    }
  }
  
  private final void a(awt paramawt, FinderJumpInfo paramFinderJumpInfo)
  {
    AppMethodBeat.i(348070);
    switch (paramFinderJumpInfo.jumpinfo_type)
    {
    }
    for (;;)
    {
      a(paramFinderJumpInfo, 1);
      AppMethodBeat.o(348070);
      return;
      Object localObject3 = new StringBuilder();
      Object localObject1;
      label62:
      label105:
      Object localObject2;
      if (paramawt == null)
      {
        localObject1 = "";
        localObject3 = (String)localObject1 + ':' + Util.getUuidRandom();
        localObject1 = as.GSQ;
        localObject1 = as.a.hu((Context)this.lzt);
        if (localObject1 != null) {
          break label195;
        }
        localObject1 = null;
        localObject2 = com.tencent.mm.plugin.finder.report.z.FrZ;
        if (paramawt != null) {
          break label203;
        }
        paramawt = "";
      }
      for (;;)
      {
        com.tencent.mm.plugin.finder.report.z.a(paramawt, 2, (bui)localObject1, com.tencent.mm.ae.d.hF(this.Avc));
        paramawt = com.tencent.mm.plugin.finder.feed.jumper.r.Bej;
        com.tencent.mm.plugin.finder.feed.jumper.r.a((Context)this.lzt, paramFinderJumpInfo, null, 1191, (String)localObject3, null, 36);
        break;
        localObject1 = paramawt.contact;
        if (localObject1 == null)
        {
          localObject1 = "";
          break label62;
        }
        localObject2 = ((FinderContact)localObject1).username;
        localObject1 = localObject2;
        if (localObject2 != null) {
          break label62;
        }
        localObject1 = "";
        break label62;
        label195:
        localObject1 = ((as)localObject1).fou();
        break label105;
        label203:
        localObject2 = paramawt.WDP;
        paramawt = (awt)localObject2;
        if (localObject2 == null) {
          paramawt = "";
        }
      }
      paramawt = com.tencent.mm.plugin.finder.feed.jumper.r.Bej;
      com.tencent.mm.plugin.finder.feed.jumper.r.a((Context)this.lzt, new com.tencent.mm.plugin.finder.feed.jumper.k(paramFinderJumpInfo));
    }
  }
  
  private void a(String paramString1, int paramInt1, String paramString2, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(348083);
    kotlin.g.b.s.u(paramString1, "eid");
    kotlin.g.b.s.u(paramString2, "jumpInfoStr");
    String str2 = ((com.tencent.mm.plugin.expt.b.d)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN();
    paramString2 = com.tencent.mm.ui.component.k.aeZF;
    String str3 = ((as)com.tencent.mm.ui.component.k.d((AppCompatActivity)this.lzt).q(as.class)).zIO;
    long l = cn.bDu();
    JSONObject localJSONObject = new JSONObject();
    do
    {
      for (;;)
      {
        try
        {
          int i = paramString1.hashCode();
          switch (i)
          {
          }
        }
        finally
        {
          String str1;
          continue;
        }
        Log.i("Finder.ActivityHeader", "report21875 sessionId:" + str2 + " contextId:" + str3 + " commentScene:" + paramInt3 + " action:" + paramInt1 + " eid:" + paramString1 + " udf_kv:" + localJSONObject);
        paramString2 = com.tencent.mm.plugin.report.service.h.OAn;
        str1 = localJSONObject.toString();
        kotlin.g.b.s.s(str1, "udfKv.toString()");
        paramString2.b(21875, new Object[] { str2, str3, Integer.valueOf(paramInt3), Integer.valueOf(paramInt1), String.valueOf(l), paramString1, n.bV(str1, ",", ";") });
        AppMethodBeat.o(348083);
        return;
        if (paramString1.equals("feed_jumpicon"))
        {
          localJSONObject.put("scene", 3);
          localJSONObject.put("type", 0);
          continue;
          if (paramString1.equals("link_editnote_avatar_profile"))
          {
            localJSONObject.put("source", 2);
            localJSONObject.put("seat_type", paramInt2);
            this.AwO = localJSONObject;
          }
        }
      }
    } while (!paramString1.equals("link_h5"));
    label378:
    paramString2 = this.AtP;
    if (paramString2 == null)
    {
      paramString2 = "";
      label391:
      localJSONObject.put("TopicId", paramString2);
      paramString2 = this.AtP;
      if (paramString2 != null) {
        break label451;
      }
      paramString2 = "";
    }
    for (;;)
    {
      localJSONObject.put("TopicName", paramString2);
      break;
      if (!paramString1.equals("link_miniprogram")) {
        break;
      }
      break label378;
      paramString2 = Long.valueOf(paramString2.ocD);
      break label391;
      label451:
      str1 = paramString2.eventName;
      paramString2 = str1;
      if (str1 == null) {
        paramString2 = "";
      }
    }
  }
  
  private final void a(String paramString, TextView paramTextView, boolean paramBoolean)
  {
    AppMethodBeat.i(348166);
    if (Util.isNullOrNil(paramString))
    {
      Log.i("SimpleUIComponent", "desc " + paramString + ", maxLineNum:2");
      AppMethodBeat.o(348166);
      return;
    }
    int j = dTy();
    Object localObject2 = paramTextView.getPaint();
    int i;
    Object localObject1;
    if (paramBoolean)
    {
      i = this.lzt.getResources().getColor(e.b.BW_100_Alpha_0_8);
      localObject1 = new StaticLayout((CharSequence)paramString, 0, paramString.length(), (TextPaint)localObject2, j, Layout.Alignment.ALIGN_NORMAL, 1.0F, 1.0F, true);
      if (((StaticLayout)localObject1).getLineCount() > 2) {
        break label294;
      }
      if (!dTV()) {
        break label264;
      }
      if (((StaticLayout)localObject1).getLineCount() != 2) {
        break label258;
      }
    }
    float f1;
    float f2;
    label258:
    for (j = ((StaticLayout)localObject1).getLineEnd(0);; j = 0)
    {
      f1 = paramTextView.getPaint().measureText(paramString.subSequence(j, paramString.length()).toString());
      f2 = this.lzt.getResources().getDimension(e.c.finder_0_25_A);
      a(paramTextView, kotlin.g.b.s.X(paramString, " "), i, (int)(f1 + f2), (kotlin.g.a.b)new c(this));
      paramString = this.AtP;
      if (paramString == null) {
        break label536;
      }
      paramString = paramString.ZHO;
      if (paramString == null) {
        break label536;
      }
      a(paramString, 0);
      AppMethodBeat.o(348166);
      return;
      i = this.lzt.getResources().getColor(e.b.FG_0);
      break;
    }
    label264:
    paramTextView.setText((CharSequence)paramString);
    paramString = this.AwJ;
    label294:
    int k;
    if (paramString != null)
    {
      paramString.setVisibility(8);
      AppMethodBeat.o(348166);
      return;
      k = ((StaticLayout)localObject1).getLineEnd(1);
      int m = ((StaticLayout)localObject1).getLineEnd(0);
      int n = (int)this.lzt.getResources().getDimension(e.c.finder_1_75_A);
      localObject1 = paramTextView.getContext().getString(e.h.finder_desc_suffix_text);
      kotlin.g.b.s.s(localObject1, "textView.context.getStri….finder_desc_suffix_text)");
      f1 = paramTextView.getPaint().measureText((String)localObject1);
      f2 = j;
      float f3 = n;
      localObject2 = new StaticLayout((CharSequence)paramString, m, k, (TextPaint)localObject2, (int)(f2 - f1 - f3), Layout.Alignment.ALIGN_NORMAL, 1.0F, 1.0F, true);
      if (((StaticLayout)localObject2).getLineCount() > 0)
      {
        k = ((StaticLayout)localObject2).getLineEnd(0);
        if (paramString.charAt(k - 1) != '\n') {
          break label543;
        }
        localObject2 = new StringBuilder();
        if (paramString == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(348166);
          throw paramString;
        }
        paramString = paramString.substring(0, k - 1);
        kotlin.g.b.s.s(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      }
    }
    for (paramString = paramString + (String)localObject1 + ' ';; paramString = paramString + (String)localObject1 + ' ')
    {
      a(paramTextView, paramString, i, (int)(j - this.lzt.getResources().getDimension(e.c.finder_2_25_A)), (kotlin.g.a.b)new d(this));
      label536:
      AppMethodBeat.o(348166);
      return;
      label543:
      localObject2 = new StringBuilder();
      if (paramString == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(348166);
        throw paramString;
      }
      paramString = paramString.substring(0, k);
      kotlin.g.b.s.s(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    }
  }
  
  private final void aq(Intent paramIntent)
  {
    AppMethodBeat.i(348114);
    Object localObject = new StringBuilder();
    com.tencent.mm.kernel.h.baC();
    paramIntent.putExtra("key_finder_post_id", com.tencent.mm.kernel.b.aZs() + '_' + Util.nowMilliSecond());
    paramIntent.putExtra("key_finder_post_from", 9);
    paramIntent.putExtra("saveActivity", true);
    paramIntent.putExtra("key_activity_type", 102);
    localObject = this.AtP;
    label120:
    String str;
    label146:
    long l;
    if (localObject == null)
    {
      localObject = "";
      paramIntent.putExtra("key_user_name", (String)localObject);
      localObject = this.AtP;
      if (localObject != null) {
        break label525;
      }
      localObject = "";
      paramIntent.putExtra("key_nick_name", (String)localObject);
      localObject = this.AtP;
      if (localObject != null) {
        break label569;
      }
      localObject = "";
      paramIntent.putExtra("key_avatar_url", (String)localObject);
      str = this.coverUrl;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      paramIntent.putExtra("key_cover_url", (String)localObject);
      localObject = this.AtP;
      if (localObject != null) {
        break label613;
      }
      l = 0L;
      label199:
      paramIntent.putExtra("key_activity_display_mask", l);
      localObject = this.AtP;
      if (localObject != null) {
        break label622;
      }
      localObject = null;
      label222:
      paramIntent.putExtra("key_topic_id", (Serializable)localObject);
      localObject = this.AtP;
      if (localObject != null) {
        break label635;
      }
      localObject = null;
      label249:
      paramIntent.putExtra("key_activity_name", (String)localObject);
      localObject = this.AtP;
      if (localObject != null) {
        break label645;
      }
      localObject = null;
      label273:
      paramIntent.putExtra("key_activity_desc", (String)localObject);
      localObject = this.AtP;
      if (localObject != null) {
        break label655;
      }
      localObject = null;
      label297:
      paramIntent.putExtra("key_activity_end_time", (Serializable)localObject);
      localObject = this.AtP;
      if (localObject != null) {
        break label668;
      }
      localObject = null;
      label324:
      paramIntent.putExtra("key_activity_post_wording", (String)localObject);
      localObject = com.tencent.mm.plugin.finder.activity.b.Aty;
      localObject = this.AtP;
      if (localObject != null) {
        break label678;
      }
    }
    label525:
    label655:
    label668:
    label678:
    for (localObject = null;; localObject = ((awt)localObject).ZHR)
    {
      localObject = com.tencent.mm.plugin.finder.activity.b.fQ((List)localObject);
      if (localObject != null) {
        paramIntent.putExtra("key_activity_jump_info_list", (Serializable)localObject);
      }
      paramIntent.putExtra("key_activity_src_type", "key_scene_from_profile");
      localObject = this.AtP;
      if (localObject != null)
      {
        localObject = ((awt)localObject).ZHN;
        if (localObject != null) {
          paramIntent.putExtra("key_wording_info", ((awx)localObject).toByteArray());
        }
      }
      localObject = com.tencent.mm.plugin.finder.utils.u.GgT;
      com.tencent.mm.plugin.finder.utils.u.a((Context)this.lzt, paramIntent, 134, 11);
      localObject = com.tencent.mm.plugin.finder.activity.a.Atw;
      com.tencent.mm.plugin.finder.activity.a.a.ap(paramIntent);
      localObject = com.tencent.mm.plugin.finder.utils.a.GfO;
      com.tencent.mm.plugin.finder.utils.a.enterFinderPostRouterUI((Context)this.lzt, paramIntent);
      AppMethodBeat.o(348114);
      return;
      localObject = ((awt)localObject).contact;
      if (localObject == null)
      {
        localObject = "";
        break;
      }
      str = ((FinderContact)localObject).username;
      localObject = str;
      if (str != null) {
        break;
      }
      localObject = "";
      break;
      localObject = ((awt)localObject).contact;
      if (localObject == null)
      {
        localObject = "";
        break label120;
      }
      str = ((FinderContact)localObject).nickname;
      localObject = str;
      if (str != null) {
        break label120;
      }
      localObject = "";
      break label120;
      label569:
      localObject = ((awt)localObject).contact;
      if (localObject == null)
      {
        localObject = "";
        break label146;
      }
      str = ((FinderContact)localObject).headUrl;
      localObject = str;
      if (str != null) {
        break label146;
      }
      localObject = "";
      break label146;
      label613:
      l = ((awt)localObject).FOi;
      break label199;
      label622:
      localObject = Long.valueOf(((awt)localObject).ocD);
      break label222;
      label635:
      localObject = ((awt)localObject).eventName;
      break label249;
      localObject = ((awt)localObject).description;
      break label273;
      localObject = Long.valueOf(((awt)localObject).endTime);
      break label297;
      localObject = ((awt)localObject).ZHS;
      break label324;
    }
  }
  
  private final void auN(String paramString)
  {
    AppMethodBeat.i(348144);
    ImageView localImageView = this.AuT;
    if ((localImageView != null) && (!Util.isNullOrNil(paramString)))
    {
      Object localObject = com.tencent.mm.plugin.finder.loader.p.ExI;
      localObject = com.tencent.mm.plugin.finder.loader.p.eCp();
      paramString = new com.tencent.mm.plugin.finder.loader.b(paramString);
      com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
      ((com.tencent.mm.loader.d)localObject).a(paramString, localImageView, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM));
    }
    AppMethodBeat.o(348144);
  }
  
  private static final void b(a parama, View paramView)
  {
    AppMethodBeat.i(348266);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(parama);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(parama, "this$0");
    localObject2 = parama.AtP;
    Object localObject3;
    if (localObject2 != null)
    {
      paramView = ((awt)localObject2).hVf;
      if (paramView != null) {
        break label284;
      }
      paramView = null;
      if ((paramView == null) && (localObject2 != null))
      {
        localObject3 = new StringBuilder();
        paramView = ((awt)localObject2).contact;
        if (paramView != null) {
          break label293;
        }
        paramView = "";
        label109:
        localObject3 = paramView + ':' + Util.getUuidRandom();
        paramView = com.tencent.mm.plugin.finder.report.z.FrZ;
        paramView = ((awt)localObject2).WDP;
        if (paramView != null) {
          break label311;
        }
        paramView = "";
        label148:
        localObject1 = as.GSQ;
        localObject1 = as.a.hu((Context)parama.lzt);
        if (localObject1 != null) {
          break label314;
        }
      }
    }
    label284:
    label293:
    label311:
    label314:
    for (localObject1 = null;; localObject1 = ((as)localObject1).fou())
    {
      com.tencent.mm.plugin.finder.report.z.a(paramView, 2, (bui)localObject1, com.tencent.mm.ae.d.hF(parama.Avc));
      com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.GfO;
      Context localContext = (Context)parama.lzt;
      localObject1 = ((awt)localObject2).WDP;
      paramView = (View)localObject1;
      if (localObject1 == null) {
        paramView = "";
      }
      localObject2 = ((awt)localObject2).ZHI;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      locala.a(localContext, paramView, (String)localObject1, 1191, (String)localObject3);
      a(parama, "link_miniprogram", 1, "", 0, 0, 24);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(348266);
      return;
      parama.a((awt)localObject2, paramView);
      break;
      localObject1 = paramView.username;
      paramView = (View)localObject1;
      if (localObject1 != null) {
        break label109;
      }
      paramView = "";
      break label109;
      break label148;
    }
  }
  
  private static final void b(a parama, FinderContact paramFinderContact, View paramView)
  {
    AppMethodBeat.i(348359);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramFinderContact);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parama, "this$0");
    kotlin.g.b.s.u(paramFinderContact, "$it");
    a(parama, "link_editnote_avatar_profile", 1, null, 2, 131, 4);
    paramView = paramFinderContact.username;
    paramFinderContact = paramView;
    if (paramView == null) {
      paramFinderContact = "";
    }
    paramView = new JSONObject();
    paramView.put("source", 2);
    localObject = ah.aiuX;
    paramView = paramView.toString();
    kotlin.g.b.s.s(paramView, "JSONObject().apply {\n   …             }.toString()");
    parama.hF(paramFinderContact, paramView);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(348359);
  }
  
  private static final void c(a parama, View paramView)
  {
    AppMethodBeat.i(348277);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parama, "this$0");
    paramView = parama.AtP;
    if (paramView == null) {
      paramView = "";
    }
    for (;;)
    {
      parama.hF(paramView, "");
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(348277);
      return;
      paramView = paramView.contact;
      if (paramView == null)
      {
        paramView = "";
      }
      else
      {
        localObject = paramView.username;
        paramView = (View)localObject;
        if (localObject == null) {
          paramView = "";
        }
      }
    }
  }
  
  private static final void c(com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(348287);
    if (params.jmw())
    {
      params.oh(1001, e.h.app_field_mmsight);
      params.oh(1002, e.h.app_field_select_new_pic);
    }
    AppMethodBeat.o(348287);
  }
  
  private static final void d(a parama, View paramView)
  {
    AppMethodBeat.i(348365);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parama, "this$0");
    parama = parama.AuX;
    if (parama != null) {
      parama.hide();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(348365);
  }
  
  private final void dTQ()
  {
    AppMethodBeat.i(348047);
    Intent localIntent = this.lzt.getIntent();
    this.nickName = localIntent.getStringExtra("key_nick_name");
    this.AtM = localIntent.getStringExtra("key_activity_name");
    this.Ava = localIntent.getStringExtra("key_activity_desc");
    this.nVM = localIntent.getStringExtra("key_avatar_url");
    this.coverUrl = localIntent.getStringExtra("key_cover_url");
    this.AwK = localIntent.getIntExtra("key_activity_participate_count", 0);
    this.Avc = localIntent.getLongExtra("key_activity_id", 0L);
    AppMethodBeat.o(348047);
  }
  
  private void dTS()
  {
    Object localObject1 = null;
    AppMethodBeat.i(348097);
    Object localObject2 = this.Ave;
    Object localObject3;
    if (localObject2 != null)
    {
      localObject2 = ((bxv)localObject2).aagK;
      if (localObject2 != null)
      {
        localObject3 = av.GiL;
        if (!av.aw(((awt)localObject2).ZHK, ((awt)localObject2).endTime)) {
          break label88;
        }
        localObject1 = this.AwG;
        if (localObject1 != null) {
          ((WeImageView)localObject1).setVisibility(8);
        }
        localObject3 = this.AwH;
        if (localObject3 != null)
        {
          localObject2 = dTT();
          ((TextView)localObject3).setText((CharSequence)localObject2);
        }
      }
    }
    label88:
    TextView localTextView;
    do
    {
      AppMethodBeat.o(348097);
      return;
      localObject2 = this.AwG;
      if (localObject2 != null) {
        ((WeImageView)localObject2).setVisibility(0);
      }
      localTextView = this.AwH;
    } while (localTextView == null);
    localObject2 = this.AtP;
    if (localObject2 == null) {}
    for (;;)
    {
      localObject2 = localObject1;
      localObject3 = localTextView;
      if (localObject1 != null) {
        break;
      }
      localObject2 = this.lzt.getResources().getString(e.h.finder_activity_participate_text);
      kotlin.g.b.s.s(localObject2, "context.resources.getStr…ctivity_participate_text)");
      localObject3 = localTextView;
      break;
      localObject2 = ((awt)localObject2).ZHN;
      if (localObject2 != null) {
        localObject1 = ((awx)localObject2).ZIe;
      }
    }
  }
  
  private final void dTU()
  {
    AppMethodBeat.i(348105);
    if (this.AwL == null)
    {
      localObject1 = new com.tencent.mm.ui.widget.a.f((Context)this.lzt, 1, true);
      Object localObject2 = af.mU((Context)this.lzt).inflate(e.f.finder_sheet_header, null);
      Object localObject5 = (TextView)((View)localObject2).findViewById(e.e.nickname);
      Object localObject3 = (ImageView)((View)localObject2).findViewById(e.e.avatar);
      Object localObject4 = com.tencent.mm.plugin.finder.api.d.AwY;
      localObject4 = d.a.auT(com.tencent.mm.model.z.bAW());
      if (localObject4 != null)
      {
        ((TextView)localObject5).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b((Context)this.lzt, (CharSequence)((m)localObject4).getNickname()));
        localObject5 = com.tencent.mm.plugin.finder.loader.p.ExI;
        localObject5 = com.tencent.mm.plugin.finder.loader.p.eCp();
        com.tencent.mm.plugin.finder.loader.b localb = new com.tencent.mm.plugin.finder.loader.b(((m)localObject4).field_avatarUrl);
        kotlin.g.b.s.s(localObject3, "avatarIv");
        com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
        ((com.tencent.mm.loader.d)localObject5).a(localb, (ImageView)localObject3, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM));
        localObject3 = av.GiL;
        kotlin.g.b.s.s(localObject2, "headerView");
        av.a((m)localObject4, (View)localObject2);
      }
      ((com.tencent.mm.ui.widget.a.f)localObject1).af((View)localObject2, true);
      ((com.tencent.mm.ui.widget.a.f)localObject1).Vtg = a..ExternalSyntheticLambda9.INSTANCE;
      ((com.tencent.mm.ui.widget.a.f)localObject1).GAC = new a..ExternalSyntheticLambda10(this);
      ((com.tencent.mm.ui.widget.a.f)localObject1).aeLi = new a..ExternalSyntheticLambda11(this);
      localObject2 = ah.aiuX;
      this.AwL = ((com.tencent.mm.ui.widget.a.f)localObject1);
    }
    Object localObject1 = this.AwN;
    if ((localObject1 != null) && (!((g)localObject1).a((kotlin.g.a.a)new f(this), (kotlin.g.a.a)new g(this)))) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(348105);
      return;
    }
    localObject1 = this.AwL;
    if ((localObject1 != null) && (!((com.tencent.mm.ui.widget.a.f)localObject1).isShowing())) {
      ((com.tencent.mm.ui.widget.a.f)localObject1).dDn();
    }
    AppMethodBeat.o(348105);
  }
  
  private final boolean dTV()
  {
    Object localObject2 = null;
    Object localObject1 = this.AtP;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (localObject1 == null)
      {
        localObject1 = this.AtP;
        if (localObject1 != null) {
          break label42;
        }
        localObject1 = localObject2;
      }
    }
    for (;;)
    {
      if (localObject1 == null) {
        break label61;
      }
      return true;
      localObject1 = ((awt)localObject1).ZHO;
      break;
      label42:
      aws localaws = ((awt)localObject1).ZHP;
      localObject1 = localObject2;
      if (localaws != null) {
        localObject1 = localaws.contact;
      }
    }
    label61:
    return false;
  }
  
  private final void dTx()
  {
    Object localObject3 = null;
    long l3 = 0L;
    int j = 0;
    AppMethodBeat.i(348133);
    Object localObject4 = this.AuU;
    Object localObject5;
    if (localObject4 != null)
    {
      localObject5 = (Context)this.lzt;
      localObject2 = this.nickName;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      ((TextView)localObject4).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b((Context)localObject5, (CharSequence)localObject1));
    }
    Object localObject1 = this.AuR;
    if (localObject1 != null) {
      ((TextView)localObject1).setText((CharSequence)this.AtM);
    }
    boolean bool1;
    if (!Util.isNullOrNil(this.coverUrl))
    {
      bool1 = true;
      localObject1 = this.AuR;
      if (localObject1 != null) {
        aw.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
      }
      localObject2 = this.nVM;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      auN((String)localObject1);
      localObject4 = this.AuS;
      if (localObject4 == null) {
        break label398;
      }
      localObject1 = this.AtP;
      if (localObject1 != null) {
        break label258;
      }
      localObject1 = "";
      label186:
      if (Util.isNullOrNil((String)localObject1)) {
        break label302;
      }
      localObject1 = kotlin.g.b.s.X((String)localObject1, this.Ava);
    }
    int i;
    for (;;)
    {
      localObject2 = localObject1;
      if (!n.rs((String)localObject1, "\n")) {
        break label380;
      }
      i = ((String)localObject1).length();
      if (localObject1 != null) {
        break label361;
      }
      localObject1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(348133);
      throw ((Throwable)localObject1);
      bool1 = false;
      break;
      label258:
      localObject1 = ((awt)localObject1).ZHN;
      if (localObject1 == null)
      {
        localObject1 = "";
        break label186;
      }
      localObject2 = ((awx)localObject1).ZIc;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break label186;
      }
      localObject1 = "";
      break label186;
      label302:
      localObject5 = ((TextView)localObject4).getResources();
      i = e.h.finder_activity_post_desc_prefix;
      localObject2 = this.Ava;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      localObject1 = ((Resources)localObject5).getString(i, new Object[] { localObject1 });
      kotlin.g.b.s.s(localObject1, "{\n                resour…Desc ?: \"\")\n            }");
    }
    label361:
    Object localObject2 = ((String)localObject1).substring(0, i - 1);
    kotlin.g.b.s.s(localObject2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    label380:
    localObject1 = ar.Giw;
    a(ar.aBF((String)localObject2), (TextView)localObject4, bool1);
    label398:
    localObject1 = this.Ave;
    if (localObject1 != null)
    {
      localObject1 = ((bxv)localObject1).aagK;
      if (localObject1 != null)
      {
        localObject2 = this.AuW;
        if (localObject2 != null)
        {
          localObject4 = av.GiL;
          if (!av.qK(((awt)localObject1).FOi)) {
            break label688;
          }
          i = 0;
          ((LinearLayout)localObject2).setVisibility(i);
        }
      }
    }
    localObject1 = this.AwH;
    if (localObject1 != null) {
      aw.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
    }
    dTS();
    localObject1 = this.Ave;
    long l1;
    label498:
    long l2;
    if (localObject1 == null)
    {
      l1 = 0L;
      if (l1 != 0L)
      {
        localObject1 = av.GiL;
        localObject1 = this.Ave;
        if (localObject1 != null) {
          break label720;
        }
        l2 = 0L;
        label523:
        if (av.qJ(l2)) {
          break label748;
        }
      }
      Log.i("Finder.ActivityHeader", "no endTime");
      localObject1 = this.Awy;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(8);
      }
      label558:
      MU(this.AwK);
      localObject1 = this.AtP;
      if (localObject1 != null) {
        break label807;
      }
      localObject1 = localObject3;
      label581:
      if (localObject1 == null)
      {
        localObject1 = this.Awz;
        if (localObject1 != null) {
          ((LinearLayout)localObject1).setVisibility(8);
        }
      }
      localObject1 = av.GiL;
      localObject1 = this.Ave;
      if (localObject1 != null) {
        break label984;
      }
      i = j;
      label622:
      localObject1 = this.Ave;
      if (localObject1 != null) {
        break label1007;
      }
      l1 = l3;
    }
    boolean bool2;
    for (;;)
    {
      bool2 = av.aw(i, l1);
      if (!bool1) {
        break label1031;
      }
      pF(bool2);
      localObject1 = com.tencent.mm.ui.component.k.aeZF;
      ((com.tencent.mm.plugin.finder.activity.uic.h)com.tencent.mm.ui.component.k.d((AppCompatActivity)this.lzt).q(com.tencent.mm.plugin.finder.activity.uic.h.class)).dTw();
      AppMethodBeat.o(348133);
      return;
      label688:
      i = 8;
      break;
      localObject1 = ((bxv)localObject1).aagK;
      if (localObject1 == null)
      {
        l1 = 0L;
        break label498;
      }
      l1 = ((awt)localObject1).endTime;
      break label498;
      label720:
      localObject1 = ((bxv)localObject1).aagK;
      if (localObject1 == null)
      {
        l2 = 0L;
        break label523;
      }
      l2 = ((awt)localObject1).FOi;
      break label523;
      label748:
      localObject1 = this.Awy;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(0);
      }
      localObject1 = this.Awy;
      if (localObject1 == null) {
        break label558;
      }
      localObject2 = av.GiL;
      ((TextView)localObject1).setText((CharSequence)av.b(l1 * 1000L, (Context)this.lzt));
      break label558;
      label807:
      localObject2 = ((awt)localObject1).ZHP;
      localObject1 = localObject3;
      if (localObject2 == null) {
        break label581;
      }
      localObject2 = ((aws)localObject2).contact;
      localObject1 = localObject3;
      if (localObject2 == null) {
        break label581;
      }
      localObject1 = this.Awz;
      if (localObject1 != null) {
        ((LinearLayout)localObject1).setVisibility(0);
      }
      a(this, "link_editnote_avatar_profile", 0, null, 1, 0, 20);
      localObject1 = this.AwA;
      if (localObject1 != null)
      {
        localObject3 = com.tencent.mm.plugin.finder.loader.p.ExI;
        localObject3 = com.tencent.mm.plugin.finder.loader.p.eCp();
        localObject4 = new com.tencent.mm.plugin.finder.loader.b(((FinderContact)localObject2).headUrl);
        localObject5 = com.tencent.mm.plugin.finder.loader.p.ExI;
        ((com.tencent.mm.loader.d)localObject3).a(localObject4, (ImageView)localObject1, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM));
        ((ImageView)localObject1).setOnClickListener(new a..ExternalSyntheticLambda7(this, (FinderContact)localObject2));
      }
      localObject1 = this.AuK;
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b((Context)this.lzt, (CharSequence)((FinderContact)localObject2).nickname));
      }
      localObject1 = ah.aiuX;
      break label581;
      label984:
      localObject1 = ((bxv)localObject1).aagK;
      i = j;
      if (localObject1 == null) {
        break label622;
      }
      i = ((awt)localObject1).ZHK;
      break label622;
      label1007:
      localObject1 = ((bxv)localObject1).aagK;
      l1 = l3;
      if (localObject1 != null) {
        l1 = ((awt)localObject1).endTime;
      }
    }
    label1031:
    pE(bool2);
    localObject1 = com.tencent.mm.ui.component.k.aeZF;
    ((com.tencent.mm.plugin.finder.activity.uic.h)com.tencent.mm.ui.component.k.d((AppCompatActivity)this.lzt).q(com.tencent.mm.plugin.finder.activity.uic.h.class)).dTr();
    AppMethodBeat.o(348133);
  }
  
  private final int dTy()
  {
    AppMethodBeat.i(348209);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    this.lzt.getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    int i = localDisplayMetrics.widthPixels;
    int j = com.tencent.mm.cd.a.bs((Context)this.lzt, e.c.Edge_6A);
    AppMethodBeat.o(348209);
    return i - j;
  }
  
  private final void fo(View paramView)
  {
    AppMethodBeat.i(348057);
    this.AuR = ((TextView)paramView.findViewById(e.e.activity_profile_header_title));
    this.AwI = ((LinearLayout)paramView.findViewById(e.e.container1));
    this.AuS = ((TextView)paramView.findViewById(e.e.activity_profile_header_desc));
    this.Awy = ((TextView)paramView.findViewById(e.e.activity_profile_end_time_text));
    this.AuT = ((ImageView)paramView.findViewById(e.e.activity_profile_header_avatar));
    Object localObject = (TextView)paramView.findViewById(e.e.activity_profile_header_name);
    if (localObject == null) {
      localObject = null;
    }
    for (;;)
    {
      this.AuU = ((TextView)localObject);
      this.AuV = ((TextView)paramView.findViewById(e.e.activity_profile_header_participate));
      this.AuW = ((LinearLayout)paramView.findViewById(e.e.activity_profile_header_participate_btn));
      localObject = this.AuW;
      if (localObject != null) {
        ((LinearLayout)localObject).setOnClickListener(new a..ExternalSyntheticLambda4(this));
      }
      localObject = this.AuS;
      if (localObject != null) {
        ((TextView)localObject).setOnTouchListener((View.OnTouchListener)new com.tencent.mm.pluginsdk.ui.span.s(((TextView)localObject).getContext()));
      }
      this.AwG = ((WeImageView)paramView.findViewById(e.e.activity_profile_header_participate_icon));
      this.AwH = ((TextView)paramView.findViewById(e.e.activity_profile_header_participate_text));
      this.AwB = ((LinearLayout)this.lzt.findViewById(e.e.activity_profile_ad_container));
      this.AwD = ((TextView)this.lzt.findViewById(e.e.activity_profile_ad_text));
      this.AwE = ((WeImageView)this.lzt.findViewById(e.e.activity_profile_mini_app_icon));
      this.AwF = ((ImageView)this.lzt.findViewById(e.e.activity_profile_activity_icon));
      this.AwC = ((WeImageView)this.lzt.findViewById(e.e.finder_profile_activity_arrow));
      paramView = this.AwB;
      if (paramView != null) {
        paramView.setOnClickListener(new a..ExternalSyntheticLambda2(this));
      }
      paramView = this.AuT;
      if (paramView != null) {
        paramView.setOnClickListener(new a..ExternalSyntheticLambda3(this));
      }
      this.AwJ = this.lzt.findViewById(e.e.activity_profile_header_desc_icon_container);
      this.Awz = ((LinearLayout)this.lzt.findViewById(e.e.activity_profile_header_note));
      this.AwA = ((ImageView)this.lzt.findViewById(e.e.activity_profile_header_note_avatar));
      this.AuK = ((TextView)this.lzt.findViewById(e.e.activity_profile_header_note_text));
      this.AuL = this.lzt.findViewById(e.e.activity_profile_header_note_line);
      AppMethodBeat.o(348057);
      return;
      aw.a((Paint)((TextView)localObject).getPaint(), 0.8F);
      ah localah = ah.aiuX;
    }
  }
  
  private final void hF(String paramString1, String paramString2)
  {
    AppMethodBeat.i(348152);
    Intent localIntent = new Intent();
    localIntent.putExtra("finder_username", paramString1);
    localIntent.putExtra("KEY_DO_NOT_CHECK_ENTER_BIZ_PROFILE", true);
    localIntent.putExtra("key_udf_kv", paramString2);
    paramString1 = as.GSQ;
    as.a.a((Context)this.lzt, localIntent, 0L, 1, false, 64);
    com.tencent.mm.plugin.finder.utils.a.GfO.enterFinderProfileUI((Context)this.lzt, localIntent);
    AppMethodBeat.o(348152);
  }
  
  private final void hn(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(348200);
    Object localObject = this.AwJ;
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    ((WeImageView)this.lzt.findViewById(e.e.activity_profile_header_desc_icon)).setIconColor(paramInt1);
    paramInt1 = (int)this.lzt.getResources().getDimension(e.c.Edge_2A);
    localObject = this.AuS;
    if (localObject != null)
    {
      localObject = ((TextView)localObject).getPaint().getFontMetricsInt();
      paramInt1 = (((Paint.FontMetricsInt)localObject).descent - ((Paint.FontMetricsInt)localObject).ascent) / 2 - paramInt1 / 2;
      Log.i("Finder.ActivityHeader", kotlin.g.b.s.X("gap :", Integer.valueOf(paramInt1)));
      localObject = this.AwJ;
      if (localObject != null) {
        break label165;
      }
      localObject = null;
      if (!(localObject instanceof FrameLayout.LayoutParams)) {
        break label173;
      }
    }
    label165:
    label173:
    for (localObject = (FrameLayout.LayoutParams)localObject;; localObject = null)
    {
      if (localObject != null)
      {
        ((FrameLayout.LayoutParams)localObject).bottomMargin = paramInt1;
        ((FrameLayout.LayoutParams)localObject).leftMargin = paramInt2;
        View localView = this.AwJ;
        if (localView != null) {
          localView.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
      }
      AppMethodBeat.o(348200);
      return;
      localObject = ((View)localObject).getLayoutParams();
      break;
    }
  }
  
  private final void pE(boolean paramBoolean)
  {
    AppMethodBeat.i(348231);
    setTextColor(this.lzt.getResources().getColor(e.b.FG_0));
    Object localObject = this.AuV;
    if (localObject != null) {
      ((TextView)localObject).setTextColor(this.lzt.getResources().getColor(e.b.FG_1));
    }
    localObject = this.AuL;
    if (localObject != null) {
      ((View)localObject).setBackgroundColor(this.lzt.getResources().getColor(e.b.FG_1));
    }
    if (paramBoolean)
    {
      localObject = this.AuW;
      if (localObject != null) {
        ((LinearLayout)localObject).setBackgroundResource(e.d.finder_activity_normal_finished_btn_bg);
      }
      localObject = this.AwH;
      if (localObject != null) {
        ((TextView)localObject).setTextColor(this.lzt.getResources().getColor(e.b.FG_2));
      }
    }
    for (;;)
    {
      localObject = this.AwB;
      if (localObject != null) {
        ((LinearLayout)localObject).setBackground(this.lzt.getResources().getDrawable(e.d.finder_profile_normal_mini_program_bg));
      }
      AppMethodBeat.o(348231);
      return;
      localObject = this.AuW;
      if (localObject != null) {
        ((LinearLayout)localObject).setBackgroundResource(e.d.finder_profile_follow_btn_bg);
      }
      int i = this.lzt.getResources().getColor(e.b.White);
      localObject = this.AwG;
      if (localObject != null) {
        ((WeImageView)localObject).setIconColor(i);
      }
      localObject = this.AwH;
      if (localObject != null) {
        ((TextView)localObject).setTextColor(i);
      }
    }
  }
  
  private final void pF(boolean paramBoolean)
  {
    AppMethodBeat.i(348218);
    Object localObject = this.AuR;
    if (localObject != null) {
      ((TextView)localObject).setTextColor(this.lzt.getResources().getColor(e.b.White));
    }
    setTextColor(this.lzt.getResources().getColor(e.b.BW_100_Alpha_0_8));
    localObject = this.AuV;
    if (localObject != null) {
      ((TextView)localObject).setTextColor(this.lzt.getResources().getColor(e.b.BW_100_Alpha_0_5));
    }
    localObject = this.AuL;
    if (localObject != null) {
      ((View)localObject).setBackgroundColor(this.lzt.getResources().getColor(e.b.BW_100_Alpha_0_5));
    }
    if (paramBoolean)
    {
      localObject = this.AuW;
      if (localObject != null) {
        ((LinearLayout)localObject).setBackgroundResource(e.d.finder_activity_covered_finished_btn_bg);
      }
      localObject = this.AwH;
      if (localObject != null) {
        ((TextView)localObject).setTextColor(this.lzt.getResources().getColor(e.b.BW_100_Alpha_0_3));
      }
    }
    for (;;)
    {
      localObject = this.AwB;
      if (localObject != null) {
        ((LinearLayout)localObject).setBackground(this.lzt.getResources().getDrawable(e.d.finder_profile_mini_program_bg));
      }
      AppMethodBeat.o(348218);
      return;
      localObject = this.AuW;
      if (localObject != null) {
        ((LinearLayout)localObject).setBackgroundResource(e.d.finder_activity_covered_btn_bg);
      }
      int i = this.lzt.getResources().getColor(e.b.White);
      localObject = this.AwG;
      if (localObject != null) {
        ((WeImageView)localObject).setIconColor(i);
      }
      localObject = this.AwH;
      if (localObject != null) {
        ((TextView)localObject).setTextColor(i);
      }
    }
  }
  
  private final void setTextColor(int paramInt)
  {
    AppMethodBeat.i(348239);
    Object localObject = this.AuU;
    if (localObject != null) {
      ((TextView)localObject).setTextColor(paramInt);
    }
    localObject = this.AuS;
    if (localObject != null) {
      ((TextView)localObject).setTextColor(paramInt);
    }
    localObject = this.Awy;
    if (localObject != null) {
      ((TextView)localObject).setTextColor(paramInt);
    }
    localObject = this.AuK;
    if (localObject != null) {
      ((TextView)localObject).setTextColor(paramInt);
    }
    localObject = this.AwD;
    if (localObject != null) {
      ((TextView)localObject).setTextColor(paramInt);
    }
    localObject = this.AwE;
    if (localObject != null) {
      ((WeImageView)localObject).setIconColor(paramInt);
    }
    localObject = this.AwC;
    if (localObject != null) {
      ((WeImageView)localObject).setIconColor(paramInt);
    }
    AppMethodBeat.o(348239);
  }
  
  public final void b(bxv parambxv)
  {
    Object localObject2 = null;
    AppMethodBeat.i(348568);
    this.Ave = parambxv;
    Object localObject1 = this.Ave;
    if (localObject1 == null)
    {
      localObject1 = null;
      this.AtP = ((awt)localObject1);
      if (parambxv == null) {
        break label600;
      }
      localObject1 = parambxv.aagK;
      if (localObject1 == null) {
        break label600;
      }
      this.AtM = ((awt)localObject1).eventName;
      this.Ava = ((awt)localObject1).description;
      this.AwK = parambxv.feedCount;
      this.Avc = ((awt)localObject1).ocD;
      this.coverUrl = ((awt)localObject1).coverImgUrl;
      this.Avd = ((awt)localObject1).ZHH;
      parambxv = ((awt)localObject1).contact;
      if (parambxv != null) {
        break label380;
      }
      parambxv = null;
      label101:
      this.nickName = parambxv;
      parambxv = ((awt)localObject1).contact;
      if (parambxv != null) {
        break label388;
      }
      parambxv = null;
      label117:
      this.nVM = parambxv;
      Log.i("Finder.ActivityHeader", "avatarUrl: " + this.nVM + " activityParticipateCount:" + this.AwK + " coverUrl:" + this.coverUrl + " nickName:" + this.nickName + " activityParticipateCount:" + this.AwK + " displayMask:" + ((awt)localObject1).FOi);
      parambxv = av.GiL;
      if (!av.qI(((awt)localObject1).FOi)) {
        break label396;
      }
      parambxv = this.AwI;
      if (parambxv != null) {
        parambxv.setVisibility(0);
      }
    }
    for (;;)
    {
      dTx();
      if (localObject1 == null) {
        break label600;
      }
      parambxv = ((awt)localObject1).hVf;
      if (parambxv != null) {
        break label414;
      }
      parambxv = (bxv)localObject2;
      if (parambxv != null) {
        break label600;
      }
      Log.i("Finder.ActivityHeader", "showJumpView by MiniProgram");
      if (localObject1 == null) {
        break label600;
      }
      if (Util.isNullOrNil(((awt)localObject1).WDP)) {
        break label585;
      }
      parambxv = this.AwB;
      if (parambxv != null) {
        parambxv.setVisibility(0);
      }
      parambxv = this.AwD;
      if (parambxv != null) {
        parambxv.setText((CharSequence)((awt)localObject1).ZHJ);
      }
      parambxv = this.AwE;
      if (parambxv != null) {
        parambxv.setVisibility(0);
      }
      parambxv = this.AwF;
      if (parambxv != null) {
        parambxv.setVisibility(8);
      }
      a(this, "link_miniprogram", 0, "", 0, 0, 24);
      AppMethodBeat.o(348568);
      return;
      localObject1 = ((bxv)localObject1).aagK;
      break;
      label380:
      parambxv = parambxv.nickname;
      break label101;
      label388:
      parambxv = parambxv.headUrl;
      break label117;
      label396:
      parambxv = this.AwI;
      if (parambxv != null) {
        parambxv.setVisibility(8);
      }
    }
    label414:
    Log.i("Finder.ActivityHeader", "showJumpView by jumpInfo");
    if (!Util.isNullOrNil(parambxv.wording))
    {
      localObject2 = this.AwB;
      if (localObject2 != null) {
        ((LinearLayout)localObject2).setVisibility(0);
      }
      localObject2 = this.AwD;
      if (localObject2 != null) {
        ((TextView)localObject2).setText((CharSequence)parambxv.wording);
      }
      localObject2 = this.AwE;
      if (localObject2 != null) {
        ((WeImageView)localObject2).setVisibility(8);
      }
      localObject2 = this.AwF;
      if (localObject2 != null) {
        ((ImageView)localObject2).setVisibility(0);
      }
      localObject2 = this.AwF;
      if (localObject2 != null)
      {
        ((ImageView)localObject2).setVisibility(0);
        Object localObject3 = com.tencent.mm.plugin.finder.loader.p.ExI;
        localObject3 = com.tencent.mm.plugin.finder.loader.p.eCl();
        com.tencent.mm.plugin.finder.loader.s locals = new com.tencent.mm.plugin.finder.loader.s(parambxv.icon_url, com.tencent.mm.plugin.finder.storage.v.FKZ);
        com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
        ((com.tencent.mm.loader.d)localObject3).a(locals, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExR)).d((ImageView)localObject2);
      }
      a(parambxv, 0);
    }
    for (;;)
    {
      break;
      localObject2 = this.AwB;
      if (localObject2 != null) {
        ((LinearLayout)localObject2).setVisibility(8);
      }
    }
    label585:
    parambxv = this.AwB;
    if (parambxv != null) {
      parambxv.setVisibility(8);
    }
    label600:
    AppMethodBeat.o(348568);
  }
  
  public final void dTP()
  {
    bui localbui = null;
    AppMethodBeat.i(348546);
    Object localObject1 = this.AtP;
    Object localObject2;
    if (localObject1 == null)
    {
      localObject1 = null;
      if (!Util.isNullOrNil((String)localObject1))
      {
        localObject2 = com.tencent.mm.plugin.finder.report.z.FrZ;
        if (localObject1 != null) {
          break label85;
        }
        localObject1 = "";
        label38:
        localObject2 = as.GSQ;
        localObject2 = as.a.hu((Context)this.lzt);
        if (localObject2 != null) {
          break label88;
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.plugin.finder.report.z.a((String)localObject1, 1, localbui, com.tencent.mm.ae.d.hF(this.Avc));
      AppMethodBeat.o(348546);
      return;
      localObject1 = ((awt)localObject1).WDP;
      break;
      label85:
      break label38;
      label88:
      localbui = ((as)localObject2).fou();
    }
  }
  
  public final void dTR()
  {
    Object localObject2 = null;
    int m = 0;
    AppMethodBeat.i(348578);
    Object localObject1 = com.tencent.mm.plugin.finder.report.z.FrZ;
    localObject1 = this.AtP;
    long l;
    label56:
    Object localObject3;
    if (localObject1 == null)
    {
      l = 0L;
      localObject1 = as.GSQ;
      localObject1 = as.a.hu((Context)this.lzt);
      if (localObject1 != null) {
        break label188;
      }
      localObject1 = null;
      com.tencent.mm.plugin.finder.report.z.a(2L, l, (bui)localObject1);
      localObject1 = new StringBuilder();
      com.tencent.mm.kernel.h.baC();
      localObject3 = com.tencent.mm.kernel.b.aZs() + '_' + Util.nowMilliSecond();
      localObject1 = com.tencent.mm.plugin.finder.activity.b.Aty;
      localObject1 = this.AtP;
      if (localObject1 != null) {
        break label198;
      }
    }
    label188:
    label198:
    for (localObject1 = null;; localObject1 = Long.valueOf(((awt)localObject1).ocD))
    {
      if (!com.tencent.mm.plugin.finder.activity.b.c((Long)localObject1, 9)) {
        break label211;
      }
      localObject1 = com.tencent.mm.plugin.finder.utils.a.GfO;
      if (!com.tencent.mm.plugin.finder.utils.a.gW((Context)this.lzt)) {
        break label211;
      }
      localObject1 = com.tencent.mm.plugin.finder.report.v.FrN;
      com.tencent.mm.plugin.finder.report.v.aP(9, true);
      localObject1 = com.tencent.mm.plugin.finder.report.v.FrN;
      com.tencent.mm.plugin.finder.report.v.azR((String)localObject3);
      AppMethodBeat.o(348578);
      return;
      l = ((awt)localObject1).ocD;
      break;
      localObject1 = ((as)localObject1).fou();
      break label56;
    }
    label211:
    localObject1 = com.tencent.mm.plugin.finder.report.v.FrN;
    com.tencent.mm.plugin.finder.report.v.aP(9, false);
    localObject1 = com.tencent.mm.plugin.finder.report.v.FrN;
    com.tencent.mm.plugin.finder.report.v.azR((String)localObject3);
    localObject1 = this.AtP;
    int i;
    label259:
    Object localObject4;
    int j;
    label298:
    int k;
    if (localObject1 == null)
    {
      localObject1 = null;
      localObject3 = this.AtP;
      if (localObject3 != null) {
        break label410;
      }
      i = 0;
      if ((i <= 0) || (localObject1 == null)) {
        break label688;
      }
      localObject3 = ((com.tencent.mm.mj_template.api.d)com.tencent.mm.kernel.h.az(com.tencent.mm.mj_template.api.d.class)).getFinderMaasConfig();
      localObject4 = ((fxs)localObject1).ZHT;
      if (localObject4 != null) {
        break label419;
      }
      j = 0;
      localObject4 = ((fxs)localObject1).ZHT;
      if (localObject4 != null) {
        break label428;
      }
      k = 0;
      label312:
      localObject4 = this.AtP;
      if (localObject4 != null) {
        break label437;
      }
      i = -1;
      label325:
      if (!((com.tencent.mm.mj_template.api.a)localObject3).af(j, k, i)) {
        break label688;
      }
      switch (((fxs)localObject1).abVu)
      {
      default: 
        localObject1 = this.AtP;
        if (localObject1 == null) {
          localObject1 = localObject2;
        }
        break;
      }
    }
    for (;;)
    {
      Log.e("Finder.ActivityHeader", kotlin.g.b.s.X("participate error for type:", localObject1));
      AppMethodBeat.o(348578);
      return;
      localObject1 = ((awt)localObject1).ZHV;
      break;
      label410:
      i = ((awt)localObject3).ZHQ;
      break label259;
      label419:
      j = ((fmi)localObject4).abME;
      break label298;
      label428:
      k = ((fmi)localObject4).abMF;
      break label312;
      label437:
      localObject4 = ((awt)localObject4).ZHV;
      if (localObject4 == null)
      {
        i = -1;
        break label325;
      }
      i = ((fxs)localObject4).abVu;
      break label325;
      localObject1 = new Intent();
      ((Intent)localObject1).putExtra("key_maas_entrance", 3);
      ((Intent)localObject1).putExtra("key_finder_post_router", 16);
      localObject2 = ah.aiuX;
      aq((Intent)localObject1);
      AppMethodBeat.o(348578);
      return;
      localObject2 = new byy();
      ((byy)localObject2).id = ((fxs)localObject1).abVv;
      ((byy)localObject2).type = ((fxs)localObject1).abVu;
      localObject3 = new fxe();
      localObject4 = ((fxs)localObject1).ZHT;
      if (localObject4 == null)
      {
        i = 0;
        ((fxe)localObject3).abME = i;
        localObject1 = ((fxs)localObject1).ZHT;
        if (localObject1 != null) {
          break label650;
        }
      }
      label650:
      for (i = m;; i = ((fmi)localObject1).abME)
      {
        ((fxe)localObject3).abMF = i;
        localObject1 = ah.aiuX;
        ((byy)localObject2).aahY = ((fxe)localObject3);
        ((com.tencent.mm.mj_template.api.d)com.tencent.mm.kernel.h.az(com.tencent.mm.mj_template.api.d.class)).creationBySameTemplate((Activity)this.lzt, (byy)localObject2, new Intent(), 11);
        AppMethodBeat.o(348578);
        return;
        i = ((fmi)localObject4).abME;
        break;
      }
      localObject3 = ((awt)localObject1).ZHV;
      localObject1 = localObject2;
      if (localObject3 != null) {
        localObject1 = Integer.valueOf(((fxs)localObject3).abVu);
      }
    }
    label688:
    dTU();
    AppMethodBeat.o(348578);
  }
  
  public final String dTT()
  {
    String str = null;
    AppMethodBeat.i(348582);
    Object localObject = this.AtP;
    if (localObject == null) {}
    while (str == null)
    {
      str = this.lzt.getResources().getString(e.h.finder_activity_finished);
      kotlin.g.b.s.s(str, "context.resources.getStr…finder_activity_finished)");
      AppMethodBeat.o(348582);
      return str;
      localObject = ((awt)localObject).ZHN;
      if (localObject != null) {
        str = ((awx)localObject).ZIi;
      }
    }
    AppMethodBeat.o(348582);
    return str;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(348554);
    this.AwP.dead();
    this.AwQ.dead();
    com.tencent.mm.plugin.finder.activity.a.a locala = com.tencent.mm.plugin.finder.activity.a.Atw;
    com.tencent.e.f.h.jXD();
    com.tencent.mm.plugin.finder.activity.a.ao(null);
    com.tencent.mm.kernel.h.aZW().b(3761, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(348554);
  }
  
  public final void fn(View paramView)
  {
    AppMethodBeat.i(348533);
    if (paramView != null)
    {
      fo(paramView);
      dTQ();
      dTx();
      this.AwP.alive();
      this.AwQ.alive();
    }
    this.pUv = paramView;
    com.tencent.mm.kernel.h.aZW().a(3761, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(348533);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(348539);
    g localg = this.AwN;
    if (localg != null) {
      localg.onSceneEnd(paramInt1, paramInt2, paramString, paramp);
    }
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramp instanceof di))) {
      this.AwM = ((di)paramp).dVy();
    }
    AppMethodBeat.o(348539);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/activity/view/ActivityHeaderManager$Companion;", "", "()V", "CREATE_ACCOUNT_REQUEST_CODE", "", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.g.b.u
    implements kotlin.g.a.b<String, ah>
  {
    c(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends kotlin.g.b.u
    implements kotlin.g.a.b<String, ah>
  {
    d(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.g.b.u
    implements kotlin.g.a.b<String, ah>
  {
    e(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    f(a parama)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    g(a parama)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.activity.view.a
 * JD-Core Version:    0.7.0.1
 */
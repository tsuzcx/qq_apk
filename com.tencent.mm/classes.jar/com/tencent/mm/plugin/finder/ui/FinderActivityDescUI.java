package com.tencent.mm.plugin.finder.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Layout.Alignment;
import android.text.SpannableString;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.am.h;
import com.tencent.mm.loader.d;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.ao;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.view.q;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderJumpInfo;
import com.tencent.mm.protocal.protobuf.aws;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.protocal.protobuf.awx;
import com.tencent.mm.protocal.protobuf.buq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.g.b.ah.a;
import kotlin.g.b.u;
import kotlin.n.n;

@com.tencent.mm.ui.base.a(3)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderActivityDescUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "ITEM_ID_PATICIPATE_ACITIVITY", "", "TAG", "", "activityDesc", "Landroid/widget/TextView;", "activityDescEndTime", "activityDescParticipateCount", "activityDescText", "activityEndTime", "", "activityEventName", "activityNickName", "activityParticipateCount", "adActivityIcon", "Landroid/widget/ImageView;", "adContainer", "Landroid/widget/LinearLayout;", "adMiniAppIcon", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "adTextView", "bottomSheetDialog", "Lcom/google/android/material/bottomsheet/BottomSheetDialog;", "cancelBtn", "color", "coverUrl", "descContainer", "Landroid/view/View;", "descIconView", "displayMask", "eventInfo", "Lcom/tencent/mm/protocal/protobuf/FinderEventInfo;", "eventWordingInfo", "Lcom/tencent/mm/protocal/protobuf/FinderEventWordingInfo;", "mDialogBehavior", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "noteAvatarContainer", "noteContainer", "noteLine", "noteTextView", "participateBtn", "dismissAuthViews", "", "authIcon", "authDesc", "authGuaranteeView", "Landroid/view/ViewGroup;", "exitText", "fixActionBar", "getAvailableDescWidth", "getLayoutId", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "isNoEllipseDescClickable", "", "jumpByJumpInfo", "jumpInfo", "Lcom/tencent/mm/protocal/protobuf/FinderJumpInfo;", "jumpByMiniProgram", "jumpToPage", "jumpToProfile", "username", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "participateText", "refreshView", "setAuthText", "authInfo", "Lcom/tencent/mm/protocal/protobuf/FinderAuthInfo;", "setDescSpan", "textView", "descText", "leftMargin", "clickListener", "Lkotlin/Function1;", "setFullScreen", "setParticipateText", "count", "setSuffixedDesc", "maxLineNum", "isCovered", "setSuffixedIcon", "showBottomSheet", "showJumpView", "showMiniProgram", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderActivityDescUI
  extends MMFinderUI
  implements h
{
  private awt AtP;
  private TextView AuK;
  private View AuL;
  private com.google.android.material.bottomsheet.a AuX;
  private BottomSheetBehavior<View> AuY;
  private ImageView AwA;
  private LinearLayout AwB;
  private TextView AwD;
  private WeImageView AwE;
  private ImageView AwF;
  private View AwJ;
  private int AwK;
  private LinearLayout Awz;
  private View CzL;
  private TextView FNZ;
  private TextView FOa;
  private TextView FOb;
  private TextView FOc;
  private final int FOd = 100;
  private long FOe;
  private String FOf = "";
  private String FOg = "";
  private String FOh = "";
  private long FOi;
  private awx FOj;
  private final String TAG = "Finder.FinderActivityDescUI";
  private int color;
  private String coverUrl = "";
  private TextView pOq;
  
  private static final kotlin.ah a(FinderActivityDescUI paramFinderActivityDescUI, b.a parama)
  {
    long l2 = 0L;
    Object localObject2 = null;
    AppMethodBeat.i(346855);
    kotlin.g.b.s.u(paramFinderActivityDescUI, "this$0");
    int i;
    label53:
    long l1;
    label69:
    label85:
    label111:
    label116:
    Object localObject3;
    if ((parama.errType == 0) && (parama.errCode == 0)) {
      if (parama == null)
      {
        parama = null;
        paramFinderActivityDescUI.AtP = parama;
        parama = paramFinderActivityDescUI.AtP;
        if (parama != null) {
          break label484;
        }
        i = 0;
        paramFinderActivityDescUI.AwK = i;
        parama = paramFinderActivityDescUI.AtP;
        if (parama != null) {
          break label492;
        }
        l1 = 0L;
        paramFinderActivityDescUI.FOi = l1;
        parama = paramFinderActivityDescUI.AtP;
        if (parama != null) {
          break label500;
        }
        parama = null;
        paramFinderActivityDescUI.FOj = parama;
        if (paramFinderActivityDescUI.FOe == 0L)
        {
          parama = paramFinderActivityDescUI.AtP;
          if (parama != null) {
            break label508;
          }
          l1 = l2;
          paramFinderActivityDescUI.FOe = l1;
        }
        parama = paramFinderActivityDescUI.FOa;
        if (parama != null)
        {
          localObject1 = av.GiL;
          l1 = paramFinderActivityDescUI.FOe;
          localObject1 = paramFinderActivityDescUI.getContext();
          kotlin.g.b.s.s(localObject1, "context");
          parama.setText((CharSequence)av.b(l1 * 1000L, (Context)localObject1));
        }
        localObject3 = com.tencent.mm.plugin.finder.utils.r.ip(2, paramFinderActivityDescUI.AwK);
        parama = paramFinderActivityDescUI.AtP;
        if (parama != null) {
          break label572;
        }
        parama = null;
        label190:
        Object localObject1 = parama;
        if (parama == null)
        {
          localObject1 = paramFinderActivityDescUI.getContext().getString(e.h.finder_activity_item_desc, new Object[] { localObject3 });
          kotlin.g.b.s.s(localObject1, "context.getString(R.stri…ity_item_desc, countText)");
        }
        parama = paramFinderActivityDescUI.FOb;
        if (parama != null) {
          parama.setText((CharSequence)localObject1);
        }
        if (paramFinderActivityDescUI.FOe != 4294967295L)
        {
          parama = av.GiL;
          if (av.qJ(paramFinderActivityDescUI.FOi))
          {
            parama = paramFinderActivityDescUI.FOa;
            if (parama != null) {
              parama.setVisibility(0);
            }
          }
        }
        parama = paramFinderActivityDescUI.FOb;
        if (parama != null) {
          parama.setVisibility(0);
        }
        localObject1 = paramFinderActivityDescUI.AtP;
        if (localObject1 != null)
        {
          parama = ((awt)localObject1).hVf;
          if (parama != null) {
            break label610;
          }
          parama = (b.a)localObject2;
          if (parama == null)
          {
            Log.i("Finder.ActivityHeader", "showJumpView by MiniProgram");
            if (localObject1 != null)
            {
              if (Util.isNullOrNil(((awt)localObject1).WDP)) {
                break label794;
              }
              parama = paramFinderActivityDescUI.AwB;
              if (parama != null) {
                parama.setVisibility(0);
              }
              parama = paramFinderActivityDescUI.AwD;
              if (parama != null) {
                parama.setText((CharSequence)((awt)localObject1).ZHJ);
              }
              parama = paramFinderActivityDescUI.AwE;
              if (parama != null) {
                parama.setVisibility(0);
              }
              parama = paramFinderActivityDescUI.AwF;
              if (parama != null) {
                parama.setVisibility(8);
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      Log.i(paramFinderActivityDescUI.TAG, "CgiFinderSearchEvent refresh");
      paramFinderActivityDescUI.refreshView();
      paramFinderActivityDescUI = kotlin.ah.aiuX;
      AppMethodBeat.o(346855);
      return paramFinderActivityDescUI;
      parama = (buq)parama.ott;
      if (parama == null)
      {
        parama = null;
        break;
      }
      parama = parama.aabt;
      if (parama == null)
      {
        parama = null;
        break;
      }
      parama = (awt)kotlin.a.p.oL((List)parama);
      break;
      label484:
      i = parama.feedCount;
      break label53;
      label492:
      l1 = parama.FOi;
      break label69;
      label500:
      parama = parama.ZHN;
      break label85;
      label508:
      l1 = parama.endTime;
      break label111;
      Log.i(paramFinderActivityDescUI.TAG, "errorType = " + parama.errType + " errorCode = " + parama.errCode + "  errorMsg = " + parama.errMsg);
      break label116;
      label572:
      parama = parama.ZHN;
      if (parama == null)
      {
        parama = null;
        break label190;
      }
      parama = parama.ZId;
      if (parama == null)
      {
        parama = null;
        break label190;
      }
      parama = kotlin.g.b.s.X((String)localObject3, parama);
      break label190;
      label610:
      Log.i("Finder.ActivityHeader", "showJumpView by jumpInfo");
      if (!Util.isNullOrNil(parama.wording))
      {
        localObject2 = paramFinderActivityDescUI.AwB;
        if (localObject2 != null) {
          ((LinearLayout)localObject2).setVisibility(0);
        }
        localObject2 = paramFinderActivityDescUI.AwD;
        if (localObject2 != null) {
          ((TextView)localObject2).setText((CharSequence)parama.wording);
        }
        localObject2 = paramFinderActivityDescUI.AwE;
        if (localObject2 != null) {
          ((WeImageView)localObject2).setVisibility(8);
        }
        localObject2 = paramFinderActivityDescUI.AwF;
        if (localObject2 != null) {
          ((ImageView)localObject2).setVisibility(0);
        }
        localObject2 = paramFinderActivityDescUI.AwF;
        if (localObject2 != null)
        {
          ((ImageView)localObject2).setVisibility(0);
          localObject3 = com.tencent.mm.plugin.finder.loader.p.ExI;
          localObject3 = com.tencent.mm.plugin.finder.loader.p.eCl();
          com.tencent.mm.plugin.finder.loader.s locals = new com.tencent.mm.plugin.finder.loader.s(parama.icon_url, v.FKZ);
          com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
          ((d)localObject3).a(locals, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExR)).d((ImageView)localObject2);
        }
      }
      for (;;)
      {
        break;
        localObject2 = paramFinderActivityDescUI.AwB;
        if (localObject2 != null) {
          ((LinearLayout)localObject2).setVisibility(8);
        }
      }
      label794:
      parama = paramFinderActivityDescUI.AwB;
      if (parama != null) {
        parama.setVisibility(8);
      }
    }
  }
  
  private static final void a(View paramView1, View paramView2, ah.a parama, FinderActivityDescUI paramFinderActivityDescUI)
  {
    AppMethodBeat.i(346901);
    kotlin.g.b.s.u(parama, "$isParticipate");
    kotlin.g.b.s.u(paramFinderActivityDescUI, "this$0");
    int i = paramView1.getHeight();
    int j = paramView2.getHeight();
    if (parama.aiwY)
    {
      k = com.tencent.mm.cd.a.fromDPToPix((Context)paramFinderActivityDescUI.getContext(), 170);
      if (i - j > k)
      {
        paramView1 = paramView2.getLayoutParams();
        paramView1.height = (i - k);
        paramView2.setLayoutParams(paramView1);
      }
      parama = paramFinderActivityDescUI.FOc;
      if (parama != null)
      {
        paramView1 = paramFinderActivityDescUI.FOj;
        if (paramView1 != null) {
          break label155;
        }
        paramView1 = null;
      }
      for (;;)
      {
        paramView2 = paramView1;
        if (paramView1 == null)
        {
          paramView2 = paramFinderActivityDescUI.getResources().getString(e.h.finder_activity_participate_text);
          kotlin.g.b.s.s(paramView2, "resources.getString(R.st…ctivity_participate_text)");
        }
        parama.setText((CharSequence)paramView2);
        paramView1 = paramFinderActivityDescUI.FOc;
        if (paramView1 == null) {
          break;
        }
        paramView1.setVisibility(0);
        AppMethodBeat.o(346901);
        return;
        label155:
        paramView2 = paramView1.ZIe;
        paramView1 = paramView2;
        if (paramView2 == null) {
          paramView1 = "";
        }
      }
    }
    int k = com.tencent.mm.cd.a.fromDPToPix((Context)paramFinderActivityDescUI.getContext(), 170);
    if (i - j > k)
    {
      paramView1 = paramView2.getLayoutParams();
      paramView1.height = (i - k);
      paramView2.setLayoutParams(paramView1);
    }
    paramView1 = paramFinderActivityDescUI.pOq;
    if (paramView1 != null) {
      paramView1.setText((CharSequence)paramFinderActivityDescUI.faC());
    }
    paramView1 = paramFinderActivityDescUI.pOq;
    if (paramView1 != null) {
      paramView1.setVisibility(0);
    }
    AppMethodBeat.o(346901);
  }
  
  private final void a(TextView paramTextView, String paramString, int paramInt1, int paramInt2, kotlin.g.a.b<? super String, kotlin.ah> paramb)
  {
    AppMethodBeat.i(346790);
    SpannableString localSpannableString = new SpannableString((CharSequence)paramString);
    hn(paramInt1, paramInt2);
    localSpannableString.setSpan(new q(paramString, paramInt1, getContext().getResources().getColor(e.b.transparent), false, (kotlin.g.a.b)new FinderActivityDescUI.a(paramb)), 0, paramString.length(), 17);
    paramTextView.setText((CharSequence)localSpannableString);
    AppMethodBeat.o(346790);
  }
  
  private static final void a(FinderActivityDescUI paramFinderActivityDescUI, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(346917);
    kotlin.g.b.s.u(paramFinderActivityDescUI, "this$0");
    paramFinderActivityDescUI.AuX = null;
    AppMethodBeat.o(346917);
  }
  
  private static final void a(FinderActivityDescUI paramFinderActivityDescUI, MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(346888);
    kotlin.g.b.s.u(paramFinderActivityDescUI, "this$0");
    if (paramMenuItem.getItemId() == paramFinderActivityDescUI.FOd)
    {
      paramMenuItem = com.tencent.mm.plugin.finder.storage.ah.FMh;
      paramMenuItem = paramFinderActivityDescUI.getIntent();
      kotlin.g.b.s.s(paramMenuItem, "intent");
      com.tencent.mm.plugin.finder.storage.ah.aI(paramMenuItem);
      paramFinderActivityDescUI.getIntent().putExtra("key_activity_type", 100);
      paramFinderActivityDescUI.getIntent().putExtra("key_activity_already_participate", false);
      paramFinderActivityDescUI.getIntent().putExtra("key_activity_jump_info_list", (Serializable)new ArrayList());
      paramFinderActivityDescUI.getIntent().putExtra("key_activity_post_wording", "");
      paramFinderActivityDescUI.setResult(-1, paramFinderActivityDescUI.getIntent());
      paramFinderActivityDescUI.finish();
    }
    AppMethodBeat.o(346888);
  }
  
  private static final void a(FinderActivityDescUI paramFinderActivityDescUI, View paramView)
  {
    AppMethodBeat.i(346869);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderActivityDescUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderActivityDescUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramFinderActivityDescUI, "this$0");
    if (paramFinderActivityDescUI.FOe != 0L) {
      paramFinderActivityDescUI.getIntent().putExtra("key_activity_end_time", paramFinderActivityDescUI.FOe);
    }
    paramView = paramFinderActivityDescUI.AtP;
    if (paramView != null)
    {
      paramView = paramView.ZHR;
      if (paramView != null)
      {
        localObject = com.tencent.mm.plugin.finder.activity.b.Aty;
        paramView = com.tencent.mm.plugin.finder.activity.b.fQ((List)paramView);
        if (paramView != null) {
          paramFinderActivityDescUI.getIntent().putExtra("key_activity_jump_info_list", (Serializable)paramView);
        }
      }
    }
    paramView = paramFinderActivityDescUI.AtP;
    if (paramView != null)
    {
      paramView = paramView.ZHS;
      if (paramView != null) {
        paramFinderActivityDescUI.getIntent().putExtra("key_activity_post_wording", paramView);
      }
    }
    paramView = com.tencent.mm.plugin.finder.report.y.FrY;
    paramView = z.bAW();
    kotlin.g.b.s.s(paramView, "getMyFinderUsername()");
    com.tencent.mm.plugin.finder.report.y.c("5", paramView, null);
    paramFinderActivityDescUI.setResult(-1, paramFinderActivityDescUI.getIntent());
    paramFinderActivityDescUI.finish();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/FinderActivityDescUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(346869);
  }
  
  private static final void a(FinderActivityDescUI paramFinderActivityDescUI, FinderContact paramFinderContact, View paramView)
  {
    AppMethodBeat.i(346910);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderActivityDescUI);
    localb.cH(paramFinderContact);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderActivityDescUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramFinderActivityDescUI, "this$0");
    kotlin.g.b.s.u(paramFinderContact, "$finderContact");
    paramView = paramFinderContact.username;
    paramFinderContact = paramView;
    if (paramView == null) {
      paramFinderContact = "";
    }
    paramFinderActivityDescUI.aAV(paramFinderContact);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/FinderActivityDescUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(346910);
  }
  
  private static final void a(FinderActivityDescUI paramFinderActivityDescUI, com.tencent.mm.ui.base.s params)
  {
    AppMethodBeat.i(346883);
    kotlin.g.b.s.u(paramFinderActivityDescUI, "this$0");
    if (params.jmw()) {
      params.a(paramFinderActivityDescUI.FOd, paramFinderActivityDescUI.getContext().getResources().getColor(e.b.Red_100), (CharSequence)paramFinderActivityDescUI.faC());
    }
    AppMethodBeat.o(346883);
  }
  
  private final void a(awt paramawt, FinderJumpInfo paramFinderJumpInfo)
  {
    AppMethodBeat.i(346825);
    switch (paramFinderJumpInfo.jumpinfo_type)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(346825);
      return;
      StringBuilder localStringBuilder = new StringBuilder();
      if (paramawt == null) {
        paramawt = "";
      }
      for (;;)
      {
        paramawt = paramawt + ':' + Util.getUuidRandom();
        Object localObject = as.GSQ;
        localObject = getContext();
        kotlin.g.b.s.s(localObject, "context");
        localObject = as.a.hu((Context)localObject);
        if (localObject != null) {
          ((as)localObject).fou();
        }
        localObject = com.tencent.mm.plugin.finder.feed.jumper.r.Bej;
        localObject = getContext();
        kotlin.g.b.s.s(localObject, "context");
        com.tencent.mm.plugin.finder.feed.jumper.r.a((Context)localObject, paramFinderJumpInfo, null, 1191, paramawt, null, 36);
        AppMethodBeat.o(346825);
        return;
        paramawt = paramawt.contact;
        if (paramawt == null)
        {
          paramawt = "";
        }
        else
        {
          localObject = paramawt.username;
          paramawt = (awt)localObject;
          if (localObject == null) {
            paramawt = "";
          }
        }
      }
      paramawt = com.tencent.mm.plugin.finder.feed.jumper.r.Bej;
      paramawt = getContext();
      kotlin.g.b.s.s(paramawt, "context");
      com.tencent.mm.plugin.finder.feed.jumper.r.a((Context)paramawt, new com.tencent.mm.plugin.finder.feed.jumper.k(paramFinderJumpInfo));
    }
  }
  
  private final void a(String paramString, TextView paramTextView, boolean paramBoolean)
  {
    AppMethodBeat.i(346777);
    if (Util.isNullOrNil(paramString))
    {
      Log.i("SimpleUIComponent", "desc " + paramString + ", maxLineNum:2");
      AppMethodBeat.o(346777);
      return;
    }
    int j = dTy();
    Object localObject2 = paramTextView.getPaint();
    int i;
    Object localObject1;
    if (paramBoolean)
    {
      i = getContext().getResources().getColor(e.b.BW_100_Alpha_0_8);
      localObject1 = new StaticLayout((CharSequence)paramString, 0, paramString.length(), (TextPaint)localObject2, j, Layout.Alignment.ALIGN_NORMAL, 1.0F, 1.0F, true);
      if (((StaticLayout)localObject1).getLineCount() > 2) {
        break label270;
      }
      if (!dTV()) {
        break label240;
      }
      if (((StaticLayout)localObject1).getLineCount() != 2) {
        break label234;
      }
    }
    float f1;
    float f2;
    label234:
    for (j = ((StaticLayout)localObject1).getLineEnd(0);; j = 0)
    {
      f1 = paramTextView.getPaint().measureText(paramString.subSequence(j, paramString.length()).toString());
      f2 = getContext().getResources().getDimension(e.c.finder_0_25_A);
      a(paramTextView, kotlin.g.b.s.X(paramString, " "), i, (int)(f1 + f2), (kotlin.g.a.b)new b(this));
      AppMethodBeat.o(346777);
      return;
      i = getContext().getResources().getColor(e.b.FG_0);
      break;
    }
    label240:
    paramTextView.setText((CharSequence)paramString);
    paramString = this.AwJ;
    label270:
    int k;
    if (paramString != null)
    {
      paramString.setVisibility(8);
      AppMethodBeat.o(346777);
      return;
      k = ((StaticLayout)localObject1).getLineEnd(1);
      int m = ((StaticLayout)localObject1).getLineEnd(0);
      int n = (int)getContext().getResources().getDimension(e.c.finder_1_75_A);
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
          break label519;
        }
        localObject2 = new StringBuilder();
        if (paramString == null)
        {
          paramString = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(346777);
          throw paramString;
        }
        paramString = paramString.substring(0, k - 1);
        kotlin.g.b.s.s(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      }
    }
    for (paramString = paramString + (String)localObject1 + ' ';; paramString = paramString + (String)localObject1 + ' ')
    {
      a(paramTextView, paramString, i, (int)(j - getContext().getResources().getDimension(e.c.finder_2_25_A)), (kotlin.g.a.b)new c(this));
      AppMethodBeat.o(346777);
      return;
      label519:
      localObject2 = new StringBuilder();
      if (paramString == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(346777);
        throw paramString;
      }
      paramString = paramString.substring(0, k);
      kotlin.g.b.s.s(paramString, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    }
  }
  
  private static final boolean a(FinderActivityDescUI paramFinderActivityDescUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(346860);
    kotlin.g.b.s.u(paramFinderActivityDescUI, "this$0");
    paramFinderActivityDescUI.setResult(-1, paramFinderActivityDescUI.getIntent());
    paramFinderActivityDescUI.finish();
    AppMethodBeat.o(346860);
    return true;
  }
  
  private final void aAV(String paramString)
  {
    AppMethodBeat.i(346817);
    Intent localIntent = new Intent();
    localIntent.putExtra("finder_username", paramString);
    paramString = as.GSQ;
    paramString = getContext();
    kotlin.g.b.s.s(paramString, "context");
    as.a.a((Context)paramString, localIntent, 0L, 1, false, 64);
    paramString = com.tencent.mm.plugin.finder.utils.a.GfO;
    AppCompatActivity localAppCompatActivity = getContext();
    kotlin.g.b.s.s(localAppCompatActivity, "context");
    paramString.enterFinderProfileUI((Context)localAppCompatActivity, localIntent);
    AppMethodBeat.o(346817);
  }
  
  private static final void b(FinderActivityDescUI paramFinderActivityDescUI, View paramView)
  {
    AppMethodBeat.i(346878);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramFinderActivityDescUI);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderActivityDescUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(paramFinderActivityDescUI, "this$0");
    localObject2 = paramFinderActivityDescUI.AtP;
    Object localObject3;
    if (localObject2 != null)
    {
      paramView = ((awt)localObject2).hVf;
      if (paramView != null) {
        break label223;
      }
      paramView = null;
      if ((paramView == null) && (localObject2 != null))
      {
        localObject3 = new StringBuilder();
        paramView = ((awt)localObject2).contact;
        if (paramView != null) {
          break label232;
        }
        paramView = "";
      }
    }
    for (;;)
    {
      localObject3 = paramView + ':' + Util.getUuidRandom();
      com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.GfO;
      paramFinderActivityDescUI = paramFinderActivityDescUI.getContext();
      kotlin.g.b.s.s(paramFinderActivityDescUI, "context");
      Context localContext = (Context)paramFinderActivityDescUI;
      paramView = ((awt)localObject2).WDP;
      paramFinderActivityDescUI = paramView;
      if (paramView == null) {
        paramFinderActivityDescUI = "";
      }
      localObject1 = ((awt)localObject2).ZHI;
      paramView = (View)localObject1;
      if (localObject1 == null) {
        paramView = "";
      }
      locala.a(localContext, paramFinderActivityDescUI, paramView, 1191, (String)localObject3);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/FinderActivityDescUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(346878);
      return;
      label223:
      paramFinderActivityDescUI.a((awt)localObject2, paramView);
      break;
      label232:
      localObject1 = paramView.username;
      paramView = (View)localObject1;
      if (localObject1 == null) {
        paramView = "";
      }
    }
  }
  
  private static final void b(FinderActivityDescUI paramFinderActivityDescUI, FinderContact paramFinderContact, View paramView)
  {
    AppMethodBeat.i(346921);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderActivityDescUI);
    localb.cH(paramFinderContact);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderActivityDescUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramFinderActivityDescUI, "this$0");
    kotlin.g.b.s.u(paramFinderContact, "$it");
    paramView = paramFinderContact.username;
    paramFinderContact = paramView;
    if (paramView == null) {
      paramFinderContact = "";
    }
    paramFinderActivityDescUI.aAV(paramFinderContact);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/FinderActivityDescUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(346921);
  }
  
  private static final void c(FinderActivityDescUI paramFinderActivityDescUI, View paramView)
  {
    AppMethodBeat.i(346896);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramFinderActivityDescUI);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderActivityDescUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(paramFinderActivityDescUI, "this$0");
    localObject2 = new com.tencent.mm.ui.widget.a.f((Context)paramFinderActivityDescUI, 1, true);
    paramView = paramFinderActivityDescUI.FOj;
    if (paramView == null) {}
    for (paramView = null;; paramView = paramView.ZIl)
    {
      localObject1 = paramView;
      if (paramView == null) {
        localObject1 = paramFinderActivityDescUI.getResources().getString(e.h.finder_activity_participate_hint_title);
      }
      kotlin.g.b.s.s(localObject1, "eventWordingInfo?.let {\n…y_participate_hint_title)");
      ((com.tencent.mm.ui.widget.a.f)localObject2).h((CharSequence)localObject1, 17, 0);
      ((com.tencent.mm.ui.widget.a.f)localObject2).Vtg = new FinderActivityDescUI..ExternalSyntheticLambda8(paramFinderActivityDescUI);
      ((com.tencent.mm.ui.widget.a.f)localObject2).GAC = new FinderActivityDescUI..ExternalSyntheticLambda9(paramFinderActivityDescUI);
      ((com.tencent.mm.ui.widget.a.f)localObject2).dDn();
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/FinderActivityDescUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(346896);
      return;
    }
  }
  
  private static final void d(FinderActivityDescUI paramFinderActivityDescUI, View paramView)
  {
    AppMethodBeat.i(346924);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderActivityDescUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderActivityDescUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramFinderActivityDescUI, "this$0");
    paramFinderActivityDescUI = paramFinderActivityDescUI.AuX;
    if (paramFinderActivityDescUI != null) {
      paramFinderActivityDescUI.hide();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/FinderActivityDescUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(346924);
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
  
  private final int dTy()
  {
    AppMethodBeat.i(346807);
    DisplayMetrics localDisplayMetrics = new DisplayMetrics();
    getContext().getWindowManager().getDefaultDisplay().getMetrics(localDisplayMetrics);
    int i = localDisplayMetrics.widthPixels;
    int j = com.tencent.mm.cd.a.bs((Context)getContext(), e.c.Edge_6A);
    AppMethodBeat.o(346807);
    return i - j;
  }
  
  private final String faC()
  {
    AppMethodBeat.i(346769);
    Object localObject = this.FOj;
    if (localObject == null) {
      localObject = null;
    }
    while (localObject == null)
    {
      localObject = getResources().getString(e.h.finder_activity_exit_text);
      kotlin.g.b.s.s(localObject, "resources.getString(R.st…inder_activity_exit_text)");
      AppMethodBeat.o(346769);
      return localObject;
      String str = ((awx)localObject).ZIk;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
    }
    AppMethodBeat.o(346769);
    return localObject;
  }
  
  private final void hn(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(346799);
    Object localObject = this.AwJ;
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    ((WeImageView)getContext().findViewById(e.e.activity_profile_header_desc_icon)).setIconColor(paramInt1);
    paramInt1 = (int)getContext().getResources().getDimension(e.c.Edge_2A);
    localObject = this.FNZ;
    if (localObject != null)
    {
      localObject = ((TextView)localObject).getPaint().getFontMetricsInt();
      paramInt1 = (((Paint.FontMetricsInt)localObject).descent - ((Paint.FontMetricsInt)localObject).ascent) / 2 - paramInt1 / 2;
      Log.i(this.TAG, kotlin.g.b.s.X("gap :", Integer.valueOf(paramInt1)));
      localObject = this.AwJ;
      if (localObject != null) {
        break label166;
      }
      localObject = null;
      if (!(localObject instanceof FrameLayout.LayoutParams)) {
        break label174;
      }
    }
    label166:
    label174:
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
      AppMethodBeat.o(346799);
      return;
      localObject = ((View)localObject).getLayoutParams();
      break;
    }
  }
  
  private final void refreshView()
  {
    Object localObject2 = null;
    AppMethodBeat.i(346761);
    Object localObject1 = this.AtP;
    Object localObject4;
    if (localObject1 == null)
    {
      localObject1 = localObject2;
      if (localObject1 == null)
      {
        Log.i(this.TAG, "descriptionContactInfo null");
        localObject1 = this.Awz;
        if (localObject1 != null) {
          ((LinearLayout)localObject1).setVisibility(8);
        }
      }
      localObject4 = this.FNZ;
      if (localObject4 == null) {
        break label409;
      }
      localObject1 = getIntent().getStringExtra("key_activity_desc");
      localObject2 = localObject1;
      if (localObject1 == null) {
        localObject2 = "";
      }
      localObject1 = this.FOj;
      if (localObject1 != null) {
        break label310;
      }
      localObject1 = "";
      label95:
      if (Util.isNullOrNil((String)localObject1)) {
        break label330;
      }
      localObject1 = kotlin.g.b.s.X((String)localObject1, localObject2);
    }
    int i;
    for (;;)
    {
      localObject2 = localObject1;
      if (!n.rs((String)localObject1, "\n")) {
        break label379;
      }
      i = ((String)localObject1).length();
      if (localObject1 != null) {
        break label361;
      }
      localObject1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(346761);
      throw ((Throwable)localObject1);
      Object localObject3 = ((awt)localObject1).ZHP;
      localObject1 = localObject2;
      if (localObject3 == null) {
        break;
      }
      localObject3 = ((aws)localObject3).contact;
      localObject1 = localObject2;
      if (localObject3 == null) {
        break;
      }
      Log.i(this.TAG, "descriptionContactInfo not null");
      localObject1 = this.Awz;
      if (localObject1 != null) {
        ((LinearLayout)localObject1).setVisibility(0);
      }
      localObject1 = this.AwA;
      if (localObject1 != null)
      {
        localObject2 = com.tencent.mm.plugin.finder.loader.p.ExI;
        localObject2 = com.tencent.mm.plugin.finder.loader.p.eCp();
        localObject4 = new com.tencent.mm.plugin.finder.loader.b(((FinderContact)localObject3).headUrl);
        com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
        ((d)localObject2).a(localObject4, (ImageView)localObject1, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM));
        ((ImageView)localObject1).setOnClickListener(new FinderActivityDescUI..ExternalSyntheticLambda7(this, (FinderContact)localObject3));
      }
      localObject1 = this.AuK;
      if (localObject1 != null) {
        ((TextView)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b((Context)getContext(), (CharSequence)((FinderContact)localObject3).nickname));
      }
      localObject1 = kotlin.ah.aiuX;
      break;
      label310:
      localObject3 = ((awx)localObject1).ZIc;
      localObject1 = localObject3;
      if (localObject3 != null) {
        break label95;
      }
      localObject1 = "";
      break label95;
      label330:
      localObject1 = ((TextView)localObject4).getResources().getString(e.h.finder_activity_post_desc_prefix, new Object[] { localObject2 });
      kotlin.g.b.s.s(localObject1, "{\n                resour…Desc ?: \"\")\n            }");
    }
    label361:
    localObject2 = ((String)localObject1).substring(0, i - 1);
    kotlin.g.b.s.s(localObject2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
    label379:
    localObject1 = com.tencent.mm.plugin.finder.utils.ar.Giw;
    localObject1 = com.tencent.mm.plugin.finder.utils.ar.aBF((String)localObject2);
    if (!Util.isNullOrNil(this.coverUrl)) {}
    for (boolean bool = true;; bool = false)
    {
      a((String)localObject1, (TextView)localObject4, bool);
      label409:
      AppMethodBeat.o(346761);
      return;
    }
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return e.f.finder_activity_desc_ui_new;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(347037);
    Set localSet = kotlin.a.ar.setOf(com.tencent.mm.plugin.finder.activity.uic.b.class);
    AppMethodBeat.o(347037);
    return localSet;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject1 = null;
    AppMethodBeat.i(347034);
    super.onCreate(paramBundle);
    this.CzL = getContext().findViewById(e.e.activity_desc_container);
    this.FNZ = ((TextView)getContext().findViewById(e.e.finder_activity_desc));
    this.AwB = ((LinearLayout)getContext().findViewById(e.e.activity_profile_ad_container));
    this.FOa = ((TextView)getContext().findViewById(e.e.activity_desc_end_time));
    this.FOb = ((TextView)getContext().findViewById(e.e.activity_participate_count));
    this.FOc = ((TextView)getContext().findViewById(e.e.paticipateBtn));
    this.pOq = ((TextView)getContext().findViewById(e.e.cancelBtn));
    paramBundle = this.FOa;
    if (paramBundle != null) {
      paramBundle.setVisibility(8);
    }
    paramBundle = this.FOb;
    if (paramBundle != null) {
      paramBundle.setVisibility(8);
    }
    paramBundle = this.AwB;
    if (paramBundle != null) {
      paramBundle.setVisibility(8);
    }
    this.color = getResources().getColor(e.b.transparent);
    getController().setStatusBarColor(this.color);
    this.coverUrl = getIntent().getStringExtra("key_cover_url");
    Object localObject2 = getIntent().getStringExtra("key_nick_name");
    paramBundle = (Bundle)localObject2;
    if (localObject2 == null) {
      paramBundle = "";
    }
    this.FOf = paramBundle;
    localObject2 = getIntent().getStringExtra("key_activity_name");
    paramBundle = (Bundle)localObject2;
    if (localObject2 == null) {
      paramBundle = "";
    }
    this.FOg = paramBundle;
    localObject2 = getIntent().getStringExtra("key_activity_desc");
    paramBundle = (Bundle)localObject2;
    if (localObject2 == null) {
      paramBundle = "";
    }
    this.FOh = paramBundle;
    this.FOe = getIntent().getLongExtra("key_activity_end_time", 0L);
    this.FOi = getIntent().getLongExtra("key_activity_display_mask", 0L);
    localObject2 = getIntent().getByteArrayExtra("key_wording_info");
    if (localObject2 != null) {
      paramBundle = (com.tencent.mm.bx.a)new awx();
    }
    try
    {
      paramBundle.parseFrom((byte[])localObject2);
      this.FOj = ((awx)paramBundle);
      paramBundle = getWindow().getDecorView();
      kotlin.g.b.s.s(paramBundle, "window.decorView");
      paramBundle.setSystemUiVisibility(1280);
      paramBundle = getSupportActionBar();
      if (paramBundle != null)
      {
        paramBundle.setBackgroundDrawable((Drawable)new ColorDrawable(0));
        paramBundle.hide();
      }
      int i = bf.getStatusBarHeight((Context)this);
      paramBundle = this.CzL;
      if (paramBundle == null)
      {
        paramBundle = (Bundle)localObject1;
        if (paramBundle != null)
        {
          localObject1 = this.CzL;
          if (localObject1 != null) {
            ((View)localObject1).setPadding(0, i + paramBundle.intValue(), 0, 0);
          }
        }
        i = getResources().getColor(e.b.transparent);
        getController().setStatusBarColor(i);
        new ao(this.FOf, this.FOg).bFJ().a((com.tencent.mm.vending.e.b)this).g(new FinderActivityDescUI..ExternalSyntheticLambda10(this));
        paramBundle = new ah.a();
        paramBundle.aiwY = getIntent().getBooleanExtra("key_activity_already_participate", false);
        if (!paramBundle.aiwY) {
          break label1039;
        }
        localObject1 = this.FOc;
        if (localObject1 != null) {
          ((TextView)localObject1).setVisibility(4);
        }
        localObject1 = this.pOq;
        if (localObject1 != null) {
          ((TextView)localObject1).setVisibility(4);
        }
        setBackBtn(new FinderActivityDescUI..ExternalSyntheticLambda1(this));
        localObject1 = this.FOc;
        if (localObject1 != null) {
          ((TextView)localObject1).setOnClickListener(new FinderActivityDescUI..ExternalSyntheticLambda2(this));
        }
        this.AwB = ((LinearLayout)getContext().findViewById(e.e.activity_profile_ad_container));
        this.AwD = ((TextView)getContext().findViewById(e.e.activity_profile_ad_text));
        this.AwE = ((WeImageView)getContext().findViewById(e.e.activity_profile_mini_app_icon));
        this.AwF = ((ImageView)getContext().findViewById(e.e.activity_profile_activity_icon));
        localObject1 = this.AwB;
        if (localObject1 != null) {
          ((LinearLayout)localObject1).setOnClickListener(new FinderActivityDescUI..ExternalSyntheticLambda5(this));
        }
        this.AwJ = getContext().findViewById(e.e.activity_profile_header_desc_icon_container);
        this.Awz = ((LinearLayout)getContext().findViewById(e.e.activity_profile_header_note));
        this.AwA = ((ImageView)getContext().findViewById(e.e.activity_profile_header_note_avatar));
        this.AuK = ((TextView)getContext().findViewById(e.e.activity_profile_header_note_text));
        this.AuL = getContext().findViewById(e.e.activity_profile_header_note_line);
        localObject1 = this.pOq;
        if (localObject1 != null) {
          ((TextView)localObject1).setOnClickListener(new FinderActivityDescUI..ExternalSyntheticLambda3(this));
        }
        localObject1 = com.tencent.mm.ui.component.k.aeZF;
        ((com.tencent.mm.plugin.finder.activity.uic.b)com.tencent.mm.ui.component.k.d((AppCompatActivity)this).q(com.tencent.mm.plugin.finder.activity.uic.b.class)).initView();
        if (!Util.isNullOrNil(this.coverUrl)) {
          break label1070;
        }
        localObject1 = this.FOb;
        if (localObject1 != null) {
          ((TextView)localObject1).setTextColor(getContext().getResources().getColor(e.b.FG_1));
        }
        localObject1 = this.FOa;
        if (localObject1 != null) {
          ((TextView)localObject1).setTextColor(getContext().getResources().getColor(e.b.FG_0));
        }
        localObject1 = this.FNZ;
        if (localObject1 != null) {
          ((TextView)localObject1).setTextColor(getContext().getResources().getColor(e.b.FG_0));
        }
        localObject1 = this.AwD;
        if (localObject1 != null) {
          ((TextView)localObject1).setTextColor(getContext().getResources().getColor(e.b.FG_0));
        }
        localObject1 = this.FNZ;
        if (localObject1 != null) {
          ((TextView)localObject1).setOnTouchListener((View.OnTouchListener)new com.tencent.mm.pluginsdk.ui.span.s(((TextView)localObject1).getContext()));
        }
        refreshView();
        localObject1 = findViewById(e.e.activity_desc_scroll);
        ((View)localObject1).post(new FinderActivityDescUI..ExternalSyntheticLambda11((View)localObject1, findViewById(e.e.activity_desc_container), paramBundle, this));
        AppMethodBeat.o(347034);
      }
    }
    catch (Exception paramBundle)
    {
      for (;;)
      {
        Log.printDebugStack("safeParser", "", new Object[] { paramBundle });
        paramBundle = null;
        continue;
        paramBundle = Integer.valueOf(paramBundle.getPaddingTop());
        continue;
        label1039:
        localObject1 = this.FOc;
        if (localObject1 != null) {
          ((TextView)localObject1).setVisibility(4);
        }
        localObject1 = this.pOq;
        if (localObject1 != null)
        {
          ((TextView)localObject1).setVisibility(4);
          continue;
          label1070:
          localObject1 = this.FOb;
          if (localObject1 != null) {
            ((TextView)localObject1).setTextColor(getContext().getResources().getColor(e.b.BW_100_Alpha_0_5));
          }
          localObject1 = this.FOa;
          if (localObject1 != null) {
            ((TextView)localObject1).setTextColor(getContext().getResources().getColor(e.b.BW_100_Alpha_0_8));
          }
          localObject1 = this.FNZ;
          if (localObject1 != null) {
            ((TextView)localObject1).setTextColor(getContext().getResources().getColor(e.b.BW_100_Alpha_0_8));
          }
          localObject1 = this.AwD;
          if (localObject1 != null) {
            ((TextView)localObject1).setTextColor(getContext().getResources().getColor(e.b.BW_100_Alpha_0_8));
          }
        }
      }
    }
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp) {}
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.b<String, kotlin.ah>
  {
    b(FinderActivityDescUI paramFinderActivityDescUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<String, kotlin.ah>
  {
    c(FinderActivityDescUI paramFinderActivityDescUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.b<String, kotlin.ah>
  {
    d(FinderActivityDescUI paramFinderActivityDescUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderActivityDescUI
 * JD-Core Version:    0.7.0.1
 */
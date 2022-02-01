package com.tencent.mm.plugin.finder.live.viewmodel.component;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.f;
import com.tencent.mm.plugin.finder.cgi.bs;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.d;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.g;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.plugin.finder.live.report.q.av;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.findersdk.a.bn;
import com.tencent.mm.plugin.h.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.avy;
import com.tencent.mm.protocal.protobuf.bkk;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.tools.b.c.a;
import com.tencent.mm.ui.tools.i;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.picker.CustomOptionPickNew;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.f;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveNoticeUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "MAX_INPUT_LENGTH", "", "getMAX_INPUT_LENGTH", "()I", "MAX_INPUT_SIZE", "getMAX_INPUT_SIZE", "TAG", "", "bottom25A", "", "getBottom25A", "()F", "bottom2A", "getBottom2A", "bottom4A", "getBottom4A", "bottom6A", "getBottom6A", "bottom7_5A", "getBottom7_5A", "contact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "dialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "isCanCreate", "", "isFromProfile", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "mAuthView", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getMAuthView", "()Landroid/widget/ImageView;", "mAuthView$delegate", "Lkotlin/Lazy;", "mAvatarView", "getMAvatarView", "mAvatarView$delegate", "mBackBtn", "Landroid/widget/TextView;", "getMBackBtn", "()Landroid/widget/TextView;", "mBackBtn$delegate", "mBanTipsText", "getMBanTipsText", "mBanTipsText$delegate", "mConfirmBtn", "getMConfirmBtn", "mConfirmBtn$delegate", "mEditLayout", "Landroid/view/View;", "getMEditLayout", "()Landroid/view/View;", "mEditLayout$delegate", "mEditView", "Lcom/tencent/mm/ui/widget/MMEditText;", "getMEditView", "()Lcom/tencent/mm/ui/widget/MMEditText;", "mEditView$delegate", "mLimitText", "getMLimitText", "mLimitText$delegate", "mNameView", "getMNameView", "mNameView$delegate", "mNoticeTimeLayout", "getMNoticeTimeLayout", "mNoticeTimeLayout$delegate", "mNoticeTimeTxt", "getMNoticeTimeTxt", "mNoticeTimeTxt$delegate", "mTipsText", "getMTipsText", "mTipsText$delegate", "scrollContainer", "Landroid/widget/ScrollView;", "getScrollContainer", "()Landroid/widget/ScrollView;", "scrollContainer$delegate", "scrollViewOriginHeight", "selectedNoticeTime", "adjustConfirmBtn", "", "show", "height", "afterCreateNotice", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLiveNoticeResponse;", "checkDoubleLineBreak", "checkTextLimit", "doCreateFinderNotice", "startTime", "getLayoutId", "initData", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateLiveNote", "onDestroy", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "refreshTimeView", "firstIndex", "secIndex", "thirdIndex", "showOrDimissLoading", "cancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "showTipsDialog", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends UIComponent
  implements com.tencent.mm.am.h
{
  private final kotlin.j CAA;
  private final kotlin.j CAB;
  private final kotlin.j CAI;
  private final kotlin.j CAz;
  final int DXw;
  private int EaA;
  private int EaB;
  private final float EaC;
  private final float EaD;
  private final float EaE;
  private final float EaF;
  private final float EaG;
  private final kotlin.j Eaq;
  private final kotlin.j Ear;
  private final kotlin.j Eas;
  private final kotlin.j Eat;
  private final kotlin.j Eau;
  private final kotlin.j Eav;
  private final kotlin.j Eaw;
  private final kotlin.j Eax;
  private final kotlin.j Eay;
  private boolean Eaz;
  private final int MAX_INPUT_SIZE;
  private final String TAG;
  private FinderContact contact;
  private i lKz;
  private boolean phV;
  w rYw;
  
  public d(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(356929);
    this.TAG = "FinderLiveNoticeUIC";
    this.CAI = kotlin.k.cm((kotlin.g.a.a)new h(paramAppCompatActivity));
    this.CAz = kotlin.k.cm((kotlin.g.a.a)new g(paramAppCompatActivity));
    this.CAA = kotlin.k.cm((kotlin.g.a.a)new n(paramAppCompatActivity));
    this.CAB = kotlin.k.cm((kotlin.g.a.a)new f(paramAppCompatActivity));
    this.Eaq = kotlin.k.cm((kotlin.g.a.a)new l(paramAppCompatActivity));
    this.Ear = kotlin.k.cm((kotlin.g.a.a)new k(paramAppCompatActivity));
    this.Eas = kotlin.k.cm((kotlin.g.a.a)new o(paramAppCompatActivity));
    this.Eat = kotlin.k.cm((kotlin.g.a.a)new p(paramAppCompatActivity));
    this.Eau = kotlin.k.cm((kotlin.g.a.a)new j(paramAppCompatActivity));
    this.Eav = kotlin.k.cm((kotlin.g.a.a)new m(paramAppCompatActivity));
    this.Eaw = kotlin.k.cm((kotlin.g.a.a)new q(paramAppCompatActivity));
    this.Eax = kotlin.k.cm((kotlin.g.a.a)new i(paramAppCompatActivity));
    this.Eay = kotlin.k.cm((kotlin.g.a.a)new r(paramAppCompatActivity));
    this.Eaz = true;
    this.MAX_INPUT_SIZE = 60;
    this.DXw = (this.MAX_INPUT_SIZE * 2);
    this.EaC = (paramAppCompatActivity.getResources().getDimensionPixelOffset(p.c.Edge_4A) / com.tencent.mm.cd.a.getScaleSize((Context)paramAppCompatActivity));
    this.EaD = (paramAppCompatActivity.getResources().getDimensionPixelOffset(p.c.Edge_2A) / com.tencent.mm.cd.a.getScaleSize((Context)paramAppCompatActivity));
    this.EaE = (paramAppCompatActivity.getResources().getDimensionPixelOffset(p.c.Edge_7_5_A) / com.tencent.mm.cd.a.getScaleSize((Context)paramAppCompatActivity));
    this.EaF = (paramAppCompatActivity.getResources().getDimensionPixelOffset(p.c.Edge_6A) / com.tencent.mm.cd.a.getScaleSize((Context)paramAppCompatActivity));
    this.EaG = (paramAppCompatActivity.getResources().getDimensionPixelOffset(p.c.Edge_25A) / com.tencent.mm.cd.a.getScaleSize((Context)paramAppCompatActivity));
    AppMethodBeat.o(356929);
  }
  
  private static final CharSequence a(d paramd, CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(357100);
    kotlin.g.b.s.u(paramd, "this$0");
    paramSpanned = paramd.exE().getText();
    String str = paramCharSequence.toString();
    CharSequence localCharSequence = (CharSequence)"\n";
    if (str == null)
    {
      paramd = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(357100);
      throw paramd;
    }
    if (str.contentEquals(localCharSequence))
    {
      kotlin.g.b.s.s(paramSpanned, "text");
      if (n.h((CharSequence)paramSpanned, (CharSequence)"\n"))
      {
        paramd = (CharSequence)"";
        AppMethodBeat.o(357100);
        return paramd;
      }
      paramSpanned = (CharSequence)paramSpanned;
      paramInt1 = 0;
      paramInt2 = 0;
      if (paramInt1 < paramSpanned.length())
      {
        if (paramSpanned.charAt(paramInt1) == '\n') {}
        for (paramInt4 = 1;; paramInt4 = 0)
        {
          paramInt3 = paramInt2;
          if (paramInt4 != 0) {
            paramInt3 = paramInt2 + 1;
          }
          paramInt1 += 1;
          paramInt2 = paramInt3;
          break;
        }
      }
      if (paramInt2 >= 4)
      {
        aa.showTextToast((Context)paramd.getActivity(), paramd.getActivity().getString(p.h.CoX));
        paramd = (CharSequence)"";
        AppMethodBeat.o(357100);
        return paramd;
      }
      AppMethodBeat.o(357100);
      return paramCharSequence;
    }
    AppMethodBeat.o(357100);
    return null;
  }
  
  private static final void a(d paramd)
  {
    AppMethodBeat.i(357045);
    kotlin.g.b.s.u(paramd, "this$0");
    if (paramd.lKz == null)
    {
      paramd.lKz = new i((Activity)paramd.getActivity());
      i locali = paramd.lKz;
      if (locali != null) {
        locali.afIL = new d..ExternalSyntheticLambda8(paramd);
      }
    }
    paramd = paramd.lKz;
    if (paramd != null) {
      paramd.start();
    }
    AppMethodBeat.o(357045);
  }
  
  private static final void a(d paramd, int paramInt, boolean paramBoolean)
  {
    ViewGroup localViewGroup = null;
    AppMethodBeat.i(357036);
    kotlin.g.b.s.u(paramd, "this$0");
    Log.i(paramd.TAG, "onKeyboardHeightChanged, height:" + paramInt + ", isResized:" + paramBoolean);
    Object localObject1;
    label67:
    label79:
    Object localObject2;
    if (paramInt > 0)
    {
      paramInt = 1;
      localObject1 = paramd.exH();
      if (localObject1 != null) {
        break label263;
      }
      localObject1 = null;
      if (!(localObject1 instanceof RelativeLayout.LayoutParams)) {
        break label271;
      }
      localObject1 = (RelativeLayout.LayoutParams)localObject1;
      localObject2 = paramd.exI();
      if (localObject2 != null) {
        break label276;
      }
      localObject2 = null;
      label93:
      if (!(localObject2 instanceof RelativeLayout.LayoutParams)) {
        break label286;
      }
      localObject2 = (RelativeLayout.LayoutParams)localObject2;
      label108:
      localObject3 = paramd.exF();
      if (localObject3 != null) {
        break label292;
      }
      localObject3 = null;
      label122:
      if (!(localObject3 instanceof RelativeLayout.LayoutParams)) {
        break label302;
      }
      localObject3 = (RelativeLayout.LayoutParams)localObject3;
      label137:
      if (paramInt == 0) {
        break label308;
      }
      if (localObject3 != null) {
        ((RelativeLayout.LayoutParams)localObject3).bottomMargin = ((int)paramd.EaF);
      }
      if (localObject1 != null) {
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = ((int)paramd.EaD);
      }
      if (localObject2 != null) {
        ((RelativeLayout.LayoutParams)localObject2).bottomMargin = ((int)paramd.EaD);
      }
      label184:
      localObject3 = paramd.exH();
      if (localObject3 != null) {
        break label354;
      }
    }
    label263:
    label271:
    label276:
    label286:
    label292:
    label302:
    label308:
    label354:
    for (Object localObject3 = null;; localObject3 = ((TextView)localObject3).getParent())
    {
      if ((localObject3 instanceof ViewGroup)) {
        localViewGroup = (ViewGroup)localObject3;
      }
      if (localViewGroup != null)
      {
        localViewGroup.updateViewLayout((View)paramd.exH(), (ViewGroup.LayoutParams)localObject1);
        localViewGroup.updateViewLayout((View)paramd.exI(), (ViewGroup.LayoutParams)localObject2);
      }
      AppMethodBeat.o(357036);
      return;
      paramInt = 0;
      break;
      localObject1 = ((TextView)localObject1).getLayoutParams();
      break label67;
      localObject1 = null;
      break label79;
      localObject2 = ((TextView)localObject2).getLayoutParams();
      break label93;
      localObject2 = null;
      break label108;
      localObject3 = ((View)localObject3).getLayoutParams();
      break label122;
      localObject3 = null;
      break label137;
      if (localObject3 != null) {
        ((RelativeLayout.LayoutParams)localObject3).bottomMargin = ((int)paramd.EaG);
      }
      if (localObject1 != null) {
        ((RelativeLayout.LayoutParams)localObject1).bottomMargin = ((int)paramd.EaE);
      }
      if (localObject2 == null) {
        break label184;
      }
      ((RelativeLayout.LayoutParams)localObject2).bottomMargin = ((int)paramd.EaC);
      break label184;
    }
  }
  
  private static final void a(d paramd, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(357126);
    kotlin.g.b.s.u(paramd, "this$0");
    paramd.exL();
    AppMethodBeat.o(357126);
  }
  
  private static final void a(d paramd, View paramView)
  {
    AppMethodBeat.i(357052);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveNoticeUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramd, "this$0");
    paramd.getActivity().finish();
    paramd.getActivity().overridePendingTransition(com.tencent.mm.plugin.finder.live.p.a.anim_not_change, com.tencent.mm.plugin.finder.live.p.a.sight_slide_bottom_out);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveNoticeUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(357052);
  }
  
  private static final void a(com.tencent.mm.ui.widget.a.j paramj, View paramView)
  {
    AppMethodBeat.i(357113);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramj);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveNoticeUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramj, "$dialog");
    paramj.cyW();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveNoticeUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(357113);
  }
  
  private static final void a(com.tencent.mm.ui.widget.picker.b paramb, ah.f paramf, d paramd, boolean paramBoolean, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    AppMethodBeat.i(357120);
    kotlin.g.b.s.u(paramb, "$optionPicker");
    kotlin.g.b.s.u(paramf, "$triple");
    kotlin.g.b.s.u(paramd, "this$0");
    paramb.hide();
    if (paramBoolean)
    {
      try
      {
        paramb = (List)((kotlin.u)paramf.aqH).bsC;
        if (paramObject1 != null) {
          break label92;
        }
        paramb = new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(357120);
        throw paramb;
      }
      finally
      {
        Log.i(paramd.TAG, paramb.getMessage());
      }
    }
    else
    {
      AppMethodBeat.o(357120);
      return;
    }
    label92:
    int i = kotlin.a.p.a(paramb, (CharSequence)paramObject1);
    paramb = ((ArrayList)((kotlin.u)paramf.aqH).bsD).get(i);
    kotlin.g.b.s.s(paramb, "triple.second[firstChosenIndex]");
    paramb = (List)paramb;
    if (paramObject2 == null)
    {
      paramb = new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(357120);
      throw paramb;
    }
    int j = kotlin.a.p.a(paramb, (CharSequence)paramObject2);
    paramb = ((ArrayList)((kotlin.u)paramf.aqH).aiuN).get(j);
    kotlin.g.b.s.s(paramb, "triple.third[secChosenIndex]");
    paramb = (List)paramb;
    if (paramObject3 == null)
    {
      paramb = new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(357120);
      throw paramb;
    }
    paramd.aD(i, j, kotlin.a.p.a(paramb, (CharSequence)paramObject3));
    AppMethodBeat.o(357120);
  }
  
  private final void aD(int paramInt1, int paramInt2, int paramInt3)
  {
    AppMethodBeat.i(357021);
    Object localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    Object localObject2 = com.tencent.mm.plugin.finder.live.utils.a.euP();
    localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    Object localObject3 = new Date(com.tencent.mm.plugin.finder.live.utils.a.bUu());
    localObject1 = Calendar.getInstance();
    ((Calendar)localObject1).setTime((Date)localObject3);
    ((Calendar)localObject1).set(5, ((Calendar)localObject1).get(5) + paramInt1);
    ((Calendar)localObject1).set(11, 24 - ((List)((ArrayList)((kotlin.u)localObject2).bsD).get(paramInt1)).size() + paramInt2);
    ((Calendar)localObject1).set(12, (12 - ((List)((ArrayList)((kotlin.u)localObject2).aiuN).get(paramInt2)).size() + paramInt3) * 5);
    ((Calendar)localObject1).set(13, 0);
    Log.i(this.TAG, "chosen time:" + ((Calendar)localObject1).getTime() + ",timeInMills:" + ((Calendar)localObject1).getTimeInMillis());
    this.EaA = ((int)(((Calendar)localObject1).getTimeInMillis() / 1000L));
    localObject2 = exG();
    localObject3 = aw.Gjk;
    ((TextView)localObject2).setText((CharSequence)aw.a(((Calendar)localObject1).getTimeInMillis(), null, false, 6));
    AppMethodBeat.o(357021);
  }
  
  private static final void b(d paramd)
  {
    AppMethodBeat.i(357087);
    kotlin.g.b.s.u(paramd, "this$0");
    paramd.aD(1, 12, 0);
    AppMethodBeat.o(357087);
  }
  
  private static final void b(d paramd, View paramView)
  {
    AppMethodBeat.i(357057);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveNoticeUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramd, "this$0");
    paramd.exL();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveNoticeUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(357057);
  }
  
  private static final void c(d paramd)
  {
    AppMethodBeat.i(357105);
    kotlin.g.b.s.u(paramd, "this$0");
    paramd.EaB = paramd.exK().getMeasuredHeight();
    AppMethodBeat.o(357105);
  }
  
  private static final void c(d paramd, View paramView)
  {
    AppMethodBeat.i(357067);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveNoticeUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramd, "this$0");
    int i = paramd.EaA;
    if (paramd.EaA <= 0)
    {
      Log.i(paramd.TAG, "illegel time");
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveNoticeUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(357067);
      return;
    }
    paramd.si(true);
    paramView = new bkk();
    paramView.startTime = i;
    paramView.YSR = paramd.exE().getEditableText().toString();
    localObject = com.tencent.mm.plugin.expt.hellhound.ext.b.b.g.zHI;
    com.tencent.mm.plugin.expt.hellhound.ext.b.b.g.a.LP(i);
    localObject = z.bAW();
    kotlin.g.b.s.s(localObject, "getMyFinderUsername()");
    paramd = ((com.tencent.mm.plugin.h)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class)).el((Context)paramd.getActivity());
    if (paramd == null) {}
    for (paramd = null;; paramd = paramd.fou())
    {
      paramd = new bs((String)localObject, paramView, 0, paramd);
      com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)paramd, 0);
      break;
    }
  }
  
  private static final void d(d paramd, View paramView)
  {
    AppMethodBeat.i(357081);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveNoticeUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramd, "this$0");
    paramView = new com.tencent.mm.ui.widget.a.j((Context)paramd.getContext(), 0, 0);
    paramd = LayoutInflater.from((Context)paramd.getContext()).inflate(p.f.CeN, null);
    kotlin.g.b.s.s(paramd, "from(context).inflate(R.…ice_ui_dialog_tips, null)");
    paramd.findViewById(p.e.icon_btn_close).setOnClickListener(new d..ExternalSyntheticLambda7(paramView));
    paramView.setCustomView(paramd);
    paramView.dDn();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveNoticeUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(357081);
  }
  
  private static final void e(d paramd, View paramView)
  {
    AppMethodBeat.i(357092);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramd);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveNoticeUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramd, "this$0");
    paramd.exE().requestFocus();
    if ((paramd.getActivity() instanceof MMActivity))
    {
      paramd = paramd.getActivity();
      if ((paramd instanceof MMActivity))
      {
        paramd = (MMActivity)paramd;
        if (paramd != null) {
          paramd.showVKB();
        }
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveNoticeUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(357092);
      return;
      paramd = null;
      break;
      paramView = (InputMethodManager)paramd.getActivity().getSystemService("input_method");
      if (paramView != null) {
        paramView.showSoftInput((View)paramd.exE(), 0);
      }
    }
  }
  
  private final MMEditText exE()
  {
    AppMethodBeat.i(356939);
    MMEditText localMMEditText = (MMEditText)this.Eaq.getValue();
    AppMethodBeat.o(356939);
    return localMMEditText;
  }
  
  private final View exF()
  {
    AppMethodBeat.i(356946);
    View localView = (View)this.Ear.getValue();
    AppMethodBeat.o(356946);
    return localView;
  }
  
  private final TextView exG()
  {
    AppMethodBeat.i(356956);
    TextView localTextView = (TextView)this.Eat.getValue();
    AppMethodBeat.o(356956);
    return localTextView;
  }
  
  private final TextView exH()
  {
    AppMethodBeat.i(356963);
    TextView localTextView = (TextView)this.Eau.getValue();
    AppMethodBeat.o(356963);
    return localTextView;
  }
  
  private final TextView exI()
  {
    AppMethodBeat.i(356977);
    TextView localTextView = (TextView)this.Eaw.getValue();
    AppMethodBeat.o(356977);
    return localTextView;
  }
  
  private final TextView exJ()
  {
    AppMethodBeat.i(356988);
    TextView localTextView = (TextView)this.Eax.getValue();
    AppMethodBeat.o(356988);
    return localTextView;
  }
  
  private final ScrollView exK()
  {
    AppMethodBeat.i(356995);
    ScrollView localScrollView = (ScrollView)this.Eay.getValue();
    AppMethodBeat.o(356995);
    return localScrollView;
  }
  
  private final void exL()
  {
    AppMethodBeat.i(357011);
    Log.i(this.TAG, "onCreateLiveNote");
    Object localObject2 = new ah.f();
    Object localObject1 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
    ((ah.f)localObject2).aqH = com.tencent.mm.plugin.finder.live.utils.a.euP();
    localObject1 = new com.tencent.mm.ui.widget.picker.b((Context)getActivity(), (ArrayList)((kotlin.u)((ah.f)localObject2).aqH).bsC, (ArrayList)((kotlin.u)((ah.f)localObject2).aqH).bsD, (ArrayList)((kotlin.u)((ah.f)localObject2).aqH).aiuN);
    if ((((com.tencent.mm.ui.widget.picker.b)localObject1).agjZ != null) && (((com.tencent.mm.ui.widget.picker.b)localObject1).agka != null) && (((com.tencent.mm.ui.widget.picker.b)localObject1).agkb != null))
    {
      ((com.tencent.mm.ui.widget.picker.b)localObject1).agjZ.setValue(1);
      ((com.tencent.mm.ui.widget.picker.b)localObject1).agjZ.aFo(1);
      ((com.tencent.mm.ui.widget.picker.b)localObject1).agka.setOptionsArray(((com.tencent.mm.ui.widget.picker.b)localObject1).aDl(1));
      ((com.tencent.mm.ui.widget.picker.b)localObject1).agka.setValue(12);
      ((com.tencent.mm.ui.widget.picker.b)localObject1).agka.aFo(12);
      ((com.tencent.mm.ui.widget.picker.b)localObject1).agka.invalidate();
      ((com.tencent.mm.ui.widget.picker.b)localObject1).agkb.setOptionsArray(((com.tencent.mm.ui.widget.picker.b)localObject1).aFr(12));
      ((com.tencent.mm.ui.widget.picker.b)localObject1).agkb.setValue(0);
      ((com.tencent.mm.ui.widget.picker.b)localObject1).agkb.aFo(0);
      ((com.tencent.mm.ui.widget.picker.b)localObject1).agkb.invalidate();
    }
    ((com.tencent.mm.ui.widget.picker.b)localObject1).bi((CharSequence)getActivity().getResources().getString(p.h.CoU));
    ((com.tencent.mm.ui.widget.picker.b)localObject1).agkd = new d..ExternalSyntheticLambda9((com.tencent.mm.ui.widget.picker.b)localObject1, (ah.f)localObject2, this);
    localObject2 = LayoutInflater.from((Context)getActivity()).inflate(p.f.Ccx, null);
    kotlin.g.b.s.s(localObject2, "from(activity).inflate(R…live_picker_footer, null)");
    View localView = LayoutInflater.from((Context)getActivity()).inflate(p.f.Cff, null);
    kotlin.g.b.s.s(localView, "from(activity).inflate(R…live_picker_header, null)");
    ((com.tencent.mm.ui.widget.picker.b)localObject1).aFb(getActivity().getResources().getColor(p.b.finder_live_logo_color));
    if (((com.tencent.mm.ui.widget.picker.b)localObject1).nhC != null)
    {
      ((com.tencent.mm.ui.widget.picker.b)localObject1).nhC.setTextColor(((com.tencent.mm.ui.widget.picker.b)localObject1).mContext.getResources().getColor(com.tencent.mm.ck.a.c.color_btn_text_selector));
      ((com.tencent.mm.ui.widget.picker.b)localObject1).nhC.setBackgroundResource(com.tencent.mm.ck.a.e.btn_solid_red);
    }
    ((com.tencent.mm.ui.widget.picker.b)localObject1).aFp(p.d.BzQ);
    ((com.tencent.mm.ui.widget.picker.b)localObject1).setHeaderView(localView);
    if (((com.tencent.mm.ui.widget.picker.b)localObject1).agkh != null)
    {
      if (localObject2 != null) {
        break label380;
      }
      ((com.tencent.mm.ui.widget.picker.b)localObject1).agkh.setVisibility(8);
    }
    for (;;)
    {
      ((com.tencent.mm.ui.widget.picker.b)localObject1).show();
      AppMethodBeat.o(357011);
      return;
      label380:
      ((com.tencent.mm.ui.widget.picker.b)localObject1).agkh.setVisibility(0);
      ((com.tencent.mm.ui.widget.picker.b)localObject1).agkh.removeAllViews();
      ((com.tencent.mm.ui.widget.picker.b)localObject1).agkh.setGravity(17);
      ((com.tencent.mm.ui.widget.picker.b)localObject1).agkh.addView((View)localObject2, new LinearLayout.LayoutParams(-1, -2));
    }
  }
  
  private final void si(boolean paramBoolean)
  {
    AppMethodBeat.i(357027);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new s(paramBoolean, this, null));
    AppMethodBeat.o(357027);
  }
  
  public final int getLayoutId()
  {
    return p.f.CeM;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(357250);
    super.onCreate(paramBundle);
    Object localObject2 = getIntent().getByteArrayExtra("KEY_FINDER_LIVE_NOTICE_CONTACT");
    if (localObject2 != null)
    {
      this.contact = new FinderContact();
      localObject1 = this.contact;
      paramBundle = (Bundle)localObject1;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("contact");
        paramBundle = null;
      }
      paramBundle.parseFrom((byte[])localObject2);
    }
    this.phV = getIntent().getBooleanExtra("KEY_FINDER_LIVE_NOTICE_IS_FROM_PROFILE", false);
    this.Eaz = getIntent().getBooleanExtra("KEY_FINDER_LIVE_NOTICE_IS_CAN_CREATE", true);
    ((TextView)this.CAI.getValue()).setOnClickListener(new d..ExternalSyntheticLambda6(this));
    paramBundle = com.tencent.mm.plugin.finder.loader.p.ExI;
    localObject2 = com.tencent.mm.plugin.finder.loader.p.eCp();
    Object localObject1 = this.contact;
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("contact");
      paramBundle = null;
    }
    paramBundle = new com.tencent.mm.plugin.finder.loader.b(paramBundle.headUrl);
    localObject1 = (ImageView)this.CAz.getValue();
    kotlin.g.b.s.s(localObject1, "mAvatarView");
    Object localObject3 = com.tencent.mm.plugin.finder.loader.p.ExI;
    ((com.tencent.mm.loader.d)localObject2).a(paramBundle, (ImageView)localObject1, com.tencent.mm.plugin.finder.loader.p.a(com.tencent.mm.plugin.finder.loader.p.a.ExM));
    localObject2 = (TextView)this.CAA.getValue();
    localObject3 = (Context)getActivity();
    localObject1 = this.contact;
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("contact");
      paramBundle = null;
    }
    ((TextView)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b((Context)localObject3, (CharSequence)paramBundle.nickname));
    paramBundle = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
    kotlin.g.b.s.s(paramBundle, "service(IFinderCommonService::class.java)");
    localObject2 = (com.tencent.mm.plugin.h)paramBundle;
    localObject3 = (ImageView)this.CAB.getValue();
    kotlin.g.b.s.s(localObject3, "mAuthView");
    localObject1 = this.contact;
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("contact");
      paramBundle = null;
    }
    h.a.a((com.tencent.mm.plugin.h)localObject2, (ImageView)localObject3, paramBundle.authInfo, 0, null, 12);
    ((View)this.Eas.getValue()).setOnClickListener(new d..ExternalSyntheticLambda2(this));
    exH().setOnClickListener(new d..ExternalSyntheticLambda4(this));
    exI().setOnClickListener(new d..ExternalSyntheticLambda3(this));
    exG().post(new d..ExternalSyntheticLambda10(this));
    exF().setOnClickListener(new d..ExternalSyntheticLambda5(this));
    exE().a(null, null, LocaleUtil.getCurrentLanguage((Context)getContext()), (com.tencent.mm.ui.widget.edittext.a.e)new d(this));
    paramBundle = new d..ExternalSyntheticLambda1(this);
    localObject1 = (InputFilter)new com.tencent.mm.ui.tools.g(this.DXw, com.tencent.mm.ui.tools.g.a.afII);
    exE().setFilters(new InputFilter[] { paramBundle, localObject1 });
    exE().addTextChangedListener((TextWatcher)new e(this));
    exK().post(new d..ExternalSyntheticLambda12(this));
    if (this.Eaz)
    {
      exH().setVisibility(0);
      exI().setVisibility(0);
      exJ().setVisibility(4);
    }
    for (;;)
    {
      com.tencent.mm.kernel.h.aZW().a(6653, (com.tencent.mm.am.h)this);
      AppMethodBeat.o(357250);
      return;
      exH().setVisibility(4);
      exI().setVisibility(4);
      exJ().setVisibility(0);
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(357267);
    super.onDestroy();
    com.tencent.mm.kernel.h.aZW().b(6653, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(357267);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(357261);
    super.onPause();
    i locali = this.lKz;
    if (locali != null) {
      locali.close();
    }
    AppMethodBeat.o(357261);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(357255);
    super.onResume();
    Object localObject = getActivity().getWindow();
    if (localObject != null)
    {
      localObject = ((Window)localObject).getDecorView();
      if (localObject != null) {
        ((View)localObject).post(new d..ExternalSyntheticLambda11(this));
      }
    }
    AppMethodBeat.o(357255);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    avy localavy = null;
    AppMethodBeat.i(357280);
    Log.i(this.TAG, "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    si(false);
    if ((paramp instanceof bs))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        localavy = ((bs)paramp).dVD();
        if (localavy != null)
        {
          paramString = localavy.live_notice_info;
          if (paramString != null) {
            ((com.tencent.mm.plugin.g)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.g.class)).a(paramString);
          }
        }
        com.tencent.mm.plugin.finder.live.report.j localj;
        q.av localav;
        if (this.phV)
        {
          com.tencent.mm.ae.d.a(500L, (kotlin.g.a.a)new a(localavy, this));
          if (localavy.live_notice_info != null)
          {
            localj = com.tencent.mm.plugin.finder.live.report.j.Dob;
            localav = q.av.DzS;
            paramString = localavy.live_notice_info;
            if (paramString != null) {
              break label394;
            }
            paramInt1 = 0;
            label170:
            long l = paramInt1;
            paramString = localavy.live_notice_info;
            if (paramString != null) {
              break label402;
            }
            paramString = "";
            label188:
            localj.a(localav, String.valueOf(l * 1000L), paramString);
          }
          localj = com.tencent.mm.plugin.finder.live.report.j.Dob;
          localav = q.av.DzT;
          paramString = localavy.live_notice_info;
          if (paramString != null) {
            break label423;
          }
          paramString = "";
        }
        for (;;)
        {
          localj.a(localav, "", paramString);
          AppMethodBeat.o(357280);
          return;
          paramp = new Intent();
          paramp.putExtra("finder_username", z.bAW());
          paramp.putExtra("KEY_FINDER_SELF_FLAG", true);
          if (localavy == null) {
            paramString = null;
          }
          for (;;)
          {
            paramp.putExtra("KEY_FINDER_LIVE_NOTICE_INFO", paramString);
            paramString = com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.h.class);
            kotlin.g.b.s.s(paramString, "service(IFinderCommonService::class.java)");
            h.a.a((com.tencent.mm.plugin.h)paramString, (Context)getActivity(), paramp, 0, 124);
            ((f)com.tencent.mm.kernel.h.ax(f.class)).enterFinderProfileUI((Context)getActivity(), paramp);
            com.tencent.mm.ae.d.a(500L, (kotlin.g.a.a)new b(this));
            break;
            paramString = localavy.live_notice_info;
            if (paramString == null) {
              paramString = null;
            } else {
              paramString = paramString.toByteArray();
            }
          }
          label394:
          paramInt1 = paramString.startTime;
          break label170;
          label402:
          paramp = paramString.YSR;
          paramString = paramp;
          if (paramp != null) {
            break label188;
          }
          paramString = "";
          break label188;
          label423:
          paramp = paramString.YSR;
          paramString = paramp;
          if (paramp == null) {
            paramString = "";
          }
        }
      }
      if (paramString != null) {
        break label493;
      }
      paramString = localavy;
    }
    for (;;)
    {
      label451:
      if (paramString == null)
      {
        paramString = (d)this;
        aa.y((Context)paramString.getActivity(), paramString.getActivity().getResources().getString(p.h.CoV), p.g.icons_filled_info);
      }
      AppMethodBeat.o(357280);
      return;
      label493:
      if (((CharSequence)paramString).length() > 0)
      {
        paramInt1 = 1;
        label507:
        if (paramInt1 == 0) {
          break label585;
        }
      }
      label585:
      for (paramp = paramString;; paramp = null)
      {
        paramString = localavy;
        if (paramp == null) {
          break;
        }
        switch (paramInt2)
        {
        default: 
          paramString = aa.makeText((Context)getContext(), (CharSequence)paramp, 0);
          paramString.setGravity(17, 0, 0);
          paramString.show();
          paramString = ah.aiuX;
          break label451;
          paramInt1 = 0;
          break label507;
        }
      }
      paramString = com.tencent.mm.ui.base.k.a((Context)getContext(), paramp, null, false, new d..ExternalSyntheticLambda0(this));
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    a(avy paramavy, d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    b(d paramd)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveNoticeUIC$checkTextLimit$1", "Lcom/tencent/mm/ui/tools/legalchecker/InputTextBoundaryCheck$DoAfterCheck;", "doWhenLess", "", "text", "", "doWhenMore", "doWhenOK", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements c.a
  {
    c(d paramd) {}
    
    public final void Tw(String paramString)
    {
      AppMethodBeat.i(357077);
      int i = kotlin.k.k.qu(com.tencent.mm.ui.tools.g.ej(this.EaI.DXw, paramString) / 2, 0);
      d.g(this.EaI).setText((CharSequence)String.valueOf(i));
      AppMethodBeat.o(357077);
    }
    
    public final void Tx(String paramString) {}
    
    public final void eY(String paramString)
    {
      AppMethodBeat.i(357070);
      d.g(this.EaI).setText((CharSequence)"0");
      AppMethodBeat.o(357070);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveNoticeUIC$initView$7", "Lcom/tencent/mm/ui/widget/edittext/SelectableEditTextHelper$OnMenuCallback;", "onMenuInit", "", "items", "", "Lcom/tencent/mm/ui/widget/edittext/SelectableEditTextHelper$MenuItem;", "visibleFlag", "", "onMenuItemClicked", "v", "Landroid/view/View;", "item", "curSelect", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    implements com.tencent.mm.ui.widget.edittext.a.e
  {
    d(d paramd) {}
    
    public final void I(List<com.tencent.mm.ui.widget.edittext.a.c> paramList, int paramInt)
    {
      AppMethodBeat.i(357064);
      if ((paramInt != 8) && (paramInt != 1))
      {
        kotlin.g.b.s.checkNotNull(paramList);
        paramList.add(new com.tencent.mm.ui.widget.edittext.a.c(this.EaI.getContext().getString(p.h.Cuy), 4));
      }
      AppMethodBeat.o(357064);
    }
    
    public final void a(View paramView, com.tencent.mm.ui.widget.edittext.a.c paramc, String paramString)
    {
      AppMethodBeat.i(357072);
      if ((paramc != null) && (paramc.id == 4)) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          d.d(this.EaI).append((CharSequence)"\n");
        }
        AppMethodBeat.o(357072);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveNoticeUIC$initView$8", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "p0", "", "p1", "", "p2", "p3", "onTextChanged", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    implements TextWatcher
  {
    e(d paramd) {}
    
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(357065);
      d.e(this.EaI);
      d.f(this.EaI);
      AppMethodBeat.o(357065);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ImageView>
  {
    f(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ImageView>
  {
    g(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends kotlin.g.b.u
    implements kotlin.g.a.a<TextView>
  {
    h(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends kotlin.g.b.u
    implements kotlin.g.a.a<TextView>
  {
    i(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends kotlin.g.b.u
    implements kotlin.g.a.a<TextView>
  {
    j(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class k
    extends kotlin.g.b.u
    implements kotlin.g.a.a<View>
  {
    k(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMEditText;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class l
    extends kotlin.g.b.u
    implements kotlin.g.a.a<MMEditText>
  {
    l(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends kotlin.g.b.u
    implements kotlin.g.a.a<TextView>
  {
    m(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends kotlin.g.b.u
    implements kotlin.g.a.a<TextView>
  {
    n(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class o
    extends kotlin.g.b.u
    implements kotlin.g.a.a<View>
  {
    o(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class p
    extends kotlin.g.b.u
    implements kotlin.g.a.a<TextView>
  {
    p(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class q
    extends kotlin.g.b.u
    implements kotlin.g.a.a<TextView>
  {
    q(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ScrollView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class r
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ScrollView>
  {
    r(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class s
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    s(boolean paramBoolean, d paramd, DialogInterface.OnCancelListener paramOnCancelListener)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.component.d
 * JD-Core Version:    0.7.0.1
 */
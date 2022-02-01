package com.tencent.mm.plugin.finder.activity.uic;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.cgi.dh;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.view.q;
import com.tencent.mm.plugin.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityPostUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "activityDesc", "", "activityName", "activityType", "", "announceTv", "Landroid/widget/TextView;", "avatarImage", "Landroid/widget/ImageView;", "cancelBtn", "cndCoverUrl", "descEdit", "Lcom/tencent/mm/ui/widget/MMEditText;", "descMaxPaddingBottom", "descMinPaddingBottom", "descWordHintText", "endTime", "", "endTimeContent", "errorTipsLayout", "Landroid/view/View;", "kotlin.jvm.PlatformType", "getErrorTipsLayout", "()Landroid/view/View;", "errorTipsLayout$delegate", "Lkotlin/Lazy;", "errorTipsTextView", "getErrorTipsTextView", "()Landroid/widget/TextView;", "errorTipsTextView$delegate", "isCoverSet", "", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "localCoverUrl", "nameEdit", "nameWordHintText", "nickName", "nickNameText", "postBtn", "Landroid/widget/Button;", "postBtnMinMarginTop", "getPostBtnMinMarginTop", "()I", "postBtnMinMarginTop$delegate", "postBtnOriginMarginTop", "getPostBtnOriginMarginTop", "postBtnOriginMarginTop$delegate", "scrollView", "Landroid/widget/ScrollView;", "selectTimeText", "selectedDateIndex", "selectedHourIndex", "titleText", "userName", "animateDesc", "", "isBig", "cancelActivity", "checkPost", "doPost", "doScene", "task", "Lcom/tencent/mm/loader/loader/IWorkTask;", "getActivityName", "getYearCount", "initEdit", "initSelectTime", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onGetTopicIdSuccess", "eventTopicId", "onKeyboardHeightChanged", "height", "isResized", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "setAnnounceView", "isCovered", "setCoverStyle", "setNormalStyle", "setTextColor", "color", "showErrorTips", "isShow", "showTimePicker", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends UIComponent
  implements com.tencent.mm.am.h, com.tencent.mm.ui.tools.h
{
  private static final j<Integer> AvD;
  public static final a Avh;
  private String AtM;
  private ImageView AuC;
  private TextView AuF;
  private final j AvA;
  private final j AvB;
  private final j AvC;
  private String Ava;
  private TextView Avi;
  private MMEditText Avj;
  private MMEditText Avk;
  private Button Avl;
  private TextView Avm;
  private TextView Avn;
  private TextView Avo;
  private TextView Avp;
  private String Avq;
  private int Avr;
  private int Avs;
  private int Avt;
  private int Avu;
  private boolean Avv;
  private String Avw;
  private String Avx;
  private int Avy;
  private final j Avz;
  private long endTime;
  private ScrollView lDL;
  private com.tencent.mm.ui.tools.i lKz;
  private String nickName;
  private TextView pOq;
  private String userName;
  
  static
  {
    AppMethodBeat.i(348419);
    Avh = new a((byte)0);
    AvD = kotlin.k.cm((kotlin.g.a.a)b.AvE);
    AppMethodBeat.o(348419);
  }
  
  public e(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(348172);
    this.Avq = "";
    this.nickName = "";
    this.userName = "";
    this.AtM = "";
    this.Ava = "";
    this.Avw = "";
    this.Avx = "";
    this.Avy = 101;
    this.Avz = kotlin.k.cm((kotlin.g.a.a)new h(this));
    this.AvA = kotlin.k.cm((kotlin.g.a.a)new i(this));
    this.AvB = kotlin.k.cm((kotlin.g.a.a)new d(this));
    this.AvC = kotlin.k.cm((kotlin.g.a.a)new e(this));
    AppMethodBeat.o(348172);
  }
  
  private final void J(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(348271);
    if (paramBoolean)
    {
      dTA().setVisibility(0);
      switch (paramInt)
      {
      default: 
        dTB().setText(com.tencent.mm.plugin.finder.e.h.finder_activity_create_unknown_failed);
        AppMethodBeat.o(348271);
        return;
      case -4055: 
        dTB().setText(com.tencent.mm.plugin.finder.e.h.finder_activity_create_failed_has_existed);
        AppMethodBeat.o(348271);
        return;
      }
      dTB().setText(com.tencent.mm.plugin.finder.e.h.finder_activity_create_failed_character_error);
      AppMethodBeat.o(348271);
      return;
    }
    dTA().setVisibility(8);
    AppMethodBeat.o(348271);
  }
  
  private static final void a(e parame, int paramInt1, int paramInt2, int paramInt3, ValueAnimator paramValueAnimator)
  {
    AppMethodBeat.i(348340);
    kotlin.g.b.s.u(parame, "this$0");
    paramValueAnimator = paramValueAnimator.getAnimatedValue();
    if (paramValueAnimator == null)
    {
      parame = new NullPointerException("null cannot be cast to non-null type kotlin.Int");
      AppMethodBeat.o(348340);
      throw parame;
    }
    int i = ((Integer)paramValueAnimator).intValue();
    paramValueAnimator = parame.Avk;
    parame = paramValueAnimator;
    if (paramValueAnimator == null)
    {
      kotlin.g.b.s.bIx("descEdit");
      parame = null;
    }
    parame.setPadding(paramInt1, paramInt2, paramInt3, i);
    AppMethodBeat.o(348340);
  }
  
  private static final void a(e parame, View paramView)
  {
    AppMethodBeat.i(348305);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parame);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/activity/uic/FinderActivityPostUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parame, "this$0");
    paramView = (Intent)parame.getIntent().clone();
    Log.i("SimpleUIComponent", "cancelActivity");
    parame = parame.getActivity();
    parame.setResult(-1, paramView);
    if (!parame.isFinishing()) {
      parame.finish();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/activity/uic/FinderActivityPostUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(348305);
  }
  
  private static final void a(com.tencent.mm.ui.widget.picker.b paramb, e parame, kotlin.r paramr, boolean paramBoolean, Object paramObject1, Object paramObject2, Object paramObject3)
  {
    AppMethodBeat.i(348358);
    kotlin.g.b.s.u(paramb, "$timePicker");
    kotlin.g.b.s.u(parame, "this$0");
    kotlin.g.b.s.u(paramr, "$timePair");
    paramb.hide();
    if (paramBoolean)
    {
      paramb = (List)paramr.bsC;
      if (paramObject1 == null)
      {
        paramb = new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(348358);
        throw paramb;
      }
      parame.Avr = kotlin.a.p.a(paramb, (CharSequence)paramObject1);
      paramb = ((ArrayList)paramr.bsD).get(parame.Avr);
      kotlin.g.b.s.s(paramb, "timePair.second[selectedDateIndex]");
      paramb = (List)paramb;
      if (paramObject2 == null)
      {
        paramb = new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(348358);
        throw paramb;
      }
      parame.Avs = kotlin.a.p.a(paramb, (CharSequence)paramObject2);
      paramb = av.GiL;
      paramb = new Date(av.bUu());
      paramObject3 = Calendar.getInstance();
      paramObject3.setTime(paramb);
      paramObject3.set(5, paramObject3.get(5) + parame.Avr);
      paramObject3.set(11, 24 - ((List)((ArrayList)paramr.bsD).get(parame.Avr)).size() + parame.Avs);
      paramObject3.set(12, 0);
      paramObject3.set(13, 0);
      Log.i("SimpleUIComponent", "chosen time:" + paramObject3.getTime() + ",timeInMills:" + paramObject3.getTimeInMillis());
      parame.endTime = (paramObject3.getTimeInMillis() / 1000L);
      parame.Avq = (paramObject1 + ' ' + paramObject2);
      paramb = parame.Avm;
      if (paramb != null) {
        break label358;
      }
      kotlin.g.b.s.bIx("selectTimeText");
      paramb = null;
    }
    label358:
    for (;;)
    {
      paramb.setText((CharSequence)parame.Avq);
      AppMethodBeat.o(348358);
      return;
    }
  }
  
  private static final boolean a(e parame, View paramView, MotionEvent paramMotionEvent)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(348367);
    kotlin.g.b.s.u(parame, "this$0");
    MMEditText localMMEditText2 = parame.Avj;
    MMEditText localMMEditText1 = localMMEditText2;
    if (localMMEditText2 == null)
    {
      kotlin.g.b.s.bIx("nameEdit");
      localMMEditText1 = null;
    }
    label95:
    label99:
    label103:
    int i;
    if (!kotlin.g.b.s.p(paramView, localMMEditText1))
    {
      localMMEditText2 = parame.Avk;
      localMMEditText1 = localMMEditText2;
      if (localMMEditText2 == null)
      {
        kotlin.g.b.s.bIx("descEdit");
        localMMEditText1 = null;
      }
      if (!kotlin.g.b.s.p(paramView, localMMEditText1)) {}
    }
    else
    {
      if (paramMotionEvent != null) {
        break label140;
      }
      paramView = null;
      if (paramView != null) {
        break label151;
      }
      if (paramView != null) {
        break label187;
      }
      if (paramView != null) {
        break label200;
      }
      i = 0;
      label105:
      if (i != 0)
      {
        parame = parame.lDL;
        if (parame != null) {
          break label213;
        }
        kotlin.g.b.s.bIx("scrollView");
        parame = localObject1;
      }
    }
    label140:
    label151:
    label187:
    label200:
    label213:
    for (;;)
    {
      parame.requestDisallowInterceptTouchEvent(false);
      AppMethodBeat.o(348367);
      return false;
      paramView = Integer.valueOf(paramMotionEvent.getActionMasked());
      break;
      if (paramView.intValue() != 0) {
        break label95;
      }
      parame = parame.lDL;
      if (parame == null)
      {
        kotlin.g.b.s.bIx("scrollView");
        parame = localObject2;
      }
      for (;;)
      {
        parame.requestDisallowInterceptTouchEvent(true);
        break;
      }
      if (paramView.intValue() != 3) {
        break label99;
      }
      i = 1;
      break label105;
      if (paramView.intValue() != 1) {
        break label103;
      }
      i = 1;
      break label105;
    }
  }
  
  private static final void b(e parame)
  {
    AppMethodBeat.i(348292);
    kotlin.g.b.s.u(parame, "this$0");
    com.tencent.mm.ui.tools.i locali = parame.lKz;
    parame = locali;
    if (locali == null)
    {
      kotlin.g.b.s.bIx("keyboardHeightProvider");
      parame = null;
    }
    parame.start();
    AppMethodBeat.o(348292);
  }
  
  private static final void b(e parame, View paramView)
  {
    AppMethodBeat.i(348323);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parame);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/activity/uic/FinderActivityPostUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parame, "this$0");
    parame.J(false, 0);
    localObject = parame.Avj;
    paramView = (View)localObject;
    if (localObject == null)
    {
      kotlin.g.b.s.bIx("nameEdit");
      paramView = null;
    }
    boolean bool1 = Util.isNullOrNil((CharSequence)paramView.getText());
    localObject = parame.Avk;
    paramView = (View)localObject;
    if (localObject == null)
    {
      kotlin.g.b.s.bIx("descEdit");
      paramView = null;
    }
    boolean bool2 = Util.isNullOrNil((CharSequence)paramView.getText());
    boolean bool3 = Util.isNullOrNil(parame.Avq);
    int i;
    if ((bool1) || (bool3) || (bool2))
    {
      if (bool1)
      {
        localObject = parame.Avj;
        paramView = (View)localObject;
        if (localObject == null)
        {
          kotlin.g.b.s.bIx("nameEdit");
          paramView = null;
        }
        paramView.setHintTextColor(parame.getResources().getColor(com.tencent.mm.plugin.finder.e.b.Red));
      }
      if (bool2)
      {
        localObject = parame.Avk;
        paramView = (View)localObject;
        if (localObject == null)
        {
          kotlin.g.b.s.bIx("descEdit");
          paramView = null;
        }
        paramView.setHintTextColor(parame.getResources().getColor(com.tencent.mm.plugin.finder.e.b.Red));
      }
      if (bool3)
      {
        localObject = parame.Avm;
        paramView = (View)localObject;
        if (localObject == null)
        {
          kotlin.g.b.s.bIx("selectTimeText");
          paramView = null;
        }
        paramView.setHintTextColor(parame.getResources().getColor(com.tencent.mm.plugin.finder.e.b.Red));
      }
      i = 0;
      if (i != 0) {
        break label332;
      }
      Log.i("SimpleUIComponent", "doPost: check post fail");
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/activity/uic/FinderActivityPostUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(348323);
      return;
      i = 1;
      break;
      label332:
      paramView = com.tencent.mm.ui.component.k.aeZF;
      if (((f)com.tencent.mm.ui.component.k.d(parame.getActivity()).q(f.class)).AvR)
      {
        paramView = com.tencent.mm.ui.component.k.aeZF;
        parame.Avx = ((f)com.tencent.mm.ui.component.k.d(parame.getActivity()).q(f.class)).AvQ;
      }
      paramView = com.tencent.mm.ui.component.k.aeZF;
      ((f)com.tencent.mm.ui.component.k.d(parame.getActivity()).q(f.class)).showProgress();
      if (Util.isNullOrNil(parame.Avx)) {
        parame.e(null);
      } else {
        ((com.tencent.mm.plugin.finder.publish.c)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.finder.publish.c.class)).finderPostManager().E(parame.Avx, new c(parame));
      }
    }
  }
  
  private static final void c(e parame, View paramView)
  {
    AppMethodBeat.i(348333);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parame);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/activity/uic/FinderActivityPostUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(parame, "this$0");
    parame.dTC();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/activity/uic/FinderActivityPostUIC", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(348333);
  }
  
  private final View dTA()
  {
    AppMethodBeat.i(348187);
    View localView = (View)this.AvB.getValue();
    AppMethodBeat.o(348187);
    return localView;
  }
  
  private final TextView dTB()
  {
    AppMethodBeat.i(348195);
    TextView localTextView = (TextView)this.AvC.getValue();
    AppMethodBeat.o(348195);
    return localTextView;
  }
  
  private final void dTC()
  {
    AppMethodBeat.i(348234);
    Object localObject1 = av.GiL;
    localObject1 = (Context)getActivity();
    Object localObject2 = com.tencent.mm.plugin.finder.storage.d.FAy;
    int m = ((Number)com.tencent.mm.plugin.finder.storage.d.eWd().bmg()).intValue();
    kotlin.g.b.s.u(localObject1, "context");
    Object localObject3 = new Date(av.bUu());
    Object localObject4 = Calendar.getInstance();
    localObject2 = new ArrayList();
    int i;
    if ((((Date)localObject3).getHours() >= 23) && (((Date)localObject3).getMinutes() >= 55))
    {
      i = 1;
      if (i >= m) {}
    }
    int k;
    for (int j = i;; j = k)
    {
      k = j + 1;
      ((Calendar)localObject4).setTime((Date)localObject3);
      ((Calendar)localObject4).set(5, ((Calendar)localObject4).get(5) + j);
      int n = ((Calendar)localObject4).get(5);
      int i1 = ((Calendar)localObject4).get(2) + 1;
      if (j == i) {
        ((ArrayList)localObject2).add(MMApplicationContext.getContext().getResources().getString(com.tencent.mm.plugin.finder.e.h.fmt_pre_nowday));
      }
      for (;;)
      {
        label169:
        if (k >= m)
        {
          localObject1 = ((Iterable)localObject2).iterator();
          for (;;)
          {
            if (((Iterator)localObject1).hasNext())
            {
              Log.i("getNoticePicker", (String)((Iterator)localObject1).next());
              continue;
              i = 0;
              break;
              if (j == i + 1)
              {
                ((ArrayList)localObject2).add(MMApplicationContext.getContext().getResources().getString(com.tencent.mm.plugin.finder.e.h.finder_live_notice_date_format, new Object[] { Integer.valueOf(i1), Integer.valueOf(n) }) + ' ' + MMApplicationContext.getContext().getResources().getString(com.tencent.mm.plugin.finder.e.h.fmt_pre_tomorrow));
                break label169;
              }
              if (j == i + 2)
              {
                ((ArrayList)localObject2).add(MMApplicationContext.getContext().getResources().getString(com.tencent.mm.plugin.finder.e.h.finder_live_notice_date_format, new Object[] { Integer.valueOf(i1), Integer.valueOf(n) }) + ' ' + MMApplicationContext.getContext().getResources().getString(com.tencent.mm.plugin.finder.e.h.fmt_pre_dayaftertomorrow));
                break label169;
              }
              j = ((Calendar)localObject4).get(7);
              if (j - 2 < 0) {
                j = 7;
              }
              for (;;)
              {
                ((ArrayList)localObject2).add(MMApplicationContext.getContext().getResources().getString(com.tencent.mm.plugin.finder.e.h.finder_live_notice_date_format, new Object[] { Integer.valueOf(i1), Integer.valueOf(n) }) + ' ' + com.tencent.mm.plugin.finder.utils.r.h((Context)localObject1, j, "campaign"));
                break;
                j -= 1;
              }
            }
          }
          localObject2 = new kotlin.r(localObject2, ((g)com.tencent.mm.kernel.h.ax(g.class)).eZ(((ArrayList)localObject2).size(), com.tencent.mm.plugin.finder.e.h.finder_campaign_time_picker_hour));
          localObject1 = new com.tencent.mm.ui.widget.picker.b((Context)getActivity(), (ArrayList)((kotlin.r)localObject2).bsC, (ArrayList)((kotlin.r)localObject2).bsD);
          localObject3 = Calendar.getInstance();
          localObject4 = av.GiL;
          ((Calendar)localObject3).setTimeInMillis(av.bUu());
          ((com.tencent.mm.ui.widget.picker.b)localObject1).oY(this.Avr, this.Avs);
          ((com.tencent.mm.ui.widget.picker.b)localObject1).bi((CharSequence)getActivity().getResources().getString(com.tencent.mm.plugin.finder.e.h.finder_live_create_visitor_confirm_btn));
          ((com.tencent.mm.ui.widget.picker.b)localObject1).agkd = new e..ExternalSyntheticLambda5((com.tencent.mm.ui.widget.picker.b)localObject1, this, (kotlin.r)localObject2);
          localObject2 = LayoutInflater.from((Context)getActivity()).inflate(com.tencent.mm.plugin.finder.e.f.finder_campaign_time_picker_header, null);
          kotlin.g.b.s.s(localObject2, "from(activity).inflate(R…time_picker_header, null)");
          ((com.tencent.mm.ui.widget.picker.b)localObject1).setHeaderView((View)localObject2);
          ((com.tencent.mm.ui.widget.picker.b)localObject1).aFb(getActivity().getResources().getColor(com.tencent.mm.plugin.finder.e.b.ORANGE));
          ((com.tencent.mm.ui.widget.picker.b)localObject1).aFp(com.tencent.mm.plugin.finder.e.d.btn_solid_orange);
          ((com.tencent.mm.ui.widget.picker.b)localObject1).show();
          AppMethodBeat.o(348234);
          return;
        }
      }
    }
  }
  
  private final int dTz()
  {
    AppMethodBeat.i(348178);
    int i = ((Number)this.Avz.getValue()).intValue();
    AppMethodBeat.o(348178);
    return i;
  }
  
  private final void e(com.tencent.mm.loader.f.c paramc)
  {
    AppMethodBeat.i(348253);
    String str = getActivityName();
    MMEditText localMMEditText = this.Avk;
    Object localObject = localMMEditText;
    if (localMMEditText == null)
    {
      kotlin.g.b.s.bIx("descEdit");
      localObject = null;
    }
    localObject = ((MMEditText)localObject).getText().toString();
    if ((paramc instanceof com.tencent.mm.plugin.finder.upload.k)) {}
    for (paramc = ((com.tencent.mm.plugin.finder.upload.k)paramc).coverUrl;; paramc = "")
    {
      this.Avw = paramc;
      com.tencent.mm.kernel.h.aZW().a(4050, (com.tencent.mm.am.h)this);
      com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)new dh(this.userName, str, (String)localObject, this.Avw, this.endTime, 0, 32), 0);
      AppMethodBeat.o(348253);
      return;
    }
  }
  
  private final String getActivityName()
  {
    AppMethodBeat.i(348244);
    MMEditText localMMEditText = this.Avj;
    Object localObject = localMMEditText;
    if (localMMEditText == null)
    {
      kotlin.g.b.s.bIx("nameEdit");
      localObject = null;
    }
    localObject = ((MMEditText)localObject).getText().toString();
    AppMethodBeat.o(348244);
    return localObject;
  }
  
  private final void pA(boolean paramBoolean)
  {
    AppMethodBeat.i(348210);
    Object localObject = getContext().getResources().getString(com.tencent.mm.plugin.finder.e.h.finder_activity_announce_name);
    kotlin.g.b.s.s(localObject, "context.resources.getStr…r_activity_announce_name)");
    String str = getResources().getString(com.tencent.mm.plugin.finder.e.h.finder_activity_post_announce, new Object[] { localObject });
    kotlin.g.b.s.s(str, "resources.getString(R.st…t_announce, announceName)");
    SpannableString localSpannableString = new SpannableString((CharSequence)str);
    TextView localTextView;
    if (paramBoolean)
    {
      localTextView = this.Avn;
      if (localTextView != null) {
        localTextView.setTextColor(getResources().getColor(com.tencent.mm.plugin.finder.e.b.BW_100_Alpha_0_5));
      }
    }
    for (;;)
    {
      localSpannableString.setSpan(new q(str, getResources().getColor(com.tencent.mm.plugin.finder.e.b.hot_tab_stream_link_color), getContext().getResources().getColor(com.tencent.mm.plugin.finder.e.b.transparent), false, (kotlin.g.a.b)new j(this)), str.length() - ((String)localObject).length(), str.length(), 17);
      localObject = this.Avn;
      if (localObject != null) {
        ((TextView)localObject).setOnTouchListener((View.OnTouchListener)new com.tencent.mm.pluginsdk.ui.span.s((Context)getContext()));
      }
      localObject = this.Avn;
      if (localObject != null) {
        ((TextView)localObject).setText((CharSequence)localSpannableString);
      }
      AppMethodBeat.o(348210);
      return;
      localTextView = this.Avn;
      if (localTextView != null) {
        localTextView.setTextColor(getResources().getColor(com.tencent.mm.plugin.finder.e.b.FG_1));
      }
    }
  }
  
  private final void setTextColor(int paramInt)
  {
    Object localObject2 = null;
    AppMethodBeat.i(348259);
    Object localObject3 = this.Avj;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("nameEdit");
      localObject1 = null;
    }
    ((MMEditText)localObject1).setTextColor(paramInt);
    localObject3 = this.Avk;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("descEdit");
      localObject1 = null;
    }
    ((MMEditText)localObject1).setTextColor(paramInt);
    localObject3 = this.Avi;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("titleText");
      localObject1 = null;
    }
    ((TextView)localObject1).setTextColor(paramInt);
    localObject3 = this.pOq;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("cancelBtn");
      localObject1 = null;
    }
    ((TextView)localObject1).setTextColor(paramInt);
    localObject1 = this.Avm;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("selectTimeText");
      localObject1 = localObject2;
    }
    for (;;)
    {
      ((TextView)localObject1).setTextColor(paramInt);
      AppMethodBeat.o(348259);
      return;
    }
  }
  
  public final void dTq()
  {
    Object localObject2 = null;
    AppMethodBeat.i(348527);
    this.Avv = true;
    int i = getResources().getColor(com.tencent.mm.plugin.finder.e.b.finder_activity_covered_white);
    Object localObject3 = this.AuF;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("nickNameText");
      localObject1 = null;
    }
    ((TextView)localObject1).setTextColor(getResources().getColor(com.tencent.mm.plugin.finder.e.b.BW_100_Alpha_0_8));
    setTextColor(i);
    localObject3 = this.Avj;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("nameEdit");
      localObject1 = null;
    }
    ((MMEditText)localObject1).setBackgroundResource(com.tencent.mm.plugin.finder.e.d.finder_post_activity_edit_covered_bg);
    localObject3 = this.Avk;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("descEdit");
      localObject1 = null;
    }
    ((MMEditText)localObject1).setBackgroundResource(com.tencent.mm.plugin.finder.e.d.finder_post_activity_edit_covered_bg);
    localObject3 = this.Avm;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("selectTimeText");
      localObject1 = null;
    }
    ((TextView)localObject1).setBackgroundResource(com.tencent.mm.plugin.finder.e.d.finder_post_activity_edit_covered_bg);
    localObject3 = this.Avj;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("nameEdit");
      localObject1 = null;
    }
    ((MMEditText)localObject1).setHintTextColor(getResources().getColor(com.tencent.mm.plugin.finder.e.b.finder_activity_text_covered_hint));
    localObject3 = this.Avk;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("descEdit");
      localObject1 = null;
    }
    ((MMEditText)localObject1).setHintTextColor(getResources().getColor(com.tencent.mm.plugin.finder.e.b.finder_activity_text_covered_hint));
    localObject1 = this.Avm;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("selectTimeText");
      localObject1 = localObject2;
    }
    for (;;)
    {
      ((TextView)localObject1).setHintTextColor(getResources().getColor(com.tencent.mm.plugin.finder.e.b.finder_activity_text_covered_hint));
      pA(true);
      AppMethodBeat.o(348527);
      return;
    }
  }
  
  public final void dTr()
  {
    Object localObject2 = null;
    AppMethodBeat.i(348535);
    this.Avv = false;
    setTextColor(getResources().getColor(com.tencent.mm.plugin.finder.e.b.black_color));
    Object localObject3 = this.AuF;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("nickNameText");
      localObject1 = null;
    }
    ((TextView)localObject1).setTextColor(getResources().getColor(com.tencent.mm.plugin.finder.e.b.FG_0));
    localObject3 = this.Avj;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("nameEdit");
      localObject1 = null;
    }
    ((MMEditText)localObject1).setBackgroundResource(com.tencent.mm.plugin.finder.e.d.finder_post_activity_edit_bg);
    localObject3 = this.Avj;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("nameEdit");
      localObject1 = null;
    }
    ((MMEditText)localObject1).setHintTextColor(getResources().getColor(com.tencent.mm.plugin.finder.e.b.BW_0_Alpha_0_3));
    localObject3 = this.Avk;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("descEdit");
      localObject1 = null;
    }
    ((MMEditText)localObject1).setBackgroundResource(com.tencent.mm.plugin.finder.e.d.finder_post_activity_edit_bg);
    localObject3 = this.Avk;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("descEdit");
      localObject1 = null;
    }
    ((MMEditText)localObject1).setHintTextColor(getResources().getColor(com.tencent.mm.plugin.finder.e.b.BW_0_Alpha_0_3));
    localObject3 = this.Avm;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("selectTimeText");
      localObject1 = null;
    }
    ((TextView)localObject1).setHintTextColor(getResources().getColor(com.tencent.mm.plugin.finder.e.b.BW_0_Alpha_0_3));
    localObject1 = this.Avm;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("selectTimeText");
      localObject1 = localObject2;
    }
    for (;;)
    {
      ((TextView)localObject1).setBackgroundResource(com.tencent.mm.plugin.finder.e.d.finder_post_activity_edit_bg);
      pA(false);
      AppMethodBeat.o(348535);
      return;
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject1 = null;
    AppMethodBeat.i(348484);
    super.onCreate(paramBundle);
    paramBundle = getActivity().findViewById(com.tencent.mm.plugin.finder.e.e.finder_activity_post_scroll);
    kotlin.g.b.s.s(paramBundle, "activity.findViewById(R.…der_activity_post_scroll)");
    this.lDL = ((ScrollView)paramBundle);
    Object localObject2 = getIntent().getStringExtra("key_nick_name");
    paramBundle = (Bundle)localObject2;
    if (localObject2 == null) {
      paramBundle = "";
    }
    this.nickName = paramBundle;
    localObject2 = getIntent().getStringExtra("key_user_name");
    paramBundle = (Bundle)localObject2;
    if (localObject2 == null) {
      paramBundle = "";
    }
    this.userName = paramBundle;
    localObject2 = getIntent().getStringExtra("key_activity_name");
    paramBundle = (Bundle)localObject2;
    if (localObject2 == null) {
      paramBundle = "";
    }
    this.AtM = paramBundle;
    localObject2 = getIntent().getStringExtra("key_activity_desc");
    paramBundle = (Bundle)localObject2;
    if (localObject2 == null) {
      paramBundle = "";
    }
    this.Ava = paramBundle;
    localObject2 = getIntent().getStringExtra("key_activity_local_cover_url");
    paramBundle = (Bundle)localObject2;
    if (localObject2 == null) {
      paramBundle = "";
    }
    this.Avx = paramBundle;
    this.Avy = getIntent().getIntExtra("key_activity_type", 101);
    this.Avv = Util.isNullOrNil(this.Avx);
    this.Avt = ((int)getResources().getDimension(com.tencent.mm.plugin.finder.e.c.Edge_2A));
    this.Avu = ((int)getResources().getDimension(com.tencent.mm.plugin.finder.e.c.Edge_5_5_A));
    Object localObject3 = com.tencent.mm.pluginsdk.ui.span.p.b((Context)getActivity(), (CharSequence)this.nickName).toString();
    kotlin.g.b.s.s(localObject3, "spanForSmiley(activity, this.nickName).toString()");
    paramBundle = getActivity().findViewById(com.tencent.mm.plugin.finder.e.e.finder_activity_post_cancel_btn);
    ((TextView)paramBundle).setOnClickListener(new e..ExternalSyntheticLambda3(this));
    localObject2 = ah.aiuX;
    kotlin.g.b.s.s(paramBundle, "activity.findViewById<Te…)\n            }\n        }");
    this.pOq = ((TextView)paramBundle);
    paramBundle = getActivity().findViewById(com.tencent.mm.plugin.finder.e.e.finder_activity_post_title);
    kotlin.g.b.s.s(paramBundle, "activity.findViewById(R.…nder_activity_post_title)");
    this.Avi = ((TextView)paramBundle);
    localObject2 = this.Avi;
    paramBundle = (Bundle)localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("titleText");
      paramBundle = null;
    }
    com.tencent.mm.ui.aw.a((Paint)paramBundle.getPaint(), 0.8F);
    localObject2 = getActivity();
    paramBundle = ((AppCompatActivity)localObject2).findViewById(com.tencent.mm.plugin.finder.e.e.finder_activity_post_name_edit);
    kotlin.g.b.s.s(paramBundle, "findViewById(R.id.finder_activity_post_name_edit)");
    this.Avj = ((MMEditText)paramBundle);
    label504:
    label1018:
    int i;
    if (!TextUtils.isEmpty((CharSequence)this.AtM))
    {
      paramBundle = this.Avj;
      if (paramBundle == null)
      {
        kotlin.g.b.s.bIx("nameEdit");
        paramBundle = null;
        paramBundle.setText((CharSequence)this.AtM);
      }
    }
    else
    {
      paramBundle = ((AppCompatActivity)localObject2).findViewById(com.tencent.mm.plugin.finder.e.e.finder_activity_post_desc_edit);
      kotlin.g.b.s.s(paramBundle, "findViewById(R.id.finder_activity_post_desc_edit)");
      this.Avk = ((MMEditText)paramBundle);
      if (!TextUtils.isEmpty((CharSequence)this.Ava))
      {
        paramBundle = this.Avk;
        if (paramBundle != null) {
          break label1634;
        }
        kotlin.g.b.s.bIx("descEdit");
        paramBundle = null;
        paramBundle.setText((CharSequence)this.Ava);
      }
      paramBundle = ((AppCompatActivity)localObject2).findViewById(com.tencent.mm.plugin.finder.e.e.activity_profile_header_name);
      kotlin.g.b.s.s(paramBundle, "findViewById(R.id.activity_profile_header_name)");
      this.AuF = ((TextView)paramBundle);
      paramBundle = ((AppCompatActivity)localObject2).findViewById(com.tencent.mm.plugin.finder.e.e.activity_profile_header_avatar);
      kotlin.g.b.s.s(paramBundle, "findViewById(R.id.activity_profile_header_avatar)");
      this.AuC = ((ImageView)paramBundle);
      paramBundle = this.AuF;
      if (paramBundle != null) {
        break label1637;
      }
      kotlin.g.b.s.bIx("nickNameText");
      paramBundle = null;
      label580:
      paramBundle.setText((CharSequence)localObject3);
      paramBundle = getIntent().getStringExtra("key_avatar_url");
      localObject2 = com.tencent.mm.plugin.finder.loader.p.ExI;
      localObject3 = com.tencent.mm.plugin.finder.loader.p.eCp();
      Object localObject4 = new com.tencent.mm.plugin.finder.loader.b(paramBundle);
      localObject2 = this.AuC;
      paramBundle = (Bundle)localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("avatarImage");
        paramBundle = null;
      }
      localObject2 = com.tencent.mm.plugin.finder.loader.p.ExI;
      ((com.tencent.mm.loader.d)localObject3).a(localObject4, paramBundle, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExM));
      localObject3 = new StringBuilder("nameEdit size ");
      localObject2 = this.Avj;
      paramBundle = (Bundle)localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("nameEdit");
        paramBundle = null;
      }
      localObject3 = ((StringBuilder)localObject3).append(paramBundle.getTextSize()).append("  descEdit size ");
      localObject2 = this.Avk;
      paramBundle = (Bundle)localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("descEdit");
        paramBundle = null;
      }
      Log.i("SimpleUIComponent", paramBundle.getTextSize());
      localObject3 = new e..ExternalSyntheticLambda4(this);
      localObject2 = this.Avj;
      paramBundle = (Bundle)localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("nameEdit");
        paramBundle = null;
      }
      paramBundle.setOnTouchListener((View.OnTouchListener)localObject3);
      localObject2 = this.Avk;
      paramBundle = (Bundle)localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("descEdit");
        paramBundle = null;
      }
      paramBundle.setOnTouchListener((View.OnTouchListener)localObject3);
      paramBundle = getActivity().findViewById(com.tencent.mm.plugin.finder.e.e.finder_activity_post_btn);
      kotlin.g.b.s.s(paramBundle, "activity.findViewById(R.…finder_activity_post_btn)");
      this.Avl = ((Button)paramBundle);
      localObject2 = this.Avl;
      paramBundle = (Bundle)localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("postBtn");
        paramBundle = null;
      }
      paramBundle.setOnClickListener(new e..ExternalSyntheticLambda2(this));
      this.Avn = ((TextView)getActivity().findViewById(com.tencent.mm.plugin.finder.e.e.activity_post_announce_text));
      pA(false);
      paramBundle = this.Avj;
      if (paramBundle != null) {
        break label1640;
      }
      kotlin.g.b.s.bIx("nameEdit");
      paramBundle = null;
      label917:
      paramBundle.addTextChangedListener((TextWatcher)new f(this));
      localObject2 = this.Avj;
      paramBundle = (Bundle)localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("nameEdit");
        paramBundle = null;
      }
      com.tencent.mm.ui.aw.a((Paint)paramBundle.getPaint(), 0.8F);
      this.Avo = ((TextView)getActivity().findViewById(com.tencent.mm.plugin.finder.e.e.finder_activity_post_name_word));
      this.Avp = ((TextView)getActivity().findViewById(com.tencent.mm.plugin.finder.e.e.finder_activity_post_desc_word));
      paramBundle = this.Avk;
      if (paramBundle != null) {
        break label1643;
      }
      kotlin.g.b.s.bIx("descEdit");
      paramBundle = null;
      paramBundle.addTextChangedListener((TextWatcher)new g(this));
      paramBundle = getActivity().findViewById(com.tencent.mm.plugin.finder.e.e.finder_activity_time_text);
      kotlin.g.b.s.s(paramBundle, "activity.findViewById(R.…inder_activity_time_text)");
      this.Avm = ((TextView)paramBundle);
      localObject2 = this.Avm;
      paramBundle = (Bundle)localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("selectTimeText");
        paramBundle = null;
      }
      paramBundle.setOnClickListener(new e..ExternalSyntheticLambda1(this));
      localObject2 = Calendar.getInstance();
      paramBundle = av.GiL;
      ((Calendar)localObject2).setTimeInMillis(av.bUu());
      ((Calendar)localObject2).set(12, 0);
      ((Calendar)localObject2).set(13, 0);
      paramBundle = Calendar.getInstance();
      localObject3 = av.GiL;
      paramBundle.setTimeInMillis(av.bUu());
      paramBundle.add(2, 1);
      paramBundle.add(11, 1);
      paramBundle.set(12, 0);
      paramBundle.set(13, 0);
      localObject3 = Calendar.getInstance();
      localObject4 = av.GiL;
      ((Calendar)localObject3).setTimeInMillis(av.bUu());
      ((Calendar)localObject3).set(2, 11);
      ((Calendar)localObject3).set(5, 31);
      ((Calendar)localObject3).set(11, 0);
      ((Calendar)localObject3).set(12, 0);
      ((Calendar)localObject3).set(13, 0);
      int k = ((Calendar)localObject3).get(6);
      int j = paramBundle.get(6) - ((Calendar)localObject2).get(6);
      i = j;
      if (j < 0) {
        i = j + k;
      }
      this.Avr = i;
      Log.i("SimpleUIComponent", "selectedDateIndex :" + this.Avr + " yearCount:" + k);
      this.Avs = paramBundle.get(11);
      if (this.Avs > 23) {
        this.Avs = 23;
      }
      Log.i("SimpleUIComponent", "initSelectTime time:" + paramBundle.getTime() + ",timeInMills:" + paramBundle.getTimeInMillis());
      this.endTime = (paramBundle.getTimeInMillis() / 1000L);
      i = paramBundle.get(7);
      if (i - 2 >= 0) {
        break label1646;
      }
      i = 7;
      label1396:
      j = paramBundle.get(5);
      k = paramBundle.get(2);
      localObject2 = getContext().getResources().getString(com.tencent.mm.plugin.finder.e.h.finder_live_notice_date_format, new Object[] { Integer.valueOf(k + 1), Integer.valueOf(j) }) + ' ' + com.tencent.mm.plugin.finder.utils.r.h((Context)getContext(), i, "campaign");
      localObject3 = com.tencent.mm.plugin.finder.utils.aw.Gjk;
      paramBundle = com.tencent.mm.plugin.finder.utils.aw.Uv(paramBundle.get(11));
      paramBundle = getContext().getResources().getString(com.tencent.mm.plugin.finder.e.h.finder_campaign_time_picker_hour, new Object[] { paramBundle });
      kotlin.g.b.s.s(paramBundle, "context.resources.getStr…ime_picker_hour, hourStr)");
      this.Avq = ((String)localObject2 + ' ' + paramBundle);
      paramBundle = this.Avm;
      if (paramBundle != null) {
        break label1653;
      }
      kotlin.g.b.s.bIx("selectTimeText");
      paramBundle = null;
      label1569:
      paramBundle.setText((CharSequence)this.Avq);
      this.lKz = new com.tencent.mm.ui.tools.i((Activity)getActivity());
      paramBundle = this.lKz;
      if (paramBundle != null) {
        break label1656;
      }
      kotlin.g.b.s.bIx("keyboardHeightProvider");
      paramBundle = localObject1;
    }
    label1634:
    label1637:
    label1640:
    label1643:
    label1646:
    label1653:
    label1656:
    for (;;)
    {
      paramBundle.afIL = ((com.tencent.mm.ui.tools.h)this);
      AppMethodBeat.o(348484);
      return;
      break;
      break label504;
      break label580;
      break label917;
      break label1018;
      i -= 1;
      break label1396;
      break label1569;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(348508);
    super.onDestroy();
    com.tencent.mm.kernel.h.aZW().b(4050, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(348508);
  }
  
  public final void onKeyboardHeightChanged(int paramInt, boolean paramBoolean)
  {
    Object localObject2 = null;
    AppMethodBeat.i(348541);
    Object localObject3 = this.Avl;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      kotlin.g.b.s.bIx("postBtn");
      localObject1 = null;
    }
    localObject1 = ((Button)localObject1).getLayoutParams();
    if (localObject1 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(348541);
      throw ((Throwable)localObject1);
    }
    localObject3 = (ViewGroup.MarginLayoutParams)localObject1;
    int i = ((Number)this.AvA.getValue()).intValue() - paramInt;
    paramInt = i;
    if (i < dTz()) {
      paramInt = dTz();
    }
    ((ViewGroup.MarginLayoutParams)localObject3).topMargin = paramInt;
    localObject1 = this.Avl;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("postBtn");
      localObject1 = localObject2;
    }
    for (;;)
    {
      ((Button)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject3);
      AppMethodBeat.o(348541);
      return;
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(348501);
    super.onPause();
    com.tencent.mm.ui.tools.i locali2 = this.lKz;
    com.tencent.mm.ui.tools.i locali1 = locali2;
    if (locali2 == null)
    {
      kotlin.g.b.s.bIx("keyboardHeightProvider");
      locali1 = null;
    }
    locali1.close();
    AppMethodBeat.o(348501);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(348493);
    super.onResume();
    Button localButton2 = this.Avl;
    Button localButton1 = localButton2;
    if (localButton2 == null)
    {
      kotlin.g.b.s.bIx("postBtn");
      localButton1 = null;
    }
    localButton1.post(new e..ExternalSyntheticLambda6(this));
    AppMethodBeat.o(348493);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(348513);
    Log.i("SimpleUIComponent", "onSceneEnd: errType=" + paramInt1 + ", errCode=" + paramInt2 + ", errMsg=" + paramString);
    if ((paramp instanceof dh))
    {
      paramString = com.tencent.mm.ui.component.k.aeZF;
      ((f)com.tencent.mm.ui.component.k.d(getActivity()).q(f.class)).dTF();
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        long l = ((dh)paramp).ocD;
        String str = getActivityName();
        paramp = this.Avk;
        paramString = paramp;
        if (paramp == null)
        {
          kotlin.g.b.s.bIx("descEdit");
          paramString = null;
        }
        paramp = paramString.getText().toString();
        paramString = new Intent();
        paramString.putExtra("key_topic_id", l);
        paramString.putExtra("key_activity_name", str);
        paramString.putExtra("key_activity_desc", paramp);
        paramString.putExtra("key_nick_name", this.nickName);
        paramString.putExtra("key_activity_local_cover_url", this.Avx);
        paramString.putExtra("key_cover_url", this.Avw);
        paramString.putExtra("key_activity_type", 101);
        paramString.putExtra("key_activity_end_time", this.endTime);
        Log.i("FinderActivityPostUI", "eventTopicId:" + l + "  name:" + str + "  desc:" + paramp);
        paramp = getActivity();
        paramp.setResult(-1, paramString);
        if (!paramp.isFinishing()) {
          paramp.finish();
        }
        AppMethodBeat.o(348513);
        return;
      }
      J(true, paramInt2);
    }
    AppMethodBeat.o(348513);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityPostUIC$Companion;", "", "()V", "DESC_ANIM_DURATION", "", "DESC_CHAR_LIMIT", "", "getDESC_CHAR_LIMIT", "()I", "DESC_CHAR_LIMIT$delegate", "Lkotlin/Lazy;", "DESC_SHOW_HINT_LEAST_LIMIT", "NAME_CHAR_LIMIT", "NAME_SHOW_HINT_LEAST_LIMIT", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<Integer>
  {
    public static final b AvE;
    
    static
    {
      AppMethodBeat.i(348068);
      AvE = new b();
      AppMethodBeat.o(348068);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/activity/uic/FinderActivityPostUIC$doPost$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements com.tencent.mm.loader.f.e<com.tencent.mm.loader.f.c>
  {
    c(e parame) {}
    
    public final void a(com.tencent.mm.loader.f.c paramc, com.tencent.mm.loader.f.i parami)
    {
      AppMethodBeat.i(348069);
      kotlin.g.b.s.u(paramc, "task");
      kotlin.g.b.s.u(parami, "status");
      if (parami == com.tencent.mm.loader.f.i.nrH)
      {
        paramc = com.tencent.mm.ui.component.k.aeZF;
        ((f)com.tencent.mm.ui.component.k.d(this.AvF.getActivity()).q(f.class)).dTF();
        AppMethodBeat.o(348069);
        return;
      }
      parami = com.tencent.mm.ui.component.k.aeZF;
      ((f)com.tencent.mm.ui.component.k.d(this.AvF.getActivity()).q(f.class)).setCover(e.f(this.AvF));
      e.a(this.AvF, paramc);
      AppMethodBeat.o(348069);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<View>
  {
    d(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<TextView>
  {
    e(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/activity/uic/FinderActivityPostUIC$initView$3", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements TextWatcher
  {
    f(e parame) {}
    
    public final void afterTextChanged(Editable paramEditable)
    {
      Object localObject1 = null;
      Object localObject2 = null;
      Button localButton = null;
      AppMethodBeat.i(348081);
      e locale;
      int j;
      int i;
      if (paramEditable != null)
      {
        locale = this.AvF;
        j = paramEditable.toString().length();
        if (8 > j) {
          break label144;
        }
        if (j >= 10) {
          break label139;
        }
        i = 1;
      }
      while (i != 0)
      {
        paramEditable = e.c(locale);
        if (paramEditable != null) {
          paramEditable.setTextColor(locale.getResources().getColor(com.tencent.mm.plugin.finder.e.b.FG_1));
        }
        paramEditable = e.c(locale);
        if (paramEditable != null) {
          paramEditable.setText((CharSequence)String.valueOf(10 - j));
        }
        localButton = e.d(locale);
        paramEditable = localButton;
        if (localButton == null)
        {
          kotlin.g.b.s.bIx("postBtn");
          paramEditable = null;
        }
        paramEditable.setEnabled(true);
        e.a(this.AvF);
        AppMethodBeat.o(348081);
        return;
        label139:
        i = 0;
        continue;
        label144:
        i = 0;
      }
      if (j == 10)
      {
        paramEditable = e.c(locale);
        if (paramEditable != null) {
          paramEditable.setTextColor(locale.getResources().getColor(com.tencent.mm.plugin.finder.e.b.FG_1));
        }
        paramEditable = e.c(locale);
        if (paramEditable != null) {
          paramEditable.setText((CharSequence)"");
        }
        paramEditable = e.d(locale);
        if (paramEditable == null)
        {
          kotlin.g.b.s.bIx("postBtn");
          paramEditable = localButton;
        }
        for (;;)
        {
          paramEditable.setEnabled(true);
          break;
        }
      }
      if (j > 10)
      {
        paramEditable = e.c(locale);
        if (paramEditable != null) {
          paramEditable.setTextColor(locale.getResources().getColor(com.tencent.mm.plugin.finder.e.b.Red));
        }
        paramEditable = e.c(locale);
        if (paramEditable != null) {
          paramEditable.setText((CharSequence)String.valueOf(10 - j));
        }
        paramEditable = e.d(locale);
        if (paramEditable == null)
        {
          kotlin.g.b.s.bIx("postBtn");
          paramEditable = localObject1;
        }
        for (;;)
        {
          paramEditable.setEnabled(false);
          break;
        }
      }
      paramEditable = e.c(locale);
      if (paramEditable != null) {
        paramEditable.setText((CharSequence)"");
      }
      paramEditable = e.d(locale);
      if (paramEditable == null)
      {
        kotlin.g.b.s.bIx("postBtn");
        paramEditable = localObject2;
      }
      for (;;)
      {
        paramEditable.setEnabled(true);
        break;
      }
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/activity/uic/FinderActivityPostUIC$initView$4", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements TextWatcher
  {
    g(e parame) {}
    
    public final void afterTextChanged(Editable paramEditable)
    {
      Object localObject1 = null;
      Object localObject2 = null;
      e.a locala = null;
      AppMethodBeat.i(348115);
      int i;
      int j;
      if (paramEditable == null)
      {
        i = 0;
        paramEditable = e.Avh;
        j = e.a.dTE();
        paramEditable = e.Avh;
        if (i >= e.a.dTE()) {
          break label191;
        }
        if (j - 10 > i) {
          break label186;
        }
        j = 1;
      }
      for (;;)
      {
        if (j == 0) {
          break label196;
        }
        paramEditable = e.e(this.AvF);
        if (paramEditable != null) {
          paramEditable.setTextColor(this.AvF.getResources().getColor(com.tencent.mm.plugin.finder.e.b.FG_1));
        }
        paramEditable = e.e(this.AvF);
        if (paramEditable != null)
        {
          localObject1 = e.Avh;
          paramEditable.setText((CharSequence)String.valueOf(e.a.dTE() - i));
        }
        e.a(this.AvF, true);
        localObject1 = e.d(this.AvF);
        paramEditable = (Editable)localObject1;
        if (localObject1 == null)
        {
          kotlin.g.b.s.bIx("postBtn");
          paramEditable = null;
        }
        paramEditable.setEnabled(true);
        e.a(this.AvF);
        AppMethodBeat.o(348115);
        return;
        paramEditable = paramEditable.toString();
        if (paramEditable == null)
        {
          i = 0;
          break;
        }
        i = paramEditable.length();
        break;
        label186:
        j = 0;
        continue;
        label191:
        j = 0;
      }
      label196:
      paramEditable = e.Avh;
      if (i == e.a.dTE())
      {
        paramEditable = e.e(this.AvF);
        if (paramEditable != null) {
          paramEditable.setTextColor(this.AvF.getResources().getColor(com.tencent.mm.plugin.finder.e.b.FG_1));
        }
        paramEditable = e.e(this.AvF);
        if (paramEditable != null) {
          paramEditable.setText((CharSequence)"");
        }
        e.a(this.AvF, false);
        paramEditable = e.d(this.AvF);
        if (paramEditable == null)
        {
          kotlin.g.b.s.bIx("postBtn");
          paramEditable = locala;
        }
        for (;;)
        {
          paramEditable.setEnabled(true);
          break;
        }
      }
      paramEditable = e.Avh;
      if (i > e.a.dTE())
      {
        paramEditable = e.e(this.AvF);
        if (paramEditable != null) {
          paramEditable.setTextColor(this.AvF.getResources().getColor(com.tencent.mm.plugin.finder.e.b.Red));
        }
        paramEditable = e.e(this.AvF);
        if (paramEditable != null)
        {
          locala = e.Avh;
          paramEditable.setText((CharSequence)String.valueOf(e.a.dTE() - i));
        }
        e.a(this.AvF, true);
        paramEditable = e.d(this.AvF);
        if (paramEditable == null)
        {
          kotlin.g.b.s.bIx("postBtn");
          paramEditable = (Editable)localObject1;
        }
        for (;;)
        {
          paramEditable.setEnabled(false);
          break;
        }
      }
      paramEditable = e.e(this.AvF);
      if (paramEditable != null) {
        paramEditable.setText((CharSequence)"");
      }
      e.a(this.AvF, false);
      paramEditable = e.d(this.AvF);
      if (paramEditable == null)
      {
        kotlin.g.b.s.bIx("postBtn");
        paramEditable = localObject2;
      }
      for (;;)
      {
        paramEditable.setEnabled(true);
        break;
      }
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<Integer>
  {
    h(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<Integer>
  {
    i(e parame)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.b<String, ah>
  {
    j(e parame)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.activity.uic.e
 * JD-Core Version:    0.7.0.1
 */
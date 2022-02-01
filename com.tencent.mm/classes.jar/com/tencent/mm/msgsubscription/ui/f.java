package com.tencent.mm.msgsubscription.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint.Style;
import android.text.TextPaint;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.modelappbrand.a.e;
import com.tencent.mm.msgsubscription.a.c;
import com.tencent.mm.msgsubscription.a.d;
import com.tencent.mm.msgsubscription.a.e;
import com.tencent.mm.msgsubscription.a.g;
import com.tencent.mm.plugin.appbrand.widget.dialog.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "context", "Landroid/content/Context;", "items", "", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "listener", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Listener;", "isSingleMode", "", "singleVoiceTmpMode", "(Landroid/content/Context;Ljava/util/List;Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Listener;ZZ)V", "_position", "", "value", "", "actionDesc", "getActionDesc", "()Ljava/lang/String;", "setActionDesc", "(Ljava/lang/String;)V", "actionTv", "Landroid/widget/TextView;", "adapter", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemAdapter;", "alwaysKeepCb", "Landroid/widget/CheckBox;", "alwaysKeepText", "getAlwaysKeepText", "setAlwaysKeepText", "alwaysKeepTv", "alwaysKeepView", "Landroid/view/View;", "alwaysRejectText", "getAlwaysRejectText", "setAlwaysRejectText", "alwaysRejectTv", "appName", "getAppName", "setAppName", "appNameTv", "cancelBtn", "Landroid/widget/Button;", "cancelBtnText", "getCancelBtnText", "setCancelBtnText", "container", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "contentType", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ContentType;", "defaultIconRes", "getDefaultIconRes", "()I", "setDefaultIconRes", "(I)V", "desc", "getDesc", "setDesc", "descTV", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$SubscribeRequestDialogListener;", "dialogListener", "getDialogListener", "()Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$SubscribeRequestDialogListener;", "setDialogListener", "(Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$SubscribeRequestDialogListener;)V", "dialogView", "dialogViewContainer", "Landroid/widget/FrameLayout;", "iconIv", "Landroid/widget/ImageView;", "iconUrl", "getIconUrl", "setIconUrl", "", "mRootView", "okBtn", "okBtnText", "getOkBtnText", "setOkBtnText", "recyclerViewContainer", "sampleBack", "sampleRoot", "sampleShowing", "sampleTitle", "getSampleTitle", "setSampleTitle", "sampleViewId", "Ljava/lang/Integer;", "sampleViewTitle", "scrollView", "Landroid/widget/ScrollView;", "showAlwaysKeepView", "getShowAlwaysKeepView", "()Z", "setShowAlwaysKeepView", "(Z)V", "showAlwaysRejectView", "getShowAlwaysRejectView", "setShowAlwaysRejectView", "stopVoiceBroadcastTask", "Lkotlin/Function0;", "", "templateShowSampleListener", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Companion$TemplateShowSampleListener;", "getTemplateShowSampleListener", "()Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Companion$TemplateShowSampleListener;", "setTemplateShowSampleListener", "(Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Companion$TemplateShowSampleListener;)V", "tip", "getTip", "setTip", "tipTv", "topSampleBtn", "addRecyclerView", "addSingleVoiceTmpMode", "item", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemWithVoice;", "alwaysKeepSelected", "applyRotation", "rotation", "cancel", "closeSampleView", "dismiss", "dispatchCancelEvent", "dispatchEvent", "event", "getContentView", "getPosition", "getRotation", "isCancelable", "isCanceledOnTouchOutside", "onBackPressedEvent", "onCancel", "onCheckedCountChanged", "size", "onDismiss", "onScreenOrientationChanged", "onShow", "dialogHelper", "onShown", "setPosition", "position", "showSample", "startSampleAnimation", "show", "Landroid/animation/Animator$AnimatorListener;", "setBoldStyle", "Companion", "ContentType", "Item", "ItemAdapter", "ItemWithForceNotify", "ItemWithVoice", "Listener", "SubscribeRequestDialogListener", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public class f
  implements n
{
  public static final f.a plk;
  private String appName;
  private List<c> bMQ;
  private final Context context;
  private String desc;
  private String iconUrl;
  private ScrollView lDL;
  private ImageView lPb;
  private Button nhC;
  private Button njI;
  private TextView nmm;
  public CheckBox plA;
  private TextView plB;
  private View plC;
  private boolean plD;
  private Integer plE;
  private com.tencent.mm.plugin.appbrand.widget.dialog.r plF;
  private f.b plG;
  private kotlin.g.a.a<ah> plH;
  public a.a plI;
  private String plJ;
  private String plK;
  public boolean plL;
  private String plM;
  public boolean plN;
  private String plO;
  private String plP;
  private String plQ;
  private String plR;
  public int plS;
  public h plT;
  private int plU;
  private View plc;
  private f.g pll;
  private final boolean plm;
  private final boolean pln;
  private FrameLayout plo;
  private f.d plp;
  private TextView plq;
  private TextView plr;
  private TextView pls;
  private View plt;
  private FrameLayout plu;
  private View plv;
  private View plw;
  private TextView plx;
  private TextView ply;
  public View plz;
  
  static
  {
    AppMethodBeat.i(149783);
    plk = new f.a((byte)0);
    AppMethodBeat.o(149783);
  }
  
  public f(Context paramContext, List<? extends c> paramList, f.g paramg, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(236592);
    this.context = paramContext;
    this.pll = paramg;
    this.plm = paramBoolean1;
    this.pln = paramBoolean2;
    paramContext = LayoutInflater.from(this.context).inflate(a.e.subscribe_msg_request_dialog, null);
    s.s(paramContext, "from(context).inflate(R.…msg_request_dialog, null)");
    this.plc = paramContext;
    this.bMQ = ((List)new ArrayList());
    this.plG = f.b.plV;
    this.iconUrl = "";
    this.appName = "";
    this.plJ = "";
    this.plK = "";
    this.plL = true;
    this.plM = "";
    this.plN = true;
    this.plO = "";
    this.desc = "";
    this.plP = "";
    this.plQ = "";
    this.plR = "";
    paramContext = this.plc.findViewById(a.d.item_list_container);
    s.s(paramContext, "mRootView.findViewById(R.id.item_list_container)");
    this.plo = ((FrameLayout)paramContext);
    paramContext = this.plc.findViewById(a.d.scroll_view);
    s.s(paramContext, "mRootView.findViewById(R.id.scroll_view)");
    this.lDL = ((ScrollView)paramContext);
    paramContext = this.plc.findViewById(a.d.icon_iv);
    s.s(paramContext, "mRootView.findViewById(R.id.icon_iv)");
    this.lPb = ((ImageView)paramContext);
    paramContext = this.plc.findViewById(a.d.action);
    s.s(paramContext, "mRootView.findViewById(R.id.action)");
    this.nmm = ((TextView)paramContext);
    paramContext = this.plc.findViewById(a.d.desc);
    s.s(paramContext, "mRootView.findViewById(R.id.desc)");
    this.plr = ((TextView)paramContext);
    paramContext = this.plc.findViewById(a.d.tip);
    s.s(paramContext, "mRootView.findViewById(R.id.tip)");
    this.pls = ((TextView)paramContext);
    paramContext = this.plc.findViewById(a.d.app_name_tv);
    s.s(paramContext, "mRootView.findViewById(R.id.app_name_tv)");
    this.plq = ((TextView)paramContext);
    paramContext = this.plc.findViewById(a.d.dialog_cancel);
    s.s(paramContext, "mRootView.findViewById(R.id.dialog_cancel)");
    this.njI = ((Button)paramContext);
    paramContext = this.plc.findViewById(a.d.dialog_ok);
    s.s(paramContext, "mRootView.findViewById(R.id.dialog_ok)");
    this.nhC = ((Button)paramContext);
    paramContext = this.plc.findViewById(a.d.sample_root);
    s.s(paramContext, "mRootView.findViewById(R.id.sample_root)");
    this.plt = paramContext;
    paramContext = this.plc.findViewById(a.d.sample_view_title);
    s.s(paramContext, "mRootView.findViewById(R.id.sample_view_title)");
    this.plB = ((TextView)paramContext);
    paramContext = this.plc.findViewById(a.d.dialog_view_container);
    s.s(paramContext, "mRootView.findViewById(R.id.dialog_view_container)");
    this.plu = ((FrameLayout)paramContext);
    paramContext = this.plc.findViewById(a.d.dialog_view);
    s.s(paramContext, "mRootView.findViewById(R.id.dialog_view)");
    this.plv = paramContext;
    paramContext = this.plc.findViewById(a.d.close_wiv);
    s.s(paramContext, "mRootView.findViewById(R.id.close_wiv)");
    this.plw = paramContext;
    this.plw.setContentDescription((CharSequence)this.context.getString(a.g.app_brand_accessibility_close_button));
    paramContext = this.plc.findViewById(a.d.always_keep_tv);
    s.s(paramContext, "mRootView.findViewById(R.id.always_keep_tv)");
    this.plx = ((TextView)paramContext);
    paramContext = this.plc.findViewById(a.d.once_type_always_keep_layout);
    s.s(paramContext, "mRootView.findViewById(R…_type_always_keep_layout)");
    this.plz = paramContext;
    paramContext = this.plc.findViewById(a.d.always_keep_checkbox);
    s.s(paramContext, "mRootView.findViewById(R.id.always_keep_checkbox)");
    this.plA = ((CheckBox)paramContext);
    paramContext = this.plc.findViewById(a.d.always_reject_tv);
    s.s(paramContext, "mRootView.findViewById(R.id.always_reject_tv)");
    this.ply = ((TextView)paramContext);
    paramContext = this.plc.findViewById(a.d.top_sample);
    s.s(paramContext, "mRootView.findViewById(R.id.top_sample)");
    this.plC = paramContext;
    this.plc.getViewTreeObserver().addOnGlobalLayoutListener(new f..ExternalSyntheticLambda8(this));
    this.plu.getViewTreeObserver().addOnGlobalLayoutListener(new f..ExternalSyntheticLambda7(this));
    this.bMQ.addAll((Collection)paramList);
    if (this.plm)
    {
      this.plG = f.b.plW;
      this.plo.setVisibility(8);
      this.plC.setVisibility(0);
      this.plC.setOnClickListener(new f..ExternalSyntheticLambda6(this, paramList));
    }
    for (;;)
    {
      this.nhC.setOnClickListener(new f..ExternalSyntheticLambda2(this));
      this.njI.setOnClickListener(new f..ExternalSyntheticLambda1(this));
      this.plz.setOnClickListener(new f..ExternalSyntheticLambda5(this, paramList));
      this.ply.setOnClickListener(new f..ExternalSyntheticLambda4(this));
      this.plU = 2;
      AppMethodBeat.o(236592);
      return;
      if (this.pln)
      {
        this.plG = f.b.plX;
        Object localObject1 = (f)paramList.get(0);
        this.plo.removeAllViews();
        paramContext = new LinearLayout(this.context);
        paramContext.setBackgroundColor(0);
        paramContext.setOrientation(1);
        paramContext.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        paramg = LayoutInflater.from(this.context).inflate(a.e.subscribe_msg_voice_broadcast_item_layout, null);
        Object localObject2 = paramg.findViewById(a.d.switch_btn);
        ((MMSwitchBtn)localObject2).setVisibility(0);
        Object localObject3 = ah.aiuX;
        localObject3 = (MMSwitchBtn)localObject2;
        if (localObject3 != null) {
          ((MMSwitchBtn)localObject3).setCheck(false);
        }
        localObject2 = (MMSwitchBtn)localObject2;
        if (localObject2 != null) {
          ((MMSwitchBtn)localObject2).setSwitchListener(new f..ExternalSyntheticLambda9((f)localObject1));
        }
        localObject2 = (WeImageView)paramg.findViewById(a.d.icon_btn);
        ((WeImageView)localObject2).setVisibility(8);
        localObject3 = (CharSequence)((f)localObject1).pmj;
        if ((localObject3 == null) || (((CharSequence)localObject3).length() == 0)) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0)
          {
            ((WeImageView)localObject2).setVisibility(0);
            ((WeImageView)localObject2).setOnClickListener(new f..ExternalSyntheticLambda0((f)localObject1, this));
          }
          ((TextView)paramg.findViewById(a.d.desc)).setText((CharSequence)this.context.getString(a.g.biz_subscribe_msg_voice_template_accept_play_voice));
          localObject1 = (kotlin.g.a.a)new f.k(this);
          i = (int)TypedValue.applyDimension(1, 56.0F, this.context.getResources().getDisplayMetrics());
          paramContext.addView((View)((kotlin.g.a.a)localObject1).invoke());
          paramContext.addView(paramg, new ViewGroup.LayoutParams(-1, i));
          paramContext.addView((View)((kotlin.g.a.a)localObject1).invoke());
          this.plo.addView((View)paramContext, new ViewGroup.LayoutParams(-1, -2));
          break;
        }
      }
      this.plG = f.b.plV;
      cn(paramList);
    }
  }
  
  private static final void a(f paramf, f paramf1, View paramView)
  {
    AppMethodBeat.i(236687);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramf);
    localb.cH(paramf1);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramf, "$item");
    s.u(paramf1, "this$0");
    paramView = com.tencent.mm.msgsubscription.voice.a.pmY;
    paramf1.plH = ((kotlin.g.a.a)new j(com.tencent.mm.msgsubscription.voice.a.Ro(paramf.pmj)));
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(236687);
  }
  
  private static final void a(f paramf, boolean paramBoolean)
  {
    AppMethodBeat.i(236682);
    s.u(paramf, "$item");
    paramf.pmk = paramBoolean;
    paramf.plZ = true;
    AppMethodBeat.o(236682);
  }
  
  private static final void a(f paramf)
  {
    AppMethodBeat.i(236631);
    s.u(paramf, "this$0");
    if (paramf.plc.getParent() != null) {
      switch (paramf.getRotation())
      {
      case 2: 
      default: 
        int i = com.tencent.mm.cd.a.mt(paramf.context) - com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 60);
        if (paramf.plc.getHeight() > i)
        {
          paramf.plc.getLayoutParams().height = Math.min(i, paramf.plc.getHeight());
          paramf.plc.requestLayout();
        }
        break;
      }
    }
    do
    {
      AppMethodBeat.o(236631);
      return;
    } while (paramf.plc.getLayoutParams().height == -2);
    paramf.plc.getLayoutParams().height = -2;
    paramf.plc.requestLayout();
    AppMethodBeat.o(236631);
  }
  
  private static final void a(f paramf, View paramView)
  {
    AppMethodBeat.i(236653);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramf);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramf, "this$0");
    paramf.xu(1);
    paramf.dismiss();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(236653);
  }
  
  private static final void a(f paramf, List paramList, View paramView)
  {
    AppMethodBeat.i(236649);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramf);
    localb.cH(paramList);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramf, "this$0");
    s.u(paramList, "$items");
    paramList = (c)paramList.get(0);
    if (!paramf.plD)
    {
      paramView = com.tencent.mm.msgsubscription.util.b.pmS;
      paramView = com.tencent.mm.msgsubscription.util.b.b(paramf.context, paramList.pma);
      paramView.setId(View.generateViewId());
      paramf.plE = Integer.valueOf(paramView.getId());
      ((LinearLayout)paramf.plt.findViewById(a.d.container)).addView(paramView);
      paramf.plt.setVisibility(0);
      paramf.plB.setText((CharSequence)paramf.plJ);
      paramf.plw.setOnClickListener(new f..ExternalSyntheticLambda3(paramf));
      paramf.plt.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new n(paramf));
      paramView = paramf.plI;
      if (paramView != null) {
        paramView.bj(paramList.nSg, paramf.bMQ.indexOf(paramList));
      }
      paramf.plD = true;
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(236649);
  }
  
  private final void a(boolean paramBoolean, Animator.AnimatorListener paramAnimatorListener)
  {
    AppMethodBeat.i(149771);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    Object localObject1;
    Object localObject2;
    ah localah;
    if (paramBoolean)
    {
      localObject1 = ObjectAnimator.ofFloat(this.plu, View.TRANSLATION_X, new float[] { 0.0F, -this.plu.getWidth() }).setDuration(200L);
      ((ObjectAnimator)localObject1).setInterpolator((TimeInterpolator)new com.tencent.mm.msgsubscription.ui.a.a());
      localObject2 = ah.aiuX;
      localObject1 = (Animator)localObject1;
      localObject2 = ObjectAnimator.ofFloat(this.plt, View.TRANSLATION_X, new float[] { this.plt.getWidth(), 0.0F }).setDuration(200L);
      ((ObjectAnimator)localObject2).setInterpolator((TimeInterpolator)new com.tencent.mm.msgsubscription.ui.a.a());
      localah = ah.aiuX;
      localAnimatorSet.playTogether(new Animator[] { localObject1, (Animator)localObject2 });
    }
    for (;;)
    {
      if (paramAnimatorListener != null) {
        localAnimatorSet.addListener(paramAnimatorListener);
      }
      localAnimatorSet.start();
      AppMethodBeat.o(149771);
      return;
      localObject1 = ObjectAnimator.ofFloat(this.plu, View.TRANSLATION_X, new float[] { -this.plu.getWidth(), 0.0F }).setDuration(200L);
      ((ObjectAnimator)localObject1).setInterpolator((TimeInterpolator)new com.tencent.mm.msgsubscription.ui.a.a());
      localObject2 = ah.aiuX;
      localObject1 = (Animator)localObject1;
      localObject2 = ObjectAnimator.ofFloat(this.plt, View.TRANSLATION_X, new float[] { 0.0F, this.plt.getWidth() }).setDuration(200L);
      ((ObjectAnimator)localObject2).setInterpolator((TimeInterpolator)new com.tencent.mm.msgsubscription.ui.a.a());
      localah = ah.aiuX;
      localAnimatorSet.playTogether(new Animator[] { localObject1, (Animator)localObject2 });
    }
  }
  
  private static final void b(f paramf)
  {
    AppMethodBeat.i(236638);
    s.u(paramf, "this$0");
    if (paramf.plu.getHeight() > 0) {
      paramf.plt.getLayoutParams().height = paramf.plu.getHeight();
    }
    AppMethodBeat.o(236638);
  }
  
  private static final void b(f paramf, View paramView)
  {
    AppMethodBeat.i(236659);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramf);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramf, "this$0");
    paramf.cancel();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(236659);
  }
  
  private static final void b(f paramf, List paramList, View paramView)
  {
    AppMethodBeat.i(236669);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramf);
    localb.cH(paramList);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramf, "this$0");
    s.u(paramList, "$items");
    paramView = paramf.plA;
    if (!paramf.plA.isChecked()) {}
    for (boolean bool = true;; bool = false)
    {
      paramView.setChecked(bool);
      paramList = ((Iterable)paramList).iterator();
      while (paramList.hasNext()) {
        ((c)paramList.next()).pmb = paramf.plA.isChecked();
      }
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(236669);
  }
  
  private final boolean bQj()
  {
    AppMethodBeat.i(149773);
    if (this.plD)
    {
      a(false, (Animator.AnimatorListener)new m(this));
      this.plD = false;
      AppMethodBeat.o(149773);
      return true;
    }
    AppMethodBeat.o(149773);
    return false;
  }
  
  private static final void c(f paramf, View paramView)
  {
    AppMethodBeat.i(236674);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramf);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramf, "this$0");
    paramf.xu(3);
    paramf.dismiss();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(236674);
  }
  
  private final void cn(List<? extends c> paramList)
  {
    AppMethodBeat.i(149769);
    RecyclerView localRecyclerView = new RecyclerView(this.context);
    this.plo.removeAllViews();
    this.plo.addView((View)localRecyclerView, new ViewGroup.LayoutParams(-1, -2));
    this.plp = new f.d(paramList, this);
    f.d locald = this.plp;
    paramList = locald;
    if (locald == null)
    {
      s.bIx("adapter");
      paramList = null;
    }
    localRecyclerView.setAdapter((RecyclerView.a)paramList);
    localRecyclerView.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    localRecyclerView.a((RecyclerView.h)new f.i(this));
    AppMethodBeat.o(149769);
  }
  
  private static final void d(f paramf, View paramView)
  {
    AppMethodBeat.i(236690);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramf);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramf, "this$0");
    paramf.bQj();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(236690);
  }
  
  private final int getRotation()
  {
    AppMethodBeat.i(149770);
    Object localObject = this.context.getSystemService("window");
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.view.WindowManager");
      AppMethodBeat.o(149770);
      throw ((Throwable)localObject);
    }
    int i = ((WindowManager)localObject).getDefaultDisplay().getRotation();
    AppMethodBeat.o(149770);
    return i;
  }
  
  private static void i(TextView paramTextView)
  {
    AppMethodBeat.i(149768);
    paramTextView.getPaint().setStyle(Paint.Style.FILL_AND_STROKE);
    paramTextView.getPaint().setStrokeWidth(0.8F);
    AppMethodBeat.o(149768);
  }
  
  private final void xu(int paramInt)
  {
    AppMethodBeat.i(149778);
    Log.i("SubscribeMsgRequestDialog", s.X("dispatchEvent ", Integer.valueOf(paramInt)));
    f.g localg = this.pll;
    if (localg != null)
    {
      List localList = (List)new ArrayList();
      localList.addAll((Collection)this.bMQ);
      ah localah = ah.aiuX;
      localg.r(paramInt, localList);
    }
    AppMethodBeat.o(149778);
  }
  
  private final void xv(int paramInt)
  {
    AppMethodBeat.i(149781);
    Object localObject = b.pkZ;
    b.a.d(paramInt, this.plc);
    switch (paramInt)
    {
    case 2: 
    default: 
      if (this.plu.indexOfChild(this.plv) == -1)
      {
        localObject = this.plv.getParent();
        if (localObject != null) {
          ((ViewGroup)localObject).removeView(this.plv);
        }
        this.plu.addView(this.plv);
        this.lDL.setVisibility(8);
      }
      break;
    }
    for (;;)
    {
      this.plc.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new l(this));
      AppMethodBeat.o(149781);
      return;
      if (this.lDL.indexOfChild(this.plv) == -1)
      {
        localObject = this.plv.getParent();
        if (localObject != null) {
          ((ViewGroup)localObject).removeView(this.plv);
        }
        this.lDL.addView(this.plv);
        this.lDL.setVisibility(0);
      }
    }
  }
  
  public final void Rg(String paramString)
  {
    AppMethodBeat.i(149762);
    s.u(paramString, "value");
    this.appName = paramString;
    this.plq.setText((CharSequence)this.appName);
    i(this.plq);
    AppMethodBeat.o(149762);
  }
  
  public final void Rh(String paramString)
  {
    AppMethodBeat.i(236737);
    s.u(paramString, "<set-?>");
    this.plJ = paramString;
    AppMethodBeat.o(236737);
  }
  
  public final void Ri(String paramString)
  {
    AppMethodBeat.i(236738);
    s.u(paramString, "value");
    this.plK = paramString;
    this.plz.setVisibility(0);
    this.plx.setText((CharSequence)this.plK);
    this.ply.setVisibility(8);
    AppMethodBeat.o(236738);
  }
  
  public final void Rj(String paramString)
  {
    AppMethodBeat.i(236740);
    s.u(paramString, "value");
    this.plM = paramString;
    this.ply.setVisibility(0);
    this.ply.setText((CharSequence)this.plM);
    this.plz.setVisibility(8);
    AppMethodBeat.o(236740);
  }
  
  public final void Rk(String paramString)
  {
    AppMethodBeat.i(149763);
    s.u(paramString, "value");
    this.plO = paramString;
    this.nmm.setText((CharSequence)this.plO);
    i(this.nmm);
    AppMethodBeat.o(149763);
  }
  
  public final void Rl(String paramString)
  {
    AppMethodBeat.i(149765);
    s.u(paramString, "value");
    this.plP = paramString;
    this.nhC.setText((CharSequence)this.plP);
    AppMethodBeat.o(149765);
  }
  
  public final void Rm(String paramString)
  {
    AppMethodBeat.i(149766);
    s.u(paramString, "value");
    this.plQ = paramString;
    this.njI.setText((CharSequence)this.plQ);
    AppMethodBeat.o(149766);
  }
  
  public final void Rn(String paramString)
  {
    AppMethodBeat.i(149767);
    s.u(paramString, "value");
    this.plR = paramString;
    this.pls.setText((CharSequence)this.plR);
    paramString = this.pls;
    if (((CharSequence)this.plR).length() == 0)
    {
      i = 1;
      if (i == 0) {
        break label78;
      }
    }
    label78:
    for (int i = 8;; i = 0)
    {
      paramString.setVisibility(i);
      AppMethodBeat.o(149767);
      return;
      i = 0;
      break;
    }
  }
  
  public final void a(com.tencent.mm.plugin.appbrand.widget.dialog.r paramr)
  {
    AppMethodBeat.i(149776);
    com.tencent.mm.modelappbrand.a.b.bEY().a(this.lPb, this.iconUrl, this.plS, (b.h)new e());
    this.plF = paramr;
    xv(getRotation());
    paramr = this.plT;
    if (paramr != null) {
      paramr.onShow();
    }
    AppMethodBeat.o(149776);
  }
  
  public final boolean bQg()
  {
    AppMethodBeat.i(149774);
    boolean bool = bQj();
    AppMethodBeat.o(149774);
    return bool;
  }
  
  public final void bQh()
  {
    AppMethodBeat.i(236762);
    com.tencent.mm.plugin.appbrand.widget.a.a.dQ(this.plc);
    AppMethodBeat.o(236762);
  }
  
  public final boolean bQi()
  {
    return false;
  }
  
  public void cancel()
  {
    AppMethodBeat.i(149779);
    xu(2);
    dismiss();
    AppMethodBeat.o(149779);
  }
  
  public void dismiss()
  {
    AppMethodBeat.i(149775);
    Object localObject = this.plF;
    if (localObject != null) {
      ((com.tencent.mm.plugin.appbrand.widget.dialog.r)localObject).c((n)this);
    }
    localObject = this.plT;
    if (localObject != null) {
      ((h)localObject).onDismiss();
    }
    localObject = this.plH;
    if (localObject != null) {
      ((kotlin.g.a.a)localObject).invoke();
    }
    AppMethodBeat.o(149775);
  }
  
  public final View getContentView()
  {
    return this.plc;
  }
  
  public final int getPosition()
  {
    return this.plU;
  }
  
  public final void hz(boolean paramBoolean)
  {
    AppMethodBeat.i(236743);
    this.plN = paramBoolean;
    TextView localTextView = this.ply;
    if (this.plN) {}
    for (int i = 0;; i = 8)
    {
      localTextView.setVisibility(i);
      AppMethodBeat.o(236743);
      return;
    }
  }
  
  public boolean isCancelable()
  {
    return false;
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(149777);
    xu(2);
    AppMethodBeat.o(149777);
  }
  
  public final void setDesc(String paramString)
  {
    AppMethodBeat.i(149764);
    s.u(paramString, "value");
    this.desc = paramString;
    this.plr.setText((CharSequence)this.desc);
    AppMethodBeat.o(149764);
  }
  
  public final void setIconUrl(String paramString)
  {
    AppMethodBeat.i(149761);
    s.u(paramString, "value");
    this.iconUrl = paramString;
    AppMethodBeat.o(149761);
  }
  
  public final void setPosition(int paramInt)
  {
    AppMethodBeat.i(236758);
    this.plU = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(236758);
      return;
      this.plc.findViewById(a.d.dialog_view_root_container).setBackground(androidx.core.content.a.m(this.context, a.c.subscribe_msg_request_dialog_center_style_bg));
      AppMethodBeat.o(236758);
      return;
      this.plc.findViewById(a.d.dialog_view_root_container).setBackground(androidx.core.content.a.m(this.context, a.c.subscribe_msg_request_dialog_bg));
    }
  }
  
  public final void xt(int paramInt)
  {
    AppMethodBeat.i(149780);
    xv(paramInt);
    AppMethodBeat.o(149780);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Companion$TemplateShowSampleListener;", "", "onSampleShow", "", "templateId", "", "check", "", "index", "", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a$a
  {
    public abstract void bj(String paramString, int paramInt);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "", "check", "", "title", "", "sampleWordings", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "templateId", "(ZLjava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;)V", "alwaysKeep", "getAlwaysKeep", "()Z", "setAlwaysKeep", "(Z)V", "getCheck", "setCheck", "getSampleWordings", "()Ljava/util/ArrayList;", "getTemplateId", "()Ljava/lang/String;", "getTitle", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static class c
  {
    public final String nSg;
    public boolean plZ;
    final ArrayList<kotlin.r<String, String>> pma;
    boolean pmb;
    final String title;
    
    public c(boolean paramBoolean, String paramString1, ArrayList<kotlin.r<String, String>> paramArrayList, String paramString2)
    {
      AppMethodBeat.i(149742);
      this.plZ = paramBoolean;
      this.title = paramString1;
      this.pma = paramArrayList;
      this.nSg = paramString2;
      AppMethodBeat.o(149742);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemWithForceNotify;", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "check", "", "title", "", "sampleWordings", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "templateId", "forceNotify", "(ZLjava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Z)V", "getForceNotify", "()Z", "setForceNotify", "(Z)V", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class e
    extends f.c
  {
    public boolean phv;
    
    public e(boolean paramBoolean1, String paramString1, ArrayList<kotlin.r<String, String>> paramArrayList, String paramString2, boolean paramBoolean2)
    {
      super(paramString1, paramArrayList, paramString2);
      AppMethodBeat.i(236580);
      this.phv = paramBoolean2;
      AppMethodBeat.o(236580);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemWithVoice;", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "check", "", "title", "", "sampleWordings", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "templateId", "voiceMediaUrl", "(ZLjava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;)V", "allowVoice", "getAllowVoice", "()Z", "setAllowVoice", "(Z)V", "getVoiceMediaUrl", "()Ljava/lang/String;", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    extends f.c
  {
    final String pmj;
    public boolean pmk;
    
    public f(boolean paramBoolean, String paramString1, ArrayList<kotlin.r<String, String>> paramArrayList, String paramString2, String paramString3)
    {
      super(paramString1, paramArrayList, paramString2);
      AppMethodBeat.i(236585);
      this.pmj = paramString3;
      AppMethodBeat.o(236585);
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$SubscribeRequestDialogListener;", "", "onDismiss", "", "onShow", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface h
  {
    public abstract void onDismiss();
    
    public abstract void onShow();
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
    implements kotlin.g.a.a<ah>
  {
    j(long paramLong)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$applyRotation$3", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class l
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    l(f paramf) {}
    
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(236571);
      f.e(this.pmq).getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      if (f.g(this.pmq) == f.b.plV) {
        f.a(this.pmq, f.h(this.pmq));
      }
      AppMethodBeat.o(236571);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$closeSampleView$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class m
    extends AnimatorListenerAdapter
  {
    m(f paramf) {}
    
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(149758);
      Object localObject = f.d(this.pmq);
      if (localObject != null)
      {
        paramAnimator = this.pmq;
        int i = ((Number)localObject).intValue();
        localObject = f.f(paramAnimator).findViewById(i);
        if (localObject != null) {
          ((LinearLayout)f.f(paramAnimator).findViewById(a.d.container)).removeView((View)localObject);
        }
      }
      com.tencent.mm.plugin.appbrand.widget.a.a.dQ(f.e(this.pmq));
      AppMethodBeat.o(149758);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$showSample$1$2", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class n
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    n(f paramf) {}
    
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(236579);
      f.f(this.pmq).getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      f.a(this.pmq, (Animator.AnimatorListener)new a(this.pmq));
      AppMethodBeat.o(236579);
    }
    
    @Metadata(d1={""}, d2={"com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$showSample$1$2$onGlobalLayout$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      extends AnimatorListenerAdapter
    {
      a(f paramf) {}
      
      public final void onAnimationEnd(Animator paramAnimator)
      {
        AppMethodBeat.i(236602);
        com.tencent.mm.plugin.appbrand.widget.a.a.dQ(f.f(this.pmq));
        AppMethodBeat.o(236602);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.f
 * JD-Core Version:    0.7.0.1
 */
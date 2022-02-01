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
import android.view.View.OnClickListener;
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
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.modelappbrand.a.e;
import com.tencent.mm.msgsubscription.a.c;
import com.tencent.mm.msgsubscription.a.d;
import com.tencent.mm.msgsubscription.a.e;
import com.tencent.mm.msgsubscription.a.f;
import com.tencent.mm.plugin.appbrand.widget.dialog.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.t;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "context", "Landroid/content/Context;", "items", "", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "listener", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Listener;", "isSingleMode", "", "singleVoiceTmpMode", "(Landroid/content/Context;Ljava/util/List;Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Listener;ZZ)V", "_position", "", "value", "", "actionDesc", "getActionDesc", "()Ljava/lang/String;", "setActionDesc", "(Ljava/lang/String;)V", "actionTv", "Landroid/widget/TextView;", "adapter", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemAdapter;", "alwaysKeepCb", "Landroid/widget/CheckBox;", "alwaysKeepText", "getAlwaysKeepText", "setAlwaysKeepText", "alwaysKeepTv", "alwaysKeepView", "Landroid/view/View;", "alwaysRejectText", "getAlwaysRejectText", "setAlwaysRejectText", "alwaysRejectTv", "appName", "getAppName", "setAppName", "appNameTv", "cancelBtn", "Landroid/widget/Button;", "cancelBtnText", "getCancelBtnText", "setCancelBtnText", "container", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "contentType", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ContentType;", "defaultIconRes", "getDefaultIconRes", "()I", "setDefaultIconRes", "(I)V", "desc", "getDesc", "setDesc", "descTV", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$SubscribeRequestDialogListener;", "dialogListener", "getDialogListener", "()Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$SubscribeRequestDialogListener;", "setDialogListener", "(Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$SubscribeRequestDialogListener;)V", "dialogView", "dialogViewContainer", "Landroid/widget/FrameLayout;", "iconIv", "Landroid/widget/ImageView;", "iconUrl", "getIconUrl", "setIconUrl", "", "mRootView", "okBtn", "okBtnText", "getOkBtnText", "setOkBtnText", "recyclerViewContainer", "sampleBack", "sampleRoot", "sampleShowing", "sampleTitle", "getSampleTitle", "setSampleTitle", "sampleViewId", "Ljava/lang/Integer;", "sampleViewTitle", "scrollView", "Landroid/widget/ScrollView;", "showAlwaysKeepView", "getShowAlwaysKeepView", "()Z", "setShowAlwaysKeepView", "(Z)V", "showAlwaysRejectView", "getShowAlwaysRejectView", "setShowAlwaysRejectView", "stopVoiceBroadcastTask", "Lkotlin/Function0;", "", "templateShowSampleListener", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Companion$TemplateShowSampleListener;", "getTemplateShowSampleListener", "()Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Companion$TemplateShowSampleListener;", "setTemplateShowSampleListener", "(Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Companion$TemplateShowSampleListener;)V", "tip", "getTip", "setTip", "tipTv", "topSampleBtn", "addRecyclerView", "addSingleVoiceTmpMode", "item", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemWithVoice;", "alwaysKeepSelected", "applyRotation", "rotation", "cancel", "closeSampleView", "dismiss", "dispatchCancelEvent", "dispatchEvent", "event", "getContentView", "getPosition", "getRotation", "isCancelable", "isCanceledOnTouchOutside", "onBackPressedEvent", "onCancel", "onCheckedCountChanged", "size", "onDismiss", "onScreenOrientationChanged", "onShow", "dialogHelper", "setPosition", "position", "showSample", "startSampleAnimation", "show", "Landroid/animation/Animator$AnimatorListener;", "setBoldStyle", "Companion", "ContentType", "Item", "ItemAdapter", "ItemWithVoice", "Listener", "SubscribeRequestDialogListener", "wxbiz-msgsubscription-sdk_release"})
public class c
  implements j
{
  public static final c.a msu;
  private String appName;
  private final Context context;
  private String desc;
  private String iconUrl;
  private ScrollView jbL;
  private ImageView jmf;
  private Button kEt;
  private Button kGN;
  private TextView kJW;
  private List<c.c> lxh;
  private View mrI;
  private FrameLayout mrJ;
  private d mrK;
  private TextView mrL;
  private TextView mrM;
  private TextView mrN;
  private View mrO;
  private FrameLayout mrP;
  private View mrQ;
  private View mrR;
  private TextView mrS;
  public TextView mrT;
  public View mrU;
  public CheckBox mrV;
  private TextView mrW;
  private View mrX;
  private boolean mrY;
  private Integer mrZ;
  private com.tencent.mm.plugin.appbrand.widget.dialog.l msa;
  private c.b msb;
  private kotlin.g.a.a<x> msc;
  public a.a msd;
  private String mse;
  private String msf;
  public boolean msh;
  private String msi;
  public boolean msj;
  private String msk;
  private String msl;
  private String msm;
  private String msn;
  public int mso;
  public g msp;
  private int msq;
  private c.f msr;
  private final boolean mss;
  private final boolean mst;
  
  static
  {
    AppMethodBeat.i(149783);
    msu = new c.a((byte)0);
    AppMethodBeat.o(149783);
  }
  
  public c(Context paramContext, List<? extends c.c> paramList, c.f paramf, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(263760);
    this.context = paramContext;
    this.msr = paramf;
    this.mss = paramBoolean1;
    this.mst = paramBoolean2;
    paramContext = LayoutInflater.from(this.context).inflate(a.e.subscribe_msg_request_dialog, null);
    p.j(paramContext, "LayoutInflater.from(cont…msg_request_dialog, null)");
    this.mrI = paramContext;
    this.lxh = ((List)new ArrayList());
    this.msb = c.b.msw;
    this.iconUrl = "";
    this.appName = "";
    this.mse = "";
    this.msf = "";
    this.msh = true;
    this.msi = "";
    this.msj = true;
    this.msk = "";
    this.desc = "";
    this.msl = "";
    this.msm = "";
    this.msn = "";
    paramContext = this.mrI.findViewById(a.d.item_list_container);
    p.j(paramContext, "mRootView.findViewById(R.id.item_list_container)");
    this.mrJ = ((FrameLayout)paramContext);
    paramContext = this.mrI.findViewById(a.d.scroll_view);
    p.j(paramContext, "mRootView.findViewById(R.id.scroll_view)");
    this.jbL = ((ScrollView)paramContext);
    paramContext = this.mrI.findViewById(a.d.icon_iv);
    p.j(paramContext, "mRootView.findViewById(R.id.icon_iv)");
    this.jmf = ((ImageView)paramContext);
    paramContext = this.mrI.findViewById(a.d.action);
    p.j(paramContext, "mRootView.findViewById(R.id.action)");
    this.kJW = ((TextView)paramContext);
    paramContext = this.mrI.findViewById(a.d.desc);
    p.j(paramContext, "mRootView.findViewById(R.id.desc)");
    this.mrM = ((TextView)paramContext);
    paramContext = this.mrI.findViewById(a.d.tip);
    p.j(paramContext, "mRootView.findViewById(R.id.tip)");
    this.mrN = ((TextView)paramContext);
    paramContext = this.mrI.findViewById(a.d.app_name_tv);
    p.j(paramContext, "mRootView.findViewById(R.id.app_name_tv)");
    this.mrL = ((TextView)paramContext);
    paramContext = this.mrI.findViewById(a.d.dialog_cancel);
    p.j(paramContext, "mRootView.findViewById(R.id.dialog_cancel)");
    this.kGN = ((Button)paramContext);
    paramContext = this.mrI.findViewById(a.d.dialog_ok);
    p.j(paramContext, "mRootView.findViewById(R.id.dialog_ok)");
    this.kEt = ((Button)paramContext);
    paramContext = this.mrI.findViewById(a.d.sample_root);
    p.j(paramContext, "mRootView.findViewById(R.id.sample_root)");
    this.mrO = paramContext;
    paramContext = this.mrI.findViewById(a.d.sample_view_title);
    p.j(paramContext, "mRootView.findViewById(R.id.sample_view_title)");
    this.mrW = ((TextView)paramContext);
    paramContext = this.mrI.findViewById(a.d.dialog_view_container);
    p.j(paramContext, "mRootView.findViewById(R.id.dialog_view_container)");
    this.mrP = ((FrameLayout)paramContext);
    paramContext = this.mrI.findViewById(a.d.dialog_view);
    p.j(paramContext, "mRootView.findViewById(R.id.dialog_view)");
    this.mrQ = paramContext;
    paramContext = this.mrI.findViewById(a.d.sample_back);
    p.j(paramContext, "mRootView.findViewById(R.id.sample_back)");
    this.mrR = paramContext;
    paramContext = this.mrI.findViewById(a.d.always_keep_tv);
    p.j(paramContext, "mRootView.findViewById(R.id.always_keep_tv)");
    this.mrS = ((TextView)paramContext);
    paramContext = this.mrI.findViewById(a.d.once_type_always_keep_layout);
    p.j(paramContext, "mRootView.findViewById(R…_type_always_keep_layout)");
    this.mrU = paramContext;
    paramContext = this.mrI.findViewById(a.d.always_keep_checkbox);
    p.j(paramContext, "mRootView.findViewById(R.id.always_keep_checkbox)");
    this.mrV = ((CheckBox)paramContext);
    paramContext = this.mrI.findViewById(a.d.always_reject_tv);
    p.j(paramContext, "mRootView.findViewById(R.id.always_reject_tv)");
    this.mrT = ((TextView)paramContext);
    paramContext = this.mrI.findViewById(a.d.top_sample);
    p.j(paramContext, "mRootView.findViewById(R.id.top_sample)");
    this.mrX = paramContext;
    this.mrI.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new c.1(this));
    this.mrP.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(149736);
        if (c.j(this.msv).getHeight() > 0) {
          c.d(this.msv).getLayoutParams().height = c.j(this.msv).getHeight();
        }
        AppMethodBeat.o(149736);
      }
    });
    this.lxh.addAll((Collection)paramList);
    if (this.mss)
    {
      this.msb = c.b.msx;
      this.mrJ.setVisibility(8);
      this.mrX.setVisibility(0);
      this.mrX.setOnClickListener((View.OnClickListener)new c.3(this, paramList));
    }
    for (;;)
    {
      this.kEt.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(149738);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          c.b(this.msv, 1);
          this.msv.dismiss();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(149738);
        }
      });
      this.kGN.setOnClickListener((View.OnClickListener)new c.5(this));
      this.mrU.setOnClickListener((View.OnClickListener)new c.6(this, paramList));
      this.mrT.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(149741);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          c.b(this.msv, 3);
          this.msv.dismiss();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(149741);
        }
      });
      this.msq = 2;
      AppMethodBeat.o(263760);
      return;
      if (this.mst)
      {
        this.msb = c.b.msy;
        paramContext = paramList.get(0);
        if (paramContext == null)
        {
          paramContext = new t("null cannot be cast to non-null type com.tencent.mm.msgsubscription.ui.SubscribeMsgRequestDialog.ItemWithVoice");
          AppMethodBeat.o(263760);
          throw paramContext;
        }
        Object localObject1 = (c.e)paramContext;
        this.mrJ.removeAllViews();
        paramContext = new LinearLayout(this.context);
        paramContext.setBackgroundColor(0);
        paramContext.setOrientation(1);
        paramContext.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        Object localObject2 = new aa.f();
        aa.f localf = new aa.f();
        paramf = LayoutInflater.from(this.context).inflate(a.e.subscribe_msg_voice_broadcast_item_layout, null);
        View localView = paramf.findViewById(a.d.icon_check);
        Object localObject3 = (WeImageView)localView;
        p.j(localObject3, "it");
        ((WeImageView)localObject3).setVisibility(0);
        ((aa.f)localObject2).aaBC = ((WeImageView)localView);
        localView = paramf.findViewById(a.d.desc);
        p.j(localView, "acceptView.findViewById<TextView>(R.id.desc)");
        ((TextView)localView).setText((CharSequence)this.context.getString(a.f.biz_subscribe_msg_voice_template_accept));
        localView = LayoutInflater.from(this.context).inflate(a.e.subscribe_msg_voice_broadcast_item_layout, null);
        localObject3 = localView.findViewById(a.d.icon_check);
        Object localObject4 = (WeImageView)localObject3;
        p.j(localObject4, "it");
        ((WeImageView)localObject4).setVisibility(8);
        localf.aaBC = ((WeImageView)localObject3);
        localObject3 = (WeImageView)localView.findViewById(a.d.icon_btn);
        p.j(localObject3, "it");
        ((WeImageView)localObject3).setVisibility(8);
        localObject4 = (CharSequence)((c.e)localObject1).msK;
        if ((localObject4 == null) || (((CharSequence)localObject4).length() == 0)) {}
        for (int i = 1;; i = 0)
        {
          if (i == 0)
          {
            ((WeImageView)localObject3).setVisibility(0);
            ((WeImageView)localObject3).setOnClickListener((View.OnClickListener)new c.i(this, localf, (c.e)localObject1));
          }
          localObject3 = localView.findViewById(a.d.desc);
          p.j(localObject3, "acceptWithVoiceView.find…ById<TextView>(R.id.desc)");
          ((TextView)localObject3).setText((CharSequence)this.context.getString(a.f.biz_subscribe_msg_voice_template_accept_play_voice));
          paramf.setOnClickListener((View.OnClickListener)new c.j((aa.f)localObject2, localf, (c.e)localObject1));
          localView.setOnClickListener((View.OnClickListener)new c.k(localf, (aa.f)localObject2, (c.e)localObject1));
          localObject1 = (kotlin.g.a.a)new c.l(this);
          localObject2 = this.context.getResources();
          p.j(localObject2, "context.resources");
          i = (int)TypedValue.applyDimension(1, 56.0F, ((Resources)localObject2).getDisplayMetrics());
          paramContext.addView((View)((kotlin.g.a.a)localObject1).invoke());
          paramContext.addView(paramf, new ViewGroup.LayoutParams(-1, i));
          paramContext.addView((View)((kotlin.g.a.a)localObject1).invoke());
          paramContext.addView(localView, new ViewGroup.LayoutParams(-1, i));
          paramContext.addView((View)((kotlin.g.a.a)localObject1).invoke());
          this.mrJ.addView((View)paramContext, new ViewGroup.LayoutParams(-1, -2));
          break;
        }
      }
      this.msb = c.b.msw;
      aI(paramList);
    }
  }
  
  private final void a(boolean paramBoolean, Animator.AnimatorListener paramAnimatorListener)
  {
    AppMethodBeat.i(149771);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    Object localObject;
    ObjectAnimator localObjectAnimator;
    if (paramBoolean)
    {
      localObject = ObjectAnimator.ofFloat(this.mrP, View.TRANSLATION_X, new float[] { 0.0F, -this.mrP.getWidth() }).setDuration(200L);
      p.j(localObject, "it");
      ((ObjectAnimator)localObject).setInterpolator((TimeInterpolator)new com.tencent.mm.msgsubscription.ui.a.a());
      localObject = (Animator)localObject;
      localObjectAnimator = ObjectAnimator.ofFloat(this.mrO, View.TRANSLATION_X, new float[] { this.mrO.getWidth(), 0.0F }).setDuration(200L);
      p.j(localObjectAnimator, "it");
      localObjectAnimator.setInterpolator((TimeInterpolator)new com.tencent.mm.msgsubscription.ui.a.a());
      localAnimatorSet.playTogether(new Animator[] { localObject, (Animator)localObjectAnimator });
    }
    for (;;)
    {
      if (paramAnimatorListener != null) {
        localAnimatorSet.addListener(paramAnimatorListener);
      }
      localAnimatorSet.start();
      AppMethodBeat.o(149771);
      return;
      localObject = ObjectAnimator.ofFloat(this.mrP, View.TRANSLATION_X, new float[] { -this.mrP.getWidth(), 0.0F }).setDuration(200L);
      p.j(localObject, "it");
      ((ObjectAnimator)localObject).setInterpolator((TimeInterpolator)new com.tencent.mm.msgsubscription.ui.a.a());
      localObject = (Animator)localObject;
      localObjectAnimator = ObjectAnimator.ofFloat(this.mrO, View.TRANSLATION_X, new float[] { 0.0F, this.mrO.getWidth() }).setDuration(200L);
      p.j(localObjectAnimator, "it");
      localObjectAnimator.setInterpolator((TimeInterpolator)new com.tencent.mm.msgsubscription.ui.a.a());
      localAnimatorSet.playTogether(new Animator[] { localObject, (Animator)localObjectAnimator });
    }
  }
  
  private final void aI(List<? extends c.c> paramList)
  {
    AppMethodBeat.i(149769);
    RecyclerView localRecyclerView = new RecyclerView(this.context);
    this.mrJ.removeAllViews();
    this.mrJ.addView((View)localRecyclerView, new ViewGroup.LayoutParams(-1, -2));
    this.mrK = new d(paramList, this);
    paramList = this.mrK;
    if (paramList == null) {
      p.bGy("adapter");
    }
    localRecyclerView.setAdapter((RecyclerView.a)paramList);
    localRecyclerView.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    localRecyclerView.b((RecyclerView.h)new c.h(this));
    AppMethodBeat.o(149769);
  }
  
  private final boolean bsA()
  {
    AppMethodBeat.i(149773);
    if (this.mrY)
    {
      a(false, (Animator.AnimatorListener)new o(this));
      this.mrY = false;
      AppMethodBeat.o(149773);
      return true;
    }
    AppMethodBeat.o(149773);
    return false;
  }
  
  private final int getRotation()
  {
    AppMethodBeat.i(149770);
    Object localObject = this.context.getSystemService("window");
    if (localObject == null)
    {
      localObject = new t("null cannot be cast to non-null type android.view.WindowManager");
      AppMethodBeat.o(149770);
      throw ((Throwable)localObject);
    }
    localObject = ((WindowManager)localObject).getDefaultDisplay();
    p.j(localObject, "(context.getSystemServic…owManager).defaultDisplay");
    int i = ((Display)localObject).getRotation();
    AppMethodBeat.o(149770);
    return i;
  }
  
  private static void h(TextView paramTextView)
  {
    AppMethodBeat.i(149768);
    TextPaint localTextPaint = paramTextView.getPaint();
    p.j(localTextPaint, "paint");
    localTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    paramTextView = paramTextView.getPaint();
    p.j(paramTextView, "paint");
    paramTextView.setStrokeWidth(0.8F);
    AppMethodBeat.o(149768);
  }
  
  private final void xt(int paramInt)
  {
    AppMethodBeat.i(149778);
    Log.i("SubscribeMsgRequestDialog", "dispatchEvent ".concat(String.valueOf(paramInt)));
    c.f localf = this.msr;
    if (localf != null)
    {
      List localList = (List)new ArrayList();
      localList.addAll((Collection)this.lxh);
      localf.c(paramInt, localList);
      AppMethodBeat.o(149778);
      return;
    }
    AppMethodBeat.o(149778);
  }
  
  private final void xv(int paramInt)
  {
    AppMethodBeat.i(149781);
    Object localObject;
    ViewGroup.LayoutParams localLayoutParams;
    if ((paramInt == 1) || (paramInt == 3))
    {
      localObject = this.mrI;
      localLayoutParams = this.mrI.getLayoutParams();
      localLayoutParams.width = d.dg(this.context);
      ((View)localObject).setLayoutParams(localLayoutParams);
      if (this.jbL.indexOfChild(this.mrQ) == -1)
      {
        localObject = this.mrQ.getParent();
        if (localObject != null)
        {
          if (localObject == null)
          {
            localObject = new t("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(149781);
            throw ((Throwable)localObject);
          }
          ((ViewGroup)localObject).removeView(this.mrQ);
        }
        this.jbL.addView(this.mrQ);
        this.jbL.setVisibility(0);
      }
    }
    for (;;)
    {
      this.mrI.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new n(this));
      AppMethodBeat.o(149781);
      return;
      if (d.dh(this.context)) {
        d.b(this.mrI, (kotlin.g.a.a)new c.m(this));
      }
      while (this.mrP.indexOfChild(this.mrQ) == -1)
      {
        localObject = this.mrQ.getParent();
        if (localObject == null) {
          break label268;
        }
        if (localObject != null) {
          break label257;
        }
        localObject = new t("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(149781);
        throw ((Throwable)localObject);
        localObject = this.mrI;
        localLayoutParams = this.mrI.getLayoutParams();
        localLayoutParams.width = -1;
        ((View)localObject).setLayoutParams(localLayoutParams);
      }
      continue;
      label257:
      ((ViewGroup)localObject).removeView(this.mrQ);
      label268:
      this.mrP.addView(this.mrQ);
      this.jbL.setVisibility(8);
    }
  }
  
  public final void Zc(String paramString)
  {
    AppMethodBeat.i(149762);
    p.k(paramString, "value");
    this.appName = paramString;
    this.mrL.setText((CharSequence)this.appName);
    h(this.mrL);
    AppMethodBeat.o(149762);
  }
  
  public final void Zd(String paramString)
  {
    AppMethodBeat.i(263744);
    p.k(paramString, "<set-?>");
    this.mse = paramString;
    AppMethodBeat.o(263744);
  }
  
  public final void Ze(String paramString)
  {
    AppMethodBeat.i(263746);
    p.k(paramString, "value");
    this.msf = paramString;
    this.mrU.setVisibility(0);
    this.mrS.setText((CharSequence)this.msf);
    this.mrT.setVisibility(8);
    AppMethodBeat.o(263746);
  }
  
  public final void Zf(String paramString)
  {
    AppMethodBeat.i(263748);
    p.k(paramString, "value");
    this.msi = paramString;
    this.mrT.setVisibility(0);
    this.mrT.setText((CharSequence)this.msi);
    this.mrU.setVisibility(8);
    AppMethodBeat.o(263748);
  }
  
  public final void Zg(String paramString)
  {
    AppMethodBeat.i(149763);
    p.k(paramString, "value");
    this.msk = paramString;
    this.kJW.setText((CharSequence)this.msk);
    h(this.kJW);
    AppMethodBeat.o(149763);
  }
  
  public final void Zh(String paramString)
  {
    AppMethodBeat.i(149765);
    p.k(paramString, "value");
    this.msl = paramString;
    this.kEt.setText((CharSequence)this.msl);
    AppMethodBeat.o(149765);
  }
  
  public final void Zi(String paramString)
  {
    AppMethodBeat.i(149766);
    p.k(paramString, "value");
    this.msm = paramString;
    this.kGN.setText((CharSequence)this.msm);
    AppMethodBeat.o(149766);
  }
  
  public final void Zj(String paramString)
  {
    AppMethodBeat.i(149767);
    p.k(paramString, "value");
    this.msn = paramString;
    this.mrN.setText((CharSequence)this.msn);
    paramString = this.mrN;
    if (((CharSequence)this.msn).length() == 0)
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
  
  public final void a(com.tencent.mm.plugin.appbrand.widget.dialog.l paraml)
  {
    AppMethodBeat.i(149776);
    com.tencent.mm.modelappbrand.a.b.bhh().a(this.jmf, this.iconUrl, this.mso, (b.h)new e());
    this.msa = paraml;
    xv(getRotation());
    paraml = this.msp;
    if (paraml != null)
    {
      paraml.onShow();
      AppMethodBeat.o(149776);
      return;
    }
    AppMethodBeat.o(149776);
  }
  
  public final boolean bsB()
  {
    AppMethodBeat.i(149774);
    boolean bool = bsA();
    AppMethodBeat.o(149774);
    return bool;
  }
  
  public final boolean bsC()
  {
    return false;
  }
  
  public void cancel()
  {
    AppMethodBeat.i(149779);
    xt(2);
    dismiss();
    AppMethodBeat.o(149779);
  }
  
  public void dismiss()
  {
    AppMethodBeat.i(149775);
    Object localObject = this.msa;
    if (localObject != null) {
      ((com.tencent.mm.plugin.appbrand.widget.dialog.l)localObject).b((j)this);
    }
    localObject = this.msp;
    if (localObject != null) {
      ((g)localObject).onDismiss();
    }
    localObject = this.msc;
    if (localObject != null)
    {
      ((kotlin.g.a.a)localObject).invoke();
      AppMethodBeat.o(149775);
      return;
    }
    AppMethodBeat.o(149775);
  }
  
  public final View getContentView()
  {
    return this.mrI;
  }
  
  public final int getPosition()
  {
    return this.msq;
  }
  
  public boolean isCancelable()
  {
    return false;
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(149777);
    xt(2);
    AppMethodBeat.o(149777);
  }
  
  public final void setDesc(String paramString)
  {
    AppMethodBeat.i(149764);
    p.k(paramString, "value");
    this.desc = paramString;
    this.mrM.setText((CharSequence)this.desc);
    AppMethodBeat.o(149764);
  }
  
  public final void setIconUrl(String paramString)
  {
    AppMethodBeat.i(149761);
    p.k(paramString, "value");
    this.iconUrl = paramString;
    AppMethodBeat.o(149761);
  }
  
  public final void setPosition(int paramInt)
  {
    AppMethodBeat.i(263754);
    this.msq = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(263754);
      return;
      View localView = this.mrI.findViewById(a.d.dialog_view_root_container);
      p.j(localView, "mRootView.findViewById<V…alog_view_root_container)");
      localView.setBackground(androidx.core.content.a.m(this.context, a.c.subscribe_msg_request_dialog_center_style_bg));
      AppMethodBeat.o(263754);
      return;
      localView = this.mrI.findViewById(a.d.dialog_view_root_container);
      p.j(localView, "mRootView.findViewById<V…alog_view_root_container)");
      localView.setBackground(androidx.core.content.a.m(this.context, a.c.subscribe_msg_request_dialog_bg));
    }
  }
  
  public final void xu(int paramInt)
  {
    AppMethodBeat.i(149780);
    xv(paramInt);
    AppMethodBeat.o(149780);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Companion$TemplateShowSampleListener;", "", "onSampleShow", "", "templateId", "", "check", "", "index", "", "wxbiz-msgsubscription-sdk_release"})
  public static abstract interface a$a
  {
    public abstract void aV(String paramString, int paramInt);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemAdapter$Holder;", "items", "", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "dialog", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog;", "(Ljava/util/List;Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog;)V", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "itemsChecked", "", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Holder", "wxbiz-msgsubscription-sdk_release"})
  public static final class d
    extends RecyclerView.a<a>
  {
    List<? extends c.c> lxh;
    private final List<c.c> msD;
    private final c msE;
    
    public d(List<? extends c.c> paramList, c paramc)
    {
      AppMethodBeat.i(149752);
      this.lxh = paramList;
      this.msE = paramc;
      this.msD = ((List)new ArrayList());
      paramList = this.msD;
      Object localObject1 = (Iterable)this.lxh;
      paramc = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if (((c.c)localObject2).msB) {
          paramc.add(localObject2);
        }
      }
      paramList.addAll((Collection)paramc);
      c.a(this.msE, this.msD.size());
      AppMethodBeat.o(149752);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(149750);
      int i = this.lxh.size();
      AppMethodBeat.o(149750);
      return i;
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemAdapter$Holder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "item", "Landroid/view/View;", "(Landroid/view/View;)V", "checkBox", "Landroid/widget/CheckBox;", "getCheckBox", "()Landroid/widget/CheckBox;", "setCheckBox", "(Landroid/widget/CheckBox;)V", "desc", "Landroid/widget/TextView;", "getDesc", "()Landroid/widget/TextView;", "setDesc", "(Landroid/widget/TextView;)V", "sample", "getSample", "()Landroid/view/View;", "setSample", "wxbiz-msgsubscription-sdk_release"})
    public static final class a
      extends RecyclerView.v
    {
      CheckBox checkBox;
      TextView msF;
      View msG;
      
      public a(View paramView)
      {
        super();
        AppMethodBeat.i(149746);
        paramView = this.amk.findViewById(a.d.checkbox);
        p.j(paramView, "itemView.findViewById(R.id.checkbox)");
        this.checkBox = ((CheckBox)paramView);
        paramView = this.amk.findViewById(a.d.desc);
        p.j(paramView, "itemView.findViewById(R.id.desc)");
        this.msF = ((TextView)paramView);
        paramView = this.amk.findViewById(a.d.sample);
        p.j(paramView, "itemView.findViewById(R.id.sample)");
        this.msG = paramView;
        AppMethodBeat.o(149746);
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b
      implements View.OnClickListener
    {
      b(c.d paramd, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(149747);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        c.a(c.d.a(this.msH), (c.c)this.msH.lxh.get(this.jEN));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(149747);
      }
    }
    
    @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c
      implements View.OnClickListener
    {
      c(c.d paramd, c.d.a parama, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(149748);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemAdapter$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramView = this.msI.checkBox;
        boolean bool;
        if (!this.msI.checkBox.isChecked())
        {
          bool = true;
          paramView.setChecked(bool);
          ((c.c)this.msH.lxh.get(this.jEN)).msB = this.msI.checkBox.isChecked();
          if (!((c.c)this.msH.lxh.get(this.jEN)).msB) {
            break label193;
          }
          c.d.b(this.msH).add(this.msH.lxh.get(this.jEN));
        }
        for (;;)
        {
          c.a(c.d.a(this.msH), c.d.b(this.msH).size());
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemAdapter$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(149748);
          return;
          bool = false;
          break;
          label193:
          c.d.b(this.msH).remove(this.msH.lxh.get(this.jEN));
        }
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$SubscribeRequestDialogListener;", "", "onDismiss", "", "onShow", "wxbiz-msgsubscription-sdk_release"})
  public static abstract interface g
  {
    public abstract void onDismiss();
    
    public abstract void onShow();
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$applyRotation$6", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "wxbiz-msgsubscription-sdk_release"})
  public static final class n
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(174567);
      c.f(this.msv).getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      if (c.g(this.msv) == c.b.msw) {
        c.a(this.msv, c.h(this.msv));
      }
      AppMethodBeat.o(174567);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$closeSampleView$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "wxbiz-msgsubscription-sdk_release"})
  public static final class o
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(149758);
      paramAnimator = c.e(this.msv);
      if (paramAnimator != null)
      {
        int i = ((Number)paramAnimator).intValue();
        paramAnimator = c.d(this.msv).findViewById(i);
        if (paramAnimator != null)
        {
          ((LinearLayout)c.d(this.msv).findViewById(a.d.container)).removeView(paramAnimator);
          AppMethodBeat.o(149758);
          return;
        }
        AppMethodBeat.o(149758);
        return;
      }
      AppMethodBeat.o(149758);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$showSample$1$2", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "wxbiz-msgsubscription-sdk_release"})
  public static final class q
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    q(c paramc) {}
    
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(149760);
      c.d(this.msv).getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      c.a(this.msv);
      AppMethodBeat.o(149760);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.c
 * JD-Core Version:    0.7.0.1
 */
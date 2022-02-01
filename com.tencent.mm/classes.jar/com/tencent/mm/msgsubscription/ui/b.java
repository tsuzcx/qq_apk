package com.tencent.mm.msgsubscription.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.s;
import android.support.v7.widget.RecyclerView.v;
import android.text.TextPaint;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.e;
import com.tencent.mm.plugin.appbrand.widget.dialog.k;
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.o;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "context", "Landroid/content/Context;", "items", "", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "listener", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Listener;", "isSingleMode", "", "(Landroid/content/Context;Ljava/util/List;Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Listener;Z)V", "_position", "", "value", "", "actionDesc", "getActionDesc", "()Ljava/lang/String;", "setActionDesc", "(Ljava/lang/String;)V", "actionTv", "Landroid/widget/TextView;", "adapter", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemAdapter;", "alwaysKeepCb", "Landroid/widget/CheckBox;", "alwaysKeepText", "getAlwaysKeepText", "setAlwaysKeepText", "alwaysKeepTv", "alwaysKeepView", "Landroid/view/View;", "alwaysRejectText", "getAlwaysRejectText", "setAlwaysRejectText", "alwaysRejectTv", "appName", "getAppName", "setAppName", "appNameTv", "cancelBtn", "Landroid/widget/Button;", "cancelBtnText", "getCancelBtnText", "setCancelBtnText", "container", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "defaultIconRes", "getDefaultIconRes", "()I", "setDefaultIconRes", "(I)V", "desc", "getDesc", "setDesc", "descTV", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$SubscribeRequestDialogListener;", "dialogListener", "getDialogListener", "()Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$SubscribeRequestDialogListener;", "setDialogListener", "(Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$SubscribeRequestDialogListener;)V", "dialogView", "dialogViewContainer", "Landroid/widget/FrameLayout;", "iconIv", "Landroid/widget/ImageView;", "iconUrl", "getIconUrl", "setIconUrl", "", "mRootView", "okBtn", "okBtnText", "getOkBtnText", "setOkBtnText", "recyclerViewContainer", "sampleBack", "sampleRoot", "sampleShowing", "sampleTitle", "getSampleTitle", "setSampleTitle", "sampleViewId", "Ljava/lang/Integer;", "sampleViewTitle", "scrollView", "Landroid/widget/ScrollView;", "showAlwaysKeepView", "getShowAlwaysKeepView", "()Z", "setShowAlwaysKeepView", "(Z)V", "showAlwaysRejectView", "getShowAlwaysRejectView", "setShowAlwaysRejectView", "templateShowSampleListener", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Companion$TemplateShowSampleListener;", "getTemplateShowSampleListener", "()Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Companion$TemplateShowSampleListener;", "setTemplateShowSampleListener", "(Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Companion$TemplateShowSampleListener;)V", "tip", "getTip", "setTip", "tipTv", "topSampleBtn", "addRecyclerView", "", "alwaysKeepSelected", "applyRotation", "rotation", "cancel", "closeSampleView", "dismiss", "dispatchCancelEvent", "dispatchEvent", "event", "getContentView", "getPosition", "getRotation", "isCancelable", "isCanceledOnTouchOutside", "onBackPressedEvent", "onCancel", "onCheckedCountChanged", "size", "onDismiss", "onScreenOrientationChanged", "onShow", "dialogHelper", "setPosition", "position", "showSample", "item", "startSampleAnimation", "show", "Landroid/animation/Animator$AnimatorListener;", "setBoldStyle", "Companion", "Item", "ItemAdapter", "Listener", "SubscribeRequestDialogListener", "wxbiz-msgsubscription-sdk_release"})
public class b
  implements k
{
  public static final a jCu;
  private String appName;
  private final Context context;
  private String desc;
  private ImageView gBZ;
  private ScrollView gxx;
  private Button hPX;
  private Button hSq;
  private TextView hVv;
  private List<b> iHf;
  private String iconUrl;
  private View jBN;
  private FrameLayout jBO;
  private c jBP;
  private TextView jBQ;
  private TextView jBR;
  private TextView jBS;
  private View jBT;
  private FrameLayout jBU;
  private View jBV;
  private View jBW;
  private TextView jBX;
  public TextView jBY;
  public View jBZ;
  public CheckBox jCa;
  private TextView jCb;
  private View jCc;
  private boolean jCd;
  private Integer jCe;
  private m jCf;
  public b.a.a jCg;
  private String jCh;
  private String jCi;
  public boolean jCj;
  private String jCk;
  public boolean jCl;
  private String jCm;
  private String jCn;
  private String jCo;
  private String jCp;
  public int jCq;
  public e jCr;
  private int jCs;
  private b.d jCt;
  
  static
  {
    AppMethodBeat.i(149783);
    jCu = new a((byte)0);
    AppMethodBeat.o(149783);
  }
  
  public b(Context paramContext, final List<b> paramList, b.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(149782);
    this.context = paramContext;
    this.jCt = paramd;
    paramContext = LayoutInflater.from(this.context).inflate(2131496633, null);
    p.g(paramContext, "LayoutInflater.from(cont…msg_request_dialog, null)");
    this.jBN = paramContext;
    this.iHf = ((List)new ArrayList());
    this.iconUrl = "";
    this.appName = "";
    this.jCh = "";
    this.jCi = "";
    this.jCj = true;
    this.jCk = "";
    this.jCl = true;
    this.jCm = "";
    this.desc = "";
    this.jCn = "";
    this.jCo = "";
    this.jCp = "";
    paramContext = this.jBN.findViewById(2131302828);
    p.g(paramContext, "mRootView.findViewById(R.id.item_list_container)");
    this.jBO = ((FrameLayout)paramContext);
    paramContext = this.jBN.findViewById(2131307339);
    p.g(paramContext, "mRootView.findViewById(R.id.scroll_view)");
    this.gxx = ((ScrollView)paramContext);
    paramContext = this.jBN.findViewById(2131302497);
    p.g(paramContext, "mRootView.findViewById(R.id.icon_iv)");
    this.gBZ = ((ImageView)paramContext);
    paramContext = this.jBN.findViewById(2131296356);
    p.g(paramContext, "mRootView.findViewById(R.id.action)");
    this.hVv = ((TextView)paramContext);
    paramContext = this.jBN.findViewById(2131299495);
    p.g(paramContext, "mRootView.findViewById(R.id.desc)");
    this.jBR = ((TextView)paramContext);
    paramContext = this.jBN.findViewById(2131309139);
    p.g(paramContext, "mRootView.findViewById(R.id.tip)");
    this.jBS = ((TextView)paramContext);
    paramContext = this.jBN.findViewById(2131296959);
    p.g(paramContext, "mRootView.findViewById(R.id.app_name_tv)");
    this.jBQ = ((TextView)paramContext);
    paramContext = this.jBN.findViewById(2131299642);
    p.g(paramContext, "mRootView.findViewById(R.id.dialog_cancel)");
    this.hSq = ((Button)paramContext);
    paramContext = this.jBN.findViewById(2131299655);
    p.g(paramContext, "mRootView.findViewById(R.id.dialog_ok)");
    this.hPX = ((Button)paramContext);
    paramContext = this.jBN.findViewById(2131307207);
    p.g(paramContext, "mRootView.findViewById(R.id.sample_root)");
    this.jBT = paramContext;
    paramContext = this.jBN.findViewById(2131307208);
    p.g(paramContext, "mRootView.findViewById(R.id.sample_view_title)");
    this.jCb = ((TextView)paramContext);
    paramContext = this.jBN.findViewById(2131299659);
    p.g(paramContext, "mRootView.findViewById(R.id.dialog_view_container)");
    this.jBU = ((FrameLayout)paramContext);
    paramContext = this.jBN.findViewById(2131299658);
    p.g(paramContext, "mRootView.findViewById(R.id.dialog_view)");
    this.jBV = paramContext;
    paramContext = this.jBN.findViewById(2131307206);
    p.g(paramContext, "mRootView.findViewById(R.id.sample_back)");
    this.jBW = paramContext;
    paramContext = this.jBN.findViewById(2131296730);
    p.g(paramContext, "mRootView.findViewById(R.id.always_keep_tv)");
    this.jBX = ((TextView)paramContext);
    paramContext = this.jBN.findViewById(2131305605);
    p.g(paramContext, "mRootView.findViewById(R…_type_always_keep_layout)");
    this.jBZ = paramContext;
    paramContext = this.jBN.findViewById(2131296729);
    p.g(paramContext, "mRootView.findViewById(R.id.always_keep_checkbox)");
    this.jCa = ((CheckBox)paramContext);
    paramContext = this.jBN.findViewById(2131296731);
    p.g(paramContext, "mRootView.findViewById(R.id.always_reject_tv)");
    this.jBY = ((TextView)paramContext);
    paramContext = this.jBN.findViewById(2131309326);
    p.g(paramContext, "mRootView.findViewById(R.id.top_sample)");
    this.jCc = paramContext;
    this.jBN.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(149735);
        Object localObject = b.f(this.jCv).getParent();
        if (localObject != null)
        {
          if (localObject == null)
          {
            localObject = new t("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(149735);
            throw ((Throwable)localObject);
          }
          localObject = (ViewGroup)localObject;
          int i = b.h(this.jCv);
          if ((i == 1) || (i == 3))
          {
            if (b.f(this.jCv).getLayoutParams().height != -2)
            {
              b.f(this.jCv).getLayoutParams().height = -2;
              b.f(this.jCv).requestLayout();
              AppMethodBeat.o(149735);
            }
          }
          else
          {
            i = ((ViewGroup)localObject).getHeight() - com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 60);
            if (b.f(this.jCv).getHeight() > i)
            {
              b.f(this.jCv).getLayoutParams().height = Math.min(i, b.f(this.jCv).getHeight());
              b.f(this.jCv).requestLayout();
            }
          }
          AppMethodBeat.o(149735);
          return;
        }
        AppMethodBeat.o(149735);
      }
    });
    this.jBU.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(149736);
        if (b.i(this.jCv).getHeight() > 0) {
          b.d(this.jCv).getLayoutParams().height = b.i(this.jCv).getHeight();
        }
        AppMethodBeat.o(149736);
      }
    });
    this.iHf.addAll((Collection)paramList);
    if (paramBoolean)
    {
      this.jBO.setVisibility(8);
      this.jCc.setVisibility(0);
      this.jCc.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(149737);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          b.a(this.jCv, (b.b)paramList.get(0));
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(149737);
        }
      });
    }
    aK(paramList);
    this.hPX.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(149738);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        b.b(this.jCv, 1);
        this.jCv.dismiss();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(149738);
      }
    });
    this.hSq.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(149739);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        this.jCv.cancel();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(149739);
      }
    });
    this.jBZ.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(149740);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = b.j(this.jCv);
        if (!b.j(this.jCv).isChecked()) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.setChecked(bool);
          paramAnonymousView = ((Iterable)paramList).iterator();
          while (paramAnonymousView.hasNext()) {
            ((b.b)paramAnonymousView.next()).jCw = b.j(this.jCv).isChecked();
          }
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(149740);
      }
    });
    this.jBY.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(149741);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        b.b(this.jCv, 3);
        this.jCv.dismiss();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(149741);
      }
    });
    this.jCs = 2;
    AppMethodBeat.o(149782);
  }
  
  private final void a(boolean paramBoolean, Animator.AnimatorListener paramAnimatorListener)
  {
    AppMethodBeat.i(149771);
    AnimatorSet localAnimatorSet = new AnimatorSet();
    Object localObject;
    ObjectAnimator localObjectAnimator;
    if (paramBoolean)
    {
      localObject = ObjectAnimator.ofFloat(this.jBU, View.TRANSLATION_X, new float[] { 0.0F, -this.jBU.getWidth() }).setDuration(200L);
      p.g(localObject, "it");
      ((ObjectAnimator)localObject).setInterpolator((TimeInterpolator)new com.tencent.mm.msgsubscription.ui.a.a());
      localObject = (Animator)localObject;
      localObjectAnimator = ObjectAnimator.ofFloat(this.jBT, View.TRANSLATION_X, new float[] { this.jBT.getWidth(), 0.0F }).setDuration(200L);
      p.g(localObjectAnimator, "it");
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
      localObject = ObjectAnimator.ofFloat(this.jBU, View.TRANSLATION_X, new float[] { -this.jBU.getWidth(), 0.0F }).setDuration(200L);
      p.g(localObject, "it");
      ((ObjectAnimator)localObject).setInterpolator((TimeInterpolator)new com.tencent.mm.msgsubscription.ui.a.a());
      localObject = (Animator)localObject;
      localObjectAnimator = ObjectAnimator.ofFloat(this.jBT, View.TRANSLATION_X, new float[] { 0.0F, this.jBT.getWidth() }).setDuration(200L);
      p.g(localObjectAnimator, "it");
      localObjectAnimator.setInterpolator((TimeInterpolator)new com.tencent.mm.msgsubscription.ui.a.a());
      localAnimatorSet.playTogether(new Animator[] { localObject, (Animator)localObjectAnimator });
    }
  }
  
  private final void aK(List<b> paramList)
  {
    AppMethodBeat.i(149769);
    RecyclerView localRecyclerView = new RecyclerView(this.context);
    this.jBO.removeAllViews();
    this.jBO.addView((View)localRecyclerView, new ViewGroup.LayoutParams(-1, -2));
    this.jBP = new c(paramList, this);
    paramList = this.jBP;
    if (paramList == null) {
      p.btv("adapter");
    }
    localRecyclerView.setAdapter((RecyclerView.a)paramList);
    localRecyclerView.setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager());
    localRecyclerView.b((RecyclerView.h)new f(this));
    AppMethodBeat.o(149769);
  }
  
  private final boolean bja()
  {
    AppMethodBeat.i(149773);
    if (this.jCd)
    {
      a(false, (Animator.AnimatorListener)new i(this));
      this.jCd = false;
      AppMethodBeat.o(149773);
      return true;
    }
    AppMethodBeat.o(149773);
    return false;
  }
  
  private static void g(TextView paramTextView)
  {
    AppMethodBeat.i(149768);
    TextPaint localTextPaint = paramTextView.getPaint();
    p.g(localTextPaint, "paint");
    localTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    paramTextView = paramTextView.getPaint();
    p.g(paramTextView, "paint");
    paramTextView.setStrokeWidth(0.8F);
    AppMethodBeat.o(149768);
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
    p.g(localObject, "(context.getSystemServic…owManager).defaultDisplay");
    int i = ((Display)localObject).getRotation();
    AppMethodBeat.o(149770);
    return i;
  }
  
  private final void us(int paramInt)
  {
    AppMethodBeat.i(149778);
    Log.i("SubscribeMsgRequestDialog", "dispatchEvent ".concat(String.valueOf(paramInt)));
    b.d locald = this.jCt;
    if (locald != null)
    {
      List localList = (List)new ArrayList();
      localList.addAll((Collection)this.iHf);
      locald.c(paramInt, localList);
      AppMethodBeat.o(149778);
      return;
    }
    AppMethodBeat.o(149778);
  }
  
  private final void uu(int paramInt)
  {
    AppMethodBeat.i(149781);
    Object localObject;
    ViewGroup.LayoutParams localLayoutParams;
    if ((paramInt == 1) || (paramInt == 3))
    {
      localObject = this.jBN;
      localLayoutParams = this.jBN.getLayoutParams();
      localLayoutParams.width = c.dj(this.context);
      ((View)localObject).setLayoutParams(localLayoutParams);
      if (this.gxx.indexOfChild(this.jBV) == -1)
      {
        localObject = this.jBV.getParent();
        if (localObject != null)
        {
          if (localObject == null)
          {
            localObject = new t("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(149781);
            throw ((Throwable)localObject);
          }
          ((ViewGroup)localObject).removeView(this.jBV);
        }
        this.gxx.addView(this.jBV);
        this.gxx.setVisibility(0);
      }
    }
    for (;;)
    {
      this.jBN.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new h(this));
      AppMethodBeat.o(149781);
      return;
      if (c.dk(this.context)) {
        c.a(this.jBN, (kotlin.g.a.a)new g(this));
      }
      while (this.jBU.indexOfChild(this.jBV) == -1)
      {
        localObject = this.jBV.getParent();
        if (localObject == null) {
          break label268;
        }
        if (localObject != null) {
          break label257;
        }
        localObject = new t("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(149781);
        throw ((Throwable)localObject);
        localObject = this.jBN;
        localLayoutParams = this.jBN.getLayoutParams();
        localLayoutParams.width = -1;
        ((View)localObject).setLayoutParams(localLayoutParams);
      }
      continue;
      label257:
      ((ViewGroup)localObject).removeView(this.jBV);
      label268:
      this.jBU.addView(this.jBV);
      this.gxx.setVisibility(8);
    }
  }
  
  public final void RD(String paramString)
  {
    AppMethodBeat.i(149762);
    p.h(paramString, "value");
    this.appName = paramString;
    this.jBQ.setText((CharSequence)this.appName);
    g(this.jBQ);
    AppMethodBeat.o(149762);
  }
  
  public final void RE(String paramString)
  {
    AppMethodBeat.i(194267);
    p.h(paramString, "<set-?>");
    this.jCh = paramString;
    AppMethodBeat.o(194267);
  }
  
  public final void RF(String paramString)
  {
    AppMethodBeat.i(194268);
    p.h(paramString, "value");
    this.jCi = paramString;
    this.jBZ.setVisibility(0);
    this.jBX.setText((CharSequence)this.jCi);
    this.jBY.setVisibility(8);
    AppMethodBeat.o(194268);
  }
  
  public final void RG(String paramString)
  {
    AppMethodBeat.i(194269);
    p.h(paramString, "value");
    this.jCk = paramString;
    this.jBY.setVisibility(0);
    this.jBY.setText((CharSequence)this.jCk);
    this.jBZ.setVisibility(8);
    AppMethodBeat.o(194269);
  }
  
  public final void RH(String paramString)
  {
    AppMethodBeat.i(149763);
    p.h(paramString, "value");
    this.jCm = paramString;
    this.hVv.setText((CharSequence)this.jCm);
    g(this.hVv);
    AppMethodBeat.o(149763);
  }
  
  public final void RI(String paramString)
  {
    AppMethodBeat.i(149765);
    p.h(paramString, "value");
    this.jCn = paramString;
    this.hPX.setText((CharSequence)this.jCn);
    AppMethodBeat.o(149765);
  }
  
  public final void RJ(String paramString)
  {
    AppMethodBeat.i(149766);
    p.h(paramString, "value");
    this.jCo = paramString;
    this.hSq.setText((CharSequence)this.jCo);
    AppMethodBeat.o(149766);
  }
  
  public final void RK(String paramString)
  {
    AppMethodBeat.i(149767);
    p.h(paramString, "value");
    this.jCp = paramString;
    this.jBS.setText((CharSequence)this.jCp);
    paramString = this.jBS;
    if (((CharSequence)this.jCp).length() == 0)
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
  
  public final void a(m paramm)
  {
    AppMethodBeat.i(149776);
    com.tencent.mm.modelappbrand.a.b.aXY().a(this.gBZ, this.iconUrl, this.jCq, (com.tencent.mm.modelappbrand.a.b.h)new e());
    this.jCf = paramm;
    uu(getRotation());
    paramm = this.jCr;
    if (paramm != null)
    {
      paramm.onShow();
      AppMethodBeat.o(149776);
      return;
    }
    AppMethodBeat.o(149776);
  }
  
  public final boolean bjb()
  {
    AppMethodBeat.i(149774);
    boolean bool = bja();
    AppMethodBeat.o(149774);
    return bool;
  }
  
  public final boolean bjc()
  {
    return false;
  }
  
  public void cancel()
  {
    AppMethodBeat.i(149779);
    us(2);
    dismiss();
    AppMethodBeat.o(149779);
  }
  
  public void dismiss()
  {
    AppMethodBeat.i(149775);
    Object localObject = this.jCf;
    if (localObject != null) {
      ((m)localObject).c((k)this);
    }
    localObject = this.jCr;
    if (localObject != null)
    {
      ((e)localObject).onDismiss();
      AppMethodBeat.o(149775);
      return;
    }
    AppMethodBeat.o(149775);
  }
  
  public final View getContentView()
  {
    return this.jBN;
  }
  
  public final int getPosition()
  {
    return this.jCs;
  }
  
  public boolean isCancelable()
  {
    return false;
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(149777);
    us(2);
    AppMethodBeat.o(149777);
  }
  
  public final void setDesc(String paramString)
  {
    AppMethodBeat.i(149764);
    p.h(paramString, "value");
    this.desc = paramString;
    this.jBR.setText((CharSequence)this.desc);
    AppMethodBeat.o(149764);
  }
  
  public final void setIconUrl(String paramString)
  {
    AppMethodBeat.i(149761);
    p.h(paramString, "value");
    this.iconUrl = paramString;
    AppMethodBeat.o(149761);
  }
  
  public final void setPosition(int paramInt)
  {
    AppMethodBeat.i(194271);
    this.jCs = paramInt;
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(194271);
      return;
      View localView = this.jBN.findViewById(2131299660);
      p.g(localView, "mRootView.findViewById<V…alog_view_root_container)");
      localView.setBackground(android.support.v4.content.b.l(this.context, 2131235159));
      AppMethodBeat.o(194271);
      return;
      localView = this.jBN.findViewById(2131299660);
      p.g(localView, "mRootView.findViewById<V…alog_view_root_container)");
      localView.setBackground(android.support.v4.content.b.l(this.context, 2131235158));
    }
  }
  
  public final void ut(int paramInt)
  {
    AppMethodBeat.i(149780);
    uu(paramInt);
    AppMethodBeat.o(149780);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Companion;", "", "()V", "TAG", "", "Rotation", "TemplateShowSampleListener", "wxbiz-msgsubscription-sdk_release"})
  public static final class a
  {
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Companion$TemplateShowSampleListener;", "", "onSampleShow", "", "templateId", "", "check", "", "index", "", "wxbiz-msgsubscription-sdk_release"})
    public static abstract interface a
    {
      public abstract void aC(String paramString, int paramInt);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "", "check", "", "title", "", "sampleWordings", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "templateId", "(ZLjava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;)V", "alwaysKeep", "getAlwaysKeep", "()Z", "setAlwaysKeep", "(Z)V", "getCheck", "setCheck", "getSampleWordings", "()Ljava/util/ArrayList;", "getTemplateId", "()Ljava/lang/String;", "getTitle", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "wxbiz-msgsubscription-sdk_release"})
  public static final class b
  {
    public final String ixM;
    boolean jCw;
    public boolean jCx;
    final ArrayList<o<String, String>> jCy;
    final String title;
    
    public b(boolean paramBoolean, String paramString1, ArrayList<o<String, String>> paramArrayList, String paramString2)
    {
      AppMethodBeat.i(149742);
      this.jCx = paramBoolean;
      this.title = paramString1;
      this.jCy = paramArrayList;
      this.ixM = paramString2;
      AppMethodBeat.o(149742);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(149745);
      if (this != paramObject)
      {
        if ((paramObject instanceof b))
        {
          paramObject = (b)paramObject;
          if ((this.jCx != paramObject.jCx) || (!p.j(this.title, paramObject.title)) || (!p.j(this.jCy, paramObject.jCy)) || (!p.j(this.ixM, paramObject.ixM))) {}
        }
      }
      else
      {
        AppMethodBeat.o(149745);
        return true;
      }
      AppMethodBeat.o(149745);
      return false;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final String toString()
    {
      AppMethodBeat.i(149743);
      String str = "Item(check=" + this.jCx + ", title=" + this.title + ", sampleWordings=" + this.jCy + ", templateId=" + this.ixM + ")";
      AppMethodBeat.o(149743);
      return str;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemAdapter$Holder;", "items", "", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "dialog", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog;", "(Ljava/util/List;Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog;)V", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "itemsChecked", "", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Holder", "wxbiz-msgsubscription-sdk_release"})
  public static final class c
    extends RecyclerView.a<a>
  {
    List<b.b> iHf;
    private final b jCA;
    private final List<b.b> jCz;
    
    public c(List<b.b> paramList, b paramb)
    {
      AppMethodBeat.i(149752);
      this.iHf = paramList;
      this.jCA = paramb;
      this.jCz = ((List)new ArrayList());
      paramList = this.jCz;
      Object localObject1 = (Iterable)this.iHf;
      paramb = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if (((b.b)localObject2).jCx) {
          paramb.add(localObject2);
        }
      }
      paramList.addAll((Collection)paramb);
      b.a(this.jCA, this.jCz.size());
      AppMethodBeat.o(149752);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(149750);
      int i = this.iHf.size();
      AppMethodBeat.o(149750);
      return i;
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemAdapter$Holder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "item", "Landroid/view/View;", "(Landroid/view/View;)V", "checkBox", "Landroid/widget/CheckBox;", "getCheckBox", "()Landroid/widget/CheckBox;", "setCheckBox", "(Landroid/widget/CheckBox;)V", "desc", "Landroid/widget/TextView;", "getDesc", "()Landroid/widget/TextView;", "setDesc", "(Landroid/widget/TextView;)V", "sample", "getSample", "()Landroid/view/View;", "setSample", "wxbiz-msgsubscription-sdk_release"})
    public static final class a
      extends RecyclerView.v
    {
      CheckBox checkBox;
      TextView jCB;
      View jCC;
      
      public a(View paramView)
      {
        super();
        AppMethodBeat.i(149746);
        paramView = this.aus.findViewById(2131298639);
        p.g(paramView, "itemView.findViewById(R.id.checkbox)");
        this.checkBox = ((CheckBox)paramView);
        paramView = this.aus.findViewById(2131299495);
        p.g(paramView, "itemView.findViewById(R.id.desc)");
        this.jCB = ((TextView)paramView);
        paramView = this.aus.findViewById(2131307205);
        p.g(paramView, "itemView.findViewById(R.id.sample)");
        this.jCC = paramView;
        AppMethodBeat.o(149746);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b
      implements View.OnClickListener
    {
      b(b.c paramc, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(149747);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        b.a(b.c.a(this.jCD), (b.b)this.jCD.iHf.get(this.gUj));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(149747);
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c
      implements View.OnClickListener
    {
      c(b.c paramc, b.c.a parama, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(149748);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemAdapter$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramView = this.jCE.checkBox;
        boolean bool;
        if (!this.jCE.checkBox.isChecked())
        {
          bool = true;
          paramView.setChecked(bool);
          ((b.b)this.jCD.iHf.get(this.gUj)).jCx = this.jCE.checkBox.isChecked();
          if (!((b.b)this.jCD.iHf.get(this.gUj)).jCx) {
            break label193;
          }
          b.c.b(this.jCD).add(this.jCD.iHf.get(this.gUj));
        }
        for (;;)
        {
          b.a(b.c.a(this.jCD), b.c.b(this.jCD).size());
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemAdapter$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(149748);
          return;
          bool = false;
          break;
          label193:
          b.c.b(this.jCD).remove(this.jCD.iHf.get(this.gUj));
        }
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$SubscribeRequestDialogListener;", "", "onDismiss", "", "onShow", "wxbiz-msgsubscription-sdk_release"})
  public static abstract interface e
  {
    public abstract void onDismiss();
    
    public abstract void onShow();
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$addRecyclerView$divider$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "paddingLeft", "", "getPaddingLeft", "()I", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "strokeWidth", "getStrokeWidth", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "onDraw", "c", "Landroid/graphics/Canvas;", "wxbiz-msgsubscription-sdk_release"})
  public static final class f
    extends RecyclerView.h
  {
    private final int paddingLeft;
    private final Paint paint;
    private final int strokeWidth;
    
    f()
    {
      AppMethodBeat.i(149756);
      this.strokeWidth = 2;
      this.paddingLeft = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 40);
      this.paint = new Paint();
      this.paint.setColor(b.b(localb).getResources().getColor(2131100275));
      this.paint.setStyle(Paint.Style.FILL);
      this.paint.setFlags(1);
      this.paint.setStrokeWidth(this.strokeWidth);
      AppMethodBeat.o(149756);
    }
    
    public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(149754);
      p.h(paramCanvas, "c");
      p.h(paramRecyclerView, "parent");
      p.h(params, "state");
      super.a(paramCanvas, paramRecyclerView, params);
      float f1 = paramRecyclerView.getPaddingLeft();
      float f2 = paramRecyclerView.getWidth() - paramRecyclerView.getPaddingRight();
      int j = paramRecyclerView.getChildCount();
      int i = 0;
      if (i < j)
      {
        params = paramRecyclerView.getChildAt(i);
        p.g(params, "child");
        Object localObject = params.getLayoutParams();
        if (localObject == null)
        {
          paramCanvas = new t("null cannot be cast to non-null type android.support.v7.widget.RecyclerView.LayoutParams");
          AppMethodBeat.o(149754);
          throw paramCanvas;
        }
        localObject = (RecyclerView.LayoutParams)localObject;
        float f3 = params.getBottom() + ((RecyclerView.LayoutParams)localObject).bottomMargin + this.strokeWidth;
        if (i == 0)
        {
          float f4 = params.getTop();
          f4 = ((RecyclerView.LayoutParams)localObject).topMargin + f4 - this.strokeWidth;
          if (paramCanvas != null) {
            paramCanvas.drawLine(f1, f4, f2, f4, this.paint);
          }
        }
        if (i == paramRecyclerView.getChildCount() - 1) {
          if (paramCanvas != null) {
            paramCanvas.drawLine(f1, f3, f2, f3, this.paint);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          if (paramCanvas != null) {
            paramCanvas.drawLine(f1 + this.paddingLeft, f3, f2, f3, this.paint);
          }
        }
      }
      AppMethodBeat.o(149754);
    }
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(149755);
      p.h(paramRect, "outRect");
      p.h(paramView, "view");
      p.h(paramRecyclerView, "parent");
      p.h(params, "state");
      if (RecyclerView.bw(paramView) == 0)
      {
        paramRect.set(0, this.strokeWidth, 0, this.strokeWidth);
        AppMethodBeat.o(149755);
        return;
      }
      paramRect.set(0, 0, 0, this.strokeWidth);
      AppMethodBeat.o(149755);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<x>
  {
    g(b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$applyRotation$6", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "wxbiz-msgsubscription-sdk_release"})
  public static final class h
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(174567);
      b.f(this.jCv).getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      b.a(this.jCv, b.g(this.jCv));
      AppMethodBeat.o(174567);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$closeSampleView$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "wxbiz-msgsubscription-sdk_release"})
  public static final class i
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(149758);
      paramAnimator = b.e(this.jCv);
      if (paramAnimator != null)
      {
        int i = ((Number)paramAnimator).intValue();
        paramAnimator = b.d(this.jCv).findViewById(i);
        if (paramAnimator != null)
        {
          ((LinearLayout)b.d(this.jCv).findViewById(2131299174)).removeView(paramAnimator);
          AppMethodBeat.o(149758);
          return;
        }
        AppMethodBeat.o(149758);
        return;
      }
      AppMethodBeat.o(149758);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$showSample$1$1"})
  static final class j
    implements View.OnClickListener
  {
    j(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(149759);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$showSample$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      b.c(this.jCv);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$showSample$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(149759);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$showSample$1$2", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "wxbiz-msgsubscription-sdk_release"})
  public static final class k
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    k(b paramb) {}
    
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(149760);
      b.d(this.jCv).getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      b.a(this.jCv);
      AppMethodBeat.o(149760);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.b
 * JD-Core Version:    0.7.0.1
 */
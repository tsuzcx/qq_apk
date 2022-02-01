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
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
import android.support.v7.widget.RecyclerView.t;
import android.support.v7.widget.RecyclerView.w;
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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.v;
import d.z;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "context", "Landroid/content/Context;", "items", "", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "listener", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Listener;", "isSingleMode", "", "(Landroid/content/Context;Ljava/util/List;Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Listener;Z)V", "_position", "", "value", "", "actionDesc", "getActionDesc", "()Ljava/lang/String;", "setActionDesc", "(Ljava/lang/String;)V", "actionTv", "Landroid/widget/TextView;", "adapter", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemAdapter;", "alwaysKeepCb", "Landroid/widget/CheckBox;", "alwaysKeepText", "getAlwaysKeepText", "setAlwaysKeepText", "alwaysKeepTv", "alwaysKeepView", "Landroid/view/View;", "alwaysRejectText", "getAlwaysRejectText", "setAlwaysRejectText", "alwaysRejectTv", "appName", "getAppName", "setAppName", "appNameTv", "cancelBtn", "Landroid/widget/Button;", "cancelBtnText", "getCancelBtnText", "setCancelBtnText", "container", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "defaultIconRes", "getDefaultIconRes", "()I", "setDefaultIconRes", "(I)V", "desc", "getDesc", "setDesc", "descTV", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$SubscribeRequestDialogListener;", "dialogListener", "getDialogListener", "()Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$SubscribeRequestDialogListener;", "setDialogListener", "(Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$SubscribeRequestDialogListener;)V", "dialogView", "dialogViewContainer", "Landroid/widget/FrameLayout;", "iconIv", "Landroid/widget/ImageView;", "iconUrl", "getIconUrl", "setIconUrl", "", "mRootView", "okBtn", "okBtnText", "getOkBtnText", "setOkBtnText", "recyclerViewContainer", "sampleBack", "sampleRoot", "sampleShowing", "sampleTitle", "getSampleTitle", "setSampleTitle", "sampleViewId", "Ljava/lang/Integer;", "sampleViewTitle", "scrollView", "Landroid/widget/ScrollView;", "showAlwaysKeepView", "getShowAlwaysKeepView", "()Z", "setShowAlwaysKeepView", "(Z)V", "showAlwaysRejectView", "getShowAlwaysRejectView", "setShowAlwaysRejectView", "templateShowSampleListener", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Companion$TemplateShowSampleListener;", "getTemplateShowSampleListener", "()Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Companion$TemplateShowSampleListener;", "setTemplateShowSampleListener", "(Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Companion$TemplateShowSampleListener;)V", "tip", "getTip", "setTip", "tipTv", "topSampleBtn", "addRecyclerView", "", "alwaysKeepSelected", "applyRotation", "rotation", "cancel", "closeSampleView", "dismiss", "dispatchCancelEvent", "dispatchEvent", "event", "getContentView", "getPosition", "getRotation", "isCancelable", "isCanceledOnTouchOutside", "onBackPressedEvent", "onCancel", "onCheckedCountChanged", "size", "onDismiss", "onScreenOrientationChanged", "onShow", "dialogHelper", "setPosition", "position", "showSample", "item", "startSampleAnimation", "show", "Landroid/animation/Animator$AnimatorListener;", "setBoldStyle", "Companion", "Item", "ItemAdapter", "Listener", "SubscribeRequestDialogListener", "wxbiz-msgsubscription-sdk_release"})
public final class b
  implements k
{
  public static final b.a iGr;
  private String appName;
  public final Context context;
  private String desc;
  private ScrollView fSp;
  private ImageView fWT;
  private Button gXc;
  private Button gZv;
  private List<b.b> hMc;
  private TextView hcC;
  public View iFK;
  private FrameLayout iFL;
  private c iFM;
  private TextView iFN;
  private TextView iFO;
  private TextView iFP;
  private View iFQ;
  private FrameLayout iFR;
  private View iFS;
  private View iFT;
  public TextView iFU;
  public TextView iFV;
  public View iFW;
  public CheckBox iFX;
  private TextView iFY;
  private View iFZ;
  private boolean iGa;
  private Integer iGb;
  private m iGc;
  public b.a.a iGd;
  public String iGe;
  public String iGf;
  public boolean iGg;
  public String iGh;
  public boolean iGi;
  private String iGj;
  private String iGk;
  private String iGl;
  private String iGm;
  public int iGn;
  public e iGo;
  public int iGp;
  private b.d iGq;
  private String iconUrl;
  
  static
  {
    AppMethodBeat.i(149783);
    iGr = new b.a((byte)0);
    AppMethodBeat.o(149783);
  }
  
  public b(Context paramContext, List<b.b> paramList, b.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(149782);
    this.context = paramContext;
    this.iGq = paramd;
    paramContext = LayoutInflater.from(this.context).inflate(2131495728, null);
    p.g(paramContext, "LayoutInflater.from(cont…msg_request_dialog, null)");
    this.iFK = paramContext;
    this.hMc = ((List)new ArrayList());
    this.iconUrl = "";
    this.appName = "";
    this.iGe = "";
    this.iGf = "";
    this.iGg = true;
    this.iGh = "";
    this.iGi = true;
    this.iGj = "";
    this.desc = "";
    this.iGk = "";
    this.iGl = "";
    this.iGm = "";
    paramContext = this.iFK.findViewById(2131301165);
    p.g(paramContext, "mRootView.findViewById(R.id.item_list_container)");
    this.iFL = ((FrameLayout)paramContext);
    paramContext = this.iFK.findViewById(2131304376);
    p.g(paramContext, "mRootView.findViewById(R.id.scroll_view)");
    this.fSp = ((ScrollView)paramContext);
    paramContext = this.iFK.findViewById(2131300891);
    p.g(paramContext, "mRootView.findViewById(R.id.icon_iv)");
    this.fWT = ((ImageView)paramContext);
    paramContext = this.iFK.findViewById(2131296340);
    p.g(paramContext, "mRootView.findViewById(R.id.action)");
    this.hcC = ((TextView)paramContext);
    paramContext = this.iFK.findViewById(2131298996);
    p.g(paramContext, "mRootView.findViewById(R.id.desc)");
    this.iFO = ((TextView)paramContext);
    paramContext = this.iFK.findViewById(2131305860);
    p.g(paramContext, "mRootView.findViewById(R.id.tip)");
    this.iFP = ((TextView)paramContext);
    paramContext = this.iFK.findViewById(2131296866);
    p.g(paramContext, "mRootView.findViewById(R.id.app_name_tv)");
    this.iFN = ((TextView)paramContext);
    paramContext = this.iFK.findViewById(2131299118);
    p.g(paramContext, "mRootView.findViewById(R.id.dialog_cancel)");
    this.gZv = ((Button)paramContext);
    paramContext = this.iFK.findViewById(2131299130);
    p.g(paramContext, "mRootView.findViewById(R.id.dialog_ok)");
    this.gXc = ((Button)paramContext);
    paramContext = this.iFK.findViewById(2131304279);
    p.g(paramContext, "mRootView.findViewById(R.id.sample_root)");
    this.iFQ = paramContext;
    paramContext = this.iFK.findViewById(2131304280);
    p.g(paramContext, "mRootView.findViewById(R.id.sample_view_title)");
    this.iFY = ((TextView)paramContext);
    paramContext = this.iFK.findViewById(2131299133);
    p.g(paramContext, "mRootView.findViewById(R.id.dialog_view_container)");
    this.iFR = ((FrameLayout)paramContext);
    paramContext = this.iFK.findViewById(2131299132);
    p.g(paramContext, "mRootView.findViewById(R.id.dialog_view)");
    this.iFS = paramContext;
    paramContext = this.iFK.findViewById(2131304278);
    p.g(paramContext, "mRootView.findViewById(R.id.sample_back)");
    this.iFT = paramContext;
    paramContext = this.iFK.findViewById(2131296653);
    p.g(paramContext, "mRootView.findViewById(R.id.always_keep_tv)");
    this.iFU = ((TextView)paramContext);
    paramContext = this.iFK.findViewById(2131303012);
    p.g(paramContext, "mRootView.findViewById(R…_type_always_keep_layout)");
    this.iFW = paramContext;
    paramContext = this.iFK.findViewById(2131296652);
    p.g(paramContext, "mRootView.findViewById(R.id.always_keep_checkbox)");
    this.iFX = ((CheckBox)paramContext);
    paramContext = this.iFK.findViewById(2131296654);
    p.g(paramContext, "mRootView.findViewById(R.id.always_reject_tv)");
    this.iFV = ((TextView)paramContext);
    paramContext = this.iFK.findViewById(2131306015);
    p.g(paramContext, "mRootView.findViewById(R.id.top_sample)");
    this.iFZ = paramContext;
    this.iFK.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(149735);
        Object localObject = b.f(this.iGs).getParent();
        if (localObject != null)
        {
          if (localObject == null)
          {
            localObject = new v("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(149735);
            throw ((Throwable)localObject);
          }
          localObject = (ViewGroup)localObject;
          int i = b.h(this.iGs);
          if ((i == 1) || (i == 3))
          {
            if (b.f(this.iGs).getLayoutParams().height != -2)
            {
              b.f(this.iGs).getLayoutParams().height = -2;
              b.f(this.iGs).requestLayout();
              AppMethodBeat.o(149735);
            }
          }
          else
          {
            i = ((ViewGroup)localObject).getHeight() - com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 60);
            if (b.f(this.iGs).getHeight() > i)
            {
              b.f(this.iGs).getLayoutParams().height = Math.min(i, b.f(this.iGs).getHeight());
              b.f(this.iGs).requestLayout();
            }
          }
          AppMethodBeat.o(149735);
          return;
        }
        AppMethodBeat.o(149735);
      }
    });
    this.iFR.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(149736);
        if (b.i(this.iGs).getHeight() > 0) {
          b.d(this.iGs).getLayoutParams().height = b.i(this.iGs).getHeight();
        }
        AppMethodBeat.o(149736);
      }
    });
    this.hMc.addAll((Collection)paramList);
    if (paramBoolean)
    {
      this.iFL.setVisibility(8);
      this.iFZ.setVisibility(0);
      this.iFZ.setOnClickListener((View.OnClickListener)new b.3(this, paramList));
    }
    aC(paramList);
    this.gXc.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(149738);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        b.b(this.iGs, 1);
        this.iGs.dismiss();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(149738);
      }
    });
    this.gZv.setOnClickListener((View.OnClickListener)new b.5(this));
    this.iFW.setOnClickListener((View.OnClickListener)new b.6(this, paramList));
    this.iFV.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(149741);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        b.b(this.iGs, 3);
        this.iGs.dismiss();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(149741);
      }
    });
    this.iGp = 2;
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
      localObject = ObjectAnimator.ofFloat(this.iFR, View.TRANSLATION_X, new float[] { 0.0F, -this.iFR.getWidth() }).setDuration(200L);
      p.g(localObject, "it");
      ((ObjectAnimator)localObject).setInterpolator((TimeInterpolator)new com.tencent.mm.msgsubscription.ui.a.a());
      localObject = (Animator)localObject;
      localObjectAnimator = ObjectAnimator.ofFloat(this.iFQ, View.TRANSLATION_X, new float[] { this.iFQ.getWidth(), 0.0F }).setDuration(200L);
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
      localObject = ObjectAnimator.ofFloat(this.iFR, View.TRANSLATION_X, new float[] { -this.iFR.getWidth(), 0.0F }).setDuration(200L);
      p.g(localObject, "it");
      ((ObjectAnimator)localObject).setInterpolator((TimeInterpolator)new com.tencent.mm.msgsubscription.ui.a.a());
      localObject = (Animator)localObject;
      localObjectAnimator = ObjectAnimator.ofFloat(this.iFQ, View.TRANSLATION_X, new float[] { 0.0F, this.iFQ.getWidth() }).setDuration(200L);
      p.g(localObjectAnimator, "it");
      localObjectAnimator.setInterpolator((TimeInterpolator)new com.tencent.mm.msgsubscription.ui.a.a());
      localAnimatorSet.playTogether(new Animator[] { localObject, (Animator)localObjectAnimator });
    }
  }
  
  private final void aC(List<b.b> paramList)
  {
    AppMethodBeat.i(149769);
    RecyclerView localRecyclerView = new RecyclerView(this.context);
    this.iFL.removeAllViews();
    this.iFL.addView((View)localRecyclerView, new ViewGroup.LayoutParams(-1, -2));
    this.iFM = new c(paramList, this);
    paramList = this.iFM;
    if (paramList == null) {
      p.bdF("adapter");
    }
    localRecyclerView.setAdapter((RecyclerView.a)paramList);
    localRecyclerView.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    localRecyclerView.b((RecyclerView.h)new f(this));
    AppMethodBeat.o(149769);
  }
  
  private final boolean aOR()
  {
    AppMethodBeat.i(149773);
    if (this.iGa)
    {
      a(false, (Animator.AnimatorListener)new i(this));
      this.iGa = false;
      AppMethodBeat.o(149773);
      return true;
    }
    AppMethodBeat.o(149773);
    return false;
  }
  
  private static void f(TextView paramTextView)
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
      localObject = new v("null cannot be cast to non-null type android.view.WindowManager");
      AppMethodBeat.o(149770);
      throw ((Throwable)localObject);
    }
    localObject = ((WindowManager)localObject).getDefaultDisplay();
    p.g(localObject, "(context.getSystemServic…owManager).defaultDisplay");
    int i = ((Display)localObject).getRotation();
    AppMethodBeat.o(149770);
    return i;
  }
  
  private final void qA(int paramInt)
  {
    AppMethodBeat.i(149778);
    ae.i("SubscribeMsgRequestDialog", "dispatchEvent ".concat(String.valueOf(paramInt)));
    b.d locald = this.iGq;
    if (locald != null)
    {
      List localList = (List)new ArrayList();
      localList.addAll((Collection)this.hMc);
      locald.c(paramInt, localList);
      AppMethodBeat.o(149778);
      return;
    }
    AppMethodBeat.o(149778);
  }
  
  private final void qC(int paramInt)
  {
    AppMethodBeat.i(149781);
    Object localObject;
    ViewGroup.LayoutParams localLayoutParams;
    if ((paramInt == 1) || (paramInt == 3))
    {
      localObject = this.iFK;
      localLayoutParams = this.iFK.getLayoutParams();
      localLayoutParams.width = c.cO(this.context);
      ((View)localObject).setLayoutParams(localLayoutParams);
      if (this.fSp.indexOfChild(this.iFS) == -1)
      {
        localObject = this.iFS.getParent();
        if (localObject != null)
        {
          if (localObject == null)
          {
            localObject = new v("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(149781);
            throw ((Throwable)localObject);
          }
          ((ViewGroup)localObject).removeView(this.iFS);
        }
        this.fSp.addView(this.iFS);
        this.fSp.setVisibility(0);
      }
    }
    for (;;)
    {
      this.iFK.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new h(this));
      AppMethodBeat.o(149781);
      return;
      if (c.cP(this.context)) {
        c.a(this.iFK, (d.g.a.a)new g(this));
      }
      while (this.iFR.indexOfChild(this.iFS) == -1)
      {
        localObject = this.iFS.getParent();
        if (localObject == null) {
          break label268;
        }
        if (localObject != null) {
          break label257;
        }
        localObject = new v("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(149781);
        throw ((Throwable)localObject);
        localObject = this.iFK;
        localLayoutParams = this.iFK.getLayoutParams();
        localLayoutParams.width = -1;
        ((View)localObject).setLayoutParams(localLayoutParams);
      }
      continue;
      label257:
      ((ViewGroup)localObject).removeView(this.iFS);
      label268:
      this.iFR.addView(this.iFS);
      this.fSp.setVisibility(8);
    }
  }
  
  public final void IK(String paramString)
  {
    AppMethodBeat.i(149762);
    p.h(paramString, "value");
    this.appName = paramString;
    this.iFN.setText((CharSequence)this.appName);
    f(this.iFN);
    AppMethodBeat.o(149762);
  }
  
  public final void IL(String paramString)
  {
    AppMethodBeat.i(149763);
    p.h(paramString, "value");
    this.iGj = paramString;
    this.hcC.setText((CharSequence)this.iGj);
    f(this.hcC);
    AppMethodBeat.o(149763);
  }
  
  public final void IM(String paramString)
  {
    AppMethodBeat.i(149765);
    p.h(paramString, "value");
    this.iGk = paramString;
    this.gXc.setText((CharSequence)this.iGk);
    AppMethodBeat.o(149765);
  }
  
  public final void IN(String paramString)
  {
    AppMethodBeat.i(149766);
    p.h(paramString, "value");
    this.iGl = paramString;
    this.gZv.setText((CharSequence)this.iGl);
    AppMethodBeat.o(149766);
  }
  
  public final void IO(String paramString)
  {
    AppMethodBeat.i(149767);
    p.h(paramString, "value");
    this.iGm = paramString;
    this.iFP.setText((CharSequence)this.iGm);
    paramString = this.iFP;
    if (((CharSequence)this.iGm).length() == 0)
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
    com.tencent.mm.modelappbrand.a.b.aEl().a(this.fWT, this.iconUrl, this.iGn, (com.tencent.mm.modelappbrand.a.b.h)new e());
    this.iGc = paramm;
    qC(getRotation());
    paramm = this.iGo;
    if (paramm != null)
    {
      paramm.onShow();
      AppMethodBeat.o(149776);
      return;
    }
    AppMethodBeat.o(149776);
  }
  
  public final boolean aOS()
  {
    AppMethodBeat.i(149774);
    boolean bool = aOR();
    AppMethodBeat.o(149774);
    return bool;
  }
  
  public final boolean aOT()
  {
    return false;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(149779);
    qA(2);
    dismiss();
    AppMethodBeat.o(149779);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(149775);
    Object localObject = this.iGc;
    if (localObject != null) {
      ((m)localObject).c((k)this);
    }
    localObject = this.iGo;
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
    return this.iFK;
  }
  
  public final int getPosition()
  {
    return this.iGp;
  }
  
  public final boolean isCancelable()
  {
    return false;
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(149777);
    qA(2);
    AppMethodBeat.o(149777);
  }
  
  public final void qB(int paramInt)
  {
    AppMethodBeat.i(149780);
    qC(paramInt);
    AppMethodBeat.o(149780);
  }
  
  public final void setDesc(String paramString)
  {
    AppMethodBeat.i(149764);
    p.h(paramString, "value");
    this.desc = paramString;
    this.iFO.setText((CharSequence)this.desc);
    AppMethodBeat.o(149764);
  }
  
  public final void setIconUrl(String paramString)
  {
    AppMethodBeat.i(149761);
    p.h(paramString, "value");
    this.iconUrl = paramString;
    AppMethodBeat.o(149761);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemAdapter$Holder;", "items", "", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "dialog", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog;", "(Ljava/util/List;Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog;)V", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "itemsChecked", "", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Holder", "wxbiz-msgsubscription-sdk_release"})
  public static final class c
    extends RecyclerView.a<a>
  {
    List<b.b> hMc;
    private final List<b.b> iGx;
    private final b iGy;
    
    public c(List<b.b> paramList, b paramb)
    {
      AppMethodBeat.i(149752);
      this.hMc = paramList;
      this.iGy = paramb;
      this.iGx = ((List)new ArrayList());
      paramList = this.iGx;
      Object localObject1 = (Iterable)this.hMc;
      paramb = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if (((b.b)localObject2).iGv) {
          paramb.add(localObject2);
        }
      }
      paramList.addAll((Collection)paramb);
      b.a(this.iGy, this.iGx.size());
      AppMethodBeat.o(149752);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(149750);
      int i = this.hMc.size();
      AppMethodBeat.o(149750);
      return i;
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemAdapter$Holder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "item", "Landroid/view/View;", "(Landroid/view/View;)V", "checkBox", "Landroid/widget/CheckBox;", "getCheckBox", "()Landroid/widget/CheckBox;", "setCheckBox", "(Landroid/widget/CheckBox;)V", "desc", "Landroid/widget/TextView;", "getDesc", "()Landroid/widget/TextView;", "setDesc", "(Landroid/widget/TextView;)V", "sample", "getSample", "()Landroid/view/View;", "setSample", "wxbiz-msgsubscription-sdk_release"})
    public static final class a
      extends RecyclerView.w
    {
      CheckBox iFD;
      View iGA;
      TextView iGz;
      
      public a(View paramView)
      {
        super();
        AppMethodBeat.i(149746);
        paramView = this.auu.findViewById(2131298255);
        p.g(paramView, "itemView.findViewById(R.id.checkbox)");
        this.iFD = ((CheckBox)paramView);
        paramView = this.auu.findViewById(2131298996);
        p.g(paramView, "itemView.findViewById(R.id.desc)");
        this.iGz = ((TextView)paramView);
        paramView = this.auu.findViewById(2131304277);
        p.g(paramView, "itemView.findViewById(R.id.sample)");
        this.iGA = paramView;
        AppMethodBeat.o(149746);
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b
      implements View.OnClickListener
    {
      b(b.c paramc, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(149747);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        b.a(b.c.a(this.iGB), (b.b)this.iGB.hMc.get(this.gke));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(149747);
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c
      implements View.OnClickListener
    {
      c(b.c paramc, b.c.a parama, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(149748);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemAdapter$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        paramView = this.iGC.iFD;
        boolean bool;
        if (!this.iGC.iFD.isChecked())
        {
          bool = true;
          paramView.setChecked(bool);
          ((b.b)this.iGB.hMc.get(this.gke)).iGv = this.iGC.iFD.isChecked();
          if (!((b.b)this.iGB.hMc.get(this.gke)).iGv) {
            break label193;
          }
          b.c.b(this.iGB).add(this.iGB.hMc.get(this.gke));
        }
        for (;;)
        {
          b.a(b.c.a(this.iGB), b.c.b(this.iGB).size());
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemAdapter$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(149748);
          return;
          bool = false;
          break;
          label193:
          b.c.b(this.iGB).remove(this.iGB.hMc.get(this.gke));
        }
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$SubscribeRequestDialogListener;", "", "onDismiss", "", "onShow", "wxbiz-msgsubscription-sdk_release"})
  public static abstract interface e
  {
    public abstract void onDismiss();
    
    public abstract void onShow();
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$addRecyclerView$divider$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "paddingLeft", "", "getPaddingLeft", "()I", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "strokeWidth", "getStrokeWidth", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "onDraw", "c", "Landroid/graphics/Canvas;", "wxbiz-msgsubscription-sdk_release"})
  public static final class f
    extends RecyclerView.h
  {
    private final int paddingLeft;
    private final Paint paint;
    private final int strokeWidth;
    
    f()
    {
      AppMethodBeat.i(149756);
      this.strokeWidth = com.tencent.mm.cb.a.h(ak.getContext(), 0.5F);
      this.paddingLeft = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 40);
      this.paint = new Paint();
      this.paint.setColor(b.b(localb).getResources().getColor(2131100241));
      this.paint.setStyle(Paint.Style.FILL);
      this.paint.setFlags(1);
      this.paint.setStrokeWidth(this.strokeWidth);
      AppMethodBeat.o(149756);
    }
    
    public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.t paramt)
    {
      AppMethodBeat.i(149754);
      p.h(paramCanvas, "c");
      p.h(paramRecyclerView, "parent");
      p.h(paramt, "state");
      super.a(paramCanvas, paramRecyclerView, paramt);
      float f1 = paramRecyclerView.getPaddingLeft();
      float f2 = paramRecyclerView.getWidth() - paramRecyclerView.getPaddingRight();
      int j = paramRecyclerView.getChildCount();
      int i = 0;
      if (i < j)
      {
        paramt = paramRecyclerView.getChildAt(i);
        p.g(paramt, "child");
        Object localObject = paramt.getLayoutParams();
        if (localObject == null)
        {
          paramCanvas = new v("null cannot be cast to non-null type android.support.v7.widget.RecyclerView.LayoutParams");
          AppMethodBeat.o(149754);
          throw paramCanvas;
        }
        localObject = (RecyclerView.LayoutParams)localObject;
        float f3 = paramt.getBottom() + ((RecyclerView.LayoutParams)localObject).bottomMargin + this.strokeWidth;
        if (i == 0)
        {
          float f4 = paramt.getTop();
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
    
    public final void a(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.t paramt)
    {
      AppMethodBeat.i(149755);
      p.h(paramRect, "outRect");
      p.h(paramView, "view");
      p.h(paramRecyclerView, "parent");
      p.h(paramt, "state");
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class g
    extends q
    implements d.g.a.a<z>
  {
    g(b paramb)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$applyRotation$6", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "wxbiz-msgsubscription-sdk_release"})
  public static final class h
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(174567);
      b.f(this.iGs).getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      b.a(this.iGs, b.g(this.iGs));
      AppMethodBeat.o(174567);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$closeSampleView$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "wxbiz-msgsubscription-sdk_release"})
  public static final class i
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(149758);
      paramAnimator = b.e(this.iGs);
      if (paramAnimator != null)
      {
        int i = ((Number)paramAnimator).intValue();
        paramAnimator = b.d(this.iGs).findViewById(i);
        if (paramAnimator != null)
        {
          ((LinearLayout)b.d(this.iGs).findViewById(2131298736)).removeView(paramAnimator);
          AppMethodBeat.o(149758);
          return;
        }
        AppMethodBeat.o(149758);
        return;
      }
      AppMethodBeat.o(149758);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$showSample$1$2", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "wxbiz-msgsubscription-sdk_release"})
  public static final class k
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    k(b paramb) {}
    
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(149760);
      b.d(this.iGs).getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      b.a(this.iGs);
      AppMethodBeat.o(149760);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.b
 * JD-Core Version:    0.7.0.1
 */
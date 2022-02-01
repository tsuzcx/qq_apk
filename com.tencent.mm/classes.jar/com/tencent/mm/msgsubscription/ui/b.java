package com.tencent.mm.msgsubscription.ui;

import android.animation.Animator;
import android.animation.Animator.AnimatorListener;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Paint.Style;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.i;
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
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "context", "Landroid/content/Context;", "items", "", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "listener", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Listener;", "isSingleMode", "", "(Landroid/content/Context;Ljava/util/List;Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Listener;Z)V", "_position", "", "value", "", "actionDesc", "getActionDesc", "()Ljava/lang/String;", "setActionDesc", "(Ljava/lang/String;)V", "actionTv", "Landroid/widget/TextView;", "adapter", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemAdapter;", "alwaysKeepCb", "Landroid/widget/CheckBox;", "alwaysKeepText", "getAlwaysKeepText", "setAlwaysKeepText", "alwaysKeepTv", "alwaysKeepView", "Landroid/view/View;", "alwaysRejectText", "getAlwaysRejectText", "setAlwaysRejectText", "alwaysRejectTv", "appName", "getAppName", "setAppName", "appNameTv", "cancelBtn", "Landroid/widget/Button;", "cancelBtnText", "getCancelBtnText", "setCancelBtnText", "container", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "defaultIconRes", "getDefaultIconRes", "()I", "setDefaultIconRes", "(I)V", "desc", "getDesc", "setDesc", "descTV", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$SubscribeRequestDialogListener;", "dialogListener", "getDialogListener", "()Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$SubscribeRequestDialogListener;", "setDialogListener", "(Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$SubscribeRequestDialogListener;)V", "dialogView", "dialogViewContainer", "Landroid/widget/FrameLayout;", "iconIv", "Landroid/widget/ImageView;", "iconUrl", "getIconUrl", "setIconUrl", "", "mRootView", "okBtn", "okBtnText", "getOkBtnText", "setOkBtnText", "recyclerViewContainer", "sampleBack", "sampleRoot", "sampleShowing", "sampleTitle", "getSampleTitle", "setSampleTitle", "sampleViewId", "Ljava/lang/Integer;", "sampleViewTitle", "scrollView", "Landroid/widget/ScrollView;", "showAlwaysKeepView", "getShowAlwaysKeepView", "()Z", "setShowAlwaysKeepView", "(Z)V", "showAlwaysRejectView", "getShowAlwaysRejectView", "setShowAlwaysRejectView", "templateShowSampleListener", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Companion$TemplateShowSampleListener;", "getTemplateShowSampleListener", "()Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Companion$TemplateShowSampleListener;", "setTemplateShowSampleListener", "(Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Companion$TemplateShowSampleListener;)V", "tip", "getTip", "setTip", "tipTv", "topSampleBtn", "addRecyclerView", "", "alwaysKeepSelected", "applyRotation", "rotation", "cancel", "closeSampleView", "dismiss", "dispatchCancelEvent", "dispatchEvent", "event", "getContentView", "getPosition", "getRotation", "isCancelable", "isCanceledOnTouchOutside", "onBackPressedEvent", "onCancel", "onCheckedCountChanged", "size", "onDismiss", "onScreenOrientationChanged", "onShow", "dialogHelper", "setPosition", "position", "showSample", "item", "startSampleAnimation", "show", "Landroid/animation/Animator$AnimatorListener;", "setBoldStyle", "Companion", "Item", "ItemAdapter", "Listener", "SubscribeRequestDialogListener", "wxbiz-msgsubscription-sdk_release"})
public final class b
  implements k
{
  public static final b.a iDy;
  private String appName;
  public final Context context;
  private String desc;
  private ScrollView fQj;
  private ImageView fUN;
  private Button gUt;
  private Button gWI;
  private TextView gZP;
  private List<b.b> hJj;
  public View iCR;
  private FrameLayout iCS;
  private c iCT;
  private TextView iCU;
  private TextView iCV;
  private TextView iCW;
  private View iCX;
  private FrameLayout iCY;
  private View iCZ;
  private View iDa;
  public TextView iDb;
  public TextView iDc;
  public View iDd;
  public CheckBox iDe;
  private TextView iDf;
  private View iDg;
  private boolean iDh;
  private Integer iDi;
  private m iDj;
  public b.a.a iDk;
  public String iDl;
  public String iDm;
  public boolean iDn;
  public String iDo;
  public boolean iDp;
  private String iDq;
  private String iDr;
  private String iDs;
  private String iDt;
  public int iDu;
  public e iDv;
  public int iDw;
  private b.d iDx;
  private String iconUrl;
  
  static
  {
    AppMethodBeat.i(149783);
    iDy = new b.a((byte)0);
    AppMethodBeat.o(149783);
  }
  
  public b(Context paramContext, List<b.b> paramList, b.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(149782);
    this.context = paramContext;
    this.iDx = paramd;
    paramContext = LayoutInflater.from(this.context).inflate(2131495728, null);
    p.g(paramContext, "LayoutInflater.from(cont…msg_request_dialog, null)");
    this.iCR = paramContext;
    this.hJj = ((List)new ArrayList());
    this.iconUrl = "";
    this.appName = "";
    this.iDl = "";
    this.iDm = "";
    this.iDn = true;
    this.iDo = "";
    this.iDp = true;
    this.iDq = "";
    this.desc = "";
    this.iDr = "";
    this.iDs = "";
    this.iDt = "";
    paramContext = this.iCR.findViewById(2131301165);
    p.g(paramContext, "mRootView.findViewById(R.id.item_list_container)");
    this.iCS = ((FrameLayout)paramContext);
    paramContext = this.iCR.findViewById(2131304376);
    p.g(paramContext, "mRootView.findViewById(R.id.scroll_view)");
    this.fQj = ((ScrollView)paramContext);
    paramContext = this.iCR.findViewById(2131300891);
    p.g(paramContext, "mRootView.findViewById(R.id.icon_iv)");
    this.fUN = ((ImageView)paramContext);
    paramContext = this.iCR.findViewById(2131296340);
    p.g(paramContext, "mRootView.findViewById(R.id.action)");
    this.gZP = ((TextView)paramContext);
    paramContext = this.iCR.findViewById(2131298996);
    p.g(paramContext, "mRootView.findViewById(R.id.desc)");
    this.iCV = ((TextView)paramContext);
    paramContext = this.iCR.findViewById(2131305860);
    p.g(paramContext, "mRootView.findViewById(R.id.tip)");
    this.iCW = ((TextView)paramContext);
    paramContext = this.iCR.findViewById(2131296866);
    p.g(paramContext, "mRootView.findViewById(R.id.app_name_tv)");
    this.iCU = ((TextView)paramContext);
    paramContext = this.iCR.findViewById(2131299118);
    p.g(paramContext, "mRootView.findViewById(R.id.dialog_cancel)");
    this.gWI = ((Button)paramContext);
    paramContext = this.iCR.findViewById(2131299130);
    p.g(paramContext, "mRootView.findViewById(R.id.dialog_ok)");
    this.gUt = ((Button)paramContext);
    paramContext = this.iCR.findViewById(2131304279);
    p.g(paramContext, "mRootView.findViewById(R.id.sample_root)");
    this.iCX = paramContext;
    paramContext = this.iCR.findViewById(2131304280);
    p.g(paramContext, "mRootView.findViewById(R.id.sample_view_title)");
    this.iDf = ((TextView)paramContext);
    paramContext = this.iCR.findViewById(2131299133);
    p.g(paramContext, "mRootView.findViewById(R.id.dialog_view_container)");
    this.iCY = ((FrameLayout)paramContext);
    paramContext = this.iCR.findViewById(2131299132);
    p.g(paramContext, "mRootView.findViewById(R.id.dialog_view)");
    this.iCZ = paramContext;
    paramContext = this.iCR.findViewById(2131304278);
    p.g(paramContext, "mRootView.findViewById(R.id.sample_back)");
    this.iDa = paramContext;
    paramContext = this.iCR.findViewById(2131296653);
    p.g(paramContext, "mRootView.findViewById(R.id.always_keep_tv)");
    this.iDb = ((TextView)paramContext);
    paramContext = this.iCR.findViewById(2131303012);
    p.g(paramContext, "mRootView.findViewById(R…_type_always_keep_layout)");
    this.iDd = paramContext;
    paramContext = this.iCR.findViewById(2131296652);
    p.g(paramContext, "mRootView.findViewById(R.id.always_keep_checkbox)");
    this.iDe = ((CheckBox)paramContext);
    paramContext = this.iCR.findViewById(2131296654);
    p.g(paramContext, "mRootView.findViewById(R.id.always_reject_tv)");
    this.iDc = ((TextView)paramContext);
    paramContext = this.iCR.findViewById(2131306015);
    p.g(paramContext, "mRootView.findViewById(R.id.top_sample)");
    this.iDg = paramContext;
    this.iCR.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new b.1(this));
    this.iCY.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(149736);
        if (b.i(this.iDz).getHeight() > 0) {
          b.d(this.iDz).getLayoutParams().height = b.i(this.iDz).getHeight();
        }
        AppMethodBeat.o(149736);
      }
    });
    this.hJj.addAll((Collection)paramList);
    if (paramBoolean)
    {
      this.iCS.setVisibility(8);
      this.iDg.setVisibility(0);
      this.iDg.setOnClickListener((View.OnClickListener)new b.3(this, paramList));
    }
    aC(paramList);
    this.gUt.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(149738);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        b.b(this.iDz, 1);
        this.iDz.dismiss();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(149738);
      }
    });
    this.gWI.setOnClickListener((View.OnClickListener)new b.5(this));
    this.iDd.setOnClickListener((View.OnClickListener)new b.6(this, paramList));
    this.iDc.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(149741);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        b.b(this.iDz, 3);
        this.iDz.dismiss();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$7", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(149741);
      }
    });
    this.iDw = 2;
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
      localObject = ObjectAnimator.ofFloat(this.iCY, View.TRANSLATION_X, new float[] { 0.0F, -this.iCY.getWidth() }).setDuration(200L);
      p.g(localObject, "it");
      ((ObjectAnimator)localObject).setInterpolator((TimeInterpolator)new com.tencent.mm.msgsubscription.ui.a.a());
      localObject = (Animator)localObject;
      localObjectAnimator = ObjectAnimator.ofFloat(this.iCX, View.TRANSLATION_X, new float[] { this.iCX.getWidth(), 0.0F }).setDuration(200L);
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
      localObject = ObjectAnimator.ofFloat(this.iCY, View.TRANSLATION_X, new float[] { -this.iCY.getWidth(), 0.0F }).setDuration(200L);
      p.g(localObject, "it");
      ((ObjectAnimator)localObject).setInterpolator((TimeInterpolator)new com.tencent.mm.msgsubscription.ui.a.a());
      localObject = (Animator)localObject;
      localObjectAnimator = ObjectAnimator.ofFloat(this.iCX, View.TRANSLATION_X, new float[] { 0.0F, this.iCX.getWidth() }).setDuration(200L);
      p.g(localObjectAnimator, "it");
      localObjectAnimator.setInterpolator((TimeInterpolator)new com.tencent.mm.msgsubscription.ui.a.a());
      localAnimatorSet.playTogether(new Animator[] { localObject, (Animator)localObjectAnimator });
    }
  }
  
  private final void aC(List<b.b> paramList)
  {
    AppMethodBeat.i(149769);
    RecyclerView localRecyclerView = new RecyclerView(this.context);
    this.iCS.removeAllViews();
    this.iCS.addView((View)localRecyclerView, new ViewGroup.LayoutParams(-1, -2));
    this.iCT = new c(paramList, this);
    paramList = this.iCT;
    if (paramList == null) {
      p.bcb("adapter");
    }
    localRecyclerView.setAdapter((RecyclerView.a)paramList);
    localRecyclerView.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    localRecyclerView.b((RecyclerView.h)new b.f(this));
    AppMethodBeat.o(149769);
  }
  
  private final boolean aOu()
  {
    AppMethodBeat.i(149773);
    if (this.iDh)
    {
      a(false, (Animator.AnimatorListener)new i(this));
      this.iDh = false;
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
  
  private final void qx(int paramInt)
  {
    AppMethodBeat.i(149778);
    ad.i("SubscribeMsgRequestDialog", "dispatchEvent ".concat(String.valueOf(paramInt)));
    b.d locald = this.iDx;
    if (locald != null)
    {
      List localList = (List)new ArrayList();
      localList.addAll((Collection)this.hJj);
      locald.c(paramInt, localList);
      AppMethodBeat.o(149778);
      return;
    }
    AppMethodBeat.o(149778);
  }
  
  private final void qz(int paramInt)
  {
    AppMethodBeat.i(149781);
    Object localObject;
    ViewGroup.LayoutParams localLayoutParams;
    if ((paramInt == 1) || (paramInt == 3))
    {
      localObject = this.iCR;
      localLayoutParams = this.iCR.getLayoutParams();
      localLayoutParams.width = c.cM(this.context);
      ((View)localObject).setLayoutParams(localLayoutParams);
      if (this.fQj.indexOfChild(this.iCZ) == -1)
      {
        localObject = this.iCZ.getParent();
        if (localObject != null)
        {
          if (localObject == null)
          {
            localObject = new v("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(149781);
            throw ((Throwable)localObject);
          }
          ((ViewGroup)localObject).removeView(this.iCZ);
        }
        this.fQj.addView(this.iCZ);
        this.fQj.setVisibility(0);
      }
    }
    for (;;)
    {
      this.iCR.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new b.h(this));
      AppMethodBeat.o(149781);
      return;
      if (c.cN(this.context)) {
        c.a(this.iCR, (d.g.a.a)new b.g(this));
      }
      while (this.iCY.indexOfChild(this.iCZ) == -1)
      {
        localObject = this.iCZ.getParent();
        if (localObject == null) {
          break label268;
        }
        if (localObject != null) {
          break label257;
        }
        localObject = new v("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(149781);
        throw ((Throwable)localObject);
        localObject = this.iCR;
        localLayoutParams = this.iCR.getLayoutParams();
        localLayoutParams.width = -1;
        ((View)localObject).setLayoutParams(localLayoutParams);
      }
      continue;
      label257:
      ((ViewGroup)localObject).removeView(this.iCZ);
      label268:
      this.iCY.addView(this.iCZ);
      this.fQj.setVisibility(8);
    }
  }
  
  public final void Ii(String paramString)
  {
    AppMethodBeat.i(149762);
    p.h(paramString, "value");
    this.appName = paramString;
    this.iCU.setText((CharSequence)this.appName);
    f(this.iCU);
    AppMethodBeat.o(149762);
  }
  
  public final void Ij(String paramString)
  {
    AppMethodBeat.i(149763);
    p.h(paramString, "value");
    this.iDq = paramString;
    this.gZP.setText((CharSequence)this.iDq);
    f(this.gZP);
    AppMethodBeat.o(149763);
  }
  
  public final void Ik(String paramString)
  {
    AppMethodBeat.i(149765);
    p.h(paramString, "value");
    this.iDr = paramString;
    this.gUt.setText((CharSequence)this.iDr);
    AppMethodBeat.o(149765);
  }
  
  public final void Il(String paramString)
  {
    AppMethodBeat.i(149766);
    p.h(paramString, "value");
    this.iDs = paramString;
    this.gWI.setText((CharSequence)this.iDs);
    AppMethodBeat.o(149766);
  }
  
  public final void Im(String paramString)
  {
    AppMethodBeat.i(149767);
    p.h(paramString, "value");
    this.iDt = paramString;
    this.iCW.setText((CharSequence)this.iDt);
    paramString = this.iCW;
    if (((CharSequence)this.iDt).length() == 0)
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
    com.tencent.mm.modelappbrand.a.b.aDV().a(this.fUN, this.iconUrl, this.iDu, (com.tencent.mm.modelappbrand.a.b.h)new e());
    this.iDj = paramm;
    qz(getRotation());
    paramm = this.iDv;
    if (paramm != null)
    {
      paramm.onShow();
      AppMethodBeat.o(149776);
      return;
    }
    AppMethodBeat.o(149776);
  }
  
  public final boolean aOv()
  {
    AppMethodBeat.i(149774);
    boolean bool = aOu();
    AppMethodBeat.o(149774);
    return bool;
  }
  
  public final boolean aOw()
  {
    return false;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(149779);
    qx(2);
    dismiss();
    AppMethodBeat.o(149779);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(149775);
    Object localObject = this.iDj;
    if (localObject != null) {
      ((m)localObject).c((k)this);
    }
    localObject = this.iDv;
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
    return this.iCR;
  }
  
  public final int getPosition()
  {
    return this.iDw;
  }
  
  public final boolean isCancelable()
  {
    return false;
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(149777);
    qx(2);
    AppMethodBeat.o(149777);
  }
  
  public final void qy(int paramInt)
  {
    AppMethodBeat.i(149780);
    qz(paramInt);
    AppMethodBeat.o(149780);
  }
  
  public final void setDesc(String paramString)
  {
    AppMethodBeat.i(149764);
    p.h(paramString, "value");
    this.desc = paramString;
    this.iCV.setText((CharSequence)this.desc);
    AppMethodBeat.o(149764);
  }
  
  public final void setIconUrl(String paramString)
  {
    AppMethodBeat.i(149761);
    p.h(paramString, "value");
    this.iconUrl = paramString;
    AppMethodBeat.o(149761);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemAdapter$Holder;", "items", "", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "dialog", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog;", "(Ljava/util/List;Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog;)V", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "itemsChecked", "", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Holder", "wxbiz-msgsubscription-sdk_release"})
  public static final class c
    extends RecyclerView.a<a>
  {
    List<b.b> hJj;
    private final List<b.b> iDE;
    private final b iDF;
    
    public c(List<b.b> paramList, b paramb)
    {
      AppMethodBeat.i(149752);
      this.hJj = paramList;
      this.iDF = paramb;
      this.iDE = ((List)new ArrayList());
      paramList = this.iDE;
      Object localObject1 = (Iterable)this.hJj;
      paramb = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if (((b.b)localObject2).iDC) {
          paramb.add(localObject2);
        }
      }
      paramList.addAll((Collection)paramb);
      b.a(this.iDF, this.iDE.size());
      AppMethodBeat.o(149752);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(149750);
      int i = this.hJj.size();
      AppMethodBeat.o(149750);
      return i;
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemAdapter$Holder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "item", "Landroid/view/View;", "(Landroid/view/View;)V", "checkBox", "Landroid/widget/CheckBox;", "getCheckBox", "()Landroid/widget/CheckBox;", "setCheckBox", "(Landroid/widget/CheckBox;)V", "desc", "Landroid/widget/TextView;", "getDesc", "()Landroid/widget/TextView;", "setDesc", "(Landroid/widget/TextView;)V", "sample", "getSample", "()Landroid/view/View;", "setSample", "wxbiz-msgsubscription-sdk_release"})
    public static final class a
      extends RecyclerView.w
    {
      CheckBox iCK;
      TextView iDG;
      View iDH;
      
      public a(View paramView)
      {
        super();
        AppMethodBeat.i(149746);
        paramView = this.auu.findViewById(2131298255);
        p.g(paramView, "itemView.findViewById(R.id.checkbox)");
        this.iCK = ((CheckBox)paramView);
        paramView = this.auu.findViewById(2131298996);
        p.g(paramView, "itemView.findViewById(R.id.desc)");
        this.iDG = ((TextView)paramView);
        paramView = this.auu.findViewById(2131304277);
        p.g(paramView, "itemView.findViewById(R.id.sample)");
        this.iDH = paramView;
        AppMethodBeat.o(149746);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b
      implements View.OnClickListener
    {
      b(b.c paramc, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(149747);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        b.a(b.c.a(this.iDI), (b.b)this.iDI.hJj.get(this.ghM));
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemAdapter$onBindViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(149747);
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c
      implements View.OnClickListener
    {
      c(b.c paramc, b.c.a parama, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(149748);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemAdapter$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramView = this.iDJ.iCK;
        boolean bool;
        if (!this.iDJ.iCK.isChecked())
        {
          bool = true;
          paramView.setChecked(bool);
          ((b.b)this.iDI.hJj.get(this.ghM)).iDC = this.iDJ.iCK.isChecked();
          if (!((b.b)this.iDI.hJj.get(this.ghM)).iDC) {
            break label193;
          }
          b.c.b(this.iDI).add(this.iDI.hJj.get(this.ghM));
        }
        for (;;)
        {
          b.a(b.c.a(this.iDI), b.c.b(this.iDI).size());
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemAdapter$onBindViewHolder$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(149748);
          return;
          bool = false;
          break;
          label193:
          b.c.b(this.iDI).remove(this.iDI.hJj.get(this.ghM));
        }
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$SubscribeRequestDialogListener;", "", "onDismiss", "", "onShow", "wxbiz-msgsubscription-sdk_release"})
  public static abstract interface e
  {
    public abstract void onDismiss();
    
    public abstract void onShow();
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$closeSampleView$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "wxbiz-msgsubscription-sdk_release"})
  public static final class i
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(149758);
      paramAnimator = b.e(this.iDz);
      if (paramAnimator != null)
      {
        int i = ((Number)paramAnimator).intValue();
        paramAnimator = b.d(this.iDz).findViewById(i);
        if (paramAnimator != null)
        {
          ((LinearLayout)b.d(this.iDz).findViewById(2131298736)).removeView(paramAnimator);
          AppMethodBeat.o(149758);
          return;
        }
        AppMethodBeat.o(149758);
        return;
      }
      AppMethodBeat.o(149758);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$showSample$1$2", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "wxbiz-msgsubscription-sdk_release"})
  public static final class k
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    k(b paramb) {}
    
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(149760);
      b.d(this.iDz).getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      b.a(this.iDz);
      AppMethodBeat.o(149760);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.b
 * JD-Core Version:    0.7.0.1
 */
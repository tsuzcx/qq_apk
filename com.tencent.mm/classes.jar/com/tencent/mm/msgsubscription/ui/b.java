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
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import d.o;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "context", "Landroid/content/Context;", "items", "", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "listener", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Listener;", "isSingleMode", "", "(Landroid/content/Context;Ljava/util/List;Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Listener;Z)V", "_position", "", "value", "", "actionDesc", "getActionDesc", "()Ljava/lang/String;", "setActionDesc", "(Ljava/lang/String;)V", "actionTv", "Landroid/widget/TextView;", "adapter", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemAdapter;", "alwaysKeepCb", "Landroid/widget/CheckBox;", "alwaysKeepText", "getAlwaysKeepText", "setAlwaysKeepText", "alwaysKeepTv", "alwaysKeepView", "Landroid/view/View;", "alwaysRejectText", "getAlwaysRejectText", "setAlwaysRejectText", "alwaysRejectTv", "appName", "getAppName", "setAppName", "appNameTv", "cancelBtn", "Landroid/widget/Button;", "cancelBtnText", "getCancelBtnText", "setCancelBtnText", "container", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "defaultIconRes", "getDefaultIconRes", "()I", "setDefaultIconRes", "(I)V", "desc", "getDesc", "setDesc", "descTV", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$SubscribeRequestDialogListener;", "dialogListener", "getDialogListener", "()Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$SubscribeRequestDialogListener;", "setDialogListener", "(Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$SubscribeRequestDialogListener;)V", "dialogView", "dialogViewContainer", "Landroid/widget/FrameLayout;", "iconIv", "Landroid/widget/ImageView;", "iconUrl", "getIconUrl", "setIconUrl", "", "mRootView", "okBtn", "okBtnText", "getOkBtnText", "setOkBtnText", "recyclerViewContainer", "sampleBack", "sampleRoot", "sampleShowing", "sampleTitle", "getSampleTitle", "setSampleTitle", "sampleViewId", "Ljava/lang/Integer;", "sampleViewTitle", "scrollView", "Landroid/widget/ScrollView;", "showAlwaysKeepView", "getShowAlwaysKeepView", "()Z", "setShowAlwaysKeepView", "(Z)V", "showAlwaysRejectView", "getShowAlwaysRejectView", "setShowAlwaysRejectView", "templateShowSampleListener", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Companion$TemplateShowSampleListener;", "getTemplateShowSampleListener", "()Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Companion$TemplateShowSampleListener;", "setTemplateShowSampleListener", "(Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Companion$TemplateShowSampleListener;)V", "tip", "getTip", "setTip", "tipTv", "topSampleBtn", "addRecyclerView", "", "alwaysKeepSelected", "applyRotation", "rotation", "cancel", "closeSampleView", "dismiss", "dispatchCancelEvent", "dispatchEvent", "event", "getContentView", "getPosition", "getRotation", "isCancelable", "isCanceledOnTouchOutside", "onBackPressedEvent", "onCancel", "onCheckedCountChanged", "size", "onDismiss", "onScreenOrientationChanged", "onShow", "dialogHelper", "setPosition", "position", "showSample", "item", "startSampleAnimation", "show", "Landroid/animation/Animator$AnimatorListener;", "setBoldStyle", "Companion", "Item", "ItemAdapter", "Listener", "SubscribeRequestDialogListener", "wxbiz-msgsubscription-sdk_release"})
public final class b
  implements com.tencent.mm.plugin.appbrand.widget.dialog.k
{
  public static final a ikh;
  private String appName;
  public final Context context;
  private String desc;
  private ImageView fBA;
  private ScrollView fwW;
  private Button gAJ;
  private Button gCY;
  private TextView gGf;
  private List<b> hqR;
  private String iconUrl;
  public View ijA;
  private FrameLayout ijB;
  private c ijC;
  private TextView ijD;
  private TextView ijE;
  private TextView ijF;
  private View ijG;
  private FrameLayout ijH;
  private View ijI;
  private View ijJ;
  public TextView ijK;
  public TextView ijL;
  public View ijM;
  public CheckBox ijN;
  private TextView ijO;
  private View ijP;
  private boolean ijQ;
  private Integer ijR;
  private m ijS;
  public b.a.a ijT;
  public String ijU;
  public String ijV;
  public boolean ijW;
  public String ijX;
  public boolean ijY;
  private String ijZ;
  private String ika;
  private String ikb;
  private String ikc;
  public int ikd;
  public e ike;
  public int ikf;
  private b.d ikg;
  
  static
  {
    AppMethodBeat.i(149783);
    ikh = new a((byte)0);
    AppMethodBeat.o(149783);
  }
  
  public b(Context paramContext, final List<b> paramList, b.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(149782);
    this.context = paramContext;
    this.ikg = paramd;
    paramContext = LayoutInflater.from(this.context).inflate(2131495728, null);
    d.g.b.k.g(paramContext, "LayoutInflater.from(cont…msg_request_dialog, null)");
    this.ijA = paramContext;
    this.hqR = ((List)new ArrayList());
    this.iconUrl = "";
    this.appName = "";
    this.ijU = "";
    this.ijV = "";
    this.ijW = true;
    this.ijX = "";
    this.ijY = true;
    this.ijZ = "";
    this.desc = "";
    this.ika = "";
    this.ikb = "";
    this.ikc = "";
    paramContext = this.ijA.findViewById(2131301165);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.item_list_container)");
    this.ijB = ((FrameLayout)paramContext);
    paramContext = this.ijA.findViewById(2131304376);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.scroll_view)");
    this.fwW = ((ScrollView)paramContext);
    paramContext = this.ijA.findViewById(2131300891);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.icon_iv)");
    this.fBA = ((ImageView)paramContext);
    paramContext = this.ijA.findViewById(2131296340);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.action)");
    this.gGf = ((TextView)paramContext);
    paramContext = this.ijA.findViewById(2131298996);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.desc)");
    this.ijE = ((TextView)paramContext);
    paramContext = this.ijA.findViewById(2131305860);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.tip)");
    this.ijF = ((TextView)paramContext);
    paramContext = this.ijA.findViewById(2131296866);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.app_name_tv)");
    this.ijD = ((TextView)paramContext);
    paramContext = this.ijA.findViewById(2131299118);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.dialog_cancel)");
    this.gCY = ((Button)paramContext);
    paramContext = this.ijA.findViewById(2131299130);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.dialog_ok)");
    this.gAJ = ((Button)paramContext);
    paramContext = this.ijA.findViewById(2131304279);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.sample_root)");
    this.ijG = paramContext;
    paramContext = this.ijA.findViewById(2131304280);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.sample_view_title)");
    this.ijO = ((TextView)paramContext);
    paramContext = this.ijA.findViewById(2131299133);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.dialog_view_container)");
    this.ijH = ((FrameLayout)paramContext);
    paramContext = this.ijA.findViewById(2131299132);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.dialog_view)");
    this.ijI = paramContext;
    paramContext = this.ijA.findViewById(2131304278);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.sample_back)");
    this.ijJ = paramContext;
    paramContext = this.ijA.findViewById(2131296653);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.always_keep_tv)");
    this.ijK = ((TextView)paramContext);
    paramContext = this.ijA.findViewById(2131303012);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R…_type_always_keep_layout)");
    this.ijM = paramContext;
    paramContext = this.ijA.findViewById(2131296652);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.always_keep_checkbox)");
    this.ijN = ((CheckBox)paramContext);
    paramContext = this.ijA.findViewById(2131296654);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.always_reject_tv)");
    this.ijL = ((TextView)paramContext);
    paramContext = this.ijA.findViewById(2131306015);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.top_sample)");
    this.ijP = paramContext;
    this.ijA.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(149735);
        Object localObject = b.f(this.iki).getParent();
        if (localObject != null)
        {
          if (localObject == null)
          {
            localObject = new v("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(149735);
            throw ((Throwable)localObject);
          }
          localObject = (ViewGroup)localObject;
          int i = b.h(this.iki);
          if ((i == 1) || (i == 3))
          {
            if (b.f(this.iki).getLayoutParams().height != -2)
            {
              b.f(this.iki).getLayoutParams().height = -2;
              b.f(this.iki).requestLayout();
              AppMethodBeat.o(149735);
            }
          }
          else
          {
            i = ((ViewGroup)localObject).getHeight() - com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 60);
            if (b.f(this.iki).getHeight() > i)
            {
              b.f(this.iki).getLayoutParams().height = Math.min(i, b.f(this.iki).getHeight());
              b.f(this.iki).requestLayout();
            }
          }
          AppMethodBeat.o(149735);
          return;
        }
        AppMethodBeat.o(149735);
      }
    });
    this.ijH.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(149736);
        if (b.i(this.iki).getHeight() > 0) {
          b.d(this.iki).getLayoutParams().height = b.i(this.iki).getHeight();
        }
        AppMethodBeat.o(149736);
      }
    });
    this.hqR.addAll((Collection)paramList);
    if (paramBoolean)
    {
      this.ijB.setVisibility(8);
      this.ijP.setVisibility(0);
      this.ijP.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(149737);
          b.a(this.iki, (b.b)paramList.get(0));
          AppMethodBeat.o(149737);
        }
      });
    }
    aB(paramList);
    this.gAJ.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(149738);
        b.b(this.iki, 1);
        this.iki.dismiss();
        AppMethodBeat.o(149738);
      }
    });
    this.gCY.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(149739);
        this.iki.cancel();
        AppMethodBeat.o(149739);
      }
    });
    this.ijM.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(149740);
        paramAnonymousView = b.j(this.iki);
        if (!b.j(this.iki).isChecked()) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.setChecked(bool);
          paramAnonymousView = ((Iterable)paramList).iterator();
          while (paramAnonymousView.hasNext()) {
            ((b.b)paramAnonymousView.next()).ikk = b.j(this.iki).isChecked();
          }
        }
        AppMethodBeat.o(149740);
      }
    });
    this.ijL.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(149741);
        b.b(this.iki, 3);
        this.iki.dismiss();
        AppMethodBeat.o(149741);
      }
    });
    this.ikf = 2;
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
      localObject = ObjectAnimator.ofFloat(this.ijH, View.TRANSLATION_X, new float[] { 0.0F, -this.ijH.getWidth() }).setDuration(200L);
      d.g.b.k.g(localObject, "it");
      ((ObjectAnimator)localObject).setInterpolator((TimeInterpolator)new com.tencent.mm.msgsubscription.ui.a.a());
      localObject = (Animator)localObject;
      localObjectAnimator = ObjectAnimator.ofFloat(this.ijG, View.TRANSLATION_X, new float[] { this.ijG.getWidth(), 0.0F }).setDuration(200L);
      d.g.b.k.g(localObjectAnimator, "it");
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
      localObject = ObjectAnimator.ofFloat(this.ijH, View.TRANSLATION_X, new float[] { -this.ijH.getWidth(), 0.0F }).setDuration(200L);
      d.g.b.k.g(localObject, "it");
      ((ObjectAnimator)localObject).setInterpolator((TimeInterpolator)new com.tencent.mm.msgsubscription.ui.a.a());
      localObject = (Animator)localObject;
      localObjectAnimator = ObjectAnimator.ofFloat(this.ijG, View.TRANSLATION_X, new float[] { 0.0F, this.ijG.getWidth() }).setDuration(200L);
      d.g.b.k.g(localObjectAnimator, "it");
      localObjectAnimator.setInterpolator((TimeInterpolator)new com.tencent.mm.msgsubscription.ui.a.a());
      localAnimatorSet.playTogether(new Animator[] { localObject, (Animator)localObjectAnimator });
    }
  }
  
  private final void aB(List<b> paramList)
  {
    AppMethodBeat.i(149769);
    RecyclerView localRecyclerView = new RecyclerView(this.context);
    this.ijB.removeAllViews();
    this.ijB.addView((View)localRecyclerView, new ViewGroup.LayoutParams(-1, -2));
    this.ijC = new c(paramList, this);
    paramList = this.ijC;
    if (paramList == null) {
      d.g.b.k.aVY("adapter");
    }
    localRecyclerView.setAdapter((RecyclerView.a)paramList);
    localRecyclerView.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    localRecyclerView.b((RecyclerView.h)new b.f(this));
    AppMethodBeat.o(149769);
  }
  
  private final boolean aLk()
  {
    AppMethodBeat.i(149773);
    if (this.ijQ)
    {
      a(false, (Animator.AnimatorListener)new i(this));
      this.ijQ = false;
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
    d.g.b.k.g(localTextPaint, "paint");
    localTextPaint.setStyle(Paint.Style.FILL_AND_STROKE);
    paramTextView = paramTextView.getPaint();
    d.g.b.k.g(paramTextView, "paint");
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
    d.g.b.k.g(localObject, "(context.getSystemServic…owManager).defaultDisplay");
    int i = ((Display)localObject).getRotation();
    AppMethodBeat.o(149770);
    return i;
  }
  
  private final void pV(int paramInt)
  {
    AppMethodBeat.i(149778);
    ac.i("SubscribeMsgRequestDialog", "dispatchEvent ".concat(String.valueOf(paramInt)));
    b.d locald = this.ikg;
    if (locald != null)
    {
      List localList = (List)new ArrayList();
      localList.addAll((Collection)this.hqR);
      locald.c(paramInt, localList);
      AppMethodBeat.o(149778);
      return;
    }
    AppMethodBeat.o(149778);
  }
  
  private final void pX(int paramInt)
  {
    AppMethodBeat.i(149781);
    Object localObject;
    ViewGroup.LayoutParams localLayoutParams;
    if ((paramInt == 1) || (paramInt == 3))
    {
      localObject = this.ijA;
      localLayoutParams = this.ijA.getLayoutParams();
      localLayoutParams.width = c.cP(this.context);
      ((View)localObject).setLayoutParams(localLayoutParams);
      if (this.fwW.indexOfChild(this.ijI) == -1)
      {
        localObject = this.ijI.getParent();
        if (localObject != null)
        {
          if (localObject == null)
          {
            localObject = new v("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(149781);
            throw ((Throwable)localObject);
          }
          ((ViewGroup)localObject).removeView(this.ijI);
        }
        this.fwW.addView(this.ijI);
        this.fwW.setVisibility(0);
      }
    }
    for (;;)
    {
      this.ijA.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new h(this));
      AppMethodBeat.o(149781);
      return;
      if (c.cQ(this.context)) {
        c.a(this.ijA, (d.g.a.a)new g(this));
      }
      while (this.ijH.indexOfChild(this.ijI) == -1)
      {
        localObject = this.ijI.getParent();
        if (localObject == null) {
          break label268;
        }
        if (localObject != null) {
          break label257;
        }
        localObject = new v("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(149781);
        throw ((Throwable)localObject);
        localObject = this.ijA;
        localLayoutParams = this.ijA.getLayoutParams();
        localLayoutParams.width = -1;
        ((View)localObject).setLayoutParams(localLayoutParams);
      }
      continue;
      label257:
      ((ViewGroup)localObject).removeView(this.ijI);
      label268:
      this.ijH.addView(this.ijI);
      this.fwW.setVisibility(8);
    }
  }
  
  public final void EU(String paramString)
  {
    AppMethodBeat.i(149762);
    d.g.b.k.h(paramString, "value");
    this.appName = paramString;
    this.ijD.setText((CharSequence)this.appName);
    f(this.ijD);
    AppMethodBeat.o(149762);
  }
  
  public final void EV(String paramString)
  {
    AppMethodBeat.i(149763);
    d.g.b.k.h(paramString, "value");
    this.ijZ = paramString;
    this.gGf.setText((CharSequence)this.ijZ);
    f(this.gGf);
    AppMethodBeat.o(149763);
  }
  
  public final void EW(String paramString)
  {
    AppMethodBeat.i(149765);
    d.g.b.k.h(paramString, "value");
    this.ika = paramString;
    this.gAJ.setText((CharSequence)this.ika);
    AppMethodBeat.o(149765);
  }
  
  public final void EX(String paramString)
  {
    AppMethodBeat.i(149766);
    d.g.b.k.h(paramString, "value");
    this.ikb = paramString;
    this.gCY.setText((CharSequence)this.ikb);
    AppMethodBeat.o(149766);
  }
  
  public final void EY(String paramString)
  {
    AppMethodBeat.i(149767);
    d.g.b.k.h(paramString, "value");
    this.ikc = paramString;
    this.ijF.setText((CharSequence)this.ikc);
    paramString = this.ijF;
    if (((CharSequence)this.ikc).length() == 0)
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
    com.tencent.mm.modelappbrand.a.b.aAS().a(this.fBA, this.iconUrl, this.ikd, (com.tencent.mm.modelappbrand.a.b.h)new e());
    this.ijS = paramm;
    pX(getRotation());
    paramm = this.ike;
    if (paramm != null)
    {
      paramm.onShow();
      AppMethodBeat.o(149776);
      return;
    }
    AppMethodBeat.o(149776);
  }
  
  public final boolean aLl()
  {
    AppMethodBeat.i(149774);
    boolean bool = aLk();
    AppMethodBeat.o(149774);
    return bool;
  }
  
  public final boolean aLm()
  {
    return false;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(149779);
    pV(2);
    dismiss();
    AppMethodBeat.o(149779);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(149775);
    Object localObject = this.ijS;
    if (localObject != null) {
      ((m)localObject).c((com.tencent.mm.plugin.appbrand.widget.dialog.k)this);
    }
    localObject = this.ike;
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
    return this.ijA;
  }
  
  public final int getPosition()
  {
    return this.ikf;
  }
  
  public final boolean isCancelable()
  {
    return false;
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(149777);
    pV(2);
    AppMethodBeat.o(149777);
  }
  
  public final void pW(int paramInt)
  {
    AppMethodBeat.i(149780);
    pX(paramInt);
    AppMethodBeat.o(149780);
  }
  
  public final void qV(String paramString)
  {
    AppMethodBeat.i(149761);
    d.g.b.k.h(paramString, "value");
    this.iconUrl = paramString;
    AppMethodBeat.o(149761);
  }
  
  public final void setDesc(String paramString)
  {
    AppMethodBeat.i(149764);
    d.g.b.k.h(paramString, "value");
    this.desc = paramString;
    this.ijE.setText((CharSequence)this.desc);
    AppMethodBeat.o(149764);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Companion;", "", "()V", "TAG", "", "Rotation", "TemplateShowSampleListener", "wxbiz-msgsubscription-sdk_release"})
  public static final class a
  {
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Companion$TemplateShowSampleListener;", "", "onSampleShow", "", "templateId", "", "check", "", "index", "", "wxbiz-msgsubscription-sdk_release"})
    public static abstract interface a
    {
      public abstract void av(String paramString, int paramInt);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "", "check", "", "title", "", "sampleWordings", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "templateId", "(ZLjava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;)V", "alwaysKeep", "getAlwaysKeep", "()Z", "setAlwaysKeep", "(Z)V", "getCheck", "setCheck", "getSampleWordings", "()Ljava/util/ArrayList;", "getTemplateId", "()Ljava/lang/String;", "getTitle", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "wxbiz-msgsubscription-sdk_release"})
  public static final class b
  {
    public final String hiK;
    boolean ikk;
    public boolean ikl;
    final ArrayList<o<String, String>> ikm;
    final String title;
    
    public b(boolean paramBoolean, String paramString1, ArrayList<o<String, String>> paramArrayList, String paramString2)
    {
      AppMethodBeat.i(149742);
      this.ikl = paramBoolean;
      this.title = paramString1;
      this.ikm = paramArrayList;
      this.hiK = paramString2;
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
          if ((this.ikl != paramObject.ikl) || (!d.g.b.k.g(this.title, paramObject.title)) || (!d.g.b.k.g(this.ikm, paramObject.ikm)) || (!d.g.b.k.g(this.hiK, paramObject.hiK))) {}
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
      String str = "Item(check=" + this.ikl + ", title=" + this.title + ", sampleWordings=" + this.ikm + ", templateId=" + this.hiK + ")";
      AppMethodBeat.o(149743);
      return str;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemAdapter$Holder;", "items", "", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "dialog", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog;", "(Ljava/util/List;Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog;)V", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "itemsChecked", "", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Holder", "wxbiz-msgsubscription-sdk_release"})
  public static final class c
    extends RecyclerView.a<a>
  {
    List<b.b> hqR;
    private final List<b.b> ikn;
    private final b iko;
    
    public c(List<b.b> paramList, b paramb)
    {
      AppMethodBeat.i(149752);
      this.hqR = paramList;
      this.iko = paramb;
      this.ikn = ((List)new ArrayList());
      paramList = this.ikn;
      Object localObject1 = (Iterable)this.hqR;
      paramb = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if (((b.b)localObject2).ikl) {
          paramb.add(localObject2);
        }
      }
      paramList.addAll((Collection)paramb);
      b.a(this.iko, this.ikn.size());
      AppMethodBeat.o(149752);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(149750);
      int i = this.hqR.size();
      AppMethodBeat.o(149750);
      return i;
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemAdapter$Holder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "item", "Landroid/view/View;", "(Landroid/view/View;)V", "checkBox", "Landroid/widget/CheckBox;", "getCheckBox", "()Landroid/widget/CheckBox;", "setCheckBox", "(Landroid/widget/CheckBox;)V", "desc", "Landroid/widget/TextView;", "getDesc", "()Landroid/widget/TextView;", "setDesc", "(Landroid/widget/TextView;)V", "sample", "getSample", "()Landroid/view/View;", "setSample", "wxbiz-msgsubscription-sdk_release"})
    public static final class a
      extends RecyclerView.w
    {
      CheckBox ijt;
      TextView ikp;
      View ikq;
      
      public a(View paramView)
      {
        super();
        AppMethodBeat.i(149746);
        paramView = this.asD.findViewById(2131298255);
        d.g.b.k.g(paramView, "itemView.findViewById(R.id.checkbox)");
        this.ijt = ((CheckBox)paramView);
        paramView = this.asD.findViewById(2131298996);
        d.g.b.k.g(paramView, "itemView.findViewById(R.id.desc)");
        this.ikp = ((TextView)paramView);
        paramView = this.asD.findViewById(2131304277);
        d.g.b.k.g(paramView, "itemView.findViewById(R.id.sample)");
        this.ikq = paramView;
        AppMethodBeat.o(149746);
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b
      implements View.OnClickListener
    {
      b(b.c paramc, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(149747);
        b.a(b.c.a(this.ikr), (b.b)this.ikr.hqR.get(this.fOm));
        AppMethodBeat.o(149747);
      }
    }
    
    @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c
      implements View.OnClickListener
    {
      c(b.c paramc, b.c.a parama, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(149748);
        paramView = this.iks.ijt;
        boolean bool;
        if (!this.iks.ijt.isChecked())
        {
          bool = true;
          paramView.setChecked(bool);
          ((b.b)this.ikr.hqR.get(this.fOm)).ikl = this.iks.ijt.isChecked();
          if (!((b.b)this.ikr.hqR.get(this.fOm)).ikl) {
            break label152;
          }
          b.c.b(this.ikr).add(this.ikr.hqR.get(this.fOm));
        }
        for (;;)
        {
          b.a(b.c.a(this.ikr), b.c.b(this.ikr).size());
          AppMethodBeat.o(149748);
          return;
          bool = false;
          break;
          label152:
          b.c.b(this.ikr).remove(this.ikr.hqR.get(this.fOm));
        }
      }
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$SubscribeRequestDialogListener;", "", "onDismiss", "", "onShow", "wxbiz-msgsubscription-sdk_release"})
  public static abstract interface e
  {
    public abstract void onDismiss();
    
    public abstract void onShow();
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    g(b paramb)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$applyRotation$6", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "wxbiz-msgsubscription-sdk_release"})
  public static final class h
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(174567);
      b.f(this.iki).getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      b.a(this.iki, b.g(this.iki));
      AppMethodBeat.o(174567);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$closeSampleView$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "wxbiz-msgsubscription-sdk_release"})
  public static final class i
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(149758);
      paramAnimator = b.e(this.iki);
      if (paramAnimator != null)
      {
        int i = ((Number)paramAnimator).intValue();
        paramAnimator = b.d(this.iki).findViewById(i);
        if (paramAnimator != null)
        {
          ((LinearLayout)b.d(this.iki).findViewById(2131298736)).removeView(paramAnimator);
          AppMethodBeat.o(149758);
          return;
        }
        AppMethodBeat.o(149758);
        return;
      }
      AppMethodBeat.o(149758);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$showSample$1$1"})
  static final class j
    implements View.OnClickListener
  {
    j(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(149759);
      b.c(this.iki);
      AppMethodBeat.o(149759);
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$showSample$1$2", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "wxbiz-msgsubscription-sdk_release"})
  public static final class k
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    k(b paramb) {}
    
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(149760);
      b.d(this.iki).getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      b.a(this.iki);
      AppMethodBeat.o(149760);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.b
 * JD-Core Version:    0.7.0.1
 */
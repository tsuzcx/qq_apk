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
import com.tencent.mm.plugin.appbrand.widget.dialog.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import d.o;
import d.v;
import d.y;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog;", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IAppBrandDialog;", "context", "Landroid/content/Context;", "items", "", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "listener", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Listener;", "isSingleMode", "", "(Landroid/content/Context;Ljava/util/List;Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Listener;Z)V", "_position", "", "value", "", "actionDesc", "getActionDesc", "()Ljava/lang/String;", "setActionDesc", "(Ljava/lang/String;)V", "actionTv", "Landroid/widget/TextView;", "adapter", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemAdapter;", "alwaysKeepCb", "Landroid/widget/CheckBox;", "alwaysKeepText", "getAlwaysKeepText", "setAlwaysKeepText", "alwaysKeepTv", "alwaysKeepView", "Landroid/view/View;", "alwaysRejectText", "getAlwaysRejectText", "setAlwaysRejectText", "alwaysRejectTv", "appName", "getAppName", "setAppName", "appNameTv", "cancelBtn", "Landroid/widget/Button;", "cancelBtnText", "getCancelBtnText", "setCancelBtnText", "container", "Lcom/tencent/mm/plugin/appbrand/widget/dialog/IRuntimeDialogContainer;", "defaultIconRes", "getDefaultIconRes", "()I", "setDefaultIconRes", "(I)V", "desc", "getDesc", "setDesc", "descTV", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$SubscribeRequestDialogListener;", "dialogListener", "getDialogListener", "()Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$SubscribeRequestDialogListener;", "setDialogListener", "(Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$SubscribeRequestDialogListener;)V", "dialogView", "dialogViewContainer", "Landroid/widget/FrameLayout;", "iconIv", "Landroid/widget/ImageView;", "iconUrl", "getIconUrl", "setIconUrl", "", "mRootView", "okBtn", "okBtnText", "getOkBtnText", "setOkBtnText", "recyclerViewContainer", "sampleBack", "sampleRoot", "sampleShowing", "sampleTitle", "getSampleTitle", "setSampleTitle", "sampleViewId", "Ljava/lang/Integer;", "sampleViewTitle", "scrollView", "Landroid/widget/ScrollView;", "showAlwaysKeepView", "getShowAlwaysKeepView", "()Z", "setShowAlwaysKeepView", "(Z)V", "showAlwaysRejectView", "getShowAlwaysRejectView", "setShowAlwaysRejectView", "templateShowSampleListener", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Companion$TemplateShowSampleListener;", "getTemplateShowSampleListener", "()Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Companion$TemplateShowSampleListener;", "setTemplateShowSampleListener", "(Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Companion$TemplateShowSampleListener;)V", "tip", "getTip", "setTip", "tipTv", "topSampleBtn", "addRecyclerView", "", "alwaysKeepSelected", "applyRotation", "rotation", "cancel", "closeSampleView", "dismiss", "dispatchCancelEvent", "dispatchEvent", "event", "getContentView", "getPosition", "getRotation", "isCancelable", "isCanceledOnTouchOutside", "onBackPressedEvent", "onCancel", "onCheckedCountChanged", "size", "onDismiss", "onScreenOrientationChanged", "onShow", "dialogHelper", "setPosition", "position", "showSample", "item", "startSampleAnimation", "show", "Landroid/animation/Animator$AnimatorListener;", "setBoldStyle", "Companion", "Item", "ItemAdapter", "Listener", "SubscribeRequestDialogListener", "wxbiz-msgsubscription-sdk_release"})
public final class b
  implements com.tencent.mm.plugin.appbrand.widget.dialog.k
{
  public static final a hJJ;
  private String appName;
  public final Context context;
  private String desc;
  private ScrollView ftp;
  private ImageView fxT;
  private List<b> gQr;
  public View hIZ;
  public boolean hJA;
  private String hJB;
  private String hJC;
  private String hJD;
  private String hJE;
  public int hJF;
  public e hJG;
  public int hJH;
  private b.d hJI;
  private FrameLayout hJa;
  private c hJb;
  private TextView hJc;
  private TextView hJd;
  private TextView hJe;
  private TextView hJf;
  private Button hJg;
  private Button hJh;
  private View hJi;
  private FrameLayout hJj;
  private View hJk;
  private View hJl;
  public TextView hJm;
  public TextView hJn;
  public View hJo;
  public CheckBox hJp;
  private TextView hJq;
  private View hJr;
  private boolean hJs;
  private Integer hJt;
  private m hJu;
  public b.a.a hJv;
  public String hJw;
  public String hJx;
  public boolean hJy;
  public String hJz;
  private String iconUrl;
  
  static
  {
    AppMethodBeat.i(149783);
    hJJ = new a((byte)0);
    AppMethodBeat.o(149783);
  }
  
  public b(Context paramContext, final List<b> paramList, b.d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(149782);
    this.context = paramContext;
    this.hJI = paramd;
    paramContext = LayoutInflater.from(this.context).inflate(2131495728, null);
    d.g.b.k.g(paramContext, "LayoutInflater.from(cont…msg_request_dialog, null)");
    this.hIZ = paramContext;
    this.gQr = ((List)new ArrayList());
    this.iconUrl = "";
    this.appName = "";
    this.hJw = "";
    this.hJx = "";
    this.hJy = true;
    this.hJz = "";
    this.hJA = true;
    this.hJB = "";
    this.desc = "";
    this.hJC = "";
    this.hJD = "";
    this.hJE = "";
    paramContext = this.hIZ.findViewById(2131301165);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.item_list_container)");
    this.hJa = ((FrameLayout)paramContext);
    paramContext = this.hIZ.findViewById(2131304376);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.scroll_view)");
    this.ftp = ((ScrollView)paramContext);
    paramContext = this.hIZ.findViewById(2131300891);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.icon_iv)");
    this.fxT = ((ImageView)paramContext);
    paramContext = this.hIZ.findViewById(2131296340);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.action)");
    this.hJc = ((TextView)paramContext);
    paramContext = this.hIZ.findViewById(2131298996);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.desc)");
    this.hJe = ((TextView)paramContext);
    paramContext = this.hIZ.findViewById(2131305860);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.tip)");
    this.hJf = ((TextView)paramContext);
    paramContext = this.hIZ.findViewById(2131296866);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.app_name_tv)");
    this.hJd = ((TextView)paramContext);
    paramContext = this.hIZ.findViewById(2131299118);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.dialog_cancel)");
    this.hJg = ((Button)paramContext);
    paramContext = this.hIZ.findViewById(2131299130);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.dialog_ok)");
    this.hJh = ((Button)paramContext);
    paramContext = this.hIZ.findViewById(2131304279);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.sample_root)");
    this.hJi = paramContext;
    paramContext = this.hIZ.findViewById(2131304280);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.sample_view_title)");
    this.hJq = ((TextView)paramContext);
    paramContext = this.hIZ.findViewById(2131299133);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.dialog_view_container)");
    this.hJj = ((FrameLayout)paramContext);
    paramContext = this.hIZ.findViewById(2131299132);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.dialog_view)");
    this.hJk = paramContext;
    paramContext = this.hIZ.findViewById(2131304278);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.sample_back)");
    this.hJl = paramContext;
    paramContext = this.hIZ.findViewById(2131296653);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.always_keep_tv)");
    this.hJm = ((TextView)paramContext);
    paramContext = this.hIZ.findViewById(2131303012);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R…_type_always_keep_layout)");
    this.hJo = paramContext;
    paramContext = this.hIZ.findViewById(2131296652);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.always_keep_checkbox)");
    this.hJp = ((CheckBox)paramContext);
    paramContext = this.hIZ.findViewById(2131296654);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.always_reject_tv)");
    this.hJn = ((TextView)paramContext);
    paramContext = this.hIZ.findViewById(2131306015);
    d.g.b.k.g(paramContext, "mRootView.findViewById(R.id.top_sample)");
    this.hJr = paramContext;
    this.hIZ.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(149735);
        Object localObject = b.f(this.hJK).getParent();
        if (localObject != null)
        {
          if (localObject == null)
          {
            localObject = new v("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(149735);
            throw ((Throwable)localObject);
          }
          localObject = (ViewGroup)localObject;
          int i = b.h(this.hJK);
          if ((i == 1) || (i == 3))
          {
            if (b.f(this.hJK).getLayoutParams().height != -2)
            {
              b.f(this.hJK).getLayoutParams().height = -2;
              b.f(this.hJK).requestLayout();
              AppMethodBeat.o(149735);
            }
          }
          else
          {
            i = ((ViewGroup)localObject).getHeight() - com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 60);
            if (b.f(this.hJK).getHeight() > i)
            {
              b.f(this.hJK).getLayoutParams().height = Math.min(i, b.f(this.hJK).getHeight());
              b.f(this.hJK).requestLayout();
            }
          }
          AppMethodBeat.o(149735);
          return;
        }
        AppMethodBeat.o(149735);
      }
    });
    this.hJj.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public final void onGlobalLayout()
      {
        AppMethodBeat.i(149736);
        if (b.i(this.hJK).getHeight() > 0) {
          b.d(this.hJK).getLayoutParams().height = b.i(this.hJK).getHeight();
        }
        AppMethodBeat.o(149736);
      }
    });
    this.gQr.addAll((Collection)paramList);
    if (paramBoolean)
    {
      this.hJa.setVisibility(8);
      this.hJr.setVisibility(0);
      this.hJr.setOnClickListener((View.OnClickListener)new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(149737);
          b.a(this.hJK, (b.b)paramList.get(0));
          AppMethodBeat.o(149737);
        }
      });
    }
    aE(paramList);
    this.hJh.setOnClickListener((View.OnClickListener)new b.4(this));
    this.hJg.setOnClickListener((View.OnClickListener)new b.5(this));
    this.hJo.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(149740);
        paramAnonymousView = b.j(this.hJK);
        if (!b.j(this.hJK).isChecked()) {}
        for (boolean bool = true;; bool = false)
        {
          paramAnonymousView.setChecked(bool);
          paramAnonymousView = ((Iterable)paramList).iterator();
          while (paramAnonymousView.hasNext()) {
            ((b.b)paramAnonymousView.next()).hJM = b.j(this.hJK).isChecked();
          }
        }
        AppMethodBeat.o(149740);
      }
    });
    this.hJn.setOnClickListener((View.OnClickListener)new b.7(this));
    this.hJH = 2;
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
      localObject = ObjectAnimator.ofFloat(this.hJj, View.TRANSLATION_X, new float[] { 0.0F, -this.hJj.getWidth() }).setDuration(200L);
      d.g.b.k.g(localObject, "it");
      ((ObjectAnimator)localObject).setInterpolator((TimeInterpolator)new com.tencent.mm.msgsubscription.ui.a.a());
      localObject = (Animator)localObject;
      localObjectAnimator = ObjectAnimator.ofFloat(this.hJi, View.TRANSLATION_X, new float[] { this.hJi.getWidth(), 0.0F }).setDuration(200L);
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
      localObject = ObjectAnimator.ofFloat(this.hJj, View.TRANSLATION_X, new float[] { -this.hJj.getWidth(), 0.0F }).setDuration(200L);
      d.g.b.k.g(localObject, "it");
      ((ObjectAnimator)localObject).setInterpolator((TimeInterpolator)new com.tencent.mm.msgsubscription.ui.a.a());
      localObject = (Animator)localObject;
      localObjectAnimator = ObjectAnimator.ofFloat(this.hJi, View.TRANSLATION_X, new float[] { 0.0F, this.hJi.getWidth() }).setDuration(200L);
      d.g.b.k.g(localObjectAnimator, "it");
      localObjectAnimator.setInterpolator((TimeInterpolator)new com.tencent.mm.msgsubscription.ui.a.a());
      localAnimatorSet.playTogether(new Animator[] { localObject, (Animator)localObjectAnimator });
    }
  }
  
  private final void aE(List<b> paramList)
  {
    AppMethodBeat.i(149769);
    RecyclerView localRecyclerView = new RecyclerView(this.context);
    this.hJa.removeAllViews();
    this.hJa.addView((View)localRecyclerView, new ViewGroup.LayoutParams(-1, -2));
    this.hJb = new c(paramList, this);
    paramList = this.hJb;
    if (paramList == null) {
      d.g.b.k.aPZ("adapter");
    }
    localRecyclerView.setAdapter((RecyclerView.a)paramList);
    localRecyclerView.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    localRecyclerView.b((RecyclerView.h)new f(this));
    AppMethodBeat.o(149769);
  }
  
  private final boolean aEt()
  {
    AppMethodBeat.i(149773);
    if (this.hJs)
    {
      a(false, (Animator.AnimatorListener)new i(this));
      this.hJs = false;
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
  
  private final void ph(int paramInt)
  {
    AppMethodBeat.i(149778);
    ad.i("SubscribeMsgRequestDialog", "dispatchEvent ".concat(String.valueOf(paramInt)));
    b.d locald = this.hJI;
    if (locald != null)
    {
      List localList = (List)new ArrayList();
      localList.addAll((Collection)this.gQr);
      locald.c(paramInt, localList);
      AppMethodBeat.o(149778);
      return;
    }
    AppMethodBeat.o(149778);
  }
  
  private final void pj(int paramInt)
  {
    AppMethodBeat.i(149781);
    Object localObject;
    ViewGroup.LayoutParams localLayoutParams;
    if ((paramInt == 1) || (paramInt == 3))
    {
      localObject = this.hIZ;
      localLayoutParams = this.hIZ.getLayoutParams();
      localLayoutParams.width = c.cG(this.context);
      ((View)localObject).setLayoutParams(localLayoutParams);
      if (this.ftp.indexOfChild(this.hJk) == -1)
      {
        localObject = this.hJk.getParent();
        if (localObject != null)
        {
          if (localObject == null)
          {
            localObject = new v("null cannot be cast to non-null type android.view.ViewGroup");
            AppMethodBeat.o(149781);
            throw ((Throwable)localObject);
          }
          ((ViewGroup)localObject).removeView(this.hJk);
        }
        this.ftp.addView(this.hJk);
        this.ftp.setVisibility(0);
      }
    }
    for (;;)
    {
      this.hIZ.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)new h(this));
      AppMethodBeat.o(149781);
      return;
      if (c.cH(this.context)) {
        c.a(this.hIZ, (d.g.a.a)new g(this));
      }
      while (this.hJj.indexOfChild(this.hJk) == -1)
      {
        localObject = this.hJk.getParent();
        if (localObject == null) {
          break label268;
        }
        if (localObject != null) {
          break label257;
        }
        localObject = new v("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(149781);
        throw ((Throwable)localObject);
        localObject = this.hIZ;
        localLayoutParams = this.hIZ.getLayoutParams();
        localLayoutParams.width = -1;
        ((View)localObject).setLayoutParams(localLayoutParams);
      }
      continue;
      label257:
      ((ViewGroup)localObject).removeView(this.hJk);
      label268:
      this.hJj.addView(this.hJk);
      this.ftp.setVisibility(8);
    }
  }
  
  public final void AP(String paramString)
  {
    AppMethodBeat.i(149762);
    d.g.b.k.h(paramString, "value");
    this.appName = paramString;
    this.hJd.setText((CharSequence)this.appName);
    f(this.hJd);
    AppMethodBeat.o(149762);
  }
  
  public final void AQ(String paramString)
  {
    AppMethodBeat.i(149763);
    d.g.b.k.h(paramString, "value");
    this.hJB = paramString;
    this.hJc.setText((CharSequence)this.hJB);
    f(this.hJc);
    AppMethodBeat.o(149763);
  }
  
  public final void AR(String paramString)
  {
    AppMethodBeat.i(149765);
    d.g.b.k.h(paramString, "value");
    this.hJC = paramString;
    this.hJh.setText((CharSequence)this.hJC);
    AppMethodBeat.o(149765);
  }
  
  public final void AS(String paramString)
  {
    AppMethodBeat.i(149766);
    d.g.b.k.h(paramString, "value");
    this.hJD = paramString;
    this.hJg.setText((CharSequence)this.hJD);
    AppMethodBeat.o(149766);
  }
  
  public final void AT(String paramString)
  {
    AppMethodBeat.i(149767);
    d.g.b.k.h(paramString, "value");
    this.hJE = paramString;
    this.hJf.setText((CharSequence)this.hJE);
    paramString = this.hJf;
    if (((CharSequence)this.hJE).length() == 0)
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
    com.tencent.mm.modelappbrand.a.b.aub().a(this.fxT, this.iconUrl, this.hJF, (com.tencent.mm.modelappbrand.a.b.h)new e());
    this.hJu = paramm;
    pj(getRotation());
    paramm = this.hJG;
    if (paramm != null)
    {
      paramm.onShow();
      AppMethodBeat.o(149776);
      return;
    }
    AppMethodBeat.o(149776);
  }
  
  public final boolean aEu()
  {
    AppMethodBeat.i(149774);
    boolean bool = aEt();
    AppMethodBeat.o(149774);
    return bool;
  }
  
  public final boolean aEv()
  {
    return false;
  }
  
  public final void cancel()
  {
    AppMethodBeat.i(149779);
    ph(2);
    dismiss();
    AppMethodBeat.o(149779);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(149775);
    Object localObject = this.hJu;
    if (localObject != null) {
      ((m)localObject).c((com.tencent.mm.plugin.appbrand.widget.dialog.k)this);
    }
    localObject = this.hJG;
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
    return this.hIZ;
  }
  
  public final int getPosition()
  {
    return this.hJH;
  }
  
  public final boolean isCancelable()
  {
    return false;
  }
  
  public final void nP(String paramString)
  {
    AppMethodBeat.i(149761);
    d.g.b.k.h(paramString, "value");
    this.iconUrl = paramString;
    AppMethodBeat.o(149761);
  }
  
  public final void onCancel()
  {
    AppMethodBeat.i(149777);
    ph(2);
    AppMethodBeat.o(149777);
  }
  
  public final void pi(int paramInt)
  {
    AppMethodBeat.i(149780);
    pj(paramInt);
    AppMethodBeat.o(149780);
  }
  
  public final void setDesc(String paramString)
  {
    AppMethodBeat.i(149764);
    d.g.b.k.h(paramString, "value");
    this.desc = paramString;
    this.hJe.setText((CharSequence)this.desc);
    AppMethodBeat.o(149764);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Companion;", "", "()V", "TAG", "", "Rotation", "TemplateShowSampleListener", "wxbiz-msgsubscription-sdk_release"})
  public static final class a
  {
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Companion$TemplateShowSampleListener;", "", "onSampleShow", "", "templateId", "", "check", "", "index", "", "wxbiz-msgsubscription-sdk_release"})
    public static abstract interface a
    {
      public abstract void ar(String paramString, int paramInt);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "", "check", "", "title", "", "sampleWordings", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "templateId", "(ZLjava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;)V", "alwaysKeep", "getAlwaysKeep", "()Z", "setAlwaysKeep", "(Z)V", "getCheck", "setCheck", "getSampleWordings", "()Ljava/util/ArrayList;", "getTemplateId", "()Ljava/lang/String;", "getTitle", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "wxbiz-msgsubscription-sdk_release"})
  public static final class b
  {
    public final String gIj;
    boolean hJM;
    public boolean hJN;
    final ArrayList<o<String, String>> hJO;
    final String title;
    
    public b(boolean paramBoolean, String paramString1, ArrayList<o<String, String>> paramArrayList, String paramString2)
    {
      AppMethodBeat.i(149742);
      this.hJN = paramBoolean;
      this.title = paramString1;
      this.hJO = paramArrayList;
      this.gIj = paramString2;
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
          if ((this.hJN != paramObject.hJN) || (!d.g.b.k.g(this.title, paramObject.title)) || (!d.g.b.k.g(this.hJO, paramObject.hJO)) || (!d.g.b.k.g(this.gIj, paramObject.gIj))) {}
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
      String str = "Item(check=" + this.hJN + ", title=" + this.title + ", sampleWordings=" + this.hJO + ", templateId=" + this.gIj + ")";
      AppMethodBeat.o(149743);
      return str;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemAdapter$Holder;", "items", "", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$Item;", "dialog", "Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog;", "(Ljava/util/List;Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog;)V", "getItems", "()Ljava/util/List;", "setItems", "(Ljava/util/List;)V", "itemsChecked", "", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Holder", "wxbiz-msgsubscription-sdk_release"})
  public static final class c
    extends RecyclerView.a<a>
  {
    List<b.b> gQr;
    private final List<b.b> hJP;
    private final b hJQ;
    
    public c(List<b.b> paramList, b paramb)
    {
      AppMethodBeat.i(149752);
      this.gQr = paramList;
      this.hJQ = paramb;
      this.hJP = ((List)new ArrayList());
      paramList = this.hJP;
      Object localObject1 = (Iterable)this.gQr;
      paramb = (Collection)new ArrayList();
      localObject1 = ((Iterable)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = ((Iterator)localObject1).next();
        if (((b.b)localObject2).hJN) {
          paramb.add(localObject2);
        }
      }
      paramList.addAll((Collection)paramb);
      b.a(this.hJQ, this.hJP.size());
      AppMethodBeat.o(149752);
    }
    
    public final int getItemCount()
    {
      AppMethodBeat.i(149750);
      int i = this.gQr.size();
      AppMethodBeat.o(149750);
      return i;
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$ItemAdapter$Holder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "item", "Landroid/view/View;", "(Landroid/view/View;)V", "checkBox", "Landroid/widget/CheckBox;", "getCheckBox", "()Landroid/widget/CheckBox;", "setCheckBox", "(Landroid/widget/CheckBox;)V", "desc", "Landroid/widget/TextView;", "getDesc", "()Landroid/widget/TextView;", "setDesc", "(Landroid/widget/TextView;)V", "sample", "getSample", "()Landroid/view/View;", "setSample", "wxbiz-msgsubscription-sdk_release"})
    public static final class a
      extends RecyclerView.v
    {
      CheckBox hIS;
      TextView hJR;
      View hJS;
      
      public a(View paramView)
      {
        super();
        AppMethodBeat.i(149746);
        paramView = this.arI.findViewById(2131298255);
        d.g.b.k.g(paramView, "itemView.findViewById(R.id.checkbox)");
        this.hIS = ((CheckBox)paramView);
        paramView = this.arI.findViewById(2131298996);
        d.g.b.k.g(paramView, "itemView.findViewById(R.id.desc)");
        this.hJR = ((TextView)paramView);
        paramView = this.arI.findViewById(2131304277);
        d.g.b.k.g(paramView, "itemView.findViewById(R.id.sample)");
        this.hJS = paramView;
        AppMethodBeat.o(149746);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class b
      implements View.OnClickListener
    {
      b(b.c paramc, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(149747);
        b.a(b.c.a(this.hJT), (b.b)this.hJT.gQr.get(this.fKG));
        AppMethodBeat.o(149747);
      }
    }
    
    @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
    static final class c
      implements View.OnClickListener
    {
      c(b.c paramc, b.c.a parama, int paramInt) {}
      
      public final void onClick(View paramView)
      {
        AppMethodBeat.i(149748);
        paramView = this.hJU.hIS;
        boolean bool;
        if (!this.hJU.hIS.isChecked())
        {
          bool = true;
          paramView.setChecked(bool);
          ((b.b)this.hJT.gQr.get(this.fKG)).hJN = this.hJU.hIS.isChecked();
          if (!((b.b)this.hJT.gQr.get(this.fKG)).hJN) {
            break label152;
          }
          b.c.b(this.hJT).add(this.hJT.gQr.get(this.fKG));
        }
        for (;;)
        {
          b.a(b.c.a(this.hJT), b.c.b(this.hJT).size());
          AppMethodBeat.o(149748);
          return;
          bool = false;
          break;
          label152:
          b.c.b(this.hJT).remove(this.hJT.gQr.get(this.fKG));
        }
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$SubscribeRequestDialogListener;", "", "onDismiss", "", "onShow", "wxbiz-msgsubscription-sdk_release"})
  public static abstract interface e
  {
    public abstract void onDismiss();
    
    public abstract void onShow();
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$addRecyclerView$divider$1", "Landroid/support/v7/widget/RecyclerView$ItemDecoration;", "paddingLeft", "", "getPaddingLeft", "()I", "paint", "Landroid/graphics/Paint;", "getPaint", "()Landroid/graphics/Paint;", "strokeWidth", "getStrokeWidth", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroid/support/v7/widget/RecyclerView;", "state", "Landroid/support/v7/widget/RecyclerView$State;", "onDraw", "c", "Landroid/graphics/Canvas;", "wxbiz-msgsubscription-sdk_release"})
  public static final class f
    extends RecyclerView.h
  {
    private final int paddingLeft;
    private final Paint paint;
    private final int strokeWidth;
    
    f()
    {
      AppMethodBeat.i(149756);
      this.strokeWidth = com.tencent.mm.cd.a.g(aj.getContext(), 0.5F);
      this.paddingLeft = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 40);
      this.paint = new Paint();
      this.paint.setColor(b.b(localb).getResources().getColor(2131100241));
      this.paint.setStyle(Paint.Style.FILL);
      this.paint.setFlags(1);
      this.paint.setStrokeWidth(this.strokeWidth);
      AppMethodBeat.o(149756);
    }
    
    public final void a(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.s params)
    {
      AppMethodBeat.i(149754);
      d.g.b.k.h(paramCanvas, "c");
      d.g.b.k.h(paramRecyclerView, "parent");
      d.g.b.k.h(params, "state");
      super.a(paramCanvas, paramRecyclerView, params);
      float f1 = paramRecyclerView.getPaddingLeft();
      float f2 = paramRecyclerView.getWidth() - paramRecyclerView.getPaddingRight();
      int j = paramRecyclerView.getChildCount();
      int i = 0;
      if (i < j)
      {
        params = paramRecyclerView.getChildAt(i);
        d.g.b.k.g(params, "child");
        Object localObject = params.getLayoutParams();
        if (localObject == null)
        {
          paramCanvas = new v("null cannot be cast to non-null type android.support.v7.widget.RecyclerView.LayoutParams");
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
      d.g.b.k.h(paramRect, "outRect");
      d.g.b.k.h(paramView, "view");
      d.g.b.k.h(paramRecyclerView, "parent");
      d.g.b.k.h(params, "state");
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
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "invoke"})
  static final class g
    extends d.g.b.l
    implements d.g.a.a<y>
  {
    g(b paramb)
    {
      super();
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$applyRotation$6", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "wxbiz-msgsubscription-sdk_release"})
  public static final class h
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(174567);
      b.f(this.hJK).getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      b.a(this.hJK, b.g(this.hJK));
      AppMethodBeat.o(174567);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$closeSampleView$1", "Landroid/animation/AnimatorListenerAdapter;", "onAnimationEnd", "", "animation", "Landroid/animation/Animator;", "wxbiz-msgsubscription-sdk_release"})
  public static final class i
    extends AnimatorListenerAdapter
  {
    public final void onAnimationEnd(Animator paramAnimator)
    {
      AppMethodBeat.i(149758);
      paramAnimator = b.e(this.hJK);
      if (paramAnimator != null)
      {
        int i = ((Number)paramAnimator).intValue();
        paramAnimator = b.d(this.hJK).findViewById(i);
        if (paramAnimator != null)
        {
          ((LinearLayout)b.d(this.hJK).findViewById(2131298736)).removeView(paramAnimator);
          AppMethodBeat.o(149758);
          return;
        }
        AppMethodBeat.o(149758);
        return;
      }
      AppMethodBeat.o(149758);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/msgsubscription/ui/SubscribeMsgRequestDialog$showSample$1$2", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "onGlobalLayout", "", "wxbiz-msgsubscription-sdk_release"})
  public static final class k
    implements ViewTreeObserver.OnGlobalLayoutListener
  {
    k(b paramb) {}
    
    public final void onGlobalLayout()
    {
      AppMethodBeat.i(149760);
      b.d(this.hJK).getViewTreeObserver().removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
      b.a(this.hJK);
      AppMethodBeat.o(149760);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.ui.b
 * JD-Core Version:    0.7.0.1
 */
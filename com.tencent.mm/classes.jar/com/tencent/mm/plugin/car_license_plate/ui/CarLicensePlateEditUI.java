package com.tencent.mm.plugin.car_license_plate.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.lifecycle.j.a;
import androidx.lifecycle.p;
import androidx.lifecycle.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.car_license_plate.a.a;
import com.tencent.mm.plugin.car_license_plate.a.d;
import com.tencent.mm.plugin.car_license_plate.a.e;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.pulldown.c;
import com.tencent.mm.ui.y;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;

@com.tencent.mm.ui.base.a(3)
@c(0)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditUI;", "Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateBaseActivity;", "()V", "defaultPlateNo", "", "finishBtn", "Landroid/view/View;", "inputLayoutController", "Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditInputLayoutController;", "keyboardController", "Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditKeyboardController;", "finish", "", "finishOnSubmitted", "text", "getLayoutId", "", "onBackPressed", "onCreateBeforeSetContentView", "onPostCreate", "savedInstanceState", "Landroid/os/Bundle;", "setEnterAnimation", "setExitAnimation", "trySubmitAndFinishActivity", "useSlideInStyle", "", "Companion", "plugin-car-license-plate_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class CarLicensePlateEditUI
  extends CarLicensePlateBaseActivity
{
  public static final CarLicensePlateEditUI.a wcs;
  private String wbL;
  private a wct;
  private b wcu;
  private View wcv;
  
  static
  {
    AppMethodBeat.i(277851);
    wcs = new CarLicensePlateEditUI.a((byte)0);
    AppMethodBeat.o(277851);
  }
  
  private static final void a(CarLicensePlateEditUI paramCarLicensePlateEditUI, View paramView)
  {
    AppMethodBeat.i(277800);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramCarLicensePlateEditUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramCarLicensePlateEditUI, "this$0");
    paramCarLicensePlateEditUI.onBackPressed();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(277800);
  }
  
  private final void akn(String paramString)
  {
    AppMethodBeat.i(277797);
    setResult(-1, new Intent().putExtra("RESULT_KEY_SUBMITTED_PLATE_TEXT", paramString));
    finish();
    AppMethodBeat.o(277797);
  }
  
  private static final void b(CarLicensePlateEditUI paramCarLicensePlateEditUI, View paramView)
  {
    AppMethodBeat.i(277802);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramCarLicensePlateEditUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramCarLicensePlateEditUI, "this$0");
    paramCarLicensePlateEditUI.onBackPressed();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(277802);
  }
  
  private static final void c(CarLicensePlateEditUI paramCarLicensePlateEditUI, final View paramView)
  {
    AppMethodBeat.i(277806);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramCarLicensePlateEditUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramCarLicensePlateEditUI, "this$0");
    localObject = paramCarLicensePlateEditUI.wct;
    paramView = (View)localObject;
    if (localObject == null)
    {
      s.bIx("inputLayoutController");
      paramView = null;
    }
    paramView = paramView.wci;
    if (s.p(paramView, paramCarLicensePlateEditUI.wbL)) {
      paramCarLicensePlateEditUI.akn(paramView);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(277806);
      return;
      kotlinx.coroutines.j.a(paramCarLicensePlateEditUI.mainScope, null, null, (m)new c(paramCarLicensePlateEditUI, paramView, null), 3);
    }
  }
  
  private final boolean diQ()
  {
    AppMethodBeat.i(277796);
    CharSequence localCharSequence = (CharSequence)this.wbL;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i == 0; i = 0)
    {
      AppMethodBeat.o(277796);
      return true;
    }
    AppMethodBeat.o(277796);
    return false;
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final void finish()
  {
    AppMethodBeat.i(277950);
    super.finish();
    if (diQ())
    {
      overridePendingTransition(a.a.slide_left_in, a.a.slide_right_out);
      AppMethodBeat.o(277950);
      return;
    }
    overridePendingTransition(a.a.anim_not_change, a.a.push_down_out);
    AppMethodBeat.o(277950);
  }
  
  public final int getLayoutId()
  {
    return a.e.car_license_plate_edit_ui_main;
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(277939);
    super.onBackPressed();
    setResult(0);
    AppMethodBeat.o(277939);
  }
  
  public final void onCreateBeforeSetContentView()
  {
    AppMethodBeat.i(277902);
    super.onCreateBeforeSetContentView();
    com.tencent.luggage.sdk.h.a.b((Activity)this, 10);
    com.tencent.luggage.sdk.h.a.b((Activity)this, 1);
    Object localObject = getWindow();
    if (localObject != null) {
      ((Window)localObject).setSoftInputMode(3);
    }
    localObject = getIntent();
    if (localObject == null) {}
    for (localObject = null;; localObject = ((Intent)localObject).getStringExtra("INTENT_KEY_DEFAULT_PLATE_TEXT"))
    {
      this.wbL = ((String)localObject);
      if (!diQ()) {
        break;
      }
      overridePendingTransition(a.a.slide_right_in, a.a.slide_left_out);
      AppMethodBeat.o(277902);
      return;
    }
    overridePendingTransition(a.a.push_up_in, a.a.anim_not_change);
    AppMethodBeat.o(277902);
  }
  
  public final void onPostCreate(Bundle paramBundle)
  {
    int j = 8;
    AppMethodBeat.i(277931);
    super.onPostCreate(paramBundle);
    getController().setStatusBarColor(androidx.core.content.a.w((Context)this, com.tencent.mm.plugin.car_license_plate.a.b.white));
    getController().setNavigationbarColor(androidx.core.content.a.w((Context)this, com.tencent.mm.plugin.car_license_plate.a.b.BW_97));
    getContentView().setBackgroundColor(androidx.core.content.a.w((Context)this, com.tencent.mm.plugin.car_license_plate.a.b.white));
    paramBundle = getContentView().findViewById(a.d.btn_cancel);
    if (diQ()) {}
    for (int i = 8;; i = 0)
    {
      paramBundle.setVisibility(i);
      paramBundle.setOnClickListener(new CarLicensePlateEditUI..ExternalSyntheticLambda0(this));
      paramBundle = getContentView().findViewById(a.d.btn_back);
      i = j;
      if (diQ()) {
        i = 0;
      }
      paramBundle.setVisibility(i);
      paramBundle.setOnClickListener(new CarLicensePlateEditUI..ExternalSyntheticLambda2(this));
      paramBundle = getContentView().findViewById(a.d.btn_finish);
      s.s(paramBundle, "this");
      this.wcv = paramBundle;
      paramBundle.setEnabled(false);
      paramBundle.setOnClickListener(new CarLicensePlateEditUI..ExternalSyntheticLambda1(this));
      paramBundle = new b();
      localObject = getContentView().findViewById(a.d.car_license_plate_edit_ui_main);
      if (localObject != null) {
        break;
      }
      paramBundle = new NullPointerException("null cannot be cast to non-null type android.widget.RelativeLayout");
      AppMethodBeat.o(277931);
      throw paramBundle;
    }
    Object localObject = (RelativeLayout)localObject;
    s.u(localObject, "containerLayout");
    paramBundle.wco = ((RelativeLayout)localObject);
    localObject = ((RelativeLayout)localObject).getContext();
    s.s(localObject, "containerLayout.context");
    paramBundle.context = ((Context)localObject);
    localObject = ah.aiuX;
    this.wcu = paramBundle;
    LinearLayout localLinearLayout = (LinearLayout)getContentView().findViewById(a.d.layout_edit_input);
    paramBundle = (MMActivity)this;
    s.s(localLinearLayout, "this");
    a locala = new a(paramBundle, localLinearLayout);
    this.wct = locala;
    paramBundle = this.wcu;
    if (paramBundle == null)
    {
      s.bIx("keyboardController");
      paramBundle = null;
    }
    for (;;)
    {
      paramBundle.wcp = ((b.a)locala);
      locala.wch = ((a.b)new b(this));
      localObject = this.wbL;
      paramBundle = (Bundle)localObject;
      if (localObject == null) {
        paramBundle = "";
      }
      locala.init(paramBundle);
      paramBundle = new ViewTreeObserver.OnGlobalLayoutListener()
      {
        @z(Ho=j.a.ON_DESTROY)
        public final void onActivityDestroyed()
        {
          AppMethodBeat.i(277660);
          ViewTreeObserver localViewTreeObserver = this.wcx.getViewTreeObserver();
          if (localViewTreeObserver == null)
          {
            AppMethodBeat.o(277660);
            return;
          }
          if (localViewTreeObserver.isAlive()) {
            localViewTreeObserver.removeOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)this);
          }
          AppMethodBeat.o(277660);
        }
        
        public final void onGlobalLayout()
        {
          AppMethodBeat.i(277650);
          if ((this.wcx.isLaidOut()) && (CarLicensePlateEditUI.d(jdField_this).isLaidOut())) {
            if (this.wcx.getMeasuredWidth() <= CarLicensePlateEditUI.d(jdField_this).getMeasuredWidth()) {
              break label91;
            }
          }
          label91:
          for (float f = CarLicensePlateEditUI.d(jdField_this).getMeasuredWidth() / this.wcx.getMeasuredWidth();; f = 1.0F)
          {
            this.wcx.setScaleX(f);
            this.wcx.setScaleY(f);
            AppMethodBeat.o(277650);
            return;
          }
        }
      };
      localLinearLayout.getViewTreeObserver().addOnGlobalLayoutListener((ViewTreeObserver.OnGlobalLayoutListener)paramBundle);
      getLifecycle().addObserver((p)paramBundle);
      paramBundle = (TextView)getContentView().findViewById(a.d.tv_privacy_desc);
      localObject = com.tencent.mm.plugin.car_license_plate.api.entity.a.wbN;
      paramBundle.setText((CharSequence)com.tencent.mm.plugin.car_license_plate.api.entity.a.wbQ.a(localObject, com.tencent.mm.plugin.car_license_plate.api.entity.a.aYe[2]));
      AppMethodBeat.o(277931);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditUI$onPostCreate$5$1$1", "Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditInputLayoutController$ViewCallback;", "onKeyboardViewRequested", "", "type", "Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateEditViewContract$CharViewType;", "onTextChanged", "text", "", "allowSubmit", "", "plugin-car-license-plate_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements a.b
  {
    b(CarLicensePlateEditUI paramCarLicensePlateEditUI) {}
    
    public final void a(c.b paramb)
    {
      AppMethodBeat.i(277658);
      s.u(paramb, "type");
      b localb = CarLicensePlateEditUI.c(this.wcw);
      if (localb == null)
      {
        s.bIx("keyboardController");
        localb = null;
      }
      Object localObject3;
      for (;;)
      {
        s.u(paramb, "type");
        localObject1 = (ViewGroup)localb.wcq.get(paramb.diT());
        if (localObject1 != null) {
          break label329;
        }
        localObject2 = localb.context;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("context");
          localObject1 = null;
        }
        localObject3 = LayoutInflater.from((Context)localObject1);
        i = a.e.car_license_plate_edit_keyboard_view;
        localObject2 = localb.wco;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          s.bIx("containerLayout");
          localObject1 = null;
        }
        localObject1 = ((LayoutInflater)localObject3).inflate(i, (ViewGroup)localObject1, false);
        if (localObject1 != null) {
          break;
        }
        paramb = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
        AppMethodBeat.o(277658);
        throw paramb;
      }
      Object localObject2 = (ViewGroup)localObject1;
      Object localObject1 = localb.wco;
      label258:
      int k;
      if (localObject1 == null)
      {
        s.bIx("containerLayout");
        localObject1 = null;
        localObject3 = (View)localObject2;
        RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, -2);
        localLayoutParams.addRule(12);
        ah localah = ah.aiuX;
        ((RelativeLayout)localObject1).addView((View)localObject3, (ViewGroup.LayoutParams)localLayoutParams);
        localb.a((ViewGroup)localObject2, paramb.diS());
        localb.wcq.put(paramb.diT(), localObject2);
        localObject1 = localObject2;
        b.a((ViewGroup)localObject1, paramb);
        k = localb.wcq.size();
        if (k <= 0) {}
      }
      int j;
      label329:
      label338:
      for (int i = 0;; i = j)
      {
        j = i + 1;
        paramb = (ViewGroup)localb.wcq.valueAt(i);
        if (s.p(localObject1, paramb)) {}
        for (i = 0;; i = 8)
        {
          paramb.setVisibility(i);
          if (j < k) {
            break label338;
          }
          AppMethodBeat.o(277658);
          return;
          break;
          break label258;
        }
      }
    }
    
    public final void aZ(String paramString, boolean paramBoolean)
    {
      AppMethodBeat.i(277648);
      s.u(paramString, "text");
      View localView = CarLicensePlateEditUI.b(this.wcw);
      paramString = localView;
      if (localView == null)
      {
        s.bIx("finishBtn");
        paramString = null;
      }
      paramString.setEnabled(paramBoolean);
      AppMethodBeat.o(277648);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    c(CarLicensePlateEditUI paramCarLicensePlateEditUI, String paramString, kotlin.d.d<? super c> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(277657);
      paramObject = (kotlin.d.d)new c(this.wcw, paramView, paramd);
      AppMethodBeat.o(277657);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(277652);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(277652);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
      }
      for (;;)
      {
        try
        {
          paramObject = (CharSequence)CarLicensePlateEditUI.a(this.wcw);
          if (paramObject == null) {
            break label335;
          }
          if (paramObject.length() == 0)
          {
            break label335;
            if (i == 0) {
              continue;
            }
            paramObject = new com.tencent.mm.plugin.car_license_plate.a.b(paramView);
            locald = (kotlin.d.d)this;
            this.label = 1;
            paramObject = paramObject.U(locald);
            if (paramObject == locala)
            {
              AppMethodBeat.o(277652);
              return locala;
            }
          }
          else
          {
            i = 0;
            continue;
            ResultKt.throwOnFailure(paramObject);
          }
          paramObject = (kotlin.g.a.a)new u(this.wcw) {};
          locald = (kotlin.d.d)this;
          this.label = 4;
          if (com.tencent.mm.plugin.car_license_plate.b.a.a(paramObject, locald) != locala) {
            break label324;
          }
          AppMethodBeat.o(277652);
          return locala;
          paramObject = CarLicensePlateEditUI.a(this.wcw);
          s.checkNotNull(paramObject);
          paramObject = new com.tencent.mm.plugin.car_license_plate.a.g(paramObject, paramView);
          locald = (kotlin.d.d)this;
          this.label = 2;
          paramObject = paramObject.U(locald);
          if (paramObject != locala) {
            continue;
          }
          AppMethodBeat.o(277652);
          return locala;
        }
        catch (com.tencent.mm.plugin.car_license_plate.a.d paramObject)
        {
          paramObject = (kotlin.g.a.a)new u(paramObject) {};
          kotlin.d.d locald = (kotlin.d.d)this;
          this.label = 3;
          if (com.tencent.mm.plugin.car_license_plate.b.a.a(paramObject, locald) != locala) {
            continue;
          }
          AppMethodBeat.o(277652);
          return locala;
          ResultKt.throwOnFailure(paramObject);
          paramObject = ah.aiuX;
          AppMethodBeat.o(277652);
          return paramObject;
        }
        ResultKt.throwOnFailure(paramObject);
        continue;
        ResultKt.throwOnFailure(paramObject);
        label324:
        paramObject = ah.aiuX;
        AppMethodBeat.o(277652);
        return paramObject;
        label335:
        int i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.car_license_plate.ui.CarLicensePlateEditUI
 * JD-Core Version:    0.7.0.1
 */
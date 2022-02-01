package com.tencent.mm.plugin.appbrand.widget.picker;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnLayoutChangeListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout.LayoutParams;
import androidx.core.content.a;
import com.tencent.luggage.b.a.a.a;
import com.tencent.luggage.b.a.a.b;
import com.tencent.luggage.b.a.a.c;
import com.tencent.luggage.b.a.a.d;
import com.tencent.luggage.b.a.a.e;
import com.tencent.luggage.b.a.a.f;
import com.tencent.luggage.b.a.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.aj;
import com.tencent.mm.plugin.appbrand.utils.b;
import com.tencent.mm.plugin.appbrand.utils.b.a;
import com.tencent.mm.plugin.appbrand.utils.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class c
  extends FrameLayout
{
  TextView sRO;
  private com.tencent.mm.plugin.appbrand.jsapi.v.c uND;
  private FrameLayout uNE;
  View uNF;
  View uNG;
  View uNH;
  private a uNI;
  private boolean uNJ;
  private View uNK;
  View uNL;
  private boolean uNM;
  private boolean uNN;
  private int uNO;
  private Runnable uNP;
  private b uNQ;
  private v uNR;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(138049);
    this.uNR = null;
    this.uNO = getResources().getConfiguration().uiMode;
    setClickable(true);
    setLongClickable(true);
    paramContext = new FrameLayout.LayoutParams(-1, -2);
    paramContext.gravity = 80;
    this.uNK = LayoutInflater.from(getContext()).inflate(a.f.app_brand_picker_container, this, false);
    this.uNE = ((FrameLayout)this.uNK.findViewById(a.e.app_brand_picker_panel_internal_picker));
    this.uNL = this.uNK.findViewById(a.e.app_brand_picker_no_title_place_holder);
    this.uNG = this.uNK.findViewById(a.e.picker_toolbar);
    this.uNH = this.uNG.findViewById(a.e.view);
    cSr();
    this.uNG.findViewById(a.e.bt_picker_confirm).setOnClickListener(new c.4(this));
    this.uNG.findViewById(a.e.bt_picker_cancel).setOnClickListener(new c.5(this));
    this.uNG.setOnClickListener(new c.6(this));
    View localView = this.uNK.findViewById(a.e.app_brand_picker_panel_internal_picker);
    localView.setOnClickListener(new c.7(this));
    localView.setBackgroundColor(a.w(localView.getContext(), a.b.BG_5));
    addView(this.uNK, paramContext);
    this.sRO = ((TextView)findViewById(a.e.app_brand_picker_header));
    this.sRO.setClickable(true);
    this.uNF = findViewById(a.e.app_brand_picker_divider);
    addOnLayoutChangeListener(new View.OnLayoutChangeListener()
    {
      public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        AppMethodBeat.i(138043);
        c.c(c.this);
        c.d(c.this);
        AppMethodBeat.o(138043);
      }
    });
    AppMethodBeat.o(138049);
  }
  
  private void cSo()
  {
    this.uNI = null;
    this.uNQ = null;
  }
  
  private void cSp()
  {
    AppMethodBeat.i(324662);
    setBackgroundResource(a.b.transparent);
    clearAnimation();
    super.setVisibility(8);
    requestLayout();
    this.uNN = false;
    AppMethodBeat.o(324662);
  }
  
  private void cSq()
  {
    AppMethodBeat.i(324663);
    if (isLandscape()) {}
    for (int i = 0;; i = getContext().getResources().getDimensionPixelSize(a.c.Edge_3A))
    {
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.uNL.getLayoutParams();
      localLayoutParams.height = i;
      this.uNL.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(324663);
      return;
    }
  }
  
  private void cSr()
  {
    AppMethodBeat.i(324664);
    int k;
    int j;
    if (isLandscape())
    {
      k = getContext().getResources().getDimensionPixelSize(a.c.Edge_2A);
      j = getContext().getResources().getDimensionPixelSize(a.c.Edge_2A);
    }
    for (int i = getContext().getResources().getDimensionPixelSize(a.c.picker_toolbar_height_land_space);; i = getContext().getResources().getDimensionPixelSize(a.c.picker_toolbar_height_portrait))
    {
      ConstraintLayout.LayoutParams localLayoutParams = (ConstraintLayout.LayoutParams)this.uNH.getLayoutParams();
      localLayoutParams.topMargin = k;
      localLayoutParams.bottomMargin = j;
      this.uNH.setLayoutParams(localLayoutParams);
      this.uNG.setLayoutParams(new LinearLayout.LayoutParams(-1, i));
      AppMethodBeat.o(324664);
      return;
      k = getContext().getResources().getDimensionPixelSize(a.c.Edge_5A);
      j = getContext().getResources().getDimensionPixelSize(a.c.Edge_4A);
    }
  }
  
  private v cSs()
  {
    AppMethodBeat.i(324666);
    if (this.uNR == null)
    {
      Log.w("MicroMsg.AppBrand.AppBrandPickerBottomPanelBase", "requireOrientationGetter, orientationGetter is null, use AndroidOrientationGetter as fallback");
      localObject = b.uql;
      this.uNR = b.a.b(null);
    }
    Object localObject = this.uNR;
    AppMethodBeat.o(324666);
    return localObject;
  }
  
  private void d(boolean paramBoolean, Object paramObject)
  {
    AppMethodBeat.i(138048);
    if ((!this.uNJ) && (this.uNI != null))
    {
      this.uNJ = true;
      this.uNI.c(paramBoolean, paramObject);
      this.uNJ = false;
    }
    AppMethodBeat.o(138048);
  }
  
  private void gc(boolean paramBoolean)
  {
    AppMethodBeat.i(324661);
    if (this.uNM)
    {
      clearAnimation();
      this.uNM = false;
    }
    if ((this.uNN) || (getVisibility() != 0))
    {
      AppMethodBeat.o(324661);
      return;
    }
    d(false, null);
    if (this.uND != null)
    {
      this.uND.onHide(this);
      if (!paramBoolean)
      {
        cSp();
        AppMethodBeat.o(324661);
        return;
      }
      this.uNN = true;
      Animation localAnimation = AnimationUtils.loadAnimation(getContext(), a.a.out_to_bottom);
      this.uNK.startAnimation(localAnimation);
      startAnimation(AnimationUtils.loadAnimation(getContext(), a.a.app_brand_faded_out));
      localAnimation.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(138042);
          c.b(c.this);
          AppMethodBeat.o(138042);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
    }
    AppMethodBeat.o(324661);
  }
  
  private boolean isLandscape()
  {
    AppMethodBeat.i(324665);
    if (aj.urz == cSs().cHR())
    {
      AppMethodBeat.o(324665);
      return true;
    }
    AppMethodBeat.o(324665);
    return false;
  }
  
  protected final void er(Object paramObject)
  {
    AppMethodBeat.i(138059);
    if (this.uNQ != null) {
      this.uNQ.ed(paramObject);
    }
    AppMethodBeat.o(138059);
  }
  
  public com.tencent.mm.plugin.appbrand.jsapi.v.c getPicker()
  {
    return this.uND;
  }
  
  protected final void gg(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(138054);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(138054);
  }
  
  public void hide()
  {
    AppMethodBeat.i(138052);
    gc(true);
    AppMethodBeat.o(138052);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(324701);
    super.onConfigurationChanged(paramConfiguration);
    if ((paramConfiguration.uiMode != this.uNO) && (this.uNP == null)) {
      this.uNP = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(324660);
          c.f(c.this).setBackground(a.m(c.this.getContext(), a.d.app_brand_picker_bg));
          c.this.sRO.setTextColor(a.w(c.this.getContext(), a.b.BW_0_Alpha_0_9));
          c.this.uNG.setBackgroundColor(a.w(c.this.getContext(), a.b.BG_5));
          ((Button)c.this.uNG.findViewById(a.e.bt_picker_confirm)).setTextColor(a.w(c.this.getContext(), a.b.color_btn_text_selector));
          ((Button)c.this.uNG.findViewById(a.e.bt_picker_confirm)).setBackground(a.m(c.this.getContext(), a.d.btn_solid_green));
          ((Button)c.this.uNG.findViewById(a.e.bt_picker_cancel)).setTextColor(a.w(c.this.getContext(), a.b.white_btn_text_selector));
          ((Button)c.this.uNG.findViewById(a.e.bt_picker_cancel)).setBackground(a.m(c.this.getContext(), a.d.btn_solid_white));
          AppMethodBeat.o(324660);
        }
      };
    }
    this.uNO = paramConfiguration.uiMode;
    AppMethodBeat.o(324701);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(138058);
    super.onDetachedFromWindow();
    cSo();
    removeAllViews();
    AppMethodBeat.o(138058);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(138055);
    if (!isShown()) {
      super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(0, -2147483648));
    }
    AppMethodBeat.o(138055);
  }
  
  public void setHeader(String paramString)
  {
    AppMethodBeat.i(138056);
    if (Util.isNullOrNil(paramString))
    {
      cSq();
      this.uNL.setVisibility(0);
      this.sRO.setText("");
      this.uNF.setVisibility(8);
      this.sRO.setVisibility(8);
      AppMethodBeat.o(138056);
      return;
    }
    String str;
    if ("设置时间".equals(paramString)) {
      str = getContext().getString(a.g.app_brand_pick_set_time);
    }
    for (;;)
    {
      this.uNL.setVisibility(8);
      this.uNF.setVisibility(0);
      this.sRO.setVisibility(0);
      this.sRO.setText(str);
      AppMethodBeat.o(138056);
      return;
      if ("设置地区".equals(paramString))
      {
        str = getContext().getString(a.g.app_brand_pick_set_local);
      }
      else if ("设置日期".equals(paramString))
      {
        str = getContext().getString(a.g.app_brand_pick_set_date);
      }
      else
      {
        str = paramString;
        if (paramString == null) {
          str = "";
        }
      }
    }
  }
  
  public void setOnResultListener(a parama)
  {
    this.uNI = parama;
  }
  
  public void setOnValueUpdateListener(b paramb)
  {
    this.uNQ = paramb;
  }
  
  public void setOrientationGetter(v paramv)
  {
    AppMethodBeat.i(324698);
    Log.d("MicroMsg.AppBrand.AppBrandPickerBottomPanelBase", "setOrientationGetter, orientationGetter is " + paramv.getName());
    this.uNR = paramv;
    AppMethodBeat.o(324698);
  }
  
  protected void setPickerImpl(com.tencent.mm.plugin.appbrand.jsapi.v.c paramc)
  {
    AppMethodBeat.i(138050);
    if (this.uND != null) {
      this.uND.onDetach(this);
    }
    this.uND = paramc;
    if (this.uND != null) {
      this.uND.onAttach(this);
    }
    if ((this.uNE == null) || (this.uND == null) || (this.uND.getView() == null))
    {
      AppMethodBeat.o(138050);
      return;
    }
    this.uNE.removeAllViews();
    cSo();
    paramc = new FrameLayout.LayoutParams(-1, -1);
    paramc.gravity = 17;
    this.uNE.addView(this.uND.getView(), paramc);
    AppMethodBeat.o(138050);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(138053);
    if (paramInt != 0)
    {
      gc(false);
      AppMethodBeat.o(138053);
      return;
    }
    super.setVisibility(paramInt);
    AppMethodBeat.o(138053);
  }
  
  public void show()
  {
    AppMethodBeat.i(138051);
    if (this.uNN)
    {
      clearAnimation();
      this.uNN = false;
    }
    if (this.uNM)
    {
      AppMethodBeat.o(138051);
      return;
    }
    if (this.uND == null)
    {
      setVisibility(8);
      AppMethodBeat.o(138051);
      return;
    }
    if (this.uNP != null)
    {
      this.uNP.run();
      this.uNP = null;
    }
    this.uND.onShow(this);
    clearAnimation();
    setVisibility(0);
    this.uNM = true;
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), a.a.app_brand_in_from_bottom);
    this.uNK.startAnimation(localAnimation);
    startAnimation(AnimationUtils.loadAnimation(getContext(), a.a.app_brand_faded_in));
    localAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(138041);
        c.this.setBackgroundResource(a.b.picker_half_alpha_bg);
        c.a(c.this);
        AppMethodBeat.o(138041);
      }
      
      public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
      
      public final void onAnimationStart(Animation paramAnonymousAnimation) {}
    });
    AppMethodBeat.o(138051);
  }
  
  public static abstract interface a<T>
  {
    public abstract void c(boolean paramBoolean, T paramT);
  }
  
  public static abstract interface b<T>
  {
    public abstract void ed(T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.c
 * JD-Core Version:    0.7.0.1
 */
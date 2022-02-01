package com.tencent.mm.plugin.appbrand.widget.picker;

import android.annotation.SuppressLint;
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
import com.tencent.mm.plugin.appbrand.utils.ae;
import com.tencent.mm.plugin.appbrand.utils.b;
import com.tencent.mm.plugin.appbrand.utils.b.a;
import com.tencent.mm.plugin.appbrand.utils.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class c
  extends FrameLayout
{
  private boolean isAnimating;
  TextView pMY;
  private s rCA;
  private com.tencent.mm.plugin.appbrand.jsapi.s.c rCo;
  private FrameLayout rCp;
  View rCq;
  View rCr;
  View rCs;
  private a rCt;
  private boolean rCu;
  private View rCv;
  View rCw;
  private int rCx;
  private Runnable rCy;
  private b rCz;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(138049);
    this.rCA = null;
    this.rCx = getResources().getConfiguration().uiMode;
    setClickable(true);
    setLongClickable(true);
    paramContext = new FrameLayout.LayoutParams(-1, -2);
    paramContext.gravity = 80;
    this.rCv = LayoutInflater.from(getContext()).inflate(a.f.app_brand_picker_container, this, false);
    this.rCp = ((FrameLayout)this.rCv.findViewById(a.e.app_brand_picker_panel_internal_picker));
    this.rCw = this.rCv.findViewById(a.e.app_brand_picker_no_title_place_holder);
    this.rCr = this.rCv.findViewById(a.e.picker_toolbar);
    this.rCs = this.rCr.findViewById(a.e.view);
    cpL();
    this.rCr.findViewById(a.e.bt_picker_confirm).setOnClickListener(new c.4(this));
    this.rCr.findViewById(a.e.bt_picker_cancel).setOnClickListener(new c.5(this));
    this.rCr.setOnClickListener(new c.6(this));
    View localView = this.rCv.findViewById(a.e.app_brand_picker_panel_internal_picker);
    localView.setOnClickListener(new c.7(this));
    localView.setBackgroundColor(a.w(localView.getContext(), a.b.BG_5));
    addView(this.rCv, paramContext);
    this.pMY = ((TextView)findViewById(a.e.app_brand_picker_header));
    this.pMY.setClickable(true);
    this.rCq = findViewById(a.e.app_brand_picker_divider);
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
  
  private void b(boolean paramBoolean, Object paramObject)
  {
    AppMethodBeat.i(138048);
    if ((!this.rCu) && (this.rCt != null))
    {
      this.rCu = true;
      this.rCt.a(paramBoolean, paramObject);
      this.rCu = false;
    }
    AppMethodBeat.o(138048);
  }
  
  private void cpJ()
  {
    this.rCt = null;
    this.rCz = null;
  }
  
  private void cpK()
  {
    AppMethodBeat.i(206939);
    if (isLandscape()) {}
    for (int i = 0;; i = getContext().getResources().getDimensionPixelSize(a.c.Edge_3A))
    {
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.rCw.getLayoutParams();
      localLayoutParams.height = i;
      this.rCw.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(206939);
      return;
    }
  }
  
  private void cpL()
  {
    AppMethodBeat.i(206941);
    int k;
    int j;
    if (isLandscape())
    {
      k = getContext().getResources().getDimensionPixelSize(a.c.Edge_2A);
      j = getContext().getResources().getDimensionPixelSize(a.c.Edge_2A);
    }
    for (int i = getContext().getResources().getDimensionPixelSize(a.c.picker_toolbar_height_land_space);; i = getContext().getResources().getDimensionPixelSize(a.c.picker_toolbar_height_portrait))
    {
      ConstraintLayout.LayoutParams localLayoutParams = (ConstraintLayout.LayoutParams)this.rCs.getLayoutParams();
      localLayoutParams.topMargin = k;
      localLayoutParams.bottomMargin = j;
      this.rCs.setLayoutParams(localLayoutParams);
      this.rCr.setLayoutParams(new LinearLayout.LayoutParams(-1, i));
      AppMethodBeat.o(206941);
      return;
      k = getContext().getResources().getDimensionPixelSize(a.c.Edge_5A);
      j = getContext().getResources().getDimensionPixelSize(a.c.Edge_4A);
    }
  }
  
  private s cpM()
  {
    AppMethodBeat.i(206948);
    if (this.rCA == null)
    {
      Log.w("MicroMsg.AppBrand.AppBrandPickerBottomPanelBase", "requireOrientationGetter, orientationGetter is null, use AndroidOrientationGetter as fallback");
      localObject = b.rip;
      this.rCA = b.a.b(null);
    }
    Object localObject = this.rCA;
    AppMethodBeat.o(206948);
    return localObject;
  }
  
  private boolean isLandscape()
  {
    AppMethodBeat.i(206943);
    if (ae.rjk == cpM().cgT())
    {
      AppMethodBeat.o(206943);
      return true;
    }
    AppMethodBeat.o(206943);
    return false;
  }
  
  protected final void cV(Object paramObject)
  {
    AppMethodBeat.i(138059);
    if (this.rCz != null) {
      this.rCz.cI(paramObject);
    }
    AppMethodBeat.o(138059);
  }
  
  @SuppressLint({"WrongCall"})
  protected final void fn(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(138054);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(138054);
  }
  
  public com.tencent.mm.plugin.appbrand.jsapi.s.c getPicker()
  {
    return this.rCo;
  }
  
  public void hide()
  {
    AppMethodBeat.i(138052);
    if (this.isAnimating)
    {
      AppMethodBeat.o(138052);
      return;
    }
    b(false, null);
    if (this.rCo != null)
    {
      this.rCo.onHide(this);
      this.isAnimating = true;
      Animation localAnimation = AnimationUtils.loadAnimation(getContext(), a.a.out_to_bottom);
      this.rCv.startAnimation(localAnimation);
      startAnimation(AnimationUtils.loadAnimation(getContext(), a.a.app_brand_faded_out));
      localAnimation.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(138042);
          c.this.setBackgroundResource(a.b.transparent);
          c.this.clearAnimation();
          c.b(c.this);
          c.this.requestLayout();
          c.a(c.this);
          AppMethodBeat.o(138042);
        }
        
        public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
        
        public final void onAnimationStart(Animation paramAnonymousAnimation) {}
      });
    }
    AppMethodBeat.o(138052);
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(206949);
    super.onConfigurationChanged(paramConfiguration);
    if ((paramConfiguration.uiMode != this.rCx) && (this.rCy == null)) {
      this.rCy = new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(206584);
          c.f(c.this).setBackground(a.m(c.this.getContext(), a.d.app_brand_picker_bg));
          c.this.pMY.setTextColor(a.w(c.this.getContext(), a.b.BW_0_Alpha_0_9));
          c.this.rCr.setBackgroundColor(a.w(c.this.getContext(), a.b.BG_5));
          ((Button)c.this.rCr.findViewById(a.e.bt_picker_confirm)).setTextColor(a.w(c.this.getContext(), a.b.color_btn_text_selector));
          ((Button)c.this.rCr.findViewById(a.e.bt_picker_confirm)).setBackground(a.m(c.this.getContext(), a.d.btn_solid_green));
          ((Button)c.this.rCr.findViewById(a.e.bt_picker_cancel)).setTextColor(a.w(c.this.getContext(), a.b.white_btn_text_selector));
          ((Button)c.this.rCr.findViewById(a.e.bt_picker_cancel)).setBackground(a.m(c.this.getContext(), a.d.btn_solid_white));
          AppMethodBeat.o(206584);
        }
      };
    }
    this.rCx = paramConfiguration.uiMode;
    AppMethodBeat.o(206949);
  }
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(138058);
    super.onDetachedFromWindow();
    cpJ();
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
      cpK();
      this.rCw.setVisibility(0);
      this.pMY.setText("");
      this.rCq.setVisibility(8);
      this.pMY.setVisibility(8);
      AppMethodBeat.o(138056);
      return;
    }
    String str;
    if ("设置时间".equals(paramString)) {
      str = getContext().getString(a.g.app_brand_pick_set_time);
    }
    for (;;)
    {
      this.rCw.setVisibility(8);
      this.rCq.setVisibility(0);
      this.pMY.setVisibility(0);
      this.pMY.setText(str);
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
    this.rCt = parama;
  }
  
  public void setOnValueUpdateListener(b paramb)
  {
    this.rCz = paramb;
  }
  
  public void setOrientationGetter(s params)
  {
    AppMethodBeat.i(206946);
    Log.d("MicroMsg.AppBrand.AppBrandPickerBottomPanelBase", "setOrientationGetter, orientationGetter is " + params.getName());
    this.rCA = params;
    AppMethodBeat.o(206946);
  }
  
  protected void setPickerImpl(com.tencent.mm.plugin.appbrand.jsapi.s.c paramc)
  {
    AppMethodBeat.i(138050);
    if (this.rCo != null) {
      this.rCo.onDetach(this);
    }
    this.rCo = paramc;
    if (this.rCo != null) {
      this.rCo.onAttach(this);
    }
    if ((this.rCp == null) || (this.rCo == null) || (this.rCo.getView() == null))
    {
      AppMethodBeat.o(138050);
      return;
    }
    this.rCp.removeAllViews();
    cpJ();
    paramc = new FrameLayout.LayoutParams(-1, -1);
    paramc.gravity = 17;
    this.rCp.addView(this.rCo.getView(), paramc);
    AppMethodBeat.o(138050);
  }
  
  public void setVisibility(int paramInt)
  {
    AppMethodBeat.i(138053);
    if (paramInt != 0)
    {
      hide();
      AppMethodBeat.o(138053);
      return;
    }
    super.setVisibility(paramInt);
    AppMethodBeat.o(138053);
  }
  
  public void show()
  {
    AppMethodBeat.i(138051);
    if (this.isAnimating)
    {
      AppMethodBeat.o(138051);
      return;
    }
    if (this.rCo == null)
    {
      setVisibility(8);
      AppMethodBeat.o(138051);
      return;
    }
    if (this.rCy != null)
    {
      this.rCy.run();
      this.rCy = null;
    }
    this.rCo.onShow(this);
    clearAnimation();
    setVisibility(0);
    this.isAnimating = true;
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), a.a.app_brand_in_from_bottom);
    this.rCv.startAnimation(localAnimation);
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
    public abstract void a(boolean paramBoolean, T paramT);
  }
  
  public static abstract interface b<T>
  {
    public abstract void cI(T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.c
 * JD-Core Version:    0.7.0.1
 */
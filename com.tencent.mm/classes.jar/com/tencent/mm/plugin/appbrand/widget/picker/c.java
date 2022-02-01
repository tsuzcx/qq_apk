package com.tencent.mm.plugin.appbrand.widget.picker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.support.constraint.ConstraintLayout.LayoutParams;
import android.support.v4.content.b;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnLayoutChangeListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.a;
import com.tencent.mm.plugin.appbrand.utils.a.a;
import com.tencent.mm.plugin.appbrand.utils.ac;
import com.tencent.mm.plugin.appbrand.utils.q;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

public class c
  extends FrameLayout
{
  private boolean isAnimating;
  TextView lEx;
  private com.tencent.mm.plugin.appbrand.jsapi.p.c nqa;
  private FrameLayout nqb;
  View nqc;
  View nqd;
  View nqe;
  private a nqf;
  private boolean nqg;
  private View nqh;
  View nqi;
  private b nqj;
  private q nqk;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(138049);
    this.nqk = null;
    setClickable(true);
    setLongClickable(true);
    paramContext = new FrameLayout.LayoutParams(-1, -2);
    paramContext.gravity = 80;
    this.nqh = LayoutInflater.from(getContext()).inflate(2131493021, this, false);
    this.nqb = ((FrameLayout)this.nqh.findViewById(2131296792));
    this.nqi = this.nqh.findViewById(2131296790);
    this.nqd = this.nqh.findViewById(2131303266);
    this.nqe = this.nqd.findViewById(2131306423);
    bGe();
    this.nqd.findViewById(2131297573).setOnClickListener(new c.4(this));
    this.nqd.findViewById(2131297572).setOnClickListener(new c.5(this));
    this.nqd.setOnClickListener(new c.6(this));
    View localView = this.nqh.findViewById(2131296792);
    localView.setOnClickListener(new c.7(this));
    localView.setBackgroundColor(b.n(localView.getContext(), 2131099653));
    addView(this.nqh, paramContext);
    this.lEx = ((TextView)findViewById(2131296789));
    this.lEx.setClickable(true);
    this.nqc = findViewById(2131296788);
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
  
  private boolean aoA()
  {
    AppMethodBeat.i(197285);
    if (ac.mUv == bGf().bxC())
    {
      AppMethodBeat.o(197285);
      return true;
    }
    AppMethodBeat.o(197285);
    return false;
  }
  
  private void b(boolean paramBoolean, Object paramObject)
  {
    AppMethodBeat.i(138048);
    if ((!this.nqg) && (this.nqf != null))
    {
      this.nqg = true;
      this.nqf.a(paramBoolean, paramObject);
      this.nqg = false;
    }
    AppMethodBeat.o(138048);
  }
  
  private void bGc()
  {
    this.nqf = null;
    this.nqj = null;
  }
  
  private void bGd()
  {
    AppMethodBeat.i(197283);
    if (aoA()) {}
    for (int i = 0;; i = getContext().getResources().getDimensionPixelSize(2131165292))
    {
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.nqi.getLayoutParams();
      localLayoutParams.height = i;
      this.nqi.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(197283);
      return;
    }
  }
  
  private void bGe()
  {
    AppMethodBeat.i(197284);
    int k;
    int j;
    if (aoA())
    {
      k = getContext().getResources().getDimensionPixelSize(2131165289);
      j = getContext().getResources().getDimensionPixelSize(2131165289);
    }
    for (int i = getContext().getResources().getDimensionPixelSize(2131166683);; i = getContext().getResources().getDimensionPixelSize(2131166684))
    {
      ConstraintLayout.LayoutParams localLayoutParams = (ConstraintLayout.LayoutParams)this.nqe.getLayoutParams();
      localLayoutParams.topMargin = k;
      localLayoutParams.bottomMargin = j;
      this.nqe.setLayoutParams(localLayoutParams);
      this.nqd.setLayoutParams(new LinearLayout.LayoutParams(-1, i));
      AppMethodBeat.o(197284);
      return;
      k = getContext().getResources().getDimensionPixelSize(2131165296);
      j = getContext().getResources().getDimensionPixelSize(2131165294);
    }
  }
  
  private q bGf()
  {
    AppMethodBeat.i(197287);
    if (this.nqk == null)
    {
      ae.w("MicroMsg.AppBrand.AppBrandPickerBottomPanelBase", "requireOrientationGetter, orientationGetter is null, use AndroidOrientationGetter as fallback");
      localObject = a.mTz;
      this.nqk = a.a.b(null);
    }
    Object localObject = this.nqk;
    AppMethodBeat.o(197287);
    return localObject;
  }
  
  protected final void cP(Object paramObject)
  {
    AppMethodBeat.i(138059);
    if (this.nqj != null) {
      this.nqj.cy(paramObject);
    }
    AppMethodBeat.o(138059);
  }
  
  @SuppressLint({"WrongCall"})
  protected final void ez(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(138054);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(138054);
  }
  
  public com.tencent.mm.plugin.appbrand.jsapi.p.c getPicker()
  {
    return this.nqa;
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
    if (this.nqa != null)
    {
      this.nqa.onHide(this);
      this.isAnimating = true;
      Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772084);
      this.nqh.startAnimation(localAnimation);
      startAnimation(AnimationUtils.loadAnimation(getContext(), 2130771993));
      localAnimation.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(138042);
          c.this.setBackgroundResource(2131101053);
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
  
  protected void onDetachedFromWindow()
  {
    AppMethodBeat.i(138058);
    super.onDetachedFromWindow();
    bGc();
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
    if (bu.isNullOrNil(paramString))
    {
      bGd();
      this.nqi.setVisibility(0);
      this.lEx.setText("");
      this.nqc.setVisibility(8);
      this.lEx.setVisibility(8);
      AppMethodBeat.o(138056);
      return;
    }
    String str;
    if ("设置时间".equals(paramString)) {
      str = getContext().getString(2131755574);
    }
    for (;;)
    {
      this.nqi.setVisibility(8);
      this.nqc.setVisibility(0);
      this.lEx.setVisibility(0);
      this.lEx.setText(str);
      AppMethodBeat.o(138056);
      return;
      if ("设置地区".equals(paramString))
      {
        str = getContext().getString(2131755573);
      }
      else if ("设置日期".equals(paramString))
      {
        str = getContext().getString(2131755572);
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
    this.nqf = parama;
  }
  
  public void setOnValueUpdateListener(b paramb)
  {
    this.nqj = paramb;
  }
  
  public void setOrientationGetter(q paramq)
  {
    AppMethodBeat.i(197286);
    ae.d("MicroMsg.AppBrand.AppBrandPickerBottomPanelBase", "setOrientationGetter, orientationGetter is " + paramq.getName());
    this.nqk = paramq;
    AppMethodBeat.o(197286);
  }
  
  protected void setPickerImpl(com.tencent.mm.plugin.appbrand.jsapi.p.c paramc)
  {
    AppMethodBeat.i(138050);
    if (this.nqa != null) {
      this.nqa.onDetach(this);
    }
    this.nqa = paramc;
    if (this.nqa != null) {
      this.nqa.onAttach(this);
    }
    if ((this.nqb == null) || (this.nqa == null) || (this.nqa.getView() == null))
    {
      AppMethodBeat.o(138050);
      return;
    }
    this.nqb.removeAllViews();
    bGc();
    paramc = new FrameLayout.LayoutParams(-1, -1);
    paramc.gravity = 17;
    this.nqb.addView(this.nqa.getView(), paramc);
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
    if (this.nqa == null)
    {
      setVisibility(8);
      AppMethodBeat.o(138051);
      return;
    }
    this.nqa.onShow(this);
    clearAnimation();
    setVisibility(0);
    this.isAnimating = true;
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130771994);
    this.nqh.startAnimation(localAnimation);
    startAnimation(AnimationUtils.loadAnimation(getContext(), 2130771992));
    localAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(138041);
        c.this.setBackgroundResource(2131100736);
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
    public abstract void cy(T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.c
 * JD-Core Version:    0.7.0.1
 */
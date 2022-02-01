package com.tencent.mm.plugin.appbrand.widget.picker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v4.content.b;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;

public class c
  extends FrameLayout
{
  private boolean isAnimating;
  TextView lcZ;
  private a mKA;
  private boolean mKB;
  private View mKC;
  View mKD;
  private c.b mKE;
  private com.tencent.mm.plugin.appbrand.jsapi.m.c mKw;
  private FrameLayout mKx;
  View mKy;
  View mKz;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(138049);
    setClickable(true);
    setLongClickable(true);
    paramContext = new FrameLayout.LayoutParams(-1, -2);
    paramContext.gravity = 80;
    this.mKC = LayoutInflater.from(getContext()).inflate(2131493021, this, false);
    this.mKx = ((FrameLayout)this.mKC.findViewById(2131296792));
    this.mKD = this.mKC.findViewById(2131296790);
    this.mKz = this.mKC.findViewById(2131303266);
    q(this.mKz, getContext().getResources().getDimensionPixelSize(2131166684), getContext().getResources().getDimensionPixelSize(2131166683));
    this.mKz.findViewById(2131297573).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(138044);
        c localc = c.this;
        if (c.c(c.this) == null) {}
        for (paramAnonymousView = null;; paramAnonymousView = c.c(c.this).currentValue())
        {
          c.a(localc, true, paramAnonymousView);
          AppMethodBeat.o(138044);
          return;
        }
      }
    });
    this.mKz.findViewById(2131297572).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(138045);
        c.a(c.this, false, null);
        AppMethodBeat.o(138045);
      }
    });
    this.mKz.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(138046);
        AppMethodBeat.o(138046);
      }
    });
    View localView = this.mKC.findViewById(2131296792);
    localView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(138047);
        AppMethodBeat.o(138047);
      }
    });
    localView.setBackgroundColor(b.n(localView.getContext(), 2131099653));
    addView(this.mKC, paramContext);
    this.lcZ = ((TextView)findViewById(2131296789));
    this.lcZ.setClickable(true);
    this.mKy = findViewById(2131296788);
    addOnLayoutChangeListener(new View.OnLayoutChangeListener()
    {
      public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        AppMethodBeat.i(138043);
        c.a(c.this, c.this.mKz, c.this.getContext().getResources().getDimensionPixelSize(2131166684), c.this.getContext().getResources().getDimensionPixelSize(2131166683));
        c.a(c.this, c.this.mKD, c.this.getContext().getResources().getDimensionPixelSize(2131165292), c.this.getContext().getResources().getDimensionPixelSize(2131165303));
        AppMethodBeat.o(138043);
      }
    });
    AppMethodBeat.o(138049);
  }
  
  private void b(boolean paramBoolean, Object paramObject)
  {
    AppMethodBeat.i(138048);
    if ((!this.mKB) && (this.mKA != null))
    {
      this.mKB = true;
      this.mKA.a(paramBoolean, paramObject);
      this.mKB = false;
    }
    AppMethodBeat.o(138048);
  }
  
  private void bBi()
  {
    this.mKA = null;
    this.mKE = null;
  }
  
  private void q(View paramView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(138057);
    if (getContext().getResources().getConfiguration().orientation == 2)
    {
      paramView.setLayoutParams(new LinearLayout.LayoutParams(-1, paramInt2));
      AppMethodBeat.o(138057);
      return;
    }
    if (getContext().getResources().getConfiguration().orientation == 1) {
      paramView.setLayoutParams(new LinearLayout.LayoutParams(-1, paramInt1));
    }
    AppMethodBeat.o(138057);
  }
  
  protected final void cM(Object paramObject)
  {
    AppMethodBeat.i(138059);
    if (this.mKE != null) {
      this.mKE.cv(paramObject);
    }
    AppMethodBeat.o(138059);
  }
  
  @SuppressLint({"WrongCall"})
  protected final void ex(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(138054);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(138054);
  }
  
  public com.tencent.mm.plugin.appbrand.jsapi.m.c getPicker()
  {
    return this.mKw;
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
    if (this.mKw != null)
    {
      this.mKw.onHide(this);
      this.isAnimating = true;
      Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772084);
      this.mKC.startAnimation(localAnimation);
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
    bBi();
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
    if (bs.isNullOrNil(paramString))
    {
      q(this.mKD, getContext().getResources().getDimensionPixelSize(2131165292), getContext().getResources().getDimensionPixelSize(2131165303));
      this.mKD.setVisibility(0);
      this.lcZ.setText("");
      this.mKy.setVisibility(8);
      this.lcZ.setVisibility(8);
      AppMethodBeat.o(138056);
      return;
    }
    String str;
    if ("设置时间".equals(paramString)) {
      str = getContext().getString(2131755574);
    }
    for (;;)
    {
      this.mKD.setVisibility(8);
      this.mKy.setVisibility(0);
      this.lcZ.setVisibility(0);
      this.lcZ.setText(str);
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
    this.mKA = parama;
  }
  
  public void setOnValueUpdateListener(c.b paramb)
  {
    this.mKE = paramb;
  }
  
  protected void setPickerImpl(com.tencent.mm.plugin.appbrand.jsapi.m.c paramc)
  {
    AppMethodBeat.i(138050);
    if (this.mKw != null) {
      this.mKw.onDetach(this);
    }
    this.mKw = paramc;
    if (this.mKw != null) {
      this.mKw.onAttach(this);
    }
    if ((this.mKx == null) || (this.mKw == null) || (this.mKw.getView() == null))
    {
      AppMethodBeat.o(138050);
      return;
    }
    this.mKx.removeAllViews();
    bBi();
    paramc = new FrameLayout.LayoutParams(-1, -1);
    paramc.gravity = 17;
    this.mKx.addView(this.mKw.getView(), paramc);
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
    if (this.mKw == null)
    {
      setVisibility(8);
      AppMethodBeat.o(138051);
      return;
    }
    this.mKw.onShow(this);
    clearAnimation();
    setVisibility(0);
    this.isAnimating = true;
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130771994);
    this.mKC.startAnimation(localAnimation);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.c
 * JD-Core Version:    0.7.0.1
 */
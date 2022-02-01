package com.tencent.mm.plugin.appbrand.widget.picker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
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
import com.tencent.mm.sdk.platformtools.bt;

public class c
  extends FrameLayout
{
  private boolean isAnimating;
  TextView kBH;
  private a miA;
  private boolean miB;
  private View miC;
  View miD;
  private b miE;
  private com.tencent.mm.plugin.appbrand.jsapi.n.c miw;
  private FrameLayout mix;
  View miy;
  View miz;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(138049);
    setClickable(true);
    setLongClickable(true);
    paramContext = new FrameLayout.LayoutParams(-1, -2);
    paramContext.gravity = 80;
    this.miC = LayoutInflater.from(getContext()).inflate(2131493021, this, false);
    this.mix = ((FrameLayout)this.miC.findViewById(2131296792));
    this.miD = this.miC.findViewById(2131296790);
    this.miz = this.miC.findViewById(2131303266);
    q(this.miz, getContext().getResources().getDimensionPixelSize(2131166684), getContext().getResources().getDimensionPixelSize(2131166683));
    this.miz.findViewById(2131297573).setOnClickListener(new c.4(this));
    this.miz.findViewById(2131297572).setOnClickListener(new c.5(this));
    this.miz.setOnClickListener(new c.6(this));
    View localView = this.miC.findViewById(2131296792);
    localView.setOnClickListener(new c.7(this));
    localView.setBackgroundColor(b.n(localView.getContext(), 2131099653));
    addView(this.miC, paramContext);
    this.kBH = ((TextView)findViewById(2131296789));
    this.kBH.setClickable(true);
    this.miy = findViewById(2131296788);
    addOnLayoutChangeListener(new View.OnLayoutChangeListener()
    {
      public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        AppMethodBeat.i(138043);
        c.a(c.this, c.this.miz, c.this.getContext().getResources().getDimensionPixelSize(2131166684), c.this.getContext().getResources().getDimensionPixelSize(2131166683));
        c.a(c.this, c.this.miD, c.this.getContext().getResources().getDimensionPixelSize(2131165292), c.this.getContext().getResources().getDimensionPixelSize(2131165303));
        AppMethodBeat.o(138043);
      }
    });
    AppMethodBeat.o(138049);
  }
  
  private void b(boolean paramBoolean, Object paramObject)
  {
    AppMethodBeat.i(138048);
    if ((!this.miB) && (this.miA != null))
    {
      this.miB = true;
      this.miA.a(paramBoolean, paramObject);
      this.miB = false;
    }
    AppMethodBeat.o(138048);
  }
  
  private void buk()
  {
    this.miA = null;
    this.miE = null;
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
  
  protected final void cN(Object paramObject)
  {
    AppMethodBeat.i(138059);
    if (this.miE != null) {
      this.miE.cx(paramObject);
    }
    AppMethodBeat.o(138059);
  }
  
  @SuppressLint({"WrongCall"})
  protected final void eu(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(138054);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(138054);
  }
  
  public com.tencent.mm.plugin.appbrand.jsapi.n.c getPicker()
  {
    return this.miw;
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
    if (this.miw != null)
    {
      this.miw.onHide(this);
      this.isAnimating = true;
      Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772084);
      this.miC.startAnimation(localAnimation);
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
    buk();
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
    if (bt.isNullOrNil(paramString))
    {
      q(this.miD, getContext().getResources().getDimensionPixelSize(2131165292), getContext().getResources().getDimensionPixelSize(2131165303));
      this.miD.setVisibility(0);
      this.kBH.setText("");
      this.miy.setVisibility(8);
      this.kBH.setVisibility(8);
      AppMethodBeat.o(138056);
      return;
    }
    String str;
    if ("设置时间".equals(paramString)) {
      str = getContext().getString(2131755574);
    }
    for (;;)
    {
      this.miD.setVisibility(8);
      this.miy.setVisibility(0);
      this.kBH.setVisibility(0);
      this.kBH.setText(str);
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
    this.miA = parama;
  }
  
  public void setOnValueUpdateListener(b paramb)
  {
    this.miE = paramb;
  }
  
  protected void setPickerImpl(com.tencent.mm.plugin.appbrand.jsapi.n.c paramc)
  {
    AppMethodBeat.i(138050);
    if (this.miw != null) {
      this.miw.onDetach(this);
    }
    this.miw = paramc;
    if (this.miw != null) {
      this.miw.onAttach(this);
    }
    if ((this.mix == null) || (this.miw == null) || (this.miw.getView() == null))
    {
      AppMethodBeat.o(138050);
      return;
    }
    this.mix.removeAllViews();
    buk();
    paramc = new FrameLayout.LayoutParams(-1, -1);
    paramc.gravity = 17;
    this.mix.addView(this.miw.getView(), paramc);
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
    if (this.miw == null)
    {
      setVisibility(8);
      AppMethodBeat.o(138051);
      return;
    }
    this.miw.onShow(this);
    clearAnimation();
    setVisibility(0);
    this.isAnimating = true;
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130771994);
    this.miC.startAnimation(localAnimation);
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
    public abstract void cx(T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.c
 * JD-Core Version:    0.7.0.1
 */
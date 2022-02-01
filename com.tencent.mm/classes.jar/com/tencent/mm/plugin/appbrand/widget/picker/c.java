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
  TextView lzZ;
  private com.tencent.mm.plugin.appbrand.jsapi.p.c nkS;
  private FrameLayout nkT;
  View nkU;
  View nkV;
  private a nkW;
  private boolean nkX;
  private View nkY;
  View nkZ;
  private b nla;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(138049);
    setClickable(true);
    setLongClickable(true);
    paramContext = new FrameLayout.LayoutParams(-1, -2);
    paramContext.gravity = 80;
    this.nkY = LayoutInflater.from(getContext()).inflate(2131493021, this, false);
    this.nkT = ((FrameLayout)this.nkY.findViewById(2131296792));
    this.nkZ = this.nkY.findViewById(2131296790);
    this.nkV = this.nkY.findViewById(2131303266);
    q(this.nkV, getContext().getResources().getDimensionPixelSize(2131166684), getContext().getResources().getDimensionPixelSize(2131166683));
    this.nkV.findViewById(2131297573).setOnClickListener(new c.4(this));
    this.nkV.findViewById(2131297572).setOnClickListener(new c.5(this));
    this.nkV.setOnClickListener(new c.6(this));
    View localView = this.nkY.findViewById(2131296792);
    localView.setOnClickListener(new c.7(this));
    localView.setBackgroundColor(b.n(localView.getContext(), 2131099653));
    addView(this.nkY, paramContext);
    this.lzZ = ((TextView)findViewById(2131296789));
    this.lzZ.setClickable(true);
    this.nkU = findViewById(2131296788);
    addOnLayoutChangeListener(new View.OnLayoutChangeListener()
    {
      public final void onLayoutChange(View paramAnonymousView, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4, int paramAnonymousInt5, int paramAnonymousInt6, int paramAnonymousInt7, int paramAnonymousInt8)
      {
        AppMethodBeat.i(138043);
        c.a(c.this, c.this.nkV, c.this.getContext().getResources().getDimensionPixelSize(2131166684), c.this.getContext().getResources().getDimensionPixelSize(2131166683));
        c.a(c.this, c.this.nkZ, c.this.getContext().getResources().getDimensionPixelSize(2131165292), c.this.getContext().getResources().getDimensionPixelSize(2131165303));
        AppMethodBeat.o(138043);
      }
    });
    AppMethodBeat.o(138049);
  }
  
  private void b(boolean paramBoolean, Object paramObject)
  {
    AppMethodBeat.i(138048);
    if ((!this.nkX) && (this.nkW != null))
    {
      this.nkX = true;
      this.nkW.a(paramBoolean, paramObject);
      this.nkX = false;
    }
    AppMethodBeat.o(138048);
  }
  
  private void bFk()
  {
    this.nkW = null;
    this.nla = null;
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
  
  protected final void cO(Object paramObject)
  {
    AppMethodBeat.i(138059);
    if (this.nla != null) {
      this.nla.cx(paramObject);
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
    return this.nkS;
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
    if (this.nkS != null)
    {
      this.nkS.onHide(this);
      this.isAnimating = true;
      Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772084);
      this.nkY.startAnimation(localAnimation);
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
    bFk();
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
      q(this.nkZ, getContext().getResources().getDimensionPixelSize(2131165292), getContext().getResources().getDimensionPixelSize(2131165303));
      this.nkZ.setVisibility(0);
      this.lzZ.setText("");
      this.nkU.setVisibility(8);
      this.lzZ.setVisibility(8);
      AppMethodBeat.o(138056);
      return;
    }
    String str;
    if ("设置时间".equals(paramString)) {
      str = getContext().getString(2131755574);
    }
    for (;;)
    {
      this.nkZ.setVisibility(8);
      this.nkU.setVisibility(0);
      this.lzZ.setVisibility(0);
      this.lzZ.setText(str);
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
    this.nkW = parama;
  }
  
  public void setOnValueUpdateListener(b paramb)
  {
    this.nla = paramb;
  }
  
  protected void setPickerImpl(com.tencent.mm.plugin.appbrand.jsapi.p.c paramc)
  {
    AppMethodBeat.i(138050);
    if (this.nkS != null) {
      this.nkS.onDetach(this);
    }
    this.nkS = paramc;
    if (this.nkS != null) {
      this.nkS.onAttach(this);
    }
    if ((this.nkT == null) || (this.nkS == null) || (this.nkS.getView() == null))
    {
      AppMethodBeat.o(138050);
      return;
    }
    this.nkT.removeAllViews();
    bFk();
    paramc = new FrameLayout.LayoutParams(-1, -1);
    paramc.gravity = 17;
    this.nkT.addView(this.nkS.getView(), paramc);
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
    if (this.nkS == null)
    {
      setVisibility(8);
      AppMethodBeat.o(138051);
      return;
    }
    this.nkS.onShow(this);
    clearAnimation();
    setVisibility(0);
    this.isAnimating = true;
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130771994);
    this.nkY.startAnimation(localAnimation);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.c
 * JD-Core Version:    0.7.0.1
 */
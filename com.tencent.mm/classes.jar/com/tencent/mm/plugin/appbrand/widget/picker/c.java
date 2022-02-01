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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class c
  extends FrameLayout
{
  private boolean isAnimating;
  TextView mMg;
  private com.tencent.mm.plugin.appbrand.jsapi.r.c ozH;
  private FrameLayout ozI;
  View ozJ;
  View ozK;
  View ozL;
  private a ozM;
  private boolean ozN;
  private View ozO;
  View ozP;
  private b ozQ;
  private q ozR;
  
  public c(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(138049);
    this.ozR = null;
    setClickable(true);
    setLongClickable(true);
    paramContext = new FrameLayout.LayoutParams(-1, -2);
    paramContext.gravity = 80;
    this.ozO = LayoutInflater.from(getContext()).inflate(2131493060, this, false);
    this.ozI = ((FrameLayout)this.ozO.findViewById(2131296874));
    this.ozP = this.ozO.findViewById(2131296872);
    this.ozK = this.ozO.findViewById(2131305938);
    this.ozL = this.ozK.findViewById(2131309854);
    ccu();
    this.ozK.findViewById(2131297812).setOnClickListener(new c.4(this));
    this.ozK.findViewById(2131297811).setOnClickListener(new c.5(this));
    this.ozK.setOnClickListener(new c.6(this));
    View localView = this.ozO.findViewById(2131296874);
    localView.setOnClickListener(new c.7(this));
    localView.setBackgroundColor(b.n(localView.getContext(), 2131099653));
    addView(this.ozO, paramContext);
    this.mMg = ((TextView)findViewById(2131296871));
    this.mMg.setClickable(true);
    this.ozJ = findViewById(2131296870);
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
    if ((!this.ozN) && (this.ozM != null))
    {
      this.ozN = true;
      this.ozM.a(paramBoolean, paramObject);
      this.ozN = false;
    }
    AppMethodBeat.o(138048);
  }
  
  private void ccs()
  {
    this.ozM = null;
    this.ozQ = null;
  }
  
  private void cct()
  {
    AppMethodBeat.i(193735);
    if (isLandscape()) {}
    for (int i = 0;; i = getContext().getResources().getDimensionPixelSize(2131165299))
    {
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)this.ozP.getLayoutParams();
      localLayoutParams.height = i;
      this.ozP.setLayoutParams(localLayoutParams);
      AppMethodBeat.o(193735);
      return;
    }
  }
  
  private void ccu()
  {
    AppMethodBeat.i(193736);
    int k;
    int j;
    if (isLandscape())
    {
      k = getContext().getResources().getDimensionPixelSize(2131165296);
      j = getContext().getResources().getDimensionPixelSize(2131165296);
    }
    for (int i = getContext().getResources().getDimensionPixelSize(2131166803);; i = getContext().getResources().getDimensionPixelSize(2131166804))
    {
      ConstraintLayout.LayoutParams localLayoutParams = (ConstraintLayout.LayoutParams)this.ozL.getLayoutParams();
      localLayoutParams.topMargin = k;
      localLayoutParams.bottomMargin = j;
      this.ozL.setLayoutParams(localLayoutParams);
      this.ozK.setLayoutParams(new LinearLayout.LayoutParams(-1, i));
      AppMethodBeat.o(193736);
      return;
      k = getContext().getResources().getDimensionPixelSize(2131165306);
      j = getContext().getResources().getDimensionPixelSize(2131165303);
    }
  }
  
  private q ccv()
  {
    AppMethodBeat.i(193739);
    if (this.ozR == null)
    {
      Log.w("MicroMsg.AppBrand.AppBrandPickerBottomPanelBase", "requireOrientationGetter, orientationGetter is null, use AndroidOrientationGetter as fallback");
      localObject = a.ogC;
      this.ozR = a.a.b(null);
    }
    Object localObject = this.ozR;
    AppMethodBeat.o(193739);
    return localObject;
  }
  
  private boolean isLandscape()
  {
    AppMethodBeat.i(193737);
    if (ac.ohw == ccv().bTN())
    {
      AppMethodBeat.o(193737);
      return true;
    }
    AppMethodBeat.o(193737);
    return false;
  }
  
  protected final void cY(Object paramObject)
  {
    AppMethodBeat.i(138059);
    if (this.ozQ != null) {
      this.ozQ.cH(paramObject);
    }
    AppMethodBeat.o(138059);
  }
  
  @SuppressLint({"WrongCall"})
  protected final void eM(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(138054);
    super.onMeasure(paramInt1, paramInt2);
    AppMethodBeat.o(138054);
  }
  
  public com.tencent.mm.plugin.appbrand.jsapi.r.c getPicker()
  {
    return this.ozH;
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
    if (this.ozH != null)
    {
      this.ozH.onHide(this);
      this.isAnimating = true;
      Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130772105);
      this.ozO.startAnimation(localAnimation);
      startAnimation(AnimationUtils.loadAnimation(getContext(), 2130771998));
      localAnimation.setAnimationListener(new Animation.AnimationListener()
      {
        public final void onAnimationEnd(Animation paramAnonymousAnimation)
        {
          AppMethodBeat.i(138042);
          c.this.setBackgroundResource(2131101287);
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
    ccs();
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
      cct();
      this.ozP.setVisibility(0);
      this.mMg.setText("");
      this.ozJ.setVisibility(8);
      this.mMg.setVisibility(8);
      AppMethodBeat.o(138056);
      return;
    }
    String str;
    if ("设置时间".equals(paramString)) {
      str = getContext().getString(2131755617);
    }
    for (;;)
    {
      this.ozP.setVisibility(8);
      this.ozJ.setVisibility(0);
      this.mMg.setVisibility(0);
      this.mMg.setText(str);
      AppMethodBeat.o(138056);
      return;
      if ("设置地区".equals(paramString))
      {
        str = getContext().getString(2131755616);
      }
      else if ("设置日期".equals(paramString))
      {
        str = getContext().getString(2131755615);
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
    this.ozM = parama;
  }
  
  public void setOnValueUpdateListener(b paramb)
  {
    this.ozQ = paramb;
  }
  
  public void setOrientationGetter(q paramq)
  {
    AppMethodBeat.i(193738);
    Log.d("MicroMsg.AppBrand.AppBrandPickerBottomPanelBase", "setOrientationGetter, orientationGetter is " + paramq.getName());
    this.ozR = paramq;
    AppMethodBeat.o(193738);
  }
  
  protected void setPickerImpl(com.tencent.mm.plugin.appbrand.jsapi.r.c paramc)
  {
    AppMethodBeat.i(138050);
    if (this.ozH != null) {
      this.ozH.onDetach(this);
    }
    this.ozH = paramc;
    if (this.ozH != null) {
      this.ozH.onAttach(this);
    }
    if ((this.ozI == null) || (this.ozH == null) || (this.ozH.getView() == null))
    {
      AppMethodBeat.o(138050);
      return;
    }
    this.ozI.removeAllViews();
    ccs();
    paramc = new FrameLayout.LayoutParams(-1, -1);
    paramc.gravity = 17;
    this.ozI.addView(this.ozH.getView(), paramc);
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
    if (this.ozH == null)
    {
      setVisibility(8);
      AppMethodBeat.o(138051);
      return;
    }
    this.ozH.onShow(this);
    clearAnimation();
    setVisibility(0);
    this.isAnimating = true;
    Animation localAnimation = AnimationUtils.loadAnimation(getContext(), 2130771999);
    this.ozO.startAnimation(localAnimation);
    startAnimation(AnimationUtils.loadAnimation(getContext(), 2130771997));
    localAnimation.setAnimationListener(new Animation.AnimationListener()
    {
      public final void onAnimationEnd(Animation paramAnonymousAnimation)
      {
        AppMethodBeat.i(138041);
        c.this.setBackgroundResource(2131100930);
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
    public abstract void cH(T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.picker.c
 * JD-Core Version:    0.7.0.1
 */
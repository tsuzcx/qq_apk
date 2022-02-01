package com.tencent.mm.plugin.appbrand.page;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;

@SuppressLint({"ViewConstructor"})
public final class ag
  extends af
{
  private ax mcJ;
  private ImageView mhA;
  private ImageView mhB;
  private ImageView mhC;
  private final Runnable mhD;
  private long mhE;
  private a mhu;
  private b mhv;
  private boolean mhw;
  private LinearLayout mhx;
  private TextView mhy;
  private View mhz;
  
  public ag(Context paramContext, ax paramax)
  {
    super(paramContext);
    AppMethodBeat.i(135223);
    this.mhw = false;
    this.mhD = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135222);
        ag.a(ag.this).setTranslationY(-ag.a(ag.this).getHeight());
        AppMethodBeat.o(135222);
      }
    };
    this.mhE = 0L;
    this.mcJ = paramax;
    this.mhx = ((LinearLayout)LayoutInflater.from(getContext()).inflate(2131493033, this, false));
    paramContext = this.mhx;
    paramax = paramax.getWrapperView();
    this.mhh = paramContext;
    this.mhi = new FrameLayout(getContext());
    this.mhi.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.mhi.addView(paramContext);
    this.mhj = new FrameLayout(getContext());
    this.mhj.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.mhj.addView(paramax);
    addView(this.mhi);
    addView(this.mhj);
    this.mhy = ((TextView)findViewById(2131296805));
    this.mhz = findViewById(2131296801);
    this.mhA = ((ImageView)findViewById(2131296802));
    this.mhB = ((ImageView)findViewById(2131296803));
    this.mhC = ((ImageView)findViewById(2131296804));
    AppMethodBeat.o(135223);
  }
  
  private void bvP()
  {
    AppMethodBeat.i(135234);
    this.mhy.setTextColor(-16777216);
    this.mhy.setAlpha(0.2F);
    AppMethodBeat.o(135234);
  }
  
  private void bvQ()
  {
    AppMethodBeat.i(135238);
    if (this.mhA == null)
    {
      ae.w("MicroMsg.AppBrandPullDownWebView", "setupDarkLoading but mLoading0 is null, try protect");
      AppMethodBeat.o(135238);
      return;
    }
    this.mhA.setImageDrawable(e(-16777216, new float[] { 0.1F, 0.4F, 0.2F, 0.1F }));
    this.mhB.setImageDrawable(e(-16777216, new float[] { 0.1F, 0.1F, 0.4F, 0.2F }));
    this.mhC.setImageDrawable(e(-16777216, new float[] { 0.1F, 0.2F, 0.1F, 0.4F }));
    AppMethodBeat.o(135238);
  }
  
  private static AnimationDrawable e(int paramInt, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(135239);
    AnimationDrawable localAnimationDrawable = new AnimationDrawable();
    ae.i("MicroMsg.AppBrandPullDownWebView", "AnimationDrawable hash:" + localAnimationDrawable.hashCode());
    localAnimationDrawable.setOneShot(false);
    localAnimationDrawable.addFrame(n(paramInt, paramArrayOfFloat[0]), 0);
    localAnimationDrawable.addFrame(n(paramInt, paramArrayOfFloat[1]), 300);
    localAnimationDrawable.addFrame(n(paramInt, paramArrayOfFloat[2]), 300);
    localAnimationDrawable.addFrame(n(paramInt, paramArrayOfFloat[3]), 300);
    AppMethodBeat.o(135239);
    return localAnimationDrawable;
  }
  
  private static Drawable n(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(135240);
    ShapeDrawable localShapeDrawable = new ShapeDrawable(new OvalShape());
    localShapeDrawable.setIntrinsicHeight(32);
    localShapeDrawable.setIntrinsicWidth(32);
    localShapeDrawable.getPaint().setColor(paramInt);
    localShapeDrawable.getPaint().setAlpha((int)(255.0F * paramFloat));
    AppMethodBeat.o(135240);
    return localShapeDrawable;
  }
  
  protected final boolean Dr()
  {
    AppMethodBeat.i(135228);
    boolean bool = this.mcJ.Dr();
    AppMethodBeat.o(135228);
    return bool;
  }
  
  public final void bT(String paramString, int paramInt)
  {
    AppMethodBeat.i(135231);
    setBackgroundTextStyle(paramString);
    setPullDownBackgroundColor(paramInt);
    AppMethodBeat.o(135231);
  }
  
  protected final void bvM()
  {
    AppMethodBeat.i(135224);
    if (this.mhA == null) {
      ae.e("MicroMsg.AppBrandPullDownWebView", "startLoadingAnimation, mLoading0 is null");
    }
    for (;;)
    {
      if (this.mhu != null) {
        this.mhu.buy();
      }
      this.mhE = System.currentTimeMillis();
      AppMethodBeat.o(135224);
      return;
      if (this.mhA.getDrawable() == null)
      {
        ae.w("MicroMsg.AppBrandPullDownWebView", "startLoadingAnimation but drawable is null, try protect");
        bvQ();
        bvP();
      }
      ((AnimationDrawable)this.mhA.getDrawable()).start();
      ((AnimationDrawable)this.mhB.getDrawable()).start();
      ((AnimationDrawable)this.mhC.getDrawable()).start();
    }
  }
  
  protected final void bvN()
  {
    AppMethodBeat.i(135225);
    if ((this.mhA == null) || (this.mhA.getDrawable() == null))
    {
      ae.w("MicroMsg.AppBrandPullDownWebView", "stopLoadingAnimation but drawable is null, try protect");
      AppMethodBeat.o(135225);
      return;
    }
    ((AnimationDrawable)this.mhA.getDrawable()).stop();
    ((AnimationDrawable)this.mhA.getDrawable()).selectDrawable(0);
    ((AnimationDrawable)this.mhB.getDrawable()).stop();
    ((AnimationDrawable)this.mhB.getDrawable()).selectDrawable(0);
    ((AnimationDrawable)this.mhC.getDrawable()).stop();
    ((AnimationDrawable)this.mhC.getDrawable()).selectDrawable(0);
    AppMethodBeat.o(135225);
  }
  
  public final void bvO()
  {
    AppMethodBeat.i(135227);
    long l = System.currentTimeMillis() - this.mhE;
    if (l < 1000L)
    {
      postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(185196);
          ag.this.bvL();
          AppMethodBeat.o(185196);
        }
      }, 1000L - l);
      AppMethodBeat.o(135227);
      return;
    }
    bvL();
    AppMethodBeat.o(135227);
  }
  
  protected final int getStayHeight()
  {
    AppMethodBeat.i(135229);
    int i = this.mhx.getHeight();
    AppMethodBeat.o(135229);
    return i;
  }
  
  public final void hi(boolean paramBoolean)
  {
    AppMethodBeat.i(135236);
    this.mhw = paramBoolean;
    setNeedStay(paramBoolean);
    View localView = this.mhz;
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(135236);
      return;
    }
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(185197);
    super.onAttachedToWindow();
    post(this.mhD);
    AppMethodBeat.o(185197);
  }
  
  public final void setBackgroundTextStyle(String paramString)
  {
    AppMethodBeat.i(135232);
    if ("light".equals(paramString))
    {
      if (this.mhA == null) {
        ae.w("MicroMsg.AppBrandPullDownWebView", "setupLightLoading but mLoading0 is null, try protect");
      }
      for (;;)
      {
        this.mhy.setTextColor(-1);
        this.mhy.setAlpha(0.4F);
        AppMethodBeat.o(135232);
        return;
        this.mhA.setImageDrawable(e(-1, new float[] { 0.2F, 0.6F, 0.4F, 0.2F }));
        this.mhB.setImageDrawable(e(-1, new float[] { 0.2F, 0.2F, 0.6F, 0.4F }));
        this.mhC.setImageDrawable(e(-1, new float[] { 0.2F, 0.4F, 0.2F, 0.6F }));
      }
    }
    if (("dark".equals(paramString)) || (!"ignore".equals(paramString)))
    {
      bvQ();
      bvP();
    }
    AppMethodBeat.o(135232);
  }
  
  public final void setHeadViewHeight(int paramInt)
  {
    AppMethodBeat.i(135230);
    if (paramInt <= this.mhx.getHeight())
    {
      AppMethodBeat.o(135230);
      return;
    }
    this.mhx.getLayoutParams().height = paramInt;
    this.mhx.requestLayout();
    AppMethodBeat.o(135230);
  }
  
  public final void setOnPullDownListener(a parama)
  {
    this.mhu = parama;
  }
  
  public final void setOnPullDownOffsetListener(b paramb)
  {
    this.mhv = paramb;
  }
  
  public final void setPullDownText(String paramString)
  {
    AppMethodBeat.i(135235);
    if (bu.isNullOrNil(paramString))
    {
      this.mhy.setVisibility(8);
      AppMethodBeat.o(135235);
      return;
    }
    this.mhy.setVisibility(0);
    this.mhy.setText(paramString);
    AppMethodBeat.o(135235);
  }
  
  protected final void uU(int paramInt)
  {
    AppMethodBeat.i(135226);
    if (this.mhv != null) {
      this.mhv.gw(paramInt);
    }
    if (!this.mhw)
    {
      AppMethodBeat.o(135226);
      return;
    }
    removeCallbacks(this.mhD);
    int i = paramInt;
    if (paramInt > this.mhx.getHeight()) {
      i = this.mhx.getHeight();
    }
    LinearLayout localLinearLayout = this.mhx;
    localLinearLayout.setTranslationY(i - localLinearLayout.getHeight());
    AppMethodBeat.o(135226);
  }
  
  public static abstract interface a
  {
    public abstract void buy();
  }
  
  public static abstract interface b
  {
    public abstract void gw(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ag
 * JD-Core Version:    0.7.0.1
 */
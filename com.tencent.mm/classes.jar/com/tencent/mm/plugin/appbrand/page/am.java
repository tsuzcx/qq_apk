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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

@SuppressLint({"ViewConstructor"})
public final class am
  extends al
{
  private bd kWU;
  private a ldI;
  private b ldJ;
  private boolean ldK;
  private LinearLayout ldL;
  private TextView ldM;
  private View ldN;
  private ImageView ldO;
  private ImageView ldP;
  private ImageView ldQ;
  private final Runnable ldR;
  private long ldS;
  
  public am(Context paramContext, bd parambd)
  {
    super(paramContext);
    AppMethodBeat.i(135223);
    this.ldK = false;
    this.ldR = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135222);
        am.a(am.this).setTranslationY(-am.a(am.this).getHeight());
        AppMethodBeat.o(135222);
      }
    };
    this.ldS = 0L;
    this.kWU = parambd;
    this.ldL = ((LinearLayout)LayoutInflater.from(getContext()).inflate(2131493033, this, false));
    paramContext = this.ldL;
    parambd = parambd.getWrapperView();
    this.ldv = paramContext;
    this.ldw = new FrameLayout(getContext());
    this.ldw.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.ldw.addView(paramContext);
    this.ldx = new FrameLayout(getContext());
    this.ldx.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.ldx.addView(parambd);
    addView(this.ldw);
    addView(this.ldx);
    this.ldM = ((TextView)findViewById(2131296805));
    this.ldN = findViewById(2131296801);
    this.ldO = ((ImageView)findViewById(2131296802));
    this.ldP = ((ImageView)findViewById(2131296803));
    this.ldQ = ((ImageView)findViewById(2131296804));
    AppMethodBeat.o(135223);
  }
  
  private void bko()
  {
    AppMethodBeat.i(135234);
    this.ldM.setTextColor(-16777216);
    this.ldM.setAlpha(0.2F);
    AppMethodBeat.o(135234);
  }
  
  private void bkp()
  {
    AppMethodBeat.i(135238);
    if (this.ldO == null)
    {
      ad.w("MicroMsg.AppBrandPullDownWebView", "setupDarkLoading but mLoading0 is null, try protect");
      AppMethodBeat.o(135238);
      return;
    }
    this.ldO.setImageDrawable(e(-16777216, new float[] { 0.1F, 0.4F, 0.2F, 0.1F }));
    this.ldP.setImageDrawable(e(-16777216, new float[] { 0.1F, 0.1F, 0.4F, 0.2F }));
    this.ldQ.setImageDrawable(e(-16777216, new float[] { 0.1F, 0.2F, 0.1F, 0.4F }));
    AppMethodBeat.o(135238);
  }
  
  private static AnimationDrawable e(int paramInt, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(135239);
    AnimationDrawable localAnimationDrawable = new AnimationDrawable();
    ad.i("MicroMsg.AppBrandPullDownWebView", "AnimationDrawable hash:" + localAnimationDrawable.hashCode());
    localAnimationDrawable.setOneShot(false);
    localAnimationDrawable.addFrame(m(paramInt, paramArrayOfFloat[0]), 0);
    localAnimationDrawable.addFrame(m(paramInt, paramArrayOfFloat[1]), 300);
    localAnimationDrawable.addFrame(m(paramInt, paramArrayOfFloat[2]), 300);
    localAnimationDrawable.addFrame(m(paramInt, paramArrayOfFloat[3]), 300);
    AppMethodBeat.o(135239);
    return localAnimationDrawable;
  }
  
  private static Drawable m(int paramInt, float paramFloat)
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
  
  protected final boolean Cl()
  {
    AppMethodBeat.i(135228);
    boolean bool = this.kWU.Cl();
    AppMethodBeat.o(135228);
    return bool;
  }
  
  public final void bI(String paramString, int paramInt)
  {
    AppMethodBeat.i(135231);
    setBackgroundTextStyle(paramString);
    setPullDownBackgroundColor(paramInt);
    AppMethodBeat.o(135231);
  }
  
  protected final void bkl()
  {
    AppMethodBeat.i(135224);
    if (this.ldO == null) {
      ad.e("MicroMsg.AppBrandPullDownWebView", "startLoadingAnimation, mLoading0 is null");
    }
    for (;;)
    {
      if (this.ldI != null) {
        this.ldI.biU();
      }
      this.ldS = System.currentTimeMillis();
      AppMethodBeat.o(135224);
      return;
      if (this.ldO.getDrawable() == null)
      {
        ad.w("MicroMsg.AppBrandPullDownWebView", "startLoadingAnimation but drawable is null, try protect");
        bkp();
        bko();
      }
      ((AnimationDrawable)this.ldO.getDrawable()).start();
      ((AnimationDrawable)this.ldP.getDrawable()).start();
      ((AnimationDrawable)this.ldQ.getDrawable()).start();
    }
  }
  
  protected final void bkm()
  {
    AppMethodBeat.i(135225);
    if ((this.ldO == null) || (this.ldO.getDrawable() == null))
    {
      ad.w("MicroMsg.AppBrandPullDownWebView", "stopLoadingAnimation but drawable is null, try protect");
      AppMethodBeat.o(135225);
      return;
    }
    ((AnimationDrawable)this.ldO.getDrawable()).stop();
    ((AnimationDrawable)this.ldO.getDrawable()).selectDrawable(0);
    ((AnimationDrawable)this.ldP.getDrawable()).stop();
    ((AnimationDrawable)this.ldP.getDrawable()).selectDrawable(0);
    ((AnimationDrawable)this.ldQ.getDrawable()).stop();
    ((AnimationDrawable)this.ldQ.getDrawable()).selectDrawable(0);
    AppMethodBeat.o(135225);
  }
  
  public final void bkn()
  {
    AppMethodBeat.i(135227);
    long l = System.currentTimeMillis() - this.ldS;
    if (l < 1000L)
    {
      postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(185196);
          am.this.bkk();
          AppMethodBeat.o(185196);
        }
      }, 1000L - l);
      AppMethodBeat.o(135227);
      return;
    }
    bkk();
    AppMethodBeat.o(135227);
  }
  
  public final void gF(boolean paramBoolean)
  {
    AppMethodBeat.i(135236);
    this.ldK = paramBoolean;
    setNeedStay(paramBoolean);
    View localView = this.ldN;
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(135236);
      return;
    }
  }
  
  protected final int getStayHeight()
  {
    AppMethodBeat.i(135229);
    int i = this.ldL.getHeight();
    AppMethodBeat.o(135229);
    return i;
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(185197);
    super.onAttachedToWindow();
    post(this.ldR);
    AppMethodBeat.o(185197);
  }
  
  public final void setBackgroundTextStyle(String paramString)
  {
    AppMethodBeat.i(135232);
    if ("light".equals(paramString))
    {
      if (this.ldO == null) {
        ad.w("MicroMsg.AppBrandPullDownWebView", "setupLightLoading but mLoading0 is null, try protect");
      }
      for (;;)
      {
        this.ldM.setTextColor(-1);
        this.ldM.setAlpha(0.4F);
        AppMethodBeat.o(135232);
        return;
        this.ldO.setImageDrawable(e(-1, new float[] { 0.2F, 0.6F, 0.4F, 0.2F }));
        this.ldP.setImageDrawable(e(-1, new float[] { 0.2F, 0.2F, 0.6F, 0.4F }));
        this.ldQ.setImageDrawable(e(-1, new float[] { 0.2F, 0.4F, 0.2F, 0.6F }));
      }
    }
    if (("dark".equals(paramString)) || (!"ignore".equals(paramString)))
    {
      bkp();
      bko();
    }
    AppMethodBeat.o(135232);
  }
  
  public final void setHeadViewHeight(int paramInt)
  {
    AppMethodBeat.i(135230);
    if (paramInt <= this.ldL.getHeight())
    {
      AppMethodBeat.o(135230);
      return;
    }
    this.ldL.getLayoutParams().height = paramInt;
    this.ldL.requestLayout();
    AppMethodBeat.o(135230);
  }
  
  public final void setOnPullDownListener(a parama)
  {
    this.ldI = parama;
  }
  
  public final void setOnPullDownOffsetListener(b paramb)
  {
    this.ldJ = paramb;
  }
  
  public final void setPullDownText(String paramString)
  {
    AppMethodBeat.i(135235);
    if (bt.isNullOrNil(paramString))
    {
      this.ldM.setVisibility(8);
      AppMethodBeat.o(135235);
      return;
    }
    this.ldM.setVisibility(0);
    this.ldM.setText(paramString);
    AppMethodBeat.o(135235);
  }
  
  protected final void tw(int paramInt)
  {
    AppMethodBeat.i(135226);
    if (this.ldJ != null) {
      this.ldJ.gJ(paramInt);
    }
    if (!this.ldK)
    {
      AppMethodBeat.o(135226);
      return;
    }
    removeCallbacks(this.ldR);
    int i = paramInt;
    if (paramInt > this.ldL.getHeight()) {
      i = this.ldL.getHeight();
    }
    LinearLayout localLinearLayout = this.ldL;
    localLinearLayout.setTranslationY(i - localLinearLayout.getHeight());
    AppMethodBeat.o(135226);
  }
  
  public static abstract interface a
  {
    public abstract void biU();
  }
  
  public static abstract interface b
  {
    public abstract void gJ(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.am
 * JD-Core Version:    0.7.0.1
 */
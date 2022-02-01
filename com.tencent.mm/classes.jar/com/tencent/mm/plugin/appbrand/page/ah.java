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
public final class ah
  extends ag
{
  private ay lYc;
  private a mdc;
  private b mdd;
  private boolean mde;
  private LinearLayout mdf;
  private TextView mdg;
  private View mdh;
  private ImageView mdi;
  private ImageView mdj;
  private ImageView mdk;
  private final Runnable mdl;
  private long mdm;
  
  public ah(Context paramContext, ay paramay)
  {
    super(paramContext);
    AppMethodBeat.i(135223);
    this.mde = false;
    this.mdl = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135222);
        ah.a(ah.this).setTranslationY(-ah.a(ah.this).getHeight());
        AppMethodBeat.o(135222);
      }
    };
    this.mdm = 0L;
    this.lYc = paramay;
    this.mdf = ((LinearLayout)LayoutInflater.from(getContext()).inflate(2131493033, this, false));
    paramContext = this.mdf;
    paramay = paramay.getWrapperView();
    this.mcP = paramContext;
    this.mcQ = new FrameLayout(getContext());
    this.mcQ.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.mcQ.addView(paramContext);
    this.mcR = new FrameLayout(getContext());
    this.mcR.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.mcR.addView(paramay);
    addView(this.mcQ);
    addView(this.mcR);
    this.mdg = ((TextView)findViewById(2131296805));
    this.mdh = findViewById(2131296801);
    this.mdi = ((ImageView)findViewById(2131296802));
    this.mdj = ((ImageView)findViewById(2131296803));
    this.mdk = ((ImageView)findViewById(2131296804));
    AppMethodBeat.o(135223);
  }
  
  private void bve()
  {
    AppMethodBeat.i(135234);
    this.mdg.setTextColor(-16777216);
    this.mdg.setAlpha(0.2F);
    AppMethodBeat.o(135234);
  }
  
  private void bvf()
  {
    AppMethodBeat.i(135238);
    if (this.mdi == null)
    {
      ad.w("MicroMsg.AppBrandPullDownWebView", "setupDarkLoading but mLoading0 is null, try protect");
      AppMethodBeat.o(135238);
      return;
    }
    this.mdi.setImageDrawable(e(-16777216, new float[] { 0.1F, 0.4F, 0.2F, 0.1F }));
    this.mdj.setImageDrawable(e(-16777216, new float[] { 0.1F, 0.1F, 0.4F, 0.2F }));
    this.mdk.setImageDrawable(e(-16777216, new float[] { 0.1F, 0.2F, 0.1F, 0.4F }));
    AppMethodBeat.o(135238);
  }
  
  private static AnimationDrawable e(int paramInt, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(135239);
    AnimationDrawable localAnimationDrawable = new AnimationDrawable();
    ad.i("MicroMsg.AppBrandPullDownWebView", "AnimationDrawable hash:" + localAnimationDrawable.hashCode());
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
  
  protected final boolean Do()
  {
    AppMethodBeat.i(135228);
    boolean bool = this.lYc.Do();
    AppMethodBeat.o(135228);
    return bool;
  }
  
  public final void bP(String paramString, int paramInt)
  {
    AppMethodBeat.i(135231);
    setBackgroundTextStyle(paramString);
    setPullDownBackgroundColor(paramInt);
    AppMethodBeat.o(135231);
  }
  
  protected final void bvb()
  {
    AppMethodBeat.i(135224);
    if (this.mdi == null) {
      ad.e("MicroMsg.AppBrandPullDownWebView", "startLoadingAnimation, mLoading0 is null");
    }
    for (;;)
    {
      if (this.mdc != null) {
        this.mdc.btN();
      }
      this.mdm = System.currentTimeMillis();
      AppMethodBeat.o(135224);
      return;
      if (this.mdi.getDrawable() == null)
      {
        ad.w("MicroMsg.AppBrandPullDownWebView", "startLoadingAnimation but drawable is null, try protect");
        bvf();
        bve();
      }
      ((AnimationDrawable)this.mdi.getDrawable()).start();
      ((AnimationDrawable)this.mdj.getDrawable()).start();
      ((AnimationDrawable)this.mdk.getDrawable()).start();
    }
  }
  
  protected final void bvc()
  {
    AppMethodBeat.i(135225);
    if ((this.mdi == null) || (this.mdi.getDrawable() == null))
    {
      ad.w("MicroMsg.AppBrandPullDownWebView", "stopLoadingAnimation but drawable is null, try protect");
      AppMethodBeat.o(135225);
      return;
    }
    ((AnimationDrawable)this.mdi.getDrawable()).stop();
    ((AnimationDrawable)this.mdi.getDrawable()).selectDrawable(0);
    ((AnimationDrawable)this.mdj.getDrawable()).stop();
    ((AnimationDrawable)this.mdj.getDrawable()).selectDrawable(0);
    ((AnimationDrawable)this.mdk.getDrawable()).stop();
    ((AnimationDrawable)this.mdk.getDrawable()).selectDrawable(0);
    AppMethodBeat.o(135225);
  }
  
  public final void bvd()
  {
    AppMethodBeat.i(135227);
    long l = System.currentTimeMillis() - this.mdm;
    if (l < 1000L)
    {
      postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(185196);
          ah.this.bva();
          AppMethodBeat.o(185196);
        }
      }, 1000L - l);
      AppMethodBeat.o(135227);
      return;
    }
    bva();
    AppMethodBeat.o(135227);
  }
  
  protected final int getStayHeight()
  {
    AppMethodBeat.i(135229);
    int i = this.mdf.getHeight();
    AppMethodBeat.o(135229);
    return i;
  }
  
  public final void hh(boolean paramBoolean)
  {
    AppMethodBeat.i(135236);
    this.mde = paramBoolean;
    setNeedStay(paramBoolean);
    View localView = this.mdh;
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
    post(this.mdl);
    AppMethodBeat.o(185197);
  }
  
  public final void setBackgroundTextStyle(String paramString)
  {
    AppMethodBeat.i(135232);
    if ("light".equals(paramString))
    {
      if (this.mdi == null) {
        ad.w("MicroMsg.AppBrandPullDownWebView", "setupLightLoading but mLoading0 is null, try protect");
      }
      for (;;)
      {
        this.mdg.setTextColor(-1);
        this.mdg.setAlpha(0.4F);
        AppMethodBeat.o(135232);
        return;
        this.mdi.setImageDrawable(e(-1, new float[] { 0.2F, 0.6F, 0.4F, 0.2F }));
        this.mdj.setImageDrawable(e(-1, new float[] { 0.2F, 0.2F, 0.6F, 0.4F }));
        this.mdk.setImageDrawable(e(-1, new float[] { 0.2F, 0.4F, 0.2F, 0.6F }));
      }
    }
    if (("dark".equals(paramString)) || (!"ignore".equals(paramString)))
    {
      bvf();
      bve();
    }
    AppMethodBeat.o(135232);
  }
  
  public final void setHeadViewHeight(int paramInt)
  {
    AppMethodBeat.i(135230);
    if (paramInt <= this.mdf.getHeight())
    {
      AppMethodBeat.o(135230);
      return;
    }
    this.mdf.getLayoutParams().height = paramInt;
    this.mdf.requestLayout();
    AppMethodBeat.o(135230);
  }
  
  public final void setOnPullDownListener(a parama)
  {
    this.mdc = parama;
  }
  
  public final void setOnPullDownOffsetListener(b paramb)
  {
    this.mdd = paramb;
  }
  
  public final void setPullDownText(String paramString)
  {
    AppMethodBeat.i(135235);
    if (bt.isNullOrNil(paramString))
    {
      this.mdg.setVisibility(8);
      AppMethodBeat.o(135235);
      return;
    }
    this.mdg.setVisibility(0);
    this.mdg.setText(paramString);
    AppMethodBeat.o(135235);
  }
  
  protected final void uQ(int paramInt)
  {
    AppMethodBeat.i(135226);
    if (this.mdd != null) {
      this.mdd.gw(paramInt);
    }
    if (!this.mde)
    {
      AppMethodBeat.o(135226);
      return;
    }
    removeCallbacks(this.mdl);
    int i = paramInt;
    if (paramInt > this.mdf.getHeight()) {
      i = this.mdf.getHeight();
    }
    LinearLayout localLinearLayout = this.mdf;
    localLinearLayout.setTranslationY(i - localLinearLayout.getHeight());
    AppMethodBeat.o(135226);
  }
  
  public static abstract interface a
  {
    public abstract void btN();
  }
  
  public static abstract interface b
  {
    public abstract void gw(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ah
 * JD-Core Version:    0.7.0.1
 */
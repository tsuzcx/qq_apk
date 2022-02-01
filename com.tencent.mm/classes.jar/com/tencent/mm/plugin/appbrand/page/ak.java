package com.tencent.mm.plugin.appbrand.page;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.luggage.wxa.a.d;
import com.tencent.luggage.wxa.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public final class ak
  extends aj
{
  private bd tti;
  private a tym;
  private b tyn;
  private boolean tyo;
  private LinearLayout typ;
  private TextView tyq;
  private View tyr;
  private ImageView tys;
  private ImageView tyt;
  private ImageView tyu;
  private final Runnable tyv;
  private long tyw;
  
  public ak(Context paramContext, bd parambd)
  {
    super(paramContext);
    AppMethodBeat.i(135223);
    this.tyo = false;
    this.tyv = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135222);
        ak.a(ak.this).setTranslationY(-ak.a(ak.this).getHeight());
        AppMethodBeat.o(135222);
      }
    };
    this.tyw = 0L;
    this.tti = parambd;
    this.typ = ((LinearLayout)LayoutInflater.from(getContext()).inflate(a.e.app_brand_pulldown_webview_background, this, false));
    h(this.typ, parambd.getWrapperView());
    this.tyq = ((TextView)findViewById(a.d.app_brand_pulldown_background_text));
    this.tyr = findViewById(a.d.app_brand_pulldown_background_loading);
    this.tys = ((ImageView)findViewById(a.d.app_brand_pulldown_background_loading0));
    this.tyt = ((ImageView)findViewById(a.d.app_brand_pulldown_background_loading1));
    this.tyu = ((ImageView)findViewById(a.d.app_brand_pulldown_background_loading2));
    AppMethodBeat.o(135223);
  }
  
  private void cFu()
  {
    AppMethodBeat.i(135234);
    this.tyq.setTextColor(-16777216);
    this.tyq.setAlpha(0.2F);
    AppMethodBeat.o(135234);
  }
  
  private void cFv()
  {
    AppMethodBeat.i(135238);
    if (this.tys == null)
    {
      Log.w("MicroMsg.AppBrandPullDownWebView", "setupDarkLoading but mLoading0 is null, try protect");
      AppMethodBeat.o(135238);
      return;
    }
    this.tys.setImageDrawable(g(-16777216, new float[] { 0.1F, 0.4F, 0.2F, 0.1F }));
    this.tyt.setImageDrawable(g(-16777216, new float[] { 0.1F, 0.1F, 0.4F, 0.2F }));
    this.tyu.setImageDrawable(g(-16777216, new float[] { 0.1F, 0.2F, 0.1F, 0.4F }));
    AppMethodBeat.o(135238);
  }
  
  private static AnimationDrawable g(int paramInt, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(135239);
    AnimationDrawable localAnimationDrawable = new AnimationDrawable();
    Log.i("MicroMsg.AppBrandPullDownWebView", "AnimationDrawable hash:" + localAnimationDrawable.hashCode());
    localAnimationDrawable.setOneShot(false);
    localAnimationDrawable.addFrame(r(paramInt, paramArrayOfFloat[0]), 0);
    localAnimationDrawable.addFrame(r(paramInt, paramArrayOfFloat[1]), 300);
    localAnimationDrawable.addFrame(r(paramInt, paramArrayOfFloat[2]), 300);
    localAnimationDrawable.addFrame(r(paramInt, paramArrayOfFloat[3]), 300);
    AppMethodBeat.o(135239);
    return localAnimationDrawable;
  }
  
  private static Drawable r(int paramInt, float paramFloat)
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
  
  protected final void CG(int paramInt)
  {
    AppMethodBeat.i(135226);
    if (this.tyn != null) {
      this.tyn.mn(paramInt);
    }
    if (!this.tyo)
    {
      AppMethodBeat.o(135226);
      return;
    }
    removeCallbacks(this.tyv);
    int i = paramInt;
    if (paramInt > this.typ.getHeight()) {
      i = this.typ.getHeight();
    }
    LinearLayout localLinearLayout = this.typ;
    localLinearLayout.setTranslationY(i - localLinearLayout.getHeight());
    AppMethodBeat.o(135226);
  }
  
  protected final boolean apP()
  {
    AppMethodBeat.i(135228);
    boolean bool = this.tti.apP();
    AppMethodBeat.o(135228);
    return bool;
  }
  
  protected final void cFr()
  {
    AppMethodBeat.i(135224);
    if (this.tys == null) {
      Log.e("MicroMsg.AppBrandPullDownWebView", "startLoadingAnimation, mLoading0 is null");
    }
    for (;;)
    {
      if (this.tym != null) {
        this.tym.cDL();
      }
      this.tyw = System.currentTimeMillis();
      AppMethodBeat.o(135224);
      return;
      if (this.tys.getDrawable() == null)
      {
        Log.w("MicroMsg.AppBrandPullDownWebView", "startLoadingAnimation but drawable is null, try protect");
        cFv();
        cFu();
      }
      ((AnimationDrawable)this.tys.getDrawable()).start();
      ((AnimationDrawable)this.tyt.getDrawable()).start();
      ((AnimationDrawable)this.tyu.getDrawable()).start();
    }
  }
  
  protected final void cFs()
  {
    AppMethodBeat.i(135225);
    if ((this.tys == null) || (this.tys.getDrawable() == null))
    {
      Log.w("MicroMsg.AppBrandPullDownWebView", "stopLoadingAnimation but drawable is null, try protect");
      AppMethodBeat.o(135225);
      return;
    }
    ((AnimationDrawable)this.tys.getDrawable()).stop();
    ((AnimationDrawable)this.tys.getDrawable()).selectDrawable(0);
    ((AnimationDrawable)this.tyt.getDrawable()).stop();
    ((AnimationDrawable)this.tyt.getDrawable()).selectDrawable(0);
    ((AnimationDrawable)this.tyu.getDrawable()).stop();
    ((AnimationDrawable)this.tyu.getDrawable()).selectDrawable(0);
    AppMethodBeat.o(135225);
  }
  
  public final void cFt()
  {
    AppMethodBeat.i(135227);
    long l = System.currentTimeMillis() - this.tyw;
    if (l < 1000L)
    {
      postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(185196);
          ak.this.cFq();
          AppMethodBeat.o(185196);
        }
      }, 1000L - l);
      AppMethodBeat.o(135227);
      return;
    }
    cFq();
    AppMethodBeat.o(135227);
  }
  
  public final void cX(String paramString, int paramInt)
  {
    AppMethodBeat.i(135231);
    setBackgroundTextStyle(paramString);
    setPullDownBackgroundColor(paramInt);
    AppMethodBeat.o(135231);
  }
  
  protected final int getStayHeight()
  {
    AppMethodBeat.i(135229);
    int i = this.typ.getHeight();
    AppMethodBeat.o(135229);
    return i;
  }
  
  public final void kr(boolean paramBoolean)
  {
    AppMethodBeat.i(135236);
    this.tyo = paramBoolean;
    setNeedStay(paramBoolean);
    View localView = this.tyr;
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
    post(this.tyv);
    AppMethodBeat.o(185197);
  }
  
  public final void setBackgroundTextStyle(String paramString)
  {
    AppMethodBeat.i(135232);
    if ("light".equals(paramString))
    {
      if (this.tys == null) {
        Log.w("MicroMsg.AppBrandPullDownWebView", "setupLightLoading but mLoading0 is null, try protect");
      }
      for (;;)
      {
        this.tyq.setTextColor(-1);
        this.tyq.setAlpha(0.4F);
        AppMethodBeat.o(135232);
        return;
        this.tys.setImageDrawable(g(-1, new float[] { 0.2F, 0.6F, 0.4F, 0.2F }));
        this.tyt.setImageDrawable(g(-1, new float[] { 0.2F, 0.2F, 0.6F, 0.4F }));
        this.tyu.setImageDrawable(g(-1, new float[] { 0.2F, 0.4F, 0.2F, 0.6F }));
      }
    }
    if (("dark".equals(paramString)) || (!"ignore".equals(paramString)))
    {
      cFv();
      cFu();
    }
    AppMethodBeat.o(135232);
  }
  
  public final void setHeadViewHeight(int paramInt)
  {
    AppMethodBeat.i(135230);
    if (paramInt <= this.typ.getHeight())
    {
      AppMethodBeat.o(135230);
      return;
    }
    this.typ.getLayoutParams().height = paramInt;
    this.typ.requestLayout();
    AppMethodBeat.o(135230);
  }
  
  public final void setOnPullDownListener(a parama)
  {
    this.tym = parama;
  }
  
  public final void setOnPullDownOffsetListener(b paramb)
  {
    this.tyn = paramb;
  }
  
  public final void setPullDownText(String paramString)
  {
    AppMethodBeat.i(135235);
    if (Util.isNullOrNil(paramString))
    {
      this.tyq.setVisibility(8);
      AppMethodBeat.o(135235);
      return;
    }
    this.tyq.setVisibility(0);
    this.tyq.setText(paramString);
    AppMethodBeat.o(135235);
  }
  
  public static abstract interface a
  {
    public abstract void cDL();
  }
  
  public static abstract interface b
  {
    public abstract void mn(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ak
 * JD-Core Version:    0.7.0.1
 */
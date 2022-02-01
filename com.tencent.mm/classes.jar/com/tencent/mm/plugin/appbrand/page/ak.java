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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.luggage.wxa.a.d;
import com.tencent.luggage.wxa.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

@SuppressLint({"ViewConstructor"})
public final class ak
  extends aj
{
  private bd qoF;
  private a qtH;
  private b qtI;
  private boolean qtJ;
  private LinearLayout qtK;
  private TextView qtL;
  private View qtM;
  private ImageView qtN;
  private ImageView qtO;
  private ImageView qtP;
  private final Runnable qtQ;
  private long qtR;
  
  public ak(Context paramContext, bd parambd)
  {
    super(paramContext);
    AppMethodBeat.i(135223);
    this.qtJ = false;
    this.qtQ = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135222);
        ak.a(ak.this).setTranslationY(-ak.a(ak.this).getHeight());
        AppMethodBeat.o(135222);
      }
    };
    this.qtR = 0L;
    this.qoF = parambd;
    this.qtK = ((LinearLayout)LayoutInflater.from(getContext()).inflate(a.e.app_brand_pulldown_webview_background, this, false));
    h(this.qtK, parambd.getWrapperView());
    this.qtL = ((TextView)findViewById(a.d.app_brand_pulldown_background_text));
    this.qtM = findViewById(a.d.app_brand_pulldown_background_loading);
    this.qtN = ((ImageView)findViewById(a.d.app_brand_pulldown_background_loading0));
    this.qtO = ((ImageView)findViewById(a.d.app_brand_pulldown_background_loading1));
    this.qtP = ((ImageView)findViewById(a.d.app_brand_pulldown_background_loading2));
    AppMethodBeat.o(135223);
  }
  
  private void ceR()
  {
    AppMethodBeat.i(135234);
    this.qtL.setTextColor(-16777216);
    this.qtL.setAlpha(0.2F);
    AppMethodBeat.o(135234);
  }
  
  private void ceS()
  {
    AppMethodBeat.i(135238);
    if (this.qtN == null)
    {
      Log.w("MicroMsg.AppBrandPullDownWebView", "setupDarkLoading but mLoading0 is null, try protect");
      AppMethodBeat.o(135238);
      return;
    }
    this.qtN.setImageDrawable(g(-16777216, new float[] { 0.1F, 0.4F, 0.2F, 0.1F }));
    this.qtO.setImageDrawable(g(-16777216, new float[] { 0.1F, 0.1F, 0.4F, 0.2F }));
    this.qtP.setImageDrawable(g(-16777216, new float[] { 0.1F, 0.2F, 0.1F, 0.4F }));
    AppMethodBeat.o(135238);
  }
  
  private static AnimationDrawable g(int paramInt, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(135239);
    AnimationDrawable localAnimationDrawable = new AnimationDrawable();
    Log.i("MicroMsg.AppBrandPullDownWebView", "AnimationDrawable hash:" + localAnimationDrawable.hashCode());
    localAnimationDrawable.setOneShot(false);
    localAnimationDrawable.addFrame(o(paramInt, paramArrayOfFloat[0]), 0);
    localAnimationDrawable.addFrame(o(paramInt, paramArrayOfFloat[1]), 300);
    localAnimationDrawable.addFrame(o(paramInt, paramArrayOfFloat[2]), 300);
    localAnimationDrawable.addFrame(o(paramInt, paramArrayOfFloat[3]), 300);
    AppMethodBeat.o(135239);
    return localAnimationDrawable;
  }
  
  private static Drawable o(int paramInt, float paramFloat)
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
  
  protected final void Cq(int paramInt)
  {
    AppMethodBeat.i(135226);
    if (this.qtI != null) {
      this.qtI.iK(paramInt);
    }
    if (!this.qtJ)
    {
      AppMethodBeat.o(135226);
      return;
    }
    removeCallbacks(this.qtQ);
    int i = paramInt;
    if (paramInt > this.qtK.getHeight()) {
      i = this.qtK.getHeight();
    }
    LinearLayout localLinearLayout = this.qtK;
    localLinearLayout.setTranslationY(i - localLinearLayout.getHeight());
    AppMethodBeat.o(135226);
  }
  
  protected final boolean PF()
  {
    AppMethodBeat.i(135228);
    boolean bool = this.qoF.PF();
    AppMethodBeat.o(135228);
    return bool;
  }
  
  protected final void ceO()
  {
    AppMethodBeat.i(135224);
    if (this.qtN == null) {
      Log.e("MicroMsg.AppBrandPullDownWebView", "startLoadingAnimation, mLoading0 is null");
    }
    for (;;)
    {
      if (this.qtH != null) {
        this.qtH.cdo();
      }
      this.qtR = System.currentTimeMillis();
      AppMethodBeat.o(135224);
      return;
      if (this.qtN.getDrawable() == null)
      {
        Log.w("MicroMsg.AppBrandPullDownWebView", "startLoadingAnimation but drawable is null, try protect");
        ceS();
        ceR();
      }
      ((AnimationDrawable)this.qtN.getDrawable()).start();
      ((AnimationDrawable)this.qtO.getDrawable()).start();
      ((AnimationDrawable)this.qtP.getDrawable()).start();
    }
  }
  
  protected final void ceP()
  {
    AppMethodBeat.i(135225);
    if ((this.qtN == null) || (this.qtN.getDrawable() == null))
    {
      Log.w("MicroMsg.AppBrandPullDownWebView", "stopLoadingAnimation but drawable is null, try protect");
      AppMethodBeat.o(135225);
      return;
    }
    ((AnimationDrawable)this.qtN.getDrawable()).stop();
    ((AnimationDrawable)this.qtN.getDrawable()).selectDrawable(0);
    ((AnimationDrawable)this.qtO.getDrawable()).stop();
    ((AnimationDrawable)this.qtO.getDrawable()).selectDrawable(0);
    ((AnimationDrawable)this.qtP.getDrawable()).stop();
    ((AnimationDrawable)this.qtP.getDrawable()).selectDrawable(0);
    AppMethodBeat.o(135225);
  }
  
  public final void ceQ()
  {
    AppMethodBeat.i(135227);
    long l = System.currentTimeMillis() - this.qtR;
    if (l < 1000L)
    {
      postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(185196);
          ak.this.ceN();
          AppMethodBeat.o(185196);
        }
      }, 1000L - l);
      AppMethodBeat.o(135227);
      return;
    }
    ceN();
    AppMethodBeat.o(135227);
  }
  
  public final void cz(String paramString, int paramInt)
  {
    AppMethodBeat.i(135231);
    setBackgroundTextStyle(paramString);
    setPullDownBackgroundColor(paramInt);
    AppMethodBeat.o(135231);
  }
  
  protected final int getStayHeight()
  {
    AppMethodBeat.i(135229);
    int i = this.qtK.getHeight();
    AppMethodBeat.o(135229);
    return i;
  }
  
  public final void jg(boolean paramBoolean)
  {
    AppMethodBeat.i(135236);
    this.qtJ = paramBoolean;
    setNeedStay(paramBoolean);
    View localView = this.qtM;
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
    post(this.qtQ);
    AppMethodBeat.o(185197);
  }
  
  public final void setBackgroundTextStyle(String paramString)
  {
    AppMethodBeat.i(135232);
    if ("light".equals(paramString))
    {
      if (this.qtN == null) {
        Log.w("MicroMsg.AppBrandPullDownWebView", "setupLightLoading but mLoading0 is null, try protect");
      }
      for (;;)
      {
        this.qtL.setTextColor(-1);
        this.qtL.setAlpha(0.4F);
        AppMethodBeat.o(135232);
        return;
        this.qtN.setImageDrawable(g(-1, new float[] { 0.2F, 0.6F, 0.4F, 0.2F }));
        this.qtO.setImageDrawable(g(-1, new float[] { 0.2F, 0.2F, 0.6F, 0.4F }));
        this.qtP.setImageDrawable(g(-1, new float[] { 0.2F, 0.4F, 0.2F, 0.6F }));
      }
    }
    if (("dark".equals(paramString)) || (!"ignore".equals(paramString)))
    {
      ceS();
      ceR();
    }
    AppMethodBeat.o(135232);
  }
  
  public final void setHeadViewHeight(int paramInt)
  {
    AppMethodBeat.i(135230);
    if (paramInt <= this.qtK.getHeight())
    {
      AppMethodBeat.o(135230);
      return;
    }
    this.qtK.getLayoutParams().height = paramInt;
    this.qtK.requestLayout();
    AppMethodBeat.o(135230);
  }
  
  public final void setOnPullDownListener(a parama)
  {
    this.qtH = parama;
  }
  
  public final void setOnPullDownOffsetListener(b paramb)
  {
    this.qtI = paramb;
  }
  
  public final void setPullDownText(String paramString)
  {
    AppMethodBeat.i(135235);
    if (Util.isNullOrNil(paramString))
    {
      this.qtL.setVisibility(8);
      AppMethodBeat.o(135235);
      return;
    }
    this.qtL.setVisibility(0);
    this.qtL.setText(paramString);
    AppMethodBeat.o(135235);
  }
  
  public static abstract interface a
  {
    public abstract void cdo();
  }
  
  public static abstract interface b
  {
    public abstract void iK(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ak
 * JD-Core Version:    0.7.0.1
 */
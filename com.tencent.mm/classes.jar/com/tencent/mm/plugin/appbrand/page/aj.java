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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

@SuppressLint({"ViewConstructor"})
public final class aj
  extends ai
{
  private bb nmX;
  private aj.a nrP;
  private b nrQ;
  private boolean nrR;
  private LinearLayout nrS;
  private TextView nrT;
  private View nrU;
  private ImageView nrV;
  private ImageView nrW;
  private ImageView nrX;
  private final Runnable nrY;
  private long nrZ;
  
  public aj(Context paramContext, bb parambb)
  {
    super(paramContext);
    AppMethodBeat.i(135223);
    this.nrR = false;
    this.nrY = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135222);
        aj.a(aj.this).setTranslationY(-aj.a(aj.this).getHeight());
        AppMethodBeat.o(135222);
      }
    };
    this.nrZ = 0L;
    this.nmX = parambb;
    this.nrS = ((LinearLayout)LayoutInflater.from(getContext()).inflate(2131493072, this, false));
    paramContext = this.nrS;
    parambb = parambb.getWrapperView();
    this.nrE = paramContext;
    this.nrF = new FrameLayout(getContext());
    this.nrF.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.nrF.addView(paramContext);
    this.nms = new FrameLayout(getContext());
    this.nms.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.nms.addView(parambb);
    addView(this.nrF);
    addView(this.nms);
    this.nrT = ((TextView)findViewById(2131296889));
    this.nrU = findViewById(2131296885);
    this.nrV = ((ImageView)findViewById(2131296886));
    this.nrW = ((ImageView)findViewById(2131296887));
    this.nrX = ((ImageView)findViewById(2131296888));
    AppMethodBeat.o(135223);
  }
  
  private void bRU()
  {
    AppMethodBeat.i(135234);
    this.nrT.setTextColor(-16777216);
    this.nrT.setAlpha(0.2F);
    AppMethodBeat.o(135234);
  }
  
  private void bRV()
  {
    AppMethodBeat.i(135238);
    if (this.nrV == null)
    {
      Log.w("MicroMsg.AppBrandPullDownWebView", "setupDarkLoading but mLoading0 is null, try protect");
      AppMethodBeat.o(135238);
      return;
    }
    this.nrV.setImageDrawable(g(-16777216, new float[] { 0.1F, 0.4F, 0.2F, 0.1F }));
    this.nrW.setImageDrawable(g(-16777216, new float[] { 0.1F, 0.1F, 0.4F, 0.2F }));
    this.nrX.setImageDrawable(g(-16777216, new float[] { 0.1F, 0.2F, 0.1F, 0.4F }));
    AppMethodBeat.o(135238);
  }
  
  private static AnimationDrawable g(int paramInt, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(135239);
    AnimationDrawable localAnimationDrawable = new AnimationDrawable();
    Log.i("MicroMsg.AppBrandPullDownWebView", "AnimationDrawable hash:" + localAnimationDrawable.hashCode());
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
  
  protected final boolean MN()
  {
    AppMethodBeat.i(135228);
    boolean bool = this.nmX.MN();
    AppMethodBeat.o(135228);
    return bool;
  }
  
  protected final void bRR()
  {
    AppMethodBeat.i(135224);
    if (this.nrV == null) {
      Log.e("MicroMsg.AppBrandPullDownWebView", "startLoadingAnimation, mLoading0 is null");
    }
    for (;;)
    {
      if (this.nrP != null) {
        this.nrP.bQy();
      }
      this.nrZ = System.currentTimeMillis();
      AppMethodBeat.o(135224);
      return;
      if (this.nrV.getDrawable() == null)
      {
        Log.w("MicroMsg.AppBrandPullDownWebView", "startLoadingAnimation but drawable is null, try protect");
        bRV();
        bRU();
      }
      ((AnimationDrawable)this.nrV.getDrawable()).start();
      ((AnimationDrawable)this.nrW.getDrawable()).start();
      ((AnimationDrawable)this.nrX.getDrawable()).start();
    }
  }
  
  protected final void bRS()
  {
    AppMethodBeat.i(135225);
    if ((this.nrV == null) || (this.nrV.getDrawable() == null))
    {
      Log.w("MicroMsg.AppBrandPullDownWebView", "stopLoadingAnimation but drawable is null, try protect");
      AppMethodBeat.o(135225);
      return;
    }
    ((AnimationDrawable)this.nrV.getDrawable()).stop();
    ((AnimationDrawable)this.nrV.getDrawable()).selectDrawable(0);
    ((AnimationDrawable)this.nrW.getDrawable()).stop();
    ((AnimationDrawable)this.nrW.getDrawable()).selectDrawable(0);
    ((AnimationDrawable)this.nrX.getDrawable()).stop();
    ((AnimationDrawable)this.nrX.getDrawable()).selectDrawable(0);
    AppMethodBeat.o(135225);
  }
  
  public final void bRT()
  {
    AppMethodBeat.i(135227);
    long l = System.currentTimeMillis() - this.nrZ;
    if (l < 1000L)
    {
      postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(185196);
          aj.this.bRQ();
          AppMethodBeat.o(185196);
        }
      }, 1000L - l);
      AppMethodBeat.o(135227);
      return;
    }
    bRQ();
    AppMethodBeat.o(135227);
  }
  
  public final void cb(String paramString, int paramInt)
  {
    AppMethodBeat.i(135231);
    setBackgroundTextStyle(paramString);
    setPullDownBackgroundColor(paramInt);
    AppMethodBeat.o(135231);
  }
  
  protected final int getStayHeight()
  {
    AppMethodBeat.i(135229);
    int i = this.nrS.getHeight();
    AppMethodBeat.o(135229);
    return i;
  }
  
  public final void ij(boolean paramBoolean)
  {
    AppMethodBeat.i(135236);
    this.nrR = paramBoolean;
    setNeedStay(paramBoolean);
    View localView = this.nrU;
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
    post(this.nrY);
    AppMethodBeat.o(185197);
  }
  
  public final void setBackgroundTextStyle(String paramString)
  {
    AppMethodBeat.i(135232);
    if ("light".equals(paramString))
    {
      if (this.nrV == null) {
        Log.w("MicroMsg.AppBrandPullDownWebView", "setupLightLoading but mLoading0 is null, try protect");
      }
      for (;;)
      {
        this.nrT.setTextColor(-1);
        this.nrT.setAlpha(0.4F);
        AppMethodBeat.o(135232);
        return;
        this.nrV.setImageDrawable(g(-1, new float[] { 0.2F, 0.6F, 0.4F, 0.2F }));
        this.nrW.setImageDrawable(g(-1, new float[] { 0.2F, 0.2F, 0.6F, 0.4F }));
        this.nrX.setImageDrawable(g(-1, new float[] { 0.2F, 0.4F, 0.2F, 0.6F }));
      }
    }
    if (("dark".equals(paramString)) || (!"ignore".equals(paramString)))
    {
      bRV();
      bRU();
    }
    AppMethodBeat.o(135232);
  }
  
  public final void setHeadViewHeight(int paramInt)
  {
    AppMethodBeat.i(135230);
    if (paramInt <= this.nrS.getHeight())
    {
      AppMethodBeat.o(135230);
      return;
    }
    this.nrS.getLayoutParams().height = paramInt;
    this.nrS.requestLayout();
    AppMethodBeat.o(135230);
  }
  
  public final void setOnPullDownListener(aj.a parama)
  {
    this.nrP = parama;
  }
  
  public final void setOnPullDownOffsetListener(b paramb)
  {
    this.nrQ = paramb;
  }
  
  public final void setPullDownText(String paramString)
  {
    AppMethodBeat.i(135235);
    if (Util.isNullOrNil(paramString))
    {
      this.nrT.setVisibility(8);
      AppMethodBeat.o(135235);
      return;
    }
    this.nrT.setVisibility(0);
    this.nrT.setText(paramString);
    AppMethodBeat.o(135235);
  }
  
  protected final void yM(int paramInt)
  {
    AppMethodBeat.i(135226);
    if (this.nrQ != null) {
      this.nrQ.hK(paramInt);
    }
    if (!this.nrR)
    {
      AppMethodBeat.o(135226);
      return;
    }
    removeCallbacks(this.nrY);
    int i = paramInt;
    if (paramInt > this.nrS.getHeight()) {
      i = this.nrS.getHeight();
    }
    LinearLayout localLinearLayout = this.nrS;
    localLinearLayout.setTranslationY(i - localLinearLayout.getHeight());
    AppMethodBeat.o(135226);
  }
  
  public static abstract interface b
  {
    public abstract void hK(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.aj
 * JD-Core Version:    0.7.0.1
 */
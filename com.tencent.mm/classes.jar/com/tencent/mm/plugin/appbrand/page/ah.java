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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

@SuppressLint({"ViewConstructor"})
public final class ah
  extends ag
{
  private ah.b lDA;
  private boolean lDB;
  private LinearLayout lDC;
  private TextView lDD;
  private View lDE;
  private ImageView lDF;
  private ImageView lDG;
  private ImageView lDH;
  private final Runnable lDI;
  private long lDJ;
  private ah.a lDz;
  private ay lyE;
  
  public ah(Context paramContext, ay paramay)
  {
    super(paramContext);
    AppMethodBeat.i(135223);
    this.lDB = false;
    this.lDI = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(135222);
        ah.a(ah.this).setTranslationY(-ah.a(ah.this).getHeight());
        AppMethodBeat.o(135222);
      }
    };
    this.lDJ = 0L;
    this.lyE = paramay;
    this.lDC = ((LinearLayout)LayoutInflater.from(getContext()).inflate(2131493033, this, false));
    paramContext = this.lDC;
    paramay = paramay.getWrapperView();
    this.lDm = paramContext;
    this.lDn = new FrameLayout(getContext());
    this.lDn.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.lDn.addView(paramContext);
    this.lDo = new FrameLayout(getContext());
    this.lDo.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.lDo.addView(paramay);
    addView(this.lDn);
    addView(this.lDo);
    this.lDD = ((TextView)findViewById(2131296805));
    this.lDE = findViewById(2131296801);
    this.lDF = ((ImageView)findViewById(2131296802));
    this.lDG = ((ImageView)findViewById(2131296803));
    this.lDH = ((ImageView)findViewById(2131296804));
    AppMethodBeat.o(135223);
  }
  
  private void brd()
  {
    AppMethodBeat.i(135234);
    this.lDD.setTextColor(-16777216);
    this.lDD.setAlpha(0.2F);
    AppMethodBeat.o(135234);
  }
  
  private void bre()
  {
    AppMethodBeat.i(135238);
    if (this.lDF == null)
    {
      ac.w("MicroMsg.AppBrandPullDownWebView", "setupDarkLoading but mLoading0 is null, try protect");
      AppMethodBeat.o(135238);
      return;
    }
    this.lDF.setImageDrawable(e(-16777216, new float[] { 0.1F, 0.4F, 0.2F, 0.1F }));
    this.lDG.setImageDrawable(e(-16777216, new float[] { 0.1F, 0.1F, 0.4F, 0.2F }));
    this.lDH.setImageDrawable(e(-16777216, new float[] { 0.1F, 0.2F, 0.1F, 0.4F }));
    AppMethodBeat.o(135238);
  }
  
  private static AnimationDrawable e(int paramInt, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(135239);
    AnimationDrawable localAnimationDrawable = new AnimationDrawable();
    ac.i("MicroMsg.AppBrandPullDownWebView", "AnimationDrawable hash:" + localAnimationDrawable.hashCode());
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
  
  protected final boolean BP()
  {
    AppMethodBeat.i(135228);
    boolean bool = this.lyE.BP();
    AppMethodBeat.o(135228);
    return bool;
  }
  
  public final void bM(String paramString, int paramInt)
  {
    AppMethodBeat.i(135231);
    setBackgroundTextStyle(paramString);
    setPullDownBackgroundColor(paramInt);
    AppMethodBeat.o(135231);
  }
  
  protected final void bra()
  {
    AppMethodBeat.i(135224);
    if (this.lDF == null) {
      ac.e("MicroMsg.AppBrandPullDownWebView", "startLoadingAnimation, mLoading0 is null");
    }
    for (;;)
    {
      if (this.lDz != null) {
        this.lDz.bpN();
      }
      this.lDJ = System.currentTimeMillis();
      AppMethodBeat.o(135224);
      return;
      if (this.lDF.getDrawable() == null)
      {
        ac.w("MicroMsg.AppBrandPullDownWebView", "startLoadingAnimation but drawable is null, try protect");
        bre();
        brd();
      }
      ((AnimationDrawable)this.lDF.getDrawable()).start();
      ((AnimationDrawable)this.lDG.getDrawable()).start();
      ((AnimationDrawable)this.lDH.getDrawable()).start();
    }
  }
  
  protected final void brb()
  {
    AppMethodBeat.i(135225);
    if ((this.lDF == null) || (this.lDF.getDrawable() == null))
    {
      ac.w("MicroMsg.AppBrandPullDownWebView", "stopLoadingAnimation but drawable is null, try protect");
      AppMethodBeat.o(135225);
      return;
    }
    ((AnimationDrawable)this.lDF.getDrawable()).stop();
    ((AnimationDrawable)this.lDF.getDrawable()).selectDrawable(0);
    ((AnimationDrawable)this.lDG.getDrawable()).stop();
    ((AnimationDrawable)this.lDG.getDrawable()).selectDrawable(0);
    ((AnimationDrawable)this.lDH.getDrawable()).stop();
    ((AnimationDrawable)this.lDH.getDrawable()).selectDrawable(0);
    AppMethodBeat.o(135225);
  }
  
  public final void brc()
  {
    AppMethodBeat.i(135227);
    long l = System.currentTimeMillis() - this.lDJ;
    if (l < 1000L)
    {
      postDelayed(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(185196);
          ah.this.bqZ();
          AppMethodBeat.o(185196);
        }
      }, 1000L - l);
      AppMethodBeat.o(135227);
      return;
    }
    bqZ();
    AppMethodBeat.o(135227);
  }
  
  public final void gZ(boolean paramBoolean)
  {
    AppMethodBeat.i(135236);
    this.lDB = paramBoolean;
    setNeedStay(paramBoolean);
    View localView = this.lDE;
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
    int i = this.lDC.getHeight();
    AppMethodBeat.o(135229);
    return i;
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(185197);
    super.onAttachedToWindow();
    post(this.lDI);
    AppMethodBeat.o(185197);
  }
  
  public final void setBackgroundTextStyle(String paramString)
  {
    AppMethodBeat.i(135232);
    if ("light".equals(paramString))
    {
      if (this.lDF == null) {
        ac.w("MicroMsg.AppBrandPullDownWebView", "setupLightLoading but mLoading0 is null, try protect");
      }
      for (;;)
      {
        this.lDD.setTextColor(-1);
        this.lDD.setAlpha(0.4F);
        AppMethodBeat.o(135232);
        return;
        this.lDF.setImageDrawable(e(-1, new float[] { 0.2F, 0.6F, 0.4F, 0.2F }));
        this.lDG.setImageDrawable(e(-1, new float[] { 0.2F, 0.2F, 0.6F, 0.4F }));
        this.lDH.setImageDrawable(e(-1, new float[] { 0.2F, 0.4F, 0.2F, 0.6F }));
      }
    }
    if (("dark".equals(paramString)) || (!"ignore".equals(paramString)))
    {
      bre();
      brd();
    }
    AppMethodBeat.o(135232);
  }
  
  public final void setHeadViewHeight(int paramInt)
  {
    AppMethodBeat.i(135230);
    if (paramInt <= this.lDC.getHeight())
    {
      AppMethodBeat.o(135230);
      return;
    }
    this.lDC.getLayoutParams().height = paramInt;
    this.lDC.requestLayout();
    AppMethodBeat.o(135230);
  }
  
  public final void setOnPullDownListener(ah.a parama)
  {
    this.lDz = parama;
  }
  
  public final void setOnPullDownOffsetListener(ah.b paramb)
  {
    this.lDA = paramb;
  }
  
  public final void setPullDownText(String paramString)
  {
    AppMethodBeat.i(135235);
    if (bs.isNullOrNil(paramString))
    {
      this.lDD.setVisibility(8);
      AppMethodBeat.o(135235);
      return;
    }
    this.lDD.setVisibility(0);
    this.lDD.setText(paramString);
    AppMethodBeat.o(135235);
  }
  
  protected final void um(int paramInt)
  {
    AppMethodBeat.i(135226);
    if (this.lDA != null) {
      this.lDA.gt(paramInt);
    }
    if (!this.lDB)
    {
      AppMethodBeat.o(135226);
      return;
    }
    removeCallbacks(this.lDI);
    int i = paramInt;
    if (paramInt > this.lDC.getHeight()) {
      i = this.lDC.getHeight();
    }
    LinearLayout localLinearLayout = this.lDC;
    localLinearLayout.setTranslationY(i - localLinearLayout.getHeight());
    AppMethodBeat.o(135226);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ah
 * JD-Core Version:    0.7.0.1
 */
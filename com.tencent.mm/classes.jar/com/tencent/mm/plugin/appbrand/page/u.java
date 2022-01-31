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
import com.tencent.luggage.l.a.d;
import com.tencent.luggage.l.a.e;
import com.tencent.mm.sdk.platformtools.bk;

@SuppressLint({"ViewConstructor"})
public final class u
  extends t
{
  private af gTF;
  private u.a gUN;
  private u.b gUO;
  private boolean gUP = false;
  private LinearLayout gUQ;
  private TextView gUR;
  private View gUS;
  private ImageView gUT;
  private ImageView gUU;
  private ImageView gUV;
  private long gUW = 0L;
  
  public u(Context paramContext, af paramaf)
  {
    super(paramContext);
    this.gTF = paramaf;
    this.gUQ = ((LinearLayout)LayoutInflater.from(getContext()).inflate(a.e.app_brand_pulldown_webview_background, this, false));
    paramContext = this.gUQ;
    paramaf = paramaf.getWrapperView();
    this.gUB = paramContext;
    this.gUC = new FrameLayout(getContext());
    this.gUC.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.gUC.addView(paramContext);
    this.QR = paramaf;
    this.gUD = new FrameLayout(getContext());
    this.gUD.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.gUD.addView(paramaf);
    addView(this.gUC);
    addView(this.gUD);
    this.gUR = ((TextView)findViewById(a.d.app_brand_pulldown_background_text));
    this.gUS = findViewById(a.d.app_brand_pulldown_background_loading);
    this.gUT = ((ImageView)findViewById(a.d.app_brand_pulldown_background_loading0));
    this.gUU = ((ImageView)findViewById(a.d.app_brand_pulldown_background_loading1));
    this.gUV = ((ImageView)findViewById(a.d.app_brand_pulldown_background_loading2));
  }
  
  private static AnimationDrawable e(int paramInt, float[] paramArrayOfFloat)
  {
    AnimationDrawable localAnimationDrawable = new AnimationDrawable();
    localAnimationDrawable.setOneShot(false);
    localAnimationDrawable.addFrame(h(paramInt, paramArrayOfFloat[0]), 0);
    localAnimationDrawable.addFrame(h(paramInt, paramArrayOfFloat[1]), 300);
    localAnimationDrawable.addFrame(h(paramInt, paramArrayOfFloat[2]), 300);
    localAnimationDrawable.addFrame(h(paramInt, paramArrayOfFloat[3]), 300);
    return localAnimationDrawable;
  }
  
  private static Drawable h(int paramInt, float paramFloat)
  {
    ShapeDrawable localShapeDrawable = new ShapeDrawable(new OvalShape());
    localShapeDrawable.setIntrinsicHeight(32);
    localShapeDrawable.setIntrinsicWidth(32);
    localShapeDrawable.getPaint().setColor(paramInt);
    localShapeDrawable.getPaint().setAlpha((int)(255.0F * paramFloat));
    return localShapeDrawable;
  }
  
  public final void aX(String paramString, int paramInt)
  {
    setBackgroundTextStyle(paramString);
    setPullDownBackgroundColor(paramInt);
  }
  
  protected final boolean agD()
  {
    return this.gTF.agD();
  }
  
  protected final void anA()
  {
    ((AnimationDrawable)this.gUT.getDrawable()).start();
    ((AnimationDrawable)this.gUU.getDrawable()).start();
    ((AnimationDrawable)this.gUV.getDrawable()).start();
    if (this.gUN != null) {
      this.gUN.anr();
    }
    this.gUW = System.currentTimeMillis();
  }
  
  protected final void anB()
  {
    ((AnimationDrawable)this.gUT.getDrawable()).stop();
    ((AnimationDrawable)this.gUT.getDrawable()).selectDrawable(0);
    ((AnimationDrawable)this.gUU.getDrawable()).stop();
    ((AnimationDrawable)this.gUU.getDrawable()).selectDrawable(0);
    ((AnimationDrawable)this.gUV.getDrawable()).stop();
    ((AnimationDrawable)this.gUV.getDrawable()).selectDrawable(0);
  }
  
  public final void anC()
  {
    long l = System.currentTimeMillis() - this.gUW;
    if (l < 1000L)
    {
      postDelayed(new u.1(this), 1000L - l);
      return;
    }
    anz();
  }
  
  public final void cT(boolean paramBoolean)
  {
    this.gUP = paramBoolean;
    setNeedStay(paramBoolean);
    View localView = this.gUS;
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  protected final int getStayHeight()
  {
    return this.gUQ.getHeight();
  }
  
  protected final void lZ(int paramInt)
  {
    if (this.gUO != null) {
      this.gUO.kU(paramInt);
    }
    if (!this.gUP) {
      return;
    }
    int i = paramInt;
    if (paramInt > this.gUQ.getHeight()) {
      i = this.gUQ.getHeight();
    }
    this.gUQ.setTranslationY(i - this.gUQ.getHeight());
  }
  
  public final void setBackgroundTextStyle(String paramString)
  {
    if ("light".equals(paramString))
    {
      this.gUT.setImageDrawable(e(-1, new float[] { 0.2F, 0.6F, 0.4F, 0.2F }));
      this.gUU.setImageDrawable(e(-1, new float[] { 0.2F, 0.2F, 0.6F, 0.4F }));
      this.gUV.setImageDrawable(e(-1, new float[] { 0.2F, 0.4F, 0.2F, 0.6F }));
      this.gUR.setTextColor(-1);
      this.gUR.setAlpha(0.4F);
    }
    while ((!"dark".equals(paramString)) && ("ignore".equals(paramString))) {
      return;
    }
    this.gUT.setImageDrawable(e(-16777216, new float[] { 0.1F, 0.4F, 0.2F, 0.1F }));
    this.gUU.setImageDrawable(e(-16777216, new float[] { 0.1F, 0.1F, 0.4F, 0.2F }));
    this.gUV.setImageDrawable(e(-16777216, new float[] { 0.1F, 0.2F, 0.1F, 0.4F }));
    this.gUR.setTextColor(-16777216);
    this.gUR.setAlpha(0.2F);
  }
  
  public final void setHeadViewHeight(int paramInt)
  {
    if (paramInt <= this.gUQ.getHeight()) {
      return;
    }
    this.gUQ.getLayoutParams().height = paramInt;
    this.gUQ.requestLayout();
  }
  
  public final void setOnPullDownListener(u.a parama)
  {
    this.gUN = parama;
  }
  
  public final void setOnPullDownOffsetListener(u.b paramb)
  {
    this.gUO = paramb;
  }
  
  public final void setPullDownText(String paramString)
  {
    if (bk.bl(paramString))
    {
      this.gUR.setVisibility(8);
      return;
    }
    this.gUR.setVisibility(0);
    this.gUR.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.u
 * JD-Core Version:    0.7.0.1
 */
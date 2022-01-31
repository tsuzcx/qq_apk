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
import com.tencent.mm.sdk.platformtools.bo;

@SuppressLint({"ViewConstructor"})
public final class ab
  extends aa
{
  private ap iuy;
  private ab.a ixX;
  private ab.b ixY;
  private boolean ixZ;
  private LinearLayout iya;
  private TextView iyb;
  private View iyc;
  private ImageView iyd;
  private ImageView iye;
  private ImageView iyf;
  private long iyg;
  
  public ab(Context paramContext, ap paramap)
  {
    super(paramContext);
    AppMethodBeat.i(87290);
    this.ixZ = false;
    this.iyg = 0L;
    this.iuy = paramap;
    this.iya = ((LinearLayout)LayoutInflater.from(getContext()).inflate(2130968714, this, false));
    paramContext = this.iya;
    paramap = paramap.getWrapperView();
    this.ixK = paramContext;
    this.ixL = new FrameLayout(getContext());
    this.ixL.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.ixL.addView(paramContext);
    this.Qz = paramap;
    this.ixM = new FrameLayout(getContext());
    this.ixM.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.ixM.addView(paramap);
    addView(this.ixL);
    addView(this.ixM);
    this.iyb = ((TextView)findViewById(2131821341));
    this.iyc = findViewById(2131821342);
    this.iyd = ((ImageView)findViewById(2131821343));
    this.iye = ((ImageView)findViewById(2131821344));
    this.iyf = ((ImageView)findViewById(2131821345));
    AppMethodBeat.o(87290);
  }
  
  private static AnimationDrawable e(int paramInt, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(87302);
    AnimationDrawable localAnimationDrawable = new AnimationDrawable();
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.AppBrandPullDownWebView", "AnimationDrawable hash:" + localAnimationDrawable.hashCode());
    localAnimationDrawable.setOneShot(false);
    localAnimationDrawable.addFrame(j(paramInt, paramArrayOfFloat[0]), 0);
    localAnimationDrawable.addFrame(j(paramInt, paramArrayOfFloat[1]), 300);
    localAnimationDrawable.addFrame(j(paramInt, paramArrayOfFloat[2]), 300);
    localAnimationDrawable.addFrame(j(paramInt, paramArrayOfFloat[3]), 300);
    AppMethodBeat.o(87302);
    return localAnimationDrawable;
  }
  
  private static Drawable j(int paramInt, float paramFloat)
  {
    AppMethodBeat.i(87303);
    ShapeDrawable localShapeDrawable = new ShapeDrawable(new OvalShape());
    localShapeDrawable.setIntrinsicHeight(32);
    localShapeDrawable.setIntrinsicWidth(32);
    localShapeDrawable.getPaint().setColor(paramInt);
    localShapeDrawable.getPaint().setAlpha((int)(255.0F * paramFloat));
    AppMethodBeat.o(87303);
    return localShapeDrawable;
  }
  
  protected final void aJE()
  {
    AppMethodBeat.i(87291);
    ((AnimationDrawable)this.iyd.getDrawable()).start();
    ((AnimationDrawable)this.iye.getDrawable()).start();
    ((AnimationDrawable)this.iyf.getDrawable()).start();
    if (this.ixX != null) {
      this.ixX.aIH();
    }
    this.iyg = System.currentTimeMillis();
    AppMethodBeat.o(87291);
  }
  
  protected final void aJF()
  {
    AppMethodBeat.i(87292);
    ((AnimationDrawable)this.iyd.getDrawable()).stop();
    ((AnimationDrawable)this.iyd.getDrawable()).selectDrawable(0);
    ((AnimationDrawable)this.iye.getDrawable()).stop();
    ((AnimationDrawable)this.iye.getDrawable()).selectDrawable(0);
    ((AnimationDrawable)this.iyf.getDrawable()).stop();
    ((AnimationDrawable)this.iyf.getDrawable()).selectDrawable(0);
    AppMethodBeat.o(87292);
  }
  
  public final void aJG()
  {
    AppMethodBeat.i(87294);
    long l = System.currentTimeMillis() - this.iyg;
    if (l < 1000L)
    {
      postDelayed(new ab.1(this), 1000L - l);
      AppMethodBeat.o(87294);
      return;
    }
    aJD();
    AppMethodBeat.o(87294);
  }
  
  public final void bp(String paramString, int paramInt)
  {
    AppMethodBeat.i(87298);
    setBackgroundTextStyle(paramString);
    setPullDownBackgroundColor(paramInt);
    AppMethodBeat.o(87298);
  }
  
  public final void eE(boolean paramBoolean)
  {
    AppMethodBeat.i(87301);
    this.ixZ = paramBoolean;
    setNeedStay(paramBoolean);
    View localView = this.iyc;
    if (paramBoolean) {}
    for (int i = 0;; i = 4)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(87301);
      return;
    }
  }
  
  protected final int getStayHeight()
  {
    AppMethodBeat.i(87296);
    int i = this.iya.getHeight();
    AppMethodBeat.o(87296);
    return i;
  }
  
  protected final void pd(int paramInt)
  {
    AppMethodBeat.i(87293);
    if (this.ixY != null) {
      this.ixY.fr(paramInt);
    }
    if (!this.ixZ)
    {
      AppMethodBeat.o(87293);
      return;
    }
    int i = paramInt;
    if (paramInt > this.iya.getHeight()) {
      i = this.iya.getHeight();
    }
    LinearLayout localLinearLayout = this.iya;
    localLinearLayout.setTranslationY(i - localLinearLayout.getHeight());
    AppMethodBeat.o(87293);
  }
  
  public final void setBackgroundTextStyle(String paramString)
  {
    AppMethodBeat.i(87299);
    if ("light".equals(paramString))
    {
      this.iyd.setImageDrawable(e(-1, new float[] { 0.2F, 0.6F, 0.4F, 0.2F }));
      this.iye.setImageDrawable(e(-1, new float[] { 0.2F, 0.2F, 0.6F, 0.4F }));
      this.iyf.setImageDrawable(e(-1, new float[] { 0.2F, 0.4F, 0.2F, 0.6F }));
      this.iyb.setTextColor(-1);
      this.iyb.setAlpha(0.4F);
      AppMethodBeat.o(87299);
      return;
    }
    if (("dark".equals(paramString)) || (!"ignore".equals(paramString)))
    {
      this.iyd.setImageDrawable(e(-16777216, new float[] { 0.1F, 0.4F, 0.2F, 0.1F }));
      this.iye.setImageDrawable(e(-16777216, new float[] { 0.1F, 0.1F, 0.4F, 0.2F }));
      this.iyf.setImageDrawable(e(-16777216, new float[] { 0.1F, 0.2F, 0.1F, 0.4F }));
      this.iyb.setTextColor(-16777216);
      this.iyb.setAlpha(0.2F);
    }
    AppMethodBeat.o(87299);
  }
  
  public final void setHeadViewHeight(int paramInt)
  {
    AppMethodBeat.i(87297);
    if (paramInt <= this.iya.getHeight())
    {
      AppMethodBeat.o(87297);
      return;
    }
    this.iya.getLayoutParams().height = paramInt;
    this.iya.requestLayout();
    AppMethodBeat.o(87297);
  }
  
  public final void setOnPullDownListener(ab.a parama)
  {
    this.ixX = parama;
  }
  
  public final void setOnPullDownOffsetListener(ab.b paramb)
  {
    this.ixY = paramb;
  }
  
  public final void setPullDownText(String paramString)
  {
    AppMethodBeat.i(87300);
    if (bo.isNullOrNil(paramString))
    {
      this.iyb.setVisibility(8);
      AppMethodBeat.o(87300);
      return;
    }
    this.iyb.setVisibility(0);
    this.iyb.setText(paramString);
    AppMethodBeat.o(87300);
  }
  
  protected final boolean vq()
  {
    AppMethodBeat.i(87295);
    boolean bool = this.iuy.vq();
    AppMethodBeat.o(87295);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.ab
 * JD-Core Version:    0.7.0.1
 */
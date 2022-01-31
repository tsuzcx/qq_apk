package com.tencent.mm.plugin.appbrand.ui;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build.VERSION;
import android.support.v4.graphics.drawable.d;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.plugin.appbrand.config.a.a.b;
import com.tencent.mm.plugin.appbrand.i;
import com.tencent.mm.plugin.appbrand.launching.j;
import com.tencent.mm.plugin.appbrand.widget.actionbar.f.a;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;
import java.lang.ref.WeakReference;

@SuppressLint({"ViewConstructor"})
public final class k
  extends com.tencent.mm.ui.statusbar.b
  implements j, r
{
  private ImageView dV;
  private i gRG;
  private ThreeDotsLoadingView iJJ;
  private TextView iLU;
  private LinearLayout iLV;
  private com.tencent.mm.plugin.appbrand.widget.actionbar.b iLW;
  private TextView iLZ;
  private View iPp;
  private View iPq;
  
  public k(Context paramContext, i parami)
  {
    super(paramContext);
    AppMethodBeat.i(102326);
    this.gRG = parami;
    setClickable(true);
    setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    LayoutInflater.from(getContext()).inflate(2130968742, this);
    this.dV = ((ImageView)findViewById(2131821423));
    paramContext = this.dV;
    if (t.fqk != null)
    {
      parami = (Bitmap)t.fqk.get();
      if ((parami != null) && (!parami.isRecycled())) {}
    }
    else
    {
      t.fqk = new WeakReference(BitmapFactory.decodeResource(ah.getResources(), 2130839617));
    }
    parami = d.a(ah.getResources(), (Bitmap)t.fqk.get());
    parami.cS();
    paramContext.setImageDrawable(parami);
    this.iLU = ((TextView)findViewById(2131821424));
    this.iJJ = ((ThreeDotsLoadingView)findViewById(2131821425));
    this.iLV = ((LinearLayout)findViewById(2131821420));
    this.iPq = findViewById(2131821422);
    this.iPp = findViewById(2131821421);
    this.iLZ = ((TextView)findViewById(2131821412));
    this.iLW = f.a.dl(getContext());
    this.iLV.addView(this.iLW.getActionView());
    int i = com.tencent.mm.plugin.appbrand.widget.b.di(getContext());
    this.iLU.getLayoutParams().height = i;
    K(-1, true);
    this.iLW.setFullscreenMode(true);
    this.iLW.setForegroundStyle("black");
    paramContext = new k.2(this);
    this.iLW.setCloseButtonClickListener(paramContext);
    this.iLW.setBackButtonClickListener(paramContext);
    this.iJJ.dOV();
    AppMethodBeat.o(102326);
  }
  
  private void a(Configuration paramConfiguration)
  {
    AppMethodBeat.i(140984);
    Object localObject = com.tencent.mm.sdk.f.a.hr(getContext());
    if (paramConfiguration.orientation == 2) {}
    for (int i = 1; (i != 0) && (localObject != null) && (Build.VERSION.SDK_INT >= 24) && (((Activity)localObject).isInMultiWindowMode()) && (((Activity)localObject).getRequestedOrientation() == 1); i = 0)
    {
      AppMethodBeat.o(140984);
      return;
    }
    if (localObject != null)
    {
      paramConfiguration = ((Activity)localObject).getWindow();
      localObject = paramConfiguration.getDecorView();
      if (i != 0)
      {
        paramConfiguration.addFlags(1024);
        ((View)localObject).setSystemUiVisibility(((View)localObject).getSystemUiVisibility() | 0x4 | 0x100);
        AppMethodBeat.o(140984);
        return;
      }
      paramConfiguration.clearFlags(1024);
      ((View)localObject).setSystemUiVisibility(((View)localObject).getSystemUiVisibility() & 0xFFFFFFFB);
    }
    AppMethodBeat.o(140984);
  }
  
  public final void aHA()
  {
    AppMethodBeat.i(102328);
    post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(102323);
        Object localObject = k.this.getParent();
        if (!(localObject instanceof ViewGroup))
        {
          AppMethodBeat.o(102323);
          return;
        }
        ValueAnimator localValueAnimator = ValueAnimator.ofInt(new int[] { 255, 0 });
        localValueAnimator.addUpdateListener(new k.1.1(this, (ViewParent)localObject));
        localValueAnimator.setStartDelay(Math.round((float)localValueAnimator.getDuration() * 0.8F));
        localValueAnimator.setDuration(Math.round((float)localValueAnimator.getDuration() * 0.2F));
        localValueAnimator.setInterpolator(new android.support.v4.view.b.a());
        localValueAnimator.start();
        localObject = ValueAnimator.ofFloat(new float[] { 1.0F, 0.0F });
        ((ValueAnimator)localObject).setDuration(Math.round((float)((ValueAnimator)localObject).getDuration() * 0.8F));
        ((ValueAnimator)localObject).addUpdateListener(new k.1.2(this));
        ((ValueAnimator)localObject).setInterpolator(new android.support.v4.view.b.b());
        ((ValueAnimator)localObject).start();
        AppMethodBeat.o(102323);
      }
    });
    AppMethodBeat.o(102328);
  }
  
  public final void aHB()
  {
    AppMethodBeat.i(102329);
    this.iLW.setNavHidden(true);
    AppMethodBeat.o(102329);
  }
  
  public final void cD(String paramString1, String paramString2)
  {
    AppMethodBeat.i(102327);
    com.tencent.mm.modelappbrand.a.b.acD().a(this.dV, paramString1, null, f.fqU);
    this.iLU.setText(paramString2);
    AppMethodBeat.o(102327);
  }
  
  public final View getView()
  {
    return this;
  }
  
  public final boolean hasOverlappingRendering()
  {
    return false;
  }
  
  public final void ng(int paramInt)
  {
    AppMethodBeat.i(102331);
    this.gRG.k(new k.3(this, paramInt), 0L);
    AppMethodBeat.o(102331);
  }
  
  protected final void onAttachedToWindow()
  {
    AppMethodBeat.i(102330);
    super.onAttachedToWindow();
    try
    {
      a(getContext().getResources().getConfiguration());
      try
      {
        label24:
        Activity localActivity = com.tencent.mm.sdk.f.a.hr(getContext());
        if (localActivity == null)
        {
          AppMethodBeat.o(102330);
          return;
        }
        if (getContext().getResources().getConfiguration().orientation == 1)
        {
          com.tencent.mm.plugin.appbrand.config.a.a.s(localActivity).a(a.b.hkD, null);
          AppMethodBeat.o(102330);
          return;
        }
      }
      catch (Exception localException1)
      {
        AppMethodBeat.o(102330);
        return;
      }
      com.tencent.mm.plugin.appbrand.config.a.a.s(localException1).a(a.b.hkF, null);
      AppMethodBeat.o(102330);
      return;
    }
    catch (Exception localException2)
    {
      break label24;
    }
  }
  
  protected final void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(140983);
    super.onConfigurationChanged(paramConfiguration);
    try
    {
      a(paramConfiguration);
      AppMethodBeat.o(140983);
      return;
    }
    catch (Exception paramConfiguration)
    {
      AppMethodBeat.o(140983);
    }
  }
  
  public final void setProgress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.k
 * JD-Core Version:    0.7.0.1
 */
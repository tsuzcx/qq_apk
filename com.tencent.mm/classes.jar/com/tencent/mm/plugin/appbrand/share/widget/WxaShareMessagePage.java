package com.tencent.mm.plugin.appbrand.share.widget;

import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.p.a;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.modelappbrand.k;
import com.tencent.mm.modelappbrand.k.a;
import com.tencent.mm.modelappbrand.k.b;
import com.tencent.mm.modelappbrand.k.c;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.mm.plugin.appbrand.z.m;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

public class WxaShareMessagePage
  extends LinearLayout
  implements LifecycleObserver, b.k
{
  public ImageView kOn;
  public ImageView lWR;
  IPCDynamicPageView lWS;
  ThreeDotsLoadingView lWT;
  public RelativeLayout lWU;
  ImageView lWV;
  MMSwitchBtn lWW;
  public ImageView lWX;
  public TextView lWY;
  k.b lWZ;
  public k.c lXa;
  public View lXb;
  public boolean lXc;
  private ImageView lXd;
  TextView lfN;
  
  public WxaShareMessagePage(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(48339);
    init(paramContext);
    AppMethodBeat.o(48339);
  }
  
  public WxaShareMessagePage(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(48340);
    init(paramContext);
    AppMethodBeat.o(48340);
  }
  
  public WxaShareMessagePage(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(48341);
    init(paramContext);
    AppMethodBeat.o(48341);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(48342);
    View localView = View.inflate(paramContext, 2131496122, this);
    this.lXb = localView.findViewById(2131300240);
    this.kOn = ((ImageView)localView.findViewById(2131298824));
    this.lWR = ((ImageView)localView.findViewById(2131299519));
    this.lWS = ((IPCDynamicPageView)localView.findViewById(2131306996));
    this.lfN = ((TextView)localView.findViewById(2131305948));
    this.lXd = ((ImageView)localView.findViewById(2131306344));
    this.lWT = ((ThreeDotsLoadingView)localView.findViewById(2131301514));
    paramContext = LayoutInflater.from(paramContext).inflate(2131494554, (ViewGroup)localView, false);
    this.lWX = ((ImageView)paramContext.findViewById(2131304748));
    this.lWY = ((TextView)paramContext.findViewById(2131304749));
    this.lWU = ((RelativeLayout)localView.findViewById(2131305960));
    this.lWV = ((ImageView)localView.findViewById(2131301043));
    this.lWW = ((MMSwitchBtn)localView.findViewById(2131305959));
    ((ViewGroup)localView.findViewById(2131298736)).addView(paramContext);
    setGravity(17);
    this.lWV.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(180364);
        if (WxaShareMessagePage.this.lXa != null) {
          WxaShareMessagePage.this.lXa.aAF();
        }
        AppMethodBeat.o(180364);
      }
    });
    setTag(2131296837, Boolean.FALSE);
    this.lWW.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(180365);
        WxaShareMessagePage.this.setTag(2131296837, Boolean.valueOf(paramAnonymousBoolean));
        if (WxaShareMessagePage.this.lXa != null) {
          WxaShareMessagePage.this.lXa.ex(paramAnonymousBoolean);
        }
        AppMethodBeat.o(180365);
      }
    });
    AppMethodBeat.o(48342);
  }
  
  public final String Ap()
  {
    AppMethodBeat.i(48345);
    String str = m.cE(this);
    AppMethodBeat.o(48345);
    return str;
  }
  
  public final void E(Bitmap paramBitmap)
  {
    AppMethodBeat.i(48343);
    this.lWT.setVisibility(4);
    this.lWT.fuX();
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      this.kOn.setImageBitmap(paramBitmap);
      this.lWR.setVisibility(4);
    }
    for (;;)
    {
      if (this.lWZ != null) {
        this.lWZ.om(0);
      }
      AppMethodBeat.o(48343);
      return;
      this.kOn.setImageBitmap(null);
      this.lWR.setVisibility(0);
    }
  }
  
  public final void aBa() {}
  
  public ImageView getCoverImageView()
  {
    return this.kOn;
  }
  
  public ImageView getErrorImageView()
  {
    return this.lWR;
  }
  
  public ThreeDotsLoadingView getLoadingView()
  {
    return this.lWT;
  }
  
  public ImageView getVideoIcon()
  {
    return this.lXd;
  }
  
  public int getWidgetHeight()
  {
    AppMethodBeat.i(48350);
    int i = com.tencent.mm.plugin.appbrand.z.g.ve(180);
    AppMethodBeat.o(48350);
    return i;
  }
  
  public IPCDynamicPageView getWidgetPageView()
  {
    return this.lWS;
  }
  
  public int getWidgetWidth()
  {
    AppMethodBeat.i(48349);
    int i = com.tencent.mm.plugin.appbrand.z.g.ve(224);
    AppMethodBeat.o(48349);
    return i;
  }
  
  public final void of()
  {
    AppMethodBeat.i(48344);
    this.lWT.setVisibility(4);
    this.lWT.fuX();
    this.kOn.setImageBitmap(null);
    this.lWR.setVisibility(0);
    if (this.lWZ != null) {
      this.lWZ.om(1);
    }
    AppMethodBeat.o(48344);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public void onActivityDestroyed()
  {
    AppMethodBeat.i(186955);
    this.lWT.fuX();
    b.aAS().a(this);
    AppMethodBeat.o(186955);
  }
  
  public void setImageData(Bitmap paramBitmap)
  {
    AppMethodBeat.i(48347);
    this.kOn.setVisibility(0);
    this.lWT.setVisibility(4);
    this.lWR.setVisibility(4);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      if (this.lXc)
      {
        this.kOn.setImageBitmap(paramBitmap);
        AppMethodBeat.o(48347);
        return;
      }
      b.h localh = ((k)com.tencent.mm.kernel.g.ab(k.class)).aAE();
      this.kOn.setImageBitmap(localh.F(paramBitmap));
      AppMethodBeat.o(48347);
      return;
    }
    this.kOn.setImageBitmap(null);
    AppMethodBeat.o(48347);
  }
  
  public void setImageUrl(String paramString)
  {
    AppMethodBeat.i(48346);
    this.lWT.setVisibility(0);
    this.lWT.fuW();
    this.lWR.setVisibility(4);
    this.kOn.setVisibility(0);
    if (this.lXc)
    {
      b.aAS().a(this, paramString, null, ((k)com.tencent.mm.kernel.g.ab(k.class)).a(112, 90, k.a.hsa));
      AppMethodBeat.o(48346);
      return;
    }
    b.aAS().a(this, paramString, null, ((k)com.tencent.mm.kernel.g.ab(k.class)).dc(112, 90));
    AppMethodBeat.o(48346);
  }
  
  public void setOnLoadImageResult(k.b paramb)
  {
    this.lWZ = paramb;
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(48348);
    this.lfN.setText(paramString);
    AppMethodBeat.o(48348);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.share.widget.WxaShareMessagePage
 * JD-Core Version:    0.7.0.1
 */
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
import com.tencent.mm.aw.p.a;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.modelappbrand.k;
import com.tencent.mm.modelappbrand.k.a;
import com.tencent.mm.modelappbrand.k.b;
import com.tencent.mm.modelappbrand.k.c;
import com.tencent.mm.plugin.appbrand.aa.m;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

public class WxaShareMessagePage
  extends LinearLayout
  implements LifecycleObserver, b.k
{
  TextView kEu;
  public ImageView kmV;
  public ImageView luX;
  IPCDynamicPageView luY;
  ThreeDotsLoadingView luZ;
  public RelativeLayout lva;
  ImageView lvb;
  MMSwitchBtn lvc;
  public ImageView lvd;
  public TextView lve;
  k.b lvf;
  public k.c lvg;
  public View lvh;
  public boolean lvi;
  private ImageView lvj;
  
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
    this.lvh = localView.findViewById(2131300240);
    this.kmV = ((ImageView)localView.findViewById(2131298824));
    this.luX = ((ImageView)localView.findViewById(2131299519));
    this.luY = ((IPCDynamicPageView)localView.findViewById(2131306996));
    this.kEu = ((TextView)localView.findViewById(2131305948));
    this.lvj = ((ImageView)localView.findViewById(2131306344));
    this.luZ = ((ThreeDotsLoadingView)localView.findViewById(2131301514));
    paramContext = LayoutInflater.from(paramContext).inflate(2131494554, (ViewGroup)localView, false);
    this.lvd = ((ImageView)paramContext.findViewById(2131304748));
    this.lve = ((TextView)paramContext.findViewById(2131304749));
    this.lva = ((RelativeLayout)localView.findViewById(2131305960));
    this.lvb = ((ImageView)localView.findViewById(2131301043));
    this.lvc = ((MMSwitchBtn)localView.findViewById(2131305959));
    ((ViewGroup)localView.findViewById(2131298736)).addView(paramContext);
    setGravity(17);
    this.lvb.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(180364);
        if (WxaShareMessagePage.this.lvg != null) {
          WxaShareMessagePage.this.lvg.atO();
        }
        AppMethodBeat.o(180364);
      }
    });
    setTag(2131296837, Boolean.FALSE);
    this.lvc.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(180365);
        WxaShareMessagePage.this.setTag(2131296837, Boolean.valueOf(paramAnonymousBoolean));
        if (WxaShareMessagePage.this.lvg != null) {
          WxaShareMessagePage.this.lvg.ec(paramAnonymousBoolean);
        }
        AppMethodBeat.o(180365);
      }
    });
    AppMethodBeat.o(48342);
  }
  
  public final String AL()
  {
    AppMethodBeat.i(48345);
    String str = m.cF(this);
    AppMethodBeat.o(48345);
    return str;
  }
  
  public final void E(Bitmap paramBitmap)
  {
    AppMethodBeat.i(48343);
    this.luZ.setVisibility(4);
    this.luZ.ffc();
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      this.kmV.setImageBitmap(paramBitmap);
      this.luX.setVisibility(4);
    }
    for (;;)
    {
      if (this.lvf != null) {
        this.lvf.ny(0);
      }
      AppMethodBeat.o(48343);
      return;
      this.kmV.setImageBitmap(null);
      this.luX.setVisibility(0);
    }
  }
  
  public final void auj() {}
  
  public ImageView getCoverImageView()
  {
    return this.kmV;
  }
  
  public ImageView getErrorImageView()
  {
    return this.luX;
  }
  
  public ThreeDotsLoadingView getLoadingView()
  {
    return this.luZ;
  }
  
  public ImageView getVideoIcon()
  {
    return this.lvj;
  }
  
  public int getWidgetHeight()
  {
    AppMethodBeat.i(48350);
    int i = com.tencent.mm.plugin.appbrand.aa.g.um(180);
    AppMethodBeat.o(48350);
    return i;
  }
  
  public IPCDynamicPageView getWidgetPageView()
  {
    return this.luY;
  }
  
  public int getWidgetWidth()
  {
    AppMethodBeat.i(48349);
    int i = com.tencent.mm.plugin.appbrand.aa.g.um(224);
    AppMethodBeat.o(48349);
    return i;
  }
  
  public final void nV()
  {
    AppMethodBeat.i(48344);
    this.luZ.setVisibility(4);
    this.luZ.ffc();
    this.kmV.setImageBitmap(null);
    this.luX.setVisibility(0);
    if (this.lvf != null) {
      this.lvf.ny(1);
    }
    AppMethodBeat.o(48344);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public void onActivityDestroyed()
  {
    AppMethodBeat.i(196111);
    this.luZ.ffc();
    b.aub().a(this);
    AppMethodBeat.o(196111);
  }
  
  public void setImageData(Bitmap paramBitmap)
  {
    AppMethodBeat.i(48347);
    this.kmV.setVisibility(0);
    this.luZ.setVisibility(4);
    this.luX.setVisibility(4);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      if (this.lvi)
      {
        this.kmV.setImageBitmap(paramBitmap);
        AppMethodBeat.o(48347);
        return;
      }
      b.h localh = ((k)com.tencent.mm.kernel.g.ab(k.class)).atN();
      this.kmV.setImageBitmap(localh.F(paramBitmap));
      AppMethodBeat.o(48347);
      return;
    }
    this.kmV.setImageBitmap(null);
    AppMethodBeat.o(48347);
  }
  
  public void setImageUrl(String paramString)
  {
    AppMethodBeat.i(48346);
    this.luZ.setVisibility(0);
    this.luZ.ffb();
    this.luX.setVisibility(4);
    this.kmV.setVisibility(0);
    if (this.lvi)
    {
      b.aub().a(this, paramString, null, ((k)com.tencent.mm.kernel.g.ab(k.class)).a(112, 90, k.a.gRA));
      AppMethodBeat.o(48346);
      return;
    }
    b.aub().a(this, paramString, null, ((k)com.tencent.mm.kernel.g.ab(k.class)).dc(112, 90));
    AppMethodBeat.o(48346);
  }
  
  public void setOnLoadImageResult(k.b paramb)
  {
    this.lvf = paramb;
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(48348);
    this.kEu.setText(paramString);
    AppMethodBeat.o(48348);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.share.widget.WxaShareMessagePage
 * JD-Core Version:    0.7.0.1
 */
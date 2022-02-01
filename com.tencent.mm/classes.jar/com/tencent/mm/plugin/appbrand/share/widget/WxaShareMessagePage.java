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
import com.tencent.mm.av.r.a;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.modelappbrand.k;
import com.tencent.mm.modelappbrand.k.a;
import com.tencent.mm.modelappbrand.k.b;
import com.tencent.mm.modelappbrand.k.c;
import com.tencent.mm.plugin.appbrand.ac.n;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

public class WxaShareMessagePage
  extends LinearLayout
  implements LifecycleObserver, b.k
{
  TextView mPa;
  public ImageView mvU;
  public ImageView nNj;
  IPCDynamicPageView nNk;
  ThreeDotsLoadingView nNl;
  public RelativeLayout nNm;
  ImageView nNn;
  MMSwitchBtn nNo;
  public ImageView nNp;
  public TextView nNq;
  k.b nNr;
  public k.c nNs;
  public View nNt;
  public boolean nNu;
  private ImageView nNv;
  
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
    View localView = View.inflate(paramContext, 2131497117, this);
    this.nNt = localView.findViewById(2131301717);
    this.mvU = ((ImageView)localView.findViewById(2131299289));
    this.nNj = ((ImageView)localView.findViewById(2131300157));
    this.nNk = ((IPCDynamicPageView)localView.findViewById(2131310508));
    this.mPa = ((TextView)localView.findViewById(2131309249));
    this.nNv = ((ImageView)localView.findViewById(2131309770));
    this.nNl = ((ThreeDotsLoadingView)localView.findViewById(2131303719));
    paramContext = LayoutInflater.from(paramContext).inflate(2131495164, (ViewGroup)localView, false);
    this.nNp = ((ImageView)paramContext.findViewById(2131307817));
    this.nNq = ((TextView)paramContext.findViewById(2131307818));
    this.nNm = ((RelativeLayout)localView.findViewById(2131309264));
    this.nNn = ((ImageView)localView.findViewById(2131302696));
    this.nNo = ((MMSwitchBtn)localView.findViewById(2131309263));
    ((ViewGroup)localView.findViewById(2131299174)).addView(paramContext);
    setGravity(17);
    this.nNn.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(180364);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/appbrand/share/widget/WxaShareMessagePage$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (WxaShareMessagePage.this.nNs != null) {
          WxaShareMessagePage.this.nNs.aXL();
        }
        a.a(this, "com/tencent/mm/plugin/appbrand/share/widget/WxaShareMessagePage$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(180364);
      }
    });
    setTag(2131296929, Boolean.FALSE);
    this.nNo.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(180365);
        WxaShareMessagePage.this.setTag(2131296929, Boolean.valueOf(paramAnonymousBoolean));
        if (WxaShareMessagePage.this.nNs != null) {
          WxaShareMessagePage.this.nNs.ft(paramAnonymousBoolean);
        }
        AppMethodBeat.o(180365);
      }
    });
    AppMethodBeat.o(48342);
  }
  
  public final void I(Bitmap paramBitmap)
  {
    AppMethodBeat.i(48343);
    this.nNl.setVisibility(4);
    this.nNl.gZi();
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      this.mvU.setImageBitmap(paramBitmap);
      this.nNj.setVisibility(4);
    }
    for (;;)
    {
      if (this.nNr != null) {
        this.nNr.sD(0);
      }
      AppMethodBeat.o(48343);
      return;
      this.mvU.setImageBitmap(null);
      this.nNj.setVisibility(0);
    }
  }
  
  public final String Lb()
  {
    AppMethodBeat.i(48345);
    String str = n.cO(this);
    AppMethodBeat.o(48345);
    return str;
  }
  
  public final void aYg() {}
  
  public ImageView getCoverImageView()
  {
    return this.mvU;
  }
  
  public ImageView getErrorImageView()
  {
    return this.nNj;
  }
  
  public ThreeDotsLoadingView getLoadingView()
  {
    return this.nNl;
  }
  
  public ImageView getVideoIcon()
  {
    return this.nNv;
  }
  
  public int getWidgetHeight()
  {
    AppMethodBeat.i(48350);
    int i = com.tencent.mm.plugin.appbrand.ac.g.zD(180);
    AppMethodBeat.o(48350);
    return i;
  }
  
  public IPCDynamicPageView getWidgetPageView()
  {
    return this.nNk;
  }
  
  public int getWidgetWidth()
  {
    AppMethodBeat.i(48349);
    int i = com.tencent.mm.plugin.appbrand.ac.g.zD(224);
    AppMethodBeat.o(48349);
    return i;
  }
  
  public final void oD()
  {
    AppMethodBeat.i(48344);
    this.nNl.setVisibility(4);
    this.nNl.gZi();
    this.mvU.setImageBitmap(null);
    this.nNj.setVisibility(0);
    if (this.nNr != null) {
      this.nNr.sD(1);
    }
    AppMethodBeat.o(48344);
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public void onActivityDestroyed()
  {
    AppMethodBeat.i(227433);
    this.nNl.gZi();
    com.tencent.mm.modelappbrand.a.b.aXY().a(this);
    AppMethodBeat.o(227433);
  }
  
  public void setImageData(Bitmap paramBitmap)
  {
    AppMethodBeat.i(48347);
    this.mvU.setVisibility(0);
    this.nNl.setVisibility(4);
    this.nNj.setVisibility(4);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      if (this.nNu)
      {
        this.mvU.setImageBitmap(paramBitmap);
        AppMethodBeat.o(48347);
        return;
      }
      b.h localh = ((k)com.tencent.mm.kernel.g.af(k.class)).aXK();
      this.mvU.setImageBitmap(localh.J(paramBitmap));
      AppMethodBeat.o(48347);
      return;
    }
    this.mvU.setImageBitmap(null);
    AppMethodBeat.o(48347);
  }
  
  public void setImageUrl(String paramString)
  {
    AppMethodBeat.i(48346);
    this.nNl.setVisibility(0);
    this.nNl.gZh();
    this.nNj.setVisibility(4);
    this.mvU.setVisibility(0);
    if (this.nNu)
    {
      com.tencent.mm.modelappbrand.a.b.aXY().a(this, paramString, null, ((k)com.tencent.mm.kernel.g.af(k.class)).a(112, 90, k.a.iIr));
      AppMethodBeat.o(48346);
      return;
    }
    com.tencent.mm.modelappbrand.a.b.aXY().a(this, paramString, null, ((k)com.tencent.mm.kernel.g.af(k.class)).jdMethod_do(112, 90));
    AppMethodBeat.o(48346);
  }
  
  public void setOnLoadImageResult(k.b paramb)
  {
    this.nNr = paramb;
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(48348);
    this.mPa.setText(paramString);
    AppMethodBeat.o(48348);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.share.widget.WxaShareMessagePage
 * JD-Core Version:    0.7.0.1
 */
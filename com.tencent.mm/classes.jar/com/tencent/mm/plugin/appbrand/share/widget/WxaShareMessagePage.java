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
import com.tencent.mm.aw.r.a;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.modelappbrand.k;
import com.tencent.mm.modelappbrand.k.a;
import com.tencent.mm.modelappbrand.k.b;
import com.tencent.mm.modelappbrand.k.c;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.mm.plugin.appbrand.z.n;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

public class WxaShareMessagePage
  extends LinearLayout
  implements LifecycleObserver, b.k
{
  TextView lCL;
  public ImageView lkQ;
  public ImageView mwG;
  IPCDynamicPageView mwH;
  ThreeDotsLoadingView mwI;
  public RelativeLayout mwJ;
  ImageView mwK;
  MMSwitchBtn mwL;
  public ImageView mwM;
  public TextView mwN;
  k.b mwO;
  public k.c mwP;
  public View mwQ;
  public boolean mwR;
  private ImageView mwS;
  
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
    this.mwQ = localView.findViewById(2131300240);
    this.lkQ = ((ImageView)localView.findViewById(2131298824));
    this.mwG = ((ImageView)localView.findViewById(2131299519));
    this.mwH = ((IPCDynamicPageView)localView.findViewById(2131306996));
    this.lCL = ((TextView)localView.findViewById(2131305948));
    this.mwS = ((ImageView)localView.findViewById(2131306344));
    this.mwI = ((ThreeDotsLoadingView)localView.findViewById(2131301514));
    paramContext = LayoutInflater.from(paramContext).inflate(2131494554, (ViewGroup)localView, false);
    this.mwM = ((ImageView)paramContext.findViewById(2131304748));
    this.mwN = ((TextView)paramContext.findViewById(2131304749));
    this.mwJ = ((RelativeLayout)localView.findViewById(2131305960));
    this.mwK = ((ImageView)localView.findViewById(2131301043));
    this.mwL = ((MMSwitchBtn)localView.findViewById(2131305959));
    ((ViewGroup)localView.findViewById(2131298736)).addView(paramContext);
    setGravity(17);
    this.mwK.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(180364);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/appbrand/share/widget/WxaShareMessagePage$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (WxaShareMessagePage.this.mwP != null) {
          WxaShareMessagePage.this.mwP.aDI();
        }
        a.a(this, "com/tencent/mm/plugin/appbrand/share/widget/WxaShareMessagePage$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(180364);
      }
    });
    setTag(2131296837, Boolean.FALSE);
    this.mwL.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(180365);
        WxaShareMessagePage.this.setTag(2131296837, Boolean.valueOf(paramAnonymousBoolean));
        if (WxaShareMessagePage.this.mwP != null) {
          WxaShareMessagePage.this.mwP.ez(paramAnonymousBoolean);
        }
        AppMethodBeat.o(180365);
      }
    });
    AppMethodBeat.o(48342);
  }
  
  public final String BM()
  {
    AppMethodBeat.i(48345);
    String str = n.cG(this);
    AppMethodBeat.o(48345);
    return str;
  }
  
  public final void E(Bitmap paramBitmap)
  {
    AppMethodBeat.i(48343);
    this.mwI.setVisibility(4);
    this.mwI.fLK();
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      this.lkQ.setImageBitmap(paramBitmap);
      this.mwG.setVisibility(4);
    }
    for (;;)
    {
      if (this.mwO != null) {
        this.mwO.oM(0);
      }
      AppMethodBeat.o(48343);
      return;
      this.lkQ.setImageBitmap(null);
      this.mwG.setVisibility(0);
    }
  }
  
  public final void aEd() {}
  
  public ImageView getCoverImageView()
  {
    return this.lkQ;
  }
  
  public ImageView getErrorImageView()
  {
    return this.mwG;
  }
  
  public ThreeDotsLoadingView getLoadingView()
  {
    return this.mwI;
  }
  
  public ImageView getVideoIcon()
  {
    return this.mwS;
  }
  
  public int getWidgetHeight()
  {
    AppMethodBeat.i(48350);
    int i = com.tencent.mm.plugin.appbrand.z.g.vJ(180);
    AppMethodBeat.o(48350);
    return i;
  }
  
  public IPCDynamicPageView getWidgetPageView()
  {
    return this.mwH;
  }
  
  public int getWidgetWidth()
  {
    AppMethodBeat.i(48349);
    int i = com.tencent.mm.plugin.appbrand.z.g.vJ(224);
    AppMethodBeat.o(48349);
    return i;
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public void onActivityDestroyed()
  {
    AppMethodBeat.i(188757);
    this.mwI.fLK();
    com.tencent.mm.modelappbrand.a.b.aDV().a(this);
    AppMethodBeat.o(188757);
  }
  
  public final void ox()
  {
    AppMethodBeat.i(48344);
    this.mwI.setVisibility(4);
    this.mwI.fLK();
    this.lkQ.setImageBitmap(null);
    this.mwG.setVisibility(0);
    if (this.mwO != null) {
      this.mwO.oM(1);
    }
    AppMethodBeat.o(48344);
  }
  
  public void setImageData(Bitmap paramBitmap)
  {
    AppMethodBeat.i(48347);
    this.lkQ.setVisibility(0);
    this.mwI.setVisibility(4);
    this.mwG.setVisibility(4);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      if (this.mwR)
      {
        this.lkQ.setImageBitmap(paramBitmap);
        AppMethodBeat.o(48347);
        return;
      }
      b.h localh = ((k)com.tencent.mm.kernel.g.ab(k.class)).aDH();
      this.lkQ.setImageBitmap(localh.F(paramBitmap));
      AppMethodBeat.o(48347);
      return;
    }
    this.lkQ.setImageBitmap(null);
    AppMethodBeat.o(48347);
  }
  
  public void setImageUrl(String paramString)
  {
    AppMethodBeat.i(48346);
    this.mwI.setVisibility(0);
    this.mwI.fLJ();
    this.mwG.setVisibility(4);
    this.lkQ.setVisibility(0);
    if (this.mwR)
    {
      com.tencent.mm.modelappbrand.a.b.aDV().a(this, paramString, null, ((k)com.tencent.mm.kernel.g.ab(k.class)).a(112, 90, k.a.hKs));
      AppMethodBeat.o(48346);
      return;
    }
    com.tencent.mm.modelappbrand.a.b.aDV().a(this, paramString, null, ((k)com.tencent.mm.kernel.g.ab(k.class)).de(112, 90));
    AppMethodBeat.o(48346);
  }
  
  public void setOnLoadImageResult(k.b paramb)
  {
    this.mwO = paramb;
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(48348);
    this.lCL.setText(paramString);
    AppMethodBeat.o(48348);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.share.widget.WxaShareMessagePage
 * JD-Core Version:    0.7.0.1
 */
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
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.mm.plugin.appbrand.y.n;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

public class WxaShareMessagePage
  extends LinearLayout
  implements LifecycleObserver, b.k
{
  TextView lHk;
  public ImageView lpo;
  public ImageView mBD;
  IPCDynamicPageView mBE;
  ThreeDotsLoadingView mBF;
  public RelativeLayout mBG;
  ImageView mBH;
  MMSwitchBtn mBI;
  public ImageView mBJ;
  public TextView mBK;
  k.b mBL;
  public k.c mBM;
  public View mBN;
  public boolean mBO;
  private ImageView mBP;
  
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
    this.mBN = localView.findViewById(2131300240);
    this.lpo = ((ImageView)localView.findViewById(2131298824));
    this.mBD = ((ImageView)localView.findViewById(2131299519));
    this.mBE = ((IPCDynamicPageView)localView.findViewById(2131306996));
    this.lHk = ((TextView)localView.findViewById(2131305948));
    this.mBP = ((ImageView)localView.findViewById(2131306344));
    this.mBF = ((ThreeDotsLoadingView)localView.findViewById(2131301514));
    paramContext = LayoutInflater.from(paramContext).inflate(2131494554, (ViewGroup)localView, false);
    this.mBJ = ((ImageView)paramContext.findViewById(2131304748));
    this.mBK = ((TextView)paramContext.findViewById(2131304749));
    this.mBG = ((RelativeLayout)localView.findViewById(2131305960));
    this.mBH = ((ImageView)localView.findViewById(2131301043));
    this.mBI = ((MMSwitchBtn)localView.findViewById(2131305959));
    ((ViewGroup)localView.findViewById(2131298736)).addView(paramContext);
    setGravity(17);
    this.mBH.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(180364);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/appbrand/share/widget/WxaShareMessagePage$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (WxaShareMessagePage.this.mBM != null) {
          WxaShareMessagePage.this.mBM.aDY();
        }
        a.a(this, "com/tencent/mm/plugin/appbrand/share/widget/WxaShareMessagePage$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(180364);
      }
    });
    setTag(2131296837, Boolean.FALSE);
    this.mBI.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(180365);
        WxaShareMessagePage.this.setTag(2131296837, Boolean.valueOf(paramAnonymousBoolean));
        if (WxaShareMessagePage.this.mBM != null) {
          WxaShareMessagePage.this.mBM.eB(paramAnonymousBoolean);
        }
        AppMethodBeat.o(180365);
      }
    });
    AppMethodBeat.o(48342);
  }
  
  public final String BN()
  {
    AppMethodBeat.i(48345);
    String str = n.cH(this);
    AppMethodBeat.o(48345);
    return str;
  }
  
  public final void F(Bitmap paramBitmap)
  {
    AppMethodBeat.i(48343);
    this.mBF.setVisibility(4);
    this.mBF.fQe();
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      this.lpo.setImageBitmap(paramBitmap);
      this.mBD.setVisibility(4);
    }
    for (;;)
    {
      if (this.mBL != null) {
        this.mBL.oP(0);
      }
      AppMethodBeat.o(48343);
      return;
      this.lpo.setImageBitmap(null);
      this.mBD.setVisibility(0);
    }
  }
  
  public final void aEt() {}
  
  public ImageView getCoverImageView()
  {
    return this.lpo;
  }
  
  public ImageView getErrorImageView()
  {
    return this.mBD;
  }
  
  public ThreeDotsLoadingView getLoadingView()
  {
    return this.mBF;
  }
  
  public ImageView getVideoIcon()
  {
    return this.mBP;
  }
  
  public int getWidgetHeight()
  {
    AppMethodBeat.i(48350);
    int i = com.tencent.mm.plugin.appbrand.y.g.vO(180);
    AppMethodBeat.o(48350);
    return i;
  }
  
  public IPCDynamicPageView getWidgetPageView()
  {
    return this.mBE;
  }
  
  public int getWidgetWidth()
  {
    AppMethodBeat.i(48349);
    int i = com.tencent.mm.plugin.appbrand.y.g.vO(224);
    AppMethodBeat.o(48349);
    return i;
  }
  
  @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
  public void onActivityDestroyed()
  {
    AppMethodBeat.i(222976);
    this.mBF.fQe();
    com.tencent.mm.modelappbrand.a.b.aEl().a(this);
    AppMethodBeat.o(222976);
  }
  
  public final void ox()
  {
    AppMethodBeat.i(48344);
    this.mBF.setVisibility(4);
    this.mBF.fQe();
    this.lpo.setImageBitmap(null);
    this.mBD.setVisibility(0);
    if (this.mBL != null) {
      this.mBL.oP(1);
    }
    AppMethodBeat.o(48344);
  }
  
  public void setImageData(Bitmap paramBitmap)
  {
    AppMethodBeat.i(48347);
    this.lpo.setVisibility(0);
    this.mBF.setVisibility(4);
    this.mBD.setVisibility(4);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      if (this.mBO)
      {
        this.lpo.setImageBitmap(paramBitmap);
        AppMethodBeat.o(48347);
        return;
      }
      b.h localh = ((k)com.tencent.mm.kernel.g.ab(k.class)).aDX();
      this.lpo.setImageBitmap(localh.G(paramBitmap));
      AppMethodBeat.o(48347);
      return;
    }
    this.lpo.setImageBitmap(null);
    AppMethodBeat.o(48347);
  }
  
  public void setImageUrl(String paramString)
  {
    AppMethodBeat.i(48346);
    this.mBF.setVisibility(0);
    this.mBF.fQd();
    this.mBD.setVisibility(4);
    this.lpo.setVisibility(0);
    if (this.mBO)
    {
      com.tencent.mm.modelappbrand.a.b.aEl().a(this, paramString, null, ((k)com.tencent.mm.kernel.g.ab(k.class)).a(112, 90, k.a.hNl));
      AppMethodBeat.o(48346);
      return;
    }
    com.tencent.mm.modelappbrand.a.b.aEl().a(this, paramString, null, ((k)com.tencent.mm.kernel.g.ab(k.class)).de(112, 90));
    AppMethodBeat.o(48346);
  }
  
  public void setOnLoadImageResult(k.b paramb)
  {
    this.mBL = paramb;
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(48348);
    this.lHk.setText(paramString);
    AppMethodBeat.o(48348);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.share.widget.WxaShareMessagePage
 * JD-Core Version:    0.7.0.1
 */
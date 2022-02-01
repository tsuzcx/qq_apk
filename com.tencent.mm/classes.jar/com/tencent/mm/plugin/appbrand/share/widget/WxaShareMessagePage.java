package com.tencent.mm.plugin.appbrand.share.widget;

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
import androidx.lifecycle.h.a;
import androidx.lifecycle.t;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.r.a;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.modelappbrand.k.a;
import com.tencent.mm.modelappbrand.k.b;
import com.tencent.mm.modelappbrand.k.c;
import com.tencent.mm.plugin.appbrand.ac.g;
import com.tencent.mm.plugin.appbrand.ac.n;
import com.tencent.mm.plugin.appbrand.au.f;
import com.tencent.mm.plugin.appbrand.au.g;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

public class WxaShareMessagePage
  extends LinearLayout
  implements androidx.lifecycle.k, b.k
{
  TextView pPT;
  public ImageView puu;
  public ImageView qPE;
  IPCDynamicPageView qPF;
  ThreeDotsLoadingView qPG;
  public RelativeLayout qPH;
  ImageView qPI;
  MMSwitchBtn qPJ;
  public ImageView qPK;
  public TextView qPL;
  k.b qPM;
  public k.c qPN;
  public View qPO;
  public boolean qPP;
  private ImageView qPQ;
  
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
    View localView = View.inflate(paramContext, au.g.wxa_share_message_page, this);
    this.qPO = localView.findViewById(au.f.frame_layout);
    this.puu = ((ImageView)localView.findViewById(au.f.cover_iv));
    this.qPE = ((ImageView)localView.findViewById(au.f.error_icon_iv));
    this.qPF = ((IPCDynamicPageView)localView.findViewById(au.f.widget_pv));
    this.pPT = ((TextView)localView.findViewById(au.f.title_tv));
    this.qPQ = ((ImageView)localView.findViewById(au.f.video_icon));
    this.qPG = ((ThreeDotsLoadingView)localView.findViewById(au.f.loading_view));
    paramContext = LayoutInflater.from(paramContext).inflate(au.g.layout_appbrand_share_page_preview_footer, (ViewGroup)localView, false);
    this.qPK = ((ImageView)paramContext.findViewById(au.f.share_msg_appbrand_footer_icon));
    this.qPL = ((TextView)paramContext.findViewById(au.f.share_msg_appbrand_footer_text));
    this.qPH = ((RelativeLayout)localView.findViewById(au.f.todo_container));
    this.qPI = ((ImageView)localView.findViewById(au.f.intro_btn));
    this.qPJ = ((MMSwitchBtn)localView.findViewById(au.f.todo_checkbox));
    ((ViewGroup)localView.findViewById(au.f.container)).addView(paramContext);
    setGravity(17);
    this.qPI.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(180364);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/appbrand/share/widget/WxaShareMessagePage$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (WxaShareMessagePage.this.qPN != null) {
          WxaShareMessagePage.this.qPN.bgU();
        }
        a.a(this, "com/tencent/mm/plugin/appbrand/share/widget/WxaShareMessagePage$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(180364);
      }
    });
    setTag(au.f.app_brand_todo_tag_share, Boolean.FALSE);
    this.qPJ.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(180365);
        WxaShareMessagePage.this.setTag(au.f.app_brand_todo_tag_share, Boolean.valueOf(paramAnonymousBoolean));
        if (WxaShareMessagePage.this.qPN != null) {
          WxaShareMessagePage.this.qPN.gd(paramAnonymousBoolean);
        }
        AppMethodBeat.o(180365);
      }
    });
    AppMethodBeat.o(48342);
  }
  
  public final void G(Bitmap paramBitmap)
  {
    AppMethodBeat.i(48343);
    this.qPG.setVisibility(4);
    this.qPG.hZY();
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      this.puu.setImageBitmap(paramBitmap);
      this.qPE.setVisibility(4);
    }
    for (;;)
    {
      if (this.qPM != null) {
        this.qPM.vA(0);
      }
      AppMethodBeat.o(48343);
      return;
      this.puu.setImageBitmap(null);
      this.qPE.setVisibility(0);
    }
  }
  
  public final void bhq() {}
  
  public final void bhr()
  {
    AppMethodBeat.i(48344);
    this.qPG.setVisibility(4);
    this.qPG.hZY();
    this.puu.setImageBitmap(null);
    this.qPE.setVisibility(0);
    if (this.qPM != null) {
      this.qPM.vA(1);
    }
    AppMethodBeat.o(48344);
  }
  
  public ImageView getCoverImageView()
  {
    return this.puu;
  }
  
  public ImageView getErrorImageView()
  {
    return this.qPE;
  }
  
  public ThreeDotsLoadingView getLoadingView()
  {
    return this.qPG;
  }
  
  public ImageView getVideoIcon()
  {
    return this.qPQ;
  }
  
  public int getWidgetHeight()
  {
    AppMethodBeat.i(48350);
    int i = g.Di(180);
    AppMethodBeat.o(48350);
    return i;
  }
  
  public IPCDynamicPageView getWidgetPageView()
  {
    return this.qPF;
  }
  
  public int getWidgetWidth()
  {
    AppMethodBeat.i(48349);
    int i = g.Di(224);
    AppMethodBeat.o(48349);
    return i;
  }
  
  public final String key()
  {
    AppMethodBeat.i(48345);
    String str = n.cP(this);
    AppMethodBeat.o(48345);
    return str;
  }
  
  @t(jl=h.a.ON_DESTROY)
  public void onActivityDestroyed()
  {
    AppMethodBeat.i(276181);
    this.qPG.hZY();
    com.tencent.mm.modelappbrand.a.b.bhh().a(this);
    AppMethodBeat.o(276181);
  }
  
  public void setImageData(Bitmap paramBitmap)
  {
    AppMethodBeat.i(48347);
    this.puu.setVisibility(0);
    this.qPG.setVisibility(4);
    this.qPE.setVisibility(4);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      if (this.qPP)
      {
        this.puu.setImageBitmap(paramBitmap);
        AppMethodBeat.o(48347);
        return;
      }
      b.h localh = ((com.tencent.mm.modelappbrand.k)h.ae(com.tencent.mm.modelappbrand.k.class)).bgT();
      this.puu.setImageBitmap(localh.H(paramBitmap));
      AppMethodBeat.o(48347);
      return;
    }
    this.puu.setImageBitmap(null);
    AppMethodBeat.o(48347);
  }
  
  public void setImageUrl(String paramString)
  {
    AppMethodBeat.i(48346);
    this.qPG.setVisibility(0);
    this.qPG.hZX();
    this.qPE.setVisibility(4);
    this.puu.setVisibility(0);
    if (this.qPP)
    {
      com.tencent.mm.modelappbrand.a.b.bhh().a(this, paramString, null, ((com.tencent.mm.modelappbrand.k)h.ae(com.tencent.mm.modelappbrand.k.class)).a(112, 90, k.a.lyt));
      AppMethodBeat.o(48346);
      return;
    }
    com.tencent.mm.modelappbrand.a.b.bhh().a(this, paramString, null, ((com.tencent.mm.modelappbrand.k)h.ae(com.tencent.mm.modelappbrand.k.class)).dK(112, 90));
    AppMethodBeat.o(48346);
  }
  
  public void setOnLoadImageResult(k.b paramb)
  {
    this.qPM = paramb;
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(48348);
    this.pPT.setText(paramString);
    AppMethodBeat.o(48348);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.share.widget.WxaShareMessagePage
 * JD-Core Version:    0.7.0.1
 */
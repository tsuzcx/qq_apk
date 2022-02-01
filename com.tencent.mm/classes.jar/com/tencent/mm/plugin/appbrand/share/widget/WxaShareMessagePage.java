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
import androidx.lifecycle.j.a;
import androidx.lifecycle.z;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.modelappbrand.a.b.h;
import com.tencent.mm.modelappbrand.a.b.k;
import com.tencent.mm.modelappbrand.k;
import com.tencent.mm.modelappbrand.k.a;
import com.tencent.mm.modelappbrand.k.b;
import com.tencent.mm.modelappbrand.k.c;
import com.tencent.mm.modelimage.s.a;
import com.tencent.mm.plugin.appbrand.af.i;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.g;
import com.tencent.mm.plugin.appbrand.dynamic.widget.IPCDynamicPageView;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.mm.ui.widget.ThreeDotsLoadingView;

public class WxaShareMessagePage
  extends LinearLayout
  implements androidx.lifecycle.p, b.k
{
  TextView sUt;
  public ImageView szA;
  public ImageView tUA;
  public TextView tUB;
  k.b tUC;
  public k.c tUD;
  public View tUE;
  public boolean tUF;
  private ImageView tUG;
  public ImageView tUu;
  IPCDynamicPageView tUv;
  ThreeDotsLoadingView tUw;
  public RelativeLayout tUx;
  ImageView tUy;
  MMSwitchBtn tUz;
  
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
    View localView = View.inflate(paramContext, ba.g.wxa_share_message_page, this);
    this.tUE = localView.findViewById(ba.f.frame_layout);
    this.szA = ((ImageView)localView.findViewById(ba.f.cover_iv));
    this.tUu = ((ImageView)localView.findViewById(ba.f.error_icon_iv));
    this.tUv = ((IPCDynamicPageView)localView.findViewById(ba.f.widget_pv));
    this.sUt = ((TextView)localView.findViewById(ba.f.title_tv));
    this.tUG = ((ImageView)localView.findViewById(ba.f.video_icon));
    this.tUw = ((ThreeDotsLoadingView)localView.findViewById(ba.f.loading_view));
    paramContext = LayoutInflater.from(paramContext).inflate(ba.g.layout_appbrand_share_page_preview_footer, (ViewGroup)localView, false);
    this.tUA = ((ImageView)paramContext.findViewById(ba.f.share_msg_appbrand_footer_icon));
    this.tUB = ((TextView)paramContext.findViewById(ba.f.share_msg_appbrand_footer_text));
    this.tUx = ((RelativeLayout)localView.findViewById(ba.f.todo_container));
    this.tUy = ((ImageView)localView.findViewById(ba.f.intro_btn));
    this.tUz = ((MMSwitchBtn)localView.findViewById(ba.f.todo_checkbox));
    ((ViewGroup)localView.findViewById(ba.f.container)).addView(paramContext);
    setGravity(17);
    this.tUy.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(180364);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/appbrand/share/widget/WxaShareMessagePage$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (WxaShareMessagePage.this.tUD != null) {
          WxaShareMessagePage.this.tUD.bEL();
        }
        a.a(this, "com/tencent/mm/plugin/appbrand/share/widget/WxaShareMessagePage$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(180364);
      }
    });
    setTag(ba.f.app_brand_todo_tag_share, Boolean.FALSE);
    this.tUz.setSwitchListener(new MMSwitchBtn.a()
    {
      public final void onStatusChange(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(180365);
        WxaShareMessagePage.this.setTag(ba.f.app_brand_todo_tag_share, Boolean.valueOf(paramAnonymousBoolean));
        if (WxaShareMessagePage.this.tUD != null) {
          WxaShareMessagePage.this.tUD.gU(paramAnonymousBoolean);
        }
        AppMethodBeat.o(180365);
      }
    });
    AppMethodBeat.o(48342);
  }
  
  public final void bFg() {}
  
  public final void bFh()
  {
    AppMethodBeat.i(48344);
    this.tUw.setVisibility(4);
    this.tUw.jFf();
    this.szA.setImageBitmap(null);
    this.tUu.setVisibility(0);
    if (this.tUC != null) {
      this.tUC.vJ(1);
    }
    AppMethodBeat.o(48344);
  }
  
  public ImageView getCoverImageView()
  {
    return this.szA;
  }
  
  public ImageView getErrorImageView()
  {
    return this.tUu;
  }
  
  public ThreeDotsLoadingView getLoadingView()
  {
    return this.tUw;
  }
  
  public ImageView getVideoIcon()
  {
    return this.tUG;
  }
  
  public int getWidgetHeight()
  {
    AppMethodBeat.i(48350);
    int i = i.DC(180);
    AppMethodBeat.o(48350);
    return i;
  }
  
  public IPCDynamicPageView getWidgetPageView()
  {
    return this.tUv;
  }
  
  public int getWidgetWidth()
  {
    AppMethodBeat.i(48349);
    int i = i.DC(224);
    AppMethodBeat.o(48349);
    return i;
  }
  
  public final String key()
  {
    AppMethodBeat.i(48345);
    String str = com.tencent.mm.plugin.appbrand.af.p.el(this);
    AppMethodBeat.o(48345);
    return str;
  }
  
  @z(Ho=j.a.ON_DESTROY)
  public void onActivityDestroyed()
  {
    AppMethodBeat.i(317498);
    this.tUw.jFf();
    com.tencent.mm.modelappbrand.a.b.bEY().a(this);
    AppMethodBeat.o(317498);
  }
  
  public final void onBitmapLoaded(Bitmap paramBitmap)
  {
    AppMethodBeat.i(48343);
    this.tUw.setVisibility(4);
    this.tUw.jFf();
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      this.szA.setImageBitmap(paramBitmap);
      this.tUu.setVisibility(4);
    }
    for (;;)
    {
      if (this.tUC != null) {
        this.tUC.vJ(0);
      }
      AppMethodBeat.o(48343);
      return;
      this.szA.setImageBitmap(null);
      this.tUu.setVisibility(0);
    }
  }
  
  public void setImageData(Bitmap paramBitmap)
  {
    AppMethodBeat.i(48347);
    this.szA.setVisibility(0);
    this.tUw.setVisibility(4);
    this.tUu.setVisibility(4);
    if ((paramBitmap != null) && (!paramBitmap.isRecycled()))
    {
      if (this.tUF)
      {
        this.szA.setImageBitmap(paramBitmap);
        AppMethodBeat.o(48347);
        return;
      }
      b.h localh = ((k)h.ax(k.class)).bEK();
      this.szA.setImageBitmap(localh.P(paramBitmap));
      AppMethodBeat.o(48347);
      return;
    }
    this.szA.setImageBitmap(null);
    AppMethodBeat.o(48347);
  }
  
  public void setImageUrl(String paramString)
  {
    AppMethodBeat.i(48346);
    this.tUw.setVisibility(0);
    this.tUw.jFe();
    this.tUu.setVisibility(4);
    this.szA.setVisibility(0);
    if (this.tUF)
    {
      com.tencent.mm.modelappbrand.a.b.bEY().a(this, paramString, null, ((k)h.ax(k.class)).a(112, 90, k.a.opU));
      AppMethodBeat.o(48346);
      return;
    }
    com.tencent.mm.modelappbrand.a.b.bEY().a(this, paramString, null, ((k)h.ax(k.class)).eE(112, 90));
    AppMethodBeat.o(48346);
  }
  
  public void setOnLoadImageResult(k.b paramb)
  {
    this.tUC = paramb;
  }
  
  public void setTitle(String paramString)
  {
    AppMethodBeat.i(48348);
    this.sUt.setText(paramString);
    AppMethodBeat.o(48348);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.share.widget.WxaShareMessagePage
 * JD-Core Version:    0.7.0.1
 */
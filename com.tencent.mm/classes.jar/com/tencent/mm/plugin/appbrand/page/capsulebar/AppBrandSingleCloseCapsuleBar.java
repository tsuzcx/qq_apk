package com.tencent.mm.plugin.appbrand.page.capsulebar;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ba.c;
import com.tencent.mm.plugin.appbrand.ba.e;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.g;
import com.tencent.mm.plugin.appbrand.ba.h;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandSingleCloseCapsuleBar;", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/BaseAppBrandSingleCloseCapsuleBar;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "forceLightMode", "", "(Landroid/content/Context;Z)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "closeV", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "contentView", "Landroid/view/View;", "iconIv", "Landroid/widget/ImageView;", "nameTv", "Landroid/widget/TextView;", "shareIv", "viewsNeedResponseAlphaAnimation", "", "currentAnimationViewAlpha", "", "getCloseButton", "getViewsNeedResponseAlphaAnimation", "getWxaIcon", "initView", "", "isForceLightMode", "isHeaderTransparent", "setCloseBtnListener", "listener", "Landroid/view/View$OnClickListener;", "setShareBtnListener", "setTitle", "name", "showShareButton", "show", "transformResource", "reId", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AppBrandSingleCloseCapsuleBar
  extends BaseAppBrandSingleCloseCapsuleBar
{
  private final String TAG;
  private View contentView;
  private TextView lDF;
  private ImageView lPb;
  private boolean qkq;
  private WeImageView tCw;
  private WeImageView tCx;
  private List<? extends View> tCy;
  
  public AppBrandSingleCloseCapsuleBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(325325);
    this.TAG = "MicroMsg.AppBrandSingleCloseCapsuleBar";
    paramContext = LayoutInflater.from(getContext()).inflate(ba.g.appbrand_half_screen_capsule_bar_view, (ViewGroup)this).findViewById(ba.f.root_container);
    s.s(paramContext, "from(context).inflate(R.…ById(R.id.root_container)");
    this.contentView = paramContext;
    paramContext = findViewById(ba.f.close);
    s.s(paramContext, "findViewById(R.id.close)");
    this.tCw = ((WeImageView)paramContext);
    paramContext = findViewById(ba.f.share);
    s.s(paramContext, "findViewById(R.id.share)");
    this.tCx = ((WeImageView)paramContext);
    paramContext = findViewById(ba.f.name);
    s.s(paramContext, "findViewById(R.id.name)");
    this.lDF = ((TextView)paramContext);
    paramContext = findViewById(ba.f.icon);
    s.s(paramContext, "findViewById(R.id.icon)");
    this.lPb = ((ImageView)paramContext);
    this.tCy = p.listOf(new View[] { (View)this.tCx, (View)this.lDF, (View)this.lPb });
    AppMethodBeat.o(325325);
  }
  
  public AppBrandSingleCloseCapsuleBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt, (byte)0);
    AppMethodBeat.i(325344);
    this.TAG = "MicroMsg.AppBrandSingleCloseCapsuleBar";
    paramContext = LayoutInflater.from(getContext()).inflate(ba.g.appbrand_half_screen_capsule_bar_view, (ViewGroup)this).findViewById(ba.f.root_container);
    s.s(paramContext, "from(context).inflate(R.…ById(R.id.root_container)");
    this.contentView = paramContext;
    paramContext = findViewById(ba.f.close);
    s.s(paramContext, "findViewById(R.id.close)");
    this.tCw = ((WeImageView)paramContext);
    paramContext = findViewById(ba.f.share);
    s.s(paramContext, "findViewById(R.id.share)");
    this.tCx = ((WeImageView)paramContext);
    paramContext = findViewById(ba.f.name);
    s.s(paramContext, "findViewById(R.id.name)");
    this.lDF = ((TextView)paramContext);
    paramContext = findViewById(ba.f.icon);
    s.s(paramContext, "findViewById(R.id.icon)");
    this.lPb = ((ImageView)paramContext);
    this.tCy = p.listOf(new View[] { (View)this.tCx, (View)this.lDF, (View)this.lPb });
    AppMethodBeat.o(325344);
  }
  
  public AppBrandSingleCloseCapsuleBar(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(325337);
    this.TAG = "MicroMsg.AppBrandSingleCloseCapsuleBar";
    paramContext = LayoutInflater.from(getContext()).inflate(ba.g.appbrand_half_screen_capsule_bar_view, (ViewGroup)this).findViewById(ba.f.root_container);
    s.s(paramContext, "from(context).inflate(R.…ById(R.id.root_container)");
    this.contentView = paramContext;
    paramContext = findViewById(ba.f.close);
    s.s(paramContext, "findViewById(R.id.close)");
    this.tCw = ((WeImageView)paramContext);
    paramContext = findViewById(ba.f.share);
    s.s(paramContext, "findViewById(R.id.share)");
    this.tCx = ((WeImageView)paramContext);
    paramContext = findViewById(ba.f.name);
    s.s(paramContext, "findViewById(R.id.name)");
    this.lDF = ((TextView)paramContext);
    paramContext = findViewById(ba.f.icon);
    s.s(paramContext, "findViewById(R.id.icon)");
    this.lPb = ((ImageView)paramContext);
    this.tCy = p.listOf(new View[] { (View)this.tCx, (View)this.lDF, (View)this.lPb });
    this.qkq = paramBoolean;
    this.contentView.setBackgroundColor(getContext().getResources().getColor(CO(ba.c.transparent)));
    this.lDF.setTextColor(getContext().getResources().getColor(CO(ba.c.black_color)));
    int i;
    if (this.qkq)
    {
      paramContext = this.tCw;
      i = ba.h.app_brand_half_screenc_capsule_bar_close_light;
      label255:
      paramContext.setImageResource(i);
      if (!this.qkq) {
        break label312;
      }
      paramContext = this.tCx;
      label272:
      i = ba.e.app_brand_half_screenc_capsule_bar_share_light;
    }
    for (;;)
    {
      paramContext.setImageResource(i);
      AppMethodBeat.o(325337);
      return;
      WeImageView localWeImageView = this.tCw;
      paramContext = localWeImageView;
      if (!aw.isDarkMode()) {
        break;
      }
      i = ba.h.app_brand_half_screen_capsule_bar_close_dark;
      paramContext = localWeImageView;
      break label255;
      label312:
      localWeImageView = this.tCx;
      paramContext = localWeImageView;
      if (!aw.isDarkMode()) {
        break label272;
      }
      i = ba.e.app_brand_half_screenc_capsule_bar_share_dark;
      paramContext = localWeImageView;
    }
  }
  
  public final int CO(int paramInt)
  {
    int i = paramInt;
    if (this.qkq)
    {
      if (paramInt != ba.c.black_color) {
        break label22;
      }
      i = ba.c.BW_0;
    }
    label22:
    do
    {
      return i;
      i = paramInt;
    } while (paramInt != ba.c.white);
    return ba.c.White;
  }
  
  public final boolean cGo()
  {
    AppMethodBeat.i(325389);
    int i;
    if (!((Collection)this.tCy).isEmpty()) {
      i = 1;
    }
    while (i != 0) {
      if (((View)this.tCy.get(0)).getAlpha() == 0.0F)
      {
        AppMethodBeat.o(325389);
        return true;
        i = 0;
      }
      else
      {
        AppMethodBeat.o(325389);
        return false;
      }
    }
    AppMethodBeat.o(325389);
    return false;
  }
  
  public final float cGp()
  {
    AppMethodBeat.i(325393);
    float f = this.lPb.getAlpha();
    AppMethodBeat.o(325393);
    return f;
  }
  
  protected final View getCloseButton()
  {
    return (View)this.tCw;
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final List<View> getViewsNeedResponseAlphaAnimation()
  {
    return this.tCy;
  }
  
  protected final ImageView getWxaIcon()
  {
    return this.lPb;
  }
  
  public final void kz(boolean paramBoolean)
  {
    AppMethodBeat.i(325381);
    WeImageView localWeImageView = this.tCx;
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localWeImageView.setVisibility(i);
      AppMethodBeat.o(325381);
      return;
    }
  }
  
  public final void setCloseBtnListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(325373);
    this.tCw.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(325373);
  }
  
  public final void setShareBtnListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(325386);
    this.tCx.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(325386);
  }
  
  public final void setTitle(String paramString)
  {
    AppMethodBeat.i(325368);
    TextView localTextView = this.lDF;
    if (paramString == null) {
      paramString = "";
    }
    for (;;)
    {
      localTextView.setText((CharSequence)paramString);
      AppMethodBeat.o(325368);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.capsulebar.AppBrandSingleCloseCapsuleBar
 * JD-Core Version:    0.7.0.1
 */
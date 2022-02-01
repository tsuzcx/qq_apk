package com.tencent.mm.plugin.appbrand.page.capsulebar;

import android.content.Context;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.ba.f;
import com.tencent.mm.plugin.appbrand.ba.g;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/page/capsulebar/AppBrandeEmbedSingleCloseCapsuleBar;", "Lcom/tencent/mm/plugin/appbrand/page/capsulebar/BaseAppBrandSingleCloseCapsuleBar;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "forceLightMode", "", "(Landroid/content/Context;Z)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "closeV", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "contentView", "Landroid/view/View;", "iconIv", "Landroid/widget/ImageView;", "nameTv", "Landroid/widget/TextView;", "titleLayout", "viewsNeedResponseAlphaAnimation", "", "currentAnimationViewAlpha", "", "getCloseButton", "getViewsNeedResponseAlphaAnimation", "getWxaIcon", "isForceLightMode", "isHeaderTransparent", "setCloseBtnListener", "", "listener", "Landroid/view/View$OnClickListener;", "setShareBtnListener", "setTitle", "name", "setTitleClickListener", "showShareButton", "show", "transformResource", "reId", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class AppBrandeEmbedSingleCloseCapsuleBar
  extends BaseAppBrandSingleCloseCapsuleBar
{
  private final String TAG;
  private View contentView;
  private TextView lDF;
  private ImageView lPb;
  private boolean qkq;
  private WeImageView tCw;
  private List<? extends View> tCy;
  private View tCz;
  
  public AppBrandeEmbedSingleCloseCapsuleBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(325319);
    this.TAG = "MicroMsg.AppBrandSingleCloseCapsuleBar";
    paramContext = LayoutInflater.from(getContext()).inflate(ba.g.appbrand_embed_half_screen_capsule_bar_view, (ViewGroup)this).findViewById(ba.f.root_container);
    s.s(paramContext, "from(context).inflate(R.…ById(R.id.root_container)");
    this.contentView = paramContext;
    paramContext = findViewById(ba.f.close);
    s.s(paramContext, "findViewById(R.id.close)");
    this.tCw = ((WeImageView)paramContext);
    paramContext = findViewById(ba.f.name);
    s.s(paramContext, "findViewById(R.id.name)");
    this.lDF = ((TextView)paramContext);
    paramContext = findViewById(ba.f.icon);
    s.s(paramContext, "findViewById(R.id.icon)");
    this.lPb = ((ImageView)paramContext);
    paramContext = findViewById(ba.f.title_lv);
    s.s(paramContext, "findViewById(R.id.title_lv)");
    this.tCz = paramContext;
    this.tCy = p.listOf(this.tCz);
    aw.d((Paint)this.lDF.getPaint());
    aw.d((Paint)((TextView)findViewById(ba.f.service_provide)).getPaint());
    AppMethodBeat.o(325319);
  }
  
  public AppBrandeEmbedSingleCloseCapsuleBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt, (byte)0);
    AppMethodBeat.i(325332);
    this.TAG = "MicroMsg.AppBrandSingleCloseCapsuleBar";
    paramContext = LayoutInflater.from(getContext()).inflate(ba.g.appbrand_embed_half_screen_capsule_bar_view, (ViewGroup)this).findViewById(ba.f.root_container);
    s.s(paramContext, "from(context).inflate(R.…ById(R.id.root_container)");
    this.contentView = paramContext;
    paramContext = findViewById(ba.f.close);
    s.s(paramContext, "findViewById(R.id.close)");
    this.tCw = ((WeImageView)paramContext);
    paramContext = findViewById(ba.f.name);
    s.s(paramContext, "findViewById(R.id.name)");
    this.lDF = ((TextView)paramContext);
    paramContext = findViewById(ba.f.icon);
    s.s(paramContext, "findViewById(R.id.icon)");
    this.lPb = ((ImageView)paramContext);
    paramContext = findViewById(ba.f.title_lv);
    s.s(paramContext, "findViewById(R.id.title_lv)");
    this.tCz = paramContext;
    this.tCy = p.listOf(this.tCz);
    aw.d((Paint)this.lDF.getPaint());
    aw.d((Paint)((TextView)findViewById(ba.f.service_provide)).getPaint());
    AppMethodBeat.o(325332);
  }
  
  public AppBrandeEmbedSingleCloseCapsuleBar(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    AppMethodBeat.i(325324);
    this.TAG = "MicroMsg.AppBrandSingleCloseCapsuleBar";
    paramContext = LayoutInflater.from(getContext()).inflate(ba.g.appbrand_embed_half_screen_capsule_bar_view, (ViewGroup)this).findViewById(ba.f.root_container);
    s.s(paramContext, "from(context).inflate(R.…ById(R.id.root_container)");
    this.contentView = paramContext;
    paramContext = findViewById(ba.f.close);
    s.s(paramContext, "findViewById(R.id.close)");
    this.tCw = ((WeImageView)paramContext);
    paramContext = findViewById(ba.f.name);
    s.s(paramContext, "findViewById(R.id.name)");
    this.lDF = ((TextView)paramContext);
    paramContext = findViewById(ba.f.icon);
    s.s(paramContext, "findViewById(R.id.icon)");
    this.lPb = ((ImageView)paramContext);
    paramContext = findViewById(ba.f.title_lv);
    s.s(paramContext, "findViewById(R.id.title_lv)");
    this.tCz = paramContext;
    this.tCy = p.listOf(this.tCz);
    aw.d((Paint)this.lDF.getPaint());
    aw.d((Paint)((TextView)findViewById(ba.f.service_provide)).getPaint());
    this.qkq = paramBoolean;
    AppMethodBeat.o(325324);
  }
  
  public final int CO(int paramInt)
  {
    return paramInt;
  }
  
  public final boolean cGo()
  {
    AppMethodBeat.i(325379);
    int i;
    if (!((Collection)this.tCy).isEmpty()) {
      i = 1;
    }
    while (i != 0) {
      if (((View)this.tCy.get(0)).getAlpha() == 0.0F)
      {
        AppMethodBeat.o(325379);
        return true;
        i = 0;
      }
      else
      {
        AppMethodBeat.o(325379);
        return false;
      }
    }
    AppMethodBeat.o(325379);
    return false;
  }
  
  public final float cGp()
  {
    AppMethodBeat.i(325384);
    if (!((Collection)this.tCy).isEmpty()) {}
    for (int i = 1; i != 0; i = 0)
    {
      float f = ((View)this.tCy.get(0)).getAlpha();
      AppMethodBeat.o(325384);
      return f;
    }
    AppMethodBeat.o(325384);
    return 255.0F;
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
  
  public final void kz(boolean paramBoolean) {}
  
  public final void setCloseBtnListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(325362);
    this.tCw.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(325362);
  }
  
  public final void setShareBtnListener(View.OnClickListener paramOnClickListener) {}
  
  public final void setTitle(String paramString)
  {
    AppMethodBeat.i(325357);
    TextView localTextView = this.lDF;
    if (paramString == null) {
      paramString = "";
    }
    for (;;)
    {
      localTextView.setText((CharSequence)paramString);
      AppMethodBeat.o(325357);
      return;
    }
  }
  
  public final void setTitleClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(325367);
    super.setTitleClickListener(paramOnClickListener);
    this.tCz.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(325367);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.page.capsulebar.AppBrandeEmbedSingleCloseCapsuleBar
 * JD-Core Version:    0.7.0.1
 */
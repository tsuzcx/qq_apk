package com.tencent.mm.plugin.finder.activity.uic;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.loader.f.e;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityDescUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "activityDescText", "Landroid/widget/TextView;", "activityNameText", "avatarImage", "Landroid/widget/ImageView;", "backBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "coverImageView", "coverMaskImageView", "defaultBg", "exitActivityBtn", "nickNameText", "title", "adjustCoverImageView", "", "getLayoutId", "", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setCover", "coverUrl", "", "setCoverMaskMargin", "setCoverStyle", "setNormalStyle", "setTextColors", "color", "Companion", "plugin-finder_release"})
public final class FinderActivityDescUIC
  extends UIComponent
{
  public static final a tqX;
  public ImageView cxe;
  public WeImageView hPV;
  public TextView hbb;
  public ImageView tqQ;
  public ImageView tqR;
  public TextView tqS;
  public TextView tqT;
  public TextView tqU;
  public TextView tqV;
  public WeImageView tqW;
  
  static
  {
    AppMethodBeat.i(242062);
    tqX = new a((byte)0);
    AppMethodBeat.o(242062);
  }
  
  public FinderActivityDescUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(242061);
    AppMethodBeat.o(242061);
  }
  
  public final void Ii(int paramInt)
  {
    AppMethodBeat.i(242060);
    Object localObject = this.tqS;
    if (localObject == null) {
      p.btv("nickNameText");
    }
    ((TextView)localObject).setTextColor(paramInt);
    localObject = this.hPV;
    if (localObject == null) {
      p.btv("backBtn");
    }
    ((WeImageView)localObject).setIconColor(paramInt);
    localObject = this.hbb;
    if (localObject == null) {
      p.btv("title");
    }
    ((TextView)localObject).setTextColor(paramInt);
    AppMethodBeat.o(242060);
  }
  
  public final int getLayoutId()
  {
    return 2131494192;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(242059);
    super.onCreate(paramBundle);
    AppMethodBeat.o(242059);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityDescUIC$Companion;", "", "()V", "FIX_RATIO", "", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  public static final class b
    implements Runnable
  {
    public b(FinderActivityDescUIC paramFinderActivityDescUIC) {}
    
    public final void run()
    {
      AppMethodBeat.i(242053);
      ViewGroup.LayoutParams localLayoutParams = FinderActivityDescUIC.a(this.tqY).getLayoutParams();
      localLayoutParams.height = ((int)(FinderActivityDescUIC.a(this.tqY).getWidth() / 0.8571429F));
      FinderActivityDescUIC.a(this.tqY).setLayoutParams(localLayoutParams);
      AppMethodBeat.o(242053);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class d
    implements View.OnClickListener
  {
    public d(FinderActivityDescUIC paramFinderActivityDescUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242056);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/activity/uic/FinderActivityDescUIC$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      if (!this.tqY.getActivity().isFinishing()) {
        this.tqY.getActivity().finish();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/activity/uic/FinderActivityDescUIC$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(242056);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "kotlin.jvm.PlatformType", "view", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete"})
  public static final class e<T, R>
    implements e<o, Bitmap>
  {
    public e(FinderActivityDescUIC paramFinderActivityDescUIC, String paramString) {}
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/activity/uic/FinderActivityDescUIC$setCover$1$1$1"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(FinderActivityDescUIC.e parame)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.activity.uic.FinderActivityDescUIC
 * JD-Core Version:    0.7.0.1
 */
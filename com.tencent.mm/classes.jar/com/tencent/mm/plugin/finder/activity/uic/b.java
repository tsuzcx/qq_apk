package com.tencent.mm.plugin.finder.activity.uic;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.f.e;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.loader.w;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityDescUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "activityDescText", "Landroid/widget/TextView;", "activityNameText", "avatarImage", "Landroid/widget/ImageView;", "backBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "coverImageView", "coverMaskContainer", "Landroid/view/ViewGroup;", "coverMaskImageView", "descTextContent", "", "exitActivityBtn", "nickNameText", "title", "adjustCoverImageView", "", "adjustCoverMaskImageView", "getAvailableDescWidth", "", "getLayoutId", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setCover", "coverUrl", "setCoverMaskMargin", "setCoverStyle", "setNormalStyle", "setSuffixedDesc", "descText", "maxLineNum", "textView", "isCovered", "", "setTextColors", "color", "showBottomSheet", "Companion", "plugin-finder_release"})
public final class b
  extends UIComponent
{
  public static final a wXL;
  public ImageView cvK;
  public TextView jMg;
  public WeImageView kEr;
  public ImageView wXD;
  public ImageView wXE;
  public ViewGroup wXF;
  public TextView wXG;
  public TextView wXH;
  public TextView wXI;
  public TextView wXJ;
  public String wXK;
  
  static
  {
    AppMethodBeat.i(239136);
    wXL = new a((byte)0);
    AppMethodBeat.o(239136);
  }
  
  public b(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(239134);
    this.wXK = "";
    AppMethodBeat.o(239134);
  }
  
  public final void LT(int paramInt)
  {
    AppMethodBeat.i(239133);
    Object localObject = this.wXG;
    if (localObject == null) {
      p.bGy("nickNameText");
    }
    ((TextView)localObject).setTextColor(paramInt);
    localObject = this.kEr;
    if (localObject == null) {
      p.bGy("backBtn");
    }
    ((WeImageView)localObject).setIconColor(paramInt);
    localObject = this.jMg;
    if (localObject == null) {
      p.bGy("title");
    }
    ((TextView)localObject).setTextColor(paramInt);
    AppMethodBeat.o(239133);
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_activity_desc_ui_new;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(239132);
    super.onCreate(paramBundle);
    AppMethodBeat.o(239132);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityDescUIC$Companion;", "", "()V", "FIX_RATIO", "", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  public static final class b
    implements Runnable
  {
    public b(b paramb) {}
    
    public final void run()
    {
      AppMethodBeat.i(263362);
      ViewGroup.LayoutParams localLayoutParams = b.a(this.wXM).getLayoutParams();
      localLayoutParams.height = ((int)(b.a(this.wXM).getWidth() * 1.333333F));
      b.a(this.wXM).setLayoutParams(localLayoutParams);
      AppMethodBeat.o(263362);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  public static final class d
    implements View.OnClickListener
  {
    public d(b paramb) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(286006);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/activity/uic/FinderActivityDescUIC$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      if (!this.wXM.getActivity().isFinishing()) {
        this.wXM.getActivity().finish();
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/activity/uic/FinderActivityDescUIC$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(286006);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "kotlin.jvm.PlatformType", "view", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete"})
  public static final class e<T, R>
    implements e<w, Bitmap>
  {
    public e(b paramb, String paramString) {}
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke", "com/tencent/mm/plugin/finder/activity/uic/FinderActivityDescUIC$setCover$1$1$1"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(b.e parame)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.activity.uic.b
 * JD-Core Version:    0.7.0.1
 */
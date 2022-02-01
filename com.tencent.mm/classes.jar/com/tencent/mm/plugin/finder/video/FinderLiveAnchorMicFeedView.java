package com.tencent.mm.plugin.finder.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.loader.f.e;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.t;
import com.tencent.mm.plugin.finder.loader.w;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/FinderLiveAnchorMicFeedView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bgView", "Landroid/widget/ImageView;", "fillMicUser", "", "coverUrl", "", "plugin-finder_release"})
public final class FinderLiveAnchorMicFeedView
  extends RelativeLayout
{
  private final ImageView zpB;
  
  public FinderLiveAnchorMicFeedView(Context paramContext)
  {
    this(paramContext, null, 0);
    AppMethodBeat.i(285813);
    AppMethodBeat.o(285813);
  }
  
  public FinderLiveAnchorMicFeedView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(285814);
    AppMethodBeat.o(285814);
  }
  
  public FinderLiveAnchorMicFeedView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(285812);
    View.inflate(paramContext, b.g.finder_live_feed_anchor_mic_ui, (ViewGroup)this);
    paramContext = findViewById(b.f.finder_live_feed_anchor_mic_bg);
    p.j(paramContext, "findViewById(R.id.finder_live_feed_anchor_mic_bg)");
    this.zpB = ((ImageView)paramContext);
    AppMethodBeat.o(285812);
  }
  
  public final void aGi(String paramString)
  {
    AppMethodBeat.i(285811);
    Log.i("Finder.Loader", "fillMicUser coverUrl:".concat(String.valueOf(paramString)));
    if (paramString != null)
    {
      t localt = t.ztT;
      t.dJe().bQ(new m(paramString)).a((e)new a(this)).tA();
      AppMethodBeat.o(285811);
      return;
    }
    AppMethodBeat.o(285811);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "kotlin.jvm.PlatformType", "<anonymous parameter 1>", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete", "com/tencent/mm/plugin/finder/video/FinderLiveAnchorMicFeedView$fillMicUser$1$1"})
  static final class a<T, R>
    implements e<w, Bitmap>
  {
    a(FinderLiveAnchorMicFeedView paramFinderLiveAnchorMicFeedView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderLiveAnchorMicFeedView
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.video;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d.b.g;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.loader.i;
import com.tencent.mm.plugin.finder.loader.p;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/FinderLiveAnchorMicFeedView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "bgView", "Landroid/widget/ImageView;", "fillMicUser", "", "coverUrl", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveAnchorMicFeedView
  extends RelativeLayout
{
  private final ImageView Esh;
  
  public FinderLiveAnchorMicFeedView(Context paramContext)
  {
    this(paramContext, null, 0);
    AppMethodBeat.i(335154);
    AppMethodBeat.o(335154);
  }
  
  public FinderLiveAnchorMicFeedView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(335161);
    AppMethodBeat.o(335161);
  }
  
  public FinderLiveAnchorMicFeedView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(335147);
    View.inflate(paramContext, p.f.CdM, (ViewGroup)this);
    paramContext = findViewById(p.e.BKv);
    s.s(paramContext, "findViewById(R.id.finder_live_feed_anchor_mic_bg)");
    this.Esh = ((ImageView)paramContext);
    AppMethodBeat.o(335147);
  }
  
  private static final void a(final FinderLiveAnchorMicFeedView paramFinderLiveAnchorMicFeedView, com.tencent.mm.loader.g.a.a parama, g paramg, Bitmap paramBitmap)
  {
    AppMethodBeat.i(335167);
    s.u(paramFinderLiveAnchorMicFeedView, "this$0");
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(paramBitmap, paramFinderLiveAnchorMicFeedView));
    AppMethodBeat.o(335167);
  }
  
  public final void aCl(String paramString)
  {
    AppMethodBeat.i(335188);
    Log.i("Finder.Loader", s.X("fillMicUser coverUrl:", paramString));
    if (paramString != null)
    {
      p localp = p.ExI;
      p.eCl().dk(new i(paramString)).a(new FinderLiveAnchorMicFeedView..ExternalSyntheticLambda0(this)).Td();
    }
    AppMethodBeat.o(335188);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(Bitmap paramBitmap, FinderLiveAnchorMicFeedView paramFinderLiveAnchorMicFeedView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderLiveAnchorMicFeedView
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/video/FinderLiveVisitorMicFeedView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attributeSet", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "avatarView", "Landroid/widget/ImageView;", "bgView", "adjustLayout", "", "rootView", "Landroid/view/ViewGroup;", "userId", "totalCount", "index", "scene", "fillMicUser", "micInfo", "Lcom/tencent/mm/protocal/protobuf/FinderLiveContact;", "plugin-finder_release"})
public final class FinderLiveVisitorMicFeedView
  extends RelativeLayout
{
  public final String TAG;
  public final ImageView mOe;
  public final ImageView zpB;
  
  public FinderLiveVisitorMicFeedView(Context paramContext)
  {
    this(paramContext, null, 0);
    AppMethodBeat.i(286290);
    AppMethodBeat.o(286290);
  }
  
  public FinderLiveVisitorMicFeedView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(286291);
    AppMethodBeat.o(286291);
  }
  
  public FinderLiveVisitorMicFeedView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(286289);
    this.TAG = "FinderLiveVisitorMicFeedView";
    View.inflate(paramContext, b.g.finder_live_feed_visitor_mic_ui, (ViewGroup)this);
    paramContext = findViewById(b.f.finder_live_feed_visitor_mic_bg);
    p.j(paramContext, "findViewById(R.id.finder_live_feed_visitor_mic_bg)");
    this.zpB = ((ImageView)paramContext);
    paramContext = findViewById(b.f.finder_live_feed_visitor_mic_avatar);
    p.j(paramContext, "findViewById(R.id.finder…_feed_visitor_mic_avatar)");
    this.mOe = ((ImageView)paramContext);
    AppMethodBeat.o(286289);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.FinderLiveVisitorMicFeedView
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.video.FinderLongVideoPlayerSeekBar;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/HorizontalVideoSeekBarLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "contentView", "Landroid/view/View;", "getContentView", "()Landroid/view/View;", "descTv", "Landroid/widget/TextView;", "getDescTv", "()Landroid/widget/TextView;", "descTv$delegate", "Lkotlin/Lazy;", "floatingBallBtn", "getFloatingBallBtn", "floatingBallBtn$delegate", "hiddenTv", "getHiddenTv", "hiddenTv$delegate", "longVideoSeekBar", "Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar;", "getLongVideoSeekBar", "()Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar;", "longVideoSeekBar$delegate", "speedCtrlBtn", "getSpeedCtrlBtn", "speedCtrlBtn$delegate", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class HorizontalVideoSeekBarLayout
  extends FrameLayout
{
  private final j FdY;
  private final j GEQ;
  private final j GER;
  private final j GES;
  private final j GEU;
  private final View contentView;
  
  public HorizontalVideoSeekBarLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(344008);
    paramContext = View.inflate(getContext(), e.f.finder_mega_video_seek_bar_layout, (ViewGroup)this);
    s.s(paramContext, "inflate(context, R.layou…eo_seek_bar_layout, this)");
    this.contentView = paramContext;
    this.GEQ = k.cm((a)new d(this));
    this.GER = k.cm((a)new e(this));
    this.GES = k.cm((a)new b(this));
    this.FdY = k.cm((a)new a(this));
    this.GEU = k.cm((a)new c(this));
    AppMethodBeat.o(344008);
  }
  
  public HorizontalVideoSeekBarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(344019);
    paramContext = View.inflate(getContext(), e.f.finder_mega_video_seek_bar_layout, (ViewGroup)this);
    s.s(paramContext, "inflate(context, R.layou…eo_seek_bar_layout, this)");
    this.contentView = paramContext;
    this.GEQ = k.cm((a)new d(this));
    this.GER = k.cm((a)new e(this));
    this.GES = k.cm((a)new b(this));
    this.FdY = k.cm((a)new a(this));
    this.GEU = k.cm((a)new c(this));
    AppMethodBeat.o(344019);
  }
  
  public HorizontalVideoSeekBarLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(344032);
    paramContext = View.inflate(getContext(), e.f.finder_mega_video_seek_bar_layout, (ViewGroup)this);
    s.s(paramContext, "inflate(context, R.layou…eo_seek_bar_layout, this)");
    this.contentView = paramContext;
    this.GEQ = k.cm((a)new d(this));
    this.GER = k.cm((a)new e(this));
    this.GES = k.cm((a)new b(this));
    this.FdY = k.cm((a)new a(this));
    this.GEU = k.cm((a)new c(this));
    AppMethodBeat.o(344032);
  }
  
  public final View getContentView()
  {
    return this.contentView;
  }
  
  public final TextView getDescTv()
  {
    AppMethodBeat.i(344098);
    Object localObject = this.FdY.getValue();
    s.s(localObject, "<get-descTv>(...)");
    localObject = (TextView)localObject;
    AppMethodBeat.o(344098);
    return localObject;
  }
  
  public final View getFloatingBallBtn()
  {
    AppMethodBeat.i(344080);
    Object localObject = this.GES.getValue();
    s.s(localObject, "<get-floatingBallBtn>(...)");
    localObject = (View)localObject;
    AppMethodBeat.o(344080);
    return localObject;
  }
  
  public final TextView getHiddenTv()
  {
    AppMethodBeat.i(344113);
    Object localObject = this.GEU.getValue();
    s.s(localObject, "<get-hiddenTv>(...)");
    localObject = (TextView)localObject;
    AppMethodBeat.o(344113);
    return localObject;
  }
  
  public final FinderLongVideoPlayerSeekBar getLongVideoSeekBar()
  {
    AppMethodBeat.i(344055);
    Object localObject = this.GEQ.getValue();
    s.s(localObject, "<get-longVideoSeekBar>(...)");
    localObject = (FinderLongVideoPlayerSeekBar)localObject;
    AppMethodBeat.o(344055);
    return localObject;
  }
  
  public final View getSpeedCtrlBtn()
  {
    AppMethodBeat.i(344071);
    Object localObject = this.GER.getValue();
    s.s(localObject, "<get-speedCtrlBtn>(...)");
    localObject = (View)localObject;
    AppMethodBeat.o(344071);
    return localObject;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<TextView>
  {
    a(HorizontalVideoSeekBarLayout paramHorizontalVideoSeekBarLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements a<View>
  {
    b(HorizontalVideoSeekBarLayout paramHorizontalVideoSeekBarLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<TextView>
  {
    c(HorizontalVideoSeekBarLayout paramHorizontalVideoSeekBarLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/video/FinderLongVideoPlayerSeekBar;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements a<FinderLongVideoPlayerSeekBar>
  {
    d(HorizontalVideoSeekBarLayout paramHorizontalVideoSeekBarLayout)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements a<View>
  {
    e(HorizontalVideoSeekBarLayout paramHorizontalVideoSeekBarLayout)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.HorizontalVideoSeekBarLayout
 * JD-Core Version:    0.7.0.1
 */
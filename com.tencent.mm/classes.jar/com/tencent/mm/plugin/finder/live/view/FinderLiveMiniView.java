package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.d.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.mini.AbsLiveMiniView;
import com.tencent.mm.loader.f.e;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.api.i;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.loader.t;
import com.tencent.mm.plugin.finder.loader.w;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.ar;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveMiniView;", "Lcom/tencent/mm/live/core/mini/AbsLiveMiniView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "anchorUsername", "closeBtn", "Landroid/widget/ImageView;", "closeGroup", "Landroid/widget/RelativeLayout;", "enablePreloadLive", "", "isAnchor", "state", "stateContainer", "Landroid/view/View;", "stateIv", "stateTv", "Landroid/widget/TextView;", "applyState", "", "floatScene", "inAnchorMode", "loadBackgroundImage", "releaseState", "setState", "newState", "setupClickListener", "clickListener", "Landroid/view/View$OnClickListener;", "closeClickListener", "setupMiniView", "showDisconnectView", "showFinishView", "showNorlView", "showPauseView", "updateState", "plugin-finder_release"})
public final class FinderLiveMiniView
  extends AbsLiveMiniView
{
  private final String TAG;
  public boolean fFE;
  private final ImageView kHA;
  private String kig;
  private int state;
  private final TextView yVc;
  private final View yVd;
  private final ImageView yVe;
  private final RelativeLayout yVf;
  private boolean yVg;
  
  public FinderLiveMiniView(Context paramContext)
  {
    this(paramContext, null, 0);
    AppMethodBeat.i(284282);
    AppMethodBeat.o(284282);
  }
  
  public FinderLiveMiniView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(284283);
    AppMethodBeat.o(284283);
  }
  
  public FinderLiveMiniView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(284281);
    this.TAG = "FinderLiveMiniView";
    this.kig = "";
    paramAttributeSet = com.tencent.c.a.a.a.a.a.Zlt;
    if (((Number)com.tencent.c.a.a.a.a.a.imw().aSr()).intValue() == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.yVg = bool;
      View.inflate(paramContext, b.g.finder_live_mini_view_ui, (ViewGroup)this);
      paramContext = findViewById(b.f.finder_live_mini_view_close_btn);
      p.j(paramContext, "findViewById(R.id.finder_live_mini_view_close_btn)");
      this.kHA = ((ImageView)paramContext);
      paramContext = findViewById(b.f.finder_live_mini_view_state_tv);
      p.j(paramContext, "findViewById(R.id.finder_live_mini_view_state_tv)");
      this.yVc = ((TextView)paramContext);
      paramContext = findViewById(b.f.finder_live_mini_view_state_container);
      p.j(paramContext, "findViewById(R.id.finder…ini_view_state_container)");
      this.yVd = paramContext;
      paramContext = findViewById(b.f.finder_live_mini_view_state_iv);
      p.j(paramContext, "findViewById(R.id.finder_live_mini_view_state_iv)");
      this.yVe = ((ImageView)paramContext);
      paramContext = findViewById(b.f.finder_live_mini_view_close_group);
      p.j(paramContext, "findViewById(R.id.finder…ve_mini_view_close_group)");
      this.yVf = ((RelativeLayout)paramContext);
      this.yVe.setClipToOutline(true);
      this.yVe.setOutlineProvider((ViewOutlineProvider)new com.tencent.mm.live.core.mini.d(com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 8)));
      this.yVe.setVisibility(8);
      this.yVd.setVisibility(8);
      AppMethodBeat.o(284281);
      return;
    }
  }
  
  private final void dFe()
  {
    AppMethodBeat.i(284275);
    Object localObject;
    if (this.kig != null)
    {
      localObject = com.tencent.mm.plugin.finder.api.d.wZQ;
      localObject = d.a.aAK(this.kig);
    }
    while (localObject != null)
    {
      localObject = ((i)localObject).field_liveCoverImg;
      if (localObject != null)
      {
        t localt = t.ztT;
        t.dJe().bQ(new com.tencent.mm.plugin.finder.loader.x((String)localObject, u.Alz)).a((e)new a(this)).tA();
        AppMethodBeat.o(284275);
        return;
        localObject = null;
      }
      else
      {
        AppMethodBeat.o(284275);
        return;
      }
    }
    AppMethodBeat.o(284275);
  }
  
  private final void dFf()
  {
    AppMethodBeat.i(284277);
    Object localObject;
    Context localContext;
    if (com.tencent.mm.ae.d.dr(this.state, 4))
    {
      localObject = this.yVc;
      localContext = getContext();
      p.j(localContext, "context");
      ((TextView)localObject).setText((CharSequence)localContext.getResources().getString(b.j.live_mini_state_has_closed));
      this.yVe.setVisibility(0);
      this.yVd.setVisibility(0);
      if (this.yVg) {
        dFe();
      }
      int k = getChildCount();
      int i = 0;
      if (i < k)
      {
        localObject = getChildAt(i);
        p.j(localObject, "it");
        int j;
        if (((View)localObject).getId() != b.f.finder_live_mini_view)
        {
          j = 1;
          label122:
          if (j == 0) {
            break label149;
          }
        }
        for (;;)
        {
          if (localObject != null) {
            ((View)localObject).getVisibility();
          }
          i += 1;
          break;
          j = 0;
          break label122;
          label149:
          localObject = null;
        }
      }
      AppMethodBeat.o(284277);
      return;
    }
    if (com.tencent.mm.ae.d.dr(this.state, 2))
    {
      localObject = this.yVc;
      localContext = getContext();
      p.j(localContext, "context");
      ((TextView)localObject).setText((CharSequence)localContext.getResources().getString(b.j.live_mini_state_pause));
      this.yVe.setVisibility(0);
      this.yVd.setVisibility(0);
      if (this.yVg) {
        dFe();
      }
      AppMethodBeat.o(284277);
      return;
    }
    if (com.tencent.mm.ae.d.dr(this.state, 1))
    {
      localObject = this.yVc;
      localContext = getContext();
      p.j(localContext, "context");
      ((TextView)localObject).setText((CharSequence)localContext.getResources().getString(b.j.live_mini_state_disconnect));
      this.yVe.setVisibility(0);
      this.yVd.setVisibility(0);
      if (this.yVg) {
        dFe();
      }
      AppMethodBeat.o(284277);
      return;
    }
    this.yVe.setVisibility(8);
    this.yVd.setVisibility(8);
    AppMethodBeat.o(284277);
  }
  
  public final void a(View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(284276);
    p.k(paramOnClickListener1, "clickListener");
    p.k(paramOnClickListener2, "closeClickListener");
    setOnClickListener(paramOnClickListener1);
    this.kHA.setOnClickListener(paramOnClickListener2);
    AppMethodBeat.o(284276);
  }
  
  public final int aMn()
  {
    return 15;
  }
  
  public final void bm(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(284274);
    this.fFE = paramBoolean;
    if (paramBoolean) {
      this.yVf.setVisibility(8);
    }
    this.kig = paramString;
    if (!this.yVg) {
      dFe();
    }
    AppMethodBeat.o(284274);
  }
  
  public final String getTAG()
  {
    return this.TAG;
  }
  
  public final void setState(int paramInt)
  {
    AppMethodBeat.i(284278);
    this.state = paramInt;
    new StringBuilder("setState newState:").append(paramInt).append(", state:").append(this.state);
    h.ioq();
    dFf();
    AppMethodBeat.o(284278);
  }
  
  public final void tj(int paramInt)
  {
    AppMethodBeat.i(284279);
    this.state |= paramInt;
    new StringBuilder("applyState applyState:").append(paramInt).append(", state:").append(this.state);
    h.ioq();
    dFf();
    AppMethodBeat.o(284279);
  }
  
  public final void tk(int paramInt)
  {
    AppMethodBeat.i(284280);
    this.state &= (paramInt ^ 0xFFFFFFFF);
    new StringBuilder("applyState releaseState:").append(paramInt).append(", state:").append(this.state);
    h.ioq();
    dFf();
    AppMethodBeat.o(284280);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "kotlin.jvm.PlatformType", "view", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete", "com/tencent/mm/plugin/finder/live/view/FinderLiveMiniView$loadBackgroundImage$1$1$1", "com/tencent/mm/plugin/finder/live/view/FinderLiveMiniView$$special$$inlined$let$lambda$1"})
  static final class a<T, R>
    implements e<w, Bitmap>
  {
    a(FinderLiveMiniView paramFinderLiveMiniView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveMiniView
 * JD-Core Version:    0.7.0.1
 */
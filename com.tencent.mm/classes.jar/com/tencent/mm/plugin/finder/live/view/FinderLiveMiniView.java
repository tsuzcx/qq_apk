package com.tencent.mm.plugin.finder.live.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.core.mini.AbsLiveMiniView;
import com.tencent.mm.plugin.finder.api.c;
import com.tencent.mm.plugin.finder.api.c.a;
import com.tencent.mm.plugin.finder.api.g;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/view/FinderLiveMiniView;", "Lcom/tencent/mm/live/core/mini/AbsLiveMiniView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "closeBtn", "Landroid/widget/ImageView;", "closeGroup", "Landroid/widget/RelativeLayout;", "isAnchor", "", "stateIv", "stateTv", "Landroid/widget/TextView;", "floatScene", "inAnchorMode", "setupClickListener", "", "clickListener", "Landroid/view/View$OnClickListener;", "closeClickListener", "setupMiniView", "anchorUsername", "", "updateState", "state", "Lcom/tencent/mm/live/core/mini/LiveMiniState;", "plugin-finder_release"})
public final class FinderLiveMiniView
  extends AbsLiveMiniView
{
  public boolean dMz;
  private final ImageView hTd;
  private final TextView uzB;
  private final ImageView uzC;
  private final RelativeLayout uzD;
  
  public FinderLiveMiniView(Context paramContext)
  {
    this(paramContext, null, 0);
    AppMethodBeat.i(247532);
    AppMethodBeat.o(247532);
  }
  
  public FinderLiveMiniView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(247533);
    AppMethodBeat.o(247533);
  }
  
  public FinderLiveMiniView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(247531);
    View.inflate(paramContext, 2131494443, (ViewGroup)this);
    paramContext = findViewById(2131301198);
    p.g(paramContext, "findViewById(R.id.finder_live_mini_view_close_btn)");
    this.hTd = ((ImageView)paramContext);
    paramContext = findViewById(2131301201);
    p.g(paramContext, "findViewById(R.id.finder_live_mini_view_state_tv)");
    this.uzB = ((TextView)paramContext);
    paramContext = findViewById(2131301200);
    p.g(paramContext, "findViewById(R.id.finder_live_mini_view_state_iv)");
    this.uzC = ((ImageView)paramContext);
    paramContext = findViewById(2131301199);
    p.g(paramContext, "findViewById(R.id.finder…ve_mini_view_close_group)");
    this.uzD = ((RelativeLayout)paramContext);
    this.uzC.setClipToOutline(true);
    this.uzC.setOutlineProvider((ViewOutlineProvider)new com.tencent.mm.live.core.mini.e(com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 8)));
    this.uzC.setVisibility(8);
    this.uzB.setVisibility(8);
    AppMethodBeat.o(247531);
  }
  
  public final void a(View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(247529);
    p.h(paramOnClickListener1, "clickListener");
    p.h(paramOnClickListener2, "closeClickListener");
    setOnClickListener(paramOnClickListener1);
    this.hTd.setOnClickListener(paramOnClickListener2);
    AppMethodBeat.o(247529);
  }
  
  public final int aEg()
  {
    return 15;
  }
  
  public final void b(com.tencent.mm.live.core.mini.d paramd)
  {
    AppMethodBeat.i(247530);
    p.h(paramd, "state");
    switch (g.$EnumSwitchMapping$0[paramd.ordinal()])
    {
    default: 
      AppMethodBeat.o(247530);
      return;
    case 1: 
      this.uzC.setVisibility(8);
      this.uzB.setVisibility(8);
      AppMethodBeat.o(247530);
      return;
    case 2: 
      paramd = this.uzB;
      localContext = getContext();
      p.g(localContext, "context");
      paramd.setText((CharSequence)localContext.getResources().getString(2131762336));
      this.uzC.setVisibility(0);
      this.uzB.setVisibility(0);
      AppMethodBeat.o(247530);
      return;
    }
    paramd = this.uzB;
    Context localContext = getContext();
    p.g(localContext, "context");
    paramd.setText((CharSequence)localContext.getResources().getString(2131762337));
    this.uzC.setVisibility(0);
    this.uzB.setVisibility(0);
    int k = getChildCount();
    int i = 0;
    label190:
    int j;
    if (i < k)
    {
      paramd = getChildAt(i);
      p.g(paramd, "it");
      if (paramd.getId() == 2131301197) {
        break label239;
      }
      j = 1;
      label219:
      if (j == 0) {
        break label244;
      }
    }
    for (;;)
    {
      if (paramd != null) {
        paramd.getVisibility();
      }
      i += 1;
      break label190;
      break;
      label239:
      j = 0;
      break label219;
      label244:
      paramd = null;
    }
  }
  
  public final void bi(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(247528);
    this.dMz = paramBoolean;
    if (paramBoolean) {
      this.uzD.setVisibility(8);
    }
    Object localObject;
    if (paramString != null)
    {
      localObject = c.tsp;
      paramString = c.a.asG(paramString);
    }
    while (paramString != null)
    {
      paramString = paramString.field_avatarUrl;
      if (paramString != null)
      {
        localObject = m.uJa;
        m.djY().bQ(new com.tencent.mm.plugin.finder.loader.a(paramString)).a((com.tencent.mm.loader.f.e)new a(this)).vC();
        AppMethodBeat.o(247528);
        return;
        paramString = null;
      }
      else
      {
        AppMethodBeat.o(247528);
        return;
      }
    }
    AppMethodBeat.o(247528);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "kotlin.jvm.PlatformType", "view", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete", "com/tencent/mm/plugin/finder/live/view/FinderLiveMiniView$setupMiniView$1$1$1", "com/tencent/mm/plugin/finder/live/view/FinderLiveMiniView$$special$$inlined$let$lambda$1"})
  static final class a<T, R>
    implements com.tencent.mm.loader.f.e<o, Bitmap>
  {
    a(FinderLiveMiniView paramFinderLiveMiniView) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.view.FinderLiveMiniView
 * JD-Core Version:    0.7.0.1
 */
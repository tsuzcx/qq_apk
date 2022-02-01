package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.u;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.t;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorCameraOptPlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "clickArea", "Landroid/view/View;", "icon", "Landroid/widget/ImageView;", "likeCntTv", "Landroid/widget/TextView;", "likeIcon", "canClearScreen", "", "updateLikeCnt", "", "likeCnt", "", "plugin-finder_release"})
public final class k
  extends d
{
  private final View clickArea;
  final com.tencent.mm.live.c.b hOp;
  private final ImageView kc;
  private final ImageView rNa;
  final TextView umN;
  
  public k(final ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(246440);
    this.hOp = paramb;
    paramb = paramViewGroup.findViewById(2131300940);
    p.g(paramb, "root.findViewById(R.id.f…ve_camera_opt_click_area)");
    this.clickArea = paramb;
    paramb = paramViewGroup.findViewById(2131300941);
    p.g(paramb, "root.findViewById(R.id.f…der_live_camera_opt_icon)");
    this.kc = ((ImageView)paramb);
    paramb = paramViewGroup.findViewById(2131300873);
    p.g(paramb, "root.findViewById(R.id.f…chor_like_indicator_icon)");
    this.rNa = ((ImageView)paramb);
    paramb = paramViewGroup.findViewById(2131300874);
    p.g(paramb, "root.findViewById(R.id.f…anchor_like_indicator_tv)");
    this.umN = ((TextView)paramb);
    this.clickArea.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(246437);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorCameraOptPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = m.vVH;
        if (m.i(this.umO.getLiveData())) {
          u.makeText(paramViewGroup.getContext(), 2131760148, 0).show();
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorCameraOptPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(246437);
          return;
          this.umO.hOp.statusChange(b.c.hNx, new Bundle());
        }
      }
    });
    paramb = this.kc;
    Context localContext = paramViewGroup.getContext();
    p.g(localContext, "root.context");
    paramb.setImageDrawable(ar.e(localContext.getResources().getDrawable(2131690491), -1));
    if (!isLandscape()) {
      paramViewGroup.post((Runnable)new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(246438);
          Object localObject = this.hOA.getLayoutParams();
          if (localObject == null)
          {
            localObject = new t("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            AppMethodBeat.o(246438);
            throw ((Throwable)localObject);
          }
          localObject = (ViewGroup.MarginLayoutParams)localObject;
          ((ViewGroup.MarginLayoutParams)localObject).bottomMargin += au.aD(this.hOA.getContext());
          AppMethodBeat.o(246438);
        }
      });
    }
    AppMethodBeat.o(246440);
  }
  
  public final boolean dgK()
  {
    return true;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  public static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    public a(k paramk, int paramInt)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.k
 * JD-Core Version:    0.7.0.1
 */
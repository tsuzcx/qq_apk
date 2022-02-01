package com.tencent.mm.plugin.finder.live.plugin;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.c.b.b;
import com.tencent.mm.live.c.b.c;
import com.tencent.mm.plugin.finder.live.view.FinderLiveLinkMicStateContainer;
import com.tencent.mm.plugin.finder.report.live.k;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;
import org.libpag.PAGFile;
import org.libpag.PAGView;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLinkMicStatePlugin;", "Lcom/tencent/mm/plugin/finder/live/plugin/FinderBaseLivePlugin;", "Landroid/view/View$OnClickListener;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "SHEET_ITEM_CLOSE_LINK_APPLY", "", "TAG", "", "hangupBtn", "Landroid/view/View;", "kotlin.jvm.PlatformType", "linkBottomSheet", "Lcom/tencent/mm/ui/widget/dialog/MMBottomSheet;", "linkedGroup", "linkedUserNameTv", "Landroid/widget/TextView;", "rootView", "Lcom/tencent/mm/plugin/finder/live/view/FinderLiveLinkMicStateContainer;", "waitGroup", "waitIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "waitTv", "waveIcon", "Lorg/libpag/PAGView;", "buildCloseDialog", "", "canClearScreen", "", "fillLinkMicUserInfo", "hideStatePanel", "onClick", "v", "showStatePanel", "updateLinkStateUI", "plugin-finder_release"})
public final class p
  extends d
  implements View.OnClickListener
{
  private final String TAG;
  private final com.tencent.mm.live.c.b hOp;
  private final FinderLiveLinkMicStateContainer unj;
  private final View unk;
  private final TextView unl;
  private final View unm;
  private final PAGView unn;
  private final View uno;
  private final WeImageView unp;
  private final TextView unq;
  
  public p(ViewGroup paramViewGroup, com.tencent.mm.live.c.b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(246486);
    this.hOp = paramb;
    this.TAG = "Finder.FinderLiveLinkMicStatePlugin";
    this.unj = ((FinderLiveLinkMicStateContainer)paramViewGroup.findViewById(2131301127));
    this.unk = paramViewGroup.findViewById(2131301121);
    this.unl = ((TextView)paramViewGroup.findViewById(2131301124));
    this.unm = paramViewGroup.findViewById(2131301123);
    this.unn = ((PAGView)paramViewGroup.findViewById(2131301126));
    this.uno = paramViewGroup.findViewById(2131301131);
    this.unp = ((WeImageView)paramViewGroup.findViewById(2131301119));
    this.unq = ((TextView)paramViewGroup.findViewById(2131301120));
    this.unj.diw();
    this.unm.setOnClickListener((View.OnClickListener)this);
    paramb = this.unn;
    kotlin.g.b.p.g(paramb, "waveIcon");
    paramViewGroup = paramViewGroup.getContext();
    kotlin.g.b.p.g(paramViewGroup, "root.context");
    paramb.setFile(PAGFile.Load(paramViewGroup.getAssets(), "finder_live_shopping_promoting.pag"));
    this.unn.setRepeatCount(-1);
    AppMethodBeat.o(246486);
  }
  
  public final boolean dgK()
  {
    return true;
  }
  
  public final void dgV()
  {
    AppMethodBeat.i(246482);
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(246482);
  }
  
  public final void dgW()
  {
    AppMethodBeat.i(246483);
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new b(this));
    AppMethodBeat.o(246483);
  }
  
  public final void dgX()
  {
    AppMethodBeat.i(246484);
    com.tencent.mm.ac.d.h((kotlin.g.a.a)new a(this));
    AppMethodBeat.o(246484);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(246485);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLinkMicStatePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if (paramView != null)
    {
      paramView = Integer.valueOf(paramView.getId());
      if (paramView != null) {
        break label83;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/plugin/FinderLiveAnchorLinkMicStatePlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(246485);
      return;
      paramView = null;
      break;
      label83:
      if (paramView.intValue() == 2131301123)
      {
        b.b.a(this.hOp, b.c.hNP);
        paramView = k.vkd;
        k.dpl().vlK = true;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.a<x>
  {
    a(p paramp)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(p paramp)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<x>
  {
    c(p paramp)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.plugin.p
 * JD-Core Version:    0.7.0.1
 */
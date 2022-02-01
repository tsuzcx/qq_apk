package com.tencent.mm.live.c;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.g;
import com.tencent.mm.live.b.h;
import com.tencent.mm.live.b.j;
import com.tencent.mm.live.b.u;
import com.tencent.mm.protocal.protobuf.crq;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.base.w;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/plugin/LiveVisitorCommentPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "banCommentCallback", "Lkotlin/Function1;", "", "", "inputHintDescTv", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "inputHintTv", "Landroid/view/View;", "inputImg", "Landroid/widget/ImageView;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "udpateBanCommentState", "plugin-logic_release"})
public final class bg
  extends a
{
  private final b kCU;
  private final kotlin.g.a.b<String, x> kDR;
  private final ImageView kHs;
  private final View kHt;
  private final TextView kHu;
  
  public bg(final ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(188569);
    this.kCU = paramb;
    this.kHs = ((ImageView)paramViewGroup.findViewById(b.e.live_input_img));
    this.kHt = paramViewGroup.findViewById(b.e.live_input_hint);
    this.kHu = ((TextView)paramViewGroup.findViewById(b.e.live_input_desc_tv));
    this.kDR = ((kotlin.g.a.b)new a(this));
    aPK();
    this.kHt.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(200972);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveVisitorCommentPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = u.kwz;
        if (u.aOr().ROp)
        {
          paramAnonymousView = new Bundle();
          paramAnonymousView.putBoolean("PARAM_IS_ENTERING_COMMENT", true);
          bg.a(this.kHv).statusChange(b.c.kzy, paramAnonymousView);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveVisitorCommentPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(200972);
          return;
          w.makeText(paramViewGroup.getContext(), (CharSequence)com.tencent.mm.ci.a.ba(paramViewGroup.getContext(), b.h.live_tip_ban_comment), 0).show();
        }
      }
    });
    if (paramViewGroup.findViewById(b.e.content_root_view) != null)
    {
      paramb = new RelativeLayout.LayoutParams(-2, -2);
      paramb.bottomMargin = ax.aB(paramViewGroup.getContext());
      paramViewGroup = paramViewGroup.findViewById(b.e.content_root_view);
      p.j(paramViewGroup, "root.findViewById<Relati…>(R.id.content_root_view)");
      ((RelativeLayout)paramViewGroup).setLayoutParams((ViewGroup.LayoutParams)paramb);
    }
    paramViewGroup = j.kue;
    j.a(name(), this.kDR);
    AppMethodBeat.o(188569);
  }
  
  public final void aPK()
  {
    AppMethodBeat.i(188567);
    Object localObject = u.kwz;
    if (u.aOr().ROp)
    {
      localObject = this.kHu;
      p.j(localObject, "inputHintDescTv");
      localContext = this.kiF.getContext();
      p.j(localContext, "root.context");
      ((TextView)localObject).setText((CharSequence)localContext.getResources().getString(b.h.live_input_title));
      localObject = this.kHs;
      localContext = this.kiF.getContext();
      p.j(localContext, "root.context");
      ((ImageView)localObject).setImageDrawable(au.e(localContext.getResources().getDrawable(b.g.icons_filled_chat), -1));
      AppMethodBeat.o(188567);
      return;
    }
    localObject = this.kHu;
    p.j(localObject, "inputHintDescTv");
    Context localContext = this.kiF.getContext();
    p.j(localContext, "root.context");
    ((TextView)localObject).setText((CharSequence)localContext.getResources().getString(b.h.live_input_title));
    localObject = this.kHs;
    localContext = this.kiF.getContext();
    p.j(localContext, "root.context");
    ((ImageView)localObject).setImageDrawable(au.e(localContext.getResources().getDrawable(b.g.icons_filled_ban_comment), -1));
    AppMethodBeat.o(188567);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(188568);
    p.k(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (bh.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(188568);
      return;
      tU(8);
      AppMethodBeat.o(188568);
      return;
      tU(0);
      AppMethodBeat.o(188568);
      return;
      if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") == true))
      {
        tU(8);
        AppMethodBeat.o(188568);
        return;
      }
      tU(0);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "<anonymous parameter 0>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.b<String, x>
  {
    a(bg parambg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.bg
 * JD-Core Version:    0.7.0.1
 */
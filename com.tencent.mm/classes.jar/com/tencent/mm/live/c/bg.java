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
import com.tencent.mm.live.b.m;
import com.tencent.mm.protocal.protobuf.civ;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.base.u;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/plugin/LiveVisitorCommentPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "banCommentCallback", "Lkotlin/Function1;", "", "", "inputHintDescTv", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "inputHintTv", "Landroid/view/View;", "inputImg", "Landroid/widget/ImageView;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "udpateBanCommentState", "plugin-logic_release"})
public final class bg
  extends a
{
  final b hOy;
  private final kotlin.g.a.b<String, kotlin.x> hPv;
  private final ImageView hSV;
  private final View hSW;
  private final TextView hSX;
  
  public bg(final ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(208218);
    this.hOy = paramb;
    this.hSV = ((ImageView)paramViewGroup.findViewById(2131303407));
    this.hSW = paramViewGroup.findViewById(2131303406);
    this.hSX = ((TextView)paramViewGroup.findViewById(2131303404));
    this.hPv = ((kotlin.g.a.b)new a(this));
    aHM();
    this.hSW.setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(208212);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveVisitorCommentPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = com.tencent.mm.live.b.x.hJf;
        if (com.tencent.mm.live.b.x.aGr().KNv)
        {
          paramAnonymousView = new Bundle();
          paramAnonymousView.putBoolean("PARAM_IS_ENTERING_COMMENT", true);
          this.hSY.hOy.statusChange(b.c.hMd, paramAnonymousView);
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveVisitorCommentPlugin$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(208212);
          return;
          u.makeText(paramViewGroup.getContext(), (CharSequence)com.tencent.mm.cb.a.aI(paramViewGroup.getContext(), 2131762423), 0).show();
        }
      }
    });
    if (paramViewGroup.findViewById(2131299216) != null)
    {
      paramb = new RelativeLayout.LayoutParams(-2, -2);
      paramb.bottomMargin = au.aD(paramViewGroup.getContext());
      paramViewGroup = paramViewGroup.findViewById(2131299216);
      p.g(paramViewGroup, "root.findViewById<Relati…>(R.id.content_root_view)");
      ((RelativeLayout)paramViewGroup).setLayoutParams((ViewGroup.LayoutParams)paramb);
    }
    paramViewGroup = m.hGg;
    m.a(name(), this.hPv);
    AppMethodBeat.o(208218);
  }
  
  public final void aHM()
  {
    AppMethodBeat.i(208216);
    Object localObject = com.tencent.mm.live.b.x.hJf;
    if (com.tencent.mm.live.b.x.aGr().KNv)
    {
      localObject = this.hSX;
      p.g(localObject, "inputHintDescTv");
      localContext = this.hwr.getContext();
      p.g(localContext, "root.context");
      ((TextView)localObject).setText((CharSequence)localContext.getResources().getString(2131762302));
      localObject = this.hSV;
      localContext = this.hwr.getContext();
      p.g(localContext, "root.context");
      ((ImageView)localObject).setImageDrawable(ar.e(localContext.getResources().getDrawable(2131690508), -1));
      AppMethodBeat.o(208216);
      return;
    }
    localObject = this.hSX;
    p.g(localObject, "inputHintDescTv");
    Context localContext = this.hwr.getContext();
    p.g(localContext, "root.context");
    ((TextView)localObject).setText((CharSequence)localContext.getResources().getString(2131762302));
    localObject = this.hSV;
    localContext = this.hwr.getContext();
    p.g(localContext, "root.context");
    ((ImageView)localObject).setImageDrawable(ar.e(localContext.getResources().getDrawable(2131690488), -1));
    AppMethodBeat.o(208216);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    AppMethodBeat.i(208217);
    p.h(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (bh.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(208217);
      return;
      rg(8);
      AppMethodBeat.o(208217);
      return;
      rg(0);
      AppMethodBeat.o(208217);
      return;
      if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") == true))
      {
        rg(8);
        AppMethodBeat.o(208217);
        return;
      }
      rg(0);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "<anonymous parameter 0>", "", "invoke"})
  static final class a
    extends q
    implements kotlin.g.a.b<String, kotlin.x>
  {
    a(bg parambg)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.c.bg
 * JD-Core Version:    0.7.0.1
 */
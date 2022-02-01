package com.tencent.mm.live.b;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
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
import com.tencent.mm.live.model.j;
import com.tencent.mm.protocal.protobuf.dio;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.bf;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/plugin/LiveVisitorCommentPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "root", "Landroid/view/ViewGroup;", "statueMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "banCommentCallback", "Lkotlin/Function1;", "", "", "inputHintDescTv", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "inputHintTv", "Landroid/view/View;", "inputImg", "Landroid/widget/ImageView;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "udpateBanCommentState", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class af
  extends a
{
  private final b ngl;
  private final kotlin.g.a.b<String, ah> nhh;
  private final ImageView nki;
  private final View nkj;
  private final TextView nkk;
  
  public af(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(247389);
    this.ngl = paramb;
    this.nki = ((ImageView)paramViewGroup.findViewById(b.e.live_input_img));
    this.nkj = paramViewGroup.findViewById(b.e.live_input_hint);
    this.nkk = ((TextView)paramViewGroup.findViewById(b.e.live_input_desc_tv));
    this.nhh = ((kotlin.g.a.b)new b(this));
    bjy();
    this.nkj.setOnClickListener(new af..ExternalSyntheticLambda0(this, paramViewGroup));
    if (paramViewGroup.findViewById(b.e.content_root_view) != null)
    {
      paramb = new RelativeLayout.LayoutParams(-2, -2);
      paramb.bottomMargin = bf.bk(paramViewGroup.getContext());
      ((RelativeLayout)paramViewGroup.findViewById(b.e.content_root_view)).setLayoutParams((ViewGroup.LayoutParams)paramb);
    }
    paramViewGroup = j.mXT;
    j.a(name(), this.nhh);
    AppMethodBeat.o(247389);
  }
  
  private static final void a(af paramaf, ViewGroup paramViewGroup, View paramView)
  {
    AppMethodBeat.i(247401);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramaf);
    localb.cH(paramViewGroup);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveVisitorCommentPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramaf, "this$0");
    s.u(paramViewGroup, "$root");
    paramView = com.tencent.mm.live.model.u.mZl;
    if (com.tencent.mm.live.model.u.bie().YLD)
    {
      paramViewGroup = new Bundle();
      paramViewGroup.putBoolean("PARAM_IS_ENTERING_COMMENT", true);
      paramaf.ngl.statusChange(b.c.ncO, paramViewGroup);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/plugin/LiveVisitorCommentPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(247401);
      return;
      aa.makeText(paramViewGroup.getContext(), (CharSequence)com.tencent.mm.cd.a.bt(paramViewGroup.getContext(), b.h.live_tip_ban_comment), 0).show();
    }
  }
  
  public final void bjy()
  {
    AppMethodBeat.i(247417);
    com.tencent.mm.live.model.u localu = com.tencent.mm.live.model.u.mZl;
    if (com.tencent.mm.live.model.u.bie().YLD)
    {
      this.nkk.setText((CharSequence)this.mJe.getContext().getResources().getString(b.h.live_input_title));
      this.nki.setImageDrawable(bb.e(this.mJe.getContext().getResources().getDrawable(b.g.icons_filled_chat), -1));
      AppMethodBeat.o(247417);
      return;
    }
    this.nkk.setText((CharSequence)this.mJe.getContext().getResources().getString(b.h.live_input_title));
    this.nki.setImageDrawable(bb.e(this.mJe.getContext().getResources().getDrawable(b.g.icons_filled_ban_comment), -1));
    AppMethodBeat.o(247417);
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    int i = 1;
    AppMethodBeat.i(247423);
    s.u(paramc, "status");
    super.statusChange(paramc, paramBundle);
    switch (a.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    }
    for (;;)
    {
      AppMethodBeat.o(247423);
      return;
      tO(8);
      AppMethodBeat.o(247423);
      return;
      tO(0);
      AppMethodBeat.o(247423);
      return;
      if ((paramBundle != null) && (paramBundle.getBoolean("PARAM_IS_ENTERING_COMMENT") == true)) {}
      while (i != 0)
      {
        tO(8);
        AppMethodBeat.o(247423);
        return;
        i = 0;
      }
      tO(0);
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "<anonymous parameter 0>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.b<String, ah>
  {
    b(af paramaf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.b.af
 * JD-Core Version:    0.7.0.1
 */
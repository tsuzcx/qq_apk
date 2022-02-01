package com.tencent.mm.live.c;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/live/plugin/LiveExceptionPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Landroid/view/View$OnClickListener;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "backBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "descTv", "Landroid/widget/TextView;", "icon", "Landroid/widget/ImageView;", "okBtn", "Landroid/widget/Button;", "titleTv", "onClick", "", "v", "Landroid/view/View;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class r
  extends a
  implements View.OnClickListener
{
  private final b IIs;
  private final WeImageView KuV;
  private final Button hJh;
  private final ImageView hg;
  private final TextView lEA;
  private final TextView titleTv;
  
  public r(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(202915);
    this.IIs = paramb;
    this.KuV = ((WeImageView)paramViewGroup.findViewById(2131307542));
    this.titleTv = ((TextView)paramViewGroup.findViewById(2131307546));
    this.lEA = ((TextView)paramViewGroup.findViewById(2131307544));
    this.hg = ((ImageView)paramViewGroup.findViewById(2131307545));
    this.hJh = ((Button)paramViewGroup.findViewById(2131307543));
    this.KuV.setOnClickListener((View.OnClickListener)this);
    this.hJh.setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(202915);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    Integer localInteger = null;
    AppMethodBeat.i(202914);
    k.h(paramc, "status");
    switch (s.ciE[paramc.ordinal()])
    {
    default: 
      AppMethodBeat.o(202914);
      return;
    }
    if (paramBundle != null)
    {
      paramc = paramBundle.getString("PARAM_LIVE_EXCEPTION_TITLE");
      label57:
      if (paramBundle == null) {
        break label169;
      }
    }
    label169:
    for (String str = paramBundle.getString("PARAM_LIVE_EXCEPTION_DESC");; str = null)
    {
      if (paramBundle != null) {
        localInteger = Integer.valueOf(paramBundle.getInt("PARAM_LIVE_EXCEPTION_ICON_RES"));
      }
      if ((localInteger != null) && (localInteger.intValue() != 0))
      {
        paramBundle = this.pTc.getContext();
        k.g(paramBundle, "root.context");
        paramBundle.getResources().getDrawable(localInteger.intValue());
      }
      paramBundle = this.titleTv;
      k.g(paramBundle, "titleTv");
      paramBundle.setText((CharSequence)paramc);
      paramc = this.lEA;
      k.g(paramc, "descTv");
      paramc.setText((CharSequence)str);
      break;
      paramc = null;
      break label57;
    }
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(202913);
    if (paramView != null)
    {
      paramView = Integer.valueOf(paramView.getId());
      if (paramView != null) {
        break label36;
      }
    }
    label36:
    while (paramView.intValue() != 2131307542)
    {
      if (paramView != null) {
        break label61;
      }
      AppMethodBeat.o(202913);
      return;
      paramView = null;
      break;
    }
    for (;;)
    {
      b.b.a(this.IIs, b.c.FAX);
      label61:
      do
      {
        AppMethodBeat.o(202913);
        return;
      } while (paramView.intValue() != 2131307543);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.c.r
 * JD-Core Version:    0.7.0.1
 */
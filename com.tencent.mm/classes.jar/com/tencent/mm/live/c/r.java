package com.tencent.mm.live.c;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/plugin/LiveExceptionPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Landroid/view/View$OnClickListener;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "backBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "descTv", "Landroid/widget/TextView;", "icon", "Landroid/widget/ImageView;", "okBtn", "Landroid/widget/Button;", "titleTv", "onClick", "", "v", "Landroid/view/View;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class r
  extends a
  implements View.OnClickListener
{
  private final WeImageView gAH;
  private final TextView gAI;
  private final Button gAJ;
  private final b gzb;
  private final ImageView ig;
  private final TextView titleTv;
  
  public r(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(190128);
    this.gzb = paramb;
    this.gAH = ((WeImageView)paramViewGroup.findViewById(2131307623));
    this.titleTv = ((TextView)paramViewGroup.findViewById(2131307627));
    this.gAI = ((TextView)paramViewGroup.findViewById(2131307625));
    this.ig = ((ImageView)paramViewGroup.findViewById(2131307626));
    this.gAJ = ((Button)paramViewGroup.findViewById(2131307624));
    this.gAH.setOnClickListener((View.OnClickListener)this);
    this.gAJ.setOnClickListener((View.OnClickListener)this);
    paramViewGroup = this.gAI;
    k.g(paramViewGroup, "descTv");
    paramViewGroup.setMovementMethod(LinkMovementMethod.getInstance());
    AppMethodBeat.o(190128);
  }
  
  public final void a(b.c paramc, Bundle paramBundle)
  {
    Object localObject2 = null;
    AppMethodBeat.i(190127);
    k.h(paramc, "status");
    switch (s.cfA[paramc.ordinal()])
    {
    default: 
      AppMethodBeat.o(190127);
      return;
    }
    label57:
    CharSequence localCharSequence;
    if (paramBundle != null)
    {
      paramc = paramBundle.getString("PARAM_LIVE_EXCEPTION_TITLE");
      if (paramBundle == null) {
        break label178;
      }
      localCharSequence = paramBundle.getCharSequence("PARAM_LIVE_EXCEPTION_DESC");
      label68:
      if (paramBundle == null) {
        break label183;
      }
    }
    label178:
    label183:
    for (paramBundle = Integer.valueOf(paramBundle.getInt("PARAM_LIVE_EXCEPTION_ICON_RES"));; paramBundle = null)
    {
      Object localObject1 = localObject2;
      if (paramBundle != null)
      {
        localObject1 = localObject2;
        if (paramBundle.intValue() != 0)
        {
          localObject1 = this.gnb.getContext();
          k.g(localObject1, "root.context");
          localObject1 = ((Context)localObject1).getResources().getDrawable(paramBundle.intValue());
        }
      }
      paramBundle = this.titleTv;
      k.g(paramBundle, "titleTv");
      paramBundle.setText((CharSequence)paramc);
      this.gAI.setText(localCharSequence, TextView.BufferType.SPANNABLE);
      this.ig.setImageDrawable((Drawable)localObject1);
      break;
      paramc = null;
      break label57;
      localCharSequence = null;
      break label68;
    }
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(190126);
    if (paramView != null)
    {
      paramView = Integer.valueOf(paramView.getId());
      if (paramView != null) {
        break label36;
      }
    }
    label36:
    while (paramView.intValue() != 2131307623)
    {
      if (paramView != null) {
        break label61;
      }
      AppMethodBeat.o(190126);
      return;
      paramView = null;
      break;
    }
    for (;;)
    {
      b.b.a(this.gzb, b.c.gxL);
      label61:
      do
      {
        AppMethodBeat.o(190126);
        return;
      } while (paramView.intValue() != 2131307624);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.r
 * JD-Core Version:    0.7.0.1
 */
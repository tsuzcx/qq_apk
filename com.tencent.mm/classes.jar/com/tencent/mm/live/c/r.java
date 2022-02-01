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
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/live/plugin/LiveExceptionPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Landroid/view/View$OnClickListener;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "backBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "descTv", "Landroid/widget/TextView;", "icon", "Landroid/widget/ImageView;", "okBtn", "Landroid/widget/Button;", "titleTv", "onClick", "", "v", "Landroid/view/View;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class r
  extends a
  implements View.OnClickListener
{
  private final b hOp;
  private final WeImageView hPV;
  private final TextView hPW;
  private final Button hPX;
  private final ImageView kc;
  private final TextView titleTv;
  
  public r(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(207994);
    this.hOp = paramb;
    this.hPV = ((WeImageView)paramViewGroup.findViewById(2131303385));
    this.titleTv = ((TextView)paramViewGroup.findViewById(2131303389));
    this.hPW = ((TextView)paramViewGroup.findViewById(2131303387));
    this.kc = ((ImageView)paramViewGroup.findViewById(2131303388));
    this.hPX = ((Button)paramViewGroup.findViewById(2131303386));
    this.hPV.setOnClickListener((View.OnClickListener)this);
    this.hPX.setOnClickListener((View.OnClickListener)this);
    paramViewGroup = this.hPW;
    p.g(paramViewGroup, "descTv");
    paramViewGroup.setMovementMethod(LinkMovementMethod.getInstance());
    AppMethodBeat.o(207994);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(207992);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/live/plugin/LiveExceptionPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
    if (paramView != null)
    {
      paramView = Integer.valueOf(paramView.getId());
      if (paramView != null) {
        break label77;
      }
    }
    label77:
    while (paramView.intValue() != 2131303385)
    {
      if (paramView != null) {
        break label99;
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveExceptionPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(207992);
      return;
      paramView = null;
      break;
    }
    for (;;)
    {
      b.b.a(this.hOp, b.c.hLD);
      break;
      label99:
      if (paramView.intValue() != 2131303386) {
        break;
      }
    }
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    Object localObject2 = null;
    AppMethodBeat.i(207993);
    p.h(paramc, "status");
    switch (s.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
      AppMethodBeat.o(207993);
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
          localObject1 = this.hwr.getContext();
          p.g(localObject1, "root.context");
          localObject1 = ((Context)localObject1).getResources().getDrawable(paramBundle.intValue());
        }
      }
      paramBundle = this.titleTv;
      p.g(paramBundle, "titleTv");
      paramBundle.setText((CharSequence)paramc);
      this.hPW.setText(localCharSequence, TextView.BufferType.SPANNABLE);
      this.kc.setImageDrawable((Drawable)localObject1);
      break;
      paramc = null;
      break label57;
      localCharSequence = null;
      break label68;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.c.r
 * JD-Core Version:    0.7.0.1
 */
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
import com.tencent.mm.live.b.e;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/live/plugin/LiveExceptionPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Landroid/view/View$OnClickListener;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "backBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "descTv", "Landroid/widget/TextView;", "icon", "Landroid/widget/ImageView;", "okBtn", "Landroid/widget/Button;", "titleTv", "onClick", "", "v", "Landroid/view/View;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"})
public final class r
  extends a
  implements View.OnClickListener
{
  private final ImageView bwJ;
  private final b kCL;
  private final WeImageView kEr;
  private final TextView kEs;
  private final Button kEt;
  private final TextView titleTv;
  
  public r(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(191876);
    this.kCL = paramb;
    this.kEr = ((WeImageView)paramViewGroup.findViewById(b.e.live_exception_back_btn));
    this.titleTv = ((TextView)paramViewGroup.findViewById(b.e.live_exception_title));
    this.kEs = ((TextView)paramViewGroup.findViewById(b.e.live_exception_desc));
    this.bwJ = ((ImageView)paramViewGroup.findViewById(b.e.live_exception_icon));
    this.kEt = ((Button)paramViewGroup.findViewById(b.e.live_exception_btn));
    this.kEr.setOnClickListener((View.OnClickListener)this);
    this.kEt.setOnClickListener((View.OnClickListener)this);
    paramViewGroup = this.kEs;
    p.j(paramViewGroup, "descTv");
    paramViewGroup.setMovementMethod(LinkMovementMethod.getInstance());
    AppMethodBeat.o(191876);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(191858);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveExceptionPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    int i;
    if (paramView != null)
    {
      paramView = Integer.valueOf(paramView.getId());
      i = b.e.live_exception_back_btn;
      if (paramView != null) {
        break label85;
      }
    }
    label85:
    while (paramView.intValue() != i)
    {
      i = b.e.live_exception_btn;
      if (paramView != null) {
        break label106;
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveExceptionPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(191858);
      return;
      paramView = null;
      break;
    }
    for (;;)
    {
      b.b.a(this.kCL, b.c.kyW);
      break;
      label106:
      if (paramView.intValue() != i) {
        break;
      }
    }
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    Object localObject2 = null;
    AppMethodBeat.i(191868);
    p.k(paramc, "status");
    switch (s.$EnumSwitchMapping$0[paramc.ordinal()])
    {
    default: 
      AppMethodBeat.o(191868);
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
          localObject1 = this.kiF.getContext();
          p.j(localObject1, "root.context");
          localObject1 = ((Context)localObject1).getResources().getDrawable(paramBundle.intValue());
        }
      }
      paramBundle = this.titleTv;
      p.j(paramBundle, "titleTv");
      paramBundle.setText((CharSequence)paramc);
      this.kEs.setText(localCharSequence, TextView.BufferType.SPANNABLE);
      this.bwJ.setImageDrawable((Drawable)localObject1);
      break;
      paramc = null;
      break label57;
      localCharSequence = null;
      break label68;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.c.r
 * JD-Core Version:    0.7.0.1
 */
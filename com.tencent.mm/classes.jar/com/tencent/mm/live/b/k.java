package com.tencent.mm.live.b;

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
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/plugin/LiveExceptionPlugin;", "Lcom/tencent/mm/live/plugin/BaseLivePlugin;", "Landroid/view/View$OnClickListener;", "root", "Landroid/view/ViewGroup;", "statusMonitor", "Lcom/tencent/mm/live/plugin/ILiveStatus;", "(Landroid/view/ViewGroup;Lcom/tencent/mm/live/plugin/ILiveStatus;)V", "backBtn", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "kotlin.jvm.PlatformType", "descTv", "Landroid/widget/TextView;", "icon", "Landroid/widget/ImageView;", "okBtn", "Landroid/widget/Button;", "titleTv", "onClick", "", "v", "Landroid/view/View;", "statusChange", "status", "Lcom/tencent/mm/live/plugin/ILiveStatus$LiveStatus;", "param", "Landroid/os/Bundle;", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class k
  extends a
  implements View.OnClickListener
{
  private final TextView descTv;
  private final ImageView dpM;
  private final b nfT;
  private final WeImageView nhB;
  private final Button nhC;
  private final TextView titleTv;
  
  public k(ViewGroup paramViewGroup, b paramb)
  {
    super(paramViewGroup, paramb);
    AppMethodBeat.i(247058);
    this.nfT = paramb;
    this.nhB = ((WeImageView)paramViewGroup.findViewById(b.e.live_exception_back_btn));
    this.titleTv = ((TextView)paramViewGroup.findViewById(b.e.live_exception_title));
    this.descTv = ((TextView)paramViewGroup.findViewById(b.e.live_exception_desc));
    this.dpM = ((ImageView)paramViewGroup.findViewById(b.e.live_exception_icon));
    this.nhC = ((Button)paramViewGroup.findViewById(b.e.live_exception_btn));
    this.nhB.setOnClickListener((View.OnClickListener)this);
    this.nhC.setOnClickListener((View.OnClickListener)this);
    this.descTv.setMovementMethod(LinkMovementMethod.getInstance());
    AppMethodBeat.o(247058);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(247078);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/plugin/LiveExceptionPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    int i;
    if (paramView == null)
    {
      paramView = null;
      i = b.e.live_exception_back_btn;
      if (paramView != null) {
        break label101;
      }
      label48:
      i = b.e.live_exception_btn;
      if (paramView != null) {
        break label114;
      }
      label56:
      i = 0;
    }
    for (;;)
    {
      if (i != 0) {
        b.b.a(this.nfT, b.c.ncl);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/plugin/LiveExceptionPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(247078);
      return;
      paramView = Integer.valueOf(paramView.getId());
      break;
      label101:
      if (paramView.intValue() != i) {
        break label48;
      }
      i = 1;
      continue;
      label114:
      if (paramView.intValue() != i) {
        break label56;
      }
      i = 1;
    }
  }
  
  public final void statusChange(b.c paramc, Bundle paramBundle)
  {
    Object localObject2 = null;
    AppMethodBeat.i(247101);
    s.u(paramc, "status");
    CharSequence localCharSequence;
    if (a.$EnumSwitchMapping$0[paramc.ordinal()] == 1)
    {
      if (paramBundle != null) {
        break label119;
      }
      paramc = null;
      if (paramBundle != null) {
        break label129;
      }
      localCharSequence = null;
      label38:
      if (paramBundle != null) {
        break label139;
      }
    }
    label129:
    label139:
    for (paramBundle = null;; paramBundle = Integer.valueOf(paramBundle.getInt("PARAM_LIVE_EXCEPTION_ICON_RES")))
    {
      Object localObject1 = localObject2;
      if (paramBundle != null)
      {
        localObject1 = localObject2;
        if (paramBundle.intValue() != 0) {
          localObject1 = this.mJe.getContext().getResources().getDrawable(paramBundle.intValue());
        }
      }
      this.titleTv.setText((CharSequence)paramc);
      this.descTv.setText(localCharSequence, TextView.BufferType.SPANNABLE);
      this.dpM.setImageDrawable((Drawable)localObject1);
      AppMethodBeat.o(247101);
      return;
      label119:
      paramc = paramBundle.getString("PARAM_LIVE_EXCEPTION_TITLE");
      break;
      localCharSequence = paramBundle.getCharSequence("PARAM_LIVE_EXCEPTION_DESC");
      break label38;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.live.b.k
 * JD-Core Version:    0.7.0.1
 */
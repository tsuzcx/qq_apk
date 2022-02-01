package com.tencent.mm.plugin.finder.live.olympic.certificate.widget;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.p.e;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/olympic/certificate/widget/CertificateFaculaWidget;", "Lcom/tencent/mm/plugin/finder/live/olympic/certificate/widget/BaseCertificateWidget;", "", "root", "Landroid/view/ViewGroup;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "(Landroid/view/ViewGroup;Landroidx/lifecycle/LifecycleOwner;)V", "faculaLayout", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "faculaView1", "Landroid/view/View;", "faculaView2", "adjustLayout", "", "getLayoutView", "onChanged", "t", "setVisibility", "isShow", "", "startAnimate", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends a<Object>
{
  private final RelativeLayout CPO;
  final View CPP;
  final View CPQ;
  
  public c(ViewGroup paramViewGroup, q paramq)
  {
    super(paramViewGroup, paramq);
    AppMethodBeat.i(360906);
    this.CPO = ((RelativeLayout)paramViewGroup.findViewById(p.e.BCX));
    this.CPP = paramViewGroup.findViewById(p.e.BCY);
    this.CPQ = paramViewGroup.findViewById(p.e.BCZ);
    AppMethodBeat.o(360906);
  }
  
  public final View getLayoutView()
  {
    AppMethodBeat.i(360911);
    Object localObject = this.CPO;
    s.s(localObject, "faculaLayout");
    localObject = (View)localObject;
    AppMethodBeat.o(360911);
    return localObject;
  }
  
  public final void onChanged(Object paramObject) {}
  
  public final void setVisibility(boolean paramBoolean)
  {
    int j = 0;
    AppMethodBeat.i(360922);
    View localView = this.CPP;
    if (paramBoolean)
    {
      this.CPP.setTranslationY(OT(200));
      i = 0;
      localView.setVisibility(i);
      localView = this.CPQ;
      if (!paramBoolean) {
        break label77;
      }
      this.CPQ.setTranslationY(0.0F);
    }
    label77:
    for (int i = j;; i = 8)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(360922);
      return;
      i = 8;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.olympic.certificate.widget.c
 * JD-Core Version:    0.7.0.1
 */
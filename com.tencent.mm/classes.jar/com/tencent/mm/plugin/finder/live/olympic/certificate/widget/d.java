package com.tencent.mm.plugin.finder.live.olympic.certificate.widget;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.olympic.certificate.b;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/olympic/certificate/widget/CertificateFrameBufferWidget;", "Lcom/tencent/mm/plugin/finder/live/olympic/certificate/widget/CertificatePositiveWidget;", "root", "Landroid/view/ViewGroup;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "serive", "Lcom/tencent/mm/plugin/finder/live/olympic/certificate/ICertificateService;", "(Landroid/view/ViewGroup;Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/mm/plugin/finder/live/olympic/certificate/ICertificateService;)V", "adjustLayout", "", "getLayoutView", "Landroid/view/View;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends g
{
  public d(ViewGroup paramViewGroup, q paramq, b paramb)
  {
    super(paramViewGroup, paramq, paramb);
    AppMethodBeat.i(360904);
    AppMethodBeat.o(360904);
  }
  
  public final void enQ()
  {
    AppMethodBeat.i(360910);
    super.enQ();
    int i = OT(40);
    i = (int)((getScreenWidth() - i * 2) / 0.6385282F);
    Object localObject = this.mJe.getLayoutParams();
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(360910);
      throw ((Throwable)localObject);
    }
    ((ViewGroup.MarginLayoutParams)localObject).height = (i + OT(84) * 2);
    AppMethodBeat.o(360910);
  }
  
  public final View getLayoutView()
  {
    return (View)this.mJe;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.olympic.certificate.widget.d
 * JD-Core Version:    0.7.0.1
 */
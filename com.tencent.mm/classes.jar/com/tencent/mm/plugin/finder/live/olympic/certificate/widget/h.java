package com.tencent.mm.plugin.finder.live.olympic.certificate.widget;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.olympic.certificate.b;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/olympic/certificate/widget/CertificateStateFrameBufferWidget;", "Lcom/tencent/mm/plugin/finder/live/olympic/certificate/widget/CertificatePositiveWidget;", "root", "Landroid/view/ViewGroup;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "serive", "Lcom/tencent/mm/plugin/finder/live/olympic/certificate/ICertificateService;", "(Landroid/view/ViewGroup;Landroidx/lifecycle/LifecycleOwner;Lcom/tencent/mm/plugin/finder/live/olympic/certificate/ICertificateService;)V", "adjustLayout", "", "getLayoutView", "Landroid/view/View;", "updateLayoutView", "t", "Lcom/tencent/mm/plugin/finder/live/olympic/certificate/data/CertificateData;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends g
{
  public h(ViewGroup paramViewGroup, q paramq, b paramb)
  {
    super(paramViewGroup, paramq, paramb);
    AppMethodBeat.i(360921);
    AppMethodBeat.o(360921);
  }
  
  public final void c(com.tencent.mm.plugin.finder.live.olympic.certificate.data.a parama)
  {
    AppMethodBeat.i(360936);
    s.u(parama, "t");
    super.c(parama);
    this.CRh.getViewTreeObserver().addOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)new a(this));
    AppMethodBeat.o(360936);
  }
  
  public final void enQ()
  {
    AppMethodBeat.i(360929);
    int i = (int)(getScreenWidth() / 0.5625F);
    Object localObject = this.mJe.getLayoutParams();
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(360929);
      throw ((Throwable)localObject);
    }
    localObject = (ViewGroup.MarginLayoutParams)localObject;
    ((ViewGroup.MarginLayoutParams)localObject).width = getScreenWidth();
    ((ViewGroup.MarginLayoutParams)localObject).height = i;
    i = OT(48);
    i = getScreenWidth() - i * 2;
    int j = (int)(i / 0.6385282F);
    localObject = this.CRe.getLayoutParams();
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(360929);
      throw ((Throwable)localObject);
    }
    localObject = (ViewGroup.MarginLayoutParams)localObject;
    ((ViewGroup.MarginLayoutParams)localObject).width = i;
    ((ViewGroup.MarginLayoutParams)localObject).height = j;
    localObject = enW().getLayoutParams();
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(360929);
      throw ((Throwable)localObject);
    }
    localObject = (ViewGroup.MarginLayoutParams)localObject;
    ((ViewGroup.MarginLayoutParams)localObject).width = ((int)(i / 1.685714F));
    ((ViewGroup.MarginLayoutParams)localObject).height = ((int)(((ViewGroup.MarginLayoutParams)localObject).width / 0.75F));
    ((ViewGroup.MarginLayoutParams)localObject).topMargin = (-(int)(((ViewGroup.MarginLayoutParams)localObject).height / 3.609375F));
    ((ViewGroup.MarginLayoutParams)localObject).rightMargin = (-(int)(((ViewGroup.MarginLayoutParams)localObject).width / 3.5F));
    localObject = enX().getLayoutParams();
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
      AppMethodBeat.o(360929);
      throw ((Throwable)localObject);
    }
    localObject = (ViewGroup.MarginLayoutParams)localObject;
    ((ViewGroup.MarginLayoutParams)localObject).width = ((int)(i / 1.378505F));
    ((ViewGroup.MarginLayoutParams)localObject).height = ((ViewGroup.MarginLayoutParams)localObject).width;
    ((ViewGroup.MarginLayoutParams)localObject).topMargin = (-((ViewGroup.MarginLayoutParams)localObject).width / 2);
    ((ViewGroup.MarginLayoutParams)localObject).rightMargin = (-((ViewGroup.MarginLayoutParams)localObject).width / 2);
    AppMethodBeat.o(360929);
  }
  
  public final View getLayoutView()
  {
    return (View)this.mJe;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/olympic/certificate/widget/CertificateStateFrameBufferWidget$updateLayoutView$1", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements ViewTreeObserver.OnPreDrawListener
  {
    a(h paramh) {}
    
    public final boolean onPreDraw()
    {
      AppMethodBeat.i(360927);
      this.CRp.CRh.getViewTreeObserver().removeOnPreDrawListener((ViewTreeObserver.OnPreDrawListener)this);
      this.CRp.CRd.setVisibility(8);
      Log.i("BaseOlympicCertificateW", "updateLayoutView: x: " + this.CRp.CRh.getX() + " y: " + this.CRp.CRh.getY() + " height: " + this.CRp.CRe.getHeight() + ", width: " + this.CRp.CRe.getWidth());
      Object localObject = this.CRp.CRe.getLayoutParams();
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        AppMethodBeat.o(360927);
        throw ((Throwable)localObject);
      }
      localObject = (ViewGroup.MarginLayoutParams)localObject;
      h localh = this.CRp;
      ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = ((int)localh.CRh.getY() + localh.CRh.getHeight() - localh.CRe.getHeight() + h.OT(56));
      Log.i("BaseOlympicCertificateW", s.X("updateLayoutView after bottomMargin: ", Integer.valueOf(((ViewGroup.MarginLayoutParams)localObject).bottomMargin)));
      this.CRp.CRe.requestLayout();
      AppMethodBeat.o(360927);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.olympic.certificate.widget.h
 * JD-Core Version:    0.7.0.1
 */
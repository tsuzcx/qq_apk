package com.tencent.mm.plugin.finder.live.olympic.certificate.widget;

import android.animation.Animator.AnimatorListener;
import android.graphics.Point;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewPropertyAnimator;
import androidx.lifecycle.q;
import androidx.lifecycle.x;
import androidx.lifecycle.y;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.bf;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/olympic/certificate/widget/BaseCertificateWidget;", "Data", "Landroidx/lifecycle/Observer;", "Landroid/view/View$OnClickListener;", "root", "Landroid/view/ViewGroup;", "owner", "Landroidx/lifecycle/LifecycleOwner;", "(Landroid/view/ViewGroup;Landroidx/lifecycle/LifecycleOwner;)V", "certificateData", "Landroidx/lifecycle/MutableLiveData;", "getCertificateData", "()Landroidx/lifecycle/MutableLiveData;", "getOwner", "()Landroidx/lifecycle/LifecycleOwner;", "getRoot", "()Landroid/view/ViewGroup;", "scaleDensity", "", "getScaleDensity", "()F", "setScaleDensity", "(F)V", "screenHeight", "", "getScreenHeight", "()I", "setScreenHeight", "(I)V", "screenWidth", "getScreenWidth", "setScreenWidth", "adjustLayout", "", "doTpPx", "dp", "getLayoutView", "Landroid/view/View;", "getLiveData", "mount", "onClick", "v", "reset", "setAlphaAnimate", "view", "isHide", "", "endBlock", "Lkotlin/Function0;", "setVisibility", "isShow", "visibility", "unMount", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class a<Data>
  implements View.OnClickListener, y<Data>
{
  public static final a CPt = new a((byte)0);
  public final x<Data> CPu;
  private float CPv;
  public final ViewGroup mJe;
  private final q owner;
  private int pvg;
  private int sJv;
  
  public a(ViewGroup paramViewGroup, q paramq)
  {
    this.mJe = paramViewGroup;
    this.owner = paramq;
    this.sJv = bf.bf(MMApplicationContext.getContext()).x;
    this.pvg = bf.bf(MMApplicationContext.getContext()).y;
    this.CPu = new x();
    paramViewGroup = com.tencent.mm.plugin.finder.live.olympic.util.a.CRW;
    paramViewGroup = this.mJe.getContext();
    s.s(paramViewGroup, "root.context");
    this.CPv = com.tencent.mm.plugin.finder.live.olympic.util.a.gy(paramViewGroup);
  }
  
  public static int OT(int paramInt)
  {
    com.tencent.mm.plugin.finder.live.olympic.util.a locala = com.tencent.mm.plugin.finder.live.olympic.util.a.CRW;
    return com.tencent.mm.plugin.finder.live.olympic.util.a.OT(paramInt);
  }
  
  public static void a(View paramView, boolean paramBoolean, kotlin.g.a.a<ah> parama)
  {
    float f2 = 0.0F;
    s.u(paramView, "view");
    ViewPropertyAnimator localViewPropertyAnimator;
    if (paramBoolean)
    {
      f1 = 1.0F;
      paramView.setAlpha(f1);
      paramView.setVisibility(0);
      localViewPropertyAnimator = paramView.animate();
      if (!paramBoolean) {
        break label75;
      }
    }
    label75:
    for (float f1 = f2;; f1 = 1.0F)
    {
      localViewPropertyAnimator.alpha(f1).setDuration(300L).setListener((Animator.AnimatorListener)new a.b(paramView, paramBoolean, parama)).start();
      return;
      f1 = 0.0F;
      break;
    }
  }
  
  public final float enP()
  {
    return this.CPv;
  }
  
  public abstract View getLayoutView();
  
  public final int getScreenHeight()
  {
    return this.pvg;
  }
  
  public final int getScreenWidth()
  {
    return this.sJv;
  }
  
  public final void mount()
  {
    Log.i("BaseOlympicCertificateW", "mount");
    this.CPu.a(this.owner, (y)this);
  }
  
  public void onClick(View paramView)
  {
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/olympic/certificate/widget/BaseCertificateWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/olympic/certificate/widget/BaseCertificateWidget", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
  }
  
  public void reset() {}
  
  public final void setVisibility(int paramInt)
  {
    getLayoutView().setVisibility(paramInt);
  }
  
  public void setVisibility(boolean paramBoolean)
  {
    View localView = getLayoutView();
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      return;
    }
  }
  
  public void unMount()
  {
    Log.i("BaseOlympicCertificateW", "unMount");
    this.CPu.b((y)this);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/olympic/certificate/widget/BaseCertificateWidget$Companion;", "", "()V", "CERTIFICATE_RATIO", "", "HEAD_RADIO", "LAYOUT_MARGIN_LEFT", "", "OLYMPIC_LOGO_CINSTRAST_WIDTH_RATIO", "OLYMPIC_LOGO_MARGIN_TOP", "OLYMPIC_LOGO_RATIO", "OLYMPIC_SAMLL_LOGO_CINSTRAST_WIDTH_RATIO", "OLYMPIC_SMALL_LOGO_MARGIN_TOP", "OLYMPIC_SMALL_LOGO_RATIO", "STAMP_RATIO", "TAG", "", "TORCH_CINSTRAST_WIDTH_RATIO", "TORCH_LIGHT_CINSTRAST_WIDTH_RATIO", "TORCH_MARGIN_RIGHT", "TORCH_MARGIN_TOP", "TORCH_RATIO", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.olympic.certificate.widget.a
 * JD-Core Version:    0.7.0.1
 */
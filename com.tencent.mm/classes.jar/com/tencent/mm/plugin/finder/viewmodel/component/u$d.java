package com.tencent.mm.plugin.finder.viewmodel.component;

import android.view.View;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.view.FadeOutLinearLayout;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.i;
import kotlin.g.b.aa.a;
import kotlin.g.b.aa.d;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
public final class u$d
  implements Runnable
{
  public u$d(aa.d paramd, FrameLayout paramFrameLayout, View paramView, aa.a parama, i parami, long paramLong) {}
  
  public final void run()
  {
    AppMethodBeat.i(287169);
    Object localObject1 = this.Bkk;
    Object localObject2 = this.Bkl;
    p.j(localObject2, "feedHeaderBar");
    int i = ((FrameLayout)localObject2).getWidth();
    localObject2 = this.Bkm;
    p.j(localObject2, "followBtn");
    int j = ((View)localObject2).getWidth();
    localObject2 = u.Bkh;
    ((aa.d)localObject1).aaBA = (i + j + u.a.ekA());
    if (this.Bkn.aaBx)
    {
      localObject1 = this.tDl.RD(b.f.share_icon_container);
      p.j(localObject1, "holder.getView<View>(R.id.share_icon_container)");
      i = d.cE(localObject1)[0];
      localObject1 = this.Bkl;
      p.j(localObject1, "feedHeaderBar");
      i -= d.cE((View)localObject1)[0] + this.Bkk.aaBA;
      localObject1 = u.Bkh;
      if (i < u.a.ekB())
      {
        localObject1 = this.Bkk;
        j = this.Bkk.aaBA;
        localObject2 = u.Bkh;
        ((aa.d)localObject1).aaBA = (i + j - u.a.ekB());
        localObject1 = (FadeOutLinearLayout)this.Bkl.findViewById(b.f.content_layout);
        if (localObject1 != null)
        {
          i = ((FadeOutLinearLayout)localObject1).getWidth();
          localObject2 = this.Bkl.findViewById(b.f.avatar_iv);
          p.j(localObject2, "feedHeaderBar.findViewById<View>(R.id.avatar_iv)");
          j = ((View)localObject2).getWidth();
          localObject2 = u.Bkh;
          int k = u.a.ekA();
          localObject2 = this.Bkm;
          p.j(localObject2, "followBtn");
          int m = ((View)localObject2).getWidth();
          localObject2 = u.Bkh;
          int n = u.a.ekA();
          int i1 = this.Bkk.aaBA;
          localObject2 = this.Bkm;
          p.j(localObject2, "followBtn");
          int i2 = ((View)localObject2).getWidth();
          localObject2 = u.Bkh;
          ((FadeOutLinearLayout)localObject1).ar(m + n - (i1 - (i + j + k * 2)) + (i2 + u.a.ekA()), this.xhm);
        }
      }
    }
    Log.i("FinderFollowAnimUIC", "showFollowAnim: feedId = " + d.Fw(this.xhm) + ", hasShrinkText = " + this.Bkn.aaBx + ", headerBarWidth = " + this.Bkk.aaBA);
    localObject1 = this.Bkl;
    p.j(localObject1, "feedHeaderBar");
    ((FrameLayout)localObject1).getLayoutParams().width = this.Bkk.aaBA;
    this.Bkl.requestLayout();
    AppMethodBeat.o(287169);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.u.d
 * JD-Core Version:    0.7.0.1
 */
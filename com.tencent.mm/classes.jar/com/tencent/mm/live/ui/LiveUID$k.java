package com.tencent.mm.live.ui;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.f;
import com.tencent.mm.live.d.d;
import com.tencent.mm.model.u;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class LiveUID$k
  implements View.OnClickListener
{
  LiveUID$k(LiveUID paramLiveUID) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(203279);
    Object localObject = new Intent((Context)this.KyL.getContext(), LiveUIB.class);
    ((Intent)localObject).putExtra("FROM_SENCE", LiveUID.m(this.KyL));
    paramView = this.KyL.getContext();
    localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(paramView, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/live/ui/LiveUID$replayGenerated$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(paramView, "com/tencent/mm/live/ui/LiveUID$replayGenerated$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramView = f.rGw;
    if (k.g(f.eNI(), u.aqG())) {
      d.fPN();
    }
    for (;;)
    {
      LiveUID.c(this.KyL);
      AppMethodBeat.o(203279);
      return;
      d.fPW();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.ui.LiveUID.k
 * JD-Core Version:    0.7.0.1
 */
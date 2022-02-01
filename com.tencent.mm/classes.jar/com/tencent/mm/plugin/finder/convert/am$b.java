package com.tencent.mm.plugin.finder.convert;

import android.arch.lifecycle.ViewModelProvider;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ch;
import com.tencent.mm.plugin.finder.cgi.ag;
import com.tencent.mm.plugin.finder.report.i;
import com.tencent.mm.plugin.finder.storage.ac;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderReporterUIC;
import com.tencent.mm.ui.MMActivity;
import d.g.b.p;
import d.l;
import d.v;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
final class am$b
  implements View.OnClickListener
{
  am$b(am paramam, ac paramac, TextView paramTextView, com.tencent.mm.view.recyclerview.e parame) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(201892);
    b localb = new b();
    localb.bd(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderMsgFollowApplyConvert$setAccept$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
    paramView = i.syT;
    paramView = this.rXM.field_username;
    p.g(paramView, "mention.field_username");
    i.ab(paramView, 1, ch.aDd());
    am.a(this.rXN, this.oTF);
    paramView = com.tencent.mm.plugin.finder.storage.logic.e.sLw;
    com.tencent.mm.plugin.finder.storage.logic.e.b(this.rXM);
    paramView = com.tencent.mm.ui.component.a.KEX;
    paramView = this.oTF.getContext();
    if (paramView == null)
    {
      paramView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(201892);
      throw paramView;
    }
    paramView = ((FinderReporterUIC)com.tencent.mm.ui.component.a.s((MMActivity)paramView).get(FinderReporterUIC.class)).cQZ();
    paramView = new ag(this.rXM, paramView, this.rXL.scene);
    g.ajj().b((n)paramView);
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderMsgFollowApplyConvert$setAccept$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(201892);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.am.b
 * JD-Core Version:    0.7.0.1
 */
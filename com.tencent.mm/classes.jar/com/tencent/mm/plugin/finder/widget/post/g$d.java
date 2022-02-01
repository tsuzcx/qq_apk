package com.tencent.mm.plugin.finder.widget.post;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.upload.h;
import com.tencent.mm.protocal.protobuf.bqr;
import com.tencent.mm.protocal.protobuf.yo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.view.ViewAnimHelper;
import com.tencent.mm.view.ViewAnimHelper.ViewInfo;
import d.g.b.k;
import d.g.b.v.f;
import d.l;
import d.v;
import java.util.LinkedList;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/widget/post/PostVideoWidget$initFakeVideoLogic$1$3"})
final class g$d
  implements View.OnClickListener
{
  g$d(v.f paramf, g paramg) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(204882);
    paramView = new bqr();
    Object localObject1 = paramView.mediaList;
    Object localObject2 = h.rNr;
    localObject2 = this.siV.siP;
    if (localObject2 == null) {
      k.fOy();
    }
    ((LinkedList)localObject1).add(h.a((yo)localObject2, (String)this.siU.KUQ, g.b(this.siV)));
    localObject1 = com.tencent.mm.plugin.finder.utils.a.rOv;
    localObject1 = this.siV.context;
    if (localObject1 == null)
    {
      paramView = new v("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(204882);
      throw paramView;
    }
    localObject1 = (Activity)localObject1;
    localObject2 = (View)g.c(this.siV);
    Object localObject3 = this.siV.context;
    if (localObject3 == null)
    {
      paramView = new v("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(204882);
      throw paramView;
    }
    localObject3 = ((MMActivity)localObject3).getWindow();
    k.g(localObject3, "(context as MMActivity).window");
    localObject2 = ViewAnimHelper.n((View)localObject2, ((Window)localObject3).getDecorView());
    k.g(localObject2, "ViewAnimHelper.getViewIn…tivity).window.decorView)");
    localObject3 = g.siT;
    com.tencent.mm.plugin.finder.utils.a.a((Activity)localObject1, (ViewAnimHelper.ViewInfo)localObject2, paramView, g.cGI());
    AppMethodBeat.o(204882);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.widget.post.g.d
 * JD-Core Version:    0.7.0.1
 */
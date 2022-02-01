package com.tencent.mm.plugin.finder.live.business;

import android.app.Activity;
import android.content.DialogInterface;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.plugin.finder.live.report.j;
import com.tencent.mm.plugin.finder.live.report.q.s;
import com.tencent.mm.plugin.finder.live.viewmodel.data.business.e;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bip;
import com.tencent.mm.ui.anim.d.c;
import com.tencent.mm.ui.anim.d.g;
import com.tencent.mm.ui.anim.d.k;
import com.tencent.mm.ui.anim.d.l;
import com.tencent.mm.ui.anim.d.m;
import com.tencent.mm.ui.anim.d.n;
import com.tencent.mm.ui.widget.a.i;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
final class b$a
  extends u
  implements kotlin.g.a.a<ah>
{
  b$a(Activity paramActivity, b paramb)
  {
    super(0);
  }
  
  private static final void a(View paramView, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(371046);
    if (paramView != null) {
      com.tencent.mm.ui.anim.d.a.a(paramView, new com.tencent.mm.ui.anim.d.f().a((com.tencent.mm.ui.anim.d.b)new l((n)k.adMQ, 3)));
    }
    AppMethodBeat.o(371046);
  }
  
  private static final void a(View paramView1, i parami, View paramView2)
  {
    AppMethodBeat.i(371050);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView1);
    localb.cH(parami);
    localb.cH(paramView2);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/business/LiveFestivalSlice$showCoupletsGuide$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parami, "$dialog");
    if (paramView1 != null) {
      com.tencent.mm.ui.anim.d.a.a(paramView1, new g().a((c)new m((n)k.adMQ)));
    }
    parami.dismiss();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/business/LiveFestivalSlice$showCoupletsGuide$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(371050);
  }
  
  private static final void a(b paramb, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(371049);
    s.u(paramb, "this$0");
    paramDialogInterface = j.Dob;
    q.s locals = q.s.akfn;
    Map localMap = (Map)new LinkedHashMap();
    localMap.put("liveid", d.hF(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)paramb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId));
    paramb = ((e)paramb.business(e.class)).Eco;
    if (paramb == null) {}
    for (long l = 0L;; l = paramb.id)
    {
      localMap.put("feedid", d.hF(l));
      paramb = ah.aiuX;
      paramDialogInterface.a(locals, localMap);
      AppMethodBeat.o(371049);
      return;
    }
  }
  
  private static final void a(i parami, b paramb, Activity paramActivity, View paramView)
  {
    AppMethodBeat.i(371051);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(parami);
    localb.cH(paramb);
    localb.cH(paramActivity);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/business/LiveFestivalSlice$showCoupletsGuide$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parami, "$dialog");
    s.u(paramb, "this$0");
    s.u(paramActivity, "$activity");
    parami.dismiss();
    b.a(paramb, paramActivity);
    parami = j.Dob;
    paramActivity = q.s.akfm;
    paramView = (Map)new LinkedHashMap();
    paramView.put("liveid", d.hF(((com.tencent.mm.plugin.finder.live.viewmodel.data.business.f)paramb.business(com.tencent.mm.plugin.finder.live.viewmodel.data.business.f.class)).liveInfo.liveId));
    paramb = ((e)paramb.business(e.class)).Eco;
    if (paramb == null) {}
    for (long l = 0L;; l = paramb.id)
    {
      paramView.put("feedid", d.hF(l));
      paramb = ah.aiuX;
      parami.a(paramActivity, paramView);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/live/business/LiveFestivalSlice$showCoupletsGuide$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(371051);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.business.b.a
 * JD-Core Version:    0.7.0.1
 */
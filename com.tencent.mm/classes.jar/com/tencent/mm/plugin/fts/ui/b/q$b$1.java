package com.tencent.mm.plugin.fts.ui.b;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.Util;

final class q$b$1
  implements View.OnClickListener
{
  q$b$1(q.b paramb, Context paramContext) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(265721);
    b localb = new b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fts/ui/item/FTSServiceNotifySenderHeaderDataItem$FTSServiceNotifySenderHeaderViewItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    paramView = new Intent();
    paramView.putExtra("Search_Scene", 4);
    paramView.putExtra("Search_Str", this.HBJ.HBI.FWt.Hte);
    d.d(this.val$context, ".ui.FTSServiceNotifyUI", paramView);
    h.OAn.b(23903, new Object[] { Integer.valueOf(5), Long.valueOf(Util.nowSecond()), null, Integer.valueOf(0) });
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fts/ui/item/FTSServiceNotifySenderHeaderDataItem$FTSServiceNotifySenderHeaderViewItem$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(265721);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.b.q.b.1
 * JD-Core Version:    0.7.0.1
 */
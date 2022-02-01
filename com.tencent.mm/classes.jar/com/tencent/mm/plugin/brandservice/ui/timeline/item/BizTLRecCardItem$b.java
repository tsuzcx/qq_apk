package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.storage.ab;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"<no name provided>", ""}, k=3, mv={1, 5, 1}, xi=48)
final class BizTLRecCardItem$b
  extends u
  implements kotlin.g.a.a<ah>
{
  BizTLRecCardItem$b(ab paramab, BizTLRecCardItem paramBizTLRecCardItem, String paramString)
  {
    super(0);
  }
  
  private static final void b(BizTLRecCardItem paramBizTLRecCardItem, String paramString, ab paramab, View paramView)
  {
    AppMethodBeat.i(302548);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramBizTLRecCardItem);
    localb.cH(paramString);
    localb.cH(paramab);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem$refreshHeader$showFollow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramBizTLRecCardItem, "this$0");
    s.u(paramab, "$info");
    s.s(paramString, "username");
    BizTLRecCardItem.a(paramBizTLRecCardItem, paramString, paramab);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/brandservice/ui/timeline/item/BizTLRecCardItem$refreshHeader$showFollow$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(302548);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.BizTLRecCardItem.b
 * JD-Core Version:    0.7.0.1
 */
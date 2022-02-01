package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.e.b;

final class b$6
  implements View.OnClickListener
{
  b$6(b paramb, w paramw, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(5859);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
    a.b("com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
    int j = (int)(System.currentTimeMillis() / 1000L);
    paramView = new Bundle();
    localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(this.nOy.field_talker);
    if ((localObject != null) && (!com.tencent.mm.o.b.lM(((aw)localObject).field_type))) {}
    for (int i = 157;; i = 90)
    {
      paramView.putInt(e.b.IUn, i);
      i = b.a(this.oaH).getIntent().getIntExtra("KOpenArticleSceneFromScene", 10000);
      paramView.putInt(e.b.IUo, i);
      paramView.putInt("geta8key_scene", 56);
      com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.a(b.a(this.oaH), this.nOy.field_msgId, this.nOy.field_msgSvrId, this.nOB, paramView);
      b.b(this.oaH).a(this.nOy, this.nOB, j);
      a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(5859);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.b.6
 * JD-Core Version:    0.7.0.1
 */
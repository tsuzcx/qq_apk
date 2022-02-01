package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.n.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.s;
import com.tencent.mm.ui.e.b;

final class c$6
  implements View.OnClickListener
{
  c$6(c paramc, s params, int paramInt) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(5859);
    int j = (int)(System.currentTimeMillis() / 1000L);
    paramView = new Bundle();
    af localaf = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(this.mLB.field_talker);
    if ((localaf != null) && (!b.ls(localaf.field_type))) {}
    for (int i = 157;; i = 90)
    {
      paramView.putInt(e.b.FHP, i);
      i = c.a(this.mXd).getIntent().getIntExtra("KOpenArticleSceneFromScene", 10000);
      paramView.putInt(e.b.FHQ, i);
      paramView.putInt("geta8key_scene", 56);
      l.a(c.a(this.mXd), this.mLB.field_msgId, this.mLB.field_msgSvrId, this.mLE, paramView);
      c.b(this.mXd).a(this.mLB, this.mLE, j);
      AppMethodBeat.o(5859);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.c.6
 * JD-Core Version:    0.7.0.1
 */
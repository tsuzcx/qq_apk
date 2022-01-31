package com.tencent.mm.plugin.game.luggage.b;

import android.content.Intent;
import com.tencent.luggage.d.a.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import java.util.HashMap;

final class p$1
  implements MMActivity.a
{
  p$1(p paramp, a.a parama, MMActivity paramMMActivity) {}
  
  public final void c(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(135880);
    if (paramInt1 == (this.njP.hashCode() & 0xFFFF))
    {
      if (paramInt2 != -1) {
        break label96;
      }
      if (paramIntent == null) {
        break label83;
      }
      paramIntent = bo.bf(paramIntent.getStringExtra("gameRegionName"), "");
      HashMap localHashMap = new HashMap();
      localHashMap.put("gameRegionName", paramIntent);
      this.njN.c("", localHashMap);
    }
    for (;;)
    {
      this.val$activity.mmSetOnActivityResultCallback(null);
      AppMethodBeat.o(135880);
      return;
      label83:
      this.njN.a("fail", null);
      continue;
      label96:
      if (paramInt2 == 1) {
        this.njN.a("fail", null);
      } else {
        this.njN.a("cancel", null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.luggage.b.p.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.emoji.e;

import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.dp;
import com.tencent.mm.f.a.dp.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.emoji.i.h;
import com.tencent.mm.plugin.emoji.model.p;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;

final class b$11
  extends IListener<dp>
{
  b$11(b paramb)
  {
    AppMethodBeat.i(161078);
    this.__eventId = dp.class.getName().hashCode();
    AppMethodBeat.o(161078);
  }
  
  private static boolean a(dp paramdp)
  {
    AppMethodBeat.i(108408);
    if ((paramdp != null) && ((paramdp instanceof dp)))
    {
      boolean bool = paramdp.fzg.enable;
      com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.VgW, Boolean.valueOf(bool));
      p.cUS().uDy = bool;
      if (bool) {
        break label96;
      }
      com.tencent.mm.plugin.report.service.h.IzE.a(12953, new Object[] { Integer.valueOf(2), "" });
      Toast.makeText(MMApplicationContext.getContext(), i.h.emoji_chatting_reward_tips_disable_toast, 0).show();
    }
    for (;;)
    {
      AppMethodBeat.o(108408);
      return false;
      label96:
      Toast.makeText(MMApplicationContext.getContext(), i.h.emoji_chatting_reward_tips_enable_toast, 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.e.b.11
 * JD-Core Version:    0.7.0.1
 */
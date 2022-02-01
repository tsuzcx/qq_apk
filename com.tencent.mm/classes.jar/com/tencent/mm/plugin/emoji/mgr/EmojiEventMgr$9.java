package com.tencent.mm.plugin.emoji.mgr;

import android.widget.Toast;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.dz;
import com.tencent.mm.autogen.a.dz.a;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.emoji.h.h;
import com.tencent.mm.plugin.emoji.model.s;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;

class EmojiEventMgr$9
  extends IListener<dz>
{
  EmojiEventMgr$9(b paramb, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(269913);
    this.__eventId = dz.class.getName().hashCode();
    AppMethodBeat.o(269913);
  }
  
  private static boolean a(dz paramdz)
  {
    AppMethodBeat.i(108408);
    if ((paramdz != null) && ((paramdz instanceof dz)))
    {
      boolean bool = paramdz.hDP.enable;
      com.tencent.mm.kernel.h.baE().ban().set(at.a.acIn, Boolean.valueOf(bool));
      s.dAp().xLQ = bool;
      if (bool) {
        break label96;
      }
      com.tencent.mm.plugin.report.service.h.OAn.b(12953, new Object[] { Integer.valueOf(2), "" });
      Toast.makeText(MMApplicationContext.getContext(), h.h.emoji_chatting_reward_tips_disable_toast, 0).show();
    }
    for (;;)
    {
      AppMethodBeat.o(108408);
      return false;
      label96:
      Toast.makeText(MMApplicationContext.getContext(), h.h.emoji_chatting_reward_tips_enable_toast, 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.mgr.EmojiEventMgr.9
 * JD-Core Version:    0.7.0.1
 */
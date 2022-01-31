package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.widget.ImageView;
import com.tencent.mm.plugin.brandservice.b.c;
import com.tencent.mm.plugin.brandservice.ui.b.c;
import com.tencent.mm.pluginsdk.ui.applet.e.a;
import com.tencent.mm.storage.q;

final class a$5
  implements e.a
{
  a$5(a parama, c.e parame, q paramq) {}
  
  public final void onFinish()
  {
    this.ifm.igd.ifL.setVisibility(0);
    if ((this.hSM.field_msgId + "_0").equals(c.ayD())) {
      this.ifm.igd.ifH.setImageResource(b.c.chatting_item_biz_music_pause_selector);
    }
    for (;;)
    {
      a.g(this.ifl).aog();
      return;
      this.ifm.igd.ifH.setImageResource(b.c.chatting_item_biz_music_play_selector);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.5
 * JD-Core Version:    0.7.0.1
 */
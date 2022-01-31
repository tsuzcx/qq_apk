package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;
import com.tencent.mm.plugin.brandservice.b.c;
import com.tencent.mm.plugin.brandservice.b.h;
import com.tencent.mm.plugin.fav.a.n;
import com.tencent.mm.sdk.platformtools.y;

final class a$21
  implements View.OnClickListener
{
  a$21(a parama, com.tencent.mm.storage.q paramq, ImageView paramImageView) {}
  
  public final void onClick(View paramView)
  {
    if ((a.f(this.ifl).isPlaying()) && (this.hSM.field_msgId == a.f(this.ifl).iho))
    {
      a.f(this.ifl).stopPlay();
      this.ifs.setImageResource(b.c.chatting_item_biz_voice_play_selector);
      return;
    }
    paramView = a.f(this.ifl);
    BizTimeLineUI localBizTimeLineUI = a.a(this.ifl);
    String str = com.tencent.mm.modelvoice.q.getFullPath(this.hSM.field_imgPath);
    long l = this.hSM.field_msgId;
    paramView.ayd().a(paramView);
    y.d("MicroMsg.FavVoiceLogic", "start play, path[%s]", new Object[] { str });
    if (paramView.ayd().startPlay(str, -1))
    {
      paramView.iho = l;
      return;
    }
    Toast.makeText(localBizTimeLineUI, b.h.biz_time_line_play_voice_fail, 1).show();
    paramView.iho = 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.21
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.modelvoice.s;
import com.tencent.mm.plugin.brandservice.ui.timeline.a;
import com.tencent.mm.plugin.fav.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;

public final class q$3
  implements View.OnClickListener
{
  public q$3(q paramq, com.tencent.mm.storage.q paramq1, ImageView paramImageView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(14278);
    if ((this.jYW.jXV.jVP.isPlaying()) && (this.jMz.field_msgId == this.jYW.jXV.jVP.jXk))
    {
      this.jYW.jXV.jVP.stopPlay();
      this.jYX.setImageResource(2130838317);
      AppMethodBeat.o(14278);
      return;
    }
    paramView = this.jYW.jXV.jVP;
    Context localContext = this.jYW.mContext;
    String str = s.getFullPath(this.jMz.field_imgPath);
    long l = this.jMz.field_msgId;
    paramView.aWW().a(paramView);
    ab.d("MicroMsg.FavVoiceLogic", "start play, path[%s]", new Object[] { str });
    if (paramView.aWW().startPlay(str, -1)) {}
    for (paramView.jXk = l;; paramView.jXk = 0L)
    {
      paramView = ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().kB(this.jMz.field_msgId);
      if (paramView.field_msgId == 0L) {
        break;
      }
      if (!s.K(paramView)) {
        s.M(paramView);
      }
      AppMethodBeat.o(14278);
      return;
      Toast.makeText(localContext, 2131297722, 1).show();
    }
    AppMethodBeat.o(14278);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.q.3
 * JD-Core Version:    0.7.0.1
 */
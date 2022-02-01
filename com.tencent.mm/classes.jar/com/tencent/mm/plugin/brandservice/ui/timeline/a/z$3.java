package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.brandservice.ui.timeline.c;
import com.tencent.mm.plugin.brandservice.ui.timeline.i;
import com.tencent.mm.plugin.fav.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ad;

public final class z$3
  implements View.OnClickListener
{
  public z$3(z paramz, com.tencent.mm.storage.s params, ImageView paramImageView) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(6070);
    if ((this.nbr.nao.mWU.isPlaying()) && (this.mLB.field_msgId == this.nbr.nao.mWU.mYw))
    {
      this.nbr.nao.mWU.stopPlay();
      this.nbs.setImageResource(2131231675);
      AppMethodBeat.o(6070);
      return;
    }
    paramView = this.nbr.nao.mWU;
    Context localContext = this.nbr.mContext;
    String str = com.tencent.mm.modelvoice.s.getFullPath(this.mLB.field_imgPath);
    long l = this.mLB.field_msgId;
    paramView.bCT().a(paramView);
    ad.d("MicroMsg.FavVoiceLogic", "start play, path[%s]", new Object[] { str });
    if (paramView.bCT().cI(str, -1)) {}
    for (paramView.mYw = l;; paramView.mYw = 0L)
    {
      paramView = ((k)g.ab(k.class)).cOI().rm(this.mLB.field_msgId);
      if (paramView.field_msgId == 0L) {
        break;
      }
      if (!com.tencent.mm.modelvoice.s.W(paramView)) {
        com.tencent.mm.modelvoice.s.Y(paramView);
      }
      AppMethodBeat.o(6070);
      return;
      Toast.makeText(localContext, 2131756638, 1).show();
    }
    AppMethodBeat.o(6070);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.z.3
 * JD-Core Version:    0.7.0.1
 */
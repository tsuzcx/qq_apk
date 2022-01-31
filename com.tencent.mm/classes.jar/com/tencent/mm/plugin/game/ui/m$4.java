package com.tencent.mm.plugin.game.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.model.c;
import com.tencent.mm.plugin.game.model.k;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.concurrent.ConcurrentHashMap;

final class m$4
  implements View.OnClickListener
{
  m$4(m paramm) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(112061);
    if (!(paramView.getTag() instanceof c))
    {
      ab.e("MicroMsg.GameListAdapter", "No button tag retrived, ignore click");
      AppMethodBeat.o(112061);
      return;
    }
    paramView = (c)paramView.getTag();
    if (!this.nAW.nAT.containsKey(paramView.field_appId))
    {
      ab.e("MicroMsg.GameListAdapter", "No DownloadInfo found");
      AppMethodBeat.o(112061);
      return;
    }
    k localk = (k)this.nAW.nAT.get(paramView.field_appId);
    localk.em(this.nAW.mContext);
    this.nAW.nxw.nuQ = paramView.nml;
    this.nAW.nxw.nok = this.nAW.nok;
    this.nAW.nxw.a(paramView, localk);
    AppMethodBeat.o(112061);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.m.4
 * JD-Core Version:    0.7.0.1
 */
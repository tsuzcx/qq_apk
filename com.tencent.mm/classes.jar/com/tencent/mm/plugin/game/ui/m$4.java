package com.tencent.mm.plugin.game.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.game.model.l;
import com.tencent.mm.sdk.platformtools.y;
import java.util.concurrent.ConcurrentHashMap;

final class m$4
  implements View.OnClickListener
{
  m$4(m paramm) {}
  
  public final void onClick(View paramView)
  {
    if (!(paramView.getTag() instanceof com.tencent.mm.plugin.game.model.d))
    {
      y.e("MicroMsg.GameListAdapter", "No button tag retrived, ignore click");
      return;
    }
    paramView = (com.tencent.mm.plugin.game.model.d)paramView.getTag();
    if (!this.ldb.lcY.containsKey(paramView.field_appId))
    {
      y.e("MicroMsg.GameListAdapter", "No DownloadInfo found");
      return;
    }
    l locall = (l)this.ldb.lcY.get(paramView.field_appId);
    locall.dz(this.ldb.mContext);
    this.ldb.kZz.kWO = paramView.kOo;
    this.ldb.kZz.kQh = this.ldb.kQh;
    this.ldb.kZz.a(paramView, locall);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.m.4
 * JD-Core Version:    0.7.0.1
 */
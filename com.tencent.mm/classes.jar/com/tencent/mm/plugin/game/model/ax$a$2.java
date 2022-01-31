package com.tencent.mm.plugin.game.model;

import android.os.Bundle;
import com.tencent.mm.ipcinvoker.c;
import com.tencent.mm.plugin.wepkg.model.BaseWepkgProcessTask;
import com.tencent.mm.plugin.wepkg.model.WepkgCrossProcessTask;
import com.tencent.mm.plugin.wepkg.model.a;
import com.tencent.mm.plugin.wepkg.utils.d;
import com.tencent.mm.sdk.platformtools.ai;

final class ax$a$2
  extends a
{
  ax$a$2(ax.a parama, Bundle paramBundle, boolean paramBoolean, c paramc) {}
  
  public final void a(BaseWepkgProcessTask paramBaseWepkgProcessTask)
  {
    if (((paramBaseWepkgProcessTask instanceof WepkgCrossProcessTask)) && (paramBaseWepkgProcessTask.bFQ))
    {
      paramBaseWepkgProcessTask = ((WepkgCrossProcessTask)paramBaseWepkgProcessTask).rPn;
      d.DS().O(new ax.a.2.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.model.ax.a.2
 * JD-Core Version:    0.7.0.1
 */
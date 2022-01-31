package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.Intent;
import com.tencent.mm.h.a.do;
import com.tencent.mm.h.a.do.b;
import com.tencent.mm.plugin.map.a.h;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;

final class i$1
  implements n.c
{
  i$1(i parami) {}
  
  public final void a(l paraml)
  {
    paraml.a(1, this.lKF.getString(a.h.app_share_to_weixin), 0);
    if (this.lKF.type == 1) {
      paraml.a(3, this.lKF.getString(a.h.plugin_favorite_opt), 0);
    }
    for (;;)
    {
      do localdo = new do();
      localdo.bJZ.bIt = this.lKF.bIt;
      com.tencent.mm.sdk.b.a.udP.m(localdo);
      if ((localdo.bKa.bJy) || (g.m(ae.getContext(), 4L))) {
        paraml.a(6, this.lKF.getString(a.h.download_other_open), 0);
      }
      return;
      if ((this.lKF.type == 2) && (this.lKF.activity.getIntent().getBooleanExtra("kFavCanDel", true)))
      {
        paraml.a(7, this.lKF.getString(a.h.favorite_save_as_note_1), 0);
        paraml.a(5, this.lKF.getString(a.h.favorite_edit_tag_tips_1), 0);
        paraml.a(4, this.lKF.getString(a.h.app_delete), 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.i.1
 * JD-Core Version:    0.7.0.1
 */
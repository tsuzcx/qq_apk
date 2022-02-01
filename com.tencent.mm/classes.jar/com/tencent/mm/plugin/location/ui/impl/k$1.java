package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ex;
import com.tencent.mm.autogen.a.ex.b;
import com.tencent.mm.plugin.map.a.i;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;

final class k$1
  implements u.g
{
  k$1(k paramk) {}
  
  public final void onCreateMMMenu(s params)
  {
    AppMethodBeat.i(56200);
    params.a(1, this.KkT.getString(a.i.app_share_to_weixin), 0);
    if (this.KkT.type == 1) {
      params.a(3, this.KkT.getString(a.i.plugin_favorite_opt), 0);
    }
    for (;;)
    {
      ex localex = new ex();
      localex.hFc.msgId = this.KkT.msgId;
      localex.publish();
      if ((localex.hFd.hEn) || (h.x(MMApplicationContext.getContext(), 4L))) {
        params.a(6, this.KkT.getString(a.i.download_other_open), 0);
      }
      AppMethodBeat.o(56200);
      return;
      if (this.KkT.type == 2)
      {
        if (this.KkT.activity.getIntent().getBooleanExtra("kFavCanDel", true))
        {
          params.a(7, this.KkT.getString(a.i.favorite_save_as_note_1), 0);
          params.a(5, this.KkT.getString(a.i.favorite_edit_tag_tips_1), 0);
          params.a(4, this.KkT.getString(a.i.app_delete), 0);
        }
      }
      else if (this.KkT.type == 10) {
        params.a(8, this.KkT.getString(a.i.plugin_favorite_opt), 0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.k.1
 * JD-Core Version:    0.7.0.1
 */
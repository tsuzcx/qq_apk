package com.tencent.mm.plugin.base.model;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.widget.b.c;
import com.tencent.mm.ui.widget.b.e.a;
import com.tencent.mm.ui.widget.b.e.b;

final class b$1
  implements e.b
{
  b$1(e.a parama, Activity paramActivity) {}
  
  public final void u(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(79061);
    this.jLl.gwf.dismiss();
    if (paramBoolean2) {
      this.val$activity.getSharedPreferences(ah.dsP(), 0).edit().putBoolean("no_more_show_add_short_cut_dialog", true).apply();
    }
    AppMethodBeat.o(79061);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.base.model.b.1
 * JD-Core Version:    0.7.0.1
 */
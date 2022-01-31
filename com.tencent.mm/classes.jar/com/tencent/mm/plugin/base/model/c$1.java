package com.tencent.mm.plugin.base.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ah;

final class c$1
  implements c.a
{
  c$1(Context paramContext) {}
  
  public final void d(boolean paramBoolean, String paramString, int paramInt)
  {
    AppMethodBeat.i(155978);
    if (paramBoolean) {
      this.val$context.getSharedPreferences(ah.dsP(), 0).edit().putBoolean("no_more_show_add_short_cut_dialog", true).commit();
    }
    AppMethodBeat.o(155978);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.base.model.c.1
 * JD-Core Version:    0.7.0.1
 */
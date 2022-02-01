package com.tencent.mm.booter;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.webview.ui.tools.fts.preload.b;
import com.tencent.mm.sdk.platformtools.Util;

public final class e
{
  public static final class a
    extends e.c
  {
    public final void onReceive(Context paramContext, Intent paramIntent)
    {
      AppMethodBeat.i(19875);
      if ((paramContext == null) || (paramIntent == null))
      {
        AppMethodBeat.o(19875);
        return;
      }
      super.onReceive(paramContext, paramIntent);
      paramContext = paramIntent.getStringExtra("toolsmp_process_action_code_key");
      if ((!Util.isNullOrNil(paramContext)) && (paramContext.equals("com.tencent.mm.intent.ACTION_PRELOAD_SEARCH")))
      {
        paramContext = paramIntent.getStringExtra("toolsmp_param_preload_url");
        int i = paramIntent.getIntExtra("toolsmp_param_preload_search_biz", -1);
        boolean bool = paramIntent.getBooleanExtra("toolsmp_param_preload_search_biz_need_reset", false);
        paramIntent = b.JpB;
        b.k(i, paramContext, bool);
      }
      AppMethodBeat.o(19875);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.booter.e
 * JD-Core Version:    0.7.0.1
 */
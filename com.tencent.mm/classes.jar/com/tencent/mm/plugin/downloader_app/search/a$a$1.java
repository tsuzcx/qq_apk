package com.tencent.mm.plugin.downloader_app.search;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;

final class a$a$1
  implements View.OnClickListener
{
  a$a$1(a.a parama, a parama1) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(136163);
    paramView = this.lbw.lbu.lbi;
    paramView.mContext.getSharedPreferences("search_history_href", 0).edit().putString("search_history_list", "").commit();
    if (paramView.lby != null) {
      paramView.lby.clear();
    }
    paramView.setData(null);
    com.tencent.mm.plugin.downloader_app.c.a.a(13, 1302, 21, 81, "", "", "");
    AppMethodBeat.o(136163);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.search.a.a.1
 * JD-Core Version:    0.7.0.1
 */
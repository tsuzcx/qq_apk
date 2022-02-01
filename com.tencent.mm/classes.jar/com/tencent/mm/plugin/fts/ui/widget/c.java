package com.tencent.mm.plugin.fts.ui.widget;

import android.view.Menu;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.tools.t;

public final class c
  extends t
{
  public boolean BRU;
  
  public final void a(FragmentActivity paramFragmentActivity, Menu paramMenu)
  {
    AppMethodBeat.i(191909);
    if (paramFragmentActivity == null)
    {
      Log.w("MicroMsg.FTSVoiceSearchViewHelper", "on add search menu, activity is null");
      AppMethodBeat.o(191909);
      return;
    }
    if (this.XUk == null) {
      this.XUk = new FTSActionBarSearchView(paramFragmentActivity);
    }
    super.a(paramFragmentActivity, paramMenu);
    AppMethodBeat.o(191909);
  }
  
  public final boolean bsi()
  {
    return this.BRU;
  }
  
  public final void setCursorVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(112330);
    ((FTSActionBarSearchView)this.XUk).setCursorVisible(paramBoolean);
    AppMethodBeat.o(112330);
  }
  
  public final void setSearchContent(String paramString)
  {
    AppMethodBeat.i(112331);
    try
    {
      super.setSearchContent(paramString);
      AppMethodBeat.o(112331);
      return;
    }
    catch (Exception paramString)
    {
      Log.e("MicroMsg.FTSVoiceSearchViewHelper", "setSearchContent exception: " + paramString.getMessage());
      AppMethodBeat.o(112331);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.c
 * JD-Core Version:    0.7.0.1
 */
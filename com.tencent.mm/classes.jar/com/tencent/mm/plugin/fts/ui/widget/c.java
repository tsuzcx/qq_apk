package com.tencent.mm.plugin.fts.ui.widget;

import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.tools.r;

public final class c
  extends r
{
  public boolean sHb;
  
  public final void a(FragmentActivity paramFragmentActivity, Menu paramMenu)
  {
    AppMethodBeat.i(112329);
    if (paramFragmentActivity == null)
    {
      ac.w("MicroMsg.FTSVoiceSearchViewHelper", "on add search menu, activity is null");
      AppMethodBeat.o(112329);
      return;
    }
    if (this.ITL == null) {
      this.ITL = new FTSActionBarSearchView(paramFragmentActivity);
    }
    super.a(paramFragmentActivity, paramMenu);
    AppMethodBeat.o(112329);
  }
  
  public final boolean aKW()
  {
    return this.sHb;
  }
  
  public final void setCursorVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(112330);
    ((FTSActionBarSearchView)this.ITL).setCursorVisible(paramBoolean);
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
      ac.e("MicroMsg.FTSVoiceSearchViewHelper", "setSearchContent exception: " + paramString.getMessage());
      AppMethodBeat.o(112331);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.c
 * JD-Core Version:    0.7.0.1
 */
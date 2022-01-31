package com.tencent.mm.plugin.fts.ui.widget;

import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.tools.q;

public final class d
  extends q
{
  public boolean ncj;
  
  public final void a(FragmentActivity paramFragmentActivity, Menu paramMenu)
  {
    AppMethodBeat.i(62204);
    if (paramFragmentActivity == null)
    {
      ab.w("MicroMsg.FTSVoiceSearchViewHelper", "on add search menu, activity is null");
      AppMethodBeat.o(62204);
      return;
    }
    if (this.Axf == null) {
      this.Axf = new FTSActionBarSearchView(paramFragmentActivity);
    }
    super.a(paramFragmentActivity, paramMenu);
    AppMethodBeat.o(62204);
  }
  
  public final boolean amZ()
  {
    return this.ncj;
  }
  
  public final void setCursorVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(62205);
    ((FTSActionBarSearchView)this.Axf).setCursorVisible(paramBoolean);
    AppMethodBeat.o(62205);
  }
  
  public final void setSearchContent(String paramString)
  {
    AppMethodBeat.i(62206);
    try
    {
      super.setSearchContent(paramString);
      AppMethodBeat.o(62206);
      return;
    }
    catch (Exception paramString)
    {
      ab.e("MicroMsg.FTSVoiceSearchViewHelper", "setSearchContent exception: " + paramString.getMessage());
      AppMethodBeat.o(62206);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.d
 * JD-Core Version:    0.7.0.1
 */
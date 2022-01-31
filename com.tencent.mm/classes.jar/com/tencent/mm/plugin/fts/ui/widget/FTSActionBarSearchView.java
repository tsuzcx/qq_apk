package com.tencent.mm.plugin.fts.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.tools.ActionBarSearchView;
import com.tencent.mm.ui.tools.ActionBarSearchView.ActionBarEditText;

public class FTSActionBarSearchView
  extends ActionBarSearchView
{
  public FTSActionBarSearchView(Context paramContext)
  {
    super(paramContext);
  }
  
  public FTSActionBarSearchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public int getLayoutId()
  {
    AppMethodBeat.i(62103);
    ab.i("FTSActionBarSearchView", "getLayoutId");
    AppMethodBeat.o(62103);
    return 2130969665;
  }
  
  public void setCursorVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(62104);
    this.ApS.setCursorVisible(paramBoolean);
    AppMethodBeat.o(62104);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.FTSActionBarSearchView
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.fts.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
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
    AppMethodBeat.i(112231);
    ae.i("FTSActionBarSearchView", "getLayoutId");
    AppMethodBeat.o(112231);
    return 2131494208;
  }
  
  public void setCursorVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(112232);
    this.KZG.setCursorVisible(paramBoolean);
    AppMethodBeat.o(112232);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.FTSActionBarSearchView
 * JD-Core Version:    0.7.0.1
 */
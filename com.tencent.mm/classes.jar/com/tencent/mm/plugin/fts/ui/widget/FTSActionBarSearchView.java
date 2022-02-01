package com.tencent.mm.plugin.fts.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.ui.p.d;
import com.tencent.mm.plugin.fts.ui.p.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.tools.ActionBarSearchView;
import com.tencent.mm.ui.tools.ActionBarSearchView.ActionBarEditText;

public class FTSActionBarSearchView
  extends ActionBarSearchView
{
  private View HCG;
  
  public FTSActionBarSearchView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(265918);
    this.HCG = findViewById(p.d.search_icon_fts_main_key);
    this.HCG.setOnClickListener(new FTSActionBarSearchView.1(this));
    AppMethodBeat.o(265918);
  }
  
  public FTSActionBarSearchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public int getLayoutId()
  {
    AppMethodBeat.i(112231);
    Log.i("FTSActionBarSearchView", "getLayoutId");
    int i = p.e.fts_main_actionbar_searchview;
    AppMethodBeat.o(112231);
    return i;
  }
  
  public void setCursorVisible(boolean paramBoolean)
  {
    AppMethodBeat.i(112232);
    this.afDh.setCursorVisible(paramBoolean);
    AppMethodBeat.o(112232);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.widget.FTSActionBarSearchView
 * JD-Core Version:    0.7.0.1
 */
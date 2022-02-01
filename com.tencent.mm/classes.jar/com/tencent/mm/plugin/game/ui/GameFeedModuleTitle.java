package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.sdk.platformtools.Util;

public class GameFeedModuleTitle
  extends LinearLayout
{
  private TextView pPT;
  
  public GameFeedModuleTitle(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42113);
    super.onFinishInflate();
    this.pPT = ((TextView)findViewById(g.e.Cjg));
    AppMethodBeat.o(42113);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(42114);
    if ((paramd == null) || (Util.isNullOrNil(paramd.CIq)))
    {
      setVisibility(8);
      AppMethodBeat.o(42114);
      return;
    }
    setVisibility(0);
    this.pPT.setText(paramd.CIq);
    AppMethodBeat.o(42114);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedModuleTitle
 * JD-Core Version:    0.7.0.1
 */
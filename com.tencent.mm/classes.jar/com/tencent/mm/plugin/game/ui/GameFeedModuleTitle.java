package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.sdk.platformtools.bo;

public class GameFeedModuleTitle
  extends LinearLayout
{
  private TextView iJG;
  
  public GameFeedModuleTitle(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(111937);
    super.onFinishInflate();
    this.iJG = ((TextView)findViewById(2131824620));
    AppMethodBeat.o(111937);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(111938);
    if ((paramd == null) || (bo.isNullOrNil(paramd.nmq)))
    {
      setVisibility(8);
      AppMethodBeat.o(111938);
      return;
    }
    setVisibility(0);
    this.iJG.setText(paramd.nmq);
    AppMethodBeat.o(111938);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedModuleTitle
 * JD-Core Version:    0.7.0.1
 */
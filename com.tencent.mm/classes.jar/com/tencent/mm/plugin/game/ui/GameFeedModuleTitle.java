package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.sdk.platformtools.bu;

public class GameFeedModuleTitle
  extends LinearLayout
{
  private TextView lHk;
  
  public GameFeedModuleTitle(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42113);
    super.onFinishInflate();
    this.lHk = ((TextView)findViewById(2131300440));
    AppMethodBeat.o(42113);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(42114);
    if ((paramd == null) || (bu.isNullOrNil(paramd.ulX)))
    {
      setVisibility(8);
      AppMethodBeat.o(42114);
      return;
    }
    setVisibility(0);
    this.lHk.setText(paramd.ulX);
    AppMethodBeat.o(42114);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedModuleTitle
 * JD-Core Version:    0.7.0.1
 */
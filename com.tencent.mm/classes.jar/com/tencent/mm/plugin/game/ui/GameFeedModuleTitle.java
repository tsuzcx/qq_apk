package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.h.e;
import com.tencent.mm.plugin.game.model.d;
import com.tencent.mm.sdk.platformtools.Util;

public class GameFeedModuleTitle
  extends LinearLayout
{
  private TextView sUt;
  
  public GameFeedModuleTitle(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42113);
    super.onFinishInflate();
    this.sUt = ((TextView)findViewById(h.e.HVo));
    AppMethodBeat.o(42113);
  }
  
  public void setData(d paramd)
  {
    AppMethodBeat.i(42114);
    if ((paramd == null) || (Util.isNullOrNil(paramd.ICA)))
    {
      setVisibility(8);
      AppMethodBeat.o(42114);
      return;
    }
    setVisibility(0);
    this.sUt.setText(paramd.ICA);
    AppMethodBeat.o(42114);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameFeedModuleTitle
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bs;

public class GameBestSellingTitle
  extends LinearLayout
{
  public GameBestSellingTitle(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(41898);
    if (bs.isNullOrNil(paramString))
    {
      setVisibility(8);
      AppMethodBeat.o(41898);
      return;
    }
    setVisibility(0);
    ((TextView)findViewById(2131300352)).setText(paramString);
    AppMethodBeat.o(41898);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameBestSellingTitle
 * JD-Core Version:    0.7.0.1
 */
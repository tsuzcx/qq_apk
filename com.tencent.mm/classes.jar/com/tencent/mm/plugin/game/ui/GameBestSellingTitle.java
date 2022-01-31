package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;

public class GameBestSellingTitle
  extends LinearLayout
{
  public GameBestSellingTitle(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void setText(String paramString)
  {
    AppMethodBeat.i(111735);
    if (bo.isNullOrNil(paramString))
    {
      setVisibility(8);
      AppMethodBeat.o(111735);
      return;
    }
    setVisibility(0);
    ((TextView)findViewById(2131824430)).setText(paramString);
    AppMethodBeat.o(111735);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameBestSellingTitle
 * JD-Core Version:    0.7.0.1
 */
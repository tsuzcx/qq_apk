package com.tencent.mm.plugin.label.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.base.MMTagPanel;

public class MMLabelPanel
  extends MMTagPanel
{
  public MMLabelPanel(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MMLabelPanel(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public final void crD()
  {
    AppMethodBeat.i(26338);
    ac.d("MicroMsg.Label.MMLabelPanel", "cpan[onPreDelTag]");
    if (getTagCount() > 0)
    {
      AppMethodBeat.o(26338);
      return;
    }
    AppMethodBeat.o(26338);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.widget.MMLabelPanel
 * JD-Core Version:    0.7.0.1
 */
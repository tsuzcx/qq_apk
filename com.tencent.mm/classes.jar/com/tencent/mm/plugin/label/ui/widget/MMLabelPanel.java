package com.tencent.mm.plugin.label.ui.widget;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.sdk.platformtools.y;
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
  
  protected final void aSc()
  {
    y.d("MicroMsg.Label.MMLabelPanel", "cpan[onPreDelTag]");
    if (getTagCount() > 0) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.widget.MMLabelPanel
 * JD-Core Version:    0.7.0.1
 */
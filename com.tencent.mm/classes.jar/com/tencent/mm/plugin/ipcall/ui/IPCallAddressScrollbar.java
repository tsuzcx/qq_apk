package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.ui.base.VerticalScrollBar;

public class IPCallAddressScrollbar
  extends VerticalScrollBar
{
  public IPCallAddressScrollbar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public final void WY()
  {
    this.tNY = new String[] { "↑", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" };
    this.tNW = 1.3F;
    this.tNX = 66;
  }
  
  public int getToastLayoutId()
  {
    return 2131495439;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallAddressScrollbar
 * JD-Core Version:    0.7.0.1
 */
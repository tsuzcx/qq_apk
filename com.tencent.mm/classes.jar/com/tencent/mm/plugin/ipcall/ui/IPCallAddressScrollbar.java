package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.mm.R.i;
import com.tencent.mm.ui.base.VerticalScrollBar;

public class IPCallAddressScrollbar
  extends VerticalScrollBar
{
  public IPCallAddressScrollbar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected int getToastLayoutId()
  {
    return R.i.show_head_toast;
  }
  
  protected final void xZ()
  {
    this.lvg = new String[] { "↑", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "#" };
    this.lve = 1.3F;
    this.lvf = 79;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallAddressScrollbar
 * JD-Core Version:    0.7.0.1
 */
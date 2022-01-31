package com.tencent.mm.plugin.address.ui;

import android.text.method.NumberKeyListener;

final class AddrEditView$1
  extends NumberKeyListener
{
  AddrEditView$1(AddrEditView paramAddrEditView) {}
  
  protected final char[] getAcceptedChars()
  {
    return new char[] { 49, 50, 51, 52, 53, 54, 55, 56, 57, 48 };
  }
  
  public final int getInputType()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.ui.AddrEditView.1
 * JD-Core Version:    0.7.0.1
 */
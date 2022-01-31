package com.tencent.mm.plugin.appbrand.widget.input;

final class AppBrandInputInvokeHandler$13
  implements aa.b
{
  AppBrandInputInvokeHandler$13(AppBrandInputInvokeHandler paramAppBrandInputInvokeHandler) {}
  
  public final boolean mK(int paramInt)
  {
    if ((paramInt != 67) || (ai.s(AppBrandInputInvokeHandler.access$200(this.htr).getText()))) {
      return false;
    }
    this.htr.onBackspacePressedWhileValueNoChange(AppBrandInputInvokeHandler.access$200(this.htr).getText().toString());
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.AppBrandInputInvokeHandler.13
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.fts.ui;

import com.tencent.mm.plugin.fts.ui.widget.FTSSayFooter.a;
import com.tencent.mm.plugin.fts.ui.widget.b;
import com.tencent.mm.ui.tools.d;

final class FTSMainUI$17
  implements FTSSayFooter.a
{
  FTSMainUI$17(FTSMainUI paramFTSMainUI) {}
  
  public final void aWr()
  {
    this.kCm.kAZ.cIL();
  }
  
  public final void cV(int paramInt1, int paramInt2)
  {
    this.kCm.kAZ.wep.fF(paramInt1, paramInt2);
  }
  
  public final int getSelectionEnd()
  {
    return this.kCm.kAZ.wep.getSelectionEnd();
  }
  
  public final int getSelectionStart()
  {
    return this.kCm.kAZ.wep.getSelectionStart();
  }
  
  public final String getText()
  {
    return this.kCm.kAZ.getSearchContent();
  }
  
  public final void setText(String paramString)
  {
    this.kCm.kAZ.setSearchContent(paramString);
    if (FTSMainUI.f(this.kCm) != null) {
      FTSMainUI.f(this.kCm).rC(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.FTSMainUI.17
 * JD-Core Version:    0.7.0.1
 */
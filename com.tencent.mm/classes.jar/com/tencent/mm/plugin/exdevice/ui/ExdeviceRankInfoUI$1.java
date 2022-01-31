package com.tencent.mm.plugin.exdevice.ui;

final class ExdeviceRankInfoUI$1
  implements Runnable
{
  ExdeviceRankInfoUI$1(ExdeviceRankInfoUI paramExdeviceRankInfoUI) {}
  
  public final void run()
  {
    ExdeviceRankInfoUI.b(this.jFV).jEW = ExdeviceRankInfoUI.a(this.jFV);
    ExdeviceRankInfoUI.b(this.jFV).notifyDataSetChanged();
    ExdeviceRankInfoUI.c(this.jFV);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.1
 * JD-Core Version:    0.7.0.1
 */
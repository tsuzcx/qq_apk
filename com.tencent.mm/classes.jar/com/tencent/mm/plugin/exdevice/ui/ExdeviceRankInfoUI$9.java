package com.tencent.mm.plugin.exdevice.ui;

final class ExdeviceRankInfoUI$9
  implements Runnable
{
  ExdeviceRankInfoUI$9(ExdeviceRankInfoUI paramExdeviceRankInfoUI) {}
  
  public final void run()
  {
    ExdeviceRankInfoUI.u(this.jFV);
    if (!ExdeviceRankInfoUI.v(this.jFV))
    {
      ExdeviceRankInfoUI.h(this.jFV);
      return;
    }
    ExdeviceRankInfoUI.b(this.jFV).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceRankInfoUI.9
 * JD-Core Version:    0.7.0.1
 */
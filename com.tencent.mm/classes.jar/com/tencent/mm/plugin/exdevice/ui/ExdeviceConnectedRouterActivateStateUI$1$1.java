package com.tencent.mm.plugin.exdevice.ui;

final class ExdeviceConnectedRouterActivateStateUI$1$1
  implements Runnable
{
  ExdeviceConnectedRouterActivateStateUI$1$1(ExdeviceConnectedRouterActivateStateUI.1 param1, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    if ((this.bEg == 0) && ((this.bEf == 0) || (this.bEf == 4)))
    {
      this.jCU.jCT.qv(2);
      return;
    }
    if (this.bEf == 4)
    {
      if (this.bEg == 90000)
      {
        this.jCU.jCT.qv(3);
        return;
      }
      this.jCU.jCT.qv(5);
      return;
    }
    this.jCU.jCT.qv(4);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceConnectedRouterActivateStateUI.1.1
 * JD-Core Version:    0.7.0.1
 */
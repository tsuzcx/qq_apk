package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.mm.protocal.c.aop;
import com.tencent.mm.protocal.c.aoq;
import com.tencent.mm.protocal.c.axd;

final class ExdeviceBindDeviceUI$f
{
  public String jAY;
  public boolean jBP = false;
  public ExdeviceBindDeviceUI.b jBQ = ExdeviceBindDeviceUI.b.jBH;
  public ExdeviceBindDeviceUI.c jBR;
  public ExdeviceBindDeviceUI.d jBS;
  public aop jBT;
  public aoq jBU;
  public int jBV;
  public axd jBW;
  public String jBX;
  
  private ExdeviceBindDeviceUI$f(ExdeviceBindDeviceUI paramExdeviceBindDeviceUI) {}
  
  public final String aMu()
  {
    if (this.jBQ == ExdeviceBindDeviceUI.b.jBH)
    {
      if (this.jBU == null) {
        return null;
      }
      return this.jBU.sAE;
    }
    return this.jBR.btt;
  }
  
  public final String getKey()
  {
    if (this.jBQ == ExdeviceBindDeviceUI.b.jBH) {
      return this.jBS.jAa + this.jBS.juM;
    }
    return this.jBR.btt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceUI.f
 * JD-Core Version:    0.7.0.1
 */
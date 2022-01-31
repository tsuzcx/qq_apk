package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.auh;
import com.tencent.mm.protocal.protobuf.aui;
import com.tencent.mm.protocal.protobuf.bdt;

final class ExdeviceBindDeviceUI$f
{
  public String lKx;
  public boolean lLo = false;
  public ExdeviceBindDeviceUI.b lLp = ExdeviceBindDeviceUI.b.lLg;
  public ExdeviceBindDeviceUI.c lLq;
  public ExdeviceBindDeviceUI.d lLr;
  public auh lLs;
  public aui lLt;
  public int lLu;
  public bdt lLv;
  public String lLw;
  
  private ExdeviceBindDeviceUI$f(ExdeviceBindDeviceUI paramExdeviceBindDeviceUI) {}
  
  public final String bqH()
  {
    if (this.lLp == ExdeviceBindDeviceUI.b.lLg)
    {
      if (this.lLt == null) {
        return null;
      }
      return this.lLt.wuT;
    }
    return this.lLq.bUD;
  }
  
  public final String getKey()
  {
    AppMethodBeat.i(19856);
    if (this.lLp == ExdeviceBindDeviceUI.b.lLg)
    {
      str = this.lLr.lJz + this.lLr.lEl;
      AppMethodBeat.o(19856);
      return str;
    }
    String str = this.lLq.bUD;
    AppMethodBeat.o(19856);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceUI.f
 * JD-Core Version:    0.7.0.1
 */
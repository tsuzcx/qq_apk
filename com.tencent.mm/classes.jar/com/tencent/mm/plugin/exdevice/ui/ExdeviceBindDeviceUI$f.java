package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.bfj;
import com.tencent.mm.protocal.protobuf.bfk;
import com.tencent.mm.protocal.protobuf.bqj;

final class ExdeviceBindDeviceUI$f
{
  public boolean pbY = false;
  public ExdeviceBindDeviceUI.b pbZ = ExdeviceBindDeviceUI.b.pbQ;
  public String pbh;
  public ExdeviceBindDeviceUI.c pca;
  public ExdeviceBindDeviceUI.d pcb;
  public bfj pcc;
  public bfk pcd;
  public int pce;
  public bqj pcf;
  public String pcg;
  
  private ExdeviceBindDeviceUI$f(ExdeviceBindDeviceUI paramExdeviceBindDeviceUI) {}
  
  public final String cap()
  {
    if (this.pbZ == ExdeviceBindDeviceUI.b.pbQ)
    {
      if (this.pcd == null) {
        return null;
      }
      return this.pcd.CEQ;
    }
    return this.pca.cGn;
  }
  
  public final String getKey()
  {
    AppMethodBeat.i(23924);
    if (this.pbZ == ExdeviceBindDeviceUI.b.pbQ)
    {
      str = this.pcb.mDeviceType + this.pcb.oUX;
      AppMethodBeat.o(23924);
      return str;
    }
    String str = this.pca.cGn;
    AppMethodBeat.o(23924);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceUI.f
 * JD-Core Version:    0.7.0.1
 */
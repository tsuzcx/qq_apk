package com.tencent.mm.plugin.exdevice.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;

 enum ExdeviceBindDeviceUI$e
{
  static
  {
    AppMethodBeat.i(23923);
    qiK = new e("SCAN_ALL", 0);
    qiL = new e("SCAN_MY_DEVICE", 1);
    qiM = new e("SCAN_CATALOG", 2);
    qiN = new e[] { qiK, qiL, qiM };
    AppMethodBeat.o(23923);
  }
  
  private ExdeviceBindDeviceUI$e() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.ExdeviceBindDeviceUI.e
 * JD-Core Version:    0.7.0.1
 */
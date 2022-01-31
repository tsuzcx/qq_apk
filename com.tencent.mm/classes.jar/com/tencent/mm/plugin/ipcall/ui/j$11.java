package com.tencent.mm.plugin.ipcall.ui;

import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.report.service.h;

final class j$11
  implements IPCallFuncButton.a
{
  j$11(j paramj) {}
  
  public final void hb(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      localj = this.lAg;
      if (localj.lzA == null) {
        localj.dpY.setVisibility(8);
      }
      for (;;)
      {
        localj.dpY.setVisibility(8);
        localj.lzL.setVisibility(8);
        localj.lzJ.setText("");
        localj.lzK.setText("");
        localj.ltd.setVisibility(0);
        h.nFQ.f(12057, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0) });
        return;
        localj.dpY.setVisibility(4);
      }
    }
    j localj = this.lAg;
    if (localj.lzA != null)
    {
      localj.dpY.setVisibility(0);
      localj.lzL.setVisibility(8);
    }
    for (;;)
    {
      localj.FU(localj.lzU);
      localj.ltd.setVisibility(4);
      break;
      localj.lzL.setVisibility(0);
      localj.dpY.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.j.11
 * JD-Core Version:    0.7.0.1
 */
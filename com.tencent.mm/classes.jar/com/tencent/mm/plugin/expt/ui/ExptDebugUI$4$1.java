package com.tencent.mm.plugin.expt.ui;

import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.widget.picker.b;
import com.tencent.mm.ui.widget.picker.b.a;

final class ExptDebugUI$4$1
  implements b.a
{
  ExptDebugUI$4$1(ExptDebugUI.4 param4, b paramb, String[] paramArrayOfString) {}
  
  public final void f(boolean paramBoolean, Object paramObject)
  {
    this.hEL.hide();
    int i = this.hEL.cKk();
    paramObject = this.jJm[i];
    ExptDebugUI.a(this.jJn.jJl, bk.getInt(paramObject, 0));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.ui.ExptDebugUI.4.1
 * JD-Core Version:    0.7.0.1
 */
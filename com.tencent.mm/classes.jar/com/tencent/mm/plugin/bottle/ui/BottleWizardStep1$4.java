package com.tencent.mm.plugin.bottle.ui;

import com.tencent.mm.pluginsdk.permission.a;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.c;
import com.tencent.mm.ui.s;

final class BottleWizardStep1$4
  implements h.c
{
  BottleWizardStep1$4(BottleWizardStep1 paramBottleWizardStep1) {}
  
  public final void gl(int paramInt)
  {
    switch (paramInt)
    {
    default: 
    case 0: 
      boolean bool;
      do
      {
        return;
        bool = a.a(this.hZK.mController.uMN, "android.permission.CAMERA", 16, "", "");
        y.i("MicroMsg.BottleWizardStep1", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bk.csb(), this.hZK.mController.uMN });
      } while (!bool);
      BottleWizardStep1.b(this.hZK);
      return;
    }
    l.a(this.hZK, 2, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.BottleWizardStep1.4
 * JD-Core Version:    0.7.0.1
 */
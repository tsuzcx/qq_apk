package com.tencent.mm.plugin.mall.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cm.f;
import com.tencent.mm.plugin.mall.a.a;
import com.tencent.mm.protocal.protobuf.bkw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import java.util.LinkedList;

final class MallFunctionSettingsUI$c$1
  implements MMSwitchBtn.a
{
  MallFunctionSettingsUI$c$1(MallFunctionSettingsUI.c paramc, bkw parambkw) {}
  
  public final void onStatusChange(boolean paramBoolean)
  {
    AppMethodBeat.i(43158);
    ab.i("MicroMsg.MallFunctionSettingsUI", "click switch: %s, id: %s", new Object[] { Boolean.valueOf(paramBoolean), this.ozn.xzw });
    if (paramBoolean) {}
    for (this.ozn.jJS = 0;; this.ozn.jJS = 1)
    {
      Object localObject = new LinkedList();
      ((LinkedList)localObject).add(this.ozn);
      MallFunctionSettingsUI localMallFunctionSettingsUI = this.ozo.ozh;
      ab.i("MicroMsg.MallFunctionSettingsUI", "do batch function operate");
      localObject = new a((LinkedList)localObject, localMallFunctionSettingsUI.cLB);
      ((a)localObject).adl().b(new MallFunctionSettingsUI.2(localMallFunctionSettingsUI, (a)localObject));
      AppMethodBeat.o(43158);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallFunctionSettingsUI.c.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.mall.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

final class MallIndexBaseUI$2
  implements b.d
{
  MallIndexBaseUI$2(MallIndexBaseUI paramMallIndexBaseUI) {}
  
  public final void a(int paramInt, MallFunction paramMallFunction)
  {
    AppMethodBeat.i(43167);
    String str;
    int i;
    if (paramMallFunction != null)
    {
      str = paramMallFunction.pUM;
      if (bo.isNullOrNil(str)) {
        i = 1;
      }
    }
    for (;;)
    {
      if ((i == 0) && (!bo.isNullOrNil(paramMallFunction.umi)))
      {
        ab.i("MicroMsg.MallIndexBaseUI", "onFunctionItemClick show disclaimer funcId=%s", new Object[] { paramMallFunction.pUM });
        com.tencent.mm.ui.base.h.a(this.ozC.getContext(), paramMallFunction.umi, this.ozC.getString(2131301520), this.ozC.getString(2131302591), new MallIndexBaseUI.2.1(this, paramMallFunction, paramInt));
      }
      for (;;)
      {
        ab.d("MicroMsg.MallIndexBaseUI", "type: %s", new Object[] { Integer.valueOf(paramMallFunction.type) });
        com.tencent.mm.plugin.report.service.h.qsU.e(14419, new Object[] { this.ozC.eAx, Integer.valueOf(4), Integer.valueOf(paramMallFunction.type) });
        AppMethodBeat.o(43167);
        return;
        g.RM();
        Object localObject = (String)g.RL().Ru().get(ac.a.yBp, null);
        if (bo.isNullOrNil((String)localObject))
        {
          i = 0;
          break;
        }
        localObject = ((String)localObject).split(",");
        if ((localObject == null) || (localObject.length == 0))
        {
          i = 0;
          break;
        }
        i = 0;
        for (;;)
        {
          if (i >= localObject.length) {
            break label296;
          }
          if (localObject[i].equals(str))
          {
            i = 1;
            break;
          }
          i += 1;
        }
        this.ozC.a(paramMallFunction, paramInt);
      }
      ab.w("MicroMsg.MallIndexBaseUI", "onFunctionItemClick functionItem null; pos=%d", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(43167);
      return;
      label296:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexBaseUI.2
 * JD-Core Version:    0.7.0.1
 */
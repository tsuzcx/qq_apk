package com.tencent.mm.plugin.mall.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.utils.e.a;
import com.tencent.mm.protocal.protobuf.bvz;
import com.tencent.mm.protocal.protobuf.ckg;

final class MallWalletUI$3
  implements e.a
{
  MallWalletUI$3(MallWalletUI paramMallWalletUI) {}
  
  public final void a(bvz paramVarArgs)
  {
    AppMethodBeat.i(43267);
    String str = "";
    int i;
    if (paramVarArgs.type == 1)
    {
      paramVarArgs = paramVarArgs.url;
      i = 1;
    }
    for (;;)
    {
      h.qsU.e(16502, new Object[] { Integer.valueOf(2), paramVarArgs, Integer.valueOf(i) });
      AppMethodBeat.o(43267);
      return;
      if ((paramVarArgs.type == 2) && (paramVarArgs.xJx != null))
      {
        paramVarArgs = paramVarArgs.xJx.username;
        i = 2;
      }
      else if ((paramVarArgs.type == 4) || (paramVarArgs.type == 5))
      {
        paramVarArgs = paramVarArgs.url;
        i = 3;
      }
      else
      {
        i = 0;
        paramVarArgs = str;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallWalletUI.3
 * JD-Core Version:    0.7.0.1
 */
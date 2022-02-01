package com.tencent.mm.plugin.mall.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.utils.k.a;
import com.tencent.mm.protocal.protobuf.eaa;
import com.tencent.mm.protocal.protobuf.erw;

final class MallWalletUI$6
  implements k.a
{
  MallWalletUI$6(MallWalletUI paramMallWalletUI) {}
  
  public final void a(eaa paramVarArgs)
  {
    AppMethodBeat.i(293333);
    String str = "";
    int i;
    if (paramVarArgs.type == 1)
    {
      paramVarArgs = paramVarArgs.url;
      i = 1;
    }
    for (;;)
    {
      h.IzE.a(16502, new Object[] { Integer.valueOf(2), paramVarArgs, Integer.valueOf(i) });
      AppMethodBeat.o(293333);
      return;
      if ((paramVarArgs.type == 2) && (paramVarArgs.Ufp != null))
      {
        paramVarArgs = paramVarArgs.Ufp.username;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallWalletUI.6
 * JD-Core Version:    0.7.0.1
 */
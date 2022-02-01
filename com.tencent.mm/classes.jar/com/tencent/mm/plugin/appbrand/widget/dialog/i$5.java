package com.tencent.mm.plugin.appbrand.widget.dialog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.protocal.protobuf.fsq;
import com.tencent.mm.sdk.platformtools.Log;

final class i$5
  implements IPCRunCgi.a
{
  i$5(i parami) {}
  
  public final void callback(int paramInt1, int paramInt2, String paramString, c paramc)
  {
    AppMethodBeat.i(49869);
    Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "updateEvaluateCgi, errType:%s, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramc != null) && (c.c.b(paramc.otC) != null) && ((c.c.b(paramc.otC) instanceof fsq)))
    {
      Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "updateEvaluateCgi, request success");
      if (this.uCF.uCN)
      {
        this.uCF.fY(3, 1);
        AppMethodBeat.o(49869);
        return;
      }
      this.uCF.fY(2, 1);
      AppMethodBeat.o(49869);
      return;
    }
    Log.e("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "updateEvaluateCgi, request fail");
    if (this.uCF.uCN)
    {
      this.uCF.fY(3, 2);
      AppMethodBeat.o(49869);
      return;
    }
    this.uCF.fY(2, 2);
    AppMethodBeat.o(49869);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.i.5
 * JD-Core Version:    0.7.0.1
 */
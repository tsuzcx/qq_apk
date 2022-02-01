package com.tencent.mm.plugin.appbrand.widget.dialog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.protocal.protobuf.emp;
import com.tencent.mm.sdk.platformtools.Log;

final class f$5
  implements IPCRunCgi.a
{
  f$5(f paramf) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, d paramd)
  {
    AppMethodBeat.i(49869);
    Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "updateEvaluateCgi, errType:%s, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramd != null) && (paramd.iLL.iLR != null) && ((paramd.iLL.iLR instanceof emp)))
    {
      Log.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "updateEvaluateCgi, request success");
      if (this.oqB.GfH)
      {
        this.oqB.eI(3, 1);
        AppMethodBeat.o(49869);
        return;
      }
      this.oqB.eI(2, 1);
      AppMethodBeat.o(49869);
      return;
    }
    Log.e("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "updateEvaluateCgi, request fail");
    if (this.oqB.GfH)
    {
      this.oqB.eI(3, 2);
      AppMethodBeat.o(49869);
      return;
    }
    this.oqB.eI(2, 2);
    AppMethodBeat.o(49869);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.f.5
 * JD-Core Version:    0.7.0.1
 */
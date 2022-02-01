package com.tencent.mm.plugin.appbrand.widget.dialog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.protocal.protobuf.dgo;
import com.tencent.mm.sdk.platformtools.ad;

final class f$5
  implements IPCRunCgi.a
{
  f$5(f paramf) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, b paramb)
  {
    AppMethodBeat.i(49869);
    ad.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "updateEvaluateCgi, errType:%s, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramb != null) && (paramb.gUT.gUX != null) && ((paramb.gUT.gUX instanceof dgo)))
    {
      ad.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "updateEvaluateCgi, request success");
      if (this.lYV.KCV)
      {
        this.lYV.es(3, 1);
        AppMethodBeat.o(49869);
        return;
      }
      this.lYV.es(2, 1);
      AppMethodBeat.o(49869);
      return;
    }
    ad.e("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "updateEvaluateCgi, request fail");
    if (this.lYV.KCV)
    {
      this.lYV.es(3, 2);
      AppMethodBeat.o(49869);
      return;
    }
    this.lYV.es(2, 2);
    AppMethodBeat.o(49869);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.f.5
 * JD-Core Version:    0.7.0.1
 */
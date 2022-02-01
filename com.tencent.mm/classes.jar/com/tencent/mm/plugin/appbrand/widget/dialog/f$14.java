package com.tencent.mm.plugin.appbrand.widget.dialog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.czs;
import com.tencent.mm.sdk.platformtools.ad;

final class f$14
  implements IPCRunCgi.a
{
  f$14(f paramf) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, b paramb)
  {
    AppMethodBeat.i(49878);
    ad.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "updateGameEvaluateCgi, errType:%s, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramb != null) && (paramb.gUT.gUX != null) && ((paramb.gUT.gUX instanceof czs)))
    {
      ad.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "updateGameEvaluateCgi, request success");
      AppMethodBeat.o(49878);
      return;
    }
    h.vKh.idkeyStat(1237L, 5L, 1L, false);
    ad.e("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "updateGameEvaluateCgi, request fail");
    AppMethodBeat.o(49878);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.dialog.f.14
 * JD-Core Version:    0.7.0.1
 */
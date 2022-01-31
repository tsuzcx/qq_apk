package com.tencent.mm.plugin.appbrand.widget.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.b;
import com.tencent.mm.ai.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.b.a;
import com.tencent.mm.protocal.protobuf.cnm;
import com.tencent.mm.sdk.platformtools.ab;

final class f$11
  implements b.a
{
  f$11(f paramf) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, b paramb)
  {
    AppMethodBeat.i(134263);
    ab.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "updateEvaluateCgi, errType:%s, errCode:%s, errMsg:%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramb != null) && (paramb.fsW.fta != null) && ((paramb.fsW.fta instanceof cnm)))
    {
      ab.i("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "updateEvaluateCgi, request success");
      if (this.jjB.jju)
      {
        this.jjB.du(3, 1);
        AppMethodBeat.o(134263);
        return;
      }
      this.jjB.du(2, 1);
      AppMethodBeat.o(134263);
      return;
    }
    ab.e("MicroMsg.AppBrand.Evaluate.AppBrandEvaluateDialogHelper", "updateEvaluateCgi, request fail");
    if (this.jjB.jju)
    {
      this.jjB.du(3, 2);
      AppMethodBeat.o(134263);
      return;
    }
    this.jjB.du(2, 2);
    AppMethodBeat.o(134263);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.b.f.11
 * JD-Core Version:    0.7.0.1
 */
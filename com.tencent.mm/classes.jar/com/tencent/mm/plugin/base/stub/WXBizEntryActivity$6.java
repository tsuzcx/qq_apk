package com.tencent.mm.plugin.base.stub;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.pluginsdk.e.a;
import com.tencent.mm.protocal.protobuf.clr;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;

final class WXBizEntryActivity$6
  implements e.a
{
  WXBizEntryActivity$6(WXBizEntryActivity paramWXBizEntryActivity) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, m paramm, boolean paramBoolean)
  {
    AppMethodBeat.i(18144);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WXBizEntryActivity", "openBusinessView, DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Boolean.valueOf(paramBoolean) });
    if ((paramm != null) && (((!paramBoolean) && (!bo.isNullOrNil(paramString))) || ((paramInt1 != 0) && (paramInt2 != 0) && ((paramm instanceof com.tencent.mm.modelsimple.ab)))))
    {
      paramm = ((com.tencent.mm.modelsimple.ab)paramm).ajY();
      if ((paramm != null) && (!this.jLI.isFinishing()))
      {
        paramString = bo.nullAsNil(bo.bf(paramm.xVH, paramString));
        h.a(this.jLI, paramString, this.jLI.getString(2131297087), this.jLI.getString(2131297018), false, new WXBizEntryActivity.6.1(this, paramString));
        AppMethodBeat.o(18144);
        return;
      }
      this.jLI.finish();
      AppMethodBeat.o(18144);
      return;
    }
    this.jLI.finish();
    AppMethodBeat.o(18144);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.WXBizEntryActivity.6
 * JD-Core Version:    0.7.0.1
 */
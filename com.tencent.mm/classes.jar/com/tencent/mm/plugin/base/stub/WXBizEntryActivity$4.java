package com.tencent.mm.plugin.base.stub;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.pluginsdk.e.a;
import com.tencent.mm.protocal.protobuf.clr;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;

final class WXBizEntryActivity$4
  implements e.a
{
  WXBizEntryActivity$4(WXBizEntryActivity paramWXBizEntryActivity) {}
  
  public final void a(int paramInt1, int paramInt2, String paramString, m paramm, boolean paramBoolean)
  {
    AppMethodBeat.i(18140);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.WXBizEntryActivity", "DeepLinkHelper.DeepLinkCallback, %d, %d, %s, %b", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Boolean.valueOf(paramBoolean) });
    if ((paramm != null) && (paramInt1 != 0) && (paramInt2 != 0) && ((paramm instanceof com.tencent.mm.modelsimple.ab)))
    {
      paramString = ((com.tencent.mm.modelsimple.ab)paramm).ajY();
      if ((paramString != null) && (!this.jLI.isFinishing()))
      {
        h.a(this.jLI, bo.nullAsNil(paramString.xVH), this.jLI.getString(2131297087), this.jLI.getString(2131297018), false, new WXBizEntryActivity.4.1(this));
        AppMethodBeat.o(18140);
        return;
      }
      this.jLI.finish();
      AppMethodBeat.o(18140);
      return;
    }
    this.jLI.finish();
    AppMethodBeat.o(18140);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.WXBizEntryActivity.4
 * JD-Core Version:    0.7.0.1
 */
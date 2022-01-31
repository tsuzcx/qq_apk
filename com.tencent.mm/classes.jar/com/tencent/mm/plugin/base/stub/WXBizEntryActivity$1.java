package com.tencent.mm.plugin.base.stub;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.sdk.platformtools.ab;

final class WXBizEntryActivity$1
  implements d.a
{
  WXBizEntryActivity$1(WXBizEntryActivity paramWXBizEntryActivity) {}
  
  public final void fH(boolean paramBoolean)
  {
    AppMethodBeat.i(18135);
    if (paramBoolean) {
      d.c(this.jLI, "game", ".ui.CreateOrJoinChatroomUI", this.jLI.getIntent());
    }
    for (;;)
    {
      this.jLI.finish();
      AppMethodBeat.o(18135);
      return;
      ab.e("MicroMsg.WXBizEntryActivity", "openIdCheck false");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.WXBizEntryActivity.1
 * JD-Core Version:    0.7.0.1
 */
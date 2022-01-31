package com.tencent.mm.plugin.base.stub;

import com.tencent.mm.br.d;
import com.tencent.mm.sdk.platformtools.y;

final class WXBizEntryActivity$1
  implements d.a
{
  WXBizEntryActivity$1(WXBizEntryActivity paramWXBizEntryActivity) {}
  
  public final void em(boolean paramBoolean)
  {
    if (paramBoolean) {
      d.c(this.hSd, "game", ".ui.CreateOrJoinChatroomUI", this.hSd.getIntent());
    }
    for (;;)
    {
      this.hSd.finish();
      return;
      y.e("MicroMsg.WXBizEntryActivity", "openIdCheck false");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.WXBizEntryActivity.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.kinda.framework.module.impl;

import com.tencent.kinda.gen.KCgi;
import com.tencent.matrix.trace.core.AppMethodBeat;

class WXPNetSceneBase$1
  implements Runnable
{
  WXPNetSceneBase$1(WXPNetSceneBase paramWXPNetSceneBase, int paramInt1, WXPCommReqResp.Resp paramResp, int paramInt2) {}
  
  public void run()
  {
    AppMethodBeat.i(144589);
    if (this.val$errType == 0)
    {
      WXPNetSceneBase.access$000(this.this$0).onResp(0, this.val$resp.getResponseWrapper().getData());
      AppMethodBeat.o(144589);
      return;
    }
    if ((this.val$errType == 4) && (this.val$errCode == -102))
    {
      WXPNetSceneBase.access$000(this.this$0).onResp(351, null);
      AppMethodBeat.o(144589);
      return;
    }
    WXPNetSceneBase.access$000(this.this$0).onResp(1, null);
    AppMethodBeat.o(144589);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.WXPNetSceneBase.1
 * JD-Core Version:    0.7.0.1
 */
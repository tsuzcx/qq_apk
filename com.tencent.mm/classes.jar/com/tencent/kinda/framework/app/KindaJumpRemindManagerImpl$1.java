package com.tencent.kinda.framework.app;

import com.tencent.kinda.gen.VoidBoolStringCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.wallet_core.c.e;
import com.tencent.mm.wallet_core.c.k;

class KindaJumpRemindManagerImpl$1
  implements e
{
  KindaJumpRemindManagerImpl$1(KindaJumpRemindManagerImpl paramKindaJumpRemindManagerImpl, VoidBoolStringCallback paramVoidBoolStringCallback1, VoidBoolStringCallback paramVoidBoolStringCallback2) {}
  
  public void onCancel()
  {
    AppMethodBeat.i(144364);
    if (KindaJumpRemindManagerImpl.access$000(this.this$0).dSl()) {
      if (this.val$continueCb != null) {
        this.val$continueCb.call(false, null);
      }
    }
    for (;;)
    {
      KindaJumpRemindManagerImpl.access$000(this.this$0).dSm();
      AppMethodBeat.o(144364);
      return;
      if (this.val$interruptCb != null) {
        this.val$interruptCb.call(false, null);
      }
    }
  }
  
  public void onEnter() {}
  
  public void onUrlCancel()
  {
    AppMethodBeat.i(144366);
    if (KindaJumpRemindManagerImpl.access$000(this.this$0).dSl()) {
      if (this.val$continueCb != null) {
        this.val$continueCb.call(false, null);
      }
    }
    for (;;)
    {
      KindaJumpRemindManagerImpl.access$000(this.this$0).dSm();
      AppMethodBeat.o(144366);
      return;
      if (this.val$interruptCb != null) {
        this.val$interruptCb.call(false, null);
      }
    }
  }
  
  public void onUrlOk()
  {
    AppMethodBeat.i(144365);
    if (KindaJumpRemindManagerImpl.access$000(this.this$0).dSl()) {
      if (this.val$continueCb != null) {
        this.val$continueCb.call(true, null);
      }
    }
    for (;;)
    {
      KindaJumpRemindManagerImpl.access$000(this.this$0).dSm();
      AppMethodBeat.o(144365);
      return;
      if (this.val$interruptCb != null) {
        this.val$interruptCb.call(true, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KindaJumpRemindManagerImpl.1
 * JD-Core Version:    0.7.0.1
 */
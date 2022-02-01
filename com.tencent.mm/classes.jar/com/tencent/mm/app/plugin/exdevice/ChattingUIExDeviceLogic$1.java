package com.tencent.mm.app.plugin.exdevice;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.fk;
import com.tencent.mm.autogen.a.ob;
import com.tencent.mm.plugin.sport.a.c;
import com.tencent.mm.sdk.event.MvvmEventCenter;
import com.tencent.mm.ui.chatting.BaseChattingUIFragment;
import com.tencent.mm.ui.chatting.d.a;

final class ChattingUIExDeviceLogic$1
  implements Runnable
{
  ChattingUIExDeviceLogic$1(ChattingUIExDeviceLogic paramChattingUIExDeviceLogic, int paramInt) {}
  
  public final void run()
  {
    AppMethodBeat.i(19769);
    if (1 == this.hli)
    {
      localObject = new fk();
      ((fk)localObject).hFE.op = 0;
      ((fk)localObject).hFE.userName = this.hlj.hlc.getTalkerUserName();
      ((fk)localObject).hFE.context = this.hlj.hlc.aezO.getContext();
      ((fk)localObject).publish();
      if (this.hlj.hlc.getTalkerUserName().equals("gh_43f2581f6fd6")) {
        ((c)MvvmEventCenter.getEvent(c.class)).publish(Integer.valueOf(1));
      }
    }
    Object localObject = new ob();
    ((ob)localObject).hQz.opType = this.hli;
    ((ob)localObject).hQz.viewId = 1;
    ((ob)localObject).hQz.hQA = this.hlj.hlc.getTalkerUserName();
    ((ob)localObject).publish();
    AppMethodBeat.o(19769);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.plugin.exdevice.ChattingUIExDeviceLogic.1
 * JD-Core Version:    0.7.0.1
 */
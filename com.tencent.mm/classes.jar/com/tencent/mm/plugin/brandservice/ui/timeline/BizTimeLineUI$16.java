package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.ui.b.c;
import java.util.LinkedList;
import java.util.List;

final class BizTimeLineUI$16
  implements MessageQueue.IdleHandler
{
  BizTimeLineUI$16(BizTimeLineUI paramBizTimeLineUI, List paramList) {}
  
  public final boolean queueIdle()
  {
    AppMethodBeat.i(14200);
    Looper.myQueue().removeIdleHandler(this);
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll(this.ieO);
    c.aU(localLinkedList);
    AppMethodBeat.o(14200);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI.16
 * JD-Core Version:    0.7.0.1
 */
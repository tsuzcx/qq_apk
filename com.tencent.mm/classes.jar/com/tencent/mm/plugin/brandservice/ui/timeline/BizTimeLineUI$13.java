package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.os.MessageQueue.IdleHandler;
import com.tencent.mm.plugin.brandservice.ui.b.c;
import java.util.LinkedList;
import java.util.List;

final class BizTimeLineUI$13
  implements MessageQueue.IdleHandler
{
  BizTimeLineUI$13(BizTimeLineUI paramBizTimeLineUI, List paramList) {}
  
  public final boolean queueIdle()
  {
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.addAll(this.gFL);
    c.aM(localLinkedList);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.BizTimeLineUI.13
 * JD-Core Version:    0.7.0.1
 */
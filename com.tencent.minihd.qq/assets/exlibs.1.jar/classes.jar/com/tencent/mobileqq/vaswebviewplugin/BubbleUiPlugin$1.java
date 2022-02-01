package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.web.WebIPCOperator;

class BubbleUiPlugin$1
  implements Runnable
{
  BubbleUiPlugin$1(BubbleUiPlugin paramBubbleUiPlugin) {}
  
  public void run()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("optype", "Bubble");
    localBundle.putString("opname", "Clk_bubble_setting");
    localBundle = DataFactory.makeIPCRequestPacket("reportActionCount", "", this.this$0.mOnRemoteResp.key, localBundle);
    WebIPCOperator.getInstance().sendServiceIpcReq(localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.BubbleUiPlugin.1
 * JD-Core Version:    0.7.0.1
 */
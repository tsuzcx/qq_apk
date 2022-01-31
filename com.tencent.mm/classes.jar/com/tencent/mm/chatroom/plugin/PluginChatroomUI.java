package com.tencent.mm.chatroom.plugin;

import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import org.xwalk.core.Log;

public class PluginChatroomUI
  extends f
{
  public void execute(g paramg)
  {
    Log.i("MicroMsg.PluginChatroomUI", "[execute]");
    pin(a.xh());
  }
  
  public String name()
  {
    return "ui-chatroom";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.plugin.PluginChatroomUI
 * JD-Core Version:    0.7.0.1
 */
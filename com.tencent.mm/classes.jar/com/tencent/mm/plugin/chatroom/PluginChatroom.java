package com.tencent.mm.plugin.chatroom;

import com.tencent.mm.kernel.b.f;
import com.tencent.mm.model.n;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.plugin.chatroom.a.d;

public class PluginChatroom
  extends f
  implements d
{
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    if (paramg.Ex()) {
      com.tencent.mm.kernel.g.a(b.class, new n());
    }
  }
  
  public String name()
  {
    return "plugin-chatroom";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.chatroom.PluginChatroom
 * JD-Core Version:    0.7.0.1
 */
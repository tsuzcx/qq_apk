package com.tencent.mm.plugin.chatroom;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.model.o;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.plugin.chatroom.a.d;

public class PluginChatroom
  extends f
  implements d
{
  public void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(5560);
    if (paramg.SD()) {
      com.tencent.mm.kernel.g.b(b.class, new o());
    }
    AppMethodBeat.o(5560);
  }
  
  public String name()
  {
    return "plugin-chatroom";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.chatroom.PluginChatroom
 * JD-Core Version:    0.7.0.1
 */
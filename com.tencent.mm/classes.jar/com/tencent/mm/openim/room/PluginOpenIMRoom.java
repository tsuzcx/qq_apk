package com.tencent.mm.openim.room;

import com.tencent.mm.kernel.api.bucket.c;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.roomsdk.a.b;
import com.tencent.mm.sdk.platformtools.y;

public class PluginOpenIMRoom
  extends f
  implements c
{
  public void configure(g paramg) {}
  
  public void execute(g paramg) {}
  
  public void onAccountInitialized(e.c paramc)
  {
    y.i("MicroMsg.PluginOpenIMRoom", "onAccountInitialized");
    b.a("@im.chatroom", new a());
  }
  
  public void onAccountRelease()
  {
    y.i("MicroMsg.PluginOpenIMRoom", "onAccountRelease");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.openim.room.PluginOpenIMRoom
 * JD-Core Version:    0.7.0.1
 */
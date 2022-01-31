package com.tencent.mm.chatroom.ui;

import com.tencent.mm.kernel.g;
import com.tencent.mm.model.af;
import com.tencent.mm.model.m;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.pluginsdk.ui.applet.j;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.storage.u;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

final class ChatroomInfoUI$33
  implements Runnable
{
  ChatroomInfoUI$33(ChatroomInfoUI paramChatroomInfoUI) {}
  
  public final void run()
  {
    ChatroomInfoUI.b(this.dod, ((c)g.r(c.class)).FF().iq(ChatroomInfoUI.b(this.dod)));
    Object localObject1 = m.gK(ChatroomInfoUI.b(this.dod));
    if (localObject1 != null) {
      ChatroomInfoUI.a(this.dod, ((List)localObject1).size());
    }
    Object localObject3;
    for (;;)
    {
      localObject3 = new LinkedList();
      localObject2 = ((List)localObject1).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        String str = (String)((Iterator)localObject2).next();
        if ((ChatroomInfoUI.c(this.dod).aaM(str)) || (ChatroomInfoUI.c(this.dod).aaP(str))) {
          ((LinkedList)localObject3).add(str);
        }
      }
      localObject1 = new LinkedList();
      ChatroomInfoUI.a(this.dod, 0);
    }
    Object localObject2 = localObject1;
    if (ChatroomInfoUI.e(this.dod) > j.scD + 1)
    {
      localObject2 = localObject1;
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).subList(0, j.scD + 1);
        localObject3 = ((LinkedList)localObject3).iterator();
        for (;;)
        {
          localObject2 = localObject1;
          if (!((Iterator)localObject3).hasNext()) {
            break;
          }
          localObject2 = (String)((Iterator)localObject3).next();
          if (!((List)localObject1).contains(localObject2)) {
            ((List)localObject1).add(0, localObject2);
          }
        }
      }
    }
    ai.d(new ChatroomInfoUI.33.1(this, (List)localObject2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ChatroomInfoUI.33
 * JD-Core Version:    0.7.0.1
 */
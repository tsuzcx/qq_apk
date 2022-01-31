package com.tencent.mm.plugin.messenger.b;

import com.tencent.mm.plugin.messenger.a.e.c;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashSet;
import java.util.Map;

final class a$3
  implements Runnable
{
  a$3(a parama, String paramString, e.c paramc) {}
  
  public final void run()
  {
    y.i("MicroMsg.SysMsgTemplateImp", "hy: removing Received listener: %s", new Object[] { this.mdL });
    HashSet localHashSet = (HashSet)a.a(this.mdK).get(this.mdL);
    if (localHashSet == null) {
      return;
    }
    localHashSet.remove(this.mdM);
    if (localHashSet.size() == 0)
    {
      a.a(this.mdK).remove(this.mdL);
      return;
    }
    a.a(this.mdK).put(this.mdL, localHashSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.b.a.3
 * JD-Core Version:    0.7.0.1
 */
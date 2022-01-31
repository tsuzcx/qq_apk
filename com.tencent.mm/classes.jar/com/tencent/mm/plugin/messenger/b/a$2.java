package com.tencent.mm.plugin.messenger.b;

import com.tencent.mm.plugin.messenger.a.e.c;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashSet;
import java.util.Map;

final class a$2
  implements Runnable
{
  a$2(a parama, String paramString, e.c paramc) {}
  
  public final void run()
  {
    y.i("MicroMsg.SysMsgTemplateImp", "hy: adding Received listener: %s", new Object[] { this.mdL });
    HashSet localHashSet2 = (HashSet)a.a(this.mdK).get(this.mdL);
    HashSet localHashSet1 = localHashSet2;
    if (localHashSet2 == null) {
      localHashSet1 = new HashSet();
    }
    if (!localHashSet1.contains(this.mdM)) {
      localHashSet1.add(this.mdM);
    }
    a.a(this.mdK).put(this.mdL, localHashSet1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.b.a.2
 * JD-Core Version:    0.7.0.1
 */
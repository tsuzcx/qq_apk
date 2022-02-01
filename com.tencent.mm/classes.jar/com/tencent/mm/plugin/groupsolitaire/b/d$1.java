package com.tencent.mm.plugin.groupsolitaire.b;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.op;
import com.tencent.mm.f.c.et;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.plugin.groupsolitaire.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.storage.ca;
import java.util.concurrent.ConcurrentHashMap;

public final class d$1
  implements Runnable
{
  public d$1(d paramd, ca paramca) {}
  
  public final void run()
  {
    AppMethodBeat.i(110381);
    Object localObject = (Pair)d.a(this.Dpw).remove(Long.valueOf(this.lru.field_msgId));
    Boolean localBoolean = (Boolean)d.b(this.Dpw).remove(Long.valueOf(this.lru.field_msgId));
    d.b localb = (d.b)d.c(this.Dpw).remove(Long.valueOf(this.lru.field_msgId));
    op localop;
    if (localObject != null)
    {
      localObject = ((PluginGroupSolitaire)h.ag(PluginGroupSolitaire.class)).getGroupSolitatireManager().ik((String)((Pair)localObject).first, (String)((Pair)localObject).second);
      localop = new op();
      localop.fNr.type = 1;
      localop.fNr.key = ((a)localObject).field_key;
      localop.fNr.username = ((a)localObject).field_username;
      localop.fNr.fNt = localBoolean.booleanValue();
      if (!localBoolean.booleanValue()) {
        break label279;
      }
    }
    label279:
    for (long l = ((n)h.ae(n.class)).eSe().Oq(((a)localObject).field_firstMsgId).field_msgSvrId;; l = this.lru.field_msgSvrId)
    {
      localop.fNs.fNu = l;
      EventCenter.instance.publish(localop);
      d.b((a)localObject, localBoolean.booleanValue(), z.bcZ(), l);
      if (localb != null)
      {
        localb.DpB.field_msgSvrId = l;
        this.Dpw.a(localb.DpB, localb.DpC, localb.scene);
      }
      AppMethodBeat.o(110381);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.b.d.1
 * JD-Core Version:    0.7.0.1
 */
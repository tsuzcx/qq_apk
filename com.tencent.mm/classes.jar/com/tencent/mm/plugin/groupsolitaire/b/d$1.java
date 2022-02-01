package com.tencent.mm.plugin.groupsolitaire.b;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.nb;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.storage.bv;
import java.util.concurrent.ConcurrentHashMap;

public final class d$1
  implements Runnable
{
  public d$1(d paramd, bv parambv) {}
  
  public final void run()
  {
    AppMethodBeat.i(110381);
    Object localObject = (Pair)this.uMW.uMS.remove(Long.valueOf(this.hHF.field_msgId));
    Boolean localBoolean = (Boolean)this.uMW.uMT.remove(Long.valueOf(this.hHF.field_msgId));
    d.b localb = (d.b)this.uMW.uMV.remove(Long.valueOf(this.hHF.field_msgId));
    nb localnb;
    if (localObject != null)
    {
      localObject = ((PluginGroupSolitaire)g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager().hu((String)((Pair)localObject).first, (String)((Pair)localObject).second);
      localnb = new nb();
      localnb.dCa.type = 1;
      localnb.dCa.key = ((com.tencent.mm.plugin.groupsolitaire.c.a)localObject).field_key;
      localnb.dCa.username = ((com.tencent.mm.plugin.groupsolitaire.c.a)localObject).field_username;
      localnb.dCa.dCc = localBoolean.booleanValue();
      if (!localBoolean.booleanValue()) {
        break label279;
      }
    }
    label279:
    for (long l = ((l)g.ab(l.class)).doJ().ys(((com.tencent.mm.plugin.groupsolitaire.c.a)localObject).field_firstMsgId).field_msgSvrId;; l = this.hHF.field_msgSvrId)
    {
      localnb.dCb.dCd = l;
      com.tencent.mm.sdk.b.a.IvT.l(localnb);
      d.a((com.tencent.mm.plugin.groupsolitaire.c.a)localObject, localBoolean.booleanValue(), v.aAC(), l);
      if (localb != null)
      {
        localb.uNb.field_msgSvrId = l;
        this.uMW.a(localb.uNb, localb.uNc, localb.scene);
      }
      AppMethodBeat.o(110381);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.b.d.1
 * JD-Core Version:    0.7.0.1
 */
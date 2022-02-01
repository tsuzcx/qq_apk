package com.tencent.mm.plugin.groupsolitaire.b;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.pz;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.plugin.groupsolitaire.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.storage.cc;
import java.util.concurrent.ConcurrentHashMap;

public final class d$1
  implements Runnable
{
  public d$1(d paramd, cc paramcc) {}
  
  public final void run()
  {
    AppMethodBeat.i(110381);
    Object localObject = (Pair)d.a(this.Jje).remove(Long.valueOf(this.oiV.field_msgId));
    Boolean localBoolean = (Boolean)d.b(this.Jje).remove(Long.valueOf(this.oiV.field_msgId));
    d.b localb = (d.b)d.c(this.Jje).remove(Long.valueOf(this.oiV.field_msgId));
    pz localpz;
    cc localcc;
    if (localObject != null)
    {
      localObject = ((PluginGroupSolitaire)h.az(PluginGroupSolitaire.class)).getGroupSolitatireManager().jr((String)((Pair)localObject).first, (String)((Pair)localObject).second);
      localpz = new pz();
      localpz.hTe.type = 1;
      localpz.hTe.key = ((a)localObject).field_key;
      localpz.hTe.username = ((a)localObject).field_username;
      localpz.hTe.hTg = localBoolean.booleanValue();
      l = 0L;
      if (!localBoolean.booleanValue()) {
        break label287;
      }
      localcc = ((n)h.ax(n.class)).gaZ().sl(((a)localObject).field_firstMsgId);
      if (localcc == null) {}
    }
    label287:
    for (long l = localcc.field_msgSvrId;; l = this.oiV.field_msgSvrId)
    {
      localpz.hTf.hTh = l;
      localpz.publish();
      d.b((a)localObject, localBoolean.booleanValue(), z.bAM(), l);
      if (localb != null)
      {
        localb.Jjj.field_msgSvrId = l;
        this.Jje.a(localb.Jjj, localb.Jjk, localb.scene);
      }
      AppMethodBeat.o(110381);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.b.d.1
 * JD-Core Version:    0.7.0.1
 */
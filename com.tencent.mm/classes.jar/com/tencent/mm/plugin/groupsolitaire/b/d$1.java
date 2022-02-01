package com.tencent.mm.plugin.groupsolitaire.b;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ms;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.plugin.messenger.foundation.a.a.h;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.storage.bo;
import java.util.concurrent.ConcurrentHashMap;

public final class d$1
  implements Runnable
{
  public d$1(d paramd, bo parambo) {}
  
  public final void run()
  {
    AppMethodBeat.i(110381);
    Object localObject = (Pair)this.tyH.tyD.remove(Long.valueOf(this.hmA.field_msgId));
    Boolean localBoolean = (Boolean)this.tyH.tyE.remove(Long.valueOf(this.hmA.field_msgId));
    d.b localb = (d.b)this.tyH.tyG.remove(Long.valueOf(this.hmA.field_msgId));
    ms localms;
    if (localObject != null)
    {
      localObject = ((PluginGroupSolitaire)g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager().hb((String)((Pair)localObject).first, (String)((Pair)localObject).second);
      localms = new ms();
      localms.dpi.type = 1;
      localms.dpi.key = ((com.tencent.mm.plugin.groupsolitaire.c.a)localObject).field_key;
      localms.dpi.username = ((com.tencent.mm.plugin.groupsolitaire.c.a)localObject).field_username;
      localms.dpi.dpk = localBoolean.booleanValue();
      if (!localBoolean.booleanValue()) {
        break label279;
      }
    }
    label279:
    for (long l = ((k)g.ab(k.class)).dcr().vP(((com.tencent.mm.plugin.groupsolitaire.c.a)localObject).field_firstMsgId).field_msgSvrId;; l = this.hmA.field_msgSvrId)
    {
      localms.dpj.dpl = l;
      com.tencent.mm.sdk.b.a.GpY.l(localms);
      d.a((com.tencent.mm.plugin.groupsolitaire.c.a)localObject, localBoolean.booleanValue(), u.axw(), l);
      if (localb != null)
      {
        localb.tyM.field_msgSvrId = l;
        this.tyH.a(localb.tyM, localb.tyN, localb.scene);
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
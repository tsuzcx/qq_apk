package com.tencent.mm.plugin.account.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.al;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

final class a$3
  implements com.tencent.mm.plugin.account.a.a.b
{
  a$3(a parama) {}
  
  public final void cY(boolean paramBoolean)
  {
    AppMethodBeat.i(124656);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ContactsAutoSyncLogic ", "performSync end, succ:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean)
    {
      AppMethodBeat.o(124656);
      return;
    }
    if (l.aqz().size() > 0)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ContactsAutoSyncLogic ", "start to upload mobile list");
      g.Rc().a(133, this.gAE);
      System.currentTimeMillis();
      l.aqv();
      localObject = new al(l.aqz(), l.aqy());
      g.Rc().a((m)localObject, 0);
      AppMethodBeat.o(124656);
      return;
    }
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ContactsAutoSyncLogic ", "update mobile friend list");
    Object localObject = (String[])this.gAE.gAB.toArray(new String[0]);
    this.gAE.gAB.clear();
    ArrayList localArrayList = new ArrayList();
    int j = localObject.length;
    int i = 0;
    if (i < j)
    {
      String str = localObject[i];
      com.tencent.mm.plugin.account.friend.a.a locala = com.tencent.mm.plugin.account.a.getAddrUploadStg().wX(str);
      if ((locala != null) && (!bo.isNullOrNil(locala.aqf())))
      {
        localArrayList.add(locala.aqf());
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ContactsAutoSyncLogic ", "find mobile %s username %s", new Object[] { locala.aqf(), str });
      }
      for (;;)
      {
        i += 1;
        break;
        com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ContactsAutoSyncLogic ", "not find mobile username %s", new Object[] { str });
      }
    }
    g.Rc().a(32, this.gAE);
    if (localArrayList.size() == 0)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ContactsAutoSyncLogic ", "sync mobile list is zero");
      localObject = new com.tencent.mm.plugin.account.friend.a.ab();
      g.Rc().a((m)localObject, 0);
      AppMethodBeat.o(124656);
      return;
    }
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ContactsAutoSyncLogic ", "sync mobile list is %d", new Object[] { Integer.valueOf(localArrayList.size()) });
    localObject = new com.tencent.mm.plugin.account.friend.a.ab(localArrayList, null);
    g.Rc().a((m)localObject, 0);
    AppMethodBeat.o(124656);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.a.3
 * JD-Core Version:    0.7.0.1
 */
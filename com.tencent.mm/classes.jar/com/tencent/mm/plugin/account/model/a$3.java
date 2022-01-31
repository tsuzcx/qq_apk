package com.tencent.mm.plugin.account.model;

import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.friend.a.ab;
import com.tencent.mm.plugin.account.friend.a.al;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

final class a$3
  implements com.tencent.mm.plugin.account.a.a.b
{
  a$3(a parama) {}
  
  public final void bW(boolean paramBoolean)
  {
    y.i("MicroMsg.ContactsAutoSyncLogic ", "performSync end, succ:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    if (!paramBoolean) {
      return;
    }
    if (l.WW().size() > 0)
    {
      y.i("MicroMsg.ContactsAutoSyncLogic ", "start to upload mobile list");
      g.Dk().a(133, this.fjm);
      System.currentTimeMillis();
      localObject = new al(l.WW(), l.WV());
      g.Dk().a((m)localObject, 0);
      return;
    }
    y.i("MicroMsg.ContactsAutoSyncLogic ", "update mobile friend list");
    Object localObject = (String[])this.fjm.fjj.toArray(new String[0]);
    this.fjm.fjj.clear();
    ArrayList localArrayList = new ArrayList();
    int j = localObject.length;
    int i = 0;
    if (i < j)
    {
      String str = localObject[i];
      com.tencent.mm.plugin.account.friend.a.a locala = com.tencent.mm.plugin.account.b.getAddrUploadStg().pH(str);
      if ((locala != null) && (!bk.bl(locala.WD())))
      {
        localArrayList.add(locala.WD());
        y.i("MicroMsg.ContactsAutoSyncLogic ", "find mobile %s username %s", new Object[] { locala.WD(), str });
      }
      for (;;)
      {
        i += 1;
        break;
        y.i("MicroMsg.ContactsAutoSyncLogic ", "not find mobile username %s", new Object[] { str });
      }
    }
    g.Dk().a(32, this.fjm);
    if (localArrayList.size() == 0)
    {
      y.i("MicroMsg.ContactsAutoSyncLogic ", "sync mobile list is zero");
      localObject = new ab();
      g.Dk().a((m)localObject, 0);
      return;
    }
    y.i("MicroMsg.ContactsAutoSyncLogic ", "sync mobile list is %d", new Object[] { Integer.valueOf(localArrayList.size()) });
    localObject = new ab(localArrayList, null);
    g.Dk().a((m)localObject, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.a.3
 * JD-Core Version:    0.7.0.1
 */
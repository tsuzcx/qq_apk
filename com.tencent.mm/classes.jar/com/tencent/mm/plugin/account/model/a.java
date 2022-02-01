package com.tencent.mm.plugin.account.model;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.ly;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class a
  implements f
{
  com.tencent.mm.plugin.account.a.a.b hWQ;
  boolean imJ;
  Set<String> jhl;
  c jhm;
  ap jhn;
  
  public a()
  {
    AppMethodBeat.i(127810);
    this.jhl = Collections.synchronizedSet(new HashSet());
    this.imJ = false;
    this.jhm = new c() {};
    this.jhn = new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(127808);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(127808);
          return;
          a.this.imJ = true;
          boolean bool = com.tencent.mm.platformtools.a.syncAddrBook(a.this.hWQ);
          if (!bool) {
            a.this.imJ = false;
          }
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ContactsAutoSyncLogic ", "sync result %b", new Object[] { Boolean.valueOf(bool) });
        }
      }
    };
    this.hWQ = new com.tencent.mm.plugin.account.a.a.b()
    {
      public final void eO(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(127809);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ContactsAutoSyncLogic ", "performSync end, succ:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(127809);
          return;
        }
        if (l.aSX().size() > 0)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ContactsAutoSyncLogic ", "start to upload mobile list");
          g.aiU().a(133, a.this);
          System.currentTimeMillis();
          l.aST();
          localObject = new ao(l.aSX(), l.aSW());
          g.aiU().a((n)localObject, 0);
          AppMethodBeat.o(127809);
          return;
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ContactsAutoSyncLogic ", "update mobile friend list");
        Object localObject = (String[])a.this.jhl.toArray(new String[0]);
        a.this.jhl.clear();
        ArrayList localArrayList = new ArrayList();
        int j = localObject.length;
        int i = 0;
        if (i < j)
        {
          String str = localObject[i];
          com.tencent.mm.plugin.account.friend.a.a locala = com.tencent.mm.plugin.account.a.getAddrUploadStg().Ju(str);
          if ((locala != null) && (!bt.isNullOrNil(locala.aSD())))
          {
            localArrayList.add(locala.aSD());
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ContactsAutoSyncLogic ", "find mobile %s username %s", new Object[] { locala.aSD(), str });
          }
          for (;;)
          {
            i += 1;
            break;
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ContactsAutoSyncLogic ", "not find mobile username %s", new Object[] { str });
          }
        }
        g.aiU().a(32, a.this);
        if (localArrayList.size() == 0)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ContactsAutoSyncLogic ", "sync mobile list is zero");
          localObject = new com.tencent.mm.plugin.account.friend.a.ad();
          g.aiU().a((n)localObject, 0);
          AppMethodBeat.o(127809);
          return;
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ContactsAutoSyncLogic ", "sync mobile list is %d", new Object[] { Integer.valueOf(localArrayList.size()) });
        localObject = new com.tencent.mm.plugin.account.friend.a.ad(localArrayList, null);
        g.aiU().a((n)localObject, 0);
        AppMethodBeat.o(127809);
      }
    };
    com.tencent.mm.sdk.b.a.IbL.c(this.jhm);
    AppMethodBeat.o(127810);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(127811);
    if (paramn.getType() == 133)
    {
      g.aiU().b(133, this);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break label137;
      }
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ContactsAutoSyncLogic ", "MMFunc_UploadMContact onSceneEnd: errType = " + paramInt1 + ", errCode = " + paramInt2);
      this.imJ = false;
    }
    while (paramn.getType() == 32)
    {
      this.imJ = false;
      g.aiU().b(32, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ContactsAutoSyncLogic ", "rtGETMFRIEND onSceneEnd: errType = " + paramInt1 + ", errCode = " + paramInt2);
        AppMethodBeat.o(127811);
        return;
        label137:
        g.aiU().a(32, this);
        paramString = (ao)paramn;
        paramString = new com.tencent.mm.plugin.account.friend.a.ad(paramString.jeE, paramString.jeF);
        g.aiU().a(paramString, 0);
      }
      else
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ContactsAutoSyncLogic ", "update All Contact");
        t.cW(aj.getContext());
      }
    }
    AppMethodBeat.o(127811);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.account.model;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.lg;
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
  implements com.tencent.mm.al.g
{
  com.tencent.mm.plugin.account.a.a.b hdI;
  boolean hsM;
  Set<String> inW;
  c inX;
  ap inY;
  
  public a()
  {
    AppMethodBeat.i(127810);
    this.inW = Collections.synchronizedSet(new HashSet());
    this.hsM = false;
    this.inX = new c() {};
    this.inY = new ap()
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
          a.this.hsM = true;
          boolean bool = com.tencent.mm.platformtools.a.syncAddrBook(a.this.hdI);
          if (!bool) {
            a.this.hsM = false;
          }
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ContactsAutoSyncLogic ", "sync result %b", new Object[] { Boolean.valueOf(bool) });
        }
      }
    };
    this.hdI = new com.tencent.mm.plugin.account.a.a.b()
    {
      public final void er(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(127809);
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ContactsAutoSyncLogic ", "performSync end, succ:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(127809);
          return;
        }
        if (l.aIU().size() > 0)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ContactsAutoSyncLogic ", "start to upload mobile list");
          com.tencent.mm.kernel.g.aeS().a(133, a.this);
          System.currentTimeMillis();
          l.aIQ();
          localObject = new ao(l.aIU(), l.aIT());
          com.tencent.mm.kernel.g.aeS().a((n)localObject, 0);
          AppMethodBeat.o(127809);
          return;
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ContactsAutoSyncLogic ", "update mobile friend list");
        Object localObject = (String[])a.this.inW.toArray(new String[0]);
        a.this.inW.clear();
        ArrayList localArrayList = new ArrayList();
        int j = localObject.length;
        int i = 0;
        if (i < j)
        {
          String str = localObject[i];
          com.tencent.mm.plugin.account.friend.a.a locala = com.tencent.mm.plugin.account.a.getAddrUploadStg().Cc(str);
          if ((locala != null) && (!bt.isNullOrNil(locala.aIA())))
          {
            localArrayList.add(locala.aIA());
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ContactsAutoSyncLogic ", "find mobile %s username %s", new Object[] { locala.aIA(), str });
          }
          for (;;)
          {
            i += 1;
            break;
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ContactsAutoSyncLogic ", "not find mobile username %s", new Object[] { str });
          }
        }
        com.tencent.mm.kernel.g.aeS().a(32, a.this);
        if (localArrayList.size() == 0)
        {
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ContactsAutoSyncLogic ", "sync mobile list is zero");
          localObject = new com.tencent.mm.plugin.account.friend.a.ad();
          com.tencent.mm.kernel.g.aeS().a((n)localObject, 0);
          AppMethodBeat.o(127809);
          return;
        }
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ContactsAutoSyncLogic ", "sync mobile list is %d", new Object[] { Integer.valueOf(localArrayList.size()) });
        localObject = new com.tencent.mm.plugin.account.friend.a.ad(localArrayList, null);
        com.tencent.mm.kernel.g.aeS().a((n)localObject, 0);
        AppMethodBeat.o(127809);
      }
    };
    com.tencent.mm.sdk.b.a.ESL.c(this.inX);
    AppMethodBeat.o(127810);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(127811);
    if (paramn.getType() == 133)
    {
      com.tencent.mm.kernel.g.aeS().b(133, this);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break label137;
      }
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ContactsAutoSyncLogic ", "MMFunc_UploadMContact onSceneEnd: errType = " + paramInt1 + ", errCode = " + paramInt2);
      this.hsM = false;
    }
    while (paramn.getType() == 32)
    {
      this.hsM = false;
      com.tencent.mm.kernel.g.aeS().b(32, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ContactsAutoSyncLogic ", "rtGETMFRIEND onSceneEnd: errType = " + paramInt1 + ", errCode = " + paramInt2);
        AppMethodBeat.o(127811);
        return;
        label137:
        com.tencent.mm.kernel.g.aeS().a(32, this);
        paramString = (ao)paramn;
        paramString = new com.tencent.mm.plugin.account.friend.a.ad(paramString.ilo, paramString.ilp);
        com.tencent.mm.kernel.g.aeS().a(paramString, 0);
      }
      else
      {
        com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ContactsAutoSyncLogic ", "update All Contact");
        t.cP(aj.getContext());
      }
    }
    AppMethodBeat.o(127811);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.a
 * JD-Core Version:    0.7.0.1
 */
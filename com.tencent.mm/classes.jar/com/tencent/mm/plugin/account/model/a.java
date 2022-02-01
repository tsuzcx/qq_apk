package com.tencent.mm.plugin.account.model;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.lp;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.account.friend.a.ad;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class a
  implements com.tencent.mm.ak.g
{
  com.tencent.mm.plugin.account.a.a.b hEl;
  boolean hTo;
  Set<String> iOc;
  c iOd;
  com.tencent.mm.sdk.platformtools.ao iOe;
  
  public a()
  {
    AppMethodBeat.i(127810);
    this.iOc = Collections.synchronizedSet(new HashSet());
    this.hTo = false;
    this.iOd = new c() {};
    this.iOe = new com.tencent.mm.sdk.platformtools.ao()
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
          a.this.hTo = true;
          boolean bool = com.tencent.mm.platformtools.a.syncAddrBook(a.this.hEl);
          if (!bool) {
            a.this.hTo = false;
          }
          ac.i("MicroMsg.ContactsAutoSyncLogic ", "sync result %b", new Object[] { Boolean.valueOf(bool) });
        }
      }
    };
    this.hEl = new com.tencent.mm.plugin.account.a.a.b()
    {
      public final void eM(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(127809);
        ac.i("MicroMsg.ContactsAutoSyncLogic ", "performSync end, succ:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(127809);
          return;
        }
        if (l.aPL().size() > 0)
        {
          ac.i("MicroMsg.ContactsAutoSyncLogic ", "start to upload mobile list");
          com.tencent.mm.kernel.g.agi().a(133, a.this);
          System.currentTimeMillis();
          l.aPH();
          localObject = new com.tencent.mm.plugin.account.friend.a.ao(l.aPL(), l.aPK());
          com.tencent.mm.kernel.g.agi().a((n)localObject, 0);
          AppMethodBeat.o(127809);
          return;
        }
        ac.i("MicroMsg.ContactsAutoSyncLogic ", "update mobile friend list");
        Object localObject = (String[])a.this.iOc.toArray(new String[0]);
        a.this.iOc.clear();
        ArrayList localArrayList = new ArrayList();
        int j = localObject.length;
        int i = 0;
        if (i < j)
        {
          String str = localObject[i];
          com.tencent.mm.plugin.account.friend.a.a locala = com.tencent.mm.plugin.account.a.getAddrUploadStg().Gf(str);
          if ((locala != null) && (!bs.isNullOrNil(locala.aPr())))
          {
            localArrayList.add(locala.aPr());
            ac.i("MicroMsg.ContactsAutoSyncLogic ", "find mobile %s username %s", new Object[] { locala.aPr(), str });
          }
          for (;;)
          {
            i += 1;
            break;
            ac.i("MicroMsg.ContactsAutoSyncLogic ", "not find mobile username %s", new Object[] { str });
          }
        }
        com.tencent.mm.kernel.g.agi().a(32, a.this);
        if (localArrayList.size() == 0)
        {
          ac.i("MicroMsg.ContactsAutoSyncLogic ", "sync mobile list is zero");
          localObject = new ad();
          com.tencent.mm.kernel.g.agi().a((n)localObject, 0);
          AppMethodBeat.o(127809);
          return;
        }
        ac.i("MicroMsg.ContactsAutoSyncLogic ", "sync mobile list is %d", new Object[] { Integer.valueOf(localArrayList.size()) });
        localObject = new ad(localArrayList, null);
        com.tencent.mm.kernel.g.agi().a((n)localObject, 0);
        AppMethodBeat.o(127809);
      }
    };
    com.tencent.mm.sdk.b.a.GpY.c(this.iOd);
    AppMethodBeat.o(127810);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(127811);
    if (paramn.getType() == 133)
    {
      com.tencent.mm.kernel.g.agi().b(133, this);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break label137;
      }
      ac.e("MicroMsg.ContactsAutoSyncLogic ", "MMFunc_UploadMContact onSceneEnd: errType = " + paramInt1 + ", errCode = " + paramInt2);
      this.hTo = false;
    }
    while (paramn.getType() == 32)
    {
      this.hTo = false;
      com.tencent.mm.kernel.g.agi().b(32, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ac.e("MicroMsg.ContactsAutoSyncLogic ", "rtGETMFRIEND onSceneEnd: errType = " + paramInt1 + ", errCode = " + paramInt2);
        AppMethodBeat.o(127811);
        return;
        label137:
        com.tencent.mm.kernel.g.agi().a(32, this);
        paramString = (com.tencent.mm.plugin.account.friend.a.ao)paramn;
        paramString = new ad(paramString.iLv, paramString.iLw);
        com.tencent.mm.kernel.g.agi().a(paramString, 0);
      }
      else
      {
        ac.i("MicroMsg.ContactsAutoSyncLogic ", "update All Contact");
        t.cY(ai.getContext());
      }
    }
    AppMethodBeat.o(127811);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.a
 * JD-Core Version:    0.7.0.1
 */
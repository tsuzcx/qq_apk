package com.tencent.mm.plugin.account.model;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.lz;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.account.friend.a.ad;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class a
  implements f
{
  com.tencent.mm.plugin.account.a.a.b hZI;
  boolean ipD;
  Set<String> jke;
  c jkf;
  aq jkg;
  
  public a()
  {
    AppMethodBeat.i(127810);
    this.jke = Collections.synchronizedSet(new HashSet());
    this.ipD = false;
    this.jkf = new c() {};
    this.jkg = new aq()
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
          a.this.ipD = true;
          boolean bool = com.tencent.mm.platformtools.a.syncAddrBook(a.this.hZI);
          if (!bool) {
            a.this.ipD = false;
          }
          ae.i("MicroMsg.ContactsAutoSyncLogic ", "sync result %b", new Object[] { Boolean.valueOf(bool) });
        }
      }
    };
    this.hZI = new com.tencent.mm.plugin.account.a.a.b()
    {
      public final void eQ(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(127809);
        ae.i("MicroMsg.ContactsAutoSyncLogic ", "performSync end, succ:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(127809);
          return;
        }
        if (l.aTw().size() > 0)
        {
          ae.i("MicroMsg.ContactsAutoSyncLogic ", "start to upload mobile list");
          g.ajj().a(133, a.this);
          System.currentTimeMillis();
          l.aTs();
          localObject = new ao(l.aTw(), l.aTv());
          g.ajj().a((n)localObject, 0);
          AppMethodBeat.o(127809);
          return;
        }
        ae.i("MicroMsg.ContactsAutoSyncLogic ", "update mobile friend list");
        Object localObject = (String[])a.this.jke.toArray(new String[0]);
        a.this.jke.clear();
        ArrayList localArrayList = new ArrayList();
        int j = localObject.length;
        int i = 0;
        if (i < j)
        {
          String str = localObject[i];
          com.tencent.mm.plugin.account.friend.a.a locala = com.tencent.mm.plugin.account.a.getAddrUploadStg().JT(str);
          if ((locala != null) && (!bu.isNullOrNil(locala.aTc())))
          {
            localArrayList.add(locala.aTc());
            ae.i("MicroMsg.ContactsAutoSyncLogic ", "find mobile %s username %s", new Object[] { locala.aTc(), str });
          }
          for (;;)
          {
            i += 1;
            break;
            ae.i("MicroMsg.ContactsAutoSyncLogic ", "not find mobile username %s", new Object[] { str });
          }
        }
        g.ajj().a(32, a.this);
        if (localArrayList.size() == 0)
        {
          ae.i("MicroMsg.ContactsAutoSyncLogic ", "sync mobile list is zero");
          localObject = new ad();
          g.ajj().a((n)localObject, 0);
          AppMethodBeat.o(127809);
          return;
        }
        ae.i("MicroMsg.ContactsAutoSyncLogic ", "sync mobile list is %d", new Object[] { Integer.valueOf(localArrayList.size()) });
        localObject = new ad(localArrayList, null);
        g.ajj().a((n)localObject, 0);
        AppMethodBeat.o(127809);
      }
    };
    com.tencent.mm.sdk.b.a.IvT.c(this.jkf);
    AppMethodBeat.o(127810);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(127811);
    if (paramn.getType() == 133)
    {
      g.ajj().b(133, this);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break label137;
      }
      ae.e("MicroMsg.ContactsAutoSyncLogic ", "MMFunc_UploadMContact onSceneEnd: errType = " + paramInt1 + ", errCode = " + paramInt2);
      this.ipD = false;
    }
    while (paramn.getType() == 32)
    {
      this.ipD = false;
      g.ajj().b(32, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        ae.e("MicroMsg.ContactsAutoSyncLogic ", "rtGETMFRIEND onSceneEnd: errType = " + paramInt1 + ", errCode = " + paramInt2);
        AppMethodBeat.o(127811);
        return;
        label137:
        g.ajj().a(32, this);
        paramString = (ao)paramn;
        paramString = new ad(paramString.jhx, paramString.jhy);
        g.ajj().a(paramString, 0);
      }
      else
      {
        ae.i("MicroMsg.ContactsAutoSyncLogic ", "update All Contact");
        t.cY(ak.getContext());
      }
    }
    AppMethodBeat.o(127811);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.a
 * JD-Core Version:    0.7.0.1
 */
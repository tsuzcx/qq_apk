package com.tencent.mm.plugin.account.model;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.app.f;
import com.tencent.mm.plugin.account.friend.model.aa;
import com.tencent.mm.plugin.account.friend.model.al;
import com.tencent.mm.plugin.account.friend.model.i;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class a
  implements com.tencent.mm.am.h
{
  private com.tencent.mm.plugin.account.sdk.a.b oDA;
  private boolean oTC;
  private Set<String> pWo;
  IListener pWp;
  private MMHandler pWq;
  
  public a()
  {
    AppMethodBeat.i(127810);
    this.pWo = Collections.synchronizedSet(new HashSet());
    this.oTC = false;
    this.pWp = new ContactsAutoSyncLogic.1(this, f.hfK);
    this.pWq = new MMHandler()
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
          a.a(a.this, true);
          boolean bool = com.tencent.mm.platformtools.a.syncAddrBook(a.d(a.this));
          if (!bool) {
            a.a(a.this, false);
          }
          Log.i("MicroMsg.ContactsAutoSyncLogic ", "sync result %b", new Object[] { Boolean.valueOf(bool) });
        }
      }
    };
    this.oDA = new com.tencent.mm.plugin.account.sdk.a.b()
    {
      public final void hi(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(127809);
        Log.i("MicroMsg.ContactsAutoSyncLogic ", "performSync end, succ:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(127809);
          return;
        }
        Object localObject = i.bXe();
        if ((localObject != null) && (((List)localObject).size() > 0))
        {
          Log.i("MicroMsg.ContactsAutoSyncLogic ", "start to upload mobile list");
          com.tencent.mm.kernel.h.aZW().a(133, a.this);
          System.currentTimeMillis();
          i.bXa();
          localObject = new al(i.bXe(), i.bXd());
          com.tencent.mm.kernel.h.aZW().a((p)localObject, 0);
          AppMethodBeat.o(127809);
          return;
        }
        Log.i("MicroMsg.ContactsAutoSyncLogic ", "update mobile friend list");
        localObject = (String[])a.b(a.this).toArray(new String[0]);
        a.b(a.this).clear();
        ArrayList localArrayList = new ArrayList();
        int j = localObject.length;
        int i = 0;
        if (i < j)
        {
          String str = localObject[i];
          com.tencent.mm.plugin.account.friend.model.a locala = com.tencent.mm.plugin.account.b.getAddrUploadStg().SR(str);
          if ((locala != null) && (!Util.isNullOrNil(locala.bWN())))
          {
            localArrayList.add(locala.bWN());
            Log.i("MicroMsg.ContactsAutoSyncLogic ", "find mobile %s username %s", new Object[] { locala.bWN(), str });
          }
          for (;;)
          {
            i += 1;
            break;
            Log.i("MicroMsg.ContactsAutoSyncLogic ", "not find mobile username %s", new Object[] { str });
          }
        }
        com.tencent.mm.kernel.h.aZW().a(32, a.this);
        if (localArrayList.size() == 0)
        {
          Log.i("MicroMsg.ContactsAutoSyncLogic ", "sync mobile list is zero");
          localObject = new aa();
          com.tencent.mm.kernel.h.aZW().a((p)localObject, 0);
          AppMethodBeat.o(127809);
          return;
        }
        Log.i("MicroMsg.ContactsAutoSyncLogic ", "sync mobile list is %d", new Object[] { Integer.valueOf(localArrayList.size()) });
        localObject = new aa(localArrayList, null);
        com.tencent.mm.kernel.h.aZW().a((p)localObject, 0);
        AppMethodBeat.o(127809);
      }
    };
    AppMethodBeat.o(127810);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(127811);
    if (paramp.getType() == 133)
    {
      com.tencent.mm.kernel.h.aZW().b(133, this);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break label137;
      }
      Log.e("MicroMsg.ContactsAutoSyncLogic ", "MMFunc_UploadMContact onSceneEnd: errType = " + paramInt1 + ", errCode = " + paramInt2);
      this.oTC = false;
    }
    while (paramp.getType() == 32)
    {
      this.oTC = false;
      com.tencent.mm.kernel.h.aZW().b(32, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.ContactsAutoSyncLogic ", "rtGETMFRIEND onSceneEnd: errType = " + paramInt1 + ", errCode = " + paramInt2);
        AppMethodBeat.o(127811);
        return;
        label137:
        com.tencent.mm.kernel.h.aZW().a(32, this);
        paramString = (al)paramp;
        paramString = new aa(paramString.pTH, paramString.pTI);
        com.tencent.mm.kernel.h.aZW().a(paramString, 0);
      }
      else
      {
        Log.i("MicroMsg.ContactsAutoSyncLogic ", "update All Contact");
      }
    }
    AppMethodBeat.o(127811);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.a
 * JD-Core Version:    0.7.0.1
 */
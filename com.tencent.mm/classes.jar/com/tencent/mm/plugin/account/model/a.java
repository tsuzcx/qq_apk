package com.tencent.mm.plugin.account.model;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.f.a.ng;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.account.friend.a.ad;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class a
  implements i
{
  private com.tencent.mm.plugin.account.sdk.a.b lKY;
  private Set<String> mZF;
  IListener mZG;
  private MMHandler mZH;
  private boolean maL;
  
  public a()
  {
    AppMethodBeat.i(127810);
    this.mZF = Collections.synchronizedSet(new HashSet());
    this.maL = false;
    this.mZG = new IListener() {};
    this.mZH = new MMHandler()
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
    this.lKY = new com.tencent.mm.plugin.account.sdk.a.b()
    {
      public final void gr(boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(127809);
        Log.i("MicroMsg.ContactsAutoSyncLogic ", "performSync end, succ:%b", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
        if (!paramAnonymousBoolean)
        {
          AppMethodBeat.o(127809);
          return;
        }
        if (l.byr().size() > 0)
        {
          Log.i("MicroMsg.ContactsAutoSyncLogic ", "start to upload mobile list");
          h.aGY().a(133, a.this);
          System.currentTimeMillis();
          l.byn();
          localObject = new ao(l.byr(), l.byq());
          h.aGY().a((q)localObject, 0);
          AppMethodBeat.o(127809);
          return;
        }
        Log.i("MicroMsg.ContactsAutoSyncLogic ", "update mobile friend list");
        Object localObject = (String[])a.b(a.this).toArray(new String[0]);
        a.b(a.this).clear();
        ArrayList localArrayList = new ArrayList();
        int j = localObject.length;
        int i = 0;
        if (i < j)
        {
          String str = localObject[i];
          com.tencent.mm.plugin.account.friend.a.a locala = com.tencent.mm.plugin.account.b.getAddrUploadStg().aax(str);
          if ((locala != null) && (!Util.isNullOrNil(locala.bxY())))
          {
            localArrayList.add(locala.bxY());
            Log.i("MicroMsg.ContactsAutoSyncLogic ", "find mobile %s username %s", new Object[] { locala.bxY(), str });
          }
          for (;;)
          {
            i += 1;
            break;
            Log.i("MicroMsg.ContactsAutoSyncLogic ", "not find mobile username %s", new Object[] { str });
          }
        }
        h.aGY().a(32, a.this);
        if (localArrayList.size() == 0)
        {
          Log.i("MicroMsg.ContactsAutoSyncLogic ", "sync mobile list is zero");
          localObject = new ad();
          h.aGY().a((q)localObject, 0);
          AppMethodBeat.o(127809);
          return;
        }
        Log.i("MicroMsg.ContactsAutoSyncLogic ", "sync mobile list is %d", new Object[] { Integer.valueOf(localArrayList.size()) });
        localObject = new ad(localArrayList, null);
        h.aGY().a((q)localObject, 0);
        AppMethodBeat.o(127809);
      }
    };
    EventCenter.instance.addListener(this.mZG);
    AppMethodBeat.o(127810);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(127811);
    if (paramq.getType() == 133)
    {
      h.aGY().b(133, this);
      if ((paramInt1 == 0) && (paramInt2 == 0)) {
        break label137;
      }
      Log.e("MicroMsg.ContactsAutoSyncLogic ", "MMFunc_UploadMContact onSceneEnd: errType = " + paramInt1 + ", errCode = " + paramInt2);
      this.maL = false;
    }
    while (paramq.getType() == 32)
    {
      this.maL = false;
      h.aGY().b(32, this);
      if ((paramInt1 != 0) || (paramInt2 != 0))
      {
        Log.e("MicroMsg.ContactsAutoSyncLogic ", "rtGETMFRIEND onSceneEnd: errType = " + paramInt1 + ", errCode = " + paramInt2);
        AppMethodBeat.o(127811);
        return;
        label137:
        h.aGY().a(32, this);
        paramString = (ao)paramq;
        paramString = new ad(paramString.mWZ, paramString.mXa);
        h.aGY().a(paramString, 0);
      }
      else
      {
        Log.i("MicroMsg.ContactsAutoSyncLogic ", "update All Contact");
        com.tencent.mm.platformtools.t.dq(MMApplicationContext.getContext());
      }
    }
    AppMethodBeat.o(127811);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.a
 * JD-Core Version:    0.7.0.1
 */
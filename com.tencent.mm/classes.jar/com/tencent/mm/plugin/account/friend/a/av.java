package com.tencent.mm.plugin.account.friend.a;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.qk;
import com.tencent.mm.g.b.a.ju;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.account.friend.widget.RecoverFriendSortView;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.bfi;
import com.tencent.mm.protocal.protobuf.bfj;
import com.tencent.mm.protocal.protobuf.cem;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.e.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class av
  extends com.tencent.mm.sdk.b.c<qk>
  implements com.tencent.mm.ak.f
{
  public Activity activity;
  p fPj;
  public RecoverFriendSortView jhX;
  public String jhY;
  ArrayList<com.tencent.mm.ui.base.sortview.d> jhZ;
  private int jia;
  boolean jib;
  AtomicInteger jic;
  public String sessionId;
  
  public av(Activity paramActivity)
  {
    AppMethodBeat.i(184440);
    this.jhZ = new ArrayList();
    this.jia = 65;
    this.jic = new AtomicInteger();
    this.activity = paramActivity;
    this.__eventId = qk.class.getName().hashCode();
    AppMethodBeat.o(184440);
  }
  
  final void aTR()
  {
    AppMethodBeat.i(184442);
    int i = au.Kj(this.jhY);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.RecoverFriendPresenter", "totalCount %d", new Object[] { Integer.valueOf(i) });
    if ((this.jia == 65) && (i < 20))
    {
      Object localObject = au.aD(this.jhY, -1);
      if (!((List)localObject).isEmpty())
      {
        localObject = ((List)localObject).iterator();
        if (((Iterator)localObject).hasNext())
        {
          au.a locala = (au.a)((Iterator)localObject).next();
          com.tencent.mm.ui.base.sortview.d locald = new com.tencent.mm.ui.base.sortview.d();
          locald.data = locala;
          i = locala.jhV.field_showHead;
          if ((i >= 65) && (i <= 90)) {}
          for (locald.JOY = ((char)i);; locald.JOY = "#")
          {
            this.jhZ.add(locald);
            break;
          }
        }
        this.jhX.gB(this.jhZ);
      }
      this.jia = 92;
      AppMethodBeat.o(184442);
      return;
    }
    do
    {
      aTS();
    } while ((this.jhZ.size() < 20) && (this.jia <= 91));
    AppMethodBeat.o(184442);
  }
  
  final void aTS()
  {
    AppMethodBeat.i(184443);
    while (this.jia <= 91)
    {
      Object localObject = au.aD(this.jhY, this.jia);
      this.jia += 1;
      if (!((List)localObject).isEmpty())
      {
        localObject = ((List)localObject).iterator();
        if (((Iterator)localObject).hasNext())
        {
          au.a locala = (au.a)((Iterator)localObject).next();
          com.tencent.mm.ui.base.sortview.d locald = new com.tencent.mm.ui.base.sortview.d();
          locald.data = locala;
          int i = locala.jhV.field_showHead;
          if ((i >= 65) && (i <= 90)) {}
          for (locald.JOY = ((char)i);; locald.JOY = "#")
          {
            this.jhZ.add(locald);
            break;
          }
        }
        this.jhX.gB(this.jhZ);
        AppMethodBeat.o(184443);
        return;
      }
    }
    AppMethodBeat.o(184443);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(184444);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.RecoverFriendPresenter", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.jib = ((bfj)((ae)paramn).gRX.hQE.hQJ).GUq;
      paramString = ((ae)paramn).aTC();
      final String str = ((bfi)((ae)paramn).gRX.hQD.hQJ).nIJ;
      com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.RecoverFriendPresenter", "hasContinue %s, oldAccount friend %d", new Object[] { Boolean.valueOf(this.jib), Integer.valueOf(paramString.size()) });
      if (!this.jhY.equals(str))
      {
        com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.RecoverFriendPresenter", "(%s,%s), not my old username, ignore", new Object[] { this.jhY, str });
        AppMethodBeat.o(184444);
        return;
      }
      this.jic.getAndIncrement();
      com.tencent.e.h.MqF.f(new com.tencent.e.i.i()
      {
        public final void aTT()
        {
          AppMethodBeat.i(184437);
          String str1 = str;
          List localList = paramString;
          Iterator localIterator = localList.iterator();
          int i = 0;
          cem localcem;
          r localr;
          label87:
          int j;
          label160:
          boolean bool;
          if (localIterator.hasNext())
          {
            localcem = (cem)localIterator.next();
            if (bu.isNullOrNil(localcem.dzr)) {
              break label423;
            }
            localr = au.bR(str1, localcem.dzr);
            if (localr != null) {
              break label420;
            }
            localr = new r();
            localr.field_encryptUsername = localcem.dzr;
            localr.field_nickname = localcem.nJO;
            localr.field_pinyinName = bu.nullAsNil(com.tencent.mm.platformtools.f.Jk(localcem.nJO)).toUpperCase();
            String str2 = localr.field_pinyinName;
            if (!bu.isNullOrNil(str2))
            {
              j = str2.charAt(0);
              if ((j >= 65) && (j <= 90))
              {
                localr.field_showHead = j;
                localr.field_ticket = localcem.xrf;
                localr.field_username = localcem.nIJ;
                localr.field_oldUsername = str1;
                localr.field_seq = localcem.Gdy;
                if (localr.systemRowid != -1L) {
                  break label288;
                }
                bool = ((ap)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getOldAccountFriendStorage()).insert(localr);
                com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.RecoverFriendLogic", "insert local old friend (%s,%s), success %s", new Object[] { localcem.dzr, localcem.nJO, Boolean.valueOf(bool) });
              }
            }
          }
          for (;;)
          {
            label271:
            if (bool) {
              i += 1;
            }
            for (;;)
            {
              break;
              j = 91;
              break label160;
              label288:
              bool = ((ap)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getOldAccountFriendStorage()).replace(localr);
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.RecoverFriendLogic", "replace local old friend (%s,%s), success %s", new Object[] { localcem.dzr, localcem.nJO, Boolean.valueOf(bool) });
              break label271;
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.RecoverFriendLogic", "insert local old %d, success %d", new Object[] { Integer.valueOf(localList.size()), Integer.valueOf(i) });
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.RecoverFriendPresenter", "insert old account friend %d, success %d", new Object[] { Integer.valueOf(paramString.size()), Integer.valueOf(i) });
              AppMethodBeat.o(184437);
              return;
            }
            label420:
            break label87;
            label423:
            bool = false;
          }
        }
      }, "Insert_Old_Account_Friend");
      if (this.jib)
      {
        ru(((ae)paramn).jhk);
        AppMethodBeat.o(184444);
        return;
      }
      if (this.jic.get() == 0)
      {
        com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.RecoverFriendPresenter", "all insert tasks are finished!");
        if (this.fPj != null) {
          this.fPj.dismiss();
        }
        aTR();
      }
      AppMethodBeat.o(184444);
      return;
    }
    aTR();
    if (this.fPj != null) {
      this.fPj.dismiss();
    }
    paramn = paramString;
    if (bu.isNullOrNil(paramString)) {
      paramn = this.activity.getString(2131755733);
    }
    com.tencent.mm.ui.base.h.cm(this.activity, paramn);
    AppMethodBeat.o(184444);
  }
  
  public final void ru(int paramInt)
  {
    AppMethodBeat.i(184441);
    com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.RecoverFriendPresenter", "do next scene, oldWx %s,seq %d", new Object[] { this.jhY, Integer.valueOf(paramInt) });
    ae localae = new ae(this.jhY, paramInt, this.sessionId);
    g.ajj().a(localae, 0);
    if (this.fPj == null) {
      this.fPj = com.tencent.mm.ui.base.h.b(this.activity, this.activity.getString(2131755805), false, null);
    }
    AppMethodBeat.o(184441);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.av
 * JD-Core Version:    0.7.0.1
 */
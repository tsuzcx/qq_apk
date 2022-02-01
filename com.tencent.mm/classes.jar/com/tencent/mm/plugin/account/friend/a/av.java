package com.tencent.mm.plugin.account.friend.a;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.qj;
import com.tencent.mm.g.b.a.js;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.account.friend.widget.RecoverFriendSortView;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.bes;
import com.tencent.mm.protocal.protobuf.bet;
import com.tencent.mm.protocal.protobuf.cds;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.e.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class av
  extends c<qj>
  implements com.tencent.mm.al.f
{
  public Activity activity;
  p fNb;
  public RecoverFriendSortView jfe;
  public String jff;
  ArrayList<com.tencent.mm.ui.base.sortview.d> jfg;
  private int jfh;
  boolean jfi;
  AtomicInteger jfj;
  public String sessionId;
  
  public av(Activity paramActivity)
  {
    AppMethodBeat.i(184440);
    this.jfg = new ArrayList();
    this.jfh = 65;
    this.jfj = new AtomicInteger();
    this.activity = paramActivity;
    this.__eventId = qj.class.getName().hashCode();
    AppMethodBeat.o(184440);
  }
  
  final void aTs()
  {
    AppMethodBeat.i(184442);
    int i = au.JK(this.jff);
    ad.i("MicroMsg.RecoverFriendPresenter", "totalCount %d", new Object[] { Integer.valueOf(i) });
    if ((this.jfh == 65) && (i < 20))
    {
      Object localObject = au.aC(this.jff, -1);
      if (!((List)localObject).isEmpty())
      {
        localObject = ((List)localObject).iterator();
        if (((Iterator)localObject).hasNext())
        {
          au.a locala = (au.a)((Iterator)localObject).next();
          com.tencent.mm.ui.base.sortview.d locald = new com.tencent.mm.ui.base.sortview.d();
          locald.data = locala;
          i = locala.jfc.field_showHead;
          if ((i >= 65) && (i <= 90)) {}
          for (locald.Juj = ((char)i);; locald.Juj = "#")
          {
            this.jfg.add(locald);
            break;
          }
        }
        this.jfe.gs(this.jfg);
      }
      this.jfh = 92;
      AppMethodBeat.o(184442);
      return;
    }
    do
    {
      aTt();
    } while ((this.jfg.size() < 20) && (this.jfh <= 91));
    AppMethodBeat.o(184442);
  }
  
  final void aTt()
  {
    AppMethodBeat.i(184443);
    while (this.jfh <= 91)
    {
      Object localObject = au.aC(this.jff, this.jfh);
      this.jfh += 1;
      if (!((List)localObject).isEmpty())
      {
        localObject = ((List)localObject).iterator();
        if (((Iterator)localObject).hasNext())
        {
          au.a locala = (au.a)((Iterator)localObject).next();
          com.tencent.mm.ui.base.sortview.d locald = new com.tencent.mm.ui.base.sortview.d();
          locald.data = locala;
          int i = locala.jfc.field_showHead;
          if ((i >= 65) && (i <= 90)) {}
          for (locald.Juj = ((char)i);; locald.Juj = "#")
          {
            this.jfg.add(locald);
            break;
          }
        }
        this.jfe.gs(this.jfg);
        AppMethodBeat.o(184443);
        return;
      }
    }
    AppMethodBeat.o(184443);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(184444);
    ad.i("MicroMsg.RecoverFriendPresenter", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.jfi = ((bet)((ae)paramn).gPp.hNL.hNQ).GAQ;
      paramString = ((ae)paramn).aTd();
      final String str = ((bes)((ae)paramn).gPp.hNK.hNQ).nDo;
      ad.i("MicroMsg.RecoverFriendPresenter", "hasContinue %s, oldAccount friend %d", new Object[] { Boolean.valueOf(this.jfi), Integer.valueOf(paramString.size()) });
      if (!this.jff.equals(str))
      {
        ad.w("MicroMsg.RecoverFriendPresenter", "(%s,%s), not my old username, ignore", new Object[] { this.jff, str });
        AppMethodBeat.o(184444);
        return;
      }
      this.jfj.getAndIncrement();
      com.tencent.e.h.LTJ.f(new com.tencent.e.i.i()
      {
        public final void aTu()
        {
          AppMethodBeat.i(184437);
          String str1 = str;
          List localList = paramString;
          Iterator localIterator = localList.iterator();
          int i = 0;
          cds localcds;
          r localr;
          label87:
          int j;
          label160:
          boolean bool;
          if (localIterator.hasNext())
          {
            localcds = (cds)localIterator.next();
            if (bt.isNullOrNil(localcds.dym)) {
              break label423;
            }
            localr = au.bR(str1, localcds.dym);
            if (localr != null) {
              break label420;
            }
            localr = new r();
            localr.field_encryptUsername = localcds.dym;
            localr.field_nickname = localcds.nEt;
            localr.field_pinyinName = bt.nullAsNil(com.tencent.mm.platformtools.f.IL(localcds.nEt)).toUpperCase();
            String str2 = localr.field_pinyinName;
            if (!bt.isNullOrNil(str2))
            {
              j = str2.charAt(0);
              if ((j >= 65) && (j <= 90))
              {
                localr.field_showHead = j;
                localr.field_ticket = localcds.xbo;
                localr.field_username = localcds.nDo;
                localr.field_oldUsername = str1;
                localr.field_seq = localcds.FKZ;
                if (localr.systemRowid != -1L) {
                  break label288;
                }
                bool = ((ap)((com.tencent.mm.plugin.account.a.a.a)g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getOldAccountFriendStorage()).insert(localr);
                ad.i("MicroMsg.RecoverFriendLogic", "insert local old friend (%s,%s), success %s", new Object[] { localcds.dym, localcds.nEt, Boolean.valueOf(bool) });
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
              ad.i("MicroMsg.RecoverFriendLogic", "replace local old friend (%s,%s), success %s", new Object[] { localcds.dym, localcds.nEt, Boolean.valueOf(bool) });
              break label271;
              ad.i("MicroMsg.RecoverFriendLogic", "insert local old %d, success %d", new Object[] { Integer.valueOf(localList.size()), Integer.valueOf(i) });
              ad.i("MicroMsg.RecoverFriendPresenter", "insert old account friend %d, success %d", new Object[] { Integer.valueOf(paramString.size()), Integer.valueOf(i) });
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
      if (this.jfi)
      {
        rr(((ae)paramn).jer);
        AppMethodBeat.o(184444);
        return;
      }
      if (this.jfj.get() == 0)
      {
        ad.i("MicroMsg.RecoverFriendPresenter", "all insert tasks are finished!");
        if (this.fNb != null) {
          this.fNb.dismiss();
        }
        aTs();
      }
      AppMethodBeat.o(184444);
      return;
    }
    aTs();
    if (this.fNb != null) {
      this.fNb.dismiss();
    }
    paramn = paramString;
    if (bt.isNullOrNil(paramString)) {
      paramn = this.activity.getString(2131755733);
    }
    com.tencent.mm.ui.base.h.cl(this.activity, paramn);
    AppMethodBeat.o(184444);
  }
  
  public final void rr(int paramInt)
  {
    AppMethodBeat.i(184441);
    ad.i("MicroMsg.RecoverFriendPresenter", "do next scene, oldWx %s,seq %d", new Object[] { this.jff, Integer.valueOf(paramInt) });
    ae localae = new ae(this.jff, paramInt, this.sessionId);
    g.aiU().a(localae, 0);
    if (this.fNb == null) {
      this.fNb = com.tencent.mm.ui.base.h.b(this.activity, this.activity.getString(2131755805), false, null);
    }
    AppMethodBeat.o(184441);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.av
 * JD-Core Version:    0.7.0.1
 */
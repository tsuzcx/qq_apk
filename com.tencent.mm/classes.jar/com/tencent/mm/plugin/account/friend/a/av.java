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
import com.tencent.mm.g.a.pp;
import com.tencent.mm.g.b.a.gv;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.plugin.account.a.a.a;
import com.tencent.mm.plugin.account.friend.widget.RecoverFriendSortView;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.protobuf.aww;
import com.tencent.mm.protocal.protobuf.awx;
import com.tencent.mm.protocal.protobuf.buk;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.e.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class av
  extends c<pp>
  implements com.tencent.mm.al.g
{
  public Activity activity;
  ArrayList<com.tencent.mm.ui.base.sortview.d> dataList;
  p fqw;
  public RecoverFriendSortView ilO;
  public String ilP;
  private int ilR;
  boolean ilS;
  AtomicInteger ilT;
  public String sessionId;
  
  public av(Activity paramActivity)
  {
    AppMethodBeat.i(184440);
    this.dataList = new ArrayList();
    this.ilR = 65;
    this.ilT = new AtomicInteger();
    this.activity = paramActivity;
    this.__eventId = pp.class.getName().hashCode();
    AppMethodBeat.o(184440);
  }
  
  final void aJp()
  {
    AppMethodBeat.i(184442);
    int i = au.Cs(this.ilP);
    ad.i("MicroMsg.RecoverFriendPresenter", "totalCount %d", new Object[] { Integer.valueOf(i) });
    if ((this.ilR == 65) && (i < 20))
    {
      Object localObject = au.aw(this.ilP, -1);
      if (!((List)localObject).isEmpty())
      {
        localObject = ((List)localObject).iterator();
        if (((Iterator)localObject).hasNext())
        {
          au.a locala = (au.a)((Iterator)localObject).next();
          com.tencent.mm.ui.base.sortview.d locald = new com.tencent.mm.ui.base.sortview.d();
          locald.data = locala;
          i = locala.ilM.field_showHead;
          if ((i >= 65) && (i <= 90)) {}
          for (locald.GgC = ((char)i);; locald.GgC = "#")
          {
            this.dataList.add(locald);
            break;
          }
        }
        this.ilO.ga(this.dataList);
      }
      this.ilR = 92;
      AppMethodBeat.o(184442);
      return;
    }
    do
    {
      aJq();
    } while ((this.dataList.size() < 20) && (this.ilR <= 91));
    AppMethodBeat.o(184442);
  }
  
  final void aJq()
  {
    AppMethodBeat.i(184443);
    while (this.ilR <= 91)
    {
      Object localObject = au.aw(this.ilP, this.ilR);
      this.ilR += 1;
      if (!((List)localObject).isEmpty())
      {
        localObject = ((List)localObject).iterator();
        if (((Iterator)localObject).hasNext())
        {
          au.a locala = (au.a)((Iterator)localObject).next();
          com.tencent.mm.ui.base.sortview.d locald = new com.tencent.mm.ui.base.sortview.d();
          locald.data = locala;
          int i = locala.ilM.field_showHead;
          if ((i >= 65) && (i <= 90)) {}
          for (locald.GgC = ((char)i);; locald.GgC = "#")
          {
            this.dataList.add(locald);
            break;
          }
        }
        this.ilO.ga(this.dataList);
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
      this.ilS = ((awx)((ae)paramn).iaa.gUT.gUX).Dwd;
      paramString = ((ae)paramn).aJa();
      final String str = ((aww)((ae)paramn).iaa.gUS.gUX).mAQ;
      ad.i("MicroMsg.RecoverFriendPresenter", "hasContinue %s, oldAccount friend %d", new Object[] { Boolean.valueOf(this.ilS), Integer.valueOf(paramString.size()) });
      if (!this.ilP.equals(str))
      {
        ad.w("MicroMsg.RecoverFriendPresenter", "(%s,%s), not my old username, ignore", new Object[] { this.ilP, str });
        AppMethodBeat.o(184444);
        return;
      }
      this.ilT.getAndIncrement();
      com.tencent.e.h.Iye.f(new com.tencent.e.i.i()
      {
        public final void aJr()
        {
          AppMethodBeat.i(184437);
          String str1 = str;
          List localList = paramString;
          Iterator localIterator = localList.iterator();
          int i = 0;
          buk localbuk;
          r localr;
          label87:
          int j;
          label160:
          boolean bool;
          if (localIterator.hasNext())
          {
            localbuk = (buk)localIterator.next();
            if (bt.isNullOrNil(localbuk.doQ)) {
              break label423;
            }
            localr = au.bH(str1, localbuk.doQ);
            if (localr != null) {
              break label420;
            }
            localr = new r();
            localr.field_encryptUsername = localbuk.doQ;
            localr.field_nickname = localbuk.mBV;
            localr.field_pinyinName = bt.nullAsNil(f.Br(localbuk.mBV)).toUpperCase();
            String str2 = localr.field_pinyinName;
            if (!bt.isNullOrNil(str2))
            {
              j = str2.charAt(0);
              if ((j >= 65) && (j <= 90))
              {
                localr.field_showHead = j;
                localr.field_ticket = localbuk.Ddo;
                localr.field_username = localbuk.mAQ;
                localr.field_oldUsername = str1;
                localr.field_seq = localbuk.CLY;
                if (localr.systemRowid != -1L) {
                  break label288;
                }
                bool = ((ap)((a)com.tencent.mm.kernel.g.ad(a.class)).getOldAccountFriendStorage()).insert(localr);
                ad.i("MicroMsg.RecoverFriendLogic", "insert local old friend (%s,%s), success %s", new Object[] { localbuk.doQ, localbuk.mBV, Boolean.valueOf(bool) });
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
              bool = ((ap)((a)com.tencent.mm.kernel.g.ad(a.class)).getOldAccountFriendStorage()).replace(localr);
              ad.i("MicroMsg.RecoverFriendLogic", "replace local old friend (%s,%s), success %s", new Object[] { localbuk.doQ, localbuk.mBV, Boolean.valueOf(bool) });
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
      if (this.ilS)
      {
        qe(((ae)paramn).ilb);
        AppMethodBeat.o(184444);
        return;
      }
      if (this.ilT.get() == 0)
      {
        ad.i("MicroMsg.RecoverFriendPresenter", "all insert tasks are finished!");
        if (this.fqw != null) {
          this.fqw.dismiss();
        }
        aJp();
      }
      AppMethodBeat.o(184444);
      return;
    }
    aJp();
    if (this.fqw != null) {
      this.fqw.dismiss();
    }
    paramn = paramString;
    if (bt.isNullOrNil(paramString)) {
      paramn = this.activity.getString(2131755733);
    }
    com.tencent.mm.ui.base.h.cf(this.activity, paramn);
    AppMethodBeat.o(184444);
  }
  
  public final void qe(int paramInt)
  {
    AppMethodBeat.i(184441);
    ad.i("MicroMsg.RecoverFriendPresenter", "do next scene, oldWx %s,seq %d", new Object[] { this.ilP, Integer.valueOf(paramInt) });
    ae localae = new ae(this.ilP, paramInt, this.sessionId);
    com.tencent.mm.kernel.g.aeS().a(localae, 0);
    if (this.fqw == null) {
      this.fqw = com.tencent.mm.ui.base.h.b(this.activity, this.activity.getString(2131755805), false, null);
    }
    AppMethodBeat.o(184441);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.av
 * JD-Core Version:    0.7.0.1
 */
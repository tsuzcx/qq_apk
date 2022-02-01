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
import com.tencent.mm.g.a.py;
import com.tencent.mm.g.b.a.in;
import com.tencent.mm.model.u;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.plugin.account.a.a.a;
import com.tencent.mm.plugin.account.friend.widget.RecoverFriendSortView;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.protocal.protobuf.bao;
import com.tencent.mm.protocal.protobuf.bap;
import com.tencent.mm.protocal.protobuf.bzb;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.e.c;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class av
  extends c<py>
  implements com.tencent.mm.ak.g
{
  public Activity activity;
  ArrayList<com.tencent.mm.ui.base.sortview.d> dataList;
  p fua;
  public RecoverFriendSortView iLV;
  public String iLW;
  private int iLX;
  boolean iLY;
  AtomicInteger iLZ;
  public String sessionId;
  
  public av(Activity paramActivity)
  {
    AppMethodBeat.i(184440);
    this.dataList = new ArrayList();
    this.iLX = 65;
    this.iLZ = new AtomicInteger();
    this.activity = paramActivity;
    this.__eventId = py.class.getName().hashCode();
    AppMethodBeat.o(184440);
  }
  
  final void aQg()
  {
    AppMethodBeat.i(184442);
    int i = au.Gv(this.iLW);
    ac.i("MicroMsg.RecoverFriendPresenter", "totalCount %d", new Object[] { Integer.valueOf(i) });
    if ((this.iLX == 65) && (i < 20))
    {
      Object localObject = au.aA(this.iLW, -1);
      if (!((List)localObject).isEmpty())
      {
        localObject = ((List)localObject).iterator();
        if (((Iterator)localObject).hasNext())
        {
          au.a locala = (au.a)((Iterator)localObject).next();
          com.tencent.mm.ui.base.sortview.d locald = new com.tencent.mm.ui.base.sortview.d();
          locald.data = locala;
          i = locala.iLT.field_showHead;
          if ((i >= 65) && (i <= 90)) {}
          for (locald.HGs = ((char)i);; locald.HGs = "#")
          {
            this.dataList.add(locald);
            break;
          }
        }
        this.iLV.gh(this.dataList);
      }
      this.iLX = 92;
      AppMethodBeat.o(184442);
      return;
    }
    do
    {
      aQh();
    } while ((this.dataList.size() < 20) && (this.iLX <= 91));
    AppMethodBeat.o(184442);
  }
  
  final void aQh()
  {
    AppMethodBeat.i(184443);
    while (this.iLX <= 91)
    {
      Object localObject = au.aA(this.iLW, this.iLX);
      this.iLX += 1;
      if (!((List)localObject).isEmpty())
      {
        localObject = ((List)localObject).iterator();
        if (((Iterator)localObject).hasNext())
        {
          au.a locala = (au.a)((Iterator)localObject).next();
          com.tencent.mm.ui.base.sortview.d locald = new com.tencent.mm.ui.base.sortview.d();
          locald.data = locala;
          int i = locala.iLT.field_showHead;
          if ((i >= 65) && (i <= 90)) {}
          for (locald.HGs = ((char)i);; locald.HGs = "#")
          {
            this.dataList.add(locald);
            break;
          }
        }
        this.iLV.gh(this.dataList);
        AppMethodBeat.o(184443);
        return;
      }
    }
    AppMethodBeat.o(184443);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, n paramn)
  {
    AppMethodBeat.i(184444);
    ac.i("MicroMsg.RecoverFriendPresenter", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.iLY = ((bap)((ae)paramn).gvE.hvs.hvw).ERy;
      paramString = ((ae)paramn).aPR();
      final String str = ((bao)((ae)paramn).gvE.hvr.hvw).ncR;
      ac.i("MicroMsg.RecoverFriendPresenter", "hasContinue %s, oldAccount friend %d", new Object[] { Boolean.valueOf(this.iLY), Integer.valueOf(paramString.size()) });
      if (!this.iLW.equals(str))
      {
        ac.w("MicroMsg.RecoverFriendPresenter", "(%s,%s), not my old username, ignore", new Object[] { this.iLW, str });
        AppMethodBeat.o(184444);
        return;
      }
      this.iLZ.getAndIncrement();
      com.tencent.e.h.JZN.f(new com.tencent.e.i.i()
      {
        public final void aQi()
        {
          AppMethodBeat.i(184437);
          String str1 = str;
          List localList = paramString;
          Iterator localIterator = localList.iterator();
          int i = 0;
          bzb localbzb;
          r localr;
          label87:
          int j;
          label160:
          boolean bool;
          if (localIterator.hasNext())
          {
            localbzb = (bzb)localIterator.next();
            if (bs.isNullOrNil(localbzb.dmy)) {
              break label423;
            }
            localr = au.bP(str1, localbzb.dmy);
            if (localr != null) {
              break label420;
            }
            localr = new r();
            localr.field_encryptUsername = localbzb.dmy;
            localr.field_nickname = localbzb.ndW;
            localr.field_pinyinName = bs.nullAsNil(f.Fv(localbzb.ndW)).toUpperCase();
            String str2 = localr.field_pinyinName;
            if (!bs.isNullOrNil(str2))
            {
              j = str2.charAt(0);
              if ((j >= 65) && (j <= 90))
              {
                localr.field_showHead = j;
                localr.field_ticket = localbzb.Ewu;
                localr.field_username = localbzb.ncR;
                localr.field_oldUsername = str1;
                localr.field_seq = localbzb.EeA;
                if (localr.systemRowid != -1L) {
                  break label288;
                }
                bool = ((ap)((a)com.tencent.mm.kernel.g.ad(a.class)).getOldAccountFriendStorage()).insert(localr);
                ac.i("MicroMsg.RecoverFriendLogic", "insert local old friend (%s,%s), success %s", new Object[] { localbzb.dmy, localbzb.ndW, Boolean.valueOf(bool) });
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
              ac.i("MicroMsg.RecoverFriendLogic", "replace local old friend (%s,%s), success %s", new Object[] { localbzb.dmy, localbzb.ndW, Boolean.valueOf(bool) });
              break label271;
              ac.i("MicroMsg.RecoverFriendLogic", "insert local old %d, success %d", new Object[] { Integer.valueOf(localList.size()), Integer.valueOf(i) });
              ac.i("MicroMsg.RecoverFriendPresenter", "insert old account friend %d, success %d", new Object[] { Integer.valueOf(paramString.size()), Integer.valueOf(i) });
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
      if (this.iLY)
      {
        qR(((ae)paramn).iLi);
        AppMethodBeat.o(184444);
        return;
      }
      if (this.iLZ.get() == 0)
      {
        ac.i("MicroMsg.RecoverFriendPresenter", "all insert tasks are finished!");
        if (this.fua != null) {
          this.fua.dismiss();
        }
        aQg();
      }
      AppMethodBeat.o(184444);
      return;
    }
    aQg();
    if (this.fua != null) {
      this.fua.dismiss();
    }
    paramn = paramString;
    if (bs.isNullOrNil(paramString)) {
      paramn = this.activity.getString(2131755733);
    }
    com.tencent.mm.ui.base.h.cg(this.activity, paramn);
    AppMethodBeat.o(184444);
  }
  
  public final void qR(int paramInt)
  {
    AppMethodBeat.i(184441);
    ac.i("MicroMsg.RecoverFriendPresenter", "do next scene, oldWx %s,seq %d", new Object[] { this.iLW, Integer.valueOf(paramInt) });
    ae localae = new ae(this.iLW, paramInt, this.sessionId);
    com.tencent.mm.kernel.g.agi().a(localae, 0);
    if (this.fua == null) {
      this.fua = com.tencent.mm.ui.base.h.b(this.activity, this.activity.getString(2131755805), false, null);
    }
    AppMethodBeat.o(184441);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.av
 * JD-Core Version:    0.7.0.1
 */
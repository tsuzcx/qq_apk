package com.tencent.mm.plugin.account.friend.a;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.by.c;
import com.tencent.mm.f.a.se;
import com.tencent.mm.f.b.a.qt;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.plugin.account.friend.a.g;
import com.tencent.mm.plugin.account.friend.widget.RecoverFriendSortView;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.bza;
import com.tencent.mm.protocal.protobuf.bzb;
import com.tencent.mm.protocal.protobuf.deb;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.f.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class av
  extends IListener<se>
  implements com.tencent.mm.an.i
{
  public Activity activity;
  private s iYE;
  public String mXA;
  private ArrayList<com.tencent.mm.ui.base.sortview.d> mXB;
  private int mXC;
  private boolean mXD;
  private AtomicInteger mXE;
  public RecoverFriendSortView mXz;
  public String sessionId;
  
  public av(Activity paramActivity)
  {
    AppMethodBeat.i(184440);
    this.mXB = new ArrayList();
    this.mXC = 65;
    this.mXE = new AtomicInteger();
    this.activity = paramActivity;
    this.__eventId = se.class.getName().hashCode();
    AppMethodBeat.o(184440);
  }
  
  private void byM()
  {
    AppMethodBeat.i(184442);
    int i = au.aaN(this.mXA);
    Log.i("MicroMsg.RecoverFriendPresenter", "totalCount %d", new Object[] { Integer.valueOf(i) });
    if ((this.mXC == 65) && (i < 20))
    {
      Object localObject = au.ba(this.mXA, -1);
      if (!((List)localObject).isEmpty())
      {
        localObject = ((List)localObject).iterator();
        if (((Iterator)localObject).hasNext())
        {
          au.a locala = (au.a)((Iterator)localObject).next();
          com.tencent.mm.ui.base.sortview.d locald = new com.tencent.mm.ui.base.sortview.d();
          locald.bnW = locala;
          i = locala.mXx.field_showHead;
          if ((i >= 65) && (i <= 90)) {}
          for (locald.Wtr = ((char)i);; locald.Wtr = "#")
          {
            this.mXB.add(locald);
            break;
          }
        }
        this.mXz.ig(this.mXB);
      }
      this.mXC = 92;
      AppMethodBeat.o(184442);
      return;
    }
    do
    {
      byN();
    } while ((this.mXB.size() < 20) && (this.mXC <= 91));
    AppMethodBeat.o(184442);
  }
  
  private void byN()
  {
    AppMethodBeat.i(184443);
    while (this.mXC <= 91)
    {
      Object localObject = au.ba(this.mXA, this.mXC);
      this.mXC += 1;
      if (!((List)localObject).isEmpty())
      {
        localObject = ((List)localObject).iterator();
        if (((Iterator)localObject).hasNext())
        {
          au.a locala = (au.a)((Iterator)localObject).next();
          com.tencent.mm.ui.base.sortview.d locald = new com.tencent.mm.ui.base.sortview.d();
          locald.bnW = locala;
          int i = locala.mXx.field_showHead;
          if ((i >= 65) && (i <= 90)) {}
          for (locald.Wtr = ((char)i);; locald.Wtr = "#")
          {
            this.mXB.add(locald);
            break;
          }
        }
        this.mXz.ig(this.mXB);
        AppMethodBeat.o(184443);
        return;
      }
    }
    AppMethodBeat.o(184443);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, q paramq)
  {
    AppMethodBeat.i(184444);
    Log.i("MicroMsg.RecoverFriendPresenter", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.mXD = ((bzb)d.c.b(((ae)paramq).kwO.lBS)).Tic;
      paramString = ((ae)paramq).byx();
      final String str = ((bza)d.b.b(((ae)paramq).kwO.lBR)).UserName;
      Log.i("MicroMsg.RecoverFriendPresenter", "hasContinue %s, oldAccount friend %d", new Object[] { Boolean.valueOf(this.mXD), Integer.valueOf(paramString.size()) });
      if (!this.mXA.equals(str))
      {
        Log.w("MicroMsg.RecoverFriendPresenter", "(%s,%s), not my old username, ignore", new Object[] { this.mXA, str });
        AppMethodBeat.o(184444);
        return;
      }
      this.mXE.getAndIncrement();
      com.tencent.e.h.ZvG.d(new com.tencent.e.i.i()
      {
        public final void byO()
        {
          AppMethodBeat.i(184437);
          String str1 = str;
          List localList = paramString;
          Iterator localIterator = localList.iterator();
          int i = 0;
          deb localdeb;
          r localr;
          label87:
          int j;
          label160:
          boolean bool;
          if (localIterator.hasNext())
          {
            localdeb = (deb)localIterator.next();
            if (Util.isNullOrNil(localdeb.fKu)) {
              break label423;
            }
            localr = au.cg(str1, localdeb.fKu);
            if (localr != null) {
              break label420;
            }
            localr = new r();
            localr.field_encryptUsername = localdeb.fKu;
            localr.field_nickname = localdeb.rWI;
            localr.field_pinyinName = Util.nullAsNil(f.ZJ(localdeb.rWI)).toUpperCase();
            String str2 = localr.field_pinyinName;
            if (!Util.isNullOrNil(str2))
            {
              j = str2.charAt(0);
              if ((j >= 65) && (j <= 90))
              {
                localr.field_showHead = j;
                localr.field_ticket = localdeb.HlB;
                localr.field_username = localdeb.UserName;
                localr.field_oldUsername = str1;
                localr.field_seq = localdeb.RYY;
                if (localr.systemRowid != -1L) {
                  break label288;
                }
                bool = ((ap)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).getOldAccountFriendStorage()).insert(localr);
                Log.i("MicroMsg.RecoverFriendLogic", "insert local old friend (%s,%s), success %s", new Object[] { localdeb.fKu, localdeb.rWI, Boolean.valueOf(bool) });
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
              bool = ((ap)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).getOldAccountFriendStorage()).replace(localr);
              Log.i("MicroMsg.RecoverFriendLogic", "replace local old friend (%s,%s), success %s", new Object[] { localdeb.fKu, localdeb.rWI, Boolean.valueOf(bool) });
              break label271;
              Log.i("MicroMsg.RecoverFriendLogic", "insert local old %d, success %d", new Object[] { Integer.valueOf(localList.size()), Integer.valueOf(i) });
              Log.i("MicroMsg.RecoverFriendPresenter", "insert old account friend %d, success %d", new Object[] { Integer.valueOf(paramString.size()), Integer.valueOf(i) });
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
      if (this.mXD)
      {
        yo(((ae)paramq).mWN);
        AppMethodBeat.o(184444);
        return;
      }
      if (this.mXE.get() == 0)
      {
        Log.i("MicroMsg.RecoverFriendPresenter", "all insert tasks are finished!");
        if (this.iYE != null) {
          this.iYE.dismiss();
        }
        byM();
      }
      AppMethodBeat.o(184444);
      return;
    }
    byM();
    if (this.iYE != null) {
      this.iYE.dismiss();
    }
    paramq = paramString;
    if (Util.isNullOrNil(paramString)) {
      paramq = this.activity.getString(a.g.app_err_system_busy_tip);
    }
    com.tencent.mm.ui.base.h.cO(this.activity, paramq);
    AppMethodBeat.o(184444);
  }
  
  public final void yo(int paramInt)
  {
    AppMethodBeat.i(184441);
    Log.i("MicroMsg.RecoverFriendPresenter", "do next scene, oldWx %s,seq %d", new Object[] { this.mXA, Integer.valueOf(paramInt) });
    ae localae = new ae(this.mXA, paramInt, this.sessionId);
    com.tencent.mm.kernel.h.aGY().a(localae, 0);
    if (this.iYE == null) {
      this.iYE = com.tencent.mm.ui.base.h.a(this.activity, this.activity.getString(a.g.app_loading_data), false, null);
    }
    AppMethodBeat.o(184441);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.av
 * JD-Core Version:    0.7.0.1
 */
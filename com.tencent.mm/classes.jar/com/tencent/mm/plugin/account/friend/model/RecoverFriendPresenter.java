package com.tencent.mm.plugin.account.friend.model;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.tu;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.mmdata.rpt.uo;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.friend.a.g;
import com.tencent.mm.plugin.account.friend.widget.RecoverFriendSortView;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.cod;
import com.tencent.mm.protocal.protobuf.coe;
import com.tencent.mm.protocal.protobuf.dvz;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.f.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class RecoverFriendPresenter
  extends IListener<tu>
  implements com.tencent.mm.am.h
{
  public Activity activity;
  public RecoverFriendSortView pUh;
  public String pUi;
  private ArrayList<com.tencent.mm.ui.base.sortview.d> pUj;
  private int pUk;
  private boolean pUl;
  private AtomicInteger pUm;
  private w psR;
  public String sessionId;
  
  public RecoverFriendPresenter(Activity paramActivity)
  {
    super(com.tencent.mm.app.f.hfK);
    AppMethodBeat.i(184440);
    this.pUj = new ArrayList();
    this.pUk = 65;
    this.pUm = new AtomicInteger();
    this.activity = paramActivity;
    this.__eventId = tu.class.getName().hashCode();
    AppMethodBeat.o(184440);
  }
  
  private void bXA()
  {
    AppMethodBeat.i(184442);
    int i = ar.Tg(this.pUi);
    Log.i("MicroMsg.RecoverFriendPresenter", "totalCount %d", new Object[] { Integer.valueOf(i) });
    if ((this.pUk == 65) && (i < 20))
    {
      Object localObject = ar.bq(this.pUi, -1);
      if (!((List)localObject).isEmpty())
      {
        localObject = ((List)localObject).iterator();
        if (((Iterator)localObject).hasNext())
        {
          ar.a locala = (ar.a)((Iterator)localObject).next();
          com.tencent.mm.ui.base.sortview.d locald = new com.tencent.mm.ui.base.sortview.d();
          locald.cpt = locala;
          i = locala.pUf.field_showHead;
          if ((i >= 65) && (i <= 90)) {}
          for (locald.aeaK = ((char)i);; locald.aeaK = "#")
          {
            this.pUj.add(locald);
            break;
          }
        }
        this.pUh.lG(this.pUj);
      }
      this.pUk = 92;
      AppMethodBeat.o(184442);
      return;
    }
    do
    {
      bXB();
    } while ((this.pUj.size() < 20) && (this.pUk <= 91));
    AppMethodBeat.o(184442);
  }
  
  private void bXB()
  {
    AppMethodBeat.i(184443);
    while (this.pUk <= 91)
    {
      Object localObject = ar.bq(this.pUi, this.pUk);
      this.pUk += 1;
      if (!((List)localObject).isEmpty())
      {
        localObject = ((List)localObject).iterator();
        if (((Iterator)localObject).hasNext())
        {
          ar.a locala = (ar.a)((Iterator)localObject).next();
          com.tencent.mm.ui.base.sortview.d locald = new com.tencent.mm.ui.base.sortview.d();
          locald.cpt = locala;
          int i = locala.pUf.field_showHead;
          if ((i >= 65) && (i <= 90)) {}
          for (locald.aeaK = ((char)i);; locald.aeaK = "#")
          {
            this.pUj.add(locald);
            break;
          }
        }
        this.pUh.lG(this.pUj);
        AppMethodBeat.o(184443);
        return;
      }
    }
    AppMethodBeat.o(184443);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, final String paramString, p paramp)
  {
    AppMethodBeat.i(184444);
    Log.i("MicroMsg.RecoverFriendPresenter", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.pUl = ((coe)c.c.b(((ab)paramp).nao.otC)).aavs;
      paramString = ((ab)paramp).bXl();
      final String str = ((cod)c.b.b(((ab)paramp).nao.otB)).UserName;
      Log.i("MicroMsg.RecoverFriendPresenter", "hasContinue %s, oldAccount friend %d", new Object[] { Boolean.valueOf(this.pUl), Integer.valueOf(paramString.size()) });
      if (!this.pUi.equals(str))
      {
        Log.w("MicroMsg.RecoverFriendPresenter", "(%s,%s), not my old username, ignore", new Object[] { this.pUi, str });
        AppMethodBeat.o(184444);
        return;
      }
      this.pUm.getAndIncrement();
      com.tencent.threadpool.h.ahAA.g(new com.tencent.threadpool.i.i()
      {
        public final void bXC()
        {
          AppMethodBeat.i(184437);
          String str1 = str;
          List localList = paramString;
          Iterator localIterator = localList.iterator();
          int i = 0;
          dvz localdvz;
          o localo;
          label87:
          int j;
          label160:
          boolean bool;
          if (localIterator.hasNext())
          {
            localdvz = (dvz)localIterator.next();
            if (Util.isNullOrNil(localdvz.hQa)) {
              break label423;
            }
            localo = ar.cu(str1, localdvz.hQa);
            if (localo != null) {
              break label420;
            }
            localo = new o();
            localo.field_encryptUsername = localdvz.hQa;
            localo.field_nickname = localdvz.vhX;
            localo.field_pinyinName = Util.nullAsNil(com.tencent.mm.platformtools.f.RZ(localdvz.vhX)).toUpperCase();
            String str2 = localo.field_pinyinName;
            if (!Util.isNullOrNil(str2))
            {
              j = str2.charAt(0);
              if ((j >= 65) && (j <= 90))
              {
                localo.field_showHead = j;
                localo.field_ticket = localdvz.Njp;
                localo.field_username = localdvz.UserName;
                localo.field_oldUsername = str1;
                localo.field_seq = localdvz.YWY;
                if (localo.systemRowid != -1L) {
                  break label288;
                }
                bool = ((am)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getOldAccountFriendStorage()).insert(localo);
                Log.i("MicroMsg.RecoverFriendLogic", "insert local old friend (%s,%s), success %s", new Object[] { localdvz.hQa, localdvz.vhX, Boolean.valueOf(bool) });
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
              bool = ((am)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getOldAccountFriendStorage()).replace(localo);
              Log.i("MicroMsg.RecoverFriendLogic", "replace local old friend (%s,%s), success %s", new Object[] { localdvz.hQa, localdvz.vhX, Boolean.valueOf(bool) });
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
      if (this.pUl)
      {
        yu(((ab)paramp).pTu);
        AppMethodBeat.o(184444);
        return;
      }
      if (this.pUm.get() == 0)
      {
        Log.i("MicroMsg.RecoverFriendPresenter", "all insert tasks are finished!");
        if (this.psR != null) {
          this.psR.dismiss();
        }
        bXA();
      }
      AppMethodBeat.o(184444);
      return;
    }
    bXA();
    if (this.psR != null) {
      this.psR.dismiss();
    }
    paramp = paramString;
    if (Util.isNullOrNil(paramString)) {
      paramp = this.activity.getString(a.g.app_err_system_busy_tip);
    }
    k.cZ(this.activity, paramp);
    AppMethodBeat.o(184444);
  }
  
  public final void yu(int paramInt)
  {
    AppMethodBeat.i(184441);
    Log.i("MicroMsg.RecoverFriendPresenter", "do next scene, oldWx %s,seq %d", new Object[] { this.pUi, Integer.valueOf(paramInt) });
    ab localab = new ab(this.pUi, paramInt, this.sessionId);
    com.tencent.mm.kernel.h.aZW().a(localab, 0);
    if (this.psR == null) {
      this.psR = k.a(this.activity, this.activity.getString(a.g.app_loading_data), false, null);
    }
    AppMethodBeat.o(184441);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.model.RecoverFriendPresenter
 * JD-Core Version:    0.7.0.1
 */
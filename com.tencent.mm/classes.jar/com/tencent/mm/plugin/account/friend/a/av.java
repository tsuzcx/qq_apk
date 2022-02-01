package com.tencent.mm.plugin.account.friend.a;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.re;
import com.tencent.mm.g.b.a.ns;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.f;
import com.tencent.mm.plugin.account.friend.widget.RecoverFriendSortView;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.protocal.protobuf.bre;
import com.tencent.mm.protocal.protobuf.brf;
import com.tencent.mm.protocal.protobuf.cut;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.e.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class av
  extends IListener<re>
  implements com.tencent.mm.ak.i
{
  public Activity activity;
  private com.tencent.mm.ui.base.q gut;
  public RecoverFriendSortView kga;
  public String kgb;
  private ArrayList<com.tencent.mm.ui.base.sortview.d> kgc;
  private int kgd;
  private boolean kge;
  private AtomicInteger kgf;
  public String sessionId;
  
  public av(Activity paramActivity)
  {
    AppMethodBeat.i(184440);
    this.kgc = new ArrayList();
    this.kgd = 65;
    this.kgf = new AtomicInteger();
    this.activity = paramActivity;
    this.__eventId = re.class.getName().hashCode();
    AppMethodBeat.o(184440);
  }
  
  private void boD()
  {
    AppMethodBeat.i(184442);
    int i = au.Th(this.kgb);
    Log.i("MicroMsg.RecoverFriendPresenter", "totalCount %d", new Object[] { Integer.valueOf(i) });
    if ((this.kgd == 65) && (i < 20))
    {
      Object localObject = au.aH(this.kgb, -1);
      if (!((List)localObject).isEmpty())
      {
        localObject = ((List)localObject).iterator();
        if (((Iterator)localObject).hasNext())
        {
          au.a locala = (au.a)((Iterator)localObject).next();
          com.tencent.mm.ui.base.sortview.d locald = new com.tencent.mm.ui.base.sortview.d();
          locald.data = locala;
          i = locala.kfY.field_showHead;
          if ((i >= 65) && (i <= 90)) {}
          for (locald.Pae = ((char)i);; locald.Pae = "#")
          {
            this.kgc.add(locald);
            break;
          }
        }
        this.kga.hy(this.kgc);
      }
      this.kgd = 92;
      AppMethodBeat.o(184442);
      return;
    }
    do
    {
      boE();
    } while ((this.kgc.size() < 20) && (this.kgd <= 91));
    AppMethodBeat.o(184442);
  }
  
  private void boE()
  {
    AppMethodBeat.i(184443);
    while (this.kgd <= 91)
    {
      Object localObject = au.aH(this.kgb, this.kgd);
      this.kgd += 1;
      if (!((List)localObject).isEmpty())
      {
        localObject = ((List)localObject).iterator();
        if (((Iterator)localObject).hasNext())
        {
          au.a locala = (au.a)((Iterator)localObject).next();
          com.tencent.mm.ui.base.sortview.d locald = new com.tencent.mm.ui.base.sortview.d();
          locald.data = locala;
          int i = locala.kfY.field_showHead;
          if ((i >= 65) && (i <= 90)) {}
          for (locald.Pae = ((char)i);; locald.Pae = "#")
          {
            this.kgc.add(locald);
            break;
          }
        }
        this.kga.hy(this.kgc);
        AppMethodBeat.o(184443);
        return;
      }
    }
    AppMethodBeat.o(184443);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, final String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(184444);
    Log.i("MicroMsg.RecoverFriendPresenter", "errType %d, errCode %d, errMsg %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.kge = ((brf)((ae)paramq).hJu.iLL.iLR).LYI;
      paramString = ((ae)paramq).boo();
      final String str = ((bre)((ae)paramq).hJu.iLK.iLR).UserName;
      Log.i("MicroMsg.RecoverFriendPresenter", "hasContinue %s, oldAccount friend %d", new Object[] { Boolean.valueOf(this.kge), Integer.valueOf(paramString.size()) });
      if (!this.kgb.equals(str))
      {
        Log.w("MicroMsg.RecoverFriendPresenter", "(%s,%s), not my old username, ignore", new Object[] { this.kgb, str });
        AppMethodBeat.o(184444);
        return;
      }
      this.kgf.getAndIncrement();
      com.tencent.f.h.RTc.b(new com.tencent.f.i.i()
      {
        public final void boF()
        {
          AppMethodBeat.i(184437);
          String str1 = str;
          List localList = paramString;
          Iterator localIterator = localList.iterator();
          int i = 0;
          cut localcut;
          r localr;
          label87:
          int j;
          label160:
          boolean bool;
          if (localIterator.hasNext())
          {
            localcut = (cut)localIterator.next();
            if (Util.isNullOrNil(localcut.dRe)) {
              break label423;
            }
            localr = au.ca(str1, localcut.dRe);
            if (localr != null) {
              break label420;
            }
            localr = new r();
            localr.field_encryptUsername = localcut.dRe;
            localr.field_nickname = localcut.oUJ;
            localr.field_pinyinName = Util.nullAsNil(f.Sh(localcut.oUJ)).toUpperCase();
            String str2 = localr.field_pinyinName;
            if (!Util.isNullOrNil(str2))
            {
              j = str2.charAt(0);
              if ((j >= 65) && (j <= 90))
              {
                localr.field_showHead = j;
                localr.field_ticket = localcut.Bri;
                localr.field_username = localcut.UserName;
                localr.field_oldUsername = str1;
                localr.field_seq = localcut.KXP;
                if (localr.systemRowid != -1L) {
                  break label288;
                }
                bool = ((ap)((com.tencent.mm.plugin.account.a.a.a)g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getOldAccountFriendStorage()).insert(localr);
                Log.i("MicroMsg.RecoverFriendLogic", "insert local old friend (%s,%s), success %s", new Object[] { localcut.dRe, localcut.oUJ, Boolean.valueOf(bool) });
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
              bool = ((ap)((com.tencent.mm.plugin.account.a.a.a)g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getOldAccountFriendStorage()).replace(localr);
              Log.i("MicroMsg.RecoverFriendLogic", "replace local old friend (%s,%s), success %s", new Object[] { localcut.dRe, localcut.oUJ, Boolean.valueOf(bool) });
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
      if (this.kge)
      {
        vk(((ae)paramq).kfo);
        AppMethodBeat.o(184444);
        return;
      }
      if (this.kgf.get() == 0)
      {
        Log.i("MicroMsg.RecoverFriendPresenter", "all insert tasks are finished!");
        if (this.gut != null) {
          this.gut.dismiss();
        }
        boD();
      }
      AppMethodBeat.o(184444);
      return;
    }
    boD();
    if (this.gut != null) {
      this.gut.dismiss();
    }
    paramq = paramString;
    if (Util.isNullOrNil(paramString)) {
      paramq = this.activity.getString(2131755804);
    }
    com.tencent.mm.ui.base.h.cD(this.activity, paramq);
    AppMethodBeat.o(184444);
  }
  
  public final void vk(int paramInt)
  {
    AppMethodBeat.i(184441);
    Log.i("MicroMsg.RecoverFriendPresenter", "do next scene, oldWx %s,seq %d", new Object[] { this.kgb, Integer.valueOf(paramInt) });
    ae localae = new ae(this.kgb, paramInt, this.sessionId);
    g.azz().a(localae, 0);
    if (this.gut == null) {
      this.gut = com.tencent.mm.ui.base.h.a(this.activity, this.activity.getString(2131755887), false, null);
    }
    AppMethodBeat.o(184441);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.a.av
 * JD-Core Version:    0.7.0.1
 */
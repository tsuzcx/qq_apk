package com.tencent.mm.plugin.account.model;

import android.accounts.Account;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Looper;
import com.jg.JgClassChecked;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.h;
import com.tencent.mm.plugin.account.friend.a.al;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.g.d;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;

@JgClassChecked(author=20, fComment="checked", lastDate="20140422", reviewer=20, vComment={com.jg.EType.SERVICESCHECK})
public class ContactsSyncService
  extends Service
  implements f
{
  private static Account gjj;
  private ContactsSyncService.a gAG;
  private Looper gAH;
  
  public ContactsSyncService()
  {
    AppMethodBeat.i(124664);
    this.gAG = null;
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ContactsSyncService", "ContactsSyncService construction");
    AppMethodBeat.o(124664);
  }
  
  private void aqY()
  {
    AppMethodBeat.i(124667);
    if (this.gAH != null) {
      this.gAH.quit();
    }
    AppMethodBeat.o(124667);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(124665);
    paramIntent = null;
    if (b.o(this, "android.permission.READ_CONTACTS"))
    {
      if (this.gAG == null) {
        this.gAG = new ContactsSyncService.a(this, getApplicationContext());
      }
      paramIntent = this.gAG.getSyncAdapterBinder();
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ContactsSyncService", "ContactsSyncService onBind ret[%s]", new Object[] { paramIntent });
      AppMethodBeat.o(124665);
      return paramIntent;
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ContactsSyncService", "ContactsSyncService onBind no permission");
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(124668);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ContactsSyncService", "contacts sync service destroy");
    super.onDestroy();
    AppMethodBeat.o(124668);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(124666);
    com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ContactsSyncService", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramm.getType());
    if (paramm.getType() == 133)
    {
      g.Rc().b(133, this);
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ContactsSyncService", "uploadcontact onSceneEnd: errType = " + paramInt1 + ", errCode = " + paramInt2);
      long l1 = ((Long)g.RL().Ru().get(327728, Long.valueOf(0L))).longValue();
      long l2 = System.currentTimeMillis();
      com.tencent.mm.sdk.platformtools.ab.d("MicroMsg.ContactsSyncService", "getMFriend : curTime=" + l2 + ", lastTime=" + l1);
      if ((paramInt2 != 0) && (l2 - l1 < 86400000L))
      {
        aqY();
        com.tencent.mm.sdk.platformtools.ab.e("MicroMsg.ContactsSyncService", "uploadmcontact list null, do not do getmfriend.");
        AppMethodBeat.o(124666);
        return;
      }
      g.RL().Ru().set(327728, Long.valueOf(l2));
      g.Rc().a(32, this);
      paramString = (al)paramm;
      paramString = new com.tencent.mm.plugin.account.friend.a.ab(paramString.gyr, paramString.gys);
      g.Rc().a(paramString, 0);
    }
    if (paramm.getType() == 32)
    {
      g.Rc().b(32, this);
      com.tencent.mm.sdk.platformtools.ab.i("MicroMsg.ContactsSyncService", "getmfriend onSceneEnd: errType = " + paramInt1 + ", errCode = " + paramInt2);
      if ((paramInt1 == 0) && (paramInt2 == 0) && (!g.RL().Ru().getBoolean(ac.a.yMa, false))) {
        d.h(new h(this, gjj), "MMAccountManager_updateLocalContacts").start();
      }
      aqY();
    }
    AppMethodBeat.o(124666);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.ContactsSyncService
 * JD-Core Version:    0.7.0.1
 */
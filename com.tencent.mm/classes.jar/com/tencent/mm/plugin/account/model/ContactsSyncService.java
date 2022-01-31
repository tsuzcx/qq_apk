package com.tencent.mm.plugin.account.model;

import android.accounts.Account;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Looper;
import com.jg.JgClassChecked;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.platformtools.h;
import com.tencent.mm.plugin.account.friend.a.ab;
import com.tencent.mm.plugin.account.friend.a.al;
import com.tencent.mm.pluginsdk.permission.a;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;

@JgClassChecked(author=20, fComment="checked", lastDate="20140422", reviewer=20, vComment={com.jg.EType.SERVICESCHECK})
public class ContactsSyncService
  extends Service
  implements f
{
  private static Account eRo;
  private ContactsSyncService.a fjo = null;
  private Looper fjp;
  
  public ContactsSyncService()
  {
    y.i("MicroMsg.ContactsSyncService", "ContactsSyncService construction");
  }
  
  private void Xv()
  {
    if (this.fjp != null) {
      this.fjp.quit();
    }
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    paramIntent = null;
    if (a.j(this, "android.permission.READ_CONTACTS"))
    {
      if (this.fjo == null) {
        this.fjo = new ContactsSyncService.a(this, getApplicationContext());
      }
      paramIntent = this.fjo.getSyncAdapterBinder();
    }
    for (;;)
    {
      y.i("MicroMsg.ContactsSyncService", "ContactsSyncService onBind ret[%s]", new Object[] { paramIntent });
      return paramIntent;
      y.i("MicroMsg.ContactsSyncService", "ContactsSyncService onBind no permission");
    }
  }
  
  public void onDestroy()
  {
    y.i("MicroMsg.ContactsSyncService", "contacts sync service destroy");
    super.onDestroy();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.ContactsSyncService", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramm.getType());
    if (paramm.getType() == 133)
    {
      g.Dk().b(133, this);
      y.i("MicroMsg.ContactsSyncService", "uploadcontact onSceneEnd: errType = " + paramInt1 + ", errCode = " + paramInt2);
      l1 = ((Long)g.DP().Dz().get(327728, Long.valueOf(0L))).longValue();
      l2 = System.currentTimeMillis();
      y.d("MicroMsg.ContactsSyncService", "getMFriend : curTime=" + l2 + ", lastTime=" + l1);
      if ((paramInt2 != 0) && (l2 - l1 < 86400000L))
      {
        Xv();
        y.e("MicroMsg.ContactsSyncService", "uploadmcontact list null, do not do getmfriend.");
      }
    }
    while (paramm.getType() != 32)
    {
      long l1;
      long l2;
      return;
      g.DP().Dz().o(327728, Long.valueOf(l2));
      g.Dk().a(32, this);
      paramString = (al)paramm;
      paramString = new ab(paramString.fgJ, paramString.fgK);
      g.Dk().a(paramString, 0);
    }
    g.Dk().b(32, this);
    y.i("MicroMsg.ContactsSyncService", "getmfriend onSceneEnd: errType = " + paramInt1 + ", errCode = " + paramInt2);
    if ((paramInt1 == 0) && (paramInt2 == 0)) {
      com.tencent.mm.sdk.f.e.b(new h(this, eRo), "MMAccountManager_updateLocalContacts").start();
    }
    Xv();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.ContactsSyncService
 * JD-Core Version:    0.7.0.1
 */
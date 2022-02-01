package com.tencent.mm.plugin.account.model;

import android.accounts.Account;
import android.app.Service;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.SyncResult;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Looper;
import com.jg.JgClassChecked;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.account.friend.a.ao;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;

@JgClassChecked(author=20, fComment="checked", lastDate="20140422", reviewer=20, vComment={com.jg.EType.SERVICESCHECK})
public class ContactsSyncService
  extends Service
  implements f
{
  private static Account iMW;
  private a jhq;
  private Looper jhr;
  
  public ContactsSyncService()
  {
    AppMethodBeat.i(127817);
    this.jhq = null;
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ContactsSyncService", "ContactsSyncService construction");
    AppMethodBeat.o(127817);
  }
  
  private void aTB()
  {
    AppMethodBeat.i(127820);
    if (this.jhr != null) {
      this.jhr.quit();
    }
    AppMethodBeat.o(127820);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(127818);
    paramIntent = null;
    if (com.tencent.mm.pluginsdk.permission.b.n(this, "android.permission.READ_CONTACTS"))
    {
      if (this.jhq == null) {
        this.jhq = new a(getApplicationContext());
      }
      paramIntent = this.jhq.getSyncAdapterBinder();
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ContactsSyncService", "ContactsSyncService onBind ret[%s]", new Object[] { paramIntent });
      AppMethodBeat.o(127818);
      return paramIntent;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ContactsSyncService", "ContactsSyncService onBind no permission");
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(127821);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ContactsSyncService", "contacts sync service destroy");
    super.onDestroy();
    AppMethodBeat.o(127821);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(127819);
    com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ContactsSyncService", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramn.getType());
    if (paramn.getType() == 133)
    {
      com.tencent.mm.kernel.g.aiU().b(133, this);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ContactsSyncService", "uploadcontact onSceneEnd: errType = " + paramInt1 + ", errCode = " + paramInt2);
      long l1 = ((Long)com.tencent.mm.kernel.g.ajC().ajl().get(327728, Long.valueOf(0L))).longValue();
      long l2 = System.currentTimeMillis();
      com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.ContactsSyncService", "getMFriend : curTime=" + l2 + ", lastTime=" + l1);
      if ((paramInt2 != 0) && (l2 - l1 < 86400000L))
      {
        aTB();
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ContactsSyncService", "uploadmcontact list null, do not do getmfriend.");
        AppMethodBeat.o(127819);
        return;
      }
      com.tencent.mm.kernel.g.ajC().ajl().set(327728, Long.valueOf(l2));
      com.tencent.mm.kernel.g.aiU().a(32, this);
      paramString = (ao)paramn;
      paramString = new com.tencent.mm.plugin.account.friend.a.ad(paramString.jeE, paramString.jeF);
      com.tencent.mm.kernel.g.aiU().a(paramString, 0);
    }
    if (paramn.getType() == 32)
    {
      com.tencent.mm.kernel.g.aiU().b(32, this);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ContactsSyncService", "getmfriend onSceneEnd: errType = " + paramInt1 + ", errCode = " + paramInt2);
      if ((paramInt1 == 0) && (paramInt2 == 0) && (!com.tencent.mm.kernel.g.ajC().ajl().getBoolean(al.a.IGb, false)))
      {
        paramString = new com.tencent.mm.platformtools.g(this, iMW);
        h.LTJ.aR(paramString);
      }
      aTB();
    }
    AppMethodBeat.o(127819);
  }
  
  final class a
    extends AbstractThreadedSyncAdapter
  {
    private Context mContext;
    
    public a(Context paramContext)
    {
      super(true);
      AppMethodBeat.i(127815);
      this.mContext = paramContext;
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ContactsSyncService", "ContactsSyncService SyncAdapterImpl construction");
      AppMethodBeat.o(127815);
    }
    
    public final void onPerformSync(Account paramAccount, Bundle paramBundle, String paramString, ContentProviderClient paramContentProviderClient, SyncResult paramSyncResult)
    {
      AppMethodBeat.i(127816);
      com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.ContactsSyncService", "ContactsSyncService SyncAdapterImpl onPerformSync");
      if (!com.tencent.mm.kernel.g.ajx())
      {
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ContactsSyncService", "ContactsSyncService account not ready, ignore this sync");
        AppMethodBeat.o(127816);
        return;
      }
      try
      {
        Looper.prepare();
        ContactsSyncService.a(ContactsSyncService.this, Looper.myLooper());
        ContactsSyncService.a(ContactsSyncService.this, paramAccount);
        Looper.loop();
        AppMethodBeat.o(127816);
        return;
      }
      catch (Exception paramAccount)
      {
        ContactsSyncService.a(ContactsSyncService.this);
        com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.ContactsSyncService", "ContactsSyncService.onPerformSync error: " + paramAccount.getMessage());
        AppMethodBeat.o(127816);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.ContactsSyncService
 * JD-Core Version:    0.7.0.1
 */
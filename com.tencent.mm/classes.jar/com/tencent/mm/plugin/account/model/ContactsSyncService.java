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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.f;
import com.tencent.mm.platformtools.g;
import com.tencent.mm.plugin.account.friend.a.ad;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar.a;

@JgClassChecked(author=20, fComment="checked", lastDate="20140422", reviewer=20, vComment={com.jg.EType.SERVICESCHECK})
public class ContactsSyncService
  extends Service
  implements com.tencent.mm.an.i
{
  private static Account mDL;
  private a mZL;
  private Looper mZM;
  
  public ContactsSyncService()
  {
    AppMethodBeat.i(127817);
    this.mZL = null;
    Log.i("MicroMsg.ContactsSyncService", "ContactsSyncService construction");
    AppMethodBeat.o(127817);
  }
  
  private void byV()
  {
    AppMethodBeat.i(127820);
    if (this.mZM != null) {
      this.mZM.quit();
    }
    AppMethodBeat.o(127820);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(127818);
    paramIntent = null;
    if (com.tencent.mm.pluginsdk.permission.b.o(this, "android.permission.READ_CONTACTS"))
    {
      if (this.mZL == null) {
        this.mZL = new a(getApplicationContext());
      }
      paramIntent = this.mZL.getSyncAdapterBinder();
    }
    for (;;)
    {
      Log.i("MicroMsg.ContactsSyncService", "ContactsSyncService onBind ret[%s]", new Object[] { paramIntent });
      AppMethodBeat.o(127818);
      return paramIntent;
      Log.i("MicroMsg.ContactsSyncService", "ContactsSyncService onBind no permission");
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(127821);
    Log.i("MicroMsg.ContactsSyncService", "contacts sync service destroy");
    super.onDestroy();
    AppMethodBeat.o(127821);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(127819);
    Log.i("MicroMsg.ContactsSyncService", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramq.getType());
    if (paramq.getType() == 133)
    {
      com.tencent.mm.kernel.h.aGY().b(133, this);
      Log.i("MicroMsg.ContactsSyncService", "uploadcontact onSceneEnd: errType = " + paramInt1 + ", errCode = " + paramInt2);
      long l1 = ((Long)com.tencent.mm.kernel.h.aHG().aHp().b(327728, Long.valueOf(0L))).longValue();
      long l2 = System.currentTimeMillis();
      Log.d("MicroMsg.ContactsSyncService", "getMFriend : curTime=" + l2 + ", lastTime=" + l1);
      if ((paramInt2 != 0) && (l2 - l1 < 86400000L))
      {
        byV();
        Log.e("MicroMsg.ContactsSyncService", "uploadmcontact list null, do not do getmfriend.");
        AppMethodBeat.o(127819);
        return;
      }
      com.tencent.mm.kernel.h.aHG().aHp().i(327728, Long.valueOf(l2));
      com.tencent.mm.kernel.h.aGY().a(32, this);
      paramString = (com.tencent.mm.plugin.account.friend.a.ao)paramq;
      paramString = new ad(paramString.mWZ, paramString.mXa);
      com.tencent.mm.kernel.h.aGY().a(paramString, 0);
    }
    if (paramq.getType() == 32)
    {
      com.tencent.mm.kernel.h.aGY().b(32, this);
      Log.i("MicroMsg.ContactsSyncService", "getmfriend onSceneEnd: errType = " + paramInt1 + ", errCode = " + paramInt2);
      if ((paramInt1 == 0) && (paramInt2 == 0) && (!com.tencent.mm.kernel.h.aHG().aHp().getBoolean(ar.a.Vxx, false)))
      {
        paramString = new g(this, mDL);
        com.tencent.e.h.ZvG.be(paramString);
      }
      byV();
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
      Log.i("MicroMsg.ContactsSyncService", "ContactsSyncService SyncAdapterImpl construction");
      AppMethodBeat.o(127815);
    }
    
    public final void onPerformSync(Account paramAccount, Bundle paramBundle, String paramString, ContentProviderClient paramContentProviderClient, SyncResult paramSyncResult)
    {
      AppMethodBeat.i(127816);
      Log.i("MicroMsg.ContactsSyncService", "ContactsSyncService SyncAdapterImpl onPerformSync");
      if (!com.tencent.mm.kernel.h.aHB())
      {
        Log.e("MicroMsg.ContactsSyncService", "ContactsSyncService account not ready, ignore this sync");
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
        Log.e("MicroMsg.ContactsSyncService", "ContactsSyncService.onPerformSync error: " + paramAccount.getMessage());
        AppMethodBeat.o(127816);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.ContactsSyncService
 * JD-Core Version:    0.7.0.1
 */
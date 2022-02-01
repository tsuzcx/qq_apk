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
import com.tencent.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.account.friend.a.ad;
import com.tencent.mm.plugin.account.friend.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ar.a;

@JgClassChecked(author=20, fComment="checked", lastDate="20140422", reviewer=20, vComment={com.jg.EType.SERVICESCHECK})
public class ContactsSyncService
  extends Service
  implements com.tencent.mm.ak.i
{
  private static Account jMD;
  private a kil;
  private Looper kim;
  
  public ContactsSyncService()
  {
    AppMethodBeat.i(127817);
    this.kil = null;
    Log.i("MicroMsg.ContactsSyncService", "ContactsSyncService construction");
    AppMethodBeat.o(127817);
  }
  
  private void boM()
  {
    AppMethodBeat.i(127820);
    if (this.kim != null) {
      this.kim.quit();
    }
    AppMethodBeat.o(127820);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(127818);
    paramIntent = null;
    if (com.tencent.mm.pluginsdk.permission.b.n(this, "android.permission.READ_CONTACTS"))
    {
      if (this.kil == null) {
        this.kil = new a(getApplicationContext());
      }
      paramIntent = this.kil.getSyncAdapterBinder();
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
      com.tencent.mm.kernel.g.azz().b(133, this);
      Log.i("MicroMsg.ContactsSyncService", "uploadcontact onSceneEnd: errType = " + paramInt1 + ", errCode = " + paramInt2);
      long l1 = ((Long)com.tencent.mm.kernel.g.aAh().azQ().get(327728, Long.valueOf(0L))).longValue();
      long l2 = System.currentTimeMillis();
      Log.d("MicroMsg.ContactsSyncService", "getMFriend : curTime=" + l2 + ", lastTime=" + l1);
      if ((paramInt2 != 0) && (l2 - l1 < 86400000L))
      {
        boM();
        Log.e("MicroMsg.ContactsSyncService", "uploadmcontact list null, do not do getmfriend.");
        AppMethodBeat.o(127819);
        return;
      }
      com.tencent.mm.kernel.g.aAh().azQ().set(327728, Long.valueOf(l2));
      com.tencent.mm.kernel.g.azz().a(32, this);
      paramString = (com.tencent.mm.plugin.account.friend.a.ao)paramq;
      paramString = new ad(paramString.kfA, paramString.kfB);
      com.tencent.mm.kernel.g.azz().a(paramString, 0);
    }
    if (paramq.getType() == 32)
    {
      com.tencent.mm.kernel.g.azz().b(32, this);
      Log.i("MicroMsg.ContactsSyncService", "getmfriend onSceneEnd: errType = " + paramInt1 + ", errCode = " + paramInt2);
      if ((paramInt1 == 0) && (paramInt2 == 0) && (!com.tencent.mm.kernel.g.aAh().azQ().getBoolean(ar.a.Ojh, false)))
      {
        paramString = new com.tencent.mm.platformtools.g(this, jMD);
        h.RTc.aX(paramString);
      }
      boM();
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
      if (!com.tencent.mm.kernel.g.aAc())
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.ContactsSyncService
 * JD-Core Version:    0.7.0.1
 */
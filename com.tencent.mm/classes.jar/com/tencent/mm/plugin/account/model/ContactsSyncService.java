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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.account.friend.model.aa;
import com.tencent.mm.plugin.account.friend.model.al;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;

public class ContactsSyncService
  extends Service
  implements com.tencent.mm.am.h
{
  private a pWu;
  private Looper pWv;
  
  public ContactsSyncService()
  {
    AppMethodBeat.i(127817);
    this.pWu = null;
    Log.i("MicroMsg.ContactsSyncService", "ContactsSyncService construction");
    AppMethodBeat.o(127817);
  }
  
  private void bXJ()
  {
    AppMethodBeat.i(127820);
    if (this.pWv != null) {
      this.pWv.quit();
    }
    AppMethodBeat.o(127820);
  }
  
  public IBinder onBind(Intent paramIntent)
  {
    AppMethodBeat.i(127818);
    paramIntent = null;
    if (b.s(this, "android.permission.READ_CONTACTS"))
    {
      if (this.pWu == null) {
        this.pWu = new a(getApplicationContext());
      }
      paramIntent = this.pWu.getSyncAdapterBinder();
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(127819);
    Log.i("MicroMsg.ContactsSyncService", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString + " type = " + paramp.getType());
    if (paramp.getType() == 133)
    {
      com.tencent.mm.kernel.h.aZW().b(133, this);
      Log.i("MicroMsg.ContactsSyncService", "uploadcontact onSceneEnd: errType = " + paramInt1 + ", errCode = " + paramInt2);
      long l1 = ((Long)com.tencent.mm.kernel.h.baE().ban().d(327728, Long.valueOf(0L))).longValue();
      long l2 = System.currentTimeMillis();
      Log.d("MicroMsg.ContactsSyncService", "getMFriend : curTime=" + l2 + ", lastTime=" + l1);
      if ((paramInt2 != 0) && (l2 - l1 < 86400000L))
      {
        bXJ();
        Log.e("MicroMsg.ContactsSyncService", "uploadmcontact list null, do not do getmfriend.");
        AppMethodBeat.o(127819);
        return;
      }
      com.tencent.mm.kernel.h.baE().ban().B(327728, Long.valueOf(l2));
      com.tencent.mm.kernel.h.aZW().a(32, this);
      paramString = (al)paramp;
      paramString = new aa(paramString.pTH, paramString.pTI);
      com.tencent.mm.kernel.h.aZW().a(paramString, 0);
    }
    if (paramp.getType() == 32)
    {
      com.tencent.mm.kernel.h.aZW().b(32, this);
      Log.i("MicroMsg.ContactsSyncService", "getmfriend onSceneEnd: errType = " + paramInt1 + ", errCode = " + paramInt2);
      bXJ();
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
      if (!com.tencent.mm.kernel.h.baz())
      {
        Log.e("MicroMsg.ContactsSyncService", "ContactsSyncService account not ready, ignore this sync");
        AppMethodBeat.o(127816);
        return;
      }
      Log.w("MicroMsg.ContactsSyncService", "Don't auto sync contacts again from now on!!!");
      AppMethodBeat.o(127816);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.ContactsSyncService
 * JD-Core Version:    0.7.0.1
 */
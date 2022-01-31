package com.tencent.mm.plugin.account.model;

import android.accounts.Account;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.SyncResult;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.y;

final class ContactsSyncService$a
  extends AbstractThreadedSyncAdapter
{
  private Context mContext;
  
  public ContactsSyncService$a(ContactsSyncService paramContactsSyncService, Context paramContext)
  {
    super(paramContext, true);
    this.mContext = paramContext;
    y.i("MicroMsg.ContactsSyncService", "ContactsSyncService SyncAdapterImpl construction");
  }
  
  public final void onPerformSync(Account paramAccount, Bundle paramBundle, String paramString, ContentProviderClient paramContentProviderClient, SyncResult paramSyncResult)
  {
    y.i("MicroMsg.ContactsSyncService", "ContactsSyncService SyncAdapterImpl onPerformSync");
    if (!g.DK())
    {
      y.e("MicroMsg.ContactsSyncService", "ContactsSyncService account not ready, ignore this sync");
      return;
    }
    try
    {
      Looper.prepare();
      ContactsSyncService.a(this.fjq, Looper.myLooper());
      ContactsSyncService.a(this.fjq, paramAccount);
      Looper.loop();
      return;
    }
    catch (Exception paramAccount)
    {
      ContactsSyncService.a(this.fjq);
      y.e("MicroMsg.ContactsSyncService", "ContactsSyncService.onPerformSync error: " + paramAccount.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.ContactsSyncService.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.account.model;

import android.accounts.Account;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.SyncResult;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;

final class ContactsSyncService$a
  extends AbstractThreadedSyncAdapter
{
  private Context mContext;
  
  public ContactsSyncService$a(ContactsSyncService paramContactsSyncService, Context paramContext)
  {
    super(paramContext, true);
    AppMethodBeat.i(124662);
    this.mContext = paramContext;
    ab.i("MicroMsg.ContactsSyncService", "ContactsSyncService SyncAdapterImpl construction");
    AppMethodBeat.o(124662);
  }
  
  public final void onPerformSync(Account paramAccount, Bundle paramBundle, String paramString, ContentProviderClient paramContentProviderClient, SyncResult paramSyncResult)
  {
    AppMethodBeat.i(124663);
    ab.i("MicroMsg.ContactsSyncService", "ContactsSyncService SyncAdapterImpl onPerformSync");
    if (!g.RG())
    {
      ab.e("MicroMsg.ContactsSyncService", "ContactsSyncService account not ready, ignore this sync");
      AppMethodBeat.o(124663);
      return;
    }
    try
    {
      Looper.prepare();
      ContactsSyncService.a(this.gAI, Looper.myLooper());
      ContactsSyncService.a(this.gAI, paramAccount);
      Looper.loop();
      AppMethodBeat.o(124663);
      return;
    }
    catch (Exception paramAccount)
    {
      ContactsSyncService.a(this.gAI);
      ab.e("MicroMsg.ContactsSyncService", "ContactsSyncService.onPerformSync error: " + paramAccount.getMessage());
      AppMethodBeat.o(124663);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.model.ContactsSyncService.a
 * JD-Core Version:    0.7.0.1
 */
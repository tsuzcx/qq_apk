package com.tencent.mm.platformtools;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.permission.b;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;

public final class h$a
{
  private final String TAG;
  private final ContentResolver gjm;
  ArrayList<ContentProviderOperation> gjn;
  
  public h$a(h paramh, ContentResolver paramContentResolver)
  {
    AppMethodBeat.i(124518);
    this.TAG = "MicroMsg.BatchOperation";
    this.gjm = paramContentResolver;
    this.gjn = new ArrayList();
    AppMethodBeat.o(124518);
  }
  
  public final void a(ContentProviderOperation paramContentProviderOperation)
  {
    AppMethodBeat.i(124519);
    this.gjn.add(paramContentProviderOperation);
    AppMethodBeat.o(124519);
  }
  
  public final void execute()
  {
    AppMethodBeat.i(124520);
    if (this.gjn.size() == 0)
    {
      ab.d("MicroMsg.BatchOperation", "no batch operation");
      AppMethodBeat.o(124520);
      return;
    }
    if (!b.o(h.a(this.gjo), "android.permission.READ_CONTACTS"))
    {
      ab.e("MicroMsg.BatchOperation", "no contact permission");
      AppMethodBeat.o(124520);
      return;
    }
    try
    {
      this.gjm.applyBatch("com.android.contacts", this.gjn);
      this.gjn.clear();
      AppMethodBeat.o(124520);
      return;
    }
    catch (OperationApplicationException localOperationApplicationException)
    {
      for (;;)
      {
        ab.e("MicroMsg.BatchOperation", "apply batch operation failed", new Object[] { localOperationApplicationException.toString() });
      }
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ab.e("MicroMsg.BatchOperation", "apply batch operation failed", new Object[] { localRemoteException.toString() });
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.BatchOperation", "apply batch operation failed", new Object[] { localException.toString() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.platformtools.h.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.platformtools;

import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.OperationApplicationException;
import android.os.RemoteException;
import com.tencent.mm.pluginsdk.permission.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;

public final class h$a
{
  private final String TAG = "MicroMsg.BatchOperation";
  private final ContentResolver eRr;
  ArrayList<ContentProviderOperation> eRs;
  
  public h$a(h paramh, ContentResolver paramContentResolver)
  {
    this.eRr = paramContentResolver;
    this.eRs = new ArrayList();
  }
  
  public final void a(ContentProviderOperation paramContentProviderOperation)
  {
    this.eRs.add(paramContentProviderOperation);
  }
  
  public final void execute()
  {
    if (this.eRs.size() == 0)
    {
      y.d("MicroMsg.BatchOperation", "no batch operation");
      return;
    }
    if (!a.j(h.a(this.eRt), "android.permission.READ_CONTACTS"))
    {
      y.e("MicroMsg.BatchOperation", "no contact permission");
      return;
    }
    try
    {
      this.eRr.applyBatch("com.android.contacts", this.eRs);
      this.eRs.clear();
      return;
    }
    catch (OperationApplicationException localOperationApplicationException)
    {
      for (;;)
      {
        y.e("MicroMsg.BatchOperation", "apply batch operation failed", new Object[] { localOperationApplicationException.toString() });
      }
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        y.e("MicroMsg.BatchOperation", "apply batch operation failed", new Object[] { localRemoteException.toString() });
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        y.e("MicroMsg.BatchOperation", "apply batch operation failed", new Object[] { localException.toString() });
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.platformtools.h.a
 * JD-Core Version:    0.7.0.1
 */
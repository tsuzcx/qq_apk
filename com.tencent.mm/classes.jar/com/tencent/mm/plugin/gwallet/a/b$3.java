package com.tencent.mm.plugin.gwallet.a;

import android.content.Intent;
import android.os.RemoteException;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import org.json.JSONException;

public final class b$3
  implements Runnable
{
  public b$3(b paramb, String paramString, ah paramah, b.b paramb1) {}
  
  public final void run()
  {
    c localc1 = new c(0, "Inventory refresh successful.");
    Intent localIntent = new Intent();
    try
    {
      int i = b.a(this.ljf, localIntent, this.ljk);
      if (i != 0) {
        localc1 = new c(i, "Error refreshing inventory (querying owned items).");
      }
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.IabHelper", localRemoteException, "", new Object[0]);
        c localc2 = new c(-1001, "Remote exception while refreshing inventory.");
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.IabHelper", localJSONException, "", new Object[0]);
        c localc3 = new c(-1002, "Error parsing JSON response while refreshing inventory.");
      }
    }
    localIntent.putExtra("RESPONSE_CODE", localc1.baN());
    this.hZR.post(new b.3.1(this, localc1, localIntent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gwallet.a.b.3
 * JD-Core Version:    0.7.0.1
 */
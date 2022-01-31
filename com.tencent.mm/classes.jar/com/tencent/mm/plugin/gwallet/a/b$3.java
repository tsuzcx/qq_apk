package com.tencent.mm.plugin.gwallet.a;

import android.content.Intent;
import android.os.RemoteException;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import org.json.JSONException;

public final class b$3
  implements Runnable
{
  public b$3(b paramb, String paramString, ak paramak, b.b paramb1) {}
  
  public final void run()
  {
    AppMethodBeat.i(41696);
    c localc1 = new c(0, "Inventory refresh successful.");
    Intent localIntent = new Intent();
    try
    {
      int i = b.a(this.nGu, localIntent, this.nGz);
      if (i != 0) {
        localc1 = new c(i, "Error refreshing inventory (querying owned items).");
      }
    }
    catch (RemoteException localRemoteException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.IabHelper", localRemoteException, "", new Object[0]);
        c localc2 = new c(-1001, "Remote exception while refreshing inventory.");
      }
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.IabHelper", localJSONException, "", new Object[0]);
        c localc3 = new c(-1002, "Error parsing JSON response while refreshing inventory.");
      }
    }
    localIntent.putExtra("RESPONSE_CODE", localc1.bHN());
    this.mFP.post(new b.3.1(this, localc1, localIntent));
    AppMethodBeat.o(41696);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gwallet.a.b.3
 * JD-Core Version:    0.7.0.1
 */
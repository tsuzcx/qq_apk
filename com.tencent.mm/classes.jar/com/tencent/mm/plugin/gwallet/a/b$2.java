package com.tencent.mm.plugin.gwallet.a;

import android.content.Context;
import android.os.RemoteException;
import com.android.vending.billing.IInAppBillingService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.Iterator;
import java.util.List;

public final class b$2
  implements Runnable
{
  public b$2(b paramb, List paramList, b.b paramb1, ak paramak) {}
  
  public final void run()
  {
    AppMethodBeat.i(41694);
    Object localObject1 = this.nGv.iterator();
    int i = 0;
    int j;
    for (;;)
    {
      if (!((Iterator)localObject1).hasNext()) {
        break label222;
      }
      Object localObject2 = (String)((Iterator)localObject1).next();
      try
      {
        b localb = this.nGu;
        localb.QI("consume");
        if (localObject2 != null) {}
        try
        {
          if (((String)localObject2).equals("")) {
            b.QJ("Can't consume " + (String)localObject2 + ". No token.");
          }
          j = localb.nGn.c(3, localb.mContext.getPackageName(), (String)localObject2);
          if (j == 0) {
            ab.d("MicroMsg.IabHelper", "Successfully consumed token: ".concat(String.valueOf(localObject2)));
          }
        }
        catch (RemoteException localRemoteException)
        {
          localObject2 = new a("Remote exception while consuming. token: ".concat(String.valueOf(localObject2)), localRemoteException);
          AppMethodBeat.o(41694);
          throw ((Throwable)localObject2);
        }
      }
      catch (a locala1)
      {
        i = locala1.nGm.bHN();
      }
    }
    ab.d("MicroMsg.IabHelper", "Error consuming consuming token ".concat(String.valueOf(locala1)));
    a locala2 = new a(j, "Error consuming token ".concat(String.valueOf(locala1)));
    AppMethodBeat.o(41694);
    throw locala2;
    label222:
    if (this.nGw != null)
    {
      localObject1 = new c(i, "");
      this.mFP.post(new b.2.1(this, (c)localObject1));
    }
    AppMethodBeat.o(41694);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gwallet.a.b.2
 * JD-Core Version:    0.7.0.1
 */
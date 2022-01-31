package com.tencent.mm.plugin.gwallet.a;

import android.content.Context;
import android.os.RemoteException;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.List;

public final class b$2
  implements Runnable
{
  public b$2(b paramb, List paramList, b.b paramb1, ah paramah) {}
  
  public final void run()
  {
    Object localObject = this.ljg.iterator();
    int i = 0;
    int j;
    for (;;)
    {
      if (!((Iterator)localObject).hasNext()) {
        break label227;
      }
      String str = (String)((Iterator)localObject).next();
      try
      {
        b localb = this.ljf;
        localb.Fk("consume");
        if (str != null) {}
        try
        {
          if (str.equals("")) {
            b.Fl("Can't consume " + str + ". No token.");
          }
          j = localb.liY.c(3, localb.mContext.getPackageName(), str);
          if (j == 0) {
            y.d("MicroMsg.IabHelper", "Successfully consumed token: " + str);
          }
        }
        catch (RemoteException localRemoteException)
        {
          throw new a("Remote exception while consuming. token: " + str, localRemoteException);
        }
      }
      catch (a locala)
      {
        i = locala.liX.baN();
      }
    }
    y.d("MicroMsg.IabHelper", "Error consuming consuming token " + locala);
    throw new a(j, "Error consuming token " + locala);
    label227:
    if (this.ljh != null)
    {
      localObject = new c(i, "");
      this.hZR.post(new b.2.1(this, (c)localObject));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.gwallet.a.b.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.backup.h;

import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.b;
import com.tencent.mm.pluginsdk.model.app.ap;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.y;
import java.util.Iterator;
import java.util.LinkedList;

public final class a$2
  implements Runnable
{
  public a$2(a parama) {}
  
  public final void run()
  {
    Iterator localIterator = this.hMJ.hMI.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (a.a)localIterator.next();
      if ((((a.a)localObject).type == 2) && (((a.a)localObject).obj != null) && ((((a.a)localObject).obj instanceof String)))
      {
        localObject = (String)((a.a)localObject).obj;
        y.d("MicroMsg.BackupRecoverDelayData", "getContact:" + (String)localObject);
        am.a.dVy.V((String)localObject, "");
      }
      else if ((((a.a)localObject).type == 1) && (((a.a)localObject).obj != null) && ((((a.a)localObject).obj instanceof String)))
      {
        ap.brm().VS((String)((a.a)localObject).obj);
      }
    }
    this.hMJ.hMI.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.h.a.2
 * JD-Core Version:    0.7.0.1
 */
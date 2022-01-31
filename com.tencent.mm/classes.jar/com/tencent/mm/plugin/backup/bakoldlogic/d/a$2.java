package com.tencent.mm.plugin.backup.bakoldlogic.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.LinkedList;

final class a$2
  implements Runnable
{
  a$2(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(17999);
    Iterator localIterator = this.jIM.jGk.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (a.a)localIterator.next();
      if ((((a.a)localObject).type == 2) && (((a.a)localObject).obj != null) && ((((a.a)localObject).obj instanceof String)))
      {
        localObject = (String)((a.a)localObject).obj;
        ab.d("MicroMsg.BakOldRecoverDelayData", "getContact:".concat(String.valueOf(localObject)));
        ao.a.flI.am((String)localObject, "");
      }
      else if ((((a.a)localObject).type == 1) && (((a.a)localObject).obj != null) && ((((a.a)localObject).obj instanceof String)))
      {
        al.cab().alr((String)((a.a)localObject).obj);
      }
    }
    this.jIM.jGk.clear();
    AppMethodBeat.o(17999);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.d.a.2
 * JD-Core Version:    0.7.0.1
 */
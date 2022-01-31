package com.tencent.mm.plugin.backup.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.pluginsdk.model.app.al;
import com.tencent.mm.pluginsdk.model.app.h;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.Iterator;
import java.util.LinkedList;

public final class a$2
  implements Runnable
{
  public a$2(a parama) {}
  
  public final void run()
  {
    AppMethodBeat.i(17684);
    Iterator localIterator = this.jGl.jGk.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (a.a)localIterator.next();
      if ((((a.a)localObject).type == 2) && (((a.a)localObject).obj != null) && ((((a.a)localObject).obj instanceof String)))
      {
        localObject = (String)((a.a)localObject).obj;
        ab.d("MicroMsg.BackupRecoverDelayData", "getContact:".concat(String.valueOf(localObject)));
        ao.a.flI.am((String)localObject, "");
      }
      else if ((((a.a)localObject).type == 1) && (((a.a)localObject).obj != null) && ((((a.a)localObject).obj instanceof String)))
      {
        al.cab().alr((String)((a.a)localObject).obj);
      }
    }
    this.jGl.jGk.clear();
    AppMethodBeat.o(17684);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.h.a.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.model.d;

import android.os.HandlerThread;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.m;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.ao.b;
import java.util.Iterator;
import java.util.LinkedList;

public final class a$2
  implements ao.b
{
  public a$2(a parama) {}
  
  public final String acc()
  {
    AppMethodBeat.i(16373);
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("worker thread id = " + aw.RO().oNc.getLooper().getThread().getId() + "[" + aw.RO().dtc() + "]\n");
    ((StringBuilder)localObject1).append("#cpu freq(KHz)[max=" + m.Lp() + ", min=" + m.Lq() + ", cur=" + m.Lr() + "]\n");
    Object localObject2 = new LinkedList(a.e(this.fpv));
    Iterator localIterator = ((LinkedList)localObject2).iterator();
    ((StringBuilder)localObject1).append("#done tasks size = " + ((LinkedList)localObject2).size() + '\n');
    if (localIterator != null)
    {
      int i = 0;
      while ((localIterator.hasNext()) && (i < a.k(this.fpv)))
      {
        localObject2 = (a.a)localIterator.next();
        ((StringBuilder)localObject1).append("[index = " + i + " | taskinfo:" + ((a.a)localObject2).info + "]\n");
        i += 1;
      }
    }
    ((StringBuilder)localObject1).append("\n#waiting" + aw.RO().caB().dump(false));
    localObject1 = ((StringBuilder)localObject1).toString();
    AppMethodBeat.o(16373);
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.d.a.2
 * JD-Core Version:    0.7.0.1
 */
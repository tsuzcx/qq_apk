package com.tencent.mm.plugin.finder.extension;

import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.cgi.at;
import com.tencent.mm.sdk.platformtools.ao.a;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import d.g.b.k;
import d.l;
import d.o;
import d.v;
import java.util.Collection;
import java.util.concurrent.ConcurrentLinkedQueue;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/os/Message;", "kotlin.jvm.PlatformType", "handleMessage"})
final class a$b
  implements ao.a
{
  a$b(a parama) {}
  
  public final boolean handleMessage(Message paramMessage)
  {
    AppMethodBeat.i(165584);
    if ((paramMessage.what == a.a(this.ree)) && (a.b(this.ree) == 0))
    {
      int i;
      if (!((Collection)a.c(this.ree)).isEmpty()) {
        i = 1;
      }
      while (i != 0)
      {
        paramMessage = (o)a.c(this.ree).peek();
        a.a(this.ree, ((Number)paramMessage.first).intValue());
        Object localObject = g.agR();
        k.g(localObject, "MMKernel.storage()");
        localObject = ((e)localObject).agA().get(ah.a.GUs, "");
        if (localObject == null)
        {
          paramMessage = new v("null cannot be cast to non-null type kotlin.String");
          AppMethodBeat.o(165584);
          throw paramMessage;
          i = 0;
        }
        else
        {
          localObject = bs.aLu((String)localObject);
          paramMessage = new at(u.axE(), (byte[])localObject, a.b(this.ree), a.Dv(((Number)paramMessage.second).intValue()));
          g.agi().b((n)paramMessage);
        }
      }
    }
    AppMethodBeat.o(165584);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.extension.a.b
 * JD-Core Version:    0.7.0.1
 */
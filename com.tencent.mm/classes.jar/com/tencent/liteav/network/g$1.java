package com.tencent.liteav.network;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import java.util.Vector;
import java.util.Vector<Lcom.tencent.liteav.network.e;>;

class g$1
  implements g.a
{
  g$1(g paramg, String paramString1, String paramString2, String paramString3, String paramString4, g.a parama) {}
  
  public void a(int paramInt, String paramString, Vector<e> paramVector)
  {
    AppMethodBeat.i(67572);
    g.a(this.f, this.a);
    g.b(this.f, this.b);
    g.a(this.f, paramInt);
    g.c(this.f, paramString);
    if ((paramVector != null) && (!paramVector.isEmpty()))
    {
      Vector localVector = new Vector();
      Iterator localIterator = paramVector.iterator();
      Object localObject;
      while (localIterator.hasNext())
      {
        e locale = (e)localIterator.next();
        localObject = locale.a;
        paramVector = (Vector<e>)localObject;
        if (((String)localObject).indexOf("?") != -1) {
          paramVector = ((String)localObject).substring(0, ((String)localObject).indexOf("?"));
        }
        localVector.add(new e(paramVector + "?txSecret=" + this.c + "&txTime=" + this.d + "&bizid=" + this.b, locale.b));
      }
      if (this.e != null)
      {
        paramVector = localVector.iterator();
        while (paramVector.hasNext())
        {
          localObject = (e)paramVector.next();
          TXCLog.e("TXRTMPAccUrlFetcher", "accurl = " + ((e)localObject).a + " quic = " + ((e)localObject).b);
        }
        this.e.a(paramInt, paramString, localVector);
      }
      AppMethodBeat.o(67572);
      return;
    }
    if (this.e != null) {
      this.e.a(paramInt, paramString, null);
    }
    AppMethodBeat.o(67572);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.liteav.network.g.1
 * JD-Core Version:    0.7.0.1
 */
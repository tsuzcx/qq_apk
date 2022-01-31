package com.tencent.mm.modelvideo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cg.h;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.List;
import java.util.Map;

final class m$2
  implements Runnable
{
  m$2(m paramm, long paramLong, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    AppMethodBeat.i(50735);
    m.alA();
    m.c(this.fWE);
    m.a(this.fWE, "");
    long l2 = 0L;
    long l1 = l2;
    if (this.fWD > 0L)
    {
      l1 = l2;
      if (m.d(this.fWE).get(Long.valueOf(this.fWD)) != null) {
        l1 = ((g.a)m.d(this.fWE).get(Long.valueOf(this.fWD))).Mm();
      }
    }
    ab.i("MicroMsg.SightMassSendService", "on ERROR massSendId: %d time: %d errType %d errCode %d", new Object[] { Long.valueOf(this.fWD), Long.valueOf(l1), Integer.valueOf(this.val$errType), Integer.valueOf(this.val$errCode) });
    if ((this.val$errType != 0) || (this.val$errCode != 0)) {
      m.j(this.fWE);
    }
    ab.i("MicroMsg.SightMassSendService", "onSceneEnd  inCnt: %d stop: %d running: %B sending: %B", new Object[] { Integer.valueOf(m.access$300()), Integer.valueOf(m.e(this.fWE)), Boolean.valueOf(m.f(this.fWE)), Boolean.valueOf(m.g(this.fWE)) });
    if (m.e(this.fWE) > 0) {
      m.h(this.fWE);
    }
    while (m.g(this.fWE))
    {
      m.alB();
      AppMethodBeat.o(50735);
      return;
    }
    ab.w("MicroMsg.SightMassSendService", "StopFlag ERROR force do stop, fail all job");
    t localt = o.alE();
    Object localObject2 = m.k(this.fWE);
    if ((localObject2 == null) || (((List)localObject2).isEmpty())) {}
    for (;;)
    {
      m.i(this.fWE);
      break;
      l1 = System.currentTimeMillis() / 1000L;
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append('(');
      int i = 0;
      while (i < ((List)localObject2).size() - 1)
      {
        ((StringBuilder)localObject1).append((Long)((List)localObject2).get(i));
        ((StringBuilder)localObject1).append(',');
        i += 1;
      }
      localObject2 = (Long)((List)localObject2).get(((List)localObject2).size() - 1);
      if (localObject2 != null) {
        ((StringBuilder)localObject1).append(localObject2);
      }
      ((StringBuilder)localObject1).append(')');
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject1 = "UPDATE videoinfo2 SET status=198, lastmodifytime=" + l1 + " WHERE masssendid IN " + (String)localObject1;
      ab.i("MicroMsg.VideoInfoStorage", "fail all massSendInfos, sql %s", new Object[] { localObject1 });
      localt.fnw.execSQL("videoinfo2", (String)localObject1);
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(50736);
    String str = super.toString() + "|onSceneEnd";
    AppMethodBeat.o(50736);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvideo.m.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.modelvideo;

import com.tencent.mm.cf.h;
import com.tencent.mm.compatible.util.g.a;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;
import java.util.Map;

final class m$2
  implements Runnable
{
  m$2(m paramm, long paramLong, int paramInt1, int paramInt2) {}
  
  public final void run()
  {
    m.Sn();
    m.c(this.eGO);
    m.a(this.eGO, "");
    long l2 = 0L;
    long l1 = l2;
    if (this.eGN > 0L)
    {
      l1 = l2;
      if (m.d(this.eGO).get(Long.valueOf(this.eGN)) != null) {
        l1 = ((g.a)m.d(this.eGO).get(Long.valueOf(this.eGN))).zJ();
      }
    }
    y.i("MicroMsg.SightMassSendService", "on ERROR massSendId: %d time: %d errType %d errCode %d", new Object[] { Long.valueOf(this.eGN), Long.valueOf(l1), Integer.valueOf(this.bEf), Integer.valueOf(this.bEg) });
    if ((this.bEf != 0) || (this.bEg != 0)) {
      m.j(this.eGO);
    }
    y.i("MicroMsg.SightMassSendService", "onSceneEnd  inCnt: %d stop: %d running: %B sending: %B", new Object[] { Integer.valueOf(m.access$300()), Integer.valueOf(m.e(this.eGO)), Boolean.valueOf(m.f(this.eGO)), Boolean.valueOf(m.g(this.eGO)) });
    if (m.e(this.eGO) > 0) {
      m.h(this.eGO);
    }
    while (m.g(this.eGO))
    {
      m.So();
      return;
    }
    y.w("MicroMsg.SightMassSendService", "StopFlag ERROR force do stop, fail all job");
    t localt = o.Sr();
    Object localObject2 = m.k(this.eGO);
    if ((localObject2 == null) || (((List)localObject2).isEmpty())) {}
    for (;;)
    {
      m.i(this.eGO);
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
      y.i("MicroMsg.VideoInfoStorage", "fail all massSendInfos, sql %s", new Object[] { localObject1 });
      localt.dXo.gk("videoinfo2", (String)localObject1);
    }
  }
  
  public final String toString()
  {
    return super.toString() + "|onSceneEnd";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvideo.m.2
 * JD-Core Version:    0.7.0.1
 */
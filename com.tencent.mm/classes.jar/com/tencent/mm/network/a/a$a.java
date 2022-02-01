package com.tencent.mm.network.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a$a
{
  public long beginTime = 0L;
  public long cCv = 0L;
  public String clientIp = "";
  public long count = 0L;
  public long endTime = 0L;
  public int errCode = 0;
  public int errType = 0;
  public long expand1 = 0L;
  public long expand2 = 0L;
  public c jGm;
  public boolean jGn = false;
  public long jGo = 0L;
  public long jGp = 0L;
  public int jGq = 0;
  public int jGr = 0;
  public long jGs = 0L;
  public long jGt = 0L;
  public long jGu = 0L;
  public long netSignal = 0L;
  public int netType = 0;
  public int retryCount = 0;
  public long rtType = 0L;
  
  public final String toString()
  {
    AppMethodBeat.i(132962);
    long l1 = this.rtType;
    long l2 = this.beginTime;
    long l3 = this.endTime;
    long l4 = this.endTime;
    long l5 = this.beginTime;
    long l6 = this.cCv;
    long l7 = this.count;
    if (this.jGm == null) {}
    for (String str = "null";; str = this.jGm.toString())
    {
      str = String.format("rtType:%d begin:%d, end:%d time:%d cost:%d count:%d ipInfo:%s socket:%b netType:%d err:(%d,%d) tx:%d rx:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4 - l5), Long.valueOf(l6), Long.valueOf(l7), str, Boolean.valueOf(this.jGn), Integer.valueOf(this.netType), Integer.valueOf(this.errType), Integer.valueOf(this.errCode), Long.valueOf(this.jGo), Long.valueOf(this.jGp) });
      AppMethodBeat.o(132962);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.network.a.a.a
 * JD-Core Version:    0.7.0.1
 */
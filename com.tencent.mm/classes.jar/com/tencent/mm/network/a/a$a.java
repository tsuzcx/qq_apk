package com.tencent.mm.network.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a$a
{
  public long bSb = 0L;
  public long beginTime = 0L;
  public String clientIp = "";
  public long endTime = 0L;
  public int errCode = 0;
  public int errType = 0;
  public long expand1 = 0L;
  public long expand2 = 0L;
  public c gfe;
  public boolean gff = false;
  public long gfg = 0L;
  public long gfh = 0L;
  public long gfi = 0L;
  public int gfj = 0;
  public int gfk = 0;
  public long gfl = 0L;
  public long gfm = 0L;
  public long gfn = 0L;
  public long netSignal = 0L;
  public int netType = 0;
  public int retryCount = 0;
  public long rtType = 0L;
  
  public final String toString()
  {
    AppMethodBeat.i(58712);
    long l1 = this.rtType;
    long l2 = this.beginTime;
    long l3 = this.endTime;
    long l4 = this.endTime;
    long l5 = this.beginTime;
    long l6 = this.bSb;
    long l7 = this.gfi;
    if (this.gfe == null) {}
    for (String str = "null";; str = this.gfe.toString())
    {
      str = String.format("rtType:%d begin:%d, end:%d time:%d cost:%d count:%d ipInfo:%s socket:%b netType:%d err:(%d,%d) tx:%d rx:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4 - l5), Long.valueOf(l6), Long.valueOf(l7), str, Boolean.valueOf(this.gff), Integer.valueOf(this.netType), Integer.valueOf(this.errType), Integer.valueOf(this.errCode), Long.valueOf(this.gfg), Long.valueOf(this.gfh) });
      AppMethodBeat.o(58712);
      return str;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.network.a.a.a
 * JD-Core Version:    0.7.0.1
 */
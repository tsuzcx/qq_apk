package com.tencent.mm.network.a;

public final class a$a
{
  public long beginTime = 0L;
  public long brE = 0L;
  public String clientIp = "";
  public long ePA = 0L;
  public c ePr;
  public boolean ePs = false;
  public long ePt = 0L;
  public long ePu = 0L;
  public long ePv = 0L;
  public int ePw = 0;
  public int ePx = 0;
  public long ePy = 0L;
  public long ePz = 0L;
  public long endTime = 0L;
  public int errCode = 0;
  public int errType = 0;
  public long expand1 = 0L;
  public long expand2 = 0L;
  public long netSignal = 0L;
  public int netType = 0;
  public int retryCount = 0;
  public long rtType = 0L;
  
  public final String toString()
  {
    long l1 = this.rtType;
    long l2 = this.beginTime;
    long l3 = this.endTime;
    long l4 = this.endTime;
    long l5 = this.beginTime;
    long l6 = this.brE;
    long l7 = this.ePv;
    if (this.ePr == null) {}
    for (String str = "null";; str = this.ePr.toString()) {
      return String.format("rtType:%d begin:%d, end:%d time:%d cost:%d count:%d ipInfo:%s socket:%b netType:%d err:(%d,%d) tx:%d rx:%d", new Object[] { Long.valueOf(l1), Long.valueOf(l2), Long.valueOf(l3), Long.valueOf(l4 - l5), Long.valueOf(l6), Long.valueOf(l7), str, Boolean.valueOf(this.ePs), Integer.valueOf(this.netType), Integer.valueOf(this.errType), Integer.valueOf(this.errCode), Long.valueOf(this.ePt), Long.valueOf(this.ePu) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.network.a.a.a
 * JD-Core Version:    0.7.0.1
 */
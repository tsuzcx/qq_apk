package com.tencent.mm.am;

public final class a$a
  implements Comparable<a>
{
  public long eke = 0L;
  public int ekf = 0;
  public boolean ekg = true;
  public boolean ekh = false;
  public int eki = 0;
  public long ekj = 0L;
  public long ekk = 0L;
  public long ekl = 0L;
  public long endTime = 0L;
  public int pid = 0;
  public long startTime = 0L;
  public int type = 0;
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    switch (this.type)
    {
    }
    for (;;)
    {
      localStringBuilder.append("\n");
      return localStringBuilder.toString();
      localStringBuilder.append(String.format("server time:%s,local start time:%s,local end time:%s,[mm] pid:%s,normal execute:%s", new Object[] { a.bU(this.eke), a.bU(this.startTime), a.bU(this.endTime), Integer.valueOf(this.pid), Boolean.valueOf(this.ekg) }));
      continue;
      localStringBuilder.append(String.format("server time:%s,local start time:%s,local end time:%s,[push] pid:%s,network:%s,normal execute:%s", new Object[] { a.bU(this.eke), a.bU(this.startTime), a.bU(this.endTime), Integer.valueOf(this.pid), Integer.valueOf(this.ekf), Boolean.valueOf(this.ekg) }));
      continue;
      localStringBuilder.append(String.format("server time:%s,local start time:%s,local end time:%s,send broadcast type(push):%s", new Object[] { a.bU(this.eke), a.bU(this.startTime), a.bU(this.endTime), Integer.valueOf(this.eki) }));
      continue;
      localStringBuilder.append(String.format("server time:%s,local start time:%s,local end time:%s,receive broadcast type(mm):%s", new Object[] { a.bU(this.eke), a.bU(this.startTime), a.bU(this.endTime), Integer.valueOf(this.eki) }));
      continue;
      localStringBuilder.append(String.format("server time:%s,local start time:%s,local end time:%s,delayed msg pid:%s, msg server time:%s,interval time:%s, msg server id:%s", new Object[] { a.bU(this.eke), a.bU(this.startTime), a.bU(this.endTime), Integer.valueOf(this.pid), a.bU(this.ekj), Long.valueOf(this.ekk), Long.valueOf(this.ekl) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.am.a.a
 * JD-Core Version:    0.7.0.1
 */
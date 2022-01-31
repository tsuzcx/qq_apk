package com.tencent.mm.an;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class a$a
  implements Comparable<a>
{
  public long endTime = 0L;
  public long fAA = 0L;
  public long fAB = 0L;
  public long fAu = 0L;
  public int fAv = 0;
  public boolean fAw = true;
  public boolean fAx = false;
  public int fAy = 0;
  public long fAz = 0L;
  public int pid = 0;
  public long startTime = 0L;
  public int type = 0;
  
  public final String toString()
  {
    AppMethodBeat.i(58327);
    Object localObject = new StringBuilder();
    switch (this.type)
    {
    }
    for (;;)
    {
      ((StringBuilder)localObject).append("\n");
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(58327);
      return localObject;
      ((StringBuilder)localObject).append(String.format("server time:%s,local start time:%s,local end time:%s,[mm] pid:%s,normal execute:%s", new Object[] { a.gP(this.fAu), a.gP(this.startTime), a.gP(this.endTime), Integer.valueOf(this.pid), Boolean.valueOf(this.fAw) }));
      continue;
      ((StringBuilder)localObject).append(String.format("server time:%s,local start time:%s,local end time:%s,[push] pid:%s,network:%s,normal execute:%s", new Object[] { a.gP(this.fAu), a.gP(this.startTime), a.gP(this.endTime), Integer.valueOf(this.pid), Integer.valueOf(this.fAv), Boolean.valueOf(this.fAw) }));
      continue;
      ((StringBuilder)localObject).append(String.format("server time:%s,local start time:%s,local end time:%s,send broadcast type(push):%s", new Object[] { a.gP(this.fAu), a.gP(this.startTime), a.gP(this.endTime), Integer.valueOf(this.fAy) }));
      continue;
      ((StringBuilder)localObject).append(String.format("server time:%s,local start time:%s,local end time:%s,receive broadcast type(mm):%s", new Object[] { a.gP(this.fAu), a.gP(this.startTime), a.gP(this.endTime), Integer.valueOf(this.fAy) }));
      continue;
      ((StringBuilder)localObject).append(String.format("server time:%s,local start time:%s,local end time:%s,delayed msg pid:%s, msg server time:%s,interval time:%s, msg server id:%s", new Object[] { a.gP(this.fAu), a.gP(this.startTime), a.gP(this.endTime), Integer.valueOf(this.pid), a.gP(this.fAz), Long.valueOf(this.fAA), Long.valueOf(this.fAB) }));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.an.a.a
 * JD-Core Version:    0.7.0.1
 */
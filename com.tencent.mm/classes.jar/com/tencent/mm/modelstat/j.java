package com.tencent.mm.modelstat;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j
{
  private static final String oWR;
  int eQp = -2;
  public int id = 0;
  public long oWA = 0L;
  public int oWB = 0;
  public long oWC = 0L;
  public int oWD = 0;
  public long oWE = 0L;
  public int oWF = 0;
  public long oWG = 0L;
  public int oWH = 0;
  public long oWI = 0L;
  public long oWJ = 0L;
  public long oWK = 0L;
  public long oWL = 0L;
  public long oWM = 0L;
  public long oWN = 0L;
  public long oWO = 0L;
  public long oWP = 0L;
  public long oWQ = 0L;
  public int oWo = 0;
  public int oWp = 0;
  public long oWq = 0L;
  public int oWr = 0;
  public long oWs = 0L;
  public int oWt = 0;
  public long oWu = 0L;
  public int oWv = 0;
  public long oWw = 0L;
  public long oWx = 0L;
  public long oWy = 0L;
  public long oWz = 0L;
  
  static
  {
    AppMethodBeat.i(151086);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("NetStatInfo:");
    localStringBuilder.append("[mobile in=%dB/%dB/%dB, out=%dB/%dB/%dB]");
    localStringBuilder.append("[wifi in=%dB/%dB/%dB, out=%dB/%dB/%dB]");
    localStringBuilder.append("[text in=%d/%dB, out=%d/%dB]");
    localStringBuilder.append("[image in=%d/%dB, out=%d/%dB]");
    localStringBuilder.append("[voice in=%d/%dB, out=%d/%dB]");
    localStringBuilder.append("[video in=%d/%dB, out=%d/%dB]");
    oWR = localStringBuilder.toString();
    AppMethodBeat.o(151086);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(151084);
    this.id = paramCursor.getInt(0);
    this.oWo = paramCursor.getInt(1);
    this.oWp = paramCursor.getInt(2);
    this.oWq = paramCursor.getLong(3);
    this.oWr = paramCursor.getInt(4);
    this.oWs = paramCursor.getLong(5);
    this.oWt = paramCursor.getInt(6);
    this.oWu = paramCursor.getLong(7);
    this.oWv = paramCursor.getInt(8);
    this.oWw = paramCursor.getLong(9);
    this.oWx = paramCursor.getLong(10);
    this.oWy = paramCursor.getLong(11);
    this.oWz = paramCursor.getLong(12);
    this.oWA = paramCursor.getLong(13);
    this.oWB = paramCursor.getInt(14);
    this.oWC = paramCursor.getLong(15);
    this.oWD = paramCursor.getInt(16);
    this.oWE = paramCursor.getLong(17);
    this.oWF = paramCursor.getInt(18);
    this.oWG = paramCursor.getLong(19);
    this.oWH = paramCursor.getInt(20);
    this.oWI = paramCursor.getLong(21);
    this.oWJ = paramCursor.getLong(22);
    this.oWK = paramCursor.getLong(23);
    this.oWL = paramCursor.getLong(24);
    this.oWM = paramCursor.getLong(25);
    this.oWN = paramCursor.getLong(26);
    this.oWO = paramCursor.getLong(27);
    this.oWP = paramCursor.getLong(28);
    this.oWQ = paramCursor.getLong(29);
    AppMethodBeat.o(151084);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(151085);
    String str = String.format(oWR, new Object[] { Long.valueOf(this.oWx), Long.valueOf(this.oWN), Long.valueOf(this.oWz), Long.valueOf(this.oWJ), Long.valueOf(this.oWP), Long.valueOf(this.oWL), Long.valueOf(this.oWy), Long.valueOf(this.oWO), Long.valueOf(this.oWA), Long.valueOf(this.oWK), Long.valueOf(this.oWQ), Long.valueOf(this.oWM), Integer.valueOf(this.oWp), Long.valueOf(this.oWq), Integer.valueOf(this.oWB), Long.valueOf(this.oWC), Integer.valueOf(this.oWr), Long.valueOf(this.oWs), Integer.valueOf(this.oWD), Long.valueOf(this.oWE), Integer.valueOf(this.oWt), Long.valueOf(this.oWu), Integer.valueOf(this.oWF), Long.valueOf(this.oWG), Integer.valueOf(this.oWv), Long.valueOf(this.oWw), Integer.valueOf(this.oWH), Long.valueOf(this.oWI) });
    AppMethodBeat.o(151085);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelstat.j
 * JD-Core Version:    0.7.0.1
 */
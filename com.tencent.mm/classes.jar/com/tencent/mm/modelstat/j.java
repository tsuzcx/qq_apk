package com.tencent.mm.modelstat;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class j
{
  private static final String mdY;
  int cUP = -2;
  public int id = 0;
  public int mdA = 0;
  public long mdB = 0L;
  public int mdC = 0;
  public long mdD = 0L;
  public long mdE = 0L;
  public long mdF = 0L;
  public long mdG = 0L;
  public long mdH = 0L;
  public int mdI = 0;
  public long mdJ = 0L;
  public int mdK = 0;
  public long mdL = 0L;
  public int mdM = 0;
  public long mdN = 0L;
  public int mdO = 0;
  public long mdP = 0L;
  public long mdQ = 0L;
  public long mdR = 0L;
  public long mdS = 0L;
  public long mdT = 0L;
  public long mdU = 0L;
  public long mdV = 0L;
  public long mdW = 0L;
  public long mdX = 0L;
  public int mdv = 0;
  public int mdw = 0;
  public long mdx = 0L;
  public int mdy = 0;
  public long mdz = 0L;
  
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
    mdY = localStringBuilder.toString();
    AppMethodBeat.o(151086);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(151084);
    this.id = paramCursor.getInt(0);
    this.mdv = paramCursor.getInt(1);
    this.mdw = paramCursor.getInt(2);
    this.mdx = paramCursor.getLong(3);
    this.mdy = paramCursor.getInt(4);
    this.mdz = paramCursor.getLong(5);
    this.mdA = paramCursor.getInt(6);
    this.mdB = paramCursor.getLong(7);
    this.mdC = paramCursor.getInt(8);
    this.mdD = paramCursor.getLong(9);
    this.mdE = paramCursor.getLong(10);
    this.mdF = paramCursor.getLong(11);
    this.mdG = paramCursor.getLong(12);
    this.mdH = paramCursor.getLong(13);
    this.mdI = paramCursor.getInt(14);
    this.mdJ = paramCursor.getLong(15);
    this.mdK = paramCursor.getInt(16);
    this.mdL = paramCursor.getLong(17);
    this.mdM = paramCursor.getInt(18);
    this.mdN = paramCursor.getLong(19);
    this.mdO = paramCursor.getInt(20);
    this.mdP = paramCursor.getLong(21);
    this.mdQ = paramCursor.getLong(22);
    this.mdR = paramCursor.getLong(23);
    this.mdS = paramCursor.getLong(24);
    this.mdT = paramCursor.getLong(25);
    this.mdU = paramCursor.getLong(26);
    this.mdV = paramCursor.getLong(27);
    this.mdW = paramCursor.getLong(28);
    this.mdX = paramCursor.getLong(29);
    AppMethodBeat.o(151084);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(151085);
    String str = String.format(mdY, new Object[] { Long.valueOf(this.mdE), Long.valueOf(this.mdU), Long.valueOf(this.mdG), Long.valueOf(this.mdQ), Long.valueOf(this.mdW), Long.valueOf(this.mdS), Long.valueOf(this.mdF), Long.valueOf(this.mdV), Long.valueOf(this.mdH), Long.valueOf(this.mdR), Long.valueOf(this.mdX), Long.valueOf(this.mdT), Integer.valueOf(this.mdw), Long.valueOf(this.mdx), Integer.valueOf(this.mdI), Long.valueOf(this.mdJ), Integer.valueOf(this.mdy), Long.valueOf(this.mdz), Integer.valueOf(this.mdK), Long.valueOf(this.mdL), Integer.valueOf(this.mdA), Long.valueOf(this.mdB), Integer.valueOf(this.mdM), Long.valueOf(this.mdN), Integer.valueOf(this.mdC), Long.valueOf(this.mdD), Integer.valueOf(this.mdO), Long.valueOf(this.mdP) });
    AppMethodBeat.o(151085);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelstat.j
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.modelstat;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
{
  private static final String FORMAT;
  int drx = -2;
  public int hWD = 0;
  public int hWE = 0;
  public long hWF = 0L;
  public int hWG = 0;
  public long hWH = 0L;
  public int hWI = 0;
  public long hWJ = 0L;
  public int hWK = 0;
  public long hWL = 0L;
  public long hWM = 0L;
  public long hWN = 0L;
  public long hWO = 0L;
  public long hWP = 0L;
  public int hWQ = 0;
  public long hWR = 0L;
  public int hWS = 0;
  public long hWT = 0L;
  public int hWU = 0;
  public long hWV = 0L;
  public int hWW = 0;
  public long hWX = 0L;
  public long hWY = 0L;
  public long hWZ = 0L;
  public long hXa = 0L;
  public long hXb = 0L;
  public long hXc = 0L;
  public long hXd = 0L;
  public long hXe = 0L;
  public long hXf = 0L;
  public int id = 0;
  
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
    FORMAT = localStringBuilder.toString();
    AppMethodBeat.o(151086);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(151084);
    this.id = paramCursor.getInt(0);
    this.hWD = paramCursor.getInt(1);
    this.hWE = paramCursor.getInt(2);
    this.hWF = paramCursor.getLong(3);
    this.hWG = paramCursor.getInt(4);
    this.hWH = paramCursor.getLong(5);
    this.hWI = paramCursor.getInt(6);
    this.hWJ = paramCursor.getLong(7);
    this.hWK = paramCursor.getInt(8);
    this.hWL = paramCursor.getLong(9);
    this.hWM = paramCursor.getLong(10);
    this.hWN = paramCursor.getLong(11);
    this.hWO = paramCursor.getLong(12);
    this.hWP = paramCursor.getLong(13);
    this.hWQ = paramCursor.getInt(14);
    this.hWR = paramCursor.getLong(15);
    this.hWS = paramCursor.getInt(16);
    this.hWT = paramCursor.getLong(17);
    this.hWU = paramCursor.getInt(18);
    this.hWV = paramCursor.getLong(19);
    this.hWW = paramCursor.getInt(20);
    this.hWX = paramCursor.getLong(21);
    this.hWY = paramCursor.getLong(22);
    this.hWZ = paramCursor.getLong(23);
    this.hXa = paramCursor.getLong(24);
    this.hXb = paramCursor.getLong(25);
    this.hXc = paramCursor.getLong(26);
    this.hXd = paramCursor.getLong(27);
    this.hXe = paramCursor.getLong(28);
    this.hXf = paramCursor.getLong(29);
    AppMethodBeat.o(151084);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(151085);
    String str = String.format(FORMAT, new Object[] { Long.valueOf(this.hWM), Long.valueOf(this.hXc), Long.valueOf(this.hWO), Long.valueOf(this.hWY), Long.valueOf(this.hXe), Long.valueOf(this.hXa), Long.valueOf(this.hWN), Long.valueOf(this.hXd), Long.valueOf(this.hWP), Long.valueOf(this.hWZ), Long.valueOf(this.hXf), Long.valueOf(this.hXb), Integer.valueOf(this.hWE), Long.valueOf(this.hWF), Integer.valueOf(this.hWQ), Long.valueOf(this.hWR), Integer.valueOf(this.hWG), Long.valueOf(this.hWH), Integer.valueOf(this.hWS), Long.valueOf(this.hWT), Integer.valueOf(this.hWI), Long.valueOf(this.hWJ), Integer.valueOf(this.hWU), Long.valueOf(this.hWV), Integer.valueOf(this.hWK), Long.valueOf(this.hWL), Integer.valueOf(this.hWW), Long.valueOf(this.hWX) });
    AppMethodBeat.o(151085);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelstat.k
 * JD-Core Version:    0.7.0.1
 */
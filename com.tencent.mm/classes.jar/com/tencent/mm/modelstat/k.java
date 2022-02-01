package com.tencent.mm.modelstat;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
{
  private static final String FORMAT;
  int dtM = -2;
  public long hwA = 0L;
  public long hwB = 0L;
  public long hwC = 0L;
  public long hwD = 0L;
  public long hwE = 0L;
  public int hwc = 0;
  public int hwd = 0;
  public long hwe = 0L;
  public int hwf = 0;
  public long hwg = 0L;
  public int hwh = 0;
  public long hwi = 0L;
  public int hwj = 0;
  public long hwk = 0L;
  public long hwl = 0L;
  public long hwm = 0L;
  public long hwn = 0L;
  public long hwo = 0L;
  public int hwp = 0;
  public long hwq = 0L;
  public int hwr = 0;
  public long hws = 0L;
  public int hwt = 0;
  public long hwu = 0L;
  public int hwv = 0;
  public long hww = 0L;
  public long hwx = 0L;
  public long hwy = 0L;
  public long hwz = 0L;
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
    this.hwc = paramCursor.getInt(1);
    this.hwd = paramCursor.getInt(2);
    this.hwe = paramCursor.getLong(3);
    this.hwf = paramCursor.getInt(4);
    this.hwg = paramCursor.getLong(5);
    this.hwh = paramCursor.getInt(6);
    this.hwi = paramCursor.getLong(7);
    this.hwj = paramCursor.getInt(8);
    this.hwk = paramCursor.getLong(9);
    this.hwl = paramCursor.getLong(10);
    this.hwm = paramCursor.getLong(11);
    this.hwn = paramCursor.getLong(12);
    this.hwo = paramCursor.getLong(13);
    this.hwp = paramCursor.getInt(14);
    this.hwq = paramCursor.getLong(15);
    this.hwr = paramCursor.getInt(16);
    this.hws = paramCursor.getLong(17);
    this.hwt = paramCursor.getInt(18);
    this.hwu = paramCursor.getLong(19);
    this.hwv = paramCursor.getInt(20);
    this.hww = paramCursor.getLong(21);
    this.hwx = paramCursor.getLong(22);
    this.hwy = paramCursor.getLong(23);
    this.hwz = paramCursor.getLong(24);
    this.hwA = paramCursor.getLong(25);
    this.hwB = paramCursor.getLong(26);
    this.hwC = paramCursor.getLong(27);
    this.hwD = paramCursor.getLong(28);
    this.hwE = paramCursor.getLong(29);
    AppMethodBeat.o(151084);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(151085);
    String str = String.format(FORMAT, new Object[] { Long.valueOf(this.hwl), Long.valueOf(this.hwB), Long.valueOf(this.hwn), Long.valueOf(this.hwx), Long.valueOf(this.hwD), Long.valueOf(this.hwz), Long.valueOf(this.hwm), Long.valueOf(this.hwC), Long.valueOf(this.hwo), Long.valueOf(this.hwy), Long.valueOf(this.hwE), Long.valueOf(this.hwA), Integer.valueOf(this.hwd), Long.valueOf(this.hwe), Integer.valueOf(this.hwp), Long.valueOf(this.hwq), Integer.valueOf(this.hwf), Long.valueOf(this.hwg), Integer.valueOf(this.hwr), Long.valueOf(this.hws), Integer.valueOf(this.hwh), Long.valueOf(this.hwi), Integer.valueOf(this.hwt), Long.valueOf(this.hwu), Integer.valueOf(this.hwj), Long.valueOf(this.hwk), Integer.valueOf(this.hwv), Long.valueOf(this.hww) });
    AppMethodBeat.o(151085);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelstat.k
 * JD-Core Version:    0.7.0.1
 */
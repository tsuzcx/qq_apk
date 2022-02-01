package com.tencent.mm.modelstat;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
{
  private static final String FORMAT;
  int dDp = -2;
  public int id = 0;
  public int ipY = 0;
  public int ipZ = 0;
  public long iqA = 0L;
  public long iqa = 0L;
  public int iqb = 0;
  public long iqc = 0L;
  public int iqd = 0;
  public long iqe = 0L;
  public int iqf = 0;
  public long iqg = 0L;
  public long iqh = 0L;
  public long iqi = 0L;
  public long iqj = 0L;
  public long iqk = 0L;
  public int iql = 0;
  public long iqm = 0L;
  public int iqn = 0;
  public long iqo = 0L;
  public int iqp = 0;
  public long iqq = 0L;
  public int iqr = 0;
  public long iqs = 0L;
  public long iqt = 0L;
  public long iqu = 0L;
  public long iqv = 0L;
  public long iqw = 0L;
  public long iqx = 0L;
  public long iqy = 0L;
  public long iqz = 0L;
  
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
    this.ipY = paramCursor.getInt(1);
    this.ipZ = paramCursor.getInt(2);
    this.iqa = paramCursor.getLong(3);
    this.iqb = paramCursor.getInt(4);
    this.iqc = paramCursor.getLong(5);
    this.iqd = paramCursor.getInt(6);
    this.iqe = paramCursor.getLong(7);
    this.iqf = paramCursor.getInt(8);
    this.iqg = paramCursor.getLong(9);
    this.iqh = paramCursor.getLong(10);
    this.iqi = paramCursor.getLong(11);
    this.iqj = paramCursor.getLong(12);
    this.iqk = paramCursor.getLong(13);
    this.iql = paramCursor.getInt(14);
    this.iqm = paramCursor.getLong(15);
    this.iqn = paramCursor.getInt(16);
    this.iqo = paramCursor.getLong(17);
    this.iqp = paramCursor.getInt(18);
    this.iqq = paramCursor.getLong(19);
    this.iqr = paramCursor.getInt(20);
    this.iqs = paramCursor.getLong(21);
    this.iqt = paramCursor.getLong(22);
    this.iqu = paramCursor.getLong(23);
    this.iqv = paramCursor.getLong(24);
    this.iqw = paramCursor.getLong(25);
    this.iqx = paramCursor.getLong(26);
    this.iqy = paramCursor.getLong(27);
    this.iqz = paramCursor.getLong(28);
    this.iqA = paramCursor.getLong(29);
    AppMethodBeat.o(151084);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(151085);
    String str = String.format(FORMAT, new Object[] { Long.valueOf(this.iqh), Long.valueOf(this.iqx), Long.valueOf(this.iqj), Long.valueOf(this.iqt), Long.valueOf(this.iqz), Long.valueOf(this.iqv), Long.valueOf(this.iqi), Long.valueOf(this.iqy), Long.valueOf(this.iqk), Long.valueOf(this.iqu), Long.valueOf(this.iqA), Long.valueOf(this.iqw), Integer.valueOf(this.ipZ), Long.valueOf(this.iqa), Integer.valueOf(this.iql), Long.valueOf(this.iqm), Integer.valueOf(this.iqb), Long.valueOf(this.iqc), Integer.valueOf(this.iqn), Long.valueOf(this.iqo), Integer.valueOf(this.iqd), Long.valueOf(this.iqe), Integer.valueOf(this.iqp), Long.valueOf(this.iqq), Integer.valueOf(this.iqf), Long.valueOf(this.iqg), Integer.valueOf(this.iqr), Long.valueOf(this.iqs) });
    AppMethodBeat.o(151085);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelstat.k
 * JD-Core Version:    0.7.0.1
 */
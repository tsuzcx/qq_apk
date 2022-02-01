package com.tencent.mm.modelstat;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
{
  private static final String FORMAT;
  int dEu = -2;
  public int id = 0;
  public int isT = 0;
  public int isU = 0;
  public long isV = 0L;
  public int isW = 0;
  public long isX = 0L;
  public int isY = 0;
  public long isZ = 0L;
  public int ita = 0;
  public long itb = 0L;
  public long itc = 0L;
  public long itd = 0L;
  public long ite = 0L;
  public long itf = 0L;
  public int itg = 0;
  public long ith = 0L;
  public int iti = 0;
  public long itj = 0L;
  public int itk = 0;
  public long itl = 0L;
  public int itm = 0;
  public long itn = 0L;
  public long ito = 0L;
  public long itp = 0L;
  public long itq = 0L;
  public long itr = 0L;
  public long its = 0L;
  public long itt = 0L;
  public long itu = 0L;
  public long itv = 0L;
  
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
    this.isT = paramCursor.getInt(1);
    this.isU = paramCursor.getInt(2);
    this.isV = paramCursor.getLong(3);
    this.isW = paramCursor.getInt(4);
    this.isX = paramCursor.getLong(5);
    this.isY = paramCursor.getInt(6);
    this.isZ = paramCursor.getLong(7);
    this.ita = paramCursor.getInt(8);
    this.itb = paramCursor.getLong(9);
    this.itc = paramCursor.getLong(10);
    this.itd = paramCursor.getLong(11);
    this.ite = paramCursor.getLong(12);
    this.itf = paramCursor.getLong(13);
    this.itg = paramCursor.getInt(14);
    this.ith = paramCursor.getLong(15);
    this.iti = paramCursor.getInt(16);
    this.itj = paramCursor.getLong(17);
    this.itk = paramCursor.getInt(18);
    this.itl = paramCursor.getLong(19);
    this.itm = paramCursor.getInt(20);
    this.itn = paramCursor.getLong(21);
    this.ito = paramCursor.getLong(22);
    this.itp = paramCursor.getLong(23);
    this.itq = paramCursor.getLong(24);
    this.itr = paramCursor.getLong(25);
    this.its = paramCursor.getLong(26);
    this.itt = paramCursor.getLong(27);
    this.itu = paramCursor.getLong(28);
    this.itv = paramCursor.getLong(29);
    AppMethodBeat.o(151084);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(151085);
    String str = String.format(FORMAT, new Object[] { Long.valueOf(this.itc), Long.valueOf(this.its), Long.valueOf(this.ite), Long.valueOf(this.ito), Long.valueOf(this.itu), Long.valueOf(this.itq), Long.valueOf(this.itd), Long.valueOf(this.itt), Long.valueOf(this.itf), Long.valueOf(this.itp), Long.valueOf(this.itv), Long.valueOf(this.itr), Integer.valueOf(this.isU), Long.valueOf(this.isV), Integer.valueOf(this.itg), Long.valueOf(this.ith), Integer.valueOf(this.isW), Long.valueOf(this.isX), Integer.valueOf(this.iti), Long.valueOf(this.itj), Integer.valueOf(this.isY), Long.valueOf(this.isZ), Integer.valueOf(this.itk), Long.valueOf(this.itl), Integer.valueOf(this.ita), Long.valueOf(this.itb), Integer.valueOf(this.itm), Long.valueOf(this.itn) });
    AppMethodBeat.o(151085);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelstat.k
 * JD-Core Version:    0.7.0.1
 */
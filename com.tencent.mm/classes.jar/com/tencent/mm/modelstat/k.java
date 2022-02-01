package com.tencent.mm.modelstat;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
{
  private static final String FORMAT;
  int cSx = -2;
  public int id = 0;
  public long joA = 0L;
  public long joB = 0L;
  public long joC = 0L;
  public long joD = 0L;
  public long joE = 0L;
  public long joF = 0L;
  public long joG = 0L;
  public long joH = 0L;
  public long joI = 0L;
  public int jog = 0;
  public int joh = 0;
  public long joi = 0L;
  public int joj = 0;
  public long jok = 0L;
  public int jol = 0;
  public long jom = 0L;
  public int jon = 0;
  public long joo = 0L;
  public long jop = 0L;
  public long joq = 0L;
  public long jor = 0L;
  public long jos = 0L;
  public int jot = 0;
  public long jou = 0L;
  public int jov = 0;
  public long jow = 0L;
  public int jox = 0;
  public long joy = 0L;
  public int joz = 0;
  
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
    this.jog = paramCursor.getInt(1);
    this.joh = paramCursor.getInt(2);
    this.joi = paramCursor.getLong(3);
    this.joj = paramCursor.getInt(4);
    this.jok = paramCursor.getLong(5);
    this.jol = paramCursor.getInt(6);
    this.jom = paramCursor.getLong(7);
    this.jon = paramCursor.getInt(8);
    this.joo = paramCursor.getLong(9);
    this.jop = paramCursor.getLong(10);
    this.joq = paramCursor.getLong(11);
    this.jor = paramCursor.getLong(12);
    this.jos = paramCursor.getLong(13);
    this.jot = paramCursor.getInt(14);
    this.jou = paramCursor.getLong(15);
    this.jov = paramCursor.getInt(16);
    this.jow = paramCursor.getLong(17);
    this.jox = paramCursor.getInt(18);
    this.joy = paramCursor.getLong(19);
    this.joz = paramCursor.getInt(20);
    this.joA = paramCursor.getLong(21);
    this.joB = paramCursor.getLong(22);
    this.joC = paramCursor.getLong(23);
    this.joD = paramCursor.getLong(24);
    this.joE = paramCursor.getLong(25);
    this.joF = paramCursor.getLong(26);
    this.joG = paramCursor.getLong(27);
    this.joH = paramCursor.getLong(28);
    this.joI = paramCursor.getLong(29);
    AppMethodBeat.o(151084);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(151085);
    String str = String.format(FORMAT, new Object[] { Long.valueOf(this.jop), Long.valueOf(this.joF), Long.valueOf(this.jor), Long.valueOf(this.joB), Long.valueOf(this.joH), Long.valueOf(this.joD), Long.valueOf(this.joq), Long.valueOf(this.joG), Long.valueOf(this.jos), Long.valueOf(this.joC), Long.valueOf(this.joI), Long.valueOf(this.joE), Integer.valueOf(this.joh), Long.valueOf(this.joi), Integer.valueOf(this.jot), Long.valueOf(this.jou), Integer.valueOf(this.joj), Long.valueOf(this.jok), Integer.valueOf(this.jov), Long.valueOf(this.jow), Integer.valueOf(this.jol), Long.valueOf(this.jom), Integer.valueOf(this.jox), Long.valueOf(this.joy), Integer.valueOf(this.jon), Long.valueOf(this.joo), Integer.valueOf(this.joz), Long.valueOf(this.joA) });
    AppMethodBeat.o(151085);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelstat.k
 * JD-Core Version:    0.7.0.1
 */
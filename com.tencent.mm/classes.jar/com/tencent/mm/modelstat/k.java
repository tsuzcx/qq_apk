package com.tencent.mm.modelstat;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class k
{
  private static final String FORMAT;
  int bsY = -2;
  public int fTA = 0;
  public int fTB = 0;
  public int fTC = 0;
  public int fTD = 0;
  public int fTE = 0;
  public int fTF = 0;
  public int fTG = 0;
  public int fTH = 0;
  public int fTI = 0;
  public int fTJ = 0;
  public int fTK = 0;
  public int fTL = 0;
  public int fTM = 0;
  public int fTN = 0;
  public int fTO = 0;
  public int fTP = 0;
  public int fTQ = 0;
  public int fTR = 0;
  public int fTS = 0;
  public int fTT = 0;
  public int fTU = 0;
  public int fTV = 0;
  public int fTt = 0;
  public int fTu = 0;
  public int fTv = 0;
  public int fTw = 0;
  public int fTx = 0;
  public int fTy = 0;
  public int fTz = 0;
  public int id = 0;
  
  static
  {
    AppMethodBeat.i(78742);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("NetStatInfo:");
    localStringBuilder.append("[mobile in=%dB/%dB/%dB, out=%dB/%dB/%dB]");
    localStringBuilder.append("[wifi in=%dB/%dB/%dB, out=%dB/%dB/%dB]");
    localStringBuilder.append("[text in=%d/%dB, out=%d/%dB]");
    localStringBuilder.append("[image in=%d/%dB, out=%d/%dB]");
    localStringBuilder.append("[voice in=%d/%dB, out=%d/%dB]");
    localStringBuilder.append("[video in=%d/%dB, out=%d/%dB]");
    FORMAT = localStringBuilder.toString();
    AppMethodBeat.o(78742);
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(78740);
    this.id = paramCursor.getInt(0);
    this.fTt = paramCursor.getInt(1);
    this.fTu = paramCursor.getInt(2);
    this.fTv = paramCursor.getInt(3);
    this.fTw = paramCursor.getInt(4);
    this.fTx = paramCursor.getInt(5);
    this.fTy = paramCursor.getInt(6);
    this.fTz = paramCursor.getInt(7);
    this.fTA = paramCursor.getInt(8);
    this.fTB = paramCursor.getInt(9);
    this.fTC = paramCursor.getInt(10);
    this.fTD = paramCursor.getInt(11);
    this.fTE = paramCursor.getInt(12);
    this.fTF = paramCursor.getInt(13);
    this.fTG = paramCursor.getInt(14);
    this.fTH = paramCursor.getInt(15);
    this.fTI = paramCursor.getInt(16);
    this.fTJ = paramCursor.getInt(17);
    this.fTK = paramCursor.getInt(18);
    this.fTL = paramCursor.getInt(19);
    this.fTM = paramCursor.getInt(20);
    this.fTN = paramCursor.getInt(21);
    this.fTO = paramCursor.getInt(22);
    this.fTP = paramCursor.getInt(23);
    this.fTQ = paramCursor.getInt(24);
    this.fTR = paramCursor.getInt(25);
    this.fTS = paramCursor.getInt(26);
    this.fTT = paramCursor.getInt(27);
    this.fTU = paramCursor.getInt(28);
    this.fTV = paramCursor.getInt(29);
    AppMethodBeat.o(78740);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(78741);
    String str = String.format(FORMAT, new Object[] { Integer.valueOf(this.fTC), Integer.valueOf(this.fTS), Integer.valueOf(this.fTE), Integer.valueOf(this.fTO), Integer.valueOf(this.fTU), Integer.valueOf(this.fTQ), Integer.valueOf(this.fTD), Integer.valueOf(this.fTT), Integer.valueOf(this.fTF), Integer.valueOf(this.fTP), Integer.valueOf(this.fTV), Integer.valueOf(this.fTR), Integer.valueOf(this.fTu), Integer.valueOf(this.fTv), Integer.valueOf(this.fTG), Integer.valueOf(this.fTH), Integer.valueOf(this.fTw), Integer.valueOf(this.fTx), Integer.valueOf(this.fTI), Integer.valueOf(this.fTJ), Integer.valueOf(this.fTy), Integer.valueOf(this.fTz), Integer.valueOf(this.fTK), Integer.valueOf(this.fTL), Integer.valueOf(this.fTA), Integer.valueOf(this.fTB), Integer.valueOf(this.fTM), Integer.valueOf(this.fTN) });
    AppMethodBeat.o(78741);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.modelstat.k
 * JD-Core Version:    0.7.0.1
 */
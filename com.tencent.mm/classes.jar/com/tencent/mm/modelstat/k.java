package com.tencent.mm.modelstat;

import android.database.Cursor;

public final class k
{
  private static final String FORMAT;
  int bcw = -2;
  public int eDC = 0;
  public int eDD = 0;
  public int eDE = 0;
  public int eDF = 0;
  public int eDG = 0;
  public int eDH = 0;
  public int eDI = 0;
  public int eDJ = 0;
  public int eDK = 0;
  public int eDL = 0;
  public int eDM = 0;
  public int eDN = 0;
  public int eDO = 0;
  public int eDP = 0;
  public int eDQ = 0;
  public int eDR = 0;
  public int eDS = 0;
  public int eDT = 0;
  public int eDU = 0;
  public int eDV = 0;
  public int eDW = 0;
  public int eDX = 0;
  public int eDY = 0;
  public int eDZ = 0;
  public int eEa = 0;
  public int eEb = 0;
  public int eEc = 0;
  public int eEd = 0;
  public int eEe = 0;
  public int id = 0;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("NetStatInfo:");
    localStringBuilder.append("[mobile in=%dB/%dB/%dB, out=%dB/%dB/%dB]");
    localStringBuilder.append("[wifi in=%dB/%dB/%dB, out=%dB/%dB/%dB]");
    localStringBuilder.append("[text in=%d/%dB, out=%d/%dB]");
    localStringBuilder.append("[image in=%d/%dB, out=%d/%dB]");
    localStringBuilder.append("[voice in=%d/%dB, out=%d/%dB]");
    localStringBuilder.append("[video in=%d/%dB, out=%d/%dB]");
    FORMAT = localStringBuilder.toString();
  }
  
  public final void d(Cursor paramCursor)
  {
    this.id = paramCursor.getInt(0);
    this.eDC = paramCursor.getInt(1);
    this.eDD = paramCursor.getInt(2);
    this.eDE = paramCursor.getInt(3);
    this.eDF = paramCursor.getInt(4);
    this.eDG = paramCursor.getInt(5);
    this.eDH = paramCursor.getInt(6);
    this.eDI = paramCursor.getInt(7);
    this.eDJ = paramCursor.getInt(8);
    this.eDK = paramCursor.getInt(9);
    this.eDL = paramCursor.getInt(10);
    this.eDM = paramCursor.getInt(11);
    this.eDN = paramCursor.getInt(12);
    this.eDO = paramCursor.getInt(13);
    this.eDP = paramCursor.getInt(14);
    this.eDQ = paramCursor.getInt(15);
    this.eDR = paramCursor.getInt(16);
    this.eDS = paramCursor.getInt(17);
    this.eDT = paramCursor.getInt(18);
    this.eDU = paramCursor.getInt(19);
    this.eDV = paramCursor.getInt(20);
    this.eDW = paramCursor.getInt(21);
    this.eDX = paramCursor.getInt(22);
    this.eDY = paramCursor.getInt(23);
    this.eDZ = paramCursor.getInt(24);
    this.eEa = paramCursor.getInt(25);
    this.eEb = paramCursor.getInt(26);
    this.eEc = paramCursor.getInt(27);
    this.eEd = paramCursor.getInt(28);
    this.eEe = paramCursor.getInt(29);
  }
  
  public final String toString()
  {
    return String.format(FORMAT, new Object[] { Integer.valueOf(this.eDL), Integer.valueOf(this.eEb), Integer.valueOf(this.eDN), Integer.valueOf(this.eDX), Integer.valueOf(this.eEd), Integer.valueOf(this.eDZ), Integer.valueOf(this.eDM), Integer.valueOf(this.eEc), Integer.valueOf(this.eDO), Integer.valueOf(this.eDY), Integer.valueOf(this.eEe), Integer.valueOf(this.eEa), Integer.valueOf(this.eDD), Integer.valueOf(this.eDE), Integer.valueOf(this.eDP), Integer.valueOf(this.eDQ), Integer.valueOf(this.eDF), Integer.valueOf(this.eDG), Integer.valueOf(this.eDR), Integer.valueOf(this.eDS), Integer.valueOf(this.eDH), Integer.valueOf(this.eDI), Integer.valueOf(this.eDT), Integer.valueOf(this.eDU), Integer.valueOf(this.eDJ), Integer.valueOf(this.eDK), Integer.valueOf(this.eDV), Integer.valueOf(this.eDW) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.modelstat.k
 * JD-Core Version:    0.7.0.1
 */
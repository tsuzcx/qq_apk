package com.tencent.mm.plugin.masssend.a;

import android.database.Cursor;

public final class a
{
  int bcw = -1;
  public int bvi = 0;
  public long createTime = 0L;
  String dXm = "";
  String dXn = "";
  String eAX = "";
  int eHD = 0;
  long eHF = 0L;
  public String filename = "";
  String maE = "";
  public String maF = "";
  public int maG = 0;
  public int maH = 0;
  int maI = 0;
  int maJ = 0;
  public int maK = 0;
  public int msgType = 0;
  int status = 0;
  public int videoSource = 0;
  
  public final String bgV()
  {
    if (this.eAX == null) {
      return "";
    }
    return this.eAX;
  }
  
  public final String bgW()
  {
    if (this.filename == null) {
      return "";
    }
    return this.filename;
  }
  
  public final String bgX()
  {
    if (this.maE == null) {
      return "";
    }
    return this.maE;
  }
  
  public final String bgY()
  {
    if (this.maF == null) {
      return "";
    }
    return this.maF;
  }
  
  public final void d(Cursor paramCursor)
  {
    this.eAX = paramCursor.getString(0);
    this.status = paramCursor.getInt(1);
    this.createTime = paramCursor.getLong(2);
    this.eHF = paramCursor.getLong(3);
    this.filename = paramCursor.getString(4);
    this.maE = paramCursor.getString(5);
    this.maF = paramCursor.getString(6);
    this.maG = paramCursor.getInt(7);
    this.msgType = paramCursor.getInt(8);
    this.maH = paramCursor.getInt(9);
    this.maI = paramCursor.getInt(10);
    this.bvi = paramCursor.getInt(11);
    this.eHD = paramCursor.getInt(12);
    this.maJ = paramCursor.getInt(13);
    this.videoSource = paramCursor.getInt(14);
    this.maK = paramCursor.getInt(15);
    this.dXm = paramCursor.getString(16);
    this.dXn = paramCursor.getString(17);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.a.a
 * JD-Core Version:    0.7.0.1
 */
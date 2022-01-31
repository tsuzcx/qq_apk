package com.tencent.mm.ag;

import android.content.ContentValues;

public final class f
{
  int bcw = -1;
  int ebH;
  int ebI;
  String ebJ;
  int ebK;
  int ebL;
  int ebM;
  String ebN;
  String ebO;
  int ebP;
  int ebQ;
  String username;
  
  public f()
  {
    reset();
  }
  
  public final String JV()
  {
    if (this.ebJ == null) {
      return "";
    }
    return this.ebJ;
  }
  
  public final void reset()
  {
    this.username = "";
    this.ebH = 0;
    this.ebI = 0;
    this.ebJ = "";
    this.ebK = 0;
    this.ebL = 0;
    this.ebM = 0;
    this.ebN = "";
    this.ebO = "";
    this.ebP = 0;
    this.ebQ = 0;
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if ((this.bcw & 0x1) != 0)
    {
      if (this.username == null)
      {
        str = "";
        localContentValues.put("username", str);
      }
    }
    else
    {
      if ((this.bcw & 0x2) != 0) {
        localContentValues.put("imgwidth", Integer.valueOf(this.ebH));
      }
      if ((this.bcw & 0x4) != 0) {
        localContentValues.put("imgheigth", Integer.valueOf(this.ebI));
      }
      if ((this.bcw & 0x8) != 0) {
        localContentValues.put("imgformat", JV());
      }
      if ((this.bcw & 0x10) != 0) {
        localContentValues.put("totallen", Integer.valueOf(this.ebK));
      }
      if ((this.bcw & 0x20) != 0) {
        localContentValues.put("startpos", Integer.valueOf(this.ebL));
      }
      if ((this.bcw & 0x40) != 0) {
        localContentValues.put("headimgtype", Integer.valueOf(this.ebM));
      }
      if ((this.bcw & 0x80) != 0)
      {
        if (this.ebN != null) {
          break label281;
        }
        str = "";
        label188:
        localContentValues.put("reserved1", str);
      }
      if ((this.bcw & 0x100) != 0) {
        if (this.ebO != null) {
          break label289;
        }
      }
    }
    label281:
    label289:
    for (String str = "";; str = this.ebO)
    {
      localContentValues.put("reserved2", str);
      if ((this.bcw & 0x200) != 0) {
        localContentValues.put("reserved3", Integer.valueOf(this.ebP));
      }
      if ((this.bcw & 0x400) != 0) {
        localContentValues.put("reserved4", Integer.valueOf(this.ebQ));
      }
      return localContentValues;
      str = this.username;
      break;
      str = this.ebN;
      break label188;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ag.f
 * JD-Core Version:    0.7.0.1
 */
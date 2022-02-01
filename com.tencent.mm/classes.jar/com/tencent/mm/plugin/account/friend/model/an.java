package com.tencent.mm.plugin.account.friend.model;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class an
{
  int eQp;
  int pTM;
  int pTN;
  int pTO;
  int pTP;
  int pTQ;
  int pTR;
  String pTS;
  String pTT;
  
  public an()
  {
    AppMethodBeat.i(131154);
    this.eQp = -1;
    this.pTM = 0;
    this.pTN = 0;
    this.pTO = 0;
    this.pTP = 0;
    this.pTQ = 0;
    this.pTR = 0;
    this.pTS = "";
    this.pTT = "";
    AppMethodBeat.o(131154);
  }
  
  public final ContentValues bXp()
  {
    AppMethodBeat.i(131156);
    ContentValues localContentValues = new ContentValues();
    if ((this.eQp & 0x1) != 0) {
      localContentValues.put("grouopid", Integer.valueOf(this.pTM));
    }
    if ((this.eQp & 0x2) != 0) {
      localContentValues.put("membernum", Integer.valueOf(this.pTN));
    }
    if ((this.eQp & 0x4) != 0) {
      localContentValues.put("weixinnum", Integer.valueOf(this.pTO));
    }
    if ((this.eQp & 0x8) != 0) {
      localContentValues.put("insert_time", Integer.valueOf(this.pTP));
    }
    if ((this.eQp & 0x10) != 0) {
      localContentValues.put("lastupdate_time", Integer.valueOf(this.pTQ));
    }
    if ((this.eQp & 0x20) != 0) {
      localContentValues.put("needupdate", Integer.valueOf(this.pTR));
    }
    if ((this.eQp & 0x40) != 0) {
      localContentValues.put("updatekey", bXq());
    }
    if ((this.eQp & 0x80) != 0) {
      localContentValues.put("groupname", bXr());
    }
    AppMethodBeat.o(131156);
    return localContentValues;
  }
  
  public final String bXq()
  {
    if (this.pTS == null) {
      return "";
    }
    return this.pTS;
  }
  
  public final String bXr()
  {
    if (this.pTT == null) {
      return "";
    }
    return this.pTT;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(131155);
    this.pTM = paramCursor.getInt(0);
    this.pTN = paramCursor.getInt(1);
    this.pTO = paramCursor.getInt(2);
    this.pTP = paramCursor.getInt(3);
    this.pTQ = paramCursor.getInt(4);
    this.pTR = paramCursor.getInt(5);
    this.pTS = paramCursor.getString(6);
    this.pTT = paramCursor.getString(7);
    AppMethodBeat.o(131155);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.model.an
 * JD-Core Version:    0.7.0.1
 */
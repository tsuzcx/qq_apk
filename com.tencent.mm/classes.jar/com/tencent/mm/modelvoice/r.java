package com.tencent.mm.modelvoice;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.fzd;

public final class r
{
  public String clientId;
  public long createTime;
  public int eQp;
  public String fileName;
  public long hTh;
  public String hVQ;
  int jUq;
  String jUr;
  public int oZm;
  public int osy;
  public String paV;
  public int paX;
  public long pba;
  public int pbc;
  int pbd;
  String pdj;
  int pdq;
  public int peH;
  int peI;
  long peJ;
  int peK;
  public int peL;
  fzd peM;
  public int status;
  
  public r()
  {
    AppMethodBeat.i(148454);
    this.eQp = -1;
    this.pdq = 0;
    this.fileName = "";
    this.hVQ = "";
    this.clientId = "";
    this.hTh = 0L;
    this.oZm = 0;
    this.paX = 0;
    this.osy = 0;
    this.status = 0;
    this.createTime = 0L;
    this.pba = 0L;
    this.peH = 0;
    this.pbc = 0;
    this.paV = "";
    this.pbd = 0;
    this.pdj = "";
    this.jUr = "";
    this.jUq = 0;
    this.peI = 0;
    this.peJ = 0L;
    this.peK = 0;
    this.peL = 0;
    this.peM = null;
    AppMethodBeat.o(148454);
  }
  
  public final boolean bPj()
  {
    return (this.status == 5) || (this.status == 6);
  }
  
  public final boolean bPk()
  {
    return ((this.status > 1) && (this.status <= 3)) || (this.status == 8);
  }
  
  public final boolean bPl()
  {
    return (this.peL & 0x1) != 0;
  }
  
  public final void convertFrom(Cursor paramCursor)
  {
    AppMethodBeat.i(148453);
    this.fileName = paramCursor.getString(0);
    this.hVQ = paramCursor.getString(1);
    this.hTh = paramCursor.getLong(2);
    this.oZm = paramCursor.getInt(3);
    this.paX = paramCursor.getInt(4);
    this.osy = paramCursor.getInt(5);
    this.status = paramCursor.getInt(6);
    this.createTime = paramCursor.getLong(7);
    this.pba = paramCursor.getLong(8);
    this.clientId = paramCursor.getString(9);
    this.peH = paramCursor.getInt(10);
    this.pbc = paramCursor.getInt(11);
    this.paV = paramCursor.getString(12);
    this.pbd = paramCursor.getInt(13);
    this.pdj = paramCursor.getString(14);
    this.jUr = paramCursor.getString(15);
    this.jUq = paramCursor.getInt(16);
    this.peI = paramCursor.getInt(17);
    this.peJ = paramCursor.getLong(18);
    this.peK = paramCursor.getInt(19);
    this.peL = paramCursor.getInt(20);
    try
    {
      paramCursor = paramCursor.getBlob(21);
      if (paramCursor != null)
      {
        fzd localfzd = new fzd();
        localfzd.parseFrom(paramCursor);
        this.peM = localfzd;
      }
      AppMethodBeat.o(148453);
      return;
    }
    catch (Exception paramCursor)
    {
      AppMethodBeat.o(148453);
    }
  }
  
  public final ContentValues convertTo()
  {
    AppMethodBeat.i(148452);
    ContentValues localContentValues = new ContentValues();
    if ((this.eQp & 0x1) != 0) {
      localContentValues.put("FileName", this.fileName);
    }
    if ((this.eQp & 0x2) != 0) {
      localContentValues.put("User", this.hVQ);
    }
    if ((this.eQp & 0x4) != 0) {
      localContentValues.put("MsgId", Long.valueOf(this.hTh));
    }
    if ((this.eQp & 0x8) != 0) {
      localContentValues.put("NetOffset", Integer.valueOf(this.oZm));
    }
    if ((this.eQp & 0x10) != 0) {
      localContentValues.put("FileNowSize", Integer.valueOf(this.paX));
    }
    if ((this.eQp & 0x20) != 0) {
      localContentValues.put("TotalLen", Integer.valueOf(this.osy));
    }
    if ((this.eQp & 0x40) != 0) {
      localContentValues.put("Status", Integer.valueOf(this.status));
    }
    if ((this.eQp & 0x80) != 0) {
      localContentValues.put("CreateTime", Long.valueOf(this.createTime));
    }
    if ((this.eQp & 0x100) != 0) {
      localContentValues.put("LastModifyTime", Long.valueOf(this.pba));
    }
    if ((this.eQp & 0x200) != 0) {
      localContentValues.put("ClientId", this.clientId);
    }
    if ((this.eQp & 0x400) != 0) {
      localContentValues.put("VoiceLength", Integer.valueOf(this.peH));
    }
    if ((this.eQp & 0x800) != 0) {
      localContentValues.put("MsgLocalId", Integer.valueOf(this.pbc));
    }
    if ((this.eQp & 0x1000) != 0) {
      localContentValues.put("Human", this.paV);
    }
    if ((this.eQp & 0x2000) != 0) {
      localContentValues.put("reserved1", Integer.valueOf(this.pbd));
    }
    if ((this.eQp & 0x4000) != 0) {
      localContentValues.put("reserved2", this.pdj);
    }
    if ((this.eQp & 0x8000) != 0) {
      localContentValues.put("MsgSource", this.jUr);
    }
    if ((this.eQp & 0x10000) != 0) {
      localContentValues.put("MsgFlag", Integer.valueOf(this.jUq));
    }
    if ((this.eQp & 0x20000) != 0) {
      localContentValues.put("MsgSeq", Integer.valueOf(this.peI));
    }
    if ((this.eQp & 0x40000) != 0) {
      localContentValues.put("MasterBufId", Long.valueOf(this.peJ));
    }
    if ((this.eQp & 0x80000) != 0) {
      localContentValues.put("checksum", Integer.valueOf(this.peK));
    }
    if ((this.eQp & 0x100000) != 0) {
      localContentValues.put("VoiceFlag", Integer.valueOf(this.peL));
    }
    if (((this.eQp & 0x200000) != 0) && (this.peM != null)) {}
    try
    {
      localContentValues.put("VoiceInfoExt", this.peM.toByteArray());
      label513:
      AppMethodBeat.o(148452);
      return localContentValues;
    }
    catch (Exception localException)
    {
      break label513;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.modelvoice.r
 * JD-Core Version:    0.7.0.1
 */
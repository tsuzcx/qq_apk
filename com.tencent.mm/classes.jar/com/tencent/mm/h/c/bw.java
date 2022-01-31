package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bw
  extends c
{
  private static final int cKX;
  private static final int cKY;
  private static final int cKZ;
  private static final int cLa;
  private static final int cLb;
  private static final int cLc;
  private static final int cLd;
  private static final int cLe = "receiveTime".hashCode();
  public static final String[] cqY = new String[0];
  private static final int crL;
  private static final int crg = "msgId".hashCode();
  private static final int crh = "rowid".hashCode();
  private static final int csv;
  private static final int ctl;
  private static final int cxe;
  private static final int czp;
  private boolean cKP = true;
  private boolean cKQ = true;
  private boolean cKR = true;
  private boolean cKS = true;
  private boolean cKT = true;
  private boolean cKU = true;
  private boolean cKV = true;
  private boolean cKW = true;
  private boolean crH = true;
  private boolean crX = true;
  private boolean crc = true;
  private boolean csU = true;
  private boolean cwQ = true;
  private boolean cze = true;
  public String field_appId;
  public long field_createTime;
  public long field_expireTime;
  public String field_gameMsgId;
  public boolean field_isHidden;
  public boolean field_isRead;
  public String field_label;
  public String field_mergerId;
  public long field_msgId;
  public int field_msgType;
  public String field_rawXML;
  public long field_receiveTime;
  public boolean field_showInMsgList;
  public String field_weight;
  
  static
  {
    cKX = "mergerId".hashCode();
    cKY = "gameMsgId".hashCode();
    cxe = "msgType".hashCode();
    csv = "createTime".hashCode();
    cKZ = "expireTime".hashCode();
    ctl = "appId".hashCode();
    cLa = "showInMsgList".hashCode();
    czp = "isRead".hashCode();
    cLb = "label".hashCode();
    cLc = "isHidden".hashCode();
    cLd = "weight".hashCode();
    crL = "rawXML".hashCode();
  }
  
  public final void d(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {
      return;
    }
    int j = arrayOfString.length;
    int i = 0;
    label20:
    int k;
    if (i < j)
    {
      k = arrayOfString[i].hashCode();
      if (crg != k) {
        break label65;
      }
      this.field_msgId = paramCursor.getLong(i);
      this.crc = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (cKX == k)
      {
        this.field_mergerId = paramCursor.getString(i);
      }
      else if (cKY == k)
      {
        this.field_gameMsgId = paramCursor.getString(i);
      }
      else if (cxe == k)
      {
        this.field_msgType = paramCursor.getInt(i);
      }
      else if (csv == k)
      {
        this.field_createTime = paramCursor.getLong(i);
      }
      else if (cKZ == k)
      {
        this.field_expireTime = paramCursor.getLong(i);
      }
      else if (ctl == k)
      {
        this.field_appId = paramCursor.getString(i);
      }
      else
      {
        boolean bool;
        if (cLa == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_showInMsgList = bool;
            break;
          }
        }
        if (czp == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_isRead = bool;
            break;
          }
        }
        if (cLb == k)
        {
          this.field_label = paramCursor.getString(i);
        }
        else
        {
          if (cLc == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_isHidden = bool;
              break;
            }
          }
          if (cLd == k) {
            this.field_weight = paramCursor.getString(i);
          } else if (crL == k) {
            this.field_rawXML = paramCursor.getString(i);
          } else if (cLe == k) {
            this.field_receiveTime = paramCursor.getLong(i);
          } else if (crh == k) {
            this.ujK = paramCursor.getLong(i);
          }
        }
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.crc) {
      localContentValues.put("msgId", Long.valueOf(this.field_msgId));
    }
    if (this.cKP) {
      localContentValues.put("mergerId", this.field_mergerId);
    }
    if (this.cKQ) {
      localContentValues.put("gameMsgId", this.field_gameMsgId);
    }
    if (this.cwQ) {
      localContentValues.put("msgType", Integer.valueOf(this.field_msgType));
    }
    if (this.crX) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.cKR) {
      localContentValues.put("expireTime", Long.valueOf(this.field_expireTime));
    }
    if (this.csU) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.cKS) {
      localContentValues.put("showInMsgList", Boolean.valueOf(this.field_showInMsgList));
    }
    if (this.cze) {
      localContentValues.put("isRead", Boolean.valueOf(this.field_isRead));
    }
    if (this.field_label == null) {
      this.field_label = "";
    }
    if (this.cKT) {
      localContentValues.put("label", this.field_label);
    }
    if (this.cKU) {
      localContentValues.put("isHidden", Boolean.valueOf(this.field_isHidden));
    }
    if (this.field_weight == null) {
      this.field_weight = "";
    }
    if (this.cKV) {
      localContentValues.put("weight", this.field_weight);
    }
    if (this.field_rawXML == null) {
      this.field_rawXML = "";
    }
    if (this.crH) {
      localContentValues.put("rawXML", this.field_rawXML);
    }
    if (this.cKW) {
      localContentValues.put("receiveTime", Long.valueOf(this.field_receiveTime));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.h.c.bw
 * JD-Core Version:    0.7.0.1
 */
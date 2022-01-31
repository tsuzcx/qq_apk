package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cb
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dAL;
  private static final int dAM;
  private static final int dAN;
  private static final int dAO;
  private static final int dAP;
  private static final int dAQ;
  private static final int dAR;
  private static final int dAS = "receiveTime".hashCode();
  private static final int dfD = "msgId".hashCode();
  private static final int dgM;
  private static final int dgf;
  private static final int dhB;
  private static final int dlf;
  private static final int dnq;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dAD = true;
  private boolean dAE = true;
  private boolean dAF = true;
  private boolean dAG = true;
  private boolean dAH = true;
  private boolean dAI = true;
  private boolean dAJ = true;
  private boolean dAK = true;
  private boolean dfz = true;
  private boolean dgb = true;
  private boolean dgp = true;
  private boolean dhk = true;
  private boolean dkR = true;
  private boolean dnf = true;
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
    dAL = "mergerId".hashCode();
    dAM = "gameMsgId".hashCode();
    dlf = "msgType".hashCode();
    dgM = "createTime".hashCode();
    dAN = "expireTime".hashCode();
    dhB = "appId".hashCode();
    dAO = "showInMsgList".hashCode();
    dnq = "isRead".hashCode();
    dAP = "label".hashCode();
    dAQ = "isHidden".hashCode();
    dAR = "weight".hashCode();
    dgf = "rawXML".hashCode();
  }
  
  public void convertFrom(Cursor paramCursor)
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
      if (dfD != k) {
        break label65;
      }
      this.field_msgId = paramCursor.getLong(i);
      this.dfz = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dAL == k)
      {
        this.field_mergerId = paramCursor.getString(i);
      }
      else if (dAM == k)
      {
        this.field_gameMsgId = paramCursor.getString(i);
      }
      else if (dlf == k)
      {
        this.field_msgType = paramCursor.getInt(i);
      }
      else if (dgM == k)
      {
        this.field_createTime = paramCursor.getLong(i);
      }
      else if (dAN == k)
      {
        this.field_expireTime = paramCursor.getLong(i);
      }
      else if (dhB == k)
      {
        this.field_appId = paramCursor.getString(i);
      }
      else
      {
        boolean bool;
        if (dAO == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_showInMsgList = bool;
            break;
          }
        }
        if (dnq == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_isRead = bool;
            break;
          }
        }
        if (dAP == k)
        {
          this.field_label = paramCursor.getString(i);
        }
        else
        {
          if (dAQ == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_isHidden = bool;
              break;
            }
          }
          if (dAR == k) {
            this.field_weight = paramCursor.getString(i);
          } else if (dgf == k) {
            this.field_rawXML = paramCursor.getString(i);
          } else if (dAS == k) {
            this.field_receiveTime = paramCursor.getLong(i);
          } else if (rowid_HASHCODE == k) {
            this.systemRowid = paramCursor.getLong(i);
          }
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dfz) {
      localContentValues.put("msgId", Long.valueOf(this.field_msgId));
    }
    if (this.dAD) {
      localContentValues.put("mergerId", this.field_mergerId);
    }
    if (this.dAE) {
      localContentValues.put("gameMsgId", this.field_gameMsgId);
    }
    if (this.dkR) {
      localContentValues.put("msgType", Integer.valueOf(this.field_msgType));
    }
    if (this.dgp) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.dAF) {
      localContentValues.put("expireTime", Long.valueOf(this.field_expireTime));
    }
    if (this.dhk) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.dAG) {
      localContentValues.put("showInMsgList", Boolean.valueOf(this.field_showInMsgList));
    }
    if (this.dnf) {
      localContentValues.put("isRead", Boolean.valueOf(this.field_isRead));
    }
    if (this.field_label == null) {
      this.field_label = "";
    }
    if (this.dAH) {
      localContentValues.put("label", this.field_label);
    }
    if (this.dAI) {
      localContentValues.put("isHidden", Boolean.valueOf(this.field_isHidden));
    }
    if (this.field_weight == null) {
      this.field_weight = "";
    }
    if (this.dAJ) {
      localContentValues.put("weight", this.field_weight);
    }
    if (this.field_rawXML == null) {
      this.field_rawXML = "";
    }
    if (this.dgb) {
      localContentValues.put("rawXML", this.field_rawXML);
    }
    if (this.dAK) {
      localContentValues.put("receiveTime", Long.valueOf(this.field_receiveTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.c.cb
 * JD-Core Version:    0.7.0.1
 */
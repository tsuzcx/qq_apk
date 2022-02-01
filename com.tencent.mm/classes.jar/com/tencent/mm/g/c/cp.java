package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cp
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eKA;
  private static final int eKB = "receiveTime".hashCode();
  private static final int eKC = "showType".hashCode();
  private static final int eKD = "interactiveMergeId".hashCode();
  private static final int eKE = "hasMergedCount".hashCode();
  private static final int eKu;
  private static final int eKv;
  private static final int eKw;
  private static final int eKx;
  private static final int eKy;
  private static final int eKz;
  private static final int elP = "msgId".hashCode();
  private static final int emY;
  private static final int emr;
  private static final int enO;
  private static final int erH;
  private static final int eug;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eKj = true;
  private boolean eKk = true;
  private boolean eKl = true;
  private boolean eKm = true;
  private boolean eKn = true;
  private boolean eKo = true;
  private boolean eKp = true;
  private boolean eKq = true;
  private boolean eKr = true;
  private boolean eKs = true;
  private boolean eKt = true;
  private boolean elL = true;
  private boolean emB = true;
  private boolean emn = true;
  private boolean enx = true;
  private boolean ers = true;
  private boolean etS = true;
  public String field_appId;
  public long field_createTime;
  public long field_expireTime;
  public String field_gameMsgId;
  public int field_hasMergedCount;
  public String field_interactiveMergeId;
  public boolean field_isHidden;
  public boolean field_isRead;
  public String field_label;
  public String field_mergerId;
  public long field_msgId;
  public int field_msgType;
  public String field_rawXML;
  public long field_receiveTime;
  public boolean field_showInMsgList;
  public int field_showType;
  public String field_weight;
  
  static
  {
    eKu = "mergerId".hashCode();
    eKv = "gameMsgId".hashCode();
    erH = "msgType".hashCode();
    emY = "createTime".hashCode();
    eKw = "expireTime".hashCode();
    enO = "appId".hashCode();
    eKx = "showInMsgList".hashCode();
    eug = "isRead".hashCode();
    eKy = "label".hashCode();
    eKz = "isHidden".hashCode();
    eKA = "weight".hashCode();
    emr = "rawXML".hashCode();
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
      if (elP != k) {
        break label65;
      }
      this.field_msgId = paramCursor.getLong(i);
      this.elL = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eKu == k)
      {
        this.field_mergerId = paramCursor.getString(i);
      }
      else if (eKv == k)
      {
        this.field_gameMsgId = paramCursor.getString(i);
      }
      else if (erH == k)
      {
        this.field_msgType = paramCursor.getInt(i);
      }
      else if (emY == k)
      {
        this.field_createTime = paramCursor.getLong(i);
      }
      else if (eKw == k)
      {
        this.field_expireTime = paramCursor.getLong(i);
      }
      else if (enO == k)
      {
        this.field_appId = paramCursor.getString(i);
      }
      else
      {
        boolean bool;
        if (eKx == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_showInMsgList = bool;
            break;
          }
        }
        if (eug == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_isRead = bool;
            break;
          }
        }
        if (eKy == k)
        {
          this.field_label = paramCursor.getString(i);
        }
        else
        {
          if (eKz == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_isHidden = bool;
              break;
            }
          }
          if (eKA == k) {
            this.field_weight = paramCursor.getString(i);
          } else if (emr == k) {
            this.field_rawXML = paramCursor.getString(i);
          } else if (eKB == k) {
            this.field_receiveTime = paramCursor.getLong(i);
          } else if (eKC == k) {
            this.field_showType = paramCursor.getInt(i);
          } else if (eKD == k) {
            this.field_interactiveMergeId = paramCursor.getString(i);
          } else if (eKE == k) {
            this.field_hasMergedCount = paramCursor.getInt(i);
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
    if (this.elL) {
      localContentValues.put("msgId", Long.valueOf(this.field_msgId));
    }
    if (this.eKj) {
      localContentValues.put("mergerId", this.field_mergerId);
    }
    if (this.eKk) {
      localContentValues.put("gameMsgId", this.field_gameMsgId);
    }
    if (this.ers) {
      localContentValues.put("msgType", Integer.valueOf(this.field_msgType));
    }
    if (this.emB) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.eKl) {
      localContentValues.put("expireTime", Long.valueOf(this.field_expireTime));
    }
    if (this.enx) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.eKm) {
      localContentValues.put("showInMsgList", Boolean.valueOf(this.field_showInMsgList));
    }
    if (this.etS) {
      localContentValues.put("isRead", Boolean.valueOf(this.field_isRead));
    }
    if (this.field_label == null) {
      this.field_label = "";
    }
    if (this.eKn) {
      localContentValues.put("label", this.field_label);
    }
    if (this.eKo) {
      localContentValues.put("isHidden", Boolean.valueOf(this.field_isHidden));
    }
    if (this.field_weight == null) {
      this.field_weight = "";
    }
    if (this.eKp) {
      localContentValues.put("weight", this.field_weight);
    }
    if (this.field_rawXML == null) {
      this.field_rawXML = "";
    }
    if (this.emn) {
      localContentValues.put("rawXML", this.field_rawXML);
    }
    if (this.eKq) {
      localContentValues.put("receiveTime", Long.valueOf(this.field_receiveTime));
    }
    if (this.eKr) {
      localContentValues.put("showType", Integer.valueOf(this.field_showType));
    }
    if (this.field_interactiveMergeId == null) {
      this.field_interactiveMergeId = "";
    }
    if (this.eKs) {
      localContentValues.put("interactiveMergeId", this.field_interactiveMergeId);
    }
    if (this.eKt) {
      localContentValues.put("hasMergedCount", Integer.valueOf(this.field_hasMergedCount));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.cp
 * JD-Core Version:    0.7.0.1
 */
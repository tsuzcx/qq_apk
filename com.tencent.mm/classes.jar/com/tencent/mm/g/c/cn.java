package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cn
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eHC;
  private static final int eHD;
  private static final int eHE;
  private static final int eHF;
  private static final int eHG;
  private static final int eHH;
  private static final int eHI;
  private static final int eHJ = "receiveTime".hashCode();
  private static final int eHK = "showType".hashCode();
  private static final int eHL = "interactiveMergeId".hashCode();
  private static final int eHM = "hasMergedCount".hashCode();
  private static final int ejL = "msgId".hashCode();
  private static final int ekU;
  private static final int ekn;
  private static final int elJ;
  private static final int epD;
  private static final int esc;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eHA = true;
  private boolean eHB = true;
  private boolean eHr = true;
  private boolean eHs = true;
  private boolean eHt = true;
  private boolean eHu = true;
  private boolean eHv = true;
  private boolean eHw = true;
  private boolean eHx = true;
  private boolean eHy = true;
  private boolean eHz = true;
  private boolean ejH = true;
  private boolean ekj = true;
  private boolean ekx = true;
  private boolean els = true;
  private boolean epo = true;
  private boolean erO = true;
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
    eHC = "mergerId".hashCode();
    eHD = "gameMsgId".hashCode();
    epD = "msgType".hashCode();
    ekU = "createTime".hashCode();
    eHE = "expireTime".hashCode();
    elJ = "appId".hashCode();
    eHF = "showInMsgList".hashCode();
    esc = "isRead".hashCode();
    eHG = "label".hashCode();
    eHH = "isHidden".hashCode();
    eHI = "weight".hashCode();
    ekn = "rawXML".hashCode();
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
      if (ejL != k) {
        break label65;
      }
      this.field_msgId = paramCursor.getLong(i);
      this.ejH = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eHC == k)
      {
        this.field_mergerId = paramCursor.getString(i);
      }
      else if (eHD == k)
      {
        this.field_gameMsgId = paramCursor.getString(i);
      }
      else if (epD == k)
      {
        this.field_msgType = paramCursor.getInt(i);
      }
      else if (ekU == k)
      {
        this.field_createTime = paramCursor.getLong(i);
      }
      else if (eHE == k)
      {
        this.field_expireTime = paramCursor.getLong(i);
      }
      else if (elJ == k)
      {
        this.field_appId = paramCursor.getString(i);
      }
      else
      {
        boolean bool;
        if (eHF == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_showInMsgList = bool;
            break;
          }
        }
        if (esc == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_isRead = bool;
            break;
          }
        }
        if (eHG == k)
        {
          this.field_label = paramCursor.getString(i);
        }
        else
        {
          if (eHH == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_isHidden = bool;
              break;
            }
          }
          if (eHI == k) {
            this.field_weight = paramCursor.getString(i);
          } else if (ekn == k) {
            this.field_rawXML = paramCursor.getString(i);
          } else if (eHJ == k) {
            this.field_receiveTime = paramCursor.getLong(i);
          } else if (eHK == k) {
            this.field_showType = paramCursor.getInt(i);
          } else if (eHL == k) {
            this.field_interactiveMergeId = paramCursor.getString(i);
          } else if (eHM == k) {
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
    if (this.ejH) {
      localContentValues.put("msgId", Long.valueOf(this.field_msgId));
    }
    if (this.eHr) {
      localContentValues.put("mergerId", this.field_mergerId);
    }
    if (this.eHs) {
      localContentValues.put("gameMsgId", this.field_gameMsgId);
    }
    if (this.epo) {
      localContentValues.put("msgType", Integer.valueOf(this.field_msgType));
    }
    if (this.ekx) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.eHt) {
      localContentValues.put("expireTime", Long.valueOf(this.field_expireTime));
    }
    if (this.els) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.eHu) {
      localContentValues.put("showInMsgList", Boolean.valueOf(this.field_showInMsgList));
    }
    if (this.erO) {
      localContentValues.put("isRead", Boolean.valueOf(this.field_isRead));
    }
    if (this.field_label == null) {
      this.field_label = "";
    }
    if (this.eHv) {
      localContentValues.put("label", this.field_label);
    }
    if (this.eHw) {
      localContentValues.put("isHidden", Boolean.valueOf(this.field_isHidden));
    }
    if (this.field_weight == null) {
      this.field_weight = "";
    }
    if (this.eHx) {
      localContentValues.put("weight", this.field_weight);
    }
    if (this.field_rawXML == null) {
      this.field_rawXML = "";
    }
    if (this.ekj) {
      localContentValues.put("rawXML", this.field_rawXML);
    }
    if (this.eHy) {
      localContentValues.put("receiveTime", Long.valueOf(this.field_receiveTime));
    }
    if (this.eHz) {
      localContentValues.put("showType", Integer.valueOf(this.field_showType));
    }
    if (this.field_interactiveMergeId == null) {
      this.field_interactiveMergeId = "";
    }
    if (this.eHA) {
      localContentValues.put("interactiveMergeId", this.field_interactiveMergeId);
    }
    if (this.eHB) {
      localContentValues.put("hasMergedCount", Integer.valueOf(this.field_hasMergedCount));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.cn
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cy
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eCW = "msgId".hashCode();
  private static final int eDy = "rawXML".hashCode();
  private static final int eEU;
  private static final int eEf;
  private static final int eIQ;
  private static final int eLo;
  private static final int fcO = "mergerId".hashCode();
  private static final int fcP = "gameMsgId".hashCode();
  private static final int fcQ;
  private static final int fcR;
  private static final int fcS;
  private static final int fcT;
  private static final int fcU;
  private static final int fcV = "receiveTime".hashCode();
  private static final int fcW = "showType".hashCode();
  private static final int fcX = "interactiveMergeId".hashCode();
  private static final int fcY = "hasMergedCount".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eCS = true;
  private boolean eDI = true;
  private boolean eDu = true;
  private boolean eED = true;
  private boolean eIB = true;
  private boolean eLb = true;
  private boolean fcD = true;
  private boolean fcE = true;
  private boolean fcF = true;
  private boolean fcG = true;
  private boolean fcH = true;
  private boolean fcI = true;
  private boolean fcJ = true;
  private boolean fcK = true;
  private boolean fcL = true;
  private boolean fcM = true;
  private boolean fcN = true;
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
    eIQ = "msgType".hashCode();
    eEf = "createTime".hashCode();
    fcQ = "expireTime".hashCode();
    eEU = "appId".hashCode();
    fcR = "showInMsgList".hashCode();
    eLo = "isRead".hashCode();
    fcS = "label".hashCode();
    fcT = "isHidden".hashCode();
    fcU = "weight".hashCode();
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
      if (eCW != k) {
        break label65;
      }
      this.field_msgId = paramCursor.getLong(i);
      this.eCS = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fcO == k)
      {
        this.field_mergerId = paramCursor.getString(i);
      }
      else if (fcP == k)
      {
        this.field_gameMsgId = paramCursor.getString(i);
      }
      else if (eIQ == k)
      {
        this.field_msgType = paramCursor.getInt(i);
      }
      else if (eEf == k)
      {
        this.field_createTime = paramCursor.getLong(i);
      }
      else if (fcQ == k)
      {
        this.field_expireTime = paramCursor.getLong(i);
      }
      else if (eEU == k)
      {
        this.field_appId = paramCursor.getString(i);
      }
      else
      {
        boolean bool;
        if (fcR == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_showInMsgList = bool;
            break;
          }
        }
        if (eLo == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_isRead = bool;
            break;
          }
        }
        if (fcS == k)
        {
          this.field_label = paramCursor.getString(i);
        }
        else
        {
          if (fcT == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_isHidden = bool;
              break;
            }
          }
          if (fcU == k) {
            this.field_weight = paramCursor.getString(i);
          } else if (eDy == k) {
            this.field_rawXML = paramCursor.getString(i);
          } else if (fcV == k) {
            this.field_receiveTime = paramCursor.getLong(i);
          } else if (fcW == k) {
            this.field_showType = paramCursor.getInt(i);
          } else if (fcX == k) {
            this.field_interactiveMergeId = paramCursor.getString(i);
          } else if (fcY == k) {
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
    if (this.eCS) {
      localContentValues.put("msgId", Long.valueOf(this.field_msgId));
    }
    if (this.fcD) {
      localContentValues.put("mergerId", this.field_mergerId);
    }
    if (this.fcE) {
      localContentValues.put("gameMsgId", this.field_gameMsgId);
    }
    if (this.eIB) {
      localContentValues.put("msgType", Integer.valueOf(this.field_msgType));
    }
    if (this.eDI) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.fcF) {
      localContentValues.put("expireTime", Long.valueOf(this.field_expireTime));
    }
    if (this.eED) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.fcG) {
      localContentValues.put("showInMsgList", Boolean.valueOf(this.field_showInMsgList));
    }
    if (this.eLb) {
      localContentValues.put("isRead", Boolean.valueOf(this.field_isRead));
    }
    if (this.field_label == null) {
      this.field_label = "";
    }
    if (this.fcH) {
      localContentValues.put("label", this.field_label);
    }
    if (this.fcI) {
      localContentValues.put("isHidden", Boolean.valueOf(this.field_isHidden));
    }
    if (this.field_weight == null) {
      this.field_weight = "";
    }
    if (this.fcJ) {
      localContentValues.put("weight", this.field_weight);
    }
    if (this.field_rawXML == null) {
      this.field_rawXML = "";
    }
    if (this.eDu) {
      localContentValues.put("rawXML", this.field_rawXML);
    }
    if (this.fcK) {
      localContentValues.put("receiveTime", Long.valueOf(this.field_receiveTime));
    }
    if (this.fcL) {
      localContentValues.put("showType", Integer.valueOf(this.field_showType));
    }
    if (this.field_interactiveMergeId == null) {
      this.field_interactiveMergeId = "";
    }
    if (this.fcM) {
      localContentValues.put("interactiveMergeId", this.field_interactiveMergeId);
    }
    if (this.fcN) {
      localContentValues.put("hasMergedCount", Integer.valueOf(this.field_hasMergedCount));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.cy
 * JD-Core Version:    0.7.0.1
 */
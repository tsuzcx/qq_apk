package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cy
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEF = "msgId".hashCode();
  private static final int eFO;
  private static final int eFh = "rawXML".hashCode();
  private static final int eGD;
  private static final int eKz;
  private static final int eMY;
  private static final int feG = "mergerId".hashCode();
  private static final int feH = "gameMsgId".hashCode();
  private static final int feI;
  private static final int feJ;
  private static final int feK;
  private static final int feL;
  private static final int feM;
  private static final int feN = "receiveTime".hashCode();
  private static final int feO = "showType".hashCode();
  private static final int feP = "interactiveMergeId".hashCode();
  private static final int feQ = "hasMergedCount".hashCode();
  private static final int feR = "redDotExpireTime".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eEB = true;
  private boolean eFd = true;
  private boolean eFr = true;
  private boolean eGm = true;
  private boolean eKk = true;
  private boolean eMK = true;
  private boolean feA = true;
  private boolean feB = true;
  private boolean feC = true;
  private boolean feD = true;
  private boolean feE = true;
  private boolean feF = true;
  private boolean feu = true;
  private boolean fev = true;
  private boolean few = true;
  private boolean fex = true;
  private boolean fey = true;
  private boolean fez = true;
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
  public long field_redDotExpireTime;
  public boolean field_showInMsgList;
  public int field_showType;
  public String field_weight;
  
  static
  {
    eKz = "msgType".hashCode();
    eFO = "createTime".hashCode();
    feI = "expireTime".hashCode();
    eGD = "appId".hashCode();
    feJ = "showInMsgList".hashCode();
    eMY = "isRead".hashCode();
    feK = "label".hashCode();
    feL = "isHidden".hashCode();
    feM = "weight".hashCode();
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
      if (eEF != k) {
        break label65;
      }
      this.field_msgId = paramCursor.getLong(i);
      this.eEB = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (feG == k)
      {
        this.field_mergerId = paramCursor.getString(i);
      }
      else if (feH == k)
      {
        this.field_gameMsgId = paramCursor.getString(i);
      }
      else if (eKz == k)
      {
        this.field_msgType = paramCursor.getInt(i);
      }
      else if (eFO == k)
      {
        this.field_createTime = paramCursor.getLong(i);
      }
      else if (feI == k)
      {
        this.field_expireTime = paramCursor.getLong(i);
      }
      else if (eGD == k)
      {
        this.field_appId = paramCursor.getString(i);
      }
      else
      {
        boolean bool;
        if (feJ == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_showInMsgList = bool;
            break;
          }
        }
        if (eMY == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_isRead = bool;
            break;
          }
        }
        if (feK == k)
        {
          this.field_label = paramCursor.getString(i);
        }
        else
        {
          if (feL == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_isHidden = bool;
              break;
            }
          }
          if (feM == k) {
            this.field_weight = paramCursor.getString(i);
          } else if (eFh == k) {
            this.field_rawXML = paramCursor.getString(i);
          } else if (feN == k) {
            this.field_receiveTime = paramCursor.getLong(i);
          } else if (feO == k) {
            this.field_showType = paramCursor.getInt(i);
          } else if (feP == k) {
            this.field_interactiveMergeId = paramCursor.getString(i);
          } else if (feQ == k) {
            this.field_hasMergedCount = paramCursor.getInt(i);
          } else if (feR == k) {
            this.field_redDotExpireTime = paramCursor.getLong(i);
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
    if (this.eEB) {
      localContentValues.put("msgId", Long.valueOf(this.field_msgId));
    }
    if (this.feu) {
      localContentValues.put("mergerId", this.field_mergerId);
    }
    if (this.fev) {
      localContentValues.put("gameMsgId", this.field_gameMsgId);
    }
    if (this.eKk) {
      localContentValues.put("msgType", Integer.valueOf(this.field_msgType));
    }
    if (this.eFr) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.few) {
      localContentValues.put("expireTime", Long.valueOf(this.field_expireTime));
    }
    if (this.eGm) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.fex) {
      localContentValues.put("showInMsgList", Boolean.valueOf(this.field_showInMsgList));
    }
    if (this.eMK) {
      localContentValues.put("isRead", Boolean.valueOf(this.field_isRead));
    }
    if (this.field_label == null) {
      this.field_label = "";
    }
    if (this.fey) {
      localContentValues.put("label", this.field_label);
    }
    if (this.fez) {
      localContentValues.put("isHidden", Boolean.valueOf(this.field_isHidden));
    }
    if (this.field_weight == null) {
      this.field_weight = "";
    }
    if (this.feA) {
      localContentValues.put("weight", this.field_weight);
    }
    if (this.field_rawXML == null) {
      this.field_rawXML = "";
    }
    if (this.eFd) {
      localContentValues.put("rawXML", this.field_rawXML);
    }
    if (this.feB) {
      localContentValues.put("receiveTime", Long.valueOf(this.field_receiveTime));
    }
    if (this.feC) {
      localContentValues.put("showType", Integer.valueOf(this.field_showType));
    }
    if (this.field_interactiveMergeId == null) {
      this.field_interactiveMergeId = "";
    }
    if (this.feD) {
      localContentValues.put("interactiveMergeId", this.field_interactiveMergeId);
    }
    if (this.feE) {
      localContentValues.put("hasMergedCount", Integer.valueOf(this.field_hasMergedCount));
    }
    if (this.feF) {
      localContentValues.put("redDotExpireTime", Long.valueOf(this.field_redDotExpireTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.cy
 * JD-Core Version:    0.7.0.1
 */
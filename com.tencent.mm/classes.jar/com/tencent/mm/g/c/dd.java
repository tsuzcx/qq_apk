package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class dd
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int createTime_HASHCODE;
  private static final int fIZ;
  private static final int fJa;
  private static final int fJb;
  private static final int fJc;
  private static final int fJd;
  private static final int fJe;
  private static final int fJf;
  private static final int fJg = "receiveTime".hashCode();
  private static final int fJh = "showType".hashCode();
  private static final int fJi = "interactiveMergeId".hashCode();
  private static final int fJj = "hasMergedCount".hashCode();
  private static final int fJk = "redDotExpireTime".hashCode();
  private static final int fjG = "needReport".hashCode();
  private static final int fjH;
  private static final int fjf = "msgId".hashCode();
  private static final int fkj;
  private static final int fof;
  private static final int fqF;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetcreateTime = true;
  private boolean fIN = true;
  private boolean fIO = true;
  private boolean fIP = true;
  private boolean fIQ = true;
  private boolean fIR = true;
  private boolean fIS = true;
  private boolean fIT = true;
  private boolean fIU = true;
  private boolean fIV = true;
  private boolean fIW = true;
  private boolean fIX = true;
  private boolean fIY = true;
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
  public boolean field_needReport;
  public String field_rawXML;
  public long field_receiveTime;
  public long field_redDotExpireTime;
  public boolean field_showInMsgList;
  public int field_showType;
  public String field_weight;
  private boolean fjC = true;
  private boolean fjD = true;
  private boolean fjS = true;
  private boolean fjb = true;
  private boolean fnQ = true;
  private boolean fqr = true;
  
  static
  {
    fIZ = "mergerId".hashCode();
    fJa = "gameMsgId".hashCode();
    fof = "msgType".hashCode();
    createTime_HASHCODE = "createTime".hashCode();
    fJb = "expireTime".hashCode();
    fkj = "appId".hashCode();
    fJc = "showInMsgList".hashCode();
    fqF = "isRead".hashCode();
    fJd = "label".hashCode();
    fJe = "isHidden".hashCode();
    fJf = "weight".hashCode();
    fjH = "rawXML".hashCode();
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
      if (fjf != k) {
        break label65;
      }
      this.field_msgId = paramCursor.getLong(i);
      this.fjb = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fIZ == k)
      {
        this.field_mergerId = paramCursor.getString(i);
      }
      else if (fJa == k)
      {
        this.field_gameMsgId = paramCursor.getString(i);
      }
      else if (fof == k)
      {
        this.field_msgType = paramCursor.getInt(i);
      }
      else if (createTime_HASHCODE == k)
      {
        this.field_createTime = paramCursor.getLong(i);
      }
      else if (fJb == k)
      {
        this.field_expireTime = paramCursor.getLong(i);
      }
      else if (fkj == k)
      {
        this.field_appId = paramCursor.getString(i);
      }
      else
      {
        boolean bool;
        if (fJc == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_showInMsgList = bool;
            break;
          }
        }
        if (fqF == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_isRead = bool;
            break;
          }
        }
        if (fJd == k)
        {
          this.field_label = paramCursor.getString(i);
        }
        else
        {
          if (fJe == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_isHidden = bool;
              break;
            }
          }
          if (fJf == k)
          {
            this.field_weight = paramCursor.getString(i);
          }
          else if (fjH == k)
          {
            this.field_rawXML = paramCursor.getString(i);
          }
          else if (fJg == k)
          {
            this.field_receiveTime = paramCursor.getLong(i);
          }
          else if (fJh == k)
          {
            this.field_showType = paramCursor.getInt(i);
          }
          else if (fJi == k)
          {
            this.field_interactiveMergeId = paramCursor.getString(i);
          }
          else if (fJj == k)
          {
            this.field_hasMergedCount = paramCursor.getInt(i);
          }
          else if (fJk == k)
          {
            this.field_redDotExpireTime = paramCursor.getLong(i);
          }
          else
          {
            if (fjG == k)
            {
              if (paramCursor.getInt(i) != 0) {}
              for (bool = true;; bool = false)
              {
                this.field_needReport = bool;
                break;
              }
            }
            if (rowid_HASHCODE == k) {
              this.systemRowid = paramCursor.getLong(i);
            }
          }
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fjb) {
      localContentValues.put("msgId", Long.valueOf(this.field_msgId));
    }
    if (this.fIN) {
      localContentValues.put("mergerId", this.field_mergerId);
    }
    if (this.fIO) {
      localContentValues.put("gameMsgId", this.field_gameMsgId);
    }
    if (this.fnQ) {
      localContentValues.put("msgType", Integer.valueOf(this.field_msgType));
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.fIP) {
      localContentValues.put("expireTime", Long.valueOf(this.field_expireTime));
    }
    if (this.fjS) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.fIQ) {
      localContentValues.put("showInMsgList", Boolean.valueOf(this.field_showInMsgList));
    }
    if (this.fqr) {
      localContentValues.put("isRead", Boolean.valueOf(this.field_isRead));
    }
    if (this.field_label == null) {
      this.field_label = "";
    }
    if (this.fIR) {
      localContentValues.put("label", this.field_label);
    }
    if (this.fIS) {
      localContentValues.put("isHidden", Boolean.valueOf(this.field_isHidden));
    }
    if (this.field_weight == null) {
      this.field_weight = "";
    }
    if (this.fIT) {
      localContentValues.put("weight", this.field_weight);
    }
    if (this.field_rawXML == null) {
      this.field_rawXML = "";
    }
    if (this.fjD) {
      localContentValues.put("rawXML", this.field_rawXML);
    }
    if (this.fIU) {
      localContentValues.put("receiveTime", Long.valueOf(this.field_receiveTime));
    }
    if (this.fIV) {
      localContentValues.put("showType", Integer.valueOf(this.field_showType));
    }
    if (this.field_interactiveMergeId == null) {
      this.field_interactiveMergeId = "";
    }
    if (this.fIW) {
      localContentValues.put("interactiveMergeId", this.field_interactiveMergeId);
    }
    if (this.fIX) {
      localContentValues.put("hasMergedCount", Integer.valueOf(this.field_hasMergedCount));
    }
    if (this.fIY) {
      localContentValues.put("redDotExpireTime", Long.valueOf(this.field_redDotExpireTime));
    }
    if (this.fjC) {
      localContentValues.put("needReport", Boolean.valueOf(this.field_needReport));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.dd
 * JD-Core Version:    0.7.0.1
 */
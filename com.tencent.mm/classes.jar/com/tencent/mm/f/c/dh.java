package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class dh
  extends IAutoDBItem
{
  public static final Column C_CREATETIME;
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("GameRawMessage");
  private static final int createTime_HASHCODE;
  private static final int hZB;
  private static final int hZC;
  private static final int hZD;
  private static final int hZE;
  private static final int hZF;
  private static final int hZG;
  private static final int hZH;
  private static final int hZI = "receiveTime".hashCode();
  private static final int hZJ = "showType".hashCode();
  private static final int hZK = "interactiveMergeId".hashCode();
  private static final int hZL = "hasMergedCount".hashCode();
  private static final int hZM = "redDotExpireTime".hashCode();
  public static final Column hZd;
  public static final Column hZe;
  public static final Column hZf;
  public static final Column hZg;
  public static final Column hZh;
  public static final Column hZi;
  public static final Column hZj;
  public static final Column hZk;
  public static final Column hZl;
  public static final Column hZm;
  public static final Column hZn;
  public static final Column hZo;
  public static final Column hml;
  private static final int hmt;
  public static final Column hna;
  public static final Column hnb;
  private static final int hni = "needReport".hashCode();
  private static final int hnj;
  public static final Column hnz;
  private static final int hoh;
  private static final int htI;
  public static final Column hte;
  public static final Column hwR;
  private static final int hxt;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetcreateTime = true;
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
  private boolean hZA = true;
  private boolean hZp = true;
  private boolean hZq = true;
  private boolean hZr = true;
  private boolean hZs = true;
  private boolean hZt = true;
  private boolean hZu = true;
  private boolean hZv = true;
  private boolean hZw = true;
  private boolean hZx = true;
  private boolean hZy = true;
  private boolean hZz = true;
  private boolean hmp = true;
  private boolean hnQ = true;
  private boolean hne = true;
  private boolean hnf = true;
  private boolean htt = true;
  private boolean hxf = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "GameRawMessage", "");
    hml = new Column("msgid", "long", "GameRawMessage", "");
    hZd = new Column("mergerid", "string", "GameRawMessage", "");
    hZe = new Column("gamemsgid", "string", "GameRawMessage", "");
    hte = new Column("msgtype", "int", "GameRawMessage", "");
    C_CREATETIME = new Column("createtime", "long", "GameRawMessage", "");
    hZf = new Column("expiretime", "long", "GameRawMessage", "");
    hnz = new Column("appid", "string", "GameRawMessage", "");
    hZg = new Column("showinmsglist", "boolean", "GameRawMessage", "");
    hwR = new Column("isread", "boolean", "GameRawMessage", "");
    hZh = new Column("label", "string", "GameRawMessage", "");
    hZi = new Column("ishidden", "boolean", "GameRawMessage", "");
    hZj = new Column("weight", "string", "GameRawMessage", "");
    hnb = new Column("rawxml", "string", "GameRawMessage", "");
    hZk = new Column("receivetime", "long", "GameRawMessage", "");
    hZl = new Column("showtype", "int", "GameRawMessage", "");
    hZm = new Column("interactivemergeid", "string", "GameRawMessage", "");
    hZn = new Column("hasmergedcount", "int", "GameRawMessage", "");
    hZo = new Column("reddotexpiretime", "long", "GameRawMessage", "");
    hna = new Column("needreport", "boolean", "GameRawMessage", "");
    hmt = "msgId".hashCode();
    hZB = "mergerId".hashCode();
    hZC = "gameMsgId".hashCode();
    htI = "msgType".hashCode();
    createTime_HASHCODE = "createTime".hashCode();
    hZD = "expireTime".hashCode();
    hoh = "appId".hashCode();
    hZE = "showInMsgList".hashCode();
    hxt = "isRead".hashCode();
    hZF = "label".hashCode();
    hZG = "isHidden".hashCode();
    hZH = "weight".hashCode();
    hnj = "rawXML".hashCode();
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
      if (hmt != k) {
        break label65;
      }
      this.field_msgId = paramCursor.getLong(i);
      this.hmp = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (hZB == k)
      {
        this.field_mergerId = paramCursor.getString(i);
      }
      else if (hZC == k)
      {
        this.field_gameMsgId = paramCursor.getString(i);
      }
      else if (htI == k)
      {
        this.field_msgType = paramCursor.getInt(i);
      }
      else if (createTime_HASHCODE == k)
      {
        this.field_createTime = paramCursor.getLong(i);
      }
      else if (hZD == k)
      {
        this.field_expireTime = paramCursor.getLong(i);
      }
      else if (hoh == k)
      {
        this.field_appId = paramCursor.getString(i);
      }
      else
      {
        boolean bool;
        if (hZE == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_showInMsgList = bool;
            break;
          }
        }
        if (hxt == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_isRead = bool;
            break;
          }
        }
        if (hZF == k)
        {
          this.field_label = paramCursor.getString(i);
        }
        else
        {
          if (hZG == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_isHidden = bool;
              break;
            }
          }
          if (hZH == k)
          {
            this.field_weight = paramCursor.getString(i);
          }
          else if (hnj == k)
          {
            this.field_rawXML = paramCursor.getString(i);
          }
          else if (hZI == k)
          {
            this.field_receiveTime = paramCursor.getLong(i);
          }
          else if (hZJ == k)
          {
            this.field_showType = paramCursor.getInt(i);
          }
          else if (hZK == k)
          {
            this.field_interactiveMergeId = paramCursor.getString(i);
          }
          else if (hZL == k)
          {
            this.field_hasMergedCount = paramCursor.getInt(i);
          }
          else if (hZM == k)
          {
            this.field_redDotExpireTime = paramCursor.getLong(i);
          }
          else
          {
            if (hni == k)
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
    if (this.hmp) {
      localContentValues.put("msgId", Long.valueOf(this.field_msgId));
    }
    if (this.hZp) {
      localContentValues.put("mergerId", this.field_mergerId);
    }
    if (this.hZq) {
      localContentValues.put("gameMsgId", this.field_gameMsgId);
    }
    if (this.htt) {
      localContentValues.put("msgType", Integer.valueOf(this.field_msgType));
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.hZr) {
      localContentValues.put("expireTime", Long.valueOf(this.field_expireTime));
    }
    if (this.hnQ) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.hZs) {
      localContentValues.put("showInMsgList", Boolean.valueOf(this.field_showInMsgList));
    }
    if (this.hxf) {
      localContentValues.put("isRead", Boolean.valueOf(this.field_isRead));
    }
    if (this.field_label == null) {
      this.field_label = "";
    }
    if (this.hZt) {
      localContentValues.put("label", this.field_label);
    }
    if (this.hZu) {
      localContentValues.put("isHidden", Boolean.valueOf(this.field_isHidden));
    }
    if (this.field_weight == null) {
      this.field_weight = "";
    }
    if (this.hZv) {
      localContentValues.put("weight", this.field_weight);
    }
    if (this.field_rawXML == null) {
      this.field_rawXML = "";
    }
    if (this.hnf) {
      localContentValues.put("rawXML", this.field_rawXML);
    }
    if (this.hZw) {
      localContentValues.put("receiveTime", Long.valueOf(this.field_receiveTime));
    }
    if (this.hZx) {
      localContentValues.put("showType", Integer.valueOf(this.field_showType));
    }
    if (this.field_interactiveMergeId == null) {
      this.field_interactiveMergeId = "";
    }
    if (this.hZy) {
      localContentValues.put("interactiveMergeId", this.field_interactiveMergeId);
    }
    if (this.hZz) {
      localContentValues.put("hasMergedCount", Integer.valueOf(this.field_hasMergedCount));
    }
    if (this.hZA) {
      localContentValues.put("redDotExpireTime", Long.valueOf(this.field_redDotExpireTime));
    }
    if (this.hne) {
      localContentValues.put("needReport", Boolean.valueOf(this.field_needReport));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "GameRawMessage";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.dh
 * JD-Core Version:    0.7.0.1
 */
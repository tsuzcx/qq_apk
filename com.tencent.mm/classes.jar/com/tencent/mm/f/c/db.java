package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class db
  extends IAutoDBItem
{
  public static final Column C_CREATETIME;
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("GameHaowanPublishEdition");
  private static final int createTime_HASHCODE;
  private static final int hUK;
  public static final Column hXP;
  public static final Column hXV;
  private static final int hYI;
  private static final int hYJ;
  private static final int hYK;
  private static final int hYL;
  private static final int hYM;
  private static final int hYN = "publishState".hashCode();
  private static final int hYO = "compressImg".hashCode();
  private static final int hYP = "mixState".hashCode();
  private static final int hYQ = "bgMixTaskId".hashCode();
  private static final int hYR = "sourceSceneId".hashCode();
  private static final int hYl;
  public static final Column hYo;
  public static final Column hYp;
  public static final Column hYq;
  public static final Column hYr;
  public static final Column hYs;
  public static final Column hYt;
  public static final Column hYu;
  public static final Column hYv;
  public static final Column hYw;
  public static final Column hYx;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean __hadSetcreateTime = true;
  public String field_BusinessData;
  public String field_bgMixTaskId;
  public boolean field_compressImg;
  public long field_createTime;
  public String field_localIdList;
  public String field_mediaList;
  public int field_mediaType;
  public int field_mixState;
  public int field_publishSource;
  public int field_publishState;
  public int field_sourceSceneId;
  public String field_taskId;
  public int field_uploadState;
  private boolean hUt = true;
  private boolean hYA = true;
  private boolean hYB = true;
  private boolean hYC = true;
  private boolean hYD = true;
  private boolean hYE = true;
  private boolean hYF = true;
  private boolean hYG = true;
  private boolean hYH = true;
  private boolean hYd = true;
  private boolean hYy = true;
  private boolean hYz = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "GameHaowanPublishEdition", "");
    hYo = new Column("taskid", "string", "GameHaowanPublishEdition", "");
    C_CREATETIME = new Column("createtime", "long", "GameHaowanPublishEdition", "");
    hYp = new Column("publishsource", "int", "GameHaowanPublishEdition", "");
    hXP = new Column("mediatype", "int", "GameHaowanPublishEdition", "");
    hYq = new Column("localidlist", "string", "GameHaowanPublishEdition", "");
    hYr = new Column("medialist", "string", "GameHaowanPublishEdition", "");
    hYs = new Column("businessdata", "string", "GameHaowanPublishEdition", "");
    hXV = new Column("uploadstate", "int", "GameHaowanPublishEdition", "");
    hYt = new Column("publishstate", "int", "GameHaowanPublishEdition", "");
    hYu = new Column("compressimg", "boolean", "GameHaowanPublishEdition", "");
    hYv = new Column("mixstate", "int", "GameHaowanPublishEdition", "");
    hYw = new Column("bgmixtaskid", "string", "GameHaowanPublishEdition", "");
    hYx = new Column("sourcesceneid", "int", "GameHaowanPublishEdition", "");
    hYI = "taskId".hashCode();
    createTime_HASHCODE = "createTime".hashCode();
    hYJ = "publishSource".hashCode();
    hUK = "mediaType".hashCode();
    hYK = "localIdList".hashCode();
    hYL = "mediaList".hashCode();
    hYM = "BusinessData".hashCode();
    hYl = "uploadState".hashCode();
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
      if (hYI != k) {
        break label65;
      }
      this.field_taskId = paramCursor.getString(i);
      this.hYy = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (createTime_HASHCODE == k)
      {
        this.field_createTime = paramCursor.getLong(i);
      }
      else if (hYJ == k)
      {
        this.field_publishSource = paramCursor.getInt(i);
      }
      else if (hUK == k)
      {
        this.field_mediaType = paramCursor.getInt(i);
      }
      else if (hYK == k)
      {
        this.field_localIdList = paramCursor.getString(i);
      }
      else if (hYL == k)
      {
        this.field_mediaList = paramCursor.getString(i);
      }
      else if (hYM == k)
      {
        this.field_BusinessData = paramCursor.getString(i);
      }
      else if (hYl == k)
      {
        this.field_uploadState = paramCursor.getInt(i);
      }
      else if (hYN == k)
      {
        this.field_publishState = paramCursor.getInt(i);
      }
      else
      {
        if (hYO == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_compressImg = bool;
            break;
          }
        }
        if (hYP == k) {
          this.field_mixState = paramCursor.getInt(i);
        } else if (hYQ == k) {
          this.field_bgMixTaskId = paramCursor.getString(i);
        } else if (hYR == k) {
          this.field_sourceSceneId = paramCursor.getInt(i);
        } else if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hYy) {
      localContentValues.put("taskId", this.field_taskId);
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.hYz) {
      localContentValues.put("publishSource", Integer.valueOf(this.field_publishSource));
    }
    if (this.hUt) {
      localContentValues.put("mediaType", Integer.valueOf(this.field_mediaType));
    }
    if (this.hYA) {
      localContentValues.put("localIdList", this.field_localIdList);
    }
    if (this.hYB) {
      localContentValues.put("mediaList", this.field_mediaList);
    }
    if (this.hYC) {
      localContentValues.put("BusinessData", this.field_BusinessData);
    }
    if (this.hYd) {
      localContentValues.put("uploadState", Integer.valueOf(this.field_uploadState));
    }
    if (this.hYD) {
      localContentValues.put("publishState", Integer.valueOf(this.field_publishState));
    }
    if (this.hYE) {
      localContentValues.put("compressImg", Boolean.valueOf(this.field_compressImg));
    }
    if (this.hYF) {
      localContentValues.put("mixState", Integer.valueOf(this.field_mixState));
    }
    if (this.hYG) {
      localContentValues.put("bgMixTaskId", this.field_bgMixTaskId);
    }
    if (this.hYH) {
      localContentValues.put("sourceSceneId", Integer.valueOf(this.field_sourceSceneId));
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
    return "GameHaowanPublishEdition";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.db
 * JD-Core Version:    0.7.0.1
 */
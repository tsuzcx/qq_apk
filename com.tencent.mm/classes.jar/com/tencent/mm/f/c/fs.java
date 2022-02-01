package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class fs
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final Column C_TYPE;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("PredownloadCmdGetCodePersistentInfo2");
  public static final Column hWa;
  public static final Column hnt;
  private static final int hnx = "scene".hashCode();
  public static final Column hnz;
  private static final int hoh;
  public static final Column hpJ;
  private static final int hpT;
  public static final Column hpY;
  public static final Column hpZ;
  public static final Column hqc;
  private static final int hqi;
  private static final int hqj;
  private static final int hqm;
  private static final int irI;
  private static final int irJ;
  private static final int irK;
  private static final int irL;
  private static final int irM;
  private static final int irN;
  private static final int irO;
  private static final int irP;
  private static final int irQ = "cmdSequence".hashCode();
  public static final Column irq;
  public static final Column irs;
  public static final Column irt;
  public static final Column iru;
  public static final Column irv;
  public static final Column irw;
  public static final Column irx;
  public static final Column iry;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  public String field_appId;
  public long field_cmdSequence;
  public boolean field_firstTimeTried;
  public long field_lastRetryTime;
  public int field_networkType;
  public String field_packageKey;
  public int field_packageType;
  public String field_pkgMd5;
  public int field_reportId;
  public int field_retriedCount;
  public long field_retryInterval;
  public int field_retryTimes;
  public int field_scene;
  public boolean field_splitDownloadURLCgi;
  public int field_type;
  public int field_version;
  private boolean hnQ = true;
  private boolean hnv = true;
  private boolean hpO = true;
  private boolean hqd = true;
  private boolean hqe = true;
  private boolean hqh = true;
  private boolean irA = true;
  private boolean irB = true;
  private boolean irC = true;
  private boolean irD = true;
  private boolean irE = true;
  private boolean irF = true;
  private boolean irG = true;
  private boolean irH = true;
  private boolean irz = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "PredownloadCmdGetCodePersistentInfo2", "");
    hnz = new Column("appid", "string", "PredownloadCmdGetCodePersistentInfo2", "");
    hpJ = new Column("version", "int", "PredownloadCmdGetCodePersistentInfo2", "");
    C_TYPE = new Column("type", "int", "PredownloadCmdGetCodePersistentInfo2", "");
    irq = new Column("retrytimes", "int", "PredownloadCmdGetCodePersistentInfo2", "");
    irs = new Column("retriedcount", "int", "PredownloadCmdGetCodePersistentInfo2", "");
    hWa = new Column("retryinterval", "long", "PredownloadCmdGetCodePersistentInfo2", "");
    irt = new Column("networktype", "int", "PredownloadCmdGetCodePersistentInfo2", "");
    iru = new Column("pkgmd5", "string", "PredownloadCmdGetCodePersistentInfo2", "");
    hpZ = new Column("packagekey", "string", "PredownloadCmdGetCodePersistentInfo2", "");
    hpY = new Column("packagetype", "int", "PredownloadCmdGetCodePersistentInfo2", "");
    irv = new Column("lastretrytime", "long", "PredownloadCmdGetCodePersistentInfo2", "");
    irw = new Column("firsttimetried", "boolean", "PredownloadCmdGetCodePersistentInfo2", "");
    hqc = new Column("reportid", "int", "PredownloadCmdGetCodePersistentInfo2", "");
    irx = new Column("splitdownloadurlcgi", "boolean", "PredownloadCmdGetCodePersistentInfo2", "");
    hnt = new Column("scene", "int", "PredownloadCmdGetCodePersistentInfo2", "");
    iry = new Column("cmdsequence", "long", "PredownloadCmdGetCodePersistentInfo2", "");
    hoh = "appId".hashCode();
    hpT = "version".hashCode();
    type_HASHCODE = "type".hashCode();
    irI = "retryTimes".hashCode();
    irJ = "retriedCount".hashCode();
    irK = "retryInterval".hashCode();
    irL = "networkType".hashCode();
    irM = "pkgMd5".hashCode();
    hqj = "packageKey".hashCode();
    hqi = "packageType".hashCode();
    irN = "lastRetryTime".hashCode();
    irO = "firstTimeTried".hashCode();
    hqm = "reportId".hashCode();
    irP = "splitDownloadURLCgi".hashCode();
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
      if (hoh != k) {
        break label60;
      }
      this.field_appId = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (hpT == k)
      {
        this.field_version = paramCursor.getInt(i);
      }
      else if (type_HASHCODE == k)
      {
        this.field_type = paramCursor.getInt(i);
      }
      else if (irI == k)
      {
        this.field_retryTimes = paramCursor.getInt(i);
      }
      else if (irJ == k)
      {
        this.field_retriedCount = paramCursor.getInt(i);
      }
      else if (irK == k)
      {
        this.field_retryInterval = paramCursor.getLong(i);
      }
      else if (irL == k)
      {
        this.field_networkType = paramCursor.getInt(i);
      }
      else if (irM == k)
      {
        this.field_pkgMd5 = paramCursor.getString(i);
      }
      else if (hqj == k)
      {
        this.field_packageKey = paramCursor.getString(i);
      }
      else if (hqi == k)
      {
        this.field_packageType = paramCursor.getInt(i);
      }
      else if (irN == k)
      {
        this.field_lastRetryTime = paramCursor.getLong(i);
      }
      else
      {
        boolean bool;
        if (irO == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_firstTimeTried = bool;
            break;
          }
        }
        if (hqm == k)
        {
          this.field_reportId = paramCursor.getInt(i);
        }
        else
        {
          if (irP == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_splitDownloadURLCgi = bool;
              break;
            }
          }
          if (hnx == k) {
            this.field_scene = paramCursor.getInt(i);
          } else if (irQ == k) {
            this.field_cmdSequence = paramCursor.getLong(i);
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
    if (this.hnQ) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.hpO) {
      localContentValues.put("version", Integer.valueOf(this.field_version));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.irz) {
      localContentValues.put("retryTimes", Integer.valueOf(this.field_retryTimes));
    }
    if (this.irA) {
      localContentValues.put("retriedCount", Integer.valueOf(this.field_retriedCount));
    }
    if (this.irB) {
      localContentValues.put("retryInterval", Long.valueOf(this.field_retryInterval));
    }
    if (this.irC) {
      localContentValues.put("networkType", Integer.valueOf(this.field_networkType));
    }
    if (this.irD) {
      localContentValues.put("pkgMd5", this.field_pkgMd5);
    }
    if (this.hqe) {
      localContentValues.put("packageKey", this.field_packageKey);
    }
    if (this.hqd) {
      localContentValues.put("packageType", Integer.valueOf(this.field_packageType));
    }
    if (this.irE) {
      localContentValues.put("lastRetryTime", Long.valueOf(this.field_lastRetryTime));
    }
    if (this.irF) {
      localContentValues.put("firstTimeTried", Boolean.valueOf(this.field_firstTimeTried));
    }
    if (this.hqh) {
      localContentValues.put("reportId", Integer.valueOf(this.field_reportId));
    }
    if (this.irG) {
      localContentValues.put("splitDownloadURLCgi", Boolean.valueOf(this.field_splitDownloadURLCgi));
    }
    if (this.hnv) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.irH) {
      localContentValues.put("cmdSequence", Long.valueOf(this.field_cmdSequence));
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
    return "PredownloadCmdGetCodePersistentInfo2";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.fs
 * JD-Core Version:    0.7.0.1
 */
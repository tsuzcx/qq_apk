package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class fd
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEB = "scene".hashCode();
  private static final int eEU = "appId".hashCode();
  private static final int eGk = "version".hashCode();
  private static final int eGu;
  private static final int eGv;
  private static final int eGy;
  private static final int foA;
  private static final int foB;
  private static final int foC;
  private static final int foD;
  private static final int foE = "cmdSequence".hashCode();
  private static final int fow;
  private static final int fox;
  private static final int foy;
  private static final int foz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE = "type".hashCode();
  private boolean __hadSettype = true;
  private boolean eED = true;
  private boolean eEz = true;
  private boolean eGf = true;
  private boolean eGp = true;
  private boolean eGq = true;
  private boolean eGt = true;
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
  private boolean fon = true;
  private boolean foo = true;
  private boolean fop = true;
  private boolean foq = true;
  private boolean jdField_for = true;
  private boolean fos = true;
  private boolean fot = true;
  private boolean fou = true;
  private boolean fov = true;
  
  static
  {
    fow = "retryTimes".hashCode();
    fox = "retriedCount".hashCode();
    foy = "retryInterval".hashCode();
    foz = "networkType".hashCode();
    foA = "pkgMd5".hashCode();
    eGv = "packageKey".hashCode();
    eGu = "packageType".hashCode();
    foB = "lastRetryTime".hashCode();
    foC = "firstTimeTried".hashCode();
    eGy = "reportId".hashCode();
    foD = "splitDownloadURLCgi".hashCode();
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
      if (eEU != k) {
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
      if (eGk == k)
      {
        this.field_version = paramCursor.getInt(i);
      }
      else if (type_HASHCODE == k)
      {
        this.field_type = paramCursor.getInt(i);
      }
      else if (fow == k)
      {
        this.field_retryTimes = paramCursor.getInt(i);
      }
      else if (fox == k)
      {
        this.field_retriedCount = paramCursor.getInt(i);
      }
      else if (foy == k)
      {
        this.field_retryInterval = paramCursor.getLong(i);
      }
      else if (foz == k)
      {
        this.field_networkType = paramCursor.getInt(i);
      }
      else if (foA == k)
      {
        this.field_pkgMd5 = paramCursor.getString(i);
      }
      else if (eGv == k)
      {
        this.field_packageKey = paramCursor.getString(i);
      }
      else if (eGu == k)
      {
        this.field_packageType = paramCursor.getInt(i);
      }
      else if (foB == k)
      {
        this.field_lastRetryTime = paramCursor.getLong(i);
      }
      else
      {
        boolean bool;
        if (foC == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_firstTimeTried = bool;
            break;
          }
        }
        if (eGy == k)
        {
          this.field_reportId = paramCursor.getInt(i);
        }
        else
        {
          if (foD == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_splitDownloadURLCgi = bool;
              break;
            }
          }
          if (eEB == k) {
            this.field_scene = paramCursor.getInt(i);
          } else if (foE == k) {
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
    if (this.eED) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.eGf) {
      localContentValues.put("version", Integer.valueOf(this.field_version));
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.fon) {
      localContentValues.put("retryTimes", Integer.valueOf(this.field_retryTimes));
    }
    if (this.foo) {
      localContentValues.put("retriedCount", Integer.valueOf(this.field_retriedCount));
    }
    if (this.fop) {
      localContentValues.put("retryInterval", Long.valueOf(this.field_retryInterval));
    }
    if (this.foq) {
      localContentValues.put("networkType", Integer.valueOf(this.field_networkType));
    }
    if (this.jdField_for) {
      localContentValues.put("pkgMd5", this.field_pkgMd5);
    }
    if (this.eGq) {
      localContentValues.put("packageKey", this.field_packageKey);
    }
    if (this.eGp) {
      localContentValues.put("packageType", Integer.valueOf(this.field_packageType));
    }
    if (this.fos) {
      localContentValues.put("lastRetryTime", Long.valueOf(this.field_lastRetryTime));
    }
    if (this.fot) {
      localContentValues.put("firstTimeTried", Boolean.valueOf(this.field_firstTimeTried));
    }
    if (this.eGt) {
      localContentValues.put("reportId", Integer.valueOf(this.field_reportId));
    }
    if (this.fou) {
      localContentValues.put("splitDownloadURLCgi", Boolean.valueOf(this.field_splitDownloadURLCgi));
    }
    if (this.eEz) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.fov) {
      localContentValues.put("cmdSequence", Long.valueOf(this.field_cmdSequence));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.fd
 * JD-Core Version:    0.7.0.1
 */
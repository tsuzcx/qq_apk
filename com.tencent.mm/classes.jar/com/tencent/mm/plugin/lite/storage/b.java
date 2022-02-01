package com.tencent.mm.plugin.lite.storage;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class b
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fPo;
  private static final int fkj = "appId".hashCode();
  private static final int flv;
  private static final int flx;
  private static final int fnB;
  private static final int fxh = "lastUseTime".hashCode();
  private static final int fyf;
  private static final int fyq = "groupId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int updateTime_HASHCODE;
  private static final int yFb = "signatureKey".hashCode();
  private static final int yFc;
  private boolean __hadSetupdateTime = true;
  private boolean fPj = true;
  public String field_appId;
  public String field_groupId;
  public long field_lastUseTime;
  public String field_md5;
  public String field_patchId;
  public String field_pkgPath;
  public String field_pkgType;
  public String field_signatureKey;
  public long field_updateTime;
  public String field_url;
  public String field_version;
  private boolean fjS = true;
  private boolean flq = true;
  private boolean fls = true;
  private boolean fnx = true;
  private boolean fwH = true;
  private boolean fxE = true;
  private boolean fxt = true;
  private boolean yEZ = true;
  private boolean yFa = true;
  
  static
  {
    flx = "pkgPath".hashCode();
    fPo = "pkgType".hashCode();
    yFc = "patchId".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
    flv = "version".hashCode();
    fnB = "url".hashCode();
    fyf = "md5".hashCode();
  }
  
  public void convertFrom(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {
      return;
    }
    int i = 0;
    int j = arrayOfString.length;
    label20:
    int k;
    if (i < j)
    {
      k = arrayOfString[i].hashCode();
      if (fkj != k) {
        break label65;
      }
      this.field_appId = paramCursor.getString(i);
      this.fjS = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fyq == k) {
        this.field_groupId = paramCursor.getString(i);
      } else if (yFb == k) {
        this.field_signatureKey = paramCursor.getString(i);
      } else if (flx == k) {
        this.field_pkgPath = paramCursor.getString(i);
      } else if (fPo == k) {
        this.field_pkgType = paramCursor.getString(i);
      } else if (yFc == k) {
        this.field_patchId = paramCursor.getString(i);
      } else if (updateTime_HASHCODE == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (flv == k) {
        this.field_version = paramCursor.getString(i);
      } else if (fnB == k) {
        this.field_url = paramCursor.getString(i);
      } else if (fyf == k) {
        this.field_md5 = paramCursor.getString(i);
      } else if (fxh == k) {
        this.field_lastUseTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fjS) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.fxE) {
      localContentValues.put("groupId", this.field_groupId);
    }
    if (this.yEZ) {
      localContentValues.put("signatureKey", this.field_signatureKey);
    }
    if (this.fls) {
      localContentValues.put("pkgPath", this.field_pkgPath);
    }
    if (this.fPj) {
      localContentValues.put("pkgType", this.field_pkgType);
    }
    if (this.yFa) {
      localContentValues.put("patchId", this.field_patchId);
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if (this.flq) {
      localContentValues.put("version", this.field_version);
    }
    if (this.fnx) {
      localContentValues.put("url", this.field_url);
    }
    if (this.fxt) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.fwH) {
      localContentValues.put("lastUseTime", Long.valueOf(this.field_lastUseTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.lite.storage.b
 * JD-Core Version:    0.7.0.1
 */
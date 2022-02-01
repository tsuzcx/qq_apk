package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class dj
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("GameSilentDownload");
  public static final Column hGW;
  private static final int hIy;
  public static final Column hNV;
  public static final Column hNv;
  private static final int hPd = "sectionMd5Byte".hashCode();
  private static final int hZD;
  public static final Column hZf;
  public static final Column hnz;
  private static final int hoh;
  public static final Column hpN;
  public static final Column hpd;
  private static final int hph;
  public static final Column hqs;
  private static final int hrk;
  private static final int hzQ;
  private static final int iaA;
  private static final int iaB;
  private static final int iaC;
  private static final int iaD;
  private static final int iaE;
  private static final int iaF;
  private static final int iaG;
  private static final int iaH;
  private static final int iaI;
  private static final int iaJ;
  private static final int iaK = "forceUpdateFlag".hashCode();
  public static final Column iac;
  public static final Column iad;
  public static final Column iae;
  public static final Column iaf;
  public static final Column iag;
  public static final Column iah;
  public static final Column iai;
  public static final Column iaj;
  public static final Column iak;
  public static final Column ial;
  public static final Column iam;
  private static final int iaz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_SecondaryUrl;
  public String field_appId;
  public boolean field_continueDelay;
  public boolean field_downloadInWidget;
  public String field_downloadUrl;
  public long field_expireTime;
  public int field_forceUpdateFlag;
  public boolean field_isFirst;
  public boolean field_isRunning;
  public boolean field_lowBattery;
  public String field_md5;
  public long field_nextCheckTime;
  public boolean field_noEnoughSpace;
  public boolean field_noSdcard;
  public boolean field_noWifi;
  public String field_packageName;
  public long field_randomTime;
  public byte[] field_sectionMd5Byte;
  public long field_size;
  private boolean hHK = true;
  private boolean hOz = true;
  private boolean hZr = true;
  private boolean hnQ = true;
  private boolean hpf = true;
  private boolean hqO = true;
  private boolean hzI = true;
  private boolean ian = true;
  private boolean iao = true;
  private boolean iap = true;
  private boolean iaq = true;
  private boolean iar = true;
  private boolean ias = true;
  private boolean iat = true;
  private boolean iau = true;
  private boolean iav = true;
  private boolean iaw = true;
  private boolean iax = true;
  private boolean iay = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "GameSilentDownload", "");
    hnz = new Column("appid", "string", "GameSilentDownload", "");
    hpN = new Column("downloadurl", "string", "GameSilentDownload", "");
    hpd = new Column("size", "long", "GameSilentDownload", "");
    hGW = new Column("md5", "string", "GameSilentDownload", "");
    hqs = new Column("packagename", "string", "GameSilentDownload", "");
    hZf = new Column("expiretime", "long", "GameSilentDownload", "");
    iac = new Column("randomtime", "long", "GameSilentDownload", "");
    iad = new Column("isfirst", "boolean", "GameSilentDownload", "");
    iae = new Column("nextchecktime", "long", "GameSilentDownload", "");
    iaf = new Column("isrunning", "boolean", "GameSilentDownload", "");
    iag = new Column("nowifi", "boolean", "GameSilentDownload", "");
    iah = new Column("nosdcard", "boolean", "GameSilentDownload", "");
    iai = new Column("noenoughspace", "boolean", "GameSilentDownload", "");
    iaj = new Column("lowbattery", "boolean", "GameSilentDownload", "");
    iak = new Column("continuedelay", "boolean", "GameSilentDownload", "");
    hNv = new Column("secondaryurl", "string", "GameSilentDownload", "");
    ial = new Column("downloadinwidget", "boolean", "GameSilentDownload", "");
    hNV = new Column("sectionmd5byte", "byte[]", "GameSilentDownload", "");
    iam = new Column("forceupdateflag", "int", "GameSilentDownload", "");
    hoh = "appId".hashCode();
    hzQ = "downloadUrl".hashCode();
    hph = "size".hashCode();
    hIy = "md5".hashCode();
    hrk = "packageName".hashCode();
    hZD = "expireTime".hashCode();
    iaz = "randomTime".hashCode();
    iaA = "isFirst".hashCode();
    iaB = "nextCheckTime".hashCode();
    iaC = "isRunning".hashCode();
    iaD = "noWifi".hashCode();
    iaE = "noSdcard".hashCode();
    iaF = "noEnoughSpace".hashCode();
    iaG = "lowBattery".hashCode();
    iaH = "continueDelay".hashCode();
    iaI = "SecondaryUrl".hashCode();
    iaJ = "downloadInWidget".hashCode();
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
        break label65;
      }
      this.field_appId = paramCursor.getString(i);
      this.hnQ = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (hzQ == k)
      {
        this.field_downloadUrl = paramCursor.getString(i);
      }
      else if (hph == k)
      {
        this.field_size = paramCursor.getLong(i);
      }
      else if (hIy == k)
      {
        this.field_md5 = paramCursor.getString(i);
      }
      else if (hrk == k)
      {
        this.field_packageName = paramCursor.getString(i);
      }
      else if (hZD == k)
      {
        this.field_expireTime = paramCursor.getLong(i);
      }
      else if (iaz == k)
      {
        this.field_randomTime = paramCursor.getLong(i);
      }
      else
      {
        boolean bool;
        if (iaA == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_isFirst = bool;
            break;
          }
        }
        if (iaB == k)
        {
          this.field_nextCheckTime = paramCursor.getLong(i);
        }
        else
        {
          if (iaC == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_isRunning = bool;
              break;
            }
          }
          if (iaD == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_noWifi = bool;
              break;
            }
          }
          if (iaE == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_noSdcard = bool;
              break;
            }
          }
          if (iaF == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_noEnoughSpace = bool;
              break;
            }
          }
          if (iaG == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_lowBattery = bool;
              break;
            }
          }
          if (iaH == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_continueDelay = bool;
              break;
            }
          }
          if (iaI == k)
          {
            this.field_SecondaryUrl = paramCursor.getString(i);
          }
          else
          {
            if (iaJ == k)
            {
              if (paramCursor.getInt(i) != 0) {}
              for (bool = true;; bool = false)
              {
                this.field_downloadInWidget = bool;
                break;
              }
            }
            if (hPd == k) {
              this.field_sectionMd5Byte = paramCursor.getBlob(i);
            } else if (iaK == k) {
              this.field_forceUpdateFlag = paramCursor.getInt(i);
            } else if (rowid_HASHCODE == k) {
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
    if (this.hnQ) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.hzI) {
      localContentValues.put("downloadUrl", this.field_downloadUrl);
    }
    if (this.hpf) {
      localContentValues.put("size", Long.valueOf(this.field_size));
    }
    if (this.hHK) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.hqO) {
      localContentValues.put("packageName", this.field_packageName);
    }
    if (this.hZr) {
      localContentValues.put("expireTime", Long.valueOf(this.field_expireTime));
    }
    if (this.ian) {
      localContentValues.put("randomTime", Long.valueOf(this.field_randomTime));
    }
    if (this.iao) {
      localContentValues.put("isFirst", Boolean.valueOf(this.field_isFirst));
    }
    if (this.iap) {
      localContentValues.put("nextCheckTime", Long.valueOf(this.field_nextCheckTime));
    }
    if (this.iaq) {
      localContentValues.put("isRunning", Boolean.valueOf(this.field_isRunning));
    }
    if (this.iar) {
      localContentValues.put("noWifi", Boolean.valueOf(this.field_noWifi));
    }
    if (this.ias) {
      localContentValues.put("noSdcard", Boolean.valueOf(this.field_noSdcard));
    }
    if (this.iat) {
      localContentValues.put("noEnoughSpace", Boolean.valueOf(this.field_noEnoughSpace));
    }
    if (this.iau) {
      localContentValues.put("lowBattery", Boolean.valueOf(this.field_lowBattery));
    }
    if (this.iav) {
      localContentValues.put("continueDelay", Boolean.valueOf(this.field_continueDelay));
    }
    if (this.iaw) {
      localContentValues.put("SecondaryUrl", this.field_SecondaryUrl);
    }
    if (this.iax) {
      localContentValues.put("downloadInWidget", Boolean.valueOf(this.field_downloadInWidget));
    }
    if (this.hOz) {
      localContentValues.put("sectionMd5Byte", this.field_sectionMd5Byte);
    }
    if (this.iay) {
      localContentValues.put("forceUpdateFlag", Integer.valueOf(this.field_forceUpdateFlag));
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
    return "GameSilentDownload";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.f.c.dj
 * JD-Core Version:    0.7.0.1
 */
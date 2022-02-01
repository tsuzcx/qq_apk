package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cz
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEU = "appId".hashCode();
  private static final int eFM;
  private static final int eHa;
  private static final int eNa = "downloadUrl".hashCode();
  private static final int eSP;
  private static final int eXz = "sectionMd5Byte".hashCode();
  private static final int fcQ;
  private static final int fdl;
  private static final int fdm;
  private static final int fdn;
  private static final int fdo;
  private static final int fdp;
  private static final int fdq;
  private static final int fdr;
  private static final int fds;
  private static final int fdt;
  private static final int fdu;
  private static final int fdv;
  private static final int fdw = "forceUpdateFlag".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eED = true;
  private boolean eFK = true;
  private boolean eGE = true;
  private boolean eMS = true;
  private boolean eSd = true;
  private boolean eWW = true;
  private boolean fcF = true;
  private boolean fcZ = true;
  private boolean fda = true;
  private boolean fdb = true;
  private boolean fdc = true;
  private boolean fdd = true;
  private boolean fde = true;
  private boolean fdf = true;
  private boolean fdg = true;
  private boolean fdh = true;
  private boolean fdi = true;
  private boolean fdj = true;
  private boolean fdk = true;
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
  
  static
  {
    eFM = "size".hashCode();
    eSP = "md5".hashCode();
    eHa = "packageName".hashCode();
    fcQ = "expireTime".hashCode();
    fdl = "randomTime".hashCode();
    fdm = "isFirst".hashCode();
    fdn = "nextCheckTime".hashCode();
    fdo = "isRunning".hashCode();
    fdp = "noWifi".hashCode();
    fdq = "noSdcard".hashCode();
    fdr = "noEnoughSpace".hashCode();
    fds = "lowBattery".hashCode();
    fdt = "continueDelay".hashCode();
    fdu = "SecondaryUrl".hashCode();
    fdv = "downloadInWidget".hashCode();
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
        break label65;
      }
      this.field_appId = paramCursor.getString(i);
      this.eED = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eNa == k)
      {
        this.field_downloadUrl = paramCursor.getString(i);
      }
      else if (eFM == k)
      {
        this.field_size = paramCursor.getLong(i);
      }
      else if (eSP == k)
      {
        this.field_md5 = paramCursor.getString(i);
      }
      else if (eHa == k)
      {
        this.field_packageName = paramCursor.getString(i);
      }
      else if (fcQ == k)
      {
        this.field_expireTime = paramCursor.getLong(i);
      }
      else if (fdl == k)
      {
        this.field_randomTime = paramCursor.getLong(i);
      }
      else
      {
        boolean bool;
        if (fdm == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_isFirst = bool;
            break;
          }
        }
        if (fdn == k)
        {
          this.field_nextCheckTime = paramCursor.getLong(i);
        }
        else
        {
          if (fdo == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_isRunning = bool;
              break;
            }
          }
          if (fdp == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_noWifi = bool;
              break;
            }
          }
          if (fdq == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_noSdcard = bool;
              break;
            }
          }
          if (fdr == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_noEnoughSpace = bool;
              break;
            }
          }
          if (fds == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_lowBattery = bool;
              break;
            }
          }
          if (fdt == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_continueDelay = bool;
              break;
            }
          }
          if (fdu == k)
          {
            this.field_SecondaryUrl = paramCursor.getString(i);
          }
          else
          {
            if (fdv == k)
            {
              if (paramCursor.getInt(i) != 0) {}
              for (bool = true;; bool = false)
              {
                this.field_downloadInWidget = bool;
                break;
              }
            }
            if (eXz == k) {
              this.field_sectionMd5Byte = paramCursor.getBlob(i);
            } else if (fdw == k) {
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
    if (this.eED) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.eMS) {
      localContentValues.put("downloadUrl", this.field_downloadUrl);
    }
    if (this.eFK) {
      localContentValues.put("size", Long.valueOf(this.field_size));
    }
    if (this.eSd) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.eGE) {
      localContentValues.put("packageName", this.field_packageName);
    }
    if (this.fcF) {
      localContentValues.put("expireTime", Long.valueOf(this.field_expireTime));
    }
    if (this.fcZ) {
      localContentValues.put("randomTime", Long.valueOf(this.field_randomTime));
    }
    if (this.fda) {
      localContentValues.put("isFirst", Boolean.valueOf(this.field_isFirst));
    }
    if (this.fdb) {
      localContentValues.put("nextCheckTime", Long.valueOf(this.field_nextCheckTime));
    }
    if (this.fdc) {
      localContentValues.put("isRunning", Boolean.valueOf(this.field_isRunning));
    }
    if (this.fdd) {
      localContentValues.put("noWifi", Boolean.valueOf(this.field_noWifi));
    }
    if (this.fde) {
      localContentValues.put("noSdcard", Boolean.valueOf(this.field_noSdcard));
    }
    if (this.fdf) {
      localContentValues.put("noEnoughSpace", Boolean.valueOf(this.field_noEnoughSpace));
    }
    if (this.fdg) {
      localContentValues.put("lowBattery", Boolean.valueOf(this.field_lowBattery));
    }
    if (this.fdh) {
      localContentValues.put("continueDelay", Boolean.valueOf(this.field_continueDelay));
    }
    if (this.fdi) {
      localContentValues.put("SecondaryUrl", this.field_SecondaryUrl);
    }
    if (this.fdj) {
      localContentValues.put("downloadInWidget", Boolean.valueOf(this.field_downloadInWidget));
    }
    if (this.eWW) {
      localContentValues.put("sectionMd5Byte", this.field_sectionMd5Byte);
    }
    if (this.fdk) {
      localContentValues.put("forceUpdateFlag", Integer.valueOf(this.field_forceUpdateFlag));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.cz
 * JD-Core Version:    0.7.0.1
 */
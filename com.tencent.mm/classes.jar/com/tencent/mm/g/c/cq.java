package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cq
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eBr;
  private static final int eGb = "sectionMd5Byte".hashCode();
  private static final int eKR;
  private static final int eKS;
  private static final int eKT;
  private static final int eKU;
  private static final int eKV;
  private static final int eKW;
  private static final int eKX;
  private static final int eKY;
  private static final int eKZ;
  private static final int eKw;
  private static final int eLa;
  private static final int eLb;
  private static final int eLc = "forceUpdateFlag".hashCode();
  private static final int enO = "appId".hashCode();
  private static final int eoH;
  private static final int epR;
  private static final int evD = "downloadUrl".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eAF = true;
  private boolean eFy = true;
  private boolean eKF = true;
  private boolean eKG = true;
  private boolean eKH = true;
  private boolean eKI = true;
  private boolean eKJ = true;
  private boolean eKK = true;
  private boolean eKL = true;
  private boolean eKM = true;
  private boolean eKN = true;
  private boolean eKO = true;
  private boolean eKP = true;
  private boolean eKQ = true;
  private boolean eKl = true;
  private boolean enx = true;
  private boolean eoF = true;
  private boolean epv = true;
  private boolean evv = true;
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
    eoH = "size".hashCode();
    eBr = "md5".hashCode();
    epR = "packageName".hashCode();
    eKw = "expireTime".hashCode();
    eKR = "randomTime".hashCode();
    eKS = "isFirst".hashCode();
    eKT = "nextCheckTime".hashCode();
    eKU = "isRunning".hashCode();
    eKV = "noWifi".hashCode();
    eKW = "noSdcard".hashCode();
    eKX = "noEnoughSpace".hashCode();
    eKY = "lowBattery".hashCode();
    eKZ = "continueDelay".hashCode();
    eLa = "SecondaryUrl".hashCode();
    eLb = "downloadInWidget".hashCode();
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
      if (enO != k) {
        break label65;
      }
      this.field_appId = paramCursor.getString(i);
      this.enx = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (evD == k)
      {
        this.field_downloadUrl = paramCursor.getString(i);
      }
      else if (eoH == k)
      {
        this.field_size = paramCursor.getLong(i);
      }
      else if (eBr == k)
      {
        this.field_md5 = paramCursor.getString(i);
      }
      else if (epR == k)
      {
        this.field_packageName = paramCursor.getString(i);
      }
      else if (eKw == k)
      {
        this.field_expireTime = paramCursor.getLong(i);
      }
      else if (eKR == k)
      {
        this.field_randomTime = paramCursor.getLong(i);
      }
      else
      {
        boolean bool;
        if (eKS == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_isFirst = bool;
            break;
          }
        }
        if (eKT == k)
        {
          this.field_nextCheckTime = paramCursor.getLong(i);
        }
        else
        {
          if (eKU == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_isRunning = bool;
              break;
            }
          }
          if (eKV == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_noWifi = bool;
              break;
            }
          }
          if (eKW == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_noSdcard = bool;
              break;
            }
          }
          if (eKX == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_noEnoughSpace = bool;
              break;
            }
          }
          if (eKY == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_lowBattery = bool;
              break;
            }
          }
          if (eKZ == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_continueDelay = bool;
              break;
            }
          }
          if (eLa == k)
          {
            this.field_SecondaryUrl = paramCursor.getString(i);
          }
          else
          {
            if (eLb == k)
            {
              if (paramCursor.getInt(i) != 0) {}
              for (bool = true;; bool = false)
              {
                this.field_downloadInWidget = bool;
                break;
              }
            }
            if (eGb == k) {
              this.field_sectionMd5Byte = paramCursor.getBlob(i);
            } else if (eLc == k) {
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
    if (this.enx) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.evv) {
      localContentValues.put("downloadUrl", this.field_downloadUrl);
    }
    if (this.eoF) {
      localContentValues.put("size", Long.valueOf(this.field_size));
    }
    if (this.eAF) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.epv) {
      localContentValues.put("packageName", this.field_packageName);
    }
    if (this.eKl) {
      localContentValues.put("expireTime", Long.valueOf(this.field_expireTime));
    }
    if (this.eKF) {
      localContentValues.put("randomTime", Long.valueOf(this.field_randomTime));
    }
    if (this.eKG) {
      localContentValues.put("isFirst", Boolean.valueOf(this.field_isFirst));
    }
    if (this.eKH) {
      localContentValues.put("nextCheckTime", Long.valueOf(this.field_nextCheckTime));
    }
    if (this.eKI) {
      localContentValues.put("isRunning", Boolean.valueOf(this.field_isRunning));
    }
    if (this.eKJ) {
      localContentValues.put("noWifi", Boolean.valueOf(this.field_noWifi));
    }
    if (this.eKK) {
      localContentValues.put("noSdcard", Boolean.valueOf(this.field_noSdcard));
    }
    if (this.eKL) {
      localContentValues.put("noEnoughSpace", Boolean.valueOf(this.field_noEnoughSpace));
    }
    if (this.eKM) {
      localContentValues.put("lowBattery", Boolean.valueOf(this.field_lowBattery));
    }
    if (this.eKN) {
      localContentValues.put("continueDelay", Boolean.valueOf(this.field_continueDelay));
    }
    if (this.eKO) {
      localContentValues.put("SecondaryUrl", this.field_SecondaryUrl);
    }
    if (this.eKP) {
      localContentValues.put("downloadInWidget", Boolean.valueOf(this.field_downloadInWidget));
    }
    if (this.eFy) {
      localContentValues.put("sectionMd5Byte", this.field_sectionMd5Byte);
    }
    if (this.eKQ) {
      localContentValues.put("forceUpdateFlag", Integer.valueOf(this.field_forceUpdateFlag));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.cq
 * JD-Core Version:    0.7.0.1
 */
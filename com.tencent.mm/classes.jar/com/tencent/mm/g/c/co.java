package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class co
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eDH = "sectionMd5Byte".hashCode();
  private static final int eHE;
  private static final int eHZ;
  private static final int eIa;
  private static final int eIb;
  private static final int eIc;
  private static final int eId;
  private static final int eIe;
  private static final int eIf;
  private static final int eIg;
  private static final int eIh;
  private static final int eIi;
  private static final int eIj;
  private static final int eIk = "forceUpdateFlag".hashCode();
  private static final int elJ = "appId".hashCode();
  private static final int emB;
  private static final int enM;
  private static final int etz = "downloadUrl".hashCode();
  private static final int eyX;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eDe = true;
  private boolean eHN = true;
  private boolean eHO = true;
  private boolean eHP = true;
  private boolean eHQ = true;
  private boolean eHR = true;
  private boolean eHS = true;
  private boolean eHT = true;
  private boolean eHU = true;
  private boolean eHV = true;
  private boolean eHW = true;
  private boolean eHX = true;
  private boolean eHY = true;
  private boolean eHt = true;
  private boolean els = true;
  private boolean emz = true;
  private boolean enq = true;
  private boolean etr = true;
  private boolean eyl = true;
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
    emB = "size".hashCode();
    eyX = "md5".hashCode();
    enM = "packageName".hashCode();
    eHE = "expireTime".hashCode();
    eHZ = "randomTime".hashCode();
    eIa = "isFirst".hashCode();
    eIb = "nextCheckTime".hashCode();
    eIc = "isRunning".hashCode();
    eId = "noWifi".hashCode();
    eIe = "noSdcard".hashCode();
    eIf = "noEnoughSpace".hashCode();
    eIg = "lowBattery".hashCode();
    eIh = "continueDelay".hashCode();
    eIi = "SecondaryUrl".hashCode();
    eIj = "downloadInWidget".hashCode();
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
      if (elJ != k) {
        break label65;
      }
      this.field_appId = paramCursor.getString(i);
      this.els = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (etz == k)
      {
        this.field_downloadUrl = paramCursor.getString(i);
      }
      else if (emB == k)
      {
        this.field_size = paramCursor.getLong(i);
      }
      else if (eyX == k)
      {
        this.field_md5 = paramCursor.getString(i);
      }
      else if (enM == k)
      {
        this.field_packageName = paramCursor.getString(i);
      }
      else if (eHE == k)
      {
        this.field_expireTime = paramCursor.getLong(i);
      }
      else if (eHZ == k)
      {
        this.field_randomTime = paramCursor.getLong(i);
      }
      else
      {
        boolean bool;
        if (eIa == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_isFirst = bool;
            break;
          }
        }
        if (eIb == k)
        {
          this.field_nextCheckTime = paramCursor.getLong(i);
        }
        else
        {
          if (eIc == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_isRunning = bool;
              break;
            }
          }
          if (eId == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_noWifi = bool;
              break;
            }
          }
          if (eIe == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_noSdcard = bool;
              break;
            }
          }
          if (eIf == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_noEnoughSpace = bool;
              break;
            }
          }
          if (eIg == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_lowBattery = bool;
              break;
            }
          }
          if (eIh == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_continueDelay = bool;
              break;
            }
          }
          if (eIi == k)
          {
            this.field_SecondaryUrl = paramCursor.getString(i);
          }
          else
          {
            if (eIj == k)
            {
              if (paramCursor.getInt(i) != 0) {}
              for (bool = true;; bool = false)
              {
                this.field_downloadInWidget = bool;
                break;
              }
            }
            if (eDH == k) {
              this.field_sectionMd5Byte = paramCursor.getBlob(i);
            } else if (eIk == k) {
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
    if (this.els) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.etr) {
      localContentValues.put("downloadUrl", this.field_downloadUrl);
    }
    if (this.emz) {
      localContentValues.put("size", Long.valueOf(this.field_size));
    }
    if (this.eyl) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.enq) {
      localContentValues.put("packageName", this.field_packageName);
    }
    if (this.eHt) {
      localContentValues.put("expireTime", Long.valueOf(this.field_expireTime));
    }
    if (this.eHN) {
      localContentValues.put("randomTime", Long.valueOf(this.field_randomTime));
    }
    if (this.eHO) {
      localContentValues.put("isFirst", Boolean.valueOf(this.field_isFirst));
    }
    if (this.eHP) {
      localContentValues.put("nextCheckTime", Long.valueOf(this.field_nextCheckTime));
    }
    if (this.eHQ) {
      localContentValues.put("isRunning", Boolean.valueOf(this.field_isRunning));
    }
    if (this.eHR) {
      localContentValues.put("noWifi", Boolean.valueOf(this.field_noWifi));
    }
    if (this.eHS) {
      localContentValues.put("noSdcard", Boolean.valueOf(this.field_noSdcard));
    }
    if (this.eHT) {
      localContentValues.put("noEnoughSpace", Boolean.valueOf(this.field_noEnoughSpace));
    }
    if (this.eHU) {
      localContentValues.put("lowBattery", Boolean.valueOf(this.field_lowBattery));
    }
    if (this.eHV) {
      localContentValues.put("continueDelay", Boolean.valueOf(this.field_continueDelay));
    }
    if (this.eHW) {
      localContentValues.put("SecondaryUrl", this.field_SecondaryUrl);
    }
    if (this.eHX) {
      localContentValues.put("downloadInWidget", Boolean.valueOf(this.field_downloadInWidget));
    }
    if (this.eDe) {
      localContentValues.put("sectionMd5Byte", this.field_sectionMd5Byte);
    }
    if (this.eHY) {
      localContentValues.put("forceUpdateFlag", Integer.valueOf(this.field_forceUpdateFlag));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.co
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cz
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eGD = "appId".hashCode();
  private static final int eHv;
  private static final int eIJ;
  private static final int eOL = "downloadUrl".hashCode();
  private static final int eUA;
  private static final int eZk = "sectionMd5Byte".hashCode();
  private static final int feI;
  private static final int ffe;
  private static final int fff;
  private static final int ffg;
  private static final int ffh;
  private static final int ffi;
  private static final int ffj;
  private static final int ffk;
  private static final int ffl;
  private static final int ffm;
  private static final int ffn;
  private static final int ffo;
  private static final int ffp = "forceUpdateFlag".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eGm = true;
  private boolean eHt = true;
  private boolean eIn = true;
  private boolean eOD = true;
  private boolean eTO = true;
  private boolean eYH = true;
  private boolean feS = true;
  private boolean feT = true;
  private boolean feU = true;
  private boolean feV = true;
  private boolean feW = true;
  private boolean feX = true;
  private boolean feY = true;
  private boolean feZ = true;
  private boolean few = true;
  private boolean ffa = true;
  private boolean ffb = true;
  private boolean ffc = true;
  private boolean ffd = true;
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
    eHv = "size".hashCode();
    eUA = "md5".hashCode();
    eIJ = "packageName".hashCode();
    feI = "expireTime".hashCode();
    ffe = "randomTime".hashCode();
    fff = "isFirst".hashCode();
    ffg = "nextCheckTime".hashCode();
    ffh = "isRunning".hashCode();
    ffi = "noWifi".hashCode();
    ffj = "noSdcard".hashCode();
    ffk = "noEnoughSpace".hashCode();
    ffl = "lowBattery".hashCode();
    ffm = "continueDelay".hashCode();
    ffn = "SecondaryUrl".hashCode();
    ffo = "downloadInWidget".hashCode();
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
      if (eGD != k) {
        break label65;
      }
      this.field_appId = paramCursor.getString(i);
      this.eGm = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eOL == k)
      {
        this.field_downloadUrl = paramCursor.getString(i);
      }
      else if (eHv == k)
      {
        this.field_size = paramCursor.getLong(i);
      }
      else if (eUA == k)
      {
        this.field_md5 = paramCursor.getString(i);
      }
      else if (eIJ == k)
      {
        this.field_packageName = paramCursor.getString(i);
      }
      else if (feI == k)
      {
        this.field_expireTime = paramCursor.getLong(i);
      }
      else if (ffe == k)
      {
        this.field_randomTime = paramCursor.getLong(i);
      }
      else
      {
        boolean bool;
        if (fff == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_isFirst = bool;
            break;
          }
        }
        if (ffg == k)
        {
          this.field_nextCheckTime = paramCursor.getLong(i);
        }
        else
        {
          if (ffh == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_isRunning = bool;
              break;
            }
          }
          if (ffi == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_noWifi = bool;
              break;
            }
          }
          if (ffj == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_noSdcard = bool;
              break;
            }
          }
          if (ffk == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_noEnoughSpace = bool;
              break;
            }
          }
          if (ffl == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_lowBattery = bool;
              break;
            }
          }
          if (ffm == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_continueDelay = bool;
              break;
            }
          }
          if (ffn == k)
          {
            this.field_SecondaryUrl = paramCursor.getString(i);
          }
          else
          {
            if (ffo == k)
            {
              if (paramCursor.getInt(i) != 0) {}
              for (bool = true;; bool = false)
              {
                this.field_downloadInWidget = bool;
                break;
              }
            }
            if (eZk == k) {
              this.field_sectionMd5Byte = paramCursor.getBlob(i);
            } else if (ffp == k) {
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
    if (this.eGm) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.eOD) {
      localContentValues.put("downloadUrl", this.field_downloadUrl);
    }
    if (this.eHt) {
      localContentValues.put("size", Long.valueOf(this.field_size));
    }
    if (this.eTO) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.eIn) {
      localContentValues.put("packageName", this.field_packageName);
    }
    if (this.few) {
      localContentValues.put("expireTime", Long.valueOf(this.field_expireTime));
    }
    if (this.feS) {
      localContentValues.put("randomTime", Long.valueOf(this.field_randomTime));
    }
    if (this.feT) {
      localContentValues.put("isFirst", Boolean.valueOf(this.field_isFirst));
    }
    if (this.feU) {
      localContentValues.put("nextCheckTime", Long.valueOf(this.field_nextCheckTime));
    }
    if (this.feV) {
      localContentValues.put("isRunning", Boolean.valueOf(this.field_isRunning));
    }
    if (this.feW) {
      localContentValues.put("noWifi", Boolean.valueOf(this.field_noWifi));
    }
    if (this.feX) {
      localContentValues.put("noSdcard", Boolean.valueOf(this.field_noSdcard));
    }
    if (this.feY) {
      localContentValues.put("noEnoughSpace", Boolean.valueOf(this.field_noEnoughSpace));
    }
    if (this.feZ) {
      localContentValues.put("lowBattery", Boolean.valueOf(this.field_lowBattery));
    }
    if (this.ffa) {
      localContentValues.put("continueDelay", Boolean.valueOf(this.field_continueDelay));
    }
    if (this.ffb) {
      localContentValues.put("SecondaryUrl", this.field_SecondaryUrl);
    }
    if (this.ffc) {
      localContentValues.put("downloadInWidget", Boolean.valueOf(this.field_downloadInWidget));
    }
    if (this.eYH) {
      localContentValues.put("sectionMd5Byte", this.field_sectionMd5Byte);
    }
    if (this.ffd) {
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
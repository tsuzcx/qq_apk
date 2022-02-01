package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class df
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fCO = "sectionMd5Byte".hashCode();
  private static final int fJH;
  private static final int fJI;
  private static final int fJJ;
  private static final int fJK;
  private static final int fJL;
  private static final int fJM;
  private static final int fJN;
  private static final int fJO;
  private static final int fJP;
  private static final int fJQ;
  private static final int fJR;
  private static final int fJS = "forceUpdateFlag".hashCode();
  private static final int fJb;
  private static final int fkX;
  private static final int fkj = "appId".hashCode();
  private static final int fml;
  private static final int fss = "downloadUrl".hashCode();
  private static final int fyf;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fCk = true;
  private boolean fIP = true;
  private boolean fJA = true;
  private boolean fJB = true;
  private boolean fJC = true;
  private boolean fJD = true;
  private boolean fJE = true;
  private boolean fJF = true;
  private boolean fJG = true;
  private boolean fJv = true;
  private boolean fJw = true;
  private boolean fJx = true;
  private boolean fJy = true;
  private boolean fJz = true;
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
  private boolean fjS = true;
  private boolean fkV = true;
  private boolean flP = true;
  private boolean fsk = true;
  private boolean fxt = true;
  
  static
  {
    fkX = "size".hashCode();
    fyf = "md5".hashCode();
    fml = "packageName".hashCode();
    fJb = "expireTime".hashCode();
    fJH = "randomTime".hashCode();
    fJI = "isFirst".hashCode();
    fJJ = "nextCheckTime".hashCode();
    fJK = "isRunning".hashCode();
    fJL = "noWifi".hashCode();
    fJM = "noSdcard".hashCode();
    fJN = "noEnoughSpace".hashCode();
    fJO = "lowBattery".hashCode();
    fJP = "continueDelay".hashCode();
    fJQ = "SecondaryUrl".hashCode();
    fJR = "downloadInWidget".hashCode();
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
      if (fss == k)
      {
        this.field_downloadUrl = paramCursor.getString(i);
      }
      else if (fkX == k)
      {
        this.field_size = paramCursor.getLong(i);
      }
      else if (fyf == k)
      {
        this.field_md5 = paramCursor.getString(i);
      }
      else if (fml == k)
      {
        this.field_packageName = paramCursor.getString(i);
      }
      else if (fJb == k)
      {
        this.field_expireTime = paramCursor.getLong(i);
      }
      else if (fJH == k)
      {
        this.field_randomTime = paramCursor.getLong(i);
      }
      else
      {
        boolean bool;
        if (fJI == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_isFirst = bool;
            break;
          }
        }
        if (fJJ == k)
        {
          this.field_nextCheckTime = paramCursor.getLong(i);
        }
        else
        {
          if (fJK == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_isRunning = bool;
              break;
            }
          }
          if (fJL == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_noWifi = bool;
              break;
            }
          }
          if (fJM == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_noSdcard = bool;
              break;
            }
          }
          if (fJN == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_noEnoughSpace = bool;
              break;
            }
          }
          if (fJO == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_lowBattery = bool;
              break;
            }
          }
          if (fJP == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_continueDelay = bool;
              break;
            }
          }
          if (fJQ == k)
          {
            this.field_SecondaryUrl = paramCursor.getString(i);
          }
          else
          {
            if (fJR == k)
            {
              if (paramCursor.getInt(i) != 0) {}
              for (bool = true;; bool = false)
              {
                this.field_downloadInWidget = bool;
                break;
              }
            }
            if (fCO == k) {
              this.field_sectionMd5Byte = paramCursor.getBlob(i);
            } else if (fJS == k) {
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
    if (this.fjS) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.fsk) {
      localContentValues.put("downloadUrl", this.field_downloadUrl);
    }
    if (this.fkV) {
      localContentValues.put("size", Long.valueOf(this.field_size));
    }
    if (this.fxt) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.flP) {
      localContentValues.put("packageName", this.field_packageName);
    }
    if (this.fIP) {
      localContentValues.put("expireTime", Long.valueOf(this.field_expireTime));
    }
    if (this.fJv) {
      localContentValues.put("randomTime", Long.valueOf(this.field_randomTime));
    }
    if (this.fJw) {
      localContentValues.put("isFirst", Boolean.valueOf(this.field_isFirst));
    }
    if (this.fJx) {
      localContentValues.put("nextCheckTime", Long.valueOf(this.field_nextCheckTime));
    }
    if (this.fJy) {
      localContentValues.put("isRunning", Boolean.valueOf(this.field_isRunning));
    }
    if (this.fJz) {
      localContentValues.put("noWifi", Boolean.valueOf(this.field_noWifi));
    }
    if (this.fJA) {
      localContentValues.put("noSdcard", Boolean.valueOf(this.field_noSdcard));
    }
    if (this.fJB) {
      localContentValues.put("noEnoughSpace", Boolean.valueOf(this.field_noEnoughSpace));
    }
    if (this.fJC) {
      localContentValues.put("lowBattery", Boolean.valueOf(this.field_lowBattery));
    }
    if (this.fJD) {
      localContentValues.put("continueDelay", Boolean.valueOf(this.field_continueDelay));
    }
    if (this.fJE) {
      localContentValues.put("SecondaryUrl", this.field_SecondaryUrl);
    }
    if (this.fJF) {
      localContentValues.put("downloadInWidget", Boolean.valueOf(this.field_downloadInWidget));
    }
    if (this.fCk) {
      localContentValues.put("sectionMd5Byte", this.field_sectionMd5Byte);
    }
    if (this.fJG) {
      localContentValues.put("forceUpdateFlag", Integer.valueOf(this.field_forceUpdateFlag));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.c.df
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cc
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dAN = "expireTime".hashCode();
  private static final int dBe = "randomTime".hashCode();
  private static final int dBf = "isFirst".hashCode();
  private static final int dBg = "nextCheckTime".hashCode();
  private static final int dBh = "isRunning".hashCode();
  private static final int dBi = "noWifi".hashCode();
  private static final int dBj = "noSdcard".hashCode();
  private static final int dBk = "noEnoughSpace".hashCode();
  private static final int dBl = "lowBattery".hashCode();
  private static final int dBm = "continueDelay".hashCode();
  private static final int dBn = "SecondaryUrl".hashCode();
  private static final int dBo = "downloadInWidget".hashCode();
  private static final int dhB = "appId".hashCode();
  private static final int dij;
  private static final int djq;
  private static final int doI = "downloadUrl".hashCode();
  private static final int dtX;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dAF = true;
  private boolean dAT = true;
  private boolean dAU = true;
  private boolean dAV = true;
  private boolean dAW = true;
  private boolean dAX = true;
  private boolean dAY = true;
  private boolean dAZ = true;
  private boolean dBa = true;
  private boolean dBb = true;
  private boolean dBc = true;
  private boolean dBd = true;
  private boolean dhk = true;
  private boolean diT = true;
  private boolean dih = true;
  private boolean doA = true;
  private boolean dtk = true;
  public String field_SecondaryUrl;
  public String field_appId;
  public boolean field_continueDelay;
  public boolean field_downloadInWidget;
  public String field_downloadUrl;
  public long field_expireTime;
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
  public long field_size;
  
  static
  {
    dij = "size".hashCode();
    dtX = "md5".hashCode();
    djq = "packageName".hashCode();
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
      if (dhB != k) {
        break label65;
      }
      this.field_appId = paramCursor.getString(i);
      this.dhk = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (doI == k)
      {
        this.field_downloadUrl = paramCursor.getString(i);
      }
      else if (dij == k)
      {
        this.field_size = paramCursor.getLong(i);
      }
      else if (dtX == k)
      {
        this.field_md5 = paramCursor.getString(i);
      }
      else if (djq == k)
      {
        this.field_packageName = paramCursor.getString(i);
      }
      else if (dAN == k)
      {
        this.field_expireTime = paramCursor.getLong(i);
      }
      else if (dBe == k)
      {
        this.field_randomTime = paramCursor.getLong(i);
      }
      else
      {
        boolean bool;
        if (dBf == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_isFirst = bool;
            break;
          }
        }
        if (dBg == k)
        {
          this.field_nextCheckTime = paramCursor.getLong(i);
        }
        else
        {
          if (dBh == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_isRunning = bool;
              break;
            }
          }
          if (dBi == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_noWifi = bool;
              break;
            }
          }
          if (dBj == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_noSdcard = bool;
              break;
            }
          }
          if (dBk == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_noEnoughSpace = bool;
              break;
            }
          }
          if (dBl == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_lowBattery = bool;
              break;
            }
          }
          if (dBm == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_continueDelay = bool;
              break;
            }
          }
          if (dBn == k)
          {
            this.field_SecondaryUrl = paramCursor.getString(i);
          }
          else
          {
            if (dBo == k)
            {
              if (paramCursor.getInt(i) != 0) {}
              for (bool = true;; bool = false)
              {
                this.field_downloadInWidget = bool;
                break;
              }
            }
            if (rowid_HASHCODE == k) {
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
    if (this.dhk) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.doA) {
      localContentValues.put("downloadUrl", this.field_downloadUrl);
    }
    if (this.dih) {
      localContentValues.put("size", Long.valueOf(this.field_size));
    }
    if (this.dtk) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.diT) {
      localContentValues.put("packageName", this.field_packageName);
    }
    if (this.dAF) {
      localContentValues.put("expireTime", Long.valueOf(this.field_expireTime));
    }
    if (this.dAT) {
      localContentValues.put("randomTime", Long.valueOf(this.field_randomTime));
    }
    if (this.dAU) {
      localContentValues.put("isFirst", Boolean.valueOf(this.field_isFirst));
    }
    if (this.dAV) {
      localContentValues.put("nextCheckTime", Long.valueOf(this.field_nextCheckTime));
    }
    if (this.dAW) {
      localContentValues.put("isRunning", Boolean.valueOf(this.field_isRunning));
    }
    if (this.dAX) {
      localContentValues.put("noWifi", Boolean.valueOf(this.field_noWifi));
    }
    if (this.dAY) {
      localContentValues.put("noSdcard", Boolean.valueOf(this.field_noSdcard));
    }
    if (this.dAZ) {
      localContentValues.put("noEnoughSpace", Boolean.valueOf(this.field_noEnoughSpace));
    }
    if (this.dBa) {
      localContentValues.put("lowBattery", Boolean.valueOf(this.field_lowBattery));
    }
    if (this.dBb) {
      localContentValues.put("continueDelay", Boolean.valueOf(this.field_continueDelay));
    }
    if (this.dBc) {
      localContentValues.put("SecondaryUrl", this.field_SecondaryUrl);
    }
    if (this.dBd) {
      localContentValues.put("downloadInWidget", Boolean.valueOf(this.field_downloadInWidget));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.c.cc
 * JD-Core Version:    0.7.0.1
 */
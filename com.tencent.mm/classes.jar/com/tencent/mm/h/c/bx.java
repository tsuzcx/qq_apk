package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bx
  extends c
{
  private static final int cAF;
  private static final int cFC;
  private static final int cKZ = "expireTime".hashCode();
  private static final int cLp = "randomTime".hashCode();
  private static final int cLq = "isFirst".hashCode();
  private static final int cLr = "nextCheckTime".hashCode();
  private static final int cLs = "isRunning".hashCode();
  private static final int cLt = "noWifi".hashCode();
  private static final int cLu = "noSdcard".hashCode();
  private static final int cLv = "noEnoughSpace".hashCode();
  private static final int cLw = "lowBattery".hashCode();
  private static final int cLx = "continueDelay".hashCode();
  private static final int cLy = "SecondaryUrl".hashCode();
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int ctS;
  private static final int ctl = "appId".hashCode();
  private static final int cve;
  private boolean cAx = true;
  private boolean cEZ = true;
  private boolean cKR = true;
  private boolean cLf = true;
  private boolean cLg = true;
  private boolean cLh = true;
  private boolean cLi = true;
  private boolean cLj = true;
  private boolean cLk = true;
  private boolean cLl = true;
  private boolean cLm = true;
  private boolean cLn = true;
  private boolean cLo = true;
  private boolean csU = true;
  private boolean ctQ = true;
  private boolean cuH = true;
  public String field_SecondaryUrl;
  public String field_appId;
  public boolean field_continueDelay;
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
    cAF = "downloadUrl".hashCode();
    ctS = "size".hashCode();
    cFC = "md5".hashCode();
    cve = "packageName".hashCode();
  }
  
  public final void d(Cursor paramCursor)
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
      if (ctl != k) {
        break label65;
      }
      this.field_appId = paramCursor.getString(i);
      this.csU = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (cAF == k)
      {
        this.field_downloadUrl = paramCursor.getString(i);
      }
      else if (ctS == k)
      {
        this.field_size = paramCursor.getLong(i);
      }
      else if (cFC == k)
      {
        this.field_md5 = paramCursor.getString(i);
      }
      else if (cve == k)
      {
        this.field_packageName = paramCursor.getString(i);
      }
      else if (cKZ == k)
      {
        this.field_expireTime = paramCursor.getLong(i);
      }
      else if (cLp == k)
      {
        this.field_randomTime = paramCursor.getLong(i);
      }
      else
      {
        boolean bool;
        if (cLq == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_isFirst = bool;
            break;
          }
        }
        if (cLr == k)
        {
          this.field_nextCheckTime = paramCursor.getLong(i);
        }
        else
        {
          if (cLs == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_isRunning = bool;
              break;
            }
          }
          if (cLt == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_noWifi = bool;
              break;
            }
          }
          if (cLu == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_noSdcard = bool;
              break;
            }
          }
          if (cLv == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_noEnoughSpace = bool;
              break;
            }
          }
          if (cLw == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_lowBattery = bool;
              break;
            }
          }
          if (cLx == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_continueDelay = bool;
              break;
            }
          }
          if (cLy == k) {
            this.field_SecondaryUrl = paramCursor.getString(i);
          } else if (crh == k) {
            this.ujK = paramCursor.getLong(i);
          }
        }
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.csU) {
      localContentValues.put("appId", this.field_appId);
    }
    if (this.cAx) {
      localContentValues.put("downloadUrl", this.field_downloadUrl);
    }
    if (this.ctQ) {
      localContentValues.put("size", Long.valueOf(this.field_size));
    }
    if (this.cEZ) {
      localContentValues.put("md5", this.field_md5);
    }
    if (this.cuH) {
      localContentValues.put("packageName", this.field_packageName);
    }
    if (this.cKR) {
      localContentValues.put("expireTime", Long.valueOf(this.field_expireTime));
    }
    if (this.cLf) {
      localContentValues.put("randomTime", Long.valueOf(this.field_randomTime));
    }
    if (this.cLg) {
      localContentValues.put("isFirst", Boolean.valueOf(this.field_isFirst));
    }
    if (this.cLh) {
      localContentValues.put("nextCheckTime", Long.valueOf(this.field_nextCheckTime));
    }
    if (this.cLi) {
      localContentValues.put("isRunning", Boolean.valueOf(this.field_isRunning));
    }
    if (this.cLj) {
      localContentValues.put("noWifi", Boolean.valueOf(this.field_noWifi));
    }
    if (this.cLk) {
      localContentValues.put("noSdcard", Boolean.valueOf(this.field_noSdcard));
    }
    if (this.cLl) {
      localContentValues.put("noEnoughSpace", Boolean.valueOf(this.field_noEnoughSpace));
    }
    if (this.cLm) {
      localContentValues.put("lowBattery", Boolean.valueOf(this.field_lowBattery));
    }
    if (this.cLn) {
      localContentValues.put("continueDelay", Boolean.valueOf(this.field_continueDelay));
    }
    if (this.cLo) {
      localContentValues.put("SecondaryUrl", this.field_SecondaryUrl);
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.h.c.bx
 * JD-Core Version:    0.7.0.1
 */
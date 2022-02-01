package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class cs
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fCJ;
  private static final int fGS = "ssidmd5".hashCode();
  private static final int fGT;
  private static final int fGU;
  private static final int fGV = "wifiType".hashCode();
  private static final int fGW = "action".hashCode();
  private static final int fGX = "showUrl".hashCode();
  private static final int fGY = "showWordEn".hashCode();
  private static final int fGZ = "showWordCn".hashCode();
  private static final int fGk;
  private static final int fHa = "showWordTw".hashCode();
  private static final int fHb = "mac".hashCode();
  private static final int fHc = "verifyResult".hashCode();
  private static final int fnB;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fCf = true;
  private boolean fGH = true;
  private boolean fGI = true;
  private boolean fGJ = true;
  private boolean fGK = true;
  private boolean fGL = true;
  private boolean fGM = true;
  private boolean fGN = true;
  private boolean fGO = true;
  private boolean fGP = true;
  private boolean fGQ = true;
  private boolean fGR = true;
  private boolean fGe = true;
  public int field_action;
  public int field_connectState;
  public long field_expiredTime;
  public String field_mac;
  public String field_mid;
  public String field_showUrl;
  public String field_showWordCn;
  public String field_showWordEn;
  public String field_showWordTw;
  public String field_ssid;
  public String field_ssidmd5;
  public String field_url;
  public int field_verifyResult;
  public int field_wifiType;
  private boolean fnx = true;
  
  static
  {
    fCJ = "ssid".hashCode();
    fGT = "mid".hashCode();
    fnB = "url".hashCode();
    fGU = "connectState".hashCode();
    fGk = "expiredTime".hashCode();
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
      if (fGS != k) {
        break label65;
      }
      this.field_ssidmd5 = paramCursor.getString(i);
      this.fGH = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fCJ == k) {
        this.field_ssid = paramCursor.getString(i);
      } else if (fGT == k) {
        this.field_mid = paramCursor.getString(i);
      } else if (fnB == k) {
        this.field_url = paramCursor.getString(i);
      } else if (fGU == k) {
        this.field_connectState = paramCursor.getInt(i);
      } else if (fGk == k) {
        this.field_expiredTime = paramCursor.getLong(i);
      } else if (fGV == k) {
        this.field_wifiType = paramCursor.getInt(i);
      } else if (fGW == k) {
        this.field_action = paramCursor.getInt(i);
      } else if (fGX == k) {
        this.field_showUrl = paramCursor.getString(i);
      } else if (fGY == k) {
        this.field_showWordEn = paramCursor.getString(i);
      } else if (fGZ == k) {
        this.field_showWordCn = paramCursor.getString(i);
      } else if (fHa == k) {
        this.field_showWordTw = paramCursor.getString(i);
      } else if (fHb == k) {
        this.field_mac = paramCursor.getString(i);
      } else if (fHc == k) {
        this.field_verifyResult = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fGH) {
      localContentValues.put("ssidmd5", this.field_ssidmd5);
    }
    if (this.fCf) {
      localContentValues.put("ssid", this.field_ssid);
    }
    if (this.fGI) {
      localContentValues.put("mid", this.field_mid);
    }
    if (this.fnx) {
      localContentValues.put("url", this.field_url);
    }
    if (this.fGJ) {
      localContentValues.put("connectState", Integer.valueOf(this.field_connectState));
    }
    if (this.fGe) {
      localContentValues.put("expiredTime", Long.valueOf(this.field_expiredTime));
    }
    if (this.fGK) {
      localContentValues.put("wifiType", Integer.valueOf(this.field_wifiType));
    }
    if (this.fGL) {
      localContentValues.put("action", Integer.valueOf(this.field_action));
    }
    if (this.fGM) {
      localContentValues.put("showUrl", this.field_showUrl);
    }
    if (this.fGN) {
      localContentValues.put("showWordEn", this.field_showWordEn);
    }
    if (this.fGO) {
      localContentValues.put("showWordCn", this.field_showWordCn);
    }
    if (this.fGP) {
      localContentValues.put("showWordTw", this.field_showWordTw);
    }
    if (this.fGQ) {
      localContentValues.put("mac", this.field_mac);
    }
    if (this.fGR) {
      localContentValues.put("verifyResult", Integer.valueOf(this.field_verifyResult));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.c.cs
 * JD-Core Version:    0.7.0.1
 */
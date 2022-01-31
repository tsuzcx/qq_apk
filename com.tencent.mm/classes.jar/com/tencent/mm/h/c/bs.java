package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bs
  extends c
{
  private static final int cJM;
  private static final int cJN;
  private static final int cJO;
  private static final int cJP = "connectState".hashCode();
  private static final int cJQ = "expiredTime".hashCode();
  private static final int cJR = "wifiType".hashCode();
  private static final int cJS = "action".hashCode();
  private static final int cJT = "showUrl".hashCode();
  private static final int cJU = "showWordEn".hashCode();
  private static final int cJV = "showWordCn".hashCode();
  private static final int cJW = "showWordTw".hashCode();
  private static final int cJX = "mac".hashCode();
  private static final int cJY = "verifyResult".hashCode();
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int cwu;
  private boolean cJA = true;
  private boolean cJB = true;
  private boolean cJC = true;
  private boolean cJD = true;
  private boolean cJE = true;
  private boolean cJF = true;
  private boolean cJG = true;
  private boolean cJH = true;
  private boolean cJI = true;
  private boolean cJJ = true;
  private boolean cJK = true;
  private boolean cJL = true;
  private boolean cJz = true;
  private boolean cwp = true;
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
  
  static
  {
    cJM = "ssidmd5".hashCode();
    cJN = "ssid".hashCode();
    cJO = "mid".hashCode();
    cwu = "url".hashCode();
  }
  
  public final void d(Cursor paramCursor)
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
      if (cJM != k) {
        break label65;
      }
      this.field_ssidmd5 = paramCursor.getString(i);
      this.cJz = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (cJN == k) {
        this.field_ssid = paramCursor.getString(i);
      } else if (cJO == k) {
        this.field_mid = paramCursor.getString(i);
      } else if (cwu == k) {
        this.field_url = paramCursor.getString(i);
      } else if (cJP == k) {
        this.field_connectState = paramCursor.getInt(i);
      } else if (cJQ == k) {
        this.field_expiredTime = paramCursor.getLong(i);
      } else if (cJR == k) {
        this.field_wifiType = paramCursor.getInt(i);
      } else if (cJS == k) {
        this.field_action = paramCursor.getInt(i);
      } else if (cJT == k) {
        this.field_showUrl = paramCursor.getString(i);
      } else if (cJU == k) {
        this.field_showWordEn = paramCursor.getString(i);
      } else if (cJV == k) {
        this.field_showWordCn = paramCursor.getString(i);
      } else if (cJW == k) {
        this.field_showWordTw = paramCursor.getString(i);
      } else if (cJX == k) {
        this.field_mac = paramCursor.getString(i);
      } else if (cJY == k) {
        this.field_verifyResult = paramCursor.getInt(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cJz) {
      localContentValues.put("ssidmd5", this.field_ssidmd5);
    }
    if (this.cJA) {
      localContentValues.put("ssid", this.field_ssid);
    }
    if (this.cJB) {
      localContentValues.put("mid", this.field_mid);
    }
    if (this.cwp) {
      localContentValues.put("url", this.field_url);
    }
    if (this.cJC) {
      localContentValues.put("connectState", Integer.valueOf(this.field_connectState));
    }
    if (this.cJD) {
      localContentValues.put("expiredTime", Long.valueOf(this.field_expiredTime));
    }
    if (this.cJE) {
      localContentValues.put("wifiType", Integer.valueOf(this.field_wifiType));
    }
    if (this.cJF) {
      localContentValues.put("action", Integer.valueOf(this.field_action));
    }
    if (this.cJG) {
      localContentValues.put("showUrl", this.field_showUrl);
    }
    if (this.cJH) {
      localContentValues.put("showWordEn", this.field_showWordEn);
    }
    if (this.cJI) {
      localContentValues.put("showWordCn", this.field_showWordCn);
    }
    if (this.cJJ) {
      localContentValues.put("showWordTw", this.field_showWordTw);
    }
    if (this.cJK) {
      localContentValues.put("mac", this.field_mac);
    }
    if (this.cJL) {
      localContentValues.put("verifyResult", Integer.valueOf(this.field_verifyResult));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.h.c.bs
 * JD-Core Version:    0.7.0.1
 */
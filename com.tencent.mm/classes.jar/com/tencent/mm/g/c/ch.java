package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ch
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eDC;
  private static final int eFH = "ssidmd5".hashCode();
  private static final int eFI;
  private static final int eFJ = "connectState".hashCode();
  private static final int eFK = "expiredTime".hashCode();
  private static final int eFL = "wifiType".hashCode();
  private static final int eFM = "action".hashCode();
  private static final int eFN = "showUrl".hashCode();
  private static final int eFO = "showWordEn".hashCode();
  private static final int eFP = "showWordCn".hashCode();
  private static final int eFQ = "showWordTw".hashCode();
  private static final int eFR = "mac".hashCode();
  private static final int eFS = "verifyResult".hashCode();
  private static final int eoZ;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eCZ = true;
  private boolean eFA = true;
  private boolean eFB = true;
  private boolean eFC = true;
  private boolean eFD = true;
  private boolean eFE = true;
  private boolean eFF = true;
  private boolean eFG = true;
  private boolean eFv = true;
  private boolean eFw = true;
  private boolean eFx = true;
  private boolean eFy = true;
  private boolean eFz = true;
  private boolean eoV = true;
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
    eDC = "ssid".hashCode();
    eFI = "mid".hashCode();
    eoZ = "url".hashCode();
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
      if (eFH != k) {
        break label65;
      }
      this.field_ssidmd5 = paramCursor.getString(i);
      this.eFv = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eDC == k) {
        this.field_ssid = paramCursor.getString(i);
      } else if (eFI == k) {
        this.field_mid = paramCursor.getString(i);
      } else if (eoZ == k) {
        this.field_url = paramCursor.getString(i);
      } else if (eFJ == k) {
        this.field_connectState = paramCursor.getInt(i);
      } else if (eFK == k) {
        this.field_expiredTime = paramCursor.getLong(i);
      } else if (eFL == k) {
        this.field_wifiType = paramCursor.getInt(i);
      } else if (eFM == k) {
        this.field_action = paramCursor.getInt(i);
      } else if (eFN == k) {
        this.field_showUrl = paramCursor.getString(i);
      } else if (eFO == k) {
        this.field_showWordEn = paramCursor.getString(i);
      } else if (eFP == k) {
        this.field_showWordCn = paramCursor.getString(i);
      } else if (eFQ == k) {
        this.field_showWordTw = paramCursor.getString(i);
      } else if (eFR == k) {
        this.field_mac = paramCursor.getString(i);
      } else if (eFS == k) {
        this.field_verifyResult = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eFv) {
      localContentValues.put("ssidmd5", this.field_ssidmd5);
    }
    if (this.eCZ) {
      localContentValues.put("ssid", this.field_ssid);
    }
    if (this.eFw) {
      localContentValues.put("mid", this.field_mid);
    }
    if (this.eoV) {
      localContentValues.put("url", this.field_url);
    }
    if (this.eFx) {
      localContentValues.put("connectState", Integer.valueOf(this.field_connectState));
    }
    if (this.eFy) {
      localContentValues.put("expiredTime", Long.valueOf(this.field_expiredTime));
    }
    if (this.eFz) {
      localContentValues.put("wifiType", Integer.valueOf(this.field_wifiType));
    }
    if (this.eFA) {
      localContentValues.put("action", Integer.valueOf(this.field_action));
    }
    if (this.eFB) {
      localContentValues.put("showUrl", this.field_showUrl);
    }
    if (this.eFC) {
      localContentValues.put("showWordEn", this.field_showWordEn);
    }
    if (this.eFD) {
      localContentValues.put("showWordCn", this.field_showWordCn);
    }
    if (this.eFE) {
      localContentValues.put("showWordTw", this.field_showWordTw);
    }
    if (this.eFF) {
      localContentValues.put("mac", this.field_mac);
    }
    if (this.eFG) {
      localContentValues.put("verifyResult", Integer.valueOf(this.field_verifyResult));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.ch
 * JD-Core Version:    0.7.0.1
 */
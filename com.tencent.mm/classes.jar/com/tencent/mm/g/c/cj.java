package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cj
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eFW;
  private static final int eIA;
  private static final int eIB = "connectState".hashCode();
  private static final int eIC = "expiredTime".hashCode();
  private static final int eID = "wifiType".hashCode();
  private static final int eIE = "action".hashCode();
  private static final int eIF = "showUrl".hashCode();
  private static final int eIG = "showWordEn".hashCode();
  private static final int eIH = "showWordCn".hashCode();
  private static final int eII = "showWordTw".hashCode();
  private static final int eIJ = "mac".hashCode();
  private static final int eIK = "verifyResult".hashCode();
  private static final int eIz = "ssidmd5".hashCode();
  private static final int erd;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eFt = true;
  private boolean eIn = true;
  private boolean eIo = true;
  private boolean eIp = true;
  private boolean eIq = true;
  private boolean eIr = true;
  private boolean eIs = true;
  private boolean eIt = true;
  private boolean eIu = true;
  private boolean eIv = true;
  private boolean eIw = true;
  private boolean eIx = true;
  private boolean eIy = true;
  private boolean eqZ = true;
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
    eFW = "ssid".hashCode();
    eIA = "mid".hashCode();
    erd = "url".hashCode();
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
      if (eIz != k) {
        break label65;
      }
      this.field_ssidmd5 = paramCursor.getString(i);
      this.eIn = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eFW == k) {
        this.field_ssid = paramCursor.getString(i);
      } else if (eIA == k) {
        this.field_mid = paramCursor.getString(i);
      } else if (erd == k) {
        this.field_url = paramCursor.getString(i);
      } else if (eIB == k) {
        this.field_connectState = paramCursor.getInt(i);
      } else if (eIC == k) {
        this.field_expiredTime = paramCursor.getLong(i);
      } else if (eID == k) {
        this.field_wifiType = paramCursor.getInt(i);
      } else if (eIE == k) {
        this.field_action = paramCursor.getInt(i);
      } else if (eIF == k) {
        this.field_showUrl = paramCursor.getString(i);
      } else if (eIG == k) {
        this.field_showWordEn = paramCursor.getString(i);
      } else if (eIH == k) {
        this.field_showWordCn = paramCursor.getString(i);
      } else if (eII == k) {
        this.field_showWordTw = paramCursor.getString(i);
      } else if (eIJ == k) {
        this.field_mac = paramCursor.getString(i);
      } else if (eIK == k) {
        this.field_verifyResult = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eIn) {
      localContentValues.put("ssidmd5", this.field_ssidmd5);
    }
    if (this.eFt) {
      localContentValues.put("ssid", this.field_ssid);
    }
    if (this.eIo) {
      localContentValues.put("mid", this.field_mid);
    }
    if (this.eqZ) {
      localContentValues.put("url", this.field_url);
    }
    if (this.eIp) {
      localContentValues.put("connectState", Integer.valueOf(this.field_connectState));
    }
    if (this.eIq) {
      localContentValues.put("expiredTime", Long.valueOf(this.field_expiredTime));
    }
    if (this.eIr) {
      localContentValues.put("wifiType", Integer.valueOf(this.field_wifiType));
    }
    if (this.eIs) {
      localContentValues.put("action", Integer.valueOf(this.field_action));
    }
    if (this.eIt) {
      localContentValues.put("showUrl", this.field_showUrl);
    }
    if (this.eIu) {
      localContentValues.put("showWordEn", this.field_showWordEn);
    }
    if (this.eIv) {
      localContentValues.put("showWordCn", this.field_showWordCn);
    }
    if (this.eIw) {
      localContentValues.put("showWordTw", this.field_showWordTw);
    }
    if (this.eIx) {
      localContentValues.put("mac", this.field_mac);
    }
    if (this.eIy) {
      localContentValues.put("verifyResult", Integer.valueOf(this.field_verifyResult));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.cj
 * JD-Core Version:    0.7.0.1
 */
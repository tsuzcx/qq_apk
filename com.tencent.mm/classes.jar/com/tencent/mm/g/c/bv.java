package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class bv
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dkC = "url".hashCode();
  private static final int dyX = "ssidmd5".hashCode();
  private static final int dyY;
  private static final int dyZ = "connectState".hashCode();
  private static final int dyq = "ssid".hashCode();
  private static final int dza = "expiredTime".hashCode();
  private static final int dzb = "wifiType".hashCode();
  private static final int dzc = "action".hashCode();
  private static final int dzd = "showUrl".hashCode();
  private static final int dze = "showWordEn".hashCode();
  private static final int dzf = "showWordCn".hashCode();
  private static final int dzg = "showWordTw".hashCode();
  private static final int dzh = "mac".hashCode();
  private static final int dzi = "verifyResult".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dky = true;
  private boolean dxP = true;
  private boolean dyL = true;
  private boolean dyM = true;
  private boolean dyN = true;
  private boolean dyO = true;
  private boolean dyP = true;
  private boolean dyQ = true;
  private boolean dyR = true;
  private boolean dyS = true;
  private boolean dyT = true;
  private boolean dyU = true;
  private boolean dyV = true;
  private boolean dyW = true;
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
    dyY = "mid".hashCode();
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
      if (dyX != k) {
        break label65;
      }
      this.field_ssidmd5 = paramCursor.getString(i);
      this.dyL = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dyq == k) {
        this.field_ssid = paramCursor.getString(i);
      } else if (dyY == k) {
        this.field_mid = paramCursor.getString(i);
      } else if (dkC == k) {
        this.field_url = paramCursor.getString(i);
      } else if (dyZ == k) {
        this.field_connectState = paramCursor.getInt(i);
      } else if (dza == k) {
        this.field_expiredTime = paramCursor.getLong(i);
      } else if (dzb == k) {
        this.field_wifiType = paramCursor.getInt(i);
      } else if (dzc == k) {
        this.field_action = paramCursor.getInt(i);
      } else if (dzd == k) {
        this.field_showUrl = paramCursor.getString(i);
      } else if (dze == k) {
        this.field_showWordEn = paramCursor.getString(i);
      } else if (dzf == k) {
        this.field_showWordCn = paramCursor.getString(i);
      } else if (dzg == k) {
        this.field_showWordTw = paramCursor.getString(i);
      } else if (dzh == k) {
        this.field_mac = paramCursor.getString(i);
      } else if (dzi == k) {
        this.field_verifyResult = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dyL) {
      localContentValues.put("ssidmd5", this.field_ssidmd5);
    }
    if (this.dxP) {
      localContentValues.put("ssid", this.field_ssid);
    }
    if (this.dyM) {
      localContentValues.put("mid", this.field_mid);
    }
    if (this.dky) {
      localContentValues.put("url", this.field_url);
    }
    if (this.dyN) {
      localContentValues.put("connectState", Integer.valueOf(this.field_connectState));
    }
    if (this.dyO) {
      localContentValues.put("expiredTime", Long.valueOf(this.field_expiredTime));
    }
    if (this.dyP) {
      localContentValues.put("wifiType", Integer.valueOf(this.field_wifiType));
    }
    if (this.dyQ) {
      localContentValues.put("action", Integer.valueOf(this.field_action));
    }
    if (this.dyR) {
      localContentValues.put("showUrl", this.field_showUrl);
    }
    if (this.dyS) {
      localContentValues.put("showWordEn", this.field_showWordEn);
    }
    if (this.dyT) {
      localContentValues.put("showWordCn", this.field_showWordCn);
    }
    if (this.dyU) {
      localContentValues.put("showWordTw", this.field_showWordTw);
    }
    if (this.dyV) {
      localContentValues.put("mac", this.field_mac);
    }
    if (this.dyW) {
      localContentValues.put("verifyResult", Integer.valueOf(this.field_verifyResult));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.c.bv
 * JD-Core Version:    0.7.0.1
 */
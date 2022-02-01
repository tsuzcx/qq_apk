package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cn
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eJV = "url".hashCode();
  private static final int eZf;
  private static final int fcA = "ssidmd5".hashCode();
  private static final int fcB;
  private static final int fcC = "connectState".hashCode();
  private static final int fcD = "expiredTime".hashCode();
  private static final int fcE = "wifiType".hashCode();
  private static final int fcF = "action".hashCode();
  private static final int fcG = "showUrl".hashCode();
  private static final int fcH = "showWordEn".hashCode();
  private static final int fcI = "showWordCn".hashCode();
  private static final int fcJ = "showWordTw".hashCode();
  private static final int fcK = "mac".hashCode();
  private static final int fcL = "verifyResult".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eJR = true;
  private boolean eYC = true;
  private boolean fco = true;
  private boolean fcp = true;
  private boolean fcq = true;
  private boolean fcr = true;
  private boolean fcs = true;
  private boolean fct = true;
  private boolean fcu = true;
  private boolean fcv = true;
  private boolean fcw = true;
  private boolean fcx = true;
  private boolean fcy = true;
  private boolean fcz = true;
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
    eZf = "ssid".hashCode();
    fcB = "mid".hashCode();
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
      if (fcA != k) {
        break label65;
      }
      this.field_ssidmd5 = paramCursor.getString(i);
      this.fco = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eZf == k) {
        this.field_ssid = paramCursor.getString(i);
      } else if (fcB == k) {
        this.field_mid = paramCursor.getString(i);
      } else if (eJV == k) {
        this.field_url = paramCursor.getString(i);
      } else if (fcC == k) {
        this.field_connectState = paramCursor.getInt(i);
      } else if (fcD == k) {
        this.field_expiredTime = paramCursor.getLong(i);
      } else if (fcE == k) {
        this.field_wifiType = paramCursor.getInt(i);
      } else if (fcF == k) {
        this.field_action = paramCursor.getInt(i);
      } else if (fcG == k) {
        this.field_showUrl = paramCursor.getString(i);
      } else if (fcH == k) {
        this.field_showWordEn = paramCursor.getString(i);
      } else if (fcI == k) {
        this.field_showWordCn = paramCursor.getString(i);
      } else if (fcJ == k) {
        this.field_showWordTw = paramCursor.getString(i);
      } else if (fcK == k) {
        this.field_mac = paramCursor.getString(i);
      } else if (fcL == k) {
        this.field_verifyResult = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fco) {
      localContentValues.put("ssidmd5", this.field_ssidmd5);
    }
    if (this.eYC) {
      localContentValues.put("ssid", this.field_ssid);
    }
    if (this.fcp) {
      localContentValues.put("mid", this.field_mid);
    }
    if (this.eJR) {
      localContentValues.put("url", this.field_url);
    }
    if (this.fcq) {
      localContentValues.put("connectState", Integer.valueOf(this.field_connectState));
    }
    if (this.fcr) {
      localContentValues.put("expiredTime", Long.valueOf(this.field_expiredTime));
    }
    if (this.fcs) {
      localContentValues.put("wifiType", Integer.valueOf(this.field_wifiType));
    }
    if (this.fct) {
      localContentValues.put("action", Integer.valueOf(this.field_action));
    }
    if (this.fcu) {
      localContentValues.put("showUrl", this.field_showUrl);
    }
    if (this.fcv) {
      localContentValues.put("showWordEn", this.field_showWordEn);
    }
    if (this.fcw) {
      localContentValues.put("showWordCn", this.field_showWordCn);
    }
    if (this.fcx) {
      localContentValues.put("showWordTw", this.field_showWordTw);
    }
    if (this.fcy) {
      localContentValues.put("mac", this.field_mac);
    }
    if (this.fcz) {
      localContentValues.put("verifyResult", Integer.valueOf(this.field_verifyResult));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.c.cn
 * JD-Core Version:    0.7.0.1
 */
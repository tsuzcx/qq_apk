package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cn
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eIm = "url".hashCode();
  private static final int eXu;
  private static final int faL = "ssidmd5".hashCode();
  private static final int faM;
  private static final int faN = "connectState".hashCode();
  private static final int faO = "expiredTime".hashCode();
  private static final int faP = "wifiType".hashCode();
  private static final int faQ = "action".hashCode();
  private static final int faR = "showUrl".hashCode();
  private static final int faS = "showWordEn".hashCode();
  private static final int faT = "showWordCn".hashCode();
  private static final int faU = "showWordTw".hashCode();
  private static final int faV = "mac".hashCode();
  private static final int faW = "verifyResult".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eIi = true;
  private boolean eWR = true;
  private boolean faA = true;
  private boolean faB = true;
  private boolean faC = true;
  private boolean faD = true;
  private boolean faE = true;
  private boolean faF = true;
  private boolean faG = true;
  private boolean faH = true;
  private boolean faI = true;
  private boolean faJ = true;
  private boolean faK = true;
  private boolean faz = true;
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
    eXu = "ssid".hashCode();
    faM = "mid".hashCode();
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
      if (faL != k) {
        break label65;
      }
      this.field_ssidmd5 = paramCursor.getString(i);
      this.faz = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eXu == k) {
        this.field_ssid = paramCursor.getString(i);
      } else if (faM == k) {
        this.field_mid = paramCursor.getString(i);
      } else if (eIm == k) {
        this.field_url = paramCursor.getString(i);
      } else if (faN == k) {
        this.field_connectState = paramCursor.getInt(i);
      } else if (faO == k) {
        this.field_expiredTime = paramCursor.getLong(i);
      } else if (faP == k) {
        this.field_wifiType = paramCursor.getInt(i);
      } else if (faQ == k) {
        this.field_action = paramCursor.getInt(i);
      } else if (faR == k) {
        this.field_showUrl = paramCursor.getString(i);
      } else if (faS == k) {
        this.field_showWordEn = paramCursor.getString(i);
      } else if (faT == k) {
        this.field_showWordCn = paramCursor.getString(i);
      } else if (faU == k) {
        this.field_showWordTw = paramCursor.getString(i);
      } else if (faV == k) {
        this.field_mac = paramCursor.getString(i);
      } else if (faW == k) {
        this.field_verifyResult = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.faz) {
      localContentValues.put("ssidmd5", this.field_ssidmd5);
    }
    if (this.eWR) {
      localContentValues.put("ssid", this.field_ssid);
    }
    if (this.faA) {
      localContentValues.put("mid", this.field_mid);
    }
    if (this.eIi) {
      localContentValues.put("url", this.field_url);
    }
    if (this.faB) {
      localContentValues.put("connectState", Integer.valueOf(this.field_connectState));
    }
    if (this.faC) {
      localContentValues.put("expiredTime", Long.valueOf(this.field_expiredTime));
    }
    if (this.faD) {
      localContentValues.put("wifiType", Integer.valueOf(this.field_wifiType));
    }
    if (this.faE) {
      localContentValues.put("action", Integer.valueOf(this.field_action));
    }
    if (this.faF) {
      localContentValues.put("showUrl", this.field_showUrl);
    }
    if (this.faG) {
      localContentValues.put("showWordEn", this.field_showWordEn);
    }
    if (this.faH) {
      localContentValues.put("showWordCn", this.field_showWordCn);
    }
    if (this.faI) {
      localContentValues.put("showWordTw", this.field_showWordTw);
    }
    if (this.faJ) {
      localContentValues.put("mac", this.field_mac);
    }
    if (this.faK) {
      localContentValues.put("verifyResult", Integer.valueOf(this.field_verifyResult));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.cn
 * JD-Core Version:    0.7.0.1
 */
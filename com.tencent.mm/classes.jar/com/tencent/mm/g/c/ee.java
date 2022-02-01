package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.eg;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;

public abstract class ee
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eRX = "acctTypeId".hashCode();
  private static final int eRY;
  private static final int eSc = "appid".hashCode();
  private static final int eSd;
  private static final int emf;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eRU = true;
  private boolean eRV = true;
  private boolean eSa = true;
  private boolean eSb = true;
  private boolean emc = true;
  public String field_acctTypeId;
  public eg field_appRec;
  public String field_appid;
  public String field_language;
  public long field_updateTime;
  
  static
  {
    eRY = "language".hashCode();
    eSd = "appRec".hashCode();
    emf = "updateTime".hashCode();
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
      if (eSc != k) {
        break label60;
      }
      this.field_appid = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (eRY == k) {
        this.field_language = paramCursor.getString(i);
      } else if (eSd == k) {
        try
        {
          byte[] arrayOfByte = paramCursor.getBlob(i);
          if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
            continue;
          }
          this.field_appRec = ((eg)new eg().parseFrom(arrayOfByte));
        }
        catch (IOException localIOException)
        {
          ad.e("MicroMsg.SDK.BaseOpenIMAppIdInfo", localIOException.getMessage());
        }
      } else if (emf == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (eRX == k) {
        this.field_acctTypeId = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eSa) {
      localContentValues.put("appid", this.field_appid);
    }
    if (this.eRV) {
      localContentValues.put("language", this.field_language);
    }
    if ((this.eSb) && (this.field_appRec != null)) {}
    try
    {
      localContentValues.put("appRec", this.field_appRec.toByteArray());
      if (this.emc) {
        localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
      }
      if (this.eRU) {
        localContentValues.put("acctTypeId", this.field_acctTypeId);
      }
      if (this.systemRowid > 0L) {
        localContentValues.put("rowid", Long.valueOf(this.systemRowid));
      }
      return localContentValues;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ad.e("MicroMsg.SDK.BaseOpenIMAppIdInfo", localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.ee
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ac;
import java.io.IOException;

public abstract class ei
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eVh = "acctTypeId".hashCode();
  private static final int eVi;
  private static final int eVm = "appid".hashCode();
  private static final int eVn;
  private static final int eol;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eVe = true;
  private boolean eVf = true;
  private boolean eVk = true;
  private boolean eVl = true;
  private boolean eoi = true;
  public String field_acctTypeId;
  public com.tencent.mm.protocal.protobuf.ei field_appRec;
  public String field_appid;
  public String field_language;
  public long field_updateTime;
  
  static
  {
    eVi = "language".hashCode();
    eVn = "appRec".hashCode();
    eol = "updateTime".hashCode();
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
      if (eVm != k) {
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
      if (eVi == k) {
        this.field_language = paramCursor.getString(i);
      } else if (eVn == k) {
        try
        {
          byte[] arrayOfByte = paramCursor.getBlob(i);
          if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
            continue;
          }
          this.field_appRec = ((com.tencent.mm.protocal.protobuf.ei)new com.tencent.mm.protocal.protobuf.ei().parseFrom(arrayOfByte));
        }
        catch (IOException localIOException)
        {
          ac.e("MicroMsg.SDK.BaseOpenIMAppIdInfo", localIOException.getMessage());
        }
      } else if (eol == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (eVh == k) {
        this.field_acctTypeId = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eVk) {
      localContentValues.put("appid", this.field_appid);
    }
    if (this.eVf) {
      localContentValues.put("language", this.field_language);
    }
    if ((this.eVl) && (this.field_appRec != null)) {}
    try
    {
      localContentValues.put("appRec", this.field_appRec.toByteArray());
      if (this.eoi) {
        localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
      }
      if (this.eVe) {
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
        ac.e("MicroMsg.SDK.BaseOpenIMAppIdInfo", localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.ei
 * JD-Core Version:    0.7.0.1
 */
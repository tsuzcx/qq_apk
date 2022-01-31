package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.dt;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;

public abstract class dk
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dJm = "acctTypeId".hashCode();
  private static final int dJn;
  private static final int dJr = "appid".hashCode();
  private static final int dJs;
  private static final int dhV;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dJj = true;
  private boolean dJk = true;
  private boolean dJp = true;
  private boolean dJq = true;
  private boolean dhT = true;
  public String field_acctTypeId;
  public dt field_appRec;
  public String field_appid;
  public String field_language;
  public long field_updateTime;
  
  static
  {
    dJn = "language".hashCode();
    dJs = "appRec".hashCode();
    dhV = "updateTime".hashCode();
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
      if (dJr != k) {
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
      if (dJn == k) {
        this.field_language = paramCursor.getString(i);
      } else if (dJs == k) {
        try
        {
          byte[] arrayOfByte = paramCursor.getBlob(i);
          if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
            continue;
          }
          this.field_appRec = ((dt)new dt().parseFrom(arrayOfByte));
        }
        catch (IOException localIOException)
        {
          ab.e("MicroMsg.SDK.BaseOpenIMAppIdInfo", localIOException.getMessage());
        }
      } else if (dhV == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (dJm == k) {
        this.field_acctTypeId = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dJp) {
      localContentValues.put("appid", this.field_appid);
    }
    if (this.dJk) {
      localContentValues.put("language", this.field_language);
    }
    if ((this.dJq) && (this.field_appRec != null)) {}
    try
    {
      localContentValues.put("appRec", this.field_appRec.toByteArray());
      if (this.dhT) {
        localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
      }
      if (this.dJj) {
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
        ab.e("MicroMsg.SDK.BaseOpenIMAppIdInfo", localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.c.dk
 * JD-Core Version:    0.7.0.1
 */
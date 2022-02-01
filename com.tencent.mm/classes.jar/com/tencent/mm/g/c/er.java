package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.ax;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.IOException;

public abstract class er
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eGZ = "updateTime".hashCode();
  private static final int fpx = "acctTypeId".hashCode();
  private static final int fpy = "language".hashCode();
  private static final int fpz = "accTypeRec".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eGW = true;
  public ax field_accTypeRec;
  public String field_acctTypeId;
  public String field_language;
  public long field_updateTime;
  private boolean fpu = true;
  private boolean fpv = true;
  private boolean fpw = true;
  
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
      if (fpx != k) {
        break label60;
      }
      this.field_acctTypeId = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (fpy == k) {
        this.field_language = paramCursor.getString(i);
      } else if (fpz == k) {
        try
        {
          byte[] arrayOfByte = paramCursor.getBlob(i);
          if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
            continue;
          }
          this.field_accTypeRec = ((ax)new ax().parseFrom(arrayOfByte));
        }
        catch (IOException localIOException)
        {
          ae.e("MicroMsg.SDK.BaseOpenIMAccTypeInfo", localIOException.getMessage());
        }
      } else if (eGZ == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fpu) {
      localContentValues.put("acctTypeId", this.field_acctTypeId);
    }
    if (this.fpv) {
      localContentValues.put("language", this.field_language);
    }
    if ((this.fpw) && (this.field_accTypeRec != null)) {}
    try
    {
      localContentValues.put("accTypeRec", this.field_accTypeRec.toByteArray());
      if (this.eGW) {
        localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
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
        ae.e("MicroMsg.SDK.BaseOpenIMAccTypeInfo", localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.er
 * JD-Core Version:    0.7.0.1
 */
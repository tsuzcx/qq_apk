package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.ax;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;

public abstract class er
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eFq = "updateTime".hashCode();
  private static final int fnw = "acctTypeId".hashCode();
  private static final int fnx = "language".hashCode();
  private static final int fny = "accTypeRec".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eFn = true;
  public ax field_accTypeRec;
  public String field_acctTypeId;
  public String field_language;
  public long field_updateTime;
  private boolean fnt = true;
  private boolean fnu = true;
  private boolean fnv = true;
  
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
      if (fnw != k) {
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
      if (fnx == k) {
        this.field_language = paramCursor.getString(i);
      } else if (fny == k) {
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
          ad.e("MicroMsg.SDK.BaseOpenIMAccTypeInfo", localIOException.getMessage());
        }
      } else if (eFq == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fnt) {
      localContentValues.put("acctTypeId", this.field_acctTypeId);
    }
    if (this.fnu) {
      localContentValues.put("language", this.field_language);
    }
    if ((this.fnv) && (this.field_accTypeRec != null)) {}
    try
    {
      localContentValues.put("accTypeRec", this.field_accTypeRec.toByteArray());
      if (this.eFn) {
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
        ad.e("MicroMsg.SDK.BaseOpenIMAccTypeInfo", localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.er
 * JD-Core Version:    0.7.0.1
 */
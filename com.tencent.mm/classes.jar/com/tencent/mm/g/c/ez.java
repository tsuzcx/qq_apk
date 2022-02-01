package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.bb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.io.IOException;

public abstract class ez
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fUc = "acctTypeId".hashCode();
  private static final int fUd = "language".hashCode();
  private static final int fUe = "accTypeRec".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int updateTime_HASHCODE = "updateTime".hashCode();
  private boolean __hadSetupdateTime = true;
  private boolean fTZ = true;
  private boolean fUa = true;
  private boolean fUb = true;
  public bb field_accTypeRec;
  public String field_acctTypeId;
  public String field_language;
  public long field_updateTime;
  
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
      if (fUc != k) {
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
      if (fUd == k) {
        this.field_language = paramCursor.getString(i);
      } else if (fUe == k) {
        try
        {
          byte[] arrayOfByte = paramCursor.getBlob(i);
          if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
            continue;
          }
          this.field_accTypeRec = ((bb)new bb().parseFrom(arrayOfByte));
        }
        catch (IOException localIOException)
        {
          Log.e("MicroMsg.SDK.BaseOpenIMAccTypeInfo", localIOException.getMessage());
        }
      } else if (updateTime_HASHCODE == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fTZ) {
      localContentValues.put("acctTypeId", this.field_acctTypeId);
    }
    if (this.fUa) {
      localContentValues.put("language", this.field_language);
    }
    if ((this.fUb) && (this.field_accTypeRec != null)) {}
    try
    {
      localContentValues.put("accTypeRec", this.field_accTypeRec.toByteArray());
      if (this.__hadSetupdateTime) {
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
        Log.e("MicroMsg.SDK.BaseOpenIMAccTypeInfo", localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.ez
 * JD-Core Version:    0.7.0.1
 */
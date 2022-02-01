package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.bua;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.IOException;

public abstract class dx
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eGD = "appId".hashCode();
  private static final int fks = "launchPB".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eGm = true;
  public String field_appId;
  public bua field_launchPB;
  private boolean fkr = true;
  
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
      if (eGD != k) {
        break label60;
      }
      this.field_appId = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (fks == k) {
        try
        {
          byte[] arrayOfByte = paramCursor.getBlob(i);
          if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
            continue;
          }
          this.field_launchPB = ((bua)new bua().parseFrom(arrayOfByte));
        }
        catch (IOException localIOException)
        {
          ae.e("MicroMsg.SDK.BaseLaunchWxaAppPBTable", localIOException.getMessage());
        }
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eGm) {
      localContentValues.put("appId", this.field_appId);
    }
    if ((this.fkr) && (this.field_launchPB != null)) {}
    try
    {
      localContentValues.put("launchPB", this.field_launchPB.toByteArray());
      if (this.systemRowid > 0L) {
        localContentValues.put("rowid", Long.valueOf(this.systemRowid));
      }
      return localContentValues;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ae.e("MicroMsg.SDK.BaseLaunchWxaAppPBTable", localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.dx
 * JD-Core Version:    0.7.0.1
 */
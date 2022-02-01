package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.che;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.io.IOException;

public abstract class ed
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fOW = "launchPB".hashCode();
  private static final int fkj = "appId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fOV = true;
  public String field_appId;
  public che field_launchPB;
  private boolean fjS = true;
  
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
      if (fkj != k) {
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
      if (fOW == k) {
        try
        {
          byte[] arrayOfByte = paramCursor.getBlob(i);
          if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
            continue;
          }
          this.field_launchPB = ((che)new che().parseFrom(arrayOfByte));
        }
        catch (IOException localIOException)
        {
          Log.e("MicroMsg.SDK.BaseLaunchWxaAppPBTable", localIOException.getMessage());
        }
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fjS) {
      localContentValues.put("appId", this.field_appId);
    }
    if ((this.fOV) && (this.field_launchPB != null)) {}
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
        Log.e("MicroMsg.SDK.BaseLaunchWxaAppPBTable", localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.ed
 * JD-Core Version:    0.7.0.1
 */
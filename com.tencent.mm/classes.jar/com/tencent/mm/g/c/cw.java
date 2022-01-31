package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.azn;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;

public abstract class cw
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dFE = "launchPB".hashCode();
  private static final int dhB = "appId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dFD = true;
  private boolean dhk = true;
  public String field_appId;
  public azn field_launchPB;
  
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
      if (dhB != k) {
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
      if (dFE == k) {
        try
        {
          byte[] arrayOfByte = paramCursor.getBlob(i);
          if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
            continue;
          }
          this.field_launchPB = ((azn)new azn().parseFrom(arrayOfByte));
        }
        catch (IOException localIOException)
        {
          ab.e("MicroMsg.SDK.BaseLaunchWxaAppPBTable", localIOException.getMessage());
        }
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dhk) {
      localContentValues.put("appId", this.field_appId);
    }
    if ((this.dFD) && (this.field_launchPB != null)) {}
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
        ab.e("MicroMsg.SDK.BaseLaunchWxaAppPBTable", localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.c.cw
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.bot;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ac;
import java.io.IOException;

public abstract class dn
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int ePY = "launchPB".hashCode();
  private static final int enO = "appId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean ePX = true;
  private boolean enx = true;
  public String field_appId;
  public bot field_launchPB;
  
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
      if (enO != k) {
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
      if (ePY == k) {
        try
        {
          byte[] arrayOfByte = paramCursor.getBlob(i);
          if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
            continue;
          }
          this.field_launchPB = ((bot)new bot().parseFrom(arrayOfByte));
        }
        catch (IOException localIOException)
        {
          ac.e("MicroMsg.SDK.BaseLaunchWxaAppPBTable", localIOException.getMessage());
        }
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.enx) {
      localContentValues.put("appId", this.field_appId);
    }
    if ((this.ePX) && (this.field_launchPB != null)) {}
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
        ac.e("MicroMsg.SDK.BaseLaunchWxaAppPBTable", localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.dn
 * JD-Core Version:    0.7.0.1
 */
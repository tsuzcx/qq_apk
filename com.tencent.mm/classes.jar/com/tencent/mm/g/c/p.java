package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.bsi;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;

public abstract class p
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dhB = "appId".hashCode();
  private static final int dis = "recommendCard".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dhk = true;
  private boolean diq = true;
  public String field_appId;
  public bsi field_recommendCard;
  
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
        break label65;
      }
      this.field_appId = paramCursor.getString(i);
      this.dhk = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dis == k) {
        try
        {
          byte[] arrayOfByte = paramCursor.getBlob(i);
          if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
            continue;
          }
          this.field_recommendCard = ((bsi)new bsi().parseFrom(arrayOfByte));
        }
        catch (IOException localIOException)
        {
          ab.e("MicroMsg.SDK.BaseAppBrandRecommendCard", localIOException.getMessage());
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
    if ((this.diq) && (this.field_recommendCard != null)) {}
    try
    {
      localContentValues.put("recommendCard", this.field_recommendCard.toByteArray());
      if (this.systemRowid > 0L) {
        localContentValues.put("rowid", Long.valueOf(this.systemRowid));
      }
      return localContentValues;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ab.e("MicroMsg.SDK.BaseAppBrandRecommendCard", localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.c.p
 * JD-Core Version:    0.7.0.1
 */
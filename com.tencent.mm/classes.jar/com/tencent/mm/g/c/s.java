package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.crr;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;

public abstract class s
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEU = "appId".hashCode();
  private static final int eFY = "recommendCard".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eED = true;
  private boolean eFX = true;
  public String field_appId;
  public crr field_recommendCard;
  
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
      if (eEU != k) {
        break label65;
      }
      this.field_appId = paramCursor.getString(i);
      this.eED = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eFY == k) {
        try
        {
          byte[] arrayOfByte = paramCursor.getBlob(i);
          if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
            continue;
          }
          this.field_recommendCard = ((crr)new crr().parseFrom(arrayOfByte));
        }
        catch (IOException localIOException)
        {
          ad.e("MicroMsg.SDK.BaseAppBrandRecommendCard", localIOException.getMessage());
        }
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eED) {
      localContentValues.put("appId", this.field_appId);
    }
    if ((this.eFX) && (this.field_recommendCard != null)) {}
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
        ad.e("MicroMsg.SDK.BaseAppBrandRecommendCard", localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.s
 * JD-Core Version:    0.7.0.1
 */
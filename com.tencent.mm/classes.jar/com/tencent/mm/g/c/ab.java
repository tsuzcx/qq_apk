package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.hp;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;

public abstract class ab
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eoP = "deviceId".hashCode();
  private static final int eoQ = "sessionName".hashCode();
  private static final int eoR = "moveTime".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eoM = true;
  private boolean eoN = true;
  private boolean eoO = true;
  public String field_deviceId;
  public hp field_moveTime;
  public String field_sessionName;
  
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
      if (eoP != k) {
        break label60;
      }
      this.field_deviceId = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (eoQ == k) {
        this.field_sessionName = paramCursor.getString(i);
      } else if (eoR == k) {
        try
        {
          byte[] arrayOfByte = paramCursor.getBlob(i);
          if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
            continue;
          }
          this.field_moveTime = ((hp)new hp().parseFrom(arrayOfByte));
        }
        catch (IOException localIOException)
        {
          ad.e("MicroMsg.SDK.BaseBackupMoveTime", localIOException.getMessage());
        }
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.field_deviceId == null) {
      this.field_deviceId = "";
    }
    if (this.eoM) {
      localContentValues.put("deviceId", this.field_deviceId);
    }
    if (this.field_sessionName == null) {
      this.field_sessionName = "";
    }
    if (this.eoN) {
      localContentValues.put("sessionName", this.field_sessionName);
    }
    if ((this.eoO) && (this.field_moveTime != null)) {}
    try
    {
      localContentValues.put("moveTime", this.field_moveTime.toByteArray());
      if (this.systemRowid > 0L) {
        localContentValues.put("rowid", Long.valueOf(this.systemRowid));
      }
      return localContentValues;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ad.e("MicroMsg.SDK.BaseBackupMoveTime", localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.ab
 * JD-Core Version:    0.7.0.1
 */
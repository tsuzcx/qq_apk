package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.j.a.a.d;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;

public abstract class ao
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dhU = "username".hashCode();
  private static final int dpI = "lastPushSeq".hashCode();
  private static final int dpJ = "lastLocalSeq".hashCode();
  private static final int dpK = "lastPushCreateTime".hashCode();
  private static final int dpL = "lastLocalCreateTime".hashCode();
  private static final int dpM = "seqBlockInfo".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dhS = true;
  private boolean dpD = true;
  private boolean dpE = true;
  private boolean dpF = true;
  private boolean dpG = true;
  private boolean dpH = true;
  public long field_lastLocalCreateTime;
  public long field_lastLocalSeq;
  public long field_lastPushCreateTime;
  public long field_lastPushSeq;
  public d field_seqBlockInfo;
  public String field_username;
  
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
      if (dhU != k) {
        break label65;
      }
      this.field_username = paramCursor.getString(i);
      this.dhS = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dpI == k) {
        this.field_lastPushSeq = paramCursor.getLong(i);
      } else if (dpJ == k) {
        this.field_lastLocalSeq = paramCursor.getLong(i);
      } else if (dpK == k) {
        this.field_lastPushCreateTime = paramCursor.getLong(i);
      } else if (dpL == k) {
        this.field_lastLocalCreateTime = paramCursor.getLong(i);
      } else if (dpM == k) {
        try
        {
          byte[] arrayOfByte = paramCursor.getBlob(i);
          if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
            continue;
          }
          this.field_seqBlockInfo = ((d)new d().parseFrom(arrayOfByte));
        }
        catch (IOException localIOException)
        {
          ab.e("MicroMsg.SDK.BaseChatroomMsgSeq", localIOException.getMessage());
        }
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.field_username == null) {
      this.field_username = "";
    }
    if (this.dhS) {
      localContentValues.put("username", this.field_username);
    }
    if (this.dpD) {
      localContentValues.put("lastPushSeq", Long.valueOf(this.field_lastPushSeq));
    }
    if (this.dpE) {
      localContentValues.put("lastLocalSeq", Long.valueOf(this.field_lastLocalSeq));
    }
    if (this.dpF) {
      localContentValues.put("lastPushCreateTime", Long.valueOf(this.field_lastPushCreateTime));
    }
    if (this.dpG) {
      localContentValues.put("lastLocalCreateTime", Long.valueOf(this.field_lastLocalCreateTime));
    }
    if ((this.dpH) && (this.field_seqBlockInfo != null)) {}
    try
    {
      localContentValues.put("seqBlockInfo", this.field_seqBlockInfo.toByteArray());
      if (this.systemRowid > 0L) {
        localContentValues.put("rowid", Long.valueOf(this.systemRowid));
      }
      return localContentValues;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ab.e("MicroMsg.SDK.BaseChatroomMsgSeq", localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.ao
 * JD-Core Version:    0.7.0.1
 */
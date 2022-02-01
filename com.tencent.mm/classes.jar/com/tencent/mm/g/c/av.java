package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.k.a.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.io.IOException;

public abstract class av
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int ftE = "lastPushSeq".hashCode();
  private static final int ftF = "lastLocalSeq".hashCode();
  private static final int ftG = "lastPushCreateTime".hashCode();
  private static final int ftH = "lastLocalCreateTime".hashCode();
  private static final int ftI = "seqBlockInfo".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int username_HASHCODE = "username".hashCode();
  private boolean __hadSetusername = true;
  public long field_lastLocalCreateTime;
  public long field_lastLocalSeq;
  public long field_lastPushCreateTime;
  public long field_lastPushSeq;
  public d field_seqBlockInfo;
  public String field_username;
  private boolean ftA = true;
  private boolean ftB = true;
  private boolean ftC = true;
  private boolean ftD = true;
  private boolean ftz = true;
  
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
      if (username_HASHCODE != k) {
        break label65;
      }
      this.field_username = paramCursor.getString(i);
      this.__hadSetusername = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (ftE == k) {
        this.field_lastPushSeq = paramCursor.getLong(i);
      } else if (ftF == k) {
        this.field_lastLocalSeq = paramCursor.getLong(i);
      } else if (ftG == k) {
        this.field_lastPushCreateTime = paramCursor.getLong(i);
      } else if (ftH == k) {
        this.field_lastLocalCreateTime = paramCursor.getLong(i);
      } else if (ftI == k) {
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
          Log.e("MicroMsg.SDK.BaseChatroomMsgSeq", localIOException.getMessage());
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
    if (this.__hadSetusername) {
      localContentValues.put("username", this.field_username);
    }
    if (this.ftz) {
      localContentValues.put("lastPushSeq", Long.valueOf(this.field_lastPushSeq));
    }
    if (this.ftA) {
      localContentValues.put("lastLocalSeq", Long.valueOf(this.field_lastLocalSeq));
    }
    if (this.ftB) {
      localContentValues.put("lastPushCreateTime", Long.valueOf(this.field_lastPushCreateTime));
    }
    if (this.ftC) {
      localContentValues.put("lastLocalCreateTime", Long.valueOf(this.field_lastLocalCreateTime));
    }
    if ((this.ftD) && (this.field_seqBlockInfo != null)) {}
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
        Log.e("MicroMsg.SDK.BaseChatroomMsgSeq", localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.av
 * JD-Core Version:    0.7.0.1
 */
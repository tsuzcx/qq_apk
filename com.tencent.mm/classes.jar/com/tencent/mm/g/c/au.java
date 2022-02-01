package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.k.a.a.d;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.IOException;

public abstract class au
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eGY = "username".hashCode();
  private static final int ePX = "lastPushSeq".hashCode();
  private static final int ePY = "lastLocalSeq".hashCode();
  private static final int ePZ = "lastPushCreateTime".hashCode();
  private static final int eQa = "lastLocalCreateTime".hashCode();
  private static final int eQb = "seqBlockInfo".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eGV = true;
  private boolean ePS = true;
  private boolean ePT = true;
  private boolean ePU = true;
  private boolean ePV = true;
  private boolean ePW = true;
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
      if (eGY != k) {
        break label65;
      }
      this.field_username = paramCursor.getString(i);
      this.eGV = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (ePX == k) {
        this.field_lastPushSeq = paramCursor.getLong(i);
      } else if (ePY == k) {
        this.field_lastLocalSeq = paramCursor.getLong(i);
      } else if (ePZ == k) {
        this.field_lastPushCreateTime = paramCursor.getLong(i);
      } else if (eQa == k) {
        this.field_lastLocalCreateTime = paramCursor.getLong(i);
      } else if (eQb == k) {
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
          ae.e("MicroMsg.SDK.BaseChatroomMsgSeq", localIOException.getMessage());
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
    if (this.eGV) {
      localContentValues.put("username", this.field_username);
    }
    if (this.ePS) {
      localContentValues.put("lastPushSeq", Long.valueOf(this.field_lastPushSeq));
    }
    if (this.ePT) {
      localContentValues.put("lastLocalSeq", Long.valueOf(this.field_lastLocalSeq));
    }
    if (this.ePU) {
      localContentValues.put("lastPushCreateTime", Long.valueOf(this.field_lastPushCreateTime));
    }
    if (this.ePV) {
      localContentValues.put("lastLocalCreateTime", Long.valueOf(this.field_lastLocalCreateTime));
    }
    if ((this.ePW) && (this.field_seqBlockInfo != null)) {}
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
        ae.e("MicroMsg.SDK.BaseChatroomMsgSeq", localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.au
 * JD-Core Version:    0.7.0.1
 */
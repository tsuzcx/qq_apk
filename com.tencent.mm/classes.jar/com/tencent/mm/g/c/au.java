package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.k.a.a.d;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;

public abstract class au
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eFp = "username".hashCode();
  private static final int eOm = "lastPushSeq".hashCode();
  private static final int eOn = "lastLocalSeq".hashCode();
  private static final int eOo = "lastPushCreateTime".hashCode();
  private static final int eOp = "lastLocalCreateTime".hashCode();
  private static final int eOq = "seqBlockInfo".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eFm = true;
  private boolean eOh = true;
  private boolean eOi = true;
  private boolean eOj = true;
  private boolean eOk = true;
  private boolean eOl = true;
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
      if (eFp != k) {
        break label65;
      }
      this.field_username = paramCursor.getString(i);
      this.eFm = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eOm == k) {
        this.field_lastPushSeq = paramCursor.getLong(i);
      } else if (eOn == k) {
        this.field_lastLocalSeq = paramCursor.getLong(i);
      } else if (eOo == k) {
        this.field_lastPushCreateTime = paramCursor.getLong(i);
      } else if (eOp == k) {
        this.field_lastLocalCreateTime = paramCursor.getLong(i);
      } else if (eOq == k) {
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
          ad.e("MicroMsg.SDK.BaseChatroomMsgSeq", localIOException.getMessage());
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
    if (this.eFm) {
      localContentValues.put("username", this.field_username);
    }
    if (this.eOh) {
      localContentValues.put("lastPushSeq", Long.valueOf(this.field_lastPushSeq));
    }
    if (this.eOi) {
      localContentValues.put("lastLocalSeq", Long.valueOf(this.field_lastLocalSeq));
    }
    if (this.eOj) {
      localContentValues.put("lastPushCreateTime", Long.valueOf(this.field_lastPushCreateTime));
    }
    if (this.eOk) {
      localContentValues.put("lastLocalCreateTime", Long.valueOf(this.field_lastLocalCreateTime));
    }
    if ((this.eOl) && (this.field_seqBlockInfo != null)) {}
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
        ad.e("MicroMsg.SDK.BaseChatroomMsgSeq", localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.au
 * JD-Core Version:    0.7.0.1
 */
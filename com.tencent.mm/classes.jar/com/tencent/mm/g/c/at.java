package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.j.a.a.d;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;

public abstract class at
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eme = "username".hashCode();
  private static final int euA = "lastLocalSeq".hashCode();
  private static final int euB = "lastPushCreateTime".hashCode();
  private static final int euC = "lastLocalCreateTime".hashCode();
  private static final int euD = "seqBlockInfo".hashCode();
  private static final int euz = "lastPushSeq".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean emb = true;
  private boolean euu = true;
  private boolean euv = true;
  private boolean euw = true;
  private boolean eux = true;
  private boolean euy = true;
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
      if (eme != k) {
        break label65;
      }
      this.field_username = paramCursor.getString(i);
      this.emb = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (euz == k) {
        this.field_lastPushSeq = paramCursor.getLong(i);
      } else if (euA == k) {
        this.field_lastLocalSeq = paramCursor.getLong(i);
      } else if (euB == k) {
        this.field_lastPushCreateTime = paramCursor.getLong(i);
      } else if (euC == k) {
        this.field_lastLocalCreateTime = paramCursor.getLong(i);
      } else if (euD == k) {
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
    if (this.emb) {
      localContentValues.put("username", this.field_username);
    }
    if (this.euu) {
      localContentValues.put("lastPushSeq", Long.valueOf(this.field_lastPushSeq));
    }
    if (this.euv) {
      localContentValues.put("lastLocalSeq", Long.valueOf(this.field_lastLocalSeq));
    }
    if (this.euw) {
      localContentValues.put("lastPushCreateTime", Long.valueOf(this.field_lastPushCreateTime));
    }
    if (this.eux) {
      localContentValues.put("lastLocalCreateTime", Long.valueOf(this.field_lastLocalCreateTime));
    }
    if ((this.euy) && (this.field_seqBlockInfo != null)) {}
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
 * Qualified Name:     com.tencent.mm.g.c.at
 * JD-Core Version:    0.7.0.1
 */
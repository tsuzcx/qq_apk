package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.k.a.a.d;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;

public abstract class an
  extends c
{
  private static final int cBD = "lastPushSeq".hashCode();
  private static final int cBE = "lastLocalSeq".hashCode();
  private static final int cBF = "lastPushCreateTime".hashCode();
  private static final int cBG = "lastLocalCreateTime".hashCode();
  private static final int cBH = "seqBlockInfo".hashCode();
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int ctF = "username".hashCode();
  private boolean cBA = true;
  private boolean cBB = true;
  private boolean cBC = true;
  private boolean cBy = true;
  private boolean cBz = true;
  private boolean ctD = true;
  public long field_lastLocalCreateTime;
  public long field_lastLocalSeq;
  public long field_lastPushCreateTime;
  public long field_lastPushSeq;
  public d field_seqBlockInfo;
  public String field_username;
  
  public final void d(Cursor paramCursor)
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
      if (ctF != k) {
        break label65;
      }
      this.field_username = paramCursor.getString(i);
      this.ctD = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (cBD == k) {
        this.field_lastPushSeq = paramCursor.getLong(i);
      } else if (cBE == k) {
        this.field_lastLocalSeq = paramCursor.getLong(i);
      } else if (cBF == k) {
        this.field_lastPushCreateTime = paramCursor.getLong(i);
      } else if (cBG == k) {
        this.field_lastLocalCreateTime = paramCursor.getLong(i);
      } else if (cBH == k) {
        try
        {
          byte[] arrayOfByte = paramCursor.getBlob(i);
          if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
            continue;
          }
          this.field_seqBlockInfo = ((d)new d().aH(arrayOfByte));
        }
        catch (IOException localIOException)
        {
          y.e("MicroMsg.SDK.BaseChatroomMsgSeq", localIOException.getMessage());
        }
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.field_username == null) {
      this.field_username = "";
    }
    if (this.ctD) {
      localContentValues.put("username", this.field_username);
    }
    if (this.cBy) {
      localContentValues.put("lastPushSeq", Long.valueOf(this.field_lastPushSeq));
    }
    if (this.cBz) {
      localContentValues.put("lastLocalSeq", Long.valueOf(this.field_lastLocalSeq));
    }
    if (this.cBA) {
      localContentValues.put("lastPushCreateTime", Long.valueOf(this.field_lastPushCreateTime));
    }
    if (this.cBB) {
      localContentValues.put("lastLocalCreateTime", Long.valueOf(this.field_lastLocalCreateTime));
    }
    if ((this.cBC) && (this.field_seqBlockInfo != null)) {}
    try
    {
      localContentValues.put("seqBlockInfo", this.field_seqBlockInfo.toByteArray());
      if (this.ujK > 0L) {
        localContentValues.put("rowid", Long.valueOf(this.ujK));
      }
      return localContentValues;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        y.e("MicroMsg.SDK.BaseChatroomMsgSeq", localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.h.c.an
 * JD-Core Version:    0.7.0.1
 */
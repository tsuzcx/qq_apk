package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.k.a.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.io.IOException;

public abstract class av
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final Column C_USERNAME;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("ChatroomMsgSeq");
  public static final Column hBA;
  public static final Column hBB;
  public static final Column hBC;
  public static final Column hBD;
  private static final int hBJ = "lastPushSeq".hashCode();
  private static final int hBK = "lastLocalSeq".hashCode();
  private static final int hBL = "lastPushCreateTime".hashCode();
  private static final int hBM = "lastLocalCreateTime".hashCode();
  private static final int hBN = "seqBlockInfo".hashCode();
  public static final Column hBz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int username_HASHCODE;
  private boolean __hadSetusername = true;
  public long field_lastLocalCreateTime;
  public long field_lastLocalSeq;
  public long field_lastPushCreateTime;
  public long field_lastPushSeq;
  public d field_seqBlockInfo;
  public String field_username;
  private boolean hBE = true;
  private boolean hBF = true;
  private boolean hBG = true;
  private boolean hBH = true;
  private boolean hBI = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "ChatroomMsgSeq", "");
    C_USERNAME = new Column("username", "string", "ChatroomMsgSeq", "");
    hBz = new Column("lastpushseq", "long", "ChatroomMsgSeq", "");
    hBA = new Column("lastlocalseq", "long", "ChatroomMsgSeq", "");
    hBB = new Column("lastpushcreatetime", "long", "ChatroomMsgSeq", "");
    hBC = new Column("lastlocalcreatetime", "long", "ChatroomMsgSeq", "");
    hBD = new Column("seqblockinfo", "proto", "ChatroomMsgSeq", "com.tencent.mm.clientproto.chatroom.protobuf.SeqBlockInfo");
    username_HASHCODE = "username".hashCode();
  }
  
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
      if (hBJ == k) {
        this.field_lastPushSeq = paramCursor.getLong(i);
      } else if (hBK == k) {
        this.field_lastLocalSeq = paramCursor.getLong(i);
      } else if (hBL == k) {
        this.field_lastPushCreateTime = paramCursor.getLong(i);
      } else if (hBM == k) {
        this.field_lastLocalCreateTime = paramCursor.getLong(i);
      } else if (hBN == k) {
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
    if (this.hBE) {
      localContentValues.put("lastPushSeq", Long.valueOf(this.field_lastPushSeq));
    }
    if (this.hBF) {
      localContentValues.put("lastLocalSeq", Long.valueOf(this.field_lastLocalSeq));
    }
    if (this.hBG) {
      localContentValues.put("lastPushCreateTime", Long.valueOf(this.field_lastPushCreateTime));
    }
    if (this.hBH) {
      localContentValues.put("lastLocalCreateTime", Long.valueOf(this.field_lastLocalCreateTime));
    }
    if ((this.hBI) && (this.field_seqBlockInfo != null)) {}
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
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "ChatroomMsgSeq";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.c.av
 * JD-Core Version:    0.7.0.1
 */
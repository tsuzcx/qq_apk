package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.io.IOException;

public abstract class fy
  extends IAutoDBItem
{
  public static final Column C_LOCALID;
  public static final Column C_ROWID;
  public static final Column C_TYPE;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("RecordMessageInfo");
  public static final Column hJn;
  private static final int hJv;
  public static final Column hLM;
  private static final int hMo;
  private static final int hmC = "status".hashCode();
  public static final Column hml;
  private static final int hmt;
  public static final Column hmw;
  public static final Column hsa;
  private static final int hsg;
  public static final Column itc;
  public static final Column itd;
  public static final Column ite;
  private static final int iti;
  private static final int itj;
  private static final int itk = "favFrom".hashCode();
  private static final int localId_HASHCODE;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSetlocalId = true;
  private boolean __hadSettype = true;
  public aoc field_dataProto;
  public String field_desc;
  public String field_favFrom;
  public int field_localId;
  public long field_msgId;
  public long field_oriMsgId;
  public int field_status;
  public String field_title;
  public String field_toUser;
  public int field_type;
  private boolean hJr = true;
  private boolean hMa = true;
  private boolean hmp = true;
  private boolean hmz = true;
  private boolean hsd = true;
  private boolean itf = true;
  private boolean itg = true;
  private boolean ith = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "RecordMessageInfo", "");
    C_LOCALID = new Column("localid", "int", "RecordMessageInfo", "");
    hml = new Column("msgid", "long", "RecordMessageInfo", "");
    itc = new Column("orimsgid", "long", "RecordMessageInfo", "");
    hLM = new Column("touser", "string", "RecordMessageInfo", "");
    hsa = new Column("title", "string", "RecordMessageInfo", "");
    hJn = new Column("desc", "string", "RecordMessageInfo", "");
    itd = new Column("dataproto", "proto", "RecordMessageInfo", "com.tencent.mm.protocal.protobuf.FavProtoItem");
    C_TYPE = new Column("type", "int", "RecordMessageInfo", "");
    hmw = new Column("status", "int", "RecordMessageInfo", "");
    ite = new Column("favfrom", "string", "RecordMessageInfo", "");
    localId_HASHCODE = "localId".hashCode();
    hmt = "msgId".hashCode();
    iti = "oriMsgId".hashCode();
    hMo = "toUser".hashCode();
    hsg = "title".hashCode();
    hJv = "desc".hashCode();
    itj = "dataProto".hashCode();
    type_HASHCODE = "type".hashCode();
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
      if (localId_HASHCODE != k) {
        break label65;
      }
      this.field_localId = paramCursor.getInt(i);
      this.__hadSetlocalId = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (hmt == k) {
        this.field_msgId = paramCursor.getLong(i);
      } else if (iti == k) {
        this.field_oriMsgId = paramCursor.getLong(i);
      } else if (hMo == k) {
        this.field_toUser = paramCursor.getString(i);
      } else if (hsg == k) {
        this.field_title = paramCursor.getString(i);
      } else if (hJv == k) {
        this.field_desc = paramCursor.getString(i);
      } else if (itj == k) {
        try
        {
          byte[] arrayOfByte = paramCursor.getBlob(i);
          if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
            continue;
          }
          this.field_dataProto = ((aoc)new aoc().parseFrom(arrayOfByte));
        }
        catch (IOException localIOException)
        {
          Log.e("MicroMsg.SDK.BaseRecordMessageInfo", localIOException.getMessage());
        }
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (hmC == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (itk == k) {
        this.field_favFrom = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.__hadSetlocalId) {
      localContentValues.put("localId", Integer.valueOf(this.field_localId));
    }
    if (this.hmp) {
      localContentValues.put("msgId", Long.valueOf(this.field_msgId));
    }
    if (this.itf) {
      localContentValues.put("oriMsgId", Long.valueOf(this.field_oriMsgId));
    }
    if (this.field_toUser == null) {
      this.field_toUser = "";
    }
    if (this.hMa) {
      localContentValues.put("toUser", this.field_toUser);
    }
    if (this.hsd) {
      localContentValues.put("title", this.field_title);
    }
    if (this.hJr) {
      localContentValues.put("desc", this.field_desc);
    }
    if ((this.itg) && (this.field_dataProto != null)) {}
    try
    {
      localContentValues.put("dataProto", this.field_dataProto.toByteArray());
      if (this.__hadSettype) {
        localContentValues.put("type", Integer.valueOf(this.field_type));
      }
      if (this.hmz) {
        localContentValues.put("status", Integer.valueOf(this.field_status));
      }
      if (this.ith) {
        localContentValues.put("favFrom", this.field_favFrom);
      }
      if (this.systemRowid > 0L) {
        localContentValues.put("rowid", Long.valueOf(this.systemRowid));
      }
      return localContentValues;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.BaseRecordMessageInfo", localIOException.getMessage());
      }
    }
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "RecordMessageInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.c.fy
 * JD-Core Version:    0.7.0.1
 */
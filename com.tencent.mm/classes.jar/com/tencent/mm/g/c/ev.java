package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;

public abstract class ev
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eBN;
  private static final int eBr = "localId".hashCode();
  private static final int eUb;
  private static final int eUc;
  private static final int eUd = "favFrom".hashCode();
  private static final int ejL = "msgId".hashCode();
  private static final int ejR;
  private static final int eoG;
  private static final int ezO;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  private boolean eBp = true;
  private boolean eBz = true;
  private boolean eTY = true;
  private boolean eTZ = true;
  private boolean eUa = true;
  private boolean ejH = true;
  private boolean ejO = true;
  private boolean eoD = true;
  private boolean ezK = true;
  public ago field_dataProto;
  public String field_desc;
  public String field_favFrom;
  public int field_localId;
  public long field_msgId;
  public long field_oriMsgId;
  public int field_status;
  public String field_title;
  public String field_toUser;
  public int field_type;
  
  static
  {
    eUb = "oriMsgId".hashCode();
    eBN = "toUser".hashCode();
    eoG = "title".hashCode();
    ezO = "desc".hashCode();
    eUc = "dataProto".hashCode();
    type_HASHCODE = "type".hashCode();
    ejR = "status".hashCode();
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
      if (eBr != k) {
        break label65;
      }
      this.field_localId = paramCursor.getInt(i);
      this.eBp = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (ejL == k) {
        this.field_msgId = paramCursor.getLong(i);
      } else if (eUb == k) {
        this.field_oriMsgId = paramCursor.getLong(i);
      } else if (eBN == k) {
        this.field_toUser = paramCursor.getString(i);
      } else if (eoG == k) {
        this.field_title = paramCursor.getString(i);
      } else if (ezO == k) {
        this.field_desc = paramCursor.getString(i);
      } else if (eUc == k) {
        try
        {
          byte[] arrayOfByte = paramCursor.getBlob(i);
          if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
            continue;
          }
          this.field_dataProto = ((ago)new ago().parseFrom(arrayOfByte));
        }
        catch (IOException localIOException)
        {
          ad.e("MicroMsg.SDK.BaseRecordMessageInfo", localIOException.getMessage());
        }
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (ejR == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (eUd == k) {
        this.field_favFrom = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eBp) {
      localContentValues.put("localId", Integer.valueOf(this.field_localId));
    }
    if (this.ejH) {
      localContentValues.put("msgId", Long.valueOf(this.field_msgId));
    }
    if (this.eTY) {
      localContentValues.put("oriMsgId", Long.valueOf(this.field_oriMsgId));
    }
    if (this.field_toUser == null) {
      this.field_toUser = "";
    }
    if (this.eBz) {
      localContentValues.put("toUser", this.field_toUser);
    }
    if (this.eoD) {
      localContentValues.put("title", this.field_title);
    }
    if (this.ezK) {
      localContentValues.put("desc", this.field_desc);
    }
    if ((this.eTZ) && (this.field_dataProto != null)) {}
    try
    {
      localContentValues.put("dataProto", this.field_dataProto.toByteArray());
      if (this.__hadSettype) {
        localContentValues.put("type", Integer.valueOf(this.field_type));
      }
      if (this.ejO) {
        localContentValues.put("status", Integer.valueOf(this.field_status));
      }
      if (this.eUa) {
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
        ad.e("MicroMsg.SDK.BaseRecordMessageInfo", localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.ev
 * JD-Core Version:    0.7.0.1
 */
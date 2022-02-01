package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.IOException;

public abstract class fj
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eEF;
  private static final int eEL = "status".hashCode();
  private static final int eJC;
  private static final int eVr;
  private static final int eWU = "localId".hashCode();
  private static final int eXq;
  private static final int frB;
  private static final int frC;
  private static final int frD = "favFrom".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  private boolean eEB = true;
  private boolean eEI = true;
  private boolean eJz = true;
  private boolean eVn = true;
  private boolean eWS = true;
  private boolean eXc = true;
  public akn field_dataProto;
  public String field_desc;
  public String field_favFrom;
  public int field_localId;
  public long field_msgId;
  public long field_oriMsgId;
  public int field_status;
  public String field_title;
  public String field_toUser;
  public int field_type;
  private boolean frA = true;
  private boolean fry = true;
  private boolean frz = true;
  
  static
  {
    eEF = "msgId".hashCode();
    frB = "oriMsgId".hashCode();
    eXq = "toUser".hashCode();
    eJC = "title".hashCode();
    eVr = "desc".hashCode();
    frC = "dataProto".hashCode();
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
      if (eWU != k) {
        break label65;
      }
      this.field_localId = paramCursor.getInt(i);
      this.eWS = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eEF == k) {
        this.field_msgId = paramCursor.getLong(i);
      } else if (frB == k) {
        this.field_oriMsgId = paramCursor.getLong(i);
      } else if (eXq == k) {
        this.field_toUser = paramCursor.getString(i);
      } else if (eJC == k) {
        this.field_title = paramCursor.getString(i);
      } else if (eVr == k) {
        this.field_desc = paramCursor.getString(i);
      } else if (frC == k) {
        try
        {
          byte[] arrayOfByte = paramCursor.getBlob(i);
          if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
            continue;
          }
          this.field_dataProto = ((akn)new akn().parseFrom(arrayOfByte));
        }
        catch (IOException localIOException)
        {
          ae.e("MicroMsg.SDK.BaseRecordMessageInfo", localIOException.getMessage());
        }
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (eEL == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (frD == k) {
        this.field_favFrom = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eWS) {
      localContentValues.put("localId", Integer.valueOf(this.field_localId));
    }
    if (this.eEB) {
      localContentValues.put("msgId", Long.valueOf(this.field_msgId));
    }
    if (this.fry) {
      localContentValues.put("oriMsgId", Long.valueOf(this.field_oriMsgId));
    }
    if (this.field_toUser == null) {
      this.field_toUser = "";
    }
    if (this.eXc) {
      localContentValues.put("toUser", this.field_toUser);
    }
    if (this.eJz) {
      localContentValues.put("title", this.field_title);
    }
    if (this.eVn) {
      localContentValues.put("desc", this.field_desc);
    }
    if ((this.frz) && (this.field_dataProto != null)) {}
    try
    {
      localContentValues.put("dataProto", this.field_dataProto.toByteArray());
      if (this.__hadSettype) {
        localContentValues.put("type", Integer.valueOf(this.field_type));
      }
      if (this.eEI) {
        localContentValues.put("status", Integer.valueOf(this.field_status));
      }
      if (this.frA) {
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
        ae.e("MicroMsg.SDK.BaseRecordMessageInfo", localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.fj
 * JD-Core Version:    0.7.0.1
 */
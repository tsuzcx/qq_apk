package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;

public abstract class fj
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eCW;
  private static final int eDc = "status".hashCode();
  private static final int eHT;
  private static final int eTG;
  private static final int eVF;
  private static final int eVj = "localId".hashCode();
  private static final int fpB;
  private static final int fpC;
  private static final int fpD = "favFrom".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  private boolean eCS = true;
  private boolean eCZ = true;
  private boolean eHQ = true;
  private boolean eTC = true;
  private boolean eVh = true;
  private boolean eVr = true;
  public akd field_dataProto;
  public String field_desc;
  public String field_favFrom;
  public int field_localId;
  public long field_msgId;
  public long field_oriMsgId;
  public int field_status;
  public String field_title;
  public String field_toUser;
  public int field_type;
  private boolean fpA = true;
  private boolean fpy = true;
  private boolean fpz = true;
  
  static
  {
    eCW = "msgId".hashCode();
    fpB = "oriMsgId".hashCode();
    eVF = "toUser".hashCode();
    eHT = "title".hashCode();
    eTG = "desc".hashCode();
    fpC = "dataProto".hashCode();
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
      if (eVj != k) {
        break label65;
      }
      this.field_localId = paramCursor.getInt(i);
      this.eVh = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eCW == k) {
        this.field_msgId = paramCursor.getLong(i);
      } else if (fpB == k) {
        this.field_oriMsgId = paramCursor.getLong(i);
      } else if (eVF == k) {
        this.field_toUser = paramCursor.getString(i);
      } else if (eHT == k) {
        this.field_title = paramCursor.getString(i);
      } else if (eTG == k) {
        this.field_desc = paramCursor.getString(i);
      } else if (fpC == k) {
        try
        {
          byte[] arrayOfByte = paramCursor.getBlob(i);
          if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
            continue;
          }
          this.field_dataProto = ((akd)new akd().parseFrom(arrayOfByte));
        }
        catch (IOException localIOException)
        {
          ad.e("MicroMsg.SDK.BaseRecordMessageInfo", localIOException.getMessage());
        }
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (eDc == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (fpD == k) {
        this.field_favFrom = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eVh) {
      localContentValues.put("localId", Integer.valueOf(this.field_localId));
    }
    if (this.eCS) {
      localContentValues.put("msgId", Long.valueOf(this.field_msgId));
    }
    if (this.fpy) {
      localContentValues.put("oriMsgId", Long.valueOf(this.field_oriMsgId));
    }
    if (this.field_toUser == null) {
      this.field_toUser = "";
    }
    if (this.eVr) {
      localContentValues.put("toUser", this.field_toUser);
    }
    if (this.eHQ) {
      localContentValues.put("title", this.field_title);
    }
    if (this.eTC) {
      localContentValues.put("desc", this.field_desc);
    }
    if ((this.fpz) && (this.field_dataProto != null)) {}
    try
    {
      localContentValues.put("dataProto", this.field_dataProto.toByteArray());
      if (this.__hadSettype) {
        localContentValues.put("type", Integer.valueOf(this.field_type));
      }
      if (this.eCZ) {
        localContentValues.put("status", Integer.valueOf(this.field_status));
      }
      if (this.fpA) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.fj
 * JD-Core Version:    0.7.0.1
 */
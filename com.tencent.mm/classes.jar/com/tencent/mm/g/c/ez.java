package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ac;
import java.io.IOException;

public abstract class ez
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eCi;
  private static final int eDL = "localId".hashCode();
  private static final int eEh;
  private static final int eXl;
  private static final int eXm;
  private static final int eXn = "favFrom".hashCode();
  private static final int elP = "msgId".hashCode();
  private static final int elV;
  private static final int eqK;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  private boolean eCe = true;
  private boolean eDJ = true;
  private boolean eDT = true;
  private boolean eXi = true;
  private boolean eXj = true;
  private boolean eXk = true;
  private boolean elL = true;
  private boolean elS = true;
  private boolean eqH = true;
  public ahn field_dataProto;
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
    eXl = "oriMsgId".hashCode();
    eEh = "toUser".hashCode();
    eqK = "title".hashCode();
    eCi = "desc".hashCode();
    eXm = "dataProto".hashCode();
    type_HASHCODE = "type".hashCode();
    elV = "status".hashCode();
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
      if (eDL != k) {
        break label65;
      }
      this.field_localId = paramCursor.getInt(i);
      this.eDJ = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (elP == k) {
        this.field_msgId = paramCursor.getLong(i);
      } else if (eXl == k) {
        this.field_oriMsgId = paramCursor.getLong(i);
      } else if (eEh == k) {
        this.field_toUser = paramCursor.getString(i);
      } else if (eqK == k) {
        this.field_title = paramCursor.getString(i);
      } else if (eCi == k) {
        this.field_desc = paramCursor.getString(i);
      } else if (eXm == k) {
        try
        {
          byte[] arrayOfByte = paramCursor.getBlob(i);
          if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
            continue;
          }
          this.field_dataProto = ((ahn)new ahn().parseFrom(arrayOfByte));
        }
        catch (IOException localIOException)
        {
          ac.e("MicroMsg.SDK.BaseRecordMessageInfo", localIOException.getMessage());
        }
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (elV == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (eXn == k) {
        this.field_favFrom = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eDJ) {
      localContentValues.put("localId", Integer.valueOf(this.field_localId));
    }
    if (this.elL) {
      localContentValues.put("msgId", Long.valueOf(this.field_msgId));
    }
    if (this.eXi) {
      localContentValues.put("oriMsgId", Long.valueOf(this.field_oriMsgId));
    }
    if (this.field_toUser == null) {
      this.field_toUser = "";
    }
    if (this.eDT) {
      localContentValues.put("toUser", this.field_toUser);
    }
    if (this.eqH) {
      localContentValues.put("title", this.field_title);
    }
    if (this.eCe) {
      localContentValues.put("desc", this.field_desc);
    }
    if ((this.eXj) && (this.field_dataProto != null)) {}
    try
    {
      localContentValues.put("dataProto", this.field_dataProto.toByteArray());
      if (this.__hadSettype) {
        localContentValues.put("type", Integer.valueOf(this.field_type));
      }
      if (this.elS) {
        localContentValues.put("status", Integer.valueOf(this.field_status));
      }
      if (this.eXk) {
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
        ac.e("MicroMsg.SDK.BaseRecordMessageInfo", localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.ez
 * JD-Core Version:    0.7.0.1
 */
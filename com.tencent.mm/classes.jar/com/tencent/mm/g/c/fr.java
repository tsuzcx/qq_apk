package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.io.IOException;

public abstract class fr
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fAT;
  private static final int fWg;
  private static final int fWh;
  private static final int fWi = "favFrom".hashCode();
  private static final int fjf;
  private static final int fjl;
  private static final int fne;
  private static final int fyW;
  private static final int localId_HASHCODE = "localId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSetlocalId = true;
  private boolean __hadSettype = true;
  private boolean fAF = true;
  private boolean fWd = true;
  private boolean fWe = true;
  private boolean fWf = true;
  public anb field_dataProto;
  public String field_desc;
  public String field_favFrom;
  public int field_localId;
  public long field_msgId;
  public long field_oriMsgId;
  public int field_status;
  public String field_title;
  public String field_toUser;
  public int field_type;
  private boolean fjb = true;
  private boolean fji = true;
  private boolean fnb = true;
  private boolean fyS = true;
  
  static
  {
    fjf = "msgId".hashCode();
    fWg = "oriMsgId".hashCode();
    fAT = "toUser".hashCode();
    fne = "title".hashCode();
    fyW = "desc".hashCode();
    fWh = "dataProto".hashCode();
    type_HASHCODE = "type".hashCode();
    fjl = "status".hashCode();
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
      if (fjf == k) {
        this.field_msgId = paramCursor.getLong(i);
      } else if (fWg == k) {
        this.field_oriMsgId = paramCursor.getLong(i);
      } else if (fAT == k) {
        this.field_toUser = paramCursor.getString(i);
      } else if (fne == k) {
        this.field_title = paramCursor.getString(i);
      } else if (fyW == k) {
        this.field_desc = paramCursor.getString(i);
      } else if (fWh == k) {
        try
        {
          byte[] arrayOfByte = paramCursor.getBlob(i);
          if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
            continue;
          }
          this.field_dataProto = ((anb)new anb().parseFrom(arrayOfByte));
        }
        catch (IOException localIOException)
        {
          Log.e("MicroMsg.SDK.BaseRecordMessageInfo", localIOException.getMessage());
        }
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (fjl == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (fWi == k) {
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
    if (this.fjb) {
      localContentValues.put("msgId", Long.valueOf(this.field_msgId));
    }
    if (this.fWd) {
      localContentValues.put("oriMsgId", Long.valueOf(this.field_oriMsgId));
    }
    if (this.field_toUser == null) {
      this.field_toUser = "";
    }
    if (this.fAF) {
      localContentValues.put("toUser", this.field_toUser);
    }
    if (this.fnb) {
      localContentValues.put("title", this.field_title);
    }
    if (this.fyS) {
      localContentValues.put("desc", this.field_desc);
    }
    if ((this.fWe) && (this.field_dataProto != null)) {}
    try
    {
      localContentValues.put("dataProto", this.field_dataProto.toByteArray());
      if (this.__hadSettype) {
        localContentValues.put("type", Integer.valueOf(this.field_type));
      }
      if (this.fji) {
        localContentValues.put("status", Integer.valueOf(this.field_status));
      }
      if (this.fWf) {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.fr
 * JD-Core Version:    0.7.0.1
 */
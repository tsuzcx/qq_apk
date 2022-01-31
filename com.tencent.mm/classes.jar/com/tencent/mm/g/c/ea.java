package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ab;
import java.io.IOException;

public abstract class ea
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dLi;
  private static final int dLj;
  private static final int dLk = "favFrom".hashCode();
  private static final int dfD;
  private static final int dfJ;
  private static final int dkj;
  private static final int duO;
  private static final int dwN;
  private static final int dwr = "localId".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  private boolean dLf = true;
  private boolean dLg = true;
  private boolean dLh = true;
  private boolean dfG = true;
  private boolean dfz = true;
  private boolean dkg = true;
  private boolean duK = true;
  private boolean dwp = true;
  private boolean dwz = true;
  public acq field_dataProto;
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
    dfD = "msgId".hashCode();
    dLi = "oriMsgId".hashCode();
    dwN = "toUser".hashCode();
    dkj = "title".hashCode();
    duO = "desc".hashCode();
    dLj = "dataProto".hashCode();
    type_HASHCODE = "type".hashCode();
    dfJ = "status".hashCode();
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
      if (dwr != k) {
        break label65;
      }
      this.field_localId = paramCursor.getInt(i);
      this.dwp = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (dfD == k) {
        this.field_msgId = paramCursor.getLong(i);
      } else if (dLi == k) {
        this.field_oriMsgId = paramCursor.getLong(i);
      } else if (dwN == k) {
        this.field_toUser = paramCursor.getString(i);
      } else if (dkj == k) {
        this.field_title = paramCursor.getString(i);
      } else if (duO == k) {
        this.field_desc = paramCursor.getString(i);
      } else if (dLj == k) {
        try
        {
          byte[] arrayOfByte = paramCursor.getBlob(i);
          if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
            continue;
          }
          this.field_dataProto = ((acq)new acq().parseFrom(arrayOfByte));
        }
        catch (IOException localIOException)
        {
          ab.e("MicroMsg.SDK.BaseRecordMessageInfo", localIOException.getMessage());
        }
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (dfJ == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (dLk == k) {
        this.field_favFrom = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dwp) {
      localContentValues.put("localId", Integer.valueOf(this.field_localId));
    }
    if (this.dfz) {
      localContentValues.put("msgId", Long.valueOf(this.field_msgId));
    }
    if (this.dLf) {
      localContentValues.put("oriMsgId", Long.valueOf(this.field_oriMsgId));
    }
    if (this.field_toUser == null) {
      this.field_toUser = "";
    }
    if (this.dwz) {
      localContentValues.put("toUser", this.field_toUser);
    }
    if (this.dkg) {
      localContentValues.put("title", this.field_title);
    }
    if (this.duK) {
      localContentValues.put("desc", this.field_desc);
    }
    if ((this.dLg) && (this.field_dataProto != null)) {}
    try
    {
      localContentValues.put("dataProto", this.field_dataProto.toByteArray());
      if (this.__hadSettype) {
        localContentValues.put("type", Integer.valueOf(this.field_type));
      }
      if (this.dfG) {
        localContentValues.put("status", Integer.valueOf(this.field_status));
      }
      if (this.dLh) {
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
        ab.e("MicroMsg.SDK.BaseRecordMessageInfo", localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.c.ea
 * JD-Core Version:    0.7.0.1
 */
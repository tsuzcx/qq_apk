package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;

public abstract class dp
  extends c
{
  private static final int cGk;
  private static final int cHJ;
  private static final int cIe;
  private static final int cUW;
  private static final int cUX;
  private static final int cUY = "favFrom".hashCode();
  public static final String[] cqY = new String[0];
  private static final int crg;
  private static final int crh = "rowid".hashCode();
  private static final int crn;
  private static final int csy;
  private static final int cvZ;
  private boolean cGg = true;
  private boolean cHH = true;
  private boolean cHR = true;
  private boolean cUT = true;
  private boolean cUU = true;
  private boolean cUV = true;
  private boolean crc = true;
  private boolean crk = true;
  private boolean csa = true;
  private boolean cvV = true;
  public yj field_dataProto;
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
    cHJ = "localId".hashCode();
    crg = "msgId".hashCode();
    cUW = "oriMsgId".hashCode();
    cIe = "toUser".hashCode();
    cvZ = "title".hashCode();
    cGk = "desc".hashCode();
    cUX = "dataProto".hashCode();
    csy = "type".hashCode();
    crn = "status".hashCode();
  }
  
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
      if (cHJ != k) {
        break label65;
      }
      this.field_localId = paramCursor.getInt(i);
      this.cHH = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (crg == k) {
        this.field_msgId = paramCursor.getLong(i);
      } else if (cUW == k) {
        this.field_oriMsgId = paramCursor.getLong(i);
      } else if (cIe == k) {
        this.field_toUser = paramCursor.getString(i);
      } else if (cvZ == k) {
        this.field_title = paramCursor.getString(i);
      } else if (cGk == k) {
        this.field_desc = paramCursor.getString(i);
      } else if (cUX == k) {
        try
        {
          byte[] arrayOfByte = paramCursor.getBlob(i);
          if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
            continue;
          }
          this.field_dataProto = ((yj)new yj().aH(arrayOfByte));
        }
        catch (IOException localIOException)
        {
          y.e("MicroMsg.SDK.BaseRecordMessageInfo", localIOException.getMessage());
        }
      } else if (csy == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (crn == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (cUY == k) {
        this.field_favFrom = paramCursor.getString(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cHH) {
      localContentValues.put("localId", Integer.valueOf(this.field_localId));
    }
    if (this.crc) {
      localContentValues.put("msgId", Long.valueOf(this.field_msgId));
    }
    if (this.cUT) {
      localContentValues.put("oriMsgId", Long.valueOf(this.field_oriMsgId));
    }
    if (this.field_toUser == null) {
      this.field_toUser = "";
    }
    if (this.cHR) {
      localContentValues.put("toUser", this.field_toUser);
    }
    if (this.cvV) {
      localContentValues.put("title", this.field_title);
    }
    if (this.cGg) {
      localContentValues.put("desc", this.field_desc);
    }
    if ((this.cUU) && (this.field_dataProto != null)) {}
    try
    {
      localContentValues.put("dataProto", this.field_dataProto.toByteArray());
      if (this.csa) {
        localContentValues.put("type", Integer.valueOf(this.field_type));
      }
      if (this.crk) {
        localContentValues.put("status", Integer.valueOf(this.field_status));
      }
      if (this.cUV) {
        localContentValues.put("favFrom", this.field_favFrom);
      }
      if (this.ujK > 0L) {
        localContentValues.put("rowid", Long.valueOf(this.ujK));
      }
      return localContentValues;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        y.e("MicroMsg.SDK.BaseRecordMessageInfo", localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.h.c.dp
 * JD-Core Version:    0.7.0.1
 */
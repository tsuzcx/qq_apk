package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;

public abstract class el
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("LiveTipsBar");
  public static final Column hHm;
  private static final int hIO = "thumbUrl".hashCode();
  public static final Column hMZ;
  public static final Column hSK;
  private static final int hSO;
  public static final Column iiO;
  public static final Column iiP;
  public static final Column iiQ;
  public static final Column iiR;
  private static final int iiX;
  private static final int iiY;
  private static final int iiZ = "anchorUsername".hashCode();
  private static final int ija = "isSender".hashCode();
  private static final int ijb = "timeStamp".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public String field_anchorUsername;
  public String field_hostRoomId;
  public boolean field_isSender;
  public long field_liveId;
  public String field_liveName;
  public String field_thumbUrl;
  public long field_timeStamp;
  private boolean hIa = true;
  private boolean hSM = true;
  private boolean iiS = true;
  private boolean iiT = true;
  private boolean iiU = true;
  private boolean iiV = true;
  private boolean iiW = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "LiveTipsBar", "");
    hSK = new Column("liveid", "long", "LiveTipsBar", "");
    iiO = new Column("hostroomid", "string", "LiveTipsBar", "");
    iiP = new Column("livename", "string", "LiveTipsBar", "");
    hHm = new Column("thumburl", "string", "LiveTipsBar", "");
    iiQ = new Column("anchorusername", "string", "LiveTipsBar", "");
    iiR = new Column("issender", "boolean", "LiveTipsBar", "");
    hMZ = new Column("timestamp", "long", "LiveTipsBar", "");
    hSO = "liveId".hashCode();
    iiX = "hostRoomId".hashCode();
    iiY = "liveName".hashCode();
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
      if (hSO != k) {
        break label65;
      }
      this.field_liveId = paramCursor.getLong(i);
      this.hSM = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (iiX == k)
      {
        this.field_hostRoomId = paramCursor.getString(i);
      }
      else if (iiY == k)
      {
        this.field_liveName = paramCursor.getString(i);
      }
      else if (hIO == k)
      {
        this.field_thumbUrl = paramCursor.getString(i);
      }
      else if (iiZ == k)
      {
        this.field_anchorUsername = paramCursor.getString(i);
      }
      else
      {
        if (ija == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isSender = bool;
            break;
          }
        }
        if (ijb == k) {
          this.field_timeStamp = paramCursor.getLong(i);
        } else if (rowid_HASHCODE == k) {
          this.systemRowid = paramCursor.getLong(i);
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hSM) {
      localContentValues.put("liveId", Long.valueOf(this.field_liveId));
    }
    if (this.field_hostRoomId == null) {
      this.field_hostRoomId = "";
    }
    if (this.iiS) {
      localContentValues.put("hostRoomId", this.field_hostRoomId);
    }
    if (this.field_liveName == null) {
      this.field_liveName = "";
    }
    if (this.iiT) {
      localContentValues.put("liveName", this.field_liveName);
    }
    if (this.field_thumbUrl == null) {
      this.field_thumbUrl = "";
    }
    if (this.hIa) {
      localContentValues.put("thumbUrl", this.field_thumbUrl);
    }
    if (this.field_anchorUsername == null) {
      this.field_anchorUsername = "";
    }
    if (this.iiU) {
      localContentValues.put("anchorUsername", this.field_anchorUsername);
    }
    if (this.iiV) {
      localContentValues.put("isSender", Boolean.valueOf(this.field_isSender));
    }
    if (this.iiW) {
      localContentValues.put("timeStamp", Long.valueOf(this.field_timeStamp));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "LiveTipsBar";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.f.c.el
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class hg
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eYF = "timeStamp".hashCode();
  private static final int ezn;
  private static final int qoV = "liveId".hashCode();
  private static final int qoW = "hostRoomId".hashCode();
  private static final int qoX = "liveName".hashCode();
  private static final int qoY;
  private static final int qoZ;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eYz = true;
  private boolean eyB = true;
  public String field_anchorUsername;
  public String field_hostRoomId;
  public boolean field_isSender;
  public long field_liveId;
  public String field_liveName;
  public String field_thumbUrl;
  public long field_timeStamp;
  private boolean qoQ = true;
  private boolean qoR = true;
  private boolean qoS = true;
  private boolean qoT = true;
  private boolean qoU = true;
  
  static
  {
    ezn = "thumbUrl".hashCode();
    qoY = "anchorUsername".hashCode();
    qoZ = "isSender".hashCode();
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
      if (qoV != k) {
        break label65;
      }
      this.field_liveId = paramCursor.getLong(i);
      this.qoQ = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (qoW == k)
      {
        this.field_hostRoomId = paramCursor.getString(i);
      }
      else if (qoX == k)
      {
        this.field_liveName = paramCursor.getString(i);
      }
      else if (ezn == k)
      {
        this.field_thumbUrl = paramCursor.getString(i);
      }
      else if (qoY == k)
      {
        this.field_anchorUsername = paramCursor.getString(i);
      }
      else
      {
        if (qoZ == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isSender = bool;
            break;
          }
        }
        if (eYF == k) {
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
    if (this.qoQ) {
      localContentValues.put("liveId", Long.valueOf(this.field_liveId));
    }
    if (this.field_hostRoomId == null) {
      this.field_hostRoomId = "";
    }
    if (this.qoR) {
      localContentValues.put("hostRoomId", this.field_hostRoomId);
    }
    if (this.field_liveName == null) {
      this.field_liveName = "";
    }
    if (this.qoS) {
      localContentValues.put("liveName", this.field_liveName);
    }
    if (this.field_thumbUrl == null) {
      this.field_thumbUrl = "";
    }
    if (this.eyB) {
      localContentValues.put("thumbUrl", this.field_thumbUrl);
    }
    if (this.field_anchorUsername == null) {
      this.field_anchorUsername = "";
    }
    if (this.qoT) {
      localContentValues.put("anchorUsername", this.field_anchorUsername);
    }
    if (this.qoU) {
      localContentValues.put("isSender", Boolean.valueOf(this.field_isSender));
    }
    if (this.eYz) {
      localContentValues.put("timeStamp", Long.valueOf(this.field_timeStamp));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.g.c.hg
 * JD-Core Version:    0.7.0.1
 */
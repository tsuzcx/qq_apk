package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ea
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eUQ = "thumbUrl".hashCode();
  private static final int fkV = "liveId".hashCode();
  private static final int fkW = "hostRoomId".hashCode();
  private static final int fkX = "liveName".hashCode();
  private static final int fkY = "anchorUsername".hashCode();
  private static final int fkZ = "isSender".hashCode();
  private static final int fla = "timeStamp".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eUe = true;
  public String field_anchorUsername;
  public String field_hostRoomId;
  public boolean field_isSender;
  public long field_liveId;
  public String field_liveName;
  public String field_thumbUrl;
  public long field_timeStamp;
  private boolean fkP = true;
  private boolean fkQ = true;
  private boolean fkR = true;
  private boolean fkS = true;
  private boolean fkT = true;
  private boolean fkU = true;
  
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
      if (fkV != k) {
        break label65;
      }
      this.field_liveId = paramCursor.getLong(i);
      this.fkP = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fkW == k)
      {
        this.field_hostRoomId = paramCursor.getString(i);
      }
      else if (fkX == k)
      {
        this.field_liveName = paramCursor.getString(i);
      }
      else if (eUQ == k)
      {
        this.field_thumbUrl = paramCursor.getString(i);
      }
      else if (fkY == k)
      {
        this.field_anchorUsername = paramCursor.getString(i);
      }
      else
      {
        if (fkZ == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isSender = bool;
            break;
          }
        }
        if (fla == k) {
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
    if (this.fkP) {
      localContentValues.put("liveId", Long.valueOf(this.field_liveId));
    }
    if (this.field_hostRoomId == null) {
      this.field_hostRoomId = "";
    }
    if (this.fkQ) {
      localContentValues.put("hostRoomId", this.field_hostRoomId);
    }
    if (this.field_liveName == null) {
      this.field_liveName = "";
    }
    if (this.fkR) {
      localContentValues.put("liveName", this.field_liveName);
    }
    if (this.field_thumbUrl == null) {
      this.field_thumbUrl = "";
    }
    if (this.eUe) {
      localContentValues.put("thumbUrl", this.field_thumbUrl);
    }
    if (this.field_anchorUsername == null) {
      this.field_anchorUsername = "";
    }
    if (this.fkS) {
      localContentValues.put("anchorUsername", this.field_anchorUsername);
    }
    if (this.fkT) {
      localContentValues.put("isSender", Boolean.valueOf(this.field_isSender));
    }
    if (this.fkU) {
      localContentValues.put("timeStamp", Long.valueOf(this.field_timeStamp));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.ea
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class ea
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eTf = "thumbUrl".hashCode();
  private static final int fiY = "liveId".hashCode();
  private static final int fiZ = "hostRoomId".hashCode();
  private static final int fja = "liveName".hashCode();
  private static final int fjb = "anchorUsername".hashCode();
  private static final int fjc = "isSender".hashCode();
  private static final int fjd = "timeStamp".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eSt = true;
  private boolean fiS = true;
  private boolean fiT = true;
  private boolean fiU = true;
  private boolean fiV = true;
  private boolean fiW = true;
  private boolean fiX = true;
  public String field_anchorUsername;
  public String field_hostRoomId;
  public boolean field_isSender;
  public long field_liveId;
  public String field_liveName;
  public String field_thumbUrl;
  public long field_timeStamp;
  
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
      if (fiY != k) {
        break label65;
      }
      this.field_liveId = paramCursor.getLong(i);
      this.fiS = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fiZ == k)
      {
        this.field_hostRoomId = paramCursor.getString(i);
      }
      else if (fja == k)
      {
        this.field_liveName = paramCursor.getString(i);
      }
      else if (eTf == k)
      {
        this.field_thumbUrl = paramCursor.getString(i);
      }
      else if (fjb == k)
      {
        this.field_anchorUsername = paramCursor.getString(i);
      }
      else
      {
        if (fjc == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isSender = bool;
            break;
          }
        }
        if (fjd == k) {
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
    if (this.fiS) {
      localContentValues.put("liveId", Long.valueOf(this.field_liveId));
    }
    if (this.field_hostRoomId == null) {
      this.field_hostRoomId = "";
    }
    if (this.fiT) {
      localContentValues.put("hostRoomId", this.field_hostRoomId);
    }
    if (this.field_liveName == null) {
      this.field_liveName = "";
    }
    if (this.fiU) {
      localContentValues.put("liveName", this.field_liveName);
    }
    if (this.field_thumbUrl == null) {
      this.field_thumbUrl = "";
    }
    if (this.eSt) {
      localContentValues.put("thumbUrl", this.field_thumbUrl);
    }
    if (this.field_anchorUsername == null) {
      this.field_anchorUsername = "";
    }
    if (this.fiV) {
      localContentValues.put("anchorUsername", this.field_anchorUsername);
    }
    if (this.fiW) {
      localContentValues.put("isSender", Boolean.valueOf(this.field_isSender));
    }
    if (this.fiX) {
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
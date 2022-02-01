package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dq
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eBH = "thumbUrl".hashCode();
  private static final int eQB = "liveId".hashCode();
  private static final int eQC = "hostRoomId".hashCode();
  private static final int eQD = "liveName".hashCode();
  private static final int eQE = "anchorUsername".hashCode();
  private static final int eQF = "isSender".hashCode();
  private static final int eQG = "timeStamp".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eAV = true;
  private boolean eQA = true;
  private boolean eQv = true;
  private boolean eQw = true;
  private boolean eQx = true;
  private boolean eQy = true;
  private boolean eQz = true;
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
      if (eQB != k) {
        break label65;
      }
      this.field_liveId = paramCursor.getLong(i);
      this.eQv = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eQC == k)
      {
        this.field_hostRoomId = paramCursor.getString(i);
      }
      else if (eQD == k)
      {
        this.field_liveName = paramCursor.getString(i);
      }
      else if (eBH == k)
      {
        this.field_thumbUrl = paramCursor.getString(i);
      }
      else if (eQE == k)
      {
        this.field_anchorUsername = paramCursor.getString(i);
      }
      else
      {
        if (eQF == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isSender = bool;
            break;
          }
        }
        if (eQG == k) {
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
    if (this.eQv) {
      localContentValues.put("liveId", Long.valueOf(this.field_liveId));
    }
    if (this.field_hostRoomId == null) {
      this.field_hostRoomId = "";
    }
    if (this.eQw) {
      localContentValues.put("hostRoomId", this.field_hostRoomId);
    }
    if (this.field_liveName == null) {
      this.field_liveName = "";
    }
    if (this.eQx) {
      localContentValues.put("liveName", this.field_liveName);
    }
    if (this.field_thumbUrl == null) {
      this.field_thumbUrl = "";
    }
    if (this.eAV) {
      localContentValues.put("thumbUrl", this.field_thumbUrl);
    }
    if (this.field_anchorUsername == null) {
      this.field_anchorUsername = "";
    }
    if (this.eQy) {
      localContentValues.put("anchorUsername", this.field_anchorUsername);
    }
    if (this.eQz) {
      localContentValues.put("isSender", Boolean.valueOf(this.field_isSender));
    }
    if (this.eQA) {
      localContentValues.put("timeStamp", Long.valueOf(this.field_timeStamp));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.dq
 * JD-Core Version:    0.7.0.1
 */
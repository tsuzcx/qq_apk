package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;

public abstract class eg
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fPA;
  private static final int fPB;
  private static final int fPC = "anchorUsername".hashCode();
  private static final int fPD = "isSender".hashCode();
  private static final int fPE = "timeStamp".hashCode();
  private static final int fPz = "liveId".hashCode();
  private static final int fyv;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fPt = true;
  private boolean fPu = true;
  private boolean fPv = true;
  private boolean fPw = true;
  private boolean fPx = true;
  private boolean fPy = true;
  public String field_anchorUsername;
  public String field_hostRoomId;
  public boolean field_isSender;
  public long field_liveId;
  public String field_liveName;
  public String field_thumbUrl;
  public long field_timeStamp;
  private boolean fxJ = true;
  
  static
  {
    fPA = "hostRoomId".hashCode();
    fPB = "liveName".hashCode();
    fyv = "thumbUrl".hashCode();
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
      if (fPz != k) {
        break label65;
      }
      this.field_liveId = paramCursor.getLong(i);
      this.fPt = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fPA == k)
      {
        this.field_hostRoomId = paramCursor.getString(i);
      }
      else if (fPB == k)
      {
        this.field_liveName = paramCursor.getString(i);
      }
      else if (fyv == k)
      {
        this.field_thumbUrl = paramCursor.getString(i);
      }
      else if (fPC == k)
      {
        this.field_anchorUsername = paramCursor.getString(i);
      }
      else
      {
        if (fPD == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (boolean bool = true;; bool = false)
          {
            this.field_isSender = bool;
            break;
          }
        }
        if (fPE == k) {
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
    if (this.fPt) {
      localContentValues.put("liveId", Long.valueOf(this.field_liveId));
    }
    if (this.field_hostRoomId == null) {
      this.field_hostRoomId = "";
    }
    if (this.fPu) {
      localContentValues.put("hostRoomId", this.field_hostRoomId);
    }
    if (this.field_liveName == null) {
      this.field_liveName = "";
    }
    if (this.fPv) {
      localContentValues.put("liveName", this.field_liveName);
    }
    if (this.field_thumbUrl == null) {
      this.field_thumbUrl = "";
    }
    if (this.fxJ) {
      localContentValues.put("thumbUrl", this.field_thumbUrl);
    }
    if (this.field_anchorUsername == null) {
      this.field_anchorUsername = "";
    }
    if (this.fPw) {
      localContentValues.put("anchorUsername", this.field_anchorUsername);
    }
    if (this.fPx) {
      localContentValues.put("isSender", Boolean.valueOf(this.field_isSender));
    }
    if (this.fPy) {
      localContentValues.put("timeStamp", Long.valueOf(this.field_timeStamp));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.c.eg
 * JD-Core Version:    0.7.0.1
 */
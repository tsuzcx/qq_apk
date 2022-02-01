package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dc
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eNC;
  private static final int eND = "likecount".hashCode();
  private static final int eNE = "selfLikeState".hashCode();
  private static final int eNs = "rankID".hashCode();
  private static final int eNt = "appusername".hashCode();
  private static final int eNw;
  private static final int eok = "username".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eNA = true;
  private boolean eNB = true;
  private boolean eNp = true;
  private boolean eNq = true;
  private boolean eNv = true;
  private boolean eNz = true;
  private boolean eoh = true;
  public String field_appusername;
  public int field_likecount;
  public String field_rankID;
  public int field_ranknum;
  public int field_score;
  public int field_selfLikeState;
  public String field_username;
  
  static
  {
    eNC = "ranknum".hashCode();
    eNw = "score".hashCode();
  }
  
  public void convertFrom(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {
      return;
    }
    int i = 0;
    int j = arrayOfString.length;
    label20:
    int k;
    if (i < j)
    {
      k = arrayOfString[i].hashCode();
      if (eNs != k) {
        break label60;
      }
      this.field_rankID = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (eNt == k) {
        this.field_appusername = paramCursor.getString(i);
      } else if (eok == k) {
        this.field_username = paramCursor.getString(i);
      } else if (eNC == k) {
        this.field_ranknum = paramCursor.getInt(i);
      } else if (eNw == k) {
        this.field_score = paramCursor.getInt(i);
      } else if (eND == k) {
        this.field_likecount = paramCursor.getInt(i);
      } else if (eNE == k) {
        this.field_selfLikeState = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eNp) {
      localContentValues.put("rankID", this.field_rankID);
    }
    if (this.eNq) {
      localContentValues.put("appusername", this.field_appusername);
    }
    if (this.eoh) {
      localContentValues.put("username", this.field_username);
    }
    if (this.eNz) {
      localContentValues.put("ranknum", Integer.valueOf(this.field_ranknum));
    }
    if (this.eNv) {
      localContentValues.put("score", Integer.valueOf(this.field_score));
    }
    if (this.eNA) {
      localContentValues.put("likecount", Integer.valueOf(this.field_likecount));
    }
    if (this.eNB) {
      localContentValues.put("selfLikeState", Integer.valueOf(this.field_selfLikeState));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.dc
 * JD-Core Version:    0.7.0.1
 */
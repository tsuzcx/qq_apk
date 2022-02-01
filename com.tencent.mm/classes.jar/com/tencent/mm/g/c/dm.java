package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dm
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eGY;
  private static final int fhL = "rankID".hashCode();
  private static final int fhM = "appusername".hashCode();
  private static final int fhP = "score".hashCode();
  private static final int fhV;
  private static final int fhW = "likecount".hashCode();
  private static final int fhX = "selfLikeState".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eGV = true;
  private boolean fhI = true;
  private boolean fhJ = true;
  private boolean fhO = true;
  private boolean fhS = true;
  private boolean fhT = true;
  private boolean fhU = true;
  public String field_appusername;
  public int field_likecount;
  public String field_rankID;
  public int field_ranknum;
  public int field_score;
  public int field_selfLikeState;
  public String field_username;
  
  static
  {
    eGY = "username".hashCode();
    fhV = "ranknum".hashCode();
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
      if (fhL != k) {
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
      if (fhM == k) {
        this.field_appusername = paramCursor.getString(i);
      } else if (eGY == k) {
        this.field_username = paramCursor.getString(i);
      } else if (fhV == k) {
        this.field_ranknum = paramCursor.getInt(i);
      } else if (fhP == k) {
        this.field_score = paramCursor.getInt(i);
      } else if (fhW == k) {
        this.field_likecount = paramCursor.getInt(i);
      } else if (fhX == k) {
        this.field_selfLikeState = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fhI) {
      localContentValues.put("rankID", this.field_rankID);
    }
    if (this.fhJ) {
      localContentValues.put("appusername", this.field_appusername);
    }
    if (this.eGV) {
      localContentValues.put("username", this.field_username);
    }
    if (this.fhS) {
      localContentValues.put("ranknum", Integer.valueOf(this.field_ranknum));
    }
    if (this.fhO) {
      localContentValues.put("score", Integer.valueOf(this.field_score));
    }
    if (this.fhT) {
      localContentValues.put("likecount", Integer.valueOf(this.field_likecount));
    }
    if (this.fhU) {
      localContentValues.put("selfLikeState", Integer.valueOf(this.field_selfLikeState));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.dm
 * JD-Core Version:    0.7.0.1
 */
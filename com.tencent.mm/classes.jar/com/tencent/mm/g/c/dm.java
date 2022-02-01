package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class dm
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eFp;
  private static final int ffO = "rankID".hashCode();
  private static final int ffP = "appusername".hashCode();
  private static final int ffS = "score".hashCode();
  private static final int ffY;
  private static final int ffZ = "likecount".hashCode();
  private static final int fga = "selfLikeState".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eFm = true;
  private boolean ffL = true;
  private boolean ffM = true;
  private boolean ffR = true;
  private boolean ffV = true;
  private boolean ffW = true;
  private boolean ffX = true;
  public String field_appusername;
  public int field_likecount;
  public String field_rankID;
  public int field_ranknum;
  public int field_score;
  public int field_selfLikeState;
  public String field_username;
  
  static
  {
    eFp = "username".hashCode();
    ffY = "ranknum".hashCode();
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
      if (ffO != k) {
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
      if (ffP == k) {
        this.field_appusername = paramCursor.getString(i);
      } else if (eFp == k) {
        this.field_username = paramCursor.getString(i);
      } else if (ffY == k) {
        this.field_ranknum = paramCursor.getInt(i);
      } else if (ffS == k) {
        this.field_score = paramCursor.getInt(i);
      } else if (ffZ == k) {
        this.field_likecount = paramCursor.getInt(i);
      } else if (fga == k) {
        this.field_selfLikeState = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.ffL) {
      localContentValues.put("rankID", this.field_rankID);
    }
    if (this.ffM) {
      localContentValues.put("appusername", this.field_appusername);
    }
    if (this.eFm) {
      localContentValues.put("username", this.field_username);
    }
    if (this.ffV) {
      localContentValues.put("ranknum", Integer.valueOf(this.field_ranknum));
    }
    if (this.ffR) {
      localContentValues.put("score", Integer.valueOf(this.field_score));
    }
    if (this.ffW) {
      localContentValues.put("likecount", Integer.valueOf(this.field_likecount));
    }
    if (this.ffX) {
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
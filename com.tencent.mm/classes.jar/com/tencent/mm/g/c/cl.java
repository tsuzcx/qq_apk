package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cl
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int dCW = "rankID".hashCode();
  private static final int dCX = "appusername".hashCode();
  private static final int dDa = "score".hashCode();
  private static final int dDg;
  private static final int dDh = "likecount".hashCode();
  private static final int dDi = "selfLikeState".hashCode();
  private static final int dhU = "username".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean dCT = true;
  private boolean dCU = true;
  private boolean dCZ = true;
  private boolean dDd = true;
  private boolean dDe = true;
  private boolean dDf = true;
  private boolean dhS = true;
  public String field_appusername;
  public int field_likecount;
  public String field_rankID;
  public int field_ranknum;
  public int field_score;
  public int field_selfLikeState;
  public String field_username;
  
  static
  {
    dDg = "ranknum".hashCode();
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
      if (dCW != k) {
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
      if (dCX == k) {
        this.field_appusername = paramCursor.getString(i);
      } else if (dhU == k) {
        this.field_username = paramCursor.getString(i);
      } else if (dDg == k) {
        this.field_ranknum = paramCursor.getInt(i);
      } else if (dDa == k) {
        this.field_score = paramCursor.getInt(i);
      } else if (dDh == k) {
        this.field_likecount = paramCursor.getInt(i);
      } else if (dDi == k) {
        this.field_selfLikeState = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.dCT) {
      localContentValues.put("rankID", this.field_rankID);
    }
    if (this.dCU) {
      localContentValues.put("appusername", this.field_appusername);
    }
    if (this.dhS) {
      localContentValues.put("username", this.field_username);
    }
    if (this.dDd) {
      localContentValues.put("ranknum", Integer.valueOf(this.field_ranknum));
    }
    if (this.dCZ) {
      localContentValues.put("score", Integer.valueOf(this.field_score));
    }
    if (this.dDe) {
      localContentValues.put("likecount", Integer.valueOf(this.field_likecount));
    }
    if (this.dDf) {
      localContentValues.put("selfLikeState", Integer.valueOf(this.field_selfLikeState));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.cl
 * JD-Core Version:    0.7.0.1
 */
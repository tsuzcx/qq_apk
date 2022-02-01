package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class da
  extends c
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int eKA = "rankID".hashCode();
  private static final int eKB = "appusername".hashCode();
  private static final int eKE = "score".hashCode();
  private static final int eKK;
  private static final int eKL = "likecount".hashCode();
  private static final int eKM = "selfLikeState".hashCode();
  private static final int eme = "username".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eKD = true;
  private boolean eKH = true;
  private boolean eKI = true;
  private boolean eKJ = true;
  private boolean eKx = true;
  private boolean eKy = true;
  private boolean emb = true;
  public String field_appusername;
  public int field_likecount;
  public String field_rankID;
  public int field_ranknum;
  public int field_score;
  public int field_selfLikeState;
  public String field_username;
  
  static
  {
    eKK = "ranknum".hashCode();
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
      if (eKA != k) {
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
      if (eKB == k) {
        this.field_appusername = paramCursor.getString(i);
      } else if (eme == k) {
        this.field_username = paramCursor.getString(i);
      } else if (eKK == k) {
        this.field_ranknum = paramCursor.getInt(i);
      } else if (eKE == k) {
        this.field_score = paramCursor.getInt(i);
      } else if (eKL == k) {
        this.field_likecount = paramCursor.getInt(i);
      } else if (eKM == k) {
        this.field_selfLikeState = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eKx) {
      localContentValues.put("rankID", this.field_rankID);
    }
    if (this.eKy) {
      localContentValues.put("appusername", this.field_appusername);
    }
    if (this.emb) {
      localContentValues.put("username", this.field_username);
    }
    if (this.eKH) {
      localContentValues.put("ranknum", Integer.valueOf(this.field_ranknum));
    }
    if (this.eKD) {
      localContentValues.put("score", Integer.valueOf(this.field_score));
    }
    if (this.eKI) {
      localContentValues.put("likecount", Integer.valueOf(this.field_likecount));
    }
    if (this.eKJ) {
      localContentValues.put("selfLikeState", Integer.valueOf(this.field_selfLikeState));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.da
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.h.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c;

public abstract class cg
  extends c
{
  private static final int cNg;
  private static final int cNh;
  private static final int cNk = "score".hashCode();
  private static final int cNq;
  private static final int cNr = "likecount".hashCode();
  private static final int cNs = "selfLikeState".hashCode();
  public static final String[] cqY = new String[0];
  private static final int crh = "rowid".hashCode();
  private static final int ctF;
  private boolean cNd = true;
  private boolean cNe = true;
  private boolean cNj = true;
  private boolean cNn = true;
  private boolean cNo = true;
  private boolean cNp = true;
  private boolean ctD = true;
  public String field_appusername;
  public int field_likecount;
  public String field_rankID;
  public int field_ranknum;
  public int field_score;
  public int field_selfLikeState;
  public String field_username;
  
  static
  {
    cNg = "rankID".hashCode();
    cNh = "appusername".hashCode();
    ctF = "username".hashCode();
    cNq = "ranknum".hashCode();
  }
  
  public final void d(Cursor paramCursor)
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
      if (cNg != k) {
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
      if (cNh == k) {
        this.field_appusername = paramCursor.getString(i);
      } else if (ctF == k) {
        this.field_username = paramCursor.getString(i);
      } else if (cNq == k) {
        this.field_ranknum = paramCursor.getInt(i);
      } else if (cNk == k) {
        this.field_score = paramCursor.getInt(i);
      } else if (cNr == k) {
        this.field_likecount = paramCursor.getInt(i);
      } else if (cNs == k) {
        this.field_selfLikeState = paramCursor.getInt(i);
      } else if (crh == k) {
        this.ujK = paramCursor.getLong(i);
      }
    }
  }
  
  public final ContentValues vf()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.cNd) {
      localContentValues.put("rankID", this.field_rankID);
    }
    if (this.cNe) {
      localContentValues.put("appusername", this.field_appusername);
    }
    if (this.ctD) {
      localContentValues.put("username", this.field_username);
    }
    if (this.cNn) {
      localContentValues.put("ranknum", Integer.valueOf(this.field_ranknum));
    }
    if (this.cNj) {
      localContentValues.put("score", Integer.valueOf(this.field_score));
    }
    if (this.cNo) {
      localContentValues.put("likecount", Integer.valueOf(this.field_likecount));
    }
    if (this.cNp) {
      localContentValues.put("selfLikeState", Integer.valueOf(this.field_selfLikeState));
    }
    if (this.ujK > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.ujK));
    }
    return localContentValues;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.h.c.cg
 * JD-Core Version:    0.7.0.1
 */
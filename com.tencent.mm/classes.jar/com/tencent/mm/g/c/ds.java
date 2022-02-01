package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.ecf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import java.io.IOException;

public abstract class ds
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = new String[0];
  private static final int fMA = "likecount".hashCode();
  private static final int fMB = "selfLikeState".hashCode();
  private static final int fMC = "sportRecord".hashCode();
  private static final int fMo = "rankID".hashCode();
  private static final int fMp = "appusername".hashCode();
  private static final int fMs;
  private static final int fMz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int username_HASHCODE = "username".hashCode();
  private boolean __hadSetusername = true;
  private boolean fMl = true;
  private boolean fMm = true;
  private boolean fMr = true;
  private boolean fMv = true;
  private boolean fMw = true;
  private boolean fMx = true;
  private boolean fMy = true;
  public String field_appusername;
  public int field_likecount;
  public String field_rankID;
  public int field_ranknum;
  public int field_score;
  public int field_selfLikeState;
  public ecf field_sportRecord;
  public String field_username;
  
  static
  {
    fMz = "ranknum".hashCode();
    fMs = "score".hashCode();
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
      if (fMo != k) {
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
      if (fMp == k) {
        this.field_appusername = paramCursor.getString(i);
      } else if (username_HASHCODE == k) {
        this.field_username = paramCursor.getString(i);
      } else if (fMz == k) {
        this.field_ranknum = paramCursor.getInt(i);
      } else if (fMs == k) {
        this.field_score = paramCursor.getInt(i);
      } else if (fMA == k) {
        this.field_likecount = paramCursor.getInt(i);
      } else if (fMB == k) {
        this.field_selfLikeState = paramCursor.getInt(i);
      } else if (fMC == k) {
        try
        {
          byte[] arrayOfByte = paramCursor.getBlob(i);
          if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
            continue;
          }
          this.field_sportRecord = ((ecf)new ecf().parseFrom(arrayOfByte));
        }
        catch (IOException localIOException)
        {
          Log.e("MicroMsg.SDK.BaseHardDeviceRankInfo", localIOException.getMessage());
        }
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fMl) {
      localContentValues.put("rankID", this.field_rankID);
    }
    if (this.fMm) {
      localContentValues.put("appusername", this.field_appusername);
    }
    if (this.__hadSetusername) {
      localContentValues.put("username", this.field_username);
    }
    if (this.fMv) {
      localContentValues.put("ranknum", Integer.valueOf(this.field_ranknum));
    }
    if (this.fMr) {
      localContentValues.put("score", Integer.valueOf(this.field_score));
    }
    if (this.fMw) {
      localContentValues.put("likecount", Integer.valueOf(this.field_likecount));
    }
    if (this.fMx) {
      localContentValues.put("selfLikeState", Integer.valueOf(this.field_selfLikeState));
    }
    if ((this.fMy) && (this.field_sportRecord != null)) {}
    try
    {
      localContentValues.put("sportRecord", this.field_sportRecord.toByteArray());
      if (this.systemRowid > 0L) {
        localContentValues.put("rowid", Long.valueOf(this.systemRowid));
      }
      return localContentValues;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.BaseHardDeviceRankInfo", localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.ds
 * JD-Core Version:    0.7.0.1
 */
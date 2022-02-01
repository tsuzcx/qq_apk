package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.emg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.io.IOException;

public abstract class dw
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final Column C_USERNAME;
  public static final String[] INDEX_CREATE = new String[0];
  public static final SingleTable TABLE = new SingleTable("HardDeviceRankInfo");
  private static final int ieA;
  private static final int ieB = "likecount".hashCode();
  private static final int ieC = "selfLikeState".hashCode();
  private static final int ieD = "sportRecord".hashCode();
  public static final Column ied;
  public static final Column iee;
  private static final int iej;
  private static final int iek;
  public static final Column iem;
  private static final int ien;
  public static final Column ier;
  public static final Column ies;
  public static final Column iet;
  public static final Column ieu;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int username_HASHCODE;
  private boolean __hadSetusername = true;
  public String field_appusername;
  public int field_likecount;
  public String field_rankID;
  public int field_ranknum;
  public int field_score;
  public int field_selfLikeState;
  public emg field_sportRecord;
  public String field_username;
  private boolean ieg = true;
  private boolean ieh = true;
  private boolean iev = true;
  private boolean iew = true;
  private boolean iex = true;
  private boolean iey = true;
  private boolean iez = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "HardDeviceRankInfo", "");
    ied = new Column("rankid", "string", "HardDeviceRankInfo", "");
    iee = new Column("appusername", "string", "HardDeviceRankInfo", "");
    C_USERNAME = new Column("username", "string", "HardDeviceRankInfo", "");
    ier = new Column("ranknum", "int", "HardDeviceRankInfo", "");
    iem = new Column("score", "int", "HardDeviceRankInfo", "");
    ies = new Column("likecount", "int", "HardDeviceRankInfo", "");
    iet = new Column("selflikestate", "int", "HardDeviceRankInfo", "");
    ieu = new Column("sportrecord", "proto", "HardDeviceRankInfo", "com.tencent.mm.protocal.protobuf.SportRecord");
    iej = "rankID".hashCode();
    iek = "appusername".hashCode();
    username_HASHCODE = "username".hashCode();
    ieA = "ranknum".hashCode();
    ien = "score".hashCode();
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
      if (iej != k) {
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
      if (iek == k) {
        this.field_appusername = paramCursor.getString(i);
      } else if (username_HASHCODE == k) {
        this.field_username = paramCursor.getString(i);
      } else if (ieA == k) {
        this.field_ranknum = paramCursor.getInt(i);
      } else if (ien == k) {
        this.field_score = paramCursor.getInt(i);
      } else if (ieB == k) {
        this.field_likecount = paramCursor.getInt(i);
      } else if (ieC == k) {
        this.field_selfLikeState = paramCursor.getInt(i);
      } else if (ieD == k) {
        try
        {
          byte[] arrayOfByte = paramCursor.getBlob(i);
          if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
            continue;
          }
          this.field_sportRecord = ((emg)new emg().parseFrom(arrayOfByte));
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
    if (this.ieg) {
      localContentValues.put("rankID", this.field_rankID);
    }
    if (this.ieh) {
      localContentValues.put("appusername", this.field_appusername);
    }
    if (this.__hadSetusername) {
      localContentValues.put("username", this.field_username);
    }
    if (this.iev) {
      localContentValues.put("ranknum", Integer.valueOf(this.field_ranknum));
    }
    if (this.iew) {
      localContentValues.put("score", Integer.valueOf(this.field_score));
    }
    if (this.iex) {
      localContentValues.put("likecount", Integer.valueOf(this.field_likecount));
    }
    if (this.iey) {
      localContentValues.put("selfLikeState", Integer.valueOf(this.field_selfLikeState));
    }
    if ((this.iez) && (this.field_sportRecord != null)) {}
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
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "HardDeviceRankInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.c.dw
 * JD-Core Version:    0.7.0.1
 */
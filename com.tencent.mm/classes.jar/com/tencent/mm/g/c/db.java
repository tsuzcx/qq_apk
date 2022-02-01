package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.plugin.gamelife.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class db
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS GameLifeSessionInfo_sessionId_index ON GameLifeSessionInfo(sessionId)", "CREATE INDEX IF NOT EXISTS GameLifeSessionInfo_talker_index ON GameLifeSessionInfo(talker)", "CREATE INDEX IF NOT EXISTS GameLifeSessionInfo_selfUsername_index ON GameLifeSessionInfo(selfUserName)" };
  private static final int fAZ = "sessionId".hashCode();
  private static final int fIK = "selfUserName".hashCode();
  private static final int fpP = "extInfo".hashCode();
  private static final int fqw = "talker".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fAL = true;
  private boolean fIH = true;
  public c field_extInfo;
  public String field_selfUserName;
  public String field_sessionId;
  public String field_talker;
  private boolean fpB = true;
  private boolean fqi = true;
  
  public static IAutoDBItem.MAutoDBInfo ajs()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[4];
    localMAutoDBInfo.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "sessionId";
    localMAutoDBInfo.colsMap.put("sessionId", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" sessionId TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "sessionId";
    localMAutoDBInfo.columns[1] = "talker";
    localMAutoDBInfo.colsMap.put("talker", "TEXT default '' ");
    localStringBuilder.append(" talker TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "selfUserName";
    localMAutoDBInfo.colsMap.put("selfUserName", "TEXT default '' ");
    localStringBuilder.append(" selfUserName TEXT default '' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "extInfo";
    localMAutoDBInfo.colsMap.put("extInfo", "BLOB");
    localStringBuilder.append(" extInfo BLOB");
    localMAutoDBInfo.columns[4] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    return localMAutoDBInfo;
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
      if (fAZ != k) {
        break label65;
      }
      this.field_sessionId = paramCursor.getString(i);
      this.fAL = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fqw == k) {
        this.field_talker = paramCursor.getString(i);
      } else if (fIK == k) {
        this.field_selfUserName = paramCursor.getString(i);
      } else if (fpP == k) {
        try
        {
          byte[] arrayOfByte = paramCursor.getBlob(i);
          if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
            continue;
          }
          this.field_extInfo = ((c)new c().parseFrom(arrayOfByte));
        }
        catch (IOException localIOException)
        {
          Log.e("MicroMsg.SDK.BaseGameLifeSessionInfo", localIOException.getMessage());
        }
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.field_sessionId == null) {
      this.field_sessionId = "";
    }
    if (this.fAL) {
      localContentValues.put("sessionId", this.field_sessionId);
    }
    if (this.field_talker == null) {
      this.field_talker = "";
    }
    if (this.fqi) {
      localContentValues.put("talker", this.field_talker);
    }
    if (this.field_selfUserName == null) {
      this.field_selfUserName = "";
    }
    if (this.fIH) {
      localContentValues.put("selfUserName", this.field_selfUserName);
    }
    if ((this.fpB) && (this.field_extInfo != null)) {}
    try
    {
      localContentValues.put("extInfo", this.field_extInfo.toByteArray());
      if (this.systemRowid > 0L) {
        localContentValues.put("rowid", Long.valueOf(this.systemRowid));
      }
      return localContentValues;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.BaseGameLifeSessionInfo", localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.db
 * JD-Core Version:    0.7.0.1
 */
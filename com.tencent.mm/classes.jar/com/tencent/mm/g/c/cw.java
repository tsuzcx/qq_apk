package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class cw
  extends com.tencent.mm.sdk.e.c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS GameLifeSessionInfo_sessionId_index ON GameLifeSessionInfo(sessionId)", "CREATE INDEX IF NOT EXISTS GameLifeSessionInfo_talker_index ON GameLifeSessionInfo(talker)", "CREATE INDEX IF NOT EXISTS GameLifeSessionInfo_selfUsername_index ON GameLifeSessionInfo(selfUserName)" };
  private static final int eMP;
  private static final int eMi = "extInfo".hashCode();
  private static final int eXw = "sessionId".hashCode();
  private static final int fer;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eLU = true;
  private boolean eMB = true;
  private boolean eXi = true;
  private boolean feo = true;
  public com.tencent.mm.plugin.gamelife.b.c field_extInfo;
  public String field_selfUserName;
  public String field_sessionId;
  public String field_talker;
  
  static
  {
    eMP = "talker".hashCode();
    fer = "selfUserName".hashCode();
  }
  
  public static c.a VD()
  {
    c.a locala = new c.a();
    locala.IBL = new Field[4];
    locala.columns = new String[5];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "sessionId";
    locala.IBN.put("sessionId", "TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(" sessionId TEXT default ''  PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "sessionId";
    locala.columns[1] = "talker";
    locala.IBN.put("talker", "TEXT default '' ");
    localStringBuilder.append(" talker TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[2] = "selfUserName";
    locala.IBN.put("selfUserName", "TEXT default '' ");
    localStringBuilder.append(" selfUserName TEXT default '' ");
    localStringBuilder.append(", ");
    locala.columns[3] = "extInfo";
    locala.IBN.put("extInfo", "BLOB");
    localStringBuilder.append(" extInfo BLOB");
    locala.columns[4] = "rowid";
    locala.sql = localStringBuilder.toString();
    return locala;
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
      if (eXw != k) {
        break label65;
      }
      this.field_sessionId = paramCursor.getString(i);
      this.eXi = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eMP == k) {
        this.field_talker = paramCursor.getString(i);
      } else if (fer == k) {
        this.field_selfUserName = paramCursor.getString(i);
      } else if (eMi == k) {
        try
        {
          byte[] arrayOfByte = paramCursor.getBlob(i);
          if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
            continue;
          }
          this.field_extInfo = ((com.tencent.mm.plugin.gamelife.b.c)new com.tencent.mm.plugin.gamelife.b.c().parseFrom(arrayOfByte));
        }
        catch (IOException localIOException)
        {
          ae.e("MicroMsg.SDK.BaseGameLifeSessionInfo", localIOException.getMessage());
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
    if (this.eXi) {
      localContentValues.put("sessionId", this.field_sessionId);
    }
    if (this.field_talker == null) {
      this.field_talker = "";
    }
    if (this.eMB) {
      localContentValues.put("talker", this.field_talker);
    }
    if (this.field_selfUserName == null) {
      this.field_selfUserName = "";
    }
    if (this.feo) {
      localContentValues.put("selfUserName", this.field_selfUserName);
    }
    if ((this.eLU) && (this.field_extInfo != null)) {}
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
        ae.e("MicroMsg.SDK.BaseGameLifeSessionInfo", localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.cw
 * JD-Core Version:    0.7.0.1
 */
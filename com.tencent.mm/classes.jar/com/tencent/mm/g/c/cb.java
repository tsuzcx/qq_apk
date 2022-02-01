package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.air;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class cb
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS Finder_Local_Comment_Id ON FinderAction(localCommentId)", "CREATE INDEX IF NOT EXISTS Finder_Feed_Id ON FinderAction(feedId)", "CREATE INDEX IF NOT EXISTS Finder_Feed_CreateTime ON FinderAction(actionTime)", "CREATE INDEX IF NOT EXISTS Finder_Feed_ActionType ON FinderAction(actionType)", "CREATE INDEX IF NOT EXISTS Finder_Reply_state ON FinderAction(state)" };
  private static final int eBv = "state".hashCode();
  private static final int eER;
  private static final int eGn = "localCommentId".hashCode();
  private static final int eGo = "feedId".hashCode();
  private static final int eGp = "actionTime".hashCode();
  private static final int eGq;
  private static final int eGr = "actionInfo".hashCode();
  private static final int eGs = "postTime".hashCode();
  private static final int eGt = "tryCount".hashCode();
  private static final int eGu = "canRemove".hashCode();
  private static final int eGv = "lastTryTime".hashCode();
  private static final int eGw = "failedFlag".hashCode();
  private static final int env;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eAJ = true;
  private boolean eEH = true;
  private boolean eGd = true;
  private boolean eGe = true;
  private boolean eGf = true;
  private boolean eGg = true;
  private boolean eGh = true;
  private boolean eGi = true;
  private boolean eGj = true;
  private boolean eGk = true;
  private boolean eGl = true;
  private boolean eGm = true;
  private boolean ent = true;
  public air field_actionInfo;
  public long field_actionTime;
  public int field_actionType;
  public int field_canRemove;
  public int field_failedFlag;
  public long field_feedId;
  public long field_lastTryTime;
  public long field_localCommentId;
  public String field_objectNonceId;
  public long field_postTime;
  public int field_scene;
  public int field_state;
  public long field_tryCount;
  
  static
  {
    eER = "actionType".hashCode();
    eGq = "objectNonceId".hashCode();
    env = "scene".hashCode();
  }
  
  public static c.a Th()
  {
    c.a locala = new c.a();
    locala.GvF = new Field[13];
    locala.columns = new String[14];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "localCommentId";
    locala.GvH.put("localCommentId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" localCommentId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.GvG = "localCommentId";
    locala.columns[1] = "feedId";
    locala.GvH.put("feedId", "LONG");
    localStringBuilder.append(" feedId LONG");
    localStringBuilder.append(", ");
    locala.columns[2] = "actionTime";
    locala.GvH.put("actionTime", "LONG");
    localStringBuilder.append(" actionTime LONG");
    localStringBuilder.append(", ");
    locala.columns[3] = "actionType";
    locala.GvH.put("actionType", "INTEGER");
    localStringBuilder.append(" actionType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "objectNonceId";
    locala.GvH.put("objectNonceId", "TEXT");
    localStringBuilder.append(" objectNonceId TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "scene";
    locala.GvH.put("scene", "INTEGER");
    localStringBuilder.append(" scene INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "state";
    locala.GvH.put("state", "INTEGER");
    localStringBuilder.append(" state INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "actionInfo";
    locala.GvH.put("actionInfo", "BLOB");
    localStringBuilder.append(" actionInfo BLOB");
    localStringBuilder.append(", ");
    locala.columns[8] = "postTime";
    locala.GvH.put("postTime", "LONG");
    localStringBuilder.append(" postTime LONG");
    localStringBuilder.append(", ");
    locala.columns[9] = "tryCount";
    locala.GvH.put("tryCount", "LONG");
    localStringBuilder.append(" tryCount LONG");
    localStringBuilder.append(", ");
    locala.columns[10] = "canRemove";
    locala.GvH.put("canRemove", "INTEGER");
    localStringBuilder.append(" canRemove INTEGER");
    localStringBuilder.append(", ");
    locala.columns[11] = "lastTryTime";
    locala.GvH.put("lastTryTime", "LONG");
    localStringBuilder.append(" lastTryTime LONG");
    localStringBuilder.append(", ");
    locala.columns[12] = "failedFlag";
    locala.GvH.put("failedFlag", "INTEGER");
    localStringBuilder.append(" failedFlag INTEGER");
    locala.columns[13] = "rowid";
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
      if (eGn != k) {
        break label65;
      }
      this.field_localCommentId = paramCursor.getLong(i);
      this.eGd = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eGo == k) {
        this.field_feedId = paramCursor.getLong(i);
      } else if (eGp == k) {
        this.field_actionTime = paramCursor.getLong(i);
      } else if (eER == k) {
        this.field_actionType = paramCursor.getInt(i);
      } else if (eGq == k) {
        this.field_objectNonceId = paramCursor.getString(i);
      } else if (env == k) {
        this.field_scene = paramCursor.getInt(i);
      } else if (eBv == k) {
        this.field_state = paramCursor.getInt(i);
      } else if (eGr == k) {
        try
        {
          byte[] arrayOfByte = paramCursor.getBlob(i);
          if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
            continue;
          }
          this.field_actionInfo = ((air)new air().parseFrom(arrayOfByte));
        }
        catch (IOException localIOException)
        {
          ac.e("MicroMsg.SDK.BaseFinderAction", localIOException.getMessage());
        }
      } else if (eGs == k) {
        this.field_postTime = paramCursor.getLong(i);
      } else if (eGt == k) {
        this.field_tryCount = paramCursor.getLong(i);
      } else if (eGu == k) {
        this.field_canRemove = paramCursor.getInt(i);
      } else if (eGv == k) {
        this.field_lastTryTime = paramCursor.getLong(i);
      } else if (eGw == k) {
        this.field_failedFlag = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eGd) {
      localContentValues.put("localCommentId", Long.valueOf(this.field_localCommentId));
    }
    if (this.eGe) {
      localContentValues.put("feedId", Long.valueOf(this.field_feedId));
    }
    if (this.eGf) {
      localContentValues.put("actionTime", Long.valueOf(this.field_actionTime));
    }
    if (this.eEH) {
      localContentValues.put("actionType", Integer.valueOf(this.field_actionType));
    }
    if (this.eGg) {
      localContentValues.put("objectNonceId", this.field_objectNonceId);
    }
    if (this.ent) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.eAJ) {
      localContentValues.put("state", Integer.valueOf(this.field_state));
    }
    if ((this.eGh) && (this.field_actionInfo != null)) {}
    try
    {
      localContentValues.put("actionInfo", this.field_actionInfo.toByteArray());
      if (this.eGi) {
        localContentValues.put("postTime", Long.valueOf(this.field_postTime));
      }
      if (this.eGj) {
        localContentValues.put("tryCount", Long.valueOf(this.field_tryCount));
      }
      if (this.eGk) {
        localContentValues.put("canRemove", Integer.valueOf(this.field_canRemove));
      }
      if (this.eGl) {
        localContentValues.put("lastTryTime", Long.valueOf(this.field_lastTryTime));
      }
      if (this.eGm) {
        localContentValues.put("failedFlag", Integer.valueOf(this.field_failedFlag));
      }
      if (this.systemRowid > 0L) {
        localContentValues.put("rowid", Long.valueOf(this.systemRowid));
      }
      return localContentValues;
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        ac.e("MicroMsg.SDK.BaseFinderAction", localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.cb
 * JD-Core Version:    0.7.0.1
 */
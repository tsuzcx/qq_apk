package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.alr;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class cc
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS Finder_Local_Comment_Id ON FinderAction(localCommentId)", "CREATE INDEX IF NOT EXISTS FinderAction_Feed_Id ON FinderAction(feedId)", "CREATE INDEX IF NOT EXISTS Finder_Feed_CreateTime ON FinderAction(actionTime)", "CREATE INDEX IF NOT EXISTS Finder_Feed_ActionType ON FinderAction(actionType)", "CREATE INDEX IF NOT EXISTS Finder_Reply_state ON FinderAction(state)" };
  private static final int eGk = "scene".hashCode();
  private static final int eUE = "state".hashCode();
  private static final int eYa;
  private static final int eZA = "actionInfo".hashCode();
  private static final int eZB = "postTime".hashCode();
  private static final int eZC = "tryCount".hashCode();
  private static final int eZD = "canRemove".hashCode();
  private static final int eZE = "lastTryTime".hashCode();
  private static final int eZF = "failedFlag".hashCode();
  private static final int eZw = "localCommentId".hashCode();
  private static final int eZx = "feedId".hashCode();
  private static final int eZy = "actionTime".hashCode();
  private static final int eZz;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eGi = true;
  private boolean eTS = true;
  private boolean eXQ = true;
  private boolean eZm = true;
  private boolean eZn = true;
  private boolean eZo = true;
  private boolean eZp = true;
  private boolean eZq = true;
  private boolean eZr = true;
  private boolean eZs = true;
  private boolean eZt = true;
  private boolean eZu = true;
  private boolean eZv = true;
  public alr field_actionInfo;
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
    eYa = "actionType".hashCode();
    eZz = "objectNonceId".hashCode();
  }
  
  public static c.a VD()
  {
    c.a locala = new c.a();
    locala.IBL = new Field[13];
    locala.columns = new String[14];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "localCommentId";
    locala.IBN.put("localCommentId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" localCommentId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IBM = "localCommentId";
    locala.columns[1] = "feedId";
    locala.IBN.put("feedId", "LONG");
    localStringBuilder.append(" feedId LONG");
    localStringBuilder.append(", ");
    locala.columns[2] = "actionTime";
    locala.IBN.put("actionTime", "LONG");
    localStringBuilder.append(" actionTime LONG");
    localStringBuilder.append(", ");
    locala.columns[3] = "actionType";
    locala.IBN.put("actionType", "INTEGER");
    localStringBuilder.append(" actionType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "objectNonceId";
    locala.IBN.put("objectNonceId", "TEXT");
    localStringBuilder.append(" objectNonceId TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "scene";
    locala.IBN.put("scene", "INTEGER");
    localStringBuilder.append(" scene INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "state";
    locala.IBN.put("state", "INTEGER");
    localStringBuilder.append(" state INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "actionInfo";
    locala.IBN.put("actionInfo", "BLOB");
    localStringBuilder.append(" actionInfo BLOB");
    localStringBuilder.append(", ");
    locala.columns[8] = "postTime";
    locala.IBN.put("postTime", "LONG");
    localStringBuilder.append(" postTime LONG");
    localStringBuilder.append(", ");
    locala.columns[9] = "tryCount";
    locala.IBN.put("tryCount", "LONG");
    localStringBuilder.append(" tryCount LONG");
    localStringBuilder.append(", ");
    locala.columns[10] = "canRemove";
    locala.IBN.put("canRemove", "INTEGER");
    localStringBuilder.append(" canRemove INTEGER");
    localStringBuilder.append(", ");
    locala.columns[11] = "lastTryTime";
    locala.IBN.put("lastTryTime", "LONG");
    localStringBuilder.append(" lastTryTime LONG");
    localStringBuilder.append(", ");
    locala.columns[12] = "failedFlag";
    locala.IBN.put("failedFlag", "INTEGER");
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
      if (eZw != k) {
        break label65;
      }
      this.field_localCommentId = paramCursor.getLong(i);
      this.eZm = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eZx == k) {
        this.field_feedId = paramCursor.getLong(i);
      } else if (eZy == k) {
        this.field_actionTime = paramCursor.getLong(i);
      } else if (eYa == k) {
        this.field_actionType = paramCursor.getInt(i);
      } else if (eZz == k) {
        this.field_objectNonceId = paramCursor.getString(i);
      } else if (eGk == k) {
        this.field_scene = paramCursor.getInt(i);
      } else if (eUE == k) {
        this.field_state = paramCursor.getInt(i);
      } else if (eZA == k) {
        try
        {
          byte[] arrayOfByte = paramCursor.getBlob(i);
          if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
            continue;
          }
          this.field_actionInfo = ((alr)new alr().parseFrom(arrayOfByte));
        }
        catch (IOException localIOException)
        {
          ae.e("MicroMsg.SDK.BaseFinderAction", localIOException.getMessage());
        }
      } else if (eZB == k) {
        this.field_postTime = paramCursor.getLong(i);
      } else if (eZC == k) {
        this.field_tryCount = paramCursor.getLong(i);
      } else if (eZD == k) {
        this.field_canRemove = paramCursor.getInt(i);
      } else if (eZE == k) {
        this.field_lastTryTime = paramCursor.getLong(i);
      } else if (eZF == k) {
        this.field_failedFlag = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eZm) {
      localContentValues.put("localCommentId", Long.valueOf(this.field_localCommentId));
    }
    if (this.eZn) {
      localContentValues.put("feedId", Long.valueOf(this.field_feedId));
    }
    if (this.eZo) {
      localContentValues.put("actionTime", Long.valueOf(this.field_actionTime));
    }
    if (this.eXQ) {
      localContentValues.put("actionType", Integer.valueOf(this.field_actionType));
    }
    if (this.eZp) {
      localContentValues.put("objectNonceId", this.field_objectNonceId);
    }
    if (this.eGi) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.eTS) {
      localContentValues.put("state", Integer.valueOf(this.field_state));
    }
    if ((this.eZq) && (this.field_actionInfo != null)) {}
    try
    {
      localContentValues.put("actionInfo", this.field_actionInfo.toByteArray());
      if (this.eZr) {
        localContentValues.put("postTime", Long.valueOf(this.field_postTime));
      }
      if (this.eZs) {
        localContentValues.put("tryCount", Long.valueOf(this.field_tryCount));
      }
      if (this.eZt) {
        localContentValues.put("canRemove", Integer.valueOf(this.field_canRemove));
      }
      if (this.eZu) {
        localContentValues.put("lastTryTime", Long.valueOf(this.field_lastTryTime));
      }
      if (this.eZv) {
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
        ae.e("MicroMsg.SDK.BaseFinderAction", localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.cc
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.aoh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class cd
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS Finder_Local_Comment_Id ON FinderAction(localCommentId)", "CREATE INDEX IF NOT EXISTS FinderAction_Feed_Id ON FinderAction(feedId)", "CREATE INDEX IF NOT EXISTS Finder_Feed_CreateTime ON FinderAction(actionTime)", "CREATE INDEX IF NOT EXISTS Finder_Feed_ActionType ON FinderAction(actionType)", "CREATE INDEX IF NOT EXISTS Finder_Reply_state ON FinderAction(state)" };
  private static final int fBD;
  private static final int fDb = "localCommentId".hashCode();
  private static final int fDc = "feedId".hashCode();
  private static final int fDd = "actionTime".hashCode();
  private static final int fDe;
  private static final int fDf = "actionInfo".hashCode();
  private static final int fDg = "postTime".hashCode();
  private static final int fDh = "tryCount".hashCode();
  private static final int fDi = "canRemove".hashCode();
  private static final int fDj = "lastTryTime".hashCode();
  private static final int fDk = "failedFlag".hashCode();
  private static final int fjQ;
  private static final int fyj;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fBt = true;
  private boolean fCR = true;
  private boolean fCS = true;
  private boolean fCT = true;
  private boolean fCU = true;
  private boolean fCV = true;
  private boolean fCW = true;
  private boolean fCX = true;
  private boolean fCY = true;
  private boolean fCZ = true;
  private boolean fDa = true;
  public aoh field_actionInfo;
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
  private boolean fjO = true;
  private boolean fxx = true;
  
  static
  {
    fBD = "actionType".hashCode();
    fDe = "objectNonceId".hashCode();
    fjQ = "scene".hashCode();
    fyj = "state".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo ajs()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[13];
    localMAutoDBInfo.columns = new String[14];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "localCommentId";
    localMAutoDBInfo.colsMap.put("localCommentId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" localCommentId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "localCommentId";
    localMAutoDBInfo.columns[1] = "feedId";
    localMAutoDBInfo.colsMap.put("feedId", "LONG");
    localStringBuilder.append(" feedId LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "actionTime";
    localMAutoDBInfo.colsMap.put("actionTime", "LONG");
    localStringBuilder.append(" actionTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "actionType";
    localMAutoDBInfo.colsMap.put("actionType", "INTEGER");
    localStringBuilder.append(" actionType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "objectNonceId";
    localMAutoDBInfo.colsMap.put("objectNonceId", "TEXT");
    localStringBuilder.append(" objectNonceId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "scene";
    localMAutoDBInfo.colsMap.put("scene", "INTEGER");
    localStringBuilder.append(" scene INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "state";
    localMAutoDBInfo.colsMap.put("state", "INTEGER");
    localStringBuilder.append(" state INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "actionInfo";
    localMAutoDBInfo.colsMap.put("actionInfo", "BLOB");
    localStringBuilder.append(" actionInfo BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "postTime";
    localMAutoDBInfo.colsMap.put("postTime", "LONG");
    localStringBuilder.append(" postTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "tryCount";
    localMAutoDBInfo.colsMap.put("tryCount", "LONG");
    localStringBuilder.append(" tryCount LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "canRemove";
    localMAutoDBInfo.colsMap.put("canRemove", "INTEGER");
    localStringBuilder.append(" canRemove INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "lastTryTime";
    localMAutoDBInfo.colsMap.put("lastTryTime", "LONG");
    localStringBuilder.append(" lastTryTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "failedFlag";
    localMAutoDBInfo.colsMap.put("failedFlag", "INTEGER");
    localStringBuilder.append(" failedFlag INTEGER");
    localMAutoDBInfo.columns[13] = "rowid";
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
      if (fDb != k) {
        break label65;
      }
      this.field_localCommentId = paramCursor.getLong(i);
      this.fCR = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fDc == k) {
        this.field_feedId = paramCursor.getLong(i);
      } else if (fDd == k) {
        this.field_actionTime = paramCursor.getLong(i);
      } else if (fBD == k) {
        this.field_actionType = paramCursor.getInt(i);
      } else if (fDe == k) {
        this.field_objectNonceId = paramCursor.getString(i);
      } else if (fjQ == k) {
        this.field_scene = paramCursor.getInt(i);
      } else if (fyj == k) {
        this.field_state = paramCursor.getInt(i);
      } else if (fDf == k) {
        try
        {
          byte[] arrayOfByte = paramCursor.getBlob(i);
          if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
            continue;
          }
          this.field_actionInfo = ((aoh)new aoh().parseFrom(arrayOfByte));
        }
        catch (IOException localIOException)
        {
          Log.e("MicroMsg.SDK.BaseFinderAction", localIOException.getMessage());
        }
      } else if (fDg == k) {
        this.field_postTime = paramCursor.getLong(i);
      } else if (fDh == k) {
        this.field_tryCount = paramCursor.getLong(i);
      } else if (fDi == k) {
        this.field_canRemove = paramCursor.getInt(i);
      } else if (fDj == k) {
        this.field_lastTryTime = paramCursor.getLong(i);
      } else if (fDk == k) {
        this.field_failedFlag = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fCR) {
      localContentValues.put("localCommentId", Long.valueOf(this.field_localCommentId));
    }
    if (this.fCS) {
      localContentValues.put("feedId", Long.valueOf(this.field_feedId));
    }
    if (this.fCT) {
      localContentValues.put("actionTime", Long.valueOf(this.field_actionTime));
    }
    if (this.fBt) {
      localContentValues.put("actionType", Integer.valueOf(this.field_actionType));
    }
    if (this.fCU) {
      localContentValues.put("objectNonceId", this.field_objectNonceId);
    }
    if (this.fjO) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.fxx) {
      localContentValues.put("state", Integer.valueOf(this.field_state));
    }
    if ((this.fCV) && (this.field_actionInfo != null)) {}
    try
    {
      localContentValues.put("actionInfo", this.field_actionInfo.toByteArray());
      if (this.fCW) {
        localContentValues.put("postTime", Long.valueOf(this.field_postTime));
      }
      if (this.fCX) {
        localContentValues.put("tryCount", Long.valueOf(this.field_tryCount));
      }
      if (this.fCY) {
        localContentValues.put("canRemove", Integer.valueOf(this.field_canRemove));
      }
      if (this.fCZ) {
        localContentValues.put("lastTryTime", Long.valueOf(this.field_lastTryTime));
      }
      if (this.fDa) {
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
        Log.e("MicroMsg.SDK.BaseFinderAction", localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.cd
 * JD-Core Version:    0.7.0.1
 */
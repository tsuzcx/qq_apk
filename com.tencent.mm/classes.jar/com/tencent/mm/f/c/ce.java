package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.apk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class ce
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS Finder_Local_Comment_Id ON FinderAction(localCommentId)", "CREATE INDEX IF NOT EXISTS FinderAction_Feed_Id ON FinderAction(feedId)", "CREATE INDEX IF NOT EXISTS Finder_Feed_CreateTime ON FinderAction(actionTime)", "CREATE INDEX IF NOT EXISTS Finder_Feed_ActionType ON FinderAction(actionType)", "CREATE INDEX IF NOT EXISTS Finder_Reply_state ON FinderAction(state)" };
  public static final SingleTable TABLE = new SingleTable("FinderAction");
  public static final Column hHa;
  private static final int hIC = "state".hashCode();
  public static final Column hMU;
  private static final int hNo;
  private static final int hPG;
  private static final int hPH;
  private static final int hPI;
  private static final int hPJ;
  private static final int hPK = "actionInfo".hashCode();
  private static final int hPL = "postTime".hashCode();
  private static final int hPM = "tryCount".hashCode();
  private static final int hPN = "canRemove".hashCode();
  private static final int hPO = "lastTryTime".hashCode();
  private static final int hPP = "failedFlag".hashCode();
  public static final Column hPm;
  public static final Column hPn;
  public static final Column hPo;
  public static final Column hPp;
  public static final Column hPq;
  public static final Column hPr;
  public static final Column hPs;
  public static final Column hPt;
  public static final Column hPu;
  public static final Column hPv;
  public static final Column hnt;
  private static final int hnx;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public apk field_actionInfo;
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
  private boolean hHO = true;
  private boolean hNe = true;
  private boolean hPA = true;
  private boolean hPB = true;
  private boolean hPC = true;
  private boolean hPD = true;
  private boolean hPE = true;
  private boolean hPF = true;
  private boolean hPw = true;
  private boolean hPx = true;
  private boolean hPy = true;
  private boolean hPz = true;
  private boolean hnv = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "FinderAction", "");
    hPm = new Column("localcommentid", "long", "FinderAction", "");
    hPn = new Column("feedid", "long", "FinderAction", "");
    hPo = new Column("actiontime", "long", "FinderAction", "");
    hMU = new Column("actiontype", "int", "FinderAction", "");
    hPp = new Column("objectnonceid", "string", "FinderAction", "");
    hnt = new Column("scene", "int", "FinderAction", "");
    hHa = new Column("state", "int", "FinderAction", "");
    hPq = new Column("actioninfo", "proto", "FinderAction", "com.tencent.mm.protocal.protobuf.FinderActionPb");
    hPr = new Column("posttime", "long", "FinderAction", "");
    hPs = new Column("trycount", "long", "FinderAction", "");
    hPt = new Column("canremove", "int", "FinderAction", "");
    hPu = new Column("lasttrytime", "long", "FinderAction", "");
    hPv = new Column("failedflag", "int", "FinderAction", "");
    hPG = "localCommentId".hashCode();
    hPH = "feedId".hashCode();
    hPI = "actionTime".hashCode();
    hNo = "actionType".hashCode();
    hPJ = "objectNonceId".hashCode();
    hnx = "scene".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aoY()
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
      if (hPG != k) {
        break label65;
      }
      this.field_localCommentId = paramCursor.getLong(i);
      this.hPw = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (hPH == k) {
        this.field_feedId = paramCursor.getLong(i);
      } else if (hPI == k) {
        this.field_actionTime = paramCursor.getLong(i);
      } else if (hNo == k) {
        this.field_actionType = paramCursor.getInt(i);
      } else if (hPJ == k) {
        this.field_objectNonceId = paramCursor.getString(i);
      } else if (hnx == k) {
        this.field_scene = paramCursor.getInt(i);
      } else if (hIC == k) {
        this.field_state = paramCursor.getInt(i);
      } else if (hPK == k) {
        try
        {
          byte[] arrayOfByte = paramCursor.getBlob(i);
          if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
            continue;
          }
          this.field_actionInfo = ((apk)new apk().parseFrom(arrayOfByte));
        }
        catch (IOException localIOException)
        {
          Log.e("MicroMsg.SDK.BaseFinderAction", localIOException.getMessage());
        }
      } else if (hPL == k) {
        this.field_postTime = paramCursor.getLong(i);
      } else if (hPM == k) {
        this.field_tryCount = paramCursor.getLong(i);
      } else if (hPN == k) {
        this.field_canRemove = paramCursor.getInt(i);
      } else if (hPO == k) {
        this.field_lastTryTime = paramCursor.getLong(i);
      } else if (hPP == k) {
        this.field_failedFlag = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hPw) {
      localContentValues.put("localCommentId", Long.valueOf(this.field_localCommentId));
    }
    if (this.hPx) {
      localContentValues.put("feedId", Long.valueOf(this.field_feedId));
    }
    if (this.hPy) {
      localContentValues.put("actionTime", Long.valueOf(this.field_actionTime));
    }
    if (this.hNe) {
      localContentValues.put("actionType", Integer.valueOf(this.field_actionType));
    }
    if (this.hPz) {
      localContentValues.put("objectNonceId", this.field_objectNonceId);
    }
    if (this.hnv) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.hHO) {
      localContentValues.put("state", Integer.valueOf(this.field_state));
    }
    if ((this.hPA) && (this.field_actionInfo != null)) {}
    try
    {
      localContentValues.put("actionInfo", this.field_actionInfo.toByteArray());
      if (this.hPB) {
        localContentValues.put("postTime", Long.valueOf(this.field_postTime));
      }
      if (this.hPC) {
        localContentValues.put("tryCount", Long.valueOf(this.field_tryCount));
      }
      if (this.hPD) {
        localContentValues.put("canRemove", Integer.valueOf(this.field_canRemove));
      }
      if (this.hPE) {
        localContentValues.put("lastTryTime", Long.valueOf(this.field_lastTryTime));
      }
      if (this.hPF) {
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
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "FinderAction";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.c.ce
 * JD-Core Version:    0.7.0.1
 */
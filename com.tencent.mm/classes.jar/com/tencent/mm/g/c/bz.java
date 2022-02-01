package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.ahs;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class bz
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS Finder_Local_Comment_Id ON FinderAction(localCommentId)", "CREATE INDEX IF NOT EXISTS Finder_Feed_Id ON FinderAction(feedId)", "CREATE INDEX IF NOT EXISTS Finder_Feed_CreateTime ON FinderAction(actionTime)", "CREATE INDEX IF NOT EXISTS Finder_Feed_ActionType ON FinderAction(actionType)", "CREATE INDEX IF NOT EXISTS Finder_Reply_state ON FinderAction(state)" };
  private static final int eCx;
  private static final int eDT = "localCommentId".hashCode();
  private static final int eDU = "feedId".hashCode();
  private static final int eDV = "actionTime".hashCode();
  private static final int eDW;
  private static final int eDX = "actionInfo".hashCode();
  private static final int eDY = "postTime".hashCode();
  private static final int eDZ = "tryCount".hashCode();
  private static final int eEa = "canRemove".hashCode();
  private static final int eEb = "lastTryTime".hashCode();
  private static final int eEc = "failedFlag".hashCode();
  private static final int elq;
  private static final int ezb;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eCn = true;
  private boolean eDJ = true;
  private boolean eDK = true;
  private boolean eDL = true;
  private boolean eDM = true;
  private boolean eDN = true;
  private boolean eDO = true;
  private boolean eDP = true;
  private boolean eDQ = true;
  private boolean eDR = true;
  private boolean eDS = true;
  private boolean elo = true;
  private boolean eyp = true;
  public ahs field_actionInfo;
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
    eCx = "actionType".hashCode();
    eDW = "objectNonceId".hashCode();
    elq = "scene".hashCode();
    ezb = "state".hashCode();
  }
  
  public static c.a So()
  {
    c.a locala = new c.a();
    locala.EYt = new Field[13];
    locala.columns = new String[14];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "localCommentId";
    locala.EYv.put("localCommentId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" localCommentId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.EYu = "localCommentId";
    locala.columns[1] = "feedId";
    locala.EYv.put("feedId", "LONG");
    localStringBuilder.append(" feedId LONG");
    localStringBuilder.append(", ");
    locala.columns[2] = "actionTime";
    locala.EYv.put("actionTime", "LONG");
    localStringBuilder.append(" actionTime LONG");
    localStringBuilder.append(", ");
    locala.columns[3] = "actionType";
    locala.EYv.put("actionType", "INTEGER");
    localStringBuilder.append(" actionType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "objectNonceId";
    locala.EYv.put("objectNonceId", "TEXT");
    localStringBuilder.append(" objectNonceId TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "scene";
    locala.EYv.put("scene", "INTEGER");
    localStringBuilder.append(" scene INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "state";
    locala.EYv.put("state", "INTEGER");
    localStringBuilder.append(" state INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "actionInfo";
    locala.EYv.put("actionInfo", "BLOB");
    localStringBuilder.append(" actionInfo BLOB");
    localStringBuilder.append(", ");
    locala.columns[8] = "postTime";
    locala.EYv.put("postTime", "LONG");
    localStringBuilder.append(" postTime LONG");
    localStringBuilder.append(", ");
    locala.columns[9] = "tryCount";
    locala.EYv.put("tryCount", "LONG");
    localStringBuilder.append(" tryCount LONG");
    localStringBuilder.append(", ");
    locala.columns[10] = "canRemove";
    locala.EYv.put("canRemove", "INTEGER");
    localStringBuilder.append(" canRemove INTEGER");
    localStringBuilder.append(", ");
    locala.columns[11] = "lastTryTime";
    locala.EYv.put("lastTryTime", "LONG");
    localStringBuilder.append(" lastTryTime LONG");
    localStringBuilder.append(", ");
    locala.columns[12] = "failedFlag";
    locala.EYv.put("failedFlag", "INTEGER");
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
      if (eDT != k) {
        break label65;
      }
      this.field_localCommentId = paramCursor.getLong(i);
      this.eDJ = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eDU == k) {
        this.field_feedId = paramCursor.getLong(i);
      } else if (eDV == k) {
        this.field_actionTime = paramCursor.getLong(i);
      } else if (eCx == k) {
        this.field_actionType = paramCursor.getInt(i);
      } else if (eDW == k) {
        this.field_objectNonceId = paramCursor.getString(i);
      } else if (elq == k) {
        this.field_scene = paramCursor.getInt(i);
      } else if (ezb == k) {
        this.field_state = paramCursor.getInt(i);
      } else if (eDX == k) {
        try
        {
          byte[] arrayOfByte = paramCursor.getBlob(i);
          if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
            continue;
          }
          this.field_actionInfo = ((ahs)new ahs().parseFrom(arrayOfByte));
        }
        catch (IOException localIOException)
        {
          ad.e("MicroMsg.SDK.BaseFinderAction", localIOException.getMessage());
        }
      } else if (eDY == k) {
        this.field_postTime = paramCursor.getLong(i);
      } else if (eDZ == k) {
        this.field_tryCount = paramCursor.getLong(i);
      } else if (eEa == k) {
        this.field_canRemove = paramCursor.getInt(i);
      } else if (eEb == k) {
        this.field_lastTryTime = paramCursor.getLong(i);
      } else if (eEc == k) {
        this.field_failedFlag = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eDJ) {
      localContentValues.put("localCommentId", Long.valueOf(this.field_localCommentId));
    }
    if (this.eDK) {
      localContentValues.put("feedId", Long.valueOf(this.field_feedId));
    }
    if (this.eDL) {
      localContentValues.put("actionTime", Long.valueOf(this.field_actionTime));
    }
    if (this.eCn) {
      localContentValues.put("actionType", Integer.valueOf(this.field_actionType));
    }
    if (this.eDM) {
      localContentValues.put("objectNonceId", this.field_objectNonceId);
    }
    if (this.elo) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.eyp) {
      localContentValues.put("state", Integer.valueOf(this.field_state));
    }
    if ((this.eDN) && (this.field_actionInfo != null)) {}
    try
    {
      localContentValues.put("actionInfo", this.field_actionInfo.toByteArray());
      if (this.eDO) {
        localContentValues.put("postTime", Long.valueOf(this.field_postTime));
      }
      if (this.eDP) {
        localContentValues.put("tryCount", Long.valueOf(this.field_tryCount));
      }
      if (this.eDQ) {
        localContentValues.put("canRemove", Integer.valueOf(this.field_canRemove));
      }
      if (this.eDR) {
        localContentValues.put("lastTryTime", Long.valueOf(this.field_lastTryTime));
      }
      if (this.eDS) {
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
        ad.e("MicroMsg.SDK.BaseFinderAction", localIOException.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.bz
 * JD-Core Version:    0.7.0.1
 */
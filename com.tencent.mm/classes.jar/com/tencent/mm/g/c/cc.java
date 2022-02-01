package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.alh;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class cc
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS Finder_Local_Comment_Id ON FinderAction(localCommentId)", "CREATE INDEX IF NOT EXISTS FinderAction_Feed_Id ON FinderAction(feedId)", "CREATE INDEX IF NOT EXISTS Finder_Feed_CreateTime ON FinderAction(actionTime)", "CREATE INDEX IF NOT EXISTS Finder_Feed_ActionType ON FinderAction(actionType)", "CREATE INDEX IF NOT EXISTS Finder_Reply_state ON FinderAction(state)" };
  private static final int eEB = "scene".hashCode();
  private static final int eST = "state".hashCode();
  private static final int eWp;
  private static final int eXL = "localCommentId".hashCode();
  private static final int eXM = "feedId".hashCode();
  private static final int eXN = "actionTime".hashCode();
  private static final int eXO;
  private static final int eXP = "actionInfo".hashCode();
  private static final int eXQ = "postTime".hashCode();
  private static final int eXR = "tryCount".hashCode();
  private static final int eXS = "canRemove".hashCode();
  private static final int eXT = "lastTryTime".hashCode();
  private static final int eXU = "failedFlag".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eEz = true;
  private boolean eSh = true;
  private boolean eWf = true;
  private boolean eXB = true;
  private boolean eXC = true;
  private boolean eXD = true;
  private boolean eXE = true;
  private boolean eXF = true;
  private boolean eXG = true;
  private boolean eXH = true;
  private boolean eXI = true;
  private boolean eXJ = true;
  private boolean eXK = true;
  public alh field_actionInfo;
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
    eWp = "actionType".hashCode();
    eXO = "objectNonceId".hashCode();
  }
  
  public static c.a Vv()
  {
    c.a locala = new c.a();
    locala.IhA = new Field[13];
    locala.columns = new String[14];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "localCommentId";
    locala.IhC.put("localCommentId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" localCommentId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "localCommentId";
    locala.columns[1] = "feedId";
    locala.IhC.put("feedId", "LONG");
    localStringBuilder.append(" feedId LONG");
    localStringBuilder.append(", ");
    locala.columns[2] = "actionTime";
    locala.IhC.put("actionTime", "LONG");
    localStringBuilder.append(" actionTime LONG");
    localStringBuilder.append(", ");
    locala.columns[3] = "actionType";
    locala.IhC.put("actionType", "INTEGER");
    localStringBuilder.append(" actionType INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "objectNonceId";
    locala.IhC.put("objectNonceId", "TEXT");
    localStringBuilder.append(" objectNonceId TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "scene";
    locala.IhC.put("scene", "INTEGER");
    localStringBuilder.append(" scene INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "state";
    locala.IhC.put("state", "INTEGER");
    localStringBuilder.append(" state INTEGER");
    localStringBuilder.append(", ");
    locala.columns[7] = "actionInfo";
    locala.IhC.put("actionInfo", "BLOB");
    localStringBuilder.append(" actionInfo BLOB");
    localStringBuilder.append(", ");
    locala.columns[8] = "postTime";
    locala.IhC.put("postTime", "LONG");
    localStringBuilder.append(" postTime LONG");
    localStringBuilder.append(", ");
    locala.columns[9] = "tryCount";
    locala.IhC.put("tryCount", "LONG");
    localStringBuilder.append(" tryCount LONG");
    localStringBuilder.append(", ");
    locala.columns[10] = "canRemove";
    locala.IhC.put("canRemove", "INTEGER");
    localStringBuilder.append(" canRemove INTEGER");
    localStringBuilder.append(", ");
    locala.columns[11] = "lastTryTime";
    locala.IhC.put("lastTryTime", "LONG");
    localStringBuilder.append(" lastTryTime LONG");
    localStringBuilder.append(", ");
    locala.columns[12] = "failedFlag";
    locala.IhC.put("failedFlag", "INTEGER");
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
      if (eXL != k) {
        break label65;
      }
      this.field_localCommentId = paramCursor.getLong(i);
      this.eXB = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eXM == k) {
        this.field_feedId = paramCursor.getLong(i);
      } else if (eXN == k) {
        this.field_actionTime = paramCursor.getLong(i);
      } else if (eWp == k) {
        this.field_actionType = paramCursor.getInt(i);
      } else if (eXO == k) {
        this.field_objectNonceId = paramCursor.getString(i);
      } else if (eEB == k) {
        this.field_scene = paramCursor.getInt(i);
      } else if (eST == k) {
        this.field_state = paramCursor.getInt(i);
      } else if (eXP == k) {
        try
        {
          byte[] arrayOfByte = paramCursor.getBlob(i);
          if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
            continue;
          }
          this.field_actionInfo = ((alh)new alh().parseFrom(arrayOfByte));
        }
        catch (IOException localIOException)
        {
          ad.e("MicroMsg.SDK.BaseFinderAction", localIOException.getMessage());
        }
      } else if (eXQ == k) {
        this.field_postTime = paramCursor.getLong(i);
      } else if (eXR == k) {
        this.field_tryCount = paramCursor.getLong(i);
      } else if (eXS == k) {
        this.field_canRemove = paramCursor.getInt(i);
      } else if (eXT == k) {
        this.field_lastTryTime = paramCursor.getLong(i);
      } else if (eXU == k) {
        this.field_failedFlag = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.eXB) {
      localContentValues.put("localCommentId", Long.valueOf(this.field_localCommentId));
    }
    if (this.eXC) {
      localContentValues.put("feedId", Long.valueOf(this.field_feedId));
    }
    if (this.eXD) {
      localContentValues.put("actionTime", Long.valueOf(this.field_actionTime));
    }
    if (this.eWf) {
      localContentValues.put("actionType", Integer.valueOf(this.field_actionType));
    }
    if (this.eXE) {
      localContentValues.put("objectNonceId", this.field_objectNonceId);
    }
    if (this.eEz) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.eSh) {
      localContentValues.put("state", Integer.valueOf(this.field_state));
    }
    if ((this.eXF) && (this.field_actionInfo != null)) {}
    try
    {
      localContentValues.put("actionInfo", this.field_actionInfo.toByteArray());
      if (this.eXG) {
        localContentValues.put("postTime", Long.valueOf(this.field_postTime));
      }
      if (this.eXH) {
        localContentValues.put("tryCount", Long.valueOf(this.field_tryCount));
      }
      if (this.eXI) {
        localContentValues.put("canRemove", Integer.valueOf(this.field_canRemove));
      }
      if (this.eXJ) {
        localContentValues.put("lastTryTime", Long.valueOf(this.field_lastTryTime));
      }
      if (this.eXK) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.g.c.cc
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.FinderTipsShowEntranceExtInfo;
import com.tencent.mm.protocal.protobuf.bhw;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class cu
  extends IAutoDBItem
{
  public static final Column C_ROWID;
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS Finder_RedDot_tips_id ON FinderRedDotInfo(tipsId)", "CREATE INDEX IF NOT EXISTS Finder_RedDot_revoke_id ON FinderRedDotInfo(revokeId)", "CREATE INDEX IF NOT EXISTS Finder_RedDot_ctrType ON FinderRedDotInfo(ctrType)", "CREATE INDEX IF NOT EXISTS Finder_RedDot_expiredTime ON FinderRedDotInfo(expiredTime)" };
  public static final SingleTable TABLE = new SingleTable("FinderRedDotInfo");
  public static final Column hST;
  public static final Column hSX;
  private static final int hTl = "revokeId".hashCode();
  private static final int hTp;
  public static final Column hVj;
  public static final Column hVk;
  public static final Column hVl;
  public static final Column hVm;
  private static final int hVr;
  private static final int hVs = "tipsShowEntranceExtInfo".hashCode();
  private static final int hVt = "ctrType".hashCode();
  private static final int hVu = "expiredTime".hashCode();
  public static final Column hxZ;
  private static final int hyL;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  public bhw field_ctrInfo;
  public int field_ctrType;
  public long field_expiredTime;
  public String field_revokeId;
  public long field_time;
  public String field_tipsId;
  public FinderTipsShowEntranceExtInfo field_tipsShowEntranceExtInfo;
  private boolean hTc = true;
  private boolean hTg = true;
  private boolean hVn = true;
  private boolean hVo = true;
  private boolean hVp = true;
  private boolean hVq = true;
  private boolean hys = true;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "FinderRedDotInfo", "");
    hSX = new Column("tipsid", "string", "FinderRedDotInfo", "");
    hVj = new Column("ctrinfo", "proto", "FinderRedDotInfo", "com.tencent.mm.protocal.protobuf.FinderRedDotCtrlInfo");
    hxZ = new Column("time", "long", "FinderRedDotInfo", "");
    hST = new Column("revokeid", "string", "FinderRedDotInfo", "");
    hVk = new Column("tipsshowentranceextinfo", "proto", "FinderRedDotInfo", "com.tencent.mm.protocal.protobuf.FinderTipsShowEntranceExtInfo");
    hVl = new Column("ctrtype", "int", "FinderRedDotInfo", "");
    hVm = new Column("expiredtime", "long", "FinderRedDotInfo", "");
    hTp = "tipsId".hashCode();
    hVr = "ctrInfo".hashCode();
    hyL = "time".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aoY()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[7];
    localMAutoDBInfo.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "tipsId";
    localMAutoDBInfo.colsMap.put("tipsId", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" tipsId TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "tipsId";
    localMAutoDBInfo.columns[1] = "ctrInfo";
    localMAutoDBInfo.colsMap.put("ctrInfo", "BLOB");
    localStringBuilder.append(" ctrInfo BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "time";
    localMAutoDBInfo.colsMap.put("time", "LONG");
    localStringBuilder.append(" time LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "revokeId";
    localMAutoDBInfo.colsMap.put("revokeId", "TEXT");
    localStringBuilder.append(" revokeId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "tipsShowEntranceExtInfo";
    localMAutoDBInfo.colsMap.put("tipsShowEntranceExtInfo", "BLOB");
    localStringBuilder.append(" tipsShowEntranceExtInfo BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "ctrType";
    localMAutoDBInfo.colsMap.put("ctrType", "INTEGER");
    localStringBuilder.append(" ctrType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "expiredTime";
    localMAutoDBInfo.colsMap.put("expiredTime", "LONG");
    localStringBuilder.append(" expiredTime LONG");
    localMAutoDBInfo.columns[7] = "rowid";
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
      if (hTp != k) {
        break label65;
      }
      this.field_tipsId = paramCursor.getString(i);
      this.hTg = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (hVr == k) {
        try
        {
          byte[] arrayOfByte1 = paramCursor.getBlob(i);
          if ((arrayOfByte1 == null) || (arrayOfByte1.length <= 0)) {
            continue;
          }
          this.field_ctrInfo = ((bhw)new bhw().parseFrom(arrayOfByte1));
        }
        catch (IOException localIOException1)
        {
          Log.e("MicroMsg.SDK.BaseFinderRedDotInfo", localIOException1.getMessage());
        }
      } else if (hyL == k) {
        this.field_time = paramCursor.getLong(i);
      } else if (hTl == k) {
        this.field_revokeId = paramCursor.getString(i);
      } else if (hVs == k) {
        try
        {
          byte[] arrayOfByte2 = paramCursor.getBlob(i);
          if ((arrayOfByte2 == null) || (arrayOfByte2.length <= 0)) {
            continue;
          }
          this.field_tipsShowEntranceExtInfo = ((FinderTipsShowEntranceExtInfo)new FinderTipsShowEntranceExtInfo().parseFrom(arrayOfByte2));
        }
        catch (IOException localIOException2)
        {
          Log.e("MicroMsg.SDK.BaseFinderRedDotInfo", localIOException2.getMessage());
        }
      } else if (hVt == k) {
        this.field_ctrType = paramCursor.getInt(i);
      } else if (hVu == k) {
        this.field_expiredTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.hTg) {
      localContentValues.put("tipsId", this.field_tipsId);
    }
    if ((this.hVn) && (this.field_ctrInfo != null)) {}
    try
    {
      localContentValues.put("ctrInfo", this.field_ctrInfo.toByteArray());
      if (this.hys) {
        localContentValues.put("time", Long.valueOf(this.field_time));
      }
      if (this.hTc) {
        localContentValues.put("revokeId", this.field_revokeId);
      }
      if ((!this.hVo) || (this.field_tipsShowEntranceExtInfo == null)) {}
    }
    catch (IOException localIOException1)
    {
      try
      {
        localContentValues.put("tipsShowEntranceExtInfo", this.field_tipsShowEntranceExtInfo.toByteArray());
        if (this.hVp) {
          localContentValues.put("ctrType", Integer.valueOf(this.field_ctrType));
        }
        if (this.hVq) {
          localContentValues.put("expiredTime", Long.valueOf(this.field_expiredTime));
        }
        if (this.systemRowid > 0L) {
          localContentValues.put("rowid", Long.valueOf(this.systemRowid));
        }
        return localContentValues;
        localIOException1 = localIOException1;
        Log.e("MicroMsg.SDK.BaseFinderRedDotInfo", localIOException1.getMessage());
      }
      catch (IOException localIOException2)
      {
        for (;;)
        {
          Log.e("MicroMsg.SDK.BaseFinderRedDotInfo", localIOException2.getMessage());
        }
      }
    }
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public String getTableName()
  {
    return "FinderRedDotInfo";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.c.cu
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.FinderTipsShowEntranceExtInfo;
import com.tencent.mm.protocal.protobuf.bbi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class co
  extends IAutoDBItem
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS Finder_RedDot_tips_id ON FinderRedDotInfo(tipsId)", "CREATE INDEX IF NOT EXISTS Finder_RedDot_revoke_id ON FinderRedDotInfo(revokeId)", "CREATE INDEX IF NOT EXISTS Finder_RedDot_ctrType ON FinderRedDotInfo(ctrType)", "CREATE INDEX IF NOT EXISTS Finder_RedDot_expiredTime ON FinderRedDotInfo(expiredTime)" };
  private static final int fGf = "tipsId".hashCode();
  private static final int fGg = "ctrInfo".hashCode();
  private static final int fGh = "revokeId".hashCode();
  private static final int fGi = "tipsShowEntranceExtInfo".hashCode();
  private static final int fGj = "ctrType".hashCode();
  private static final int fGk = "expiredTime".hashCode();
  private static final int frC = "time".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean fFZ = true;
  private boolean fGa = true;
  private boolean fGb = true;
  private boolean fGc = true;
  private boolean fGd = true;
  private boolean fGe = true;
  public bbi field_ctrInfo;
  public int field_ctrType;
  public long field_expiredTime;
  public String field_revokeId;
  public long field_time;
  public String field_tipsId;
  public FinderTipsShowEntranceExtInfo field_tipsShowEntranceExtInfo;
  private boolean frj = true;
  
  public static IAutoDBItem.MAutoDBInfo ajs()
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
      if (fGf != k) {
        break label65;
      }
      this.field_tipsId = paramCursor.getString(i);
      this.fFZ = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (fGg == k) {
        try
        {
          byte[] arrayOfByte1 = paramCursor.getBlob(i);
          if ((arrayOfByte1 == null) || (arrayOfByte1.length <= 0)) {
            continue;
          }
          this.field_ctrInfo = ((bbi)new bbi().parseFrom(arrayOfByte1));
        }
        catch (IOException localIOException1)
        {
          Log.e("MicroMsg.SDK.BaseFinderRedDotInfo", localIOException1.getMessage());
        }
      } else if (frC == k) {
        this.field_time = paramCursor.getLong(i);
      } else if (fGh == k) {
        this.field_revokeId = paramCursor.getString(i);
      } else if (fGi == k) {
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
      } else if (fGj == k) {
        this.field_ctrType = paramCursor.getInt(i);
      } else if (fGk == k) {
        this.field_expiredTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.fFZ) {
      localContentValues.put("tipsId", this.field_tipsId);
    }
    if ((this.fGa) && (this.field_ctrInfo != null)) {}
    try
    {
      localContentValues.put("ctrInfo", this.field_ctrInfo.toByteArray());
      if (this.frj) {
        localContentValues.put("time", Long.valueOf(this.field_time));
      }
      if (this.fGb) {
        localContentValues.put("revokeId", this.field_revokeId);
      }
      if ((!this.fGc) || (this.field_tipsShowEntranceExtInfo == null)) {}
    }
    catch (IOException localIOException1)
    {
      try
      {
        localContentValues.put("tipsShowEntranceExtInfo", this.field_tipsShowEntranceExtInfo.toByteArray());
        if (this.fGd) {
          localContentValues.put("ctrType", Integer.valueOf(this.field_ctrType));
        }
        if (this.fGe) {
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.co
 * JD-Core Version:    0.7.0.1
 */
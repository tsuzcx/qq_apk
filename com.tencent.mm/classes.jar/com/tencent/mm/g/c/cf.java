package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.amh;
import com.tencent.mm.protocal.protobuf.aqi;
import com.tencent.mm.protocal.protobuf.bvg;
import com.tencent.mm.protocal.protobuf.bvl;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class cf
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS FinderFeedItem_local_index ON FinderFeedItem(localId)", "CREATE INDEX IF NOT EXISTS FinderFeedItem_Id ON FinderFeedItem(id)", "CREATE INDEX IF NOT EXISTS FinderFeedItem_create_time ON FinderFeedItem(createTime)", "CREATE INDEX IF NOT EXISTS FinderFeedItem__Local_Flag ON FinderFeedItem(localFlag)" };
  private static final int eEe = "localFlag".hashCode();
  private static final int eEf;
  private static final int eFp;
  private static final int eFq;
  private static final int eOw;
  private static final int eVj = "localId".hashCode();
  private static final int eYE;
  private static final int eYF;
  private static final int eYG = "postinfo".hashCode();
  private static final int eYH = "mediaExtList".hashCode();
  private static final int eYI = "reportObject".hashCode();
  private static final int eYJ = "postExtraData".hashCode();
  private static final int eYK = "customData".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eDH = true;
  private boolean eDI = true;
  private boolean eFm = true;
  private boolean eFn = true;
  private boolean eOs = true;
  private boolean eVh = true;
  private boolean eYA = true;
  private boolean eYB = true;
  private boolean eYC = true;
  private boolean eYD = true;
  private boolean eYx = true;
  private boolean eYy = true;
  private boolean eYz = true;
  public long field_createTime;
  public amh field_customData;
  public FinderObject field_finderObject;
  public long field_id;
  public int field_localFlag;
  public long field_localId;
  public bvl field_mediaExtList;
  public aqi field_postExtraData;
  public bvg field_postinfo;
  public FinderFeedReportObject field_reportObject;
  public int field_sourceFlag;
  public long field_updateTime;
  public String field_username;
  
  static
  {
    eOw = "id".hashCode();
    eEf = "createTime".hashCode();
    eFp = "username".hashCode();
    eYE = "sourceFlag".hashCode();
    eFq = "updateTime".hashCode();
    eYF = "finderObject".hashCode();
  }
  
  private final void buildBuff() {}
  
  public static c.a initAutoDBInfo(Class<?> paramClass)
  {
    paramClass = new c.a();
    paramClass.IhA = new Field[13];
    paramClass.columns = new String[14];
    StringBuilder localStringBuilder = new StringBuilder();
    paramClass.columns[0] = "localId";
    paramClass.IhC.put("localId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" localId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    paramClass.IhB = "localId";
    paramClass.columns[1] = "id";
    paramClass.IhC.put("id", "LONG");
    localStringBuilder.append(" id LONG");
    localStringBuilder.append(", ");
    paramClass.columns[2] = "createTime";
    paramClass.IhC.put("createTime", "LONG");
    localStringBuilder.append(" createTime LONG");
    localStringBuilder.append(", ");
    paramClass.columns[3] = "username";
    paramClass.IhC.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    paramClass.columns[4] = "sourceFlag";
    paramClass.IhC.put("sourceFlag", "INTEGER");
    localStringBuilder.append(" sourceFlag INTEGER");
    localStringBuilder.append(", ");
    paramClass.columns[5] = "updateTime";
    paramClass.IhC.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    paramClass.columns[6] = "finderObject";
    paramClass.IhC.put("finderObject", "BLOB");
    localStringBuilder.append(" finderObject BLOB");
    localStringBuilder.append(", ");
    paramClass.columns[7] = "localFlag";
    paramClass.IhC.put("localFlag", "INTEGER");
    localStringBuilder.append(" localFlag INTEGER");
    localStringBuilder.append(", ");
    paramClass.columns[8] = "postinfo";
    paramClass.IhC.put("postinfo", "BLOB");
    localStringBuilder.append(" postinfo BLOB");
    localStringBuilder.append(", ");
    paramClass.columns[9] = "mediaExtList";
    paramClass.IhC.put("mediaExtList", "BLOB");
    localStringBuilder.append(" mediaExtList BLOB");
    localStringBuilder.append(", ");
    paramClass.columns[10] = "reportObject";
    paramClass.IhC.put("reportObject", "BLOB");
    localStringBuilder.append(" reportObject BLOB");
    localStringBuilder.append(", ");
    paramClass.columns[11] = "postExtraData";
    paramClass.IhC.put("postExtraData", "BLOB");
    localStringBuilder.append(" postExtraData BLOB");
    localStringBuilder.append(", ");
    paramClass.columns[12] = "customData";
    paramClass.IhC.put("customData", "BLOB");
    localStringBuilder.append(" customData BLOB");
    paramClass.columns[13] = "rowid";
    paramClass.sql = localStringBuilder.toString();
    return paramClass;
  }
  
  private final void parseBuff() {}
  
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
      if (eVj != k) {
        break label65;
      }
      this.field_localId = paramCursor.getLong(i);
      this.eVh = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eOw == k) {
        this.field_id = paramCursor.getLong(i);
      } else if (eEf == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (eFp == k) {
        this.field_username = paramCursor.getString(i);
      } else if (eYE == k) {
        this.field_sourceFlag = paramCursor.getInt(i);
      } else if (eFq == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (eYF == k) {
        try
        {
          byte[] arrayOfByte1 = paramCursor.getBlob(i);
          if ((arrayOfByte1 == null) || (arrayOfByte1.length <= 0)) {
            continue;
          }
          this.field_finderObject = ((FinderObject)new FinderObject().parseFrom(arrayOfByte1));
        }
        catch (IOException localIOException1)
        {
          ad.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException1.getMessage());
        }
      } else if (eEe == k) {
        this.field_localFlag = paramCursor.getInt(i);
      } else if (eYG == k) {
        try
        {
          byte[] arrayOfByte2 = paramCursor.getBlob(i);
          if ((arrayOfByte2 == null) || (arrayOfByte2.length <= 0)) {
            continue;
          }
          this.field_postinfo = ((bvg)new bvg().parseFrom(arrayOfByte2));
        }
        catch (IOException localIOException2)
        {
          ad.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException2.getMessage());
        }
      } else if (eYH == k) {
        try
        {
          byte[] arrayOfByte3 = paramCursor.getBlob(i);
          if ((arrayOfByte3 == null) || (arrayOfByte3.length <= 0)) {
            continue;
          }
          this.field_mediaExtList = ((bvl)new bvl().parseFrom(arrayOfByte3));
        }
        catch (IOException localIOException3)
        {
          ad.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException3.getMessage());
        }
      } else if (eYI == k) {
        try
        {
          byte[] arrayOfByte4 = paramCursor.getBlob(i);
          if ((arrayOfByte4 == null) || (arrayOfByte4.length <= 0)) {
            continue;
          }
          this.field_reportObject = ((FinderFeedReportObject)new FinderFeedReportObject().parseFrom(arrayOfByte4));
        }
        catch (IOException localIOException4)
        {
          ad.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException4.getMessage());
        }
      } else if (eYJ == k) {
        try
        {
          byte[] arrayOfByte5 = paramCursor.getBlob(i);
          if ((arrayOfByte5 == null) || (arrayOfByte5.length <= 0)) {
            continue;
          }
          this.field_postExtraData = ((aqi)new aqi().parseFrom(arrayOfByte5));
        }
        catch (IOException localIOException5)
        {
          ad.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException5.getMessage());
        }
      } else if (eYK == k) {
        try
        {
          byte[] arrayOfByte6 = paramCursor.getBlob(i);
          if ((arrayOfByte6 == null) || (arrayOfByte6.length <= 0)) {
            continue;
          }
          this.field_customData = ((amh)new amh().parseFrom(arrayOfByte6));
        }
        catch (IOException localIOException6)
        {
          ad.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException6.getMessage());
        }
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    buildBuff();
    ContentValues localContentValues = new ContentValues();
    if (this.eVh) {
      localContentValues.put("localId", Long.valueOf(this.field_localId));
    }
    if (this.eOs) {
      localContentValues.put("id", Long.valueOf(this.field_id));
    }
    if (this.eDI) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.eFm) {
      localContentValues.put("username", this.field_username);
    }
    if (this.eYx) {
      localContentValues.put("sourceFlag", Integer.valueOf(this.field_sourceFlag));
    }
    if (this.eFn) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if ((this.eYy) && (this.field_finderObject != null)) {}
    try
    {
      localContentValues.put("finderObject", this.field_finderObject.toByteArray());
      if (this.eDH) {
        localContentValues.put("localFlag", Integer.valueOf(this.field_localFlag));
      }
      if ((!this.eYz) || (this.field_postinfo == null)) {}
    }
    catch (IOException localIOException5)
    {
      try
      {
        localContentValues.put("postinfo", this.field_postinfo.toByteArray());
        if ((!this.eYA) || (this.field_mediaExtList == null)) {}
      }
      catch (IOException localIOException5)
      {
        try
        {
          localContentValues.put("mediaExtList", this.field_mediaExtList.toByteArray());
          if ((!this.eYB) || (this.field_reportObject == null)) {}
        }
        catch (IOException localIOException5)
        {
          try
          {
            localContentValues.put("reportObject", this.field_reportObject.toByteArray());
            if ((!this.eYC) || (this.field_postExtraData == null)) {}
          }
          catch (IOException localIOException5)
          {
            try
            {
              localContentValues.put("postExtraData", this.field_postExtraData.toByteArray());
              if ((!this.eYD) || (this.field_customData == null)) {}
            }
            catch (IOException localIOException5)
            {
              try
              {
                for (;;)
                {
                  localContentValues.put("customData", this.field_customData.toByteArray());
                  if (this.systemRowid > 0L) {
                    localContentValues.put("rowid", Long.valueOf(this.systemRowid));
                  }
                  return localContentValues;
                  localIOException1 = localIOException1;
                  ad.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException1.getMessage());
                  continue;
                  localIOException2 = localIOException2;
                  ad.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException2.getMessage());
                  continue;
                  localIOException3 = localIOException3;
                  ad.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException3.getMessage());
                  continue;
                  localIOException4 = localIOException4;
                  ad.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException4.getMessage());
                }
                localIOException5 = localIOException5;
                ad.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException5.getMessage());
              }
              catch (IOException localIOException6)
              {
                for (;;)
                {
                  ad.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException6.getMessage());
                }
              }
            }
          }
        }
      }
    }
  }
  
  public void reset() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.g.c.cf
 * JD-Core Version:    0.7.0.1
 */
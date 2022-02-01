package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.amt;
import com.tencent.mm.protocal.protobuf.aqx;
import com.tencent.mm.protocal.protobuf.bwa;
import com.tencent.mm.protocal.protobuf.bwf;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ae;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class cf
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS FinderFeedItem_local_index ON FinderFeedItem(localId)", "CREATE INDEX IF NOT EXISTS FinderFeedItem_Id ON FinderFeedItem(id)", "CREATE INDEX IF NOT EXISTS FinderFeedItem_create_time ON FinderFeedItem(createTime)", "CREATE INDEX IF NOT EXISTS FinderFeedItem__Local_Flag ON FinderFeedItem(localFlag)" };
  private static final int eFN = "localFlag".hashCode();
  private static final int eFO;
  private static final int eGY;
  private static final int eGZ;
  private static final int eQh;
  private static final int eWU = "localId".hashCode();
  private static final int far;
  private static final int fas;
  private static final int fat = "postinfo".hashCode();
  private static final int fau = "mediaExtList".hashCode();
  private static final int fav = "reportObject".hashCode();
  private static final int faw = "postExtraData".hashCode();
  private static final int fax = "customData".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eFq = true;
  private boolean eFr = true;
  private boolean eGV = true;
  private boolean eGW = true;
  private boolean eQd = true;
  private boolean eWS = true;
  private boolean fak = true;
  private boolean fal = true;
  private boolean fam = true;
  private boolean fan = true;
  private boolean fao = true;
  private boolean fap = true;
  private boolean faq = true;
  public long field_createTime;
  public amt field_customData;
  public FinderObject field_finderObject;
  public long field_id;
  public int field_localFlag;
  public long field_localId;
  public bwf field_mediaExtList;
  public aqx field_postExtraData;
  public bwa field_postinfo;
  public FinderFeedReportObject field_reportObject;
  public int field_sourceFlag;
  public long field_updateTime;
  public String field_username;
  
  static
  {
    eQh = "id".hashCode();
    eFO = "createTime".hashCode();
    eGY = "username".hashCode();
    far = "sourceFlag".hashCode();
    eGZ = "updateTime".hashCode();
    fas = "finderObject".hashCode();
  }
  
  private final void buildBuff() {}
  
  public static c.a initAutoDBInfo(Class<?> paramClass)
  {
    paramClass = new c.a();
    paramClass.IBL = new Field[13];
    paramClass.columns = new String[14];
    StringBuilder localStringBuilder = new StringBuilder();
    paramClass.columns[0] = "localId";
    paramClass.IBN.put("localId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" localId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    paramClass.IBM = "localId";
    paramClass.columns[1] = "id";
    paramClass.IBN.put("id", "LONG");
    localStringBuilder.append(" id LONG");
    localStringBuilder.append(", ");
    paramClass.columns[2] = "createTime";
    paramClass.IBN.put("createTime", "LONG");
    localStringBuilder.append(" createTime LONG");
    localStringBuilder.append(", ");
    paramClass.columns[3] = "username";
    paramClass.IBN.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    paramClass.columns[4] = "sourceFlag";
    paramClass.IBN.put("sourceFlag", "INTEGER");
    localStringBuilder.append(" sourceFlag INTEGER");
    localStringBuilder.append(", ");
    paramClass.columns[5] = "updateTime";
    paramClass.IBN.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    paramClass.columns[6] = "finderObject";
    paramClass.IBN.put("finderObject", "BLOB");
    localStringBuilder.append(" finderObject BLOB");
    localStringBuilder.append(", ");
    paramClass.columns[7] = "localFlag";
    paramClass.IBN.put("localFlag", "INTEGER");
    localStringBuilder.append(" localFlag INTEGER");
    localStringBuilder.append(", ");
    paramClass.columns[8] = "postinfo";
    paramClass.IBN.put("postinfo", "BLOB");
    localStringBuilder.append(" postinfo BLOB");
    localStringBuilder.append(", ");
    paramClass.columns[9] = "mediaExtList";
    paramClass.IBN.put("mediaExtList", "BLOB");
    localStringBuilder.append(" mediaExtList BLOB");
    localStringBuilder.append(", ");
    paramClass.columns[10] = "reportObject";
    paramClass.IBN.put("reportObject", "BLOB");
    localStringBuilder.append(" reportObject BLOB");
    localStringBuilder.append(", ");
    paramClass.columns[11] = "postExtraData";
    paramClass.IBN.put("postExtraData", "BLOB");
    localStringBuilder.append(" postExtraData BLOB");
    localStringBuilder.append(", ");
    paramClass.columns[12] = "customData";
    paramClass.IBN.put("customData", "BLOB");
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
      if (eWU != k) {
        break label65;
      }
      this.field_localId = paramCursor.getLong(i);
      this.eWS = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (eQh == k) {
        this.field_id = paramCursor.getLong(i);
      } else if (eFO == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (eGY == k) {
        this.field_username = paramCursor.getString(i);
      } else if (far == k) {
        this.field_sourceFlag = paramCursor.getInt(i);
      } else if (eGZ == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (fas == k) {
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
          ae.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException1.getMessage());
        }
      } else if (eFN == k) {
        this.field_localFlag = paramCursor.getInt(i);
      } else if (fat == k) {
        try
        {
          byte[] arrayOfByte2 = paramCursor.getBlob(i);
          if ((arrayOfByte2 == null) || (arrayOfByte2.length <= 0)) {
            continue;
          }
          this.field_postinfo = ((bwa)new bwa().parseFrom(arrayOfByte2));
        }
        catch (IOException localIOException2)
        {
          ae.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException2.getMessage());
        }
      } else if (fau == k) {
        try
        {
          byte[] arrayOfByte3 = paramCursor.getBlob(i);
          if ((arrayOfByte3 == null) || (arrayOfByte3.length <= 0)) {
            continue;
          }
          this.field_mediaExtList = ((bwf)new bwf().parseFrom(arrayOfByte3));
        }
        catch (IOException localIOException3)
        {
          ae.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException3.getMessage());
        }
      } else if (fav == k) {
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
          ae.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException4.getMessage());
        }
      } else if (faw == k) {
        try
        {
          byte[] arrayOfByte5 = paramCursor.getBlob(i);
          if ((arrayOfByte5 == null) || (arrayOfByte5.length <= 0)) {
            continue;
          }
          this.field_postExtraData = ((aqx)new aqx().parseFrom(arrayOfByte5));
        }
        catch (IOException localIOException5)
        {
          ae.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException5.getMessage());
        }
      } else if (fax == k) {
        try
        {
          byte[] arrayOfByte6 = paramCursor.getBlob(i);
          if ((arrayOfByte6 == null) || (arrayOfByte6.length <= 0)) {
            continue;
          }
          this.field_customData = ((amt)new amt().parseFrom(arrayOfByte6));
        }
        catch (IOException localIOException6)
        {
          ae.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException6.getMessage());
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
    if (this.eWS) {
      localContentValues.put("localId", Long.valueOf(this.field_localId));
    }
    if (this.eQd) {
      localContentValues.put("id", Long.valueOf(this.field_id));
    }
    if (this.eFr) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.eGV) {
      localContentValues.put("username", this.field_username);
    }
    if (this.fak) {
      localContentValues.put("sourceFlag", Integer.valueOf(this.field_sourceFlag));
    }
    if (this.eGW) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if ((this.fal) && (this.field_finderObject != null)) {}
    try
    {
      localContentValues.put("finderObject", this.field_finderObject.toByteArray());
      if (this.eFq) {
        localContentValues.put("localFlag", Integer.valueOf(this.field_localFlag));
      }
      if ((!this.fam) || (this.field_postinfo == null)) {}
    }
    catch (IOException localIOException5)
    {
      try
      {
        localContentValues.put("postinfo", this.field_postinfo.toByteArray());
        if ((!this.fan) || (this.field_mediaExtList == null)) {}
      }
      catch (IOException localIOException5)
      {
        try
        {
          localContentValues.put("mediaExtList", this.field_mediaExtList.toByteArray());
          if ((!this.fao) || (this.field_reportObject == null)) {}
        }
        catch (IOException localIOException5)
        {
          try
          {
            localContentValues.put("reportObject", this.field_reportObject.toByteArray());
            if ((!this.fap) || (this.field_postExtraData == null)) {}
          }
          catch (IOException localIOException5)
          {
            try
            {
              localContentValues.put("postExtraData", this.field_postExtraData.toByteArray());
              if ((!this.faq) || (this.field_customData == null)) {}
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
                  ae.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException1.getMessage());
                  continue;
                  localIOException2 = localIOException2;
                  ae.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException2.getMessage());
                  continue;
                  localIOException3 = localIOException3;
                  ae.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException3.getMessage());
                  continue;
                  localIOException4 = localIOException4;
                  ae.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException4.getMessage());
                }
                localIOException5 = localIOException5;
                ae.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException5.getMessage());
              }
              catch (IOException localIOException6)
              {
                for (;;)
                {
                  ae.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException6.getMessage());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.g.c.cf
 * JD-Core Version:    0.7.0.1
 */
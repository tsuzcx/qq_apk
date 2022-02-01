package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.akk;
import com.tencent.mm.protocal.protobuf.bme;
import com.tencent.mm.protocal.protobuf.bmi;
import com.tencent.mm.protocal.protobuf.dym;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class cb
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS local_index ON FinderFeedItem(localId)", "CREATE INDEX IF NOT EXISTS Finder_Feed_Id ON FinderFeedItem(id)", "CREATE INDEX IF NOT EXISTS Finder_create_time ON FinderFeedItem(createTime)", "CREATE INDEX IF NOT EXISTS Finder_Feed_Local_Flag ON FinderFeedItem(localFlag)" };
  private static final int eBr = "localId".hashCode();
  private static final int eEA = "mediaExtList".hashCode();
  private static final int eEB = "reportObject".hashCode();
  private static final int eEC = "postExtraData".hashCode();
  private static final int eEx;
  private static final int eEy;
  private static final int eEz;
  private static final int ekT;
  private static final int ekU;
  private static final int eme;
  private static final int emf;
  private static final int exb = "id".hashCode();
  private static final int qnA = "customData".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eBp = true;
  private boolean eEr = true;
  private boolean eEs = true;
  private boolean eEt = true;
  private boolean eEu = true;
  private boolean eEv = true;
  private boolean eEw = true;
  private boolean ekw = true;
  private boolean ekx = true;
  private boolean emb = true;
  private boolean emc = true;
  private boolean ewY = true;
  public long field_createTime;
  public dym field_customData;
  public FinderObject field_finderObject;
  public long field_id;
  public int field_localFlag;
  public long field_localId;
  public bmi field_mediaExtList;
  public akk field_postExtraData;
  public bme field_postinfo;
  public FinderFeedReportObject field_reportObject;
  public int field_sourceFlag;
  public long field_updateTime;
  public String field_username;
  private boolean qnz = true;
  
  static
  {
    ekU = "createTime".hashCode();
    eme = "username".hashCode();
    eEx = "sourceFlag".hashCode();
    emf = "updateTime".hashCode();
    eEy = "finderObject".hashCode();
    ekT = "localFlag".hashCode();
    eEz = "postinfo".hashCode();
  }
  
  private final void buildBuff() {}
  
  public static c.a initAutoDBInfo(Class<?> paramClass)
  {
    paramClass = new c.a();
    paramClass.EYt = new Field[13];
    paramClass.columns = new String[14];
    StringBuilder localStringBuilder = new StringBuilder();
    paramClass.columns[0] = "localId";
    paramClass.EYv.put("localId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" localId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    paramClass.EYu = "localId";
    paramClass.columns[1] = "id";
    paramClass.EYv.put("id", "LONG");
    localStringBuilder.append(" id LONG");
    localStringBuilder.append(", ");
    paramClass.columns[2] = "createTime";
    paramClass.EYv.put("createTime", "LONG");
    localStringBuilder.append(" createTime LONG");
    localStringBuilder.append(", ");
    paramClass.columns[3] = "username";
    paramClass.EYv.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    paramClass.columns[4] = "sourceFlag";
    paramClass.EYv.put("sourceFlag", "INTEGER");
    localStringBuilder.append(" sourceFlag INTEGER");
    localStringBuilder.append(", ");
    paramClass.columns[5] = "updateTime";
    paramClass.EYv.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    paramClass.columns[6] = "finderObject";
    paramClass.EYv.put("finderObject", "BLOB");
    localStringBuilder.append(" finderObject BLOB");
    localStringBuilder.append(", ");
    paramClass.columns[7] = "localFlag";
    paramClass.EYv.put("localFlag", "INTEGER");
    localStringBuilder.append(" localFlag INTEGER");
    localStringBuilder.append(", ");
    paramClass.columns[8] = "postinfo";
    paramClass.EYv.put("postinfo", "BLOB");
    localStringBuilder.append(" postinfo BLOB");
    localStringBuilder.append(", ");
    paramClass.columns[9] = "mediaExtList";
    paramClass.EYv.put("mediaExtList", "BLOB");
    localStringBuilder.append(" mediaExtList BLOB");
    localStringBuilder.append(", ");
    paramClass.columns[10] = "reportObject";
    paramClass.EYv.put("reportObject", "BLOB");
    localStringBuilder.append(" reportObject BLOB");
    localStringBuilder.append(", ");
    paramClass.columns[11] = "postExtraData";
    paramClass.EYv.put("postExtraData", "BLOB");
    localStringBuilder.append(" postExtraData BLOB");
    localStringBuilder.append(", ");
    paramClass.columns[12] = "customData";
    paramClass.EYv.put("customData", "BLOB");
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
      if (eBr != k) {
        break label65;
      }
      this.field_localId = paramCursor.getLong(i);
      this.eBp = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (exb == k) {
        this.field_id = paramCursor.getLong(i);
      } else if (ekU == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (eme == k) {
        this.field_username = paramCursor.getString(i);
      } else if (eEx == k) {
        this.field_sourceFlag = paramCursor.getInt(i);
      } else if (emf == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (eEy == k) {
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
      } else if (ekT == k) {
        this.field_localFlag = paramCursor.getInt(i);
      } else if (eEz == k) {
        try
        {
          byte[] arrayOfByte2 = paramCursor.getBlob(i);
          if ((arrayOfByte2 == null) || (arrayOfByte2.length <= 0)) {
            continue;
          }
          this.field_postinfo = ((bme)new bme().parseFrom(arrayOfByte2));
        }
        catch (IOException localIOException2)
        {
          ad.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException2.getMessage());
        }
      } else if (eEA == k) {
        try
        {
          byte[] arrayOfByte3 = paramCursor.getBlob(i);
          if ((arrayOfByte3 == null) || (arrayOfByte3.length <= 0)) {
            continue;
          }
          this.field_mediaExtList = ((bmi)new bmi().parseFrom(arrayOfByte3));
        }
        catch (IOException localIOException3)
        {
          ad.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException3.getMessage());
        }
      } else if (eEB == k) {
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
      } else if (eEC == k) {
        try
        {
          byte[] arrayOfByte5 = paramCursor.getBlob(i);
          if ((arrayOfByte5 == null) || (arrayOfByte5.length <= 0)) {
            continue;
          }
          this.field_postExtraData = ((akk)new akk().parseFrom(arrayOfByte5));
        }
        catch (IOException localIOException5)
        {
          ad.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException5.getMessage());
        }
      } else if (qnA == k) {
        try
        {
          byte[] arrayOfByte6 = paramCursor.getBlob(i);
          if ((arrayOfByte6 == null) || (arrayOfByte6.length <= 0)) {
            continue;
          }
          this.field_customData = ((dym)new dym().parseFrom(arrayOfByte6));
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
    if (this.eBp) {
      localContentValues.put("localId", Long.valueOf(this.field_localId));
    }
    if (this.ewY) {
      localContentValues.put("id", Long.valueOf(this.field_id));
    }
    if (this.ekx) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.emb) {
      localContentValues.put("username", this.field_username);
    }
    if (this.eEr) {
      localContentValues.put("sourceFlag", Integer.valueOf(this.field_sourceFlag));
    }
    if (this.emc) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if ((this.eEs) && (this.field_finderObject != null)) {}
    try
    {
      localContentValues.put("finderObject", this.field_finderObject.toByteArray());
      if (this.ekw) {
        localContentValues.put("localFlag", Integer.valueOf(this.field_localFlag));
      }
      if ((!this.eEt) || (this.field_postinfo == null)) {}
    }
    catch (IOException localIOException5)
    {
      try
      {
        localContentValues.put("postinfo", this.field_postinfo.toByteArray());
        if ((!this.eEu) || (this.field_mediaExtList == null)) {}
      }
      catch (IOException localIOException5)
      {
        try
        {
          localContentValues.put("mediaExtList", this.field_mediaExtList.toByteArray());
          if ((!this.eEv) || (this.field_reportObject == null)) {}
        }
        catch (IOException localIOException5)
        {
          try
          {
            localContentValues.put("reportObject", this.field_reportObject.toByteArray());
            if ((!this.eEw) || (this.field_postExtraData == null)) {}
          }
          catch (IOException localIOException5)
          {
            try
            {
              localContentValues.put("postExtraData", this.field_postExtraData.toByteArray());
              if ((!this.qnz) || (this.field_customData == null)) {}
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.g.c.cb
 * JD-Core Version:    0.7.0.1
 */
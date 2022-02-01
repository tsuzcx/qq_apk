package com.tencent.mm.g.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.ajm;
import com.tencent.mm.protocal.protobuf.amw;
import com.tencent.mm.protocal.protobuf.bqt;
import com.tencent.mm.protocal.protobuf.bqy;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ac;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class cd
  extends c
{
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS local_index ON FinderFeedItem(localId)", "CREATE INDEX IF NOT EXISTS Finder_Feed_Id ON FinderFeedItem(id)", "CREATE INDEX IF NOT EXISTS Finder_create_time ON FinderFeedItem(createTime)", "CREATE INDEX IF NOT EXISTS Finder_Feed_Local_Flag ON FinderFeedItem(localFlag)" };
  private static final int eDL = "localId".hashCode();
  private static final int eGW;
  private static final int eGX;
  private static final int eGY = "postinfo".hashCode();
  private static final int eGZ = "mediaExtList".hashCode();
  private static final int eHa = "reportObject".hashCode();
  private static final int eHb = "postExtraData".hashCode();
  private static final int eHc = "customData".hashCode();
  private static final int emX;
  private static final int emY;
  private static final int eok;
  private static final int eol;
  private static final int ewX = "id".hashCode();
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private boolean eDJ = true;
  private boolean eGP = true;
  private boolean eGQ = true;
  private boolean eGR = true;
  private boolean eGS = true;
  private boolean eGT = true;
  private boolean eGU = true;
  private boolean eGV = true;
  private boolean emA = true;
  private boolean emB = true;
  private boolean eoh = true;
  private boolean eoi = true;
  private boolean ewT = true;
  public long field_createTime;
  public ajm field_customData;
  public FinderObject field_finderObject;
  public long field_id;
  public int field_localFlag;
  public long field_localId;
  public bqy field_mediaExtList;
  public amw field_postExtraData;
  public bqt field_postinfo;
  public FinderFeedReportObject field_reportObject;
  public int field_sourceFlag;
  public long field_updateTime;
  public String field_username;
  
  static
  {
    emY = "createTime".hashCode();
    eok = "username".hashCode();
    eGW = "sourceFlag".hashCode();
    eol = "updateTime".hashCode();
    eGX = "finderObject".hashCode();
    emX = "localFlag".hashCode();
  }
  
  private final void buildBuff() {}
  
  public static c.a initAutoDBInfo(Class<?> paramClass)
  {
    paramClass = new c.a();
    paramClass.GvF = new Field[13];
    paramClass.columns = new String[14];
    StringBuilder localStringBuilder = new StringBuilder();
    paramClass.columns[0] = "localId";
    paramClass.GvH.put("localId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" localId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    paramClass.GvG = "localId";
    paramClass.columns[1] = "id";
    paramClass.GvH.put("id", "LONG");
    localStringBuilder.append(" id LONG");
    localStringBuilder.append(", ");
    paramClass.columns[2] = "createTime";
    paramClass.GvH.put("createTime", "LONG");
    localStringBuilder.append(" createTime LONG");
    localStringBuilder.append(", ");
    paramClass.columns[3] = "username";
    paramClass.GvH.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    paramClass.columns[4] = "sourceFlag";
    paramClass.GvH.put("sourceFlag", "INTEGER");
    localStringBuilder.append(" sourceFlag INTEGER");
    localStringBuilder.append(", ");
    paramClass.columns[5] = "updateTime";
    paramClass.GvH.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    paramClass.columns[6] = "finderObject";
    paramClass.GvH.put("finderObject", "BLOB");
    localStringBuilder.append(" finderObject BLOB");
    localStringBuilder.append(", ");
    paramClass.columns[7] = "localFlag";
    paramClass.GvH.put("localFlag", "INTEGER");
    localStringBuilder.append(" localFlag INTEGER");
    localStringBuilder.append(", ");
    paramClass.columns[8] = "postinfo";
    paramClass.GvH.put("postinfo", "BLOB");
    localStringBuilder.append(" postinfo BLOB");
    localStringBuilder.append(", ");
    paramClass.columns[9] = "mediaExtList";
    paramClass.GvH.put("mediaExtList", "BLOB");
    localStringBuilder.append(" mediaExtList BLOB");
    localStringBuilder.append(", ");
    paramClass.columns[10] = "reportObject";
    paramClass.GvH.put("reportObject", "BLOB");
    localStringBuilder.append(" reportObject BLOB");
    localStringBuilder.append(", ");
    paramClass.columns[11] = "postExtraData";
    paramClass.GvH.put("postExtraData", "BLOB");
    localStringBuilder.append(" postExtraData BLOB");
    localStringBuilder.append(", ");
    paramClass.columns[12] = "customData";
    paramClass.GvH.put("customData", "BLOB");
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
      if (eDL != k) {
        break label65;
      }
      this.field_localId = paramCursor.getLong(i);
      this.eDJ = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (ewX == k) {
        this.field_id = paramCursor.getLong(i);
      } else if (emY == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (eok == k) {
        this.field_username = paramCursor.getString(i);
      } else if (eGW == k) {
        this.field_sourceFlag = paramCursor.getInt(i);
      } else if (eol == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (eGX == k) {
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
          ac.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException1.getMessage());
        }
      } else if (emX == k) {
        this.field_localFlag = paramCursor.getInt(i);
      } else if (eGY == k) {
        try
        {
          byte[] arrayOfByte2 = paramCursor.getBlob(i);
          if ((arrayOfByte2 == null) || (arrayOfByte2.length <= 0)) {
            continue;
          }
          this.field_postinfo = ((bqt)new bqt().parseFrom(arrayOfByte2));
        }
        catch (IOException localIOException2)
        {
          ac.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException2.getMessage());
        }
      } else if (eGZ == k) {
        try
        {
          byte[] arrayOfByte3 = paramCursor.getBlob(i);
          if ((arrayOfByte3 == null) || (arrayOfByte3.length <= 0)) {
            continue;
          }
          this.field_mediaExtList = ((bqy)new bqy().parseFrom(arrayOfByte3));
        }
        catch (IOException localIOException3)
        {
          ac.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException3.getMessage());
        }
      } else if (eHa == k) {
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
          ac.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException4.getMessage());
        }
      } else if (eHb == k) {
        try
        {
          byte[] arrayOfByte5 = paramCursor.getBlob(i);
          if ((arrayOfByte5 == null) || (arrayOfByte5.length <= 0)) {
            continue;
          }
          this.field_postExtraData = ((amw)new amw().parseFrom(arrayOfByte5));
        }
        catch (IOException localIOException5)
        {
          ac.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException5.getMessage());
        }
      } else if (eHc == k) {
        try
        {
          byte[] arrayOfByte6 = paramCursor.getBlob(i);
          if ((arrayOfByte6 == null) || (arrayOfByte6.length <= 0)) {
            continue;
          }
          this.field_customData = ((ajm)new ajm().parseFrom(arrayOfByte6));
        }
        catch (IOException localIOException6)
        {
          ac.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException6.getMessage());
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
    if (this.eDJ) {
      localContentValues.put("localId", Long.valueOf(this.field_localId));
    }
    if (this.ewT) {
      localContentValues.put("id", Long.valueOf(this.field_id));
    }
    if (this.emB) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.eoh) {
      localContentValues.put("username", this.field_username);
    }
    if (this.eGP) {
      localContentValues.put("sourceFlag", Integer.valueOf(this.field_sourceFlag));
    }
    if (this.eoi) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if ((this.eGQ) && (this.field_finderObject != null)) {}
    try
    {
      localContentValues.put("finderObject", this.field_finderObject.toByteArray());
      if (this.emA) {
        localContentValues.put("localFlag", Integer.valueOf(this.field_localFlag));
      }
      if ((!this.eGR) || (this.field_postinfo == null)) {}
    }
    catch (IOException localIOException5)
    {
      try
      {
        localContentValues.put("postinfo", this.field_postinfo.toByteArray());
        if ((!this.eGS) || (this.field_mediaExtList == null)) {}
      }
      catch (IOException localIOException5)
      {
        try
        {
          localContentValues.put("mediaExtList", this.field_mediaExtList.toByteArray());
          if ((!this.eGT) || (this.field_reportObject == null)) {}
        }
        catch (IOException localIOException5)
        {
          try
          {
            localContentValues.put("reportObject", this.field_reportObject.toByteArray());
            if ((!this.eGU) || (this.field_postExtraData == null)) {}
          }
          catch (IOException localIOException5)
          {
            try
            {
              localContentValues.put("postExtraData", this.field_postExtraData.toByteArray());
              if ((!this.eGV) || (this.field_customData == null)) {}
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
                  ac.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException1.getMessage());
                  continue;
                  localIOException2 = localIOException2;
                  ac.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException2.getMessage());
                  continue;
                  localIOException3 = localIOException3;
                  ac.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException3.getMessage());
                  continue;
                  localIOException4 = localIOException4;
                  ac.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException4.getMessage());
                }
                localIOException5 = localIOException5;
                ac.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException5.getMessage());
              }
              catch (IOException localIOException6)
              {
                for (;;)
                {
                  ac.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException6.getMessage());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.g.c.cd
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.f.c;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.FinderFeedReportObject;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.arw;
import com.tencent.mm.protocal.protobuf.bgw;
import com.tencent.mm.protocal.protobuf.csc;
import com.tencent.mm.protocal.protobuf.csh;
import com.tencent.mm.protocal.protobuf.cso;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class ci
  extends IAutoDBItem
{
  public static final String COL_CLIPLIST = "clipList";
  public static final String COL_CREATETIME = "createTime";
  public static final String COL_CUSTOMDATA = "customData";
  public static final String COL_FINDEROBJECT = "finderObject";
  public static final String COL_HALFMEDIAEXTLIST = "halfMediaExtList";
  public static final String COL_ID = "id";
  public static final String COL_LOCALFLAG = "localFlag";
  public static final String COL_LOCALID = "localId";
  public static final String COL_LONGVIDEOMEDIAEXTLIST = "longVideoMediaExtList";
  public static final String COL_MEDIAEXTLIST = "mediaExtList";
  public static final String COL_POSTEXTRADATA = "postExtraData";
  public static final String COL_POSTINFO = "postinfo";
  public static final String COL_REPORTOBJECT = "reportObject";
  public static final String COL_SOURCEFLAG = "sourceFlag";
  public static final String COL_UPDATETIME = "updateTime";
  public static final String COL_USERNAME = "username";
  public static final Column C_CLIPLIST;
  public static final Column C_CREATETIME;
  public static final Column C_CUSTOMDATA;
  public static final Column C_FINDEROBJECT;
  public static final Column C_HALFMEDIAEXTLIST;
  public static final Column C_ID;
  public static final Column C_LOCALFLAG;
  public static final Column C_LOCALID;
  public static final Column C_LONGVIDEOMEDIAEXTLIST;
  public static final Column C_MEDIAEXTLIST;
  public static final Column C_POSTEXTRADATA;
  public static final Column C_POSTINFO;
  public static final Column C_REPORTOBJECT;
  public static final Column C_ROWID;
  public static final Column C_SOURCEFLAG;
  public static final Column C_UPDATETIME;
  public static final Column C_USERNAME;
  public static final String[] INDEX_CREATE = { "CREATE INDEX IF NOT EXISTS FinderFeedItem_local_index ON FinderFeedItem(localId)", "CREATE INDEX IF NOT EXISTS FinderFeedItem_Id ON FinderFeedItem(id)", "CREATE INDEX IF NOT EXISTS FinderFeedItem_create_time ON FinderFeedItem(createTime)", "CREATE INDEX IF NOT EXISTS FinderFeedItem__Local_Flag ON FinderFeedItem(localFlag)" };
  public static final SingleTable TABLE = new SingleTable("FinderFeedItem");
  public static final String TABLE_NAME = "FinderFeedItem";
  private static final String TAG = "MicroMsg.SDK.BaseFinderFeedItem";
  private static final int clipList_HASHCODE = "clipList".hashCode();
  private static final int createTime_HASHCODE;
  private static final int customData_HASHCODE;
  private static final int finderObject_HASHCODE;
  private static final int halfMediaExtList_HASHCODE;
  private static final int id_HASHCODE;
  private static final int localFlag_HASHCODE;
  private static final int localId_HASHCODE;
  private static final int longVideoMediaExtList_HASHCODE;
  private static final int mediaExtList_HASHCODE;
  private static final int postExtraData_HASHCODE;
  private static final int postinfo_HASHCODE;
  private static final int reportObject_HASHCODE;
  private static final int rowid_HASHCODE = "rowid".hashCode();
  private static final int sourceFlag_HASHCODE;
  private static final int updateTime_HASHCODE;
  private static final int username_HASHCODE;
  private boolean __hadSetclipList = true;
  private boolean __hadSetcreateTime = true;
  private boolean __hadSetcustomData = true;
  private boolean __hadSetfinderObject = true;
  private boolean __hadSethalfMediaExtList = true;
  private boolean __hadSetid = true;
  private boolean __hadSetlocalFlag = true;
  private boolean __hadSetlocalId = true;
  private boolean __hadSetlongVideoMediaExtList = true;
  private boolean __hadSetmediaExtList = true;
  private boolean __hadSetpostExtraData = true;
  private boolean __hadSetpostinfo = true;
  private boolean __hadSetreportObject = true;
  private boolean __hadSetsourceFlag = true;
  private boolean __hadSetupdateTime = true;
  private boolean __hadSetusername = true;
  public csc field_clipList;
  public long field_createTime;
  public arw field_customData;
  public FinderObject field_finderObject;
  public cso field_halfMediaExtList;
  public long field_id;
  public int field_localFlag;
  public long field_localId;
  public cso field_longVideoMediaExtList;
  public cso field_mediaExtList;
  public bgw field_postExtraData;
  public csh field_postinfo;
  public FinderFeedReportObject field_reportObject;
  public int field_sourceFlag;
  public long field_updateTime;
  public String field_username;
  
  static
  {
    C_ROWID = new Column("rowid", "long", "FinderFeedItem", "");
    C_LOCALID = new Column("localid", "long", "FinderFeedItem", "");
    C_ID = new Column("id", "long", "FinderFeedItem", "");
    C_CREATETIME = new Column("createtime", "long", "FinderFeedItem", "");
    C_USERNAME = new Column("username", "string", "FinderFeedItem", "");
    C_SOURCEFLAG = new Column("sourceflag", "int", "FinderFeedItem", "");
    C_UPDATETIME = new Column("updatetime", "long", "FinderFeedItem", "");
    C_FINDEROBJECT = new Column("finderobject", "proto", "FinderFeedItem", "com.tencent.mm.protocal.protobuf.FinderObject");
    C_LOCALFLAG = new Column("localflag", "int", "FinderFeedItem", "");
    C_POSTINFO = new Column("postinfo", "proto", "FinderFeedItem", "com.tencent.mm.protocal.protobuf.LocalFinderPostInfo");
    C_MEDIAEXTLIST = new Column("mediaextlist", "proto", "FinderFeedItem", "com.tencent.mm.protocal.protobuf.LocalMediaListExt");
    C_REPORTOBJECT = new Column("reportobject", "proto", "FinderFeedItem", "com.tencent.mm.protocal.protobuf.FinderFeedReportObject");
    C_POSTEXTRADATA = new Column("postextradata", "proto", "FinderFeedItem", "com.tencent.mm.protocal.protobuf.FinderPostExtra");
    C_CUSTOMDATA = new Column("customdata", "proto", "FinderFeedItem", "com.tencent.mm.protocal.protobuf.FinderCustomFeedData");
    C_LONGVIDEOMEDIAEXTLIST = new Column("longvideomediaextlist", "proto", "FinderFeedItem", "com.tencent.mm.protocal.protobuf.LocalMediaListExt");
    C_HALFMEDIAEXTLIST = new Column("halfmediaextlist", "proto", "FinderFeedItem", "com.tencent.mm.protocal.protobuf.LocalMediaListExt");
    C_CLIPLIST = new Column("cliplist", "proto", "FinderFeedItem", "com.tencent.mm.protocal.protobuf.LocalClipListExt");
    localId_HASHCODE = "localId".hashCode();
    id_HASHCODE = "id".hashCode();
    createTime_HASHCODE = "createTime".hashCode();
    username_HASHCODE = "username".hashCode();
    sourceFlag_HASHCODE = "sourceFlag".hashCode();
    updateTime_HASHCODE = "updateTime".hashCode();
    finderObject_HASHCODE = "finderObject".hashCode();
    localFlag_HASHCODE = "localFlag".hashCode();
    postinfo_HASHCODE = "postinfo".hashCode();
    mediaExtList_HASHCODE = "mediaExtList".hashCode();
    reportObject_HASHCODE = "reportObject".hashCode();
    postExtraData_HASHCODE = "postExtraData".hashCode();
    customData_HASHCODE = "customData".hashCode();
    longVideoMediaExtList_HASHCODE = "longVideoMediaExtList".hashCode();
    halfMediaExtList_HASHCODE = "halfMediaExtList".hashCode();
  }
  
  private final void buildBuff() {}
  
  public static IAutoDBItem.MAutoDBInfo initAutoDBInfo(Class<?> paramClass)
  {
    paramClass = new IAutoDBItem.MAutoDBInfo();
    paramClass.fields = new Field[16];
    paramClass.columns = new String[17];
    StringBuilder localStringBuilder = new StringBuilder();
    paramClass.columns[0] = "localId";
    paramClass.colsMap.put("localId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" localId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    paramClass.primaryKey = "localId";
    paramClass.columns[1] = "id";
    paramClass.colsMap.put("id", "LONG");
    localStringBuilder.append(" id LONG");
    localStringBuilder.append(", ");
    paramClass.columns[2] = "createTime";
    paramClass.colsMap.put("createTime", "LONG");
    localStringBuilder.append(" createTime LONG");
    localStringBuilder.append(", ");
    paramClass.columns[3] = "username";
    paramClass.colsMap.put("username", "TEXT");
    localStringBuilder.append(" username TEXT");
    localStringBuilder.append(", ");
    paramClass.columns[4] = "sourceFlag";
    paramClass.colsMap.put("sourceFlag", "INTEGER");
    localStringBuilder.append(" sourceFlag INTEGER");
    localStringBuilder.append(", ");
    paramClass.columns[5] = "updateTime";
    paramClass.colsMap.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    paramClass.columns[6] = "finderObject";
    paramClass.colsMap.put("finderObject", "BLOB");
    localStringBuilder.append(" finderObject BLOB");
    localStringBuilder.append(", ");
    paramClass.columns[7] = "localFlag";
    paramClass.colsMap.put("localFlag", "INTEGER");
    localStringBuilder.append(" localFlag INTEGER");
    localStringBuilder.append(", ");
    paramClass.columns[8] = "postinfo";
    paramClass.colsMap.put("postinfo", "BLOB");
    localStringBuilder.append(" postinfo BLOB");
    localStringBuilder.append(", ");
    paramClass.columns[9] = "mediaExtList";
    paramClass.colsMap.put("mediaExtList", "BLOB");
    localStringBuilder.append(" mediaExtList BLOB");
    localStringBuilder.append(", ");
    paramClass.columns[10] = "reportObject";
    paramClass.colsMap.put("reportObject", "BLOB");
    localStringBuilder.append(" reportObject BLOB");
    localStringBuilder.append(", ");
    paramClass.columns[11] = "postExtraData";
    paramClass.colsMap.put("postExtraData", "BLOB");
    localStringBuilder.append(" postExtraData BLOB");
    localStringBuilder.append(", ");
    paramClass.columns[12] = "customData";
    paramClass.colsMap.put("customData", "BLOB");
    localStringBuilder.append(" customData BLOB");
    localStringBuilder.append(", ");
    paramClass.columns[13] = "longVideoMediaExtList";
    paramClass.colsMap.put("longVideoMediaExtList", "BLOB");
    localStringBuilder.append(" longVideoMediaExtList BLOB");
    localStringBuilder.append(", ");
    paramClass.columns[14] = "halfMediaExtList";
    paramClass.colsMap.put("halfMediaExtList", "BLOB");
    localStringBuilder.append(" halfMediaExtList BLOB");
    localStringBuilder.append(", ");
    paramClass.columns[15] = "clipList";
    paramClass.colsMap.put("clipList", "BLOB");
    localStringBuilder.append(" clipList BLOB");
    paramClass.columns[16] = "rowid";
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
      if (localId_HASHCODE != k) {
        break label65;
      }
      this.field_localId = paramCursor.getLong(i);
      this.__hadSetlocalId = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (id_HASHCODE == k) {
        this.field_id = paramCursor.getLong(i);
      } else if (createTime_HASHCODE == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (username_HASHCODE == k) {
        this.field_username = paramCursor.getString(i);
      } else if (sourceFlag_HASHCODE == k) {
        this.field_sourceFlag = paramCursor.getInt(i);
      } else if (updateTime_HASHCODE == k) {
        this.field_updateTime = paramCursor.getLong(i);
      } else if (finderObject_HASHCODE == k) {
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
          Log.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException1.getMessage());
        }
      } else if (localFlag_HASHCODE == k) {
        this.field_localFlag = paramCursor.getInt(i);
      } else if (postinfo_HASHCODE == k) {
        try
        {
          byte[] arrayOfByte2 = paramCursor.getBlob(i);
          if ((arrayOfByte2 == null) || (arrayOfByte2.length <= 0)) {
            continue;
          }
          this.field_postinfo = ((csh)new csh().parseFrom(arrayOfByte2));
        }
        catch (IOException localIOException2)
        {
          Log.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException2.getMessage());
        }
      } else if (mediaExtList_HASHCODE == k) {
        try
        {
          byte[] arrayOfByte3 = paramCursor.getBlob(i);
          if ((arrayOfByte3 == null) || (arrayOfByte3.length <= 0)) {
            continue;
          }
          this.field_mediaExtList = ((cso)new cso().parseFrom(arrayOfByte3));
        }
        catch (IOException localIOException3)
        {
          Log.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException3.getMessage());
        }
      } else if (reportObject_HASHCODE == k) {
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
          Log.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException4.getMessage());
        }
      } else if (postExtraData_HASHCODE == k) {
        try
        {
          byte[] arrayOfByte5 = paramCursor.getBlob(i);
          if ((arrayOfByte5 == null) || (arrayOfByte5.length <= 0)) {
            continue;
          }
          this.field_postExtraData = ((bgw)new bgw().parseFrom(arrayOfByte5));
        }
        catch (IOException localIOException5)
        {
          Log.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException5.getMessage());
        }
      } else if (customData_HASHCODE == k) {
        try
        {
          byte[] arrayOfByte6 = paramCursor.getBlob(i);
          if ((arrayOfByte6 == null) || (arrayOfByte6.length <= 0)) {
            continue;
          }
          this.field_customData = ((arw)new arw().parseFrom(arrayOfByte6));
        }
        catch (IOException localIOException6)
        {
          Log.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException6.getMessage());
        }
      } else if (longVideoMediaExtList_HASHCODE == k) {
        try
        {
          byte[] arrayOfByte7 = paramCursor.getBlob(i);
          if ((arrayOfByte7 == null) || (arrayOfByte7.length <= 0)) {
            continue;
          }
          this.field_longVideoMediaExtList = ((cso)new cso().parseFrom(arrayOfByte7));
        }
        catch (IOException localIOException7)
        {
          Log.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException7.getMessage());
        }
      } else if (halfMediaExtList_HASHCODE == k) {
        try
        {
          byte[] arrayOfByte8 = paramCursor.getBlob(i);
          if ((arrayOfByte8 == null) || (arrayOfByte8.length <= 0)) {
            continue;
          }
          this.field_halfMediaExtList = ((cso)new cso().parseFrom(arrayOfByte8));
        }
        catch (IOException localIOException8)
        {
          Log.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException8.getMessage());
        }
      } else if (clipList_HASHCODE == k) {
        try
        {
          byte[] arrayOfByte9 = paramCursor.getBlob(i);
          if ((arrayOfByte9 == null) || (arrayOfByte9.length <= 0)) {
            continue;
          }
          this.field_clipList = ((csc)new csc().parseFrom(arrayOfByte9));
        }
        catch (IOException localIOException9)
        {
          Log.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException9.getMessage());
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
    if (this.__hadSetlocalId) {
      localContentValues.put("localId", Long.valueOf(this.field_localId));
    }
    if (this.__hadSetid) {
      localContentValues.put("id", Long.valueOf(this.field_id));
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.__hadSetusername) {
      localContentValues.put("username", this.field_username);
    }
    if (this.__hadSetsourceFlag) {
      localContentValues.put("sourceFlag", Integer.valueOf(this.field_sourceFlag));
    }
    if (this.__hadSetupdateTime) {
      localContentValues.put("updateTime", Long.valueOf(this.field_updateTime));
    }
    if ((this.__hadSetfinderObject) && (this.field_finderObject != null)) {}
    try
    {
      localContentValues.put("finderObject", this.field_finderObject.toByteArray());
      if (this.__hadSetlocalFlag) {
        localContentValues.put("localFlag", Integer.valueOf(this.field_localFlag));
      }
      if ((!this.__hadSetpostinfo) || (this.field_postinfo == null)) {}
    }
    catch (IOException localIOException8)
    {
      try
      {
        localContentValues.put("postinfo", this.field_postinfo.toByteArray());
        if ((!this.__hadSetmediaExtList) || (this.field_mediaExtList == null)) {}
      }
      catch (IOException localIOException8)
      {
        try
        {
          localContentValues.put("mediaExtList", this.field_mediaExtList.toByteArray());
          if ((!this.__hadSetreportObject) || (this.field_reportObject == null)) {}
        }
        catch (IOException localIOException8)
        {
          try
          {
            localContentValues.put("reportObject", this.field_reportObject.toByteArray());
            if ((!this.__hadSetpostExtraData) || (this.field_postExtraData == null)) {}
          }
          catch (IOException localIOException8)
          {
            try
            {
              localContentValues.put("postExtraData", this.field_postExtraData.toByteArray());
              if ((!this.__hadSetcustomData) || (this.field_customData == null)) {}
            }
            catch (IOException localIOException8)
            {
              try
              {
                localContentValues.put("customData", this.field_customData.toByteArray());
                if ((!this.__hadSetlongVideoMediaExtList) || (this.field_longVideoMediaExtList == null)) {}
              }
              catch (IOException localIOException8)
              {
                try
                {
                  localContentValues.put("longVideoMediaExtList", this.field_longVideoMediaExtList.toByteArray());
                  if ((!this.__hadSethalfMediaExtList) || (this.field_halfMediaExtList == null)) {}
                }
                catch (IOException localIOException8)
                {
                  try
                  {
                    localContentValues.put("halfMediaExtList", this.field_halfMediaExtList.toByteArray());
                    if ((!this.__hadSetclipList) || (this.field_clipList == null)) {}
                  }
                  catch (IOException localIOException8)
                  {
                    try
                    {
                      for (;;)
                      {
                        localContentValues.put("clipList", this.field_clipList.toByteArray());
                        if (this.systemRowid > 0L) {
                          localContentValues.put("rowid", Long.valueOf(this.systemRowid));
                        }
                        return localContentValues;
                        localIOException1 = localIOException1;
                        Log.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException1.getMessage());
                        continue;
                        localIOException2 = localIOException2;
                        Log.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException2.getMessage());
                        continue;
                        localIOException3 = localIOException3;
                        Log.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException3.getMessage());
                        continue;
                        localIOException4 = localIOException4;
                        Log.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException4.getMessage());
                        continue;
                        localIOException5 = localIOException5;
                        Log.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException5.getMessage());
                        continue;
                        localIOException6 = localIOException6;
                        Log.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException6.getMessage());
                        continue;
                        localIOException7 = localIOException7;
                        Log.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException7.getMessage());
                      }
                      localIOException8 = localIOException8;
                      Log.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException8.getMessage());
                    }
                    catch (IOException localIOException9)
                    {
                      for (;;)
                      {
                        Log.e("MicroMsg.SDK.BaseFinderFeedItem", localIOException9.getMessage());
                      }
                    }
                  }
                }
              }
            }
          }
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
    return "FinderFeedItem";
  }
  
  public void reset() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.f.c.ci
 * JD-Core Version:    0.7.0.1
 */
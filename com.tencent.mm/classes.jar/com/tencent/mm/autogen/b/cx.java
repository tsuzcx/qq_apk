package com.tencent.mm.autogen.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.observer.StorageObserverOwner;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class cx
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column LOCALID;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("FinderLocalOperation");
  private static final int jJD;
  public static final Column jJz;
  public static final Column kaX;
  private static final int kbH;
  public static final Column ksT;
  public static final Column ksU;
  public static final Column ksV;
  private static final int ksZ;
  private static final int kta;
  private static final int ktb;
  private static final int localId_HASHCODE;
  private static final StorageObserverOwner<cx> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private boolean __hadSetlocalId = true;
  public bui field_contextObj;
  public boolean field_isPrivate;
  public int field_likeAction;
  public long field_localId;
  public int field_scene;
  public boolean field_showTips;
  private boolean jJB = true;
  private boolean kbp = true;
  private boolean ksW = true;
  private boolean ksX = true;
  private boolean ksY = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    LOCALID = new Column("localId", "long", TABLE.getName(), "");
    ksT = new Column("likeAction", "int", TABLE.getName(), "");
    jJz = new Column("scene", "int", TABLE.getName(), "");
    kaX = new Column("showTips", "boolean", TABLE.getName(), "");
    ksU = new Column("contextObj", "proto", TABLE.getName(), "com.tencent.mm.protocal.protobuf.FinderReportContextObj");
    ksV = new Column("isPrivate", "boolean", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    localId_HASHCODE = "localId".hashCode();
    ksZ = "likeAction".hashCode();
    jJD = "scene".hashCode();
    kbH = "showTips".hashCode();
    kta = "contextObj".hashCode();
    ktb = "isPrivate".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[6];
    localMAutoDBInfo.columns = new String[7];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "localId";
    localMAutoDBInfo.colsMap.put("localId", "LONG PRIMARY KEY ");
    localStringBuilder.append(" localId LONG PRIMARY KEY ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "localId";
    localMAutoDBInfo.columns[1] = "likeAction";
    localMAutoDBInfo.colsMap.put("likeAction", "INTEGER");
    localStringBuilder.append(" likeAction INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "scene";
    localMAutoDBInfo.colsMap.put("scene", "INTEGER");
    localStringBuilder.append(" scene INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "showTips";
    localMAutoDBInfo.colsMap.put("showTips", "INTEGER");
    localStringBuilder.append(" showTips INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "contextObj";
    localMAutoDBInfo.colsMap.put("contextObj", "BLOB");
    localStringBuilder.append(" contextObj BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "isPrivate";
    localMAutoDBInfo.colsMap.put("isPrivate", "INTEGER");
    localStringBuilder.append(" isPrivate INTEGER");
    localMAutoDBInfo.columns[6] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    boolean bool2 = false;
    if (paramContentValues.containsKey("localId"))
    {
      this.field_localId = paramContentValues.getAsLong("localId").longValue();
      if (paramBoolean) {
        this.__hadSetlocalId = true;
      }
    }
    if (paramContentValues.containsKey("likeAction"))
    {
      this.field_likeAction = paramContentValues.getAsInteger("likeAction").intValue();
      if (paramBoolean) {
        this.ksW = true;
      }
    }
    if (paramContentValues.containsKey("scene"))
    {
      this.field_scene = paramContentValues.getAsInteger("scene").intValue();
      if (paramBoolean) {
        this.jJB = true;
      }
    }
    if (paramContentValues.containsKey("showTips")) {
      if (paramContentValues.getAsInteger("showTips").intValue() == 0) {
        break label252;
      }
    }
    label252:
    for (boolean bool1 = true;; bool1 = false)
    {
      this.field_showTips = bool1;
      if (paramBoolean) {
        this.kbp = true;
      }
      if (paramContentValues.containsKey("contextObj")) {}
      try
      {
        byte[] arrayOfByte = paramContentValues.getAsByteArray("contextObj");
        if ((arrayOfByte != null) && (arrayOfByte.length > 0))
        {
          this.field_contextObj = ((bui)new bui().parseFrom(arrayOfByte));
          if (paramBoolean) {
            this.ksX = true;
          }
        }
      }
      catch (IOException localIOException)
      {
        for (;;)
        {
          Log.e("MicroMsg.SDK.BaseFinderLocalOperation", localIOException.getMessage());
        }
      }
      if (paramContentValues.containsKey("isPrivate"))
      {
        bool1 = bool2;
        if (paramContentValues.getAsInteger("isPrivate").intValue() != 0) {
          bool1 = true;
        }
        this.field_isPrivate = bool1;
        if (paramBoolean) {
          this.ksY = true;
        }
      }
      if (paramContentValues.containsKey("rowid")) {
        this.systemRowid = paramContentValues.getAsLong("rowid").longValue();
      }
      return;
    }
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
      if (ksZ == k)
      {
        this.field_likeAction = paramCursor.getInt(i);
      }
      else if (jJD == k)
      {
        this.field_scene = paramCursor.getInt(i);
      }
      else
      {
        boolean bool;
        if (kbH == k)
        {
          if (paramCursor.getInt(i) != 0) {}
          for (bool = true;; bool = false)
          {
            this.field_showTips = bool;
            break;
          }
        }
        if (kta == k)
        {
          try
          {
            byte[] arrayOfByte = paramCursor.getBlob(i);
            if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
              continue;
            }
            this.field_contextObj = ((bui)new bui().parseFrom(arrayOfByte));
          }
          catch (IOException localIOException)
          {
            Log.e("MicroMsg.SDK.BaseFinderLocalOperation", localIOException.getMessage());
          }
        }
        else
        {
          if (ktb == k)
          {
            if (paramCursor.getInt(i) != 0) {}
            for (bool = true;; bool = false)
            {
              this.field_isPrivate = bool;
              break;
            }
          }
          if (rowid_HASHCODE == k) {
            this.systemRowid = paramCursor.getLong(i);
          }
        }
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.__hadSetlocalId) {
      localContentValues.put("localId", Long.valueOf(this.field_localId));
    }
    if (this.ksW) {
      localContentValues.put("likeAction", Integer.valueOf(this.field_likeAction));
    }
    if (this.jJB) {
      localContentValues.put("scene", Integer.valueOf(this.field_scene));
    }
    if (this.kbp) {
      localContentValues.put("showTips", Boolean.valueOf(this.field_showTips));
    }
    if ((this.ksX) && (this.field_contextObj != null)) {}
    try
    {
      localContentValues.put("contextObj", this.field_contextObj.toByteArray());
      if (this.ksY) {
        localContentValues.put("isPrivate", Boolean.valueOf(this.field_isPrivate));
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
        Log.e("MicroMsg.SDK.BaseFinderLocalOperation", localIOException.getMessage());
      }
    }
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return DB_INFO;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public StorageObserverOwner<? extends cx> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return Long.valueOf(this.field_localId);
  }
  
  public SingleTable getTable()
  {
    return TABLE;
  }
  
  public String getTableName()
  {
    return TABLE.getName();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.autogen.b.cx
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.autogen.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.observer.StorageObserverOwner;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class fl
  extends IAutoDBItem
{
  public static final Column CREATETIME;
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("MultiTalkMember");
  public static final Column USERNAME;
  private static final int createTime_HASHCODE;
  private static final int jIF;
  public static final Column jIz;
  public static final Column kLF;
  public static final Column kLJ;
  private static final int kLR;
  private static final int kLV;
  public static final Column kLX;
  public static final Column kLY;
  private static final int kMb;
  private static final int kMc;
  private static final StorageObserverOwner<fl> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int userName_HASHCODE;
  private boolean __hadSetcreateTime = true;
  private boolean __hadSetuserName = true;
  public long field_createTime;
  public String field_inviteUserName;
  public long field_memberId;
  public long field_memberUuid;
  public int field_status;
  public String field_userName;
  public String field_wxGroupId;
  private boolean jIC = true;
  private boolean kLL = true;
  private boolean kLP = true;
  private boolean kLZ = true;
  private boolean kMa = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kLX = new Column("memberUuid", "long", TABLE.getName(), "");
    kLF = new Column("wxGroupId", "string", TABLE.getName(), "");
    USERNAME = new Column("userName", "string", TABLE.getName(), "");
    kLJ = new Column("inviteUserName", "string", TABLE.getName(), "");
    kLY = new Column("memberId", "long", TABLE.getName(), "");
    jIz = new Column("status", "int", TABLE.getName(), "");
    CREATETIME = new Column("createTime", "long", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    kMb = "memberUuid".hashCode();
    kLR = "wxGroupId".hashCode();
    userName_HASHCODE = "userName".hashCode();
    kLV = "inviteUserName".hashCode();
    kMc = "memberId".hashCode();
    jIF = "status".hashCode();
    createTime_HASHCODE = "createTime".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[7];
    localMAutoDBInfo.columns = new String[8];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "memberUuid";
    localMAutoDBInfo.colsMap.put("memberUuid", "LONG");
    localStringBuilder.append(" memberUuid LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "wxGroupId";
    localMAutoDBInfo.colsMap.put("wxGroupId", "TEXT");
    localStringBuilder.append(" wxGroupId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "userName";
    localMAutoDBInfo.colsMap.put("userName", "TEXT");
    localStringBuilder.append(" userName TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "inviteUserName";
    localMAutoDBInfo.colsMap.put("inviteUserName", "TEXT");
    localStringBuilder.append(" inviteUserName TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "memberId";
    localMAutoDBInfo.colsMap.put("memberId", "LONG");
    localStringBuilder.append(" memberId LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "status";
    localMAutoDBInfo.colsMap.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "createTime";
    localMAutoDBInfo.colsMap.put("createTime", "LONG");
    localStringBuilder.append(" createTime LONG");
    localMAutoDBInfo.columns[7] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("memberUuid"))
    {
      this.field_memberUuid = paramContentValues.getAsLong("memberUuid").longValue();
      if (paramBoolean) {
        this.kLZ = true;
      }
    }
    if (paramContentValues.containsKey("wxGroupId"))
    {
      this.field_wxGroupId = paramContentValues.getAsString("wxGroupId");
      if (paramBoolean) {
        this.kLL = true;
      }
    }
    if (paramContentValues.containsKey("userName"))
    {
      this.field_userName = paramContentValues.getAsString("userName");
      if (paramBoolean) {
        this.__hadSetuserName = true;
      }
    }
    if (paramContentValues.containsKey("inviteUserName"))
    {
      this.field_inviteUserName = paramContentValues.getAsString("inviteUserName");
      if (paramBoolean) {
        this.kLP = true;
      }
    }
    if (paramContentValues.containsKey("memberId"))
    {
      this.field_memberId = paramContentValues.getAsLong("memberId").longValue();
      if (paramBoolean) {
        this.kMa = true;
      }
    }
    if (paramContentValues.containsKey("status"))
    {
      this.field_status = paramContentValues.getAsInteger("status").intValue();
      if (paramBoolean) {
        this.jIC = true;
      }
    }
    if (paramContentValues.containsKey("createTime"))
    {
      this.field_createTime = paramContentValues.getAsLong("createTime").longValue();
      if (paramBoolean) {
        this.__hadSetcreateTime = true;
      }
    }
    if (paramContentValues.containsKey("rowid")) {
      this.systemRowid = paramContentValues.getAsLong("rowid").longValue();
    }
  }
  
  public void convertFrom(Cursor paramCursor)
  {
    String[] arrayOfString = paramCursor.getColumnNames();
    if (arrayOfString == null) {
      return;
    }
    int i = 0;
    int j = arrayOfString.length;
    label20:
    int k;
    if (i < j)
    {
      k = arrayOfString[i].hashCode();
      if (kMb != k) {
        break label60;
      }
      this.field_memberUuid = paramCursor.getLong(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (kLR == k) {
        this.field_wxGroupId = paramCursor.getString(i);
      } else if (userName_HASHCODE == k) {
        this.field_userName = paramCursor.getString(i);
      } else if (kLV == k) {
        this.field_inviteUserName = paramCursor.getString(i);
      } else if (kMc == k) {
        this.field_memberId = paramCursor.getLong(i);
      } else if (jIF == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (createTime_HASHCODE == k) {
        this.field_createTime = paramCursor.getLong(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.kLZ) {
      localContentValues.put("memberUuid", Long.valueOf(this.field_memberUuid));
    }
    if (this.kLL) {
      localContentValues.put("wxGroupId", this.field_wxGroupId);
    }
    if (this.__hadSetuserName) {
      localContentValues.put("userName", this.field_userName);
    }
    if (this.kLP) {
      localContentValues.put("inviteUserName", this.field_inviteUserName);
    }
    if (this.kMa) {
      localContentValues.put("memberId", Long.valueOf(this.field_memberId));
    }
    if (this.jIC) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.__hadSetcreateTime) {
      localContentValues.put("createTime", Long.valueOf(this.field_createTime));
    }
    if (this.systemRowid > 0L) {
      localContentValues.put("rowid", Long.valueOf(this.systemRowid));
    }
    return localContentValues;
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return DB_INFO;
  }
  
  public String[] getIndexCreateSQL()
  {
    return INDEX_CREATE;
  }
  
  public StorageObserverOwner<? extends fl> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return Long.valueOf(this.systemRowid);
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
 * Qualified Name:     com.tencent.mm.autogen.b.fl
 * JD-Core Version:    0.7.0.1
 */
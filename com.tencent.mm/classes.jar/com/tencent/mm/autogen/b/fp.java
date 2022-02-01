package com.tencent.mm.autogen.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.protocal.protobuf.fnj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.observer.StorageObserverOwner;
import com.tencent.mm.sdk.storage.sql.Column;
import com.tencent.mm.sdk.storage.sql.SingleTable;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Map;

public abstract class fp
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final Column EXPOSURETIME;
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("NewTipsInfo2");
  private static final int exposureTime_HASHCODE;
  public static final Column jJI;
  public static final Column jJJ;
  private static final int jKg;
  private static final int jKh;
  public static final Column jON;
  private static final int jOT;
  private static final int jSZ;
  public static final Column jSx;
  private static final int kOM;
  private static final int kOP;
  private static final int kOT;
  private static final int kOU;
  private static final int kOV;
  public static final Column kOY;
  public static final Column kOZ;
  public static final Column kOo;
  public static final Column kOr;
  public static final Column kOv;
  public static final Column kOw;
  public static final Column kOx;
  public static final Column kPa;
  public static final Column kPb;
  public static final Column kPc;
  public static final Column kPd;
  public static final Column kPe;
  public static final Column kPf;
  private static final int kPo;
  private static final int kPp;
  private static final int kPq;
  private static final int kPr;
  private static final int kPs;
  private static final int kPt;
  private static final int kPu;
  private static final int kPv;
  public static final Column kcW;
  private static final int kdW;
  public static final Column kee;
  private static final int kfH;
  private static final StorageObserverOwner<fp> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private boolean __hadSetexposureTime = true;
  public long field_beginShowTime;
  public long field_disappearTime;
  public String field_dynamicPath;
  public long field_exposureDisappearTime;
  public long field_exposureTime;
  public String field_extInfo;
  public String field_icon_url;
  public String field_lang;
  public int field_maxClientVersion;
  public int field_minClientVersion;
  public long field_overdueTime;
  public fnj field_parents;
  public int field_path;
  public int field_priority;
  public int field_showType;
  public int field_state;
  public int field_tipId;
  public int field_tipType;
  public String field_title;
  public String field_uniqueId;
  private boolean jJU = true;
  private boolean jJV = true;
  private boolean jOQ = true;
  private boolean jSL = true;
  private boolean kOA = true;
  private boolean kOD = true;
  private boolean kOH = true;
  private boolean kOI = true;
  private boolean kOJ = true;
  private boolean kPg = true;
  private boolean kPh = true;
  private boolean kPi = true;
  private boolean kPj = true;
  private boolean kPk = true;
  private boolean kPl = true;
  private boolean kPm = true;
  private boolean kPn = true;
  private boolean kdw = true;
  private boolean keT = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kOY = new Column("uniqueId", "string", TABLE.getName(), "");
    jJJ = new Column("path", "int", TABLE.getName(), "");
    jJI = new Column("showType", "int", TABLE.getName(), "");
    jON = new Column("title", "string", TABLE.getName(), "");
    kOZ = new Column("icon_url", "string", TABLE.getName(), "");
    kPa = new Column("parents", "proto", TABLE.getName(), "com.tencent.mm.protocal.protobuf.TipsShowInfoParentList");
    kOo = new Column("tipId", "int", TABLE.getName(), "");
    kPb = new Column("priority", "int", TABLE.getName(), "");
    kOr = new Column("tipType", "int", TABLE.getName(), "");
    kOv = new Column("beginShowTime", "long", TABLE.getName(), "");
    EXPOSURETIME = new Column("exposureTime", "long", TABLE.getName(), "");
    kOx = new Column("overdueTime", "long", TABLE.getName(), "");
    kOw = new Column("disappearTime", "long", TABLE.getName(), "");
    kPc = new Column("exposureDisappearTime", "long", TABLE.getName(), "");
    kPd = new Column("minClientVersion", "int", TABLE.getName(), "");
    kPe = new Column("maxClientVersion", "int", TABLE.getName(), "");
    jSx = new Column("extInfo", "string", TABLE.getName(), "");
    kee = new Column("state", "int", TABLE.getName(), "");
    kPf = new Column("dynamicPath", "string", TABLE.getName(), "");
    kcW = new Column("lang", "string", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    kPo = "uniqueId".hashCode();
    jKh = "path".hashCode();
    jKg = "showType".hashCode();
    jOT = "title".hashCode();
    kPp = "icon_url".hashCode();
    kPq = "parents".hashCode();
    kOM = "tipId".hashCode();
    kPr = "priority".hashCode();
    kOP = "tipType".hashCode();
    kOT = "beginShowTime".hashCode();
    exposureTime_HASHCODE = "exposureTime".hashCode();
    kOV = "overdueTime".hashCode();
    kOU = "disappearTime".hashCode();
    kPs = "exposureDisappearTime".hashCode();
    kPt = "minClientVersion".hashCode();
    kPu = "maxClientVersion".hashCode();
    jSZ = "extInfo".hashCode();
    kfH = "state".hashCode();
    kPv = "dynamicPath".hashCode();
    kdW = "lang".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[20];
    localMAutoDBInfo.columns = new String[21];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "uniqueId";
    localMAutoDBInfo.colsMap.put("uniqueId", "TEXT");
    localStringBuilder.append(" uniqueId TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[1] = "path";
    localMAutoDBInfo.colsMap.put("path", "INTEGER");
    localStringBuilder.append(" path INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "showType";
    localMAutoDBInfo.colsMap.put("showType", "INTEGER");
    localStringBuilder.append(" showType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "title";
    localMAutoDBInfo.colsMap.put("title", "TEXT");
    localStringBuilder.append(" title TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "icon_url";
    localMAutoDBInfo.colsMap.put("icon_url", "TEXT");
    localStringBuilder.append(" icon_url TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "parents";
    localMAutoDBInfo.colsMap.put("parents", "BLOB");
    localStringBuilder.append(" parents BLOB");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "tipId";
    localMAutoDBInfo.colsMap.put("tipId", "INTEGER");
    localStringBuilder.append(" tipId INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "priority";
    localMAutoDBInfo.colsMap.put("priority", "INTEGER");
    localStringBuilder.append(" priority INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "tipType";
    localMAutoDBInfo.colsMap.put("tipType", "INTEGER");
    localStringBuilder.append(" tipType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "beginShowTime";
    localMAutoDBInfo.colsMap.put("beginShowTime", "LONG");
    localStringBuilder.append(" beginShowTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "exposureTime";
    localMAutoDBInfo.colsMap.put("exposureTime", "LONG");
    localStringBuilder.append(" exposureTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "overdueTime";
    localMAutoDBInfo.colsMap.put("overdueTime", "LONG");
    localStringBuilder.append(" overdueTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "disappearTime";
    localMAutoDBInfo.colsMap.put("disappearTime", "LONG");
    localStringBuilder.append(" disappearTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "exposureDisappearTime";
    localMAutoDBInfo.colsMap.put("exposureDisappearTime", "LONG");
    localStringBuilder.append(" exposureDisappearTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "minClientVersion";
    localMAutoDBInfo.colsMap.put("minClientVersion", "INTEGER");
    localStringBuilder.append(" minClientVersion INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "maxClientVersion";
    localMAutoDBInfo.colsMap.put("maxClientVersion", "INTEGER");
    localStringBuilder.append(" maxClientVersion INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "extInfo";
    localMAutoDBInfo.colsMap.put("extInfo", "TEXT");
    localStringBuilder.append(" extInfo TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "state";
    localMAutoDBInfo.colsMap.put("state", "INTEGER default '0' ");
    localStringBuilder.append(" state INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[18] = "dynamicPath";
    localMAutoDBInfo.colsMap.put("dynamicPath", "TEXT");
    localStringBuilder.append(" dynamicPath TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[19] = "lang";
    localMAutoDBInfo.colsMap.put("lang", "TEXT");
    localStringBuilder.append(" lang TEXT");
    localMAutoDBInfo.columns[20] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("uniqueId"))
    {
      this.field_uniqueId = paramContentValues.getAsString("uniqueId");
      if (paramBoolean) {
        this.kPg = true;
      }
    }
    if (paramContentValues.containsKey("path"))
    {
      this.field_path = paramContentValues.getAsInteger("path").intValue();
      if (paramBoolean) {
        this.jJV = true;
      }
    }
    if (paramContentValues.containsKey("showType"))
    {
      this.field_showType = paramContentValues.getAsInteger("showType").intValue();
      if (paramBoolean) {
        this.jJU = true;
      }
    }
    if (paramContentValues.containsKey("title"))
    {
      this.field_title = paramContentValues.getAsString("title");
      if (paramBoolean) {
        this.jOQ = true;
      }
    }
    if (paramContentValues.containsKey("icon_url"))
    {
      this.field_icon_url = paramContentValues.getAsString("icon_url");
      if (paramBoolean) {
        this.kPh = true;
      }
    }
    if (paramContentValues.containsKey("parents")) {}
    try
    {
      byte[] arrayOfByte = paramContentValues.getAsByteArray("parents");
      if ((arrayOfByte != null) && (arrayOfByte.length > 0))
      {
        this.field_parents = ((fnj)new fnj().parseFrom(arrayOfByte));
        if (paramBoolean) {
          this.kPi = true;
        }
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        Log.e("MicroMsg.SDK.BaseNewTipsInfo2", localIOException.getMessage());
      }
    }
    if (paramContentValues.containsKey("tipId"))
    {
      this.field_tipId = paramContentValues.getAsInteger("tipId").intValue();
      if (paramBoolean) {
        this.kOA = true;
      }
    }
    if (paramContentValues.containsKey("priority"))
    {
      this.field_priority = paramContentValues.getAsInteger("priority").intValue();
      if (paramBoolean) {
        this.kPj = true;
      }
    }
    if (paramContentValues.containsKey("tipType"))
    {
      this.field_tipType = paramContentValues.getAsInteger("tipType").intValue();
      if (paramBoolean) {
        this.kOD = true;
      }
    }
    if (paramContentValues.containsKey("beginShowTime"))
    {
      this.field_beginShowTime = paramContentValues.getAsLong("beginShowTime").longValue();
      if (paramBoolean) {
        this.kOH = true;
      }
    }
    if (paramContentValues.containsKey("exposureTime"))
    {
      this.field_exposureTime = paramContentValues.getAsLong("exposureTime").longValue();
      if (paramBoolean) {
        this.__hadSetexposureTime = true;
      }
    }
    if (paramContentValues.containsKey("overdueTime"))
    {
      this.field_overdueTime = paramContentValues.getAsLong("overdueTime").longValue();
      if (paramBoolean) {
        this.kOJ = true;
      }
    }
    if (paramContentValues.containsKey("disappearTime"))
    {
      this.field_disappearTime = paramContentValues.getAsLong("disappearTime").longValue();
      if (paramBoolean) {
        this.kOI = true;
      }
    }
    if (paramContentValues.containsKey("exposureDisappearTime"))
    {
      this.field_exposureDisappearTime = paramContentValues.getAsLong("exposureDisappearTime").longValue();
      if (paramBoolean) {
        this.kPk = true;
      }
    }
    if (paramContentValues.containsKey("minClientVersion"))
    {
      this.field_minClientVersion = paramContentValues.getAsInteger("minClientVersion").intValue();
      if (paramBoolean) {
        this.kPl = true;
      }
    }
    if (paramContentValues.containsKey("maxClientVersion"))
    {
      this.field_maxClientVersion = paramContentValues.getAsInteger("maxClientVersion").intValue();
      if (paramBoolean) {
        this.kPm = true;
      }
    }
    if (paramContentValues.containsKey("extInfo"))
    {
      this.field_extInfo = paramContentValues.getAsString("extInfo");
      if (paramBoolean) {
        this.jSL = true;
      }
    }
    if (paramContentValues.containsKey("state"))
    {
      this.field_state = paramContentValues.getAsInteger("state").intValue();
      if (paramBoolean) {
        this.keT = true;
      }
    }
    if (paramContentValues.containsKey("dynamicPath"))
    {
      this.field_dynamicPath = paramContentValues.getAsString("dynamicPath");
      if (paramBoolean) {
        this.kPn = true;
      }
    }
    if (paramContentValues.containsKey("lang"))
    {
      this.field_lang = paramContentValues.getAsString("lang");
      if (paramBoolean) {
        this.kdw = true;
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
    int j = arrayOfString.length;
    int i = 0;
    label20:
    int k;
    if (i < j)
    {
      k = arrayOfString[i].hashCode();
      if (kPo != k) {
        break label60;
      }
      this.field_uniqueId = paramCursor.getString(i);
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label60:
      if (jKh == k) {
        this.field_path = paramCursor.getInt(i);
      } else if (jKg == k) {
        this.field_showType = paramCursor.getInt(i);
      } else if (jOT == k) {
        this.field_title = paramCursor.getString(i);
      } else if (kPp == k) {
        this.field_icon_url = paramCursor.getString(i);
      } else if (kPq == k) {
        try
        {
          byte[] arrayOfByte = paramCursor.getBlob(i);
          if ((arrayOfByte == null) || (arrayOfByte.length <= 0)) {
            continue;
          }
          this.field_parents = ((fnj)new fnj().parseFrom(arrayOfByte));
        }
        catch (IOException localIOException)
        {
          Log.e("MicroMsg.SDK.BaseNewTipsInfo2", localIOException.getMessage());
        }
      } else if (kOM == k) {
        this.field_tipId = paramCursor.getInt(i);
      } else if (kPr == k) {
        this.field_priority = paramCursor.getInt(i);
      } else if (kOP == k) {
        this.field_tipType = paramCursor.getInt(i);
      } else if (kOT == k) {
        this.field_beginShowTime = paramCursor.getLong(i);
      } else if (exposureTime_HASHCODE == k) {
        this.field_exposureTime = paramCursor.getLong(i);
      } else if (kOV == k) {
        this.field_overdueTime = paramCursor.getLong(i);
      } else if (kOU == k) {
        this.field_disappearTime = paramCursor.getLong(i);
      } else if (kPs == k) {
        this.field_exposureDisappearTime = paramCursor.getLong(i);
      } else if (kPt == k) {
        this.field_minClientVersion = paramCursor.getInt(i);
      } else if (kPu == k) {
        this.field_maxClientVersion = paramCursor.getInt(i);
      } else if (jSZ == k) {
        this.field_extInfo = paramCursor.getString(i);
      } else if (kfH == k) {
        this.field_state = paramCursor.getInt(i);
      } else if (kPv == k) {
        this.field_dynamicPath = paramCursor.getString(i);
      } else if (kdW == k) {
        this.field_lang = paramCursor.getString(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.kPg) {
      localContentValues.put("uniqueId", this.field_uniqueId);
    }
    if (this.jJV) {
      localContentValues.put("path", Integer.valueOf(this.field_path));
    }
    if (this.jJU) {
      localContentValues.put("showType", Integer.valueOf(this.field_showType));
    }
    if (this.jOQ) {
      localContentValues.put("title", this.field_title);
    }
    if (this.kPh) {
      localContentValues.put("icon_url", this.field_icon_url);
    }
    if ((this.kPi) && (this.field_parents != null)) {}
    try
    {
      localContentValues.put("parents", this.field_parents.toByteArray());
      if (this.kOA) {
        localContentValues.put("tipId", Integer.valueOf(this.field_tipId));
      }
      if (this.kPj) {
        localContentValues.put("priority", Integer.valueOf(this.field_priority));
      }
      if (this.kOD) {
        localContentValues.put("tipType", Integer.valueOf(this.field_tipType));
      }
      if (this.kOH) {
        localContentValues.put("beginShowTime", Long.valueOf(this.field_beginShowTime));
      }
      if (this.__hadSetexposureTime) {
        localContentValues.put("exposureTime", Long.valueOf(this.field_exposureTime));
      }
      if (this.kOJ) {
        localContentValues.put("overdueTime", Long.valueOf(this.field_overdueTime));
      }
      if (this.kOI) {
        localContentValues.put("disappearTime", Long.valueOf(this.field_disappearTime));
      }
      if (this.kPk) {
        localContentValues.put("exposureDisappearTime", Long.valueOf(this.field_exposureDisappearTime));
      }
      if (this.kPl) {
        localContentValues.put("minClientVersion", Integer.valueOf(this.field_minClientVersion));
      }
      if (this.kPm) {
        localContentValues.put("maxClientVersion", Integer.valueOf(this.field_maxClientVersion));
      }
      if (this.jSL) {
        localContentValues.put("extInfo", this.field_extInfo);
      }
      if (this.keT) {
        localContentValues.put("state", Integer.valueOf(this.field_state));
      }
      if (this.kPn) {
        localContentValues.put("dynamicPath", this.field_dynamicPath);
      }
      if (this.kdw) {
        localContentValues.put("lang", this.field_lang);
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
        Log.e("MicroMsg.SDK.BaseNewTipsInfo2", localIOException.getMessage());
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
  
  public StorageObserverOwner<? extends fp> getObserverOwner()
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
 * Qualified Name:     com.tencent.mm.autogen.b.fp
 * JD-Core Version:    0.7.0.1
 */
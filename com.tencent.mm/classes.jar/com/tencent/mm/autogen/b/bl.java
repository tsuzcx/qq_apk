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

public abstract class bl
  extends IAutoDBItem
{
  public static final IAutoDBItem.MAutoDBInfo DB_INFO = aJm();
  public static final String[] INDEX_CREATE;
  public static final Column ROWID;
  public static final SingleTable TABLE = new SingleTable("EmojiGroupInfo");
  public static final Column TYPE;
  private static final int jIF;
  public static final Column jIz;
  public static final Column jOV;
  private static final int jOZ;
  public static final Column kcB;
  public static final Column kcC;
  public static final Column kcD;
  public static final Column kcE;
  public static final Column kcF;
  public static final Column kcG;
  public static final Column kcH;
  public static final Column kcI;
  public static final Column kcJ;
  public static final Column kcK;
  public static final Column kcL;
  public static final Column kcM;
  public static final Column kcN;
  public static final Column kcO;
  public static final Column kcP;
  public static final Column kcQ;
  public static final Column kcR;
  public static final Column kcS;
  public static final Column kcT;
  public static final Column kcU;
  public static final Column kcV;
  public static final Column kcW;
  public static final Column kcX;
  public static final Column kcY;
  public static final Column kcZ;
  public static final Column kct;
  private static final int kdA;
  private static final int kdB;
  private static final int kdC;
  private static final int kdD;
  private static final int kdE;
  private static final int kdF;
  private static final int kdG;
  private static final int kdH;
  private static final int kdI;
  private static final int kdJ;
  private static final int kdK;
  private static final int kdL;
  private static final int kdM;
  private static final int kdN;
  private static final int kdO;
  private static final int kdP;
  private static final int kdQ;
  private static final int kdR;
  private static final int kdS;
  private static final int kdT;
  private static final int kdU;
  private static final int kdV;
  private static final int kdW;
  private static final int kdX;
  private static final int kdY;
  private static final int kdZ;
  private static final StorageObserverOwner<bl> observerOwner = new StorageObserverOwner();
  private static final int rowid_HASHCODE;
  private static final int type_HASHCODE;
  private boolean __hadSettype = true;
  public String field_BigIconUrl;
  public String field_MutiLanName;
  public int field_buttonType;
  public int field_count;
  public int field_flag;
  public int field_idx;
  public String field_lang;
  public long field_lastUseTime;
  public String field_packAuthInfo;
  public String field_packCopyright;
  public String field_packCoverUrl;
  public String field_packDesc;
  public long field_packExpire;
  public int field_packFlag;
  public String field_packGrayIconUrl;
  public String field_packIconUrl;
  public String field_packName;
  public String field_packPrice;
  public int field_packStatus;
  public long field_packTimeStamp;
  public int field_packType;
  public String field_productID;
  public int field_recommand;
  public int field_recommandType;
  public String field_recommandWord;
  public int field_sort;
  public int field_status;
  public int field_sync;
  public int field_type;
  private boolean jIC = true;
  private boolean jOX = true;
  private boolean kda = true;
  private boolean kdb = true;
  private boolean kdc = true;
  private boolean kdd = true;
  private boolean kde = true;
  private boolean kdf = true;
  private boolean kdg = true;
  private boolean kdh = true;
  private boolean kdi = true;
  private boolean kdj = true;
  private boolean kdk = true;
  private boolean kdl = true;
  private boolean kdm = true;
  private boolean kdn = true;
  private boolean kdo = true;
  private boolean kdp = true;
  private boolean kdq = true;
  private boolean kdr = true;
  private boolean kds = true;
  private boolean kdt = true;
  private boolean kdu = true;
  private boolean kdv = true;
  private boolean kdw = true;
  private boolean kdx = true;
  private boolean kdy = true;
  private boolean kdz = true;
  
  static
  {
    ROWID = new Column("rowid", "long", TABLE.getName(), "");
    kct = new Column("productID", "string", TABLE.getName(), "");
    kcB = new Column("packIconUrl", "string", TABLE.getName(), "");
    kcC = new Column("packGrayIconUrl", "string", TABLE.getName(), "");
    kcD = new Column("packCoverUrl", "string", TABLE.getName(), "");
    kcE = new Column("packName", "string", TABLE.getName(), "");
    kcF = new Column("packDesc", "string", TABLE.getName(), "");
    kcG = new Column("packAuthInfo", "string", TABLE.getName(), "");
    kcH = new Column("packPrice", "string", TABLE.getName(), "");
    kcI = new Column("packType", "int", TABLE.getName(), "");
    kcJ = new Column("packFlag", "int", TABLE.getName(), "");
    kcK = new Column("packExpire", "long", TABLE.getName(), "");
    kcL = new Column("packTimeStamp", "long", TABLE.getName(), "");
    kcM = new Column("packCopyright", "string", TABLE.getName(), "");
    TYPE = new Column("type", "int", TABLE.getName(), "");
    jIz = new Column("status", "int", TABLE.getName(), "");
    kcN = new Column("sort", "int", TABLE.getName(), "");
    kcO = new Column("lastUseTime", "long", TABLE.getName(), "");
    kcP = new Column("packStatus", "int", TABLE.getName(), "");
    jOV = new Column("flag", "int", TABLE.getName(), "");
    kcQ = new Column("recommand", "int", TABLE.getName(), "");
    kcR = new Column("sync", "int", TABLE.getName(), "");
    kcS = new Column("idx", "int", TABLE.getName(), "");
    kcT = new Column("BigIconUrl", "string", TABLE.getName(), "");
    kcU = new Column("MutiLanName", "string", TABLE.getName(), "");
    kcV = new Column("recommandType", "int", TABLE.getName(), "");
    kcW = new Column("lang", "string", TABLE.getName(), "");
    kcX = new Column("recommandWord", "string", TABLE.getName(), "");
    kcY = new Column("buttonType", "int", TABLE.getName(), "");
    kcZ = new Column("count", "int", TABLE.getName(), "");
    INDEX_CREATE = new String[0];
    kdA = "productID".hashCode();
    kdB = "packIconUrl".hashCode();
    kdC = "packGrayIconUrl".hashCode();
    kdD = "packCoverUrl".hashCode();
    kdE = "packName".hashCode();
    kdF = "packDesc".hashCode();
    kdG = "packAuthInfo".hashCode();
    kdH = "packPrice".hashCode();
    kdI = "packType".hashCode();
    kdJ = "packFlag".hashCode();
    kdK = "packExpire".hashCode();
    kdL = "packTimeStamp".hashCode();
    kdM = "packCopyright".hashCode();
    type_HASHCODE = "type".hashCode();
    jIF = "status".hashCode();
    kdN = "sort".hashCode();
    kdO = "lastUseTime".hashCode();
    kdP = "packStatus".hashCode();
    jOZ = "flag".hashCode();
    kdQ = "recommand".hashCode();
    kdR = "sync".hashCode();
    kdS = "idx".hashCode();
    kdT = "BigIconUrl".hashCode();
    kdU = "MutiLanName".hashCode();
    kdV = "recommandType".hashCode();
    kdW = "lang".hashCode();
    kdX = "recommandWord".hashCode();
    kdY = "buttonType".hashCode();
    kdZ = "count".hashCode();
    rowid_HASHCODE = "rowid".hashCode();
  }
  
  public static IAutoDBItem.MAutoDBInfo aJm()
  {
    IAutoDBItem.MAutoDBInfo localMAutoDBInfo = new IAutoDBItem.MAutoDBInfo();
    localMAutoDBInfo.fields = new Field[29];
    localMAutoDBInfo.columns = new String[30];
    StringBuilder localStringBuilder = new StringBuilder();
    localMAutoDBInfo.columns[0] = "productID";
    localMAutoDBInfo.colsMap.put("productID", "TEXT PRIMARY KEY  COLLATE NOCASE ");
    localStringBuilder.append(" productID TEXT PRIMARY KEY  COLLATE NOCASE ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.primaryKey = "productID";
    localMAutoDBInfo.columns[1] = "packIconUrl";
    localMAutoDBInfo.colsMap.put("packIconUrl", "TEXT");
    localStringBuilder.append(" packIconUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[2] = "packGrayIconUrl";
    localMAutoDBInfo.colsMap.put("packGrayIconUrl", "TEXT");
    localStringBuilder.append(" packGrayIconUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[3] = "packCoverUrl";
    localMAutoDBInfo.colsMap.put("packCoverUrl", "TEXT");
    localStringBuilder.append(" packCoverUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[4] = "packName";
    localMAutoDBInfo.colsMap.put("packName", "TEXT");
    localStringBuilder.append(" packName TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[5] = "packDesc";
    localMAutoDBInfo.colsMap.put("packDesc", "TEXT");
    localStringBuilder.append(" packDesc TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[6] = "packAuthInfo";
    localMAutoDBInfo.colsMap.put("packAuthInfo", "TEXT");
    localStringBuilder.append(" packAuthInfo TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[7] = "packPrice";
    localMAutoDBInfo.colsMap.put("packPrice", "TEXT");
    localStringBuilder.append(" packPrice TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[8] = "packType";
    localMAutoDBInfo.colsMap.put("packType", "INTEGER");
    localStringBuilder.append(" packType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[9] = "packFlag";
    localMAutoDBInfo.colsMap.put("packFlag", "INTEGER");
    localStringBuilder.append(" packFlag INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[10] = "packExpire";
    localMAutoDBInfo.colsMap.put("packExpire", "LONG");
    localStringBuilder.append(" packExpire LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[11] = "packTimeStamp";
    localMAutoDBInfo.colsMap.put("packTimeStamp", "LONG");
    localStringBuilder.append(" packTimeStamp LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[12] = "packCopyright";
    localMAutoDBInfo.colsMap.put("packCopyright", "TEXT");
    localStringBuilder.append(" packCopyright TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[13] = "type";
    localMAutoDBInfo.colsMap.put("type", "INTEGER");
    localStringBuilder.append(" type INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[14] = "status";
    localMAutoDBInfo.colsMap.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[15] = "sort";
    localMAutoDBInfo.colsMap.put("sort", "INTEGER default '1' ");
    localStringBuilder.append(" sort INTEGER default '1' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[16] = "lastUseTime";
    localMAutoDBInfo.colsMap.put("lastUseTime", "LONG");
    localStringBuilder.append(" lastUseTime LONG");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[17] = "packStatus";
    localMAutoDBInfo.colsMap.put("packStatus", "INTEGER default '0' ");
    localStringBuilder.append(" packStatus INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[18] = "flag";
    localMAutoDBInfo.colsMap.put("flag", "INTEGER default '0' ");
    localStringBuilder.append(" flag INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[19] = "recommand";
    localMAutoDBInfo.colsMap.put("recommand", "INTEGER default '0' ");
    localStringBuilder.append(" recommand INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[20] = "sync";
    localMAutoDBInfo.colsMap.put("sync", "INTEGER default '0' ");
    localStringBuilder.append(" sync INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[21] = "idx";
    localMAutoDBInfo.colsMap.put("idx", "INTEGER default '0' ");
    localStringBuilder.append(" idx INTEGER default '0' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[22] = "BigIconUrl";
    localMAutoDBInfo.colsMap.put("BigIconUrl", "TEXT");
    localStringBuilder.append(" BigIconUrl TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[23] = "MutiLanName";
    localMAutoDBInfo.colsMap.put("MutiLanName", "TEXT");
    localStringBuilder.append(" MutiLanName TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[24] = "recommandType";
    localMAutoDBInfo.colsMap.put("recommandType", "INTEGER default '-1' ");
    localStringBuilder.append(" recommandType INTEGER default '-1' ");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[25] = "lang";
    localMAutoDBInfo.colsMap.put("lang", "TEXT");
    localStringBuilder.append(" lang TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[26] = "recommandWord";
    localMAutoDBInfo.colsMap.put("recommandWord", "TEXT");
    localStringBuilder.append(" recommandWord TEXT");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[27] = "buttonType";
    localMAutoDBInfo.colsMap.put("buttonType", "INTEGER");
    localStringBuilder.append(" buttonType INTEGER");
    localStringBuilder.append(", ");
    localMAutoDBInfo.columns[28] = "count";
    localMAutoDBInfo.colsMap.put("count", "INTEGER");
    localStringBuilder.append(" count INTEGER");
    localMAutoDBInfo.columns[29] = "rowid";
    localMAutoDBInfo.sql = localStringBuilder.toString();
    if (localMAutoDBInfo.primaryKey == null) {
      localMAutoDBInfo.primaryKey = "rowid";
    }
    return localMAutoDBInfo;
  }
  
  public void convertFrom(ContentValues paramContentValues, boolean paramBoolean)
  {
    if (paramContentValues.containsKey("productID"))
    {
      this.field_productID = paramContentValues.getAsString("productID");
      if (paramBoolean) {
        this.kda = true;
      }
    }
    if (paramContentValues.containsKey("packIconUrl"))
    {
      this.field_packIconUrl = paramContentValues.getAsString("packIconUrl");
      if (paramBoolean) {
        this.kdb = true;
      }
    }
    if (paramContentValues.containsKey("packGrayIconUrl"))
    {
      this.field_packGrayIconUrl = paramContentValues.getAsString("packGrayIconUrl");
      if (paramBoolean) {
        this.kdc = true;
      }
    }
    if (paramContentValues.containsKey("packCoverUrl"))
    {
      this.field_packCoverUrl = paramContentValues.getAsString("packCoverUrl");
      if (paramBoolean) {
        this.kdd = true;
      }
    }
    if (paramContentValues.containsKey("packName"))
    {
      this.field_packName = paramContentValues.getAsString("packName");
      if (paramBoolean) {
        this.kde = true;
      }
    }
    if (paramContentValues.containsKey("packDesc"))
    {
      this.field_packDesc = paramContentValues.getAsString("packDesc");
      if (paramBoolean) {
        this.kdf = true;
      }
    }
    if (paramContentValues.containsKey("packAuthInfo"))
    {
      this.field_packAuthInfo = paramContentValues.getAsString("packAuthInfo");
      if (paramBoolean) {
        this.kdg = true;
      }
    }
    if (paramContentValues.containsKey("packPrice"))
    {
      this.field_packPrice = paramContentValues.getAsString("packPrice");
      if (paramBoolean) {
        this.kdh = true;
      }
    }
    if (paramContentValues.containsKey("packType"))
    {
      this.field_packType = paramContentValues.getAsInteger("packType").intValue();
      if (paramBoolean) {
        this.kdi = true;
      }
    }
    if (paramContentValues.containsKey("packFlag"))
    {
      this.field_packFlag = paramContentValues.getAsInteger("packFlag").intValue();
      if (paramBoolean) {
        this.kdj = true;
      }
    }
    if (paramContentValues.containsKey("packExpire"))
    {
      this.field_packExpire = paramContentValues.getAsLong("packExpire").longValue();
      if (paramBoolean) {
        this.kdk = true;
      }
    }
    if (paramContentValues.containsKey("packTimeStamp"))
    {
      this.field_packTimeStamp = paramContentValues.getAsLong("packTimeStamp").longValue();
      if (paramBoolean) {
        this.kdl = true;
      }
    }
    if (paramContentValues.containsKey("packCopyright"))
    {
      this.field_packCopyright = paramContentValues.getAsString("packCopyright");
      if (paramBoolean) {
        this.kdm = true;
      }
    }
    if (paramContentValues.containsKey("type"))
    {
      this.field_type = paramContentValues.getAsInteger("type").intValue();
      if (paramBoolean) {
        this.__hadSettype = true;
      }
    }
    if (paramContentValues.containsKey("status"))
    {
      this.field_status = paramContentValues.getAsInteger("status").intValue();
      if (paramBoolean) {
        this.jIC = true;
      }
    }
    if (paramContentValues.containsKey("sort"))
    {
      this.field_sort = paramContentValues.getAsInteger("sort").intValue();
      if (paramBoolean) {
        this.kdn = true;
      }
    }
    if (paramContentValues.containsKey("lastUseTime"))
    {
      this.field_lastUseTime = paramContentValues.getAsLong("lastUseTime").longValue();
      if (paramBoolean) {
        this.kdo = true;
      }
    }
    if (paramContentValues.containsKey("packStatus"))
    {
      this.field_packStatus = paramContentValues.getAsInteger("packStatus").intValue();
      if (paramBoolean) {
        this.kdp = true;
      }
    }
    if (paramContentValues.containsKey("flag"))
    {
      this.field_flag = paramContentValues.getAsInteger("flag").intValue();
      if (paramBoolean) {
        this.jOX = true;
      }
    }
    if (paramContentValues.containsKey("recommand"))
    {
      this.field_recommand = paramContentValues.getAsInteger("recommand").intValue();
      if (paramBoolean) {
        this.kdq = true;
      }
    }
    if (paramContentValues.containsKey("sync"))
    {
      this.field_sync = paramContentValues.getAsInteger("sync").intValue();
      if (paramBoolean) {
        this.kdr = true;
      }
    }
    if (paramContentValues.containsKey("idx"))
    {
      this.field_idx = paramContentValues.getAsInteger("idx").intValue();
      if (paramBoolean) {
        this.kds = true;
      }
    }
    if (paramContentValues.containsKey("BigIconUrl"))
    {
      this.field_BigIconUrl = paramContentValues.getAsString("BigIconUrl");
      if (paramBoolean) {
        this.kdt = true;
      }
    }
    if (paramContentValues.containsKey("MutiLanName"))
    {
      this.field_MutiLanName = paramContentValues.getAsString("MutiLanName");
      if (paramBoolean) {
        this.kdu = true;
      }
    }
    if (paramContentValues.containsKey("recommandType"))
    {
      this.field_recommandType = paramContentValues.getAsInteger("recommandType").intValue();
      if (paramBoolean) {
        this.kdv = true;
      }
    }
    if (paramContentValues.containsKey("lang"))
    {
      this.field_lang = paramContentValues.getAsString("lang");
      if (paramBoolean) {
        this.kdw = true;
      }
    }
    if (paramContentValues.containsKey("recommandWord"))
    {
      this.field_recommandWord = paramContentValues.getAsString("recommandWord");
      if (paramBoolean) {
        this.kdx = true;
      }
    }
    if (paramContentValues.containsKey("buttonType"))
    {
      this.field_buttonType = paramContentValues.getAsInteger("buttonType").intValue();
      if (paramBoolean) {
        this.kdy = true;
      }
    }
    if (paramContentValues.containsKey("count"))
    {
      this.field_count = paramContentValues.getAsInteger("count").intValue();
      if (paramBoolean) {
        this.kdz = true;
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
      if (kdA != k) {
        break label65;
      }
      this.field_productID = paramCursor.getString(i);
      this.kda = true;
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label65:
      if (kdB == k) {
        this.field_packIconUrl = paramCursor.getString(i);
      } else if (kdC == k) {
        this.field_packGrayIconUrl = paramCursor.getString(i);
      } else if (kdD == k) {
        this.field_packCoverUrl = paramCursor.getString(i);
      } else if (kdE == k) {
        this.field_packName = paramCursor.getString(i);
      } else if (kdF == k) {
        this.field_packDesc = paramCursor.getString(i);
      } else if (kdG == k) {
        this.field_packAuthInfo = paramCursor.getString(i);
      } else if (kdH == k) {
        this.field_packPrice = paramCursor.getString(i);
      } else if (kdI == k) {
        this.field_packType = paramCursor.getInt(i);
      } else if (kdJ == k) {
        this.field_packFlag = paramCursor.getInt(i);
      } else if (kdK == k) {
        this.field_packExpire = paramCursor.getLong(i);
      } else if (kdL == k) {
        this.field_packTimeStamp = paramCursor.getLong(i);
      } else if (kdM == k) {
        this.field_packCopyright = paramCursor.getString(i);
      } else if (type_HASHCODE == k) {
        this.field_type = paramCursor.getInt(i);
      } else if (jIF == k) {
        this.field_status = paramCursor.getInt(i);
      } else if (kdN == k) {
        this.field_sort = paramCursor.getInt(i);
      } else if (kdO == k) {
        this.field_lastUseTime = paramCursor.getLong(i);
      } else if (kdP == k) {
        this.field_packStatus = paramCursor.getInt(i);
      } else if (jOZ == k) {
        this.field_flag = paramCursor.getInt(i);
      } else if (kdQ == k) {
        this.field_recommand = paramCursor.getInt(i);
      } else if (kdR == k) {
        this.field_sync = paramCursor.getInt(i);
      } else if (kdS == k) {
        this.field_idx = paramCursor.getInt(i);
      } else if (kdT == k) {
        this.field_BigIconUrl = paramCursor.getString(i);
      } else if (kdU == k) {
        this.field_MutiLanName = paramCursor.getString(i);
      } else if (kdV == k) {
        this.field_recommandType = paramCursor.getInt(i);
      } else if (kdW == k) {
        this.field_lang = paramCursor.getString(i);
      } else if (kdX == k) {
        this.field_recommandWord = paramCursor.getString(i);
      } else if (kdY == k) {
        this.field_buttonType = paramCursor.getInt(i);
      } else if (kdZ == k) {
        this.field_count = paramCursor.getInt(i);
      } else if (rowid_HASHCODE == k) {
        this.systemRowid = paramCursor.getLong(i);
      }
    }
  }
  
  public ContentValues convertTo()
  {
    ContentValues localContentValues = new ContentValues();
    if (this.kda) {
      localContentValues.put("productID", this.field_productID);
    }
    if (this.kdb) {
      localContentValues.put("packIconUrl", this.field_packIconUrl);
    }
    if (this.kdc) {
      localContentValues.put("packGrayIconUrl", this.field_packGrayIconUrl);
    }
    if (this.kdd) {
      localContentValues.put("packCoverUrl", this.field_packCoverUrl);
    }
    if (this.kde) {
      localContentValues.put("packName", this.field_packName);
    }
    if (this.kdf) {
      localContentValues.put("packDesc", this.field_packDesc);
    }
    if (this.kdg) {
      localContentValues.put("packAuthInfo", this.field_packAuthInfo);
    }
    if (this.kdh) {
      localContentValues.put("packPrice", this.field_packPrice);
    }
    if (this.kdi) {
      localContentValues.put("packType", Integer.valueOf(this.field_packType));
    }
    if (this.kdj) {
      localContentValues.put("packFlag", Integer.valueOf(this.field_packFlag));
    }
    if (this.kdk) {
      localContentValues.put("packExpire", Long.valueOf(this.field_packExpire));
    }
    if (this.kdl) {
      localContentValues.put("packTimeStamp", Long.valueOf(this.field_packTimeStamp));
    }
    if (this.kdm) {
      localContentValues.put("packCopyright", this.field_packCopyright);
    }
    if (this.__hadSettype) {
      localContentValues.put("type", Integer.valueOf(this.field_type));
    }
    if (this.jIC) {
      localContentValues.put("status", Integer.valueOf(this.field_status));
    }
    if (this.kdn) {
      localContentValues.put("sort", Integer.valueOf(this.field_sort));
    }
    if (this.kdo) {
      localContentValues.put("lastUseTime", Long.valueOf(this.field_lastUseTime));
    }
    if (this.kdp) {
      localContentValues.put("packStatus", Integer.valueOf(this.field_packStatus));
    }
    if (this.jOX) {
      localContentValues.put("flag", Integer.valueOf(this.field_flag));
    }
    if (this.kdq) {
      localContentValues.put("recommand", Integer.valueOf(this.field_recommand));
    }
    if (this.kdr) {
      localContentValues.put("sync", Integer.valueOf(this.field_sync));
    }
    if (this.kds) {
      localContentValues.put("idx", Integer.valueOf(this.field_idx));
    }
    if (this.kdt) {
      localContentValues.put("BigIconUrl", this.field_BigIconUrl);
    }
    if (this.kdu) {
      localContentValues.put("MutiLanName", this.field_MutiLanName);
    }
    if (this.kdv) {
      localContentValues.put("recommandType", Integer.valueOf(this.field_recommandType));
    }
    if (this.kdw) {
      localContentValues.put("lang", this.field_lang);
    }
    if (this.kdx) {
      localContentValues.put("recommandWord", this.field_recommandWord);
    }
    if (this.kdy) {
      localContentValues.put("buttonType", Integer.valueOf(this.field_buttonType));
    }
    if (this.kdz) {
      localContentValues.put("count", Integer.valueOf(this.field_count));
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
  
  public StorageObserverOwner<? extends bl> getObserverOwner()
  {
    return observerOwner;
  }
  
  public Object getPrimaryKeyValue()
  {
    return this.field_productID;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.autogen.b.bl
 * JD-Core Version:    0.7.0.1
 */